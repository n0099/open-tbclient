package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class vg6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vp6 a;

    public vg6(TbPageContext tbPageContext, vp6 vp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, vp6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = vp6Var;
    }

    public void a(tm5 tm5Var) {
        vp6 vp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tm5Var) == null) || (vp6Var = this.a) == null || vp6Var.J0() == null || this.a.J0().g0() == null || this.a.j1() == null || tm5Var == null || this.a.j1().d0() == null || this.a.n0() == null) {
            return;
        }
        BdTypeRecyclerView d0 = this.a.j1().d0();
        int i = tm5Var.a;
        if (i != 2) {
            if (i == 3 && tm5Var.a() != null) {
                d0.removeHeaderView(tm5Var.a());
                this.a.n0().h0(0);
            }
        } else if (tm5Var.a() == null) {
        } else {
            d0.removeHeaderView(tm5Var.a());
            d0.t(tm5Var.a(), d0.getHeaderViewsCount() - 1);
            this.a.n0().h0(8);
        }
    }
}
