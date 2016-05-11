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
public class al implements com.baidu.tbadk.mvc.b.j {
    protected ArrayList<FeedData> cyK = new ArrayList<>();
    protected com.baidu.tbadk.core.data.ad cyL = new com.baidu.tbadk.core.data.ad();
    protected ah cyM = new ah();
    protected boolean sZ;

    public ArrayList<FeedData> alr() {
        return this.cyK;
    }

    public com.baidu.tbadk.core.data.ad getPage() {
        return this.cyL;
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
                    if (feedData.getThread_Type() == 33) {
                        if (TbadkCoreApplication.m11getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            this.cyK.add(feedData);
                        }
                    } else {
                        this.cyK.add(feedData);
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) && !com.baidu.tieba.graffiti.d.aj(null)) || (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) && !com.baidu.tieba.graffiti.d.XZ())) {
                            this.cyK.remove(feedData);
                        }
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && com.baidu.tbadk.core.util.y.r(feedData.getPraiseList()) == 0) {
                            this.cyK.remove(feedData);
                        }
                    }
                }
            }
            this.cyM.parserJson(jSONObject.optJSONObject("message"));
            this.cyL.parserJson(jSONObject.optJSONObject("page"));
            this.sZ = true;
        } catch (Exception e) {
            this.sZ = false;
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
                            if (TbadkCoreApplication.m11getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                this.cyK.add(feedData);
                            }
                        } else {
                            this.cyK.add(feedData);
                            if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) && !com.baidu.tieba.graffiti.d.aj(null)) || (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) && !com.baidu.tieba.graffiti.d.XZ())) {
                                this.cyK.remove(feedData);
                            }
                            if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && com.baidu.tbadk.core.util.y.r(feedData.getPraiseList()) == 0) {
                                this.cyK.remove(feedData);
                            }
                        }
                    }
                }
                this.cyL.a(dataRes.page);
                this.sZ = true;
            } catch (Exception e) {
                this.sZ = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
