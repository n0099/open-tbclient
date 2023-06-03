package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.searchbox.common.security.DeviceInfoIPCServiceManager;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.api.plugin.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class d {
    public static SharedPreferences c;
    public static ScheduledExecutorService b = Executors.newSingleThreadScheduledExecutor(new f.a("tt_pangle_thread_pl_report"));
    public static final List<Pair<String, JSONObject>> d = new ArrayList();
    public static final Map<String, String> a = new HashMap();
    public static volatile boolean e = false;

    public static void a() {
        if (!e) {
            try {
                e = true;
                b.shutdown();
            } catch (Throwable unused) {
            }
        }
    }

    public static final void a(int i, String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("duration", Long.valueOf(j));
            jSONObject.putOpt("code", Integer.valueOf(i));
            jSONObject.putOpt("message", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        e("plugin_load_failed", jSONObject);
    }

    public static void a(Context context) {
        c = context.getSharedPreferences("tt_sdk_settings_other", 0);
    }

    public static void a(final Bundle bundle) {
        if (!e) {
            b.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.d.3
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject;
                    Bundle bundle2 = bundle;
                    if (bundle2 == null) {
                        return;
                    }
                    try {
                        String string = bundle2.getString("event_name");
                        String string2 = bundle.getString("event_extra");
                        if (TextUtils.isEmpty(string2)) {
                            jSONObject = new JSONObject();
                        } else {
                            jSONObject = new JSONObject(string2);
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(d.f(string, jSONObject));
                        d.c(arrayList);
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public static void a(AdConfig adConfig) {
        if (adConfig == null) {
            return;
        }
        a.put("appid", adConfig.getAppId());
        Object extra = adConfig.getExtra("plugin_update_conf");
        if (extra instanceof Integer) {
            String num = ((Integer) extra).toString();
            Map<String, String> map = a;
            if (num == null) {
                num = "2";
            }
            map.put("plugin_update_conf", num);
        }
        TTCustomController customController = adConfig.getCustomController();
        if (customController != null) {
            try {
                a.put("oaid", customController.getDevOaid());
                a.put("imei", customController.getDevImei());
            } catch (Exception unused) {
            }
        }
    }

    public static void a(String str, JSONObject jSONObject) {
        e("zeus_" + str, jSONObject);
    }

    public static void b(final String str, final JSONObject jSONObject) {
        if (!e) {
            b.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.d.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(d.f(str, jSONObject));
                    d.c(arrayList);
                }
            });
        }
    }

    public static void c(String str, JSONObject jSONObject) {
        d.add(new Pair<>(str, jSONObject));
    }

    public static void e(String str, JSONObject jSONObject) {
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
            return;
        }
        b(str, jSONObject);
    }

    public static void a(final List<JSONObject> list) {
        if (!e) {
            if (list != null && list.isEmpty() && d.isEmpty()) {
                return;
            }
            b.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.c(list);
                }
            });
        }
    }

    public static void c(List<JSONObject> list) {
        if (list == null) {
            return;
        }
        String str = "pangolin.snssdk.com";
        SharedPreferences sharedPreferences = c;
        if (sharedPreferences != null) {
            str = sharedPreferences.getString("url_alog", "pangolin.snssdk.com");
        }
        String format = String.format("https://%s%s", str, "/api/ad/union/sdk/stats/batch/");
        JSONObject jSONObject = new JSONObject();
        try {
            if (d.size() > 0) {
                Iterator<Pair<String, JSONObject>> it = d.iterator();
                while (it.hasNext()) {
                    Pair<String, JSONObject> next = it.next();
                    list.add(f((String) next.first, (JSONObject) next.second));
                    it.remove();
                }
            }
            jSONObject.put("stats_list", new JSONArray((Collection) list));
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.api.plugin.a.c.a().a(true, format, com.bytedance.sdk.openadsdk.api.plugin.b.b.a(jSONObject).toString().getBytes());
    }

    public static JSONObject f(String str, JSONObject jSONObject) {
        String str2;
        String str3 = "4.5.2.6";
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("support_abi", Arrays.toString(Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2}));
            jSONObject2.put("ad_sdk_version", "4.5.2.6");
            String a2 = e.a("com.byted.pangle");
            if (!TextUtils.isEmpty(a2)) {
                str3 = a2;
            }
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, str3);
            jSONObject2.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject2.put("is_plugin", true);
            if (jSONObject != null) {
                str2 = jSONObject.toString();
            } else {
                str2 = "";
            }
            jSONObject2.put("event_extra", str2);
            jSONObject2.put("type", str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("model", Build.MODEL);
            jSONObject3.put("vendor", Build.MANUFACTURER);
            jSONObject3.put("imei", a.get("imei"));
            jSONObject3.put("oaid", a.get("oaid"));
            jSONObject2.put(DeviceInfoIPCServiceManager.IPC_SERVICE_NAME, jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }
}
