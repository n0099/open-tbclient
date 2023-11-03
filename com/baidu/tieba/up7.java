package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class up7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pz7 a;

    public up7(TbPageContext tbPageContext, pz7 pz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, pz7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pz7Var;
    }

    public void a(f06 f06Var) {
        pz7 pz7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, f06Var) == null) && (pz7Var = this.a) != null && pz7Var.y1() != null && this.a.y1().w0() != null && this.a.i2() != null && f06Var != null && this.a.i2().g0() != null && this.a.W0() != null) {
            BdTypeRecyclerView g0 = this.a.i2().g0();
            int i = f06Var.a;
            if (i != 2) {
                if (i != 3 || f06Var.a() == null) {
                    return;
                }
                g0.removeHeaderView(f06Var.a());
                this.a.W0().A0(0);
            } else if (f06Var.a() == null) {
            } else {
                g0.removeHeaderView(f06Var.a());
                g0.addHeaderView(f06Var.a(), g0.getHeaderViewsCount() - 1);
                this.a.W0().A0(8);
            }
        }
    }
}
