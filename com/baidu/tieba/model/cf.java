package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ForumData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class cf {

    /* renamed from: a  reason: collision with root package name */
    private Context f1930a;
    private com.baidu.tieba.data.aw b = new com.baidu.tieba.data.aw();

    public cf(Context context, String str) {
        this.f1930a = context;
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
            com.baidu.tieba.data.ba baVar = new com.baidu.tieba.data.ba();
            baVar.a(optJSONObject3);
            this.b.a(baVar);
            ForumData forumData = new ForumData();
            forumData.parserJson(optJSONObject2);
            this.b.a(forumData);
            com.baidu.tieba.data.as asVar = new com.baidu.tieba.data.as();
            asVar.a(optJSONObject);
            asVar.a(this.f1930a);
            this.b.a(asVar);
            int length = optJSONArray.length();
            ArrayList<com.baidu.tieba.data.as> arrayList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                com.baidu.tieba.data.as asVar2 = new com.baidu.tieba.data.as();
                asVar2.a(jSONObject2);
                asVar2.a(this.f1930a);
                arrayList.add(asVar2);
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
            com.baidu.tieba.util.bg.b("SubPbModel", "parseJson", "error = " + e.getMessage());
        }
    }

    public com.baidu.tieba.data.aw a() {
        return this.b;
    }
}
