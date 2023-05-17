package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.p3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l6 extends i6 implements j6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o3 h;

    public l6() {
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

    public l6(o3 o3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        o(o3Var);
    }

    public void o(o3 o3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, o3Var) == null) {
            this.h = o3Var;
            j(o3Var.n());
            h(o3Var.k());
        }
    }

    public l6 p(y2 y2Var) {
        InterceptResult invokeL;
        o3 o3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y2Var)) == null) {
            o3 o3Var2 = this.h;
            if (o3Var2 instanceof p3.b) {
                o3Var = new p3.b((p3.b) o3Var2);
            } else {
                o3Var = new o3(o3Var2);
            }
            o3Var.u(y2Var);
            o3Var.z(a(), k());
            l6 l6Var = new l6(o3Var);
            l6Var.b(l());
            l6Var.c(g());
            l6Var.f(i());
            l6Var.d(e());
            return l6Var;
        }
        return (l6) invokeL.objValue;
    }
}
