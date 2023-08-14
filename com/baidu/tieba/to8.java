package com.baidu.tieba;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.i95;
import com.baidu.tieba.immessagecenter.mention.base.DeviderLineDecoration;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class to8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public NavigationBar c;
    public NoNetworkView d;
    public RelativeLayout e;
    public BdSwipeRefreshLayout f;
    public BdTypeRecyclerView g;
    public j95 h;
    public PbListView i;
    public NoDataView j;
    public boolean k;
    public cp8 l;
    public e m;
    public View.OnClickListener n;
    public final i95.g o;

    /* loaded from: classes8.dex */
    public interface e {
        void a();

        void b();
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ to8 a;

        public a(to8 to8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {to8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = to8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.i != null && this.a.m != null) {
                this.a.i.P(0);
                this.a.i.G(null);
                this.a.i.U();
                this.a.m.b();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements i95.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ to8 a;

        public b(to8 to8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {to8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = to8Var;
        }

        @Override // com.baidu.tieba.i95.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    if (this.a.m != null) {
                        this.a.m.a();
                        return;
                    }
                    return;
                }
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.a.f;
                if (bdSwipeRefreshLayout != null) {
                    bdSwipeRefreshLayout.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(to8 to8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {to8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view2 = viewHolder.itemView;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ to8 a;

        public d(to8 to8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {to8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = to8Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.i != null && this.a.m != null) {
                this.a.i.P(0);
                this.a.i.G(null);
                this.a.i.R();
                this.a.m.b();
            }
        }
    }

    public to8(TbPageContext tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new a(this);
        this.o = new b(this);
        this.a = tbPageContext;
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f090166);
        g(tbPageContext);
        this.l = new cp8(tbPageContext, this.g);
    }

    public void i(in inVar) {
        cp8 cp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, inVar) == null) && (cp8Var = this.l) != null) {
            cp8Var.e(inVar);
        }
    }

    public void j(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.m = eVar;
        }
    }

    public void l(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (bdSwipeRefreshLayout = this.f) != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            j95 j95Var = this.h;
            if (j95Var != null) {
                j95Var.C(i);
            }
            NoNetworkView noNetworkView = this.d;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.a, i);
            }
            PbListView pbListView = this.i;
            if (pbListView != null) {
                pbListView.J(SkinManager.getColor(R.color.CAM_X0109));
                this.i.e(i);
            }
            NoDataView noDataView = this.j;
            if (noDataView != null) {
                noDataView.f(this.a, i);
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            }
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a, i);
            }
            cp8 cp8Var = this.l;
            if (cp8Var != null) {
                cp8Var.c();
            }
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
        }
    }

    public RelativeLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public List<ym> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.g;
            if (bdTypeRecyclerView == null) {
                return null;
            }
            return bdTypeRecyclerView.getData();
        }
        return (List) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            cp8 cp8Var = this.l;
            if (cp8Var != null) {
                cp8Var.d();
            }
            j95 j95Var = this.h;
            if (j95Var != null) {
                j95Var.T();
            }
        }
    }

    public final void g(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, tbPageContext) != null) || this.b == null) {
            return;
        }
        if (this.h == null) {
            j95 j95Var = new j95(tbPageContext);
            this.h = j95Var;
            j95Var.a(this.o);
        }
        this.h.V(tbPageContext.getUniqueId());
        if (this.i == null) {
            PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
            this.i = pbListView;
            pbListView.c();
        }
        this.i.s(R.color.CAM_X0205);
        this.i.w(BdUtilHelper.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
        this.i.B();
        this.i.L(R.dimen.tbfontsize33);
        this.i.J(SkinManager.getColor(R.color.CAM_X0109));
        this.i.F(R.color.CAM_X0110);
        this.i.G(this.n);
        NoNetworkView noNetworkView = (NoNetworkView) this.b.findViewById(R.id.obfuscated_res_0x7f091965);
        this.d = noNetworkView;
        noNetworkView.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        this.e = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0907b1);
        NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.view_navigation_bar);
        this.c = navigationBar;
        navigationBar.showBottomLine();
        this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f010e));
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090168);
        this.f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.h);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.b.findViewById(R.id.obfuscated_res_0x7f090169);
        this.g = bdTypeRecyclerView;
        ((DefaultItemAnimator) bdTypeRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.g.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
        this.g.setFadingEdgeLength(0);
        this.g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
        this.g.setOverScrollMode(2);
        this.g.addItemDecoration(new DeviderLineDecoration());
        this.g.setRecyclerListener(new c(this));
        this.g.setOnSrollToBottomListener(new d(this));
    }

    public void k(boolean z, ArrayList<ym> arrayList) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, arrayList) == null) && (bdSwipeRefreshLayout = this.f) != null && this.i != null && this.g != null && this.l != null) {
            bdSwipeRefreshLayout.setRefreshing(false);
            if (z) {
                this.i.P(0);
                this.i.g();
                this.i.G(this.n);
            } else {
                this.i.P(0);
                this.i.g();
                this.i.H(this.a.getResources().getString(R.string.list_no_more));
                this.i.G(null);
            }
            if (ListUtils.isEmpty(arrayList)) {
                if (this.j == null) {
                    NoDataView a2 = NoDataViewFactory.a(this.a.getContext(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f010f)), null);
                    this.j = a2;
                    a2.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
                }
                if (this.j.getParent() == null && !this.k) {
                    this.k = true;
                    this.g.addHeaderView(this.j, 0);
                    this.j.setVisibility(0);
                    this.j.f(this.a, TbadkCoreApplication.getInst().getSkinType());
                }
                this.g.setNextPage(null);
                return;
            }
            this.g.removeHeaderView(this.j);
            this.k = false;
            this.g.setNextPage(this.i);
            this.l.f(arrayList);
            this.l.c();
        }
    }
}
