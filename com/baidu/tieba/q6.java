package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class q6 extends n6 implements o6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t3 h;

    public q6() {
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

    public q6(t3 t3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        o(t3Var);
    }

    public void o(t3 t3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t3Var) == null) {
            this.h = t3Var;
            j(t3Var.n());
            h(t3Var.k());
        }
    }

    public q6 p(d3 d3Var) {
        InterceptResult invokeL;
        t3 t3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d3Var)) == null) {
            t3 t3Var2 = this.h;
            if (t3Var2 instanceof u3.b) {
                t3Var = new u3.b((u3.b) t3Var2);
            } else {
                t3Var = new t3(t3Var2);
            }
            t3Var.u(d3Var);
            t3Var.z(a(), k());
            q6 q6Var = new q6(t3Var);
            q6Var.b(l());
            q6Var.c(g());
            q6Var.f(i());
            q6Var.d(e());
            return q6Var;
        }
        return (q6) invokeL.objValue;
    }
}
