package com.bytedance.sdk.openadsdk.downloadnew.a.b;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompatJellybean;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.l;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public l f29073a;

    /* renamed from: b  reason: collision with root package name */
    public String f29074b;

    /* renamed from: c  reason: collision with root package name */
    public String f29075c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f29076d;

    public static a a() {
        return new a();
    }

    public a b(String str) {
        this.f29075c = str;
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
        this.f29076d = jSONObject;
        return this;
    }

    @NonNull
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", this.f29074b);
            jSONObject.put(NotificationCompatJellybean.KEY_LABEL, this.f29075c);
            if (this.f29076d != null) {
                jSONObject.put("extra", this.f29076d);
            }
            if (this.f29073a != null) {
                jSONObject.put("material_meta", this.f29073a.aL());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public a a(l lVar) {
        this.f29073a = lVar;
        return this;
    }

    public a a(String str) {
        this.f29074b = str;
        return this;
    }
}
