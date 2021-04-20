package com.bytedance.sdk.openadsdk.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.sapi2.SapiOptions;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d {
    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, Map<String, Object> map) {
        if (a(str, lVar)) {
            return;
        }
        Context a2 = context == null ? com.bytedance.sdk.openadsdk.core.p.a() : context;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("device", com.bytedance.sdk.openadsdk.utils.i.e(a2).toString());
            jSONObject2.put("is_cache", lVar.aw() ? 1 : 0);
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            al.a(jSONObject2);
            jSONObject.put("ad_extra_data", jSONObject2.toString());
            jSONObject.putOpt("log_extra", lVar.ap());
            float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - ak.g(lVar.ap())).floatValue();
            if (floatValue <= 0.0f) {
                floatValue = 0.0f;
            }
            jSONObject.putOpt("show_time", Float.valueOf(floatValue));
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.p.c().a(com.bytedance.sdk.openadsdk.c.a.a(a2, str, "show", lVar.am(), jSONObject));
        String a3 = com.bytedance.sdk.openadsdk.core.k.a(com.bytedance.sdk.openadsdk.core.p.a());
        if (!TextUtils.isEmpty(a3)) {
            com.bytedance.sdk.openadsdk.core.p.g().a(a3, lVar.ah(), true);
        }
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.k.a(context))) {
            return;
        }
        s.a().b("AdShow");
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
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
            } catch (Exception unused) {
            }
            e(context, lVar, str, str2, jSONObject);
            return;
        }
        c(context, lVar, str, str2);
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

    public static void g(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
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
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        jSONObject.put("ad_extra_data", jSONObject2.toString());
        e(context, lVar, str, str2, jSONObject);
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
        } catch (Exception unused) {
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
        } catch (Throwable unused) {
        }
        e(context, lVar, str, "click_open", jSONObject);
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
        } catch (Exception unused) {
        }
        e(context, lVar, str, str2, jSONObject);
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

    public static void e(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, JSONObject jSONObject) {
        if (lVar == null) {
            return;
        }
        if (jSONObject != null) {
            try {
                jSONObject.putOpt("log_extra", lVar.ap());
            } catch (JSONException unused) {
            }
        }
        com.bytedance.sdk.openadsdk.core.p.c().a(com.bytedance.sdk.openadsdk.c.a.a(context, str, str2, lVar.am(), jSONObject));
        if (u.c()) {
            u.c("AdEvent", "tag: " + str + "label: " + str2 + " " + lVar.am());
        }
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static void a(String str, JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.d.l lVar) {
            try {
                String a2 = ak.a(lVar);
                if (a2 == null) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ad_extra_data", jSONObject.toString());
                d.e(com.bytedance.sdk.openadsdk.core.p.a(), lVar, a2 + "_landingpage", str, jSONObject2);
            } catch (Throwable th) {
                Log.d("AdEvent", "Gecko.loadEvent error", th);
            }
        }

        public static void a(int i, int i2, com.bytedance.sdk.openadsdk.core.d.l lVar) {
            try {
                String a2 = ak.a(lVar);
                if (a2 == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("all_times", i2);
                jSONObject.put("hit_times", i);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ad_extra_data", jSONObject.toString());
                d.e(com.bytedance.sdk.openadsdk.core.p.a(), lVar, a2 + "_landingpage", "local_res_hit_rate", jSONObject2);
            } catch (Throwable th) {
                Log.d("AdEvent", "Gecko.localResHitRate error", th);
            }
        }
    }

    public static void c(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("log_extra", lVar.ap());
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.p.c().a(com.bytedance.sdk.openadsdk.c.a.a(context, str, str2, lVar.am(), jSONObject));
        if (u.c()) {
            u.c("AdEvent", "tag: " + str + "label: " + str2 + " " + lVar.am());
        }
    }

    public static void b(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2) {
        c(context, lVar, str, str2);
    }

    public static void b(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            } catch (Exception unused) {
            }
        }
        e(context, lVar, str, str2, jSONObject2);
    }

    public static void b(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("render_type", "h5");
            jSONObject2.putOpt("render_type_2", 0);
            jSONObject.putOpt("ad_extra_data", jSONObject2);
            jSONObject.put("duration", j);
        } catch (Exception unused) {
        }
        c(context, lVar, str, TrackLoadSettingsAtom.TYPE, jSONObject);
    }

    public static void c(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        e(context, lVar, str, str2, jSONObject);
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.l lVar, String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("device", com.bytedance.sdk.openadsdk.utils.i.e(com.bytedance.sdk.openadsdk.core.p.a()).toString());
            jSONObject2.put("download_creative_duration", j);
            jSONObject.put("ad_extra_data", jSONObject2.toString());
            jSONObject.putOpt("log_extra", lVar.ap());
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.p.c().a(com.bytedance.sdk.openadsdk.c.a.a(com.bytedance.sdk.openadsdk.core.p.a(), str, "download_creative_duration", lVar.am(), jSONObject));
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.l lVar, Activity activity) {
        if (lVar != null && activity != null) {
            try {
                String a2 = ak.a(lVar);
                if (a2 == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("page_name", activity.getClass().getName());
                al.a(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ad_extra_data", jSONObject);
                e(com.bytedance.sdk.openadsdk.core.p.a(), lVar, a2, "page_on_create", jSONObject2);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, String str, com.bytedance.sdk.openadsdk.core.d.l lVar, com.bytedance.sdk.openadsdk.core.d.f fVar, String str2, boolean z, Map<String, Object> map) {
        if (a(str2, lVar)) {
            return;
        }
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.p.a();
        }
        JSONObject jSONObject = new JSONObject();
        if (fVar != null) {
            try {
                JSONObject a2 = fVar.a();
                a2.put("device", com.bytedance.sdk.openadsdk.utils.i.e(context).toString());
                a2.put("is_valid", z);
                al.a(a2);
                if (map != null) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        a2.put(entry.getKey(), entry.getValue());
                    }
                }
                a(lVar, a2, str2);
                jSONObject.put("ad_extra_data", a2.toString());
            } catch (JSONException unused) {
            }
        }
        jSONObject.putOpt("log_extra", lVar.ap());
        float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - ak.g(lVar.ap())).floatValue();
        if (floatValue <= 0.0f) {
            floatValue = 0.0f;
        }
        jSONObject.putOpt("show_time", Float.valueOf(floatValue));
        com.bytedance.sdk.openadsdk.core.p.c().a(com.bytedance.sdk.openadsdk.c.a.a(context, str2, str, lVar.am(), jSONObject));
        String a3 = com.bytedance.sdk.openadsdk.core.k.a(com.bytedance.sdk.openadsdk.core.p.a());
        if (!TextUtils.isEmpty(a3) && PrefetchEvent.STATE_CLICK.equals(str)) {
            com.bytedance.sdk.openadsdk.core.p.g().a(a3, lVar.ai(), true);
        }
        if (u.c()) {
            u.c("AdEvent", str + " " + lVar.am());
        }
    }

    public static boolean a(String str, com.bytedance.sdk.openadsdk.core.d.l lVar) {
        return !TextUtils.isEmpty(str) && lVar != null && str.equals("feed_video_middle_page") && lVar.aG() == 1;
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.l lVar, JSONObject jSONObject, String str) {
        if (lVar == null || jSONObject == null || TextUtils.isEmpty(str) || !str.equals("embeded_ad")) {
            return;
        }
        int i = 1;
        try {
            jSONObject.put("video_middle_page", (lVar.aG() != 1 || lVar.T() == null) ? 0 : 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
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
            } catch (Exception unused) {
            }
            e(context, lVar, str, str2, jSONObject);
            return;
        }
        c(context, lVar, str, str2);
    }

    public static void a(@NonNull com.bytedance.sdk.openadsdk.core.d.l lVar, List<FilterWord> list) {
        com.bytedance.sdk.openadsdk.dislike.a.a().a(lVar, list);
        if (u.c()) {
            u.c("AdEvent", "tt_dislike_icon " + lVar.am());
        }
    }

    public static void a(Context context, long j, com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (context == null || lVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("skip_duration", j);
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        e(context, lVar, "splash_ad", FreeSpaceBox.TYPE, jSONObject);
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str) {
        c(context, lVar, str, "click_close");
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, long j, int i, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("duration", j);
            jSONObject.put(SapiOptions.s, i);
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        e(context, lVar, str, str2, jSONObject);
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, long j, JSONObject jSONObject) {
        if (context == null || lVar == null || jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("duration", j);
            jSONObject2.put("ad_extra_data", jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        e(context, lVar, str, str2, jSONObject2);
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2) {
        c(context, lVar, str, str2);
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, long j) {
        String str2;
        if (context != null && com.bytedance.sdk.openadsdk.core.p.h().v()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", System.currentTimeMillis() - j);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1695837674:
                    if (str.equals("banner_ad")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1364000502:
                    if (str.equals("rewarded_video")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -891990144:
                    if (str.equals("stream")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -764631662:
                    if (str.equals("fullscreen_interstitial_ad")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -712491894:
                    if (str.equals("embeded_ad")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1844104722:
                    if (str.equals("interaction")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1912999166:
                    if (str.equals("draw_ad")) {
                        c2 = 6;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    str2 = "banner_ad_loadtime";
                    break;
                case 1:
                    str2 = "interaction_loadtime";
                    break;
                case 2:
                    str2 = "embeded_ad_loadtime";
                    break;
                case 3:
                    str2 = "stream_loadtime";
                    break;
                case 4:
                    str2 = "rewarded_video_loadtime";
                    break;
                case 5:
                    str2 = "fullscreen_interstitial_ad_loadtime";
                    break;
                case 6:
                    str2 = "draw_ad_loadtime";
                    break;
                default:
                    str2 = "";
                    break;
            }
            e(context, lVar, str, str2, jSONObject);
        }
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, Long l) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("duration", l);
        } catch (Exception unused) {
        }
        e(context, lVar, str, str2, jSONObject);
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
                jSONObject2.put("device", com.bytedance.sdk.openadsdk.utils.i.e(com.bytedance.sdk.openadsdk.core.p.a()).toString());
                jSONObject.put("ad_extra_data", jSONObject2.toString());
                jSONObject.put("tag", str2);
                if (PrefetchEvent.STATE_CLICK.equals(str3)) {
                    float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - ak.g(jSONObject.optString("log_extra"))).floatValue();
                    if (floatValue <= 0.0f) {
                        floatValue = 0.0f;
                    }
                    jSONObject.putOpt("show_time", Float.valueOf(floatValue));
                }
            } catch (JSONException unused) {
            }
        }
        com.bytedance.sdk.openadsdk.core.p.c().a(com.bytedance.sdk.openadsdk.c.a.a(str, str2, str3, j, j2, jSONObject));
        if (u.c()) {
            u.c("AdEvent", "sendJsAdEvent");
        }
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, int i, int i2) {
        if (lVar == null || context == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("color_percent", Integer.valueOf(i));
        if (lVar.X() != null) {
            hashMap.put("playable_url", lVar.X().j());
        }
        hashMap.put("memory_total", Integer.valueOf(ak.j()));
        hashMap.put("memory_use", Integer.valueOf(ak.l() - ak.k()));
        hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, ak.h(lVar.ap()));
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("color_percent_type", Integer.valueOf(i2));
        k(context, lVar, str, str2, hashMap);
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || lVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("scheme", str3);
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        e(context, lVar, str, str2, jSONObject);
    }

    public static void a(long j, String str, String str2) {
        com.bytedance.sdk.openadsdk.core.d.l lVar;
        try {
            lVar = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(str2));
        } catch (Throwable unused) {
            lVar = null;
        }
        if (lVar == null) {
            return;
        }
        a(com.bytedance.sdk.openadsdk.core.p.a(), lVar, str, "open_appback", Long.valueOf(j));
        com.bytedance.sdk.openadsdk.utils.k.a(0L);
        com.bytedance.sdk.openadsdk.utils.k.c("");
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("render_type", "h5");
            jSONObject2.putOpt("render_type_2", 0);
            jSONObject.putOpt("ad_extra_data", jSONObject2);
        } catch (Exception unused) {
        }
        c(context, lVar, "landingpage", "open_url_h5", jSONObject);
    }
}
