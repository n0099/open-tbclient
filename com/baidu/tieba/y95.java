package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class y95 {
    public static /* synthetic */ Interceptable $ic = null;
    public static x95 a = null;
    public static int b = 0;
    public static int c = 0;
    public static int d = 0;
    public static int e = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948285012, "Lcom/baidu/tieba/y95;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948285012, "Lcom/baidu/tieba/y95;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            x95 x95Var = a;
            if (x95Var == null) {
                return -1;
            }
            return x95Var.getCurrentTabType();
        }
        return invokeV.intValue;
    }

    public static Class<?> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            x95 x95Var = a;
            if (x95Var == null) {
                return null;
            }
            return x95Var.d();
        }
        return (Class) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            x95 x95Var = a;
            if (x95Var == null) {
                return null;
            }
            return x95Var.f();
        }
        return (String) invokeV.objValue;
    }

    public static void d(Context context) {
        x95 x95Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) != null) || (x95Var = a) == null) {
            return;
        }
        x95Var.a(context);
    }

    public static void h(x95 x95Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, x95Var) == null) {
            a = x95Var;
        }
    }

    public static void e(Context context, int i) {
        x95 x95Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65541, null, context, i) != null) || (x95Var = a) == null) {
            return;
        }
        x95Var.b(context, i);
    }

    public static void f(Context context, int i, boolean z) {
        x95 x95Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65542, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || (x95Var = a) == null) {
            return;
        }
        x95Var.c(context, i, z);
    }

    public static void g(Context context, int i, boolean z) {
        x95 x95Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65543, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || (x95Var = a) == null) {
            return;
        }
        x95Var.e(context, i, z);
    }
}
