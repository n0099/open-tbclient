package com.bytedance.sdk.openadsdk.core.b;

import android.content.Context;
import com.bytedance.sdk.openadsdk.i.e;
import com.bytedance.sdk.openadsdk.utils.aj;
import d.b.c.b.b.h;
import d.b.c.b.d.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    public static void a(Context context, String str, long j) {
        h hVar = new h(1, aj.b("https://i.snssdk.com/api/ad/union/sdk/stats/"), a(str, j), null);
        g b2 = e.b();
        b2.b(10000);
        hVar.setRetryPolicy(b2).build(e.c().e());
    }

    public static JSONObject a(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "over_freq");
            jSONObject.put("rit", str);
            jSONObject.put("ad_sdk_version", "3.4.5.5");
            jSONObject.put("timestamp", j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
