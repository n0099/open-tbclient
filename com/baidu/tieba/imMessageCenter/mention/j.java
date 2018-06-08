package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.util.w;
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
public class j implements com.baidu.tbadk.mvc.b.j {
    protected boolean Gp;
    protected ArrayList<FeedData> ezW = new ArrayList<>();
    protected am ezX = new am();
    protected h ezY = new h();

    public ArrayList<FeedData> aNB() {
        return this.ezW;
    }

    public am uB() {
        return this.ezX;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void v(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    FeedData feedData = new FeedData();
                    feedData.parserJson(optJSONArray2.optJSONObject(i));
                    this.ezW.add(feedData);
                    if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && w.y(feedData.getPraiseList()) == 0) {
                        this.ezW.remove(feedData);
                    }
                }
            }
            this.ezY.parserJson(jSONObject.optJSONObject("message"));
            this.ezX.parserJson(jSONObject.optJSONObject(WBPageConstants.ParamKey.PAGE));
            this.Gp = true;
        } catch (Exception e) {
            this.Gp = false;
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
                        this.ezW.add(feedData);
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && w.y(feedData.getPraiseList()) == 0) {
                            this.ezW.remove(feedData);
                        }
                    }
                }
                this.ezX.a(dataRes.page);
                this.Gp = true;
            } catch (Exception e) {
                this.Gp = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
