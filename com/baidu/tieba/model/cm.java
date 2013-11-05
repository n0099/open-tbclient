package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ForumData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class cm {

    /* renamed from: a  reason: collision with root package name */
    private Context f1939a;
    private com.baidu.tieba.data.bb b = new com.baidu.tieba.data.bb();

    public cm(Context context, String str) {
        this.f1939a = context;
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
            com.baidu.tieba.data.bf bfVar = new com.baidu.tieba.data.bf();
            bfVar.a(optJSONObject3);
            this.b.a(bfVar);
            ForumData forumData = new ForumData();
            forumData.parserJson(optJSONObject2);
            this.b.a(forumData);
            com.baidu.tieba.data.as asVar = new com.baidu.tieba.data.as();
            asVar.a(optJSONObject);
            asVar.b(this.f1939a);
            this.b.a(asVar);
            int length = optJSONArray.length();
            ArrayList<com.baidu.tieba.data.as> arrayList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                com.baidu.tieba.data.as asVar2 = new com.baidu.tieba.data.as();
                asVar2.a(jSONObject2);
                asVar2.b(this.f1939a);
                arrayList.add(asVar2);
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
            com.baidu.tieba.util.be.b("SubPbModel", "parseJson", "error = " + e.getMessage());
        }
    }

    public com.baidu.tieba.data.bb a() {
        return this.b;
    }
}
