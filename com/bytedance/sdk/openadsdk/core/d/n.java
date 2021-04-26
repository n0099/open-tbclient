package com.bytedance.sdk.openadsdk.core.d;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public String f28744a;

    public String a() {
        return this.f28744a;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_url", a());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static String a(l lVar) {
        n h2;
        if (lVar == null || (h2 = lVar.h()) == null) {
            return null;
        }
        return h2.a();
    }

    public void a(String str) {
        this.f28744a = str;
    }

    public static n a(JSONObject jSONObject) {
        n nVar = new n();
        nVar.a(jSONObject.optString("playable_url", ""));
        return nVar;
    }
}
