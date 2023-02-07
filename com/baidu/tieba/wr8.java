package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class wr8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, vr8 vr8Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, vr8Var)) == null) {
            if (i <= 0) {
                return vr8Var.a();
            }
            if (vr8Var.c()) {
                return i + vr8Var.b();
            }
            return i + vr8Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull vr8 vr8Var, int i2, @Nullable T t, @Nullable xr8 xr8Var, @Nullable yr8 yr8Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), vr8Var, Integer.valueOf(i2), t, xr8Var, yr8Var})) == null) {
            if (vr8Var.a() != -1 && vr8Var.b() != -1) {
                int a = a(i2, vr8Var);
                if (xr8Var != null && t != null) {
                    if (i <= i2) {
                        if (yr8Var != 0) {
                            yr8Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (yr8Var != 0) {
                            yr8Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = mv7.i(list);
                    if (i3 >= i5 && (xr8Var.b() || i3 > i5)) {
                        if (yr8Var != 0) {
                            yr8Var.d(i, i3, i5, xr8Var, t);
                        }
                        return false;
                    }
                    xr8Var.a(i3);
                    if (!xr8Var.b()) {
                        mv7.b(list, t, i3);
                        if (yr8Var != 0) {
                            yr8Var.c(i, i3, xr8Var, t);
                            return true;
                        }
                        return true;
                    } else if (yr8Var != 0) {
                        yr8Var.e(i, i3, mv7.d(list, i3), xr8Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (yr8Var != 0) {
                    yr8Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
