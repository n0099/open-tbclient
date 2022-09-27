package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class jx4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static ix4 a = null;
    public static int b = 0;
    public static int c = 0;
    public static int d = 0;
    public static int e = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947898659, "Lcom/baidu/tieba/jx4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947898659, "Lcom/baidu/tieba/jx4;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ix4 ix4Var = a;
            if (ix4Var == null) {
                return -1;
            }
            return ix4Var.getCurrentTabType();
        }
        return invokeV.intValue;
    }

    public static Class<?> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ix4 ix4Var = a;
            if (ix4Var == null) {
                return null;
            }
            return ix4Var.d();
        }
        return (Class) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ix4 ix4Var = a;
            if (ix4Var == null) {
                return null;
            }
            return ix4Var.f();
        }
        return (String) invokeV.objValue;
    }

    public static void d(Context context) {
        ix4 ix4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) || (ix4Var = a) == null) {
            return;
        }
        ix4Var.a(context);
    }

    public static void e(Context context, int i) {
        ix4 ix4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65541, null, context, i) == null) || (ix4Var = a) == null) {
            return;
        }
        ix4Var.b(context, i);
    }

    public static void f(Context context, int i, boolean z) {
        ix4 ix4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || (ix4Var = a) == null) {
            return;
        }
        ix4Var.c(context, i, z);
    }

    public static void g(Context context, int i, boolean z) {
        ix4 ix4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || (ix4Var = a) == null) {
            return;
        }
        ix4Var.e(context, i, z);
    }

    public static void h(ix4 ix4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, ix4Var) == null) {
            a = ix4Var;
        }
    }
}
