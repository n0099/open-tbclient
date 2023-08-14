package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.o4b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes7.dex */
public final class p4b {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static o4b.a b;
    public static o4b.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948013483, "Lcom/baidu/tieba/p4b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948013483, "Lcom/baidu/tieba/p4b;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (p4b.class) {
                if (!a) {
                    b5b.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new q4b();
                    c = new a5b();
                    o4b.a().c();
                    o4b.a().d(c);
                    o4b.a().d(b);
                    o4b.a().e(context);
                    a = true;
                    return;
                }
                b5b.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
