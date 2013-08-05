package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tieba.data.AntiData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class by {

    /* renamed from: a  reason: collision with root package name */
    private Context f1364a;
    private com.baidu.tieba.data.bh b = new com.baidu.tieba.data.bh();

    public by(Context context, String str) {
        this.f1364a = context;
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
            com.baidu.tieba.data.bm bmVar = new com.baidu.tieba.data.bm();
            bmVar.a(optJSONObject3);
            this.b.a(bmVar);
            com.baidu.tieba.data.v vVar = new com.baidu.tieba.data.v();
            vVar.a(optJSONObject2);
            this.b.a(vVar);
            com.baidu.tieba.data.aw awVar = new com.baidu.tieba.data.aw();
            awVar.a(optJSONObject);
            awVar.b(this.f1364a);
            this.b.a(awVar);
            int length = optJSONArray.length();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                com.baidu.tieba.data.aw awVar2 = new com.baidu.tieba.data.aw();
                awVar2.a(jSONObject2);
                awVar2.b(this.f1364a);
                arrayList.add(awVar2);
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
            com.baidu.tieba.util.aj.b("SubPbModel", "parseJson", "error = " + e.getMessage());
        }
    }

    public com.baidu.tieba.data.bh a() {
        return this.b;
    }
}
