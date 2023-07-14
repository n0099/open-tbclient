package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u1c;
import com.baidu.tieba.x1c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.schedulers.Schedulers;
/* loaded from: classes8.dex */
public final class x2c<T> implements u1c.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final m2c<u1c<? extends Notification<?>>, u1c<?>> f;
    public transient /* synthetic */ FieldHolder $fh;
    public final u1c<T> a;
    public final m2c<? super u1c<? extends Notification<?>>, ? extends u1c<?>> b;
    public final boolean c;
    public final boolean d;
    public final x1c e;

    /* loaded from: classes8.dex */
    public static class a implements m2c<u1c<? extends Notification<?>>, u1c<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.x2c$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0533a implements m2c<Notification<?>, Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0533a(a aVar) {
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
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.m2c
            public Notification<?> call(Notification<?> notification) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, notification)) == null) {
                    return Notification.c(null);
                }
                return (Notification) invokeL.objValue;
            }
        }

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

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: com.baidu.tieba.u1c<R>, com.baidu.tieba.u1c<?> */
        @Override // com.baidu.tieba.m2c
        public u1c<?> call(u1c<? extends Notification<?>> u1cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, u1cVar)) == null) {
                return u1cVar.p(new C0533a(this));
            }
            return (u1c) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements h2c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a2c a;
        public final /* synthetic */ s6c b;
        public final /* synthetic */ t3c c;
        public final /* synthetic */ AtomicLong d;
        public final /* synthetic */ w6c e;
        public final /* synthetic */ x2c f;

        /* loaded from: classes8.dex */
        public class a extends a2c<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean e;
            public final /* synthetic */ b f;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = bVar;
            }

            @Override // com.baidu.tieba.a2c
            public void f(w1c w1cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, w1cVar) == null) {
                    this.f.c.c(w1cVar);
                }
            }

            @Override // com.baidu.tieba.v1c
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, th) == null) && !this.e) {
                    this.e = true;
                    unsubscribe();
                    this.f.b.onNext(Notification.b(th));
                }
            }

            @Override // com.baidu.tieba.v1c
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048580, this, t) == null) && !this.e) {
                    this.f.a.onNext(t);
                    g();
                    this.f.c.b(1L);
                }
            }

            public final void g() {
                long j;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    do {
                        j = this.f.d.get();
                        if (j == Long.MAX_VALUE) {
                            return;
                        }
                    } while (!this.f.d.compareAndSet(j, j - 1));
                }
            }

            @Override // com.baidu.tieba.v1c
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.e) {
                    this.e = true;
                    unsubscribe();
                    this.f.b.onNext(Notification.a());
                }
            }
        }

        public b(x2c x2cVar, a2c a2cVar, s6c s6cVar, t3c t3cVar, AtomicLong atomicLong, w6c w6cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x2cVar, a2cVar, s6cVar, t3cVar, atomicLong, w6cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = x2cVar;
            this.a = a2cVar;
            this.b = s6cVar;
            this.c = t3cVar;
            this.d = atomicLong;
            this.e = w6cVar;
        }

        @Override // com.baidu.tieba.h2c
        public void call() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.isUnsubscribed()) {
                return;
            }
            a aVar = new a(this);
            this.e.a(aVar);
            this.f.a.O(aVar);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements u1c.b<Notification<?>, Notification<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x2c a;

        /* loaded from: classes8.dex */
        public class a extends a2c<Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a2c e;
            public final /* synthetic */ c f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, a2c a2cVar, a2c a2cVar2) {
                super(a2cVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, a2cVar, a2cVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((a2c) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = cVar;
                this.e = a2cVar2;
            }

            @Override // com.baidu.tieba.a2c
            public void f(w1c w1cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, w1cVar) == null) {
                    w1cVar.request(Long.MAX_VALUE);
                }
            }

            @Override // com.baidu.tieba.v1c
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    this.e.onError(th);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.v1c
            /* renamed from: g */
            public void onNext(Notification<?> notification) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, notification) == null) {
                    if (notification.i() && this.f.a.c) {
                        this.e.onCompleted();
                    } else if (notification.j() && this.f.a.d) {
                        this.e.onError(notification.e());
                    } else {
                        this.e.onNext(notification);
                    }
                }
            }

            @Override // com.baidu.tieba.v1c
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.e.onCompleted();
                }
            }
        }

        public c(x2c x2cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x2cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x2cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.u1c.b, com.baidu.tieba.m2c
        public a2c<? super Notification<?>> call(a2c<? super Notification<?>> a2cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, a2cVar)) == null) {
                return new a(this, a2cVar, a2cVar);
            }
            return (a2c) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements h2c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u1c a;
        public final /* synthetic */ a2c b;
        public final /* synthetic */ AtomicLong c;
        public final /* synthetic */ x1c.a d;
        public final /* synthetic */ h2c e;
        public final /* synthetic */ AtomicBoolean f;

        /* loaded from: classes8.dex */
        public class a extends a2c<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, a2c a2cVar) {
                super(a2cVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, a2cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((a2c) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = dVar;
            }

            @Override // com.baidu.tieba.a2c
            public void f(w1c w1cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, w1cVar) == null) {
                    w1cVar.request(Long.MAX_VALUE);
                }
            }

            @Override // com.baidu.tieba.v1c
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.b.onError(th);
                }
            }

            @Override // com.baidu.tieba.v1c
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.e.b.onCompleted();
                }
            }

            @Override // com.baidu.tieba.v1c
            public void onNext(Object obj) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, obj) == null) && !this.e.b.isUnsubscribed()) {
                    if (this.e.c.get() > 0) {
                        d dVar = this.e;
                        dVar.d.b(dVar.e);
                        return;
                    }
                    this.e.f.compareAndSet(false, true);
                }
            }
        }

        public d(x2c x2cVar, u1c u1cVar, a2c a2cVar, AtomicLong atomicLong, x1c.a aVar, h2c h2cVar, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x2cVar, u1cVar, a2cVar, atomicLong, aVar, h2cVar, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u1cVar;
            this.b = a2cVar;
            this.c = atomicLong;
            this.d = aVar;
            this.e = h2cVar;
            this.f = atomicBoolean;
        }

        @Override // com.baidu.tieba.h2c
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.O(new a(this, this.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements w1c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicLong a;
        public final /* synthetic */ t3c b;
        public final /* synthetic */ AtomicBoolean c;
        public final /* synthetic */ x1c.a d;
        public final /* synthetic */ h2c e;

        public e(x2c x2cVar, AtomicLong atomicLong, t3c t3cVar, AtomicBoolean atomicBoolean, x1c.a aVar, h2c h2cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x2cVar, atomicLong, t3cVar, atomicBoolean, aVar, h2cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atomicLong;
            this.b = t3cVar;
            this.c = atomicBoolean;
            this.d = aVar;
            this.e = h2cVar;
        }

        @Override // com.baidu.tieba.w1c
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && j > 0) {
                q2c.b(this.a, j);
                this.b.request(j);
                if (this.c.compareAndSet(true, false)) {
                    this.d.b(this.e);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948249920, "Lcom/baidu/tieba/x2c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948249920, "Lcom/baidu/tieba/x2c;");
                return;
            }
        }
        f = new a();
    }

    public x2c(u1c<T> u1cVar, m2c<? super u1c<? extends Notification<?>>, ? extends u1c<?>> m2cVar, boolean z, boolean z2, x1c x1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u1cVar, m2cVar, Boolean.valueOf(z), Boolean.valueOf(z2), x1cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = u1cVar;
        this.b = m2cVar;
        this.c = z;
        this.d = z2;
        this.e = x1cVar;
    }

    public static <T> u1c<T> a(u1c<T> u1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, u1cVar)) == null) {
            return b(u1cVar, f);
        }
        return (u1c) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((a2c) ((a2c) obj));
    }

    public static <T> u1c<T> b(u1c<T> u1cVar, m2c<? super u1c<? extends Notification<?>>, ? extends u1c<?>> m2cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, u1cVar, m2cVar)) == null) {
            return u1c.d(new x2c(u1cVar, m2cVar, true, false, Schedulers.trampoline()));
        }
        return (u1c) invokeLL.objValue;
    }

    public void call(a2c<? super T> a2cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, a2cVar) == null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            AtomicLong atomicLong = new AtomicLong();
            x1c.a createWorker = this.e.createWorker();
            a2cVar.b(createWorker);
            w6c w6cVar = new w6c();
            a2cVar.b(w6cVar);
            r6c<T, T> P = p6c.Q().P();
            P.F(e6c.a());
            t3c t3cVar = new t3c();
            b bVar = new b(this, a2cVar, P, t3cVar, atomicLong, w6cVar);
            createWorker.b(new d(this, this.b.call(P.o(new c(this))), a2cVar, atomicLong, createWorker, bVar, atomicBoolean));
            a2cVar.f(new e(this, atomicLong, t3cVar, atomicBoolean, createWorker, bVar));
        }
    }
}
