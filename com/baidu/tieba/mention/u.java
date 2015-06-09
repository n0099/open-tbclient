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
    protected boolean acq;
    protected ArrayList<FeedData> bGk = new ArrayList<>();
    protected com.baidu.tbadk.core.data.q bGl = new com.baidu.tbadk.core.data.q();
    protected com.baidu.tbadk.data.e bGm = new com.baidu.tbadk.data.e();

    public ArrayList<FeedData> Zp() {
        return this.bGk;
    }

    public com.baidu.tbadk.core.data.q Zq() {
        return this.bGl;
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
                    this.bGk.add(feedData);
                }
            }
            this.bGm.parserJson(jSONObject.optJSONObject("message"));
            this.bGl.parserJson(jSONObject.optJSONObject("page"));
            this.acq = true;
        } catch (Exception e) {
            this.acq = false;
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
                        this.bGk.add(feedData);
                    }
                }
                this.bGl.a(dataRes.page);
                this.acq = true;
            } catch (Exception e) {
                this.acq = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
