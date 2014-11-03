package com.baidu.tieba.model;

import android.content.Context;
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
public class am extends com.baidu.adp.base.e {
    private boolean Ln;
    private com.baidu.tbadk.core.data.m alT;
    private ArrayList<FeedData> bpy;
    private com.baidu.tieba.data.ac bpz;

    public am(Context context) {
        super(context);
        this.bpz = new com.baidu.tieba.data.ac();
        this.bpy = new ArrayList<>();
        this.alT = new com.baidu.tbadk.core.data.m();
        this.Ln = true;
    }

    public boolean isSucc() {
        return this.Ln;
    }

    public void B(ArrayList<FeedData> arrayList) {
        this.bpy = arrayList;
    }

    public ArrayList<FeedData> TN() {
        return this.bpy;
    }

    public com.baidu.tbadk.core.data.m zO() {
        return this.alT;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            this.Ln = false;
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    FeedData feedData = new FeedData();
                    feedData.parserJson(optJSONArray2.optJSONObject(i));
                    this.bpy.add(feedData);
                }
            }
            this.bpz.parserJson(jSONObject.optJSONObject("message"));
            this.alT.parserJson(jSONObject.optJSONObject("page"));
            this.Ln = true;
        } catch (Exception e) {
            this.Ln = false;
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
                    this.bpy.add(feedData);
                }
            }
            this.alT.a(dataRes.page);
            this.Ln = true;
        } catch (Exception e) {
            this.Ln = false;
            BdLog.e(e.getMessage());
        }
    }

    public void U(int i, int i2) {
        ArrayList<FeedData> TN;
        ReplyMeRequestMessage replyMeRequestMessage = new ReplyMeRequestMessage();
        replyMeRequestMessage.set_pn(Integer.valueOf(i2));
        if (i == 4 && (TN = TN()) != null && TN.size() > 0) {
            FeedData feedData = TN.get(TN.size() - 1);
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
