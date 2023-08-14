package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b1c;
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
public final class z2c extends b1c implements f3c {
    public static /* synthetic */ Interceptable $ic;
    public static final int c;
    public static final c d;
    public static final b e;
    public transient /* synthetic */ FieldHolder $fh;
    public final ThreadFactory a;
    public final AtomicReference<b> b;

    /* loaded from: classes8.dex */
    public static final class a extends b1c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final p3c a;
        public final y5c b;
        public final p3c c;
        public final c d;

        /* renamed from: com.baidu.tieba.z2c$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0552a implements l1c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l1c a;
            public final /* synthetic */ a b;

            public C0552a(a aVar, l1c l1cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, l1cVar};
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
                this.a = l1cVar;
            }

            @Override // com.baidu.tieba.l1c
            public void call() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.isUnsubscribed()) {
                    return;
                }
                this.a.call();
            }
        }

        /* loaded from: classes8.dex */
        public class b implements l1c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l1c a;
            public final /* synthetic */ a b;

            public b(a aVar, l1c l1cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, l1cVar};
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
                this.a = l1cVar;
            }

            @Override // com.baidu.tieba.l1c
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
            this.a = new p3c();
            y5c y5cVar = new y5c();
            this.b = y5cVar;
            this.c = new p3c(this.a, y5cVar);
            this.d = cVar;
        }

        @Override // com.baidu.tieba.b1c.a
        public f1c b(l1c l1cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, l1cVar)) == null) {
                if (isUnsubscribed()) {
                    return b6c.c();
                }
                return this.d.i(new C0552a(this, l1cVar), 0L, null, this.a);
            }
            return (f1c) invokeL.objValue;
        }

        @Override // com.baidu.tieba.b1c.a
        public f1c c(l1c l1cVar, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{l1cVar, Long.valueOf(j), timeUnit})) == null) {
                if (isUnsubscribed()) {
                    return b6c.c();
                }
                return this.d.j(new b(this, l1cVar), j, timeUnit, this.b);
            }
            return (f1c) invokeCommon.objValue;
        }

        @Override // com.baidu.tieba.f1c
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.c.isUnsubscribed();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.f1c
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
                    return z2c.d;
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
    public static final class c extends e3c {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948309502, "Lcom/baidu/tieba/z2c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948309502, "Lcom/baidu/tieba/z2c;");
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

    public z2c(ThreadFactory threadFactory) {
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

    public f1c a(l1c l1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, l1cVar)) == null) {
            return this.b.get().a().h(l1cVar, -1L, TimeUnit.NANOSECONDS);
        }
        return (f1c) invokeL.objValue;
    }

    @Override // com.baidu.tieba.b1c
    public b1c.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new a(this.b.get().a());
        }
        return (b1c.a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.f3c
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

    @Override // com.baidu.tieba.f3c
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
