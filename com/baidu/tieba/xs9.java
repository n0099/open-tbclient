package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes8.dex */
public class xs9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, ws9 ws9Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, ws9Var)) == null) {
            if (i <= 0) {
                return ws9Var.a();
            }
            if (ws9Var.c()) {
                return i + ws9Var.b();
            }
            return i + ws9Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull ws9 ws9Var, int i2, @Nullable T t, @Nullable ys9 ys9Var, @Nullable zs9 zs9Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), ws9Var, Integer.valueOf(i2), t, ys9Var, zs9Var})) == null) {
            if (ws9Var.a() != -1 && ws9Var.b() != -1) {
                int a = a(i2, ws9Var);
                if (ys9Var != null && t != null) {
                    if (i <= i2) {
                        if (zs9Var != 0) {
                            zs9Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (zs9Var != 0) {
                            zs9Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = du8.i(list);
                    if (i3 >= i5 && (ys9Var.b() || i3 > i5)) {
                        if (zs9Var != 0) {
                            zs9Var.d(i, i3, i5, ys9Var, t);
                        }
                        return false;
                    }
                    ys9Var.a(i3);
                    if (!ys9Var.b()) {
                        du8.b(list, t, i3);
                        if (zs9Var != 0) {
                            zs9Var.c(i, i3, ys9Var, t);
                            return true;
                        }
                        return true;
                    } else if (zs9Var != 0) {
                        zs9Var.e(i, i3, du8.d(list, i3), ys9Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (zs9Var != 0) {
                    zs9Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
