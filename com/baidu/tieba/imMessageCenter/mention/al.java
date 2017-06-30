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
    protected ArrayList<FeedData> duE = new ArrayList<>();
    protected com.baidu.tbadk.core.data.as duF = new com.baidu.tbadk.core.data.as();
    protected ah duG = new ah();

    public ArrayList<FeedData> axM() {
        return this.duE;
    }

    public com.baidu.tbadk.core.data.as qu() {
        return this.duF;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void n(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    FeedData feedData = new FeedData();
                    feedData.parserJson(optJSONArray2.optJSONObject(i));
                    if (feedData.getThread_Type() == 33) {
                        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            this.duE.add(feedData);
                        }
                    } else {
                        this.duE.add(feedData);
                        if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) && !com.baidu.tieba.graffiti.c.akm()) {
                            this.duE.remove(feedData);
                        }
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && com.baidu.tbadk.core.util.z.s(feedData.getPraiseList()) == 0) {
                            this.duE.remove(feedData);
                        }
                    }
                }
            }
            this.duG.parserJson(jSONObject.optJSONObject(PushConstants.EXTRA_PUSH_MESSAGE));
            this.duF.parserJson(jSONObject.optJSONObject("page"));
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
                                this.duE.add(feedData);
                            }
                        } else {
                            this.duE.add(feedData);
                            if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) && !com.baidu.tieba.graffiti.c.akm()) {
                                this.duE.remove(feedData);
                            }
                            if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && com.baidu.tbadk.core.util.z.s(feedData.getPraiseList()) == 0) {
                                this.duE.remove(feedData);
                            }
                        }
                    }
                }
                this.duF.a(dataRes.page);
                this.CB = true;
            } catch (Exception e) {
                this.CB = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
