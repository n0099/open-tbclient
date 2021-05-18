package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.util.AdExtParam;
import d.a.j0.g0.b.d;
import d.a.j0.g0.b.g;
import d.a.j0.z0.w;
import d.a.k0.s2.g0.a;
import d.a.k0.s2.i0.b;
import java.util.HashMap;
import tbclient.FrsPage.AdParam;
import tbclient.FrsPage.DataReq;
import tbclient.FrsPage.FrsPageReqIdl;
/* loaded from: classes5.dex */
public class FrsRequestData extends OrmObject implements g, d {
    public static final String CATEGORY_ID_KEY = "categoryid";
    public static final int FRS_SMARTLOAD_TYPE_BY_REFRESH = 1;
    public static final int FRS_SMART_LOAD_TYPE_BY_MORE = 2;
    public static final int FRS_SORT_TYPE_BY_LIKED_SORT = 4;
    public static final int FRS_SORT_TYPE_BY_LIKE_USER = 2;
    public static final int FRS_SORT_TYPE_BY_REPLY_TIME = 0;
    public static final int FRS_SORT_TYPE_BY_SEND_TYPE = 1;
    public static final int FRS_SORT_TYPE_BY_SMART_SORT = 3;
    public static final int FRS_SORT_TYPE_DEFAULT_VALUE = -1;
    public static final int IS_GOOD = 1;
    public static final int IS_NOT_GOOD = 0;
    public static final int THREAD_NUM_LOAD = 30;
    public static final int THREAD_NUM_PAGE = 90;
    public int C;
    public int D;
    public String E;
    public String F;

    /* renamed from: e  reason: collision with root package name */
    public int f20834e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20835f;

    /* renamed from: g  reason: collision with root package name */
    public String f20836g;

    /* renamed from: h  reason: collision with root package name */
    public int f20837h;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public double p;
    public int q;
    public String r;
    public String s;
    public int t;
    public int v;
    public int w;
    public int x;
    public int y;
    public long z;

    /* renamed from: i  reason: collision with root package name */
    public int f20838i = 90;
    public int j = 30;
    public String u = "";
    public int A = -1;
    public int B = 1;
    public int G = 0;
    public int H = 0;
    public HashMap<String, String> I = null;
    public long J = 0;
    public int K = 0;
    public String L = "";
    public int M = -1;
    public String N = "";

    public void A(int i2) {
        this.m = i2;
    }

    public void B(int i2) {
        this.w = i2;
    }

    public void C(int i2) {
        this.x = i2;
    }

    public void D(int i2) {
        this.M = i2;
    }

    public void E(long j) {
        this.J = j;
    }

    public void F(int i2) {
        this.K = i2;
    }

    public void G(int i2) {
        this.l = i2;
    }

    public void H(int i2) {
        this.G = i2;
    }

    public void I(String str) {
        this.f20836g = str;
    }

    public void J(long j) {
        this.z = j;
    }

    public void K(String str) {
        this.s = str;
    }

    public void L(int i2) {
        this.C = i2;
    }

    public void M(int i2) {
        this.B = i2;
    }

    public void N(int i2) {
        this.y = i2;
    }

    public void O(String str) {
        this.E = str;
    }

    public void P(String str) {
        this.F = str;
    }

    public void Q(int i2) {
        this.D = i2;
    }

    public void R(String str) {
        this.L = str;
    }

    public void S(double d2) {
        this.p = d2;
    }

    public void T(int i2) {
        this.o = i2;
    }

    public void U(int i2) {
        this.n = i2;
    }

    public void V(int i2) {
        this.k = i2;
    }

    public void W(String str) {
        this.u = str;
    }

    public void X(int i2) {
        this.q = i2;
    }

    @Override // d.a.j0.g0.b.i
    public Object c(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.kw = this.f20836g;
        builder.pn = Integer.valueOf(this.f20837h);
        builder.rn = Integer.valueOf(this.f20838i);
        builder.rn_need = Integer.valueOf(this.j);
        builder.with_group = Integer.valueOf(this.k);
        builder.is_good = Integer.valueOf(this.l);
        builder.cid = Integer.valueOf(this.m);
        builder.scr_w = Integer.valueOf(this.n);
        builder.scr_h = Integer.valueOf(this.o);
        builder.scr_dip = Double.valueOf(this.p);
        builder.st_type = this.r;
        builder.q_type = Integer.valueOf(this.q);
        builder.st_param = Integer.valueOf(this.v);
        builder.ctime = Integer.valueOf(this.w);
        builder.data_size = Integer.valueOf(this.x);
        builder.net_error = Integer.valueOf(this.y);
        builder.lastids = this.s;
        builder.category_id = Integer.valueOf(this.t);
        builder.yuelaou_locate = this.u;
        builder.sort_type = Integer.valueOf(this.A);
        builder.last_click_tid = Long.valueOf(this.z);
        builder.app_pos = a.e().a();
        builder.load_type = Integer.valueOf(this.B);
        builder.obj_locate = this.E;
        builder.obj_source = this.F;
        builder.is_selection = Integer.valueOf(this.G);
        builder.call_from = Integer.valueOf(this.H);
        builder.hot_thread_id = Long.valueOf(this.J);
        AdParam.Builder builder2 = new AdParam.Builder();
        builder2.refresh_count = Integer.valueOf(this.D);
        builder2.load_count = Integer.valueOf(this.C);
        builder2.yoga_lib_version = "";
        builder.ad_param = builder2.build(false);
        builder.is_default_navtab = Integer.valueOf(this.K);
        builder.ad_context_list = this.B != 1 ? b.f().d("FRS") : "";
        builder.up_schema = this.L;
        builder.default_sort_type = Integer.valueOf(this.M);
        AdExtParam.a b2 = AdExtParam.a.b();
        b2.e(this.N);
        builder.ad_ext_params = b2.a();
        w.c(builder, true, false, true);
        FrsPageReqIdl.Builder builder3 = new FrsPageReqIdl.Builder();
        builder3.data = builder.build(false);
        return builder3.build(false);
    }

    @Override // d.a.j0.g0.b.c
    public String getCacheKey() {
        return null;
    }

    public int getCid() {
        return this.m;
    }

    public int getPn() {
        return this.f20837h;
    }

    public int getUpdateType() {
        return this.f20834e;
    }

    @Override // d.a.j0.g0.b.d
    public boolean i() {
        return false;
    }

    public boolean isNeedCache() {
        return this.f20835f;
    }

    @Override // d.a.j0.g0.b.d
    public boolean isNeedUid() {
        return false;
    }

    @Override // d.a.j0.g0.b.f
    public HashMap<String, Object> o() {
        return null;
    }

    @Override // d.a.j0.g0.b.f
    public HashMap<String, String> q() {
        return this.I;
    }

    @Override // d.a.j0.g0.b.d
    public String r() {
        return null;
    }

    public void s(String str, String str2) {
        if (this.I == null) {
            this.I = new HashMap<>();
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.I.put(str, str2);
    }

    public void setCallFrom(int i2) {
        this.H = i2;
    }

    public void setNeedCache(boolean z) {
        this.f20835f = z;
    }

    public void setPn(int i2) {
        this.f20837h = i2;
    }

    public void setSortType(int i2) {
        this.A = i2;
    }

    public void setStType(String str) {
        this.r = str;
    }

    public void setUpdateType(int i2) {
        this.f20834e = i2;
    }

    public int t() {
        return this.t;
    }

    public int u() {
        return this.l;
    }

    public String v() {
        return this.f20836g;
    }

    public int w() {
        return this.B;
    }

    public int x() {
        return this.A;
    }

    public void y(String str) {
        this.N = str;
    }

    public void z(int i2) {
        this.t = i2;
    }
}
