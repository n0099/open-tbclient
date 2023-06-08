package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wm7 a;

    public nd7(TbPageContext tbPageContext, wm7 wm7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, wm7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = wm7Var;
    }

    public void a(s36 s36Var) {
        wm7 wm7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, s36Var) == null) && (wm7Var = this.a) != null && wm7Var.V0() != null && this.a.V0().C0() != null && this.a.y1() != null && s36Var != null && this.a.y1().g0() != null && this.a.x0() != null) {
            BdTypeRecyclerView g0 = this.a.y1().g0();
            int i = s36Var.a;
            if (i != 2) {
                if (i != 3 || s36Var.a() == null) {
                    return;
                }
                g0.removeHeaderView(s36Var.a());
                this.a.x0().y0(0);
            } else if (s36Var.a() == null) {
            } else {
                g0.removeHeaderView(s36Var.a());
                g0.addHeaderView(s36Var.a(), g0.getHeaderViewsCount() - 1);
                this.a.x0().y0(8);
            }
        }
    }
}
