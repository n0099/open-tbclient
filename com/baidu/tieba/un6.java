package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class un6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xw6 a;

    public un6(TbPageContext tbPageContext, xw6 xw6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, xw6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = xw6Var;
    }

    public void a(oq5 oq5Var) {
        xw6 xw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, oq5Var) == null) && (xw6Var = this.a) != null && xw6Var.P0() != null && this.a.P0().o0() != null && this.a.u1() != null && oq5Var != null && this.a.u1().g0() != null && this.a.s0() != null) {
            BdTypeRecyclerView g0 = this.a.u1().g0();
            int i = oq5Var.a;
            if (i != 2) {
                if (i != 3 || oq5Var.a() == null) {
                    return;
                }
                g0.removeHeaderView(oq5Var.a());
                this.a.s0().f0(0);
            } else if (oq5Var.a() == null) {
            } else {
                g0.removeHeaderView(oq5Var.a());
                g0.t(oq5Var.a(), g0.getHeaderViewsCount() - 1);
                this.a.s0().f0(8);
            }
        }
    }
}
