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
import com.baidu.tieba.sa5;
import com.baidu.tieba.square.square.SquareActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class s9a extends j9<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<Object> a;
    public View b;
    public BdListView c;
    public NoNetworkView d;
    public ta5 e;
    public p9a f;
    public NoDataView g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s9a(TbPageContext<Object> tbPageContext, View view2, View.OnKeyListener onKeyListener) {
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
                super((l9) newInitContext.callArgs[0]);
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
        BdListView bdListView = (BdListView) view2.findViewById(R.id.obfuscated_res_0x7f09226b);
        this.c = bdListView;
        bdListView.setOnKeyListener(onKeyListener);
        if (this.a.getOrignalPage() instanceof SquareActivity) {
            this.c.setOnItemClickListener((SquareActivity) this.a.getOrignalPage());
        }
        p9a p9aVar = new p9a(tbPageContext);
        this.f = p9aVar;
        this.c.setAdapter((ListAdapter) p9aVar);
        ta5 ta5Var = new ta5(tbPageContext);
        this.e = ta5Var;
        this.c.setPullRefresh(ta5Var);
        this.d = (NoNetworkView) this.b.findViewById(R.id.view_no_network);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s9a(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view2, View.OnKeyListener onKeyListener) {
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
        this.e.a0(bdUniqueId);
    }

    public void B(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
            y();
            if (!z && str != null) {
                this.a.showToast(str, true);
            }
        }
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void D() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (noDataView = this.g) != null) {
            noDataView.setVisibility(8);
            this.c.removeHeaderView(this.g);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d.setVisibility(8);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.c.z(0L);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.d.setVisibility(0);
        }
    }

    public void F(q9a q9aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, q9aVar) == null) && q9aVar != null) {
            try {
                if (!q9aVar.g()) {
                    this.f.i(q9aVar);
                    this.f.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void G(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.d.e(bVar);
        }
    }

    public void H(sa5.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gVar) == null) {
            this.e.f(gVar);
        }
    }

    public void x(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.d.a(bVar);
        }
    }

    public void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            if (this.g == null) {
                this.g = NoDataViewFactory.a(this.a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0703a1)), NoDataViewFactory.e.a(i), null);
            }
            this.g.setTextOption(NoDataViewFactory.e.a(i));
            this.g.f(this.a, TbadkCoreApplication.getInst().getSkinType());
            this.g.setVisibility(0);
            this.c.removeHeaderView(this.g);
            this.c.addHeaderView(this.g);
        }
    }

    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            q05 layoutMode = this.a.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(this.b);
            this.f.h(i);
            this.e.H(i);
            this.d.d(this.mContext, i);
        }
    }
}
