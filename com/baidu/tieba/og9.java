package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class og9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = -1;
    public static String b = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948031432, "Lcom/baidu/tieba/og9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948031432, "Lcom/baidu/tieba/og9;");
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (!TextUtils.isEmpty(b)) {
                return b;
            }
            try {
                b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return b;
        }
        return (String) invokeL.objValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            int i = a;
            if (i >= 0) {
                return i;
            }
            try {
                a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return a;
        }
        return invokeL.intValue;
    }
}
