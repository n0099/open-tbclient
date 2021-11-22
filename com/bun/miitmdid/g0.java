package com.bun.miitmdid;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes11.dex */
public class g0 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f62075a = 2;

    /* renamed from: b  reason: collision with root package name */
    public static int f62076b = 6000;

    /* renamed from: c  reason: collision with root package name */
    public static int f62077c = 5;

    /* renamed from: d  reason: collision with root package name */
    public static BlockingQueue<Runnable> f62078d;

    /* renamed from: e  reason: collision with root package name */
    public static ThreadFactory f62079e;

    /* renamed from: f  reason: collision with root package name */
    public static ThreadPoolExecutor f62080f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public static class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f62081a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62081a = new AtomicInteger();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                return new Thread(runnable, "OAIDSDK ThreadPool thread:" + this.f62081a.getAndIncrement());
            }
            return (Thread) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1731452150, "Lcom/bun/miitmdid/g0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1731452150, "Lcom/bun/miitmdid/g0;");
                return;
            }
        }
        f62078d = new ArrayBlockingQueue(3);
        f62079e = new a();
        f62080f = new ThreadPoolExecutor(f62075a, f62077c, f62076b, TimeUnit.SECONDS, f62078d, f62079e);
    }

    public static void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, runnable) == null) {
            f62080f.execute(runnable);
        }
    }
}
