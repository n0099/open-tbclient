package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes7.dex */
public final class GlideExecutor implements ExecutorService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_ANIMATION_EXECUTOR_NAME = "animation";
    public static final String DEFAULT_DISK_CACHE_EXECUTOR_NAME = "disk-cache";
    public static final int DEFAULT_DISK_CACHE_EXECUTOR_THREADS = 1;
    public static final String DEFAULT_SOURCE_EXECUTOR_NAME = "source";
    public static final String DEFAULT_SOURCE_UNLIMITED_EXECUTOR_NAME = "source-unlimited";
    public static final long KEEP_ALIVE_TIME_MS;
    public static final int MAXIMUM_AUTOMATIC_THREAD_COUNT = 4;
    public static final String TAG = "GlideExecutor";
    public static volatile int bestThreadCount;
    public transient /* synthetic */ FieldHolder $fh;
    public final ExecutorService delegate;

    /* loaded from: classes7.dex */
    public interface UncaughtThrowableStrategy {
        public static final UncaughtThrowableStrategy IGNORE = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                }
            }

            {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        };
        public static final UncaughtThrowableStrategy LOG = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, th) == null) && th != null && Log.isLoggable(GlideExecutor.TAG, 6)) {
                    Log.e(GlideExecutor.TAG, "Request threw uncaught throwable", th);
                }
            }
        };
        public static final UncaughtThrowableStrategy THROW = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(1048576, this, th) != null) || th == null) {
                    return;
                }
                throw new RuntimeException("Request threw uncaught throwable", th);
            }
        };
        public static final UncaughtThrowableStrategy DEFAULT = LOG;

        void handle(Throwable th);
    }

    /* loaded from: classes7.dex */
    public final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public static final long NO_THREAD_TIMEOUT = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public int corePoolSize;
        public int maximumPoolSize;
        public String name;
        public final boolean preventNetworkOperations;
        public long threadTimeoutMillis;
        public UncaughtThrowableStrategy uncaughtThrowableStrategy;

        public Builder(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.uncaughtThrowableStrategy = UncaughtThrowableStrategy.DEFAULT;
            this.preventNetworkOperations = z;
        }

        public GlideExecutor build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!TextUtils.isEmpty(this.name)) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.corePoolSize, this.maximumPoolSize, this.threadTimeoutMillis, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(this.name, this.uncaughtThrowableStrategy, this.preventNetworkOperations));
                    if (this.threadTimeoutMillis != 0) {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    }
                    return new GlideExecutor(threadPoolExecutor);
                }
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.name);
            }
            return (GlideExecutor) invokeV.objValue;
        }

        public Builder setName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.name = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setThreadCount(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.corePoolSize = i;
                this.maximumPoolSize = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setThreadTimeoutMillis(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                this.threadTimeoutMillis = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder setUncaughtThrowableStrategy(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, uncaughtThrowableStrategy)) == null) {
                this.uncaughtThrowableStrategy = uncaughtThrowableStrategy;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class DefaultThreadFactory implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DEFAULT_PRIORITY = 9;
        public transient /* synthetic */ FieldHolder $fh;
        public final String name;
        public final boolean preventNetworkOperations;
        public int threadNum;
        public final UncaughtThrowableStrategy uncaughtThrowableStrategy;

        public DefaultThreadFactory(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, uncaughtThrowableStrategy, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.name = str;
            this.uncaughtThrowableStrategy = uncaughtThrowableStrategy;
            this.preventNetworkOperations = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Thread thread;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                synchronized (this) {
                    thread = new Thread(this, runnable, "glide-" + this.name + "-thread-" + this.threadNum) { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.DefaultThreadFactory.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DefaultThreadFactory this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(runnable, r10);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, runnable, r10};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    Object[] objArr2 = newInitContext.callArgs;
                                    super((Runnable) objArr2[0], (String) objArr2[1]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                Process.setThreadPriority(9);
                                if (this.this$0.preventNetworkOperations) {
                                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                                }
                                try {
                                    super.run();
                                } catch (Throwable th) {
                                    this.this$0.uncaughtThrowableStrategy.handle(th);
                                }
                            }
                        }
                    };
                    this.threadNum = this.threadNum + 1;
                }
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-374450776, "Lcom/bumptech/glide/load/engine/executor/GlideExecutor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-374450776, "Lcom/bumptech/glide/load/engine/executor/GlideExecutor;");
                return;
            }
        }
        KEEP_ALIVE_TIME_MS = TimeUnit.SECONDS.toMillis(10L);
    }

    public static int calculateBestThreadCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (bestThreadCount == 0) {
                bestThreadCount = Math.min(4, RuntimeCompat.availableProcessors());
            }
            return bestThreadCount;
        }
        return invokeV.intValue;
    }

    public static Builder newAnimationBuilder() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (calculateBestThreadCount() >= 4) {
                i = 2;
            } else {
                i = 1;
            }
            return new Builder(true).setThreadCount(i).setName("animation");
        }
        return (Builder) invokeV.objValue;
    }

    public static GlideExecutor newAnimationExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return newAnimationBuilder().build();
        }
        return (GlideExecutor) invokeV.objValue;
    }

    public static Builder newDiskCacheBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return new Builder(true).setThreadCount(1).setName(DEFAULT_DISK_CACHE_EXECUTOR_NAME);
        }
        return (Builder) invokeV.objValue;
    }

    public static GlideExecutor newDiskCacheExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return newDiskCacheBuilder().build();
        }
        return (GlideExecutor) invokeV.objValue;
    }

    public static Builder newSourceBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return new Builder(false).setThreadCount(calculateBestThreadCount()).setName("source");
        }
        return (Builder) invokeV.objValue;
    }

    public static GlideExecutor newSourceExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return newSourceBuilder().build();
        }
        return (GlideExecutor) invokeV.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.delegate.isShutdown();
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.delegate.isTerminated();
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.delegate.shutdown();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public List shutdownNow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.delegate.shutdownNow();
        }
        return (List) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.delegate.toString();
        }
        return (String) invokeV.objValue;
    }

    public GlideExecutor(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executorService};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.delegate = executorService;
    }

    @Deprecated
    public static GlideExecutor newDiskCacheExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, uncaughtThrowableStrategy)) == null) {
            return newDiskCacheBuilder().setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
        }
        return (GlideExecutor) invokeL.objValue;
    }

    @Deprecated
    public static GlideExecutor newSourceExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, uncaughtThrowableStrategy)) == null) {
            return newSourceBuilder().setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
        }
        return (GlideExecutor) invokeL.objValue;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
            this.delegate.execute(runnable);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection) throws InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) {
            return this.delegate.invokeAll(collection);
        }
        return (List) invokeL.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection) throws InterruptedException, ExecutionException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, collection)) == null) {
            return this.delegate.invokeAny(collection);
        }
        return invokeL.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, runnable)) == null) {
            return this.delegate.submit(runnable);
        }
        return (Future) invokeL.objValue;
    }

    @Deprecated
    public static GlideExecutor newAnimationExecutor(int i, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65541, null, i, uncaughtThrowableStrategy)) == null) {
            return newAnimationBuilder().setThreadCount(i).setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
        }
        return (GlideExecutor) invokeIL.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return this.delegate.awaitTermination(j, timeUnit);
        }
        return invokeJL.booleanValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, runnable, obj)) == null) {
            return this.delegate.submit(runnable, obj);
        }
        return (Future) invokeLL.objValue;
    }

    @Deprecated
    public static GlideExecutor newDiskCacheExecutor(int i, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65544, null, i, str, uncaughtThrowableStrategy)) == null) {
            return newDiskCacheBuilder().setThreadCount(i).setName(str).setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
        }
        return (GlideExecutor) invokeILL.objValue;
    }

    @Deprecated
    public static GlideExecutor newSourceExecutor(int i, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65548, null, i, str, uncaughtThrowableStrategy)) == null) {
            return newSourceBuilder().setThreadCount(i).setName(str).setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
        }
        return (GlideExecutor) invokeILL.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection, long j, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{collection, Long.valueOf(j), timeUnit})) == null) {
            return this.delegate.invokeAll(collection, j, timeUnit);
        }
        return (List) invokeCommon.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{collection, Long.valueOf(j), timeUnit})) == null) {
            return this.delegate.invokeAny(collection, j, timeUnit);
        }
        return invokeCommon.objValue;
    }

    public static GlideExecutor newUnlimitedSourceExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, KEEP_ALIVE_TIME_MS, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory(DEFAULT_SOURCE_UNLIMITED_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT, false)));
        }
        return (GlideExecutor) invokeV.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Callable callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, callable)) == null) {
            return this.delegate.submit(callable);
        }
        return (Future) invokeL.objValue;
    }
}
