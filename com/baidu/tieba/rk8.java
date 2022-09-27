package com.baidu.tieba;

import android.view.View;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.square.square.SquareActivity;
import com.baidu.tieba.yx4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class rk8 extends p9<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<Object> a;
    public View b;
    public BdListView c;
    public NoNetworkView d;
    public zx4 e;
    public ok8 f;
    public NoDataView g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public rk8(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view2, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view2, onKeyListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, view2, onKeyListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (View) objArr2[1], (View.OnKeyListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e.b0(bdUniqueId);
    }

    public void j(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.d.a(bVar);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.A(0L);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.setVisibility(0);
        }
    }

    public void m(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048579, this, z, str) == null) {
            k();
            if (z || str == null) {
                return;
            }
            this.a.showToast(str, true);
        }
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public void o() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (noDataView = this.g) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.c.removeHeaderView(this.g);
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.a.getLayoutMode().l(i == 1);
            this.a.getLayoutMode().k(this.b);
            this.f.h(i);
            this.e.H(i);
            this.d.d(this.mContext, i);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.d.setVisibility(8);
        }
    }

    public void q(pk8 pk8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pk8Var) == null) || pk8Var == null) {
            return;
        }
        try {
            if (pk8Var.g()) {
                return;
            }
            this.f.i(pk8Var);
            this.f.notifyDataSetChanged();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void r(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.d.e(bVar);
        }
    }

    public void s(yx4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.e.f(gVar);
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (this.g == null) {
                this.g = NoDataViewFactory.a(this.a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070283)), NoDataViewFactory.e.a(i), null);
            }
            this.g.setTextOption(NoDataViewFactory.e.a(i));
            this.g.f(this.a, TbadkCoreApplication.getInst().getSkinType());
            this.g.setVisibility(0);
            this.c.removeHeaderView(this.g);
            this.c.addHeaderView(this.g);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rk8(TbPageContext<Object> tbPageContext, View view2, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, onKeyListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.c = null;
        this.e = null;
        this.f = null;
        this.a = tbPageContext;
        this.b = view2;
        BdListView bdListView = (BdListView) view2.findViewById(R.id.obfuscated_res_0x7f091f56);
        this.c = bdListView;
        bdListView.setOnKeyListener(onKeyListener);
        if (this.a.getOrignalPage() instanceof SquareActivity) {
            this.c.setOnItemClickListener((SquareActivity) this.a.getOrignalPage());
        }
        ok8 ok8Var = new ok8(tbPageContext);
        this.f = ok8Var;
        this.c.setAdapter((ListAdapter) ok8Var);
        zx4 zx4Var = new zx4(tbPageContext);
        this.e = zx4Var;
        this.c.setPullRefresh(zx4Var);
        this.d = (NoNetworkView) this.b.findViewById(R.id.obfuscated_res_0x7f0925c6);
    }
}
