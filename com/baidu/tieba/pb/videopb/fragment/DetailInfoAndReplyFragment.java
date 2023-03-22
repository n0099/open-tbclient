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
import com.baidu.tieba.ac9;
import com.baidu.tieba.al8;
import com.baidu.tieba.aq8;
import com.baidu.tieba.bc9;
import com.baidu.tieba.bq8;
import com.baidu.tieba.cn8;
import com.baidu.tieba.dm8;
import com.baidu.tieba.dq8;
import com.baidu.tieba.hi;
import com.baidu.tieba.ji8;
import com.baidu.tieba.ki8;
import com.baidu.tieba.lq8;
import com.baidu.tieba.oo8;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbChildTitleViewHolder;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.rq8;
import com.baidu.tieba.v35;
import com.baidu.tieba.vl5;
import com.baidu.tieba.vp8;
import com.baidu.tieba.w35;
import com.baidu.tieba.xi8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements vp8, rq8.b, vl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewTreeObserver.OnGlobalLayoutListener A;
    public boolean B;
    public boolean C;
    public RecyclerView.OnScrollListener D;
    public final v35.g E;
    public CustomMessageListener F;
    public final CustomMessageListener G;
    public final BdListView.p H;
    public AbsPbActivity a;
    public AbsVideoPbFragment b;
    public View c;
    public BdTypeRecyclerView d;
    public LinearLayoutManager e;
    public aq8 f;
    public lq8 g;
    public PbListView h;
    public View i;
    public rq8 j;
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
    public w35 u;
    public boolean v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    @Override // com.baidu.tieba.vl5
    public boolean L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.vl5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vl5
    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
        }
    }

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
                    this.a.D().j5();
                    this.a.D().l5();
                }
                if (this.a.D() != null) {
                    this.a.D().W4(i);
                }
                if (i == 0) {
                    this.a.q2(true);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                this.a.k2();
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
    public class b implements v35.g {
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

        @Override // com.baidu.tieba.v35.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.L() != null && this.a.L().z2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.U1();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.L() != null && this.a.L().w1() != null && this.a.L().w1().H() != null) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                ac9 ac9Var = null;
                Iterator<bc9> it = this.a.L().w1().H().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    bc9 next = it.next();
                    if (next instanceof ac9) {
                        ac9 ac9Var2 = (ac9) next;
                        if (str.equals(ac9Var2.q1())) {
                            ac9Var = ac9Var2;
                            break;
                        }
                    }
                }
                if (ac9Var != null && this.a.f != null && this.a.d != null) {
                    this.a.L().w1().H().remove(ac9Var);
                    if (this.a.f.a() != null) {
                        this.a.f.a().remove(ac9Var);
                    }
                    if (this.a.d.getListView2().getData() != null) {
                        this.a.d.getListView2().getData().remove(ac9Var);
                    }
                    this.a.f.l();
                }
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.L() != null && (customResponsedMessage.getData() instanceof ki8)) {
                ki8 ki8Var = (ki8) customResponsedMessage.getData();
                if (StringHelper.equals(this.a.L().Q1(), ki8Var.S())) {
                    this.a.L().H0(ki8Var.Q());
                    this.a.L().H2(ki8Var, 3, "");
                    MessageManager.getInstance().unRegisterStickyMode(2921648);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.B && this.a.D() != null) {
                this.a.B = true;
                this.a.D().A3(this.a.d, false);
            }
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
                    this.a.w2();
                } else {
                    this.a.l();
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
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.mIsLogin) {
                return;
            }
            if (!this.a.z && this.a.S1() && this.a.L() != null) {
                StatisticItem statisticItem = new StatisticItem("c13999");
                statisticItem.param("tid", this.a.L().Q1());
                statisticItem.param("fid", this.a.L().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                this.a.z = true;
            }
            if (this.a.L().v2(false)) {
                this.a.u2();
                if (this.a.getPageContext() != null) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                }
            } else if (this.a.L().w1() != null) {
                this.a.o2();
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
                this.a.h1(true);
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

    public final void k2() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (bdTypeRecyclerView = this.d) != null && this.e != null && this.f != null) {
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
                v2(0);
            } else {
                v2(8);
            }
        }
    }

    public void p2(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048617, this, i2, i3) == null) && (bdTypeRecyclerView = this.d) != null && bdTypeRecyclerView.getLayoutManager() != null && (this.d.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.d.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
        }
    }

    public static DetailInfoAndReplyFragment j2(AbsVideoPbFragment absVideoPbFragment) {
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

    @Override // com.baidu.tieba.rq8.b
    public void h1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.p = z;
        }
    }

    public void l2(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048603, this, z) == null) && (bdTypeRecyclerView = this.d) != null) {
            bdTypeRecyclerView.setCanFling(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, context) == null) {
            super.onAttach(context);
            if (context instanceof AbsPbActivity) {
                this.a = (AbsPbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    public void r2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, str) == null) && (pbListView = this.h) != null) {
            pbListView.F(str);
        }
    }

    public void s2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, str) == null) && (pbListView = this.h) != null) {
            pbListView.K(str, this.y);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, view2) == null) {
            super.showLoadingView(view2);
        }
    }

    public void t2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.m = z;
        }
    }

    public void v2(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048625, this, i2) == null) && (view2 = this.k) != null) {
            view2.setVisibility(i2);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsVideoPbFragment D() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.b == null && (absPbActivity = this.a) != null) {
                Fragment F1 = absPbActivity.F1();
                if (F1 instanceof AbsVideoPbFragment) {
                    this.b = (AbsVideoPbFragment) F1;
                }
            }
            return this.b;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return D().L();
        }
        return (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsPbActivity M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null) {
                return absPbActivity;
            }
            return D().M();
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public void U1() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (bdSwipeRefreshLayout = this.t) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.t.setRefreshing(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: V1 */
    public aq8 E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.f;
        }
        return (aq8) invokeV.objValue;
    }

    public int W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                return bdTypeRecyclerView.getFirstVisiblePosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int X1() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.d.getChildAt(0)) == null) {
                return 0;
            }
            return childAt.getTop();
        }
        return invokeV.intValue;
    }

    public BdTypeRecyclerView Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.d;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public int a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.x;
        }
        return invokeV.intValue;
    }

    public View b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public int c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    public lq8 d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.g;
        }
        return (lq8) invokeV.objValue;
    }

    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (L() != null) {
                return L().Z0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && getView() != null) {
            ViewGroup viewGroup = (ViewGroup) getView();
            hideLoadingView(viewGroup);
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                viewGroup.getChildAt(i2).setVisibility(0);
            }
        }
    }

    public void m2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048605, this) != null) || this.d == null) {
        }
    }

    public void n2() {
        aq8 aq8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (aq8Var = this.f) != null) {
            aq8Var.m();
        }
    }

    public void o2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && this.o != 2) {
            this.d.setNextPage(this.h);
            this.o = 2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onPause();
            oo8.a();
            if (D() != null) {
                al8.a().j(M());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onResume();
            this.p = false;
            q2(false);
        }
    }

    public void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.h.C();
            this.h.T();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.TRUE));
        }
    }

    public void w2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && getView() != null) {
            ViewGroup viewGroup = (ViewGroup) getView();
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                viewGroup.getChildAt(i2).setVisibility(8);
            }
            showLoadingView(viewGroup);
        }
    }

    @Override // com.baidu.tieba.vl5
    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.canScrollVertically(-1) || e2()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void R1(boolean z, int i2, int i3, int i4, ki8 ki8Var, String str, int i5, boolean z2) {
        int size;
        int i6;
        int size2;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), ki8Var, str, Integer.valueOf(i5), Boolean.valueOf(z2)}) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(M()).get(VideoPbViewModel.class);
            if (z && L() != null && ki8Var != null) {
                if (!z2) {
                    if (this.C) {
                        L().D0();
                    } else {
                        this.C = true;
                    }
                }
                this.v = L().O1();
                boolean isEnabled = this.t.isEnabled();
                if (ki8Var.z().c() == 0 && this.v) {
                    this.t.setEnabled(false);
                } else if (!isEnabled) {
                    this.t.setEnabled(true);
                    this.t.o();
                }
                this.f.t(videoPbViewModel.m());
                this.f.u(this.v);
                this.f.s(ki8Var, z2);
                this.l = false;
                if (TbadkCoreApplication.isLogin()) {
                    this.d.setNextPage(this.h);
                    this.o = 2;
                    if (D() != null && D().N != null) {
                        this.b.N.W();
                    }
                } else {
                    this.l = true;
                    if (ki8Var.z().b() == 1) {
                        if (this.j == null) {
                            rq8 rq8Var = new rq8(this, this);
                            this.j = rq8Var;
                            rq8Var.a();
                            this.j.h();
                            if (this.f instanceof bq8) {
                                this.j.i(new i(this));
                            }
                        }
                        this.d.setNextPage(this.j);
                    } else {
                        this.d.setNextPage(this.h);
                    }
                    this.o = 3;
                }
                if (this.r != null) {
                    xi8 xi8Var = new xi8(xi8.i);
                    ThreadData Q = ki8Var.Q();
                    if (Q != null) {
                        Q.getReply_num();
                    }
                    L().O1();
                    xi8Var.d = i2();
                    xi8Var.c = ki8Var.g;
                    ki8Var.c();
                    xi8Var.e = ki8Var.l0();
                    xi8Var.g = ki8Var.f;
                    this.r.h(xi8Var);
                }
                ArrayList<bc9> H = ki8Var.H();
                if (ki8Var.z().b() != 0 && H != null && H.size() >= ki8Var.z().e()) {
                    if (L().f1()) {
                        if (this.n) {
                            T1();
                            if (ki8Var.z().b() != 0) {
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
                    if (ki8Var.z().b() == 0) {
                        this.h.F(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.h.F(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.h.m();
                    if (ki8Var.z().b() == 0 || H == null) {
                        o2();
                    }
                }
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                if (i3 != 6) {
                                    if (i3 == 8) {
                                        if (this.d.getData() == null && ki8Var.H() == null) {
                                            size2 = 0;
                                        } else {
                                            size2 = this.d.getData().size() - ki8Var.H().size();
                                        }
                                        BdTypeRecyclerView bdTypeRecyclerView = this.d;
                                        if (i4 > 0) {
                                            i7 = i4 + size2;
                                        } else {
                                            i7 = 0;
                                        }
                                        bdTypeRecyclerView.setSelection(i7);
                                        this.h.g();
                                        this.h.F(getString(R.string.obfuscated_res_0x7f0f0ec3));
                                        this.h.A();
                                    }
                                } else {
                                    if (i5 == 1) {
                                        Parcelable e2 = dm8.b().e();
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
                    } else if (i5 == 1) {
                        Parcelable e3 = dm8.b().e();
                        if (e3 instanceof RecyclerView.SavedState) {
                            this.d.onRestoreInstanceState(e3);
                            if (ListUtils.getCount(H) > 1 && ki8Var.z().b() > 0) {
                                this.h.g();
                                this.h.F(getString(R.string.obfuscated_res_0x7f0f0ec3));
                                this.h.A();
                            }
                        }
                    }
                } else {
                    if (this.d.getData() == null && ki8Var.H() == null) {
                        size = 0;
                    } else {
                        size = this.d.getData().size() - ki8Var.H().size();
                    }
                    BdTypeRecyclerView bdTypeRecyclerView2 = this.d;
                    if (i4 > 1) {
                        i6 = (i4 + size) - 2;
                    } else {
                        i6 = 0;
                    }
                    bdTypeRecyclerView2.setSelection(i6);
                }
                if (this.m) {
                    m2();
                    this.m = false;
                    if (i5 == 0) {
                        t2(true);
                    }
                }
                D().e5(ki8Var);
                if (this.h != null) {
                    if (ki8Var.z().b() == 0) {
                        this.h.N(8);
                    } else {
                        this.h.N(0);
                    }
                }
                if (cn8.a(Z1())) {
                    if (L().F2()) {
                        cn8.g(Z1(), L().W0());
                    } else if (videoPbViewModel.n()) {
                        videoPbViewModel.x(false);
                        if (L().G2()) {
                            cn8.h(Z1(), L().X0());
                            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.r;
                            if (pbReplyTitleViewHolder != null) {
                                pbReplyTitleViewHolder.s(0);
                            }
                        } else {
                            cn8.e(Z1());
                        }
                    } else if (!StringUtils.isNull(videoPbViewModel.g())) {
                        cn8.f(Z1(), videoPbViewModel.g());
                        videoPbViewModel.y(null);
                    }
                }
                if (this.a instanceof PbActivity) {
                    videoPbViewModel.v(false);
                    ((PbActivity) this.a).b2(ki8Var.g(), this.d);
                }
            }
        }
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            PbListView pbListView = this.h;
            if (pbListView != null && !TextUtils.isEmpty(pbListView.i())) {
                return this.h.i().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.A();
                this.h.g();
            }
            if (D() != null && D().N != null) {
                this.b.N.W();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.FALSE));
        }
    }

    public final boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (L() == null || L().u1() == null || L().u1().c() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
                if (L() != null && L().w1() != null && lastVisiblePosition >= L().w1().H().size()) {
                    return L().w1().H().size() - 2;
                }
                return lastVisiblePosition;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onDestroy();
            aq8 aq8Var = this.f;
            if (aq8Var != null) {
                aq8Var.n();
            }
            MessageManager.getInstance().unRegisterListener(this.F);
            MessageManager.getInstance().unRegisterListener(this.G);
            al8.a().d();
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.A);
            }
            if (getActivity() instanceof PbActivity) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921757));
            }
        }
    }

    public final void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0741, (ViewGroup) null));
            this.r = pbReplyTitleViewHolder;
            pbReplyTitleViewHolder.v = false;
            pbReplyTitleViewHolder.q(D().c4());
            this.r.p(D().I1);
            this.r.s(8);
            if (!this.b.I4()) {
                this.q.addView(this.r.j());
            }
            this.s = new PbChildTitleViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.pb_child_title, (ViewGroup) null));
            ji8 ji8Var = new ji8();
            ji8Var.f(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
            this.s.a(ji8Var);
            this.s.d(8);
            if (!this.b.I4()) {
                this.q.addView(this.s.b());
            }
        }
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.y = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            this.d = (BdTypeRecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f092764);
            e eVar = new e(this, getContext());
            this.e = eVar;
            this.d.setLayoutManager(eVar);
            if (this.b.I4()) {
                this.f = new bq8(this, this.d);
            } else {
                this.f = new dq8(this, this.d);
            }
            this.f.A(D().c4());
            this.f.v(D().d4());
            this.f.y(D().g4());
            this.f.x(this.g.j());
            this.f.E(this.g.m());
            this.k = this.c.findViewById(R.id.obfuscated_res_0x7f091da2);
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.h = pbListView;
            View findViewById = pbListView.c().findViewById(R.id.pb_more_view);
            this.i = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(D().c4());
                SkinManager.setBackgroundResource(this.i, R.drawable.pb_foot_more_trans_selector);
            }
            this.h.C();
            this.h.q(R.drawable.pb_foot_more_trans_selector);
            this.h.r(R.drawable.pb_foot_more_trans_selector);
            this.h.u();
            this.d.setOnSrollToBottomListener(this.H);
            this.d.addOnScrollListener(this.D);
            this.d.setOnTouchListener(D().h4());
            this.A = new f(this);
            this.d.getViewTreeObserver().addOnGlobalLayoutListener(this.A);
            if (this.u == null) {
                w35 w35Var = new w35(getPageContext());
                this.u = w35Var;
                w35Var.n();
                this.u.f(this.E);
            }
            if (this.t == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091a34);
                this.t = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.u);
                this.t.setEnabled(false);
                SkinManager.setBackgroundColor(this.t, R.color.CAM_X0205);
            }
            this.q = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f092767);
            f2();
            this.f.z(D().I1);
            registerListener(this.F);
            registerListener(this.G);
        }
    }

    public void h2() {
        ki8 w1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || (w1 = L().w1()) == null) {
            return;
        }
        this.f.u(L().O1());
        this.f.r(w1);
        this.f.l();
        ArrayList<bc9> H = w1.H();
        if (w1.z().b() == 0 || H == null || H.size() < w1.z().e()) {
            if (ListUtils.getCount(H) != 0 && (ListUtils.getCount(H) != 1 || H.get(0) == null || H.get(0).E() != 1)) {
                if (w1.z().b() == 0) {
                    this.h.F(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.h.F(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.h.m();
            } else if (i2()) {
                this.h.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ec9), this.y);
            } else {
                this.h.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0eca), this.y);
            }
        }
        D().e5(w1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(M()).get(VideoPbViewModel.class);
            videoPbViewModel.o().observe(this, new g(this));
            R1(true, 0, 3, 0, videoPbViewModel.c(), "", 1, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            super.onUserChanged(z);
            x2(z);
            if (D() != null && D().N != null) {
                this.b.N.I();
            }
            if (z && this.p) {
                u2();
                L().v2(true);
            }
        }
    }

    public void x2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048627, this, z) == null) && z && this.l) {
            this.h.F(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.d.setNextPage(this.h);
            this.o = 2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            super.onChangeSkinType(i2);
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.e(i2);
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
            aq8 aq8Var = this.f;
            if (aq8Var != null) {
                aq8Var.l();
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

    public final void q2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048618, this, z) == null) && D() != null && M() != null && M().K1() != null && this.f.e() != null) {
            al8.a().g(M().K1().l2(), this.f.e().x(), this.r.j(), M().getPageStayDurationItem(), z, null, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048612, this, layoutInflater, viewGroup, bundle)) == null) {
            this.g = new lq8(this);
            this.c = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0716, (ViewGroup) null);
            g2();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.vp8
    public void s1(boolean z, int i2, int i3, int i4, ki8 ki8Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), ki8Var, str, Integer.valueOf(i5)}) == null) && getActivity() != null) {
            R1(z, i2, i3, i4, ki8Var, str, i5, false);
        }
    }

    public void y2(boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            aq8 aq8Var = this.f;
            if (aq8Var != null) {
                aq8Var.w(z);
                this.f.l();
            }
            if (z && D() != null) {
                oo8.d(getPageContext(), L(), this, D().getView());
            }
            ki8 w1 = L().w1();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            if (w1 != null) {
                str = w1.m();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }
}
