package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class k42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947863040, "Lcom/baidu/tieba/k42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947863040, "Lcom/baidu/tieba/k42;");
                return;
            }
        }
        boolean z = ho1.a;
    }

    @Nullable
    public static <C extends m32> C a(n32 n32Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, n32Var)) == null) {
            if (n32Var == null) {
                q42.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = n32Var.d();
            String str = n32Var.c;
            if (TextUtils.isEmpty(str)) {
                x42.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            n42 d2 = d(str);
            if (d2 == null) {
                x42.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = n32Var.b;
            if (TextUtils.isEmpty(str2)) {
                x42.o("Component-Finder", "find " + d + " with a empty componentId");
                List<m32> list = d2.a().c.get(n32Var.a);
                if (list == null) {
                    x42.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    x42.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    x42.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                x42.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends m32> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            n42 d = d(str);
            if (d == null) {
                x42.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                x42.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static n42 c(n32 n32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, n32Var)) == null) {
            if (n32Var == null) {
                q42.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(n32Var.c);
        }
        return (n42) invokeL.objValue;
    }

    @Nullable
    public static n42 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                x42.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            fu1 A = kt2.U().A(str);
            if (!(A instanceof du1)) {
                return null;
            }
            return ((du1) A).c0();
        }
        return (n42) invokeL.objValue;
    }
}
