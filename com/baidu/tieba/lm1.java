package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class lm1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lm1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadPoolExecutor a;
    public ScheduledThreadPoolExecutor b;

    public lm1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b();
    }

    public static lm1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (lm1.class) {
                    if (c == null) {
                        c = new lm1();
                    }
                }
            }
            return c;
        }
        return (lm1) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = mm1.g(5, 15);
            this.b = mm1.f(3);
        }
    }

    public void c(Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) && runnable != null) {
            try {
                this.a.submit(runnable);
            } catch (Throwable unused) {
            }
        }
    }

    public void d(km1 km1Var, long j, long j2, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{km1Var, Long.valueOf(j), Long.valueOf(j2), timeUnit}) == null) && km1Var != null && (scheduledThreadPoolExecutor = this.b) != null && !scheduledThreadPoolExecutor.isShutdown()) {
            try {
                km1Var.i(System.currentTimeMillis());
                km1Var.h(this.b.scheduleAtFixedRate(km1Var, j, j2, timeUnit));
            } catch (Throwable unused) {
            }
        }
    }
}
