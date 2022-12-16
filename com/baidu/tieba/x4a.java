package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e3a;
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
/* loaded from: classes6.dex */
public final class x4a extends e3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Executor a;

    /* loaded from: classes6.dex */
    public static final class a extends e3a.a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Executor a;
        public final v7a b;
        public final ConcurrentLinkedQueue<ScheduledAction> c;
        public final AtomicInteger d;
        public final ScheduledExecutorService e;

        /* renamed from: com.baidu.tieba.x4a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0482a implements o3a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ w7a a;
            public final /* synthetic */ a b;

            public C0482a(a aVar, w7a w7aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, w7aVar};
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
                this.a = w7aVar;
            }

            @Override // com.baidu.tieba.o3a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.b.b(this.a);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements o3a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ w7a a;
            public final /* synthetic */ o3a b;
            public final /* synthetic */ i3a c;
            public final /* synthetic */ a d;

            public b(a aVar, w7a w7aVar, o3a o3aVar, i3a i3aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, w7aVar, o3aVar, i3aVar};
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
                this.a = w7aVar;
                this.b = o3aVar;
                this.c = i3aVar;
            }

            @Override // com.baidu.tieba.o3a
            public void call() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.isUnsubscribed()) {
                    return;
                }
                i3a b = this.d.b(this.b);
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
            this.b = new v7a();
            this.e = y4a.a();
        }

        @Override // com.baidu.tieba.e3a.a
        public i3a b(o3a o3aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, o3aVar)) == null) {
                if (isUnsubscribed()) {
                    return y7a.c();
                }
                ScheduledAction scheduledAction = new ScheduledAction(i7a.q(o3aVar), this.b);
                this.b.a(scheduledAction);
                this.c.offer(scheduledAction);
                if (this.d.getAndIncrement() == 0) {
                    try {
                        this.a.execute(this);
                    } catch (RejectedExecutionException e) {
                        this.b.b(scheduledAction);
                        this.d.decrementAndGet();
                        i7a.j(e);
                        throw e;
                    }
                }
                return scheduledAction;
            }
            return (i3a) invokeL.objValue;
        }

        @Override // com.baidu.tieba.e3a.a
        public i3a c(o3a o3aVar, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{o3aVar, Long.valueOf(j), timeUnit})) == null) {
                if (j <= 0) {
                    return b(o3aVar);
                }
                if (isUnsubscribed()) {
                    return y7a.c();
                }
                o3a q = i7a.q(o3aVar);
                w7a w7aVar = new w7a();
                w7a w7aVar2 = new w7a();
                w7aVar2.a(w7aVar);
                this.b.a(w7aVar2);
                i3a a = y7a.a(new C0482a(this, w7aVar2));
                ScheduledAction scheduledAction = new ScheduledAction(new b(this, w7aVar2, q, a));
                w7aVar.a(scheduledAction);
                try {
                    scheduledAction.add(this.e.schedule(scheduledAction, j, timeUnit));
                    return a;
                } catch (RejectedExecutionException e) {
                    i7a.j(e);
                    throw e;
                }
            }
            return (i3a) invokeCommon.objValue;
        }

        @Override // com.baidu.tieba.i3a
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.isUnsubscribed();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.i3a
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

    public x4a(Executor executor) {
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

    @Override // com.baidu.tieba.e3a
    public e3a.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this.a);
        }
        return (e3a.a) invokeV.objValue;
    }
}
