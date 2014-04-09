package com.baidu.tieba.signall;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class p {
    private int a;
    private String b;
    private int c;
    private String d;
    private com.baidu.tieba.home.q e = new com.baidu.tieba.home.q();
    private ArrayList<q> f = new ArrayList<>();

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final com.baidu.tieba.home.q c() {
        return this.e;
    }

    public final ArrayList<q> d() {
        return this.f;
    }

    public final int e() {
        return this.c;
    }

    public final String f() {
        return this.d;
    }

    public final void a(String str) {
        if (str != null) {
            try {
                a(new JSONObject(str));
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.e.a(jSONObject.optJSONObject("error"));
                this.a = jSONObject.optInt("show_dialog");
                this.b = jSONObject.optString("sign_notice");
                this.c = jSONObject.optInt("is_timeout");
                this.d = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        q qVar = new q();
                        qVar.a(jSONObject2);
                        this.f.add(qVar);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
