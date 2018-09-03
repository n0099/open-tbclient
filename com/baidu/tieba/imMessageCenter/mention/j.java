package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.w;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ReplyMe.DataRes;
import tbclient.ReplyMe.ReplyList;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes2.dex */
public class j implements com.baidu.tbadk.mvc.b.j {
    protected boolean Gp;
    protected ArrayList<FeedData> eHB = new ArrayList<>();
    protected al eHC = new al();
    protected h eHD = new h();

    public ArrayList<FeedData> aPe() {
        return this.eHB;
    }

    public al uv() {
        return this.eHC;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void u(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    FeedData feedData = new FeedData();
                    feedData.parserJson(optJSONArray2.optJSONObject(i));
                    this.eHB.add(feedData);
                    if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && w.y(feedData.getPraiseList()) == 0) {
                        this.eHB.remove(feedData);
                    }
                }
            }
            this.eHD.parserJson(jSONObject.optJSONObject("message"));
            this.eHC.parserJson(jSONObject.optJSONObject("page"));
            this.Gp = true;
        } catch (Exception e) {
            this.Gp = false;
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
                        this.eHB.add(feedData);
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && w.y(feedData.getPraiseList()) == 0) {
                            this.eHB.remove(feedData);
                        }
                    }
                }
                this.eHC.a(dataRes.page);
                this.Gp = true;
            } catch (Exception e) {
                this.Gp = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
