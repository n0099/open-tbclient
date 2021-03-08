package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.u;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l {
    private boolean A;
    private boolean B;
    private h C;
    private Map<String, Object> D;
    private a E;
    private a F;
    private boolean G;
    private int H;
    private String I;
    private AdSlot Q;
    private int R;
    private String T;
    private JSONObject X;
    private int Z;

    /* renamed from: a  reason: collision with root package name */
    public String f4398a;
    private n ae;
    private c af;
    private String ag;
    private int b;
    private k c;
    private k d;
    private String e;
    private String g;
    private String i;
    private String l;
    private String m;
    private String n;
    private b p;
    private g q;
    private int r;
    private String s;
    private String t;
    private long w;
    private int x;
    private t y;
    private boolean z;
    private int f = -1;
    private List<k> h = new ArrayList();
    private List<String> j = new ArrayList();
    private List<String> k = new ArrayList();
    private String o = "0";
    private List<FilterWord> u = new ArrayList();
    private int v = 0;
    private String J = "";
    private String K = "";
    private int L = 0;
    private int M = 2;
    private int N = -200;
    private int O = 0;
    private e P = new e();
    private int S = 1;
    private int U = 0;
    private int V = 0;
    private int W = 0;
    private int Y = 1;
    private int aa = 0;
    private int ab = 0;
    private int ac = 0;
    private int ad = 1;

    public static boolean a(l lVar) {
        return lVar != null && lVar.a() == 1;
    }

    public int a() {
        return this.ac;
    }

    public void a(int i) {
        this.ac = i;
    }

    public void a(String str) {
        this.K = str;
    }

    public String b() {
        return this.K;
    }

    public void b(int i) {
        this.L = i;
    }

    public int c() {
        return this.L;
    }

    public void c(int i) {
        this.M = i;
    }

    public int d() {
        return this.M;
    }

    public int e() {
        return this.U;
    }

    public void d(int i) {
        this.U = i;
    }

    public boolean f() {
        return this.U == 1;
    }

    public JSONObject g() {
        if (this.ae == null) {
            return null;
        }
        return this.ae.b();
    }

    public n h() {
        return this.ae;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ae = n.a(jSONObject);
        }
    }

    public int i() {
        return this.H;
    }

    public void e(int i) {
        this.H = i;
    }

    public String j() {
        return this.I;
    }

    public void b(String str) {
        this.I = str;
    }

    public int k() {
        return this.W;
    }

    public void f(int i) {
        this.W = i;
    }

    public int l() {
        return this.V;
    }

    public void g(int i) {
        this.V = i;
    }

    public int m() {
        return this.S;
    }

    public void h(int i) {
        this.S = i;
    }

    public int n() {
        return this.O;
    }

    public void i(int i) {
        this.O = i;
    }

    public e o() {
        return this.P;
    }

    public void a(e eVar) {
        this.P = eVar;
    }

    public AdSlot p() {
        return this.Q;
    }

    public void a(AdSlot adSlot) {
        this.Q = adSlot;
    }

    public boolean q() {
        return r() == 1;
    }

    public int r() {
        if (this.C == null) {
            return 0;
        }
        return this.C.e();
    }

    public boolean s() {
        return t() == 1;
    }

    public int t() {
        if (this.C == null) {
            return 0;
        }
        return this.C.i();
    }

    public int u() {
        if (this.C == null) {
            return 300;
        }
        return this.C.j();
    }

    public int v() {
        return this.R;
    }

    public void j(int i) {
        this.R = i;
    }

    public int w() {
        return this.N;
    }

    public void k(int i) {
        this.N = i;
    }

    public int x() {
        return this.Y;
    }

    public void l(int i) {
        this.Y = i;
    }

    public void c(String str) {
        this.J = str;
    }

    public String y() {
        return this.J;
    }

    public int z() {
        return this.Z;
    }

    public void m(int i) {
        this.Z = i;
    }

    public boolean A() {
        return this.y == null || this.y.n() != 1;
    }

    public boolean B() {
        return this.y != null && this.y.o() == 1;
    }

    public boolean C() {
        return this.G;
    }

    public static boolean b(l lVar) {
        return lVar != null && lVar.C();
    }

    public boolean D() {
        return C() && i() == 1;
    }

    public void a(boolean z) {
        this.G = z;
    }

    public boolean E() {
        return F() == 1;
    }

    public int F() {
        if (this.C == null) {
            return 1;
        }
        return this.C.a();
    }

    public int G() {
        if (this.C == null) {
            return 1;
        }
        return this.C.c();
    }

    public int H() {
        if (this.C == null) {
            return 0;
        }
        return this.C.d();
    }

    public int I() {
        if (this.C == null) {
            return 0;
        }
        return this.C.k();
    }

    public int J() {
        if (this.C == null) {
            return 1;
        }
        return this.C.f();
    }

    public int K() {
        if (this.C == null) {
            return 1;
        }
        return this.C.g();
    }

    public int L() {
        if (this.C == null) {
            return 1;
        }
        return this.C.h();
    }

    public a M() {
        return this.E;
    }

    public void a(a aVar) {
        this.E = aVar;
        com.bytedance.sdk.openadsdk.core.widget.webview.d.a().b();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(this);
    }

    public a N() {
        return this.F;
    }

    public void b(a aVar) {
        this.F = aVar;
        com.bytedance.sdk.openadsdk.core.widget.webview.d.a().b();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b(this);
    }

    public h O() {
        return this.C;
    }

    public void a(h hVar) {
        this.C = hVar;
    }

    public c P() {
        return this.af;
    }

    public void a(c cVar) {
        this.af = cVar;
    }

    public String Q() {
        return this.ag;
    }

    public void d(String str) {
        this.ag = str;
    }

    public t R() {
        return this.y;
    }

    public void a(t tVar) {
        this.y = tVar;
    }

    public void e(String str) {
        this.s = str;
    }

    public String S() {
        return this.s;
    }

    public int T() {
        return this.b;
    }

    public void n(int i) {
        this.b = i;
    }

    public k U() {
        return this.c;
    }

    public void a(k kVar) {
        this.c = kVar;
    }

    public k V() {
        return this.d;
    }

    public void b(k kVar) {
        this.d = kVar;
    }

    public String W() {
        return this.e;
    }

    public void f(String str) {
        this.e = str;
    }

    public int X() {
        return this.f;
    }

    public void o(int i) {
        this.f = i;
    }

    public String Y() {
        return this.g;
    }

    public void g(String str) {
        this.g = str;
    }

    public List<k> Z() {
        return this.h;
    }

    public void c(k kVar) {
        this.h.add(kVar);
    }

    public String aa() {
        return this.i;
    }

    public void h(String str) {
        this.i = str;
    }

    public List<String> ab() {
        return this.j;
    }

    public List<String> ac() {
        return this.k;
    }

    public String ad() {
        return this.l;
    }

    public void i(String str) {
        this.l = str;
    }

    public String ae() {
        return this.m;
    }

    public void j(String str) {
        this.m = str;
    }

    public String af() {
        return this.n;
    }

    public void k(String str) {
        this.n = str;
    }

    public String ag() {
        return this.o;
    }

    public void l(String str) {
        this.o = str;
    }

    public b ah() {
        return this.p;
    }

    public void a(b bVar) {
        this.p = bVar;
    }

    public g ai() {
        return this.q;
    }

    public void a(g gVar) {
        this.q = gVar;
    }

    public String aj() {
        return this.t;
    }

    public void m(String str) {
        this.t = str;
    }

    public int ak() {
        return this.r;
    }

    public void p(int i) {
        this.r = i;
    }

    public List<FilterWord> al() {
        return this.u;
    }

    public void a(FilterWord filterWord) {
        this.u.add(filterWord);
    }

    public long am() {
        return this.w;
    }

    public void a(long j) {
        this.w = j;
    }

    public int an() {
        return this.x;
    }

    public void q(int i) {
        this.x = i;
    }

    public boolean ao() {
        return this.z;
    }

    public void b(boolean z) {
        this.z = z;
    }

    public boolean ap() {
        return this.A;
    }

    public void c(boolean z) {
        this.A = z;
    }

    public boolean aq() {
        return this.B;
    }

    public void d(boolean z) {
        this.B = z;
    }

    public Map<String, Object> ar() {
        return this.D;
    }

    public void a(Map<String, Object> map) {
        this.D = map;
    }

    public JSONObject as() {
        return this.X;
    }

    public void b(JSONObject jSONObject) {
        this.X = jSONObject;
    }

    public String at() {
        return this.T;
    }

    public void n(String str) {
        this.T = str;
    }

    public void r(int i) {
        this.aa = i;
    }

    public int au() {
        return this.aa;
    }

    public boolean av() {
        return au() == 1;
    }

    public boolean aw() {
        return ax() == 1;
    }

    public void s(int i) {
        this.ab = i;
    }

    public int ax() {
        return this.ab;
    }

    public String ay() {
        return this.f4398a;
    }

    public void o(String str) {
        this.f4398a = str;
    }

    public int az() {
        return this.ad;
    }

    public void t(int i) {
        this.ad = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.o.equals(lVar.o) && this.t.equals(lVar.t);
    }

    public int hashCode() {
        return (this.o.hashCode() * 31) + this.t.hashCode();
    }

    public boolean aA() {
        if (this.h.isEmpty()) {
            return false;
        }
        if (this.r != 4 || this.h.size() >= 3) {
            for (k kVar : this.h) {
                if (!kVar.e()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int aB() {
        if (this.C == null) {
            return -1;
        }
        return this.C.b();
    }

    public boolean aC() {
        return aD() == 1;
    }

    public int aD() {
        return this.v;
    }

    public void u(int i) {
        this.v = i;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.b = 4;
            this.o = jSONObject.optString("id");
            this.s = jSONObject.optString("source");
            this.p = new b();
            this.p.d(jSONObject.optString("pkg_name"));
            this.p.c(jSONObject.optString("name"));
            this.p.b(jSONObject.optString("download_url"));
        }
    }

    public JSONObject aE() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("interaction_type", T());
            jSONObject.put("target_url", W());
            jSONObject.put("use_media_video_player", a());
            jSONObject.put("landing_scroll_percentage", X());
            jSONObject.put("gecko_id", Y());
            jSONObject.put(LegoListActivityConfig.AD_ID, ag());
            jSONObject.put("source", S());
            jSONObject.put("package_name", ay());
            jSONObject.put(StatisticConstants.SCREENSHOT, ao());
            jSONObject.put("dislike_control", aD());
            jSONObject.put("play_bar_show_time", w());
            jSONObject.put("is_playable", C());
            jSONObject.put("playable", g());
            jSONObject.put("playable_type", i());
            jSONObject.put("playable_style", j());
            jSONObject.put("play_bar_style", n());
            jSONObject.put("if_block_lp", e());
            jSONObject.put("cache_sort", x());
            jSONObject.put("if_sp_cache", z());
            jSONObject.put("render_control", d());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("reward_name", b());
            jSONObject2.put("reward_amount", c());
            jSONObject.put("reward_data", jSONObject2);
            k U = U();
            if (U != null && !TextUtils.isEmpty(U.a())) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("url", U.a());
                jSONObject3.put("height", U.c());
                jSONObject3.put("width", U.b());
                jSONObject.put(AlaStaticKeys.ALA_STATIC_VALUE_ICON, jSONObject3);
            }
            k V = V();
            if (V != null && !TextUtils.isEmpty(V.a())) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("url", V.a());
                jSONObject4.put("height", V.c());
                jSONObject4.put("width", V.b());
                jSONObject.put("cover_image", jSONObject4);
            }
            Object as = as();
            if (as != null) {
                jSONObject.put("session_params", as);
            }
            e o = o();
            if (o != null) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("click_upper_content_area", o.f4389a);
                jSONObject5.put("click_upper_non_content_area", o.b);
                jSONObject5.put("click_lower_content_area", o.c);
                jSONObject5.put("click_lower_non_content_area", o.d);
                jSONObject5.put("click_button_area", o.e);
                jSONObject5.put("click_video_area", o.f);
                jSONObject.put("click_area", jSONObject5);
            }
            AdSlot p = p();
            if (p != null) {
                jSONObject.put("adslot", p.toJsonObj());
            }
            List<k> Z = Z();
            if (Z != null) {
                JSONArray jSONArray = new JSONArray();
                for (k kVar : Z) {
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("url", kVar.a());
                    jSONObject6.put("height", kVar.c());
                    jSONObject6.put("width", kVar.b());
                    jSONArray.put(jSONObject6);
                }
                jSONObject.put("image", jSONArray);
            }
            List<String> ab = ab();
            if (ab != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str : ab) {
                    jSONArray2.put(str);
                }
                jSONObject.put("show_url", jSONArray2);
            }
            List<String> ac = ac();
            if (ac != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (String str2 : ac) {
                    jSONArray3.put(str2);
                }
                jSONObject.put("click_url", jSONArray3);
            }
            jSONObject.put(Oauth2AccessToken.KEY_PHONE_NUM, aa());
            jSONObject.put("title", ad());
            jSONObject.put("description", ae());
            jSONObject.put("ext", aj());
            jSONObject.put("image_mode", ak());
            jSONObject.put("is_playable", C());
            jSONObject.put("intercept_flag", v());
            jSONObject.put("button_text", af());
            jSONObject.put("ad_logo", m());
            jSONObject.put("video_adaptation", l());
            jSONObject.put("feed_video_opentype", k());
            b ah = ah();
            if (ah != null) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("app_name", ah.c());
                jSONObject7.put("package_name", ah.d());
                jSONObject7.put("download_url", ah.b());
                jSONObject7.put(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, ah.e());
                jSONObject7.put("comment_num", ah.f());
                jSONObject7.put("quick_app_url", ah.a());
                jSONObject7.put("app_size", ah.g());
                jSONObject.put("app", jSONObject7);
            }
            g ai = ai();
            if (ai != null) {
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("deeplink_url", ai.a());
                jSONObject8.put("fallback_url", ai.b());
                jSONObject8.put("fallback_type", ai.c());
                jSONObject.put("deep_link", jSONObject8);
            }
            List<FilterWord> al = al();
            if (al != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (FilterWord filterWord : al) {
                    JSONObject b = b(filterWord);
                    if (b != null) {
                        jSONArray4.put(b);
                    }
                }
                jSONObject.put("filter_words", jSONArray4);
            }
            jSONObject.put("count_down", an());
            jSONObject.put("expiration_time", am());
            t R = R();
            if (R != null) {
                jSONObject.put("video", R.m());
            }
            JSONObject jSONObject9 = new JSONObject();
            jSONObject9.put("auto_open", G());
            jSONObject9.put("download_mode", H());
            jSONObject9.put("download_type", aB());
            jSONObject9.put("auto_control", r());
            jSONObject9.put("auto_control_choose", t());
            jSONObject9.put("auto_control_time", u());
            jSONObject9.put("if_suspend_download", F());
            jSONObject9.put("if_send_click", I());
            jSONObject9.put("dl_popup", J());
            jSONObject9.put("market_popup", K());
            jSONObject9.put("if_pop_lp", L());
            jSONObject.put("download_conf", jSONObject9);
            jSONObject.put("if_both_open", au());
            jSONObject.put("if_double_deeplink", ax());
            if (ar() != null) {
                JSONObject jSONObject10 = new JSONObject();
                Set<Map.Entry<String, Object>> entrySet = ar().entrySet();
                if (entrySet != null && !entrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : entrySet) {
                        jSONObject10.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("media_ext", jSONObject10);
            }
            jSONObject.put("landing_page_type", az());
            a M = M();
            if (M != null) {
                JSONObject jSONObject11 = new JSONObject();
                jSONObject11.put("id", M.b());
                jSONObject11.put("md5", M.c());
                jSONObject11.put("url", M.d());
                jSONObject11.put("data", M.e());
                jSONObject11.put("diff_data", M.f());
                jSONObject11.put("version", M.a());
                jSONObject11.put("dynamic_creative", M.g());
                jSONObject.put("tpl_info", jSONObject11);
            }
            a N = N();
            if (N != null) {
                JSONObject jSONObject12 = new JSONObject();
                jSONObject12.put("middle_id", N.b());
                jSONObject12.put("middle_md5", N.c());
                jSONObject12.put("middle_url", N.d());
                jSONObject12.put("middle_data", N.e());
                jSONObject12.put("middle_diff_data", N.f());
                jSONObject12.put("middle_version", N.a());
                jSONObject12.put("middle_dynamic_creative", N.g());
                jSONObject.put("middle_tpl_info", jSONObject12);
            }
            jSONObject.put("market_url", at());
            c P = P();
            if (P != null) {
                JSONObject jSONObject13 = new JSONObject();
                jSONObject13.put("developer_name", P.c());
                jSONObject13.put("app_version", P.b());
                jSONObject13.put("permissions", P.e());
                jSONObject13.put("privacy_policy_url", P.d());
                jSONObject13.put("package_name", P.f());
                jSONObject13.put("app_name", P.g());
                jSONObject.put("app_manage", jSONObject13);
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private JSONObject b(FilterWord filterWord) {
        if (filterWord == null) {
            return null;
        }
        try {
            if (filterWord.isValid()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", filterWord.getId());
                jSONObject.put("name", filterWord.getName());
                jSONObject.put("is_selected", filterWord.getIsSelected());
                if (filterWord.hasSecondOptions()) {
                    JSONArray jSONArray = new JSONArray();
                    for (FilterWord filterWord2 : filterWord.getOptions()) {
                        jSONArray.put(b(filterWord2));
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("options", jSONArray);
                    }
                }
                return jSONObject;
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static boolean c(l lVar) {
        if (lVar == null) {
            return false;
        }
        return lVar.ak() == 5 || lVar.ak() == 15;
    }

    public static boolean d(l lVar) {
        return lVar != null && lVar.C() && lVar.i() == 1;
    }

    public static boolean e(l lVar) {
        return lVar != null && lVar.C() && lVar.i() == 0;
    }

    public static boolean f(l lVar) {
        try {
            return lVar.as().optInt("parent_type") == 1;
        } catch (Exception e) {
            Log.e("MaterialMeta", "isLuBanLandingPage error " + e);
            return false;
        }
    }

    public static boolean a(l lVar, boolean z, boolean z2) {
        if (lVar != null && lVar.y != null && lVar.y.a() == 1) {
            u.b("MaterialMeta", "can show end card follow js");
            return z2;
        }
        u.b("MaterialMeta", "can show end card follow js WebViewClient");
        return z;
    }

    public static boolean g(l lVar) {
        if (lVar == null || lVar.y == null) {
            return false;
        }
        return lVar.y.a() == 1;
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f4399a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;

        public String a() {
            return this.f;
        }

        public void a(String str) {
            this.f = str;
        }

        public String b() {
            return this.f4399a;
        }

        public void b(String str) {
            this.f4399a = str;
        }

        public String c() {
            return this.b;
        }

        public void c(String str) {
            this.b = str;
        }

        public String d() {
            return this.c;
        }

        public void d(String str) {
            this.c = str;
        }

        public String e() {
            return this.d;
        }

        public void e(String str) {
            this.d = str;
        }

        public String f() {
            return this.e;
        }

        public void f(String str) {
            this.e = str;
        }

        public String g() {
            return this.g;
        }

        public void g(String str) {
            this.g = str;
        }
    }
}
