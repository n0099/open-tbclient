package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vac;
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
public final class vcc extends vac {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Executor a;

    /* loaded from: classes8.dex */
    public static final class a extends vac.a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Executor a;
        public final tfc b;
        public final ConcurrentLinkedQueue<ScheduledAction> c;
        public final AtomicInteger d;
        public final ScheduledExecutorService e;

        /* renamed from: com.baidu.tieba.vcc$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0503a implements fbc {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ufc a;
            public final /* synthetic */ a b;

            public C0503a(a aVar, ufc ufcVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ufcVar};
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
                this.a = ufcVar;
            }

            @Override // com.baidu.tieba.fbc
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.b.d(this.a);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements fbc {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ufc a;
            public final /* synthetic */ fbc b;
            public final /* synthetic */ zac c;
            public final /* synthetic */ a d;

            public b(a aVar, ufc ufcVar, fbc fbcVar, zac zacVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ufcVar, fbcVar, zacVar};
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
                this.a = ufcVar;
                this.b = fbcVar;
                this.c = zacVar;
            }

            @Override // com.baidu.tieba.fbc
            public void call() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.isUnsubscribed()) {
                    return;
                }
                zac b = this.d.b(this.b);
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
            this.b = new tfc();
            this.e = wcc.a();
        }

        @Override // com.baidu.tieba.vac.a
        public zac b(fbc fbcVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fbcVar)) == null) {
                if (isUnsubscribed()) {
                    return wfc.c();
                }
                ScheduledAction scheduledAction = new ScheduledAction(gfc.q(fbcVar), this.b);
                this.b.a(scheduledAction);
                this.c.offer(scheduledAction);
                if (this.d.getAndIncrement() == 0) {
                    try {
                        this.a.execute(this);
                    } catch (RejectedExecutionException e) {
                        this.b.d(scheduledAction);
                        this.d.decrementAndGet();
                        gfc.j(e);
                        throw e;
                    }
                }
                return scheduledAction;
            }
            return (zac) invokeL.objValue;
        }

        @Override // com.baidu.tieba.vac.a
        public zac c(fbc fbcVar, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{fbcVar, Long.valueOf(j), timeUnit})) == null) {
                if (j <= 0) {
                    return b(fbcVar);
                }
                if (isUnsubscribed()) {
                    return wfc.c();
                }
                fbc q = gfc.q(fbcVar);
                ufc ufcVar = new ufc();
                ufc ufcVar2 = new ufc();
                ufcVar2.a(ufcVar);
                this.b.a(ufcVar2);
                zac a = wfc.a(new C0503a(this, ufcVar2));
                ScheduledAction scheduledAction = new ScheduledAction(new b(this, ufcVar2, q, a));
                ufcVar.a(scheduledAction);
                try {
                    scheduledAction.add(this.e.schedule(scheduledAction, j, timeUnit));
                    return a;
                } catch (RejectedExecutionException e) {
                    gfc.j(e);
                    throw e;
                }
            }
            return (zac) invokeCommon.objValue;
        }

        @Override // com.baidu.tieba.zac
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.isUnsubscribed();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.zac
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

    public vcc(Executor executor) {
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

    @Override // com.baidu.tieba.vac
    public vac.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this.a);
        }
        return (vac.a) invokeV.objValue;
    }
}
