package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.v3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r6 extends o6 implements p6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u3 h;

    public r6() {
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

    public r6(u3 u3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        o(u3Var);
    }

    public void o(u3 u3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, u3Var) == null) {
            this.h = u3Var;
            j(u3Var.n());
            h(u3Var.k());
        }
    }

    public r6 p(e3 e3Var) {
        InterceptResult invokeL;
        u3 u3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e3Var)) == null) {
            u3 u3Var2 = this.h;
            if (u3Var2 instanceof v3.b) {
                u3Var = new v3.b((v3.b) u3Var2);
            } else {
                u3Var = new u3(u3Var2);
            }
            u3Var.u(e3Var);
            u3Var.z(a(), k());
            r6 r6Var = new r6(u3Var);
            r6Var.b(l());
            r6Var.c(g());
            r6Var.f(i());
            r6Var.d(e());
            return r6Var;
        }
        return (r6) invokeL.objValue;
    }
}
