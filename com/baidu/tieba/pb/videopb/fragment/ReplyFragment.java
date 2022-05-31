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
import com.repackage.ah8;
import com.repackage.ds7;
import com.repackage.ex7;
import com.repackage.ft4;
import com.repackage.gt4;
import com.repackage.gt7;
import com.repackage.ju7;
import com.repackage.jx7;
import com.repackage.kp7;
import com.repackage.li;
import com.repackage.ow7;
import com.repackage.qw7;
import com.repackage.qx7;
import com.repackage.xp7;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class ReplyFragment extends BaseVideoPBReplyFragment implements ow7, qx7.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView.OnScrollListener A;
    public MultiNestedLayout.b B;
    public final ft4.g C;
    public CustomMessageListener D;
    public final BdListView.p E;
    public AbsPbActivity a;
    public AbsVideoPbFragment b;
    public View c;
    public BdTypeRecyclerView d;
    public qw7 e;
    public ex7 f;
    public MultiNestedLayout g;
    public PbListView h;
    public View i;
    public qx7 j;
    public View k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public boolean p;
    public jx7 q;
    public View r;
    public BdSwipeRefreshLayout s;
    public gt4 t;
    public boolean u;
    public int v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes3.dex */
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
                    this.a.s().n4();
                    this.a.s().p4();
                }
                if (this.a.s() != null) {
                    this.a.s().a4(i);
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

    /* loaded from: classes3.dex */
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
                            this.a.s().F4(8);
                        }
                    } else if (this.a.k.getVisibility() != 0) {
                        this.a.s().F4(0);
                    }
                } else {
                    this.a.s().F4(8);
                    this.a.k.setVisibility(0);
                }
                this.a.w = i;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ft4.g {
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

        @Override // com.repackage.ft4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.v() != null && this.a.v().M2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.S0();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.v() == null || this.a.v().P1() == null || this.a.v().P1().F() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ah8 ah8Var = null;
            Iterator<PostData> it = this.a.v().P1().F().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PostData next = it.next();
                if (next instanceof ah8) {
                    ah8 ah8Var2 = (ah8) next;
                    if (str.equals(ah8Var2.N0())) {
                        ah8Var = ah8Var2;
                        break;
                    }
                }
            }
            if (ah8Var == null || this.a.e == null || this.a.d == null) {
                return;
            }
            this.a.v().P1().F().remove(ah8Var);
            if (this.a.e.a() != null) {
                this.a.e.a().remove(ah8Var);
            }
            if (this.a.d.getListView2().getData() != null) {
                this.a.d.getListView2().getData().remove(ah8Var);
            }
            this.a.e.e();
        }
    }

    /* loaded from: classes3.dex */
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
                    this.a.p1();
                } else {
                    this.a.g();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (!this.a.y && this.a.Q0() && this.a.v() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.v().h2());
                    statisticItem.param("fid", this.a.v().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    this.a.y = true;
                }
                if (this.a.v().I2(false)) {
                    this.a.n1();
                    if (this.a.getPageContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (this.a.v().P1() != null) {
                    this.a.i1();
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
        this.h = null;
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

    public static ReplyFragment f1(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            ReplyFragment replyFragment = new ReplyFragment();
            replyFragment.setArguments(bundle);
            replyFragment.b = absVideoPbFragment;
            return replyFragment;
        }
        return (ReplyFragment) invokeL.objValue;
    }

    public final void P0(boolean z, int i, int i2, int i3, kp7 kp7Var, String str, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), kp7Var, str, Integer.valueOf(i4)}) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(w()).get(VideoPbViewModel.class);
            if (!z || v() == null || kp7Var == null) {
                return;
            }
            if (this.z) {
                v().W0();
            } else {
                this.z = true;
            }
            this.u = v().f2();
            boolean isEnabled = this.s.isEnabled();
            if (kp7Var.y().c() == 0 && this.u) {
                this.s.setEnabled(false);
            } else if (!isEnabled) {
                this.s.setEnabled(true);
                this.s.o();
            }
            this.e.g(videoPbViewModel.m());
            this.e.h(this.u);
            this.e.f(kp7Var);
            this.l = false;
            if (TbadkCoreApplication.isLogin()) {
                this.d.setNextPage(this.h);
                this.o = 2;
                if (s() != null && s().N != null) {
                    this.b.N.V();
                }
            } else {
                this.l = true;
                if (kp7Var.y().b() == 1) {
                    if (this.j == null) {
                        qx7 qx7Var = new qx7(this, this);
                        this.j = qx7Var;
                        qx7Var.a();
                        this.j.g();
                    }
                    this.d.setNextPage(this.j);
                } else {
                    this.d.setNextPage(this.h);
                }
                this.o = 3;
            }
            if (this.q != null && this.r != null) {
                xp7 xp7Var = new xp7(xp7.h);
                ThreadData O = kp7Var.O();
                if (O != null) {
                    O.getReply_num();
                }
                v().f2();
                xp7Var.d = e1();
                xp7Var.c = kp7Var.g;
                kp7Var.c();
                xp7Var.e = kp7Var.g0();
                xp7Var.g = kp7Var.f;
                xp7Var.f = O.isVideoWorksInfo();
                this.q.e(xp7Var);
            }
            ArrayList<PostData> F = kp7Var.F();
            if (kp7Var.y().b() != 0 && F != null && F.size() >= kp7Var.y().e()) {
                if (v().y1()) {
                    if (this.n) {
                        R0();
                        if (kp7Var.y().b() != 0) {
                            this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dc7));
                        }
                    } else {
                        this.h.z();
                        this.h.N();
                    }
                } else {
                    this.h.z();
                    this.h.N();
                }
                this.h.k();
            } else {
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                    if (kp7Var.y().b() == 0) {
                        this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09f3));
                    } else {
                        this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a38));
                    }
                    this.h.k();
                } else if (e1()) {
                    this.h.H(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dcf), this.x);
                } else {
                    this.h.H(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dd0), this.x);
                }
                if (kp7Var.y().b() == 0 || F == null) {
                    i1();
                }
            }
            if (i2 == 2) {
                this.d.setSelection(i3 > 1 ? (i3 + ((this.d.getData() == null && kp7Var.F() == null) ? 0 : this.d.getData().size() - kp7Var.F().size())) - 2 : 0);
            } else if (i2 != 3) {
                if (i2 == 4) {
                    this.n = false;
                } else if (i2 == 5) {
                    this.d.setSelection(0);
                } else if (i2 == 6) {
                    if (i4 == 1) {
                        Parcelable e2 = gt7.b().e();
                        if (e2 instanceof RecyclerView.SavedState) {
                            this.d.onRestoreInstanceState(e2);
                        }
                    }
                    this.d.setSelection(0);
                } else if (i2 == 8) {
                    int size = (this.d.getData() == null && kp7Var.F() == null) ? 0 : this.d.getData().size() - kp7Var.F().size();
                    this.g.setMaxOffset();
                    this.d.setSelection(i3 > 0 ? i3 + size : 0);
                    this.h.f();
                    this.h.C(getString(R.string.obfuscated_res_0x7f0f0dc8));
                    this.h.x();
                }
            } else if (i4 == 1) {
                Parcelable e3 = gt7.b().e();
                if (e3 instanceof RecyclerView.SavedState) {
                    this.d.onRestoreInstanceState(e3);
                    if (ListUtils.getCount(F) > 1 && kp7Var.y().b() > 0) {
                        this.h.f();
                        this.h.C(getString(R.string.obfuscated_res_0x7f0f0dc8));
                        this.h.x();
                    }
                }
            }
            if (this.m) {
                h1();
                this.m = false;
                if (i4 == 0) {
                    m1(true);
                }
            }
            s().i4(kp7Var);
            String q1 = v().q1();
            if (TextUtils.isEmpty(q1)) {
                return;
            }
            ju7.b(X0(), q1);
        }
    }

    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbListView pbListView = this.h;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.h.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09f3));
        }
        return invokeV.booleanValue;
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.x();
                this.h.f();
            }
            if (s() == null || s().N == null) {
                return;
            }
            this.b.N.V();
        }
    }

    public void S0() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bdSwipeRefreshLayout = this.s) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.s.setRefreshing(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: T0 */
    public qw7 E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : (qw7) invokeV.objValue;
    }

    public int U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                return bdTypeRecyclerView.getFirstVisiblePosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int V0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.d.getChildAt(0)) == null) {
                return 0;
            }
            return childAt.getTop();
        }
        return invokeV.intValue;
    }

    public int W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
                return (v() == null || v().P1() == null || lastVisiblePosition < v().P1().F().size()) ? lastVisiblePosition : v().P1().F().size() - 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public BdTypeRecyclerView X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.d : (BdTypeRecyclerView) invokeV.objValue;
    }

    public int Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.w : invokeV.intValue;
    }

    public View Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    public int a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.v : invokeV.intValue;
    }

    public ex7 b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f : (ex7) invokeV.objValue;
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.x = li.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            MultiNestedLayout multiNestedLayout = (MultiNestedLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091456);
            this.g = multiNestedLayout;
            multiNestedLayout.setScrollStateChangeListener(this.B);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f09232f);
            this.d = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            qw7 qw7Var = new qw7(this, this.d);
            this.e = qw7Var;
            qw7Var.l(s().d3());
            this.e.i(s().e3());
            this.e.k(s().h3());
            this.e.j(this.f.i());
            this.e.m(this.f.l());
            this.k = this.c.findViewById(R.id.obfuscated_res_0x7f091a57);
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.h = pbListView;
            View findViewById = pbListView.b().findViewById(R.id.obfuscated_res_0x7f0916cb);
            this.i = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(s().d3());
                SkinManager.setBackgroundResource(this.i, R.drawable.pb_foot_more_trans_selector);
            }
            this.h.z();
            this.h.o(R.drawable.pb_foot_more_trans_selector);
            this.h.p(R.drawable.pb_foot_more_trans_selector);
            this.h.s();
            this.d.setOnSrollToBottomListener(this.E);
            this.d.addOnScrollListener(this.A);
            this.d.setOnTouchListener(s().i3());
            if (this.t == null) {
                gt4 gt4Var = new gt4(getPageContext());
                this.t = gt4Var;
                gt4Var.n();
                this.t.e(this.C);
            }
            if (this.s == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091723);
                this.s = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.t);
                this.s.setEnabled(false);
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0205);
            }
            View findViewById2 = this.c.findViewById(R.id.obfuscated_res_0x7f09232e);
            this.r = findViewById2;
            jx7 jx7Var = new jx7(findViewById2);
            this.q = jx7Var;
            jx7Var.i(s().d3());
            this.q.j(s().M1);
            registerListener(this.D);
        }
    }

    public void d1() {
        kp7 P1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (P1 = v().P1()) == null) {
            return;
        }
        this.e.h(v().f2());
        this.e.f(P1);
        this.e.e();
        ArrayList<PostData> F = P1.F();
        if (P1.y().b() == 0 || F == null || F.size() < P1.y().e()) {
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                if (P1.y().b() == 0) {
                    this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09f3));
                } else {
                    this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a38));
                }
                this.h.k();
            } else if (e1()) {
                this.h.H(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dcf), this.x);
            } else {
                this.h.H(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dd0), this.x);
            }
        }
        s().i4(P1);
    }

    public boolean e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (v() != null) {
                return v().s1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g() {
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

    public void g1(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || (bdTypeRecyclerView = this.d) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    public void h1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || this.d == null) {
        }
    }

    public void i1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.o == 2) {
            return;
        }
        this.d.setNextPage(this.h);
        this.o = 2;
    }

    public void j1(int i, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048597, this, i, i2) == null) || (bdTypeRecyclerView = this.d) == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.d.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.d.getLayoutManager()).scrollToPositionWithOffset(i, i2);
    }

    public void k1(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || (pbListView = this.h) == null) {
            return;
        }
        pbListView.C(str);
    }

    public void l1(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || (pbListView = this.h) == null) {
            return;
        }
        pbListView.H(str, this.x);
    }

    public void m1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.m = z;
        }
    }

    @Override // com.repackage.qx7.b
    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.p = z;
        }
    }

    public void n1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.h.z();
            this.h.Q();
        }
    }

    public void o1(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i) == null) || (view2 = this.k) == null) {
            return;
        }
        view2.setVisibility(i);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(w()).get(VideoPbViewModel.class);
            videoPbViewModel.o().observe(this, new e(this));
            P0(true, 0, 3, 0, videoPbViewModel.c(), "", 1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, context) == null) {
            super.onAttach(context);
            if (context instanceof AbsPbActivity) {
                this.a = (AbsPbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            super.onChangeSkinType(i);
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.d(i);
                if (this.i != null) {
                    getBaseFragmentActivity().getLayoutMode().j(this.i);
                    SkinManager.setBackgroundResource(this.i, R.drawable.pb_foot_more_trans_selector);
                }
            }
            jx7 jx7Var = this.q;
            if (jx7Var != null) {
                jx7Var.h(i);
            }
            qw7 qw7Var = this.e;
            if (qw7Var != null) {
                qw7Var.e();
            }
            View view2 = this.k;
            if (view2 != null) {
                SkinManager.setBackgroundResource(view2, R.drawable.personalize_tab_shadow);
            }
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048608, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f = new ex7(this);
            this.c = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0683, (ViewGroup) null);
            c1();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.D);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                ds7.a().f();
            } else {
                ds7.a().j(w());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onResume();
            this.p = false;
            if (isPrimary()) {
                ds7.a().f();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onStop();
            ds7.a().j(w());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            super.onUserChanged(z);
            q1(z);
            if (s() != null && s().N != null) {
                this.b.N.H();
            }
            if (z && this.p) {
                n1();
                v().I2(true);
            }
        }
    }

    public void p1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || getView() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i).setVisibility(8);
        }
        showLoadingView(viewGroup);
    }

    public void q1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z) == null) && z && this.l) {
            this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03e7));
            this.d.setNextPage(this.h);
            this.o = 2;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsVideoPbFragment s() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.b == null && (absPbActivity = this.a) != null) {
                Fragment findFragment = absPbActivity.findFragment();
                if (findFragment instanceof AbsVideoPbFragment) {
                    this.b = (AbsVideoPbFragment) findFragment;
                }
            }
            return this.b;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view2) == null) {
            super.showLoadingView(view2);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? s().v() : (PbModel) invokeV.objValue;
    }

    @Override // com.repackage.ow7
    public void v0(boolean z, int i, int i2, int i3, kp7 kp7Var, String str, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), kp7Var, str, Integer.valueOf(i4)}) == null) || getActivity() == null) {
            return;
        }
        P0(z, i, i2, i3, kp7Var, str, i4);
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsPbActivity w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            return absPbActivity != null ? absPbActivity : s().w();
        }
        return (AbsPbActivity) invokeV.objValue;
    }
}
