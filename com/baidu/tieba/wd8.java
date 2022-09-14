package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class wd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, vd8 vd8Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, vd8Var)) == null) {
            if (i <= 0) {
                return vd8Var.a();
            }
            if (vd8Var.c()) {
                return i + vd8Var.b();
            }
            return i + vd8Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull vd8 vd8Var, int i2, @Nullable T t, @Nullable xd8 xd8Var, @Nullable yd8 yd8Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), vd8Var, Integer.valueOf(i2), t, xd8Var, yd8Var})) == null) {
            if (vd8Var.a() != -1 && vd8Var.b() != -1) {
                int a = a(i2, vd8Var);
                if (xd8Var != null && t != null) {
                    if (i <= i2) {
                        if (yd8Var != 0) {
                            yd8Var.a(i, a);
                        }
                        return false;
                    }
                    int i3 = i + 1;
                    if (i3 < a) {
                        if (yd8Var != 0) {
                            yd8Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i > a ? i3 : a;
                    int i5 = mg7.i(list);
                    if (i4 >= i5 && (xd8Var.b() || i4 > i5)) {
                        if (yd8Var != 0) {
                            yd8Var.d(i, i4, i5, xd8Var, t);
                        }
                        return false;
                    }
                    xd8Var.a(i4);
                    if (xd8Var.b()) {
                        if (yd8Var != 0) {
                            yd8Var.e(i, i4, mg7.d(list, i4), xd8Var, t);
                            return true;
                        }
                        return true;
                    }
                    mg7.b(list, t, i4);
                    if (yd8Var != 0) {
                        yd8Var.c(i, i4, xd8Var, t);
                        return true;
                    }
                    return true;
                } else if (yd8Var != 0) {
                    yd8Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
