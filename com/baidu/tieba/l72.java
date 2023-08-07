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
/* loaded from: classes6.dex */
public class l72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947895714, "Lcom/baidu/tieba/l72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947895714, "Lcom/baidu/tieba/l72;");
                return;
            }
        }
        boolean z = ir1.a;
    }

    @Nullable
    public static <C extends n62> C a(o62 o62Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, o62Var)) == null) {
            if (o62Var == null) {
                r72.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = o62Var.d();
            String str = o62Var.c;
            if (TextUtils.isEmpty(str)) {
                y72.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            o72 d2 = d(str);
            if (d2 == null) {
                y72.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = o62Var.b;
            if (TextUtils.isEmpty(str2)) {
                y72.o("Component-Finder", "find " + d + " with a empty componentId");
                List<n62> list = d2.a().c.get(o62Var.a);
                if (list == null) {
                    y72.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    y72.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    y72.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                y72.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends n62> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            o72 d = d(str);
            if (d == null) {
                y72.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                y72.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static o72 c(o62 o62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, o62Var)) == null) {
            if (o62Var == null) {
                r72.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(o62Var.c);
        }
        return (o72) invokeL.objValue;
    }

    @Nullable
    public static o72 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                y72.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            gx1 A = lw2.T().A(str);
            if (!(A instanceof ex1)) {
                return null;
            }
            return ((ex1) A).a0();
        }
        return (o72) invokeL.objValue;
    }
}
