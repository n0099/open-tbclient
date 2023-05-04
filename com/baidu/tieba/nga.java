package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.mga;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes5.dex */
public final class nga {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static mga.a b;
    public static mga.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948002881, "Lcom/baidu/tieba/nga;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948002881, "Lcom/baidu/tieba/nga;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (nga.class) {
                if (!a) {
                    zga.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new oga();
                    c = new yga();
                    mga.a().c();
                    mga.a().d(c);
                    mga.a().d(b);
                    mga.a().e(context);
                    a = true;
                    return;
                }
                zga.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
