package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kc0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = false;
    public static int b = 50;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947908145, "Lcom/baidu/tieba/kc0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947908145, "Lcom/baidu/tieba/kc0;");
        }
    }

    public static synchronized int a(Context context) {
        InterceptResult invokeL;
        int i;
        int identifier;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (kc0.class) {
                if (!a && (identifier = context.getResources().getIdentifier("status_bar_height", EMABTest.TYPE_DIMEN, "android")) > 0) {
                    int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                    b = dimensionPixelSize;
                    a = true;
                    Log.d("StatusBarHeightUtil", String.format("Get status bar height %d", Integer.valueOf(dimensionPixelSize)));
                }
                i = b;
            }
            return i;
        }
        return invokeL.intValue;
    }
}
