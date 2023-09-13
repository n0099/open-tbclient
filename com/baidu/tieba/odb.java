package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.ndb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes7.dex */
public final class odb {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static ndb.a b;
    public static ndb.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948029820, "Lcom/baidu/tieba/odb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948029820, "Lcom/baidu/tieba/odb;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (odb.class) {
                if (!a) {
                    aeb.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new pdb();
                    c = new zdb();
                    ndb.a().c();
                    ndb.a().d(c);
                    ndb.a().d(b);
                    ndb.a().e(context);
                    a = true;
                    return;
                }
                aeb.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
