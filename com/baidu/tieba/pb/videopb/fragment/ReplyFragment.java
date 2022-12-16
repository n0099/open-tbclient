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
import com.baidu.tieba.a48;
import com.baidu.tieba.az4;
import com.baidu.tieba.bz4;
import com.baidu.tieba.h08;
import com.baidu.tieba.h88;
import com.baidu.tieba.i58;
import com.baidu.tieba.ks8;
import com.baidu.tieba.m88;
import com.baidu.tieba.o88;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.MultiNestedLayout;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.r78;
import com.baidu.tieba.t78;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.u08;
import com.baidu.tieba.x28;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class ReplyFragment extends BaseVideoPBReplyFragment implements r78, o88.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView.OnScrollListener A;
    public MultiNestedLayout.b B;
    public final az4.g C;
    public CustomMessageListener D;
    public final BdListView.p E;
    public AbsPbActivity a;
    public AbsVideoPbFragment b;
    public View c;
    public BdTypeRecyclerView d;
    public t78 e;
    public h88 f;
    public MultiNestedLayout g;
    public PbListView h;
    public View i;
    public o88 j;
    public View k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public boolean p;
    public m88 q;
    public View r;
    public BdSwipeRefreshLayout s;
    public bz4 t;
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
                    this.a.J().d5();
                    this.a.J().f5();
                }
                if (this.a.J() != null) {
                    this.a.J().Q4(i);
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
                if (this.a.w == 1 && i != 1 && this.a.v != 0) {
                    this.a.J().u5(8);
                    this.a.k.setVisibility(0);
                } else if (this.a.w == 0 && i != 0) {
                    if (this.a.k.getVisibility() != 0) {
                        this.a.J().u5(0);
                    }
                } else if (this.a.w != 0 && i == 0) {
                    this.a.J().u5(8);
                }
                this.a.w = i;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements az4.g {
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

        @Override // com.baidu.tieba.az4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.M() != null && this.a.M().k2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.L1();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.M() != null && this.a.M().l1() != null && this.a.M().l1().H() != null) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                ks8 ks8Var = null;
                Iterator<PostData> it = this.a.M().l1().H().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next instanceof ks8) {
                        ks8 ks8Var2 = (ks8) next;
                        if (str.equals(ks8Var2.n1())) {
                            ks8Var = ks8Var2;
                            break;
                        }
                    }
                }
                if (ks8Var != null && this.a.e != null && this.a.d != null) {
                    this.a.M().l1().H().remove(ks8Var);
                    if (this.a.e.a() != null) {
                        this.a.e.a().remove(ks8Var);
                    }
                    if (this.a.d.getListView2().getData() != null) {
                        this.a.d.getListView2().getData().remove(ks8Var);
                    }
                    this.a.e.e();
                }
            }
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
                    this.a.i2();
                } else {
                    this.a.n();
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
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.mIsLogin) {
                return;
            }
            if (!this.a.y && this.a.J1() && this.a.M() != null) {
                StatisticItem statisticItem = new StatisticItem("c13999");
                statisticItem.param("tid", this.a.M().F1());
                statisticItem.param("fid", this.a.M().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                this.a.y = true;
            }
            if (this.a.M().g2(false)) {
                this.a.g2();
                if (this.a.getPageContext() != null) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                }
            } else if (this.a.M().l1() != null) {
                this.a.b2();
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

    public int P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
                if (M() != null && M().l1() != null && lastVisiblePosition >= M().l1().H().size()) {
                    return M().l1().H().size() - 2;
                }
                return lastVisiblePosition;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static ReplyFragment Y1(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            ReplyFragment replyFragment = new ReplyFragment();
            replyFragment.setArguments(bundle);
            replyFragment.b = absVideoPbFragment;
            return replyFragment;
        }
        return (ReplyFragment) invokeL.objValue;
    }

    public void Z1(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && (bdTypeRecyclerView = this.d) != null) {
            bdTypeRecyclerView.setCanFling(z);
        }
    }

    public void d2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, str) == null) && (pbListView = this.h) != null) {
            pbListView.F(str);
        }
    }

    @Override // com.baidu.tieba.o88.b
    public void e1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.p = z;
        }
    }

    public void e2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, str) == null) && (pbListView = this.h) != null) {
            pbListView.K(str, this.x);
        }
    }

    public void f2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.m = z;
        }
    }

    public void h2(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048604, this, i) == null) && (view2 = this.k) != null) {
            view2.setVisibility(i);
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, view2) == null) {
            super.showLoadingView(view2);
        }
    }

    public void c2(int i, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048598, this, i, i2) == null) && (bdTypeRecyclerView = this.d) != null && bdTypeRecyclerView.getLayoutManager() != null && (this.d.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.d.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    public final void I1(boolean z, int i, int i2, int i3, h08 h08Var, String str, int i4) {
        int size;
        int i5;
        int size2;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), h08Var, str, Integer.valueOf(i4)}) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(R()).get(VideoPbViewModel.class);
            if (z && M() != null && h08Var != null) {
                if (this.z) {
                    M().s0();
                } else {
                    this.z = true;
                }
                this.u = M().D1();
                boolean isEnabled = this.s.isEnabled();
                if (h08Var.z().c() == 0 && this.u) {
                    this.s.setEnabled(false);
                } else if (!isEnabled) {
                    this.s.setEnabled(true);
                    this.s.o();
                }
                this.e.g(videoPbViewModel.m());
                this.e.h(this.u);
                this.e.f(h08Var);
                this.l = false;
                if (TbadkCoreApplication.isLogin()) {
                    this.d.setNextPage(this.h);
                    this.o = 2;
                    if (J() != null && J().N != null) {
                        this.b.N.V();
                    }
                } else {
                    this.l = true;
                    if (h08Var.z().b() == 1) {
                        if (this.j == null) {
                            o88 o88Var = new o88(this, this);
                            this.j = o88Var;
                            o88Var.a();
                            this.j.h();
                        }
                        this.d.setNextPage(this.j);
                    } else {
                        this.d.setNextPage(this.h);
                    }
                    this.o = 3;
                }
                if (this.q != null && this.r != null) {
                    u08 u08Var = new u08(u08.i);
                    ThreadData Q = h08Var.Q();
                    if (Q != null) {
                        Q.getReply_num();
                    }
                    M().D1();
                    u08Var.d = X1();
                    u08Var.c = h08Var.g;
                    h08Var.c();
                    u08Var.e = h08Var.l0();
                    u08Var.g = h08Var.f;
                    u08Var.f = Q.isVideoWorksInfo();
                    this.q.e(u08Var);
                }
                ArrayList<PostData> H = h08Var.H();
                if (h08Var.z().b() != 0 && H != null && H.size() >= h08Var.z().e()) {
                    if (M().U0()) {
                        if (this.n) {
                            K1();
                            if (h08Var.z().b() != 0) {
                                this.h.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                            }
                        } else {
                            this.h.C();
                            this.h.Q();
                        }
                    } else {
                        this.h.C();
                        this.h.Q();
                    }
                    this.h.m();
                } else {
                    if (ListUtils.getCount(H) != 0 && (ListUtils.getCount(H) != 1 || H.get(0) == null || H.get(0).D() != 1)) {
                        if (h08Var.z().b() == 0) {
                            this.h.F(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                        } else {
                            this.h.F(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                        }
                        this.h.m();
                    } else if (X1()) {
                        this.h.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e5f), this.x);
                    } else {
                        this.h.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e60), this.x);
                    }
                    if (h08Var.z().b() == 0 || H == null) {
                        b2();
                    }
                }
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                if (i2 != 6) {
                                    if (i2 == 8) {
                                        if (this.d.getData() == null && h08Var.H() == null) {
                                            size2 = 0;
                                        } else {
                                            size2 = this.d.getData().size() - h08Var.H().size();
                                        }
                                        this.g.setMaxOffset();
                                        BdTypeRecyclerView bdTypeRecyclerView = this.d;
                                        if (i3 > 0) {
                                            i6 = i3 + size2;
                                        } else {
                                            i6 = 0;
                                        }
                                        bdTypeRecyclerView.setSelection(i6);
                                        this.h.g();
                                        this.h.F(getString(R.string.obfuscated_res_0x7f0f0e59));
                                        this.h.A();
                                    }
                                } else {
                                    if (i4 == 1) {
                                        Parcelable e2 = a48.b().e();
                                        if (e2 instanceof RecyclerView.SavedState) {
                                            this.d.onRestoreInstanceState(e2);
                                        }
                                    }
                                    this.d.setSelection(0);
                                }
                            } else {
                                this.d.setSelection(0);
                            }
                        } else {
                            this.n = false;
                        }
                    } else if (i4 == 1) {
                        Parcelable e3 = a48.b().e();
                        if (e3 instanceof RecyclerView.SavedState) {
                            this.d.onRestoreInstanceState(e3);
                            if (ListUtils.getCount(H) > 1 && h08Var.z().b() > 0) {
                                this.h.g();
                                this.h.F(getString(R.string.obfuscated_res_0x7f0f0e59));
                                this.h.A();
                            }
                        }
                    }
                } else {
                    if (this.d.getData() == null && h08Var.H() == null) {
                        size = 0;
                    } else {
                        size = this.d.getData().size() - h08Var.H().size();
                    }
                    BdTypeRecyclerView bdTypeRecyclerView2 = this.d;
                    if (i3 > 1) {
                        i5 = (i3 + size) - 2;
                    } else {
                        i5 = 0;
                    }
                    bdTypeRecyclerView2.setSelection(i5);
                }
                if (this.m) {
                    a2();
                    this.m = false;
                    if (i4 == 0) {
                        f2(true);
                    }
                }
                J().Y4(h08Var);
                String M0 = M().M0();
                if (!TextUtils.isEmpty(M0)) {
                    i58.b(Q1(), M0);
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsVideoPbFragment J() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.b == null && (absPbActivity = this.a) != null) {
                Fragment e1 = absPbActivity.e1();
                if (e1 instanceof AbsVideoPbFragment) {
                    this.b = (AbsVideoPbFragment) e1;
                }
            }
            return this.b;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    public void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.A();
                this.h.g();
            }
            if (J() != null && J().N != null) {
                this.b.N.V();
            }
        }
    }

    public void L1() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bdSwipeRefreshLayout = this.s) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.s.setRefreshing(false);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return J().M();
        }
        return (PbModel) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: M1 */
    public t78 x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (t78) invokeV.objValue;
    }

    public int N1() {
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

    public int O1() {
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

    public BdTypeRecyclerView Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.d;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsPbActivity R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null) {
                return absPbActivity;
            }
            return J().R();
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public int R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    public View S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public int T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.v;
        }
        return invokeV.intValue;
    }

    public h88 U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.f;
        }
        return (h88) invokeV.objValue;
    }

    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (M() != null) {
                return M().O0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void a2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || this.d == null) {
        }
    }

    public void b2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && this.o != 2) {
            this.d.setNextPage(this.h);
            this.o = 2;
        }
    }

    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.h.C();
            this.h.T();
        }
    }

    public void i2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && getView() != null) {
            ViewGroup viewGroup = (ViewGroup) getView();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                viewGroup.getChildAt(i).setVisibility(8);
            }
            showLoadingView(viewGroup);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && getView() != null) {
            ViewGroup viewGroup = (ViewGroup) getView();
            hideLoadingView(viewGroup);
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                viewGroup.getChildAt(i).setVisibility(0);
            }
        }
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
                x28.a().f();
            } else {
                x28.a().j(R());
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
                x28.a().f();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onStop();
            x28.a().j(R());
        }
    }

    public boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbListView pbListView = this.h;
            if (pbListView != null && !TextUtils.isEmpty(pbListView.i())) {
                return this.h.i().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.x = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            MultiNestedLayout multiNestedLayout = (MultiNestedLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09164b);
            this.g = multiNestedLayout;
            multiNestedLayout.setScrollStateChangeListener(this.B);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f092613);
            this.d = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            t78 t78Var = new t78(this, this.d);
            this.e = t78Var;
            t78Var.l(J().U3());
            this.e.i(J().V3());
            this.e.k(J().Y3());
            this.e.j(this.f.j());
            this.e.m(this.f.m());
            this.k = this.c.findViewById(R.id.obfuscated_res_0x7f091cb1);
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.h = pbListView;
            View findViewById = pbListView.c().findViewById(R.id.pb_more_view);
            this.i = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(J().U3());
                SkinManager.setBackgroundResource(this.i, R.drawable.pb_foot_more_trans_selector);
            }
            this.h.C();
            this.h.q(R.drawable.pb_foot_more_trans_selector);
            this.h.r(R.drawable.pb_foot_more_trans_selector);
            this.h.u();
            this.d.setOnSrollToBottomListener(this.E);
            this.d.addOnScrollListener(this.A);
            this.d.setOnTouchListener(J().Z3());
            if (this.t == null) {
                bz4 bz4Var = new bz4(getPageContext());
                this.t = bz4Var;
                bz4Var.n();
                this.t.f(this.C);
            }
            if (this.s == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09194c);
                this.s = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.t);
                this.s.setEnabled(false);
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0205);
            }
            View findViewById2 = this.c.findViewById(R.id.obfuscated_res_0x7f092612);
            this.r = findViewById2;
            m88 m88Var = new m88(findViewById2);
            this.q = m88Var;
            m88Var.i(J().U3());
            this.q.j(J().J1);
            registerListener(this.D);
        }
    }

    public void W1() {
        h08 l1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || (l1 = M().l1()) == null) {
            return;
        }
        this.e.h(M().D1());
        this.e.f(l1);
        this.e.e();
        ArrayList<PostData> H = l1.H();
        if (l1.z().b() == 0 || H == null || H.size() < l1.z().e()) {
            if (ListUtils.getCount(H) != 0 && (ListUtils.getCount(H) != 1 || H.get(0) == null || H.get(0).D() != 1)) {
                if (l1.z().b() == 0) {
                    this.h.F(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.h.F(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.h.m();
            } else if (X1()) {
                this.h.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e5f), this.x);
            } else {
                this.h.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e60), this.x);
            }
        }
        J().Y4(l1);
    }

    public void j2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048606, this, z) == null) && z && this.l) {
            this.h.F(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.d.setNextPage(this.h);
            this.o = 2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(R()).get(VideoPbViewModel.class);
            videoPbViewModel.o().observe(this, new e(this));
            I1(true, 0, 3, 0, videoPbViewModel.c(), "", 1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            super.onUserChanged(z);
            j2(z);
            if (J() != null && J().N != null) {
                this.b.N.H();
            }
            if (z && this.p) {
                g2();
                M().g2(true);
            }
        }
    }

    @Override // com.baidu.tieba.r78
    public void n1(boolean z, int i, int i2, int i3, h08 h08Var, String str, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), h08Var, str, Integer.valueOf(i4)}) == null) && getActivity() != null) {
            I1(z, i, i2, i3, h08Var, str, i4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            super.onChangeSkinType(i);
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.e(i);
                if (this.i != null) {
                    getBaseFragmentActivity().getLayoutMode().k(this.i);
                    SkinManager.setBackgroundResource(this.i, R.drawable.pb_foot_more_trans_selector);
                }
            }
            m88 m88Var = this.q;
            if (m88Var != null) {
                m88Var.h(i);
            }
            t78 t78Var = this.e;
            if (t78Var != null) {
                t78Var.e();
            }
            View view2 = this.k;
            if (view2 != null) {
                SkinManager.setBackgroundResource(view2, R.drawable.personalize_tab_shadow);
            }
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048613, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f = new h88(this);
            this.c = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d070f, (ViewGroup) null);
            V1();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }
}
