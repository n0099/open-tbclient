package com.baidu.webkit.internal.daemon;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.Log;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class ZeusThreadPoolUtil implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CPU_COUNT;
    public static final String LOG_TAG = "ZeusThreadPoolUtil";
    public static final int THREAD_POOL_KEEP_ALIVE_TIME = 60;
    public static final int THREAD_POOL_MAX = 4;
    public static final int THREAD_POOL_MIN = 2;
    public static ThreadPoolExecutor mExecutor;
    public static Queue<Runnable> mLazyRunQueue;
    public static volatile boolean sIsZeusLoaded;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                Thread thread = new Thread(runnable);
                thread.setDaemon(true);
                thread.setName("T7@ZeusThreadPool");
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1781800974, "Lcom/baidu/webkit/internal/daemon/ZeusThreadPoolUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1781800974, "Lcom/baidu/webkit/internal/daemon/ZeusThreadPoolUtil;");
                return;
            }
        }
        CPU_COUNT = Runtime.getRuntime().availableProcessors();
    }

    public ZeusThreadPoolUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void doExecute(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, runnable) == null) {
            try {
                if (mExecutor == null) {
                    start();
                }
                if (mExecutor == null || runnable == null) {
                    return;
                }
                Log.d(LOG_TAG, "execute task:".concat(String.valueOf(runnable)));
                mExecutor.execute(runnable);
            } catch (Throwable th) {
                Log.printStackTrace(th);
            }
        }
    }

    public static void execute(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            synchronized (ZeusThreadPoolUtil.class) {
                if (sIsZeusLoaded) {
                    doExecute(runnable);
                    return;
                }
                if (mLazyRunQueue == null) {
                    mLazyRunQueue = new ConcurrentLinkedQueue();
                }
                mLazyRunQueue.add(runnable);
                Log.d(LOG_TAG, "WebkitUnLoaded execute task=".concat(String.valueOf(runnable)));
            }
        }
    }

    public static void executeIgnoreZeus(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, runnable) == null) {
            doExecute(runnable);
        }
    }

    public static void notifyZeusLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            Log.d(LOG_TAG, "notifyZeusLoaded");
            synchronized (ZeusThreadPoolUtil.class) {
                sIsZeusLoaded = true;
                if (mLazyRunQueue != null) {
                    Runnable poll = mLazyRunQueue.poll();
                    while (true) {
                        Runnable runnable = poll;
                        if (runnable == null) {
                            break;
                        }
                        doExecute(runnable);
                        poll = mLazyRunQueue.poll();
                    }
                }
            }
        }
    }

    public static void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            Log.d(LOG_TAG, "start");
            try {
                synchronized (ZeusThreadPoolUtil.class) {
                    if (mExecutor == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a((byte) 0), new ThreadPoolExecutor.DiscardOldestPolicy());
                        mExecutor = threadPoolExecutor;
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            Log.d(LOG_TAG, IntentConfig.STOP);
            try {
                synchronized (ZeusThreadPoolUtil.class) {
                    if (mExecutor != null) {
                        mExecutor.shutdownNow();
                        mExecutor = null;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
