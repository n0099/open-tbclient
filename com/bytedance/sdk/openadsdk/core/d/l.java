package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class l {
    public boolean A;
    public boolean B;
    public h C;
    public Map<String, Object> D;
    public a E;
    public a F;
    public boolean G;
    public int H;
    public String I;
    public PersonalizationPrompt N;
    public AdSlot R;
    public int S;
    public String U;
    public JSONObject Y;

    /* renamed from: a  reason: collision with root package name */
    public String f28719a;
    public int aa;
    public q af;
    public n ag;
    public c ah;
    public String ai;

    /* renamed from: b  reason: collision with root package name */
    public int f28720b;

    /* renamed from: c  reason: collision with root package name */
    public k f28721c;

    /* renamed from: d  reason: collision with root package name */
    public k f28722d;

    /* renamed from: e  reason: collision with root package name */
    public String f28723e;

    /* renamed from: g  reason: collision with root package name */
    public String f28725g;

    /* renamed from: i  reason: collision with root package name */
    public String f28727i;
    public String l;
    public String m;
    public String n;
    public b p;
    public g q;
    public int r;
    public String s;
    public String t;
    public long w;
    public int x;
    public v y;
    public boolean z;

    /* renamed from: f  reason: collision with root package name */
    public int f28724f = -1;

    /* renamed from: h  reason: collision with root package name */
    public List<k> f28726h = new ArrayList();
    public List<String> j = new ArrayList();
    public List<String> k = new ArrayList();
    public String o = "0";
    public List<FilterWord> u = new ArrayList();
    public int v = 0;
    public String J = "";
    public String K = "";
    public int L = 0;
    public int M = 2;
    public int O = -200;
    public int P = 0;
    public e Q = new e();
    public int T = 1;
    public int V = 0;
    public int W = 0;
    public int X = 0;
    public int Z = 1;
    public int ab = 0;
    public int ac = 0;
    public int ad = 0;
    public int ae = 1;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f28728a;

        /* renamed from: b  reason: collision with root package name */
        public String f28729b;

        /* renamed from: c  reason: collision with root package name */
        public String f28730c;

        /* renamed from: d  reason: collision with root package name */
        public String f28731d;

        /* renamed from: e  reason: collision with root package name */
        public String f28732e;

        /* renamed from: f  reason: collision with root package name */
        public String f28733f;

        /* renamed from: g  reason: collision with root package name */
        public String f28734g;

        public String a() {
            return this.f28733f;
        }

        public String b() {
            return this.f28728a;
        }

        public String c() {
            return this.f28729b;
        }

        public String d() {
            return this.f28730c;
        }

        public String e() {
            return this.f28731d;
        }

        public String f() {
            return this.f28732e;
        }

        public String g() {
            return this.f28734g;
        }

        public void a(String str) {
            this.f28733f = str;
        }

        public void b(String str) {
            this.f28728a = str;
        }

        public void c(String str) {
            this.f28729b = str;
        }

        public void d(String str) {
            this.f28730c = str;
        }

        public void e(String str) {
            this.f28731d = str;
        }

        public void f(String str) {
            this.f28732e = str;
        }

        public void g(String str) {
            this.f28734g = str;
        }
    }

    public static boolean a(l lVar) {
        return lVar != null && lVar.a() == 1;
    }

    public boolean A() {
        v vVar = this.y;
        return vVar == null || vVar.n() != 1;
    }

    public boolean B() {
        v vVar = this.y;
        return vVar != null && vVar.o() == 1;
    }

    public boolean C() {
        return this.G;
    }

    public boolean D() {
        return C() && i() == 1;
    }

    public boolean E() {
        return F() == 1;
    }

    public int F() {
        h hVar = this.C;
        if (hVar == null) {
            return 1;
        }
        return hVar.a();
    }

    public int G() {
        h hVar = this.C;
        if (hVar == null) {
            return 1;
        }
        return hVar.c();
    }

    public int H() {
        h hVar = this.C;
        if (hVar == null) {
            return 0;
        }
        return hVar.d();
    }

    public int I() {
        h hVar = this.C;
        if (hVar == null) {
            return 0;
        }
        return hVar.k();
    }

    public int J() {
        h hVar = this.C;
        if (hVar == null) {
            return 1;
        }
        return hVar.f();
    }

    public int K() {
        h hVar = this.C;
        if (hVar == null) {
            return 1;
        }
        return hVar.g();
    }

    public int L() {
        h hVar = this.C;
        if (hVar == null) {
            return 1;
        }
        return hVar.h();
    }

    public int M() {
        q qVar = this.af;
        if (qVar == null) {
            return 1;
        }
        return qVar.a();
    }

    public String N() {
        q qVar = this.af;
        return qVar == null ? "" : qVar.b();
    }

    public int O() {
        q qVar = this.af;
        if (qVar == null) {
            return 50;
        }
        return qVar.c();
    }

    public int P() {
        q qVar = this.af;
        if (qVar == null) {
            return 236;
        }
        return qVar.d();
    }

    public int Q() {
        q qVar = this.af;
        if (qVar == null) {
            return 82;
        }
        return qVar.e();
    }

    public int R() {
        q qVar = this.af;
        if (qVar == null) {
            return 56;
        }
        return qVar.f();
    }

    public a S() {
        return this.E;
    }

    public a T() {
        return this.F;
    }

    public h U() {
        return this.C;
    }

    public c V() {
        return this.ah;
    }

    public String W() {
        return this.ai;
    }

    public v X() {
        return this.y;
    }

    public String Y() {
        return this.s;
    }

    public int Z() {
        return this.f28720b;
    }

    public String aA() {
        return this.U;
    }

    public int aB() {
        return this.ab;
    }

    public boolean aC() {
        return aB() == 1;
    }

    public boolean aD() {
        return aE() == 1;
    }

    public int aE() {
        return this.ac;
    }

    public String aF() {
        return this.f28719a;
    }

    public int aG() {
        return this.ae;
    }

    public boolean aH() {
        if (this.f28726h.isEmpty()) {
            return false;
        }
        if (this.r != 4 || this.f28726h.size() >= 3) {
            for (k kVar : this.f28726h) {
                if (!kVar.e()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int aI() {
        h hVar = this.C;
        if (hVar == null) {
            return -1;
        }
        return hVar.b();
    }

    public boolean aJ() {
        return aK() == 1;
    }

    public int aK() {
        return this.v;
    }

    public JSONObject aL() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("interaction_type", Z());
            jSONObject.put("target_url", ac());
            jSONObject.put("use_media_video_player", a());
            jSONObject.put("landing_scroll_percentage", ad());
            jSONObject.put("gecko_id", ae());
            jSONObject.put(LegoListActivityConfig.AD_ID, am());
            jSONObject.put("source", Y());
            jSONObject.put("package_name", aF());
            jSONObject.put("screenshot", av());
            jSONObject.put("dislike_control", aK());
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
            k aa = aa();
            if (aa != null && !TextUtils.isEmpty(aa.a())) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("url", aa.a());
                jSONObject3.put("height", aa.c());
                jSONObject3.put("width", aa.b());
                jSONObject.put("icon", jSONObject3);
            }
            k ab = ab();
            if (ab != null && !TextUtils.isEmpty(ab.a())) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("url", ab.a());
                jSONObject4.put("height", ab.c());
                jSONObject4.put("width", ab.b());
                jSONObject.put("cover_image", jSONObject4);
            }
            Object az = az();
            if (az != null) {
                jSONObject.put("session_params", az);
            }
            e o = o();
            if (o != null) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("click_upper_content_area", o.f28659a);
                jSONObject5.put("click_upper_non_content_area", o.f28660b);
                jSONObject5.put("click_lower_content_area", o.f28661c);
                jSONObject5.put("click_lower_non_content_area", o.f28662d);
                jSONObject5.put("click_button_area", o.f28663e);
                jSONObject5.put("click_video_area", o.f28664f);
                jSONObject.put("click_area", jSONObject5);
            }
            AdSlot p = p();
            if (p != null) {
                jSONObject.put("adslot", p.toJsonObj());
            }
            List<k> af = af();
            if (af != null) {
                JSONArray jSONArray = new JSONArray();
                for (k kVar : af) {
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("url", kVar.a());
                    jSONObject6.put("height", kVar.c());
                    jSONObject6.put("width", kVar.b());
                    jSONArray.put(jSONObject6);
                }
                jSONObject.put("image", jSONArray);
            }
            List<String> ah = ah();
            if (ah != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str : ah) {
                    jSONArray2.put(str);
                }
                jSONObject.put("show_url", jSONArray2);
            }
            List<String> ai = ai();
            if (ai != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (String str2 : ai) {
                    jSONArray3.put(str2);
                }
                jSONObject.put("click_url", jSONArray3);
            }
            jSONObject.put(Oauth2AccessToken.KEY_PHONE_NUM, ag());
            jSONObject.put("title", aj());
            jSONObject.put("description", ak());
            jSONObject.put("ext", ap());
            jSONObject.put("image_mode", aq());
            jSONObject.put("is_playable", C());
            jSONObject.put("intercept_flag", v());
            jSONObject.put("button_text", al());
            jSONObject.put("ad_logo", m());
            jSONObject.put("video_adaptation", l());
            jSONObject.put("feed_video_opentype", k());
            b an = an();
            if (an != null) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put(DpStatConstants.KEY_APP_NAME, an.c());
                jSONObject7.put("package_name", an.d());
                jSONObject7.put("download_url", an.b());
                jSONObject7.put("score", an.e());
                jSONObject7.put("comment_num", an.f());
                jSONObject7.put("quick_app_url", an.a());
                jSONObject7.put("app_size", an.g());
                jSONObject.put("app", jSONObject7);
            }
            g ao = ao();
            if (ao != null) {
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("deeplink_url", ao.a());
                jSONObject8.put("fallback_url", ao.b());
                jSONObject8.put("fallback_type", ao.c());
                jSONObject.put("deep_link", jSONObject8);
            }
            List<FilterWord> ar = ar();
            if (ar != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (FilterWord filterWord : ar) {
                    JSONObject b2 = b(filterWord);
                    if (b2 != null) {
                        jSONArray4.put(b2);
                    }
                }
                jSONObject.put("filter_words", jSONArray4);
            }
            PersonalizationPrompt as = as();
            if (as != null) {
                jSONObject.put("personalization_prompts", as.toJson());
            }
            jSONObject.put("count_down", au());
            jSONObject.put("expiration_time", at());
            v X = X();
            if (X != null) {
                jSONObject.put("video", X.m());
            }
            JSONObject jSONObject9 = new JSONObject();
            jSONObject9.put("auto_open", G());
            jSONObject9.put("download_mode", H());
            jSONObject9.put("download_type", aI());
            jSONObject9.put("auto_control", r());
            jSONObject9.put("auto_control_choose", t());
            jSONObject9.put("auto_control_time", u());
            jSONObject9.put("if_suspend_download", F());
            jSONObject9.put("if_send_click", I());
            jSONObject9.put("dl_popup", J());
            jSONObject9.put("market_popup", K());
            jSONObject9.put("if_pop_lp", L());
            jSONObject.put("download_conf", jSONObject9);
            jSONObject.put("if_both_open", aB());
            jSONObject.put("if_double_deeplink", aE());
            Object jSONObject10 = new JSONObject();
            jSONObject9.put("splash_clickarea", M());
            jSONObject9.put("splash_clicktext", N());
            jSONObject9.put("area_height", O());
            jSONObject9.put("area_width", P());
            jSONObject9.put("area_blank_height", Q());
            jSONObject9.put("half_blank_height", R());
            jSONObject.put("splash_control", jSONObject10);
            if (ay() != null) {
                JSONObject jSONObject11 = new JSONObject();
                Set<Map.Entry<String, Object>> entrySet = ay().entrySet();
                if (entrySet != null && !entrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : entrySet) {
                        jSONObject11.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("media_ext", jSONObject11);
            }
            jSONObject.put("landing_page_type", aG());
            a S = S();
            if (S != null) {
                JSONObject jSONObject12 = new JSONObject();
                jSONObject12.put("id", S.b());
                jSONObject12.put(PackageTable.MD5, S.c());
                jSONObject12.put("url", S.d());
                jSONObject12.put("data", S.e());
                jSONObject12.put("diff_data", S.f());
                jSONObject12.put("version", S.a());
                jSONObject12.put("dynamic_creative", S.g());
                jSONObject.put("tpl_info", jSONObject12);
            }
            a T = T();
            if (T != null) {
                JSONObject jSONObject13 = new JSONObject();
                jSONObject13.put("middle_id", T.b());
                jSONObject13.put("middle_md5", T.c());
                jSONObject13.put("middle_url", T.d());
                jSONObject13.put("middle_data", T.e());
                jSONObject13.put("middle_diff_data", T.f());
                jSONObject13.put("middle_version", T.a());
                jSONObject13.put("middle_dynamic_creative", T.g());
                jSONObject.put("middle_tpl_info", jSONObject13);
            }
            jSONObject.put("market_url", aA());
            c V = V();
            if (V != null) {
                JSONObject jSONObject14 = new JSONObject();
                jSONObject14.put("developer_name", V.c());
                jSONObject14.put("app_version", V.b());
                jSONObject14.put("permissions", V.e());
                jSONObject14.put("privacy_policy_url", V.d());
                jSONObject14.put("package_name", V.f());
                jSONObject14.put(DpStatConstants.KEY_APP_NAME, V.g());
                jSONObject.put("app_manage", jSONObject14);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public k aa() {
        return this.f28721c;
    }

    public k ab() {
        return this.f28722d;
    }

    public String ac() {
        return this.f28723e;
    }

    public int ad() {
        return this.f28724f;
    }

    public String ae() {
        return this.f28725g;
    }

    public List<k> af() {
        return this.f28726h;
    }

    public String ag() {
        return this.f28727i;
    }

    public List<String> ah() {
        return this.j;
    }

    public List<String> ai() {
        return this.k;
    }

    public String aj() {
        return this.l;
    }

    public String ak() {
        return this.m;
    }

    public String al() {
        return this.n;
    }

    public String am() {
        return this.o;
    }

    public b an() {
        return this.p;
    }

    public g ao() {
        return this.q;
    }

    public String ap() {
        return this.t;
    }

    public int aq() {
        return this.r;
    }

    public List<FilterWord> ar() {
        return this.u;
    }

    public PersonalizationPrompt as() {
        return this.N;
    }

    public long at() {
        return this.w;
    }

    public int au() {
        return this.x;
    }

    public boolean av() {
        return this.z;
    }

    public boolean aw() {
        return this.A;
    }

    public boolean ax() {
        return this.B;
    }

    public Map<String, Object> ay() {
        return this.D;
    }

    public JSONObject az() {
        return this.Y;
    }

    public String b() {
        return this.K;
    }

    public int c() {
        return this.L;
    }

    public int d() {
        return this.M;
    }

    public int e() {
        return this.V;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.o.equals(lVar.o) && this.t.equals(lVar.t);
    }

    public boolean f() {
        return this.V == 1;
    }

    public JSONObject g() {
        n nVar = this.ag;
        if (nVar == null) {
            return null;
        }
        return nVar.b();
    }

    public n h() {
        return this.ag;
    }

    public int hashCode() {
        return (this.o.hashCode() * 31) + this.t.hashCode();
    }

    public int i() {
        return this.H;
    }

    public String j() {
        return this.I;
    }

    public int k() {
        return this.X;
    }

    public int l() {
        return this.W;
    }

    public int m() {
        return this.T;
    }

    public int n() {
        return this.P;
    }

    public e o() {
        return this.Q;
    }

    public AdSlot p() {
        return this.R;
    }

    public boolean q() {
        return r() == 1;
    }

    public int r() {
        h hVar = this.C;
        if (hVar == null) {
            return 0;
        }
        return hVar.e();
    }

    public boolean s() {
        return t() == 1;
    }

    public int t() {
        h hVar = this.C;
        if (hVar == null) {
            return 0;
        }
        return hVar.i();
    }

    public int u() {
        h hVar = this.C;
        if (hVar == null) {
            return 300;
        }
        return hVar.j();
    }

    public int v() {
        return this.S;
    }

    public int w() {
        return this.O;
    }

    public int x() {
        return this.Z;
    }

    public String y() {
        return this.J;
    }

    public int z() {
        return this.aa;
    }

    public int a() {
        return this.ad;
    }

    public void b(int i2) {
        this.L = i2;
    }

    public void c(int i2) {
        this.M = i2;
    }

    public void d(int i2) {
        this.V = i2;
    }

    public void e(int i2) {
        this.H = i2;
    }

    public void f(int i2) {
        this.X = i2;
    }

    public void h(int i2) {
        this.T = i2;
    }

    public void i(int i2) {
        this.P = i2;
    }

    public void j(int i2) {
        this.S = i2;
    }

    public void k(int i2) {
        this.O = i2;
    }

    public void l(int i2) {
        this.Z = i2;
    }

    public void m(int i2) {
        this.aa = i2;
    }

    public void n(int i2) {
        this.f28720b = i2;
    }

    public void o(int i2) {
        this.f28724f = i2;
    }

    public void p(int i2) {
        this.r = i2;
    }

    public void q(int i2) {
        this.x = i2;
    }

    public void r(int i2) {
        this.ab = i2;
    }

    public void s(int i2) {
        this.ac = i2;
    }

    public void t(int i2) {
        this.ae = i2;
    }

    public void u(int i2) {
        this.v = i2;
    }

    public void a(int i2) {
        this.ad = i2;
    }

    public void b(String str) {
        this.I = str;
    }

    public void c(String str) {
        this.J = str;
    }

    public void d(String str) {
        this.ai = str;
    }

    public void e(String str) {
        this.s = str;
    }

    public void f(String str) {
        this.f28723e = str;
    }

    public void g(int i2) {
        this.W = i2;
    }

    public void h(String str) {
        this.f28727i = str;
    }

    public void i(String str) {
        this.l = str;
    }

    public void j(String str) {
        this.m = str;
    }

    public void k(String str) {
        this.n = str;
    }

    public void l(String str) {
        this.o = str;
    }

    public void m(String str) {
        this.t = str;
    }

    public void n(String str) {
        this.U = str;
    }

    public void o(String str) {
        this.f28719a = str;
    }

    public static boolean b(l lVar) {
        return lVar != null && lVar.C();
    }

    public static boolean e(l lVar) {
        return lVar != null && lVar.C() && lVar.i() == 0;
    }

    public static boolean f(l lVar) {
        try {
            return lVar.az().optInt("parent_type") == 1;
        } catch (Exception e2) {
            Log.e("MaterialMeta", "isLuBanLandingPage error " + e2);
            return false;
        }
    }

    public void a(String str) {
        this.K = str;
    }

    public void c(k kVar) {
        this.f28726h.add(kVar);
    }

    public void d(boolean z) {
        this.B = z;
    }

    public void g(String str) {
        this.f28725g = str;
    }

    public static boolean d(l lVar) {
        return lVar != null && lVar.C() && lVar.i() == 1;
    }

    public static boolean g(l lVar) {
        v vVar;
        return (lVar == null || (vVar = lVar.y) == null || vVar.a() != 1) ? false : true;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.ag = n.a(jSONObject);
    }

    public void b(a aVar) {
        this.F = aVar;
        com.bytedance.sdk.openadsdk.core.widget.webview.d.a().b();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b(this);
    }

    public void c(boolean z) {
        this.A = z;
    }

    public void a(e eVar) {
        this.Q = eVar;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f28720b = 4;
        this.o = jSONObject.optString("id");
        this.s = jSONObject.optString("source");
        b bVar = new b();
        this.p = bVar;
        bVar.d(jSONObject.optString(EmotionResourceInfo.JSON_KEY_PKG_NAME));
        this.p.c(jSONObject.optString("name"));
        this.p.b(jSONObject.optString("download_url"));
    }

    public void a(AdSlot adSlot) {
        this.R = adSlot;
    }

    public void a(boolean z) {
        this.G = z;
    }

    public void b(k kVar) {
        this.f28722d = kVar;
    }

    public void a(a aVar) {
        this.E = aVar;
        com.bytedance.sdk.openadsdk.core.widget.webview.d.a().b();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(this);
    }

    public void b(boolean z) {
        this.z = z;
    }

    public void b(JSONObject jSONObject) {
        this.Y = jSONObject;
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
        } catch (Throwable unused) {
        }
        return null;
    }

    public void a(h hVar) {
        this.C = hVar;
    }

    public static boolean c(l lVar) {
        if (lVar == null) {
            return false;
        }
        return lVar.aq() == 5 || lVar.aq() == 15;
    }

    public void a(q qVar) {
        this.af = qVar;
    }

    public void a(c cVar) {
        this.ah = cVar;
    }

    public void a(v vVar) {
        this.y = vVar;
    }

    public void a(k kVar) {
        this.f28721c = kVar;
    }

    public void a(b bVar) {
        this.p = bVar;
    }

    public void a(g gVar) {
        this.q = gVar;
    }

    public void a(FilterWord filterWord) {
        this.u.add(filterWord);
    }

    public void a(PersonalizationPrompt personalizationPrompt) {
        this.N = personalizationPrompt;
    }

    public void a(long j) {
        this.w = j;
    }

    public void a(Map<String, Object> map) {
        this.D = map;
    }

    public static boolean a(l lVar, boolean z, boolean z2) {
        v vVar;
        if (lVar != null && (vVar = lVar.y) != null && vVar.a() == 1) {
            com.bytedance.sdk.openadsdk.utils.u.b("MaterialMeta", "can show end card follow js");
            return z2;
        }
        com.bytedance.sdk.openadsdk.utils.u.b("MaterialMeta", "can show end card follow js WebViewClient");
        return z;
    }
}
