package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.v;
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
    protected boolean IM;
    protected ArrayList<FeedData> eOR = new ArrayList<>();
    protected al eOS = new al();
    protected h eOT = new h();

    public ArrayList<FeedData> aRt() {
        return this.eOR;
    }

    public al vy() {
        return this.eOS;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void E(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    FeedData feedData = new FeedData();
                    feedData.parserJson(optJSONArray2.optJSONObject(i));
                    this.eOR.add(feedData);
                    if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && v.y(feedData.getPraiseList()) == 0) {
                        this.eOR.remove(feedData);
                    }
                }
            }
            this.eOT.parserJson(jSONObject.optJSONObject("message"));
            this.eOS.parserJson(jSONObject.optJSONObject("page"));
            this.IM = true;
        } catch (Exception e) {
            this.IM = false;
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
                        this.eOR.add(feedData);
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && v.y(feedData.getPraiseList()) == 0) {
                            this.eOR.remove(feedData);
                        }
                    }
                }
                this.eOS.a(dataRes.page);
                this.IM = true;
            } catch (Exception e) {
                this.IM = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
