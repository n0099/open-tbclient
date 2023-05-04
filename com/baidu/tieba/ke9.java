package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class ke9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, je9 je9Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, je9Var)) == null) {
            if (i <= 0) {
                return je9Var.a();
            }
            if (je9Var.c()) {
                return i + je9Var.b();
            }
            return i + je9Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull je9 je9Var, int i2, @Nullable T t, @Nullable le9 le9Var, @Nullable me9 me9Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), je9Var, Integer.valueOf(i2), t, le9Var, me9Var})) == null) {
            if (je9Var.a() != -1 && je9Var.b() != -1) {
                int a = a(i2, je9Var);
                if (le9Var != null && t != null) {
                    if (i <= i2) {
                        if (me9Var != 0) {
                            me9Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (me9Var != 0) {
                            me9Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = ch8.i(list);
                    if (i3 >= i5 && (le9Var.b() || i3 > i5)) {
                        if (me9Var != 0) {
                            me9Var.d(i, i3, i5, le9Var, t);
                        }
                        return false;
                    }
                    le9Var.a(i3);
                    if (!le9Var.b()) {
                        ch8.b(list, t, i3);
                        if (me9Var != 0) {
                            me9Var.c(i, i3, le9Var, t);
                            return true;
                        }
                        return true;
                    } else if (me9Var != 0) {
                        me9Var.e(i, i3, ch8.d(list, i3), le9Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (me9Var != 0) {
                    me9Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
