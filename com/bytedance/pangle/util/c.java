package com.bytedance.pangle.util;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class c {
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tArr, t)) == null) {
            if (tArr != null) {
                i = 0;
                while (i < tArr.length) {
                    if (tArr[i] == t || (tArr[i] != null && tArr[i].equals(t))) {
                        break;
                    }
                    i++;
                }
            }
            i = -1;
            return i != -1;
        }
        return invokeLL.booleanValue;
    }
}
