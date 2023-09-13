package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vac;
import com.baidu.tieba.wac;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class mcc<T> implements wac.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final wac.c<T> a;
    public final long b;
    public final TimeUnit c;
    public final vac d;

    /* loaded from: classes7.dex */
    public static final class a<T> extends xac<T> implements fbc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final xac<? super T> b;
        public final vac.a c;
        public final long d;
        public final TimeUnit e;
        public T f;
        public Throwable g;

        public a(xac<? super T> xacVar, vac.a aVar, long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xacVar, aVar, Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xacVar;
            this.c = aVar;
            this.d = j;
            this.e = timeUnit;
        }

        @Override // com.baidu.tieba.xac
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.g = th;
                this.c.c(this, this.d, this.e);
            }
        }

        @Override // com.baidu.tieba.xac
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.f = t;
                this.c.c(this, this.d, this.e);
            }
        }

        @Override // com.baidu.tieba.fbc
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

    public mcc(wac.c<T> cVar, long j, TimeUnit timeUnit, vac vacVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, Long.valueOf(j), timeUnit, vacVar};
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
        this.d = vacVar;
        this.b = j;
        this.c = timeUnit;
    }

    public void call(xac<? super T> xacVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xacVar) == null) {
            vac.a createWorker = this.d.createWorker();
            a aVar = new a(xacVar, createWorker, this.b, this.c);
            xacVar.a(createWorker);
            xacVar.a(aVar);
            this.a.call(aVar);
        }
    }

    @Override // com.baidu.tieba.wac.c, com.baidu.tieba.gbc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((xac) ((xac) obj));
    }
}
