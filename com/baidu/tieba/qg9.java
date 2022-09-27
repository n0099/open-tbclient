package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Locale;
/* loaded from: classes5.dex */
public class qg9 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948091014, "Lcom/baidu/tieba/qg9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948091014, "Lcom/baidu/tieba/qg9;");
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String fileName = stackTrace[4].getFileName();
            String methodName = stackTrace[4].getMethodName();
            return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), "[ (" + fileName + ":" + stackTrace[4].getLineNumber() + ")#" + (methodName.substring(0, 1).toUpperCase() + methodName.substring(1)) + " ] ", str);
        }
        return (String) invokeL.objValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && a) {
            String[] h = h(str);
            if (h != null && h.length == 2) {
                Log.d(h[0], h[1]);
            } else {
                Log.d("BdLog", str);
            }
        }
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) && a) {
            Log.d(str, a(str2));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && a) {
            String[] h = h(str);
            if (h != null && h.length == 2) {
                Log.e(h[0], h[1]);
            } else {
                Log.e("BdLog", str);
            }
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) && a) {
            Log.e(str, a(str2));
        }
    }

    public static void f(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65542, null, str, str2, th) == null) && a) {
            Log.e(str, a(str2), th);
        }
    }

    public static void g(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, th) == null) && a && th != null) {
            th.printStackTrace();
        }
    }

    public static String[] h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String fileName = stackTrace[4].getFileName();
            String methodName = stackTrace[4].getMethodName();
            return new String[]{fileName, String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), "[ (" + fileName + ":" + stackTrace[4].getLineNumber() + ")#" + (methodName.substring(0, 1).toUpperCase() + methodName.substring(1)) + " ] ", str)};
        }
        return (String[]) invokeL.objValue;
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, str) == null) && a) {
            String[] h = h(str);
            if (h != null && h.length == 2) {
                Log.i(h[0], h[1]);
            } else {
                Log.i("BdLog", str);
            }
        }
    }

    public static void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) && a) {
            Log.i(str, a(str2));
        }
    }

    public static void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) && a) {
            Log.v(str, a(str2));
        }
    }

    public static void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) && a) {
            Log.w(str, a(str2));
        }
    }
}
