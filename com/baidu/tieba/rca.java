package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.qca;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes6.dex */
public final class rca {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static qca.a b;
    public static qca.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948118201, "Lcom/baidu/tieba/rca;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948118201, "Lcom/baidu/tieba/rca;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (rca.class) {
                if (!a) {
                    dda.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new sca();
                    c = new cda();
                    qca.a().c();
                    qca.a().d(c);
                    qca.a().d(b);
                    qca.a().e(context);
                    a = true;
                    return;
                }
                dda.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
