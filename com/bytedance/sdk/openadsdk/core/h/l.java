package com.bytedance.sdk.openadsdk.core.h;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.q;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ae;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l implements e {
    private String e;
    private String g;
    private String j;
    private String q;
    private String r;
    private String u;
    private String v;
    private int w;
    private int x;

    /* renamed from: a  reason: collision with root package name */
    private int f6896a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f6897b = -1;
    private Map<String, a> c = new HashMap();
    private Map<String, m> d = new HashMap();
    private Set<String> f = new HashSet();
    private Set<String> h = Collections.synchronizedSet(new HashSet());
    private List<g> i = new CopyOnWriteArrayList();
    private int k = 1;
    private int l = 30;
    private int m = 1;
    private int n = 0;
    private JSONObject o = null;
    private String p = "";
    private int s = 1;
    private int t = 5;
    private int y = 0;
    private long z = 0;
    private Set<String> A = Collections.synchronizedSet(new HashSet());
    private Set<String> B = Collections.synchronizedSet(new HashSet());
    private int C = 0;
    private int D = 1;
    private long E = 10000;
    private int F = 50;
    private int G = 30;
    private int H = 5;
    private int I = SdkConfigData.DEFAULT_REQUEST_INTERVAL;
    private String J = "pangolin.snssdk.com";
    private String K = "extlog.snssdk.com/service/2/app_log/";
    private int L = 100;
    private int M = 3000;
    private Set<String> N = Collections.synchronizedSet(new HashSet());
    private String O = "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json";
    private int P = 0;

    @Override // com.bytedance.sdk.openadsdk.core.h.e
    public void a() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            this.J = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "url_ads", "pangolin.snssdk.com");
            this.K = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "url_alog", "extlog.snssdk.com/service/2/app_log/");
            this.j = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "xpath", "");
            this.E = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "duration", 10000L);
            this.F = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max", 50);
            this.k = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_network", 1);
            this.l = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_size", 30);
            this.m = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_storage_internal", 1);
            this.G = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "pos_cache_time", 30);
            this.H = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "vbtt", 5);
            this.I = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_template", (int) SdkConfigData.DEFAULT_REQUEST_INTERVAL);
            this.g = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "template_ids", (String) null);
            this.q = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ab_test_version", (String) null);
            this.r = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ab_test_param", (String) null);
            this.s = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "web_info_wifi_enable", 1);
            this.t = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "web_info_page_count", 5);
            this.u = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "pyload_h5", (String) null);
            this.v = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "playableLoadH5Url", (String) null);
            this.w = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_load_type", 1);
            this.x = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_check_type", 1);
            this.C = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "if_both_open", 0);
            this.D = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "support_tnc", 1);
            this.e = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "tpl_infos", (String) null);
            this.y = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "app_list_control", 0);
            this.L = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max_tpl_cnts", 100);
            this.M = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_tpl_timeout_ctrl", 3000);
            this.N.clear();
            this.N = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "gecko_hosts", (Set<String>) null);
            this.N = a(this.N);
            this.z = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "hit_app_list_time", 0L);
            this.A.clear();
            this.f6896a = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "circle_splash_switch", 0);
            this.f6897b = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "circle_load_splash_time", -1);
            this.P = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "sp_key_if_sp_cache", 0);
            this.O = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "dyn_draw_engine_url", "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json");
            Set<String> b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "hit_app_list_data", (Set<String>) null);
            if (b2 != null && !b2.isEmpty()) {
                for (String str : b2) {
                    this.A.add(str);
                }
            }
            this.B.clear();
            Set<String> b3 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "scheme_list_data", (Set<String>) null);
            if (b3 != null && !b3.isEmpty()) {
                for (String str2 : b3) {
                    this.B.add(str2);
                }
            }
            t(com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "push_config", (String) null));
            String b4 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ad_slot_conf", (String) null);
            if (!TextUtils.isEmpty(b4)) {
                try {
                    JSONArray jSONArray = new JSONArray(b4);
                    int length = jSONArray.length();
                    if (length > 0) {
                        this.c.clear();
                        for (int i = 0; i < length; i++) {
                            a b5 = b(jSONArray.optJSONObject(i));
                            if (b5 != null) {
                                this.c.put(b5.f6868a, b5);
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
            this.p = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "download_sdk_config", "");
            if (!TextUtils.isEmpty(this.p)) {
                try {
                    this.o = new JSONObject(this.p);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            this.n = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "enable_download_opt", 0);
            com.bytedance.sdk.openadsdk.downloadnew.a.e.c();
            return;
        }
        ae K = K();
        this.J = K.b("url_ads", "pangolin.snssdk.com");
        this.K = K.b("url_alog", "extlog.snssdk.com/service/2/app_log/");
        this.j = K.b("xpath", "");
        this.E = K.b("duration", 10000L);
        this.F = K.b("max", 50);
        this.k = K.b("download_config_dl_network", 1);
        this.l = K.b("download_config_dl_size", 30);
        this.m = K.b("download_config_storage_internal", 1);
        this.G = K.b("pos_cache_time", 30);
        this.I = K.b("fetch_template", SdkConfigData.DEFAULT_REQUEST_INTERVAL);
        this.q = K.a("ab_test_version");
        this.r = K.a("ab_test_param");
        this.H = K.b("vbtt", 5);
        this.g = K.b("template_ids", (String) null);
        this.s = K.b("web_info_wifi_enable", 1);
        this.t = K.b("web_info_page_count", 5);
        this.u = K.b("pyload_h5", (String) null);
        this.v = K.b("playableLoadH5Url", (String) null);
        this.w = K.b("splash_load_type", 1);
        this.x = K.b("splash_check_type", 1);
        this.C = K.b("if_both_open", 0);
        this.D = K.b("support_tnc", 1);
        this.e = K.b("tpl_infos", (String) null);
        this.y = K.b("app_list_control", 0);
        this.L = K.b("max_tpl_cnts", 100);
        this.M = K.b("fetch_tpl_timeout_ctrl", 3000);
        this.N.clear();
        this.N = K.b("gecko_hosts", (Set<String>) null);
        this.N = a(this.N);
        this.z = K.b("hit_app_list_time", 0L);
        this.A.clear();
        this.f6896a = K.b("circle_splash_switch", 0);
        this.f6897b = K.b("circle_load_splash_time", -1);
        this.O = K.b("dyn_draw_engine_url", "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json");
        this.P = K.b("sp_key_if_sp_cache", 0);
        Set<String> b6 = K.b("hit_app_list_data", (Set<String>) null);
        if (b6 != null && !b6.isEmpty()) {
            for (String str3 : b6) {
                this.A.add(str3);
            }
        }
        this.B.clear();
        Set<String> b7 = K.b("scheme_list_data", (Set<String>) null);
        if (b7 != null && !b7.isEmpty()) {
            for (String str4 : b7) {
                this.B.add(str4);
            }
        }
        t(K.b("push_config", (String) null));
        String b8 = K.b("ad_slot_conf", (String) null);
        if (!TextUtils.isEmpty(b8)) {
            try {
                JSONArray jSONArray2 = new JSONArray(b8);
                int length2 = jSONArray2.length();
                if (length2 > 0) {
                    this.c.clear();
                    for (int i2 = 0; i2 < length2; i2++) {
                        a b9 = b(jSONArray2.optJSONObject(i2));
                        if (b9 != null) {
                            this.c.put(b9.f6868a, b9);
                        }
                    }
                }
            } catch (Exception e3) {
            }
        }
        this.p = K.b("download_sdk_config", "");
        if (!TextUtils.isEmpty(this.p)) {
            try {
                this.o = new JSONObject(this.p);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        this.n = K.b("enable_download_opt", 0);
        com.bytedance.sdk.openadsdk.downloadnew.a.e.c();
    }

    private void t(String str) {
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    g gVar = new g();
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    gVar.f6882a = optJSONObject.optString("action");
                    gVar.f6883b = optJSONObject.optString("service");
                    gVar.c = optJSONObject.optString("package");
                    gVar.d = optJSONObject.optInt("wakeup_interval");
                    this.i.add(gVar);
                }
                f.a().b();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static a b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("code_id");
        int optInt = jSONObject.optInt("auto_play", 1);
        int optInt2 = jSONObject.optInt("voice_control", 1);
        int optInt3 = jSONObject.optInt("rv_preload", 2);
        int optInt4 = jSONObject.optInt("nv_preload", 1);
        int optInt5 = jSONObject.optInt("read_video_from_cache", 1);
        int optInt6 = jSONObject.optInt("proportion_watching", 100);
        int optInt7 = jSONObject.optInt("skip_time_displayed", 0);
        int optInt8 = jSONObject.optInt("video_skip_result", 2);
        int optInt9 = jSONObject.optInt("reg_creative_control", 1);
        int optInt10 = jSONObject.optInt("play_bar_show_time", 3);
        int optInt11 = jSONObject.optInt("rv_skip_time", -1);
        int optInt12 = jSONObject.optInt("endcard_close_time", -1);
        int optInt13 = jSONObject.optInt("playable_endcard_close_time", -1);
        int optInt14 = jSONObject.optInt("voice_control", 2);
        int optInt15 = jSONObject.optInt("if_show_win", 1);
        int optInt16 = jSONObject.optInt("sp_preload", 0);
        int optInt17 = jSONObject.optInt("stop_time", 1500);
        int optInt18 = jSONObject.optInt("native_playable_delay", 2);
        int optInt19 = jSONObject.optInt("time_out_control", -1);
        int optInt20 = jSONObject.optInt("playable_duration_time", 20);
        int optInt21 = jSONObject.optInt("playable_close_time", -1);
        int optInt22 = jSONObject.optInt("playable_reward_type", 0);
        int optInt23 = jSONObject.optInt("reward_is_callback", 0);
        int optInt24 = jSONObject.optInt("iv_skip_time", 5);
        return a.a().a(optString).n(optInt).o(optInt2).p(optInt3).q(optInt4).r(optInt5).s(optInt6).t(optInt7).u(optInt8).v(optInt9).m(optInt10).l(optInt11).j(optInt12).i(optInt14).k(optInt13).w(optInt15).f(optInt16).g(optInt17).h(optInt18).e(optInt19).a(optInt21).d(optInt20).b(optInt22).c(optInt23).x(optInt24).a(jSONObject.optJSONArray("parent_tpl_ids"));
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x02c5  */
    @Override // com.bytedance.sdk.openadsdk.core.h.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@NonNull JSONObject jSONObject) {
        String str;
        JSONArray optJSONArray;
        String str2 = null;
        JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject != null) {
            this.f6896a = optJSONObject.optInt("circle_splash", 0);
            this.f6897b = optJSONObject.optInt("circle_time", -1);
            this.P = optJSONObject.optInt("if_sp_cache", 0);
        }
        this.O = jSONObject.optString("dyn_draw_engine_url", "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json");
        this.J = jSONObject.optString("ads_url", "pangolin.snssdk.com");
        this.K = jSONObject.optString("app_log_url", "extlog.snssdk.com/service/2/app_log/");
        this.j = jSONObject.optString("xpath");
        this.G = jSONObject.optInt("pos_cache_time", 30);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("feq_policy");
        if (optJSONObject2 != null) {
            this.E = optJSONObject2.optLong("duration") * 1000;
            this.F = optJSONObject2.optInt("max");
        }
        this.H = jSONObject.optInt("vbtt", 5);
        this.I = jSONObject.optInt("fetch_tpl_interval", SdkConfigData.DEFAULT_REQUEST_INTERVAL);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("abtest");
        if (optJSONObject3 != null) {
            this.q = optJSONObject3.optString("version");
            this.r = optJSONObject3.optString("param");
        } else if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_sdk_settings", "ab_test_version");
            com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_sdk_settings", "ab_test_param");
        } else {
            ae K = K();
            K.b("ab_test_version");
            K.b("ab_test_param");
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("web_info");
        if (optJSONObject4 != null) {
            this.s = optJSONObject4.optInt("web_info_wifi_enable", 1);
            this.t = optJSONObject4.optInt("web_info_page_count", 5);
        }
        this.u = jSONObject.optString("pyload_h5");
        this.v = jSONObject.optString("pure_pyload_h5");
        this.w = c(jSONObject);
        u.f("splashLoad", "setting-》mSplashLoadType=" + this.w);
        this.x = d(jSONObject);
        u.f("splashLoad", "setting-》mSplashCheckType=" + this.x);
        this.C = jSONObject.optInt("if_both_open", 0);
        this.D = jSONObject.optInt("support_tnc", 1);
        this.y = jSONObject.optInt("al", 0);
        this.L = jSONObject.optInt("max_tpl_cnts", 100);
        JSONObject optJSONObject5 = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject5 != null) {
            this.M = optJSONObject5.optInt("fetch_tpl_timeout_ctrl", 3000);
            try {
                this.N.clear();
                JSONArray optJSONArray2 = optJSONObject5.optJSONArray("gecko_hosts");
                if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        this.N.add(optJSONArray2.getString(i));
                    }
                }
                this.N = a(this.N);
            } catch (Throwable th) {
                u.b("GeckoLog: settings json error " + th);
            }
        }
        this.z = System.currentTimeMillis();
        this.A.clear();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("spam_app_list");
        if (optJSONArray3 != null) {
            int length = optJSONArray3.length();
            for (int i2 = 0; i2 < length; i2++) {
                String optString = optJSONArray3.optString(i2);
                if (!TextUtils.isEmpty(optString)) {
                    this.A.add(optString);
                }
            }
        }
        this.B.clear();
        JSONArray optJSONArray4 = jSONObject.optJSONArray("scheme_check_list");
        if (optJSONArray4 != null) {
            int length2 = optJSONArray4.length();
            for (int i3 = 0; i3 < length2; i3++) {
                String optString2 = optJSONArray4.optString(i3);
                if (!TextUtils.isEmpty(optString2)) {
                    this.B.add(optString2);
                }
            }
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("download_config");
        if (optJSONObject6 != null) {
            this.k = optJSONObject6.optInt("dl_network", 1);
            this.l = optJSONObject6.optInt("dl_size", 30);
            this.m = optJSONObject6.optInt("if_storage_internal", 1);
            this.n = optJSONObject6.optInt("enable_download_opt", 0);
        }
        this.o = jSONObject.optJSONObject("download_sdk_config");
        if (this.o != null) {
            this.p = this.o.toString();
        } else {
            this.p = "";
        }
        try {
            JSONArray optJSONArray5 = jSONObject.optJSONArray("push_config");
            if (optJSONArray5 != null) {
                str = optJSONArray5.toString();
                try {
                    int length3 = optJSONArray5.length();
                    for (int i4 = 0; i4 < length3; i4++) {
                        g gVar = new g();
                        JSONObject optJSONObject7 = optJSONArray5.optJSONObject(i4);
                        if (optJSONObject7 != null) {
                            gVar.f6882a = optJSONObject7.optString("action");
                            gVar.f6883b = optJSONObject7.optString("service");
                            gVar.c = optJSONObject7.optString("package");
                            gVar.d = optJSONObject7.optInt("wakeup_interval");
                            this.i.add(gVar);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                    optJSONArray = jSONObject.optJSONArray("ad_slot_conf_list");
                    if (optJSONArray != null) {
                    }
                    com.bytedance.sdk.openadsdk.downloadnew.a.e.c();
                    a(str2, str);
                }
            } else {
                str = null;
            }
            f.a().b();
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
        optJSONArray = jSONObject.optJSONArray("ad_slot_conf_list");
        if (optJSONArray != null) {
            str2 = optJSONArray.toString();
            int length4 = optJSONArray.length();
            if (length4 > 0) {
                this.c.clear();
                for (int i5 = 0; i5 < length4; i5++) {
                    a b2 = b(optJSONArray.optJSONObject(i5));
                    if (b2 != null) {
                        this.c.put(b2.f6868a, b2);
                    }
                }
            }
        }
        com.bytedance.sdk.openadsdk.downloadnew.a.e.c();
        a(str2, str);
    }

    private int c(JSONObject jSONObject) {
        this.w = jSONObject.optInt("splash_load_type", 1);
        switch (this.w) {
            case 0:
            case 1:
            case 2:
            case 3:
                return this.w;
            default:
                return 1;
        }
    }

    private int d(JSONObject jSONObject) {
        this.x = jSONObject.optInt("splash_check_type", 1);
        switch (this.x) {
            case 0:
            case 1:
                return this.x;
            default:
                return 1;
        }
    }

    private void a(String str, String str2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "url_ads", this.J);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "url_alog", this.K);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "xpath", this.j);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "duration", Long.valueOf(this.E));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max", Integer.valueOf(this.F));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_network", Integer.valueOf(this.k));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_size", Integer.valueOf(this.l));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_storage_internal", Integer.valueOf(this.m));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "pos_cache_time", Integer.valueOf(this.G));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "vbtt", Integer.valueOf(this.H));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_template", Integer.valueOf(this.I));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "web_info_wifi_enable", Integer.valueOf(this.s));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "web_info_page_count", Integer.valueOf(this.t));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_load_type", Integer.valueOf(this.w));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_check_type", Integer.valueOf(this.x));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "if_both_open", Integer.valueOf(this.C));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "support_tnc", Integer.valueOf(this.D));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "pyload_h5", this.u);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "playableLoadH5Url", this.v);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "app_list_control", Integer.valueOf(this.y));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max_tpl_cnts", Integer.valueOf(this.L));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_tpl_timeout_ctrl", Integer.valueOf(this.M));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "gecko_hosts", this.N);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "hit_app_list_time", Long.valueOf(this.z));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "hit_app_list_data", this.A);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "scheme_list_data", this.B);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "circle_splash_switch", Integer.valueOf(this.f6896a));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "circle_load_splash_time", Integer.valueOf(this.f6897b));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "sp_key_if_sp_cache", Integer.valueOf(this.P));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "dyn_draw_engine_url", this.O);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_sdk_config", this.p);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "enable_download_opt", Integer.valueOf(this.n));
            if (!TextUtils.isEmpty(this.q)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "ab_test_version", this.q);
            }
            if (!TextUtils.isEmpty(this.r)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "ab_test_param", this.r);
            }
            if (!TextUtils.isEmpty(str2)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "push_config", str2);
            }
            if (!TextUtils.isEmpty(str)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "ad_slot_conf", str);
            }
            if (!TextUtils.isEmpty(this.g)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "template_ids", this.g);
            }
            if (!TextUtils.isEmpty(this.e)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "tpl_infos", this.e);
                return;
            }
            return;
        }
        ae K = K();
        K.a("url_ads", this.J);
        K.a("url_alog", this.K);
        K.a("xpath", this.j);
        K.a("duration", this.E);
        K.a("max", this.F);
        K.a("download_config_dl_network", this.k);
        K.a("download_config_dl_size", this.l);
        K.a("download_config_storage_internal", this.m);
        K.a("pos_cache_time", this.G);
        K.a("fetch_template", this.I);
        K.a("web_info_wifi_enable", this.s);
        K.a("web_info_page_count", this.t);
        K.a("pyload_h5", this.u);
        K.a("playableLoadH5Url", this.v);
        K.a("splash_load_type", this.w);
        K.a("splash_check_type", this.x);
        K.a("if_both_open", this.C);
        K.a("support_tnc", this.D);
        K.a("app_list_control", this.y);
        K.a("max_tpl_cnts", this.L);
        K.a("fetch_tpl_timeout_ctrl", this.M);
        K.a("gecko_hosts", this.N);
        K.a("hit_app_list_time", this.z);
        K.a("hit_app_list_data", this.A);
        K.a("scheme_list_data", this.B);
        K.a("circle_splash_switch", this.f6896a);
        K.a("circle_load_splash_time", this.f6897b);
        K.a("dyn_draw_engine_url", this.O);
        K.a("sp_key_if_sp_cache", this.P);
        K.a("download_sdk_config", this.p);
        K.a("enable_download_opt", this.n);
        if (!TextUtils.isEmpty(this.q)) {
            K.a("ab_test_version", this.q);
        }
        if (!TextUtils.isEmpty(this.r)) {
            K.a("ab_test_param", this.r);
        }
        K.a("vbtt", this.H);
        if (!TextUtils.isEmpty(str2)) {
            K.a("push_config", str2);
        }
        if (!TextUtils.isEmpty(str)) {
            K.a("ad_slot_conf", str);
        }
        if (!TextUtils.isEmpty(this.g)) {
            K.a("template_ids", this.g);
        }
        if (!TextUtils.isEmpty(this.e)) {
            K.a("tpl_infos", this.e);
        }
    }

    private ae K() {
        return ae.a("tt_sdk_settings", p.a());
    }

    @NonNull
    public String b() {
        return TextUtils.isEmpty(this.J) ? "pangolin.snssdk.com" : this.J;
    }

    @NonNull
    public String c() {
        return TextUtils.isEmpty(this.K) ? "extlog.snssdk.com/service/2/app_log/" : this.K;
    }

    public boolean d() {
        return this.C == 1;
    }

    public boolean e() {
        return this.D == 1;
    }

    public int f() {
        return this.k;
    }

    public int g() {
        return this.l * 1024 * 1024;
    }

    public String h() {
        return this.q;
    }

    public String i() {
        return this.r;
    }

    public String j() {
        return this.j;
    }

    public long k() {
        return this.E;
    }

    public int l() {
        return this.F;
    }

    public int m() {
        return this.G;
    }

    public int n() {
        return this.t;
    }

    public String o() {
        return this.u;
    }

    public String p() {
        return this.v;
    }

    public JSONObject q() {
        return this.o;
    }

    public boolean r() {
        return this.n == 1;
    }

    public int s() {
        return this.w;
    }

    public int t() {
        return this.x;
    }

    public boolean u() {
        return s() != 0;
    }

    public boolean v() {
        return t() == 1;
    }

    public boolean w() {
        return this.s == 1;
    }

    public boolean x() {
        return this.m == 1;
    }

    public int y() {
        return this.f6896a;
    }

    public int z() {
        return this.f6897b;
    }

    public String A() {
        return this.O;
    }

    public boolean a(int i) {
        return r(String.valueOf(i)).c == 1;
    }

    public boolean a(String str) {
        switch (p.h().r(String.valueOf(str)).e) {
            case 1:
                return x.d(p.a());
            case 2:
                return x.c(p.a()) != 0;
            case 3:
            default:
                return false;
        }
    }

    public boolean b(String str) {
        return r(String.valueOf(str)).h == 1;
    }

    public int c(String str) {
        return r(String.valueOf(str)).t;
    }

    public boolean d(String str) {
        return str == null || p.h().r(String.valueOf(str)).p == 1;
    }

    public boolean e(String str) {
        return str == null || p.h().r(String.valueOf(str)).q == 0;
    }

    public int f(String str) {
        if (str == null) {
            return 1500;
        }
        return p.h().r(String.valueOf(str)).r;
    }

    public int g(String str) {
        return p.h().r(String.valueOf(str)).l;
    }

    public JSONArray h(String str) {
        try {
            Set<String> b2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b(str);
            if (b2 == null || b2.size() == 0) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (String str2 : b2) {
                q a2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(str2);
                if (a2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", a2.b());
                    jSONObject.put("md5", a2.c());
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean i(String str) {
        try {
            a r = p.h().r(String.valueOf(str));
            if (r != null) {
                if (r.z != null) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public int j(String str) {
        return r(String.valueOf(str)).i;
    }

    public int k(String str) {
        return r(str).k;
    }

    public int l(String str) {
        if (str == null) {
            return -1;
        }
        return p.h().r(String.valueOf(str)).m;
    }

    public int a(String str, boolean z) {
        if (str == null) {
            return a(z);
        }
        a r = p.h().r(String.valueOf(str));
        return r.v != -1 ? r.v : a(z);
    }

    public int m(String str) {
        if (str == null) {
            return 0;
        }
        return p.h().r(String.valueOf(str)).w;
    }

    public boolean n(String str) {
        return r(String.valueOf(str)).x == 0;
    }

    public int o(String str) {
        if (str == null) {
            return 20;
        }
        return p.h().r(String.valueOf(str)).u;
    }

    private int a(boolean z) {
        return z ? 20 : 5;
    }

    public int p(String str) {
        if (str == null) {
            return -1;
        }
        return p.h().r(String.valueOf(str)).n;
    }

    public boolean b(int i) {
        if (i == 0) {
            return false;
        }
        return p.h().r(String.valueOf(i)).o == 1;
    }

    public boolean q(String str) {
        return str == null || p.h().r(String.valueOf(str)).f == 1;
    }

    public List<String> B() {
        if (this.z + 172800000 < System.currentTimeMillis()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.A) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public int C() {
        return this.P;
    }

    public List<String> D() {
        if (this.z + 172800000 < System.currentTimeMillis()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.B) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public boolean E() {
        return this.y == 1;
    }

    public int F() {
        return this.L;
    }

    public int G() {
        if (this.M <= 0) {
            this.M = 3000;
        }
        return this.M;
    }

    public String[] H() {
        try {
            if (this.N == null || this.N.size() == 0) {
                return null;
            }
            return (String[]) this.N.toArray(new String[0]);
        } catch (Throwable th) {
            return null;
        }
    }

    public int c(int i) {
        return r(String.valueOf(i)).f6869b;
    }

    public int d(int i) {
        return r(String.valueOf(i)).j;
    }

    public int e(int i) {
        return r(String.valueOf(i)).y;
    }

    public int I() {
        return this.H;
    }

    public a r(String str) {
        a aVar = this.c.get(str);
        return aVar == null ? u(str) : aVar;
    }

    private a u(String str) {
        return a.a().a(str).n(1).o(this.f.contains(str) ? 0 : 1).p(2).q(1).r(1).s(100).t(0).v(1).m(3).l(-1).j(-1).i(2).k(-1).w(1).e(-1).a(-1).d(20).x(5).a((JSONArray) null);
    }

    public List<g> J() {
        return this.i;
    }

    public void s(String str) {
        this.f.add(str);
    }

    public static Set<String> a(Set<String> set) {
        try {
            if (set == null) {
                return new HashSet();
            }
            HashSet hashSet = new HashSet();
            for (String str : set) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            return hashSet;
        } catch (Throwable th) {
            return new HashSet();
        }
    }
}
