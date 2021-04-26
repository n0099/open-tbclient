package com.baidu.tieba.pb.videopb.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbChildTitleViewHolder;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.i0.r.f0.f;
import d.a.i0.r.q.a2;
import d.a.j0.d2.k.e.m0;
import d.a.j0.d2.p.e;
import d.a.j0.d3.h0.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements d.a.j0.d2.o.h, e.b {
    public int C;
    public ViewTreeObserver.OnGlobalLayoutListener E;
    public boolean F;

    /* renamed from: e  reason: collision with root package name */
    public PbActivity f20250e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPbFragment f20251f;

    /* renamed from: g  reason: collision with root package name */
    public View f20252g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f20253h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayoutManager f20254i;
    public d.a.j0.d2.o.m.b j;
    public d.a.j0.d2.o.n.b k;
    public View o;
    public boolean t;
    public LinearLayout u;
    public PbReplyTitleViewHolder v;
    public PbChildTitleViewHolder w;
    public BdSwipeRefreshLayout x;
    public PbListView l = null;
    public View m = null;
    public d.a.j0.d2.p.e n = null;
    public boolean p = false;
    public boolean q = false;
    public boolean r = true;
    public int s = 0;
    public d.a.i0.r.f0.g y = null;
    public boolean z = false;
    public int A = 0;
    public int B = 0;
    public boolean D = false;
    public RecyclerView.OnScrollListener G = new a();
    public final f.g H = new b();
    public CustomMessageListener I = new c(2016331);
    public final BdListView.p J = new g();

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 1) {
                DetailInfoAndReplyFragment.this.w().j4();
                DetailInfoAndReplyFragment.this.w().l4();
            }
            if (DetailInfoAndReplyFragment.this.w() != null) {
                DetailInfoAndReplyFragment.this.w().W3(i2);
            }
            if (i2 == 0) {
                DetailInfoAndReplyFragment.this.o1(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            DetailInfoAndReplyFragment.this.j1();
            if (recyclerView.canScrollVertically(-1)) {
                DetailInfoAndReplyFragment.this.A = 2;
                return;
            }
            if (Math.abs(i3) > 0 && DetailInfoAndReplyFragment.this.A != 0) {
                DetailInfoAndReplyFragment.this.o.setVisibility(8);
            }
            DetailInfoAndReplyFragment.this.A = 0;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.a.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (DetailInfoAndReplyFragment.this.z() != null && DetailInfoAndReplyFragment.this.z().l1(true)) {
                TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                DetailInfoAndReplyFragment.this.U0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || DetailInfoAndReplyFragment.this.z() == null || DetailInfoAndReplyFragment.this.z().y0() == null || DetailInfoAndReplyFragment.this.z().y0().D() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            o oVar = null;
            Iterator<PostData> it = DetailInfoAndReplyFragment.this.z().y0().D().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PostData next = it.next();
                if (next instanceof o) {
                    o oVar2 = (o) next;
                    if (str.equals(oVar2.C0())) {
                        oVar = oVar2;
                        break;
                    }
                }
            }
            if (oVar == null || DetailInfoAndReplyFragment.this.j == null || DetailInfoAndReplyFragment.this.f20253h == null) {
                return;
            }
            DetailInfoAndReplyFragment.this.z().y0().D().remove(oVar);
            if (DetailInfoAndReplyFragment.this.j.a() != null) {
                DetailInfoAndReplyFragment.this.j.a().remove(oVar);
            }
            if (DetailInfoAndReplyFragment.this.f20253h.getListView2().getData() != null) {
                DetailInfoAndReplyFragment.this.f20253h.getListView2().getData().remove(oVar);
            }
            DetailInfoAndReplyFragment.this.j.r();
        }
    }

    /* loaded from: classes3.dex */
    public class d extends LinearLayoutManager {
        public d(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements ViewTreeObserver.OnGlobalLayoutListener {
        public e() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (DetailInfoAndReplyFragment.this.F || DetailInfoAndReplyFragment.this.w() == null) {
                return;
            }
            DetailInfoAndReplyFragment.this.F = true;
            DetailInfoAndReplyFragment.this.w().x2(DetailInfoAndReplyFragment.this.f20253h, false);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Observer<Boolean> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            if (bool != null && bool.booleanValue()) {
                DetailInfoAndReplyFragment.this.u1();
            } else {
                DetailInfoAndReplyFragment.this.n();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements BdListView.p {
        public g() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (DetailInfoAndReplyFragment.this.mIsLogin) {
                if (!DetailInfoAndReplyFragment.this.D && DetailInfoAndReplyFragment.this.S0() && DetailInfoAndReplyFragment.this.z() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", DetailInfoAndReplyFragment.this.z().O0());
                    statisticItem.param("fid", DetailInfoAndReplyFragment.this.z().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    DetailInfoAndReplyFragment.this.D = true;
                }
                if (DetailInfoAndReplyFragment.this.z().h1(false)) {
                    DetailInfoAndReplyFragment.this.s1();
                    if (DetailInfoAndReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (DetailInfoAndReplyFragment.this.z().y0() != null) {
                    DetailInfoAndReplyFragment.this.m1();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f20262e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f20263f;

        public h(boolean z, int i2) {
            this.f20262e = z;
            this.f20263f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f20262e) {
                DetailInfoAndReplyFragment.this.n1(this.f20263f, UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
        }
    }

    public static DetailInfoAndReplyFragment i1(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
        detailInfoAndReplyFragment.setArguments(bundle);
        detailInfoAndReplyFragment.f20251f = videoPbFragment;
        return detailInfoAndReplyFragment;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity A() {
        PbActivity pbActivity = this.f20250e;
        return pbActivity != null ? pbActivity : w().A();
    }

    public final void R0(boolean z, int i2, int i3, int i4, d.a.j0.d2.h.e eVar, String str, int i5, boolean z2) {
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(A()).get(VideoPbViewModel.class);
        if (!z || z() == null || eVar == null) {
            return;
        }
        this.z = z().M0();
        boolean isEnabled = this.x.isEnabled();
        boolean z3 = true;
        int i6 = 0;
        if (eVar.w().c() == 0 && this.z) {
            this.x.setEnabled(false);
        } else if (!isEnabled) {
            this.x.setEnabled(true);
            this.x.o();
        }
        this.j.w(videoPbViewModel.l());
        this.j.x(this.z);
        this.j.v(eVar, z2);
        this.p = false;
        if (TbadkCoreApplication.isLogin()) {
            this.f20253h.setNextPage(this.l);
            this.s = 2;
            if (w() != null && w().S != null) {
                this.f20251f.S.T();
            }
        } else {
            this.p = true;
            if (eVar.w().b() == 1) {
                if (this.n == null) {
                    d.a.j0.d2.p.e eVar2 = new d.a.j0.d2.p.e(this, this);
                    this.n = eVar2;
                    eVar2.a();
                    this.n.g();
                }
                this.f20253h.setNextPage(this.n);
            } else {
                this.f20253h.setNextPage(this.l);
            }
            this.s = 3;
        }
        if (this.v != null) {
            d.a.j0.d2.h.o oVar = new d.a.j0.d2.h.o(d.a.j0.d2.h.o.l);
            a2 L = eVar.L();
            if (L != null) {
                L.Z0();
            }
            z().M0();
            oVar.f52054h = h1();
            oVar.f52053g = eVar.f52021g;
            eVar.c();
            oVar.f52055i = eVar.a0();
            oVar.k = eVar.f52020f;
            this.v.h(oVar);
        }
        ArrayList<PostData> D = eVar.D();
        if (eVar.w().b() != 0 && D != null && D.size() >= eVar.w().e()) {
            if (z().i0()) {
                if (this.r) {
                    T0();
                    if (eVar.w().b() != 0) {
                        this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                    }
                } else {
                    this.l.x();
                    this.l.L();
                }
            } else {
                this.l.x();
                this.l.L();
            }
            this.l.j();
        } else {
            if (eVar.w().b() == 0) {
                this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
            } else {
                this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
            }
            this.l.j();
            if (eVar.w().b() == 0 || D == null) {
                m1();
            }
        }
        if (i3 == 2) {
            this.f20253h.setSelection(i4 > 1 ? (i4 + ((this.f20253h.getData() == null && eVar.D() == null) ? 0 : this.f20253h.getData().size() - eVar.D().size())) - 2 : 0);
        } else if (i3 != 3) {
            if (i3 == 4) {
                this.r = false;
            } else if (i3 == 5) {
                this.f20253h.setSelection(0);
            } else if (i3 == 6) {
                if (i5 == 1) {
                    Parcelable e2 = m0.b().e();
                    if (e2 instanceof RecyclerView.SavedState) {
                        this.f20253h.onRestoreInstanceState(e2);
                    }
                }
                this.f20253h.setSelection(0);
            } else if (i3 == 8) {
                this.f20253h.setSelection(i4 > 0 ? i4 + ((this.f20253h.getData() == null && eVar.D() == null) ? 0 : this.f20253h.getData().size() - eVar.D().size()) : 0);
                this.l.f();
                this.l.A(getString(R.string.pb_load_more_without_point));
                this.l.v();
            }
        } else if (i5 == 1) {
            Parcelable e3 = m0.b().e();
            if (e3 instanceof RecyclerView.SavedState) {
                this.f20253h.onRestoreInstanceState(e3);
                if (ListUtils.getCount(D) > 1 && eVar.w().b() > 0) {
                    this.l.f();
                    this.l.A(getString(R.string.pb_load_more_without_point));
                    this.l.v();
                }
            }
        }
        if (this.q) {
            l1();
            this.q = false;
            if (i5 == 0) {
                r1(true);
            }
        }
        w().e4(eVar);
        if (this.l != null) {
            if (eVar.w().b() == 0) {
                this.l.I(8);
            } else {
                this.l.I(0);
            }
        }
        if (ListUtils.getCount(this.j.a()) <= 0 || !videoPbViewModel.m()) {
            return;
        }
        videoPbViewModel.w(false);
        String b0 = z().b0();
        ArrayList<n> a2 = this.j.a();
        if (a2 != null) {
            if (!k.isEmpty(b0)) {
                for (int i7 = 0; i7 < a2.size(); i7++) {
                    if (a2.get(i7).getType() == PostData.p0 && b0.equals(((PostData) a2.get(i7)).E())) {
                        i6 = i7;
                        break;
                    }
                }
            } else {
                int i8 = 0;
                while (true) {
                    if (i8 >= a2.size()) {
                        break;
                    } else if (a2.get(i8).getType() == d.a.j0.d2.h.o.l) {
                        i6 = i8;
                        break;
                    } else {
                        i8++;
                    }
                }
            }
            z3 = false;
            if (i6 != 0) {
                d.a.c.e.m.e.a().post(new h(z3, i6));
            }
        }
    }

    public boolean S0() {
        PbListView pbListView = this.l;
        if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
            return false;
        }
        return this.l.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }

    public void T0() {
        PbListView pbListView = this.l;
        if (pbListView != null) {
            pbListView.v();
            this.l.f();
        }
        if (w() != null && w().S != null) {
            this.f20251f.S.T();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.FALSE));
    }

    public void U0() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.x;
        if (bdSwipeRefreshLayout == null || !bdSwipeRefreshLayout.isEnabled()) {
            return;
        }
        this.x.setRefreshing(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: V0 */
    public d.a.j0.d2.o.m.b E0() {
        return this.j;
    }

    public int W0() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f20253h;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getFirstVisiblePosition();
        }
        return 0;
    }

    public int X0() {
        View childAt;
        BdTypeRecyclerView bdTypeRecyclerView = this.f20253h;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.f20253h.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int Y0() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f20253h;
        if (bdTypeRecyclerView != null) {
            int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
            return (z() == null || z().y0() == null || lastVisiblePosition < z().y0().D().size()) ? lastVisiblePosition : z().y0().D().size() - 2;
        }
        return 0;
    }

    public BdTypeRecyclerView Z0() {
        return this.f20253h;
    }

    public int a1() {
        return this.B;
    }

    public View b1() {
        return this.m;
    }

    public int c1() {
        return this.A;
    }

    public d.a.j0.d2.o.n.b d1() {
        return this.k;
    }

    public final void e1() {
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.pb_reply_title_layout, (ViewGroup) null));
        this.v = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.u = false;
        pbReplyTitleViewHolder.p(w().V2());
        this.v.o(w().M1);
        this.v.r(8);
        this.u.addView(this.v.j());
        this.w = new PbChildTitleViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.pb_child_title, (ViewGroup) null));
        d.a.j0.d2.h.d dVar = new d.a.j0.d2.h.d();
        dVar.h(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
        this.w.b(dVar);
        this.w.e(8);
        this.u.addView(this.w.c());
    }

    public final void f1() {
        this.C = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.f20253h = (BdTypeRecyclerView) this.f20252g.findViewById(R.id.video_pb_reply_list);
        d dVar = new d(getContext());
        this.f20254i = dVar;
        this.f20253h.setLayoutManager(dVar);
        d.a.j0.d2.o.m.b bVar = new d.a.j0.d2.o.m.b(this, this.f20253h);
        this.j = bVar;
        bVar.C(w().V2());
        this.j.y(w().W2());
        this.j.A(w().Z2());
        this.j.z(this.k.i());
        this.j.D(this.k.l());
        this.o = this.f20252g.findViewById(R.id.reply_pager_title_shadow);
        PbListView pbListView = new PbListView(getPageContext().getPageActivity());
        this.l = pbListView;
        View findViewById = pbListView.b().findViewById(R.id.pb_more_view);
        this.m = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(w().V2());
            SkinManager.setBackgroundResource(this.m, R.drawable.pb_foot_more_trans_selector);
        }
        this.l.x();
        this.l.n(R.drawable.pb_foot_more_trans_selector);
        this.l.o(R.drawable.pb_foot_more_trans_selector);
        this.l.q();
        this.f20253h.setOnSrollToBottomListener(this.J);
        this.f20253h.addOnScrollListener(this.G);
        this.f20253h.setOnTouchListener(w().a3());
        this.E = new e();
        this.f20253h.getViewTreeObserver().addOnGlobalLayoutListener(this.E);
        if (this.y == null) {
            d.a.i0.r.f0.g gVar = new d.a.i0.r.f0.g(getPageContext());
            this.y = gVar;
            gVar.n();
            this.y.a(this.H);
        }
        if (this.x == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f20252g.findViewById(R.id.pb_video_pull_refresh_layout);
            this.x = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.y);
            this.x.setEnabled(false);
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0205);
        }
        this.u = (LinearLayout) this.f20252g.findViewById(R.id.video_pb_suck_container);
        e1();
        this.j.B(w().M1);
        registerListener(this.I);
    }

    public void g1() {
        d.a.j0.d2.h.e y0 = z().y0();
        if (y0 == null) {
            return;
        }
        this.j.x(z().M0());
        this.j.u(y0);
        this.j.r();
        ArrayList<PostData> D = y0.D();
        if (y0.w().b() == 0 || D == null || D.size() < y0.w().e()) {
            if (ListUtils.getCount(D) != 0 && (ListUtils.getCount(D) != 1 || D.get(0) == null || D.get(0).A() != 1)) {
                if (y0.w().b() == 0) {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.l.j();
            } else if (h1()) {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.C);
            } else {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.C);
            }
        }
        w().e4(y0);
    }

    public boolean h1() {
        if (z() != null) {
            return z().d0();
        }
        return false;
    }

    @Override // d.a.j0.d2.p.e.b
    public void j0(boolean z) {
        this.t = z;
    }

    public final void j1() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f20253h;
        if (bdTypeRecyclerView == null || this.f20254i == null || this.j == null) {
            return;
        }
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount() + this.j.j();
        int headerViewsCount2 = this.f20253h.getHeaderViewsCount() + this.j.i();
        int findFirstVisibleItemPosition = this.f20254i.findFirstVisibleItemPosition();
        if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
            this.v.r(0);
        } else {
            this.v.r(8);
        }
        if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
            this.w.e(0);
            this.v.r(8);
        } else {
            this.w.e(8);
        }
        if ((headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) || (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2)) {
            t1(0);
        } else {
            t1(8);
        }
    }

    public void k1(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f20253h;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setCanFling(z);
        }
    }

    public void l1() {
        if (this.f20253h == null) {
        }
    }

    public void m1() {
        if (this.s != 2) {
            this.f20253h.setNextPage(this.l);
            this.s = 2;
        }
    }

    public void n() {
        if (getView() != null) {
            ViewGroup viewGroup = (ViewGroup) getView();
            hideLoadingView(viewGroup);
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                viewGroup.getChildAt(i2).setVisibility(0);
            }
        }
    }

    public void n1(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f20253h;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.f20253h.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.f20253h.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public final void o1(boolean z) {
        if (w() == null || A() == null || A().getPbModel() == null || this.j.k() == null) {
            return;
        }
        d.a.j0.d2.k.e.n.a().f(A().getPbModel().Y0(), this.j.k().h0(), this.v.j(), A().getPageStayDurationItem(), z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(A()).get(VideoPbViewModel.class);
        videoPbViewModel.n().observe(this, new f());
        R0(true, 0, 3, 0, videoPbViewModel.c(), "", 1, true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.f20250e = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        PbListView pbListView = this.l;
        if (pbListView != null) {
            pbListView.d(i2);
            if (this.m != null) {
                getBaseFragmentActivity().getLayoutMode().j(this.m);
                SkinManager.setBackgroundResource(this.m, R.drawable.pb_foot_more_trans_selector);
            }
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.v;
        if (pbReplyTitleViewHolder != null) {
            pbReplyTitleViewHolder.l(i2);
        }
        PbChildTitleViewHolder pbChildTitleViewHolder = this.w;
        if (pbChildTitleViewHolder != null) {
            pbChildTitleViewHolder.d();
        }
        d.a.j0.d2.o.m.b bVar = this.j;
        if (bVar != null) {
            bVar.r();
        }
        View view = this.o;
        if (view != null) {
            SkinManager.setBackgroundResource(view, R.drawable.personalize_tab_shadow);
        }
        SkinManager.setBackgroundColor(this.x, R.color.CAM_X0201);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.k = new d.a.j0.d2.o.n.b(this);
        this.f20252g = layoutInflater.inflate(R.layout.pb_detail_info_and_reply_fragment, (ViewGroup) null);
        f1();
        return this.f20252g;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.a.j0.d2.o.m.b bVar = this.j;
        if (bVar != null) {
            bVar.s();
        }
        MessageManager.getInstance().unRegisterListener(this.I);
        d.a.j0.d2.k.e.n.a().c();
        BdTypeRecyclerView bdTypeRecyclerView = this.f20253h;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.E);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (w() != null) {
            d.a.j0.d2.k.e.n.a().h(A());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.t = false;
        o1(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        v1(z);
        if (w() != null && w().S != null) {
            this.f20251f.S.G();
        }
        if (z && this.t) {
            s1();
            z().h1(true);
        }
    }

    public void p1(String str) {
        PbListView pbListView = this.l;
        if (pbListView != null) {
            pbListView.A(str);
        }
    }

    public void q1(String str) {
        PbListView pbListView = this.l;
        if (pbListView != null) {
            pbListView.F(str, this.C);
        }
    }

    public void r1(boolean z) {
        this.q = z;
    }

    public void s1() {
        this.l.x();
        this.l.O();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.TRUE));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        super.showLoadingView(view);
    }

    public void t1(int i2) {
        View view = this.o;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public void u1() {
        if (getView() != null) {
            ViewGroup viewGroup = (ViewGroup) getView();
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                viewGroup.getChildAt(i2).setVisibility(8);
            }
            showLoadingView(viewGroup);
        }
    }

    public void v1(boolean z) {
        if (z && this.p) {
            this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.f20253h.setNextPage(this.l);
            this.s = 2;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment w() {
        PbActivity pbActivity;
        if (this.f20251f == null && (pbActivity = this.f20250e) != null) {
            Fragment findFragment = pbActivity.findFragment();
            if (findFragment instanceof VideoPbFragment) {
                this.f20251f = (VideoPbFragment) findFragment;
            }
        }
        return this.f20251f;
    }

    @Override // d.a.j0.d2.o.h
    public void x0(boolean z, int i2, int i3, int i4, d.a.j0.d2.h.e eVar, String str, int i5) {
        if (getActivity() != null) {
            R0(z, i2, i3, i4, eVar, str, i5, false);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel z() {
        return w().z();
    }
}
