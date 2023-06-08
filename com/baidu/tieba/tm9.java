package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class tm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, sm9 sm9Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, sm9Var)) == null) {
            if (i <= 0) {
                return sm9Var.a();
            }
            if (sm9Var.c()) {
                return i + sm9Var.b();
            }
            return i + sm9Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull sm9 sm9Var, int i2, @Nullable T t, @Nullable um9 um9Var, @Nullable vm9 vm9Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), sm9Var, Integer.valueOf(i2), t, um9Var, vm9Var})) == null) {
            if (sm9Var.a() != -1 && sm9Var.b() != -1) {
                int a = a(i2, sm9Var);
                if (um9Var != null && t != null) {
                    if (i <= i2) {
                        if (vm9Var != 0) {
                            vm9Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (vm9Var != 0) {
                            vm9Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = yo8.i(list);
                    if (i3 >= i5 && (um9Var.b() || i3 > i5)) {
                        if (vm9Var != 0) {
                            vm9Var.d(i, i3, i5, um9Var, t);
                        }
                        return false;
                    }
                    um9Var.a(i3);
                    if (!um9Var.b()) {
                        yo8.b(list, t, i3);
                        if (vm9Var != 0) {
                            vm9Var.c(i, i3, um9Var, t);
                            return true;
                        }
                        return true;
                    } else if (vm9Var != 0) {
                        vm9Var.e(i, i3, yo8.d(list, i3), um9Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (vm9Var != 0) {
                    vm9Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
