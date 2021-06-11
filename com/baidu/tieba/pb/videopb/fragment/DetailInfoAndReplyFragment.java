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
import d.a.c.k.e.n;
import d.a.m0.r.f0.f;
import d.a.m0.r.q.a2;
import d.a.n0.e2.k.e.m0;
import d.a.n0.e2.p.e;
import d.a.n0.e3.h0.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements d.a.n0.e2.o.h, e.b {
    public int C;
    public ViewTreeObserver.OnGlobalLayoutListener E;
    public boolean F;

    /* renamed from: e  reason: collision with root package name */
    public PbActivity f19537e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPbFragment f19538f;

    /* renamed from: g  reason: collision with root package name */
    public View f19539g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f19540h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayoutManager f19541i;
    public d.a.n0.e2.o.m.b j;
    public d.a.n0.e2.o.n.b k;
    public View o;
    public boolean t;
    public LinearLayout u;
    public PbReplyTitleViewHolder v;
    public PbChildTitleViewHolder w;
    public BdSwipeRefreshLayout x;
    public PbListView l = null;
    public View m = null;
    public d.a.n0.e2.p.e n = null;
    public boolean p = false;
    public boolean q = false;
    public boolean r = true;
    public int s = 0;
    public d.a.m0.r.f0.g y = null;
    public boolean z = false;
    public int A = 0;
    public int B = 0;
    public boolean D = false;
    public RecyclerView.OnScrollListener G = new a();
    public final f.g H = new b();
    public CustomMessageListener I = new c(2016331);
    public final BdListView.p J = new g();

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 1) {
                DetailInfoAndReplyFragment.this.x().n4();
                DetailInfoAndReplyFragment.this.x().p4();
            }
            if (DetailInfoAndReplyFragment.this.x() != null) {
                DetailInfoAndReplyFragment.this.x().a4(i2);
            }
            if (i2 == 0) {
                DetailInfoAndReplyFragment.this.q1(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            DetailInfoAndReplyFragment.this.l1();
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

    /* loaded from: classes5.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (DetailInfoAndReplyFragment.this.A() != null && DetailInfoAndReplyFragment.this.A().o1(true)) {
                TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                DetailInfoAndReplyFragment.this.W0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || DetailInfoAndReplyFragment.this.A() == null || DetailInfoAndReplyFragment.this.A().C0() == null || DetailInfoAndReplyFragment.this.A().C0().D() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            o oVar = null;
            Iterator<PostData> it = DetailInfoAndReplyFragment.this.A().C0().D().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PostData next = it.next();
                if (next instanceof o) {
                    o oVar2 = (o) next;
                    if (str.equals(oVar2.D0())) {
                        oVar = oVar2;
                        break;
                    }
                }
            }
            if (oVar == null || DetailInfoAndReplyFragment.this.j == null || DetailInfoAndReplyFragment.this.f19540h == null) {
                return;
            }
            DetailInfoAndReplyFragment.this.A().C0().D().remove(oVar);
            if (DetailInfoAndReplyFragment.this.j.a() != null) {
                DetailInfoAndReplyFragment.this.j.a().remove(oVar);
            }
            if (DetailInfoAndReplyFragment.this.f19540h.getListView2().getData() != null) {
                DetailInfoAndReplyFragment.this.f19540h.getListView2().getData().remove(oVar);
            }
            DetailInfoAndReplyFragment.this.j.r();
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class e implements ViewTreeObserver.OnGlobalLayoutListener {
        public e() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (DetailInfoAndReplyFragment.this.F || DetailInfoAndReplyFragment.this.x() == null) {
                return;
            }
            DetailInfoAndReplyFragment.this.F = true;
            DetailInfoAndReplyFragment.this.x().B2(DetailInfoAndReplyFragment.this.f19540h, false);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Observer<Boolean> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            if (bool != null && bool.booleanValue()) {
                DetailInfoAndReplyFragment.this.w1();
            } else {
                DetailInfoAndReplyFragment.this.o();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements BdListView.p {
        public g() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (DetailInfoAndReplyFragment.this.mIsLogin) {
                if (!DetailInfoAndReplyFragment.this.D && DetailInfoAndReplyFragment.this.U0() && DetailInfoAndReplyFragment.this.A() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", DetailInfoAndReplyFragment.this.A().S0());
                    statisticItem.param("fid", DetailInfoAndReplyFragment.this.A().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    DetailInfoAndReplyFragment.this.D = true;
                }
                if (DetailInfoAndReplyFragment.this.A().k1(false)) {
                    DetailInfoAndReplyFragment.this.u1();
                    if (DetailInfoAndReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (DetailInfoAndReplyFragment.this.A().C0() != null) {
                    DetailInfoAndReplyFragment.this.o1();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f19549e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19550f;

        public h(boolean z, int i2) {
            this.f19549e = z;
            this.f19550f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f19549e) {
                DetailInfoAndReplyFragment.this.p1(this.f19550f, UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
        }
    }

    public static DetailInfoAndReplyFragment k1(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
        detailInfoAndReplyFragment.setArguments(bundle);
        detailInfoAndReplyFragment.f19538f = videoPbFragment;
        return detailInfoAndReplyFragment;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel A() {
        return x().A();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity B() {
        PbActivity pbActivity = this.f19537e;
        return pbActivity != null ? pbActivity : x().B();
    }

    public final void T0(boolean z, int i2, int i3, int i4, d.a.n0.e2.h.e eVar, String str, int i5, boolean z2) {
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(B()).get(VideoPbViewModel.class);
        if (!z || A() == null || eVar == null) {
            return;
        }
        this.z = A().Q0();
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
            this.f19540h.setNextPage(this.l);
            this.s = 2;
            if (x() != null && x().S != null) {
                this.f19538f.S.V();
            }
        } else {
            this.p = true;
            if (eVar.w().b() == 1) {
                if (this.n == null) {
                    d.a.n0.e2.p.e eVar2 = new d.a.n0.e2.p.e(this, this);
                    this.n = eVar2;
                    eVar2.a();
                    this.n.g();
                }
                this.f19540h.setNextPage(this.n);
            } else {
                this.f19540h.setNextPage(this.l);
            }
            this.s = 3;
        }
        if (this.v != null) {
            d.a.n0.e2.h.o oVar = new d.a.n0.e2.h.o(d.a.n0.e2.h.o.l);
            a2 L = eVar.L();
            if (L != null) {
                L.b1();
            }
            A().Q0();
            oVar.f56647h = j1();
            oVar.f56646g = eVar.f56614g;
            eVar.c();
            oVar.f56648i = eVar.a0();
            oVar.k = eVar.f56613f;
            this.v.h(oVar);
        }
        ArrayList<PostData> D = eVar.D();
        if (eVar.w().b() != 0 && D != null && D.size() >= eVar.w().e()) {
            if (A().m0()) {
                if (this.r) {
                    V0();
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
                o1();
            }
        }
        if (i3 == 2) {
            this.f19540h.setSelection(i4 > 1 ? (i4 + ((this.f19540h.getData() == null && eVar.D() == null) ? 0 : this.f19540h.getData().size() - eVar.D().size())) - 2 : 0);
        } else if (i3 != 3) {
            if (i3 == 4) {
                this.r = false;
            } else if (i3 == 5) {
                this.f19540h.setSelection(0);
            } else if (i3 == 6) {
                if (i5 == 1) {
                    Parcelable e2 = m0.b().e();
                    if (e2 instanceof RecyclerView.SavedState) {
                        this.f19540h.onRestoreInstanceState(e2);
                    }
                }
                this.f19540h.setSelection(0);
            } else if (i3 == 8) {
                this.f19540h.setSelection(i4 > 0 ? i4 + ((this.f19540h.getData() == null && eVar.D() == null) ? 0 : this.f19540h.getData().size() - eVar.D().size()) : 0);
                this.l.f();
                this.l.A(getString(R.string.pb_load_more_without_point));
                this.l.v();
            }
        } else if (i5 == 1) {
            Parcelable e3 = m0.b().e();
            if (e3 instanceof RecyclerView.SavedState) {
                this.f19540h.onRestoreInstanceState(e3);
                if (ListUtils.getCount(D) > 1 && eVar.w().b() > 0) {
                    this.l.f();
                    this.l.A(getString(R.string.pb_load_more_without_point));
                    this.l.v();
                }
            }
        }
        if (this.q) {
            n1();
            this.q = false;
            if (i5 == 0) {
                t1(true);
            }
        }
        x().i4(eVar);
        if (this.l != null) {
            if (eVar.w().b() != 0 && !d.a.m0.c1.b.e.d()) {
                this.l.I(0);
            } else {
                this.l.I(8);
            }
        }
        if (ListUtils.getCount(this.j.a()) <= 0 || !videoPbViewModel.m()) {
            return;
        }
        videoPbViewModel.w(false);
        String f0 = A().f0();
        ArrayList<n> a2 = this.j.a();
        if (a2 != null) {
            if (!k.isEmpty(f0)) {
                for (int i7 = 0; i7 < a2.size(); i7++) {
                    if (a2.get(i7).getType() == PostData.p0 && f0.equals(((PostData) a2.get(i7)).E())) {
                        i6 = i7;
                        break;
                    }
                }
            } else {
                int i8 = 0;
                while (true) {
                    if (i8 >= a2.size()) {
                        break;
                    } else if (a2.get(i8).getType() == d.a.n0.e2.h.o.l) {
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

    public boolean U0() {
        PbListView pbListView = this.l;
        if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
            return false;
        }
        return this.l.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }

    public void V0() {
        PbListView pbListView = this.l;
        if (pbListView != null) {
            pbListView.v();
            this.l.f();
        }
        if (x() != null && x().S != null) {
            this.f19538f.S.V();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.FALSE));
    }

    public void W0() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.x;
        if (bdSwipeRefreshLayout == null || !bdSwipeRefreshLayout.isEnabled()) {
            return;
        }
        this.x.setRefreshing(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: X0 */
    public d.a.n0.e2.o.m.b G0() {
        return this.j;
    }

    public int Y0() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f19540h;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getFirstVisiblePosition();
        }
        return 0;
    }

    public int Z0() {
        View childAt;
        BdTypeRecyclerView bdTypeRecyclerView = this.f19540h;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.f19540h.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int a1() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f19540h;
        if (bdTypeRecyclerView != null) {
            int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
            return (A() == null || A().C0() == null || lastVisiblePosition < A().C0().D().size()) ? lastVisiblePosition : A().C0().D().size() - 2;
        }
        return 0;
    }

    public BdTypeRecyclerView b1() {
        return this.f19540h;
    }

    public int c1() {
        return this.B;
    }

    public View d1() {
        return this.m;
    }

    public int e1() {
        return this.A;
    }

    public d.a.n0.e2.o.n.b f1() {
        return this.k;
    }

    public final void g1() {
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.pb_reply_title_layout, (ViewGroup) null));
        this.v = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.u = false;
        pbReplyTitleViewHolder.p(x().Z2());
        this.v.o(x().N1);
        this.v.r(8);
        this.u.addView(this.v.j());
        this.w = new PbChildTitleViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.pb_child_title, (ViewGroup) null));
        d.a.n0.e2.h.d dVar = new d.a.n0.e2.h.d();
        dVar.g(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
        this.w.b(dVar);
        this.w.e(8);
        this.u.addView(this.w.c());
    }

    public final void h1() {
        this.C = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.f19540h = (BdTypeRecyclerView) this.f19539g.findViewById(R.id.video_pb_reply_list);
        d dVar = new d(getContext());
        this.f19541i = dVar;
        this.f19540h.setLayoutManager(dVar);
        d.a.n0.e2.o.m.b bVar = new d.a.n0.e2.o.m.b(this, this.f19540h);
        this.j = bVar;
        bVar.C(x().Z2());
        this.j.y(x().a3());
        this.j.A(x().d3());
        this.j.z(this.k.i());
        this.j.D(this.k.l());
        this.o = this.f19539g.findViewById(R.id.reply_pager_title_shadow);
        PbListView pbListView = new PbListView(getPageContext().getPageActivity());
        this.l = pbListView;
        View findViewById = pbListView.b().findViewById(R.id.pb_more_view);
        this.m = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(x().Z2());
            SkinManager.setBackgroundResource(this.m, R.drawable.pb_foot_more_trans_selector);
        }
        this.l.x();
        this.l.n(R.drawable.pb_foot_more_trans_selector);
        this.l.o(R.drawable.pb_foot_more_trans_selector);
        this.l.q();
        this.f19540h.setOnSrollToBottomListener(this.J);
        this.f19540h.addOnScrollListener(this.G);
        this.f19540h.setOnTouchListener(x().e3());
        this.E = new e();
        this.f19540h.getViewTreeObserver().addOnGlobalLayoutListener(this.E);
        if (this.y == null) {
            d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(getPageContext());
            this.y = gVar;
            gVar.n();
            this.y.a(this.H);
        }
        if (this.x == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f19539g.findViewById(R.id.pb_video_pull_refresh_layout);
            this.x = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.y);
            this.x.setEnabled(false);
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0205);
        }
        this.u = (LinearLayout) this.f19539g.findViewById(R.id.video_pb_suck_container);
        g1();
        this.j.B(x().N1);
        registerListener(this.I);
        if (d.a.m0.c1.b.e.d()) {
            this.l.I(8);
            this.m.setVisibility(8);
        }
    }

    public void i1() {
        d.a.n0.e2.h.e C0 = A().C0();
        if (C0 == null) {
            return;
        }
        this.j.x(A().Q0());
        this.j.u(C0);
        this.j.r();
        ArrayList<PostData> D = C0.D();
        if (C0.w().b() == 0 || D == null || D.size() < C0.w().e()) {
            if (ListUtils.getCount(D) != 0 && (ListUtils.getCount(D) != 1 || D.get(0) == null || D.get(0).A() != 1)) {
                if (C0.w().b() == 0) {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.l.j();
            } else if (j1()) {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.C);
            } else {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.C);
            }
        }
        x().i4(C0);
    }

    public boolean j1() {
        if (A() != null) {
            return A().h0();
        }
        return false;
    }

    public final void l1() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f19540h;
        if (bdTypeRecyclerView == null || this.f19541i == null || this.j == null) {
            return;
        }
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount() + this.j.j();
        int headerViewsCount2 = this.f19540h.getHeaderViewsCount() + this.j.i();
        int findFirstVisibleItemPosition = this.f19541i.findFirstVisibleItemPosition();
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
            v1(0);
        } else {
            v1(8);
        }
    }

    @Override // d.a.n0.e2.p.e.b
    public void m0(boolean z) {
        this.t = z;
    }

    public void m1(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f19540h;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setCanFling(z);
        }
    }

    public void n1() {
        if (this.f19540h == null) {
        }
    }

    public void o() {
        if (getView() != null) {
            ViewGroup viewGroup = (ViewGroup) getView();
            hideLoadingView(viewGroup);
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                viewGroup.getChildAt(i2).setVisibility(0);
            }
        }
    }

    public void o1() {
        if (this.s != 2) {
            this.f19540h.setNextPage(this.l);
            this.s = 2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(B()).get(VideoPbViewModel.class);
        videoPbViewModel.n().observe(this, new f());
        T0(true, 0, 3, 0, videoPbViewModel.c(), "", 1, true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.f19537e = (PbActivity) context;
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
        d.a.n0.e2.o.m.b bVar = this.j;
        if (bVar != null) {
            bVar.r();
        }
        View view = this.o;
        if (view != null) {
            SkinManager.setBackgroundResource(view, R.drawable.personalize_tab_shadow);
        }
        SkinManager.setBackgroundColor(this.x, R.color.CAM_X0201);
        if (d.a.m0.c1.b.e.d()) {
            SkinManager.setBackgroundColor(this.f19540h, R.color.CAM_X0202);
            return;
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f19540h;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setBackgroundResource(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.k = new d.a.n0.e2.o.n.b(this);
        this.f19539g = layoutInflater.inflate(R.layout.pb_detail_info_and_reply_fragment, (ViewGroup) null);
        h1();
        return this.f19539g;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.a.n0.e2.o.m.b bVar = this.j;
        if (bVar != null) {
            bVar.s();
        }
        MessageManager.getInstance().unRegisterListener(this.I);
        d.a.n0.e2.k.e.n.a().c();
        BdTypeRecyclerView bdTypeRecyclerView = this.f19540h;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.E);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (x() != null) {
            d.a.n0.e2.k.e.n.a().h(B());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.t = false;
        q1(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        x1(z);
        if (x() != null && x().S != null) {
            this.f19538f.S.H();
        }
        if (z && this.t) {
            u1();
            A().k1(true);
        }
    }

    public void p1(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f19540h;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.f19540h.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.f19540h.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public final void q1(boolean z) {
        if (x() == null || B() == null || B().getPbModel() == null || this.j.k() == null) {
            return;
        }
        d.a.n0.e2.k.e.n.a().f(B().getPbModel().b1(), this.j.k().i0(), this.v.j(), B().getPageStayDurationItem(), z);
    }

    public void r1(String str) {
        PbListView pbListView = this.l;
        if (pbListView != null) {
            pbListView.A(str);
        }
    }

    public void s1(String str) {
        PbListView pbListView = this.l;
        if (pbListView != null) {
            pbListView.F(str, this.C);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        super.showLoadingView(view);
    }

    public void t1(boolean z) {
        this.q = z;
    }

    public void u1() {
        this.l.x();
        this.l.O();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.TRUE));
    }

    public void v1(int i2) {
        View view = this.o;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public void w1() {
        if (getView() != null) {
            ViewGroup viewGroup = (ViewGroup) getView();
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                viewGroup.getChildAt(i2).setVisibility(8);
            }
            showLoadingView(viewGroup);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment x() {
        PbActivity pbActivity;
        if (this.f19538f == null && (pbActivity = this.f19537e) != null) {
            Fragment findFragment = pbActivity.findFragment();
            if (findFragment instanceof VideoPbFragment) {
                this.f19538f = (VideoPbFragment) findFragment;
            }
        }
        return this.f19538f;
    }

    public void x1(boolean z) {
        if (z && this.p) {
            this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.f19540h.setNextPage(this.l);
            this.s = 2;
        }
    }

    @Override // d.a.n0.e2.o.h
    public void z0(boolean z, int i2, int i3, int i4, d.a.n0.e2.h.e eVar, String str, int i5) {
        if (getActivity() != null) {
            T0(z, i2, i3, i4, eVar, str, i5, false);
        }
    }
}
