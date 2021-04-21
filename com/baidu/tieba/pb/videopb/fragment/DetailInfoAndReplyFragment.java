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
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.i0.r.f0.f;
import d.b.i0.r.q.a2;
import d.b.j0.d2.k.e.m0;
import d.b.j0.d2.p.e;
import d.b.j0.d3.h0.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements d.b.j0.d2.o.h, e.b {
    public int C;
    public ViewTreeObserver.OnGlobalLayoutListener E;
    public boolean F;

    /* renamed from: e  reason: collision with root package name */
    public PbActivity f19765e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPbFragment f19766f;

    /* renamed from: g  reason: collision with root package name */
    public View f19767g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f19768h;
    public LinearLayoutManager i;
    public d.b.j0.d2.o.m.b j;
    public d.b.j0.d2.o.n.b k;
    public View o;
    public boolean t;
    public LinearLayout u;
    public PbReplyTitleViewHolder v;
    public PbChildTitleViewHolder w;
    public BdSwipeRefreshLayout x;
    public PbListView l = null;
    public View m = null;
    public d.b.j0.d2.p.e n = null;
    public boolean p = false;
    public boolean q = false;
    public boolean r = true;
    public int s = 0;
    public d.b.i0.r.f0.g y = null;
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
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                DetailInfoAndReplyFragment.this.I().j4();
                DetailInfoAndReplyFragment.this.I().l4();
            }
            if (DetailInfoAndReplyFragment.this.I() != null) {
                DetailInfoAndReplyFragment.this.I().W3(i);
            }
            if (i == 0) {
                DetailInfoAndReplyFragment.this.o1(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            DetailInfoAndReplyFragment.this.j1();
            if (recyclerView.canScrollVertically(-1)) {
                DetailInfoAndReplyFragment.this.A = 2;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoAndReplyFragment.this.A != 0) {
                DetailInfoAndReplyFragment.this.o.setVisibility(8);
            }
            DetailInfoAndReplyFragment.this.A = 0;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.b.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (DetailInfoAndReplyFragment.this.L() != null && DetailInfoAndReplyFragment.this.L().l1(true)) {
                TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                DetailInfoAndReplyFragment.this.U0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || DetailInfoAndReplyFragment.this.L() == null || DetailInfoAndReplyFragment.this.L().y0() == null || DetailInfoAndReplyFragment.this.L().y0().D() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            o oVar = null;
            Iterator<PostData> it = DetailInfoAndReplyFragment.this.L().y0().D().iterator();
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
            if (oVar == null || DetailInfoAndReplyFragment.this.j == null || DetailInfoAndReplyFragment.this.f19768h == null) {
                return;
            }
            DetailInfoAndReplyFragment.this.L().y0().D().remove(oVar);
            if (DetailInfoAndReplyFragment.this.j.a() != null) {
                DetailInfoAndReplyFragment.this.j.a().remove(oVar);
            }
            if (DetailInfoAndReplyFragment.this.f19768h.getListView2().getData() != null) {
                DetailInfoAndReplyFragment.this.f19768h.getListView2().getData().remove(oVar);
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
            if (DetailInfoAndReplyFragment.this.F || DetailInfoAndReplyFragment.this.I() == null) {
                return;
            }
            DetailInfoAndReplyFragment.this.F = true;
            DetailInfoAndReplyFragment.this.I().x2(DetailInfoAndReplyFragment.this.f19768h, false);
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
                if (!DetailInfoAndReplyFragment.this.D && DetailInfoAndReplyFragment.this.S0() && DetailInfoAndReplyFragment.this.L() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", DetailInfoAndReplyFragment.this.L().O0());
                    statisticItem.param("fid", DetailInfoAndReplyFragment.this.L().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    DetailInfoAndReplyFragment.this.D = true;
                }
                if (DetailInfoAndReplyFragment.this.L().h1(false)) {
                    DetailInfoAndReplyFragment.this.s1();
                    if (DetailInfoAndReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (DetailInfoAndReplyFragment.this.L().y0() != null) {
                    DetailInfoAndReplyFragment.this.m1();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f19776e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19777f;

        public h(boolean z, int i) {
            this.f19776e = z;
            this.f19777f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f19776e) {
                DetailInfoAndReplyFragment.this.n1(this.f19777f, UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
        }
    }

    public static DetailInfoAndReplyFragment i1(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
        detailInfoAndReplyFragment.setArguments(bundle);
        detailInfoAndReplyFragment.f19766f = videoPbFragment;
        return detailInfoAndReplyFragment;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment I() {
        PbActivity pbActivity;
        if (this.f19766f == null && (pbActivity = this.f19765e) != null) {
            Fragment findFragment = pbActivity.findFragment();
            if (findFragment instanceof VideoPbFragment) {
                this.f19766f = (VideoPbFragment) findFragment;
            }
        }
        return this.f19766f;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel L() {
        return I().L();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity P() {
        PbActivity pbActivity = this.f19765e;
        return pbActivity != null ? pbActivity : I().P();
    }

    public final void R0(boolean z, int i, int i2, int i3, d.b.j0.d2.h.e eVar, String str, int i4, boolean z2) {
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(P()).get(VideoPbViewModel.class);
        if (!z || L() == null || eVar == null) {
            return;
        }
        this.z = L().M0();
        boolean isEnabled = this.x.isEnabled();
        boolean z3 = true;
        int i5 = 0;
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
            this.f19768h.setNextPage(this.l);
            this.s = 2;
            if (I() != null && I().S != null) {
                this.f19766f.S.T();
            }
        } else {
            this.p = true;
            if (eVar.w().b() == 1) {
                if (this.n == null) {
                    d.b.j0.d2.p.e eVar2 = new d.b.j0.d2.p.e(this, this);
                    this.n = eVar2;
                    eVar2.a();
                    this.n.g();
                }
                this.f19768h.setNextPage(this.n);
            } else {
                this.f19768h.setNextPage(this.l);
            }
            this.s = 3;
        }
        if (this.v != null) {
            d.b.j0.d2.h.o oVar = new d.b.j0.d2.h.o(d.b.j0.d2.h.o.l);
            a2 L = eVar.L();
            if (L != null) {
                L.Z0();
            }
            L().M0();
            oVar.f54273h = h1();
            oVar.f54272g = eVar.f54242g;
            eVar.c();
            oVar.i = eVar.a0();
            oVar.k = eVar.f54241f;
            this.v.h(oVar);
        }
        ArrayList<PostData> D = eVar.D();
        if (eVar.w().b() != 0 && D != null && D.size() >= eVar.w().e()) {
            if (L().i0()) {
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
        if (i2 == 2) {
            this.f19768h.setSelection(i3 > 1 ? (i3 + ((this.f19768h.getData() == null && eVar.D() == null) ? 0 : this.f19768h.getData().size() - eVar.D().size())) - 2 : 0);
        } else if (i2 != 3) {
            if (i2 == 4) {
                this.r = false;
            } else if (i2 == 5) {
                this.f19768h.setSelection(0);
            } else if (i2 == 6) {
                if (i4 == 1) {
                    Parcelable e2 = m0.b().e();
                    if (e2 instanceof RecyclerView.SavedState) {
                        this.f19768h.onRestoreInstanceState(e2);
                    }
                }
                this.f19768h.setSelection(0);
            } else if (i2 == 8) {
                this.f19768h.setSelection(i3 > 0 ? i3 + ((this.f19768h.getData() == null && eVar.D() == null) ? 0 : this.f19768h.getData().size() - eVar.D().size()) : 0);
                this.l.f();
                this.l.A(getString(R.string.pb_load_more_without_point));
                this.l.v();
            }
        } else if (i4 == 1) {
            Parcelable e3 = m0.b().e();
            if (e3 instanceof RecyclerView.SavedState) {
                this.f19768h.onRestoreInstanceState(e3);
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
            if (i4 == 0) {
                r1(true);
            }
        }
        I().e4(eVar);
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
        String b0 = L().b0();
        ArrayList<n> a2 = this.j.a();
        if (a2 != null) {
            if (!k.isEmpty(b0)) {
                for (int i6 = 0; i6 < a2.size(); i6++) {
                    if (a2.get(i6).getType() == PostData.p0 && b0.equals(((PostData) a2.get(i6)).E())) {
                        i5 = i6;
                        break;
                    }
                }
            } else {
                int i7 = 0;
                while (true) {
                    if (i7 >= a2.size()) {
                        break;
                    } else if (a2.get(i7).getType() == d.b.j0.d2.h.o.l) {
                        i5 = i7;
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            z3 = false;
            if (i5 != 0) {
                d.b.c.e.m.e.a().post(new h(z3, i5));
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
        if (I() != null && I().S != null) {
            this.f19766f.S.T();
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
    public d.b.j0.d2.o.m.b E0() {
        return this.j;
    }

    public int W0() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f19768h;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getFirstVisiblePosition();
        }
        return 0;
    }

    public int X0() {
        View childAt;
        BdTypeRecyclerView bdTypeRecyclerView = this.f19768h;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.f19768h.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    @Override // d.b.j0.d2.p.e.b
    public void Y(boolean z) {
        this.t = z;
    }

    public int Y0() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f19768h;
        if (bdTypeRecyclerView != null) {
            int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
            return (L() == null || L().y0() == null || lastVisiblePosition < L().y0().D().size()) ? lastVisiblePosition : L().y0().D().size() - 2;
        }
        return 0;
    }

    public BdTypeRecyclerView Z0() {
        return this.f19768h;
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

    public d.b.j0.d2.o.n.b d1() {
        return this.k;
    }

    public final void e1() {
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.pb_reply_title_layout, (ViewGroup) null));
        this.v = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.u = false;
        pbReplyTitleViewHolder.p(I().V2());
        this.v.o(I().M1);
        this.v.r(8);
        this.u.addView(this.v.j());
        this.w = new PbChildTitleViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.pb_child_title, (ViewGroup) null));
        d.b.j0.d2.h.d dVar = new d.b.j0.d2.h.d();
        dVar.g(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
        this.w.b(dVar);
        this.w.e(8);
        this.u.addView(this.w.c());
    }

    public final void f1() {
        this.C = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.f19768h = (BdTypeRecyclerView) this.f19767g.findViewById(R.id.video_pb_reply_list);
        d dVar = new d(getContext());
        this.i = dVar;
        this.f19768h.setLayoutManager(dVar);
        d.b.j0.d2.o.m.b bVar = new d.b.j0.d2.o.m.b(this, this.f19768h);
        this.j = bVar;
        bVar.C(I().V2());
        this.j.y(I().W2());
        this.j.A(I().Z2());
        this.j.z(this.k.i());
        this.j.D(this.k.l());
        this.o = this.f19767g.findViewById(R.id.reply_pager_title_shadow);
        PbListView pbListView = new PbListView(getPageContext().getPageActivity());
        this.l = pbListView;
        View findViewById = pbListView.b().findViewById(R.id.pb_more_view);
        this.m = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(I().V2());
            SkinManager.setBackgroundResource(this.m, R.drawable.pb_foot_more_trans_selector);
        }
        this.l.x();
        this.l.n(R.drawable.pb_foot_more_trans_selector);
        this.l.o(R.drawable.pb_foot_more_trans_selector);
        this.l.q();
        this.f19768h.setOnSrollToBottomListener(this.J);
        this.f19768h.addOnScrollListener(this.G);
        this.f19768h.setOnTouchListener(I().a3());
        this.E = new e();
        this.f19768h.getViewTreeObserver().addOnGlobalLayoutListener(this.E);
        if (this.y == null) {
            d.b.i0.r.f0.g gVar = new d.b.i0.r.f0.g(getPageContext());
            this.y = gVar;
            gVar.n();
            this.y.b(this.H);
        }
        if (this.x == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f19767g.findViewById(R.id.pb_video_pull_refresh_layout);
            this.x = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.y);
            this.x.setEnabled(false);
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0205);
        }
        this.u = (LinearLayout) this.f19767g.findViewById(R.id.video_pb_suck_container);
        e1();
        this.j.B(I().M1);
        registerListener(this.I);
    }

    public void g1() {
        d.b.j0.d2.h.e y0 = L().y0();
        if (y0 == null) {
            return;
        }
        this.j.x(L().M0());
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
        I().e4(y0);
    }

    public boolean h1() {
        if (L() != null) {
            return L().d0();
        }
        return false;
    }

    public final void j1() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f19768h;
        if (bdTypeRecyclerView == null || this.i == null || this.j == null) {
            return;
        }
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount() + this.j.j();
        int headerViewsCount2 = this.f19768h.getHeaderViewsCount() + this.j.i();
        int findFirstVisibleItemPosition = this.i.findFirstVisibleItemPosition();
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f19768h;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setCanFling(z);
        }
    }

    public void l1() {
        if (this.f19768h == null) {
        }
    }

    public void m1() {
        if (this.s != 2) {
            this.f19768h.setNextPage(this.l);
            this.s = 2;
        }
    }

    public void n() {
        if (getView() != null) {
            ViewGroup viewGroup = (ViewGroup) getView();
            hideLoadingView(viewGroup);
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                viewGroup.getChildAt(i).setVisibility(0);
            }
        }
    }

    public void n1(int i, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f19768h;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.f19768h.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.f19768h.getLayoutManager()).scrollToPositionWithOffset(i, i2);
    }

    public final void o1(boolean z) {
        if (I() == null || P() == null || P().getPbModel() == null || this.j.k() == null) {
            return;
        }
        d.b.j0.d2.k.e.n.a().f(P().getPbModel().Y0(), this.j.k().l0(), this.v.j(), P().getPageStayDurationItem(), z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(P()).get(VideoPbViewModel.class);
        videoPbViewModel.n().observe(this, new f());
        R0(true, 0, 3, 0, videoPbViewModel.c(), "", 1, true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.f19765e = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        PbListView pbListView = this.l;
        if (pbListView != null) {
            pbListView.d(i);
            if (this.m != null) {
                getBaseFragmentActivity().getLayoutMode().j(this.m);
                SkinManager.setBackgroundResource(this.m, R.drawable.pb_foot_more_trans_selector);
            }
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.v;
        if (pbReplyTitleViewHolder != null) {
            pbReplyTitleViewHolder.l(i);
        }
        PbChildTitleViewHolder pbChildTitleViewHolder = this.w;
        if (pbChildTitleViewHolder != null) {
            pbChildTitleViewHolder.d();
        }
        d.b.j0.d2.o.m.b bVar = this.j;
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
        this.k = new d.b.j0.d2.o.n.b(this);
        this.f19767g = layoutInflater.inflate(R.layout.pb_detail_info_and_reply_fragment, (ViewGroup) null);
        f1();
        return this.f19767g;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.b.j0.d2.o.m.b bVar = this.j;
        if (bVar != null) {
            bVar.s();
        }
        MessageManager.getInstance().unRegisterListener(this.I);
        d.b.j0.d2.k.e.n.a().c();
        BdTypeRecyclerView bdTypeRecyclerView = this.f19768h;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.E);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (I() != null) {
            d.b.j0.d2.k.e.n.a().h(P());
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
        if (I() != null && I().S != null) {
            this.f19766f.S.G();
        }
        if (z && this.t) {
            s1();
            L().h1(true);
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

    @Override // d.b.j0.d2.o.h
    public void t0(boolean z, int i, int i2, int i3, d.b.j0.d2.h.e eVar, String str, int i4) {
        if (getActivity() != null) {
            R0(z, i, i2, i3, eVar, str, i4, false);
        }
    }

    public void t1(int i) {
        View view = this.o;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void u1() {
        if (getView() != null) {
            ViewGroup viewGroup = (ViewGroup) getView();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                viewGroup.getChildAt(i).setVisibility(8);
            }
            showLoadingView(viewGroup);
        }
    }

    public void v1(boolean z) {
        if (z && this.p) {
            this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.f19768h.setNextPage(this.l);
            this.s = 2;
        }
    }
}
