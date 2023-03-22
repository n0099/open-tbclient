package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.schedulers.GenericScheduledExecutorServiceFactory;
/* loaded from: classes5.dex */
public final class lta implements pta {
    public static /* synthetic */ Interceptable $ic;
    public static final ScheduledExecutorService[] b;
    public static final ScheduledExecutorService c;
    public static final lta d;
    public static int e;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference<ScheduledExecutorService[]> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947955792, "Lcom/baidu/tieba/lta;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947955792, "Lcom/baidu/tieba/lta;");
                return;
            }
        }
        b = new ScheduledExecutorService[0];
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        c = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        d = new lta();
    }

    public static ScheduledExecutorService a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ScheduledExecutorService[] scheduledExecutorServiceArr = d.a.get();
            if (scheduledExecutorServiceArr == b) {
                return c;
            }
            int i = e + 1;
            if (i >= scheduledExecutorServiceArr.length) {
                i = 0;
            }
            e = i;
            return scheduledExecutorServiceArr[i];
        }
        return (ScheduledExecutorService) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pta
    public void shutdown() {
        ScheduledExecutorService[] scheduledExecutorServiceArr;
        ScheduledExecutorService[] scheduledExecutorServiceArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            do {
                scheduledExecutorServiceArr = this.a.get();
                scheduledExecutorServiceArr2 = b;
                if (scheduledExecutorServiceArr == scheduledExecutorServiceArr2) {
                    return;
                }
            } while (!this.a.compareAndSet(scheduledExecutorServiceArr, scheduledExecutorServiceArr2));
            for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
                ota.d(scheduledExecutorService);
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    public lta() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new AtomicReference<>(b);
        start();
    }

    @Override // com.baidu.tieba.pta
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            if (availableProcessors > 4) {
                availableProcessors /= 2;
            }
            if (availableProcessors > 8) {
                availableProcessors = 8;
            }
            ScheduledExecutorService[] scheduledExecutorServiceArr = new ScheduledExecutorService[availableProcessors];
            int i = 0;
            for (int i2 = 0; i2 < availableProcessors; i2++) {
                scheduledExecutorServiceArr[i2] = GenericScheduledExecutorServiceFactory.create();
            }
            if (this.a.compareAndSet(b, scheduledExecutorServiceArr)) {
                while (i < availableProcessors) {
                    ScheduledExecutorService scheduledExecutorService = scheduledExecutorServiceArr[i];
                    if (!ota.k(scheduledExecutorService) && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
                        ota.g((ScheduledThreadPoolExecutor) scheduledExecutorService);
                    }
                    i++;
                }
                return;
            }
            while (i < availableProcessors) {
                scheduledExecutorServiceArr[i].shutdownNow();
                i++;
            }
        }
    }
}
