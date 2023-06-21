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
import com.baidu.tieba.a0a;
import com.baidu.tieba.b0a;
import com.baidu.tieba.f79;
import com.baidu.tieba.h89;
import com.baidu.tieba.ic9;
import com.baidu.tieba.io;
import com.baidu.tieba.j49;
import com.baidu.tieba.k99;
import com.baidu.tieba.kc9;
import com.baidu.tieba.lc9;
import com.baidu.tieba.nt5;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pc9;
import com.baidu.tieba.sc9;
import com.baidu.tieba.wi;
import com.baidu.tieba.x95;
import com.baidu.tieba.y49;
import com.baidu.tieba.y95;
import com.baidu.tieba.ya9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements ic9, sc9.b, nt5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final x95.g A;
    public CustomMessageListener B;
    public final CustomMessageListener C;
    public final BdListView.p D;
    public AbsPbActivity a;
    public AbsVideoPbFragment b;
    public View c;
    public BdTypeRecyclerView d;
    public io e;
    public LinearLayoutManager f;
    public kc9 g;
    public pc9 h;
    public PbListView i;
    public View j;
    public sc9 k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public boolean p;
    public PbReplyTitleViewHolder q;
    public BdSwipeRefreshLayout r;
    public y95 s;
    public boolean t;
    public int u;
    public boolean v;
    public ViewTreeObserver.OnGlobalLayoutListener w;
    public boolean x;
    public boolean y;
    public RecyclerView.OnScrollListener z;

    @Override // com.baidu.tieba.nt5
    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.nt5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nt5
    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
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
                    this.a.N().k4();
                    this.a.N().l4();
                }
                if (this.a.N() != null) {
                    this.a.N().b4(i);
                }
                if (i == 0) {
                    this.a.p2(true);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                this.a.k2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements x95.g {
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

        @Override // com.baidu.tieba.x95.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.Q() != null && this.a.Q().w2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.W1();
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
                a0a a0aVar = null;
                Iterator<b0a> it = this.a.Q().y1().F().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b0a next = it.next();
                    if (next instanceof a0a) {
                        a0a a0aVar2 = (a0a) next;
                        if (str.equals(a0aVar2.A1())) {
                            a0aVar = a0aVar2;
                            break;
                        }
                    }
                }
                if (a0aVar != null && this.a.g != null && this.a.d != null) {
                    this.a.Q().y1().F().remove(a0aVar);
                    if (this.a.g.a() != null) {
                        this.a.g.a().remove(a0aVar);
                    }
                    if (this.a.d.getListView2().getData() != null) {
                        this.a.d.getListView2().getData().remove(a0aVar);
                    }
                    this.a.S1();
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
                this.a.g.l();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.Q() != null && (customResponsedMessage.getData() instanceof j49)) {
                j49 j49Var = (j49) customResponsedMessage.getData();
                if (StringHelper.equals(this.a.Q().R1(), j49Var.P())) {
                    this.a.Q().K0(j49Var.N());
                    this.a.Q().D2(j49Var, 3, "");
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.x && this.a.N() != null) {
                this.a.x = true;
                this.a.N().V2(this.a.d, false);
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
            if (!this.a.v && this.a.U1() && this.a.Q() != null) {
                StatisticItem statisticItem = new StatisticItem("c13999");
                statisticItem.param("tid", this.a.Q().R1());
                statisticItem.param("fid", this.a.Q().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                this.a.v = true;
            }
            if (this.a.Q().u2(false)) {
                this.a.t2();
                if (this.a.getPageContext() != null) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                }
            } else if (this.a.Q().y1() != null) {
                this.a.n2();
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

    public int a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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

    public final void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d077e, (ViewGroup) null));
            this.q = pbReplyTitleViewHolder;
            pbReplyTitleViewHolder.v = false;
            pbReplyTitleViewHolder.r(N().u3());
            this.q.q(N().U0);
            this.q.t(8);
        }
    }

    public final void k2() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (bdTypeRecyclerView = this.d) != null && this.f != null && this.g != null) {
            int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount() + this.g.d();
            int headerViewsCount2 = this.d.getHeaderViewsCount() + this.g.c();
            int findFirstVisibleItemPosition = this.f.findFirstVisibleItemPosition();
            if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
                this.q.t(0);
            } else {
                this.q.t(8);
            }
            if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
                this.q.t(8);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onDestroy();
            kc9 kc9Var = this.g;
            if (kc9Var != null) {
                kc9Var.n();
            }
            MessageManager.getInstance().unRegisterListener(this.B);
            MessageManager.getInstance().unRegisterListener(this.C);
            f79.a().d();
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.w);
            }
            if (getActivity() instanceof PbActivity) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921757));
            }
        }
    }

    public void o2(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048604, this, i2, i3) == null) && (bdTypeRecyclerView = this.d) != null && bdTypeRecyclerView.getLayoutManager() != null && (this.d.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.d.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
        }
    }

    public static DetailInfoAndReplyFragment j2(AbsVideoPbFragment absVideoPbFragment) {
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

    @Override // com.baidu.tieba.sc9.b
    public void l1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.p = z;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        j49 y1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) {
            super.onActivityCreated(bundle);
            PbModel Q = Q();
            if (Q != null && (y1 = Q.y1()) != null) {
                T1(true, 0, 3, 0, y1, "", 1, true);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, context) == null) {
            super.onAttach(context);
            if (context instanceof AbsPbActivity) {
                this.a = (AbsPbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    public void q2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048616, this, str) == null) && (pbListView = this.i) != null) {
            pbListView.H(str);
        }
    }

    public void r2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, str) == null) && (pbListView = this.i) != null) {
            pbListView.M(str, this.u);
        }
    }

    public void s2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.m = z;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, view2) == null) {
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

    public final void S1() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (bdTypeRecyclerView = this.d) == null) {
            return;
        }
        if (this.e == null) {
            this.e = new io(bdTypeRecyclerView);
        }
        this.e.e(new d(this));
    }

    public AbsPbActivity V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null) {
                return absPbActivity;
            }
            return N().V();
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public void W1() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (bdSwipeRefreshLayout = this.r) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.r.setRefreshing(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: X1 */
    public kc9 H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.g;
        }
        return (kc9) invokeV.objValue;
    }

    public int Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                return bdTypeRecyclerView.getFirstVisiblePosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int Z1() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.d.getChildAt(0)) == null) {
                return 0;
            }
            return childAt.getTop();
        }
        return invokeV.intValue;
    }

    public BdTypeRecyclerView b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.d;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public View c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.j;
        }
        return (View) invokeV.objValue;
    }

    public pc9 d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.h;
        }
        return (pc9) invokeV.objValue;
    }

    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (Q() != null) {
                return Q().b1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.d == null) {
        }
    }

    public void m2() {
        kc9 kc9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (kc9Var = this.g) != null) {
            kc9Var.m();
        }
    }

    public void n2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.o != 2) {
            this.d.setNextPage(this.i);
            this.o = 2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onPause();
            ya9.a();
            if (N() != null) {
                f79.a().i(V());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onResume();
            this.p = false;
            p2(false);
        }
    }

    public void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.i.D();
            this.i.U();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.TRUE));
        }
    }

    @Override // com.baidu.tieba.nt5
    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.canScrollVertically(-1) || e2()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void T1(boolean z, int i2, int i3, int i4, j49 j49Var, String str, int i5, boolean z2) {
        int size;
        int i6;
        int size2;
        int i7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), j49Var, str, Integer.valueOf(i5), Boolean.valueOf(z2)}) == null) && z && Q() != null && j49Var != null) {
            if (!z2) {
                if (this.y) {
                    Q().G0();
                } else {
                    this.y = true;
                }
            }
            this.t = Q().Q1();
            boolean isEnabled = this.r.isEnabled();
            if (j49Var.y().c() == 0 && this.t) {
                this.r.setEnabled(false);
            } else if (!isEnabled) {
                this.r.setEnabled(true);
                this.r.o();
            }
            this.g.t(this.t);
            this.g.s(j49Var, z2);
            this.l = false;
            if (TbadkCoreApplication.isLogin()) {
                this.d.setNextPage(this.i);
                this.o = 2;
                if (N() != null && N().o != null) {
                    this.b.o.W();
                }
            } else {
                this.l = true;
                if (j49Var.y().b() == 1) {
                    if (this.k == null) {
                        sc9 sc9Var = new sc9(this, this);
                        this.k = sc9Var;
                        sc9Var.a();
                        this.k.h();
                        if (this.g instanceof lc9) {
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
                y49 y49Var = new y49(y49.g);
                y49Var.c = i2();
                y49Var.b = j49Var.g;
                y49Var.d = j49Var.i0();
                y49Var.e = j49Var.f;
                this.q.i(y49Var);
            }
            ArrayList<b0a> F = j49Var.F();
            if (j49Var.y().b() != 0 && F != null && F.size() >= j49Var.y().e()) {
                if (Q().h1()) {
                    if (this.n) {
                        V1();
                        if (j49Var.y().b() != 0) {
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
                if (j49Var.y().b() == 0) {
                    this.i.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.i.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.i.n();
                if (j49Var.y().b() == 0 || F == null) {
                    n2();
                }
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                if (i3 == 8) {
                                    if (this.d.getData() == null && j49Var.F() == null) {
                                        size2 = 0;
                                    } else {
                                        size2 = this.d.getData().size() - j49Var.F().size();
                                    }
                                    BdTypeRecyclerView bdTypeRecyclerView = this.d;
                                    if (i4 > 0) {
                                        i7 = i4 + size2;
                                    } else {
                                        i7 = 0;
                                    }
                                    bdTypeRecyclerView.setSelection(i7);
                                    this.i.g();
                                    this.i.H(getString(R.string.obfuscated_res_0x7f0f0fac));
                                    this.i.B();
                                }
                            } else {
                                if (i5 == 1) {
                                    Parcelable e2 = h89.b().e();
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
                    Parcelable e3 = h89.b().e();
                    if (e3 instanceof RecyclerView.SavedState) {
                        this.d.onRestoreInstanceState(e3);
                        if (ListUtils.getCount(F) > 1 && j49Var.y().b() > 0) {
                            this.i.g();
                            this.i.H(getString(R.string.obfuscated_res_0x7f0f0fac));
                            this.i.B();
                        }
                    }
                }
            } else {
                if (this.d.getData() == null && j49Var.F() == null) {
                    size = 0;
                } else {
                    size = this.d.getData().size() - j49Var.F().size();
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
                l2();
                this.m = false;
                if (i5 == 0) {
                    s2(true);
                }
            }
            N().g4(j49Var);
            if (this.i != null) {
                if (j49Var.y().b() == 0) {
                    this.i.O(8);
                } else {
                    this.i.O(0);
                }
            }
            if (k99.a(b2())) {
                if (Q().C2()) {
                    k99.c(b2(), Q().Y0());
                }
                AbsPbActivity absPbActivity = this.a;
                if (absPbActivity instanceof PbActivity) {
                    ((PbActivity) absPbActivity).d2(j49Var.f(), this.d);
                }
            }
        }
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            PbListView pbListView = this.i;
            if (pbListView != null && !TextUtils.isEmpty(pbListView.j())) {
                return this.i.j().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            PbListView pbListView = this.i;
            if (pbListView != null) {
                pbListView.B();
                this.i.g();
            }
            if (N() != null && N().o != null) {
                this.b.o.W();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.FALSE));
        }
    }

    public final boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (Q() == null || Q().w1() == null || Q().w1().c() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.u = wi.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f092824);
            this.d = bdTypeRecyclerView;
            this.e = new io(bdTypeRecyclerView);
            f fVar = new f(this, getContext());
            this.f = fVar;
            this.d.setLayoutManager(fVar);
            lc9 lc9Var = new lc9(this, this.d);
            this.g = lc9Var;
            lc9Var.z(N().u3());
            this.g.u(N().v3());
            this.g.x(N().y3());
            this.g.w(this.h.j());
            this.g.D(this.h.m());
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.i = pbListView;
            View findViewById = pbListView.c().findViewById(R.id.pb_more_view);
            this.j = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(N().u3());
                SkinManager.setBackgroundResource(this.j, R.drawable.pb_foot_more_trans_selector);
            }
            this.i.D();
            this.i.r(R.drawable.pb_foot_more_trans_selector);
            this.i.s(R.drawable.pb_foot_more_trans_selector);
            this.i.v();
            this.d.setOnSrollToBottomListener(this.D);
            this.d.addOnScrollListener(this.z);
            this.d.setOnTouchListener(N().z3());
            this.w = new g(this);
            this.d.getViewTreeObserver().addOnGlobalLayoutListener(this.w);
            if (this.s == null) {
                y95 y95Var = new y95(getPageContext());
                this.s = y95Var;
                y95Var.n();
                this.s.f(this.A);
            }
            if (this.r == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091ab6);
                this.r = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.s);
                this.r.setEnabled(false);
                SkinManager.setBackgroundColor(this.r, R.color.CAM_X0205);
            }
            f2();
            this.g.y(N().U0);
            registerListener(this.B);
            registerListener(this.C);
        }
    }

    public void h2() {
        j49 y1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || (y1 = Q().y1()) == null) {
            return;
        }
        this.g.t(Q().Q1());
        this.g.r(y1);
        S1();
        ArrayList<b0a> F = y1.F();
        if (y1.y().b() == 0 || F == null || F.size() < y1.y().e()) {
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).I() != 1)) {
                if (y1.y().b() == 0) {
                    this.i.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.i.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.i.n();
            } else if (i2()) {
                this.i.M(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fb2), this.u);
            } else {
                this.i.M(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fb3), this.u);
            }
        }
        N().g4(y1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            super.onChangeSkinType(i2);
            PbListView pbListView = this.i;
            if (pbListView != null) {
                pbListView.e(i2);
                if (this.j != null) {
                    getBaseFragmentActivity().getLayoutMode().k(this.j);
                    SkinManager.setBackgroundResource(this.j, R.drawable.pb_foot_more_trans_selector);
                }
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.q;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.m(i2);
            }
            S1();
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0201);
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setBackgroundResource(0);
            }
        }
    }

    public final void p2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048614, this, z) == null) && N() != null && V() != null && V().K1() != null && this.g.e() != null) {
            f79.a().f(V().K1().l2(), this.g.e().x(), this.q.k(), V().getPageStayDurationItem(), z, null, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048609, this, layoutInflater, viewGroup, bundle)) == null) {
            this.h = new pc9(this);
            this.c = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0755, (ViewGroup) null);
            g2();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            super.onUserChanged(z);
            u2(z);
            if (N() != null && N().o != null) {
                this.b.o.I();
            }
            if (z && this.p) {
                t2();
                Q().u2(true);
            }
        }
    }

    public void u2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048621, this, z) == null) && z && this.l) {
            this.i.H(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.d.setNextPage(this.i);
            this.o = 2;
        }
    }

    public void v2(boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            kc9 kc9Var = this.g;
            if (kc9Var != null) {
                kc9Var.v(z);
                S1();
            }
            if (z && N() != null) {
                ya9.d(getPageContext(), Q(), this, N().getView());
            }
            j49 y1 = Q().y1();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            if (y1 != null) {
                str = y1.l();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    @Override // com.baidu.tieba.ic9
    public void w1(boolean z, int i2, int i3, int i4, j49 j49Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), j49Var, str, Integer.valueOf(i5)}) == null) && getActivity() != null) {
            T1(z, i2, i3, i4, j49Var, str, i5, false);
        }
    }
}
