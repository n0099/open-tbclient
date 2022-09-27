package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class le8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, ke8 ke8Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, ke8Var)) == null) {
            if (i <= 0) {
                return ke8Var.a();
            }
            if (ke8Var.c()) {
                return i + ke8Var.b();
            }
            return i + ke8Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull ke8 ke8Var, int i2, @Nullable T t, @Nullable me8 me8Var, @Nullable ne8 ne8Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), ke8Var, Integer.valueOf(i2), t, me8Var, ne8Var})) == null) {
            if (ke8Var.a() != -1 && ke8Var.b() != -1) {
                int a = a(i2, ke8Var);
                if (me8Var != null && t != null) {
                    if (i <= i2) {
                        if (ne8Var != 0) {
                            ne8Var.a(i, a);
                        }
                        return false;
                    }
                    int i3 = i + 1;
                    if (i3 < a) {
                        if (ne8Var != 0) {
                            ne8Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i > a ? i3 : a;
                    int i5 = ah7.i(list);
                    if (i4 >= i5 && (me8Var.b() || i4 > i5)) {
                        if (ne8Var != 0) {
                            ne8Var.d(i, i4, i5, me8Var, t);
                        }
                        return false;
                    }
                    me8Var.a(i4);
                    if (me8Var.b()) {
                        if (ne8Var != 0) {
                            ne8Var.e(i, i4, ah7.d(list, i4), me8Var, t);
                            return true;
                        }
                        return true;
                    }
                    ah7.b(list, t, i4);
                    if (ne8Var != 0) {
                        ne8Var.c(i, i4, me8Var, t);
                        return true;
                    }
                    return true;
                } else if (ne8Var != 0) {
                    ne8Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
