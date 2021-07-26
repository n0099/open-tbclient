package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, obj, str) == null) && obj == null) {
            b(str);
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) && TextUtils.isEmpty(str)) {
            b(str2);
        }
    }

    public static void a(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(65539, null, z, str) == null) || z) {
            return;
        }
        b(str);
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            b(str);
        }
    }
}
