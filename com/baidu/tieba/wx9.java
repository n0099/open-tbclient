package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes8.dex */
public class wx9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, vx9 vx9Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, vx9Var)) == null) {
            if (i <= 0) {
                return vx9Var.a();
            }
            if (vx9Var.c()) {
                return i + vx9Var.b();
            }
            return i + vx9Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull vx9 vx9Var, int i2, @Nullable T t, @Nullable xx9 xx9Var, @Nullable yx9 yx9Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), vx9Var, Integer.valueOf(i2), t, xx9Var, yx9Var})) == null) {
            if (vx9Var.a() != -1 && vx9Var.b() != -1) {
                int a = a(i2, vx9Var);
                if (xx9Var != null && t != null) {
                    if (i <= i2) {
                        if (yx9Var != 0) {
                            yx9Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (yx9Var != 0) {
                            yx9Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = dy8.i(list);
                    if (i3 >= i5 && (xx9Var.b() || i3 > i5)) {
                        if (yx9Var != 0) {
                            yx9Var.d(i, i3, i5, xx9Var, t);
                        }
                        return false;
                    }
                    xx9Var.a(i3);
                    if (!xx9Var.b()) {
                        dy8.b(list, t, i3);
                        if (yx9Var != 0) {
                            yx9Var.c(i, i3, xx9Var, t);
                            return true;
                        }
                        return true;
                    } else if (yx9Var != 0) {
                        yx9Var.e(i, i3, dy8.d(list, i3), xx9Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (yx9Var != 0) {
                    yx9Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
