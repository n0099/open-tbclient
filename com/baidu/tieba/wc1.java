package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wc1 {
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
                if (baseContext == null || (f = je1.f(baseContext, "mPackageInfo")) == null || (classLoader = (ClassLoader) je1.f(f, "mClassLoader")) == null) {
                    return false;
                }
                xc1 xc1Var = new xc1(classLoader.getParent(), classLoader);
                je1.k(f, "mClassLoader", xc1Var);
                Thread.currentThread().setContextClassLoader(xc1Var);
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
