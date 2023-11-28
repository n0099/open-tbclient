package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes8.dex */
public class sf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull bh4 bh4Var, @Nullable List<hf4> list, @Nullable List<if4> list2, @NonNull ce4 ce4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, bh4Var, list, list2, ce4Var) == null) {
            mg4 b = uf4.b(bh4Var, ce4Var);
            if (list != null && !list.isEmpty()) {
                uf4.a(b, lg4.h(list, ce4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                uf4.a(b, lg4.e(list2, ce4Var));
            }
            b.e();
        }
    }

    public static void b(ch4 ch4Var, ce4 ce4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, ch4Var, ce4Var) == null) {
            uf4.c(ch4Var, ce4Var);
        }
    }

    public static void c(dh4 dh4Var, ce4 ce4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, dh4Var, ce4Var) == null) {
            uf4.d(dh4Var, ce4Var);
        }
    }

    public static void d(eh4 eh4Var, ce4 ce4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, eh4Var, ce4Var) == null) {
            uf4.e(eh4Var, ce4Var);
        }
    }

    public static void e(zi4 zi4Var, ce4 ce4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, zi4Var, ce4Var) == null) {
            uf4.f(zi4Var, ce4Var);
        }
    }

    public static synchronized void f(List<if4> list, ce4 ce4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, ce4Var) == null) {
            synchronized (sf4.class) {
                uf4.g(list, ce4Var);
            }
        }
    }
}
