package com.baidu.tieba.mention;

import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ReplyMe.DataRes;
import tbclient.ReplyMe.ReplyList;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes.dex */
public class x implements com.baidu.tbadk.mvc.b.j {
    protected boolean ahA;
    protected ArrayList<FeedData> bWb = new ArrayList<>();
    protected com.baidu.tbadk.core.data.p bWc = new com.baidu.tbadk.core.data.p();
    protected com.baidu.tbadk.data.e bWd = new com.baidu.tbadk.data.e();

    public ArrayList<FeedData> abF() {
        return this.bWb;
    }

    public com.baidu.tbadk.core.data.p getPage() {
        return this.bWc;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void g(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    FeedData feedData = new FeedData();
                    feedData.parserJson(optJSONArray2.optJSONObject(i));
                    this.bWb.add(feedData);
                }
            }
            this.bWd.parserJson(jSONObject.optJSONObject("message"));
            this.bWc.parserJson(jSONObject.optJSONObject("page"));
            this.ahA = true;
        } catch (Exception e) {
            this.ahA = false;
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
        if (message instanceof ReplyMeResIdl) {
            DataRes dataRes = ((ReplyMeResIdl) message).data;
            try {
                List<ReplyList> list = dataRes.reply_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        FeedData feedData = new FeedData();
                        feedData.parserProtoBuf(list.get(i));
                        this.bWb.add(feedData);
                    }
                }
                this.bWc.a(dataRes.page);
                this.ahA = true;
            } catch (Exception e) {
                this.ahA = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
