package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ki7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cs7 a;

    public ki7(TbPageContext tbPageContext, cs7 cs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cs7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cs7Var;
    }

    public void a(b46 b46Var) {
        cs7 cs7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, b46Var) == null) && (cs7Var = this.a) != null && cs7Var.f1() != null && this.a.f1().u0() != null && this.a.N1() != null && b46Var != null && this.a.N1().g0() != null && this.a.G0() != null) {
            BdTypeRecyclerView g0 = this.a.N1().g0();
            int i = b46Var.a;
            if (i != 2) {
                if (i != 3 || b46Var.a() == null) {
                    return;
                }
                g0.removeHeaderView(b46Var.a());
                this.a.G0().z0(0);
            } else if (b46Var.a() == null) {
            } else {
                g0.removeHeaderView(b46Var.a());
                g0.addHeaderView(b46Var.a(), g0.getHeaderViewsCount() - 1);
                this.a.G0().z0(8);
            }
        }
    }
}
