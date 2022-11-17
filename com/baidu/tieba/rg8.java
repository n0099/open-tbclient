package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class rg8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, qg8 qg8Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, qg8Var)) == null) {
            if (i <= 0) {
                return qg8Var.a();
            }
            if (qg8Var.c()) {
                return i + qg8Var.b();
            }
            return i + qg8Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull qg8 qg8Var, int i2, @Nullable T t, @Nullable sg8 sg8Var, @Nullable tg8 tg8Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), qg8Var, Integer.valueOf(i2), t, sg8Var, tg8Var})) == null) {
            if (qg8Var.a() != -1 && qg8Var.b() != -1) {
                int a = a(i2, qg8Var);
                if (sg8Var != null && t != null) {
                    if (i <= i2) {
                        if (tg8Var != 0) {
                            tg8Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (tg8Var != 0) {
                            tg8Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = hj7.i(list);
                    if (i3 >= i5 && (sg8Var.b() || i3 > i5)) {
                        if (tg8Var != 0) {
                            tg8Var.d(i, i3, i5, sg8Var, t);
                        }
                        return false;
                    }
                    sg8Var.a(i3);
                    if (!sg8Var.b()) {
                        hj7.b(list, t, i3);
                        if (tg8Var != 0) {
                            tg8Var.c(i, i3, sg8Var, t);
                            return true;
                        }
                        return true;
                    } else if (tg8Var != 0) {
                        tg8Var.e(i, i3, hj7.d(list, i3), sg8Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (tg8Var != 0) {
                    tg8Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
