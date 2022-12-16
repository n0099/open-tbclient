package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.rh9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes6.dex */
public final class sh9 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static rh9.a b;
    public static rh9.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948151557, "Lcom/baidu/tieba/sh9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948151557, "Lcom/baidu/tieba/sh9;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (sh9.class) {
                if (!a) {
                    ei9.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new th9();
                    c = new di9();
                    rh9.a().c();
                    rh9.a().d(c);
                    rh9.a().d(b);
                    rh9.a().e(context);
                    a = true;
                    return;
                }
                ei9.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
