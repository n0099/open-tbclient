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
public class y implements com.baidu.tbadk.mvc.b.j {
    protected boolean Cj;
    protected ArrayList<FeedData> caG = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o caH = new com.baidu.tbadk.core.data.o();
    protected u caI = new u();

    public ArrayList<FeedData> adc() {
        return this.caG;
    }

    public com.baidu.tbadk.core.data.o getPage() {
        return this.caH;
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
                    this.caG.add(feedData);
                }
            }
            this.caI.parserJson(jSONObject.optJSONObject("message"));
            this.caH.parserJson(jSONObject.optJSONObject("page"));
            this.Cj = true;
        } catch (Exception e) {
            this.Cj = false;
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
                        this.caG.add(feedData);
                    }
                }
                this.caH.a(dataRes.page);
                this.Cj = true;
            } catch (Exception e) {
                this.Cj = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
