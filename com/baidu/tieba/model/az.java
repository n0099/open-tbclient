package com.baidu.tieba.model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class az {
    private com.baidu.tieba.data.aj c = new com.baidu.tieba.data.aj();

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<com.baidu.tieba.data.u> f1411a = new ArrayList<>();
    private com.baidu.tieba.data.an b = new com.baidu.tieba.data.an();
    private boolean d = true;

    public boolean a() {
        return this.d;
    }

    public void a(ArrayList<com.baidu.tieba.data.u> arrayList) {
        this.f1411a = arrayList;
    }

    public ArrayList<com.baidu.tieba.data.u> b() {
        return this.f1411a;
    }

    public com.baidu.tieba.data.an c() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.d = false;
            com.baidu.tieba.util.av.b("MentionModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    com.baidu.tieba.data.u uVar = new com.baidu.tieba.data.u();
                    uVar.a(optJSONArray2.optJSONObject(i));
                    this.f1411a.add(uVar);
                }
            }
            this.c.a(jSONObject.optJSONObject("message"));
            this.b.a(jSONObject.optJSONObject("page"));
        } catch (Exception e) {
            this.d = false;
            com.baidu.tieba.util.av.b("MentionModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
