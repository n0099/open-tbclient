package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yo7 a;

    public mf7(TbPageContext tbPageContext, yo7 yo7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, yo7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = yo7Var;
    }

    public void a(o26 o26Var) {
        yo7 yo7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, o26Var) == null) && (yo7Var = this.a) != null && yo7Var.W0() != null && this.a.W0().v0() != null && this.a.z1() != null && o26Var != null && this.a.z1().g0() != null && this.a.y0() != null) {
            BdTypeRecyclerView g0 = this.a.z1().g0();
            int i = o26Var.a;
            if (i != 2) {
                if (i != 3 || o26Var.a() == null) {
                    return;
                }
                g0.removeHeaderView(o26Var.a());
                this.a.y0().B0(0);
            } else if (o26Var.a() == null) {
            } else {
                g0.removeHeaderView(o26Var.a());
                g0.addHeaderView(o26Var.a(), g0.getHeaderViewsCount() - 1);
                this.a.y0().B0(8);
            }
        }
    }
}
