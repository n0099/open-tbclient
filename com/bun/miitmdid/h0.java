package com.bun.miitmdid;

import androidx.annotation.Keep;
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
@Keep
/* loaded from: classes8.dex */
public class h0 {
    public static /* synthetic */ Interceptable $ic = null;
    @Keep
    public static int a = 2;
    @Keep
    public static int b = 6000;
    @Keep
    public static int c = 5;
    @Keep
    public static BlockingQueue<Runnable> d;
    @Keep
    public static ThreadFactory e;
    @Keep
    public static ThreadPoolExecutor f;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    /* loaded from: classes8.dex */
    public class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Keep
        public final AtomicInteger a;

        public a() {
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
            this.a = new AtomicInteger();
        }

        @Override // java.util.concurrent.ThreadFactory
        @Keep
        public native Thread newThread(Runnable runnable);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1731451189, "Lcom/bun/miitmdid/h0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1731451189, "Lcom/bun/miitmdid/h0;");
                return;
            }
        }
        d = new ArrayBlockingQueue(3);
        e = new a();
        f = new ThreadPoolExecutor(a, c, b, TimeUnit.SECONDS, d, e);
    }

    @Keep
    public static native void a(Runnable runnable);
}
