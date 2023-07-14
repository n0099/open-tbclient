package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u1c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes8.dex */
public final class u2c<T> implements u1c.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final u1c<T> a;
    public final m2c<? super T, Boolean> b;

    /* loaded from: classes8.dex */
    public static final class a<T> extends a2c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final a2c<? super T> e;
        public final m2c<? super T, Boolean> f;
        public boolean g;

        public a(a2c<? super T> a2cVar, m2c<? super T, Boolean> m2cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a2cVar, m2cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = a2cVar;
            this.f = m2cVar;
            e(0L);
        }

        @Override // com.baidu.tieba.a2c
        public void f(w1c w1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, w1cVar) == null) {
                super.f(w1cVar);
                this.e.f(w1cVar);
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (this.g) {
                    h6c.j(th);
                    return;
                }
                this.g = true;
                this.e.onError(th);
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.g) {
                return;
            }
            this.e.onCompleted();
        }

        @Override // com.baidu.tieba.v1c
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                try {
                    if (this.f.call(t).booleanValue()) {
                        this.e.onNext(t);
                    } else {
                        e(1L);
                    }
                } catch (Throwable th) {
                    g2c.e(th);
                    unsubscribe();
                    onError(OnErrorThrowable.addValueAsLastCause(th, t));
                }
            }
        }
    }

    public u2c(u1c<T> u1cVar, m2c<? super T, Boolean> m2cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u1cVar, m2cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = u1cVar;
        this.b = m2cVar;
    }

    public void call(a2c<? super T> a2cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, a2cVar) == null) {
            a aVar = new a(a2cVar, this.b);
            a2cVar.b(aVar);
            this.a.O(aVar);
        }
    }

    @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((a2c) ((a2c) obj));
    }
}
