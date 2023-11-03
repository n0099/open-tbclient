package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes8.dex */
public class rf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull ah4 ah4Var, @Nullable List<gf4> list, @Nullable List<hf4> list2, @NonNull be4 be4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, ah4Var, list, list2, be4Var) == null) {
            lg4 b = tf4.b(ah4Var, be4Var);
            if (list != null && !list.isEmpty()) {
                tf4.a(b, kg4.h(list, be4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                tf4.a(b, kg4.e(list2, be4Var));
            }
            b.e();
        }
    }

    public static void b(bh4 bh4Var, be4 be4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, bh4Var, be4Var) == null) {
            tf4.c(bh4Var, be4Var);
        }
    }

    public static void c(ch4 ch4Var, be4 be4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ch4Var, be4Var) == null) {
            tf4.d(ch4Var, be4Var);
        }
    }

    public static void d(dh4 dh4Var, be4 be4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, dh4Var, be4Var) == null) {
            tf4.e(dh4Var, be4Var);
        }
    }

    public static void e(yi4 yi4Var, be4 be4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, yi4Var, be4Var) == null) {
            tf4.f(yi4Var, be4Var);
        }
    }

    public static synchronized void f(List<hf4> list, be4 be4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, be4Var) == null) {
            synchronized (rf4.class) {
                tf4.g(list, be4Var);
            }
        }
    }
}
