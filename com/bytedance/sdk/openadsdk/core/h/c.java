package com.bytedance.sdk.openadsdk.core.h;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    String f6578a;

    /* renamed from: b  reason: collision with root package name */
    HashMap<String, d> f6579b = new HashMap<>();

    private c() {
    }

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            c cVar = new c();
            cVar.a(jSONObject.optString("cip"));
            JSONArray optJSONArray = jSONObject.optJSONArray("dns");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    d a2 = d.a(optJSONArray.getJSONObject(i));
                    cVar.b().put(a2.a(), a2);
                }
            } else {
                d a3 = d.a(jSONObject);
                cVar.b().put(a3.a(), a3);
            }
            return cVar;
        } catch (Exception e) {
            return null;
        }
    }

    public String a() {
        return this.f6578a;
    }

    public void a(String str) {
        this.f6578a = str;
    }

    public HashMap<String, d> b() {
        return this.f6579b;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cip", a());
            JSONArray jSONArray = new JSONArray();
            if (b() != null) {
                for (Map.Entry<String, d> entry : b().entrySet()) {
                    jSONArray.put(entry.getValue().h());
                }
            }
            jSONObject.put("dns", jSONArray);
        } catch (Exception e) {
        }
        return jSONObject;
    }
}
