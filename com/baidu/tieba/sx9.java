package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qw9;
import com.baidu.tieba.tw9;
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
/* loaded from: classes5.dex */
public final class sx9<T> implements qw9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final ix9<qw9<? extends Notification<?>>, qw9<?>> f;
    public transient /* synthetic */ FieldHolder $fh;
    public final qw9<T> a;
    public final ix9<? super qw9<? extends Notification<?>>, ? extends qw9<?>> b;
    public final boolean c;
    public final boolean d;
    public final tw9 e;

    /* loaded from: classes5.dex */
    public static class a implements ix9<qw9<? extends Notification<?>>, qw9<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.sx9$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0416a implements ix9<Notification<?>, Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0416a(a aVar) {
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
            @Override // com.baidu.tieba.ix9
            public Notification<?> call(Notification<?> notification) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, notification)) == null) ? Notification.c(null) : (Notification) invokeL.objValue;
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
        /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: com.baidu.tieba.qw9<R>, com.baidu.tieba.qw9<?> */
        @Override // com.baidu.tieba.ix9
        public qw9<?> call(qw9<? extends Notification<?>> qw9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qw9Var)) == null) ? qw9Var.h(new C0416a(this)) : (qw9) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements dx9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ww9 a;
        public final /* synthetic */ i1a b;
        public final /* synthetic */ jy9 c;
        public final /* synthetic */ AtomicLong d;
        public final /* synthetic */ m1a e;
        public final /* synthetic */ sx9 f;

        /* loaded from: classes5.dex */
        public class a extends ww9<T> {
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

            @Override // com.baidu.tieba.ww9
            public void f(sw9 sw9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, sw9Var) == null) {
                    this.f.c.c(sw9Var);
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

            @Override // com.baidu.tieba.rw9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.e) {
                    return;
                }
                this.e = true;
                unsubscribe();
                this.f.b.onNext(Notification.a());
            }

            @Override // com.baidu.tieba.rw9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, th) == null) || this.e) {
                    return;
                }
                this.e = true;
                unsubscribe();
                this.f.b.onNext(Notification.b(th));
            }

            @Override // com.baidu.tieba.rw9
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048580, this, t) == null) || this.e) {
                    return;
                }
                this.f.a.onNext(t);
                g();
                this.f.c.b(1L);
            }
        }

        public b(sx9 sx9Var, ww9 ww9Var, i1a i1aVar, jy9 jy9Var, AtomicLong atomicLong, m1a m1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx9Var, ww9Var, i1aVar, jy9Var, atomicLong, m1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = sx9Var;
            this.a = ww9Var;
            this.b = i1aVar;
            this.c = jy9Var;
            this.d = atomicLong;
            this.e = m1aVar;
        }

        @Override // com.baidu.tieba.dx9
        public void call() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.isUnsubscribed()) {
                return;
            }
            a aVar = new a(this);
            this.e.a(aVar);
            this.f.a.B(aVar);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements qw9.b<Notification<?>, Notification<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sx9 a;

        /* loaded from: classes5.dex */
        public class a extends ww9<Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ww9 e;
            public final /* synthetic */ c f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, ww9 ww9Var, ww9 ww9Var2) {
                super(ww9Var);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, ww9Var, ww9Var2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((ww9) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = cVar;
                this.e = ww9Var2;
            }

            @Override // com.baidu.tieba.ww9
            public void f(sw9 sw9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, sw9Var) == null) {
                    sw9Var.request(Long.MAX_VALUE);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.rw9
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

            @Override // com.baidu.tieba.rw9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.e.onCompleted();
                }
            }

            @Override // com.baidu.tieba.rw9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    this.e.onError(th);
                }
            }
        }

        public c(sx9 sx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sx9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qw9.b, com.baidu.tieba.ix9
        public ww9<? super Notification<?>> call(ww9<? super Notification<?>> ww9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ww9Var)) == null) ? new a(this, ww9Var, ww9Var) : (ww9) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements dx9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qw9 a;
        public final /* synthetic */ ww9 b;
        public final /* synthetic */ AtomicLong c;
        public final /* synthetic */ tw9.a d;
        public final /* synthetic */ dx9 e;
        public final /* synthetic */ AtomicBoolean f;

        /* loaded from: classes5.dex */
        public class a extends ww9<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, ww9 ww9Var) {
                super(ww9Var);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, ww9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((ww9) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = dVar;
            }

            @Override // com.baidu.tieba.ww9
            public void f(sw9 sw9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, sw9Var) == null) {
                    sw9Var.request(Long.MAX_VALUE);
                }
            }

            @Override // com.baidu.tieba.rw9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.e.b.onCompleted();
                }
            }

            @Override // com.baidu.tieba.rw9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.b.onError(th);
                }
            }

            @Override // com.baidu.tieba.rw9
            public void onNext(Object obj) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || this.e.b.isUnsubscribed()) {
                    return;
                }
                if (this.e.c.get() > 0) {
                    d dVar = this.e;
                    dVar.d.b(dVar.e);
                    return;
                }
                this.e.f.compareAndSet(false, true);
            }
        }

        public d(sx9 sx9Var, qw9 qw9Var, ww9 ww9Var, AtomicLong atomicLong, tw9.a aVar, dx9 dx9Var, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx9Var, qw9Var, ww9Var, atomicLong, aVar, dx9Var, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qw9Var;
            this.b = ww9Var;
            this.c = atomicLong;
            this.d = aVar;
            this.e = dx9Var;
            this.f = atomicBoolean;
        }

        @Override // com.baidu.tieba.dx9
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B(new a(this, this.b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements sw9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicLong a;
        public final /* synthetic */ jy9 b;
        public final /* synthetic */ AtomicBoolean c;
        public final /* synthetic */ tw9.a d;
        public final /* synthetic */ dx9 e;

        public e(sx9 sx9Var, AtomicLong atomicLong, jy9 jy9Var, AtomicBoolean atomicBoolean, tw9.a aVar, dx9 dx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx9Var, atomicLong, jy9Var, atomicBoolean, aVar, dx9Var};
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
            this.b = jy9Var;
            this.c = atomicBoolean;
            this.d = aVar;
            this.e = dx9Var;
        }

        @Override // com.baidu.tieba.sw9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || j <= 0) {
                return;
            }
            lx9.b(this.a, j);
            this.b.request(j);
            if (this.c.compareAndSet(true, false)) {
                this.d.b(this.e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948166933, "Lcom/baidu/tieba/sx9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948166933, "Lcom/baidu/tieba/sx9;");
                return;
            }
        }
        f = new a();
    }

    public sx9(qw9<T> qw9Var, ix9<? super qw9<? extends Notification<?>>, ? extends qw9<?>> ix9Var, boolean z, boolean z2, tw9 tw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qw9Var, ix9Var, Boolean.valueOf(z), Boolean.valueOf(z2), tw9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = qw9Var;
        this.b = ix9Var;
        this.c = z;
        this.d = z2;
        this.e = tw9Var;
    }

    public static <T> qw9<T> a(qw9<T> qw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, qw9Var)) == null) ? b(qw9Var, f) : (qw9) invokeL.objValue;
    }

    public static <T> qw9<T> b(qw9<T> qw9Var, ix9<? super qw9<? extends Notification<?>>, ? extends qw9<?>> ix9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, qw9Var, ix9Var)) == null) ? qw9.a(new sx9(qw9Var, ix9Var, true, false, Schedulers.trampoline())) : (qw9) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.qw9.a, com.baidu.tieba.ex9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ww9) ((ww9) obj));
    }

    public void call(ww9<? super T> ww9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ww9Var) == null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            AtomicLong atomicLong = new AtomicLong();
            tw9.a createWorker = this.e.createWorker();
            ww9Var.b(createWorker);
            m1a m1aVar = new m1a();
            ww9Var.b(m1aVar);
            h1a<T, T> C = f1a.D().C();
            C.u(u0a.a());
            jy9 jy9Var = new jy9();
            b bVar = new b(this, ww9Var, C, jy9Var, atomicLong, m1aVar);
            createWorker.b(new d(this, this.b.call(C.g(new c(this))), ww9Var, atomicLong, createWorker, bVar, atomicBoolean));
            ww9Var.f(new e(this, atomicLong, jy9Var, atomicBoolean, createWorker, bVar));
        }
    }
}
