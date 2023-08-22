package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.q7c;
import com.baidu.tieba.r7c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class l9c<T> implements r7c.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final r7c.c<T> a;
    public final q7c b;

    /* loaded from: classes6.dex */
    public static final class a<T> extends s7c<T> implements a8c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final s7c<? super T> b;
        public final q7c.a c;
        public T d;
        public Throwable e;

        public a(s7c<? super T> s7cVar, q7c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s7cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s7cVar;
            this.c = aVar;
        }

        @Override // com.baidu.tieba.s7c
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.e = th;
                this.c.b(this);
            }
        }

        @Override // com.baidu.tieba.s7c
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.d = t;
                this.c.b(this);
            }
        }

        @Override // com.baidu.tieba.a8c
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

    public l9c(r7c.c<T> cVar, q7c q7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, q7cVar};
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
        this.b = q7cVar;
    }

    public void call(s7c<? super T> s7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, s7cVar) == null) {
            q7c.a createWorker = this.b.createWorker();
            a aVar = new a(s7cVar, createWorker);
            s7cVar.a(createWorker);
            s7cVar.a(aVar);
            this.a.call(aVar);
        }
    }

    @Override // com.baidu.tieba.r7c.c, com.baidu.tieba.b8c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((s7c) ((s7c) obj));
    }
}
