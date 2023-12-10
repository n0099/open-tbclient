package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ms7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g28 a;

    public ms7(TbPageContext tbPageContext, g28 g28Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, g28Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = g28Var;
    }

    public void a(r06 r06Var) {
        g28 g28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, r06Var) == null) && (g28Var = this.a) != null && g28Var.J1() != null && this.a.J1().w0() != null && this.a.u2() != null && r06Var != null && this.a.u2().g0() != null && this.a.c1() != null) {
            BdTypeRecyclerView g0 = this.a.u2().g0();
            int i = r06Var.a;
            if (i != 2) {
                if (i != 3 || r06Var.a() == null) {
                    return;
                }
                g0.removeHeaderView(r06Var.a());
                this.a.c1().A0(0);
            } else if (r06Var.a() == null) {
            } else {
                g0.removeHeaderView(r06Var.a());
                g0.addHeaderView(r06Var.a(), g0.getHeaderViewsCount() - 1);
                this.a.c1().A0(8);
            }
        }
    }
}
