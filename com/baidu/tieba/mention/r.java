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
public class r implements com.baidu.tbadk.mvc.b.j {
    protected boolean QO;
    protected ArrayList<FeedData> bsf = new ArrayList<>();
    protected com.baidu.tbadk.core.data.p bsg = new com.baidu.tbadk.core.data.p();
    protected com.baidu.tbadk.data.e bsh = new com.baidu.tbadk.data.e();

    public ArrayList<FeedData> TR() {
        return this.bsf;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void c(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    FeedData feedData = new FeedData();
                    feedData.parserJson(optJSONArray2.optJSONObject(i));
                    this.bsf.add(feedData);
                }
            }
            this.bsh.parserJson(jSONObject.optJSONObject("message"));
            this.bsg.parserJson(jSONObject.optJSONObject("page"));
            this.QO = true;
        } catch (Exception e) {
            this.QO = false;
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
                        this.bsf.add(feedData);
                    }
                }
                this.bsg.a(dataRes.page);
                this.QO = true;
            } catch (Exception e) {
                this.QO = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
