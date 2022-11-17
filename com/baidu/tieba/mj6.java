package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class mj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ms6 a;

    public mj6(TbPageContext tbPageContext, ms6 ms6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ms6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ms6Var;
    }

    public void a(zo5 zo5Var) {
        ms6 ms6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, zo5Var) == null) && (ms6Var = this.a) != null && ms6Var.J0() != null && this.a.J0().h0() != null && this.a.j1() != null && zo5Var != null && this.a.j1().e0() != null && this.a.n0() != null) {
            BdTypeRecyclerView e0 = this.a.j1().e0();
            int i = zo5Var.a;
            if (i != 2) {
                if (i != 3 || zo5Var.a() == null) {
                    return;
                }
                e0.removeHeaderView(zo5Var.a());
                this.a.n0().h0(0);
            } else if (zo5Var.a() == null) {
            } else {
                e0.removeHeaderView(zo5Var.a());
                e0.t(zo5Var.a(), e0.getHeaderViewsCount() - 1);
                this.a.n0().h0(8);
            }
        }
    }
}
