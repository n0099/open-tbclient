package com.bytedance.sdk.openadsdk.core.d;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private String f4401a;

    public String a() {
        return this.f4401a;
    }

    public static String a(l lVar) {
        n h;
        if (lVar == null || (h = lVar.h()) == null) {
            return null;
        }
        return h.a();
    }

    public void a(String str) {
        this.f4401a = str;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_url", a());
        } catch (Exception e) {
        }
        return jSONObject;
    }

    public static n a(JSONObject jSONObject) {
        n nVar = new n();
        nVar.a(jSONObject.optString("playable_url", ""));
        return nVar;
    }
}
