package com.bytedance.sdk.openadsdk.core.b;

import android.content.Context;
import com.bytedance.sdk.adnet.b.h;
import com.bytedance.sdk.openadsdk.i.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static void a(Context context, String str, long j) {
        new h(1, "https://i.snssdk.com/api/ad/union/sdk/stats/", a(str, j), null).setRetryPolicy(e.b().PT(10000)).build(e.a(context).d());
    }

    private static JSONObject a(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "over_freq");
            jSONObject.put("rit", str);
            jSONObject.put("ad_sdk_version", "3.2.5.1");
            jSONObject.put("timestamp", j);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
