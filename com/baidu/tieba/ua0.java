package com.baidu.tieba;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class ua0 {
    public static /* synthetic */ Interceptable $ic;
    public static ua0 d;
    public static final int e;
    public static final int f;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadPoolExecutor a;
    public ExecutorService b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948204133, "Lcom/baidu/tieba/ua0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948204133, "Lcom/baidu/tieba/ua0;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        e = availableProcessors;
        f = Math.max(2, Math.min(availableProcessors - 1, 4));
        g = (e * 2) + 1;
    }

    public ua0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.c = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f, g, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.b = Executors.newSingleThreadExecutor();
    }

    public static ua0 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (d == null) {
                synchronized (ua0.class) {
                    if (d == null) {
                        d = new ua0(context);
                    }
                }
            }
            return d;
        }
        return (ua0) invokeL.objValue;
    }

    public void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            try {
                this.a.submit(runnable);
            } catch (Throwable th) {
                if (wa0.a) {
                    xa0.c("TaskManager", "Exception ", th);
                }
            }
        }
    }
}
