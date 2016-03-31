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
    protected boolean CK;
    protected ArrayList<FeedData> cxL = new ArrayList<>();
    protected com.baidu.tbadk.core.data.ac cxM = new com.baidu.tbadk.core.data.ac();
    protected ag cxN = new ag();

    public ArrayList<FeedData> alk() {
        return this.cxL;
    }

    public com.baidu.tbadk.core.data.ac getPage() {
        return this.cxM;
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
                        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            this.cxL.add(feedData);
                        }
                    } else {
                        this.cxL.add(feedData);
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) && !com.baidu.tieba.graffiti.d.af(null)) || (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) && !com.baidu.tieba.graffiti.d.Yf())) {
                            this.cxL.remove(feedData);
                        }
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && com.baidu.tbadk.core.util.y.p(feedData.getPraiseList()) == 0) {
                            this.cxL.remove(feedData);
                        }
                    }
                }
            }
            this.cxN.parserJson(jSONObject.optJSONObject("message"));
            this.cxM.parserJson(jSONObject.optJSONObject("page"));
            this.CK = true;
        } catch (Exception e) {
            this.CK = false;
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
                            if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                this.cxL.add(feedData);
                            }
                        } else {
                            this.cxL.add(feedData);
                            if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) && !com.baidu.tieba.graffiti.d.af(null)) || (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) && !com.baidu.tieba.graffiti.d.Yf())) {
                                this.cxL.remove(feedData);
                            }
                            if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && com.baidu.tbadk.core.util.y.p(feedData.getPraiseList()) == 0) {
                                this.cxL.remove(feedData);
                            }
                        }
                    }
                }
                this.cxM.a(dataRes.page);
                this.CK = true;
            } catch (Exception e) {
                this.CK = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
