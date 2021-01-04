package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements i {

    /* renamed from: a  reason: collision with root package name */
    public final String f6515a;

    /* renamed from: b  reason: collision with root package name */
    public final JSONObject f6516b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, JSONObject jSONObject) {
        this.f6515a = str;
        this.f6516b = jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(Context context, String str, String str2, String str3, JSONObject jSONObject) {
        return new a(UUID.randomUUID().toString(), b(context, str, str2, str3, jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        return new a(UUID.randomUUID().toString(), b(str, str2, str3, j, j2, jSONObject));
    }

    private static JSONObject b(Context context, String str, String str2, String str3, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("event_ts", System.currentTimeMillis());
            jSONObject2.putOpt("tag", str);
            jSONObject2.putOpt("label", str2);
            jSONObject2.putOpt("category", "app_union");
            try {
                jSONObject2.putOpt("value", Long.valueOf(Long.parseLong(str3)));
            } catch (NumberFormatException e) {
                jSONObject2.putOpt("value", 0L);
            }
            jSONObject2.putOpt("is_ad_event", "1");
            jSONObject2.putOpt("nt", Integer.valueOf(x.c(context)));
            jSONObject2.putOpt("tob_ab_sdk_version", com.bytedance.sdk.openadsdk.core.i.c().t());
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.putOpt(next, jSONObject.opt(next));
                }
            }
        } catch (Exception e2) {
        }
        return jSONObject2;
    }

    private static JSONObject b(String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("event_ts", System.currentTimeMillis());
            jSONObject2.putOpt("tag", str2);
            jSONObject2.putOpt("label", str3);
            jSONObject2.putOpt("category", str);
            jSONObject2.putOpt("value", Long.valueOf(j));
            jSONObject2.putOpt("is_ad_event", "1");
            jSONObject2.putOpt("ext_value", Long.valueOf(j2));
            jSONObject2.putOpt("tob_ab_sdk_version", com.bytedance.sdk.openadsdk.core.i.c().t());
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.putOpt(next, jSONObject.opt(next));
                }
            }
        } catch (Exception e) {
        }
        return jSONObject2;
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("localId", null);
            JSONObject optJSONObject = jSONObject.optJSONObject("event");
            if (TextUtils.isEmpty(optString) || optJSONObject == null) {
                return null;
            }
            return new a(optString, optJSONObject);
        } catch (Throwable th) {
            return null;
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.f6515a) || this.f6516b == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.f6515a);
            jSONObject.put("event", this.f6516b);
        } catch (Throwable th) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.c.i
    public String b() {
        return this.f6515a;
    }
}
