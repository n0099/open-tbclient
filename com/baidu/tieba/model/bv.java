package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ForumData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bv {
    private Context a;
    private com.baidu.tieba.data.av b = new com.baidu.tieba.data.av();

    public bv(Context context, String str) {
        this.a = context;
        a(str);
    }

    private void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("post");
            JSONArray optJSONArray = jSONObject.optJSONArray("subpost_list");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("forum");
            JSONObject optJSONObject3 = jSONObject.optJSONObject("thread");
            JSONObject optJSONObject4 = jSONObject.optJSONObject("anti");
            AntiData antiData = new AntiData();
            antiData.parserJson(optJSONObject4);
            this.b.a(antiData);
            com.baidu.tieba.data.az azVar = new com.baidu.tieba.data.az();
            azVar.a(optJSONObject3);
            this.b.a(azVar);
            ForumData forumData = new ForumData();
            forumData.parserJson(optJSONObject2);
            this.b.a(forumData);
            com.baidu.tieba.data.aq aqVar = new com.baidu.tieba.data.aq();
            aqVar.a(optJSONObject);
            aqVar.a(this.a);
            this.b.a(aqVar);
            int length = optJSONArray.length();
            ArrayList<com.baidu.tieba.data.aq> arrayList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                com.baidu.tieba.data.aq aqVar2 = new com.baidu.tieba.data.aq();
                aqVar2.a(jSONObject2);
                aqVar2.a(this.a);
                arrayList.add(aqVar2);
            }
            this.b.a(arrayList);
            JSONObject optJSONObject5 = jSONObject.optJSONObject("page");
            int optInt = optJSONObject5.optInt("total_page");
            int optInt2 = optJSONObject5.optInt("page_size");
            int optInt3 = optJSONObject5.optInt("current_page");
            int optInt4 = optJSONObject5.optInt("total_count");
            this.b.e(optInt3);
            this.b.d(optInt2);
            this.b.c(optInt4);
            this.b.b(optInt);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("SubPbModel", "parseJson", "error = " + e.getMessage());
        }
    }

    public com.baidu.tieba.data.av a() {
        return this.b;
    }
}
