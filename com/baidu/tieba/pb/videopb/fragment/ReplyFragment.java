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
import com.baidu.tieba.d58;
import com.baidu.tieba.dx7;
import com.baidu.tieba.e28;
import com.baidu.tieba.i58;
import com.baidu.tieba.k58;
import com.baidu.tieba.n48;
import com.baidu.tieba.p48;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.MultiNestedLayout;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.qx7;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tz7;
import com.baidu.tieba.uy4;
import com.baidu.tieba.vy4;
import com.baidu.tieba.w08;
import com.baidu.tieba.xi;
import com.baidu.tieba.zo8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class ReplyFragment extends BaseVideoPBReplyFragment implements n48, k58.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView.OnScrollListener A;
    public MultiNestedLayout.b B;
    public final uy4.g C;
    public CustomMessageListener D;
    public final BdListView.p E;
    public AbsPbActivity a;
    public AbsVideoPbFragment b;
    public View c;
    public BdTypeRecyclerView d;
    public p48 e;
    public d58 f;
    public MultiNestedLayout g;
    public PbListView h;
    public View i;
    public k58 j;
    public View k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public boolean p;
    public i58 q;
    public View r;
    public BdSwipeRefreshLayout s;
    public vy4 t;
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
                    this.a.B().X4();
                    this.a.B().Z4();
                }
                if (this.a.B() != null) {
                    this.a.B().K4(i);
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
                    this.a.B().o5(8);
                    this.a.k.setVisibility(0);
                } else if (this.a.w == 0 && i != 0) {
                    if (this.a.k.getVisibility() != 0) {
                        this.a.B().o5(0);
                    }
                } else if (this.a.w != 0 && i == 0) {
                    this.a.B().o5(8);
                }
                this.a.w = i;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements uy4.g {
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

        @Override // com.baidu.tieba.uy4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.K() != null && this.a.K().R2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.F1();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.K() != null && this.a.K().S1() != null && this.a.K().S1().H() != null) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                zo8 zo8Var = null;
                Iterator<PostData> it = this.a.K().S1().H().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next instanceof zo8) {
                        zo8 zo8Var2 = (zo8) next;
                        if (str.equals(zo8Var2.m1())) {
                            zo8Var = zo8Var2;
                            break;
                        }
                    }
                }
                if (zo8Var != null && this.a.e != null && this.a.d != null) {
                    this.a.K().S1().H().remove(zo8Var);
                    if (this.a.e.a() != null) {
                        this.a.e.a().remove(zo8Var);
                    }
                    if (this.a.d.getListView2().getData() != null) {
                        this.a.d.getListView2().getData().remove(zo8Var);
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
                    this.a.c2();
                } else {
                    this.a.m();
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
            if (!this.a.y && this.a.D1() && this.a.K() != null) {
                StatisticItem statisticItem = new StatisticItem("c13999");
                statisticItem.param("tid", this.a.K().m2());
                statisticItem.param("fid", this.a.K().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                this.a.y = true;
            }
            if (this.a.K().N2(false)) {
                this.a.a2();
                if (this.a.getPageContext() != null) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                }
            } else if (this.a.K().S1() != null) {
                this.a.V1();
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

    public int J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
                if (K() != null && K().S1() != null && lastVisiblePosition >= K().S1().H().size()) {
                    return K().S1().H().size() - 2;
                }
                return lastVisiblePosition;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static ReplyFragment S1(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            ReplyFragment replyFragment = new ReplyFragment();
            replyFragment.setArguments(bundle);
            replyFragment.b = absVideoPbFragment;
            return replyFragment;
        }
        return (ReplyFragment) invokeL.objValue;
    }

    public void T1(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && (bdTypeRecyclerView = this.d) != null) {
            bdTypeRecyclerView.setCanFling(z);
        }
    }

    @Override // com.baidu.tieba.k58.b
    public void X0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.p = z;
        }
    }

    public void X1(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, str) == null) && (pbListView = this.h) != null) {
            pbListView.D(str);
        }
    }

    public void Y1(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, str) == null) && (pbListView = this.h) != null) {
            pbListView.I(str, this.x);
        }
    }

    public void Z1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.m = z;
        }
    }

    public void b2(int i) {
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
        if (interceptable == null || interceptable.invokeL(1048620, this, view2) == null) {
            super.showLoadingView(view2);
        }
    }

    public void W1(int i, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048598, this, i, i2) == null) && (bdTypeRecyclerView = this.d) != null && bdTypeRecyclerView.getLayoutManager() != null && (this.d.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.d.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsVideoPbFragment B() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.b == null && (absPbActivity = this.a) != null) {
                Fragment d1 = absPbActivity.d1();
                if (d1 instanceof AbsVideoPbFragment) {
                    this.b = (AbsVideoPbFragment) d1;
                }
            }
            return this.b;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    public void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.y();
                this.h.f();
            }
            if (B() != null && B().N != null) {
                this.b.N.V();
            }
        }
    }

    public void F1() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bdSwipeRefreshLayout = this.s) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.s.setRefreshing(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: G1 */
    public p48 q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (p48) invokeV.objValue;
    }

    public int H1() {
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

    public int I1() {
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

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return B().K();
        }
        return (PbModel) invokeV.objValue;
    }

    public BdTypeRecyclerView K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.d;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public int L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    public View M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public int N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.v;
        }
        return invokeV.intValue;
    }

    public d58 O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.f;
        }
        return (d58) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsPbActivity P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null) {
                return absPbActivity;
            }
            return B().P();
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (K() != null) {
                return K().v1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void U1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || this.d == null) {
        }
    }

    public void V1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && this.o != 2) {
            this.d.setNextPage(this.h);
            this.o = 2;
        }
    }

    public void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.h.A();
            this.h.R();
        }
    }

    public void c2() {
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

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && getView() != null) {
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
                tz7.a().f();
            } else {
                tz7.a().j(P());
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
                tz7.a().f();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onStop();
            tz7.a().j(P());
        }
    }

    public final void C1(boolean z, int i, int i2, int i3, dx7 dx7Var, String str, int i4) {
        int size;
        int i5;
        int size2;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), dx7Var, str, Integer.valueOf(i4)}) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(P()).get(VideoPbViewModel.class);
            if (z && K() != null && dx7Var != null) {
                if (this.z) {
                    K().Z0();
                } else {
                    this.z = true;
                }
                this.u = K().k2();
                boolean isEnabled = this.s.isEnabled();
                if (dx7Var.z().c() == 0 && this.u) {
                    this.s.setEnabled(false);
                } else if (!isEnabled) {
                    this.s.setEnabled(true);
                    this.s.o();
                }
                this.e.g(videoPbViewModel.m());
                this.e.h(this.u);
                this.e.f(dx7Var);
                this.l = false;
                if (TbadkCoreApplication.isLogin()) {
                    this.d.setNextPage(this.h);
                    this.o = 2;
                    if (B() != null && B().N != null) {
                        this.b.N.V();
                    }
                } else {
                    this.l = true;
                    if (dx7Var.z().b() == 1) {
                        if (this.j == null) {
                            k58 k58Var = new k58(this, this);
                            this.j = k58Var;
                            k58Var.a();
                            this.j.g();
                        }
                        this.d.setNextPage(this.j);
                    } else {
                        this.d.setNextPage(this.h);
                    }
                    this.o = 3;
                }
                if (this.q != null && this.r != null) {
                    qx7 qx7Var = new qx7(qx7.i);
                    ThreadData Q = dx7Var.Q();
                    if (Q != null) {
                        Q.getReply_num();
                    }
                    K().k2();
                    qx7Var.d = R1();
                    qx7Var.c = dx7Var.g;
                    dx7Var.c();
                    qx7Var.e = dx7Var.l0();
                    qx7Var.g = dx7Var.f;
                    qx7Var.f = Q.isVideoWorksInfo();
                    this.q.e(qx7Var);
                }
                ArrayList<PostData> H = dx7Var.H();
                if (dx7Var.z().b() != 0 && H != null && H.size() >= dx7Var.z().e()) {
                    if (K().B1()) {
                        if (this.n) {
                            E1();
                            if (dx7Var.z().b() != 0) {
                                this.h.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e1c));
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
                    if (ListUtils.getCount(H) != 0 && (ListUtils.getCount(H) != 1 || H.get(0) == null || H.get(0).D() != 1)) {
                        if (dx7Var.z().b() == 0) {
                            this.h.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a18));
                        } else {
                            this.h.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a6c));
                        }
                        this.h.k();
                    } else if (R1()) {
                        this.h.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e23), this.x);
                    } else {
                        this.h.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e24), this.x);
                    }
                    if (dx7Var.z().b() == 0 || H == null) {
                        V1();
                    }
                }
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                if (i2 != 6) {
                                    if (i2 == 8) {
                                        if (this.d.getData() == null && dx7Var.H() == null) {
                                            size2 = 0;
                                        } else {
                                            size2 = this.d.getData().size() - dx7Var.H().size();
                                        }
                                        this.g.setMaxOffset();
                                        BdTypeRecyclerView bdTypeRecyclerView = this.d;
                                        if (i3 > 0) {
                                            i6 = i3 + size2;
                                        } else {
                                            i6 = 0;
                                        }
                                        bdTypeRecyclerView.setSelection(i6);
                                        this.h.f();
                                        this.h.D(getString(R.string.obfuscated_res_0x7f0f0e1d));
                                        this.h.y();
                                    }
                                } else {
                                    if (i4 == 1) {
                                        Parcelable e2 = w08.b().e();
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
                        Parcelable e3 = w08.b().e();
                        if (e3 instanceof RecyclerView.SavedState) {
                            this.d.onRestoreInstanceState(e3);
                            if (ListUtils.getCount(H) > 1 && dx7Var.z().b() > 0) {
                                this.h.f();
                                this.h.D(getString(R.string.obfuscated_res_0x7f0f0e1d));
                                this.h.y();
                            }
                        }
                    }
                } else {
                    if (this.d.getData() == null && dx7Var.H() == null) {
                        size = 0;
                    } else {
                        size = this.d.getData().size() - dx7Var.H().size();
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
                    U1();
                    this.m = false;
                    if (i4 == 0) {
                        Z1(true);
                    }
                }
                B().S4(dx7Var);
                String t1 = K().t1();
                if (!TextUtils.isEmpty(t1)) {
                    e28.b(K1(), t1);
                }
            }
        }
    }

    public boolean D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbListView pbListView = this.h;
            if (pbListView != null && !TextUtils.isEmpty(pbListView.h())) {
                return this.h.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a18));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.x = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            MultiNestedLayout multiNestedLayout = (MultiNestedLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0915e1);
            this.g = multiNestedLayout;
            multiNestedLayout.setScrollStateChangeListener(this.B);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f092590);
            this.d = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            p48 p48Var = new p48(this, this.d);
            this.e = p48Var;
            p48Var.l(B().O3());
            this.e.i(B().P3());
            this.e.k(B().S3());
            this.e.j(this.f.j());
            this.e.m(this.f.m());
            this.k = this.c.findViewById(R.id.obfuscated_res_0x7f091c3c);
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.h = pbListView;
            View findViewById = pbListView.b().findViewById(R.id.obfuscated_res_0x7f09187f);
            this.i = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(B().O3());
                SkinManager.setBackgroundResource(this.i, R.drawable.pb_foot_more_trans_selector);
            }
            this.h.A();
            this.h.o(R.drawable.pb_foot_more_trans_selector);
            this.h.p(R.drawable.pb_foot_more_trans_selector);
            this.h.s();
            this.d.setOnSrollToBottomListener(this.E);
            this.d.addOnScrollListener(this.A);
            this.d.setOnTouchListener(B().T3());
            if (this.t == null) {
                vy4 vy4Var = new vy4(getPageContext());
                this.t = vy4Var;
                vy4Var.n();
                this.t.f(this.C);
            }
            if (this.s == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0918d9);
                this.s = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.t);
                this.s.setEnabled(false);
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0205);
            }
            View findViewById2 = this.c.findViewById(R.id.obfuscated_res_0x7f09258f);
            this.r = findViewById2;
            i58 i58Var = new i58(findViewById2);
            this.q = i58Var;
            i58Var.i(B().O3());
            this.q.j(B().J1);
            registerListener(this.D);
        }
    }

    public void Q1() {
        dx7 S1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || (S1 = K().S1()) == null) {
            return;
        }
        this.e.h(K().k2());
        this.e.f(S1);
        this.e.e();
        ArrayList<PostData> H = S1.H();
        if (S1.z().b() == 0 || H == null || H.size() < S1.z().e()) {
            if (ListUtils.getCount(H) != 0 && (ListUtils.getCount(H) != 1 || H.get(0) == null || H.get(0).D() != 1)) {
                if (S1.z().b() == 0) {
                    this.h.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a18));
                } else {
                    this.h.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a6c));
                }
                this.h.k();
            } else if (R1()) {
                this.h.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e23), this.x);
            } else {
                this.h.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e24), this.x);
            }
        }
        B().S4(S1);
    }

    public void d2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048606, this, z) == null) && z && this.l) {
            this.h.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03f8));
            this.d.setNextPage(this.h);
            this.o = 2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(P()).get(VideoPbViewModel.class);
            videoPbViewModel.o().observe(this, new e(this));
            C1(true, 0, 3, 0, videoPbViewModel.c(), "", 1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            super.onUserChanged(z);
            d2(z);
            if (B() != null && B().N != null) {
                this.b.N.H();
            }
            if (z && this.p) {
                a2();
                K().N2(true);
            }
        }
    }

    @Override // com.baidu.tieba.n48
    public void g1(boolean z, int i, int i2, int i3, dx7 dx7Var, String str, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), dx7Var, str, Integer.valueOf(i4)}) == null) && getActivity() != null) {
            C1(z, i, i2, i3, dx7Var, str, i4);
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
                    getBaseFragmentActivity().getLayoutMode().k(this.i);
                    SkinManager.setBackgroundResource(this.i, R.drawable.pb_foot_more_trans_selector);
                }
            }
            i58 i58Var = this.q;
            if (i58Var != null) {
                i58Var.h(i);
            }
            p48 p48Var = this.e;
            if (p48Var != null) {
                p48Var.e();
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
            this.f = new d58(this);
            this.c = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d06fa, (ViewGroup) null);
            P1();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }
}
