package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class u67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dg7 a;

    public u67(TbPageContext tbPageContext, dg7 dg7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, dg7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = dg7Var;
    }

    public void a(dy5 dy5Var) {
        dg7 dg7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, dy5Var) == null) && (dg7Var = this.a) != null && dg7Var.T0() != null && this.a.T0().D0() != null && this.a.w1() != null && dy5Var != null && this.a.w1().g0() != null && this.a.w0() != null) {
            BdTypeRecyclerView g0 = this.a.w1().g0();
            int i = dy5Var.a;
            if (i != 2) {
                if (i != 3 || dy5Var.a() == null) {
                    return;
                }
                g0.removeHeaderView(dy5Var.a());
                this.a.w0().x0(0);
            } else if (dy5Var.a() == null) {
            } else {
                g0.removeHeaderView(dy5Var.a());
                g0.addHeaderView(dy5Var.a(), g0.getHeaderViewsCount() - 1);
                this.a.w0().x0(8);
            }
        }
    }
}
