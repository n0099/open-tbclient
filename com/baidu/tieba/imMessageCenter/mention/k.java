package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.v;
import com.sina.weibo.sdk.constant.WBPageConstants;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ReplyMe.DataRes;
import tbclient.ReplyMe.ReplyList;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes2.dex */
public class k implements com.baidu.tbadk.mvc.b.j {
    protected boolean apG;
    protected ArrayList<FeedData> eSJ = new ArrayList<>();
    protected al eSK = new al();
    protected h eSL = new h();

    public ArrayList<FeedData> aNE() {
        return this.eSJ;
    }

    public al yA() {
        return this.eSK;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void o(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    FeedData feedData = new FeedData();
                    feedData.parserJson(optJSONArray2.optJSONObject(i));
                    if (feedData.getThread_Type() == 33) {
                        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            this.eSJ.add(feedData);
                        }
                    } else {
                        this.eSJ.add(feedData);
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && v.D(feedData.getPraiseList()) == 0) {
                            this.eSJ.remove(feedData);
                        }
                    }
                }
            }
            this.eSL.parserJson(jSONObject.optJSONObject("message"));
            this.eSK.parserJson(jSONObject.optJSONObject(WBPageConstants.ParamKey.PAGE));
            this.apG = true;
        } catch (Exception e) {
            this.apG = false;
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
                                this.eSJ.add(feedData);
                            }
                        } else {
                            this.eSJ.add(feedData);
                            if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && v.D(feedData.getPraiseList()) == 0) {
                                this.eSJ.remove(feedData);
                            }
                        }
                    }
                }
                this.eSK.a(dataRes.page);
                this.apG = true;
            } catch (Exception e) {
                this.apG = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
