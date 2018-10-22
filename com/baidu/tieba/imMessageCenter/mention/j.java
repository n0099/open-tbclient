package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
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
/* loaded from: classes4.dex */
public class j implements com.baidu.tbadk.mvc.b.j {
    protected boolean Jo;
    protected ArrayList<FeedData> eWA = new ArrayList<>();
    protected al eWB = new al();
    protected h eWC = new h();

    public ArrayList<FeedData> aUH() {
        return this.eWA;
    }

    public al xH() {
        return this.eWB;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void H(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    FeedData feedData = new FeedData();
                    feedData.parserJson(optJSONArray2.optJSONObject(i));
                    this.eWA.add(feedData);
                    if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && v.I(feedData.getPraiseList()) == 0) {
                        this.eWA.remove(feedData);
                    }
                }
            }
            this.eWC.parserJson(jSONObject.optJSONObject("message"));
            this.eWB.parserJson(jSONObject.optJSONObject(SystemScreenshotManager.PAGE));
            this.Jo = true;
        } catch (Exception e) {
            this.Jo = false;
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
                        this.eWA.add(feedData);
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && v.I(feedData.getPraiseList()) == 0) {
                            this.eWA.remove(feedData);
                        }
                    }
                }
                this.eWB.a(dataRes.page);
                this.Jo = true;
            } catch (Exception e) {
                this.Jo = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
