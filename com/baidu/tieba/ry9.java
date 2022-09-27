package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fx9;
import com.baidu.tieba.ix9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeoutException;
/* loaded from: classes5.dex */
public class ry9<T> implements fx9.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;
    public final b<T> b;
    public final fx9<? extends T> c;
    public final ix9 d;

    /* loaded from: classes5.dex */
    public interface a<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3);
    }

    /* loaded from: classes5.dex */
    public interface b<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3, T4 t4);
    }

    /* loaded from: classes5.dex */
    public static final class c<T> extends lx9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b2a e;
        public final i1a<T> f;
        public final b<T> g;
        public final fx9<? extends T> h;
        public final ix9.a i;
        public final yy9 j;
        public boolean k;
        public long l;

        /* loaded from: classes5.dex */
        public class a extends lx9<T> {
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

            @Override // com.baidu.tieba.lx9
            public void f(hx9 hx9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hx9Var) == null) {
                    this.e.j.c(hx9Var);
                }
            }

            @Override // com.baidu.tieba.gx9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.e.f.onCompleted();
                }
            }

            @Override // com.baidu.tieba.gx9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.f.onError(th);
                }
            }

            @Override // com.baidu.tieba.gx9
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.e.f.onNext(t);
                }
            }
        }

        public c(i1a<T> i1aVar, b<T> bVar, b2a b2aVar, fx9<? extends T> fx9Var, ix9.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i1aVar, bVar, b2aVar, fx9Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = i1aVar;
            this.g = bVar;
            this.e = b2aVar;
            this.h = fx9Var;
            this.i = aVar;
            this.j = new yy9();
        }

        @Override // com.baidu.tieba.lx9
        public void f(hx9 hx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hx9Var) == null) {
                this.j.c(hx9Var);
            }
        }

        public void g(long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                synchronized (this) {
                    z = true;
                    if (j != this.l || this.k) {
                        z = false;
                    } else {
                        this.k = true;
                    }
                }
                if (z) {
                    if (this.h == null) {
                        this.f.onError(new TimeoutException());
                        return;
                    }
                    a aVar = new a(this);
                    this.h.B(aVar);
                    this.e.a(aVar);
                }
            }
        }

        @Override // com.baidu.tieba.gx9
        public void onCompleted() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    z = true;
                    if (this.k) {
                        z = false;
                    } else {
                        this.k = true;
                    }
                }
                if (z) {
                    this.e.unsubscribe();
                    this.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.gx9
        public void onError(Throwable th) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                synchronized (this) {
                    z = true;
                    if (this.k) {
                        z = false;
                    } else {
                        this.k = true;
                    }
                }
                if (z) {
                    this.e.unsubscribe();
                    this.f.onError(th);
                }
            }
        }

        @Override // com.baidu.tieba.gx9
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
                    this.e.a((mx9) this.g.call(this, Long.valueOf(j), t, this.i));
                }
            }
        }
    }

    public ry9(a<T> aVar, b<T> bVar, fx9<? extends T> fx9Var, ix9 ix9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, fx9Var, ix9Var};
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
        this.c = fx9Var;
        this.d = ix9Var;
    }

    @Override // com.baidu.tieba.fx9.b, com.baidu.tieba.xx9
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((lx9) ((lx9) obj));
    }

    public lx9<? super T> call(lx9<? super T> lx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lx9Var)) == null) {
            ix9.a createWorker = this.d.createWorker();
            lx9Var.b(createWorker);
            i1a i1aVar = new i1a(lx9Var);
            b2a b2aVar = new b2a();
            i1aVar.b(b2aVar);
            c cVar = new c(i1aVar, this.b, b2aVar, this.c, createWorker);
            i1aVar.b(cVar);
            i1aVar.f(cVar.j);
            b2aVar.a((mx9) this.a.call(cVar, 0L, createWorker));
            return cVar;
        }
        return (lx9) invokeL.objValue;
    }
}
