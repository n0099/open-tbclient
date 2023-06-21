package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.kob;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.CompositeException;
/* loaded from: classes8.dex */
public final class xpb<T> implements kob.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final kob<T> a;
    public final uob<? super T> b;
    public final uob<Throwable> c;

    /* loaded from: classes8.dex */
    public static final class a<T> extends lob<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final lob<? super T> b;
        public final uob<? super T> c;
        public final uob<Throwable> d;

        public a(lob<? super T> lobVar, uob<? super T> uobVar, uob<Throwable> uobVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lobVar, uobVar, uobVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lobVar;
            this.c = uobVar;
            this.d = uobVar2;
        }

        @Override // com.baidu.tieba.lob
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    sob.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.baidu.tieba.lob
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    sob.h(th, this, t);
                }
            }
        }
    }

    public xpb(kob<T> kobVar, uob<? super T> uobVar, uob<Throwable> uobVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kobVar, uobVar, uobVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = kobVar;
        this.b = uobVar;
        this.c = uobVar2;
    }

    public void call(lob<? super T> lobVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lobVar) == null) {
            a aVar = new a(lobVar, this.b, this.c);
            lobVar.a(aVar);
            this.a.j(aVar);
        }
    }

    @Override // com.baidu.tieba.kob.c, com.baidu.tieba.uob
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((lob) ((lob) obj));
    }
}
