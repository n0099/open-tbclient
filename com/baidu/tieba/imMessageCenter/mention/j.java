package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.am;
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
public class j implements com.baidu.tbadk.mvc.b.j {
    protected boolean Ai;
    protected ArrayList<FeedData> eoF = new ArrayList<>();
    protected am eoG = new am();
    protected h eoH = new h();

    public ArrayList<FeedData> aIG() {
        return this.eoF;
    }

    public am rf() {
        return this.eoG;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void r(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    FeedData feedData = new FeedData();
                    feedData.parserJson(optJSONArray2.optJSONObject(i));
                    this.eoF.add(feedData);
                    if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && v.v(feedData.getPraiseList()) == 0) {
                        this.eoF.remove(feedData);
                    }
                }
            }
            this.eoH.parserJson(jSONObject.optJSONObject("message"));
            this.eoG.parserJson(jSONObject.optJSONObject(WBPageConstants.ParamKey.PAGE));
            this.Ai = true;
        } catch (Exception e) {
            this.Ai = false;
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
                        this.eoF.add(feedData);
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && v.v(feedData.getPraiseList()) == 0) {
                            this.eoF.remove(feedData);
                        }
                    }
                }
                this.eoG.a(dataRes.page);
                this.Ai = true;
            } catch (Exception e) {
                this.Ai = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
