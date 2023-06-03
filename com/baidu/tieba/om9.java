package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class om9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, nm9 nm9Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, nm9Var)) == null) {
            if (i <= 0) {
                return nm9Var.a();
            }
            if (nm9Var.c()) {
                return i + nm9Var.b();
            }
            return i + nm9Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull nm9 nm9Var, int i2, @Nullable T t, @Nullable pm9 pm9Var, @Nullable qm9 qm9Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), nm9Var, Integer.valueOf(i2), t, pm9Var, qm9Var})) == null) {
            if (nm9Var.a() != -1 && nm9Var.b() != -1) {
                int a = a(i2, nm9Var);
                if (pm9Var != null && t != null) {
                    if (i <= i2) {
                        if (qm9Var != 0) {
                            qm9Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (qm9Var != 0) {
                            qm9Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = vo8.i(list);
                    if (i3 >= i5 && (pm9Var.b() || i3 > i5)) {
                        if (qm9Var != 0) {
                            qm9Var.d(i, i3, i5, pm9Var, t);
                        }
                        return false;
                    }
                    pm9Var.a(i3);
                    if (!pm9Var.b()) {
                        vo8.b(list, t, i3);
                        if (qm9Var != 0) {
                            qm9Var.c(i, i3, pm9Var, t);
                            return true;
                        }
                        return true;
                    } else if (qm9Var != 0) {
                        qm9Var.e(i, i3, vo8.d(list, i3), pm9Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (qm9Var != 0) {
                    qm9Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
