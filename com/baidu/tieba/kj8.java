package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class kj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, jj8 jj8Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, jj8Var)) == null) {
            if (i <= 0) {
                return jj8Var.a();
            }
            if (jj8Var.c()) {
                return i + jj8Var.b();
            }
            return i + jj8Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull jj8 jj8Var, int i2, @Nullable T t, @Nullable lj8 lj8Var, @Nullable mj8 mj8Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), jj8Var, Integer.valueOf(i2), t, lj8Var, mj8Var})) == null) {
            if (jj8Var.a() != -1 && jj8Var.b() != -1) {
                int a = a(i2, jj8Var);
                if (lj8Var != null && t != null) {
                    if (i <= i2) {
                        if (mj8Var != 0) {
                            mj8Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (mj8Var != 0) {
                            mj8Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = fm7.i(list);
                    if (i3 >= i5 && (lj8Var.b() || i3 > i5)) {
                        if (mj8Var != 0) {
                            mj8Var.d(i, i3, i5, lj8Var, t);
                        }
                        return false;
                    }
                    lj8Var.a(i3);
                    if (!lj8Var.b()) {
                        fm7.b(list, t, i3);
                        if (mj8Var != 0) {
                            mj8Var.c(i, i3, lj8Var, t);
                            return true;
                        }
                        return true;
                    } else if (mj8Var != 0) {
                        mj8Var.e(i, i3, fm7.d(list, i3), lj8Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (mj8Var != 0) {
                    mj8Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
