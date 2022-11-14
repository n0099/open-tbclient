package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class lj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ls6 a;

    public lj6(TbPageContext tbPageContext, ls6 ls6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ls6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ls6Var;
    }

    public void a(yo5 yo5Var) {
        ls6 ls6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, yo5Var) == null) && (ls6Var = this.a) != null && ls6Var.J0() != null && this.a.J0().h0() != null && this.a.j1() != null && yo5Var != null && this.a.j1().e0() != null && this.a.n0() != null) {
            BdTypeRecyclerView e0 = this.a.j1().e0();
            int i = yo5Var.a;
            if (i != 2) {
                if (i != 3 || yo5Var.a() == null) {
                    return;
                }
                e0.removeHeaderView(yo5Var.a());
                this.a.n0().h0(0);
            } else if (yo5Var.a() == null) {
            } else {
                e0.removeHeaderView(yo5Var.a());
                e0.t(yo5Var.a(), e0.getHeaderViewsCount() - 1);
                this.a.n0().h0(8);
            }
        }
    }
}
