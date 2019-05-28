package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.util.v;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ReplyMe.DataRes;
import tbclient.ReplyMe.ReplyList;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes4.dex */
public class j implements com.baidu.tbadk.mvc.b.j {
    protected boolean Hi;
    protected ArrayList<FeedData> gPr = new ArrayList<>();
    protected an page = new an();
    protected h gPs = new h();

    public ArrayList<FeedData> bFu() {
        return this.gPr;
    }

    public an getPage() {
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
                    this.gPr.add(feedData);
                    if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && v.Z(feedData.getPraiseList()) == 0) {
                        this.gPr.remove(feedData);
                    }
                }
            }
            this.gPs.parserJson(jSONObject.optJSONObject("message"));
            this.page.parserJson(jSONObject.optJSONObject("page"));
            this.Hi = true;
        } catch (Exception e) {
            this.Hi = false;
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
                        this.gPr.add(feedData);
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && v.Z(feedData.getPraiseList()) == 0) {
                            this.gPr.remove(feedData);
                        }
                    }
                }
                this.page.a(dataRes.page);
                this.Hi = true;
            } catch (Exception e) {
                this.Hi = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
