package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.x1c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.schedulers.ScheduledAction;
/* loaded from: classes8.dex */
public final class w3c extends x1c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Executor a;

    /* loaded from: classes8.dex */
    public static final class a extends x1c.a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Executor a;
        public final u6c b;
        public final ConcurrentLinkedQueue<ScheduledAction> c;
        public final AtomicInteger d;
        public final ScheduledExecutorService e;

        /* renamed from: com.baidu.tieba.w3c$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0518a implements h2c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ v6c a;
            public final /* synthetic */ a b;

            public C0518a(a aVar, v6c v6cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, v6cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = v6cVar;
            }

            @Override // com.baidu.tieba.h2c
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.b.d(this.a);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements h2c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ v6c a;
            public final /* synthetic */ h2c b;
            public final /* synthetic */ b2c c;
            public final /* synthetic */ a d;

            public b(a aVar, v6c v6cVar, h2c h2cVar, b2c b2cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, v6cVar, h2cVar, b2cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = aVar;
                this.a = v6cVar;
                this.b = h2cVar;
                this.c = b2cVar;
            }

            @Override // com.baidu.tieba.h2c
            public void call() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.isUnsubscribed()) {
                    return;
                }
                b2c b = this.d.b(this.b);
                this.a.a(b);
                if (b.getClass() == ScheduledAction.class) {
                    ((ScheduledAction) b).add(this.c);
                }
            }
        }

        public a(Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {executor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = executor;
            this.c = new ConcurrentLinkedQueue<>();
            this.d = new AtomicInteger();
            this.b = new u6c();
            this.e = x3c.a();
        }

        @Override // com.baidu.tieba.x1c.a
        public b2c b(h2c h2cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, h2cVar)) == null) {
                if (isUnsubscribed()) {
                    return x6c.c();
                }
                ScheduledAction scheduledAction = new ScheduledAction(h6c.q(h2cVar), this.b);
                this.b.a(scheduledAction);
                this.c.offer(scheduledAction);
                if (this.d.getAndIncrement() == 0) {
                    try {
                        this.a.execute(this);
                    } catch (RejectedExecutionException e) {
                        this.b.d(scheduledAction);
                        this.d.decrementAndGet();
                        h6c.j(e);
                        throw e;
                    }
                }
                return scheduledAction;
            }
            return (b2c) invokeL.objValue;
        }

        @Override // com.baidu.tieba.x1c.a
        public b2c c(h2c h2cVar, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{h2cVar, Long.valueOf(j), timeUnit})) == null) {
                if (j <= 0) {
                    return b(h2cVar);
                }
                if (isUnsubscribed()) {
                    return x6c.c();
                }
                h2c q = h6c.q(h2cVar);
                v6c v6cVar = new v6c();
                v6c v6cVar2 = new v6c();
                v6cVar2.a(v6cVar);
                this.b.a(v6cVar2);
                b2c a = x6c.a(new C0518a(this, v6cVar2));
                ScheduledAction scheduledAction = new ScheduledAction(new b(this, v6cVar2, q, a));
                v6cVar.a(scheduledAction);
                try {
                    scheduledAction.add(this.e.schedule(scheduledAction, j, timeUnit));
                    return a;
                } catch (RejectedExecutionException e) {
                    h6c.j(e);
                    throw e;
                }
            }
            return (b2c) invokeCommon.objValue;
        }

        @Override // com.baidu.tieba.b2c
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.isUnsubscribed();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.b2c
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.b.unsubscribe();
                this.c.clear();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                while (!this.b.isUnsubscribed()) {
                    ScheduledAction poll = this.c.poll();
                    if (poll == null) {
                        return;
                    }
                    if (!poll.isUnsubscribed()) {
                        if (!this.b.isUnsubscribed()) {
                            poll.run();
                        } else {
                            this.c.clear();
                            return;
                        }
                    }
                    if (this.d.decrementAndGet() == 0) {
                        return;
                    }
                }
                this.c.clear();
            }
        }
    }

    public w3c(Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = executor;
    }

    @Override // com.baidu.tieba.x1c
    public x1c.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this.a);
        }
        return (x1c.a) invokeV.objValue;
    }
}
