package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wg5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = false;
    public static int b = 50;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948269636, "Lcom/baidu/tieba/wg5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948269636, "Lcom/baidu/tieba/wg5;");
        }
    }

    public static synchronized int a(Context context) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (wg5.class) {
                if (!a) {
                    int statusBarHeight = AndroidUtils.getStatusBarHeight(context);
                    b = statusBarHeight;
                    Log.d("StatusBarHeightUtil", String.format("Get status bar height %d", Integer.valueOf(statusBarHeight)));
                    a = true;
                }
                i = b;
            }
            return i;
        }
        return invokeL.intValue;
    }
}
