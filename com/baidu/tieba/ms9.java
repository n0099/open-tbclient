package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.ls9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes5.dex */
public final class ms9 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static ls9.a b;
    public static ls9.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947983382, "Lcom/baidu/tieba/ms9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947983382, "Lcom/baidu/tieba/ms9;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (ms9.class) {
                if (!a) {
                    ys9.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new ns9();
                    c = new xs9();
                    ls9.a().c();
                    ls9.a().d(c);
                    ls9.a().d(b);
                    ls9.a().e(context);
                    a = true;
                    return;
                }
                ys9.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
