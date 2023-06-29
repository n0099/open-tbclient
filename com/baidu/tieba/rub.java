package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.btb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public final class rub<T> implements btb.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final btb<T> a;
    public final ltb<? super T> b;
    public final ltb<Throwable> c;

    /* loaded from: classes7.dex */
    public static final class a<T> extends ctb<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ctb<? super T> b;
        public final ltb<? super T> c;
        public final ltb<Throwable> d;

        public a(ctb<? super T> ctbVar, ltb<? super T> ltbVar, ltb<Throwable> ltbVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ctbVar, ltbVar, ltbVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ctbVar;
            this.c = ltbVar;
            this.d = ltbVar2;
        }

        @Override // com.baidu.tieba.ctb
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    jtb.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.baidu.tieba.ctb
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    jtb.h(th, this, t);
                }
            }
        }
    }

    public rub(btb<T> btbVar, ltb<? super T> ltbVar, ltb<Throwable> ltbVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {btbVar, ltbVar, ltbVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = btbVar;
        this.b = ltbVar;
        this.c = ltbVar2;
    }

    public void call(ctb<? super T> ctbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ctbVar) == null) {
            a aVar = new a(ctbVar, this.b, this.c);
            ctbVar.a(aVar);
            this.a.j(aVar);
        }
    }

    @Override // com.baidu.tieba.btb.c, com.baidu.tieba.ltb
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ctb) ((ctb) obj));
    }
}
