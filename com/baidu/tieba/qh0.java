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
/* loaded from: classes6.dex */
public class qh0 {
    public static /* synthetic */ Interceptable $ic;
    public static final ph0 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948091696, "Lcom/baidu/tieba/qh0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948091696, "Lcom/baidu/tieba/qh0;");
                return;
            }
        }
        a = new ph0();
    }

    public static boolean a(@NonNull Context context, @NonNull vh0 vh0Var, @Nullable Map<String, Object> map, @Nullable zh0 zh0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, context, vh0Var, map, zh0Var)) == null) {
            return a.a(context, vh0Var, map, zh0Var);
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

    public static boolean e(String str, @Nullable Context context, @Nullable Map<String, Object> map, @Nullable zh0 zh0Var) {
        InterceptResult invokeLLLL;
        i31 i31Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, str, context, map, zh0Var)) == null) {
            if (f31.a && (i31Var = (i31) e31.a().a(i31.class)) != null) {
                i31Var.a(str);
            }
            if (!ei0.o(str)) {
                ei0.d(zh0Var, str, 201, false);
                return false;
            }
            if (context == null) {
                context = hi0.b();
            }
            return a(context, new vh0(str), map, zh0Var);
        }
        return invokeLLLL.booleanValue;
    }
}
