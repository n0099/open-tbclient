package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gz9;
import com.baidu.tieba.jz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeoutException;
/* loaded from: classes5.dex */
public class s0a<T> implements gz9.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;
    public final b<T> b;
    public final gz9<? extends T> c;
    public final jz9 d;

    /* loaded from: classes5.dex */
    public interface a<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3);
    }

    /* loaded from: classes5.dex */
    public interface b<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3, T4 t4);
    }

    /* loaded from: classes5.dex */
    public static final class c<T> extends mz9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c4a e;
        public final j3a<T> f;
        public final b<T> g;
        public final gz9<? extends T> h;
        public final jz9.a i;
        public final z0a j;
        public boolean k;
        public long l;

        /* loaded from: classes5.dex */
        public class a extends mz9<T> {
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

            @Override // com.baidu.tieba.mz9
            public void f(iz9 iz9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iz9Var) == null) {
                    this.e.j.c(iz9Var);
                }
            }

            @Override // com.baidu.tieba.hz9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.f.onError(th);
                }
            }

            @Override // com.baidu.tieba.hz9
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.e.f.onNext(t);
                }
            }

            @Override // com.baidu.tieba.hz9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.e.f.onCompleted();
                }
            }
        }

        public c(j3a<T> j3aVar, b<T> bVar, c4a c4aVar, gz9<? extends T> gz9Var, jz9.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j3aVar, bVar, c4aVar, gz9Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = j3aVar;
            this.g = bVar;
            this.e = c4aVar;
            this.h = gz9Var;
            this.i = aVar;
            this.j = new z0a();
        }

        @Override // com.baidu.tieba.mz9
        public void f(iz9 iz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iz9Var) == null) {
                this.j.c(iz9Var);
            }
        }

        @Override // com.baidu.tieba.hz9
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
                    this.h.B(aVar);
                    this.e.a(aVar);
                }
            }
        }

        @Override // com.baidu.tieba.hz9
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
                    this.e.a((nz9) this.g.call(this, Long.valueOf(j), t, this.i));
                }
            }
        }

        @Override // com.baidu.tieba.hz9
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

    public s0a(a<T> aVar, b<T> bVar, gz9<? extends T> gz9Var, jz9 jz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, gz9Var, jz9Var};
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
        this.c = gz9Var;
        this.d = jz9Var;
    }

    public mz9<? super T> call(mz9<? super T> mz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mz9Var)) == null) {
            jz9.a createWorker = this.d.createWorker();
            mz9Var.b(createWorker);
            j3a j3aVar = new j3a(mz9Var);
            c4a c4aVar = new c4a();
            j3aVar.b(c4aVar);
            c cVar = new c(j3aVar, this.b, c4aVar, this.c, createWorker);
            j3aVar.b(cVar);
            j3aVar.f(cVar.j);
            c4aVar.a((nz9) this.a.call(cVar, 0L, createWorker));
            return cVar;
        }
        return (mz9) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gz9.b, com.baidu.tieba.yz9
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((mz9) ((mz9) obj));
    }
}
