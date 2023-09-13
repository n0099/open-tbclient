package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vac;
import com.baidu.tieba.wac;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class qcc<T> implements wac.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final wac.c<T> a;
    public final vac b;

    /* loaded from: classes7.dex */
    public static final class a<T> extends xac<T> implements fbc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final xac<? super T> b;
        public final vac.a c;
        public T d;
        public Throwable e;

        public a(xac<? super T> xacVar, vac.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xacVar, aVar};
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
        }

        @Override // com.baidu.tieba.xac
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.e = th;
                this.c.b(this);
            }
        }

        @Override // com.baidu.tieba.xac
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.d = t;
                this.c.b(this);
            }
        }

        @Override // com.baidu.tieba.fbc
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

    public qcc(wac.c<T> cVar, vac vacVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, vacVar};
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
        this.b = vacVar;
    }

    public void call(xac<? super T> xacVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xacVar) == null) {
            vac.a createWorker = this.b.createWorker();
            a aVar = new a(xacVar, createWorker);
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
