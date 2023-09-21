package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class q5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, p5a p5aVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, p5aVar)) == null) {
            if (i <= 0) {
                return p5aVar.a();
            }
            if (p5aVar.c()) {
                return i + p5aVar.b();
            }
            return i + p5aVar.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull p5a p5aVar, int i2, @Nullable T t, @Nullable r5a r5aVar, @Nullable s5a s5aVar) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), p5aVar, Integer.valueOf(i2), t, r5aVar, s5aVar})) == null) {
            if (p5aVar.a() != -1 && p5aVar.b() != -1) {
                int a = a(i2, p5aVar);
                if (r5aVar != null && t != null) {
                    if (i <= i2) {
                        if (s5aVar != 0) {
                            s5aVar.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (s5aVar != 0) {
                            s5aVar.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = t49.i(list);
                    if (i3 >= i5 && (r5aVar.b() || i3 > i5)) {
                        if (s5aVar != 0) {
                            s5aVar.d(i, i3, i5, r5aVar, t);
                        }
                        return false;
                    }
                    r5aVar.a(i3);
                    if (!r5aVar.b()) {
                        t49.b(list, t, i3);
                        if (s5aVar != 0) {
                            s5aVar.c(i, i3, r5aVar, t);
                            return true;
                        }
                        return true;
                    } else if (s5aVar != 0) {
                        s5aVar.e(i, i3, t49.d(list, i3), r5aVar, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (s5aVar != 0) {
                    s5aVar.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
