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
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.an9;
import com.baidu.tieba.bq9;
import com.baidu.tieba.cq9;
import com.baidu.tieba.dt5;
import com.baidu.tieba.gq9;
import com.baidu.tieba.jq9;
import com.baidu.tieba.ni9;
import com.baidu.tieba.nn;
import com.baidu.tieba.p95;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.po9;
import com.baidu.tieba.q95;
import com.baidu.tieba.uk9;
import com.baidu.tieba.yfa;
import com.baidu.tieba.yh9;
import com.baidu.tieba.yl9;
import com.baidu.tieba.zfa;
import com.baidu.tieba.zp9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements zp9, jq9.b, dt5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final p95.g A;
    public CustomMessageListener B;
    public final CustomMessageListener C;
    public final BdListView.p D;
    public AbsPbActivity a;
    public AbsVideoPbFragment b;
    public View c;
    public BdTypeRecyclerView d;
    public nn e;
    public LinearLayoutManager f;
    public bq9 g;
    public gq9 h;
    public PbListView i;
    public View j;
    public jq9 k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public boolean p;
    public PbReplyTitleViewHolder q;
    public BdSwipeRefreshLayout r;
    public q95 s;
    public boolean t;
    public int u;
    public boolean v;
    public ViewTreeObserver.OnGlobalLayoutListener w;
    public boolean x;
    public boolean y;
    public RecyclerView.OnScrollListener z;

    @Override // com.baidu.tieba.dt5
    public boolean Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.dt5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dt5
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
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
                    this.a.Q().w4();
                    this.a.Q().x4();
                }
                if (this.a.Q() != null) {
                    this.a.Q().o4(i);
                }
                if (i == 0) {
                    this.a.C2(true);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                this.a.x2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements p95.g {
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

        @Override // com.baidu.tieba.p95.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.W() != null && this.a.W().r2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.j2();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.W() != null && this.a.W().s1() != null && this.a.W().s1().F() != null) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                yfa yfaVar = null;
                Iterator<zfa> it = this.a.W().s1().F().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    zfa next = it.next();
                    if (next instanceof yfa) {
                        yfa yfaVar2 = (yfa) next;
                        if (str.equals(yfaVar2.A1())) {
                            yfaVar = yfaVar2;
                            break;
                        }
                    }
                }
                if (yfaVar != null && this.a.g != null && this.a.d != null) {
                    this.a.W().s1().F().remove(yfaVar);
                    if (this.a.g.a() != null) {
                        this.a.g.a().remove(yfaVar);
                    }
                    if (this.a.d.getListView2().getData() != null) {
                        this.a.d.getListView2().getData().remove(yfaVar);
                    }
                    this.a.f2();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        public d(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g != null) {
                this.a.g.m();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(DetailInfoAndReplyFragment detailInfoAndReplyFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.W() != null && (customResponsedMessage.getData() instanceof yh9)) {
                yh9 yh9Var = (yh9) customResponsedMessage.getData();
                if (StringHelper.equals(this.a.W().M1(), yh9Var.Q())) {
                    this.a.W().D0(yh9Var.O());
                    this.a.W().y2(yh9Var, 3, "");
                    MessageManager.getInstance().unRegisterStickyMode(2921648);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends LinearLayoutManager {
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
        public f(DetailInfoAndReplyFragment detailInfoAndReplyFragment, Context context) {
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
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
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

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.x && this.a.Q() != null) {
                this.a.x = true;
                this.a.Q().i3(this.a.d, false);
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if (!this.a.v && this.a.h2() && this.a.W() != null) {
                StatisticItem statisticItem = new StatisticItem("c13999");
                statisticItem.param("tid", this.a.W().M1());
                statisticItem.param("fid", this.a.W().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                this.a.v = true;
            }
            if (this.a.W().p2(false)) {
                this.a.G2();
                if (this.a.getPageContext() != null) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                }
            } else if (this.a.W().s1() != null) {
                this.a.A2();
            }
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.x1(true);
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
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = 0;
        this.s = null;
        this.t = false;
        this.v = false;
        this.z = new a(this);
        this.A = new b(this);
        this.B = new c(this, 2016331);
        this.C = new e(this, 2921648);
        this.D = new h(this);
    }

    public int n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
                if (W() != null && W().s1() != null && lastVisiblePosition >= W().s1().F().size()) {
                    return W().s1().F().size() - 2;
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
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onDestroy();
            bq9 bq9Var = this.g;
            if (bq9Var != null) {
                bq9Var.o();
            }
            MessageManager.getInstance().unRegisterListener(this.B);
            MessageManager.getInstance().unRegisterListener(this.C);
            uk9.a().d();
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.w);
            }
            if (getActivity() instanceof PbActivity) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921757));
            }
        }
    }

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07b7, (ViewGroup) null));
            this.q = pbReplyTitleViewHolder;
            pbReplyTitleViewHolder.v = false;
            pbReplyTitleViewHolder.s(Q().H3());
            this.q.r(Q().U0);
            this.q.u(8);
        }
    }

    public final void x2() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (bdTypeRecyclerView = this.d) != null && this.f != null && this.g != null) {
            int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount() + this.g.e();
            int headerViewsCount2 = this.d.getHeaderViewsCount() + this.g.d();
            int findFirstVisibleItemPosition = this.f.findFirstVisibleItemPosition();
            if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
                this.q.u(0);
            } else {
                this.q.u(8);
            }
            if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
                this.q.u(8);
            }
        }
    }

    public void B2(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) && (bdTypeRecyclerView = this.d) != null && bdTypeRecyclerView.getLayoutManager() != null && (this.d.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.d.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
        }
    }

    public static DetailInfoAndReplyFragment w2(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
            detailInfoAndReplyFragment.setArguments(bundle);
            detailInfoAndReplyFragment.b = absVideoPbFragment;
            return detailInfoAndReplyFragment;
        }
        return (DetailInfoAndReplyFragment) invokeL.objValue;
    }

    public void D2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (pbListView = this.i) != null) {
            pbListView.H(str);
        }
    }

    public void E2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && (pbListView = this.i) != null) {
            pbListView.M(str, this.u);
        }
    }

    public void F2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.m = z;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        yh9 s1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            super.onActivityCreated(bundle);
            PbModel W = W();
            if (W != null && (s1 = W.s1()) != null) {
                g2(true, 0, 3, 0, s1, "", 1, true);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, context) == null) {
            super.onAttach(context);
            if (context instanceof AbsPbActivity) {
                this.a = (AbsPbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view2) == null) {
            super.showLoadingView(view2);
        }
    }

    @Override // com.baidu.tieba.jq9.b
    public void x1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.p = z;
        }
    }

    public void A2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.o != 2) {
            this.d.setNextPage(this.i);
            this.o = 2;
        }
    }

    @Override // com.baidu.tieba.dt5
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.canScrollVertically(-1) || r2()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.i.D();
            this.i.U();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.TRUE));
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsVideoPbFragment Q() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.b == null && (absPbActivity = this.a) != null) {
                Fragment D1 = absPbActivity.D1();
                if (D1 instanceof AbsVideoPbFragment) {
                    this.b = (AbsVideoPbFragment) D1;
                }
            }
            return this.b;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return Q().W();
        }
        return (PbModel) invokeV.objValue;
    }

    public AbsPbActivity d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null) {
                return absPbActivity;
            }
            return Q().d0();
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public final void f2() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || (bdTypeRecyclerView = this.d) == null) {
            return;
        }
        if (this.e == null) {
            this.e = new nn(bdTypeRecyclerView);
        }
        this.e.e(new d(this));
    }

    public void j2() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (bdSwipeRefreshLayout = this.r) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.r.setRefreshing(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: k2 */
    public bq9 U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.g;
        }
        return (bq9) invokeV.objValue;
    }

    public int l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                return bdTypeRecyclerView.getFirstVisiblePosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int m2() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.d.getChildAt(0)) == null) {
                return 0;
            }
            return childAt.getTop();
        }
        return invokeV.intValue;
    }

    public BdTypeRecyclerView o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.d;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onPause();
            po9.a();
            if (Q() != null) {
                uk9.a().i(d0());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onResume();
            this.p = false;
            C2(false);
        }
    }

    public View p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.j;
        }
        return (View) invokeV.objValue;
    }

    public gq9 q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.h;
        }
        return (gq9) invokeV.objValue;
    }

    public boolean v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (W() != null) {
                return W().V0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void y2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048623, this) != null) || this.d == null) {
        }
    }

    public void z2() {
        bq9 bq9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && (bq9Var = this.g) != null) {
            bq9Var.n();
        }
    }

    public final void C2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && Q() != null && d0() != null && d0().I1() != null && this.g.f() != null) {
            uk9.a().f(d0().I1().g2(), this.g.f().x(), this.q.l(), d0().getPageStayDurationItem(), z, null, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            super.onChangeSkinType(i2);
            PbListView pbListView = this.i;
            if (pbListView != null) {
                pbListView.e(i2);
                if (this.j != null) {
                    getBaseFragmentActivity().getLayoutMode().onModeChanged(this.j);
                    SkinManager.setBackgroundResource(this.j, R.drawable.pb_foot_more_trans_selector);
                }
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.q;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.n(i2);
            }
            f2();
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0201);
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setBackgroundResource(0);
            }
        }
    }

    public void H2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && z && this.l) {
            this.i.H(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.d.setNextPage(this.i);
            this.o = 2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            super.onUserChanged(z);
            H2(z);
            if (Q() != null && Q().o != null) {
                this.b.o.I();
            }
            if (z && this.p) {
                G2();
                W().p2(true);
            }
        }
    }

    public void I2(boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            bq9 bq9Var = this.g;
            if (bq9Var != null) {
                bq9Var.w(z);
                f2();
            }
            if (z && Q() != null) {
                po9.d(getPageContext(), W(), this, Q().getView());
            }
            yh9 s1 = W().s1();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            if (s1 != null) {
                str = s1.l();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    @Override // com.baidu.tieba.zp9
    public void J1(boolean z, int i2, int i3, int i4, yh9 yh9Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), yh9Var, str, Integer.valueOf(i5)}) == null) && getActivity() != null) {
            g2(z, i2, i3, i4, yh9Var, str, i5, false);
        }
    }

    public final void g2(boolean z, int i2, int i3, int i4, yh9 yh9Var, String str, int i5, boolean z2) {
        int size;
        int i6;
        int size2;
        int i7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), yh9Var, str, Integer.valueOf(i5), Boolean.valueOf(z2)}) == null) && z && W() != null && yh9Var != null) {
            if (!z2) {
                if (this.y) {
                    W().z0();
                } else {
                    this.y = true;
                }
            }
            this.t = W().L1();
            boolean isEnabled = this.r.isEnabled();
            if (yh9Var.y().c() == 0 && this.t) {
                this.r.setEnabled(false);
            } else if (!isEnabled) {
                this.r.setEnabled(true);
                this.r.o();
            }
            this.g.u(this.t);
            this.g.t(yh9Var, z2);
            this.l = false;
            if (TbadkCoreApplication.isLogin()) {
                this.d.setNextPage(this.i);
                this.o = 2;
                if (Q() != null && Q().o != null) {
                    this.b.o.W();
                }
            } else {
                this.l = true;
                if (yh9Var.y().b() == 1) {
                    if (this.k == null) {
                        jq9 jq9Var = new jq9(this, this);
                        this.k = jq9Var;
                        jq9Var.a();
                        this.k.h();
                        if (this.g instanceof cq9) {
                            this.k.i(new i(this));
                        }
                    }
                    this.d.setNextPage(this.k);
                } else {
                    this.d.setNextPage(this.i);
                }
                this.o = 3;
            }
            if (this.q != null) {
                ni9 ni9Var = new ni9(ni9.g);
                ni9Var.c = v2();
                ni9Var.b = yh9Var.g;
                ni9Var.d = yh9Var.j0();
                ni9Var.e = yh9Var.f;
                this.q.j(ni9Var);
            }
            ArrayList<zfa> F = yh9Var.F();
            if (yh9Var.y().b() != 0 && F != null && F.size() >= yh9Var.y().e()) {
                if (W().b1()) {
                    if (this.n) {
                        i2();
                        if (yh9Var.y().b() != 0) {
                            this.i.H(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.i.D();
                        this.i.R();
                    }
                } else {
                    this.i.D();
                    this.i.R();
                }
                this.i.n();
            } else {
                if (yh9Var.y().b() == 0) {
                    this.i.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.i.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.i.n();
                if (yh9Var.y().b() == 0 || F == null) {
                    A2();
                }
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                if (i3 == 8) {
                                    if (this.d.getData() == null && yh9Var.F() == null) {
                                        size2 = 0;
                                    } else {
                                        size2 = this.d.getData().size() - yh9Var.F().size();
                                    }
                                    BdTypeRecyclerView bdTypeRecyclerView = this.d;
                                    if (i4 > 0) {
                                        i7 = i4 + size2;
                                    } else {
                                        i7 = 0;
                                    }
                                    bdTypeRecyclerView.setSelection(i7);
                                    this.i.g();
                                    this.i.H(getString(R.string.obfuscated_res_0x7f0f0fe8));
                                    this.i.B();
                                }
                            } else {
                                if (i5 == 1) {
                                    Parcelable e2 = yl9.b().e();
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
                    Parcelable e3 = yl9.b().e();
                    if (e3 instanceof RecyclerView.SavedState) {
                        this.d.onRestoreInstanceState(e3);
                        if (ListUtils.getCount(F) > 1 && yh9Var.y().b() > 0) {
                            this.i.g();
                            this.i.H(getString(R.string.obfuscated_res_0x7f0f0fe8));
                            this.i.B();
                        }
                    }
                }
            } else {
                if (this.d.getData() == null && yh9Var.F() == null) {
                    size = 0;
                } else {
                    size = this.d.getData().size() - yh9Var.F().size();
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
                y2();
                this.m = false;
                if (i5 == 0) {
                    F2(true);
                }
            }
            Q().t4(yh9Var);
            if (this.i != null) {
                if (yh9Var.y().b() == 0) {
                    this.i.O(8);
                } else {
                    this.i.O(0);
                }
            }
            if (an9.a(o2())) {
                if (W().x2()) {
                    an9.c(o2(), W().S0());
                }
                AbsPbActivity absPbActivity = this.a;
                if (absPbActivity instanceof PbActivity) {
                    ((PbActivity) absPbActivity).d2(yh9Var.f(), this.d);
                }
            }
        }
    }

    public boolean h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            PbListView pbListView = this.i;
            if (pbListView != null && !TextUtils.isEmpty(pbListView.j())) {
                return this.i.j().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            PbListView pbListView = this.i;
            if (pbListView != null) {
                pbListView.B();
                this.i.g();
            }
            if (Q() != null && Q().o != null) {
                this.b.o.W();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.FALSE));
        }
    }

    public final boolean r2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (W() == null || W().q1() == null || W().q1().c() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048607, this, layoutInflater, viewGroup, bundle)) == null) {
            this.h = new gq9(this);
            this.c = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d078d, (ViewGroup) null);
            t2();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    public final void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.u = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f09290d);
            this.d = bdTypeRecyclerView;
            this.e = new nn(bdTypeRecyclerView);
            f fVar = new f(this, getContext());
            this.f = fVar;
            this.d.setLayoutManager(fVar);
            cq9 cq9Var = new cq9(this, this.d);
            this.g = cq9Var;
            cq9Var.A(Q().H3());
            this.g.v(Q().I3());
            this.g.y(Q().L3());
            this.g.x(this.h.j());
            this.g.E(this.h.m());
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.i = pbListView;
            View findViewById = pbListView.c().findViewById(R.id.pb_more_view);
            this.j = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(Q().H3());
                SkinManager.setBackgroundResource(this.j, R.drawable.pb_foot_more_trans_selector);
            }
            this.i.D();
            this.i.r(R.drawable.pb_foot_more_trans_selector);
            this.i.s(R.drawable.pb_foot_more_trans_selector);
            this.i.v();
            this.d.setOnSrollToBottomListener(this.D);
            this.d.addOnScrollListener(this.z);
            this.d.setOnTouchListener(Q().M3());
            this.w = new g(this);
            this.d.getViewTreeObserver().addOnGlobalLayoutListener(this.w);
            if (this.s == null) {
                q95 q95Var = new q95(getPageContext());
                this.s = q95Var;
                q95Var.i();
                this.s.a(this.A);
            }
            if (this.r == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091b63);
                this.r = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.s);
                this.r.setEnabled(false);
                SkinManager.setBackgroundColor(this.r, R.color.CAM_X0205);
            }
            s2();
            this.g.z(Q().U0);
            registerListener(this.B);
            registerListener(this.C);
        }
    }

    public void u2() {
        yh9 s1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048619, this) != null) || (s1 = W().s1()) == null) {
            return;
        }
        this.g.u(W().L1());
        this.g.s(s1);
        f2();
        ArrayList<zfa> F = s1.F();
        if (s1.y().b() == 0 || F == null || F.size() < s1.y().e()) {
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).I() != 1)) {
                if (s1.y().b() == 0) {
                    this.i.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.i.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.i.n();
            } else if (v2()) {
                this.i.M(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fee), this.u);
            } else {
                this.i.M(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fef), this.u);
            }
        }
        Q().t4(s1);
    }
}
