package com.bytedance.sdk.component.image.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.image.ILog;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ILog f65529a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ILog iLog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, iLog) == null) {
            f65529a = iLog;
        }
    }

    public static void b(String str) {
        ILog iLog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || (iLog = f65529a) == null) {
            return;
        }
        iLog.e(str);
    }

    public static void a(String str) {
        ILog iLog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || (iLog = f65529a) == null) {
            return;
        }
        iLog.w(str);
    }

    public static void b(String str, String str2) {
        ILog iLog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) || (iLog = f65529a) == null) {
            return;
        }
        iLog.e(str, str2);
    }

    public static void a(String str, String str2) {
        ILog iLog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) || (iLog = f65529a) == null) {
            return;
        }
        iLog.w(str, str2);
    }
}
