package com.baidu.tieba.pb.videopb.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.h0.r.f0.f;
import d.b.h0.r.q.a2;
import d.b.i0.c2.k.e.k0;
import d.b.i0.c2.p.a;
import d.b.i0.c3.h0.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements d.b.i0.c2.o.a, a.b {
    public int C;

    /* renamed from: e  reason: collision with root package name */
    public PbActivity f20069e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPbFragment f20070f;

    /* renamed from: g  reason: collision with root package name */
    public View f20071g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f20072h;
    public LinearLayoutManager i;
    public d.b.i0.c2.o.f.b j;
    public d.b.i0.c2.o.g.b k;
    public View o;
    public boolean t;
    public LinearLayout u;
    public PbReplyTitleViewHolder v;
    public PbChildTitleViewHolder w;
    public BdSwipeRefreshLayout x;
    public PbListView l = null;
    public View m = null;
    public d.b.i0.c2.p.a n = null;
    public boolean p = false;
    public boolean q = false;
    public boolean r = true;
    public int s = 0;
    public d.b.h0.r.f0.g y = null;
    public boolean z = false;
    public int A = 0;
    public int B = 0;
    public boolean D = false;
    public RecyclerView.OnScrollListener E = new a();
    public final f.g F = new b();
    public CustomMessageListener G = new c(2016331);
    public final BdListView.p H = new f();

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                DetailInfoAndReplyFragment.this.I().V3();
                DetailInfoAndReplyFragment.this.I().X3();
            }
            if (DetailInfoAndReplyFragment.this.I() != null) {
                DetailInfoAndReplyFragment.this.I().J3(i);
            }
            if (i == 0) {
                DetailInfoAndReplyFragment.this.m1(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            DetailInfoAndReplyFragment.this.h1();
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

    /* loaded from: classes5.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (DetailInfoAndReplyFragment.this.L() != null && DetailInfoAndReplyFragment.this.L().l1(true)) {
                TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                DetailInfoAndReplyFragment.this.S0();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                    if (str.equals(oVar2.A0())) {
                        oVar = oVar2;
                        break;
                    }
                }
            }
            if (oVar == null || DetailInfoAndReplyFragment.this.j == null || DetailInfoAndReplyFragment.this.f20072h == null) {
                return;
            }
            DetailInfoAndReplyFragment.this.L().y0().D().remove(oVar);
            if (DetailInfoAndReplyFragment.this.j.a() != null) {
                DetailInfoAndReplyFragment.this.j.a().remove(oVar);
            }
            if (DetailInfoAndReplyFragment.this.f20072h.getListView2().getData() != null) {
                DetailInfoAndReplyFragment.this.f20072h.getListView2().getData().remove(oVar);
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
    public class e implements Observer<Boolean> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            if (bool != null && bool.booleanValue()) {
                DetailInfoAndReplyFragment.this.s1();
            } else {
                DetailInfoAndReplyFragment.this.n();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements BdListView.p {
        public f() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (DetailInfoAndReplyFragment.this.mIsLogin) {
                if (!DetailInfoAndReplyFragment.this.D && DetailInfoAndReplyFragment.this.Q0() && DetailInfoAndReplyFragment.this.L() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", DetailInfoAndReplyFragment.this.L().O0());
                    statisticItem.param("fid", DetailInfoAndReplyFragment.this.L().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    DetailInfoAndReplyFragment.this.D = true;
                }
                if (DetailInfoAndReplyFragment.this.L().h1(false)) {
                    DetailInfoAndReplyFragment.this.q1();
                    if (DetailInfoAndReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (DetailInfoAndReplyFragment.this.L().y0() != null) {
                    DetailInfoAndReplyFragment.this.k1();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f20079e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f20080f;

        public g(boolean z, int i) {
            this.f20079e = z;
            this.f20080f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f20079e) {
                DetailInfoAndReplyFragment.this.l1(this.f20080f, UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
        }
    }

    public static DetailInfoAndReplyFragment g1(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
        detailInfoAndReplyFragment.setArguments(bundle);
        detailInfoAndReplyFragment.f20070f = videoPbFragment;
        return detailInfoAndReplyFragment;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment I() {
        PbActivity pbActivity;
        if (this.f20070f == null && (pbActivity = this.f20069e) != null) {
            Fragment findFragment = pbActivity.findFragment();
            if (findFragment instanceof VideoPbFragment) {
                this.f20070f = (VideoPbFragment) findFragment;
            }
        }
        return this.f20070f;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel L() {
        return I().L();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity P() {
        PbActivity pbActivity = this.f20069e;
        return pbActivity != null ? pbActivity : I().P();
    }

    public final void P0(boolean z, int i, int i2, int i3, d.b.i0.c2.h.e eVar, String str, int i4, boolean z2) {
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
            this.f20072h.setNextPage(this.l);
            this.s = 2;
            if (I() != null && I().Q != null) {
                this.f20070f.Q.T();
            }
        } else {
            this.p = true;
            if (eVar.w().b() == 1) {
                if (this.n == null) {
                    d.b.i0.c2.p.a aVar = new d.b.i0.c2.p.a(this, this);
                    this.n = aVar;
                    aVar.a();
                    this.n.g();
                }
                this.f20072h.setNextPage(this.n);
            } else {
                this.f20072h.setNextPage(this.l);
            }
            this.s = 3;
        }
        if (this.v != null) {
            d.b.i0.c2.h.o oVar = new d.b.i0.c2.h.o(d.b.i0.c2.h.o.l);
            a2 L = eVar.L();
            if (L != null) {
                L.Z0();
            }
            L().M0();
            oVar.f52456h = f1();
            oVar.f52455g = eVar.f52425g;
            eVar.c();
            oVar.i = eVar.Z();
            oVar.k = eVar.f52424f;
            this.v.h(oVar);
        }
        ArrayList<PostData> D = eVar.D();
        if (eVar.w().b() != 0 && D != null && D.size() >= eVar.w().e()) {
            if (L().i0()) {
                if (this.r) {
                    R0();
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
                k1();
            }
        }
        if (i2 == 2) {
            this.f20072h.setSelection(i3 > 1 ? (i3 + ((this.f20072h.getData() == null && eVar.D() == null) ? 0 : this.f20072h.getData().size() - eVar.D().size())) - 2 : 0);
        } else if (i2 != 3) {
            if (i2 == 4) {
                this.r = false;
            } else if (i2 == 5) {
                this.f20072h.setSelection(0);
            } else if (i2 == 6) {
                if (i4 == 1) {
                    Parcelable e2 = k0.b().e();
                    if (e2 instanceof RecyclerView.SavedState) {
                        this.f20072h.onRestoreInstanceState(e2);
                    }
                }
                this.f20072h.setSelection(0);
            } else if (i2 == 8) {
                this.f20072h.setSelection(i3 > 0 ? i3 + ((this.f20072h.getData() == null && eVar.D() == null) ? 0 : this.f20072h.getData().size() - eVar.D().size()) : 0);
                this.l.f();
                this.l.A(getString(R.string.pb_load_more_without_point));
                this.l.v();
            }
        } else if (i4 == 1) {
            Parcelable e3 = k0.b().e();
            if (e3 instanceof RecyclerView.SavedState) {
                this.f20072h.onRestoreInstanceState(e3);
                if (ListUtils.getCount(D) > 1 && eVar.w().b() > 0) {
                    this.l.f();
                    this.l.A(getString(R.string.pb_load_more_without_point));
                    this.l.v();
                }
            }
        }
        if (this.q) {
            j1();
            this.q = false;
            if (i4 == 0) {
                p1(true);
            }
        }
        I().Q3(eVar);
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
                    if (a2.get(i6).getType() == PostData.o0 && b0.equals(((PostData) a2.get(i6)).D())) {
                        i5 = i6;
                        break;
                    }
                }
            } else {
                int i7 = 0;
                while (true) {
                    if (i7 >= a2.size()) {
                        break;
                    } else if (a2.get(i7).getType() == d.b.i0.c2.h.o.l) {
                        i5 = i7;
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            z3 = false;
            if (i5 != 0) {
                d.b.b.e.m.e.a().post(new g(z3, i5));
            }
        }
    }

    public boolean Q0() {
        PbListView pbListView = this.l;
        if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
            return false;
        }
        return this.l.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }

    public void R0() {
        PbListView pbListView = this.l;
        if (pbListView != null) {
            pbListView.v();
            this.l.f();
        }
        if (I() != null && I().Q != null) {
            this.f20070f.Q.T();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.FALSE));
    }

    public void S0() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.x;
        if (bdSwipeRefreshLayout == null || !bdSwipeRefreshLayout.isEnabled()) {
            return;
        }
        this.x.setRefreshing(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: T0 */
    public d.b.i0.c2.o.f.b E0() {
        return this.j;
    }

    public int U0() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f20072h;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getFirstVisiblePosition();
        }
        return 0;
    }

    public int V0() {
        View childAt;
        BdTypeRecyclerView bdTypeRecyclerView = this.f20072h;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.f20072h.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int W0() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f20072h;
        if (bdTypeRecyclerView != null) {
            int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
            return (L() == null || L().y0() == null || lastVisiblePosition < L().y0().D().size()) ? lastVisiblePosition : L().y0().D().size() - 2;
        }
        return 0;
    }

    public BdTypeRecyclerView X0() {
        return this.f20072h;
    }

    @Override // d.b.i0.c2.p.a.b
    public void Y(boolean z) {
        this.t = z;
    }

    public int Y0() {
        return this.B;
    }

    public View Z0() {
        return this.m;
    }

    public int a1() {
        return this.A;
    }

    public d.b.i0.c2.o.g.b b1() {
        return this.k;
    }

    public final void c1() {
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.pb_reply_title_layout, (ViewGroup) null));
        this.v = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.u = false;
        pbReplyTitleViewHolder.p(I().T2());
        this.v.o(I().G1);
        this.v.r(8);
        this.u.addView(this.v.j());
        this.w = new PbChildTitleViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.pb_child_title, (ViewGroup) null));
        d.b.i0.c2.h.d dVar = new d.b.i0.c2.h.d();
        dVar.g(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
        this.w.b(dVar);
        this.w.e(8);
        this.u.addView(this.w.c());
    }

    public final void d1() {
        this.C = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.f20072h = (BdTypeRecyclerView) this.f20071g.findViewById(R.id.video_pb_reply_list);
        d dVar = new d(getContext());
        this.i = dVar;
        this.f20072h.setLayoutManager(dVar);
        d.b.i0.c2.o.f.b bVar = new d.b.i0.c2.o.f.b(this, this.f20072h);
        this.j = bVar;
        bVar.C(I().T2());
        this.j.y(I().U2());
        this.j.A(I().X2());
        this.j.z(this.k.i());
        this.j.D(this.k.l());
        this.o = this.f20071g.findViewById(R.id.reply_pager_title_shadow);
        PbListView pbListView = new PbListView(getPageContext().getPageActivity());
        this.l = pbListView;
        View findViewById = pbListView.b().findViewById(R.id.pb_more_view);
        this.m = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(I().T2());
            SkinManager.setBackgroundResource(this.m, R.drawable.pb_foot_more_trans_selector);
        }
        this.l.x();
        this.l.n(R.drawable.pb_foot_more_trans_selector);
        this.l.o(R.drawable.pb_foot_more_trans_selector);
        this.l.q();
        this.f20072h.setOnSrollToBottomListener(this.H);
        this.f20072h.addOnScrollListener(this.E);
        this.f20072h.setOnTouchListener(I().Y2());
        if (this.y == null) {
            d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(getPageContext());
            this.y = gVar;
            gVar.n();
            this.y.b(this.F);
        }
        if (this.x == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f20071g.findViewById(R.id.pb_video_pull_refresh_layout);
            this.x = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.y);
            this.x.setEnabled(false);
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0205);
        }
        this.u = (LinearLayout) this.f20071g.findViewById(R.id.video_pb_suck_container);
        c1();
        this.j.B(I().G1);
        registerListener(this.G);
    }

    public void e1() {
        d.b.i0.c2.h.e y0 = L().y0();
        if (y0 == null) {
            return;
        }
        this.j.x(L().M0());
        this.j.u(y0);
        this.j.r();
        ArrayList<PostData> D = y0.D();
        if (y0.w().b() == 0 || D == null || D.size() < y0.w().e()) {
            if (ListUtils.getCount(D) != 0 && (ListUtils.getCount(D) != 1 || D.get(0) == null || D.get(0).z() != 1)) {
                if (y0.w().b() == 0) {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.l.j();
            } else if (f1()) {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.C);
            } else {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.C);
            }
        }
        I().Q3(y0);
    }

    public boolean f1() {
        if (L() != null) {
            return L().d0();
        }
        return false;
    }

    public final void h1() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f20072h;
        if (bdTypeRecyclerView == null || this.i == null || this.j == null) {
            return;
        }
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount() + this.j.j();
        int headerViewsCount2 = this.f20072h.getHeaderViewsCount() + this.j.i();
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
            r1(0);
        } else {
            r1(8);
        }
    }

    public void i1(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f20072h;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setCanFling(z);
        }
    }

    public void j1() {
        if (this.f20072h == null) {
        }
    }

    public void k1() {
        if (this.s != 2) {
            this.f20072h.setNextPage(this.l);
            this.s = 2;
        }
    }

    public void l1(int i, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f20072h;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.f20072h.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.f20072h.getLayoutManager()).scrollToPositionWithOffset(i, i2);
    }

    public final void m1(boolean z) {
        if (I() == null || P() == null || P().getPbModel() == null || this.j.k() == null) {
            return;
        }
        d.b.i0.c2.k.e.l.a().f(P().getPbModel().Y0(), this.j.k().l0(), this.v.j(), P().getPageStayDurationItem(), z);
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

    public void n1(String str) {
        PbListView pbListView = this.l;
        if (pbListView != null) {
            pbListView.A(str);
        }
    }

    public void o1(String str) {
        PbListView pbListView = this.l;
        if (pbListView != null) {
            pbListView.F(str, this.C);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(P()).get(VideoPbViewModel.class);
        videoPbViewModel.n().observe(this, new e());
        P0(true, 0, 3, 0, videoPbViewModel.c(), "", 1, true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.f20069e = (PbActivity) context;
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
        d.b.i0.c2.o.f.b bVar = this.j;
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
        this.k = new d.b.i0.c2.o.g.b(this);
        this.f20071g = layoutInflater.inflate(R.layout.pb_detail_info_and_reply_fragment, (ViewGroup) null);
        d1();
        return this.f20071g;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.b.i0.c2.o.f.b bVar = this.j;
        if (bVar != null) {
            bVar.s();
        }
        MessageManager.getInstance().unRegisterListener(this.G);
        d.b.i0.c2.k.e.l.a().c();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (I() != null) {
            d.b.i0.c2.k.e.l.a().h(P());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.t = false;
        m1(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        t1(z);
        if (I() != null && I().Q != null) {
            this.f20070f.Q.G();
        }
        if (z && this.t) {
            q1();
            L().h1(true);
        }
    }

    public void p1(boolean z) {
        this.q = z;
    }

    public void q1() {
        this.l.x();
        this.l.O();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.TRUE));
    }

    public void r1(int i) {
        View view = this.o;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void s1() {
        if (getView() != null) {
            ViewGroup viewGroup = (ViewGroup) getView();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                viewGroup.getChildAt(i).setVisibility(8);
            }
            showLoadingView(viewGroup);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        super.showLoadingView(view);
    }

    @Override // d.b.i0.c2.o.a
    public void t0(boolean z, int i, int i2, int i3, d.b.i0.c2.h.e eVar, String str, int i4) {
        if (getActivity() != null) {
            P0(z, i, i2, i3, eVar, str, i4, false);
        }
    }

    public void t1(boolean z) {
        if (z && this.p) {
            this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.f20072h.setNextPage(this.l);
            this.s = 2;
        }
    }
}
