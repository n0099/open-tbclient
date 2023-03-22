package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class p19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, o19 o19Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, o19Var)) == null) {
            if (i <= 0) {
                return o19Var.a();
            }
            if (o19Var.c()) {
                return i + o19Var.b();
            }
            return i + o19Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull o19 o19Var, int i2, @Nullable T t, @Nullable q19 q19Var, @Nullable r19 r19Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), o19Var, Integer.valueOf(i2), t, q19Var, r19Var})) == null) {
            if (o19Var.a() != -1 && o19Var.b() != -1) {
                int a = a(i2, o19Var);
                if (q19Var != null && t != null) {
                    if (i <= i2) {
                        if (r19Var != 0) {
                            r19Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (r19Var != 0) {
                            r19Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = v38.i(list);
                    if (i3 >= i5 && (q19Var.b() || i3 > i5)) {
                        if (r19Var != 0) {
                            r19Var.d(i, i3, i5, q19Var, t);
                        }
                        return false;
                    }
                    q19Var.a(i3);
                    if (!q19Var.b()) {
                        v38.b(list, t, i3);
                        if (r19Var != 0) {
                            r19Var.c(i, i3, q19Var, t);
                            return true;
                        }
                        return true;
                    } else if (r19Var != 0) {
                        r19Var.e(i, i3, v38.d(list, i3), q19Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (r19Var != 0) {
                    r19Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
