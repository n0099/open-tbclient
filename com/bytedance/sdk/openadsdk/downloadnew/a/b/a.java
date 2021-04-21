package com.bytedance.sdk.openadsdk.downloadnew.a.b;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompatJellybean;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.l;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public l f28907a;

    /* renamed from: b  reason: collision with root package name */
    public String f28908b;

    /* renamed from: c  reason: collision with root package name */
    public String f28909c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f28910d;

    public static a a() {
        return new a();
    }

    public a b(String str) {
        this.f28909c = str;
        return this;
    }

    public static a a(JSONObject jSONObject) {
        String str;
        String str2;
        JSONObject jSONObject2;
        l lVar = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            str = jSONObject.optString("tag", null);
        } catch (Exception unused) {
            str = null;
            str2 = null;
        }
        try {
            str2 = jSONObject.optString(NotificationCompatJellybean.KEY_LABEL, null);
            try {
                jSONObject2 = jSONObject.optJSONObject("extra");
                try {
                    lVar = c.a(jSONObject.optJSONObject("material_meta"));
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                jSONObject2 = null;
            }
        } catch (Exception unused4) {
            str2 = null;
            jSONObject2 = str2;
            return a().a(str).b(str2).b(jSONObject2).a(lVar);
        }
        return a().a(str).b(str2).b(jSONObject2).a(lVar);
    }

    public a b(JSONObject jSONObject) {
        this.f28910d = jSONObject;
        return this;
    }

    @NonNull
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", this.f28908b);
            jSONObject.put(NotificationCompatJellybean.KEY_LABEL, this.f28909c);
            if (this.f28910d != null) {
                jSONObject.put("extra", this.f28910d);
            }
            if (this.f28907a != null) {
                jSONObject.put("material_meta", this.f28907a.aL());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public a a(l lVar) {
        this.f28907a = lVar;
        return this;
    }

    public a a(String str) {
        this.f28908b = str;
        return this;
    }
}
