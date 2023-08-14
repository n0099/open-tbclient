package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c1c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public final class s2c<T> implements c1c.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c1c<T> a;
    public final m1c<? super T> b;
    public final m1c<Throwable> c;

    /* loaded from: classes7.dex */
    public static final class a<T> extends d1c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final d1c<? super T> b;
        public final m1c<? super T> c;
        public final m1c<Throwable> d;

        public a(d1c<? super T> d1cVar, m1c<? super T> m1cVar, m1c<Throwable> m1cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d1cVar, m1cVar, m1cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d1cVar;
            this.c = m1cVar;
            this.d = m1cVar2;
        }

        @Override // com.baidu.tieba.d1c
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    k1c.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.baidu.tieba.d1c
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    k1c.h(th, this, t);
                }
            }
        }
    }

    public s2c(c1c<T> c1cVar, m1c<? super T> m1cVar, m1c<Throwable> m1cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c1cVar, m1cVar, m1cVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c1cVar;
        this.b = m1cVar;
        this.c = m1cVar2;
    }

    public void call(d1c<? super T> d1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d1cVar) == null) {
            a aVar = new a(d1cVar, this.b, this.c);
            d1cVar.a(aVar);
            this.a.j(aVar);
        }
    }

    @Override // com.baidu.tieba.c1c.c, com.baidu.tieba.m1c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((d1c) ((d1c) obj));
    }
}
