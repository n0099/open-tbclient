package com.baidu.tieba;

import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.nearby.NearbyFriendsActivity;
import com.baidu.tieba.v35;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class rd8 implements qd8, v35.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NearbyFriendsActivity a;
    public pd8 b;
    public NavigationBar c;
    public FrameLayout d;
    public BdSwipeRefreshLayout e;
    public BdTypeRecyclerView f;
    public w35 g;
    public PbListView h;
    public md8 i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        public a(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.f != null) {
                    this.a.f.stopScroll();
                }
                if ((this.a.h == null && this.a.a == null && this.a.b == null) || !BdNetTypeUtil.isNetWorkAvailable()) {
                    return;
                }
                this.a.h.O(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.a.h.E(null);
                if (this.a.b.hasMore()) {
                    this.a.h.Q();
                    this.a.b.b();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd8 a;

        public b(rd8 rd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd8Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f != null) {
                    this.a.f.stopScroll();
                }
                this.a.C();
            }
        }
    }

    public rd8(NearbyFriendsActivity nearbyFriendsActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nearbyFriendsActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = nearbyFriendsActivity;
    }

    @Override // com.baidu.tieba.qd8
    public void c(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (bdSwipeRefreshLayout = this.e) != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    @Override // com.baidu.tieba.v35.g
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.b.refresh();
        }
    }

    @Override // com.baidu.tieba.qd8
    public void h(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) != null) || (pbListView = this.h) == null) {
            return;
        }
        pbListView.F(str);
        this.h.E(w());
    }

    @Override // com.baidu.tieba.qd8
    public void m(int i) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (bdSwipeRefreshLayout = this.e) != null) {
            bdSwipeRefreshLayout.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.qd8
    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            C();
        }
    }

    @Override // com.baidu.tieba.qd8
    public void o(pd8 pd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pd8Var) == null) {
            this.b = pd8Var;
        }
    }

    @Override // com.baidu.tieba.qd8
    public void q(String str) {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, str) == null) && (nearbyFriendsActivity = this.a) != null && (frameLayout = this.d) != null) {
            nearbyFriendsActivity.showNetRefreshView(frameLayout, str, false);
        }
    }

    public final void A() {
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (nearbyFriendsActivity = this.a) != null && this.e != null) {
            w35 w35Var = new w35(nearbyFriendsActivity.getPageContext());
            this.g = w35Var;
            w35Var.f(this);
            this.e.setProgressView(this.g);
        }
    }

    @Override // com.baidu.tieba.qd8
    public void a() {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (nearbyFriendsActivity = this.a) != null && (frameLayout = this.d) != null) {
            nearbyFriendsActivity.showLoadingView(frameLayout);
        }
    }

    @Override // com.baidu.tieba.qd8
    public void d() {
        pd8 pd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (pd8Var = this.b) != null && this.a != null) {
            pd8Var.reload();
        }
    }

    @Override // com.baidu.tieba.qd8
    public void k() {
        md8 md8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (md8Var = this.i) != null) {
            md8Var.D(false);
        }
    }

    @Override // com.baidu.tieba.qd8
    public void l() {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (nearbyFriendsActivity = this.a) != null && (frameLayout = this.d) != null) {
            nearbyFriendsActivity.hideLoadingView(frameLayout);
        }
    }

    @Override // com.baidu.tieba.qd8
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            w35 w35Var = this.g;
            if (w35Var != null) {
                w35Var.f(null);
            }
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.E(null);
            }
            this.a = null;
        }
    }

    @Override // com.baidu.tieba.qd8
    public void p() {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (nearbyFriendsActivity = this.a) != null && (frameLayout = this.d) != null) {
            nearbyFriendsActivity.hideNetRefreshView(frameLayout);
        }
    }

    public final View.OnClickListener w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return new a(this);
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public final BdListView.p x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return new b(this);
        }
        return (BdListView.p) invokeV.objValue;
    }

    public final void z() {
        NearbyFriendsActivity nearbyFriendsActivity;
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (nearbyFriendsActivity = this.a) != null && (navigationBar = this.c) != null) {
            navigationBar.setCenterTextTitle(nearbyFriendsActivity.getString(R.string.obfuscated_res_0x7f0f0d11));
            this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    public final void B() {
        BdTypeRecyclerView bdTypeRecyclerView;
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeRecyclerView = this.f) != null && (nearbyFriendsActivity = this.a) != null) {
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(nearbyFriendsActivity));
            this.f.setFadingEdgeLength(0);
            this.f.setOverScrollMode(2);
            this.f.setOnSrollToBottomListener(x());
            ArrayList arrayList = new ArrayList();
            md8 md8Var = new md8(this.a, qa5.l, 2);
            this.i = md8Var;
            arrayList.add(md8Var);
            this.f.addAdapters(arrayList);
        }
    }

    @Override // com.baidu.tieba.qd8
    public void onCreate() {
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || (nearbyFriendsActivity = this.a) == null) {
            return;
        }
        this.c = (NavigationBar) nearbyFriendsActivity.findViewById(R.id.navigation_bar);
        this.d = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090772);
        this.e = (BdSwipeRefreshLayout) this.a.findViewById(R.id.refresh_layout);
        this.f = (BdTypeRecyclerView) this.a.findViewById(R.id.obfuscated_res_0x7f0917f3);
        z();
        B();
        A();
        y();
        this.b.reload();
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.h != null && this.b != null && this.a != null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.f.setNextPage(null);
                return;
            }
            this.f.setNextPage(this.h);
            this.h.O(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.h.E(null);
            if (this.b.hasMore()) {
                this.h.s(false);
                this.h.Q();
                this.b.b();
                return;
            }
            this.h.s(true);
            this.h.F(this.a.getString(R.string.obfuscated_res_0x7f0f0d16));
            this.h.g();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || this.a == null) {
            return;
        }
        PbListView pbListView = new PbListView(this.a);
        this.h = pbListView;
        pbListView.c();
        this.h.r(R.color.transparent);
        this.h.v(hi.g(this.a, R.dimen.tbds182));
        this.h.A();
        this.h.J(R.dimen.tbfontsize36);
        this.h.H(SkinManager.getColor(R.color.CAM_X0107));
        this.h.D(R.color.CAM_X0110);
        this.h.u();
        this.h.E(w());
    }

    @Override // com.baidu.tieba.qd8
    public void e(boolean z, List<gn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048582, this, z, list) == null) && this.f != null && list != null) {
            md8 md8Var = this.i;
            if (md8Var != null) {
                md8Var.D(z);
            }
            this.f.setData(list);
        }
    }

    @Override // com.baidu.tieba.qd8
    public void i(int i) {
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048585, this, i) != null) || (nearbyFriendsActivity = this.a) == null) {
            return;
        }
        NavigationBar navigationBar = this.c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(nearbyFriendsActivity.getPageContext(), i);
        }
        w35 w35Var = this.g;
        if (w35Var != null) {
            w35Var.H(i);
        }
        PbListView pbListView = this.h;
        if (pbListView != null) {
            pbListView.H(SkinManager.getColor(R.color.CAM_X0107));
            this.h.e(i);
        }
    }
}
