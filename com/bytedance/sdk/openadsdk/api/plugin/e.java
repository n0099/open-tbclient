package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.api.plugin.g;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class e {
    public static SharedPreferences b;
    public static ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor(new g.a("tt_pangle_thread_pl_report"));
    public static volatile boolean c = false;
    public static Map<String, String> d = new HashMap();

    public static void c(final String str, final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("action", 1);
            bundle.putString("event_name", str);
            bundle.putString("event_extra", jSONObject.toString());
            adManager.getExtra(Bundle.class, bundle);
        } else if (c) {
        } else {
            a.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.b(e.d(str, jSONObject));
                }
            });
        }
    }

    public static JSONObject d(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("support_abi", Arrays.toString(Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2}));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ad_sdk_version", "4.0.2.2");
            jSONObject3.put("plugin_version", "4.0.2.2");
            jSONObject3.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject3.put("is_plugin", true);
            jSONObject3.put("event_extra", jSONObject.toString());
            jSONObject3.put("type", str);
            jSONObject3.put("appid", d.get("appid"));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("model", Build.MODEL);
            jSONObject4.put("vendor", Build.MANUFACTURER);
            jSONObject4.put("imei", d.get("imei"));
            jSONObject4.put("oaid", d.get("oaid"));
            jSONObject3.put("device_info", jSONObject4);
            jSONArray.put(jSONObject3);
            jSONObject2.put("stats_list", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public static void a(Context context) {
        b = context.getSharedPreferences("tt_sdk_settings", 0);
    }

    public static String b(JSONObject jSONObject) {
        SharedPreferences sharedPreferences = b;
        return com.bytedance.sdk.openadsdk.api.a.c.a().a(true, String.format("https://%s%s", sharedPreferences != null ? sharedPreferences.getString("url_alog", "pangolin.snssdk.com") : "pangolin.snssdk.com", "/api/ad/union/sdk/stats/batch/"), com.bytedance.sdk.openadsdk.api.b.b.a(jSONObject).toString().getBytes());
    }

    public static final void a(int i, String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("duration", Long.valueOf(j));
            jSONObject.putOpt("code", Integer.valueOf(i));
            jSONObject.putOpt("message", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("plugin_load_failed", jSONObject);
    }

    public static void b(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            String string = bundle.getString("event_name");
            String string2 = bundle.getString("event_extra");
            b(d(string, TextUtils.isEmpty(string2) ? new JSONObject() : new JSONObject(string2)));
        } catch (Exception unused) {
        }
    }

    public static void a(String str, JSONObject jSONObject) {
        c("zeus_" + str, jSONObject);
    }

    public static void a() {
        if (c) {
            return;
        }
        try {
            c = true;
            a.shutdown();
        } catch (Throwable unused) {
        }
    }

    public static void a(final Bundle bundle) {
        if (c) {
            return;
        }
        a.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.b(bundle);
            }
        });
    }

    public static void a(AdConfig adConfig) {
        if (adConfig == null) {
            return;
        }
        d.put("appid", adConfig.getAppId());
        TTCustomController customController = adConfig.getCustomController();
        if (customController != null) {
            try {
                d.put("oaid", customController.getDevOaid());
                d.put("imei", customController.getDevImei());
            } catch (Exception unused) {
            }
        }
    }
}
