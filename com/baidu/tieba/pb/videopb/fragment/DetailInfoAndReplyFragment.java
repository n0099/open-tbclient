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
import com.repackage.cu7;
import com.repackage.fv7;
import com.repackage.fz7;
import com.repackage.gu4;
import com.repackage.hu4;
import com.repackage.ir7;
import com.repackage.ja5;
import com.repackage.jr7;
import com.repackage.ni8;
import com.repackage.pi;
import com.repackage.py7;
import com.repackage.rz7;
import com.repackage.uy7;
import com.repackage.vy7;
import com.repackage.wr7;
import com.repackage.xy7;
import com.repackage.zv7;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements py7, rz7.b, ja5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewTreeObserver.OnGlobalLayoutListener A;
    public boolean B;
    public boolean C;
    public RecyclerView.OnScrollListener D;
    public final gu4.g E;
    public CustomMessageListener F;
    public final CustomMessageListener G;
    public final BdListView.p H;
    public AbsPbActivity a;
    public AbsVideoPbFragment b;
    public View c;
    public BdTypeRecyclerView d;
    public LinearLayoutManager e;
    public uy7 f;
    public fz7 g;
    public PbListView h;
    public View i;
    public rz7 j;
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
    public hu4 u;
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
                    this.a.B().c5();
                    this.a.B().e5();
                }
                if (this.a.B() != null) {
                    this.a.B().P4(i);
                }
                if (i == 0) {
                    this.a.f2(true);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                this.a.Z1();
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
    public class b implements gu4.g {
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

        @Override // com.repackage.gu4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.F() != null && this.a.F().O2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.J1();
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
            if (ni8Var == null || this.a.f == null || this.a.d == null) {
                return;
            }
            this.a.F().R1().F().remove(ni8Var);
            if (this.a.f.a() != null) {
                this.a.f.a().remove(ni8Var);
            }
            if (this.a.d.getListView2().getData() != null) {
                this.a.d.getListView2().getData().remove(ni8Var);
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.F() == null || !(customResponsedMessage.getData() instanceof jr7)) {
                return;
            }
            jr7 jr7Var = (jr7) customResponsedMessage.getData();
            if (StringHelper.equals(this.a.F().j2(), jr7Var.Q())) {
                this.a.F().c1(jr7Var.O());
                this.a.F().W2(jr7Var, 3, "");
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.B || this.a.B() == null) {
                return;
            }
            this.a.B = true;
            this.a.B().q3(this.a.d, false);
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
                    this.a.l2();
                } else {
                    this.a.m();
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
                if (!this.a.z && this.a.H1() && this.a.F() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.F().j2());
                    statisticItem.param("fid", this.a.F().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    this.a.z = true;
                }
                if (this.a.F().K2(false)) {
                    this.a.j2();
                    if (this.a.getPageContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (this.a.F().R1() != null) {
                    this.a.d2();
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
                this.a.X0(true);
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

    public static DetailInfoAndReplyFragment Y1(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
            detailInfoAndReplyFragment.setArguments(bundle);
            detailInfoAndReplyFragment.b = absVideoPbFragment;
            return detailInfoAndReplyFragment;
        }
        return (DetailInfoAndReplyFragment) invokeL.objValue;
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

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? B().F() : (PbModel) invokeV.objValue;
    }

    public final void G1(boolean z, int i2, int i3, int i4, jr7 jr7Var, String str, int i5, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), jr7Var, str, Integer.valueOf(i5), Boolean.valueOf(z2)}) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(N()).get(VideoPbViewModel.class);
            if (!z || F() == null || jr7Var == null) {
                return;
            }
            if (!z2) {
                if (this.C) {
                    F().Y0();
                } else {
                    this.C = true;
                }
            }
            this.v = F().h2();
            boolean isEnabled = this.t.isEnabled();
            if (jr7Var.y().c() == 0 && this.v) {
                this.t.setEnabled(false);
            } else if (!isEnabled) {
                this.t.setEnabled(true);
                this.t.o();
            }
            this.f.t(videoPbViewModel.m());
            this.f.u(this.v);
            this.f.s(jr7Var, z2);
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
                        if (this.f instanceof vy7) {
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
                wr7 wr7Var = new wr7(wr7.h);
                ThreadData O = jr7Var.O();
                if (O != null) {
                    O.getReply_num();
                }
                F().h2();
                wr7Var.d = X1();
                wr7Var.c = jr7Var.g;
                jr7Var.c();
                wr7Var.e = jr7Var.g0();
                wr7Var.g = jr7Var.f;
                this.r.h(wr7Var);
            }
            ArrayList<PostData> F = jr7Var.F();
            if (jr7Var.y().b() != 0 && F != null && F.size() >= jr7Var.y().e()) {
                if (F().A1()) {
                    if (this.n) {
                        I1();
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
                if (jr7Var.y().b() == 0) {
                    this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09cf));
                } else {
                    this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a15));
                }
                this.h.k();
                if (jr7Var.y().b() == 0 || F == null) {
                    d2();
                }
            }
            if (i3 == 2) {
                this.d.setSelection(i4 > 1 ? (i4 + ((this.d.getData() == null && jr7Var.F() == null) ? 0 : this.d.getData().size() - jr7Var.F().size())) - 2 : 0);
            } else if (i3 != 3) {
                if (i3 == 4) {
                    this.n = false;
                } else if (i3 == 5) {
                    this.d.setSelection(0);
                } else if (i3 == 6) {
                    if (i5 == 1) {
                        Parcelable e2 = fv7.b().e();
                        if (e2 instanceof RecyclerView.SavedState) {
                            this.d.onRestoreInstanceState(e2);
                        }
                    }
                    this.d.setSelection(0);
                } else if (i3 == 8) {
                    this.d.setSelection(i4 > 0 ? i4 + ((this.d.getData() == null && jr7Var.F() == null) ? 0 : this.d.getData().size() - jr7Var.F().size()) : 0);
                    this.h.f();
                    this.h.C(getString(R.string.obfuscated_res_0x7f0f0dab));
                    this.h.x();
                }
            } else if (i5 == 1) {
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
                b2();
                this.m = false;
                if (i5 == 0) {
                    i2(true);
                }
            }
            B().X4(jr7Var);
            if (this.h != null) {
                if (jr7Var.y().b() == 0) {
                    this.h.K(8);
                } else {
                    this.h.K(0);
                }
            }
            if (zv7.a(O1())) {
                if (F().U2()) {
                    zv7.g(O1(), F().r1());
                } else if (videoPbViewModel.n()) {
                    videoPbViewModel.x(false);
                    if (F().V2()) {
                        zv7.h(O1(), F().s1(), W1());
                        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.r;
                        if (pbReplyTitleViewHolder != null) {
                            pbReplyTitleViewHolder.r(0);
                        }
                    } else {
                        zv7.e(O1());
                    }
                } else if (!StringUtils.isNull(videoPbViewModel.g())) {
                    zv7.f(O1(), videoPbViewModel.g());
                    videoPbViewModel.y(null);
                }
            }
            if (this.a instanceof PbActivity) {
                videoPbViewModel.v(false);
                ((PbActivity) this.a).j1(jr7Var.g(), this.d);
            }
        }
    }

    public boolean H1() {
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

    public void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.x();
                this.h.f();
            }
            if (B() != null && B().N != null) {
                this.b.N.V();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.FALSE));
        }
    }

    @Override // com.repackage.ja5
    public boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void J1() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (bdSwipeRefreshLayout = this.t) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.t.setRefreshing(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: K1 */
    public uy7 s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f : (uy7) invokeV.objValue;
    }

    public int L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                return bdTypeRecyclerView.getFirstVisiblePosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int M1() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.d.getChildAt(0)) == null) {
                return 0;
            }
            return childAt.getTop();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsPbActivity N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            return absPbActivity != null ? absPbActivity : B().N();
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public int N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
                return (F() == null || F().R1() == null || lastVisiblePosition < F().R1().F().size()) ? lastVisiblePosition : F().R1().F().size() - 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public BdTypeRecyclerView O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.d : (BdTypeRecyclerView) invokeV.objValue;
    }

    public int P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.x : invokeV.intValue;
    }

    public View Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    public int R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.w : invokeV.intValue;
    }

    public fz7 S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.g : (fz7) invokeV.objValue;
    }

    public final void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d06a9, (ViewGroup) null));
            this.r = pbReplyTitleViewHolder;
            pbReplyTitleViewHolder.u = false;
            pbReplyTitleViewHolder.p(B().S3());
            this.r.o(B().M1);
            this.r.r(8);
            if (!this.b.y4()) {
                this.q.addView(this.r.j());
            }
            this.s = new PbChildTitleViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d067e, (ViewGroup) null));
            ir7 ir7Var = new ir7();
            ir7Var.d(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f88));
            this.s.b(ir7Var);
            this.s.e(8);
            if (this.b.y4()) {
                return;
            }
            this.q.addView(this.s.c());
        }
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.y = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            this.d = (BdTypeRecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f0923c6);
            e eVar = new e(this, getContext());
            this.e = eVar;
            this.d.setLayoutManager(eVar);
            if (this.b.y4()) {
                this.f = new vy7(this, this.d);
            } else {
                this.f = new xy7(this, this.d);
            }
            this.f.z(B().S3());
            this.f.v(B().T3());
            this.f.x(B().W3());
            this.f.w(this.g.i());
            this.f.D(this.g.l());
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
            this.d.setOnSrollToBottomListener(this.H);
            this.d.addOnScrollListener(this.D);
            this.d.setOnTouchListener(B().X3());
            this.A = new f(this);
            this.d.getViewTreeObserver().addOnGlobalLayoutListener(this.A);
            if (this.u == null) {
                hu4 hu4Var = new hu4(getPageContext());
                this.u = hu4Var;
                hu4Var.n();
                this.u.f(this.E);
            }
            if (this.t == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09179b);
                this.t = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.u);
                this.t.setEnabled(false);
                SkinManager.setBackgroundColor(this.t, R.color.CAM_X0205);
            }
            this.q = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0923c9);
            T1();
            this.f.y(B().M1);
            registerListener(this.F);
            registerListener(this.G);
        }
    }

    public void V1() {
        jr7 R1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (R1 = F().R1()) == null) {
            return;
        }
        this.f.u(F().h2());
        this.f.r(R1);
        this.f.l();
        ArrayList<PostData> F = R1.F();
        if (R1.y().b() == 0 || F == null || F.size() < R1.y().e()) {
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).B() != 1)) {
                if (R1.y().b() == 0) {
                    this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09cf));
                } else {
                    this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a15));
                }
                this.h.k();
            } else if (X1()) {
                this.h.H(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0db1), this.y);
            } else {
                this.h.H(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0db2), this.y);
            }
        }
        B().X4(R1);
    }

    public final boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            return absPbActivity != null && absPbActivity.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0) == 12;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.rz7.b
    public void X0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.p = z;
        }
    }

    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (F() != null) {
                return F().u1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Z1() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (bdTypeRecyclerView = this.d) == null || this.e == null || this.f == null) {
            return;
        }
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount() + this.f.d();
        int headerViewsCount2 = this.d.getHeaderViewsCount() + this.f.c();
        int findFirstVisibleItemPosition = this.e.findFirstVisibleItemPosition();
        if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
            this.r.r(0);
        } else {
            this.r.r(8);
        }
        if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
            this.s.e(0);
            this.r.r(8);
        } else {
            this.s.e(8);
        }
        if ((headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) || (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2)) {
            k2(0);
        } else {
            k2(8);
        }
    }

    public void a2(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || (bdTypeRecyclerView = this.d) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    public void b2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.d == null) {
        }
    }

    public void c2() {
        uy7 uy7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (uy7Var = this.f) == null) {
            return;
        }
        uy7Var.m();
    }

    public void d2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.o == 2) {
            return;
        }
        this.d.setNextPage(this.h);
        this.o = 2;
    }

    public void e2(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048604, this, i2, i3) == null) || (bdTypeRecyclerView = this.d) == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.d.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.d.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public final void f2(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || B() == null || N() == null || N().M0() == null || this.f.e() == null) {
            return;
        }
        cu7.a().g(N().M0().A2(), this.f.e().c0(), this.r.j(), N().getPageStayDurationItem(), z, null, null);
    }

    public void g2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, str) == null) || (pbListView = this.h) == null) {
            return;
        }
        pbListView.C(str);
    }

    @Override // com.repackage.ja5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public void h2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, str) == null) || (pbListView = this.h) == null) {
            return;
        }
        pbListView.H(str, this.y);
    }

    @Override // com.repackage.py7
    public void i1(boolean z, int i2, int i3, int i4, jr7 jr7Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), jr7Var, str, Integer.valueOf(i5)}) == null) || getActivity() == null) {
            return;
        }
        G1(z, i2, i3, i4, jr7Var, str, i5, false);
    }

    public void i2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.m = z;
        }
    }

    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.h.z();
            this.h.Q();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.TRUE));
        }
    }

    public void k2(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048612, this, i2) == null) || (view2 = this.k) == null) {
            return;
        }
        view2.setVisibility(i2);
    }

    public void l2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || getView() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setVisibility(8);
        }
        showLoadingView(viewGroup);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || getView() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        hideLoadingView(viewGroup);
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setVisibility(0);
        }
    }

    public void m2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z) == null) && z && this.l) {
            this.h.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03df));
            this.d.setNextPage(this.h);
            this.o = 2;
        }
    }

    @Override // com.repackage.ja5
    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(N()).get(VideoPbViewModel.class);
            videoPbViewModel.o().observe(this, new g(this));
            G1(true, 0, 3, 0, videoPbViewModel.c(), "", 1, true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, context) == null) {
            super.onAttach(context);
            if (context instanceof AbsPbActivity) {
                this.a = (AbsPbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
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
                pbReplyTitleViewHolder.l(i2);
            }
            PbChildTitleViewHolder pbChildTitleViewHolder = this.s;
            if (pbChildTitleViewHolder != null) {
                pbChildTitleViewHolder.d();
            }
            uy7 uy7Var = this.f;
            if (uy7Var != null) {
                uy7Var.l();
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
        if (interceptable == null || interceptable.invokeL(1048620, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048621, this, layoutInflater, viewGroup, bundle)) == null) {
            this.g = new fz7(this);
            this.c = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0680, (ViewGroup) null);
            U1();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.onDestroy();
            uy7 uy7Var = this.f;
            if (uy7Var != null) {
                uy7Var.n();
            }
            MessageManager.getInstance().unRegisterListener(this.F);
            MessageManager.getInstance().unRegisterListener(this.G);
            cu7.a().d();
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.A);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            super.onPause();
            if (B() != null) {
                cu7.a().j(N());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.onResume();
            this.p = false;
            f2(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            super.onUserChanged(z);
            m2(z);
            if (B() != null && B().N != null) {
                this.b.N.H();
            }
            if (z && this.p) {
                j2();
                F().K2(true);
            }
        }
    }

    @Override // com.repackage.ja5
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView == null) {
                return false;
            }
            return !bdTypeRecyclerView.canScrollVertically(-1);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, view2) == null) {
            super.showLoadingView(view2);
        }
    }
}
