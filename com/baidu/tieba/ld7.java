package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ld7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public um7 a;

    public ld7(TbPageContext tbPageContext, um7 um7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, um7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = um7Var;
    }

    public void a(q36 q36Var) {
        um7 um7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, q36Var) == null) && (um7Var = this.a) != null && um7Var.V0() != null && this.a.V0().C0() != null && this.a.y1() != null && q36Var != null && this.a.y1().g0() != null && this.a.x0() != null) {
            BdTypeRecyclerView g0 = this.a.y1().g0();
            int i = q36Var.a;
            if (i != 2) {
                if (i != 3 || q36Var.a() == null) {
                    return;
                }
                g0.removeHeaderView(q36Var.a());
                this.a.x0().y0(0);
            } else if (q36Var.a() == null) {
            } else {
                g0.removeHeaderView(q36Var.a());
                g0.addHeaderView(q36Var.a(), g0.getHeaderViewsCount() - 1);
                this.a.x0().y0(8);
            }
        }
    }
}
