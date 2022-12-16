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
public class r02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948067733, "Lcom/baidu/tieba/r02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948067733, "Lcom/baidu/tieba/r02;");
                return;
            }
        }
        boolean z = ok1.a;
    }

    @Nullable
    public static <C extends tz1> C a(uz1 uz1Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uz1Var)) == null) {
            if (uz1Var == null) {
                x02.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = uz1Var.d();
            String str = uz1Var.c;
            if (TextUtils.isEmpty(str)) {
                e12.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            u02 d2 = d(str);
            if (d2 == null) {
                e12.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = uz1Var.b;
            if (TextUtils.isEmpty(str2)) {
                e12.o("Component-Finder", "find " + d + " with a empty componentId");
                List<tz1> list = d2.a().c.get(uz1Var.a);
                if (list == null) {
                    e12.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    e12.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    e12.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                e12.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends tz1> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            u02 d = d(str);
            if (d == null) {
                e12.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                e12.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static u02 c(uz1 uz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, uz1Var)) == null) {
            if (uz1Var == null) {
                x02.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(uz1Var.c);
        }
        return (u02) invokeL.objValue;
    }

    @Nullable
    public static u02 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                e12.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            mq1 A = rp2.U().A(str);
            if (!(A instanceof kq1)) {
                return null;
            }
            return ((kq1) A).c0();
        }
        return (u02) invokeL.objValue;
    }
}
