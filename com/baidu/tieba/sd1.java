package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class sd1 {
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
                if (baseContext == null || (f = ff1.f(baseContext, "mPackageInfo")) == null || (classLoader = (ClassLoader) ff1.f(f, "mClassLoader")) == null) {
                    return false;
                }
                td1 td1Var = new td1(classLoader.getParent(), classLoader);
                ff1.k(f, "mClassLoader", td1Var);
                Thread.currentThread().setContextClassLoader(td1Var);
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
