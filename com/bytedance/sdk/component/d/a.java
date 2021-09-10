package com.bytedance.sdk.component.d;

import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class a extends ThreadPoolExecutor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f65020a;

    /* renamed from: com.bytedance.sdk.component.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1887a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f65028a;

        /* renamed from: b  reason: collision with root package name */
        public int f65029b;

        /* renamed from: c  reason: collision with root package name */
        public long f65030c;

        /* renamed from: d  reason: collision with root package name */
        public TimeUnit f65031d;

        /* renamed from: e  reason: collision with root package name */
        public int f65032e;

        /* renamed from: f  reason: collision with root package name */
        public BlockingQueue<Runnable> f65033f;

        /* renamed from: g  reason: collision with root package name */
        public ThreadFactory f65034g;

        /* renamed from: h  reason: collision with root package name */
        public RejectedExecutionHandler f65035h;

        /* renamed from: i  reason: collision with root package name */
        public int f65036i;

        public C1887a() {
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
            this.f65028a = "io";
            this.f65029b = 1;
            this.f65030c = 30L;
            this.f65031d = TimeUnit.SECONDS;
            this.f65032e = Integer.MAX_VALUE;
            this.f65033f = null;
            this.f65034g = null;
            this.f65036i = 5;
        }

        public C1887a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f65028a = str;
                return this;
            }
            return (C1887a) invokeL.objValue;
        }

        public C1887a b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.f65036i = i2;
                return this;
            }
            return (C1887a) invokeI.objValue;
        }

        public C1887a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f65029b = i2;
                return this;
            }
            return (C1887a) invokeI.objValue;
        }

        public C1887a a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                this.f65030c = j2;
                return this;
            }
            return (C1887a) invokeJ.objValue;
        }

        public C1887a a(TimeUnit timeUnit) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, timeUnit)) == null) {
                this.f65031d = timeUnit;
                return this;
            }
            return (C1887a) invokeL.objValue;
        }

        public C1887a a(BlockingQueue<Runnable> blockingQueue) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, blockingQueue)) == null) {
                this.f65033f = blockingQueue;
                return this;
            }
            return (C1887a) invokeL.objValue;
        }

        public C1887a a(RejectedExecutionHandler rejectedExecutionHandler) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rejectedExecutionHandler)) == null) {
                this.f65035h = rejectedExecutionHandler;
                return this;
            }
            return (C1887a) invokeL.objValue;
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.f65034g == null) {
                    this.f65034g = new h(this.f65036i, this.f65028a);
                }
                if (this.f65035h == null) {
                    this.f65035h = e.f();
                }
                if (this.f65033f == null) {
                    this.f65033f = new LinkedBlockingQueue();
                }
                return new a(this.f65028a, this.f65029b, this.f65032e, this.f65030c, this.f65031d, this.f65033f, this.f65034g, this.f65035h);
            }
            return (a) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str, int i2, int i3, long j2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i2, i3, j2, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Long) objArr2[2]).longValue(), (TimeUnit) objArr2[3], (BlockingQueue) objArr2[4], (ThreadFactory) objArr2[5], (RejectedExecutionHandler) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65020a = str;
    }

    private void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, runnable) == null) {
            try {
                super.execute(runnable);
            } catch (OutOfMemoryError e2) {
                a(runnable, e2);
            } catch (Throwable th) {
                a(runnable, th);
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        BlockingQueue<Runnable> queue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, th) == null) {
            super.afterExecute(runnable, th);
            if (!e.e() || TextUtils.isEmpty(this.f65020a) || (queue = getQueue()) == null) {
                return;
            }
            String str = this.f65020a;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 3366) {
                if (hashCode != 107332) {
                    if (hashCode == 2993840 && str.equals("aidl")) {
                        c2 = 1;
                    }
                } else if (str.equals(TbConfig.TMP_LOG_DIR_NAME)) {
                    c2 = 2;
                }
            } else if (str.equals("io")) {
                c2 = 0;
            }
            if (c2 == 0) {
                a(queue, 4);
            } else if (c2 == 1) {
                a(queue, 1);
            } else if (c2 != 2) {
            } else {
                a(queue, 2);
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        BlockingQueue<Runnable> queue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
            if (runnable instanceof g) {
                a(new b((g) runnable, this));
            } else {
                a(new b(new g(this, "unknown", runnable) { // from class: com.bytedance.sdk.component.d.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Runnable f65021a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f65022b;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r8, runnable};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((String) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f65022b = this;
                        this.f65021a = runnable;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f65021a.run();
                        }
                    }
                }, this));
            }
            if (!e.e() || TextUtils.isEmpty(this.f65020a) || (queue = getQueue()) == null) {
                return;
            }
            String str = this.f65020a;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 3366) {
                if (hashCode != 107332) {
                    if (hashCode == 2993840 && str.equals("aidl")) {
                        c2 = 1;
                    }
                } else if (str.equals(TbConfig.TMP_LOG_DIR_NAME)) {
                    c2 = 2;
                }
            } else if (str.equals("io")) {
                c2 = 0;
            }
            if (c2 == 0) {
                a(queue, e.f65054a + 2, getCorePoolSize() * 2);
            } else if (c2 == 1) {
                a(queue, 4, 4);
            } else if (c2 != 2) {
            } else {
                a(queue, 6, 6);
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || "io".equals(this.f65020a) || "aidl".equals(this.f65020a)) {
            return;
        }
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!"io".equals(this.f65020a) && !"aidl".equals(this.f65020a)) {
                return super.shutdownNow();
            }
            return Collections.emptyList();
        }
        return (List) invokeV.objValue;
    }

    private void a(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, runnable, outOfMemoryError) == null) {
            a(runnable, (Throwable) outOfMemoryError);
        }
    }

    private void a(Runnable runnable, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, this, runnable, th) == null) || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        try {
            runnable.run();
        } catch (Throwable th2) {
            k.c("", "try exc failed", th2);
        }
    }

    private void a(BlockingQueue<Runnable> blockingQueue, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, blockingQueue, i2) == null) || getCorePoolSize() == i2 || blockingQueue == null || blockingQueue.size() > 0) {
            return;
        }
        try {
            setCorePoolSize(i2);
            k.b("ADThreadPoolExecutor", "reduceCoreThreadSize: reduce poolType =  ", this.f65020a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
        } catch (Exception e2) {
            k.c("ADThreadPoolExecutor", e2.getMessage());
        }
    }

    private void a(BlockingQueue<Runnable> blockingQueue, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(AdIconUtil.AD_TEXT_ID, this, blockingQueue, i2, i3) == null) || getCorePoolSize() == i2 || blockingQueue == null || blockingQueue.size() < i3) {
            return;
        }
        try {
            setCorePoolSize(i2);
            k.b("ADThreadPoolExecutor", "increaseCoreThreadSize: increase poolType =  ", this.f65020a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
        } catch (Exception e2) {
            k.c("ADThreadPoolExecutor", e2.getMessage());
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65020a : (String) invokeV.objValue;
    }
}
