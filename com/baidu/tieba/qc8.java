package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class qc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, pc8 pc8Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, pc8Var)) == null) {
            if (i <= 0) {
                return pc8Var.a();
            }
            if (pc8Var.c()) {
                return i + pc8Var.b();
            }
            return i + pc8Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull pc8 pc8Var, int i2, @Nullable T t, @Nullable rc8 rc8Var, @Nullable sc8 sc8Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), pc8Var, Integer.valueOf(i2), t, rc8Var, sc8Var})) == null) {
            if (pc8Var.a() != -1 && pc8Var.b() != -1) {
                int a = a(i2, pc8Var);
                if (rc8Var != null && t != null) {
                    if (i <= i2) {
                        if (sc8Var != 0) {
                            sc8Var.a(i, a);
                        }
                        return false;
                    }
                    int i3 = i + 1;
                    if (i3 < a) {
                        if (sc8Var != 0) {
                            sc8Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i > a ? i3 : a;
                    int i5 = if7.i(list);
                    if (i4 >= i5 && (rc8Var.b() || i4 > i5)) {
                        if (sc8Var != 0) {
                            sc8Var.d(i, i4, i5, rc8Var, t);
                        }
                        return false;
                    }
                    rc8Var.a(i4);
                    if (rc8Var.b()) {
                        if (sc8Var != 0) {
                            sc8Var.e(i, i4, if7.d(list, i4), rc8Var, t);
                            return true;
                        }
                        return true;
                    }
                    if7.b(list, t, i4);
                    if (sc8Var != 0) {
                        sc8Var.c(i, i4, rc8Var, t);
                        return true;
                    }
                    return true;
                } else if (sc8Var != 0) {
                    sc8Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
