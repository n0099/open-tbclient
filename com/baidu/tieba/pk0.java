package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class pk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, str, str2) == null) {
            f(3, str, str2);
        }
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            f(6, str, str2);
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            f(4, str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, str, str2, th) == null) {
            f(3, str, str2 + '\n' + Log.getStackTraceString(th));
        }
    }

    public static void d(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, th) == null) {
            f(6, str, str2 + '\n' + Log.getStackTraceString(th));
        }
    }

    public static void g(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65542, null, i, str, str2) == null) {
            if (str2.length() > 1000) {
                Log.println(i, str, str2.substring(0, 1000));
                g(i, str, str2.substring(1000));
                return;
            }
            Log.println(i, str, str2);
        }
    }

    public static void h(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, str2, th) == null) {
            f(5, str, str2 + '\n' + Log.getStackTraceString(th));
        }
    }

    public static void f(int i, String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(65541, null, i, str, str2) == null) && str != null) {
            if (str2 != null) {
                str3 = PreferencesUtil.LEFT_MOUNT + Thread.currentThread().getName() + PreferencesUtil.RIGHT_MOUNT + str2;
            } else {
                str3 = "LogEx method param(msg) is null";
            }
            g(i, str, str3);
        }
    }
}
