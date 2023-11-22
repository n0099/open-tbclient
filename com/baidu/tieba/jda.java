package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class jda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, ida idaVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, idaVar)) == null) {
            if (i <= 0) {
                return idaVar.a();
            }
            if (idaVar.c()) {
                return i + idaVar.b();
            }
            return i + idaVar.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull ida idaVar, int i2, @Nullable T t, @Nullable kda kdaVar, @Nullable lda ldaVar) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), idaVar, Integer.valueOf(i2), t, kdaVar, ldaVar})) == null) {
            if (idaVar.a() != -1 && idaVar.b() != -1) {
                int a = a(i2, idaVar);
                if (kdaVar != null && t != null) {
                    if (i <= i2) {
                        if (ldaVar != 0) {
                            ldaVar.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (ldaVar != 0) {
                            ldaVar.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = jc9.i(list);
                    if (i3 >= i5 && (kdaVar.b() || i3 > i5)) {
                        if (ldaVar != 0) {
                            ldaVar.d(i, i3, i5, kdaVar, t);
                        }
                        return false;
                    }
                    kdaVar.a(i3);
                    if (!kdaVar.b()) {
                        jc9.b(list, t, i3);
                        if (ldaVar != 0) {
                            ldaVar.c(i, i3, kdaVar, t);
                            return true;
                        }
                        return true;
                    } else if (ldaVar != 0) {
                        ldaVar.e(i, i3, jc9.d(list, i3), kdaVar, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (ldaVar != 0) {
                    ldaVar.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
