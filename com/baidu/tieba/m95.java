package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class m95 {
    public static /* synthetic */ Interceptable $ic = null;
    public static l95 a = null;
    public static int b = 0;
    public static int c = 0;
    public static int d = 0;
    public static int e = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947927520, "Lcom/baidu/tieba/m95;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947927520, "Lcom/baidu/tieba/m95;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            l95 l95Var = a;
            if (l95Var == null) {
                return -1;
            }
            return l95Var.getCurrentTabType();
        }
        return invokeV.intValue;
    }

    public static Class<?> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            l95 l95Var = a;
            if (l95Var == null) {
                return null;
            }
            return l95Var.d();
        }
        return (Class) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            l95 l95Var = a;
            if (l95Var == null) {
                return null;
            }
            return l95Var.f();
        }
        return (String) invokeV.objValue;
    }

    public static void d(Context context) {
        l95 l95Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) != null) || (l95Var = a) == null) {
            return;
        }
        l95Var.a(context);
    }

    public static void h(l95 l95Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, l95Var) == null) {
            a = l95Var;
        }
    }

    public static void e(Context context, int i) {
        l95 l95Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65541, null, context, i) != null) || (l95Var = a) == null) {
            return;
        }
        l95Var.b(context, i);
    }

    public static void f(Context context, int i, boolean z) {
        l95 l95Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65542, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || (l95Var = a) == null) {
            return;
        }
        l95Var.c(context, i, z);
    }

    public static void g(Context context, int i, boolean z) {
        l95 l95Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65543, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || (l95Var = a) == null) {
            return;
        }
        l95Var.e(context, i, z);
    }
}
