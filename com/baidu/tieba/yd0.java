package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes8.dex */
public class yd0 {
    public static /* synthetic */ Interceptable $ic;
    public static final xd0 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948326180, "Lcom/baidu/tieba/yd0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948326180, "Lcom/baidu/tieba/yd0;");
                return;
            }
        }
        a = new xd0();
    }

    public static boolean a(@NonNull Context context, @NonNull de0 de0Var, @Nullable Map<String, Object> map, @Nullable he0 he0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, context, de0Var, map, he0Var)) == null) {
            return a.a(context, de0Var, map, he0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return c(str, null);
        }
        return invokeL.booleanValue;
    }

    public static boolean c(String str, @Nullable Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, context)) == null) {
            return d(str, context, null);
        }
        return invokeLL.booleanValue;
    }

    public static boolean d(String str, @Nullable Context context, @Nullable Map<String, Object> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, context, map)) == null) {
            return e(str, context, map, null);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean e(String str, @Nullable Context context, @Nullable Map<String, Object> map, @Nullable he0 he0Var) {
        InterceptResult invokeLLLL;
        k01 k01Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, str, context, map, he0Var)) == null) {
            if (g01.a && (k01Var = (k01) f01.a().a(k01.class)) != null) {
                k01Var.a(str);
            }
            if (!me0.o(str)) {
                me0.d(he0Var, str, 201, false);
                return false;
            }
            if (context == null) {
                context = pe0.b();
            }
            return a(context, new de0(str), map, he0Var);
        }
        return invokeLLLL.booleanValue;
    }
}
