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
import d.a.r0.r.f0.f;
import d.a.r0.r.f0.g;
import d.a.r0.r.q.b2;
import d.a.s0.h2.k.e.m0;
import d.a.s0.h2.k.e.n;
import d.a.s0.h2.p.e;
import d.a.s0.h3.h0.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class ReplyFragment extends BaseVideoPBReplyFragment implements d.a.s0.h2.o.a, e.b {
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
    public PbActivity f19792e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPbFragment f19793f;

    /* renamed from: g  reason: collision with root package name */
    public View f19794g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f19795h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.h2.o.c f19796i;
    public d.a.s0.h2.o.g.b j;
    public MultiNestedLayout k;
    public PbListView l;
    public View m;
    public d.a.s0.h2.p.e n;
    public View o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;
    public boolean t;
    public d.a.s0.h2.o.k.b u;
    public View v;
    public BdSwipeRefreshLayout w;
    public g x;
    public boolean y;
    public int z;

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f19797a;

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
            this.f19797a = replyFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 1) {
                    this.f19797a.v().j4();
                    this.f19797a.v().l4();
                }
                if (this.f19797a.v() != null) {
                    this.f19797a.v().W3(i2);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (recyclerView.canScrollVertically(-1)) {
                    this.f19797a.z = 2;
                    return;
                }
                if (Math.abs(i3) > 0 && this.f19797a.z != 0) {
                    this.f19797a.o.setVisibility(8);
                }
                this.f19797a.z = 0;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements MultiNestedLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f19798a;

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
            this.f19798a = replyFragment;
        }

        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f19798a.A != 1 || i2 == 1 || this.f19798a.z == 0) {
                    if (this.f19798a.A != 0 || i2 == 0) {
                        if (this.f19798a.A != 0 && i2 == 0) {
                            this.f19798a.v().z4(8);
                        }
                    } else if (this.f19798a.o.getVisibility() != 0) {
                        this.f19798a.v().z4(0);
                    }
                } else {
                    this.f19798a.v().z4(8);
                    this.f19798a.o.setVisibility(0);
                }
                this.f19798a.A = i2;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f19799e;

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
            this.f19799e = replyFragment;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.f19799e.y() != null && this.f19799e.y().p1(true)) {
                    TiebaStatic.eventStat(this.f19799e.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.f19799e.U0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f19800a;

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
            this.f19800a = replyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f19800a.y() == null || this.f19800a.y().D0() == null || this.f19800a.y().D0().E() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            o oVar = null;
            Iterator<PostData> it = this.f19800a.y().D0().E().iterator();
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
            if (oVar == null || this.f19800a.f19796i == null || this.f19800a.f19795h == null) {
                return;
            }
            this.f19800a.y().D0().E().remove(oVar);
            if (this.f19800a.f19796i.a() != null) {
                this.f19800a.f19796i.a().remove(oVar);
            }
            if (this.f19800a.f19795h.getListView2().getData() != null) {
                this.f19800a.f19795h.getListView2().getData().remove(oVar);
            }
            this.f19800a.f19796i.e();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f19801e;

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
            this.f19801e = replyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.f19801e.r1();
                } else {
                    this.f19801e.m();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f19802e;

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
            this.f19802e = replyFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f19802e.mIsLogin) {
                if (!this.f19802e.C && this.f19802e.S0() && this.f19802e.y() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.f19802e.y().T0());
                    statisticItem.param("fid", this.f19802e.y().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    this.f19802e.C = true;
                }
                if (this.f19802e.y().l1(false)) {
                    this.f19802e.p1();
                    if (this.f19802e.getPageContext() != null) {
                        TiebaStatic.eventStat(this.f19802e.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (this.f19802e.y().D0() != null) {
                    this.f19802e.k1();
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

    public static ReplyFragment h1(VideoPbFragment videoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, videoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            ReplyFragment replyFragment = new ReplyFragment();
            replyFragment.setArguments(bundle);
            replyFragment.f19793f = videoPbFragment;
            return replyFragment;
        }
        return (ReplyFragment) invokeL.objValue;
    }

    public final void R0(boolean z, int i2, int i3, int i4, d.a.s0.h2.h.e eVar, String str, int i5) {
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
            this.f19796i.g(videoPbViewModel.l());
            this.f19796i.h(this.y);
            this.f19796i.f(eVar);
            this.p = false;
            if (TbadkCoreApplication.isLogin()) {
                this.f19795h.setNextPage(this.l);
                this.s = 2;
                if (v() != null && v().T != null) {
                    this.f19793f.T.V();
                }
            } else {
                this.p = true;
                if (eVar.x().b() == 1) {
                    if (this.n == null) {
                        d.a.s0.h2.p.e eVar2 = new d.a.s0.h2.p.e(this, this);
                        this.n = eVar2;
                        eVar2.a();
                        this.n.g();
                    }
                    this.f19795h.setNextPage(this.n);
                } else {
                    this.f19795h.setNextPage(this.l);
                }
                this.s = 3;
            }
            if (this.u != null && this.v != null) {
                d.a.s0.h2.h.o oVar = new d.a.s0.h2.h.o(d.a.s0.h2.h.o.l);
                b2 N = eVar.N();
                if (N != null) {
                    N.P0();
                }
                y().R0();
                oVar.f60177h = g1();
                oVar.f60176g = eVar.f60143g;
                eVar.c();
                oVar.f60178i = eVar.e0();
                oVar.k = eVar.f60142f;
                oVar.j = N.r2();
                this.u.e(oVar);
            }
            ArrayList<PostData> E = eVar.E();
            if (eVar.x().b() != 0 && E != null && E.size() >= eVar.x().e()) {
                if (y().n0()) {
                    if (this.r) {
                        T0();
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
                } else if (g1()) {
                    this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.B);
                } else {
                    this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.B);
                }
                if (eVar.x().b() == 0 || E == null) {
                    k1();
                }
            }
            if (i3 == 2) {
                this.f19795h.setSelection(i4 > 1 ? (i4 + ((this.f19795h.getData() == null && eVar.E() == null) ? 0 : this.f19795h.getData().size() - eVar.E().size())) - 2 : 0);
            } else if (i3 != 3) {
                if (i3 == 4) {
                    this.r = false;
                } else if (i3 == 5) {
                    this.f19795h.setSelection(0);
                } else if (i3 == 6) {
                    if (i5 == 1) {
                        Parcelable e2 = m0.b().e();
                        if (e2 instanceof RecyclerView.SavedState) {
                            this.f19795h.onRestoreInstanceState(e2);
                        }
                    }
                    this.f19795h.setSelection(0);
                } else if (i3 == 8) {
                    int size = (this.f19795h.getData() == null && eVar.E() == null) ? 0 : this.f19795h.getData().size() - eVar.E().size();
                    this.k.setMaxOffset();
                    this.f19795h.setSelection(i4 > 0 ? i4 + size : 0);
                    this.l.f();
                    this.l.A(getString(R.string.pb_load_more_without_point));
                    this.l.v();
                }
            } else if (i5 == 1) {
                Parcelable e3 = m0.b().e();
                if (e3 instanceof RecyclerView.SavedState) {
                    this.f19795h.onRestoreInstanceState(e3);
                    if (ListUtils.getCount(E) > 1 && eVar.x().b() > 0) {
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
            v().e4(eVar);
        }
    }

    public boolean S0() {
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

    public void T0() {
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
            this.f19793f.T.V();
        }
    }

    public void U0() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bdSwipeRefreshLayout = this.w) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.w.setRefreshing(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: V0 */
    public d.a.s0.h2.o.c G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19796i : (d.a.s0.h2.o.c) invokeV.objValue;
    }

    public int W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19795h;
            if (bdTypeRecyclerView != null) {
                return bdTypeRecyclerView.getFirstVisiblePosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int X0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19795h;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.f19795h.getChildAt(0)) == null) {
                return 0;
            }
            return childAt.getTop();
        }
        return invokeV.intValue;
    }

    public int Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19795h;
            if (bdTypeRecyclerView != null) {
                int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
                return (y() == null || y().D0() == null || lastVisiblePosition < y().D0().E().size()) ? lastVisiblePosition : y().D0().E().size() - 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public BdTypeRecyclerView Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f19795h : (BdTypeRecyclerView) invokeV.objValue;
    }

    public int a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.A : invokeV.intValue;
    }

    public View b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public int c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.z : invokeV.intValue;
    }

    public d.a.s0.h2.o.g.b d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.j : (d.a.s0.h2.o.g.b) invokeV.objValue;
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.B = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            MultiNestedLayout multiNestedLayout = (MultiNestedLayout) this.f19794g.findViewById(R.id.multi_nested_layout);
            this.k = multiNestedLayout;
            multiNestedLayout.setScrollStateChangeListener(this.E);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f19794g.findViewById(R.id.video_pb_reply_list);
            this.f19795h = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            d.a.s0.h2.o.c cVar = new d.a.s0.h2.o.c(this, this.f19795h);
            this.f19796i = cVar;
            cVar.l(v().c3());
            this.f19796i.i(v().d3());
            this.f19796i.k(v().g3());
            this.f19796i.j(this.j.i());
            this.f19796i.m(this.j.l());
            this.o = this.f19794g.findViewById(R.id.reply_pager_title_shadow);
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.l = pbListView;
            View findViewById = pbListView.b().findViewById(R.id.pb_more_view);
            this.m = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(v().c3());
                SkinManager.setBackgroundResource(this.m, R.drawable.pb_foot_more_trans_selector);
            }
            this.l.x();
            this.l.n(R.drawable.pb_foot_more_trans_selector);
            this.l.o(R.drawable.pb_foot_more_trans_selector);
            this.l.q();
            this.f19795h.setOnSrollToBottomListener(this.H);
            this.f19795h.addOnScrollListener(this.D);
            this.f19795h.setOnTouchListener(v().h3());
            if (this.x == null) {
                g gVar = new g(getPageContext());
                this.x = gVar;
                gVar.n();
                this.x.a(this.F);
            }
            if (this.w == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f19794g.findViewById(R.id.pb_video_pull_refresh_layout);
                this.w = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.x);
                this.w.setEnabled(false);
                SkinManager.setBackgroundColor(this.w, R.color.CAM_X0205);
            }
            View findViewById2 = this.f19794g.findViewById(R.id.video_pb_reply_all_title);
            this.v = findViewById2;
            d.a.s0.h2.o.k.b bVar = new d.a.s0.h2.o.k.b(findViewById2);
            this.u = bVar;
            bVar.i(v().c3());
            this.u.j(v().P1);
            registerListener(this.G);
        }
    }

    public void f1() {
        d.a.s0.h2.h.e D0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (D0 = y().D0()) == null) {
            return;
        }
        this.f19796i.h(y().R0());
        this.f19796i.f(D0);
        this.f19796i.e();
        ArrayList<PostData> E = D0.E();
        if (D0.x().b() == 0 || E == null || E.size() < D0.x().e()) {
            if (ListUtils.getCount(E) != 0 && (ListUtils.getCount(E) != 1 || E.get(0) == null || E.get(0).A() != 1)) {
                if (D0.x().b() == 0) {
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
        v().e4(D0);
    }

    public boolean g1() {
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

    public void i1(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (bdTypeRecyclerView = this.f19795h) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    public void j1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || this.f19795h == null) {
        }
    }

    public void k1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.s == 2) {
            return;
        }
        this.f19795h.setNextPage(this.l);
        this.s = 2;
    }

    public void l1(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) || (bdTypeRecyclerView = this.f19795h) == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.f19795h.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.f19795h.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || getView() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        hideLoadingView(viewGroup);
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setVisibility(0);
        }
    }

    @Override // d.a.s0.h2.p.e.b
    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.t = z;
        }
    }

    public void m1(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || (pbListView = this.l) == null) {
            return;
        }
        pbListView.A(str);
    }

    public void n1(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || (pbListView = this.l) == null) {
            return;
        }
        pbListView.F(str, this.B);
    }

    public void o1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.q = z;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(z()).get(VideoPbViewModel.class);
            videoPbViewModel.n().observe(this, new e(this));
            R0(true, 0, 3, 0, videoPbViewModel.c(), "", 1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, context) == null) {
            super.onAttach(context);
            if (context instanceof PbActivity) {
                this.f19792e = (PbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            super.onChangeSkinType(i2);
            PbListView pbListView = this.l;
            if (pbListView != null) {
                pbListView.d(i2);
                if (this.m != null) {
                    getBaseFragmentActivity().getLayoutMode().j(this.m);
                    SkinManager.setBackgroundResource(this.m, R.drawable.pb_foot_more_trans_selector);
                }
            }
            d.a.s0.h2.o.k.b bVar = this.u;
            if (bVar != null) {
                bVar.h(i2);
            }
            d.a.s0.h2.o.c cVar = this.f19796i;
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
        if (interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048606, this, layoutInflater, viewGroup, bundle)) == null) {
            this.j = new d.a.s0.h2.o.g.b(this);
            this.f19794g = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
            e1();
            return this.f19794g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.G);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onStop();
            n.a().j(z());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            super.onUserChanged(z);
            s1(z);
            if (v() != null && v().T != null) {
                this.f19793f.T.H();
            }
            if (z && this.t) {
                p1();
                y().l1(true);
            }
        }
    }

    public void p1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.l.x();
            this.l.O();
        }
    }

    public void q1(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048613, this, i2) == null) || (view = this.o) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void r1() {
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

    public void s1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z) == null) && z && this.p) {
            this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.f19795h.setNextPage(this.l);
            this.s = 2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, view) == null) {
            super.showLoadingView(view);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment v() {
        InterceptResult invokeV;
        PbActivity pbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.f19793f == null && (pbActivity = this.f19792e) != null) {
                Fragment findFragment = pbActivity.findFragment();
                if (findFragment instanceof VideoPbFragment) {
                    this.f19793f = (VideoPbFragment) findFragment;
                }
            }
            return this.f19793f;
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
            PbActivity pbActivity = this.f19792e;
            return pbActivity != null ? pbActivity : v().z();
        }
        return (PbActivity) invokeV.objValue;
    }

    @Override // d.a.s0.h2.o.a
    public void z0(boolean z, int i2, int i3, int i4, d.a.s0.h2.h.e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) || getActivity() == null) {
            return;
        }
        R0(z, i2, i3, i4, eVar, str, i5);
    }
}
