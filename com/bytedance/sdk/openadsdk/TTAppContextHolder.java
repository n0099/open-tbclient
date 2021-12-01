package com.bytedance.sdk.openadsdk;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.api.b.d;
import java.lang.reflect.Method;
/* loaded from: classes12.dex */
public class TTAppContextHolder {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile Context a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes12.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        @SuppressLint({"StaticFieldLeak"})
        public static volatile Application a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1345061329, "Lcom/bytedance/sdk/openadsdk/TTAppContextHolder$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1345061329, "Lcom/bytedance/sdk/openadsdk/TTAppContextHolder$a;");
                    return;
                }
            }
            try {
                Object b2 = b();
                a = (Application) b2.getClass().getMethod("getApplication", new Class[0]).invoke(b2, new Object[0]);
                d.c("MyApplication", "application get success");
            } catch (Throwable th) {
                d.b("MyApplication", "application get failed", th);
            }
        }

        public static Application a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a : (Application) invokeV.objValue;
        }

        public static Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                try {
                    Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                    method.setAccessible(true);
                    return method.invoke(null, new Object[0]);
                } catch (Throwable th) {
                    d.b("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    public TTAppContextHolder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                setContext(null);
            }
            return a;
        }
        return (Context) invokeV.objValue;
    }

    public static synchronized void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            synchronized (TTAppContextHolder.class) {
                if (a == null) {
                    if (context != null) {
                        a = context.getApplicationContext();
                    } else if (a.a() != null) {
                        try {
                            a = a.a();
                            if (a != null) {
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
    }
}
