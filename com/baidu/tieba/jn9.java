package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
/* loaded from: classes4.dex */
public final class jn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65536, null, z) == null) && !z) {
            throw new IllegalArgumentException();
        }
    }

    @NonNull
    @EnsuresNonNull({"#1"})
    public static String b(@Nullable String str, @NonNull Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, obj)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException(String.valueOf(obj));
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static void c(@NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && do9.a()) {
            throw new IllegalStateException(str);
        }
    }

    @NonNull
    @EnsuresNonNull({"#1"})
    public static <T> T d(@Nullable T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException("null reference");
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    @EnsuresNonNull({"#1"})
    public static <T> T e(@NonNull T t, @NonNull Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, t, obj)) == null) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(String.valueOf(obj));
        }
        return (T) invokeLL.objValue;
    }
}
