package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.sac;
import com.baidu.tieba.vac;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeoutException;
/* loaded from: classes6.dex */
public class lcc<T> implements sac.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;
    public final b<T> b;
    public final sac<? extends T> c;
    public final vac d;

    /* loaded from: classes6.dex */
    public interface a<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3);
    }

    /* loaded from: classes6.dex */
    public interface b<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3, T4 t4);
    }

    /* loaded from: classes6.dex */
    public static final class c<T> extends yac<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final vfc e;
        public final cfc<T> f;
        public final b<T> g;
        public final sac<? extends T> h;
        public final vac.a i;
        public final scc j;
        public boolean k;
        public long l;

        /* loaded from: classes6.dex */
        public class a extends yac<T> {
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

            @Override // com.baidu.tieba.yac
            public void f(uac uacVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, uacVar) == null) {
                    this.e.j.c(uacVar);
                }
            }

            @Override // com.baidu.tieba.tac
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.f.onError(th);
                }
            }

            @Override // com.baidu.tieba.tac
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.e.f.onNext(t);
                }
            }

            @Override // com.baidu.tieba.tac
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.e.f.onCompleted();
                }
            }
        }

        public c(cfc<T> cfcVar, b<T> bVar, vfc vfcVar, sac<? extends T> sacVar, vac.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cfcVar, bVar, vfcVar, sacVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = cfcVar;
            this.g = bVar;
            this.e = vfcVar;
            this.h = sacVar;
            this.i = aVar;
            this.j = new scc();
        }

        @Override // com.baidu.tieba.yac
        public void f(uac uacVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, uacVar) == null) {
                this.j.c(uacVar);
            }
        }

        @Override // com.baidu.tieba.tac
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

        @Override // com.baidu.tieba.tac
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
                    this.e.a((zac) this.g.call(this, Long.valueOf(j), t, this.i));
                }
            }
        }

        @Override // com.baidu.tieba.tac
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

    public lcc(a<T> aVar, b<T> bVar, sac<? extends T> sacVar, vac vacVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, sacVar, vacVar};
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
        this.c = sacVar;
        this.d = vacVar;
    }

    public yac<? super T> call(yac<? super T> yacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yacVar)) == null) {
            vac.a createWorker = this.d.createWorker();
            yacVar.b(createWorker);
            cfc cfcVar = new cfc(yacVar);
            vfc vfcVar = new vfc();
            cfcVar.b(vfcVar);
            c cVar = new c(cfcVar, this.b, vfcVar, this.c, createWorker);
            cfcVar.b(cVar);
            cfcVar.f(cVar.j);
            vfcVar.a((zac) this.a.call(cVar, 0L, createWorker));
            return cVar;
        }
        return (yac) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sac.b, com.baidu.tieba.lbc
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((yac) ((yac) obj));
    }
}
