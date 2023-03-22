package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class l5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ThreadPoolExecutor a;

    /* loaded from: classes5.dex */
    public class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AtomicInteger a;

        public a(l5 l5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l5Var};
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
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                Thread thread = new Thread(runnable, "NetThread" + this.a.getAndIncrement());
                thread.setDaemon(true);
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    public l5(int i) {
        boolean z;
        int i2;
        BlockingQueue linkedBlockingQueue;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (i == Integer.MAX_VALUE) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i2 = 0;
        } else {
            i2 = i;
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        if (z) {
            linkedBlockingQueue = new SynchronousQueue();
        } else {
            linkedBlockingQueue = new LinkedBlockingQueue();
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i, 60L, timeUnit, linkedBlockingQueue, new a(this));
        this.a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(!z);
        new g7();
        new g7();
    }
}
