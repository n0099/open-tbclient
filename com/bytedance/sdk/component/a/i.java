package com.bytedance.sdk.component.a;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f64476a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            f64476a = z;
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            boolean z = f64476a;
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            boolean z = f64476a;
        }
    }

    public static void b(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, th) == null) && f64476a) {
            String str2 = "Stacktrace: " + Log.getStackTraceString(th);
        }
    }

    public static void a(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, str, th) == null) && f64476a) {
            String str2 = "Stacktrace: " + Log.getStackTraceString(th);
        }
    }

    public static void a(RuntimeException runtimeException) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, runtimeException) == null) && f64476a) {
            throw runtimeException;
        }
    }
}
