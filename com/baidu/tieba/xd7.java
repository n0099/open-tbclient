package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gn7 a;

    public xd7(TbPageContext tbPageContext, gn7 gn7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, gn7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = gn7Var;
    }

    public void a(c46 c46Var) {
        gn7 gn7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, c46Var) == null) && (gn7Var = this.a) != null && gn7Var.V0() != null && this.a.V0().C0() != null && this.a.y1() != null && c46Var != null && this.a.y1().g0() != null && this.a.x0() != null) {
            BdTypeRecyclerView g0 = this.a.y1().g0();
            int i = c46Var.a;
            if (i != 2) {
                if (i != 3 || c46Var.a() == null) {
                    return;
                }
                g0.removeHeaderView(c46Var.a());
                this.a.x0().z0(0);
            } else if (c46Var.a() == null) {
            } else {
                g0.removeHeaderView(c46Var.a());
                g0.addHeaderView(c46Var.a(), g0.getHeaderViewsCount() - 1);
                this.a.x0().z0(8);
            }
        }
    }
}
