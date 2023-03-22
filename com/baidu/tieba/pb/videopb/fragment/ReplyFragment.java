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
import com.baidu.tieba.ac9;
import com.baidu.tieba.al8;
import com.baidu.tieba.bc9;
import com.baidu.tieba.dm8;
import com.baidu.tieba.hi;
import com.baidu.tieba.ki8;
import com.baidu.tieba.lq8;
import com.baidu.tieba.mn8;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.MultiNestedLayout;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.qq8;
import com.baidu.tieba.rq8;
import com.baidu.tieba.v35;
import com.baidu.tieba.vp8;
import com.baidu.tieba.w35;
import com.baidu.tieba.xi8;
import com.baidu.tieba.xp8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class ReplyFragment extends BaseVideoPBReplyFragment implements vp8, rq8.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView.OnScrollListener A;
    public MultiNestedLayout.b B;
    public final v35.g C;
    public CustomMessageListener D;
    public final BdListView.p E;
    public AbsPbActivity a;
    public AbsVideoPbFragment b;
    public View c;
    public BdTypeRecyclerView d;
    public xp8 e;
    public lq8 f;
    public MultiNestedLayout g;
    public PbListView h;
    public View i;
    public rq8 j;
    public View k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public boolean p;
    public qq8 q;
    public View r;
    public BdSwipeRefreshLayout s;
    public w35 t;
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
                    this.a.D().j5();
                    this.a.D().l5();
                }
                if (this.a.D() != null) {
                    this.a.D().W4(i);
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
                    this.a.D().B5(8);
                    this.a.k.setVisibility(0);
                } else if (this.a.w == 0 && i != 0) {
                    if (this.a.k.getVisibility() != 0) {
                        this.a.D().B5(0);
                    }
                } else if (this.a.w != 0 && i == 0) {
                    this.a.D().B5(8);
                }
                this.a.w = i;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements v35.g {
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

        @Override // com.baidu.tieba.v35.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.L() != null && this.a.L().z2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.S1();
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
                if (ac9Var != null && this.a.e != null && this.a.d != null) {
                    this.a.L().w1().H().remove(ac9Var);
                    if (this.a.e.a() != null) {
                        this.a.e.a().remove(ac9Var);
                    }
                    if (this.a.d.getListView2().getData() != null) {
                        this.a.d.getListView2().getData().remove(ac9Var);
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
                    this.a.p2();
                } else {
                    this.a.l();
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
            if (!this.a.y && this.a.Q1() && this.a.L() != null) {
                StatisticItem statisticItem = new StatisticItem("c13999");
                statisticItem.param("tid", this.a.L().Q1());
                statisticItem.param("fid", this.a.L().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                this.a.y = true;
            }
            if (this.a.L().v2(false)) {
                this.a.n2();
                if (this.a.getPageContext() != null) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                }
            } else if (this.a.L().w1() != null) {
                this.a.i2();
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

    public int W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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

    public static ReplyFragment f2(AbsVideoPbFragment absVideoPbFragment) {
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

    public void g2(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048596, this, z) == null) && (bdTypeRecyclerView = this.d) != null) {
            bdTypeRecyclerView.setCanFling(z);
        }
    }

    @Override // com.baidu.tieba.rq8.b
    public void h1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.p = z;
        }
    }

    public void k2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, str) == null) && (pbListView = this.h) != null) {
            pbListView.F(str);
        }
    }

    public void l2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, str) == null) && (pbListView = this.h) != null) {
            pbListView.K(str, this.x);
        }
    }

    public void m2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.m = z;
        }
    }

    public void o2(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048606, this, i) == null) && (view2 = this.k) != null) {
            view2.setVisibility(i);
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, view2) == null) {
            super.showLoadingView(view2);
        }
    }

    public void j2(int i, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048600, this, i, i2) == null) && (bdTypeRecyclerView = this.d) != null && bdTypeRecyclerView.getLayoutManager() != null && (this.d.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.d.getLayoutManager()).scrollToPositionWithOffset(i, i2);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null) {
                return absPbActivity;
            }
            return D().M();
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.A();
                this.h.g();
            }
            if (D() != null && D().N != null) {
                this.b.N.W();
            }
        }
    }

    public void S1() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (bdSwipeRefreshLayout = this.s) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.s.setRefreshing(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: T1 */
    public xp8 E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return (xp8) invokeV.objValue;
    }

    public int U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                return bdTypeRecyclerView.getFirstVisiblePosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int V1() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.d.getChildAt(0)) == null) {
                return 0;
            }
            return childAt.getTop();
        }
        return invokeV.intValue;
    }

    public BdTypeRecyclerView X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.d;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public int Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    public View Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public int a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.v;
        }
        return invokeV.intValue;
    }

    public lq8 b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.f;
        }
        return (lq8) invokeV.objValue;
    }

    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (L() != null) {
                return L().Z0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || this.d == null) {
        }
    }

    public void i2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.o != 2) {
            this.d.setNextPage(this.h);
            this.o = 2;
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && getView() != null) {
            ViewGroup viewGroup = (ViewGroup) getView();
            hideLoadingView(viewGroup);
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                viewGroup.getChildAt(i).setVisibility(0);
            }
        }
    }

    public void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.h.C();
            this.h.T();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.D);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                al8.a().f();
            } else {
                al8.a().j(M());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onResume();
            this.p = false;
            if (isPrimary()) {
                al8.a().f();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onStop();
            al8.a().j(M());
        }
    }

    public void p2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && getView() != null) {
            ViewGroup viewGroup = (ViewGroup) getView();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                viewGroup.getChildAt(i).setVisibility(8);
            }
            showLoadingView(viewGroup);
        }
    }

    public final void P1(boolean z, int i, int i2, int i3, ki8 ki8Var, String str, int i4) {
        int size;
        int i5;
        int size2;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ki8Var, str, Integer.valueOf(i4)}) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(M()).get(VideoPbViewModel.class);
            if (z && L() != null && ki8Var != null) {
                if (this.z) {
                    L().D0();
                } else {
                    this.z = true;
                }
                this.u = L().O1();
                boolean isEnabled = this.s.isEnabled();
                if (ki8Var.z().c() == 0 && this.u) {
                    this.s.setEnabled(false);
                } else if (!isEnabled) {
                    this.s.setEnabled(true);
                    this.s.o();
                }
                this.e.g(videoPbViewModel.m());
                this.e.h(this.u);
                this.e.f(ki8Var);
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
                        }
                        this.d.setNextPage(this.j);
                    } else {
                        this.d.setNextPage(this.h);
                    }
                    this.o = 3;
                }
                if (this.q != null && this.r != null) {
                    xi8 xi8Var = new xi8(xi8.i);
                    ThreadData Q = ki8Var.Q();
                    if (Q != null) {
                        Q.getReply_num();
                    }
                    L().O1();
                    xi8Var.d = e2();
                    xi8Var.c = ki8Var.g;
                    ki8Var.c();
                    xi8Var.e = ki8Var.l0();
                    xi8Var.g = ki8Var.f;
                    xi8Var.f = Q.isVideoWorksInfo();
                    this.q.e(xi8Var);
                }
                ArrayList<bc9> H = ki8Var.H();
                if (ki8Var.z().b() != 0 && H != null && H.size() >= ki8Var.z().e()) {
                    if (L().f1()) {
                        if (this.n) {
                            R1();
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
                    if (ListUtils.getCount(H) != 0 && (ListUtils.getCount(H) != 1 || H.get(0) == null || H.get(0).E() != 1)) {
                        if (ki8Var.z().b() == 0) {
                            this.h.F(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                        } else {
                            this.h.F(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                        }
                        this.h.m();
                    } else if (e2()) {
                        this.h.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ec9), this.x);
                    } else {
                        this.h.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0eca), this.x);
                    }
                    if (ki8Var.z().b() == 0 || H == null) {
                        i2();
                    }
                }
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                if (i2 != 6) {
                                    if (i2 == 8) {
                                        if (this.d.getData() == null && ki8Var.H() == null) {
                                            size2 = 0;
                                        } else {
                                            size2 = this.d.getData().size() - ki8Var.H().size();
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
                                        this.h.F(getString(R.string.obfuscated_res_0x7f0f0ec3));
                                        this.h.A();
                                    }
                                } else {
                                    if (i4 == 1) {
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
                    } else if (i4 == 1) {
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
                    if (i3 > 1) {
                        i5 = (i3 + size) - 2;
                    } else {
                        i5 = 0;
                    }
                    bdTypeRecyclerView2.setSelection(i5);
                }
                if (this.m) {
                    h2();
                    this.m = false;
                    if (i4 == 0) {
                        m2(true);
                    }
                }
                D().e5(ki8Var);
                String X0 = L().X0();
                if (!TextUtils.isEmpty(X0)) {
                    mn8.b(X1(), X0);
                }
            }
        }
    }

    public boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            PbListView pbListView = this.h;
            if (pbListView != null && !TextUtils.isEmpty(pbListView.i())) {
                return this.h.i().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.x = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            MultiNestedLayout multiNestedLayout = (MultiNestedLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091729);
            this.g = multiNestedLayout;
            multiNestedLayout.setScrollStateChangeListener(this.B);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f092764);
            this.d = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            xp8 xp8Var = new xp8(this, this.d);
            this.e = xp8Var;
            xp8Var.l(D().c4());
            this.e.i(D().d4());
            this.e.k(D().g4());
            this.e.j(this.f.j());
            this.e.m(this.f.m());
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
            this.d.setOnSrollToBottomListener(this.E);
            this.d.addOnScrollListener(this.A);
            this.d.setOnTouchListener(D().h4());
            if (this.t == null) {
                w35 w35Var = new w35(getPageContext());
                this.t = w35Var;
                w35Var.n();
                this.t.f(this.C);
            }
            if (this.s == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091a34);
                this.s = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.t);
                this.s.setEnabled(false);
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0205);
            }
            View findViewById2 = this.c.findViewById(R.id.obfuscated_res_0x7f092763);
            this.r = findViewById2;
            qq8 qq8Var = new qq8(findViewById2);
            this.q = qq8Var;
            qq8Var.i(D().c4());
            this.q.j(D().I1);
            registerListener(this.D);
        }
    }

    public void d2() {
        ki8 w1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || (w1 = L().w1()) == null) {
            return;
        }
        this.e.h(L().O1());
        this.e.f(w1);
        this.e.e();
        ArrayList<bc9> H = w1.H();
        if (w1.z().b() == 0 || H == null || H.size() < w1.z().e()) {
            if (ListUtils.getCount(H) != 0 && (ListUtils.getCount(H) != 1 || H.get(0) == null || H.get(0).E() != 1)) {
                if (w1.z().b() == 0) {
                    this.h.F(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.h.F(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.h.m();
            } else if (e2()) {
                this.h.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ec9), this.x);
            } else {
                this.h.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0eca), this.x);
            }
        }
        D().e5(w1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(M()).get(VideoPbViewModel.class);
            videoPbViewModel.o().observe(this, new e(this));
            P1(true, 0, 3, 0, videoPbViewModel.c(), "", 1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            super.onUserChanged(z);
            q2(z);
            if (D() != null && D().N != null) {
                this.b.N.I();
            }
            if (z && this.p) {
                n2();
                L().v2(true);
            }
        }
    }

    public void q2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048618, this, z) == null) && z && this.l) {
            this.h.F(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.d.setNextPage(this.h);
            this.o = 2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            super.onChangeSkinType(i);
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.e(i);
                if (this.i != null) {
                    getBaseFragmentActivity().getLayoutMode().k(this.i);
                    SkinManager.setBackgroundResource(this.i, R.drawable.pb_foot_more_trans_selector);
                }
            }
            qq8 qq8Var = this.q;
            if (qq8Var != null) {
                qq8Var.h(i);
            }
            xp8 xp8Var = this.e;
            if (xp8Var != null) {
                xp8Var.e();
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048611, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f = new lq8(this);
            this.c = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d073f, (ViewGroup) null);
            c2();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.vp8
    public void s1(boolean z, int i, int i2, int i3, ki8 ki8Var, String str, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ki8Var, str, Integer.valueOf(i4)}) == null) && getActivity() != null) {
            P1(z, i, i2, i3, ki8Var, str, i4);
        }
    }
}
