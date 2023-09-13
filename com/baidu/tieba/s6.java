package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.v3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class s6 extends o6 implements p6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public w3 h;

    public s6() {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s6(s6 s6Var) {
        super(s6Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s6Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((p6) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        o(s6Var.h);
    }

    public s6(w3 w3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w3Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        o(w3Var);
    }

    public void o(w3 w3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, w3Var) == null) {
            this.h = w3Var;
            if (w3Var != null) {
                j(w3Var.c());
                h(w3Var.b());
            }
        }
    }

    public p6 p(e3 e3Var) {
        InterceptResult invokeL;
        u3 u3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e3Var)) == null) {
            w3 w3Var = this.h;
            if (w3Var instanceof v3.a) {
                u3Var = new v3.b((v3.a) w3Var);
            } else {
                u3Var = new u3(w3Var);
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
        return (p6) invokeL.objValue;
    }
}
