package com.baidu.tieba.pb.videopb.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.o0.r.f0.f;
import d.a.o0.r.f0.g;
import d.a.o0.r.q.b2;
import d.a.p0.h2.k.e.m0;
import d.a.p0.h2.k.e.n;
import d.a.p0.h2.p.e;
import d.a.p0.h3.h0.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class ReplyFragment extends BaseVideoPBReplyFragment implements d.a.p0.h2.o.a, e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public RecyclerView.OnScrollListener D;
    public MultiNestedLayout.b E;
    public final f.g F;
    public CustomMessageListener G;
    public final BdListView.p H;

    /* renamed from: e  reason: collision with root package name */
    public PbActivity f19832e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPbFragment f19833f;

    /* renamed from: g  reason: collision with root package name */
    public View f19834g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f19835h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.p0.h2.o.c f19836i;
    public d.a.p0.h2.o.g.b j;
    public MultiNestedLayout k;
    public PbListView l;
    public View m;
    public d.a.p0.h2.p.e n;
    public View o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;
    public boolean t;
    public d.a.p0.h2.o.k.b u;
    public View v;
    public BdSwipeRefreshLayout w;
    public g x;
    public boolean y;
    public int z;

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f19837a;

        public a(ReplyFragment replyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19837a = replyFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 1) {
                    this.f19837a.v().k4();
                    this.f19837a.v().m4();
                }
                if (this.f19837a.v() != null) {
                    this.f19837a.v().X3(i2);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (recyclerView.canScrollVertically(-1)) {
                    this.f19837a.z = 2;
                    return;
                }
                if (Math.abs(i3) > 0 && this.f19837a.z != 0) {
                    this.f19837a.o.setVisibility(8);
                }
                this.f19837a.z = 0;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements MultiNestedLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f19838a;

        public b(ReplyFragment replyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19838a = replyFragment;
        }

        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f19838a.A != 1 || i2 == 1 || this.f19838a.z == 0) {
                    if (this.f19838a.A != 0 || i2 == 0) {
                        if (this.f19838a.A != 0 && i2 == 0) {
                            this.f19838a.v().A4(8);
                        }
                    } else if (this.f19838a.o.getVisibility() != 0) {
                        this.f19838a.v().A4(0);
                    }
                } else {
                    this.f19838a.v().A4(8);
                    this.f19838a.o.setVisibility(0);
                }
                this.f19838a.A = i2;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f19839e;

        public c(ReplyFragment replyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19839e = replyFragment;
        }

        @Override // d.a.o0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.f19839e.y() != null && this.f19839e.y().p1(true)) {
                    TiebaStatic.eventStat(this.f19839e.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.f19839e.V0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f19840a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ReplyFragment replyFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19840a = replyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f19840a.y() == null || this.f19840a.y().D0() == null || this.f19840a.y().D0().E() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            o oVar = null;
            Iterator<PostData> it = this.f19840a.y().D0().E().iterator();
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
            if (oVar == null || this.f19840a.f19836i == null || this.f19840a.f19835h == null) {
                return;
            }
            this.f19840a.y().D0().E().remove(oVar);
            if (this.f19840a.f19836i.a() != null) {
                this.f19840a.f19836i.a().remove(oVar);
            }
            if (this.f19840a.f19835h.getListView2().getData() != null) {
                this.f19840a.f19835h.getListView2().getData().remove(oVar);
            }
            this.f19840a.f19836i.e();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f19841e;

        public e(ReplyFragment replyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19841e = replyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.f19841e.s1();
                } else {
                    this.f19841e.l();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f19842e;

        public f(ReplyFragment replyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19842e = replyFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f19842e.mIsLogin) {
                if (!this.f19842e.C && this.f19842e.T0() && this.f19842e.y() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.f19842e.y().T0());
                    statisticItem.param("fid", this.f19842e.y().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    this.f19842e.C = true;
                }
                if (this.f19842e.y().l1(false)) {
                    this.f19842e.q1();
                    if (this.f19842e.getPageContext() != null) {
                        TiebaStatic.eventStat(this.f19842e.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (this.f19842e.y().D0() != null) {
                    this.f19842e.l1();
                }
            }
        }
    }

    public ReplyFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = null;
        this.m = null;
        this.n = null;
        this.p = false;
        this.q = false;
        this.r = true;
        this.s = 0;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 0;
        this.C = false;
        this.D = new a(this);
        this.E = new b(this);
        this.F = new c(this);
        this.G = new d(this, 2016331);
        this.H = new f(this);
    }

    public static ReplyFragment i1(VideoPbFragment videoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, videoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            ReplyFragment replyFragment = new ReplyFragment();
            replyFragment.setArguments(bundle);
            replyFragment.f19833f = videoPbFragment;
            return replyFragment;
        }
        return (ReplyFragment) invokeL.objValue;
    }

    public final void S0(boolean z, int i2, int i3, int i4, d.a.p0.h2.h.e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(z()).get(VideoPbViewModel.class);
            if (!z || y() == null || eVar == null) {
                return;
            }
            this.y = y().R0();
            boolean isEnabled = this.w.isEnabled();
            if (eVar.x().c() == 0 && this.y) {
                this.w.setEnabled(false);
            } else if (!isEnabled) {
                this.w.setEnabled(true);
                this.w.o();
            }
            this.f19836i.g(videoPbViewModel.l());
            this.f19836i.h(this.y);
            this.f19836i.f(eVar);
            this.p = false;
            if (TbadkCoreApplication.isLogin()) {
                this.f19835h.setNextPage(this.l);
                this.s = 2;
                if (v() != null && v().T != null) {
                    this.f19833f.T.V();
                }
            } else {
                this.p = true;
                if (eVar.x().b() == 1) {
                    if (this.n == null) {
                        d.a.p0.h2.p.e eVar2 = new d.a.p0.h2.p.e(this, this);
                        this.n = eVar2;
                        eVar2.a();
                        this.n.g();
                    }
                    this.f19835h.setNextPage(this.n);
                } else {
                    this.f19835h.setNextPage(this.l);
                }
                this.s = 3;
            }
            if (this.u != null && this.v != null) {
                d.a.p0.h2.h.o oVar = new d.a.p0.h2.h.o(d.a.p0.h2.h.o.l);
                b2 N = eVar.N();
                if (N != null) {
                    N.P0();
                }
                y().R0();
                oVar.f56933h = h1();
                oVar.f56932g = eVar.f56899g;
                eVar.c();
                oVar.f56934i = eVar.e0();
                oVar.k = eVar.f56898f;
                oVar.j = N.r2();
                this.u.e(oVar);
            }
            ArrayList<PostData> E = eVar.E();
            if (eVar.x().b() != 0 && E != null && E.size() >= eVar.x().e()) {
                if (y().n0()) {
                    if (this.r) {
                        U0();
                        if (eVar.x().b() != 0) {
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
                if (ListUtils.getCount(E) != 0 && (ListUtils.getCount(E) != 1 || E.get(0) == null || E.get(0).A() != 1)) {
                    if (eVar.x().b() == 0) {
                        this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.l.j();
                } else if (h1()) {
                    this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.B);
                } else {
                    this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.B);
                }
                if (eVar.x().b() == 0 || E == null) {
                    l1();
                }
            }
            if (i3 == 2) {
                this.f19835h.setSelection(i4 > 1 ? (i4 + ((this.f19835h.getData() == null && eVar.E() == null) ? 0 : this.f19835h.getData().size() - eVar.E().size())) - 2 : 0);
            } else if (i3 != 3) {
                if (i3 == 4) {
                    this.r = false;
                } else if (i3 == 5) {
                    this.f19835h.setSelection(0);
                } else if (i3 == 6) {
                    if (i5 == 1) {
                        Parcelable e2 = m0.b().e();
                        if (e2 instanceof RecyclerView.SavedState) {
                            this.f19835h.onRestoreInstanceState(e2);
                        }
                    }
                    this.f19835h.setSelection(0);
                } else if (i3 == 8) {
                    int size = (this.f19835h.getData() == null && eVar.E() == null) ? 0 : this.f19835h.getData().size() - eVar.E().size();
                    this.k.setMaxOffset();
                    this.f19835h.setSelection(i4 > 0 ? i4 + size : 0);
                    this.l.f();
                    this.l.A(getString(R.string.pb_load_more_without_point));
                    this.l.v();
                }
            } else if (i5 == 1) {
                Parcelable e3 = m0.b().e();
                if (e3 instanceof RecyclerView.SavedState) {
                    this.f19835h.onRestoreInstanceState(e3);
                    if (ListUtils.getCount(E) > 1 && eVar.x().b() > 0) {
                        this.l.f();
                        this.l.A(getString(R.string.pb_load_more_without_point));
                        this.l.v();
                    }
                }
            }
            if (this.q) {
                k1();
                this.q = false;
                if (i5 == 0) {
                    p1(true);
                }
            }
            v().f4(eVar);
        }
    }

    public boolean T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbListView pbListView = this.l;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.l.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
        }
        return invokeV.booleanValue;
    }

    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PbListView pbListView = this.l;
            if (pbListView != null) {
                pbListView.v();
                this.l.f();
            }
            if (v() == null || v().T == null) {
                return;
            }
            this.f19833f.T.V();
        }
    }

    public void V0() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bdSwipeRefreshLayout = this.w) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.w.setRefreshing(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: W0 */
    public d.a.p0.h2.o.c H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19836i : (d.a.p0.h2.o.c) invokeV.objValue;
    }

    public int X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19835h;
            if (bdTypeRecyclerView != null) {
                return bdTypeRecyclerView.getFirstVisiblePosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int Y0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19835h;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.f19835h.getChildAt(0)) == null) {
                return 0;
            }
            return childAt.getTop();
        }
        return invokeV.intValue;
    }

    public int Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19835h;
            if (bdTypeRecyclerView != null) {
                int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
                return (y() == null || y().D0() == null || lastVisiblePosition < y().D0().E().size()) ? lastVisiblePosition : y().D0().E().size() - 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public BdTypeRecyclerView a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f19835h : (BdTypeRecyclerView) invokeV.objValue;
    }

    public int b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.A : invokeV.intValue;
    }

    public View c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public int d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.z : invokeV.intValue;
    }

    public d.a.p0.h2.o.g.b e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.j : (d.a.p0.h2.o.g.b) invokeV.objValue;
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.B = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            MultiNestedLayout multiNestedLayout = (MultiNestedLayout) this.f19834g.findViewById(R.id.multi_nested_layout);
            this.k = multiNestedLayout;
            multiNestedLayout.setScrollStateChangeListener(this.E);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f19834g.findViewById(R.id.video_pb_reply_list);
            this.f19835h = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            d.a.p0.h2.o.c cVar = new d.a.p0.h2.o.c(this, this.f19835h);
            this.f19836i = cVar;
            cVar.l(v().d3());
            this.f19836i.i(v().e3());
            this.f19836i.k(v().h3());
            this.f19836i.j(this.j.i());
            this.f19836i.m(this.j.l());
            this.o = this.f19834g.findViewById(R.id.reply_pager_title_shadow);
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.l = pbListView;
            View findViewById = pbListView.b().findViewById(R.id.pb_more_view);
            this.m = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(v().d3());
                SkinManager.setBackgroundResource(this.m, R.drawable.pb_foot_more_trans_selector);
            }
            this.l.x();
            this.l.n(R.drawable.pb_foot_more_trans_selector);
            this.l.o(R.drawable.pb_foot_more_trans_selector);
            this.l.q();
            this.f19835h.setOnSrollToBottomListener(this.H);
            this.f19835h.addOnScrollListener(this.D);
            this.f19835h.setOnTouchListener(v().i3());
            if (this.x == null) {
                g gVar = new g(getPageContext());
                this.x = gVar;
                gVar.n();
                this.x.a(this.F);
            }
            if (this.w == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f19834g.findViewById(R.id.pb_video_pull_refresh_layout);
                this.w = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.x);
                this.w.setEnabled(false);
                SkinManager.setBackgroundColor(this.w, R.color.CAM_X0205);
            }
            View findViewById2 = this.f19834g.findViewById(R.id.video_pb_reply_all_title);
            this.v = findViewById2;
            d.a.p0.h2.o.k.b bVar = new d.a.p0.h2.o.k.b(findViewById2);
            this.u = bVar;
            bVar.i(v().d3());
            this.u.j(v().P1);
            registerListener(this.G);
        }
    }

    public void g1() {
        d.a.p0.h2.h.e D0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (D0 = y().D0()) == null) {
            return;
        }
        this.f19836i.h(y().R0());
        this.f19836i.f(D0);
        this.f19836i.e();
        ArrayList<PostData> E = D0.E();
        if (D0.x().b() == 0 || E == null || E.size() < D0.x().e()) {
            if (ListUtils.getCount(E) != 0 && (ListUtils.getCount(E) != 1 || E.get(0) == null || E.get(0).A() != 1)) {
                if (D0.x().b() == 0) {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.l.j();
            } else if (h1()) {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.B);
            } else {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.B);
            }
        }
        v().f4(D0);
    }

    public boolean h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (y() != null) {
                return y().i0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j1(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (bdTypeRecyclerView = this.f19835h) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    public void k1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || this.f19835h == null) {
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || getView() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        hideLoadingView(viewGroup);
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setVisibility(0);
        }
    }

    public void l1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.s == 2) {
            return;
        }
        this.f19835h.setNextPage(this.l);
        this.s = 2;
    }

    @Override // d.a.p0.h2.p.e.b
    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.t = z;
        }
    }

    public void m1(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048598, this, i2, i3) == null) || (bdTypeRecyclerView = this.f19835h) == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.f19835h.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.f19835h.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public void n1(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || (pbListView = this.l) == null) {
            return;
        }
        pbListView.A(str);
    }

    public void o1(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || (pbListView = this.l) == null) {
            return;
        }
        pbListView.F(str, this.B);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(z()).get(VideoPbViewModel.class);
            videoPbViewModel.n().observe(this, new e(this));
            S0(true, 0, 3, 0, videoPbViewModel.c(), "", 1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, context) == null) {
            super.onAttach(context);
            if (context instanceof PbActivity) {
                this.f19832e = (PbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            super.onChangeSkinType(i2);
            PbListView pbListView = this.l;
            if (pbListView != null) {
                pbListView.d(i2);
                if (this.m != null) {
                    getBaseFragmentActivity().getLayoutMode().j(this.m);
                    SkinManager.setBackgroundResource(this.m, R.drawable.pb_foot_more_trans_selector);
                }
            }
            d.a.p0.h2.o.k.b bVar = this.u;
            if (bVar != null) {
                bVar.h(i2);
            }
            d.a.p0.h2.o.c cVar = this.f19836i;
            if (cVar != null) {
                cVar.e();
            }
            View view = this.o;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.drawable.personalize_tab_shadow);
            }
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048605, this, layoutInflater, viewGroup, bundle)) == null) {
            this.j = new d.a.p0.h2.o.g.b(this);
            this.f19834g = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
            f1();
            return this.f19834g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.G);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                n.a().f();
            } else {
                n.a().j(z());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onResume();
            this.t = false;
            if (isPrimary()) {
                n.a().f();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onStop();
            n.a().j(z());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            super.onUserChanged(z);
            t1(z);
            if (v() != null && v().T != null) {
                this.f19833f.T.H();
            }
            if (z && this.t) {
                q1();
                y().l1(true);
            }
        }
    }

    public void p1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.q = z;
        }
    }

    public void q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.l.x();
            this.l.O();
        }
    }

    public void r1(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048613, this, i2) == null) || (view = this.o) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void s1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || getView() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setVisibility(8);
        }
        showLoadingView(viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, view) == null) {
            super.showLoadingView(view);
        }
    }

    public void t1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048616, this, z) == null) && z && this.p) {
            this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.f19835h.setNextPage(this.l);
            this.s = 2;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment v() {
        InterceptResult invokeV;
        PbActivity pbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.f19833f == null && (pbActivity = this.f19832e) != null) {
                Fragment findFragment = pbActivity.findFragment();
                if (findFragment instanceof VideoPbFragment) {
                    this.f19833f = (VideoPbFragment) findFragment;
                }
            }
            return this.f19833f;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? v().y() : (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            PbActivity pbActivity = this.f19832e;
            return pbActivity != null ? pbActivity : v().z();
        }
        return (PbActivity) invokeV.objValue;
    }

    @Override // d.a.p0.h2.o.a
    public void z0(boolean z, int i2, int i3, int i4, d.a.p0.h2.h.e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) || getActivity() == null) {
            return;
        }
        S0(z, i2, i3, i4, eVar, str, i5);
    }
}
