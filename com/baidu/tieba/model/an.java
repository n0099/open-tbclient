package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class an {
    private Context a;
    private com.baidu.tieba.data.an b = new com.baidu.tieba.data.an();

    public an(Context context, String str) {
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
            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
            oVar.a(optJSONObject3);
            this.b.a(oVar);
            ForumData forumData = new ForumData();
            forumData.parserJson(optJSONObject2);
            this.b.a(forumData);
            com.baidu.tieba.data.ai aiVar = new com.baidu.tieba.data.ai();
            aiVar.a(optJSONObject);
            aiVar.a(this.a);
            this.b.a(aiVar);
            int length = optJSONArray.length();
            ArrayList<com.baidu.tieba.data.ai> arrayList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                com.baidu.tieba.data.ai aiVar2 = new com.baidu.tieba.data.ai();
                aiVar2.a(jSONObject2);
                aiVar2.a(this.a);
                arrayList.add(aiVar2);
            }
            this.b.a(arrayList);
            JSONObject optJSONObject5 = jSONObject.optJSONObject("page");
            int optInt = optJSONObject5.optInt("total_page");
            int optInt2 = optJSONObject5.optInt("page_size");
            int optInt3 = optJSONObject5.optInt("current_page");
            int optInt4 = optJSONObject5.optInt("total_count");
            this.b.d(optInt3);
            this.b.c(optInt2);
            this.b.b(optInt4);
            this.b.a(optInt);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("MentionSubPbModel", "parseJson", "error = " + e.getMessage());
        }
    }

    public final com.baidu.tieba.data.an a() {
        return this.b;
    }
}
