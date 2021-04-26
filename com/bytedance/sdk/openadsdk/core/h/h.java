package com.bytedance.sdk.openadsdk.core.h;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.pms.db.PackageTable;
import com.bytedance.sdk.openadsdk.core.d.t;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.af;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
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
/* loaded from: classes5.dex */
public class h implements c {

    /* renamed from: e  reason: collision with root package name */
    public String f28979e;

    /* renamed from: g  reason: collision with root package name */
    public String f28981g;
    public String j;
    public String q;
    public String r;
    public String u;
    public String v;

    /* renamed from: a  reason: collision with root package name */
    public int f28975a = Integer.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public int f28976b = Integer.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, a> f28977c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public Map<String, i> f28978d = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final Set<String> f28980f = new HashSet();

    /* renamed from: h  reason: collision with root package name */
    public Set<String> f28982h = Collections.synchronizedSet(new HashSet());

    /* renamed from: i  reason: collision with root package name */
    public final List<e> f28983i = new CopyOnWriteArrayList();
    public int k = Integer.MAX_VALUE;
    public int l = Integer.MAX_VALUE;
    public int m = Integer.MAX_VALUE;
    public int n = Integer.MAX_VALUE;
    public JSONObject o = null;
    public String p = "";
    public int s = Integer.MAX_VALUE;
    public int t = Integer.MAX_VALUE;
    public int w = Integer.MAX_VALUE;
    public int x = Integer.MAX_VALUE;
    public int y = Integer.MAX_VALUE;
    public long z = 0;
    public Set<String> A = Collections.synchronizedSet(new HashSet());
    public Set<String> B = Collections.synchronizedSet(new HashSet());
    public int C = Integer.MAX_VALUE;
    public int D = Integer.MAX_VALUE;
    public long E = 2147483647L;
    public int F = Integer.MAX_VALUE;
    public int G = Integer.MAX_VALUE;
    public int H = Integer.MAX_VALUE;
    public String I = null;
    public String J = null;
    public int K = Integer.MAX_VALUE;
    public int L = Integer.MAX_VALUE;
    public Set<String> M = Collections.synchronizedSet(new HashSet());
    public String N = null;
    public int O = Integer.MAX_VALUE;
    public int P = Integer.MAX_VALUE;
    public volatile boolean Q = false;
    public int S = Integer.MAX_VALUE;
    public int T = Integer.MAX_VALUE;
    public final af R = af.a("tt_sdk_settings", p.a());

    private int a(boolean z) {
        return z ? 20 : 5;
    }

    public static a b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("code_id");
        int optInt = jSONObject.optInt("auto_play", 1);
        int optInt2 = jSONObject.optInt("voice_control", 1);
        int optInt3 = jSONObject.optInt("rv_preload", 2);
        int optInt4 = jSONObject.optInt("nv_preload", 1);
        int optInt5 = jSONObject.optInt("proportion_watching", 100);
        int optInt6 = jSONObject.optInt("skip_time_displayed", 0);
        int optInt7 = jSONObject.optInt("video_skip_result", 2);
        int optInt8 = jSONObject.optInt("reg_creative_control", 1);
        int optInt9 = jSONObject.optInt("play_bar_show_time", 3);
        int optInt10 = jSONObject.optInt("rv_skip_time", -1);
        int optInt11 = jSONObject.optInt("endcard_close_time", -1);
        int optInt12 = jSONObject.optInt("playable_endcard_close_time", -1);
        int optInt13 = jSONObject.optInt("voice_control", 2);
        int optInt14 = jSONObject.optInt("if_show_win", 1);
        int optInt15 = jSONObject.optInt("sp_preload", 0);
        int optInt16 = jSONObject.optInt("stop_time", 1500);
        int optInt17 = jSONObject.optInt("native_playable_delay", 2);
        int optInt18 = jSONObject.optInt("time_out_control", -1);
        int optInt19 = jSONObject.optInt("playable_duration_time", 20);
        int optInt20 = jSONObject.optInt("playable_close_time", -1);
        int optInt21 = jSONObject.optInt("playable_reward_type", 0);
        int optInt22 = jSONObject.optInt("reward_is_callback", 0);
        int optInt23 = jSONObject.optInt("iv_skip_time", 5);
        JSONArray optJSONArray = jSONObject.optJSONArray("parent_tpl_ids");
        if (!f(optInt2)) {
            optInt2 = 1;
        }
        if (!f(optInt13)) {
            optInt13 = 1;
        }
        return a.a().a(optString).n(optInt).o(optInt2).p(optInt3).q(optInt4).r(optInt5).s(optInt6).t(optInt7).u(optInt8).m(optInt9).l(optInt10).j(optInt11).i(optInt13).k(optInt12).v(optInt14).f(optInt15).g(optInt16).h(optInt17).e(optInt18).a(optInt20).d(optInt19).b(optInt21).c(optInt22).w(optInt23).a(optJSONArray);
    }

    private int c(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("splash_load_type", 2);
        this.w = optInt;
        if (optInt == 0 || optInt == 1 || optInt == 2 || optInt == 3) {
            return this.w;
        }
        return 2;
    }

    private int d(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("splash_check_type", 1);
        this.x = optInt;
        if (optInt == 0 || optInt == 1) {
            return this.x;
        }
        return 1;
    }

    public static boolean f(int i2) {
        return i2 == 1 || i2 == 2;
    }

    private void s(String str) {
        if (str == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                e eVar = new e();
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                eVar.f28962a = optJSONObject.optString("action");
                eVar.f28963b = optJSONObject.optString("service");
                eVar.f28964c = optJSONObject.optString("package");
                eVar.f28965d = optJSONObject.optInt("wakeup_interval");
                this.f28983i.add(eVar);
            }
            d.a().b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public List<String> A() {
        if (this.z + 172800000 < System.currentTimeMillis()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.A) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public int B() {
        if (this.O == Integer.MAX_VALUE) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.O = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "sp_key_if_sp_cache", 0);
            } else {
                this.O = this.R.b("sp_key_if_sp_cache", 0);
            }
        }
        return this.O;
    }

    public List<String> C() {
        if (this.z + 172800000 < System.currentTimeMillis()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.B) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public boolean D() {
        if (this.y == Integer.MAX_VALUE) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.y = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "app_list_control", 0);
            } else {
                this.y = this.R.b("app_list_control", 0);
            }
        }
        return this.y == 1;
    }

    public int E() {
        if (this.K == Integer.MAX_VALUE) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.K = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max_tpl_cnts", 100);
            } else {
                this.K = this.R.b("max_tpl_cnts", 100);
            }
        }
        return this.K;
    }

    public int F() {
        if (this.L == Integer.MAX_VALUE) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.L = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_tpl_timeout_ctrl", 3000);
            } else {
                this.L = this.R.b("fetch_tpl_timeout_ctrl", 3000);
            }
        }
        if (this.L <= 0) {
            this.L = 3000;
        }
        return this.L;
    }

    public String[] G() {
        if (this.M == null || this.M.size() == 0) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.M = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "gecko_hosts", (Set<String>) null);
            } else {
                this.M = this.R.b("gecko_hosts", (Set<String>) null);
            }
            Set<String> a2 = a(this.M);
            this.M = a2;
            if (a2 != null) {
                if (a2.size() == 0) {
                }
            }
            return null;
        }
        return (String[]) this.M.toArray(new String[0]);
    }

    public int H() {
        if (this.G == Integer.MAX_VALUE) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.G = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "vbtt", 5);
            } else {
                this.G = this.R.b("vbtt", 5);
            }
        }
        return this.G;
    }

    public List<e> I() {
        if (this.f28983i.isEmpty()) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                s(com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "push_config", (String) null));
            } else {
                s(this.R.b("push_config", (String) null));
            }
        }
        return this.f28983i;
    }

    public boolean J() {
        return this.Q;
    }

    public boolean K() {
        if (this.P == Integer.MAX_VALUE) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.P = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "if_pre_connect", 0);
            } else {
                this.P = this.R.b("if_pre_connect", 0);
            }
        }
        return this.P == 1;
    }

    public boolean L() {
        if (this.S == Integer.MAX_VALUE) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.S = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "read_video_from_cache", 1);
            } else {
                this.S = this.R.b("read_video_from_cache", 1);
            }
        }
        return this.S == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.h.c
    public synchronized void a() {
        this.Q = true;
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            this.I = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "url_ads", "pangolin.snssdk.com");
            this.J = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "url_alog", "extlog.snssdk.com/service/2/app_log/");
            this.j = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "xpath", "");
            this.E = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "duration", 10000L);
            this.F = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max", 50);
            this.k = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_network", 1);
            this.l = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_size", 30);
            this.m = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_storage_internal", 1);
            this.G = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "vbtt", 5);
            this.H = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_template", 3600);
            this.f28981g = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "template_ids", (String) null);
            this.q = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ab_test_version", (String) null);
            this.r = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ab_test_param", (String) null);
            this.s = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "web_info_wifi_enable", 1);
            this.t = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "web_info_page_count", 5);
            this.u = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "pyload_h5", (String) null);
            this.v = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "playableLoadH5Url", (String) null);
            this.w = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_load_type", 2);
            this.x = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_check_type", 1);
            this.C = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "if_both_open", 0);
            this.D = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "support_tnc", 1);
            this.f28979e = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "tpl_infos", (String) null);
            this.P = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "if_pre_connect", 0);
            this.T = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "global_rate", 1);
            this.y = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "app_list_control", 0);
            this.K = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max_tpl_cnts", 100);
            this.L = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_tpl_timeout_ctrl", 3000);
            if (this.M != null) {
                this.M.clear();
            }
            Set<String> b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "gecko_hosts", (Set<String>) null);
            this.M = b2;
            this.M = a(b2);
            this.z = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "hit_app_list_time", 0L);
            this.A.clear();
            this.f28975a = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "circle_splash_switch", 0);
            this.f28976b = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "circle_load_splash_time", -1);
            this.O = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "sp_key_if_sp_cache", 0);
            this.N = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "dyn_draw_engine_url", "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json");
            Set<String> b3 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "hit_app_list_data", (Set<String>) null);
            if (b3 != null && !b3.isEmpty()) {
                for (String str : b3) {
                    this.A.add(str);
                }
            }
            this.B.clear();
            Set<String> b4 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "scheme_list_data", (Set<String>) null);
            if (b4 != null && !b4.isEmpty()) {
                for (String str2 : b4) {
                    this.B.add(str2);
                }
            }
            s(com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "push_config", (String) null));
            String b5 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ad_slot_conf", (String) null);
            if (!TextUtils.isEmpty(b5)) {
                try {
                    JSONArray jSONArray = new JSONArray(b5);
                    int length = jSONArray.length();
                    if (length > 0) {
                        this.f28977c.clear();
                        for (int i2 = 0; i2 < length; i2++) {
                            a b6 = b(jSONArray.optJSONObject(i2));
                            if (b6 != null) {
                                this.f28977c.put(b6.f28940a, b6);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            String b7 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "download_sdk_config", "");
            this.p = b7;
            if (!TextUtils.isEmpty(b7)) {
                try {
                    this.o = new JSONObject(this.p);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            this.n = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "enable_download_opt", 0);
            this.S = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "read_video_from_cache", 1);
            com.bytedance.sdk.openadsdk.downloadnew.a.g.c();
            return;
        }
        this.I = this.R.b("url_ads", "pangolin.snssdk.com");
        this.J = this.R.b("url_alog", "extlog.snssdk.com/service/2/app_log/");
        this.j = this.R.b("xpath", "");
        this.E = this.R.b("duration", 10000L);
        this.F = this.R.b("max", 50);
        this.k = this.R.b("download_config_dl_network", 1);
        this.l = this.R.b("download_config_dl_size", 30);
        this.m = this.R.b("download_config_storage_internal", 1);
        this.H = this.R.b("fetch_template", 3600);
        this.q = this.R.a("ab_test_version");
        this.r = this.R.a("ab_test_param");
        this.G = this.R.b("vbtt", 5);
        this.f28981g = this.R.b("template_ids", (String) null);
        this.s = this.R.b("web_info_wifi_enable", 1);
        this.t = this.R.b("web_info_page_count", 5);
        this.u = this.R.b("pyload_h5", (String) null);
        this.v = this.R.b("playableLoadH5Url", (String) null);
        this.w = this.R.b("splash_load_type", 2);
        this.x = this.R.b("splash_check_type", 1);
        this.C = this.R.b("if_both_open", 0);
        this.D = this.R.b("support_tnc", 1);
        this.f28979e = this.R.b("tpl_infos", (String) null);
        this.P = this.R.b("if_pre_connect", 0);
        this.T = this.R.b("global_rate", 1);
        this.y = this.R.b("app_list_control", 0);
        this.K = this.R.b("max_tpl_cnts", 100);
        this.L = this.R.b("fetch_tpl_timeout_ctrl", 3000);
        if (this.M != null) {
            this.M.clear();
        }
        Set<String> b8 = this.R.b("gecko_hosts", (Set<String>) null);
        this.M = b8;
        this.M = a(b8);
        this.z = this.R.b("hit_app_list_time", 0L);
        this.A.clear();
        this.f28975a = this.R.b("circle_splash_switch", 0);
        this.f28976b = this.R.b("circle_load_splash_time", -1);
        this.N = this.R.b("dyn_draw_engine_url", "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json");
        this.O = this.R.b("sp_key_if_sp_cache", 0);
        Set<String> b9 = this.R.b("hit_app_list_data", (Set<String>) null);
        if (b9 != null && !b9.isEmpty()) {
            for (String str3 : b9) {
                this.A.add(str3);
            }
        }
        this.B.clear();
        Set<String> b10 = this.R.b("scheme_list_data", (Set<String>) null);
        if (b10 != null && !b10.isEmpty()) {
            for (String str4 : b10) {
                this.B.add(str4);
            }
        }
        s(this.R.b("push_config", (String) null));
        String b11 = this.R.b("ad_slot_conf", (String) null);
        if (!TextUtils.isEmpty(b11)) {
            try {
                JSONArray jSONArray2 = new JSONArray(b11);
                int length2 = jSONArray2.length();
                if (length2 > 0) {
                    this.f28977c.clear();
                    for (int i3 = 0; i3 < length2; i3++) {
                        a b12 = b(jSONArray2.optJSONObject(i3));
                        if (b12 != null) {
                            this.f28977c.put(b12.f28940a, b12);
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        }
        String b13 = this.R.b("download_sdk_config", "");
        this.p = b13;
        if (!TextUtils.isEmpty(b13)) {
            try {
                this.o = new JSONObject(this.p);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        this.n = this.R.b("enable_download_opt", 0);
        this.S = this.R.b("read_video_from_cache", 1);
        com.bytedance.sdk.openadsdk.downloadnew.a.g.c();
        return;
    }

    public int e() {
        if (this.k == Integer.MAX_VALUE) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.k = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_network", 1);
            } else {
                this.k = this.R.b("download_config_dl_network", 1);
            }
        }
        return this.k;
    }

    public int f() {
        if (this.l == Integer.MAX_VALUE) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.l = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_size", 30);
            } else {
                this.l = this.R.b("download_config_dl_size", 30);
            }
        }
        return this.l * 1024 * 1024;
    }

    public String g() {
        if (TextUtils.isEmpty(this.q)) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.q = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ab_test_version", (String) null);
            } else {
                this.q = this.R.a("ab_test_version");
            }
        }
        return this.q;
    }

    public String h() {
        if (TextUtils.isEmpty(this.r)) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.r = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ab_test_param", (String) null);
            } else {
                this.r = this.R.a("ab_test_param");
            }
        }
        return this.r;
    }

    public String i() {
        if (TextUtils.isEmpty(this.j)) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.j = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "xpath", "");
            } else {
                this.j = this.R.b("xpath", "");
            }
        }
        return this.j;
    }

    public long j() {
        if (this.E == 2147483647L) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.E = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "duration", 10000L);
            } else {
                this.E = this.R.b("duration", 10000L);
            }
        }
        return this.E;
    }

    public int k() {
        if (this.F == Integer.MAX_VALUE) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.F = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max", 50);
            } else {
                this.F = this.R.b("max", 50);
            }
        }
        return this.F;
    }

    public int l() {
        if (this.t == Integer.MAX_VALUE) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.t = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "web_info_page_count", 5);
            } else {
                this.t = this.R.b("web_info_page_count", 5);
            }
        }
        return this.t;
    }

    public String m() {
        if (TextUtils.isEmpty(this.u)) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.u = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "pyload_h5", (String) null);
            } else {
                this.u = this.R.b("pyload_h5", (String) null);
            }
        }
        return this.u;
    }

    public String n() {
        if (TextUtils.isEmpty(this.v)) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.v = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "playableLoadH5Url", (String) null);
            } else {
                this.v = this.R.b("playableLoadH5Url", (String) null);
            }
        }
        return this.v;
    }

    public JSONObject o() {
        if (this.o == null) {
            String b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "download_sdk_config", "");
            this.p = b2;
            if (!TextUtils.isEmpty(b2)) {
                try {
                    this.o = new JSONObject(this.p);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return this.o;
    }

    public boolean p() {
        if (this.n == Integer.MAX_VALUE) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.n = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "enable_download_opt", 0);
            } else {
                this.n = this.R.b("enable_download_opt", 0);
            }
        }
        return this.n == 1;
    }

    public int q() {
        if (this.w == Integer.MAX_VALUE) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.w = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_load_type", 2);
            } else {
                this.w = this.R.b("splash_load_type", 2);
            }
        }
        return this.w;
    }

    public int r() {
        if (this.x == Integer.MAX_VALUE) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.x = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_check_type", 1);
            } else {
                this.x = this.R.b("splash_check_type", 1);
            }
        }
        return this.x;
    }

    public boolean t() {
        return r() == 1;
    }

    public boolean u() {
        if (this.s == Integer.MAX_VALUE) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.s = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "web_info_wifi_enable", 1);
            } else {
                this.s = this.R.b("web_info_wifi_enable", 1);
            }
        }
        return this.s == 1;
    }

    public boolean v() {
        if (this.T == Integer.MAX_VALUE) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.T = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "global_rate", 1);
            } else {
                this.T = this.R.b("global_rate", 1);
            }
        }
        return this.T == 1;
    }

    public boolean w() {
        if (this.m == Integer.MAX_VALUE) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.m = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_storage_internal", 1);
            } else {
                this.m = this.R.b("download_config_storage_internal", 1);
            }
        }
        return this.m == 1;
    }

    public int x() {
        if (this.f28975a == Integer.MAX_VALUE) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.f28975a = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "circle_splash_switch", 0);
            } else {
                this.f28975a = this.R.b("circle_splash_switch", 0);
            }
        }
        return this.f28975a;
    }

    public int y() {
        if (this.f28976b == Integer.MAX_VALUE) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.f28976b = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "circle_load_splash_time", -1);
            } else {
                this.f28976b = this.R.b("circle_load_splash_time", -1);
            }
        }
        return this.f28976b;
    }

    public String z() {
        if (TextUtils.isEmpty(this.N)) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.N = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "dyn_draw_engine_url", "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json");
            } else {
                this.N = this.R.b("dyn_draw_engine_url", "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json");
            }
        }
        return this.N;
    }

    private a t(String str) {
        return a.a().a(str).n(1).o(!this.f28980f.contains(str) ? 1 : 0).p(2).q(1).r(100).s(0).u(1).m(3).l(-1).j(-1).i(2).k(-1).v(1).e(-1).a(-1).d(20).w(5).a((JSONArray) null);
    }

    @NonNull
    public String c() {
        if (TextUtils.isEmpty(this.J)) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.J = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "url_alog", "extlog.snssdk.com/service/2/app_log/");
            } else {
                this.J = this.R.b("url_alog", "extlog.snssdk.com/service/2/app_log/");
            }
            if (TextUtils.isEmpty(this.J)) {
                this.J = "extlog.snssdk.com/service/2/app_log/";
            }
        }
        return this.J;
    }

    public boolean d() {
        if (this.D == Integer.MAX_VALUE) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.D = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "support_tnc", 1);
            } else {
                this.D = this.R.b("support_tnc", 1);
            }
        }
        return this.D == 1;
    }

    public boolean e(String str) {
        return str == null || p.h().q(String.valueOf(str)).p == 0;
    }

    public int f(String str) {
        if (str == null) {
            return 1500;
        }
        return p.h().q(String.valueOf(str)).q;
    }

    public int g(String str) {
        return p.h().q(String.valueOf(str)).k;
    }

    public JSONArray h(String str) {
        try {
            Set<String> b2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b(str);
            if (b2 != null && b2.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                for (String str2 : b2) {
                    t a2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(str2);
                    if (a2 != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", a2.b());
                        jSONObject.put(PackageTable.MD5, a2.c());
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public boolean i(String str) {
        try {
            a q = p.h().q(String.valueOf(str));
            if (q != null) {
                return q.y != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public int j(String str) {
        return q(String.valueOf(str)).f28947h;
    }

    public int k(String str) {
        return q(str).j;
    }

    public int l(String str) {
        if (str == null) {
            return -1;
        }
        return p.h().q(String.valueOf(str)).l;
    }

    public int m(String str) {
        if (str == null) {
            return 0;
        }
        return p.h().q(String.valueOf(str)).v;
    }

    public boolean n(String str) {
        return q(String.valueOf(str)).w == 0;
    }

    public int p(String str) {
        if (str == null) {
            return -1;
        }
        return p.h().q(String.valueOf(str)).m;
    }

    public a q(String str) {
        JSONArray jSONArray;
        int length;
        if (this.f28977c.size() == 0) {
            String b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ad_slot_conf", (String) null);
            if (!TextUtils.isEmpty(b2)) {
                try {
                    synchronized (this.f28977c) {
                        if (this.f28977c.size() == 0 && (length = (jSONArray = new JSONArray(b2)).length()) > 0) {
                            for (int i2 = 0; i2 < length; i2++) {
                                a b3 = b(jSONArray.optJSONObject(i2));
                                if (b3 != null) {
                                    this.f28977c.put(b3.f28940a, b3);
                                }
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        a aVar = this.f28977c.get(str);
        return aVar == null ? t(str) : aVar;
    }

    public void r(String str) {
        this.f28980f.add(str);
    }

    public int o(String str) {
        if (str == null) {
            return 20;
        }
        return p.h().q(String.valueOf(str)).t;
    }

    public boolean d(String str) {
        return str == null || p.h().q(String.valueOf(str)).o == 1;
    }

    public int e(int i2) {
        return q(String.valueOf(i2)).x;
    }

    public int c(String str) {
        return q(String.valueOf(str)).s;
    }

    public int d(int i2) {
        return q(String.valueOf(i2)).f28948i;
    }

    public int c(int i2) {
        return q(String.valueOf(i2)).f28941b;
    }

    public boolean s() {
        return q() != 0;
    }

    @NonNull
    public String b() {
        if (TextUtils.isEmpty(this.I)) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.I = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "url_ads", "pangolin.snssdk.com");
            } else {
                this.I = this.R.b("url_ads", "pangolin.snssdk.com");
            }
            if (TextUtils.isEmpty(this.I)) {
                this.I = "pangolin.snssdk.com";
            }
        }
        return this.I;
    }

    public boolean b(String str) {
        return q(String.valueOf(str)).f28946g == 1;
    }

    public boolean b(int i2) {
        return i2 != 0 && p.h().q(String.valueOf(i2)).n == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x029a  */
    @Override // com.bytedance.sdk.openadsdk.core.h.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@NonNull JSONObject jSONObject) {
        String str;
        JSONArray optJSONArray;
        JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject != null) {
            this.f28975a = optJSONObject.optInt("circle_splash", 0);
            this.f28976b = optJSONObject.optInt("circle_time", -1);
            this.O = optJSONObject.optInt("if_sp_cache", 0);
            this.P = optJSONObject.optInt("if_pre_connect", 0);
        }
        this.N = jSONObject.optString("dyn_draw_engine_url", "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json");
        this.I = jSONObject.optString("ads_url", "pangolin.snssdk.com");
        this.J = jSONObject.optString("app_log_url", "extlog.snssdk.com/service/2/app_log/");
        this.j = jSONObject.optString("xpath");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("feq_policy");
        if (optJSONObject2 != null) {
            this.E = optJSONObject2.optLong("duration") * 1000;
            this.F = optJSONObject2.optInt("max");
        }
        this.G = jSONObject.optInt("vbtt", 5);
        this.H = jSONObject.optInt("fetch_tpl_interval", 3600);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("abtest");
        if (optJSONObject3 != null) {
            this.q = optJSONObject3.optString("version");
            this.r = optJSONObject3.optString("param");
        } else if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_sdk_settings", "ab_test_version");
            com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_sdk_settings", "ab_test_param");
        } else {
            this.R.b("ab_test_version");
            this.R.b("ab_test_param");
        }
        this.S = jSONObject.optInt("read_video_from_cache", 1);
        JSONObject optJSONObject4 = jSONObject.optJSONObject("web_info");
        if (optJSONObject4 != null) {
            this.s = optJSONObject4.optInt("web_info_wifi_enable", 1);
            this.t = optJSONObject4.optInt("web_info_page_count", 5);
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("log_rate_conf");
        if (optJSONObject5 != null) {
            this.T = optJSONObject5.optInt("global_rate", 1);
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
        this.K = jSONObject.optInt("max_tpl_cnts", 100);
        JSONObject optJSONObject6 = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject6 != null) {
            this.L = optJSONObject6.optInt("fetch_tpl_timeout_ctrl", 3000);
            try {
                this.M.clear();
                JSONArray optJSONArray2 = optJSONObject6.optJSONArray("gecko_hosts");
                if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        this.M.add(optJSONArray2.getString(i2));
                    }
                }
                this.M = a(this.M);
            } catch (Throwable th) {
                u.b("GeckoLog: settings json error " + th);
            }
        }
        this.z = System.currentTimeMillis();
        this.A.clear();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("spam_app_list");
        if (optJSONArray3 != null) {
            int length = optJSONArray3.length();
            for (int i3 = 0; i3 < length; i3++) {
                String optString = optJSONArray3.optString(i3);
                if (!TextUtils.isEmpty(optString)) {
                    this.A.add(optString);
                }
            }
        }
        this.B.clear();
        JSONArray optJSONArray4 = jSONObject.optJSONArray("scheme_check_list");
        if (optJSONArray4 != null) {
            int length2 = optJSONArray4.length();
            for (int i4 = 0; i4 < length2; i4++) {
                String optString2 = optJSONArray4.optString(i4);
                if (!TextUtils.isEmpty(optString2)) {
                    this.B.add(optString2);
                }
            }
        }
        JSONObject optJSONObject7 = jSONObject.optJSONObject("download_config");
        if (optJSONObject7 != null) {
            this.k = optJSONObject7.optInt("dl_network", 1);
            this.l = optJSONObject7.optInt("dl_size", 30);
            this.m = optJSONObject7.optInt("if_storage_internal", 1);
            this.n = optJSONObject7.optInt("enable_download_opt", 0);
        }
        JSONObject optJSONObject8 = jSONObject.optJSONObject("download_sdk_config");
        this.o = optJSONObject8;
        if (optJSONObject8 != null) {
            this.p = optJSONObject8.toString();
        } else {
            this.p = "";
        }
        String str2 = null;
        try {
            JSONArray optJSONArray5 = jSONObject.optJSONArray("push_config");
            if (optJSONArray5 != null) {
                str = optJSONArray5.toString();
                try {
                    int length3 = optJSONArray5.length();
                    for (int i5 = 0; i5 < length3; i5++) {
                        e eVar = new e();
                        JSONObject optJSONObject9 = optJSONArray5.optJSONObject(i5);
                        if (optJSONObject9 != null) {
                            eVar.f28962a = optJSONObject9.optString("action");
                            eVar.f28963b = optJSONObject9.optString("service");
                            eVar.f28964c = optJSONObject9.optString("package");
                            eVar.f28965d = optJSONObject9.optInt("wakeup_interval");
                            this.f28983i.add(eVar);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                    optJSONArray = jSONObject.optJSONArray("ad_slot_conf_list");
                    if (optJSONArray != null) {
                    }
                    com.bytedance.sdk.openadsdk.downloadnew.a.g.c();
                    a(str2, str);
                }
            } else {
                str = null;
            }
            d.a().b();
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
        optJSONArray = jSONObject.optJSONArray("ad_slot_conf_list");
        if (optJSONArray != null) {
            str2 = optJSONArray.toString();
            int length4 = optJSONArray.length();
            if (length4 > 0) {
                this.f28977c.clear();
                for (int i6 = 0; i6 < length4; i6++) {
                    a b2 = b(optJSONArray.optJSONObject(i6));
                    if (b2 != null) {
                        this.f28977c.put(b2.f28940a, b2);
                    }
                }
            }
        }
        com.bytedance.sdk.openadsdk.downloadnew.a.g.c();
        a(str2, str);
    }

    private void a(String str, String str2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "url_ads", this.I);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "url_alog", this.J);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "xpath", this.j);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "duration", Long.valueOf(this.E));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max", Integer.valueOf(this.F));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_network", Integer.valueOf(this.k));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_size", Integer.valueOf(this.l));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_storage_internal", Integer.valueOf(this.m));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "vbtt", Integer.valueOf(this.G));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_template", Integer.valueOf(this.H));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "web_info_wifi_enable", Integer.valueOf(this.s));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "web_info_page_count", Integer.valueOf(this.t));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_load_type", Integer.valueOf(this.w));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_check_type", Integer.valueOf(this.x));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "if_both_open", Integer.valueOf(this.C));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "support_tnc", Integer.valueOf(this.D));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "pyload_h5", this.u);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "playableLoadH5Url", this.v);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "app_list_control", Integer.valueOf(this.y));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max_tpl_cnts", Integer.valueOf(this.K));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_tpl_timeout_ctrl", Integer.valueOf(this.L));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "gecko_hosts", this.M);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "hit_app_list_time", Long.valueOf(this.z));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "hit_app_list_data", this.A);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "scheme_list_data", this.B);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "circle_splash_switch", Integer.valueOf(this.f28975a));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "circle_load_splash_time", Integer.valueOf(this.f28976b));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "sp_key_if_sp_cache", Integer.valueOf(this.O));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "dyn_draw_engine_url", this.N);
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
            if (!TextUtils.isEmpty(this.f28981g)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "template_ids", this.f28981g);
            }
            if (!TextUtils.isEmpty(this.f28979e)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "tpl_infos", this.f28979e);
            }
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "if_pre_connect", Integer.valueOf(this.P));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "global_rate", Integer.valueOf(this.T));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "read_video_from_cache", Integer.valueOf(this.S));
            return;
        }
        this.R.a("url_ads", this.I);
        this.R.a("url_alog", this.J);
        this.R.a("xpath", this.j);
        this.R.a("duration", this.E);
        this.R.a("max", this.F);
        this.R.a("download_config_dl_network", this.k);
        this.R.a("download_config_dl_size", this.l);
        this.R.a("download_config_storage_internal", this.m);
        this.R.a("fetch_template", this.H);
        this.R.a("web_info_wifi_enable", this.s);
        this.R.a("web_info_page_count", this.t);
        this.R.a("pyload_h5", this.u);
        this.R.a("playableLoadH5Url", this.v);
        this.R.a("splash_load_type", this.w);
        this.R.a("splash_check_type", this.x);
        this.R.a("if_both_open", this.C);
        this.R.a("support_tnc", this.D);
        this.R.a("app_list_control", this.y);
        this.R.a("max_tpl_cnts", this.K);
        this.R.a("fetch_tpl_timeout_ctrl", this.L);
        this.R.a("gecko_hosts", this.M);
        this.R.a("hit_app_list_time", this.z);
        this.R.a("hit_app_list_data", this.A);
        this.R.a("scheme_list_data", this.B);
        this.R.a("circle_splash_switch", this.f28975a);
        this.R.a("circle_load_splash_time", this.f28976b);
        this.R.a("dyn_draw_engine_url", this.N);
        this.R.a("sp_key_if_sp_cache", this.O);
        this.R.a("download_sdk_config", this.p);
        this.R.a("enable_download_opt", this.n);
        if (!TextUtils.isEmpty(this.q)) {
            this.R.a("ab_test_version", this.q);
        }
        if (!TextUtils.isEmpty(this.r)) {
            this.R.a("ab_test_param", this.r);
        }
        this.R.a("vbtt", this.G);
        if (!TextUtils.isEmpty(str2)) {
            this.R.a("push_config", str2);
        }
        if (!TextUtils.isEmpty(str)) {
            this.R.a("ad_slot_conf", str);
        }
        if (!TextUtils.isEmpty(this.f28981g)) {
            this.R.a("template_ids", this.f28981g);
        }
        if (!TextUtils.isEmpty(this.f28979e)) {
            this.R.a("tpl_infos", this.f28979e);
        }
        this.R.a("if_pre_connect", this.P);
        this.R.a("global_rate", this.T);
        this.R.a("read_video_from_cache", this.S);
    }

    public boolean a(int i2) {
        return q(String.valueOf(i2)).f28942c == 1;
    }

    public boolean a(String str) {
        int i2 = p.h().q(String.valueOf(str)).f28944e;
        if (i2 != 1) {
            return i2 == 2 && x.c(p.a()) != 0;
        }
        return x.d(p.a());
    }

    public int a(String str, boolean z) {
        if (str == null) {
            return a(z);
        }
        int i2 = p.h().q(String.valueOf(str)).u;
        return i2 != -1 ? i2 : a(z);
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
        } catch (Throwable unused) {
            return new HashSet();
        }
    }
}
