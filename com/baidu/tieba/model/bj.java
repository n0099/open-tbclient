package com.baidu.tieba.model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bj {
    private com.baidu.tieba.data.ak c = new com.baidu.tieba.data.ak();

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<com.baidu.tieba.data.u> f1912a = new ArrayList<>();
    private com.baidu.tieba.data.an b = new com.baidu.tieba.data.an();
    private boolean d = true;

    public boolean a() {
        return this.d;
    }

    public void a(ArrayList<com.baidu.tieba.data.u> arrayList) {
        this.f1912a = arrayList;
    }

    public ArrayList<com.baidu.tieba.data.u> b() {
        return this.f1912a;
    }

    public com.baidu.tieba.data.an c() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.d = false;
            com.baidu.tieba.util.bg.b("MentionModel", "parserJson", "error = " + e.getMessage());
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
                    this.f1912a.add(uVar);
                }
            }
            this.c.a(jSONObject.optJSONObject("message"));
            this.b.a(jSONObject.optJSONObject("page"));
        } catch (Exception e) {
            this.d = false;
            com.baidu.tieba.util.bg.b("MentionModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
