package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ol4 extends tk4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jl4 a;
    public boolean b;

    public ol4(jl4 jl4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jl4Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jl4Var;
        this.b = z;
    }

    @Override // com.baidu.tieba.tk4
    public jl4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (jl4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tk4
    public boolean b(jl4 jl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jl4Var)) == null) {
            jl4 jl4Var2 = this.a;
            if (jl4Var2 == jl4Var) {
                return true;
            }
            return jl4Var2.d(jl4Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.tk4
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) || this.b) {
            return;
        }
        if (z) {
            jl4 jl4Var = this.a;
            jl4Var.a.b.b = 0L;
            jl4Var.b(0);
        }
        hl4.b().f(this.a);
    }

    @Override // com.baidu.tieba.tk4
    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "isAttached=" + this.b + " " + super.toString();
        }
        return (String) invokeV.objValue;
    }
}
