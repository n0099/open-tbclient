package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n7c;
import com.baidu.tieba.q7c;
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
/* loaded from: classes7.dex */
public final class r8c<T> implements n7c.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final g8c<n7c<? extends Notification<?>>, n7c<?>> f;
    public transient /* synthetic */ FieldHolder $fh;
    public final n7c<T> a;
    public final g8c<? super n7c<? extends Notification<?>>, ? extends n7c<?>> b;
    public final boolean c;
    public final boolean d;
    public final q7c e;

    /* loaded from: classes7.dex */
    public static class a implements g8c<n7c<? extends Notification<?>>, n7c<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.r8c$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0466a implements g8c<Notification<?>, Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0466a(a aVar) {
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
            @Override // com.baidu.tieba.g8c
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
        /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: com.baidu.tieba.n7c<R>, com.baidu.tieba.n7c<?> */
        @Override // com.baidu.tieba.g8c
        public n7c<?> call(n7c<? extends Notification<?>> n7cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, n7cVar)) == null) {
                return n7cVar.p(new C0466a(this));
            }
            return (n7c) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a8c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t7c a;
        public final /* synthetic */ mcc b;
        public final /* synthetic */ n9c c;
        public final /* synthetic */ AtomicLong d;
        public final /* synthetic */ qcc e;
        public final /* synthetic */ r8c f;

        /* loaded from: classes7.dex */
        public class a extends t7c<T> {
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

            @Override // com.baidu.tieba.t7c
            public void f(p7c p7cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, p7cVar) == null) {
                    this.f.c.c(p7cVar);
                }
            }

            @Override // com.baidu.tieba.o7c
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, th) == null) && !this.e) {
                    this.e = true;
                    unsubscribe();
                    this.f.b.onNext(Notification.b(th));
                }
            }

            @Override // com.baidu.tieba.o7c
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

            @Override // com.baidu.tieba.o7c
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.e) {
                    this.e = true;
                    unsubscribe();
                    this.f.b.onNext(Notification.a());
                }
            }
        }

        public b(r8c r8cVar, t7c t7cVar, mcc mccVar, n9c n9cVar, AtomicLong atomicLong, qcc qccVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r8cVar, t7cVar, mccVar, n9cVar, atomicLong, qccVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = r8cVar;
            this.a = t7cVar;
            this.b = mccVar;
            this.c = n9cVar;
            this.d = atomicLong;
            this.e = qccVar;
        }

        @Override // com.baidu.tieba.a8c
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

    /* loaded from: classes7.dex */
    public class c implements n7c.b<Notification<?>, Notification<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r8c a;

        /* loaded from: classes7.dex */
        public class a extends t7c<Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ t7c e;
            public final /* synthetic */ c f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, t7c t7cVar, t7c t7cVar2) {
                super(t7cVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, t7cVar, t7cVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((t7c) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = cVar;
                this.e = t7cVar2;
            }

            @Override // com.baidu.tieba.t7c
            public void f(p7c p7cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, p7cVar) == null) {
                    p7cVar.request(Long.MAX_VALUE);
                }
            }

            @Override // com.baidu.tieba.o7c
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    this.e.onError(th);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.o7c
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

            @Override // com.baidu.tieba.o7c
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.e.onCompleted();
                }
            }
        }

        public c(r8c r8cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r8cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r8cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n7c.b, com.baidu.tieba.g8c
        public t7c<? super Notification<?>> call(t7c<? super Notification<?>> t7cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t7cVar)) == null) {
                return new a(this, t7cVar, t7cVar);
            }
            return (t7c) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a8c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n7c a;
        public final /* synthetic */ t7c b;
        public final /* synthetic */ AtomicLong c;
        public final /* synthetic */ q7c.a d;
        public final /* synthetic */ a8c e;
        public final /* synthetic */ AtomicBoolean f;

        /* loaded from: classes7.dex */
        public class a extends t7c<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, t7c t7cVar) {
                super(t7cVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, t7cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((t7c) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = dVar;
            }

            @Override // com.baidu.tieba.t7c
            public void f(p7c p7cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, p7cVar) == null) {
                    p7cVar.request(Long.MAX_VALUE);
                }
            }

            @Override // com.baidu.tieba.o7c
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.b.onError(th);
                }
            }

            @Override // com.baidu.tieba.o7c
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.e.b.onCompleted();
                }
            }

            @Override // com.baidu.tieba.o7c
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

        public d(r8c r8cVar, n7c n7cVar, t7c t7cVar, AtomicLong atomicLong, q7c.a aVar, a8c a8cVar, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r8cVar, n7cVar, t7cVar, atomicLong, aVar, a8cVar, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n7cVar;
            this.b = t7cVar;
            this.c = atomicLong;
            this.d = aVar;
            this.e = a8cVar;
            this.f = atomicBoolean;
        }

        @Override // com.baidu.tieba.a8c
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.O(new a(this, this.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements p7c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicLong a;
        public final /* synthetic */ n9c b;
        public final /* synthetic */ AtomicBoolean c;
        public final /* synthetic */ q7c.a d;
        public final /* synthetic */ a8c e;

        public e(r8c r8cVar, AtomicLong atomicLong, n9c n9cVar, AtomicBoolean atomicBoolean, q7c.a aVar, a8c a8cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r8cVar, atomicLong, n9cVar, atomicBoolean, aVar, a8cVar};
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
            this.b = n9cVar;
            this.c = atomicBoolean;
            this.d = aVar;
            this.e = a8cVar;
        }

        @Override // com.baidu.tieba.p7c
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && j > 0) {
                k8c.b(this.a, j);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948076940, "Lcom/baidu/tieba/r8c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948076940, "Lcom/baidu/tieba/r8c;");
                return;
            }
        }
        f = new a();
    }

    public r8c(n7c<T> n7cVar, g8c<? super n7c<? extends Notification<?>>, ? extends n7c<?>> g8cVar, boolean z, boolean z2, q7c q7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n7cVar, g8cVar, Boolean.valueOf(z), Boolean.valueOf(z2), q7cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = n7cVar;
        this.b = g8cVar;
        this.c = z;
        this.d = z2;
        this.e = q7cVar;
    }

    public static <T> n7c<T> a(n7c<T> n7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, n7cVar)) == null) {
            return b(n7cVar, f);
        }
        return (n7c) invokeL.objValue;
    }

    @Override // com.baidu.tieba.n7c.a, com.baidu.tieba.b8c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((t7c) ((t7c) obj));
    }

    public static <T> n7c<T> b(n7c<T> n7cVar, g8c<? super n7c<? extends Notification<?>>, ? extends n7c<?>> g8cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, n7cVar, g8cVar)) == null) {
            return n7c.d(new r8c(n7cVar, g8cVar, true, false, Schedulers.trampoline()));
        }
        return (n7c) invokeLL.objValue;
    }

    public void call(t7c<? super T> t7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t7cVar) == null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            AtomicLong atomicLong = new AtomicLong();
            q7c.a createWorker = this.e.createWorker();
            t7cVar.b(createWorker);
            qcc qccVar = new qcc();
            t7cVar.b(qccVar);
            lcc<T, T> P = jcc.Q().P();
            P.F(ybc.a());
            n9c n9cVar = new n9c();
            b bVar = new b(this, t7cVar, P, n9cVar, atomicLong, qccVar);
            createWorker.b(new d(this, this.b.call(P.o(new c(this))), t7cVar, atomicLong, createWorker, bVar, atomicBoolean));
            t7cVar.f(new e(this, atomicLong, n9cVar, atomicBoolean, createWorker, bVar));
        }
    }
}
