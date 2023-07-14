package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
/* loaded from: classes8.dex */
public class ya0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "lcpsdk";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948323297, "Lcom/baidu/tieba/ya0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948323297, "Lcom/baidu/tieba/ya0;");
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) && xa0.a) {
            String str3 = a;
            Log.d(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) && xa0.a) {
            String str3 = a;
            Log.e(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) && xa0.a) {
            String str3 = a;
            Log.i(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) && xa0.a) {
            String str3 = a;
            Log.v(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, str, str2) == null) && xa0.a) {
            String str3 = a;
            Log.w(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, str, str2, th) == null) && xa0.a) {
            String str3 = a;
            Log.e(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2, th);
        }
    }
}
