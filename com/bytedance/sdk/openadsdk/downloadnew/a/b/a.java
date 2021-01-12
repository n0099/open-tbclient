package com.bytedance.sdk.openadsdk.downloadnew.a.b;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.l;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public l f7092a;

    /* renamed from: b  reason: collision with root package name */
    public String f7093b;
    public String c;
    public JSONObject d;

    public static a a() {
        return new a();
    }

    public static a a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        String str;
        String str2;
        l lVar = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            str2 = jSONObject.optString("tag", null);
            try {
                str = jSONObject.optString("label", null);
                try {
                    jSONObject2 = jSONObject.optJSONObject("extra");
                    try {
                        lVar = c.a(jSONObject.optJSONObject("material_meta"));
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    jSONObject2 = null;
                }
            } catch (Exception e3) {
                jSONObject2 = null;
                str = null;
            }
        } catch (Exception e4) {
            jSONObject2 = null;
            str = null;
            str2 = null;
        }
        return a().a(str2).b(str).b(jSONObject2).a(lVar);
    }

    public a a(l lVar) {
        this.f7092a = lVar;
        return this;
    }

    public a a(String str) {
        this.f7093b = str;
        return this;
    }

    public a b(String str) {
        this.c = str;
        return this;
    }

    public a b(JSONObject jSONObject) {
        this.d = jSONObject;
        return this;
    }

    @NonNull
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", this.f7093b);
            jSONObject.put("label", this.c);
            if (this.d != null) {
                jSONObject.put("extra", this.d);
            }
            if (this.f7092a != null) {
                jSONObject.put("material_meta", this.f7092a.am());
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }
}
