package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class oc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, nc8 nc8Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, nc8Var)) == null) {
            if (i <= 0) {
                return nc8Var.a();
            }
            if (nc8Var.c()) {
                return i + nc8Var.b();
            }
            return i + nc8Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull nc8 nc8Var, int i2, @Nullable T t, @Nullable pc8 pc8Var, @Nullable qc8 qc8Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), nc8Var, Integer.valueOf(i2), t, pc8Var, qc8Var})) == null) {
            if (nc8Var.a() != -1 && nc8Var.b() != -1) {
                int a = a(i2, nc8Var);
                if (pc8Var != null && t != null) {
                    if (i <= i2) {
                        if (qc8Var != 0) {
                            qc8Var.a(i, a);
                        }
                        return false;
                    }
                    int i3 = i + 1;
                    if (i3 < a) {
                        if (qc8Var != 0) {
                            qc8Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i > a ? i3 : a;
                    int i5 = gf7.i(list);
                    if (i4 >= i5 && (pc8Var.b() || i4 > i5)) {
                        if (qc8Var != 0) {
                            qc8Var.d(i, i4, i5, pc8Var, t);
                        }
                        return false;
                    }
                    pc8Var.a(i4);
                    if (pc8Var.b()) {
                        if (qc8Var != 0) {
                            qc8Var.e(i, i4, gf7.d(list, i4), pc8Var, t);
                            return true;
                        }
                        return true;
                    }
                    gf7.b(list, t, i4);
                    if (qc8Var != 0) {
                        qc8Var.c(i, i4, pc8Var, t);
                        return true;
                    }
                    return true;
                } else if (qc8Var != 0) {
                    qc8Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
