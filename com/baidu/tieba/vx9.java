package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes8.dex */
public class vx9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, ux9 ux9Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, ux9Var)) == null) {
            if (i <= 0) {
                return ux9Var.a();
            }
            if (ux9Var.c()) {
                return i + ux9Var.b();
            }
            return i + ux9Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull ux9 ux9Var, int i2, @Nullable T t, @Nullable wx9 wx9Var, @Nullable xx9 xx9Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), ux9Var, Integer.valueOf(i2), t, wx9Var, xx9Var})) == null) {
            if (ux9Var.a() != -1 && ux9Var.b() != -1) {
                int a = a(i2, ux9Var);
                if (wx9Var != null && t != null) {
                    if (i <= i2) {
                        if (xx9Var != 0) {
                            xx9Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (xx9Var != 0) {
                            xx9Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = cy8.i(list);
                    if (i3 >= i5 && (wx9Var.b() || i3 > i5)) {
                        if (xx9Var != 0) {
                            xx9Var.d(i, i3, i5, wx9Var, t);
                        }
                        return false;
                    }
                    wx9Var.a(i3);
                    if (!wx9Var.b()) {
                        cy8.b(list, t, i3);
                        if (xx9Var != 0) {
                            xx9Var.c(i, i3, wx9Var, t);
                            return true;
                        }
                        return true;
                    } else if (xx9Var != 0) {
                        xx9Var.e(i, i3, cy8.d(list, i3), wx9Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (xx9Var != 0) {
                    xx9Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
