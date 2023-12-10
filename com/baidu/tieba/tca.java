package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class tca {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public View c;
    public PbListView d;
    public uaa e;
    public PersonCenterTabBaseFragment f;
    public NoDataView g;
    public np5 h;
    public int i;

    /* loaded from: classes8.dex */
    public class a extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
        public a(tca tcaVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tcaVar, context};
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
        }
    }

    /* loaded from: classes8.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tca a;

        public b(tca tcaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tcaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tcaVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (this.a.h == null) {
                    this.a.h = new np5();
                    this.a.h.a(this.a.i);
                }
                if (i == 0) {
                    this.a.h.e();
                } else {
                    this.a.h.d();
                }
            }
        }
    }

    public tca(TbPageContext tbPageContext, View view2, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, personCenterTabBaseFragment};
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
        this.i = 1010;
        this.a = tbPageContext;
        this.c = view2;
        this.f = personCenterTabBaseFragment;
        h();
    }

    public void d(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            this.b.addHeaderView(view2);
        }
    }

    public void l(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) {
            this.b.setOnSrollToBottomListener(pVar);
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.i = i;
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.b.setNextPage(this.d);
            this.d.P(0);
            this.d.g();
            this.d.H(this.a.getString(i));
        }
    }

    public uaa e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (uaa) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.setNextPage(null);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            np5 np5Var = this.h;
            if (np5Var != null) {
                np5Var.c();
            }
            this.b.setOnSrollToBottomListener(null);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.smoothScrollToPosition(0);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.b.setNextPage(this.d);
            this.d.P(0);
            this.d.U();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.b.setNextPage(this.d);
            this.d.P(0);
            this.d.g();
            this.d.H(this.a.getString(R.string.list_no_more));
        }
    }

    public final void h() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f091a28);
            this.b = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new a(this, bdTypeRecyclerView.getContext()));
            this.b.addOnScrollListener(new b(this));
            PbListView pbListView = new PbListView(this.a.getPageActivity());
            this.d = pbListView;
            pbListView.a();
            this.d.s(R.color.CAM_X0205);
            this.d.w(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds182));
            this.d.B();
            this.d.L(R.dimen.tbfontsize33);
            this.d.J(SkinManager.getColor(R.color.CAM_X0107));
            this.d.F(R.color.CAM_X0110);
            uaa uaaVar = new uaa(this.a, this.b, this.f.getUniqueId());
            this.e = uaaVar;
            uaaVar.d(this.f.I2());
            this.e.h(32);
            if (this.f.I2()) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f;
                if (personCenterTabBaseFragment instanceof PersonCenterDynamicTabFragment) {
                    i = 4;
                } else if (personCenterTabBaseFragment instanceof PersonCenterThreadTabFragment) {
                    i = 6;
                }
                this.e.f(i);
                this.e.g(this.f.H2());
            }
            i = 0;
            this.e.f(i);
            this.e.g(this.f.H2());
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            SkinManager.setBackgroundResource(this.c, R.color.CAM_X0201);
            uaa uaaVar = this.e;
            if (uaaVar != null) {
                uaaVar.b();
            }
            NoDataView noDataView = this.g;
            if (noDataView != null) {
                noDataView.f(this.a, i);
            }
            PbListView pbListView = this.d;
            if (pbListView != null) {
                pbListView.J(SkinManager.getColor(R.color.CAM_X0107));
                this.d.e(i);
            }
        }
    }

    public void n(List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                g();
                if (this.b.getHeaderViewsCount() == 0) {
                    p(R.string.obfuscated_res_0x7f0f10a2);
                }
            } else {
                NoDataView noDataView = this.g;
                if (noDataView != null && noDataView.getParent() != null) {
                    this.b.removeHeaderView(this.g);
                }
            }
            this.b.setData(list);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.f.H2())));
        }
    }

    public final void p(int i) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            if (this.f.H2() == 1) {
                string = this.f.getResources().getString(R.string.obfuscated_res_0x7f0f10a0);
            } else {
                string = this.f.getResources().getString(R.string.obfuscated_res_0x7f0f10a1);
            }
            if (this.g == null) {
                this.g = NoDataViewFactory.a(this.a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070387)), NoDataViewFactory.e.d(null, string), null);
            }
            this.g.f(this.a, TbadkApplication.getInst().getSkinType());
            this.g.setVisibility(0);
            this.b.removeHeaderView(this.g);
            this.g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.b.addHeaderView(this.g);
        }
    }
}
