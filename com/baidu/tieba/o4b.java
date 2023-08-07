package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.n4b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes7.dex */
public final class o4b {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static n4b.a b;
    public static n4b.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947983692, "Lcom/baidu/tieba/o4b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947983692, "Lcom/baidu/tieba/o4b;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (o4b.class) {
                if (!a) {
                    a5b.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new p4b();
                    c = new z4b();
                    n4b.a().c();
                    n4b.a().d(c);
                    n4b.a().d(b);
                    n4b.a().e(context);
                    a = true;
                    return;
                }
                a5b.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
