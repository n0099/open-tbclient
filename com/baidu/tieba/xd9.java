package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.wd9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes6.dex */
public final class xd9 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static wd9.a b;
    public static wd9.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948296668, "Lcom/baidu/tieba/xd9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948296668, "Lcom/baidu/tieba/xd9;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (xd9.class) {
                if (!a) {
                    je9.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new yd9();
                    c = new ie9();
                    wd9.a().c();
                    wd9.a().d(c);
                    wd9.a().d(b);
                    wd9.a().e(context);
                    a = true;
                    return;
                }
                je9.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
