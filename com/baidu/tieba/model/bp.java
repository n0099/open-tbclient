package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tieba.data.AntiData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bp {

    /* renamed from: a  reason: collision with root package name */
    private Context f1045a;
    private com.baidu.tieba.data.aw b = new com.baidu.tieba.data.aw();

    public bp(Context context, String str) {
        this.f1045a = context;
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
            com.baidu.tieba.data.r rVar = new com.baidu.tieba.data.r();
            rVar.a(optJSONObject2);
            this.b.a(rVar);
            com.baidu.tieba.data.an anVar = new com.baidu.tieba.data.an();
            anVar.a(optJSONObject);
            anVar.b(this.f1045a);
            this.b.a(anVar);
            int length = optJSONArray.length();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                com.baidu.tieba.data.an anVar2 = new com.baidu.tieba.data.an();
                anVar2.a(jSONObject2);
                anVar2.b(this.f1045a);
                arrayList.add(anVar2);
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
            com.baidu.tieba.util.z.b("SubPbModel", "parseJson", "error = " + e.getMessage());
        }
    }

    public com.baidu.tieba.data.aw a() {
        return this.b;
    }
}
