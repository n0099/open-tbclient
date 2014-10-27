package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class an {
    private com.baidu.tieba.data.ar bpm = new com.baidu.tieba.data.ar();
    private Context mContext;

    public an(Context context, String str) {
        this.mContext = context;
        parseJson(str);
    }

    private void parseJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("post");
            JSONArray optJSONArray = jSONObject.optJSONArray("subpost_list");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("forum");
            JSONObject optJSONObject3 = jSONObject.optJSONObject("thread");
            JSONObject optJSONObject4 = jSONObject.optJSONObject("anti");
            AntiData antiData = new AntiData();
            antiData.parserJson(optJSONObject4);
            this.bpm.a(antiData);
            com.baidu.tbadk.core.data.q qVar = new com.baidu.tbadk.core.data.q();
            qVar.parserJson(optJSONObject3);
            this.bpm.a(qVar);
            ForumData forumData = new ForumData();
            forumData.parserJson(optJSONObject2);
            this.bpm.a(forumData);
            com.baidu.tieba.data.ak akVar = new com.baidu.tieba.data.ak();
            akVar.parserJson(optJSONObject);
            akVar.O(this.mContext);
            this.bpm.a(akVar);
            int length = optJSONArray.length();
            ArrayList<com.baidu.tieba.data.ak> arrayList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                com.baidu.tieba.data.ak akVar2 = new com.baidu.tieba.data.ak();
                akVar2.parserJson(jSONObject2);
                akVar2.O(this.mContext);
                arrayList.add(akVar2);
            }
            this.bpm.l(arrayList);
            JSONObject optJSONObject5 = jSONObject.optJSONObject("page");
            int optInt = optJSONObject5.optInt("total_page");
            int optInt2 = optJSONObject5.optInt("page_size");
            int optInt3 = optJSONObject5.optInt("current_page");
            int optInt4 = optJSONObject5.optInt("total_count");
            this.bpm.ek(optInt3);
            this.bpm.ej(optInt2);
            this.bpm.setTotalCount(optInt4);
            this.bpm.ei(optInt);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public com.baidu.tieba.data.ar TL() {
        return this.bpm;
    }
}
