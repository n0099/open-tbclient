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
import com.baidu.tieba.x95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class pz8 implements oz8, x95.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NearbyFriendsActivity a;
    public nz8 b;
    public NavigationBar c;
    public FrameLayout d;
    public BdSwipeRefreshLayout e;
    public BdTypeRecyclerView f;
    public y95 g;
    public PbListView h;
    public kz8 i;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz8 a;

        public a(pz8 pz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pz8Var;
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
                this.a.h.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.a.h.G(null);
                if (this.a.b.hasMore()) {
                    this.a.h.R();
                    this.a.b.b();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz8 a;

        public b(pz8 pz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pz8Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f != null) {
                    this.a.f.stopScroll();
                }
                this.a.B();
            }
        }
    }

    public pz8(NearbyFriendsActivity nearbyFriendsActivity) {
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

    @Override // com.baidu.tieba.oz8
    public void c(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (bdSwipeRefreshLayout = this.e) != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    @Override // com.baidu.tieba.x95.g
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.b.refresh();
        }
    }

    @Override // com.baidu.tieba.oz8
    public void h(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, str) != null) || (pbListView = this.h) == null) {
            return;
        }
        pbListView.H(str);
        this.h.G(v());
    }

    @Override // com.baidu.tieba.oz8
    public void l(int i) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (bdSwipeRefreshLayout = this.e) != null) {
            bdSwipeRefreshLayout.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.oz8
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            B();
        }
    }

    @Override // com.baidu.tieba.oz8
    public void n(nz8 nz8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, nz8Var) == null) {
            this.b = nz8Var;
        }
    }

    @Override // com.baidu.tieba.oz8
    public void p(String str) {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && (nearbyFriendsActivity = this.a) != null && (frameLayout = this.d) != null) {
            nearbyFriendsActivity.showNetRefreshView(frameLayout, str, false);
        }
    }

    public final void A() {
        BdTypeRecyclerView bdTypeRecyclerView;
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bdTypeRecyclerView = this.f) != null && (nearbyFriendsActivity = this.a) != null) {
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(nearbyFriendsActivity));
            this.f.setFadingEdgeLength(0);
            this.f.setOverScrollMode(2);
            this.f.setOnSrollToBottomListener(w());
            ArrayList arrayList = new ArrayList();
            kz8 kz8Var = new kz8(this.a, dh5.l, 2);
            this.i = kz8Var;
            arrayList.add(kz8Var);
            this.f.addAdapters(arrayList);
        }
    }

    @Override // com.baidu.tieba.oz8
    public void onCreate() {
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || (nearbyFriendsActivity = this.a) == null) {
            return;
        }
        this.c = (NavigationBar) nearbyFriendsActivity.findViewById(R.id.navigation_bar);
        this.d = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09079f);
        this.e = (BdSwipeRefreshLayout) this.a.findViewById(R.id.refresh_layout);
        this.f = (BdTypeRecyclerView) this.a.findViewById(R.id.obfuscated_res_0x7f091876);
        y();
        A();
        z();
        x();
        this.b.reload();
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.h != null && this.b != null && this.a != null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.f.setNextPage(null);
                return;
            }
            this.f.setNextPage(this.h);
            this.h.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.h.G(null);
            if (this.b.hasMore()) {
                this.h.t(false);
                this.h.R();
                this.b.b();
                return;
            }
            this.h.t(true);
            this.h.H(this.a.getString(R.string.obfuscated_res_0x7f0f0dea));
            this.h.g();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || this.a == null) {
            return;
        }
        PbListView pbListView = new PbListView(this.a);
        this.h = pbListView;
        pbListView.c();
        this.h.s(R.color.transparent);
        this.h.w(wi.g(this.a, R.dimen.tbds182));
        this.h.B();
        this.h.L(R.dimen.tbfontsize36);
        this.h.J(SkinManager.getColor(R.color.CAM_X0107));
        this.h.F(R.color.CAM_X0110);
        this.h.v();
        this.h.G(v());
    }

    @Override // com.baidu.tieba.oz8
    public void a() {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (nearbyFriendsActivity = this.a) != null && (frameLayout = this.d) != null) {
            nearbyFriendsActivity.showLoadingView(frameLayout);
        }
    }

    @Override // com.baidu.tieba.oz8
    public void d() {
        nz8 nz8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (nz8Var = this.b) != null && this.a != null) {
            nz8Var.reload();
        }
    }

    @Override // com.baidu.tieba.oz8
    public void hideLoadingView() {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (nearbyFriendsActivity = this.a) != null && (frameLayout = this.d) != null) {
            nearbyFriendsActivity.hideLoadingView(frameLayout);
        }
    }

    @Override // com.baidu.tieba.oz8
    public void k() {
        kz8 kz8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (kz8Var = this.i) != null) {
            kz8Var.D(false);
        }
    }

    @Override // com.baidu.tieba.oz8
    public void o() {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (nearbyFriendsActivity = this.a) != null && (frameLayout = this.d) != null) {
            nearbyFriendsActivity.hideNetRefreshView(frameLayout);
        }
    }

    @Override // com.baidu.tieba.oz8
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            y95 y95Var = this.g;
            if (y95Var != null) {
                y95Var.f(null);
            }
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.G(null);
            }
            this.a = null;
        }
    }

    public final View.OnClickListener v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return new a(this);
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public final BdListView.p w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return new b(this);
        }
        return (BdListView.p) invokeV.objValue;
    }

    public final void y() {
        NearbyFriendsActivity nearbyFriendsActivity;
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (nearbyFriendsActivity = this.a) != null && (navigationBar = this.c) != null) {
            navigationBar.setCenterTextTitle(nearbyFriendsActivity.getString(R.string.obfuscated_res_0x7f0f0de5));
            this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    public final void z() {
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (nearbyFriendsActivity = this.a) != null && this.e != null) {
            y95 y95Var = new y95(nearbyFriendsActivity.getPageContext());
            this.g = y95Var;
            y95Var.f(this);
            this.e.setProgressView(this.g);
        }
    }

    @Override // com.baidu.tieba.oz8
    public void e(boolean z, List<wn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048581, this, z, list) == null) && this.f != null && list != null) {
            kz8 kz8Var = this.i;
            if (kz8Var != null) {
                kz8Var.D(z);
            }
            this.f.setData(list);
        }
    }

    @Override // com.baidu.tieba.oz8
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
        y95 y95Var = this.g;
        if (y95Var != null) {
            y95Var.H(i);
        }
        PbListView pbListView = this.h;
        if (pbListView != null) {
            pbListView.J(SkinManager.getColor(R.color.CAM_X0107));
            this.h.e(i);
        }
    }
}
