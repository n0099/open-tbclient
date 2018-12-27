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
    protected boolean Jr;
    protected ArrayList<FeedData> fhy = new ArrayList<>();
    protected al fhz = new al();
    protected h fhA = new h();

    public ArrayList<FeedData> aWJ() {
        return this.fhy;
    }

    public al yS() {
        return this.fhz;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void I(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    FeedData feedData = new FeedData();
                    feedData.parserJson(optJSONArray2.optJSONObject(i));
                    this.fhy.add(feedData);
                    if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && v.H(feedData.getPraiseList()) == 0) {
                        this.fhy.remove(feedData);
                    }
                }
            }
            this.fhA.parserJson(jSONObject.optJSONObject("message"));
            this.fhz.parserJson(jSONObject.optJSONObject(SystemScreenshotManager.PAGE));
            this.Jr = true;
        } catch (Exception e) {
            this.Jr = false;
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
                        this.fhy.add(feedData);
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && v.H(feedData.getPraiseList()) == 0) {
                            this.fhy.remove(feedData);
                        }
                    }
                }
                this.fhz.a(dataRes.page);
                this.Jr = true;
            } catch (Exception e) {
                this.Jr = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
