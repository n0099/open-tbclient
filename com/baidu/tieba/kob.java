package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qmb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.schedulers.ScheduledAction;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes6.dex */
public final class kob extends qmb implements rob {
    public static /* synthetic */ Interceptable $ic;
    public static final long c;
    public static final TimeUnit d;
    public static final c e;
    public static final a f;
    public transient /* synthetic */ FieldHolder $fh;
    public final ThreadFactory a;
    public final AtomicReference<a> b;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ThreadFactory a;
        public final long b;
        public final ConcurrentLinkedQueue<c> c;
        public final krb d;
        public final ScheduledExecutorService e;
        public final Future<?> f;

        /* renamed from: com.baidu.tieba.kob$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class ThreadFactoryC0372a implements ThreadFactory {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ThreadFactory a;

            public ThreadFactoryC0372a(a aVar, ThreadFactory threadFactory) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, threadFactory};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                    Thread newThread = this.a.newThread(runnable);
                    newThread.setName(newThread.getName() + " (Evictor)");
                    return newThread;
                }
                return (Thread) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a();
                }
            }
        }

        public a(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            long j2;
            ScheduledFuture<?> scheduledFuture;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFactory, Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadFactory;
            if (timeUnit != null) {
                j2 = timeUnit.toNanos(j);
            } else {
                j2 = 0;
            }
            this.b = j2;
            this.c = new ConcurrentLinkedQueue<>();
            this.d = new krb();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactoryC0372a(this, threadFactory));
                qob.k(scheduledExecutorService);
                b bVar = new b(this);
                long j3 = this.b;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(bVar, j3, j3, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.e = scheduledExecutorService;
            this.f = scheduledFuture;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.c.isEmpty()) {
                long c = c();
                Iterator<c> it = this.c.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.l() <= c) {
                        if (this.c.remove(next)) {
                            this.d.b(next);
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public c b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.d.isUnsubscribed()) {
                    return kob.e;
                }
                while (!this.c.isEmpty()) {
                    c poll = this.c.poll();
                    if (poll != null) {
                        return poll;
                    }
                }
                c cVar = new c(this.a);
                this.d.a(cVar);
                return cVar;
            }
            return (c) invokeV.objValue;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return System.nanoTime();
            }
            return invokeV.longValue;
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                try {
                    if (this.f != null) {
                        this.f.cancel(true);
                    }
                    if (this.e != null) {
                        this.e.shutdownNow();
                    }
                } finally {
                    this.d.unsubscribe();
                }
            }
        }

        public void d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
                cVar.m(c() + this.b);
                this.c.offer(cVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends qmb.a implements anb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final krb a;
        public final a b;
        public final c c;
        public final AtomicBoolean d;

        /* loaded from: classes6.dex */
        public class a implements anb {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ anb a;
            public final /* synthetic */ b b;

            public a(b bVar, anb anbVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, anbVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = anbVar;
            }

            @Override // com.baidu.tieba.anb
            public void call() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.isUnsubscribed()) {
                    return;
                }
                this.a.call();
            }
        }

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new krb();
            this.b = aVar;
            this.d = new AtomicBoolean();
            this.c = aVar.b();
        }

        @Override // com.baidu.tieba.qmb.a
        public umb b(anb anbVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, anbVar)) == null) {
                return c(anbVar, 0L, null);
            }
            return (umb) invokeL.objValue;
        }

        @Override // com.baidu.tieba.qmb.a
        public umb c(anb anbVar, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{anbVar, Long.valueOf(j), timeUnit})) == null) {
                if (this.a.isUnsubscribed()) {
                    return nrb.c();
                }
                ScheduledAction h = this.c.h(new a(this, anbVar), j, timeUnit);
                this.a.a(h);
                h.addParent(this.a);
                return h;
            }
            return (umb) invokeCommon.objValue;
        }

        @Override // com.baidu.tieba.anb
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b.d(this.c);
            }
        }

        @Override // com.baidu.tieba.umb
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a.isUnsubscribed();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.umb
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.d.compareAndSet(false, true)) {
                    this.c.b(this);
                }
                this.a.unsubscribe();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends qob {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFactory};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ThreadFactory) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = 0L;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.i;
            }
            return invokeV.longValue;
        }

        public void m(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.i = j;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947921227, "Lcom/baidu/tieba/kob;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947921227, "Lcom/baidu/tieba/kob;");
                return;
            }
        }
        d = TimeUnit.SECONDS;
        c cVar = new c(RxThreadFactory.NONE);
        e = cVar;
        cVar.unsubscribe();
        a aVar = new a(null, 0L, null);
        f = aVar;
        aVar.e();
        c = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public kob(ThreadFactory threadFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadFactory};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = threadFactory;
        this.b = new AtomicReference<>(f);
        start();
    }

    @Override // com.baidu.tieba.qmb
    public qmb.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new b(this.b.get());
        }
        return (qmb.a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rob
    public void shutdown() {
        a aVar;
        a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            do {
                aVar = this.b.get();
                aVar2 = f;
                if (aVar == aVar2) {
                    return;
                }
            } while (!this.b.compareAndSet(aVar, aVar2));
            aVar.e();
        }
    }

    @Override // com.baidu.tieba.rob
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a aVar = new a(this.a, c, d);
            if (!this.b.compareAndSet(f, aVar)) {
                aVar.e();
            }
        }
    }
}
