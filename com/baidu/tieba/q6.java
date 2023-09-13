package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class q6 extends o6 implements p6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q3 h;

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

    public q3 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (q3) invokeV.objValue;
    }

    public q6(q3 q3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        p(q3Var);
    }

    public q6 q(e3 e3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e3Var)) == null) {
            q6 q6Var = new q6(this);
            q6Var.h = new q3(q6Var.o(), e3Var);
            return q6Var;
        }
        return (q6) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q6(q6 q6Var) {
        super(q6Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q6Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((p6) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.h = q6Var.h;
    }

    public void p(q3 q3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q3Var) == null) {
            this.h = q3Var;
            if (q3Var != null) {
                j(q3Var.k());
                h(q3Var.j());
                f(q3Var.g());
                c(q3Var.f());
                d(q3Var.d());
                b(q3Var.e());
            }
        }
    }
}
