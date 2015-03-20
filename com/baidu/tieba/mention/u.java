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
public class u implements com.baidu.tbadk.mvc.b.k {
    protected boolean abe;
    protected ArrayList<FeedData> bDb = new ArrayList<>();
    protected com.baidu.tbadk.core.data.q bDc = new com.baidu.tbadk.core.data.q();
    protected com.baidu.tbadk.data.e bDd = new com.baidu.tbadk.data.e();

    public ArrayList<FeedData> XD() {
        return this.bDb;
    }

    public com.baidu.tbadk.core.data.q XE() {
        return this.bDc;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public void c(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    FeedData feedData = new FeedData();
                    feedData.parserJson(optJSONArray2.optJSONObject(i));
                    this.bDb.add(feedData);
                }
            }
            this.bDd.parserJson(jSONObject.optJSONObject("message"));
            this.bDc.parserJson(jSONObject.optJSONObject("page"));
            this.abe = true;
        } catch (Exception e) {
            this.abe = false;
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public void a(Message message) {
        if (message instanceof ReplyMeResIdl) {
            DataRes dataRes = ((ReplyMeResIdl) message).data;
            try {
                List<ReplyList> list = dataRes.reply_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        FeedData feedData = new FeedData();
                        feedData.parserProtoBuf(list.get(i));
                        this.bDb.add(feedData);
                    }
                }
                this.bDc.a(dataRes.page);
                this.abe = true;
            } catch (Exception e) {
                this.abe = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
