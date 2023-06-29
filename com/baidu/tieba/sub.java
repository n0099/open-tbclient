package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.btb;
import com.baidu.tieba.xsb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public final class sub<T> implements btb.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final xsb.a<T> a;

    /* loaded from: classes7.dex */
    public static final class a<T> extends dtb<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ctb<? super T> e;
        public T f;
        public int g;

        public a(ctb<? super T> ctbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ctbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ctbVar;
        }

        @Override // com.baidu.tieba.ysb
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.g == 2) {
                    kxb.j(th);
                    return;
                }
                this.f = null;
                this.e.b(th);
            }
        }

        @Override // com.baidu.tieba.ysb
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                int i = this.g;
                if (i == 0) {
                    this.g = 1;
                    this.f = t;
                } else if (i == 1) {
                    this.g = 2;
                    this.e.b(new IndexOutOfBoundsException("The upstream produced more than one value"));
                }
            }
        }

        @Override // com.baidu.tieba.ysb
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.g;
                if (i == 0) {
                    this.e.b(new NoSuchElementException());
                } else if (i == 1) {
                    this.g = 2;
                    T t = this.f;
                    this.f = null;
                    this.e.c(t);
                }
            }
        }
    }

    public sub(xsb.a<T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
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
    }

    public void call(ctb<? super T> ctbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ctbVar) == null) {
            a aVar = new a(ctbVar);
            ctbVar.a(aVar);
            this.a.call(aVar);
        }
    }

    @Override // com.baidu.tieba.btb.c, com.baidu.tieba.ltb
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ctb) ((ctb) obj));
    }
}
