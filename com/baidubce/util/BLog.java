package com.baidubce.util;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class BLog {
    public static /* synthetic */ Interceptable $ic = null;
    public static String LOG_TAG = "BOS";
    public static boolean enableLog;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1536497336, "Lcom/baidubce/util/BLog;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1536497336, "Lcom/baidubce/util/BLog;");
        }
    }

    public BLog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void debug(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && enableLog) {
            Log.d(LOG_TAG, str);
        }
    }

    public static void disableLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            enableLog = false;
        }
    }

    public static void enableLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            enableLog = true;
        }
    }

    public static void error(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, str) == null) && enableLog) {
            Log.e(LOG_TAG, String.valueOf(str));
        }
    }

    public static void info(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65550, null, str) == null) && enableLog) {
            Log.i(LOG_TAG, str);
        }
    }

    public static boolean isEnableLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? enableLog : invokeV.booleanValue;
    }

    public static void warn(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65556, null, str) == null) && enableLog) {
            Log.w(LOG_TAG, String.valueOf(str));
        }
    }

    public static void debug(String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, obj) == null) && enableLog) {
            String str2 = LOG_TAG;
            Log.d(str2, str + obj);
        }
    }

    public static void error(String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, null, str, obj) == null) && enableLog) {
            String str2 = LOG_TAG;
            Log.e(str2, str + obj);
        }
    }

    public static void info(String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65551, null, str, obj) == null) && enableLog) {
            String str2 = LOG_TAG;
            Log.i(str2, str + obj);
        }
    }

    public static void warn(String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65557, null, str, obj) == null) && enableLog) {
            String str2 = LOG_TAG;
            Log.w(str2, str + obj);
        }
    }

    public static void debug(String str, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, obj, obj2) == null) && enableLog) {
            String str2 = LOG_TAG;
            Log.d(str2, str + obj + obj2);
        }
    }

    public static void error(String str, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65547, null, str, obj, obj2) == null) && enableLog) {
            String str2 = LOG_TAG;
            Log.e(str2, str + obj + obj2);
        }
    }

    public static void info(String str, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65552, null, str, obj, obj2) == null) && enableLog) {
            String str2 = LOG_TAG;
            Log.i(str2, str + obj + obj2);
        }
    }

    public static void warn(String str, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65558, null, str, obj, obj2) == null) && enableLog) {
            String str2 = LOG_TAG;
            Log.w(str2, str + obj + obj2);
        }
    }

    public static void debug(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, str, th) == null) && enableLog) {
            Log.d(LOG_TAG, str, th);
        }
    }

    public static void error(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, str, th) == null) && enableLog) {
            Log.e(LOG_TAG, str, th);
        }
    }

    public static void info(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65554, null, str, th) == null) && enableLog) {
            Log.i(LOG_TAG, str, th);
        }
    }

    public static void warn(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65560, null, str, th) == null) && enableLog) {
            Log.w(LOG_TAG, str, th);
        }
    }

    public static void debug(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65541, null, str, str2, th) == null) && enableLog) {
            String str3 = LOG_TAG;
            Log.d(str3, str + str2, th);
        }
    }

    public static void error(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65548, null, str, str2, th) == null) && enableLog) {
            String str3 = LOG_TAG;
            Log.e(str3, str + str2, th);
        }
    }

    public static void info(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65553, null, str, str2, th) == null) && enableLog) {
            String str3 = LOG_TAG;
            Log.i(str3, str + str2, th);
        }
    }

    public static void warn(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65559, null, str, str2, th) == null) && enableLog) {
            String str3 = LOG_TAG;
            Log.w(str3, str + str2, th);
        }
    }
}
