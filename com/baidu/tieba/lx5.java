package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class lx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(65536, null, z) != null) || z) {
            return;
        }
        throw new IllegalArgumentException();
    }

    @NonNull
    public static <T> T b(@Nullable T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, t)) == null) {
            if (t != null) {
                return t;
            }
            throw null;
        }
        return (T) invokeL.objValue;
    }

    public static void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            e(z, null);
        }
    }

    @NonNull
    public static <T> T c(@Nullable T t, @NonNull Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, t, obj)) == null) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(String.valueOf(obj));
        }
        return (T) invokeLL.objValue;
    }

    public static void e(boolean z, @Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(InputDeviceCompat.SOURCE_TRACKBALL, null, z, str) != null) || z) {
            return;
        }
        throw new IllegalStateException(str);
    }
}
