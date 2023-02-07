package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.hr9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes5.dex */
public final class ir9 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static hr9.a b;
    public static hr9.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947863257, "Lcom/baidu/tieba/ir9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947863257, "Lcom/baidu/tieba/ir9;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (ir9.class) {
                if (!a) {
                    ur9.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new jr9();
                    c = new tr9();
                    hr9.a().c();
                    hr9.a().d(c);
                    hr9.a().d(b);
                    hr9.a().e(context);
                    a = true;
                    return;
                }
                ur9.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
