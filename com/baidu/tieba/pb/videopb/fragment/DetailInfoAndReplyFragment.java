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
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.a38;
import com.baidu.tieba.cz7;
import com.baidu.tieba.ej;
import com.baidu.tieba.i38;
import com.baidu.tieba.ie5;
import com.baidu.tieba.iv7;
import com.baidu.tieba.jn8;
import com.baidu.tieba.jv7;
import com.baidu.tieba.l18;
import com.baidu.tieba.p38;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbChildTitleViewHolder;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.s28;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.wv7;
import com.baidu.tieba.x28;
import com.baidu.tieba.y28;
import com.baidu.tieba.yx4;
import com.baidu.tieba.zx4;
import com.baidu.tieba.zx7;
import com.baidu.tieba.zz7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements s28, p38.b, ie5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewTreeObserver.OnGlobalLayoutListener A;
    public boolean B;
    public boolean C;
    public RecyclerView.OnScrollListener D;
    public final yx4.g E;
    public CustomMessageListener F;
    public final CustomMessageListener G;
    public final BdListView.p H;
    public AbsPbActivity a;
    public AbsVideoPbFragment b;
    public View c;
    public BdTypeRecyclerView d;
    public LinearLayoutManager e;
    public x28 f;
    public i38 g;
    public PbListView h;
    public View i;
    public p38 j;
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
    public zx4 u;
    public boolean v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes5.dex */
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
                    this.a.B().Y4();
                    this.a.B().a5();
                }
                if (this.a.B() != null) {
                    this.a.B().L4(i);
                }
                if (i == 0) {
                    this.a.d2(true);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                this.a.X1();
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

    /* loaded from: classes5.dex */
    public class b implements yx4.g {
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

        @Override // com.baidu.tieba.yx4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.K() != null && this.a.K().R2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.H1();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.K() == null || this.a.K().S1() == null || this.a.K().S1().F() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            jn8 jn8Var = null;
            Iterator<PostData> it = this.a.K().S1().F().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PostData next = it.next();
                if (next instanceof jn8) {
                    jn8 jn8Var2 = (jn8) next;
                    if (str.equals(jn8Var2.k1())) {
                        jn8Var = jn8Var2;
                        break;
                    }
                }
            }
            if (jn8Var == null || this.a.f == null || this.a.d == null) {
                return;
            }
            this.a.K().S1().F().remove(jn8Var);
            if (this.a.f.a() != null) {
                this.a.f.a().remove(jn8Var);
            }
            if (this.a.d.getListView2().getData() != null) {
                this.a.d.getListView2().getData().remove(jn8Var);
            }
            this.a.f.l();
        }
    }

    /* loaded from: classes5.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.K() == null || !(customResponsedMessage.getData() instanceof jv7)) {
                return;
            }
            jv7 jv7Var = (jv7) customResponsedMessage.getData();
            if (StringHelper.equals(this.a.K().m2(), jv7Var.Q())) {
                this.a.K().d1(jv7Var.O());
                this.a.K().Z2(jv7Var, 3, "");
                MessageManager.getInstance().unRegisterStickyMode(2921648);
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
            this.a.B().n3(this.a.d, false);
        }
    }

    /* loaded from: classes5.dex */
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
                    this.a.j2();
                } else {
                    this.a.m();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (!this.a.z && this.a.F1() && this.a.K() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.K().m2());
                    statisticItem.param("fid", this.a.K().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    this.a.z = true;
                }
                if (this.a.K().N2(false)) {
                    this.a.h2();
                    if (this.a.getPageContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (this.a.K().S1() != null) {
                    this.a.b2();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.V0(true);
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

    public static DetailInfoAndReplyFragment W1(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, absVideoPbFragment)) == null) {
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
                Fragment c1 = absPbActivity.c1();
                if (c1 instanceof AbsVideoPbFragment) {
                    this.b = (AbsVideoPbFragment) c1;
                }
            }
            return this.b;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    public final void E1(boolean z, int i2, int i3, int i4, jv7 jv7Var, String str, int i5, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), jv7Var, str, Integer.valueOf(i5), Boolean.valueOf(z2)}) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(P()).get(VideoPbViewModel.class);
            if (!z || K() == null || jv7Var == null) {
                return;
            }
            if (!z2) {
                if (this.C) {
                    K().Z0();
                } else {
                    this.C = true;
                }
            }
            this.v = K().k2();
            boolean isEnabled = this.t.isEnabled();
            if (jv7Var.y().c() == 0 && this.v) {
                this.t.setEnabled(false);
            } else if (!isEnabled) {
                this.t.setEnabled(true);
                this.t.o();
            }
            this.f.t(videoPbViewModel.m());
            this.f.u(this.v);
            this.f.s(jv7Var, z2);
            this.l = false;
            if (TbadkCoreApplication.isLogin()) {
                this.d.setNextPage(this.h);
                this.o = 2;
                if (B() != null && B().N != null) {
                    this.b.N.V();
                }
            } else {
                this.l = true;
                if (jv7Var.y().b() == 1) {
                    if (this.j == null) {
                        p38 p38Var = new p38(this, this);
                        this.j = p38Var;
                        p38Var.a();
                        this.j.g();
                        if (this.f instanceof y28) {
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
                wv7 wv7Var = new wv7(wv7.i);
                ThreadData O = jv7Var.O();
                if (O != null) {
                    O.getReply_num();
                }
                K().k2();
                wv7Var.d = V1();
                wv7Var.c = jv7Var.g;
                jv7Var.c();
                wv7Var.e = jv7Var.i0();
                wv7Var.g = jv7Var.f;
                this.r.h(wv7Var);
            }
            ArrayList<PostData> F = jv7Var.F();
            if (jv7Var.y().b() != 0 && F != null && F.size() >= jv7Var.y().e()) {
                if (K().B1()) {
                    if (this.n) {
                        G1();
                        if (jv7Var.y().b() != 0) {
                            this.h.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0df4));
                        }
                    } else {
                        this.h.A();
                        this.h.O();
                    }
                } else {
                    this.h.A();
                    this.h.O();
                }
                this.h.k();
            } else {
                if (jv7Var.y().b() == 0) {
                    this.h.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ff));
                } else {
                    this.h.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a53));
                }
                this.h.k();
                if (jv7Var.y().b() == 0 || F == null) {
                    b2();
                }
            }
            if (i3 == 2) {
                this.d.setSelection(i4 > 1 ? (i4 + ((this.d.getData() == null && jv7Var.F() == null) ? 0 : this.d.getData().size() - jv7Var.F().size())) - 2 : 0);
            } else if (i3 != 3) {
                if (i3 == 4) {
                    this.n = false;
                } else if (i3 == 5) {
                    this.d.setSelection(0);
                } else if (i3 == 6) {
                    if (i5 == 1) {
                        Parcelable e2 = cz7.b().e();
                        if (e2 instanceof RecyclerView.SavedState) {
                            this.d.onRestoreInstanceState(e2);
                        }
                    }
                    this.d.setSelection(0);
                } else if (i3 == 8) {
                    this.d.setSelection(i4 > 0 ? i4 + ((this.d.getData() == null && jv7Var.F() == null) ? 0 : this.d.getData().size() - jv7Var.F().size()) : 0);
                    this.h.f();
                    this.h.D(getString(R.string.obfuscated_res_0x7f0f0df5));
                    this.h.y();
                }
            } else if (i5 == 1) {
                Parcelable e3 = cz7.b().e();
                if (e3 instanceof RecyclerView.SavedState) {
                    this.d.onRestoreInstanceState(e3);
                    if (ListUtils.getCount(F) > 1 && jv7Var.y().b() > 0) {
                        this.h.f();
                        this.h.D(getString(R.string.obfuscated_res_0x7f0f0df5));
                        this.h.y();
                    }
                }
            }
            if (this.m) {
                Z1();
                this.m = false;
                if (i5 == 0) {
                    g2(true);
                }
            }
            B().T4(jv7Var);
            if (this.h != null) {
                if (jv7Var.y().b() == 0) {
                    this.h.L(8);
                } else {
                    this.h.L(0);
                }
            }
            if (zz7.a(M1())) {
                if (K().X2()) {
                    zz7.g(M1(), K().s1());
                } else if (videoPbViewModel.n()) {
                    videoPbViewModel.x(false);
                    if (K().Y2()) {
                        zz7.h(M1(), K().t1(), U1());
                        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.r;
                        if (pbReplyTitleViewHolder != null) {
                            pbReplyTitleViewHolder.s(0);
                        }
                    } else {
                        zz7.e(M1());
                    }
                } else if (!StringUtils.isNull(videoPbViewModel.g())) {
                    zz7.f(M1(), videoPbViewModel.g());
                    videoPbViewModel.y(null);
                }
            }
            if (this.a instanceof PbActivity) {
                videoPbViewModel.v(false);
                ((PbActivity) this.a).A1(jv7Var.g(), this.d);
            }
        }
    }

    public boolean F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbListView pbListView = this.h;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.h.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ff));
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ie5
    public boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.y();
                this.h.f();
            }
            if (B() != null && B().N != null) {
                this.b.N.V();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.FALSE));
        }
    }

    public void H1() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (bdSwipeRefreshLayout = this.t) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.t.setRefreshing(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: I1 */
    public x28 q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (x28) invokeV.objValue;
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

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? B().K() : (PbModel) invokeV.objValue;
    }

    public int K1() {
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

    public int L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
                return (K() == null || K().S1() == null || lastVisiblePosition < K().S1().F().size()) ? lastVisiblePosition : K().S1().F().size() - 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public BdTypeRecyclerView M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.d : (BdTypeRecyclerView) invokeV.objValue;
    }

    public int N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.x : invokeV.intValue;
    }

    public View O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsPbActivity P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            return absPbActivity != null ? absPbActivity : B().P();
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public int P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.w : invokeV.intValue;
    }

    public i38 Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.g : (i38) invokeV.objValue;
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d06e7, (ViewGroup) null));
            this.r = pbReplyTitleViewHolder;
            pbReplyTitleViewHolder.v = false;
            pbReplyTitleViewHolder.q(B().P3());
            this.r.p(B().K1);
            this.r.s(8);
            if (!this.b.v4()) {
                this.q.addView(this.r.j());
            }
            this.s = new PbChildTitleViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d06ba, (ViewGroup) null));
            iv7 iv7Var = new iv7();
            iv7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fdd));
            this.s.a(iv7Var);
            this.s.d(8);
            if (this.b.v4()) {
                return;
            }
            this.q.addView(this.s.b());
        }
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.y = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            this.d = (BdTypeRecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f092550);
            e eVar = new e(this, getContext());
            this.e = eVar;
            this.d.setLayoutManager(eVar);
            if (this.b.v4()) {
                this.f = new y28(this, this.d);
            } else {
                this.f = new a38(this, this.d);
            }
            this.f.A(B().P3());
            this.f.v(B().Q3());
            this.f.y(B().T3());
            this.f.x(this.g.j());
            this.f.E(this.g.m());
            this.k = this.c.findViewById(R.id.obfuscated_res_0x7f091bf8);
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.h = pbListView;
            View findViewById = pbListView.b().findViewById(R.id.obfuscated_res_0x7f09184a);
            this.i = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(B().P3());
                SkinManager.setBackgroundResource(this.i, R.drawable.pb_foot_more_trans_selector);
            }
            this.h.A();
            this.h.o(R.drawable.pb_foot_more_trans_selector);
            this.h.p(R.drawable.pb_foot_more_trans_selector);
            this.h.s();
            this.d.setOnSrollToBottomListener(this.H);
            this.d.addOnScrollListener(this.D);
            this.d.setOnTouchListener(B().U3());
            this.A = new f(this);
            this.d.getViewTreeObserver().addOnGlobalLayoutListener(this.A);
            if (this.u == null) {
                zx4 zx4Var = new zx4(getPageContext());
                this.u = zx4Var;
                zx4Var.n();
                this.u.f(this.E);
            }
            if (this.t == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0918a3);
                this.t = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.u);
                this.t.setEnabled(false);
                SkinManager.setBackgroundColor(this.t, R.color.CAM_X0205);
            }
            this.q = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f092553);
            R1();
            this.f.z(B().K1);
            registerListener(this.F);
            registerListener(this.G);
        }
    }

    public void T1() {
        jv7 S1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (S1 = K().S1()) == null) {
            return;
        }
        this.f.u(K().k2());
        this.f.r(S1);
        this.f.l();
        ArrayList<PostData> F = S1.F();
        if (S1.y().b() == 0 || F == null || F.size() < S1.y().e()) {
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).C() != 1)) {
                if (S1.y().b() == 0) {
                    this.h.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ff));
                } else {
                    this.h.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a53));
                }
                this.h.k();
            } else if (V1()) {
                this.h.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dfb), this.y);
            } else {
                this.h.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dfc), this.y);
            }
        }
        B().T4(S1);
    }

    public final boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            return absPbActivity != null && absPbActivity.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0) == 12;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.p38.b
    public void V0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.p = z;
        }
    }

    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (K() != null) {
                return K().v1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void X1() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (bdTypeRecyclerView = this.d) == null || this.e == null || this.f == null) {
            return;
        }
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount() + this.f.d();
        int headerViewsCount2 = this.d.getHeaderViewsCount() + this.f.c();
        int findFirstVisibleItemPosition = this.e.findFirstVisibleItemPosition();
        if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
            this.r.s(0);
        } else {
            this.r.s(8);
        }
        if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
            this.s.d(0);
            this.r.s(8);
        } else {
            this.s.d(8);
        }
        if ((headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) || (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2)) {
            i2(0);
        } else {
            i2(8);
        }
    }

    public void Y1(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || (bdTypeRecyclerView = this.d) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    public void Z1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.d == null) {
        }
    }

    public void a2() {
        x28 x28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (x28Var = this.f) == null) {
            return;
        }
        x28Var.m();
    }

    public void b2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.o == 2) {
            return;
        }
        this.d.setNextPage(this.h);
        this.o = 2;
    }

    public void c2(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048604, this, i2, i3) == null) || (bdTypeRecyclerView = this.d) == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.d.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.d.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public final void d2(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || B() == null || P() == null || P().j1() == null || this.f.e() == null) {
            return;
        }
        zx7.a().g(P().j1().D2(), this.f.e().v(), this.r.j(), P().getPageStayDurationItem(), z, null, null);
    }

    public void e2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, str) == null) || (pbListView = this.h) == null) {
            return;
        }
        pbListView.D(str);
    }

    @Override // com.baidu.tieba.s28
    public void f1(boolean z, int i2, int i3, int i4, jv7 jv7Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), jv7Var, str, Integer.valueOf(i5)}) == null) || getActivity() == null) {
            return;
        }
        E1(z, i2, i3, i4, jv7Var, str, i5, false);
    }

    public void f2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, str) == null) || (pbListView = this.h) == null) {
            return;
        }
        pbListView.I(str, this.y);
    }

    public void g2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.m = z;
        }
    }

    @Override // com.baidu.tieba.ie5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.h.A();
            this.h.R();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.TRUE));
        }
    }

    public void i2(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048612, this, i2) == null) || (view2 = this.k) == null) {
            return;
        }
        view2.setVisibility(i2);
    }

    public void j2() {
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

    public void k2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048614, this, z) == null) && z && this.l) {
            this.h.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03ef));
            this.d.setNextPage(this.h);
            this.o = 2;
        }
    }

    public void l2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            x28 x28Var = this.f;
            if (x28Var != null) {
                x28Var.w(z);
                this.f.l();
            }
            if (z && B() != null) {
                l18.d(getPageContext(), K(), this, B().getView());
            }
            jv7 S1 = K().S1();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK).param("fid", S1 != null ? S1.m() : "0").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || getView() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        hideLoadingView(viewGroup);
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ie5
    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(P()).get(VideoPbViewModel.class);
            videoPbViewModel.o().observe(this, new g(this));
            E1(true, 0, 3, 0, videoPbViewModel.c(), "", 1, true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, context) == null) {
            super.onAttach(context);
            if (context instanceof AbsPbActivity) {
                this.a = (AbsPbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            super.onChangeSkinType(i2);
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.d(i2);
                if (this.i != null) {
                    getBaseFragmentActivity().getLayoutMode().k(this.i);
                    SkinManager.setBackgroundResource(this.i, R.drawable.pb_foot_more_trans_selector);
                }
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.r;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.l(i2);
            }
            PbChildTitleViewHolder pbChildTitleViewHolder = this.s;
            if (pbChildTitleViewHolder != null) {
                pbChildTitleViewHolder.c();
            }
            x28 x28Var = this.f;
            if (x28Var != null) {
                x28Var.l();
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
        if (interceptable == null || interceptable.invokeL(1048621, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048622, this, layoutInflater, viewGroup, bundle)) == null) {
            this.g = new i38(this);
            this.c = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d06bc, (ViewGroup) null);
            S1();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            super.onDestroy();
            x28 x28Var = this.f;
            if (x28Var != null) {
                x28Var.n();
            }
            MessageManager.getInstance().unRegisterListener(this.F);
            MessageManager.getInstance().unRegisterListener(this.G);
            zx7.a().d();
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.A);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.onPause();
            l18.a();
            if (B() != null) {
                zx7.a().j(P());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            super.onResume();
            this.p = false;
            d2(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            super.onUserChanged(z);
            k2(z);
            if (B() != null && B().N != null) {
                this.b.N.H();
            }
            if (z && this.p) {
                h2();
                K().N2(true);
            }
        }
    }

    @Override // com.baidu.tieba.ie5
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048629, this, view2) == null) {
            super.showLoadingView(view2);
        }
    }
}
