package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yg1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = null;
    public static String b = null;
    public static int c = 0;
    public static boolean d = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948329094, "Lcom/baidu/tieba/yg1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948329094, "Lcom/baidu/tieba/yg1;");
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return Thread.currentThread().getName() + PreferencesUtil.LEFT_MOUNT + a + ":" + b + ":" + c + PreferencesUtil.RIGHT_MOUNT + str;
        }
        return (String) invokeL.objValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, str) != null) || !d) {
            return;
        }
        Log.d("CashierSdk", str);
    }

    public static void d(Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, objArr) != null) || !d) {
            return;
        }
        e(new Throwable().getStackTrace());
        Log.e("CashierSdk", f(objArr));
    }

    public static void e(StackTraceElement[] stackTraceElementArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, stackTraceElementArr) == null) {
            a = stackTraceElementArr[1].getFileName();
            b = stackTraceElementArr[1].getMethodName();
            c = stackTraceElementArr[1].getLineNumber();
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65543, null, str) != null) || !d) {
            return;
        }
        Log.i("CashierSdk", str);
    }

    public static void c(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, str, th) != null) || !d) {
            return;
        }
        e(new Throwable().getStackTrace());
        Log.e("CashierSdk", f(str), th);
    }

    public static String f(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, objArr)) == null) {
            if (objArr == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                if (obj != null) {
                    sb.append(obj.toString());
                }
            }
            return a(sb.toString());
        }
        return (String) invokeL.objValue;
    }
}
