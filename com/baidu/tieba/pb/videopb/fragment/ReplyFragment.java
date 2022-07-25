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
import com.repackage.cu7;
import com.repackage.fv7;
import com.repackage.fz7;
import com.repackage.gu4;
import com.repackage.hu4;
import com.repackage.jr7;
import com.repackage.jw7;
import com.repackage.kz7;
import com.repackage.ni8;
import com.repackage.pi;
import com.repackage.py7;
import com.repackage.ry7;
import com.repackage.rz7;
import com.repackage.wr7;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class ReplyFragment extends BaseVideoPBReplyFragment implements py7, rz7.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView.OnScrollListener A;
    public MultiNestedLayout.b B;
    public final gu4.g C;
    public CustomMessageListener D;
    public final BdListView.p E;
    public AbsPbActivity a;
    public AbsVideoPbFragment b;
    public View c;
    public BdTypeRecyclerView d;
    public ry7 e;
    public fz7 f;
    public MultiNestedLayout g;
    public PbListView h;
    public View i;
    public rz7 j;
    public View k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public boolean p;
    public kz7 q;
    public View r;
    public BdSwipeRefreshLayout s;
    public hu4 t;
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
                    this.a.B().c5();
                    this.a.B().e5();
                }
                if (this.a.B() != null) {
                    this.a.B().P4(i);
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
                            this.a.B().u5(8);
                        }
                    } else if (this.a.k.getVisibility() != 0) {
                        this.a.B().u5(0);
                    }
                } else {
                    this.a.B().u5(8);
                    this.a.k.setVisibility(0);
                }
                this.a.w = i;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements gu4.g {
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

        @Override // com.repackage.gu4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.F() != null && this.a.F().O2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.H1();
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.F() == null || this.a.F().R1() == null || this.a.F().R1().F() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ni8 ni8Var = null;
            Iterator<PostData> it = this.a.F().R1().F().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PostData next = it.next();
                if (next instanceof ni8) {
                    ni8 ni8Var2 = (ni8) next;
                    if (str.equals(ni8Var2.R0())) {
                        ni8Var = ni8Var2;
                        break;
                    }
                }
            }
            if (ni8Var == null || this.a.e == null || this.a.d == null) {
                return;
            }
            this.a.F().R1().F().remove(ni8Var);
            if (this.a.e.a() != null) {
                this.a.e.a().remove(ni8Var);
            }
            if (this.a.d.getListView2().getData() != null) {
                this.a.d.getListView2().getData().remove(ni8Var);
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
                    this.a.e2();
                } else {
                    this.a.m();
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
                if (!this.a.y && this.a.F1() && this.a.F() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.F().j2());
                    statisticItem.param("fid", this.a.F().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    this.a.y = true;
                }
                if (this.a.F().K2(false)) {
                    this.a.c2();
                    if (this.a.getPageContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (this.a.F().R1() != null) {
                    this.a.X1();
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

    public static ReplyFragment U1(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            ReplyFragment replyFragment = new ReplyFragment();
            replyFragment.setArguments(bundle);
            replyFragment.b = absVideoPbFragment;
            return replyFragment;
        }
        return (ReplyFragment) invokeL.objValue;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsVideoPbFragment B() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.b == null && (absPbActivity = this.a) != null) {
                Fragment E0 = absPbActivity.E0();
                if (E0 instanceof AbsVideoPbFragment) {
                    this.b = (AbsVideoPbFragment) E0;
                }
            }
            return this.b;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    public final void E1(boolean z, int i, int i2, int i3, jr7 jr7Var, String str, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), jr7Var, str, Integer.valueOf(i4)}) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(N()).get(VideoPbViewModel.class);
            if (!z || F() == null || jr7Var == null) {
                return;
            }
            if (this.z) {
                F().Y0();
            } else {
                this.z = true;
            }
            this.u = F().h2();
            boolean isEnabled = this.s.isEnabled();
            if (jr7Var.y().c() == 0 && this.u) {
                this.s.setEnabled(false);
            } else if (!isEnabled) {
                this.s.setEnabled(true);
                this.s.o();
            }
            this.e.g(videoPbViewModel.m());
            this.e.h(this.u);
            this.e.f(jr7Var);
            this.l = false;
            if (TbadkCoreApplication.isLogin()) {
                this.d.setNextPage(this.h);
                this.o = 2;
                if (B() != null && B().N != null) {
                    this.b.N.V();
                }
            } else {
                this.l = true;
                if (jr7Var.y().b() == 1) {
                    if (this.j == null) {
                        rz7 rz7Var = new rz7(this, this);
                        this.j = rz7Var;
                        rz7Var.a();
                        this.j.g();
                    }
                    this.d.setNextPage(this.j);
                } else {
                    this.d.setNextPage(this.h);
                }
                this.o = 3;
            }
            if (this.q != null && this.r != null) {
                wr7 wr7Var = new wr7(wr7.h);
                ThreadData O = jr7Var.O();
                if (O != null) {
                    O.getReply_num();
                }
                F().h2();
                wr7Var.d = T1();
                wr7Var.c = jr7Var.g;
                jr7Var.c();
                wr7Var.e = jr7Var.g0();
                wr7Var.g = jr7Var.f;
                wr7Var.f = O.isVideoWorksInfo();
                this.q.e(wr7Var);
            }
            ArrayList<PostData> F = jr7Var.F();
            if (jr7Var.y().b() != 0 && F != null && F.size() >= jr7Var.y().e()) {
                if (F().A1()) {
                    if (this.n) {
                        G1();
                        if (jr7Var.y().b() != 0) {
                            this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0daa));
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
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).B() != 1)) {
                    if (jr7Var.y().b() == 0) {
                        this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09cf));
                    } else {
                        this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a15));
                    }
                    this.h.k();
                } else if (T1()) {
                    this.h.H(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0db1), this.x);
                } else {
                    this.h.H(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0db2), this.x);
                }
                if (jr7Var.y().b() == 0 || F == null) {
                    X1();
                }
            }
            if (i2 == 2) {
                this.d.setSelection(i3 > 1 ? (i3 + ((this.d.getData() == null && jr7Var.F() == null) ? 0 : this.d.getData().size() - jr7Var.F().size())) - 2 : 0);
            } else if (i2 != 3) {
                if (i2 == 4) {
                    this.n = false;
                } else if (i2 == 5) {
                    this.d.setSelection(0);
                } else if (i2 == 6) {
                    if (i4 == 1) {
                        Parcelable e2 = fv7.b().e();
                        if (e2 instanceof RecyclerView.SavedState) {
                            this.d.onRestoreInstanceState(e2);
                        }
                    }
                    this.d.setSelection(0);
                } else if (i2 == 8) {
                    int size = (this.d.getData() == null && jr7Var.F() == null) ? 0 : this.d.getData().size() - jr7Var.F().size();
                    this.g.setMaxOffset();
                    this.d.setSelection(i3 > 0 ? i3 + size : 0);
                    this.h.f();
                    this.h.C(getString(R.string.obfuscated_res_0x7f0f0dab));
                    this.h.x();
                }
            } else if (i4 == 1) {
                Parcelable e3 = fv7.b().e();
                if (e3 instanceof RecyclerView.SavedState) {
                    this.d.onRestoreInstanceState(e3);
                    if (ListUtils.getCount(F) > 1 && jr7Var.y().b() > 0) {
                        this.h.f();
                        this.h.C(getString(R.string.obfuscated_res_0x7f0f0dab));
                        this.h.x();
                    }
                }
            }
            if (this.m) {
                W1();
                this.m = false;
                if (i4 == 0) {
                    b2(true);
                }
            }
            B().X4(jr7Var);
            String s1 = F().s1();
            if (TextUtils.isEmpty(s1)) {
                return;
            }
            jw7.b(M1(), s1);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? B().F() : (PbModel) invokeV.objValue;
    }

    public boolean F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PbListView pbListView = this.h;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.h.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09cf));
        }
        return invokeV.booleanValue;
    }

    public void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.x();
                this.h.f();
            }
            if (B() == null || B().N == null) {
                return;
            }
            this.b.N.V();
        }
    }

    public void H1() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (bdSwipeRefreshLayout = this.s) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.s.setRefreshing(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: I1 */
    public ry7 s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (ry7) invokeV.objValue;
    }

    public int J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                return bdTypeRecyclerView.getFirstVisiblePosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int K1() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.d.getChildAt(0)) == null) {
                return 0;
            }
            return childAt.getTop();
        }
        return invokeV.intValue;
    }

    public int L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
                return (F() == null || F().R1() == null || lastVisiblePosition < F().R1().F().size()) ? lastVisiblePosition : F().R1().F().size() - 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public BdTypeRecyclerView M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.d : (BdTypeRecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsPbActivity N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            return absPbActivity != null ? absPbActivity : B().N();
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public int N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.w : invokeV.intValue;
    }

    public View O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    public int P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.v : invokeV.intValue;
    }

    public fz7 Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f : (fz7) invokeV.objValue;
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.x = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            MultiNestedLayout multiNestedLayout = (MultiNestedLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0914cb);
            this.g = multiNestedLayout;
            multiNestedLayout.setScrollStateChangeListener(this.B);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f0923c6);
            this.d = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            ry7 ry7Var = new ry7(this, this.d);
            this.e = ry7Var;
            ry7Var.l(B().S3());
            this.e.i(B().T3());
            this.e.k(B().W3());
            this.e.j(this.f.i());
            this.e.m(this.f.l());
            this.k = this.c.findViewById(R.id.obfuscated_res_0x7f091ad0);
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.h = pbListView;
            View findViewById = pbListView.b().findViewById(R.id.obfuscated_res_0x7f091743);
            this.i = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(B().S3());
                SkinManager.setBackgroundResource(this.i, R.drawable.pb_foot_more_trans_selector);
            }
            this.h.z();
            this.h.o(R.drawable.pb_foot_more_trans_selector);
            this.h.p(R.drawable.pb_foot_more_trans_selector);
            this.h.s();
            this.d.setOnSrollToBottomListener(this.E);
            this.d.addOnScrollListener(this.A);
            this.d.setOnTouchListener(B().X3());
            if (this.t == null) {
                hu4 hu4Var = new hu4(getPageContext());
                this.t = hu4Var;
                hu4Var.n();
                this.t.f(this.C);
            }
            if (this.s == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09179b);
                this.s = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.t);
                this.s.setEnabled(false);
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0205);
            }
            View findViewById2 = this.c.findViewById(R.id.obfuscated_res_0x7f0923c5);
            this.r = findViewById2;
            kz7 kz7Var = new kz7(findViewById2);
            this.q = kz7Var;
            kz7Var.i(B().S3());
            this.q.j(B().M1);
            registerListener(this.D);
        }
    }

    public void S1() {
        jr7 R1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (R1 = F().R1()) == null) {
            return;
        }
        this.e.h(F().h2());
        this.e.f(R1);
        this.e.e();
        ArrayList<PostData> F = R1.F();
        if (R1.y().b() == 0 || F == null || F.size() < R1.y().e()) {
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).B() != 1)) {
                if (R1.y().b() == 0) {
                    this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09cf));
                } else {
                    this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a15));
                }
                this.h.k();
            } else if (T1()) {
                this.h.H(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0db1), this.x);
            } else {
                this.h.H(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0db2), this.x);
            }
        }
        B().X4(R1);
    }

    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (F() != null) {
                return F().u1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void V1(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || (bdTypeRecyclerView = this.d) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    public void W1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || this.d == null) {
        }
    }

    @Override // com.repackage.rz7.b
    public void X0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.p = z;
        }
    }

    public void X1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.o == 2) {
            return;
        }
        this.d.setNextPage(this.h);
        this.o = 2;
    }

    public void Y1(int i, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048599, this, i, i2) == null) || (bdTypeRecyclerView = this.d) == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.d.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.d.getLayoutManager()).scrollToPositionWithOffset(i, i2);
    }

    public void Z1(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || (pbListView = this.h) == null) {
            return;
        }
        pbListView.C(str);
    }

    public void a2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, str) == null) || (pbListView = this.h) == null) {
            return;
        }
        pbListView.H(str, this.x);
    }

    public void b2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.m = z;
        }
    }

    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.h.z();
            this.h.Q();
        }
    }

    public void d2(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048604, this, i) == null) || (view2 = this.k) == null) {
            return;
        }
        view2.setVisibility(i);
    }

    public void e2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || getView() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i).setVisibility(8);
        }
        showLoadingView(viewGroup);
    }

    public void f2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048606, this, z) == null) && z && this.l) {
            this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03df));
            this.d.setNextPage(this.h);
            this.o = 2;
        }
    }

    @Override // com.repackage.py7
    public void i1(boolean z, int i, int i2, int i3, jr7 jr7Var, String str, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), jr7Var, str, Integer.valueOf(i4)}) == null) || getActivity() == null) {
            return;
        }
        E1(z, i, i2, i3, jr7Var, str, i4);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || getView() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        hideLoadingView(viewGroup);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i).setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(N()).get(VideoPbViewModel.class);
            videoPbViewModel.o().observe(this, new e(this));
            E1(true, 0, 3, 0, videoPbViewModel.c(), "", 1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, context) == null) {
            super.onAttach(context);
            if (context instanceof AbsPbActivity) {
                this.a = (AbsPbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            super.onChangeSkinType(i);
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.d(i);
                if (this.i != null) {
                    getBaseFragmentActivity().getLayoutMode().j(this.i);
                    SkinManager.setBackgroundResource(this.i, R.drawable.pb_foot_more_trans_selector);
                }
            }
            kz7 kz7Var = this.q;
            if (kz7Var != null) {
                kz7Var.h(i);
            }
            ry7 ry7Var = this.e;
            if (ry7Var != null) {
                ry7Var.e();
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
        if (interceptable == null || interceptable.invokeL(1048612, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048613, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f = new fz7(this);
            this.c = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d06a7, (ViewGroup) null);
            R1();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.D);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                cu7.a().f();
            } else {
                cu7.a().j(N());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onResume();
            this.p = false;
            if (isPrimary()) {
                cu7.a().f();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onStop();
            cu7.a().j(N());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            super.onUserChanged(z);
            f2(z);
            if (B() != null && B().N != null) {
                this.b.N.H();
            }
            if (z && this.p) {
                c2();
                F().K2(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, view2) == null) {
            super.showLoadingView(view2);
        }
    }
}
