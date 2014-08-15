package com.baidu.tieba.model;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.data.FeedData;
import com.baidu.tieba.mention.ReplyMeRequestMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ReplyMe.DataRes;
import tbclient.ReplyMe.ReplyList;
/* loaded from: classes.dex */
public class al extends com.baidu.adp.base.e {
    private com.baidu.tieba.data.ad c = new com.baidu.tieba.data.ad();
    private ArrayList<FeedData> a = new ArrayList<>();
    private com.baidu.tbadk.core.data.l b = new com.baidu.tbadk.core.data.l();
    private boolean d = true;

    public boolean a() {
        return this.d;
    }

    public void a(ArrayList<FeedData> arrayList) {
        this.a = arrayList;
    }

    public ArrayList<FeedData> b() {
        return this.a;
    }

    public com.baidu.tbadk.core.data.l c() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.d = false;
            BdLog.e(e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    FeedData feedData = new FeedData();
                    feedData.parserJson(optJSONArray2.optJSONObject(i));
                    this.a.add(feedData);
                }
            }
            this.c.a(jSONObject.optJSONObject("message"));
            this.b.a(jSONObject.optJSONObject("page"));
            this.d = true;
        } catch (Exception e) {
            this.d = false;
            BdLog.e(e.getMessage());
        }
    }

    public void a(DataRes dataRes) {
        try {
            List<ReplyList> list = dataRes.reply_list;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    FeedData feedData = new FeedData();
                    feedData.parserProtoBuf(list.get(i));
                    this.a.add(feedData);
                }
            }
            this.b.a(dataRes.page);
            this.d = true;
        } catch (Exception e) {
            this.d = false;
            BdLog.e(e.getMessage());
        }
    }

    public void a(int i, int i2) {
        ArrayList<FeedData> b;
        ReplyMeRequestMessage replyMeRequestMessage = new ReplyMeRequestMessage();
        replyMeRequestMessage.set_pn(Integer.valueOf(i2));
        if (i == 4 && (b = b()) != null && b.size() > 0) {
            FeedData feedData = b.get(b.size() - 1);
            replyMeRequestMessage.set_ids(String.format("%s,%s", feedData.getThread_id(), feedData.getPost_id()));
        }
        replyMeRequestMessage.setUpdateType(i);
        replyMeRequestMessage.setModel(this);
        sendMessage(replyMeRequestMessage);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return true;
    }
}
