package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class w71 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Application application) {
        InterceptResult invokeL;
        Object f;
        ClassLoader classLoader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, application)) == null) {
            try {
                Context baseContext = application.getBaseContext();
                if (baseContext == null || (f = j91.f(baseContext, "mPackageInfo")) == null || (classLoader = (ClassLoader) j91.f(f, "mClassLoader")) == null) {
                    return false;
                }
                x71 x71Var = new x71(classLoader.getParent(), classLoader);
                j91.k(f, "mClassLoader", x71Var);
                Thread.currentThread().setContextClassLoader(x71Var);
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
