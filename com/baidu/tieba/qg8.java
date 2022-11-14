package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class qg8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, pg8 pg8Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, pg8Var)) == null) {
            if (i <= 0) {
                return pg8Var.a();
            }
            if (pg8Var.c()) {
                return i + pg8Var.b();
            }
            return i + pg8Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull pg8 pg8Var, int i2, @Nullable T t, @Nullable rg8 rg8Var, @Nullable sg8 sg8Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), pg8Var, Integer.valueOf(i2), t, rg8Var, sg8Var})) == null) {
            if (pg8Var.a() != -1 && pg8Var.b() != -1) {
                int a = a(i2, pg8Var);
                if (rg8Var != null && t != null) {
                    if (i <= i2) {
                        if (sg8Var != 0) {
                            sg8Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (sg8Var != 0) {
                            sg8Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = gj7.i(list);
                    if (i3 >= i5 && (rg8Var.b() || i3 > i5)) {
                        if (sg8Var != 0) {
                            sg8Var.d(i, i3, i5, rg8Var, t);
                        }
                        return false;
                    }
                    rg8Var.a(i3);
                    if (!rg8Var.b()) {
                        gj7.b(list, t, i3);
                        if (sg8Var != 0) {
                            sg8Var.c(i, i3, rg8Var, t);
                            return true;
                        }
                        return true;
                    } else if (sg8Var != 0) {
                        sg8Var.e(i, i3, gj7.d(list, i3), rg8Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (sg8Var != 0) {
                    sg8Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
