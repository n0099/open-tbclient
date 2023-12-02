package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class jt2 {
    public static /* synthetic */ Interceptable $ic;
    public static ArrayList<it2> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947894753, "Lcom/baidu/tieba/jt2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947894753, "Lcom/baidu/tieba/jt2;");
                return;
            }
        }
        a = new ArrayList<>();
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            a.clear();
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                it2 it2Var = a.get(size);
                if (it2Var != null) {
                    it2Var.onDestroy();
                }
            }
        }
    }

    public static void a(it2 it2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, it2Var) == null) && it2Var != null && !a.contains(it2Var)) {
            a.add(it2Var);
        }
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                it2 it2Var = a.get(size);
                if (it2Var != null) {
                    it2Var.j(z);
                }
            }
        }
    }

    public static void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                it2 it2Var = a.get(size);
                if (it2Var != null) {
                    it2Var.k(z);
                }
            }
        }
    }

    public static void k(it2 it2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65547, null, it2Var) != null) || it2Var == null) {
            return;
        }
        a.remove(it2Var);
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            it2 it2Var = a.get(size);
            if (it2Var != null && TextUtils.equals(str, it2Var.b())) {
                it2Var.onDestroy();
            }
        }
    }

    public static it2 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (int size = a.size() - 1; size >= 0; size--) {
                it2 it2Var = a.get(size);
                if (it2Var != null && TextUtils.equals(str, it2Var.c())) {
                    return it2Var;
                }
            }
            return null;
        }
        return (it2) invokeL.objValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (int size = a.size() - 1; size >= 0; size--) {
                it2 it2Var = a.get(size);
                if (it2Var != null && TextUtils.equals(str, it2Var.b()) && it2Var.onBackPressed()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static it2 f(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            for (int size = a.size() - 1; size >= 0; size--) {
                it2 it2Var = a.get(size);
                if (it2Var != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, it2Var.b())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, it2Var.f())) || TextUtils.equals(str3, it2Var.c())))) {
                    return it2Var;
                }
            }
            return null;
        }
        return (it2) invokeLLL.objValue;
    }

    public static void i(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65545, null, str, z) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            it2 it2Var = a.get(size);
            if (it2Var != null && TextUtils.equals(str, it2Var.b())) {
                it2Var.k(z);
            }
        }
    }
}
