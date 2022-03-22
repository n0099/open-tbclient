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
import c.a.d.f.p.n;
import c.a.o0.r.l0.f;
import c.a.p0.a4.k0.o;
import c.a.p0.w2.i.r;
import c.a.p0.w2.m.f.i1.l;
import c.a.p0.w2.m.f.q;
import c.a.p0.w2.m.f.s0;
import c.a.p0.w2.r.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.MultiNestedLayout;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class ReplyFragment extends BaseVideoPBReplyFragment implements c.a.p0.w2.q.b, g.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView.OnScrollListener A;
    public MultiNestedLayout.b B;
    public final f.g C;
    public CustomMessageListener D;
    public final BdListView.p E;
    public AbsPbActivity a;

    /* renamed from: b  reason: collision with root package name */
    public AbsVideoPbFragment f35200b;

    /* renamed from: c  reason: collision with root package name */
    public View f35201c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f35202d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.w2.q.d f35203e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.w2.q.h.b f35204f;

    /* renamed from: g  reason: collision with root package name */
    public MultiNestedLayout f35205g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f35206h;
    public View i;
    public g j;
    public View k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public boolean p;
    public c.a.p0.w2.q.l.b q;
    public View r;
    public BdSwipeRefreshLayout s;
    public c.a.o0.r.l0.g t;
    public boolean u;
    public int v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyFragment a;

        public a(ReplyFragment replyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = replyFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1) {
                    this.a.t().j4();
                    this.a.t().l4();
                }
                if (this.a.t() != null) {
                    this.a.t().W3(i);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (recyclerView.canScrollVertically(-1)) {
                    this.a.v = 2;
                    return;
                }
                if (Math.abs(i2) > 0 && this.a.v != 0) {
                    this.a.k.setVisibility(8);
                }
                this.a.v = 0;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements MultiNestedLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyFragment a;

        public b(ReplyFragment replyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = replyFragment;
        }

        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.w != 1 || i == 1 || this.a.v == 0) {
                    if (this.a.w != 0 || i == 0) {
                        if (this.a.w != 0 && i == 0) {
                            this.a.t().B4(8);
                        }
                    } else if (this.a.k.getVisibility() != 0) {
                        this.a.t().B4(0);
                    }
                } else {
                    this.a.t().B4(8);
                    this.a.k.setVisibility(0);
                }
                this.a.w = i;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyFragment a;

        public c(ReplyFragment replyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = replyFragment;
        }

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.w() != null && this.a.w().O1(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.Q0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ReplyFragment replyFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = replyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.w() == null || this.a.w().S0() == null || this.a.w().S0().F() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            o oVar = null;
            Iterator<PostData> it = this.a.w().S0().F().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PostData next = it.next();
                if (next instanceof o) {
                    o oVar2 = (o) next;
                    if (str.equals(oVar2.K0())) {
                        oVar = oVar2;
                        break;
                    }
                }
            }
            if (oVar == null || this.a.f35203e == null || this.a.f35202d == null) {
                return;
            }
            this.a.w().S0().F().remove(oVar);
            if (this.a.f35203e.a() != null) {
                this.a.f35203e.a().remove(oVar);
            }
            if (this.a.f35202d.getListView2().getData() != null) {
                this.a.f35202d.getListView2().getData().remove(oVar);
            }
            this.a.f35203e.e();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyFragment a;

        public e(ReplyFragment replyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = replyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.a.n1();
                } else {
                    this.a.d();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyFragment a;

        public f(ReplyFragment replyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = replyFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.mIsLogin) {
                if (!this.a.y && this.a.O0() && this.a.w() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.w().k1());
                    statisticItem.param("fid", this.a.w().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    this.a.y = true;
                }
                if (this.a.w().K1(false)) {
                    this.a.l1();
                    if (this.a.getPageContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (this.a.w().S0() != null) {
                    this.a.g1();
                }
            }
        }
    }

    public ReplyFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35206h = null;
        this.i = null;
        this.j = null;
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = 0;
        this.t = null;
        this.u = false;
        this.v = 0;
        this.w = 0;
        this.y = false;
        this.A = new a(this);
        this.B = new b(this);
        this.C = new c(this);
        this.D = new d(this, 2016331);
        this.E = new f(this);
    }

    public static ReplyFragment d1(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            ReplyFragment replyFragment = new ReplyFragment();
            replyFragment.setArguments(bundle);
            replyFragment.f35200b = absVideoPbFragment;
            return replyFragment;
        }
        return (ReplyFragment) invokeL.objValue;
    }

    public final void N0(boolean z, int i, int i2, int i3, c.a.p0.w2.i.f fVar, String str, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fVar, str, Integer.valueOf(i4)}) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(x()).get(VideoPbViewModel.class);
            if (!z || w() == null || fVar == null) {
                return;
            }
            if (this.z) {
                w().a0();
            } else {
                this.z = true;
            }
            this.u = w().i1();
            boolean isEnabled = this.s.isEnabled();
            if (fVar.y().c() == 0 && this.u) {
                this.s.setEnabled(false);
            } else if (!isEnabled) {
                this.s.setEnabled(true);
                this.s.o();
            }
            this.f35203e.g(videoPbViewModel.l());
            this.f35203e.h(this.u);
            this.f35203e.f(fVar);
            this.l = false;
            if (TbadkCoreApplication.isLogin()) {
                this.f35202d.setNextPage(this.f35206h);
                this.o = 2;
                if (t() != null && t().N != null) {
                    this.f35200b.N.V();
                }
            } else {
                this.l = true;
                if (fVar.y().b() == 1) {
                    if (this.j == null) {
                        g gVar = new g(this, this);
                        this.j = gVar;
                        gVar.a();
                        this.j.g();
                    }
                    this.f35202d.setNextPage(this.j);
                } else {
                    this.f35202d.setNextPage(this.f35206h);
                }
                this.o = 3;
            }
            if (this.q != null && this.r != null) {
                r rVar = new r(r.f19847h);
                ThreadData O = fVar.O();
                if (O != null) {
                    O.getReply_num();
                }
                w().i1();
                rVar.f19850d = c1();
                rVar.f19849c = fVar.f19820g;
                fVar.c();
                rVar.f19851e = fVar.g0();
                rVar.f19853g = fVar.f19819f;
                rVar.f19852f = O.isVideoWorksInfo();
                this.q.e(rVar);
            }
            ArrayList<PostData> F = fVar.F();
            if (fVar.y().b() != 0 && F != null && F.size() >= fVar.y().e()) {
                if (w().C0()) {
                    if (this.n) {
                        P0();
                        if (fVar.y().b() != 0) {
                            this.f35206h.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0da7));
                        }
                    } else {
                        this.f35206h.A();
                        this.f35206h.O();
                    }
                } else {
                    this.f35206h.A();
                    this.f35206h.O();
                }
                this.f35206h.k();
            } else {
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                    if (fVar.y().b() == 0) {
                        this.f35206h.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
                    } else {
                        this.f35206h.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a2b));
                    }
                    this.f35206h.k();
                } else if (c1()) {
                    this.f35206h.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dae), this.x);
                } else {
                    this.f35206h.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0daf), this.x);
                }
                if (fVar.y().b() == 0 || F == null) {
                    g1();
                }
            }
            if (i2 == 2) {
                this.f35202d.setSelection(i3 > 1 ? (i3 + ((this.f35202d.getData() == null && fVar.F() == null) ? 0 : this.f35202d.getData().size() - fVar.F().size())) - 2 : 0);
            } else if (i2 != 3) {
                if (i2 == 4) {
                    this.n = false;
                } else if (i2 == 5) {
                    this.f35202d.setSelection(0);
                } else if (i2 == 6) {
                    if (i4 == 1) {
                        Parcelable e2 = s0.b().e();
                        if (e2 instanceof RecyclerView.SavedState) {
                            this.f35202d.onRestoreInstanceState(e2);
                        }
                    }
                    this.f35202d.setSelection(0);
                } else if (i2 == 8) {
                    int size = (this.f35202d.getData() == null && fVar.F() == null) ? 0 : this.f35202d.getData().size() - fVar.F().size();
                    this.f35205g.setMaxOffset();
                    this.f35202d.setSelection(i3 > 0 ? i3 + size : 0);
                    this.f35206h.f();
                    this.f35206h.D(getString(R.string.obfuscated_res_0x7f0f0da8));
                    this.f35206h.y();
                }
            } else if (i4 == 1) {
                Parcelable e3 = s0.b().e();
                if (e3 instanceof RecyclerView.SavedState) {
                    this.f35202d.onRestoreInstanceState(e3);
                    if (ListUtils.getCount(F) > 1 && fVar.y().b() > 0) {
                        this.f35206h.f();
                        this.f35206h.D(getString(R.string.obfuscated_res_0x7f0f0da8));
                        this.f35206h.y();
                    }
                }
            }
            if (this.m) {
                f1();
                this.m = false;
                if (i4 == 0) {
                    k1(true);
                }
            }
            t().e4(fVar);
            String u0 = w().u0();
            if (TextUtils.isEmpty(u0)) {
                return;
            }
            l.b(V0(), u0);
        }
    }

    public boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbListView pbListView = this.f35206h;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.f35206h.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
        }
        return invokeV.booleanValue;
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PbListView pbListView = this.f35206h;
            if (pbListView != null) {
                pbListView.y();
                this.f35206h.f();
            }
            if (t() == null || t().N == null) {
                return;
            }
            this.f35200b.N.V();
        }
    }

    public void Q0() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bdSwipeRefreshLayout = this.s) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.s.setRefreshing(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: R0 */
    public c.a.p0.w2.q.d C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f35203e : (c.a.p0.w2.q.d) invokeV.objValue;
    }

    public int S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f35202d;
            if (bdTypeRecyclerView != null) {
                return bdTypeRecyclerView.getFirstVisiblePosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int T0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f35202d;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.f35202d.getChildAt(0)) == null) {
                return 0;
            }
            return childAt.getTop();
        }
        return invokeV.intValue;
    }

    public int U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f35202d;
            if (bdTypeRecyclerView != null) {
                int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
                return (w() == null || w().S0() == null || lastVisiblePosition < w().S0().F().size()) ? lastVisiblePosition : w().S0().F().size() - 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public BdTypeRecyclerView V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f35202d : (BdTypeRecyclerView) invokeV.objValue;
    }

    public int W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.w : invokeV.intValue;
    }

    public View X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    public int Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.v : invokeV.intValue;
    }

    public c.a.p0.w2.q.h.b Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f35204f : (c.a.p0.w2.q.h.b) invokeV.objValue;
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.x = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            MultiNestedLayout multiNestedLayout = (MultiNestedLayout) this.f35201c.findViewById(R.id.obfuscated_res_0x7f091482);
            this.f35205g = multiNestedLayout;
            multiNestedLayout.setScrollStateChangeListener(this.B);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f35201c.findViewById(R.id.obfuscated_res_0x7f09235b);
            this.f35202d = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            c.a.p0.w2.q.d dVar = new c.a.p0.w2.q.d(this, this.f35202d);
            this.f35203e = dVar;
            dVar.l(t().Z2());
            this.f35203e.i(t().a3());
            this.f35203e.k(t().d3());
            this.f35203e.j(this.f35204f.i());
            this.f35203e.m(this.f35204f.l());
            this.k = this.f35201c.findViewById(R.id.obfuscated_res_0x7f091a69);
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.f35206h = pbListView;
            View findViewById = pbListView.b().findViewById(R.id.obfuscated_res_0x7f0916f0);
            this.i = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(t().Z2());
                SkinManager.setBackgroundResource(this.i, R.drawable.pb_foot_more_trans_selector);
            }
            this.f35206h.A();
            this.f35206h.o(R.drawable.pb_foot_more_trans_selector);
            this.f35206h.p(R.drawable.pb_foot_more_trans_selector);
            this.f35206h.s();
            this.f35202d.setOnSrollToBottomListener(this.E);
            this.f35202d.addOnScrollListener(this.A);
            this.f35202d.setOnTouchListener(t().e3());
            if (this.t == null) {
                c.a.o0.r.l0.g gVar = new c.a.o0.r.l0.g(getPageContext());
                this.t = gVar;
                gVar.n();
                this.t.f(this.C);
            }
            if (this.s == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f35201c.findViewById(R.id.obfuscated_res_0x7f091748);
                this.s = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.t);
                this.s.setEnabled(false);
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0205);
            }
            View findViewById2 = this.f35201c.findViewById(R.id.obfuscated_res_0x7f09235a);
            this.r = findViewById2;
            c.a.p0.w2.q.l.b bVar = new c.a.p0.w2.q.l.b(findViewById2);
            this.q = bVar;
            bVar.i(t().Z2());
            this.q.j(t().M1);
            registerListener(this.D);
        }
    }

    public void b1() {
        c.a.p0.w2.i.f S0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (S0 = w().S0()) == null) {
            return;
        }
        this.f35203e.h(w().i1());
        this.f35203e.f(S0);
        this.f35203e.e();
        ArrayList<PostData> F = S0.F();
        if (S0.y().b() == 0 || F == null || F.size() < S0.y().e()) {
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                if (S0.y().b() == 0) {
                    this.f35206h.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
                } else {
                    this.f35206h.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a2b));
                }
                this.f35206h.k();
            } else if (c1()) {
                this.f35206h.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dae), this.x);
            } else {
                this.f35206h.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0daf), this.x);
            }
        }
        t().e4(S0);
    }

    public boolean c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (w() != null) {
                return w().w0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || getView() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        hideLoadingView(viewGroup);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i).setVisibility(0);
        }
    }

    public void e1(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || (bdTypeRecyclerView = this.f35202d) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    public void f1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || this.f35202d == null) {
        }
    }

    public void g1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.o == 2) {
            return;
        }
        this.f35202d.setNextPage(this.f35206h);
        this.o = 2;
    }

    public void h1(int i, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048597, this, i, i2) == null) || (bdTypeRecyclerView = this.f35202d) == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.f35202d.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.f35202d.getLayoutManager()).scrollToPositionWithOffset(i, i2);
    }

    public void i1(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || (pbListView = this.f35206h) == null) {
            return;
        }
        pbListView.D(str);
    }

    public void j1(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || (pbListView = this.f35206h) == null) {
            return;
        }
        pbListView.I(str, this.x);
    }

    @Override // c.a.p0.w2.r.g.b
    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.p = z;
        }
    }

    public void k1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.m = z;
        }
    }

    public void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.f35206h.A();
            this.f35206h.R();
        }
    }

    public void m1(int i) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i) == null) || (view = this.k) == null) {
            return;
        }
        view.setVisibility(i);
    }

    public void n1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || getView() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i).setVisibility(8);
        }
        showLoadingView(viewGroup);
    }

    public void o1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048605, this, z) == null) && z && this.l) {
            this.f35206h.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03d8));
            this.f35202d.setNextPage(this.f35206h);
            this.o = 2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(x()).get(VideoPbViewModel.class);
            videoPbViewModel.n().observe(this, new e(this));
            N0(true, 0, 3, 0, videoPbViewModel.c(), "", 1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, context) == null) {
            super.onAttach(context);
            if (context instanceof AbsPbActivity) {
                this.a = (AbsPbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            super.onChangeSkinType(i);
            PbListView pbListView = this.f35206h;
            if (pbListView != null) {
                pbListView.d(i);
                if (this.i != null) {
                    getBaseFragmentActivity().getLayoutMode().j(this.i);
                    SkinManager.setBackgroundResource(this.i, R.drawable.pb_foot_more_trans_selector);
                }
            }
            c.a.p0.w2.q.l.b bVar = this.q;
            if (bVar != null) {
                bVar.h(i);
            }
            c.a.p0.w2.q.d dVar = this.f35203e;
            if (dVar != null) {
                dVar.e();
            }
            View view = this.k;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.drawable.personalize_tab_shadow);
            }
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048610, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f35204f = new c.a.p0.w2.q.h.b(this);
            this.f35201c = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d069f, (ViewGroup) null);
            a1();
            return this.f35201c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.D);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                q.a().f();
            } else {
                q.a().j(x());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onResume();
            this.p = false;
            if (isPrimary()) {
                q.a().f();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onStop();
            q.a().j(x());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            super.onUserChanged(z);
            o1(z);
            if (t() != null && t().N != null) {
                this.f35200b.N.H();
            }
            if (z && this.p) {
                l1();
                w().K1(true);
            }
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
    public AbsVideoPbFragment t() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.f35200b == null && (absPbActivity = this.a) != null) {
                Fragment findFragment = absPbActivity.findFragment();
                if (findFragment instanceof AbsVideoPbFragment) {
                    this.f35200b = (AbsVideoPbFragment) findFragment;
                }
            }
            return this.f35200b;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // c.a.p0.w2.q.b
    public void u0(boolean z, int i, int i2, int i3, c.a.p0.w2.i.f fVar, String str, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fVar, str, Integer.valueOf(i4)}) == null) || getActivity() == null) {
            return;
        }
        N0(z, i, i2, i3, fVar, str, i4);
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? t().w() : (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsPbActivity x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            return absPbActivity != null ? absPbActivity : t().x();
        }
        return (AbsPbActivity) invokeV.objValue;
    }
}
