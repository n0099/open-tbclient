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
/* loaded from: classes7.dex */
public class t52 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948132120, "Lcom/baidu/tieba/t52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948132120, "Lcom/baidu/tieba/t52;");
                return;
            }
        }
        boolean z = qp1.a;
    }

    @Nullable
    public static <C extends v42> C a(w42 w42Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, w42Var)) == null) {
            if (w42Var == null) {
                z52.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = w42Var.d();
            String str = w42Var.c;
            if (TextUtils.isEmpty(str)) {
                g62.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            w52 d2 = d(str);
            if (d2 == null) {
                g62.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = w42Var.b;
            if (TextUtils.isEmpty(str2)) {
                g62.o("Component-Finder", "find " + d + " with a empty componentId");
                List<v42> list = d2.a().c.get(w42Var.a);
                if (list == null) {
                    g62.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    g62.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    g62.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                g62.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends v42> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            w52 d = d(str);
            if (d == null) {
                g62.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                g62.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static w52 c(w42 w42Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, w42Var)) == null) {
            if (w42Var == null) {
                z52.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(w42Var.c);
        }
        return (w52) invokeL.objValue;
    }

    @Nullable
    public static w52 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                g62.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            ov1 A = tu2.U().A(str);
            if (!(A instanceof mv1)) {
                return null;
            }
            return ((mv1) A).c0();
        }
        return (w52) invokeL.objValue;
    }
}
