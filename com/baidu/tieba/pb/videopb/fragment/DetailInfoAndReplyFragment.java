package com.baidu.tieba.pb.videopb.fragment;

import android.content.Context;
import android.content.Intent;
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
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbChildTitleViewHolder;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.as7;
import com.repackage.bs7;
import com.repackage.fz7;
import com.repackage.h08;
import com.repackage.kz7;
import com.repackage.lz7;
import com.repackage.mi;
import com.repackage.nz7;
import com.repackage.os7;
import com.repackage.pu4;
import com.repackage.qu4;
import com.repackage.qw7;
import com.repackage.uu7;
import com.repackage.vz7;
import com.repackage.xv7;
import com.repackage.y95;
import com.repackage.zj8;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements fz7, h08.b, y95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewTreeObserver.OnGlobalLayoutListener A;
    public boolean B;
    public boolean C;
    public RecyclerView.OnScrollListener D;
    public final pu4.g E;
    public CustomMessageListener F;
    public final CustomMessageListener G;
    public final BdListView.p H;
    public AbsPbActivity a;
    public AbsVideoPbFragment b;
    public View c;
    public BdTypeRecyclerView d;
    public LinearLayoutManager e;
    public kz7 f;
    public vz7 g;
    public PbListView h;
    public View i;
    public h08 j;
    public View k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public boolean p;
    public LinearLayout q;
    public PbReplyTitleViewHolder r;
    public PbChildTitleViewHolder s;
    public BdSwipeRefreshLayout t;
    public qu4 u;
    public boolean v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        public a(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = detailInfoAndReplyFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1) {
                    this.a.s().j4();
                    this.a.s().l4();
                }
                if (this.a.s() != null) {
                    this.a.s().W3(i);
                }
                if (i == 0) {
                    this.a.o1(true);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                this.a.i1();
                if (recyclerView.canScrollVertically(-1)) {
                    this.a.w = 2;
                    return;
                }
                if (Math.abs(i2) > 0 && this.a.w != 0) {
                    this.a.k.setVisibility(8);
                }
                this.a.w = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements pu4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = detailInfoAndReplyFragment;
        }

        @Override // com.repackage.pu4.g
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
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(DetailInfoAndReplyFragment detailInfoAndReplyFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment, Integer.valueOf(i)};
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
            this.a = detailInfoAndReplyFragment;
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
            zj8 zj8Var = null;
            Iterator<PostData> it = this.a.v().P1().F().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PostData next = it.next();
                if (next instanceof zj8) {
                    zj8 zj8Var2 = (zj8) next;
                    if (str.equals(zj8Var2.N0())) {
                        zj8Var = zj8Var2;
                        break;
                    }
                }
            }
            if (zj8Var == null || this.a.f == null || this.a.d == null) {
                return;
            }
            this.a.v().P1().F().remove(zj8Var);
            if (this.a.f.a() != null) {
                this.a.f.a().remove(zj8Var);
            }
            if (this.a.d.getListView2().getData() != null) {
                this.a.d.getListView2().getData().remove(zj8Var);
            }
            this.a.f.l();
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(DetailInfoAndReplyFragment detailInfoAndReplyFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment, Integer.valueOf(i)};
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
            this.a = detailInfoAndReplyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.v() == null || !(customResponsedMessage.getData() instanceof bs7)) {
                return;
            }
            bs7 bs7Var = (bs7) customResponsedMessage.getData();
            if (StringHelper.equals(this.a.v().h2(), bs7Var.Q())) {
                this.a.v().a1(bs7Var.O());
                this.a.v().U2(bs7Var, 3, "");
                MessageManager.getInstance().unRegisterStickyMode(2921648);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(DetailInfoAndReplyFragment detailInfoAndReplyFragment, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = detailInfoAndReplyFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view2, Rect rect, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{recyclerView, view2, rect, Boolean.valueOf(z)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view2, Rect rect, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{recyclerView, view2, rect, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        public f(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = detailInfoAndReplyFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.B || this.a.s() == null) {
                return;
            }
            this.a.B = true;
            this.a.s().z2(this.a.d, false);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        public g(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = detailInfoAndReplyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.a.u1();
                } else {
                    this.a.g();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        public h(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = detailInfoAndReplyFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.mIsLogin) {
                if (!this.a.z && this.a.Q0() && this.a.v() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.v().h2());
                    statisticItem.param("fid", this.a.v().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    this.a.z = true;
                }
                if (this.a.v().I2(false)) {
                    this.a.s1();
                    if (this.a.getPageContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (this.a.v().P1() != null) {
                    this.a.m1();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        public i(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = detailInfoAndReplyFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ViewHelper.skipToLoginActivity(this.a.getContext());
                this.a.l0(true);
                this.a.getPageContext().getPageActivity().finish();
            }
        }
    }

    public DetailInfoAndReplyFragment() {
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
        this.h = null;
        this.i = null;
        this.j = null;
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = 0;
        this.u = null;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.z = false;
        this.D = new a(this);
        this.E = new b(this);
        this.F = new c(this, 2016331);
        this.G = new d(this, 2921648);
        this.H = new h(this);
    }

    public static DetailInfoAndReplyFragment h1(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
            detailInfoAndReplyFragment.setArguments(bundle);
            detailInfoAndReplyFragment.b = absVideoPbFragment;
            return detailInfoAndReplyFragment;
        }
        return (DetailInfoAndReplyFragment) invokeL.objValue;
    }

    public final void P0(boolean z, int i2, int i3, int i4, bs7 bs7Var, String str, int i5, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bs7Var, str, Integer.valueOf(i5), Boolean.valueOf(z2)}) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(w()).get(VideoPbViewModel.class);
            if (!z || v() == null || bs7Var == null) {
                return;
            }
            if (!z2) {
                if (this.C) {
                    v().W0();
                } else {
                    this.C = true;
                }
            }
            this.v = v().f2();
            boolean isEnabled = this.t.isEnabled();
            if (bs7Var.y().c() == 0 && this.v) {
                this.t.setEnabled(false);
            } else if (!isEnabled) {
                this.t.setEnabled(true);
                this.t.o();
            }
            this.f.t(videoPbViewModel.m());
            this.f.u(this.v);
            this.f.s(bs7Var, z2);
            this.l = false;
            if (TbadkCoreApplication.isLogin()) {
                this.d.setNextPage(this.h);
                this.o = 2;
                if (s() != null && s().N != null) {
                    this.b.N.V();
                }
            } else {
                this.l = true;
                if (bs7Var.y().b() == 1) {
                    if (this.j == null) {
                        h08 h08Var = new h08(this, this);
                        this.j = h08Var;
                        h08Var.a();
                        this.j.g();
                        if (this.f instanceof lz7) {
                            this.j.h(new i(this));
                        }
                    }
                    this.d.setNextPage(this.j);
                } else {
                    this.d.setNextPage(this.h);
                }
                this.o = 3;
            }
            if (this.r != null) {
                os7 os7Var = new os7(os7.h);
                ThreadData O = bs7Var.O();
                if (O != null) {
                    O.getReply_num();
                }
                v().f2();
                os7Var.d = g1();
                os7Var.c = bs7Var.g;
                bs7Var.c();
                os7Var.e = bs7Var.g0();
                os7Var.g = bs7Var.f;
                this.r.i(os7Var);
            }
            ArrayList<PostData> F = bs7Var.F();
            if (bs7Var.y().b() != 0 && F != null && F.size() >= bs7Var.y().e()) {
                if (v().y1()) {
                    if (this.n) {
                        R0();
                        if (bs7Var.y().b() != 0) {
                            this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dc3));
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
                if (bs7Var.y().b() == 0) {
                    this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ec));
                } else {
                    this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a31));
                }
                this.h.k();
                if (bs7Var.y().b() == 0 || F == null) {
                    m1();
                }
            }
            if (i3 == 2) {
                this.d.setSelection(i4 > 1 ? (i4 + ((this.d.getData() == null && bs7Var.F() == null) ? 0 : this.d.getData().size() - bs7Var.F().size())) - 2 : 0);
            } else if (i3 != 3) {
                if (i3 == 4) {
                    this.n = false;
                } else if (i3 == 5) {
                    this.d.setSelection(0);
                } else if (i3 == 6) {
                    if (i5 == 1) {
                        Parcelable e2 = xv7.b().e();
                        if (e2 instanceof RecyclerView.SavedState) {
                            this.d.onRestoreInstanceState(e2);
                        }
                    }
                    this.d.setSelection(0);
                } else if (i3 == 8) {
                    this.d.setSelection(i4 > 0 ? i4 + ((this.d.getData() == null && bs7Var.F() == null) ? 0 : this.d.getData().size() - bs7Var.F().size()) : 0);
                    this.h.f();
                    this.h.C(getString(R.string.obfuscated_res_0x7f0f0dc4));
                    this.h.x();
                }
            } else if (i5 == 1) {
                Parcelable e3 = xv7.b().e();
                if (e3 instanceof RecyclerView.SavedState) {
                    this.d.onRestoreInstanceState(e3);
                    if (ListUtils.getCount(F) > 1 && bs7Var.y().b() > 0) {
                        this.h.f();
                        this.h.C(getString(R.string.obfuscated_res_0x7f0f0dc4));
                        this.h.x();
                    }
                }
            }
            if (this.m) {
                k1();
                this.m = false;
                if (i5 == 0) {
                    r1(true);
                }
            }
            s().e4(bs7Var);
            if (this.h != null) {
                if (bs7Var.y().b() == 0) {
                    this.h.K(8);
                } else {
                    this.h.K(0);
                }
            }
            if (qw7.a(X0())) {
                if (v().S2()) {
                    qw7.g(X0(), v().p1());
                } else if (videoPbViewModel.n()) {
                    videoPbViewModel.x(false);
                    if (v().T2()) {
                        qw7.h(X0(), v().q1(), f1());
                        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.r;
                        if (pbReplyTitleViewHolder != null) {
                            pbReplyTitleViewHolder.t(0);
                        }
                    } else {
                        qw7.e(X0());
                    }
                } else if (!StringUtils.isNull(videoPbViewModel.g())) {
                    qw7.f(X0(), videoPbViewModel.g());
                    videoPbViewModel.y(null);
                }
            }
            if (this.a instanceof PbActivity) {
                videoPbViewModel.v(false);
                ((PbActivity) this.a).logOnPbDataSet(bs7Var.g(), this.d);
            }
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
            return this.h.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ec));
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
            if (s() != null && s().N != null) {
                this.b.N.V();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.FALSE));
        }
    }

    public void S0() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bdSwipeRefreshLayout = this.t) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.t.setRefreshing(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: T0 */
    public kz7 C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f : (kz7) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.x : invokeV.intValue;
    }

    public View Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    public int a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.w : invokeV.intValue;
    }

    public vz7 b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.g : (vz7) invokeV.objValue;
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0690, (ViewGroup) null));
            this.r = pbReplyTitleViewHolder;
            pbReplyTitleViewHolder.u = false;
            pbReplyTitleViewHolder.r(s().Z2());
            this.r.q(s().M1);
            this.r.t(8);
            if (!this.b.F3()) {
                this.q.addView(this.r.k());
            }
            this.s = new PbChildTitleViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0666, (ViewGroup) null));
            as7 as7Var = new as7();
            as7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f88));
            this.s.c(as7Var);
            this.s.f(8);
            if (this.b.F3()) {
                return;
            }
            this.q.addView(this.s.d());
        }
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.y = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            this.d = (BdTypeRecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f09238a);
            e eVar = new e(this, getContext());
            this.e = eVar;
            this.d.setLayoutManager(eVar);
            if (this.b.F3()) {
                this.f = new lz7(this, this.d);
            } else {
                this.f = new nz7(this, this.d);
            }
            this.f.z(s().Z2());
            this.f.v(s().a3());
            this.f.x(s().d3());
            this.f.w(this.g.i());
            this.f.D(this.g.l());
            this.k = this.c.findViewById(R.id.obfuscated_res_0x7f091aa7);
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.h = pbListView;
            View findViewById = pbListView.b().findViewById(R.id.obfuscated_res_0x7f091716);
            this.i = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(s().Z2());
                SkinManager.setBackgroundResource(this.i, R.drawable.pb_foot_more_trans_selector);
            }
            this.h.z();
            this.h.o(R.drawable.pb_foot_more_trans_selector);
            this.h.p(R.drawable.pb_foot_more_trans_selector);
            this.h.s();
            this.d.setOnSrollToBottomListener(this.H);
            this.d.addOnScrollListener(this.D);
            this.d.setOnTouchListener(s().e3());
            this.A = new f(this);
            this.d.getViewTreeObserver().addOnGlobalLayoutListener(this.A);
            if (this.u == null) {
                qu4 qu4Var = new qu4(getPageContext());
                this.u = qu4Var;
                qu4Var.n();
                this.u.e(this.E);
            }
            if (this.t == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09176e);
                this.t = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.u);
                this.t.setEnabled(false);
                SkinManager.setBackgroundColor(this.t, R.color.CAM_X0205);
            }
            this.q = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09238d);
            c1();
            this.f.y(s().M1);
            registerListener(this.F);
            registerListener(this.G);
        }
    }

    public void e1() {
        bs7 P1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (P1 = v().P1()) == null) {
            return;
        }
        this.f.u(v().f2());
        this.f.r(P1);
        this.f.l();
        ArrayList<PostData> F = P1.F();
        if (P1.y().b() == 0 || F == null || F.size() < P1.y().e()) {
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                if (P1.y().b() == 0) {
                    this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ec));
                } else {
                    this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a31));
                }
                this.h.k();
            } else if (g1()) {
                this.h.H(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dcb), this.y);
            } else {
                this.h.H(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dcc), this.y);
            }
        }
        s().e4(P1);
    }

    public final boolean f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            return absPbActivity != null && absPbActivity.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0) == 12;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || getView() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        hideLoadingView(viewGroup);
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setVisibility(0);
        }
    }

    public boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (v() != null) {
                return v().s1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.y95
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public final void i1() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (bdTypeRecyclerView = this.d) == null || this.e == null || this.f == null) {
            return;
        }
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount() + this.f.d();
        int headerViewsCount2 = this.d.getHeaderViewsCount() + this.f.c();
        int findFirstVisibleItemPosition = this.e.findFirstVisibleItemPosition();
        if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
            this.r.t(0);
        } else {
            this.r.t(8);
        }
        if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
            this.s.f(0);
            this.r.t(8);
        } else {
            this.s.f(8);
        }
        if ((headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) || (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2)) {
            t1(0);
        } else {
            t1(8);
        }
    }

    @Override // com.repackage.y95
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.y95
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView == null) {
                return false;
            }
            return !bdTypeRecyclerView.canScrollVertically(-1);
        }
        return invokeV.booleanValue;
    }

    public void j1(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || (bdTypeRecyclerView = this.d) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    public void k1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.d == null) {
        }
    }

    @Override // com.repackage.h08.b
    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.p = z;
        }
    }

    public void l1() {
        kz7 kz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (kz7Var = this.f) == null) {
            return;
        }
        kz7Var.m();
    }

    public void m1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || this.o == 2) {
            return;
        }
        this.d.setNextPage(this.h);
        this.o = 2;
    }

    public void n1(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048605, this, i2, i3) == null) || (bdTypeRecyclerView = this.d) == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.d.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.d.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public final void o1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || s() == null || w() == null || w().getPbModel() == null || this.f.e() == null) {
            return;
        }
        uu7.a().g(w().getPbModel().y2(), this.f.e().c0(), this.r.k(), w().getPageStayDurationItem(), z, null, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(w()).get(VideoPbViewModel.class);
            videoPbViewModel.o().observe(this, new g(this));
            P0(true, 0, 3, 0, videoPbViewModel.c(), "", 1, true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, context) == null) {
            super.onAttach(context);
            if (context instanceof AbsPbActivity) {
                this.a = (AbsPbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            super.onChangeSkinType(i2);
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.d(i2);
                if (this.i != null) {
                    getBaseFragmentActivity().getLayoutMode().j(this.i);
                    SkinManager.setBackgroundResource(this.i, R.drawable.pb_foot_more_trans_selector);
                }
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.r;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.m(i2);
            }
            PbChildTitleViewHolder pbChildTitleViewHolder = this.s;
            if (pbChildTitleViewHolder != null) {
                pbChildTitleViewHolder.e();
            }
            kz7 kz7Var = this.f;
            if (kz7Var != null) {
                kz7Var.l();
            }
            View view2 = this.k;
            if (view2 != null) {
                SkinManager.setBackgroundResource(view2, R.drawable.personalize_tab_shadow);
            }
            SkinManager.setBackgroundColor(this.t, R.color.CAM_X0201);
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setBackgroundResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048611, this, layoutInflater, viewGroup, bundle)) == null) {
            this.g = new vz7(this);
            this.c = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0668, (ViewGroup) null);
            d1();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onDestroy();
            kz7 kz7Var = this.f;
            if (kz7Var != null) {
                kz7Var.n();
            }
            MessageManager.getInstance().unRegisterListener(this.F);
            MessageManager.getInstance().unRegisterListener(this.G);
            uu7.a().d();
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.A);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onPause();
            if (s() != null) {
                uu7.a().j(w());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onResume();
            this.p = false;
            o1(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            super.onUserChanged(z);
            v1(z);
            if (s() != null && s().N != null) {
                this.b.N.H();
            }
            if (z && this.p) {
                s1();
                v().I2(true);
            }
        }
    }

    @Override // com.repackage.y95
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
        }
    }

    public void p1(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, str) == null) || (pbListView = this.h) == null) {
            return;
        }
        pbListView.C(str);
    }

    public void q1(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, str) == null) || (pbListView = this.h) == null) {
            return;
        }
        pbListView.H(str, this.y);
    }

    public void r1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.m = z;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsVideoPbFragment s() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
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

    public void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.h.z();
            this.h.Q();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.TRUE));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, view2) == null) {
            super.showLoadingView(view2);
        }
    }

    @Override // com.repackage.fz7
    public void t0(boolean z, int i2, int i3, int i4, bs7 bs7Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bs7Var, str, Integer.valueOf(i5)}) == null) || getActivity() == null) {
            return;
        }
        P0(z, i2, i3, i4, bs7Var, str, i5, false);
    }

    public void t1(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048624, this, i2) == null) || (view2 = this.k) == null) {
            return;
        }
        view2.setVisibility(i2);
    }

    public void u1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048625, this) == null) || getView() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setVisibility(8);
        }
        showLoadingView(viewGroup);
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? s().v() : (PbModel) invokeV.objValue;
    }

    public void v1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048627, this, z) == null) && z && this.l) {
            this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03e4));
            this.d.setNextPage(this.h);
            this.o = 2;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsPbActivity w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            return absPbActivity != null ? absPbActivity : s().w();
        }
        return (AbsPbActivity) invokeV.objValue;
    }
}
