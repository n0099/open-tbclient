package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class lo9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, ko9 ko9Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, ko9Var)) == null) {
            if (i <= 0) {
                return ko9Var.a();
            }
            if (ko9Var.c()) {
                return i + ko9Var.b();
            }
            return i + ko9Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull ko9 ko9Var, int i2, @Nullable T t, @Nullable mo9 mo9Var, @Nullable no9 no9Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), ko9Var, Integer.valueOf(i2), t, mo9Var, no9Var})) == null) {
            if (ko9Var.a() != -1 && ko9Var.b() != -1) {
                int a = a(i2, ko9Var);
                if (mo9Var != null && t != null) {
                    if (i <= i2) {
                        if (no9Var != 0) {
                            no9Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (no9Var != 0) {
                            no9Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = sp8.i(list);
                    if (i3 >= i5 && (mo9Var.b() || i3 > i5)) {
                        if (no9Var != 0) {
                            no9Var.d(i, i3, i5, mo9Var, t);
                        }
                        return false;
                    }
                    mo9Var.a(i3);
                    if (!mo9Var.b()) {
                        sp8.b(list, t, i3);
                        if (no9Var != 0) {
                            no9Var.c(i, i3, mo9Var, t);
                            return true;
                        }
                        return true;
                    } else if (no9Var != 0) {
                        no9Var.e(i, i3, sp8.d(list, i3), mo9Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (no9Var != 0) {
                    no9Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
