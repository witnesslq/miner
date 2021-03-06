package miner.timeouttest;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

import java.util.Map;

public class PrintBolt extends BaseRichBolt {

    private OutputCollector _collector;

    public void execute(Tuple input) {
        try {
            String result = input.getString(0);
            System.out.println(result+"---");
            _collector.ack(input);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector){
        this._collector = collector;
    }



    public void declareOutputFields(OutputFieldsDeclarer declarer) {
    }

}
