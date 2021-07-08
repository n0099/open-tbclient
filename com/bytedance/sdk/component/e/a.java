package com.bytedance.sdk.component.e;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.j;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class a extends ThreadPoolExecutor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f28842a;

    /* renamed from: com.bytedance.sdk.component.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0324a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f28850a;

        /* renamed from: b  reason: collision with root package name */
        public int f28851b;

        /* renamed from: c  reason: collision with root package name */
        public long f28852c;

        /* renamed from: d  reason: collision with root package name */
        public TimeUnit f28853d;

        /* renamed from: e  reason: collision with root package name */
        public int f28854e;

        /* renamed from: f  reason: collision with root package name */
        public BlockingQueue<Runnable> f28855f;

        /* renamed from: g  reason: collision with root package name */
        public ThreadFactory f28856g;

        /* renamed from: h  reason: collision with root package name */
        public RejectedExecutionHandler f28857h;

        /* renamed from: i  reason: collision with root package name */
        public int f28858i;

        public C0324a() {
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
            this.f28850a = "io";
            this.f28851b = 1;
            this.f28852c = 30L;
            this.f28853d = TimeUnit.SECONDS;
            this.f28854e = 1;
            this.f28855f = null;
            this.f28856g = null;
            this.f28858i = 5;
        }

        public C0324a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f28850a = str;
                return this;
            }
            return (C0324a) invokeL.objValue;
        }

        public C0324a b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.f28854e = i2;
                return this;
            }
            return (C0324a) invokeI.objValue;
        }

        public C0324a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f28851b = i2;
                return this;
            }
            return (C0324a) invokeI.objValue;
        }

        public C0324a a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                this.f28852c = j;
                return this;
            }
            return (C0324a) invokeJ.objValue;
        }

        public C0324a a(TimeUnit timeUnit) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, timeUnit)) == null) {
                this.f28853d = timeUnit;
                return this;
            }
            return (C0324a) invokeL.objValue;
        }

        public C0324a a(BlockingQueue<Runnable> blockingQueue) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, blockingQueue)) == null) {
                this.f28855f = blockingQueue;
                return this;
            }
            return (C0324a) invokeL.objValue;
        }

        public C0324a a(RejectedExecutionHandler rejectedExecutionHandler) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rejectedExecutionHandler)) == null) {
                this.f28857h = rejectedExecutionHandler;
                return this;
            }
            return (C0324a) invokeL.objValue;
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.f28856g == null) {
                    this.f28856g = new h(this.f28858i, this.f28850a);
                }
                if (this.f28857h == null) {
                    this.f28857h = e.f();
                }
                if (this.f28855f == null) {
                    this.f28855f = new LinkedBlockingQueue();
                }
                return new a(this.f28850a, this.f28851b, this.f28854e, this.f28852c, this.f28853d, this.f28855f, this.f28856g, this.f28857h);
            }
            return (a) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str, int i2, int i3, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i2, i3, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler};
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
        this.f28842a = str;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28842a : (String) invokeV.objValue;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        BlockingQueue<Runnable> queue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, th) == null) {
            super.afterExecute(runnable, th);
            if (!e.e() || TextUtils.isEmpty(this.f28842a) || (queue = getQueue()) == null) {
                return;
            }
            String str = this.f28842a;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 107332) {
                if (hashCode == 2993840 && str.equals("aidl")) {
                    c2 = 0;
                }
            } else if (str.equals(TbConfig.TMP_LOG_DIR_NAME)) {
                c2 = 1;
            }
            if (c2 != 0) {
                if (c2 == 1 && queue.size() >= 4 && getCorePoolSize() != 2) {
                    setCorePoolSize(2);
                    setMaximumPoolSize(4);
                    j.b("ADThreadPoolExecutor", "afterExecute: reduce ", this.f28842a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
                }
            } else if (queue.size() >= 4 || getCorePoolSize() == 0) {
            } else {
                try {
                    setCorePoolSize(0);
                    setMaximumPoolSize(4);
                    j.b("ADThreadPoolExecutor", "afterExecute: reduce ", this.f28842a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
                } catch (Exception e2) {
                    j.c("ADThreadPoolExecutor", e2.getMessage());
                }
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        BlockingQueue<Runnable> queue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
            if (runnable instanceof g) {
                super.execute(new b((g) runnable, this));
            } else {
                super.execute(new b(new g(this, "unknown", runnable) { // from class: com.bytedance.sdk.component.e.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Runnable f28843a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f28844b;

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
                        this.f28844b = this;
                        this.f28843a = runnable;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f28843a.run();
                        }
                    }
                }, this));
            }
            if (!e.e() || TextUtils.isEmpty(this.f28842a) || (queue = getQueue()) == null) {
                return;
            }
            String str = this.f28842a;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 107332) {
                if (hashCode == 2993840 && str.equals("aidl")) {
                    c2 = 0;
                }
            } else if (str.equals(TbConfig.TMP_LOG_DIR_NAME)) {
                c2 = 1;
            }
            if (c2 != 0) {
                if (c2 == 1 && queue.size() >= 4 && getCorePoolSize() != 4) {
                    setMaximumPoolSize(e.f28876a + 4);
                    setCorePoolSize(4);
                    j.b("ADThreadPoolExecutor", "execute: increase poolType =  ", this.f28842a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
                }
            } else if (queue.size() < 4 || getCorePoolSize() == 4) {
            } else {
                try {
                    setMaximumPoolSize(e.f28876a + 4);
                    setCorePoolSize(4);
                    j.b("ADThreadPoolExecutor", "execute: increase poolType =  ", this.f28842a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
                } catch (Exception e2) {
                    j.c("ADThreadPoolExecutor", e2.getMessage());
                }
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || "io".equals(this.f28842a) || "aidl".equals(this.f28842a)) {
            return;
        }
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!"io".equals(this.f28842a) && !"aidl".equals(this.f28842a)) {
                return super.shutdownNow();
            }
            return Collections.emptyList();
        }
        return (List) invokeV.objValue;
    }
}
