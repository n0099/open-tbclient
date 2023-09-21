package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ui7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ms7 a;

    public ui7(TbPageContext tbPageContext, ms7 ms7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ms7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ms7Var;
    }

    public void a(c46 c46Var) {
        ms7 ms7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, c46Var) == null) && (ms7Var = this.a) != null && ms7Var.m1() != null && this.a.m1().u0() != null && this.a.R1() != null && c46Var != null && this.a.R1().g0() != null && this.a.O0() != null) {
            BdTypeRecyclerView g0 = this.a.R1().g0();
            int i = c46Var.a;
            if (i != 2) {
                if (i != 3 || c46Var.a() == null) {
                    return;
                }
                g0.removeHeaderView(c46Var.a());
                this.a.O0().w0(0);
            } else if (c46Var.a() == null) {
            } else {
                g0.removeHeaderView(c46Var.a());
                g0.addHeaderView(c46Var.a(), g0.getHeaderViewsCount() - 1);
                this.a.O0().w0(8);
            }
        }
    }
}
