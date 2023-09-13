package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.sac;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes8.dex */
public final class tbc<T> implements sac.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final sac<T> a;
    public final lbc<? super T, Boolean> b;

    /* loaded from: classes8.dex */
    public static final class a<T> extends yac<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final yac<? super T> e;
        public final lbc<? super T, Boolean> f;
        public boolean g;

        public a(yac<? super T> yacVar, lbc<? super T, Boolean> lbcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yacVar, lbcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = yacVar;
            this.f = lbcVar;
            e(0L);
        }

        @Override // com.baidu.tieba.yac
        public void f(uac uacVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, uacVar) == null) {
                super.f(uacVar);
                this.e.f(uacVar);
            }
        }

        @Override // com.baidu.tieba.tac
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (this.g) {
                    gfc.j(th);
                    return;
                }
                this.g = true;
                this.e.onError(th);
            }
        }

        @Override // com.baidu.tieba.tac
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.g) {
                return;
            }
            this.e.onCompleted();
        }

        @Override // com.baidu.tieba.tac
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
                    ebc.e(th);
                    unsubscribe();
                    onError(OnErrorThrowable.addValueAsLastCause(th, t));
                }
            }
        }
    }

    public tbc(sac<T> sacVar, lbc<? super T, Boolean> lbcVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sacVar, lbcVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = sacVar;
        this.b = lbcVar;
    }

    public void call(yac<? super T> yacVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yacVar) == null) {
            a aVar = new a(yacVar, this.b);
            yacVar.b(aVar);
            this.a.O(aVar);
        }
    }

    @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yac) ((yac) obj));
    }
}
