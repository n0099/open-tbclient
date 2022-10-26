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
import com.baidu.tieba.ey4;
import com.baidu.tieba.nearby.NearbyFriendsActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class wq7 implements vq7, ey4.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NearbyFriendsActivity a;
    public uq7 b;
    public NavigationBar c;
    public FrameLayout d;
    public BdSwipeRefreshLayout e;
    public BdTypeRecyclerView f;
    public fy4 g;
    public PbListView h;
    public rq7 i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wq7 a;

        public a(wq7 wq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wq7Var;
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
                this.a.h.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.a.h.C(null);
                if (this.a.b.hasMore()) {
                    this.a.h.O();
                    this.a.b.b();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wq7 a;

        public b(wq7 wq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wq7Var;
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

    public wq7(NearbyFriendsActivity nearbyFriendsActivity) {
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

    @Override // com.baidu.tieba.vq7
    public void c(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (bdSwipeRefreshLayout = this.e) != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    @Override // com.baidu.tieba.ey4.g
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.b.refresh();
        }
    }

    @Override // com.baidu.tieba.vq7
    public void h(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) != null) || (pbListView = this.h) == null) {
            return;
        }
        pbListView.D(str);
        this.h.C(w());
    }

    @Override // com.baidu.tieba.vq7
    public void l(int i) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (bdSwipeRefreshLayout = this.e) != null) {
            bdSwipeRefreshLayout.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.vq7
    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            C();
        }
    }

    @Override // com.baidu.tieba.vq7
    public void o(uq7 uq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, uq7Var) == null) {
            this.b = uq7Var;
        }
    }

    @Override // com.baidu.tieba.vq7
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
            fy4 fy4Var = new fy4(nearbyFriendsActivity.getPageContext());
            this.g = fy4Var;
            fy4Var.f(this);
            this.e.setProgressView(this.g);
        }
    }

    @Override // com.baidu.tieba.vq7
    public void a() {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (nearbyFriendsActivity = this.a) != null && (frameLayout = this.d) != null) {
            nearbyFriendsActivity.showLoadingView(frameLayout);
        }
    }

    @Override // com.baidu.tieba.vq7
    public void d() {
        uq7 uq7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (uq7Var = this.b) != null && this.a != null) {
            uq7Var.reload();
        }
    }

    @Override // com.baidu.tieba.vq7
    public void k() {
        rq7 rq7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (rq7Var = this.i) != null) {
            rq7Var.B(false);
        }
    }

    @Override // com.baidu.tieba.vq7
    public void m() {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (nearbyFriendsActivity = this.a) != null && (frameLayout = this.d) != null) {
            nearbyFriendsActivity.hideLoadingView(frameLayout);
        }
    }

    @Override // com.baidu.tieba.vq7
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            fy4 fy4Var = this.g;
            if (fy4Var != null) {
                fy4Var.f(null);
            }
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.C(null);
            }
            this.a = null;
        }
    }

    @Override // com.baidu.tieba.vq7
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
            navigationBar.setCenterTextTitle(nearbyFriendsActivity.getString(R.string.obfuscated_res_0x7f0f0c59));
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
            rq7 rq7Var = new rq7(this.a, r45.l, 2);
            this.i = rq7Var;
            arrayList.add(rq7Var);
            this.f.a(arrayList);
        }
    }

    @Override // com.baidu.tieba.vq7
    public void onCreate() {
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || (nearbyFriendsActivity = this.a) == null) {
            return;
        }
        this.c = (NavigationBar) nearbyFriendsActivity.findViewById(R.id.obfuscated_res_0x7f091649);
        this.d = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0906e0);
        this.e = (BdSwipeRefreshLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091bbf);
        this.f = (BdTypeRecyclerView) this.a.findViewById(R.id.obfuscated_res_0x7f091660);
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
            this.h.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.h.C(null);
            if (this.b.hasMore()) {
                this.h.q(false);
                this.h.O();
                this.b.b();
                return;
            }
            this.h.q(true);
            this.h.D(this.a.getString(R.string.obfuscated_res_0x7f0f0c5e));
            this.h.f();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || this.a == null) {
            return;
        }
        PbListView pbListView = new PbListView(this.a);
        this.h = pbListView;
        pbListView.b();
        this.h.p(R.color.transparent);
        this.h.t(fj.f(this.a, R.dimen.tbds182));
        this.h.y();
        this.h.H(R.dimen.tbfontsize36);
        this.h.F(SkinManager.getColor(R.color.CAM_X0107));
        this.h.B(R.color.CAM_X0110);
        this.h.s();
        this.h.C(w());
    }

    @Override // com.baidu.tieba.vq7
    public void g(boolean z, List list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048583, this, z, list) == null) && this.f != null && list != null) {
            rq7 rq7Var = this.i;
            if (rq7Var != null) {
                rq7Var.B(z);
            }
            this.f.setData(list);
        }
    }

    @Override // com.baidu.tieba.vq7
    public void j(int i) {
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048585, this, i) != null) || (nearbyFriendsActivity = this.a) == null) {
            return;
        }
        NavigationBar navigationBar = this.c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(nearbyFriendsActivity.getPageContext(), i);
        }
        fy4 fy4Var = this.g;
        if (fy4Var != null) {
            fy4Var.H(i);
        }
        PbListView pbListView = this.h;
        if (pbListView != null) {
            pbListView.F(SkinManager.getColor(R.color.CAM_X0107));
            this.h.d(i);
        }
    }
}
