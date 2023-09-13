package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.sac;
import com.baidu.tieba.vac;
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
public final class wbc<T> implements sac.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final lbc<sac<? extends Notification<?>>, sac<?>> f;
    public transient /* synthetic */ FieldHolder $fh;
    public final sac<T> a;
    public final lbc<? super sac<? extends Notification<?>>, ? extends sac<?>> b;
    public final boolean c;
    public final boolean d;
    public final vac e;

    /* loaded from: classes8.dex */
    public static class a implements lbc<sac<? extends Notification<?>>, sac<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.wbc$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0515a implements lbc<Notification<?>, Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0515a(a aVar) {
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
            @Override // com.baidu.tieba.lbc
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
        /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: com.baidu.tieba.sac<R>, com.baidu.tieba.sac<?> */
        @Override // com.baidu.tieba.lbc
        public sac<?> call(sac<? extends Notification<?>> sacVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sacVar)) == null) {
                return sacVar.p(new C0515a(this));
            }
            return (sac) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements fbc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yac a;
        public final /* synthetic */ rfc b;
        public final /* synthetic */ scc c;
        public final /* synthetic */ AtomicLong d;
        public final /* synthetic */ vfc e;
        public final /* synthetic */ wbc f;

        /* loaded from: classes8.dex */
        public class a extends yac<T> {
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

            @Override // com.baidu.tieba.yac
            public void f(uac uacVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, uacVar) == null) {
                    this.f.c.c(uacVar);
                }
            }

            @Override // com.baidu.tieba.tac
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, th) == null) && !this.e) {
                    this.e = true;
                    unsubscribe();
                    this.f.b.onNext(Notification.b(th));
                }
            }

            @Override // com.baidu.tieba.tac
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

            @Override // com.baidu.tieba.tac
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.e) {
                    this.e = true;
                    unsubscribe();
                    this.f.b.onNext(Notification.a());
                }
            }
        }

        public b(wbc wbcVar, yac yacVar, rfc rfcVar, scc sccVar, AtomicLong atomicLong, vfc vfcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wbcVar, yacVar, rfcVar, sccVar, atomicLong, vfcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = wbcVar;
            this.a = yacVar;
            this.b = rfcVar;
            this.c = sccVar;
            this.d = atomicLong;
            this.e = vfcVar;
        }

        @Override // com.baidu.tieba.fbc
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
    public class c implements sac.b<Notification<?>, Notification<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wbc a;

        /* loaded from: classes8.dex */
        public class a extends yac<Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ yac e;
            public final /* synthetic */ c f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, yac yacVar, yac yacVar2) {
                super(yacVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, yacVar, yacVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((yac) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = cVar;
                this.e = yacVar2;
            }

            @Override // com.baidu.tieba.yac
            public void f(uac uacVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, uacVar) == null) {
                    uacVar.request(Long.MAX_VALUE);
                }
            }

            @Override // com.baidu.tieba.tac
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    this.e.onError(th);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.tac
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

            @Override // com.baidu.tieba.tac
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.e.onCompleted();
                }
            }
        }

        public c(wbc wbcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wbcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wbcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sac.b, com.baidu.tieba.lbc
        public yac<? super Notification<?>> call(yac<? super Notification<?>> yacVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yacVar)) == null) {
                return new a(this, yacVar, yacVar);
            }
            return (yac) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements fbc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sac a;
        public final /* synthetic */ yac b;
        public final /* synthetic */ AtomicLong c;
        public final /* synthetic */ vac.a d;
        public final /* synthetic */ fbc e;
        public final /* synthetic */ AtomicBoolean f;

        /* loaded from: classes8.dex */
        public class a extends yac<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, yac yacVar) {
                super(yacVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, yacVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((yac) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = dVar;
            }

            @Override // com.baidu.tieba.yac
            public void f(uac uacVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, uacVar) == null) {
                    uacVar.request(Long.MAX_VALUE);
                }
            }

            @Override // com.baidu.tieba.tac
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.b.onError(th);
                }
            }

            @Override // com.baidu.tieba.tac
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.e.b.onCompleted();
                }
            }

            @Override // com.baidu.tieba.tac
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

        public d(wbc wbcVar, sac sacVar, yac yacVar, AtomicLong atomicLong, vac.a aVar, fbc fbcVar, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wbcVar, sacVar, yacVar, atomicLong, aVar, fbcVar, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sacVar;
            this.b = yacVar;
            this.c = atomicLong;
            this.d = aVar;
            this.e = fbcVar;
            this.f = atomicBoolean;
        }

        @Override // com.baidu.tieba.fbc
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.O(new a(this, this.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements uac {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicLong a;
        public final /* synthetic */ scc b;
        public final /* synthetic */ AtomicBoolean c;
        public final /* synthetic */ vac.a d;
        public final /* synthetic */ fbc e;

        public e(wbc wbcVar, AtomicLong atomicLong, scc sccVar, AtomicBoolean atomicBoolean, vac.a aVar, fbc fbcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wbcVar, atomicLong, sccVar, atomicBoolean, aVar, fbcVar};
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
            this.b = sccVar;
            this.c = atomicBoolean;
            this.d = aVar;
            this.e = fbcVar;
        }

        @Override // com.baidu.tieba.uac
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && j > 0) {
                pbc.b(this.a, j);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948266257, "Lcom/baidu/tieba/wbc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948266257, "Lcom/baidu/tieba/wbc;");
                return;
            }
        }
        f = new a();
    }

    public wbc(sac<T> sacVar, lbc<? super sac<? extends Notification<?>>, ? extends sac<?>> lbcVar, boolean z, boolean z2, vac vacVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sacVar, lbcVar, Boolean.valueOf(z), Boolean.valueOf(z2), vacVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = sacVar;
        this.b = lbcVar;
        this.c = z;
        this.d = z2;
        this.e = vacVar;
    }

    public static <T> sac<T> a(sac<T> sacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, sacVar)) == null) {
            return b(sacVar, f);
        }
        return (sac) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yac) ((yac) obj));
    }

    public static <T> sac<T> b(sac<T> sacVar, lbc<? super sac<? extends Notification<?>>, ? extends sac<?>> lbcVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, sacVar, lbcVar)) == null) {
            return sac.d(new wbc(sacVar, lbcVar, true, false, Schedulers.trampoline()));
        }
        return (sac) invokeLL.objValue;
    }

    public void call(yac<? super T> yacVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yacVar) == null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            AtomicLong atomicLong = new AtomicLong();
            vac.a createWorker = this.e.createWorker();
            yacVar.b(createWorker);
            vfc vfcVar = new vfc();
            yacVar.b(vfcVar);
            qfc<T, T> P = ofc.Q().P();
            P.F(dfc.a());
            scc sccVar = new scc();
            b bVar = new b(this, yacVar, P, sccVar, atomicLong, vfcVar);
            createWorker.b(new d(this, this.b.call(P.o(new c(this))), yacVar, atomicLong, createWorker, bVar, atomicBoolean));
            yacVar.f(new e(this, atomicLong, sccVar, atomicBoolean, createWorker, bVar));
        }
    }
}
