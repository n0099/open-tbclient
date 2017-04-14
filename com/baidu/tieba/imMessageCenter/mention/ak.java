package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ReplyMe.DataRes;
import tbclient.ReplyMe.ReplyList;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes.dex */
public class ak implements com.baidu.tbadk.mvc.b.j {
    protected boolean Cy;
    protected ArrayList<FeedData> dkQ = new ArrayList<>();
    protected com.baidu.tbadk.core.data.ap dkR = new com.baidu.tbadk.core.data.ap();
    protected ag dkS = new ag();

    public ArrayList<FeedData> avo() {
        return this.dkQ;
    }

    public com.baidu.tbadk.core.data.ap rr() {
        return this.dkR;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void m(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    FeedData feedData = new FeedData();
                    feedData.parserJson(optJSONArray2.optJSONObject(i));
                    if (feedData.getThread_Type() == 33) {
                        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            this.dkQ.add(feedData);
                        }
                    } else {
                        this.dkQ.add(feedData);
                        if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) && !com.baidu.tieba.graffiti.c.agD()) {
                            this.dkQ.remove(feedData);
                        }
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && com.baidu.tbadk.core.util.x.p(feedData.getPraiseList()) == 0) {
                            this.dkQ.remove(feedData);
                        }
                    }
                }
            }
            this.dkS.parserJson(jSONObject.optJSONObject("message"));
            this.dkR.parserJson(jSONObject.optJSONObject("page"));
            this.Cy = true;
        } catch (Exception e) {
            this.Cy = false;
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
                        if (feedData.getThread_Type() == 33) {
                            if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                this.dkQ.add(feedData);
                            }
                        } else {
                            this.dkQ.add(feedData);
                            if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) && !com.baidu.tieba.graffiti.c.agD()) {
                                this.dkQ.remove(feedData);
                            }
                            if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && com.baidu.tbadk.core.util.x.p(feedData.getPraiseList()) == 0) {
                                this.dkQ.remove(feedData);
                            }
                        }
                    }
                }
                this.dkR.a(dataRes.page);
                this.Cy = true;
            } catch (Exception e) {
                this.Cy = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
