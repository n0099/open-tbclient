package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class l61 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947894722, "Lcom/baidu/tieba/l61;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947894722, "Lcom/baidu/tieba/l61;");
        }
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (context.checkSelfPermission(str) != 0) {
                        return false;
                    }
                    return true;
                } else if (context.checkCallingOrSelfPermission(str) != 0) {
                    return false;
                } else {
                    return true;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if ("permission_location".equalsIgnoreCase(str)) {
                    return b;
                }
                if ("permission_storage".equalsIgnoreCase(str)) {
                    return c;
                }
                if ("permission_app_list".equalsIgnoreCase(str)) {
                    return d;
                }
                if ("permission_read_phone_state".equalsIgnoreCase(str)) {
                    return a;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
