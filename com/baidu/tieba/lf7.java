package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class lf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xo7 a;

    public lf7(TbPageContext tbPageContext, xo7 xo7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, xo7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = xo7Var;
    }

    public void a(n26 n26Var) {
        xo7 xo7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, n26Var) == null) && (xo7Var = this.a) != null && xo7Var.W0() != null && this.a.W0().v0() != null && this.a.z1() != null && n26Var != null && this.a.z1().g0() != null && this.a.y0() != null) {
            BdTypeRecyclerView g0 = this.a.z1().g0();
            int i = n26Var.a;
            if (i != 2) {
                if (i != 3 || n26Var.a() == null) {
                    return;
                }
                g0.removeHeaderView(n26Var.a());
                this.a.y0().B0(0);
            } else if (n26Var.a() == null) {
            } else {
                g0.removeHeaderView(n26Var.a());
                g0.addHeaderView(n26Var.a(), g0.getHeaderViewsCount() - 1);
                this.a.y0().B0(8);
            }
        }
    }
}
