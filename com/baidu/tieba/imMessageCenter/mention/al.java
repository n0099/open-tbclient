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
    protected ArrayList<FeedData> dsJ = new ArrayList<>();
    protected com.baidu.tbadk.core.data.ak dsK = new com.baidu.tbadk.core.data.ak();
    protected ah dsL = new ah();
    protected boolean vS;

    public ArrayList<FeedData> azf() {
        return this.dsJ;
    }

    public com.baidu.tbadk.core.data.ak getPage() {
        return this.dsK;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void i(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    FeedData feedData = new FeedData();
                    feedData.parserJson(optJSONArray2.optJSONObject(i));
                    if (feedData.getThread_Type() == 33) {
                        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            this.dsJ.add(feedData);
                        }
                    } else {
                        this.dsJ.add(feedData);
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) && !com.baidu.tieba.graffiti.d.al(null)) || (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) && !com.baidu.tieba.graffiti.d.ajH())) {
                            this.dsJ.remove(feedData);
                        }
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && com.baidu.tbadk.core.util.y.s(feedData.getPraiseList()) == 0) {
                            this.dsJ.remove(feedData);
                        }
                    }
                }
            }
            this.dsL.parserJson(jSONObject.optJSONObject("message"));
            this.dsK.parserJson(jSONObject.optJSONObject("page"));
            this.vS = true;
        } catch (Exception e) {
            this.vS = false;
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
                                this.dsJ.add(feedData);
                            }
                        } else {
                            this.dsJ.add(feedData);
                            if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) && !com.baidu.tieba.graffiti.d.al(null)) || (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) && !com.baidu.tieba.graffiti.d.ajH())) {
                                this.dsJ.remove(feedData);
                            }
                            if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && com.baidu.tbadk.core.util.y.s(feedData.getPraiseList()) == 0) {
                                this.dsJ.remove(feedData);
                            }
                        }
                    }
                }
                this.dsK.a(dataRes.page);
                this.vS = true;
            } catch (Exception e) {
                this.vS = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
