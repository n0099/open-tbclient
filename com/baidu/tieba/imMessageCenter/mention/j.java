package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.x;
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
    protected boolean isSucc;
    protected ArrayList<FeedData> kJR = new ArrayList<>();
    protected ax page = new ax();
    protected h kJS = new h();

    public ArrayList<FeedData> cXu() {
        return this.kJR;
    }

    public ax getPage() {
        return this.page;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void initByJson(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    FeedData feedData = new FeedData();
                    feedData.parserJson(optJSONArray2.optJSONObject(i));
                    this.kJR.add(feedData);
                    if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && x.getCount(feedData.getPraiseList()) == 0) {
                        this.kJR.remove(feedData);
                    }
                }
            }
            this.kJS.parserJson(jSONObject.optJSONObject("message"));
            this.page.parserJson(jSONObject.optJSONObject("page"));
            this.isSucc = true;
        } catch (Exception e) {
            this.isSucc = false;
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void initByProtobuf(Message message) {
        if (message instanceof ReplyMeResIdl) {
            DataRes dataRes = ((ReplyMeResIdl) message).data;
            try {
                List<ReplyList> list = dataRes.reply_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        FeedData feedData = new FeedData();
                        feedData.parserProtoBuf(list.get(i));
                        this.kJR.add(feedData);
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && x.getCount(feedData.getPraiseList()) == 0) {
                            this.kJR.remove(feedData);
                        }
                    }
                }
                this.page.a(dataRes.page);
                this.isSucc = true;
            } catch (Exception e) {
                this.isSucc = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
