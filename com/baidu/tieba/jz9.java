package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ay9;
import com.baidu.tieba.xx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeoutException;
/* loaded from: classes4.dex */
public class jz9 implements xx9.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a a;
    public final b b;
    public final xx9 c;
    public final ay9 d;

    /* loaded from: classes4.dex */
    public interface a {
        /* synthetic */ Object call(Object obj, Object obj2, Object obj3);
    }

    /* loaded from: classes4.dex */
    public interface b {
        /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4);
    }

    /* loaded from: classes4.dex */
    public final class c extends dy9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final t2a e;
        public final a2a f;
        public final b g;
        public final xx9 h;
        public final ay9.a i;
        public final qz9 j;
        public boolean k;
        public long l;

        /* loaded from: classes4.dex */
        public class a extends dy9 {
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

            @Override // com.baidu.tieba.dy9
            public void f(zx9 zx9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, zx9Var) == null) {
                    this.e.j.c(zx9Var);
                }
            }

            @Override // com.baidu.tieba.yx9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.f.onError(th);
                }
            }

            @Override // com.baidu.tieba.yx9
            public void onNext(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
                    this.e.f.onNext(obj);
                }
            }

            @Override // com.baidu.tieba.yx9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.e.f.onCompleted();
                }
            }
        }

        public c(a2a a2aVar, b bVar, t2a t2aVar, xx9 xx9Var, ay9.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a2aVar, bVar, t2aVar, xx9Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = a2aVar;
            this.g = bVar;
            this.e = t2aVar;
            this.h = xx9Var;
            this.i = aVar;
            this.j = new qz9();
        }

        @Override // com.baidu.tieba.dy9
        public void f(zx9 zx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zx9Var) == null) {
                this.j.c(zx9Var);
            }
        }

        @Override // com.baidu.tieba.yx9
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

        @Override // com.baidu.tieba.yx9
        public void onNext(Object obj) {
            long j;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
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
                    this.f.onNext(obj);
                    this.e.a((ey9) this.g.call(this, Long.valueOf(j), obj, this.i));
                }
            }
        }

        @Override // com.baidu.tieba.yx9
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

    public jz9(a aVar, b bVar, xx9 xx9Var, ay9 ay9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, xx9Var, ay9Var};
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
        this.c = xx9Var;
        this.d = ay9Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xx9.b, com.baidu.tieba.py9
    public dy9 call(dy9 dy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dy9Var)) == null) {
            ay9.a createWorker = this.d.createWorker();
            dy9Var.b(createWorker);
            a2a a2aVar = new a2a(dy9Var);
            t2a t2aVar = new t2a();
            a2aVar.b(t2aVar);
            c cVar = new c(a2aVar, this.b, t2aVar, this.c, createWorker);
            a2aVar.b(cVar);
            a2aVar.f(cVar.j);
            t2aVar.a((ey9) this.a.call(cVar, 0L, createWorker));
            return cVar;
        }
        return (dy9) invokeL.objValue;
    }
}
