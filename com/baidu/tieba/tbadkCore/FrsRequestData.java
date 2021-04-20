package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.util.AdExtParam;
import d.b.h0.g0.b.d;
import d.b.h0.g0.b.g;
import d.b.h0.z0.w;
import d.b.i0.s2.d0.a;
import d.b.i0.s2.f0.b;
import java.util.HashMap;
import tbclient.FrsPage.AdParam;
import tbclient.FrsPage.DataReq;
import tbclient.FrsPage.FrsPageReqIdl;
/* loaded from: classes3.dex */
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
    public int f21001e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21002f;

    /* renamed from: g  reason: collision with root package name */
    public String f21003g;

    /* renamed from: h  reason: collision with root package name */
    public int f21004h;
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
    public int i = 90;
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

    public void A(int i) {
        this.m = i;
    }

    public void B(int i) {
        this.w = i;
    }

    public void C(int i) {
        this.x = i;
    }

    public void D(int i) {
        this.M = i;
    }

    public void E(long j) {
        this.J = j;
    }

    public void F(int i) {
        this.K = i;
    }

    public void G(int i) {
        this.l = i;
    }

    public void H(int i) {
        this.G = i;
    }

    public void I(String str) {
        this.f21003g = str;
    }

    public void J(long j) {
        this.z = j;
    }

    public void K(String str) {
        this.s = str;
    }

    public void L(int i) {
        this.C = i;
    }

    public void M(int i) {
        this.B = i;
    }

    public void N(int i) {
        this.y = i;
    }

    public void O(String str) {
        this.E = str;
    }

    public void P(String str) {
        this.F = str;
    }

    public void Q(int i) {
        this.D = i;
    }

    public void R(String str) {
        this.L = str;
    }

    public void S(double d2) {
        this.p = d2;
    }

    public void T(int i) {
        this.o = i;
    }

    public void U(int i) {
        this.n = i;
    }

    public void V(int i) {
        this.k = i;
    }

    public void W(String str) {
        this.u = str;
    }

    public void X(int i) {
        this.q = i;
    }

    @Override // d.b.h0.g0.b.i
    public Object e(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.kw = this.f21003g;
        builder.pn = Integer.valueOf(this.f21004h);
        builder.rn = Integer.valueOf(this.i);
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

    @Override // d.b.h0.g0.b.c
    public String getCacheKey() {
        return null;
    }

    public int getCid() {
        return this.m;
    }

    public int getPn() {
        return this.f21004h;
    }

    public int getUpdateType() {
        return this.f21001e;
    }

    public boolean isNeedCache() {
        return this.f21002f;
    }

    @Override // d.b.h0.g0.b.d
    public boolean isNeedUid() {
        return false;
    }

    @Override // d.b.h0.g0.b.f
    public HashMap<String, Object> k() {
        return null;
    }

    @Override // d.b.h0.g0.b.f
    public HashMap<String, String> p() {
        return this.I;
    }

    @Override // d.b.h0.g0.b.d
    public String q() {
        return null;
    }

    @Override // d.b.h0.g0.b.d
    public boolean r() {
        return false;
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

    public void setCallFrom(int i) {
        this.H = i;
    }

    public void setNeedCache(boolean z) {
        this.f21002f = z;
    }

    public void setPn(int i) {
        this.f21004h = i;
    }

    public void setSortType(int i) {
        this.A = i;
    }

    public void setStType(String str) {
        this.r = str;
    }

    public void setUpdateType(int i) {
        this.f21001e = i;
    }

    public int t() {
        return this.t;
    }

    public int u() {
        return this.l;
    }

    public String v() {
        return this.f21003g;
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

    public void z(int i) {
        this.t = i;
    }
}
