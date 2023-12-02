package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class kw2 implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    public kw2() {
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

    @Nullable
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return b(this);
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return super.clone();
        }
        return invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public static String b(kw2 kw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, kw2Var)) == null) {
            if (kw2Var == null || TextUtils.isEmpty(kw2Var.a)) {
                return null;
            }
            if (TextUtils.isEmpty(kw2Var.b)) {
                return kw2Var.a;
            }
            return kw2Var.a + "?" + kw2Var.b;
        }
        return (String) invokeL.objValue;
    }

    public static String c(kw2 kw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, kw2Var)) == null) {
            if (kw2Var == null || TextUtils.isEmpty(kw2Var.d)) {
                return null;
            }
            if (TextUtils.isEmpty(kw2Var.b)) {
                return kw2Var.d;
            }
            return kw2Var.d + "?" + kw2Var.b;
        }
        return (String) invokeL.objValue;
    }

    public static kw2 d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            kw2 kw2Var = new kw2();
            kw2Var.a = ck3.f(str);
            kw2Var.b = ck3.o(str);
            kw2Var.c = str2;
            kw2Var.d = ca3.b(kw2Var.a);
            return kw2Var;
        }
        return (kw2) invokeLL.objValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.b = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "SwanAppPageParam{mPage='" + this.a + "', mParams='" + this.b + "', mBaseUrl='" + this.c + "', mRoutePage='" + this.d + "', mRoutType='" + this.e + "', mRouteId='" + this.f + "'}";
        }
        return (String) invokeV.objValue;
    }
}
