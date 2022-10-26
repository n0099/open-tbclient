package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class ve8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, ue8 ue8Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, ue8Var)) == null) {
            if (i <= 0) {
                return ue8Var.a();
            }
            if (ue8Var.c()) {
                return i + ue8Var.b();
            }
            return i + ue8Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static boolean b(List list, int i, ue8 ue8Var, int i2, Object obj, we8 we8Var, xe8 xe8Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), ue8Var, Integer.valueOf(i2), obj, we8Var, xe8Var})) == null) {
            if (ue8Var.a() != -1 && ue8Var.b() != -1) {
                int a = a(i2, ue8Var);
                if (we8Var != null && obj != null) {
                    if (i <= i2) {
                        if (xe8Var != null) {
                            xe8Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (xe8Var != null) {
                            xe8Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = lh7.i(list);
                    if (i3 >= i5 && (we8Var.b() || i3 > i5)) {
                        if (xe8Var != null) {
                            xe8Var.d(i, i3, i5, we8Var, obj);
                        }
                        return false;
                    }
                    we8Var.a(i3);
                    if (!we8Var.b()) {
                        lh7.b(list, obj, i3);
                        if (xe8Var != null) {
                            xe8Var.c(i, i3, we8Var, obj);
                            return true;
                        }
                        return true;
                    } else if (xe8Var != null) {
                        xe8Var.e(i, i3, lh7.d(list, i3), we8Var, obj);
                        return true;
                    } else {
                        return true;
                    }
                } else if (xe8Var != null) {
                    xe8Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
