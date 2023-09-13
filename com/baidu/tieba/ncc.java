package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.wac;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public final class ncc<T> implements wac.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final wac<T> a;
    public final gbc<? super T> b;
    public final gbc<Throwable> c;

    /* loaded from: classes7.dex */
    public static final class a<T> extends xac<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final xac<? super T> b;
        public final gbc<? super T> c;
        public final gbc<Throwable> d;

        public a(xac<? super T> xacVar, gbc<? super T> gbcVar, gbc<Throwable> gbcVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xacVar, gbcVar, gbcVar2};
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
            this.c = gbcVar;
            this.d = gbcVar2;
        }

        @Override // com.baidu.tieba.xac
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    ebc.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.baidu.tieba.xac
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    ebc.h(th, this, t);
                }
            }
        }
    }

    public ncc(wac<T> wacVar, gbc<? super T> gbcVar, gbc<Throwable> gbcVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wacVar, gbcVar, gbcVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = wacVar;
        this.b = gbcVar;
        this.c = gbcVar2;
    }

    public void call(xac<? super T> xacVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xacVar) == null) {
            a aVar = new a(xacVar, this.b, this.c);
            xacVar.a(aVar);
            this.a.j(aVar);
        }
    }

    @Override // com.baidu.tieba.wac.c, com.baidu.tieba.gbc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((xac) ((xac) obj));
    }
}
