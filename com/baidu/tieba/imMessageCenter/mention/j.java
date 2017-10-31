package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ap;
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
    protected boolean BJ;
    protected ArrayList<FeedData> dRJ = new ArrayList<>();
    protected ap dRK = new ap();
    protected h dRL = new h();

    public ArrayList<FeedData> aDd() {
        return this.dRJ;
    }

    public ap qv() {
        return this.dRK;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void k(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    FeedData feedData = new FeedData();
                    feedData.parserJson(optJSONArray2.optJSONObject(i));
                    if (feedData.getThread_Type() == 33) {
                        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            this.dRJ.add(feedData);
                        }
                    } else {
                        this.dRJ.add(feedData);
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && v.u(feedData.getPraiseList()) == 0) {
                            this.dRJ.remove(feedData);
                        }
                    }
                }
            }
            this.dRL.parserJson(jSONObject.optJSONObject(PushConstants.EXTRA_PUSH_MESSAGE));
            this.dRK.parserJson(jSONObject.optJSONObject("page"));
            this.BJ = true;
        } catch (Exception e) {
            this.BJ = false;
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
                            if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                this.dRJ.add(feedData);
                            }
                        } else {
                            this.dRJ.add(feedData);
                            if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && v.u(feedData.getPraiseList()) == 0) {
                                this.dRJ.remove(feedData);
                            }
                        }
                    }
                }
                this.dRK.a(dataRes.page);
                this.BJ = true;
            } catch (Exception e) {
                this.BJ = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
