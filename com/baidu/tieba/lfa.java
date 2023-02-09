package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bea;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.CompositeException;
/* loaded from: classes5.dex */
public final class lfa<T> implements bea.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bea<T> a;
    public final lea<? super T> b;
    public final lea<Throwable> c;

    /* loaded from: classes5.dex */
    public static final class a<T> extends cea<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final cea<? super T> b;
        public final lea<? super T> c;
        public final lea<Throwable> d;

        public a(cea<? super T> ceaVar, lea<? super T> leaVar, lea<Throwable> leaVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ceaVar, leaVar, leaVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ceaVar;
            this.c = leaVar;
            this.d = leaVar2;
        }

        @Override // com.baidu.tieba.cea
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    jea.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.baidu.tieba.cea
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    jea.h(th, this, t);
                }
            }
        }
    }

    public lfa(bea<T> beaVar, lea<? super T> leaVar, lea<Throwable> leaVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {beaVar, leaVar, leaVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = beaVar;
        this.b = leaVar;
        this.c = leaVar2;
    }

    public void call(cea<? super T> ceaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ceaVar) == null) {
            a aVar = new a(ceaVar, this.b, this.c);
            ceaVar.a(aVar);
            this.a.j(aVar);
        }
    }

    @Override // com.baidu.tieba.bea.c, com.baidu.tieba.lea
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((cea) ((cea) obj));
    }
}
