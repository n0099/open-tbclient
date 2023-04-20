package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class nb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, mb9 mb9Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, mb9Var)) == null) {
            if (i <= 0) {
                return mb9Var.a();
            }
            if (mb9Var.c()) {
                return i + mb9Var.b();
            }
            return i + mb9Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull mb9 mb9Var, int i2, @Nullable T t, @Nullable ob9 ob9Var, @Nullable pb9 pb9Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), mb9Var, Integer.valueOf(i2), t, ob9Var, pb9Var})) == null) {
            if (mb9Var.a() != -1 && mb9Var.b() != -1) {
                int a = a(i2, mb9Var);
                if (ob9Var != null && t != null) {
                    if (i <= i2) {
                        if (pb9Var != 0) {
                            pb9Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (pb9Var != 0) {
                            pb9Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = ue8.i(list);
                    if (i3 >= i5 && (ob9Var.b() || i3 > i5)) {
                        if (pb9Var != 0) {
                            pb9Var.d(i, i3, i5, ob9Var, t);
                        }
                        return false;
                    }
                    ob9Var.a(i3);
                    if (!ob9Var.b()) {
                        ue8.b(list, t, i3);
                        if (pb9Var != 0) {
                            pb9Var.c(i, i3, ob9Var, t);
                            return true;
                        }
                        return true;
                    } else if (pb9Var != 0) {
                        pb9Var.e(i, i3, ue8.d(list, i3), ob9Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (pb9Var != 0) {
                    pb9Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
