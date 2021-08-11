package com.bytedance.sdk.component.net.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes9.dex */
public class NetLog {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DEBUG = false;
    public static final String TAG = "NetLog";
    public static int sLevel = 4;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1651162399, "Lcom/bytedance/sdk/component/net/utils/NetLog;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1651162399, "Lcom/bytedance/sdk/component/net/utils/NetLog;");
        }
    }

    public NetLog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && DEBUG) {
            d(TAG, str);
        }
    }

    public static boolean debug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? sLevel <= 3 : invokeV.booleanValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, str) == null) && DEBUG) {
            e(TAG, str);
        }
    }

    public static String formatMsgs(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, objArr)) == null) {
            if (objArr == null || objArr.length == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                if (obj != null) {
                    sb.append(obj.toString());
                } else {
                    sb.append(" null ");
                }
                sb.append(" ");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static int getLogLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? sLevel : invokeV.intValue;
    }

    public static String getSimpleClassName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            int lastIndexOf = str.lastIndexOf(46);
            return lastIndexOf < 0 ? str : str.substring(lastIndexOf + 1);
        }
        return (String) invokeL.objValue;
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65550, null, str) == null) && DEBUG) {
            i(TAG, str);
        }
    }

    public static boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? DEBUG : invokeV.booleanValue;
    }

    public static void logDirect(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65555, null, str, str2) != null) || str2 == null) {
        }
    }

    public static void openDebugMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            DEBUG = true;
            setLogLevel(3);
        }
    }

    public static void setLogLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65557, null, i2) == null) {
            sLevel = i2;
        }
    }

    public static void st(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65558, null, str, i2) == null) {
            try {
                throw new Exception();
            } catch (Exception e2) {
                StackTraceElement[] stackTrace = e2.getStackTrace();
                StringBuilder sb = new StringBuilder();
                for (int i3 = 1; i3 < Math.min(i2, stackTrace.length); i3++) {
                    if (i3 > 1) {
                        sb.append(StringUtils.LF);
                    }
                    sb.append(getSimpleClassName(stackTrace[i3].getClassName()));
                    sb.append(".");
                    sb.append(stackTrace[i3].getMethodName());
                }
                v(str, sb.toString());
            }
        }
    }

    public static void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, str) == null) {
            v(TAG, str);
        }
    }

    public static void w(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65563, null, str) == null) && DEBUG) {
            w(TAG, str);
        }
    }

    public static void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65560, null, str, str2) == null) && DEBUG && str2 != null) {
            int i2 = sLevel;
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) && DEBUG && str2 != null) {
            int i2 = sLevel;
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) && DEBUG && str2 != null) {
            int i2 = sLevel;
        }
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65551, null, str, str2) == null) && DEBUG && str2 != null) {
            int i2 = sLevel;
        }
    }

    public static void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65564, null, str, str2) == null) && DEBUG && str2 != null) {
            int i2 = sLevel;
        }
    }

    public static void v(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65561, null, str, str2, th) == null) && DEBUG) {
            if (str2 == null && th == null) {
                return;
            }
            int i2 = sLevel;
        }
    }

    public static void d(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, th) == null) && DEBUG) {
            if (str2 == null && th == null) {
                return;
            }
            int i2 = sLevel;
        }
    }

    public static void e(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65545, null, str, str2, th) == null) && DEBUG) {
            if (str2 == null && th == null) {
                return;
            }
            int i2 = sLevel;
        }
    }

    public static void i(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65552, null, str, str2, th) == null) && DEBUG) {
            if (str2 == null && th == null) {
                return;
            }
            int i2 = sLevel;
        }
    }

    public static void w(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65565, null, str, str2, th) == null) && DEBUG) {
            if (str2 == null && th == null) {
                return;
            }
            int i2 = sLevel;
        }
    }

    public static void v(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65562, null, str, objArr) == null) || !DEBUG || objArr == null || sLevel > 2) {
            return;
        }
        formatMsgs(objArr);
    }

    public static void d(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, objArr) == null) || !DEBUG || objArr == null || sLevel > 3) {
            return;
        }
        formatMsgs(objArr);
    }

    public static void e(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, str, objArr) == null) || !DEBUG || objArr == null || sLevel > 6) {
            return;
        }
        formatMsgs(objArr);
    }

    public static void i(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65553, null, str, objArr) == null) || !DEBUG || objArr == null || sLevel > 4) {
            return;
        }
        formatMsgs(objArr);
    }

    public static void w(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65566, null, str, objArr) == null) || !DEBUG || objArr == null || sLevel > 5) {
            return;
        }
        formatMsgs(objArr);
    }
}
