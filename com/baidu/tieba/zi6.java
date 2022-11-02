package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class zi6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zr6 a;

    public zi6(TbPageContext tbPageContext, zr6 zr6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, zr6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = zr6Var;
    }

    public void a(mo5 mo5Var) {
        zr6 zr6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, mo5Var) == null) && (zr6Var = this.a) != null && zr6Var.J0() != null && this.a.J0().g0() != null && this.a.j1() != null && mo5Var != null && this.a.j1().e0() != null && this.a.n0() != null) {
            BdTypeRecyclerView e0 = this.a.j1().e0();
            int i = mo5Var.a;
            if (i != 2) {
                if (i != 3 || mo5Var.a() == null) {
                    return;
                }
                e0.removeHeaderView(mo5Var.a());
                this.a.n0().h0(0);
            } else if (mo5Var.a() == null) {
            } else {
                e0.removeHeaderView(mo5Var.a());
                e0.t(mo5Var.a(), e0.getHeaderViewsCount() - 1);
                this.a.n0().h0(8);
            }
        }
    }
}
