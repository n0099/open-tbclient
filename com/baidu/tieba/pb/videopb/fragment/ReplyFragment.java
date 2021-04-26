package com.baidu.tieba.pb.videopb.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.MultiNestedLayout;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.c.e.p.l;
import d.a.i0.r.f0.f;
import d.a.i0.r.f0.g;
import d.a.i0.r.q.a2;
import d.a.j0.d2.k.e.m0;
import d.a.j0.d2.k.e.n;
import d.a.j0.d2.o.h;
import d.a.j0.d2.o.j;
import d.a.j0.d2.p.e;
import d.a.j0.d3.h0.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class ReplyFragment extends BaseVideoPBReplyFragment implements h, e.b {
    public int B;

    /* renamed from: e  reason: collision with root package name */
    public PbActivity f20273e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPbFragment f20274f;

    /* renamed from: g  reason: collision with root package name */
    public View f20275g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f20276h;

    /* renamed from: i  reason: collision with root package name */
    public j f20277i;
    public d.a.j0.d2.o.n.b j;
    public MultiNestedLayout k;
    public View o;
    public boolean t;
    public d.a.j0.d2.o.r.b u;
    public View v;
    public BdSwipeRefreshLayout w;
    public PbListView l = null;
    public View m = null;
    public d.a.j0.d2.p.e n = null;
    public boolean p = false;
    public boolean q = false;
    public boolean r = true;
    public int s = 0;
    public g x = null;
    public boolean y = false;
    public int z = 0;
    public int A = 0;
    public boolean C = false;
    public RecyclerView.OnScrollListener D = new a();
    public MultiNestedLayout.b E = new b();
    public final f.g F = new c();
    public CustomMessageListener G = new d(2016331);
    public final BdListView.p H = new f();

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 1) {
                ReplyFragment.this.w().j4();
                ReplyFragment.this.w().l4();
            }
            if (ReplyFragment.this.w() != null) {
                ReplyFragment.this.w().W3(i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if (recyclerView.canScrollVertically(-1)) {
                ReplyFragment.this.z = 2;
                return;
            }
            if (Math.abs(i3) > 0 && ReplyFragment.this.z != 0) {
                ReplyFragment.this.o.setVisibility(8);
            }
            ReplyFragment.this.z = 0;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements MultiNestedLayout.b {
        public b() {
        }

        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void a(int i2) {
            if (ReplyFragment.this.A != 1 || i2 == 1 || ReplyFragment.this.z == 0) {
                if (ReplyFragment.this.A != 0 || i2 == 0) {
                    if (ReplyFragment.this.A != 0 && i2 == 0) {
                        ReplyFragment.this.w().z4(8);
                    }
                } else if (ReplyFragment.this.o.getVisibility() != 0) {
                    ReplyFragment.this.w().z4(0);
                }
            } else {
                ReplyFragment.this.w().z4(8);
                ReplyFragment.this.o.setVisibility(0);
            }
            ReplyFragment.this.A = i2;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements f.g {
        public c() {
        }

        @Override // d.a.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.z() != null && ReplyFragment.this.z().l1(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.S0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || ReplyFragment.this.z() == null || ReplyFragment.this.z().y0() == null || ReplyFragment.this.z().y0().D() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            o oVar = null;
            Iterator<PostData> it = ReplyFragment.this.z().y0().D().iterator();
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
            if (oVar == null || ReplyFragment.this.f20277i == null || ReplyFragment.this.f20276h == null) {
                return;
            }
            ReplyFragment.this.z().y0().D().remove(oVar);
            if (ReplyFragment.this.f20277i.a() != null) {
                ReplyFragment.this.f20277i.a().remove(oVar);
            }
            if (ReplyFragment.this.f20276h.getListView2().getData() != null) {
                ReplyFragment.this.f20276h.getListView2().getData().remove(oVar);
            }
            ReplyFragment.this.f20277i.e();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Observer<Boolean> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            if (bool != null && bool.booleanValue()) {
                ReplyFragment.this.p1();
            } else {
                ReplyFragment.this.n();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements BdListView.p {
        public f() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (!ReplyFragment.this.C && ReplyFragment.this.Q0() && ReplyFragment.this.z() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", ReplyFragment.this.z().O0());
                    statisticItem.param("fid", ReplyFragment.this.z().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    ReplyFragment.this.C = true;
                }
                if (ReplyFragment.this.z().h1(false)) {
                    ReplyFragment.this.n1();
                    if (ReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (ReplyFragment.this.z().y0() != null) {
                    ReplyFragment.this.i1();
                }
            }
        }
    }

    public static ReplyFragment f1(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.f20274f = videoPbFragment;
        return replyFragment;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity A() {
        PbActivity pbActivity = this.f20273e;
        return pbActivity != null ? pbActivity : w().A();
    }

    public final void P0(boolean z, int i2, int i3, int i4, d.a.j0.d2.h.e eVar, String str, int i5) {
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(A()).get(VideoPbViewModel.class);
        if (!z || z() == null || eVar == null) {
            return;
        }
        this.y = z().M0();
        boolean isEnabled = this.w.isEnabled();
        if (eVar.w().c() == 0 && this.y) {
            this.w.setEnabled(false);
        } else if (!isEnabled) {
            this.w.setEnabled(true);
            this.w.o();
        }
        this.f20277i.g(videoPbViewModel.l());
        this.f20277i.h(this.y);
        this.f20277i.f(eVar);
        this.p = false;
        if (TbadkCoreApplication.isLogin()) {
            this.f20276h.setNextPage(this.l);
            this.s = 2;
            if (w() != null && w().S != null) {
                this.f20274f.S.T();
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
                this.f20276h.setNextPage(this.n);
            } else {
                this.f20276h.setNextPage(this.l);
            }
            this.s = 3;
        }
        if (this.u != null && this.v != null) {
            d.a.j0.d2.h.o oVar = new d.a.j0.d2.h.o(d.a.j0.d2.h.o.l);
            a2 L = eVar.L();
            if (L != null) {
                L.Z0();
            }
            z().M0();
            oVar.f52054h = e1();
            oVar.f52053g = eVar.f52021g;
            eVar.c();
            oVar.f52055i = eVar.a0();
            oVar.k = eVar.f52020f;
            oVar.j = L.A2();
            this.u.e(oVar);
        }
        ArrayList<PostData> D = eVar.D();
        if (eVar.w().b() != 0 && D != null && D.size() >= eVar.w().e()) {
            if (z().i0()) {
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
            if (ListUtils.getCount(D) != 0 && (ListUtils.getCount(D) != 1 || D.get(0) == null || D.get(0).A() != 1)) {
                if (eVar.w().b() == 0) {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.l.j();
            } else if (e1()) {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.B);
            } else {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.B);
            }
            if (eVar.w().b() == 0 || D == null) {
                i1();
            }
        }
        if (i3 == 2) {
            this.f20276h.setSelection(i4 > 1 ? (i4 + ((this.f20276h.getData() == null && eVar.D() == null) ? 0 : this.f20276h.getData().size() - eVar.D().size())) - 2 : 0);
        } else if (i3 != 3) {
            if (i3 == 4) {
                this.r = false;
            } else if (i3 == 5) {
                this.f20276h.setSelection(0);
            } else if (i3 == 6) {
                if (i5 == 1) {
                    Parcelable e2 = m0.b().e();
                    if (e2 instanceof RecyclerView.SavedState) {
                        this.f20276h.onRestoreInstanceState(e2);
                    }
                }
                this.f20276h.setSelection(0);
            } else if (i3 == 8) {
                int size = (this.f20276h.getData() == null && eVar.D() == null) ? 0 : this.f20276h.getData().size() - eVar.D().size();
                this.k.setMaxOffset();
                this.f20276h.setSelection(i4 > 0 ? i4 + size : 0);
                this.l.f();
                this.l.A(getString(R.string.pb_load_more_without_point));
                this.l.v();
            }
        } else if (i5 == 1) {
            Parcelable e3 = m0.b().e();
            if (e3 instanceof RecyclerView.SavedState) {
                this.f20276h.onRestoreInstanceState(e3);
                if (ListUtils.getCount(D) > 1 && eVar.w().b() > 0) {
                    this.l.f();
                    this.l.A(getString(R.string.pb_load_more_without_point));
                    this.l.v();
                }
            }
        }
        if (this.q) {
            h1();
            this.q = false;
            if (i5 == 0) {
                m1(true);
            }
        }
        w().e4(eVar);
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
        if (w() == null || w().S == null) {
            return;
        }
        this.f20274f.S.T();
    }

    public void S0() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.w;
        if (bdSwipeRefreshLayout == null || !bdSwipeRefreshLayout.isEnabled()) {
            return;
        }
        this.w.setRefreshing(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: T0 */
    public j E0() {
        return this.f20277i;
    }

    public int U0() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f20276h;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getFirstVisiblePosition();
        }
        return 0;
    }

    public int V0() {
        View childAt;
        BdTypeRecyclerView bdTypeRecyclerView = this.f20276h;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.f20276h.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int W0() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f20276h;
        if (bdTypeRecyclerView != null) {
            int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
            return (z() == null || z().y0() == null || lastVisiblePosition < z().y0().D().size()) ? lastVisiblePosition : z().y0().D().size() - 2;
        }
        return 0;
    }

    public BdTypeRecyclerView X0() {
        return this.f20276h;
    }

    public int Y0() {
        return this.A;
    }

    public View Z0() {
        return this.m;
    }

    public int a1() {
        return this.z;
    }

    public d.a.j0.d2.o.n.b b1() {
        return this.j;
    }

    public final void c1() {
        this.B = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        MultiNestedLayout multiNestedLayout = (MultiNestedLayout) this.f20275g.findViewById(R.id.multi_nested_layout);
        this.k = multiNestedLayout;
        multiNestedLayout.setScrollStateChangeListener(this.E);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f20275g.findViewById(R.id.video_pb_reply_list);
        this.f20276h = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        j jVar = new j(this, this.f20276h);
        this.f20277i = jVar;
        jVar.l(w().V2());
        this.f20277i.i(w().W2());
        this.f20277i.k(w().Z2());
        this.f20277i.j(this.j.i());
        this.f20277i.m(this.j.l());
        this.o = this.f20275g.findViewById(R.id.reply_pager_title_shadow);
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
        this.f20276h.setOnSrollToBottomListener(this.H);
        this.f20276h.addOnScrollListener(this.D);
        this.f20276h.setOnTouchListener(w().a3());
        if (this.x == null) {
            g gVar = new g(getPageContext());
            this.x = gVar;
            gVar.n();
            this.x.a(this.F);
        }
        if (this.w == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f20275g.findViewById(R.id.pb_video_pull_refresh_layout);
            this.w = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.x);
            this.w.setEnabled(false);
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0205);
        }
        View findViewById2 = this.f20275g.findViewById(R.id.video_pb_reply_all_title);
        this.v = findViewById2;
        d.a.j0.d2.o.r.b bVar = new d.a.j0.d2.o.r.b(findViewById2);
        this.u = bVar;
        bVar.i(w().V2());
        this.u.j(w().M1);
        registerListener(this.G);
    }

    public void d1() {
        d.a.j0.d2.h.e y0 = z().y0();
        if (y0 == null) {
            return;
        }
        this.f20277i.h(z().M0());
        this.f20277i.f(y0);
        this.f20277i.e();
        ArrayList<PostData> D = y0.D();
        if (y0.w().b() == 0 || D == null || D.size() < y0.w().e()) {
            if (ListUtils.getCount(D) != 0 && (ListUtils.getCount(D) != 1 || D.get(0) == null || D.get(0).A() != 1)) {
                if (y0.w().b() == 0) {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.l.j();
            } else if (e1()) {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.B);
            } else {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.B);
            }
        }
        w().e4(y0);
    }

    public boolean e1() {
        if (z() != null) {
            return z().d0();
        }
        return false;
    }

    public void g1(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f20276h;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setCanFling(z);
        }
    }

    public void h1() {
        if (this.f20276h == null) {
        }
    }

    public void i1() {
        if (this.s != 2) {
            this.f20276h.setNextPage(this.l);
            this.s = 2;
        }
    }

    @Override // d.a.j0.d2.p.e.b
    public void j0(boolean z) {
        this.t = z;
    }

    public void j1(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f20276h;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.f20276h.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.f20276h.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public void k1(String str) {
        PbListView pbListView = this.l;
        if (pbListView != null) {
            pbListView.A(str);
        }
    }

    public void l1(String str) {
        PbListView pbListView = this.l;
        if (pbListView != null) {
            pbListView.F(str, this.B);
        }
    }

    public void m1(boolean z) {
        this.q = z;
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

    public void n1() {
        this.l.x();
        this.l.O();
    }

    public void o1(int i2) {
        View view = this.o;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(A()).get(VideoPbViewModel.class);
        videoPbViewModel.n().observe(this, new e());
        P0(true, 0, 3, 0, videoPbViewModel.c(), "", 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.f20273e = (PbActivity) context;
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
        d.a.j0.d2.o.r.b bVar = this.u;
        if (bVar != null) {
            bVar.h(i2);
        }
        j jVar = this.f20277i;
        if (jVar != null) {
            jVar.e();
        }
        View view = this.o;
        if (view != null) {
            SkinManager.setBackgroundResource(view, R.drawable.personalize_tab_shadow);
        }
        SkinManager.setBackgroundColor(this.w, R.color.CAM_X0201);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.j = new d.a.j0.d2.o.n.b(this);
        this.f20275g = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        c1();
        return this.f20275g;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.G);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            n.a().e();
        } else {
            n.a().h(A());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.t = false;
        if (isPrimary()) {
            n.a().e();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        n.a().h(A());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        q1(z);
        if (w() != null && w().S != null) {
            this.f20274f.S.G();
        }
        if (z && this.t) {
            n1();
            z().h1(true);
        }
    }

    public void p1() {
        if (getView() != null) {
            ViewGroup viewGroup = (ViewGroup) getView();
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                viewGroup.getChildAt(i2).setVisibility(8);
            }
            showLoadingView(viewGroup);
        }
    }

    public void q1(boolean z) {
        if (z && this.p) {
            this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.f20276h.setNextPage(this.l);
            this.s = 2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        super.showLoadingView(view);
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment w() {
        PbActivity pbActivity;
        if (this.f20274f == null && (pbActivity = this.f20273e) != null) {
            Fragment findFragment = pbActivity.findFragment();
            if (findFragment instanceof VideoPbFragment) {
                this.f20274f = (VideoPbFragment) findFragment;
            }
        }
        return this.f20274f;
    }

    @Override // d.a.j0.d2.o.h
    public void x0(boolean z, int i2, int i3, int i4, d.a.j0.d2.h.e eVar, String str, int i5) {
        if (getActivity() != null) {
            P0(z, i2, i3, i4, eVar, str, i5);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel z() {
        return w().z();
    }
}
