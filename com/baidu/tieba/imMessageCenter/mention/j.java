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
    protected boolean BZ;
    protected ArrayList<FeedData> dJX = new ArrayList<>();
    protected ap dJY = new ap();
    protected h dJZ = new h();

    public ArrayList<FeedData> aAI() {
        return this.dJX;
    }

    public ap qq() {
        return this.dJY;
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
                            this.dJX.add(feedData);
                        }
                    } else {
                        this.dJX.add(feedData);
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && v.t(feedData.getPraiseList()) == 0) {
                            this.dJX.remove(feedData);
                        }
                    }
                }
            }
            this.dJZ.parserJson(jSONObject.optJSONObject(PushConstants.EXTRA_PUSH_MESSAGE));
            this.dJY.parserJson(jSONObject.optJSONObject("page"));
            this.BZ = true;
        } catch (Exception e) {
            this.BZ = false;
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
                                this.dJX.add(feedData);
                            }
                        } else {
                            this.dJX.add(feedData);
                            if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && v.t(feedData.getPraiseList()) == 0) {
                                this.dJX.remove(feedData);
                            }
                        }
                    }
                }
                this.dJY.a(dataRes.page);
                this.BZ = true;
            } catch (Exception e) {
                this.BZ = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
