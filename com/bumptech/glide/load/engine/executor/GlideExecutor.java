package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
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
/* loaded from: classes12.dex */
public final class GlideExecutor implements ExecutorService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ANIMATION_EXECUTOR_NAME = "animation";
    public static final String DEFAULT_DISK_CACHE_EXECUTOR_NAME = "disk-cache";
    public static final int DEFAULT_DISK_CACHE_EXECUTOR_THREADS = 1;
    public static final String DEFAULT_SOURCE_EXECUTOR_NAME = "source";
    public static final long KEEP_ALIVE_TIME_MS;
    public static final int MAXIMUM_AUTOMATIC_THREAD_COUNT = 4;
    public static final String SOURCE_UNLIMITED_EXECUTOR_NAME = "source-unlimited";
    public static final String TAG = "GlideExecutor";
    public static volatile int bestThreadCount;
    public transient /* synthetic */ FieldHolder $fh;
    public final ExecutorService delegate;

    /* loaded from: classes12.dex */
    public static final class DefaultThreadFactory implements ThreadFactory {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public synchronized Thread newThread(@NonNull Runnable runnable) {
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
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
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

    /* loaded from: classes12.dex */
    public interface UncaughtThrowableStrategy {
        public static final UncaughtThrowableStrategy IGNORE = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
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

            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, th) == null) || th == null) {
                    return;
                }
                Log.isLoggable(GlideExecutor.TAG, 6);
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, th) == null) && th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        };
        public static final UncaughtThrowableStrategy DEFAULT = LOG;

        void handle(Throwable th);
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

    @VisibleForTesting
    public GlideExecutor(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executorService};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.delegate = executorService;
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

    public static GlideExecutor newAnimationExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return newAnimationExecutor(calculateBestThreadCount() >= 4 ? 2 : 1, UncaughtThrowableStrategy.DEFAULT);
        }
        return (GlideExecutor) invokeV.objValue;
    }

    public static GlideExecutor newDiskCacheExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? newDiskCacheExecutor(1, DEFAULT_DISK_CACHE_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT) : (GlideExecutor) invokeV.objValue;
    }

    public static GlideExecutor newSourceExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? newSourceExecutor(calculateBestThreadCount(), "source", UncaughtThrowableStrategy.DEFAULT) : (GlideExecutor) invokeV.objValue;
    }

    public static GlideExecutor newUnlimitedSourceExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, KEEP_ALIVE_TIME_MS, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory(SOURCE_UNLIMITED_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT, false))) : (GlideExecutor) invokeV.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j2, timeUnit)) == null) ? this.delegate.awaitTermination(j2, timeUnit) : invokeJL.booleanValue;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
            this.delegate.execute(runnable);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) ? this.delegate.invokeAll(collection) : (List) invokeL.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, collection)) == null) ? (T) this.delegate.invokeAny(collection) : (T) invokeL.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.delegate.isShutdown() : invokeV.booleanValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.delegate.isTerminated() : invokeV.booleanValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.delegate.shutdown();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.delegate.shutdownNow() : (List) invokeV.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, runnable)) == null) ? this.delegate.submit(runnable) : (Future) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.delegate.toString() : (String) invokeV.objValue;
    }

    public static GlideExecutor newDiskCacheExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, uncaughtThrowableStrategy)) == null) ? newDiskCacheExecutor(1, DEFAULT_DISK_CACHE_EXECUTOR_NAME, uncaughtThrowableStrategy) : (GlideExecutor) invokeL.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{collection, Long.valueOf(j2), timeUnit})) == null) ? this.delegate.invokeAll(collection, j2, timeUnit) : (List) invokeCommon.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{collection, Long.valueOf(j2), timeUnit})) == null) ? (T) this.delegate.invokeAny(collection, j2, timeUnit) : (T) invokeCommon.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, runnable, t)) == null) ? this.delegate.submit(runnable, t) : (Future) invokeLL.objValue;
    }

    public static GlideExecutor newAnimationExecutor(int i2, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, uncaughtThrowableStrategy)) == null) ? new GlideExecutor(new ThreadPoolExecutor(0, i2, KEEP_ALIVE_TIME_MS, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory("animation", uncaughtThrowableStrategy, true))) : (GlideExecutor) invokeIL.objValue;
    }

    public static GlideExecutor newDiskCacheExecutor(int i2, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(65542, null, i2, str, uncaughtThrowableStrategy)) == null) ? new GlideExecutor(new ThreadPoolExecutor(i2, i2, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(str, uncaughtThrowableStrategy, true))) : (GlideExecutor) invokeILL.objValue;
    }

    public static GlideExecutor newSourceExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, uncaughtThrowableStrategy)) == null) ? newSourceExecutor(calculateBestThreadCount(), "source", uncaughtThrowableStrategy) : (GlideExecutor) invokeL.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, callable)) == null) ? this.delegate.submit(callable) : (Future) invokeL.objValue;
    }

    public static GlideExecutor newSourceExecutor(int i2, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(65545, null, i2, str, uncaughtThrowableStrategy)) == null) ? new GlideExecutor(new ThreadPoolExecutor(i2, i2, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(str, uncaughtThrowableStrategy, false))) : (GlideExecutor) invokeILL.objValue;
    }
}
