package com.baidu.tieba;

import android.view.View;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.p55;
import com.baidu.tieba.square.square.SquareActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ita extends BdBaseView<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<Object> a;
    public View b;
    public BdListView c;
    public NoNetworkView d;
    public q55 e;
    public fta f;
    public NoDataView g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ita(TbPageContext<Object> tbPageContext, View view2, View.OnKeyListener onKeyListener) {
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
                super((BdPageContext) newInitContext.callArgs[0]);
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
        BdListView bdListView = (BdListView) view2.findViewById(R.id.obfuscated_res_0x7f09239f);
        this.c = bdListView;
        bdListView.setOnKeyListener(onKeyListener);
        if (this.a.getOrignalPage() instanceof SquareActivity) {
            this.c.setOnItemClickListener((SquareActivity) this.a.getOrignalPage());
        }
        fta ftaVar = new fta(tbPageContext);
        this.f = ftaVar;
        this.c.setAdapter((ListAdapter) ftaVar);
        q55 q55Var = new q55(tbPageContext);
        this.e = q55Var;
        this.c.setPullRefresh(q55Var);
        this.d = (NoNetworkView) this.b.findViewById(R.id.view_no_network);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ita(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view2, View.OnKeyListener onKeyListener) {
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
        this.e.W(bdUniqueId);
    }

    public View A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void C() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (noDataView = this.g) != null) {
            noDataView.setVisibility(8);
            this.c.removeHeaderView(this.g);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.setVisibility(8);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.c.z(0L);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.d.setVisibility(0);
        }
    }

    public void E(gta gtaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, gtaVar) == null) && gtaVar != null) {
            try {
                if (!gtaVar.g()) {
                    this.f.i(gtaVar);
                    this.f.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void F(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.d.removeNetworkChangeListener(bVar);
        }
    }

    public void G(p55.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.e.a(gVar);
        }
    }

    public void g(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.d.addNetworkChangeListener(bVar);
        }
    }

    public void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (this.g == null) {
                this.g = NoDataViewFactory.a(this.a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0703a2)), NoDataViewFactory.e.a(i), null);
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
            BDLayoutMode layoutMode = this.a.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.a.getLayoutMode().onModeChanged(this.b);
            this.f.h(i);
            this.e.D(i);
            this.d.onChangeSkinType(this.mContext, i);
        }
    }

    public void z(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048587, this, z, str) == null) {
            x();
            if (!z && str != null) {
                this.a.showToast(str, true);
            }
        }
    }
}
