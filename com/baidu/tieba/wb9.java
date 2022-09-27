package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.vb9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes6.dex */
public final class wb9 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static vb9.a b;
    public static vb9.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948264955, "Lcom/baidu/tieba/wb9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948264955, "Lcom/baidu/tieba/wb9;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (wb9.class) {
                if (!a) {
                    ic9.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new xb9();
                    c = new hc9();
                    vb9.a().c();
                    vb9.a().d(c);
                    vb9.a().d(b);
                    vb9.a().e(context);
                    a = true;
                    return;
                }
                ic9.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
