package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.ie9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes4.dex */
public final class je9 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static ie9.a b;
    public static ie9.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947880555, "Lcom/baidu/tieba/je9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947880555, "Lcom/baidu/tieba/je9;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (je9.class) {
                if (!a) {
                    ve9.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new ke9();
                    c = new ue9();
                    ie9.a().c();
                    ie9.a().d(c);
                    ie9.a().d(b);
                    ie9.a().e(context);
                    a = true;
                    return;
                }
                ve9.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
