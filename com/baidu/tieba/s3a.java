package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class s3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, r3a r3aVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, r3aVar)) == null) {
            if (i <= 0) {
                return r3aVar.a();
            }
            if (r3aVar.c()) {
                return i + r3aVar.b();
            }
            return i + r3aVar.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull r3a r3aVar, int i2, @Nullable T t, @Nullable t3a t3aVar, @Nullable u3a u3aVar) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), r3aVar, Integer.valueOf(i2), t, t3aVar, u3aVar})) == null) {
            if (r3aVar.a() != -1 && r3aVar.b() != -1) {
                int a = a(i2, r3aVar);
                if (t3aVar != null && t != null) {
                    if (i <= i2) {
                        if (u3aVar != 0) {
                            u3aVar.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (u3aVar != 0) {
                            u3aVar.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = i39.i(list);
                    if (i3 >= i5 && (t3aVar.b() || i3 > i5)) {
                        if (u3aVar != 0) {
                            u3aVar.d(i, i3, i5, t3aVar, t);
                        }
                        return false;
                    }
                    t3aVar.a(i3);
                    if (!t3aVar.b()) {
                        i39.b(list, t, i3);
                        if (u3aVar != 0) {
                            u3aVar.c(i, i3, t3aVar, t);
                            return true;
                        }
                        return true;
                    } else if (u3aVar != 0) {
                        u3aVar.e(i, i3, i39.d(list, i3), t3aVar, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (u3aVar != 0) {
                    u3aVar.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
