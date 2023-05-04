package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n5b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public final class z6b<T> implements n5b.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final n5b<T> a;
    public final x5b<? super T> b;
    public final x5b<Throwable> c;

    /* loaded from: classes7.dex */
    public static final class a<T> extends o5b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final o5b<? super T> b;
        public final x5b<? super T> c;
        public final x5b<Throwable> d;

        public a(o5b<? super T> o5bVar, x5b<? super T> x5bVar, x5b<Throwable> x5bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o5bVar, x5bVar, x5bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o5bVar;
            this.c = x5bVar;
            this.d = x5bVar2;
        }

        @Override // com.baidu.tieba.o5b
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    v5b.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.baidu.tieba.o5b
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    v5b.h(th, this, t);
                }
            }
        }
    }

    public z6b(n5b<T> n5bVar, x5b<? super T> x5bVar, x5b<Throwable> x5bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n5bVar, x5bVar, x5bVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = n5bVar;
        this.b = x5bVar;
        this.c = x5bVar2;
    }

    public void call(o5b<? super T> o5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, o5bVar) == null) {
            a aVar = new a(o5bVar, this.b, this.c);
            o5bVar.a(aVar);
            this.a.j(aVar);
        }
    }

    @Override // com.baidu.tieba.n5b.c, com.baidu.tieba.x5b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((o5b) ((o5b) obj));
    }
}
