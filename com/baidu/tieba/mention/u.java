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
    protected boolean abm;
    protected ArrayList<FeedData> bDo = new ArrayList<>();
    protected com.baidu.tbadk.core.data.q bDp = new com.baidu.tbadk.core.data.q();
    protected com.baidu.tbadk.data.e bDq = new com.baidu.tbadk.data.e();

    public ArrayList<FeedData> XP() {
        return this.bDo;
    }

    public com.baidu.tbadk.core.data.q XQ() {
        return this.bDp;
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
                    this.bDo.add(feedData);
                }
            }
            this.bDq.parserJson(jSONObject.optJSONObject("message"));
            this.bDp.parserJson(jSONObject.optJSONObject("page"));
            this.abm = true;
        } catch (Exception e) {
            this.abm = false;
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
                        this.bDo.add(feedData);
                    }
                }
                this.bDp.a(dataRes.page);
                this.abm = true;
            } catch (Exception e) {
                this.abm = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
