package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.atb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes8.dex */
public final class yub extends atb implements evb {
    public static /* synthetic */ Interceptable $ic;
    public static final int c;
    public static final c d;
    public static final b e;
    public transient /* synthetic */ FieldHolder $fh;
    public final ThreadFactory a;
    public final AtomicReference<b> b;

    /* loaded from: classes8.dex */
    public static final class a extends atb.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ovb a;
        public final xxb b;
        public final ovb c;
        public final c d;

        /* renamed from: com.baidu.tieba.yub$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0541a implements ktb {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ktb a;
            public final /* synthetic */ a b;

            public C0541a(a aVar, ktb ktbVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ktbVar};
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
                this.a = ktbVar;
            }

            @Override // com.baidu.tieba.ktb
            public void call() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.isUnsubscribed()) {
                    return;
                }
                this.a.call();
            }
        }

        /* loaded from: classes8.dex */
        public class b implements ktb {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ktb a;
            public final /* synthetic */ a b;

            public b(a aVar, ktb ktbVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ktbVar};
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
                this.a = ktbVar;
            }

            @Override // com.baidu.tieba.ktb
            public void call() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.isUnsubscribed()) {
                    return;
                }
                this.a.call();
            }
        }

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new ovb();
            xxb xxbVar = new xxb();
            this.b = xxbVar;
            this.c = new ovb(this.a, xxbVar);
            this.d = cVar;
        }

        @Override // com.baidu.tieba.atb.a
        public etb b(ktb ktbVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ktbVar)) == null) {
                if (isUnsubscribed()) {
                    return ayb.c();
                }
                return this.d.i(new C0541a(this, ktbVar), 0L, null, this.a);
            }
            return (etb) invokeL.objValue;
        }

        @Override // com.baidu.tieba.atb.a
        public etb c(ktb ktbVar, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{ktbVar, Long.valueOf(j), timeUnit})) == null) {
                if (isUnsubscribed()) {
                    return ayb.c();
                }
                return this.d.j(new b(this, ktbVar), j, timeUnit, this.b);
            }
            return (etb) invokeCommon.objValue;
        }

        @Override // com.baidu.tieba.etb
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.c.isUnsubscribed();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.etb
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.c.unsubscribe();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final c[] b;
        public long c;

        public b(ThreadFactory threadFactory, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFactory, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = new c[i];
            for (int i4 = 0; i4 < i; i4++) {
                this.b[i4] = new c(threadFactory);
            }
        }

        public c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i = this.a;
                if (i == 0) {
                    return yub.d;
                }
                c[] cVarArr = this.b;
                long j = this.c;
                this.c = 1 + j;
                return cVarArr[(int) (j % i)];
            }
            return (c) invokeV.objValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (c cVar : this.b) {
                    cVar.unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends dvb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948344067, "Lcom/baidu/tieba/yub;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948344067, "Lcom/baidu/tieba/yub;");
                return;
            }
        }
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        c = intValue;
        c cVar = new c(RxThreadFactory.NONE);
        d = cVar;
        cVar.unsubscribe();
        e = new b(null, 0);
    }

    public yub(ThreadFactory threadFactory) {
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
        this.b = new AtomicReference<>(e);
        start();
    }

    public etb a(ktb ktbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ktbVar)) == null) {
            return this.b.get().a().h(ktbVar, -1L, TimeUnit.NANOSECONDS);
        }
        return (etb) invokeL.objValue;
    }

    @Override // com.baidu.tieba.atb
    public atb.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new a(this.b.get().a());
        }
        return (atb.a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.evb
    public void shutdown() {
        b bVar;
        b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            do {
                bVar = this.b.get();
                bVar2 = e;
                if (bVar == bVar2) {
                    return;
                }
            } while (!this.b.compareAndSet(bVar, bVar2));
            bVar.b();
        }
    }

    @Override // com.baidu.tieba.evb
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b bVar = new b(this.a, c);
            if (!this.b.compareAndSet(e, bVar)) {
                bVar.b();
            }
        }
    }
}
