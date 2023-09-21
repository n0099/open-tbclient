package com.baidu.tieba;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class x1c {
    public static /* synthetic */ Interceptable $ic;
    public static SharedPreferences a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948248959, "Lcom/baidu/tieba/x1c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948248959, "Lcom/baidu/tieba/x1c;");
        }
    }

    public static String a(String str, String str2, Context context) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, context)) == null) {
            return b(context).getString(str, str2);
        }
        return (String) invokeLLL.objValue;
    }

    public static void c(String str, String str2, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, context) == null) {
            b(context).edit().putString(str, str2).apply();
        }
    }

    public static synchronized SharedPreferences b(Context context) {
        InterceptResult invokeL;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (x1c.class) {
                if (a == null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        a = context.createDeviceProtectedStorageContext().getSharedPreferences("aegis", 0);
                    } else {
                        a = context.getApplicationContext().getSharedPreferences("aegis", 0);
                    }
                }
                sharedPreferences = a;
            }
            return sharedPreferences;
        }
        return (SharedPreferences) invokeL.objValue;
    }
}
