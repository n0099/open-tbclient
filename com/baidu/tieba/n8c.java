package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n7c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public class n8c<T> implements n7c.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final o7c<? super T> a;
    public final n7c<T> b;

    /* loaded from: classes7.dex */
    public static final class a<T> extends t7c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final t7c<? super T> e;
        public final o7c<? super T> f;
        public boolean g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(t7c<? super T> t7cVar, o7c<? super T> o7cVar) {
            super(t7cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t7cVar, o7cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((t7c) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = t7cVar;
            this.f = o7cVar;
        }

        @Override // com.baidu.tieba.o7c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.g) {
                return;
            }
            try {
                this.f.onCompleted();
                this.g = true;
                this.e.onCompleted();
            } catch (Throwable th) {
                z7c.f(th, this);
            }
        }

        @Override // com.baidu.tieba.o7c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.g) {
                    bcc.j(th);
                    return;
                }
                this.g = true;
                try {
                    this.f.onError(th);
                    this.e.onError(th);
                } catch (Throwable th2) {
                    z7c.e(th2);
                    this.e.onError(new CompositeException(Arrays.asList(th, th2)));
                }
            }
        }

        @Override // com.baidu.tieba.o7c
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) != null) || this.g) {
                return;
            }
            try {
                this.f.onNext(t);
                this.e.onNext(t);
            } catch (Throwable th) {
                z7c.g(th, this, t);
            }
        }
    }

    public n8c(n7c<T> n7cVar, o7c<? super T> o7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n7cVar, o7cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = n7cVar;
        this.a = o7cVar;
    }

    public void call(t7c<? super T> t7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t7cVar) == null) {
            this.b.O(new a(t7cVar, this.a));
        }
    }

    @Override // com.baidu.tieba.n7c.a, com.baidu.tieba.b8c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((t7c) ((t7c) obj));
    }
}
