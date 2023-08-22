package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n7c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes8.dex */
public final class t8c<T> implements n7c.b<Boolean, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final g8c<? super T, Boolean> a;
    public final boolean b;

    /* loaded from: classes8.dex */
    public class a extends t7c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean e;
        public boolean f;
        public final /* synthetic */ SingleDelayedProducer g;
        public final /* synthetic */ t7c h;
        public final /* synthetic */ t8c i;

        public a(t8c t8cVar, SingleDelayedProducer singleDelayedProducer, t7c t7cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t8cVar, singleDelayedProducer, t7cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = t8cVar;
            this.g = singleDelayedProducer;
            this.h = t7cVar;
        }

        @Override // com.baidu.tieba.o7c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.f) {
                this.f = true;
                if (this.e) {
                    this.g.setValue(Boolean.FALSE);
                } else {
                    this.g.setValue(Boolean.valueOf(this.i.b));
                }
            }
        }

        @Override // com.baidu.tieba.o7c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (!this.f) {
                    this.f = true;
                    this.h.onError(th);
                    return;
                }
                bcc.j(th);
            }
        }

        @Override // com.baidu.tieba.o7c
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) != null) || this.f) {
                return;
            }
            this.e = true;
            try {
                if (this.i.a.call(t).booleanValue()) {
                    this.f = true;
                    this.g.setValue(Boolean.valueOf(true ^ this.i.b));
                    unsubscribe();
                }
            } catch (Throwable th) {
                z7c.g(th, this, t);
            }
        }
    }

    public t8c(g8c<? super T, Boolean> g8cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g8cVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = g8cVar;
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.n7c.b, com.baidu.tieba.g8c
    public t7c<? super T> call(t7c<? super Boolean> t7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t7cVar)) == null) {
            SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(t7cVar);
            a aVar = new a(this, singleDelayedProducer, t7cVar);
            t7cVar.b(aVar);
            t7cVar.f(singleDelayedProducer);
            return aVar;
        }
        return (t7c) invokeL.objValue;
    }
}
