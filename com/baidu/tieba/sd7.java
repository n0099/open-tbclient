package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class sd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bn7 a;

    public sd7(TbPageContext tbPageContext, bn7 bn7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bn7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bn7Var;
    }

    public void a(x36 x36Var) {
        bn7 bn7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, x36Var) == null) && (bn7Var = this.a) != null && bn7Var.V0() != null && this.a.V0().C0() != null && this.a.y1() != null && x36Var != null && this.a.y1().g0() != null && this.a.x0() != null) {
            BdTypeRecyclerView g0 = this.a.y1().g0();
            int i = x36Var.a;
            if (i != 2) {
                if (i != 3 || x36Var.a() == null) {
                    return;
                }
                g0.removeHeaderView(x36Var.a());
                this.a.x0().y0(0);
            } else if (x36Var.a() == null) {
            } else {
                g0.removeHeaderView(x36Var.a());
                g0.addHeaderView(x36Var.a(), g0.getHeaderViewsCount() - 1);
                this.a.x0().y0(8);
            }
        }
    }
}
