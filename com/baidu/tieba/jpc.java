package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.doc;
import com.baidu.tieba.goc;
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
/* loaded from: classes6.dex */
public final class jpc<T> implements doc.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final woc<doc<? extends Notification<?>>, doc<?>> f;
    public transient /* synthetic */ FieldHolder $fh;
    public final doc<T> a;
    public final woc<? super doc<? extends Notification<?>>, ? extends doc<?>> b;
    public final boolean c;
    public final boolean d;
    public final goc e;

    /* loaded from: classes6.dex */
    public static class a implements woc<doc<? extends Notification<?>>, doc<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.jpc$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0367a implements woc<Notification<?>, Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0367a(a aVar) {
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
            @Override // com.baidu.tieba.woc
            /* renamed from: a */
            public Notification<?> call(Notification<?> notification) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, notification)) == null) {
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
        /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: com.baidu.tieba.doc<R>, com.baidu.tieba.doc<?> */
        @Override // com.baidu.tieba.woc
        /* renamed from: a */
        public doc<?> call(doc<? extends Notification<?>> docVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, docVar)) == null) {
                return docVar.p(new C0367a(this));
            }
            return (doc) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements qoc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ joc a;
        public final /* synthetic */ etc b;
        public final /* synthetic */ fqc c;
        public final /* synthetic */ AtomicLong d;
        public final /* synthetic */ itc e;
        public final /* synthetic */ jpc f;

        /* loaded from: classes6.dex */
        public class a extends joc<T> {
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

            @Override // com.baidu.tieba.joc
            public void f(foc focVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, focVar) == null) {
                    this.f.c.c(focVar);
                }
            }

            @Override // com.baidu.tieba.eoc
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, th) == null) && !this.e) {
                    this.e = true;
                    unsubscribe();
                    this.f.b.onNext(Notification.b(th));
                }
            }

            @Override // com.baidu.tieba.eoc
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

            @Override // com.baidu.tieba.eoc
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.e) {
                    this.e = true;
                    unsubscribe();
                    this.f.b.onNext(Notification.a());
                }
            }
        }

        public b(jpc jpcVar, joc jocVar, etc etcVar, fqc fqcVar, AtomicLong atomicLong, itc itcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jpcVar, jocVar, etcVar, fqcVar, atomicLong, itcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = jpcVar;
            this.a = jocVar;
            this.b = etcVar;
            this.c = fqcVar;
            this.d = atomicLong;
            this.e = itcVar;
        }

        @Override // com.baidu.tieba.qoc
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

    /* loaded from: classes6.dex */
    public class c implements doc.b<Notification<?>, Notification<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jpc a;

        /* loaded from: classes6.dex */
        public class a extends joc<Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ joc e;
            public final /* synthetic */ c f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, joc jocVar, joc jocVar2) {
                super(jocVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, jocVar, jocVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((joc) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = cVar;
                this.e = jocVar2;
            }

            @Override // com.baidu.tieba.joc
            public void f(foc focVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, focVar) == null) {
                    focVar.request(Long.MAX_VALUE);
                }
            }

            @Override // com.baidu.tieba.eoc
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    this.e.onError(th);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.eoc
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

            @Override // com.baidu.tieba.eoc
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.e.onCompleted();
                }
            }
        }

        public c(jpc jpcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jpcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jpcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.woc
        /* renamed from: a */
        public joc<? super Notification<?>> call(joc<? super Notification<?>> jocVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jocVar)) == null) {
                return new a(this, jocVar, jocVar);
            }
            return (joc) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements qoc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ doc a;
        public final /* synthetic */ joc b;
        public final /* synthetic */ AtomicLong c;
        public final /* synthetic */ goc.a d;
        public final /* synthetic */ qoc e;
        public final /* synthetic */ AtomicBoolean f;

        /* loaded from: classes6.dex */
        public class a extends joc<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, joc jocVar) {
                super(jocVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, jocVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((joc) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = dVar;
            }

            @Override // com.baidu.tieba.joc
            public void f(foc focVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, focVar) == null) {
                    focVar.request(Long.MAX_VALUE);
                }
            }

            @Override // com.baidu.tieba.eoc
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.b.onError(th);
                }
            }

            @Override // com.baidu.tieba.eoc
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.e.b.onCompleted();
                }
            }

            @Override // com.baidu.tieba.eoc
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

        public d(jpc jpcVar, doc docVar, joc jocVar, AtomicLong atomicLong, goc.a aVar, qoc qocVar, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jpcVar, docVar, jocVar, atomicLong, aVar, qocVar, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = docVar;
            this.b = jocVar;
            this.c = atomicLong;
            this.d = aVar;
            this.e = qocVar;
            this.f = atomicBoolean;
        }

        @Override // com.baidu.tieba.qoc
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.O(new a(this, this.b));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements foc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicLong a;
        public final /* synthetic */ fqc b;
        public final /* synthetic */ AtomicBoolean c;
        public final /* synthetic */ goc.a d;
        public final /* synthetic */ qoc e;

        public e(jpc jpcVar, AtomicLong atomicLong, fqc fqcVar, AtomicBoolean atomicBoolean, goc.a aVar, qoc qocVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jpcVar, atomicLong, fqcVar, atomicBoolean, aVar, qocVar};
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
            this.b = fqcVar;
            this.c = atomicBoolean;
            this.d = aVar;
            this.e = qocVar;
        }

        @Override // com.baidu.tieba.foc
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && j > 0) {
                cpc.b(this.a, j);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947892428, "Lcom/baidu/tieba/jpc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947892428, "Lcom/baidu/tieba/jpc;");
                return;
            }
        }
        f = new a();
    }

    public jpc(doc<T> docVar, woc<? super doc<? extends Notification<?>>, ? extends doc<?>> wocVar, boolean z, boolean z2, goc gocVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {docVar, wocVar, Boolean.valueOf(z), Boolean.valueOf(z2), gocVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = docVar;
        this.b = wocVar;
        this.c = z;
        this.d = z2;
        this.e = gocVar;
    }

    public static <T> doc<T> b(doc<T> docVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, docVar)) == null) {
            return c(docVar, f);
        }
        return (doc) invokeL.objValue;
    }

    public static <T> doc<T> c(doc<T> docVar, woc<? super doc<? extends Notification<?>>, ? extends doc<?>> wocVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, docVar, wocVar)) == null) {
            return doc.d(new jpc(docVar, wocVar, true, false, Schedulers.trampoline()));
        }
        return (doc) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.roc
    /* renamed from: a */
    public void call(joc<? super T> jocVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jocVar) == null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            AtomicLong atomicLong = new AtomicLong();
            goc.a createWorker = this.e.createWorker();
            jocVar.b(createWorker);
            itc itcVar = new itc();
            jocVar.b(itcVar);
            dtc<T, T> P = btc.Q().P();
            P.F(qsc.a());
            fqc fqcVar = new fqc();
            b bVar = new b(this, jocVar, P, fqcVar, atomicLong, itcVar);
            createWorker.b(new d(this, this.b.call(P.o(new c(this))), jocVar, atomicLong, createWorker, bVar, atomicBoolean));
            jocVar.f(new e(this, atomicLong, fqcVar, atomicBoolean, createWorker, bVar));
        }
    }
}
