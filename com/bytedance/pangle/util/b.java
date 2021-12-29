package com.bytedance.pangle.util;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(@Nullable T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tArr)) == null) ? tArr == null || tArr.length == 0 : invokeL.booleanValue;
    }

    public static <T> boolean a(@Nullable T[] tArr, T[] tArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tArr, tArr2)) == null) {
            if (tArr2 == null) {
                return true;
            }
            for (T t : tArr2) {
                if (!a(tArr, t)) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static <T> boolean a(@Nullable T[] tArr, T t) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tArr, t)) == null) {
            if (tArr != null) {
                i2 = 0;
                while (i2 < tArr.length) {
                    if (tArr[i2] == t || (tArr[i2] != null && tArr[i2].equals(t))) {
                        break;
                    }
                    i2++;
                }
            }
            i2 = -1;
            return i2 != -1;
        }
        return invokeLL.booleanValue;
    }
}
