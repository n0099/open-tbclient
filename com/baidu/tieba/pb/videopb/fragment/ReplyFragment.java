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
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
import d.a.m0.r.q.a2;
import d.a.n0.e2.k.e.m0;
import d.a.n0.e2.k.e.n;
import d.a.n0.e2.o.h;
import d.a.n0.e2.o.j;
import d.a.n0.e2.p.e;
import d.a.n0.e3.h0.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class ReplyFragment extends BaseVideoPBReplyFragment implements h, e.b {
    public int B;

    /* renamed from: e  reason: collision with root package name */
    public PbActivity f19560e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPbFragment f19561f;

    /* renamed from: g  reason: collision with root package name */
    public View f19562g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f19563h;

    /* renamed from: i  reason: collision with root package name */
    public j f19564i;
    public d.a.n0.e2.o.n.b j;
    public MultiNestedLayout k;
    public View o;
    public boolean t;
    public d.a.n0.e2.o.r.b u;
    public View v;
    public BdSwipeRefreshLayout w;
    public PbListView l = null;
    public View m = null;
    public d.a.n0.e2.p.e n = null;
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

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 1) {
                ReplyFragment.this.x().n4();
                ReplyFragment.this.x().p4();
            }
            if (ReplyFragment.this.x() != null) {
                ReplyFragment.this.x().a4(i2);
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

    /* loaded from: classes5.dex */
    public class b implements MultiNestedLayout.b {
        public b() {
        }

        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void a(int i2) {
            if (ReplyFragment.this.A != 1 || i2 == 1 || ReplyFragment.this.z == 0) {
                if (ReplyFragment.this.A != 0 || i2 == 0) {
                    if (ReplyFragment.this.A != 0 && i2 == 0) {
                        ReplyFragment.this.x().D4(8);
                    }
                } else if (ReplyFragment.this.o.getVisibility() != 0) {
                    ReplyFragment.this.x().D4(0);
                }
            } else {
                ReplyFragment.this.x().D4(8);
                ReplyFragment.this.o.setVisibility(0);
            }
            ReplyFragment.this.A = i2;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements f.g {
        public c() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.A() != null && ReplyFragment.this.A().o1(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.U0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || ReplyFragment.this.A() == null || ReplyFragment.this.A().C0() == null || ReplyFragment.this.A().C0().D() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            o oVar = null;
            Iterator<PostData> it = ReplyFragment.this.A().C0().D().iterator();
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
            if (oVar == null || ReplyFragment.this.f19564i == null || ReplyFragment.this.f19563h == null) {
                return;
            }
            ReplyFragment.this.A().C0().D().remove(oVar);
            if (ReplyFragment.this.f19564i.a() != null) {
                ReplyFragment.this.f19564i.a().remove(oVar);
            }
            if (ReplyFragment.this.f19563h.getListView2().getData() != null) {
                ReplyFragment.this.f19563h.getListView2().getData().remove(oVar);
            }
            ReplyFragment.this.f19564i.e();
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
                ReplyFragment.this.r1();
            } else {
                ReplyFragment.this.o();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements BdListView.p {
        public f() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (!ReplyFragment.this.C && ReplyFragment.this.S0() && ReplyFragment.this.A() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", ReplyFragment.this.A().S0());
                    statisticItem.param("fid", ReplyFragment.this.A().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    ReplyFragment.this.C = true;
                }
                if (ReplyFragment.this.A().k1(false)) {
                    ReplyFragment.this.p1();
                    if (ReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (ReplyFragment.this.A().C0() != null) {
                    ReplyFragment.this.k1();
                }
            }
        }
    }

    public static ReplyFragment h1(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.f19561f = videoPbFragment;
        return replyFragment;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel A() {
        return x().A();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity B() {
        PbActivity pbActivity = this.f19560e;
        return pbActivity != null ? pbActivity : x().B();
    }

    public final void R0(boolean z, int i2, int i3, int i4, d.a.n0.e2.h.e eVar, String str, int i5) {
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(B()).get(VideoPbViewModel.class);
        if (!z || A() == null || eVar == null) {
            return;
        }
        this.y = A().Q0();
        boolean isEnabled = this.w.isEnabled();
        if (eVar.w().c() == 0 && this.y) {
            this.w.setEnabled(false);
        } else if (!isEnabled) {
            this.w.setEnabled(true);
            this.w.o();
        }
        this.f19564i.g(videoPbViewModel.l());
        this.f19564i.h(this.y);
        this.f19564i.f(eVar);
        this.p = false;
        if (TbadkCoreApplication.isLogin()) {
            this.f19563h.setNextPage(this.l);
            this.s = 2;
            if (x() != null && x().S != null) {
                this.f19561f.S.V();
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
                this.f19563h.setNextPage(this.n);
            } else {
                this.f19563h.setNextPage(this.l);
            }
            this.s = 3;
        }
        if (this.u != null && this.v != null) {
            d.a.n0.e2.h.o oVar = new d.a.n0.e2.h.o(d.a.n0.e2.h.o.l);
            a2 L = eVar.L();
            if (L != null) {
                L.b1();
            }
            A().Q0();
            oVar.f56647h = g1();
            oVar.f56646g = eVar.f56614g;
            eVar.c();
            oVar.f56648i = eVar.a0();
            oVar.k = eVar.f56613f;
            oVar.j = L.E2();
            this.u.e(oVar);
        }
        ArrayList<PostData> D = eVar.D();
        if (eVar.w().b() != 0 && D != null && D.size() >= eVar.w().e()) {
            if (A().m0()) {
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
            if (ListUtils.getCount(D) != 0 && (ListUtils.getCount(D) != 1 || D.get(0) == null || D.get(0).A() != 1)) {
                if (eVar.w().b() == 0) {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.l.j();
            } else if (g1()) {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.B);
            } else {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.B);
            }
            if (eVar.w().b() == 0 || D == null) {
                k1();
            }
        }
        if (i3 == 2) {
            this.f19563h.setSelection(i4 > 1 ? (i4 + ((this.f19563h.getData() == null && eVar.D() == null) ? 0 : this.f19563h.getData().size() - eVar.D().size())) - 2 : 0);
        } else if (i3 != 3) {
            if (i3 == 4) {
                this.r = false;
            } else if (i3 == 5) {
                this.f19563h.setSelection(0);
            } else if (i3 == 6) {
                if (i5 == 1) {
                    Parcelable e2 = m0.b().e();
                    if (e2 instanceof RecyclerView.SavedState) {
                        this.f19563h.onRestoreInstanceState(e2);
                    }
                }
                this.f19563h.setSelection(0);
            } else if (i3 == 8) {
                int size = (this.f19563h.getData() == null && eVar.D() == null) ? 0 : this.f19563h.getData().size() - eVar.D().size();
                this.k.setMaxOffset();
                this.f19563h.setSelection(i4 > 0 ? i4 + size : 0);
                this.l.f();
                this.l.A(getString(R.string.pb_load_more_without_point));
                this.l.v();
            }
        } else if (i5 == 1) {
            Parcelable e3 = m0.b().e();
            if (e3 instanceof RecyclerView.SavedState) {
                this.f19563h.onRestoreInstanceState(e3);
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
            if (i5 == 0) {
                o1(true);
            }
        }
        x().i4(eVar);
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
        if (x() == null || x().S == null) {
            return;
        }
        this.f19561f.S.V();
    }

    public void U0() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.w;
        if (bdSwipeRefreshLayout == null || !bdSwipeRefreshLayout.isEnabled()) {
            return;
        }
        this.w.setRefreshing(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: V0 */
    public j G0() {
        return this.f19564i;
    }

    public int W0() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f19563h;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getFirstVisiblePosition();
        }
        return 0;
    }

    public int X0() {
        View childAt;
        BdTypeRecyclerView bdTypeRecyclerView = this.f19563h;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.f19563h.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int Y0() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f19563h;
        if (bdTypeRecyclerView != null) {
            int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
            return (A() == null || A().C0() == null || lastVisiblePosition < A().C0().D().size()) ? lastVisiblePosition : A().C0().D().size() - 2;
        }
        return 0;
    }

    public BdTypeRecyclerView Z0() {
        return this.f19563h;
    }

    public int a1() {
        return this.A;
    }

    public View b1() {
        return this.m;
    }

    public int c1() {
        return this.z;
    }

    public d.a.n0.e2.o.n.b d1() {
        return this.j;
    }

    public final void e1() {
        this.B = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        MultiNestedLayout multiNestedLayout = (MultiNestedLayout) this.f19562g.findViewById(R.id.multi_nested_layout);
        this.k = multiNestedLayout;
        multiNestedLayout.setScrollStateChangeListener(this.E);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f19562g.findViewById(R.id.video_pb_reply_list);
        this.f19563h = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        j jVar = new j(this, this.f19563h);
        this.f19564i = jVar;
        jVar.l(x().Z2());
        this.f19564i.i(x().a3());
        this.f19564i.k(x().d3());
        this.f19564i.j(this.j.i());
        this.f19564i.m(this.j.l());
        this.o = this.f19562g.findViewById(R.id.reply_pager_title_shadow);
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
        this.f19563h.setOnSrollToBottomListener(this.H);
        this.f19563h.addOnScrollListener(this.D);
        this.f19563h.setOnTouchListener(x().e3());
        if (this.x == null) {
            g gVar = new g(getPageContext());
            this.x = gVar;
            gVar.n();
            this.x.a(this.F);
        }
        if (this.w == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f19562g.findViewById(R.id.pb_video_pull_refresh_layout);
            this.w = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.x);
            this.w.setEnabled(false);
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0205);
        }
        View findViewById2 = this.f19562g.findViewById(R.id.video_pb_reply_all_title);
        this.v = findViewById2;
        d.a.n0.e2.o.r.b bVar = new d.a.n0.e2.o.r.b(findViewById2);
        this.u = bVar;
        bVar.i(x().Z2());
        this.u.j(x().N1);
        registerListener(this.G);
    }

    public void f1() {
        d.a.n0.e2.h.e C0 = A().C0();
        if (C0 == null) {
            return;
        }
        this.f19564i.h(A().Q0());
        this.f19564i.f(C0);
        this.f19564i.e();
        ArrayList<PostData> D = C0.D();
        if (C0.w().b() == 0 || D == null || D.size() < C0.w().e()) {
            if (ListUtils.getCount(D) != 0 && (ListUtils.getCount(D) != 1 || D.get(0) == null || D.get(0).A() != 1)) {
                if (C0.w().b() == 0) {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.l.j();
            } else if (g1()) {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.B);
            } else {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.B);
            }
        }
        x().i4(C0);
    }

    public boolean g1() {
        if (A() != null) {
            return A().h0();
        }
        return false;
    }

    public void i1(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f19563h;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setCanFling(z);
        }
    }

    public void j1() {
        if (this.f19563h == null) {
        }
    }

    public void k1() {
        if (this.s != 2) {
            this.f19563h.setNextPage(this.l);
            this.s = 2;
        }
    }

    public void l1(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f19563h;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.f19563h.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.f19563h.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    @Override // d.a.n0.e2.p.e.b
    public void m0(boolean z) {
        this.t = z;
    }

    public void m1(String str) {
        PbListView pbListView = this.l;
        if (pbListView != null) {
            pbListView.A(str);
        }
    }

    public void n1(String str) {
        PbListView pbListView = this.l;
        if (pbListView != null) {
            pbListView.F(str, this.B);
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

    public void o1(boolean z) {
        this.q = z;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(B()).get(VideoPbViewModel.class);
        videoPbViewModel.n().observe(this, new e());
        R0(true, 0, 3, 0, videoPbViewModel.c(), "", 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.f19560e = (PbActivity) context;
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
        d.a.n0.e2.o.r.b bVar = this.u;
        if (bVar != null) {
            bVar.h(i2);
        }
        j jVar = this.f19564i;
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
        this.j = new d.a.n0.e2.o.n.b(this);
        this.f19562g = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        e1();
        return this.f19562g;
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
            n.a().h(B());
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
        n.a().h(B());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        s1(z);
        if (x() != null && x().S != null) {
            this.f19561f.S.H();
        }
        if (z && this.t) {
            p1();
            A().k1(true);
        }
    }

    public void p1() {
        this.l.x();
        this.l.O();
    }

    public void q1(int i2) {
        View view = this.o;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public void r1() {
        if (getView() != null) {
            ViewGroup viewGroup = (ViewGroup) getView();
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                viewGroup.getChildAt(i2).setVisibility(8);
            }
            showLoadingView(viewGroup);
        }
    }

    public void s1(boolean z) {
        if (z && this.p) {
            this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.f19563h.setNextPage(this.l);
            this.s = 2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        super.showLoadingView(view);
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment x() {
        PbActivity pbActivity;
        if (this.f19561f == null && (pbActivity = this.f19560e) != null) {
            Fragment findFragment = pbActivity.findFragment();
            if (findFragment instanceof VideoPbFragment) {
                this.f19561f = (VideoPbFragment) findFragment;
            }
        }
        return this.f19561f;
    }

    @Override // d.a.n0.e2.o.h
    public void z0(boolean z, int i2, int i3, int i4, d.a.n0.e2.h.e eVar, String str, int i5) {
        if (getActivity() != null) {
            R0(z, i2, i3, i4, eVar, str, i5);
        }
    }
}
