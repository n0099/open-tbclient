package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class jj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, ij8 ij8Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, ij8Var)) == null) {
            if (i <= 0) {
                return ij8Var.a();
            }
            if (ij8Var.c()) {
                return i + ij8Var.b();
            }
            return i + ij8Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull ij8 ij8Var, int i2, @Nullable T t, @Nullable kj8 kj8Var, @Nullable lj8 lj8Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), ij8Var, Integer.valueOf(i2), t, kj8Var, lj8Var})) == null) {
            if (ij8Var.a() != -1 && ij8Var.b() != -1) {
                int a = a(i2, ij8Var);
                if (kj8Var != null && t != null) {
                    if (i <= i2) {
                        if (lj8Var != 0) {
                            lj8Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (lj8Var != 0) {
                            lj8Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = em7.i(list);
                    if (i3 >= i5 && (kj8Var.b() || i3 > i5)) {
                        if (lj8Var != 0) {
                            lj8Var.d(i, i3, i5, kj8Var, t);
                        }
                        return false;
                    }
                    kj8Var.a(i3);
                    if (!kj8Var.b()) {
                        em7.b(list, t, i3);
                        if (lj8Var != 0) {
                            lj8Var.c(i, i3, kj8Var, t);
                            return true;
                        }
                        return true;
                    } else if (lj8Var != 0) {
                        lj8Var.e(i, i3, em7.d(list, i3), kj8Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (lj8Var != 0) {
                    lj8Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
