package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.f3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.CompositeException;
/* loaded from: classes5.dex */
public final class p4a<T> implements f3a.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f3a<T> a;
    public final p3a<? super T> b;
    public final p3a<Throwable> c;

    /* loaded from: classes5.dex */
    public static final class a<T> extends g3a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final g3a<? super T> b;
        public final p3a<? super T> c;
        public final p3a<Throwable> d;

        public a(g3a<? super T> g3aVar, p3a<? super T> p3aVar, p3a<Throwable> p3aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g3aVar, p3aVar, p3aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g3aVar;
            this.c = p3aVar;
            this.d = p3aVar2;
        }

        @Override // com.baidu.tieba.g3a
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    n3a.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.baidu.tieba.g3a
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    n3a.h(th, this, t);
                }
            }
        }
    }

    public p4a(f3a<T> f3aVar, p3a<? super T> p3aVar, p3a<Throwable> p3aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f3aVar, p3aVar, p3aVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = f3aVar;
        this.b = p3aVar;
        this.c = p3aVar2;
    }

    public void call(g3a<? super T> g3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, g3aVar) == null) {
            a aVar = new a(g3aVar, this.b, this.c);
            g3aVar.a(aVar);
            this.a.j(aVar);
        }
    }

    @Override // com.baidu.tieba.f3a.c, com.baidu.tieba.p3a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((g3a) ((g3a) obj));
    }
}
