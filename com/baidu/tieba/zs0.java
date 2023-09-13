package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class zs0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public pt0 d;

    public zs0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 30000;
        this.b = 30000;
        this.c = 30000;
        this.d = ct0.a().a(true);
    }

    public zs0 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            this.a = i;
            return this;
        }
        return (zs0) invokeI.objValue;
    }

    public zs0 b(pt0 pt0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pt0Var)) == null) {
            this.d = pt0Var;
            return this;
        }
        return (zs0) invokeL.objValue;
    }

    public zs0 c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            this.b = i;
            return this;
        }
        return (zs0) invokeI.objValue;
    }

    public zs0 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            this.c = i;
            return this;
        }
        return (zs0) invokeI.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || zs0.class != obj.getClass()) {
                return false;
            }
            zs0 zs0Var = (zs0) obj;
            if (this.a == zs0Var.a && this.b == zs0Var.b && this.c == zs0Var.c && this.d == zs0Var.d) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return super.hashCode();
        }
        return invokeV.intValue;
    }
}
