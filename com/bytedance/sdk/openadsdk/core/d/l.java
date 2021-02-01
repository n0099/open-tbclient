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
    private h B;
    private Map<String, Object> C;
    private a D;
    private boolean E;
    private int F;
    private String G;
    private AdSlot L;
    private int M;
    private String O;
    private JSONObject S;
    private int U;
    private c V;
    private String W;

    /* renamed from: a  reason: collision with root package name */
    public String f6511a;

    /* renamed from: b  reason: collision with root package name */
    private int f6512b;
    private k c;
    private k d;
    private String e;
    private String f;
    private String h;
    private String k;
    private String l;
    private String m;
    private b o;
    private g p;
    private int q;
    private String r;
    private String s;
    private long v;
    private int w;
    private s x;
    private boolean y;
    private boolean z;
    private List<k> g = new ArrayList();
    private List<String> i = new ArrayList();
    private List<String> j = new ArrayList();
    private String n = "0";
    private List<FilterWord> t = new ArrayList();
    private int u = 0;
    private String H = "";
    private int I = -200;
    private int J = 0;
    private e K = new e();
    private int N = 1;
    private int P = 0;
    private int Q = 0;
    private int R = 0;
    private int T = 1;

    public int a() {
        return this.P;
    }

    public void a(int i) {
        this.P = i;
    }

    public boolean b() {
        return this.P == 1;
    }

    public int c() {
        return this.F;
    }

    public void b(int i) {
        this.F = i;
    }

    public String d() {
        return this.G;
    }

    public void a(String str) {
        this.G = str;
    }

    public int e() {
        return this.R;
    }

    public void c(int i) {
        this.R = i;
    }

    public int f() {
        return this.Q;
    }

    public void d(int i) {
        this.Q = i;
    }

    public int g() {
        return this.N;
    }

    public void e(int i) {
        this.N = i;
    }

    public int h() {
        return this.J;
    }

    public void f(int i) {
        this.J = i;
    }

    public e i() {
        return this.K;
    }

    public void a(e eVar) {
        this.K = eVar;
    }

    public AdSlot j() {
        return this.L;
    }

    public void a(AdSlot adSlot) {
        this.L = adSlot;
    }

    public int k() {
        if (this.B == null) {
            return 0;
        }
        return this.B.e();
    }

    public int l() {
        return this.M;
    }

    public void g(int i) {
        this.M = i;
    }

    public int m() {
        return this.I;
    }

    public void h(int i) {
        this.I = i;
    }

    public int n() {
        return this.T;
    }

    public void i(int i) {
        this.T = i;
    }

    public void b(String str) {
        this.H = str;
    }

    public String o() {
        return this.H;
    }

    public int p() {
        return this.U;
    }

    public void j(int i) {
        this.U = i;
    }

    public boolean q() {
        return this.x == null || this.x.m() != 1;
    }

    public boolean r() {
        return this.x != null && this.x.n() == 1;
    }

    public boolean s() {
        return this.E;
    }

    public static boolean a(l lVar) {
        return lVar != null && lVar.s();
    }

    public boolean t() {
        return s() && c() == 1;
    }

    public void a(boolean z) {
        this.E = z;
    }

    public boolean u() {
        return v() == 1;
    }

    public int v() {
        if (this.B == null) {
            return 1;
        }
        return this.B.a();
    }

    public int w() {
        if (this.B == null) {
            return 0;
        }
        return this.B.c();
    }

    public int x() {
        if (this.B == null) {
            return 0;
        }
        return this.B.d();
    }

    public int y() {
        if (this.B == null) {
            return 1;
        }
        return this.B.f();
    }

    public int z() {
        if (this.B == null) {
            return 1;
        }
        return this.B.g();
    }

    public int A() {
        if (this.B == null) {
            return 1;
        }
        return this.B.h();
    }

    public a B() {
        return this.D;
    }

    public void a(a aVar) {
        this.D = aVar;
        com.bytedance.sdk.openadsdk.core.widget.webview.d.a().b();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(this);
    }

    public h C() {
        return this.B;
    }

    public void a(h hVar) {
        this.B = hVar;
    }

    public c D() {
        return this.V;
    }

    public void a(c cVar) {
        this.V = cVar;
    }

    public String E() {
        return this.W;
    }

    public void c(String str) {
        this.W = str;
    }

    public s F() {
        return this.x;
    }

    public void a(s sVar) {
        this.x = sVar;
    }

    public void d(String str) {
        this.r = str;
    }

    public String G() {
        return this.r;
    }

    public int H() {
        return this.f6512b;
    }

    public void k(int i) {
        this.f6512b = i;
    }

    public k I() {
        return this.c;
    }

    public void a(k kVar) {
        this.c = kVar;
    }

    public k J() {
        return this.d;
    }

    public void b(k kVar) {
        this.d = kVar;
    }

    public String K() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }

    public String L() {
        return this.f;
    }

    public void f(String str) {
        this.f = str;
    }

    public List<k> M() {
        return this.g;
    }

    public void c(k kVar) {
        this.g.add(kVar);
    }

    public String N() {
        return this.h;
    }

    public void g(String str) {
        this.h = str;
    }

    public List<String> O() {
        return this.i;
    }

    public List<String> P() {
        return this.j;
    }

    public String Q() {
        return this.k;
    }

    public void h(String str) {
        this.k = str;
    }

    public String R() {
        return this.l;
    }

    public void i(String str) {
        this.l = str;
    }

    public String S() {
        return this.m;
    }

    public void j(String str) {
        this.m = str;
    }

    public String T() {
        return this.n;
    }

    public void k(String str) {
        this.n = str;
    }

    public b U() {
        return this.o;
    }

    public void a(b bVar) {
        this.o = bVar;
    }

    public g V() {
        return this.p;
    }

    public void a(g gVar) {
        this.p = gVar;
    }

    public String W() {
        return this.s;
    }

    public void l(String str) {
        this.s = str;
    }

    public int X() {
        return this.q;
    }

    public void l(int i) {
        this.q = i;
    }

    public List<FilterWord> Y() {
        return this.t;
    }

    public void a(FilterWord filterWord) {
        this.t.add(filterWord);
    }

    public long Z() {
        return this.v;
    }

    public void a(long j) {
        this.v = j;
    }

    public int aa() {
        return this.w;
    }

    public void m(int i) {
        this.w = i;
    }

    public boolean ab() {
        return this.y;
    }

    public void b(boolean z) {
        this.y = z;
    }

    public boolean ac() {
        return this.z;
    }

    public void c(boolean z) {
        this.z = z;
    }

    public boolean ad() {
        return this.A;
    }

    public void d(boolean z) {
        this.A = z;
    }

    public Map<String, Object> ae() {
        return this.C;
    }

    public void a(Map<String, Object> map) {
        this.C = map;
    }

    public JSONObject af() {
        return this.S;
    }

    public void a(JSONObject jSONObject) {
        this.S = jSONObject;
    }

    public String ag() {
        return this.O;
    }

    public void m(String str) {
        this.O = str;
    }

    public String ah() {
        return this.f6511a;
    }

    public void n(String str) {
        this.f6511a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.n.equals(lVar.n) && this.s.equals(lVar.s);
    }

    public int hashCode() {
        return (this.n.hashCode() * 31) + this.s.hashCode();
    }

    public boolean ai() {
        if (this.g.isEmpty()) {
            return false;
        }
        if (this.q != 4 || this.g.size() >= 3) {
            for (k kVar : this.g) {
                if (!kVar.d()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int aj() {
        if (this.B == null) {
            return -1;
        }
        return this.B.b();
    }

    public boolean ak() {
        return al() == 1;
    }

    public int al() {
        return this.u;
    }

    public void n(int i) {
        this.u = i;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f6512b = 4;
            this.n = jSONObject.optString("id");
            this.r = jSONObject.optString("source");
            this.o = new b();
            this.o.d(jSONObject.optString("pkg_name"));
            this.o.c(jSONObject.optString("name"));
            this.o.b(jSONObject.optString("download_url"));
        }
    }

    public JSONObject am() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("interaction_type", H());
            jSONObject.put("target_url", K());
            jSONObject.put("gecko_id", L());
            jSONObject.put(LegoListActivityConfig.AD_ID, T());
            jSONObject.put("source", G());
            jSONObject.put("package_name", ah());
            jSONObject.put(StatisticConstants.SCREENSHOT, ab());
            jSONObject.put("dislike_control", al());
            jSONObject.put("play_bar_show_time", m());
            jSONObject.put("is_playable", s());
            jSONObject.put("playable_type", c());
            jSONObject.put("playable_style", d());
            jSONObject.put("play_bar_style", h());
            jSONObject.put("if_block_lp", a());
            jSONObject.put("cache_sort", n());
            jSONObject.put("if_sp_cache", p());
            k I = I();
            if (I != null && !TextUtils.isEmpty(I.a())) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("url", I.a());
                jSONObject2.put("height", I.c());
                jSONObject2.put("width", I.b());
                jSONObject.put(AlaStaticKeys.ALA_STATIC_VALUE_ICON, jSONObject2);
            }
            k J = J();
            if (J != null && !TextUtils.isEmpty(J.a())) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("url", J.a());
                jSONObject3.put("height", J.c());
                jSONObject3.put("width", J.b());
                jSONObject.put("cover_image", jSONObject3);
            }
            Object af = af();
            if (af != null) {
                jSONObject.put("session_params", af);
            }
            e i = i();
            if (i != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("click_upper_content_area", i.f6493a);
                jSONObject4.put("click_upper_non_content_area", i.f6494b);
                jSONObject4.put("click_lower_content_area", i.c);
                jSONObject4.put("click_lower_non_content_area", i.d);
                jSONObject4.put("click_button_area", i.e);
                jSONObject4.put("click_video_area", i.f);
                jSONObject.put("click_area", jSONObject4);
            }
            AdSlot j = j();
            if (j != null) {
                jSONObject.put("adslot", j.toJsonObj());
            }
            List<k> M = M();
            if (M != null) {
                JSONArray jSONArray = new JSONArray();
                for (k kVar : M) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("url", kVar.a());
                    jSONObject5.put("height", kVar.c());
                    jSONObject5.put("width", kVar.b());
                    jSONArray.put(jSONObject5);
                }
                jSONObject.put("image", jSONArray);
            }
            List<String> O = O();
            if (O != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str : O) {
                    jSONArray2.put(str);
                }
                jSONObject.put("show_url", jSONArray2);
            }
            List<String> P = P();
            if (P != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (String str2 : P) {
                    jSONArray3.put(str2);
                }
                jSONObject.put("click_url", jSONArray3);
            }
            jSONObject.put(Oauth2AccessToken.KEY_PHONE_NUM, N());
            jSONObject.put("title", Q());
            jSONObject.put("description", R());
            jSONObject.put("ext", W());
            jSONObject.put("image_mode", X());
            jSONObject.put("is_playable", s());
            jSONObject.put("intercept_flag", l());
            jSONObject.put("button_text", S());
            jSONObject.put("ad_logo", g());
            jSONObject.put("video_adaptation", f());
            jSONObject.put("feed_video_opentype", e());
            b U = U();
            if (U != null) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("app_name", U.c());
                jSONObject6.put("package_name", U.d());
                jSONObject6.put("download_url", U.b());
                jSONObject6.put(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, U.e());
                jSONObject6.put("comment_num", U.f());
                jSONObject6.put("quick_app_url", U.a());
                jSONObject6.put("app_size", U.g());
                jSONObject.put("app", jSONObject6);
            }
            g V = V();
            if (V != null) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("deeplink_url", V.a());
                jSONObject7.put("fallback_url", V.b());
                jSONObject7.put("fallback_type", V.c());
                jSONObject.put("deep_link", jSONObject7);
            }
            List<FilterWord> Y = Y();
            if (Y != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (FilterWord filterWord : Y) {
                    JSONObject b2 = b(filterWord);
                    if (b2 != null) {
                        jSONArray4.put(b2);
                    }
                }
                jSONObject.put("filter_words", jSONArray4);
            }
            jSONObject.put("count_down", aa());
            jSONObject.put("expiration_time", Z());
            s F = F();
            if (F != null) {
                jSONObject.put("video", F.l());
            }
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("auto_open", w());
            jSONObject8.put("download_mode", x());
            jSONObject8.put("download_type", aj());
            jSONObject8.put("auto_control", k());
            jSONObject8.put("if_suspend_download", v());
            jSONObject8.put("dl_popup", y());
            jSONObject8.put("market_popup", z());
            jSONObject8.put("if_pop_lp", A());
            jSONObject.put("download_conf", jSONObject8);
            if (ae() != null) {
                JSONObject jSONObject9 = new JSONObject();
                Set<Map.Entry<String, Object>> entrySet = ae().entrySet();
                if (entrySet != null && !entrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : entrySet) {
                        jSONObject9.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("media_ext", jSONObject9);
            }
            a B = B();
            if (B != null) {
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("id", B.b());
                jSONObject10.put("md5", B.c());
                jSONObject10.put("url", B.d());
                jSONObject10.put("data", B.e());
                jSONObject10.put("diff_data", B.f());
                jSONObject10.put("version", B.a());
                jSONObject10.put("dynamic_creative", B.g());
                jSONObject.put("tpl_info", jSONObject10);
            }
            jSONObject.put("market_url", ag());
            c D = D();
            if (D != null) {
                JSONObject jSONObject11 = new JSONObject();
                jSONObject11.put("developer_name", D.c());
                jSONObject11.put("app_version", D.b());
                jSONObject11.put("permissions", D.e());
                jSONObject11.put("privacy_policy_url", D.d());
                jSONObject11.put("package_name", D.f());
                jSONObject11.put("app_name", D.g());
                jSONObject.put("app_manage", jSONObject11);
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

    public static boolean b(l lVar) {
        return lVar != null && lVar.s() && lVar.c() == 1;
    }

    public static boolean c(l lVar) {
        return lVar != null && lVar.s() && lVar.c() == 0;
    }

    public static boolean d(l lVar) {
        try {
            return lVar.af().optInt("parent_type") == 1;
        } catch (Exception e) {
            Log.e("MaterialMeta", "isLuBanLandingPage error " + e);
            return false;
        }
    }

    public static boolean a(l lVar, boolean z, boolean z2) {
        if (lVar != null && lVar.x != null && lVar.x.a() == 1) {
            u.b("MaterialMeta", "can show end card follow js");
            return z2;
        }
        u.b("MaterialMeta", "can show end card follow js WebViewClient");
        return z;
    }

    public static boolean e(l lVar) {
        if (lVar == null || lVar.x == null) {
            return false;
        }
        return lVar.x.a() == 1;
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f6513a;

        /* renamed from: b  reason: collision with root package name */
        private String f6514b;
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
            return this.f6513a;
        }

        public void b(String str) {
            this.f6513a = str;
        }

        public String c() {
            return this.f6514b;
        }

        public void c(String str) {
            this.f6514b = str;
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
