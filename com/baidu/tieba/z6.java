package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.d4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class z6 extends w6 implements x6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c4 h;

    public z6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public z6(c4 c4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        o(c4Var);
    }

    public void o(c4 c4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, c4Var) == null) {
            this.h = c4Var;
            j(c4Var.n());
            h(c4Var.k());
        }
    }

    public z6 p(m3 m3Var) {
        InterceptResult invokeL;
        c4 c4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m3Var)) == null) {
            c4 c4Var2 = this.h;
            if (c4Var2 instanceof d4.b) {
                c4Var = new d4.b((d4.b) c4Var2);
            } else {
                c4Var = new c4(c4Var2);
            }
            c4Var.u(m3Var);
            c4Var.z(a(), k());
            z6 z6Var = new z6(c4Var);
            z6Var.b(l());
            z6Var.c(g());
            z6Var.f(i());
            z6Var.d(e());
            return z6Var;
        }
        return (z6) invokeL.objValue;
    }
}
