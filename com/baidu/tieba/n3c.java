package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.x1c;
import com.baidu.tieba.y1c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class n3c<T> implements y1c.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final y1c.c<T> a;
    public final long b;
    public final TimeUnit c;
    public final x1c d;

    /* loaded from: classes7.dex */
    public static final class a<T> extends z1c<T> implements h2c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final z1c<? super T> b;
        public final x1c.a c;
        public final long d;
        public final TimeUnit e;
        public T f;
        public Throwable g;

        public a(z1c<? super T> z1cVar, x1c.a aVar, long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z1cVar, aVar, Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z1cVar;
            this.c = aVar;
            this.d = j;
            this.e = timeUnit;
        }

        @Override // com.baidu.tieba.z1c
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.g = th;
                this.c.c(this, this.d, this.e);
            }
        }

        @Override // com.baidu.tieba.z1c
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.f = t;
                this.c.c(this, this.d, this.e);
            }
        }

        @Override // com.baidu.tieba.h2c
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

    public n3c(y1c.c<T> cVar, long j, TimeUnit timeUnit, x1c x1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, Long.valueOf(j), timeUnit, x1cVar};
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
        this.d = x1cVar;
        this.b = j;
        this.c = timeUnit;
    }

    public void call(z1c<? super T> z1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, z1cVar) == null) {
            x1c.a createWorker = this.d.createWorker();
            a aVar = new a(z1cVar, createWorker, this.b, this.c);
            z1cVar.a(createWorker);
            z1cVar.a(aVar);
            this.a.call(aVar);
        }
    }

    @Override // com.baidu.tieba.y1c.c, com.baidu.tieba.i2c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((z1c) ((z1c) obj));
    }
}
