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
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
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
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.c49;
import com.baidu.tieba.eb9;
import com.baidu.tieba.gb9;
import com.baidu.tieba.h69;
import com.baidu.tieba.hb9;
import com.baidu.tieba.it5;
import com.baidu.tieba.iy9;
import com.baidu.tieba.jy9;
import com.baidu.tieba.l79;
import com.baidu.tieba.lb9;
import com.baidu.tieba.m39;
import com.baidu.tieba.o89;
import com.baidu.tieba.ob9;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.vi;
import com.baidu.tieba.w95;
import com.baidu.tieba.x95;
import com.baidu.tieba.z99;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements eb9, ob9.b, it5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public final CustomMessageListener B;
    public final BdListView.p C;
    public AbsPbActivity a;
    public AbsVideoPbFragment b;
    public View c;
    public BdTypeRecyclerView d;
    public LinearLayoutManager e;
    public gb9 f;
    public lb9 g;
    public PbListView h;
    public View i;
    public ob9 j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public boolean o;
    public PbReplyTitleViewHolder p;
    public BdSwipeRefreshLayout q;
    public x95 r;
    public boolean s;
    public int t;
    public boolean u;
    public ViewTreeObserver.OnGlobalLayoutListener v;
    public boolean w;
    public boolean x;
    public RecyclerView.OnScrollListener y;
    public final w95.g z;

    @Override // com.baidu.tieba.it5
    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.it5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.it5
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
        }
    }

    /* loaded from: classes7.dex */
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
                    this.a.N().j4();
                    this.a.N().k4();
                }
                if (this.a.N() != null) {
                    this.a.N().a4(i);
                }
                if (i == 0) {
                    this.a.n2(true);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                this.a.i2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements w95.g {
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

        @Override // com.baidu.tieba.w95.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.Q() != null && this.a.Q().w2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.U1();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.Q() != null && this.a.Q().y1() != null && this.a.Q().y1().F() != null) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                iy9 iy9Var = null;
                Iterator<jy9> it = this.a.Q().y1().F().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    jy9 next = it.next();
                    if (next instanceof iy9) {
                        iy9 iy9Var2 = (iy9) next;
                        if (str.equals(iy9Var2.t1())) {
                            iy9Var = iy9Var2;
                            break;
                        }
                    }
                }
                if (iy9Var != null && this.a.f != null && this.a.d != null) {
                    this.a.Q().y1().F().remove(iy9Var);
                    if (this.a.f.a() != null) {
                        this.a.f.a().remove(iy9Var);
                    }
                    if (this.a.d.getListView2().getData() != null) {
                        this.a.d.getListView2().getData().remove(iy9Var);
                    }
                    this.a.f.l();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.Q() != null && (customResponsedMessage.getData() instanceof m39)) {
                m39 m39Var = (m39) customResponsedMessage.getData();
                if (StringHelper.equals(this.a.Q().R1(), m39Var.P())) {
                    this.a.Q().K0(m39Var.N());
                    this.a.Q().D2(m39Var, 3, "");
                    MessageManager.getInstance().unRegisterStickyMode(2921648);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.w && this.a.N() != null) {
                this.a.w = true;
                this.a.N().U2(this.a.d, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements BdListView.p {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.mIsLogin) {
                return;
            }
            if (!this.a.u && this.a.S1() && this.a.Q() != null) {
                StatisticItem statisticItem = new StatisticItem("c13999");
                statisticItem.param("tid", this.a.Q().R1());
                statisticItem.param("fid", this.a.Q().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                this.a.u = true;
            }
            if (this.a.Q().u2(false)) {
                this.a.r2();
                if (this.a.getPageContext() != null) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                }
            } else if (this.a.Q().y1() != null) {
                this.a.l2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ViewHelper.skipToLoginActivity(this.a.getContext());
                this.a.l1(true);
                this.a.getPageContext().getPageActivity().finish();
            }
        }
    }

    public DetailInfoAndReplyFragment() {
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
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = 0;
        this.r = null;
        this.s = false;
        this.u = false;
        this.y = new a(this);
        this.z = new b(this);
        this.A = new c(this, 2016331);
        this.B = new d(this, 2921648);
        this.C = new g(this);
    }

    public int Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
                if (Q() != null && Q().y1() != null && lastVisiblePosition >= Q().y1().F().size()) {
                    return Q().y1().F().size() - 2;
                }
                return lastVisiblePosition;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0780, (ViewGroup) null));
            this.p = pbReplyTitleViewHolder;
            pbReplyTitleViewHolder.v = false;
            pbReplyTitleViewHolder.r(N().t3());
            this.p.q(N().U0);
            this.p.t(8);
        }
    }

    public final void i2() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (bdTypeRecyclerView = this.d) != null && this.e != null && this.f != null) {
            int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount() + this.f.d();
            int headerViewsCount2 = this.d.getHeaderViewsCount() + this.f.c();
            int findFirstVisibleItemPosition = this.e.findFirstVisibleItemPosition();
            if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
                this.p.t(0);
            } else {
                this.p.t(8);
            }
            if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
                this.p.t(8);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onDestroy();
            gb9 gb9Var = this.f;
            if (gb9Var != null) {
                gb9Var.n();
            }
            MessageManager.getInstance().unRegisterListener(this.A);
            MessageManager.getInstance().unRegisterListener(this.B);
            h69.a().d();
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.v);
            }
            if (getActivity() instanceof PbActivity) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921757));
            }
        }
    }

    public void m2(int i, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048603, this, i, i2) == null) && (bdTypeRecyclerView = this.d) != null && bdTypeRecyclerView.getLayoutManager() != null && (this.d.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.d.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    public static DetailInfoAndReplyFragment h2(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
            detailInfoAndReplyFragment.setArguments(bundle);
            detailInfoAndReplyFragment.b = absVideoPbFragment;
            return detailInfoAndReplyFragment;
        }
        return (DetailInfoAndReplyFragment) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ob9.b
    public void l1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.o = z;
        }
    }

    public void o2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, str) == null) && (pbListView = this.h) != null) {
            pbListView.H(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        m39 y1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bundle) == null) {
            super.onActivityCreated(bundle);
            PbModel Q = Q();
            if (Q != null && (y1 = Q.y1()) != null) {
                R1(true, 0, 3, 0, y1, "", 1, true);
            }
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    public void p2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048615, this, str) == null) && (pbListView = this.h) != null) {
            pbListView.M(str, this.t);
        }
    }

    public void q2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.l = z;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, view2) == null) {
            super.showLoadingView(view2);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsVideoPbFragment N() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.b == null && (absPbActivity = this.a) != null) {
                Fragment E1 = absPbActivity.E1();
                if (E1 instanceof AbsVideoPbFragment) {
                    this.b = (AbsVideoPbFragment) E1;
                }
            }
            return this.b;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return N().Q();
        }
        return (PbModel) invokeV.objValue;
    }

    public void U1() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (bdSwipeRefreshLayout = this.q) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.q.setRefreshing(false);
        }
    }

    public AbsPbActivity V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null) {
                return absPbActivity;
            }
            return N().V();
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: V1 */
    public gb9 H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.f;
        }
        return (gb9) invokeV.objValue;
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

    public View a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public lb9 b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.g;
        }
        return (lb9) invokeV.objValue;
    }

    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (Q() != null) {
                return Q().b1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || this.d == null) {
        }
    }

    public void k2() {
        gb9 gb9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (gb9Var = this.f) != null) {
            gb9Var.m();
        }
    }

    public void l2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.n != 2) {
            this.d.setNextPage(this.h);
            this.n = 2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onPause();
            z99.a();
            if (N() != null) {
                h69.a().i(V());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onResume();
            this.o = false;
            n2(false);
        }
    }

    public void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.h.D();
            this.h.U();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.TRUE));
        }
    }

    @Override // com.baidu.tieba.it5
    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.canScrollVertically(-1) || c2()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void R1(boolean z, int i, int i2, int i3, m39 m39Var, String str, int i4, boolean z2) {
        int size;
        int i5;
        int size2;
        int i6;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), m39Var, str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) && z && Q() != null && m39Var != null) {
            if (!z2) {
                if (this.x) {
                    Q().G0();
                } else {
                    this.x = true;
                }
            }
            this.s = Q().Q1();
            boolean isEnabled = this.q.isEnabled();
            if (m39Var.y().c() == 0 && this.s) {
                this.q.setEnabled(false);
            } else if (!isEnabled) {
                this.q.setEnabled(true);
                this.q.o();
            }
            this.f.t(this.s);
            this.f.s(m39Var, z2);
            this.k = false;
            if (TbadkCoreApplication.isLogin()) {
                this.d.setNextPage(this.h);
                this.n = 2;
                if (N() != null && N().o != null) {
                    this.b.o.W();
                }
            } else {
                this.k = true;
                if (m39Var.y().b() == 1) {
                    if (this.j == null) {
                        ob9 ob9Var = new ob9(this, this);
                        this.j = ob9Var;
                        ob9Var.a();
                        this.j.h();
                        if (this.f instanceof hb9) {
                            this.j.i(new h(this));
                        }
                    }
                    this.d.setNextPage(this.j);
                } else {
                    this.d.setNextPage(this.h);
                }
                this.n = 3;
            }
            if (this.p != null) {
                c49 c49Var = new c49(c49.g);
                c49Var.c = g2();
                c49Var.b = m39Var.g;
                c49Var.d = m39Var.i0();
                c49Var.e = m39Var.f;
                this.p.i(c49Var);
            }
            ArrayList<jy9> F = m39Var.F();
            if (m39Var.y().b() != 0 && F != null && F.size() >= m39Var.y().e()) {
                if (Q().h1()) {
                    if (this.m) {
                        T1();
                        if (m39Var.y().b() != 0) {
                            this.h.H(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.h.D();
                        this.h.R();
                    }
                } else {
                    this.h.D();
                    this.h.R();
                }
                this.h.n();
            } else {
                if (m39Var.y().b() == 0) {
                    this.h.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.h.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.h.n();
                if (m39Var.y().b() == 0 || F == null) {
                    l2();
                }
            }
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            if (i2 != 6) {
                                if (i2 == 8) {
                                    if (this.d.getData() == null && m39Var.F() == null) {
                                        size2 = 0;
                                    } else {
                                        size2 = this.d.getData().size() - m39Var.F().size();
                                    }
                                    BdTypeRecyclerView bdTypeRecyclerView = this.d;
                                    if (i3 > 0) {
                                        i6 = i3 + size2;
                                    } else {
                                        i6 = 0;
                                    }
                                    bdTypeRecyclerView.setSelection(i6);
                                    this.h.g();
                                    this.h.H(getString(R.string.obfuscated_res_0x7f0f0fa9));
                                    this.h.B();
                                }
                            } else {
                                if (i4 == 1) {
                                    Parcelable e2 = l79.b().e();
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
                        this.m = false;
                    }
                } else if (i4 == 1) {
                    Parcelable e3 = l79.b().e();
                    if (e3 instanceof RecyclerView.SavedState) {
                        this.d.onRestoreInstanceState(e3);
                        if (ListUtils.getCount(F) > 1 && m39Var.y().b() > 0) {
                            this.h.g();
                            this.h.H(getString(R.string.obfuscated_res_0x7f0f0fa9));
                            this.h.B();
                        }
                    }
                }
            } else {
                if (this.d.getData() == null && m39Var.F() == null) {
                    size = 0;
                } else {
                    size = this.d.getData().size() - m39Var.F().size();
                }
                BdTypeRecyclerView bdTypeRecyclerView2 = this.d;
                if (i3 > 1) {
                    i5 = (i3 + size) - 2;
                } else {
                    i5 = 0;
                }
                bdTypeRecyclerView2.setSelection(i5);
            }
            if (this.l) {
                j2();
                this.l = false;
                if (i4 == 0) {
                    q2(true);
                }
            }
            N().f4(m39Var);
            if (this.h != null) {
                if (m39Var.y().b() == 0) {
                    this.h.O(8);
                } else {
                    this.h.O(0);
                }
            }
            if (o89.a(Z1())) {
                if (Q().C2()) {
                    o89.c(Z1(), Q().Y0());
                }
                AbsPbActivity absPbActivity = this.a;
                if (absPbActivity instanceof PbActivity) {
                    ((PbActivity) absPbActivity).d2(m39Var.f(), this.d);
                }
            }
        }
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            PbListView pbListView = this.h;
            if (pbListView != null && !TextUtils.isEmpty(pbListView.j())) {
                return this.h.j().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.B();
                this.h.g();
            }
            if (N() != null && N().o != null) {
                this.b.o.W();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.FALSE));
        }
    }

    public final boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (Q() == null || Q().w1() == null || Q().w1().c() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.t = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            this.d = (BdTypeRecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f092817);
            e eVar = new e(this, getContext());
            this.e = eVar;
            this.d.setLayoutManager(eVar);
            hb9 hb9Var = new hb9(this, this.d);
            this.f = hb9Var;
            hb9Var.z(N().t3());
            this.f.u(N().u3());
            this.f.x(N().x3());
            this.f.w(this.g.j());
            this.f.D(this.g.m());
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.h = pbListView;
            View findViewById = pbListView.c().findViewById(R.id.pb_more_view);
            this.i = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(N().t3());
                SkinManager.setBackgroundResource(this.i, R.drawable.pb_foot_more_trans_selector);
            }
            this.h.D();
            this.h.r(R.drawable.pb_foot_more_trans_selector);
            this.h.s(R.drawable.pb_foot_more_trans_selector);
            this.h.v();
            this.d.setOnSrollToBottomListener(this.C);
            this.d.addOnScrollListener(this.y);
            this.d.setOnTouchListener(N().y3());
            this.v = new f(this);
            this.d.getViewTreeObserver().addOnGlobalLayoutListener(this.v);
            if (this.r == null) {
                x95 x95Var = new x95(getPageContext());
                this.r = x95Var;
                x95Var.n();
                this.r.f(this.z);
            }
            if (this.q == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091aac);
                this.q = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.r);
                this.q.setEnabled(false);
                SkinManager.setBackgroundColor(this.q, R.color.CAM_X0205);
            }
            d2();
            this.f.y(N().U0);
            registerListener(this.A);
            registerListener(this.B);
        }
    }

    public void f2() {
        m39 y1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || (y1 = Q().y1()) == null) {
            return;
        }
        this.f.t(Q().Q1());
        this.f.r(y1);
        this.f.l();
        ArrayList<jy9> F = y1.F();
        if (y1.y().b() == 0 || F == null || F.size() < y1.y().e()) {
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).D() != 1)) {
                if (y1.y().b() == 0) {
                    this.h.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.h.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.h.n();
            } else if (g2()) {
                this.h.M(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0faf), this.t);
            } else {
                this.h.M(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fb0), this.t);
            }
        }
        N().f4(y1);
    }

    public final void n2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048604, this, z) == null) && N() != null && V() != null && V().K1() != null && this.f.e() != null) {
            h69.a().f(V().K1().l2(), this.f.e().x(), this.p.k(), V().getPageStayDurationItem(), z, null, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            super.onChangeSkinType(i);
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.e(i);
                if (this.i != null) {
                    getBaseFragmentActivity().getLayoutMode().k(this.i);
                    SkinManager.setBackgroundResource(this.i, R.drawable.pb_foot_more_trans_selector);
                }
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.p;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.m(i);
            }
            gb9 gb9Var = this.f;
            if (gb9Var != null) {
                gb9Var.l();
            }
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0201);
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setBackgroundResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048610, this, layoutInflater, viewGroup, bundle)) == null) {
            this.g = new lb9(this);
            this.c = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0757, (ViewGroup) null);
            e2();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            super.onUserChanged(z);
            s2(z);
            if (N() != null && N().o != null) {
                this.b.o.I();
            }
            if (z && this.o) {
                r2();
                Q().u2(true);
            }
        }
    }

    public void s2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048619, this, z) == null) && z && this.k) {
            this.h.H(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.d.setNextPage(this.h);
            this.n = 2;
        }
    }

    public void t2(boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            gb9 gb9Var = this.f;
            if (gb9Var != null) {
                gb9Var.v(z);
                this.f.l();
            }
            if (z && N() != null) {
                z99.d(getPageContext(), Q(), this, N().getView());
            }
            m39 y1 = Q().y1();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            if (y1 != null) {
                str = y1.l();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    @Override // com.baidu.tieba.eb9
    public void w1(boolean z, int i, int i2, int i3, m39 m39Var, String str, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), m39Var, str, Integer.valueOf(i4)}) == null) && getActivity() != null) {
            R1(z, i, i2, i3, m39Var, str, i4, false);
        }
    }
}
