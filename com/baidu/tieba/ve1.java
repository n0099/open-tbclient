package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ve1 {
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
                if (baseContext == null || (f = ig1.f(baseContext, "mPackageInfo")) == null || (classLoader = (ClassLoader) ig1.f(f, "mClassLoader")) == null) {
                    return false;
                }
                we1 we1Var = new we1(classLoader.getParent(), classLoader);
                ig1.k(f, "mClassLoader", we1Var);
                Thread.currentThread().setContextClassLoader(we1Var);
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
