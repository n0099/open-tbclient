package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u1c;
import com.baidu.tieba.x1c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeoutException;
/* loaded from: classes6.dex */
public class m3c<T> implements u1c.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;
    public final b<T> b;
    public final u1c<? extends T> c;
    public final x1c d;

    /* loaded from: classes6.dex */
    public interface a<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3);
    }

    /* loaded from: classes6.dex */
    public interface b<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3, T4 t4);
    }

    /* loaded from: classes6.dex */
    public static final class c<T> extends a2c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final w6c e;
        public final d6c<T> f;
        public final b<T> g;
        public final u1c<? extends T> h;
        public final x1c.a i;
        public final t3c j;
        public boolean k;
        public long l;

        /* loaded from: classes6.dex */
        public class a extends a2c<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c e;

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
                this.e = cVar;
            }

            @Override // com.baidu.tieba.a2c
            public void f(w1c w1cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, w1cVar) == null) {
                    this.e.j.c(w1cVar);
                }
            }

            @Override // com.baidu.tieba.v1c
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.f.onError(th);
                }
            }

            @Override // com.baidu.tieba.v1c
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.e.f.onNext(t);
                }
            }

            @Override // com.baidu.tieba.v1c
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.e.f.onCompleted();
                }
            }
        }

        public c(d6c<T> d6cVar, b<T> bVar, w6c w6cVar, u1c<? extends T> u1cVar, x1c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d6cVar, bVar, w6cVar, u1cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = d6cVar;
            this.g = bVar;
            this.e = w6cVar;
            this.h = u1cVar;
            this.i = aVar;
            this.j = new t3c();
        }

        @Override // com.baidu.tieba.a2c
        public void f(w1c w1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, w1cVar) == null) {
                this.j.c(w1cVar);
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onError(Throwable th) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                synchronized (this) {
                    z = true;
                    if (!this.k) {
                        this.k = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    this.e.unsubscribe();
                    this.f.onError(th);
                }
            }
        }

        public void g(long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                synchronized (this) {
                    z = true;
                    if (j == this.l && !this.k) {
                        this.k = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    if (this.h == null) {
                        this.f.onError(new TimeoutException());
                        return;
                    }
                    a aVar = new a(this);
                    this.h.O(aVar);
                    this.e.a(aVar);
                }
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onNext(T t) {
            long j;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
                synchronized (this) {
                    if (!this.k) {
                        j = this.l + 1;
                        this.l = j;
                        z = true;
                    } else {
                        j = this.l;
                        z = false;
                    }
                }
                if (z) {
                    this.f.onNext(t);
                    this.e.a((b2c) this.g.call(this, Long.valueOf(j), t, this.i));
                }
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onCompleted() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    z = true;
                    if (!this.k) {
                        this.k = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    this.e.unsubscribe();
                    this.f.onCompleted();
                }
            }
        }
    }

    public m3c(a<T> aVar, b<T> bVar, u1c<? extends T> u1cVar, x1c x1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, u1cVar, x1cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
        this.b = bVar;
        this.c = u1cVar;
        this.d = x1cVar;
    }

    public a2c<? super T> call(a2c<? super T> a2cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, a2cVar)) == null) {
            x1c.a createWorker = this.d.createWorker();
            a2cVar.b(createWorker);
            d6c d6cVar = new d6c(a2cVar);
            w6c w6cVar = new w6c();
            d6cVar.b(w6cVar);
            c cVar = new c(d6cVar, this.b, w6cVar, this.c, createWorker);
            d6cVar.b(cVar);
            d6cVar.f(cVar.j);
            w6cVar.a((b2c) this.a.call(cVar, 0L, createWorker));
            return cVar;
        }
        return (a2c) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u1c.b, com.baidu.tieba.m2c
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((a2c) ((a2c) obj));
    }
}
