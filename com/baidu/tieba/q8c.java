package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.p7c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public final class q8c<T> implements p7c.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final p7c<T> a;
    public final i8c<? super T, Boolean> b;

    /* loaded from: classes7.dex */
    public static final class a<T> extends v7c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final v7c<? super T> e;
        public final i8c<? super T, Boolean> f;
        public boolean g;

        public a(v7c<? super T> v7cVar, i8c<? super T, Boolean> i8cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v7cVar, i8cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = v7cVar;
            this.f = i8cVar;
            e(0L);
        }

        @Override // com.baidu.tieba.v7c
        public void f(r7c r7cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r7cVar) == null) {
                super.f(r7cVar);
                this.e.f(r7cVar);
            }
        }

        @Override // com.baidu.tieba.q7c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (this.g) {
                    dcc.j(th);
                    return;
                }
                this.g = true;
                this.e.onError(th);
            }
        }

        @Override // com.baidu.tieba.q7c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.g) {
                return;
            }
            this.e.onCompleted();
        }

        @Override // com.baidu.tieba.q7c
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
                    b8c.e(th);
                    unsubscribe();
                    onError(OnErrorThrowable.addValueAsLastCause(th, t));
                }
            }
        }
    }

    public q8c(p7c<T> p7cVar, i8c<? super T, Boolean> i8cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p7cVar, i8cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = p7cVar;
        this.b = i8cVar;
    }

    public void call(v7c<? super T> v7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v7cVar) == null) {
            a aVar = new a(v7cVar, this.b);
            v7cVar.b(aVar);
            this.a.O(aVar);
        }
    }

    @Override // com.baidu.tieba.p7c.a, com.baidu.tieba.d8c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((v7c) ((v7c) obj));
    }
}
