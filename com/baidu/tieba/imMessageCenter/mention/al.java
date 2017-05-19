package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushConstants;
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
/* loaded from: classes2.dex */
public class al implements com.baidu.tbadk.mvc.b.j {
    protected boolean CB;
    protected ArrayList<FeedData> dhm = new ArrayList<>();
    protected com.baidu.tbadk.core.data.aq dhn = new com.baidu.tbadk.core.data.aq();
    protected ah dho = new ah();

    public ArrayList<FeedData> atk() {
        return this.dhm;
    }

    public com.baidu.tbadk.core.data.aq qB() {
        return this.dhn;
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
                            this.dhm.add(feedData);
                        }
                    } else {
                        this.dhm.add(feedData);
                        if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) && !com.baidu.tieba.graffiti.c.afn()) {
                            this.dhm.remove(feedData);
                        }
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && com.baidu.tbadk.core.util.x.q(feedData.getPraiseList()) == 0) {
                            this.dhm.remove(feedData);
                        }
                    }
                }
            }
            this.dho.parserJson(jSONObject.optJSONObject(PushConstants.EXTRA_PUSH_MESSAGE));
            this.dhn.parserJson(jSONObject.optJSONObject("page"));
            this.CB = true;
        } catch (Exception e) {
            this.CB = false;
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
                                this.dhm.add(feedData);
                            }
                        } else {
                            this.dhm.add(feedData);
                            if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) && !com.baidu.tieba.graffiti.c.afn()) {
                                this.dhm.remove(feedData);
                            }
                            if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && com.baidu.tbadk.core.util.x.q(feedData.getPraiseList()) == 0) {
                                this.dhm.remove(feedData);
                            }
                        }
                    }
                }
                this.dhn.a(dataRes.page);
                this.CB = true;
            } catch (Exception e) {
                this.CB = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
