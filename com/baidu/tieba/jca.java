package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.ica;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes5.dex */
public final class jca {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static ica.a b;
    public static ica.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947879873, "Lcom/baidu/tieba/jca;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947879873, "Lcom/baidu/tieba/jca;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (jca.class) {
                if (!a) {
                    vca.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new kca();
                    c = new uca();
                    ica.a().c();
                    ica.a().d(c);
                    ica.a().d(b);
                    ica.a().e(context);
                    a = true;
                    return;
                }
                vca.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
