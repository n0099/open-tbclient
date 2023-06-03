package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.t3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class p6 extends m6 implements n6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s3 h;

    public p6() {
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

    public p6(s3 s3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        o(s3Var);
    }

    public void o(s3 s3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, s3Var) == null) {
            this.h = s3Var;
            j(s3Var.n());
            h(s3Var.k());
        }
    }

    public p6 p(c3 c3Var) {
        InterceptResult invokeL;
        s3 s3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c3Var)) == null) {
            s3 s3Var2 = this.h;
            if (s3Var2 instanceof t3.b) {
                s3Var = new t3.b((t3.b) s3Var2);
            } else {
                s3Var = new s3(s3Var2);
            }
            s3Var.u(c3Var);
            s3Var.z(a(), k());
            p6 p6Var = new p6(s3Var);
            p6Var.b(l());
            p6Var.c(g());
            p6Var.f(i());
            p6Var.d(e());
            return p6Var;
        }
        return (p6) invokeL.objValue;
    }
}
