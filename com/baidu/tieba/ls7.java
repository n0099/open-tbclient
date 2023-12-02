package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ls7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f28 a;

    public ls7(TbPageContext tbPageContext, f28 f28Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, f28Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = f28Var;
    }

    public void a(r06 r06Var) {
        f28 f28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, r06Var) == null) && (f28Var = this.a) != null && f28Var.J1() != null && this.a.J1().w0() != null && this.a.u2() != null && r06Var != null && this.a.u2().g0() != null && this.a.c1() != null) {
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
