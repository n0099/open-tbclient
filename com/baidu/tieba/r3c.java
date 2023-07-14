package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.x1c;
import com.baidu.tieba.y1c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class r3c<T> implements y1c.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final y1c.c<T> a;
    public final x1c b;

    /* loaded from: classes7.dex */
    public static final class a<T> extends z1c<T> implements h2c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final z1c<? super T> b;
        public final x1c.a c;
        public T d;
        public Throwable e;

        public a(z1c<? super T> z1cVar, x1c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z1cVar, aVar};
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
        }

        @Override // com.baidu.tieba.z1c
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.e = th;
                this.c.b(this);
            }
        }

        @Override // com.baidu.tieba.z1c
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.d = t;
                this.c.b(this);
            }
        }

        @Override // com.baidu.tieba.h2c
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    Throwable th = this.e;
                    if (th != null) {
                        this.e = null;
                        this.b.b(th);
                    } else {
                        T t = this.d;
                        this.d = null;
                        this.b.c(t);
                    }
                } finally {
                    this.c.unsubscribe();
                }
            }
        }
    }

    public r3c(y1c.c<T> cVar, x1c x1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, x1cVar};
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
        this.b = x1cVar;
    }

    public void call(z1c<? super T> z1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, z1cVar) == null) {
            x1c.a createWorker = this.b.createWorker();
            a aVar = new a(z1cVar, createWorker);
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
