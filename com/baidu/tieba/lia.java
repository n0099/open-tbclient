package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.kia;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes6.dex */
public final class lia {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static kia.a b;
    public static kia.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947945221, "Lcom/baidu/tieba/lia;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947945221, "Lcom/baidu/tieba/lia;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (lia.class) {
                if (!a) {
                    xia.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new mia();
                    c = new wia();
                    kia.a().c();
                    kia.a().d(c);
                    kia.a().d(b);
                    kia.a().e(context);
                    a = true;
                    return;
                }
                xia.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
