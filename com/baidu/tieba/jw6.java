package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class jw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m57 a;

    public jw6(TbPageContext tbPageContext, m57 m57Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, m57Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = m57Var;
    }

    public void a(wv5 wv5Var) {
        m57 m57Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, wv5Var) == null) && (m57Var = this.a) != null && m57Var.Q0() != null && this.a.Q0().z0() != null && this.a.v1() != null && wv5Var != null && this.a.v1().g0() != null && this.a.s0() != null) {
            BdTypeRecyclerView g0 = this.a.v1().g0();
            int i = wv5Var.a;
            if (i != 2) {
                if (i != 3 || wv5Var.a() == null) {
                    return;
                }
                g0.removeHeaderView(wv5Var.a());
                this.a.s0().m0(0);
            } else if (wv5Var.a() == null) {
            } else {
                g0.removeHeaderView(wv5Var.a());
                g0.addHeaderView(wv5Var.a(), g0.getHeaderViewsCount() - 1);
                this.a.s0().m0(8);
            }
        }
    }
}
