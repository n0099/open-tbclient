package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class mw8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, lw8 lw8Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, lw8Var)) == null) {
            if (i <= 0) {
                return lw8Var.a();
            }
            if (lw8Var.c()) {
                return i + lw8Var.b();
            }
            return i + lw8Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull lw8 lw8Var, int i2, @Nullable T t, @Nullable nw8 nw8Var, @Nullable ow8 ow8Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), lw8Var, Integer.valueOf(i2), t, nw8Var, ow8Var})) == null) {
            if (lw8Var.a() != -1 && lw8Var.b() != -1) {
                int a = a(i2, lw8Var);
                if (nw8Var != null && t != null) {
                    if (i <= i2) {
                        if (ow8Var != 0) {
                            ow8Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (ow8Var != 0) {
                            ow8Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = ry7.i(list);
                    if (i3 >= i5 && (nw8Var.b() || i3 > i5)) {
                        if (ow8Var != 0) {
                            ow8Var.d(i, i3, i5, nw8Var, t);
                        }
                        return false;
                    }
                    nw8Var.a(i3);
                    if (!nw8Var.b()) {
                        ry7.b(list, t, i3);
                        if (ow8Var != 0) {
                            ow8Var.c(i, i3, nw8Var, t);
                            return true;
                        }
                        return true;
                    } else if (ow8Var != 0) {
                        ow8Var.e(i, i3, ry7.d(list, i3), nw8Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (ow8Var != 0) {
                    ow8Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
