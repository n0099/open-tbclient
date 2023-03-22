package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.r2a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes6.dex */
public final class s2a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static r2a.a b;
    public static r2a.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948100903, "Lcom/baidu/tieba/s2a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948100903, "Lcom/baidu/tieba/s2a;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (s2a.class) {
                if (!a) {
                    e3a.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new t2a();
                    c = new d3a();
                    r2a.a().c();
                    r2a.a().d(c);
                    r2a.a().d(b);
                    r2a.a().e(context);
                    a = true;
                    return;
                }
                e3a.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
