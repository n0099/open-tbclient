package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class y6 extends v6 implements w6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b4 h;

    public y6() {
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

    public y6(b4 b4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        o(b4Var);
    }

    public void o(b4 b4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b4Var) == null) {
            this.h = b4Var;
            j(b4Var.n());
            h(b4Var.k());
        }
    }

    public y6 p(l3 l3Var) {
        InterceptResult invokeL;
        b4 b4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l3Var)) == null) {
            b4 b4Var2 = this.h;
            if (b4Var2 instanceof c4.b) {
                b4Var = new c4.b((c4.b) b4Var2);
            } else {
                b4Var = new b4(b4Var2);
            }
            b4Var.u(l3Var);
            b4Var.z(a(), k());
            y6 y6Var = new y6(b4Var);
            y6Var.b(l());
            y6Var.c(g());
            y6Var.f(i());
            y6Var.d(e());
            return y6Var;
        }
        return (y6) invokeL.objValue;
    }
}
