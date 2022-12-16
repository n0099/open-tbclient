package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e3a;
import com.baidu.tieba.f3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class o4a<T> implements f3a.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f3a.c<T> a;
    public final long b;
    public final TimeUnit c;
    public final e3a d;

    /* loaded from: classes5.dex */
    public static final class a<T> extends g3a<T> implements o3a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final g3a<? super T> b;
        public final e3a.a c;
        public final long d;
        public final TimeUnit e;
        public T f;
        public Throwable g;

        public a(g3a<? super T> g3aVar, e3a.a aVar, long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g3aVar, aVar, Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g3aVar;
            this.c = aVar;
            this.d = j;
            this.e = timeUnit;
        }

        @Override // com.baidu.tieba.g3a
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.g = th;
                this.c.c(this, this.d, this.e);
            }
        }

        @Override // com.baidu.tieba.g3a
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.f = t;
                this.c.c(this, this.d, this.e);
            }
        }

        @Override // com.baidu.tieba.o3a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    Throwable th = this.g;
                    if (th != null) {
                        this.g = null;
                        this.b.b(th);
                    } else {
                        T t = this.f;
                        this.f = null;
                        this.b.c(t);
                    }
                } finally {
                    this.c.unsubscribe();
                }
            }
        }
    }

    public o4a(f3a.c<T> cVar, long j, TimeUnit timeUnit, e3a e3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, Long.valueOf(j), timeUnit, e3aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cVar;
        this.d = e3aVar;
        this.b = j;
        this.c = timeUnit;
    }

    public void call(g3a<? super T> g3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, g3aVar) == null) {
            e3a.a createWorker = this.d.createWorker();
            a aVar = new a(g3aVar, createWorker, this.b, this.c);
            g3aVar.a(createWorker);
            g3aVar.a(aVar);
            this.a.call(aVar);
        }
    }

    @Override // com.baidu.tieba.f3a.c, com.baidu.tieba.p3a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((g3a) ((g3a) obj));
    }
}
