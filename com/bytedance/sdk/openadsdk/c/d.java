package com.bytedance.sdk.openadsdk.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import com.coremedia.iso.boxes.FreeSpaceBox;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    public static void a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, Map<String, Object> map) {
        Context a2 = context == null ? com.bytedance.sdk.openadsdk.core.p.a() : context;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(Config.DEVICE_PART, com.bytedance.sdk.openadsdk.utils.i.d(a2).toString());
            jSONObject2.put("is_cache", lVar.ac() ? 1 : 0);
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            ak.a(jSONObject2);
            jSONObject.put("ad_extra_data", jSONObject2.toString());
            jSONObject.putOpt("log_extra", lVar.W());
            float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - aj.g(lVar.W())).floatValue();
            if (floatValue <= 0.0f) {
                floatValue = 0.0f;
            }
            jSONObject.putOpt("show_time", Float.valueOf(floatValue));
        } catch (JSONException e) {
        }
        com.bytedance.sdk.openadsdk.core.p.c().a(com.bytedance.sdk.openadsdk.c.a.a(a2, str, "show", lVar.T(), jSONObject));
        String a3 = com.bytedance.sdk.openadsdk.core.k.a(com.bytedance.sdk.openadsdk.core.p.a());
        if (!TextUtils.isEmpty(a3)) {
            com.bytedance.sdk.openadsdk.core.p.g().a(a3, lVar.O(), true);
        }
        u.e("AdEvent", "pangolin ad show " + lVar.T());
        if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.k.a(context))) {
            s.b(com.bytedance.sdk.openadsdk.core.k.a(context)).c("AdShow");
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(Config.DEVICE_PART, com.bytedance.sdk.openadsdk.utils.i.d(com.bytedance.sdk.openadsdk.core.p.a()).toString());
            if (str2.equals("download_creative_duration")) {
                jSONObject2.put("download_creative_duration", j);
            } else if (str2.equals("load_ad_duration")) {
                jSONObject2.put("load_ad_duration", j);
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
            jSONObject.putOpt("log_extra", lVar.W());
        } catch (JSONException e) {
        }
        com.bytedance.sdk.openadsdk.core.p.c().a(com.bytedance.sdk.openadsdk.c.a.a(com.bytedance.sdk.openadsdk.core.p.a(), str, str2, lVar.T(), jSONObject));
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.l lVar, String str, Map<String, Object> map) {
        Context a2 = com.bytedance.sdk.openadsdk.core.p.a();
        JSONObject jSONObject = new JSONObject();
        if (map != null && map.size() > 0) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(Config.DEVICE_PART, com.bytedance.sdk.openadsdk.utils.i.d(a2).toString());
                Object remove = map.remove("total_time");
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                if (remove instanceof Long) {
                    jSONObject.put("duration", remove);
                } else {
                    jSONObject.put("duration", 0);
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception e) {
            }
            e(a2, lVar, str, "load_ad_duration", jSONObject);
            return;
        }
        c(a2, lVar, str, "load_ad_duration");
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.l lVar, Activity activity) {
        if (lVar != null && activity != null) {
            try {
                String a2 = aj.a(lVar);
                if (a2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("page_name", activity.getClass().getName());
                    ak.a(jSONObject);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("ad_extra_data", jSONObject);
                    e(com.bytedance.sdk.openadsdk.core.p.a(), lVar, a2, "page_on_create", jSONObject2);
                }
            } catch (Throwable th) {
            }
        }
    }

    public static void a(Context context, String str, com.bytedance.sdk.openadsdk.core.d.l lVar, com.bytedance.sdk.openadsdk.core.d.f fVar, String str2, boolean z, Map<String, Object> map) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.p.a();
        }
        JSONObject jSONObject = new JSONObject();
        if (fVar != null) {
            try {
                JSONObject a2 = fVar.a();
                a2.put(Config.DEVICE_PART, com.bytedance.sdk.openadsdk.utils.i.d(context).toString());
                a2.put("is_valid", z);
                ak.a(a2);
                if (map != null) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        a2.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("ad_extra_data", a2.toString());
            } catch (JSONException e) {
            }
        }
        jSONObject.putOpt("log_extra", lVar.W());
        float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - aj.g(lVar.W())).floatValue();
        if (floatValue <= 0.0f) {
            floatValue = 0.0f;
        }
        jSONObject.putOpt("show_time", Float.valueOf(floatValue));
        com.bytedance.sdk.openadsdk.core.p.c().a(com.bytedance.sdk.openadsdk.c.a.a(context, str2, str, lVar.T(), jSONObject));
        String a3 = com.bytedance.sdk.openadsdk.core.k.a(com.bytedance.sdk.openadsdk.core.p.a());
        if (!TextUtils.isEmpty(a3) && "click".equals(str)) {
            com.bytedance.sdk.openadsdk.core.p.g().a(a3, lVar.P(), true);
        }
        if (u.c()) {
            u.c("AdEvent", str + " " + lVar.T());
        }
    }

    public static void b(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, Map<String, Object> map) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.p.a();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("log_extra", lVar.W());
        } catch (Exception e) {
        }
        com.bytedance.sdk.openadsdk.core.p.c().a(com.bytedance.sdk.openadsdk.c.a.a(context, str, "render_h5_detect", lVar.T(), jSONObject));
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            e(context, lVar, str, str2, jSONObject2);
            return;
        }
        c(context, lVar, str, str2);
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null && map.size() > 0) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception e) {
            }
            e(context, lVar, str, str2, jSONObject);
            return;
        }
        c(context, lVar, str, str2);
    }

    public static void b(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, Map<String, Object> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception e) {
            }
            e(context, lVar, str, str2, jSONObject);
            return;
        }
        c(context, lVar, str, str2);
    }

    public static void a(@NonNull com.bytedance.sdk.openadsdk.core.d.l lVar, List<FilterWord> list) {
        com.bytedance.sdk.openadsdk.dislike.a.a().a(lVar, list);
        if (u.c()) {
            u.c("AdEvent", "tt_dislike_icon " + lVar.T());
        }
    }

    public static void a(Context context, long j, com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (context != null && lVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("skip_duration", j);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            e(context, lVar, "splash_ad", FreeSpaceBox.TYPE, jSONObject);
        }
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str) {
        c(context, lVar, str, "click_close");
    }

    public static void c(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                u.b(th.toString());
            }
        }
        jSONObject2.put("ad_extra_data", jSONObject.toString());
        e(context, lVar, str, str2, jSONObject2);
    }

    public static void d(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                u.b(th.toString());
            }
        }
        jSONObject2.put("ad_extra_data", jSONObject.toString());
        e(context, lVar, str, str2, jSONObject2);
    }

    public static void e(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, Map<String, Object> map) {
        f(context, lVar, str, str2, map);
    }

    public static void f(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                u.b(th.toString());
            }
        }
        jSONObject2.put("ad_extra_data", jSONObject.toString());
        e(context, lVar, str, str2, jSONObject2);
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, long j, int i, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("duration", j);
            jSONObject.put("percent", i);
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        e(context, lVar, str, str2, jSONObject);
    }

    public static void g(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jSONObject.put("ad_extra_data", jSONObject2.toString());
        e(context, lVar, str, str2, jSONObject);
    }

    public static void h(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jSONObject.put("ad_extra_data", jSONObject2.toString());
        e(context, lVar, str, str2, jSONObject);
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2) {
        c(context, lVar, str, str2);
    }

    public static void b(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2) {
        c(context, lVar, str, str2);
    }

    public static void b(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            } catch (Exception e) {
            }
        }
        e(context, lVar, str, str2, jSONObject2);
    }

    public static void i(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception e) {
        }
        e(context, lVar, str, str2, jSONObject);
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, Long l) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("duration", l);
        } catch (Exception e) {
        }
        e(context, lVar, str, str2, jSONObject);
    }

    public static void j(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("refer", str2);
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Throwable th) {
        }
        e(context, lVar, str, "click_open", jSONObject);
    }

    private static void c(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("log_extra", lVar.W());
        } catch (JSONException e) {
        }
        com.bytedance.sdk.openadsdk.core.p.c().a(com.bytedance.sdk.openadsdk.c.a.a(context, str, str2, lVar.T(), jSONObject));
        if (u.c()) {
            u.c("AdEvent", "tag: " + str + "label: " + str2 + " " + lVar.T());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, JSONObject jSONObject) {
        if (lVar != null) {
            if (jSONObject != null) {
                try {
                    jSONObject.putOpt("log_extra", lVar.W());
                } catch (JSONException e) {
                }
            }
            com.bytedance.sdk.openadsdk.core.p.c().a(com.bytedance.sdk.openadsdk.c.a.a(context, str, str2, lVar.T(), jSONObject));
            if (u.c()) {
                u.c("AdEvent", "tag: " + str + "label: " + str2 + " " + lVar.T());
            }
        }
    }

    public static void a(Context context, String str, long j) {
        com.bytedance.sdk.openadsdk.core.b.c.a(context, str, j);
    }

    public static void a(String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                String optString = jSONObject.optString("ad_extra_data", null);
                if (optString != null) {
                    jSONObject2 = new JSONObject(optString);
                }
                jSONObject2.put(Config.DEVICE_PART, com.bytedance.sdk.openadsdk.utils.i.d(com.bytedance.sdk.openadsdk.core.p.a()).toString());
                jSONObject.put("ad_extra_data", jSONObject2.toString());
                jSONObject.put("tag", str2);
                if ("click".equals(str3)) {
                    float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - aj.g(jSONObject.optString("log_extra"))).floatValue();
                    if (floatValue <= 0.0f) {
                        floatValue = 0.0f;
                    }
                    jSONObject.putOpt("show_time", Float.valueOf(floatValue));
                }
            } catch (JSONException e) {
            }
        }
        com.bytedance.sdk.openadsdk.core.p.c().a(com.bytedance.sdk.openadsdk.c.a.a(str, str2, str3, j, j2, jSONObject));
        if (u.c()) {
            u.c("AdEvent", "sendJsAdEvent");
        }
    }

    public static void c(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        e(context, lVar, str, str2, jSONObject);
    }

    public static void k(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception e) {
        }
        e(context, lVar, str, str2, jSONObject);
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, int i, int i2) {
        if (lVar != null && context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("color_percent", Integer.valueOf(i));
            if (lVar.F() != null) {
                hashMap.put("playable_url", lVar.F().i());
            }
            hashMap.put("memory_total", Integer.valueOf(aj.i()));
            hashMap.put("memory_use", Integer.valueOf(aj.k() - aj.j()));
            hashMap.put("request_id", aj.h(lVar.W()));
            hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("color_percent_type", Integer.valueOf(i2));
            k(context, lVar, str, str2, hashMap);
        }
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && lVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scheme", str3);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception e) {
            }
            e(context, lVar, str, str2, jSONObject);
        }
    }

    public static void a(long j, String str, String str2) {
        com.bytedance.sdk.openadsdk.core.d.l lVar = null;
        try {
            lVar = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(str2));
        } catch (Throwable th) {
        }
        if (lVar != null) {
            a(com.bytedance.sdk.openadsdk.core.p.a(), lVar, str, "open_appback", Long.valueOf(j));
            com.bytedance.sdk.openadsdk.utils.k.a(0L);
            com.bytedance.sdk.openadsdk.utils.k.b("");
        }
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static void a(String str, JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.d.l lVar) {
            try {
                String a2 = aj.a(lVar);
                if (a2 != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    d.e(com.bytedance.sdk.openadsdk.core.p.a(), lVar, a2 + "_landingpage", str, jSONObject2);
                }
            } catch (Throwable th) {
                Log.d("AdEvent", "Gecko.loadEvent error", th);
            }
        }

        public static void a(int i, int i2, com.bytedance.sdk.openadsdk.core.d.l lVar) {
            try {
                String a2 = aj.a(lVar);
                if (a2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("all_times", i2);
                    jSONObject.put("hit_times", i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    d.e(com.bytedance.sdk.openadsdk.core.p.a(), lVar, a2 + "_landingpage", "local_res_hit_rate", jSONObject2);
                }
            } catch (Throwable th) {
                Log.d("AdEvent", "Gecko.localResHitRate error", th);
            }
        }
    }
}
