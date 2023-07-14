package com.baidu.validation.utils;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class ValidationLog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "Validation";
    public static boolean enabled = true;
    public transient /* synthetic */ FieldHolder $fh;

    public ValidationLog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String a(String str, Object[] objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, objArr)) == null) {
            if (objArr != null) {
                try {
                    if (objArr.length == 0) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = objArr.length;
                    for (int i = 0; i < length; i++) {
                        Object obj = objArr[i];
                        if (obj != null) {
                            if (i != 0) {
                                sb.append("|");
                            }
                            try {
                                if (obj instanceof Throwable) {
                                    sb.append(Log.getStackTraceString((Throwable) obj));
                                } else {
                                    sb.append(obj);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                    return sb.toString();
                } catch (Throwable th) {
                    Log.e(str, "converArrayToString t: " + th);
                    return "converArrayToString null";
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static void d(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, str, objArr) == null) && enabled) {
            Log.d(str, a(str, objArr));
        }
    }

    public static void d(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, objArr) == null) {
            d(TAG, objArr);
        }
    }

    public static void e(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, th) == null) {
            e(str, th);
        }
    }

    public static void e(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, str, objArr) == null) && enabled) {
            Log.e(str, a(str, objArr));
        }
    }

    public static void e(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, th) == null) {
            e(TAG, th);
        }
    }

    public static void enable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            enabled = z;
        }
    }

    public static void i(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, str, objArr) == null) && enabled) {
            Log.i(str, a(str, objArr));
        }
    }

    public static void i(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, objArr) == null) {
            i(TAG, objArr);
        }
    }

    public static void w(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, null, str, objArr) == null) && enabled) {
            Log.w(str, a(str, objArr));
        }
    }

    public static void w(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, objArr) == null) {
            w(TAG, objArr);
        }
    }
}
