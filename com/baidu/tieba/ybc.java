package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.sac;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes8.dex */
public final class ybc<T> implements sac.b<Boolean, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final lbc<? super T, Boolean> a;
    public final boolean b;

    /* loaded from: classes8.dex */
    public class a extends yac<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean e;
        public boolean f;
        public final /* synthetic */ SingleDelayedProducer g;
        public final /* synthetic */ yac h;
        public final /* synthetic */ ybc i;

        public a(ybc ybcVar, SingleDelayedProducer singleDelayedProducer, yac yacVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ybcVar, singleDelayedProducer, yacVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = ybcVar;
            this.g = singleDelayedProducer;
            this.h = yacVar;
        }

        @Override // com.baidu.tieba.tac
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

        @Override // com.baidu.tieba.tac
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (!this.f) {
                    this.f = true;
                    this.h.onError(th);
                    return;
                }
                gfc.j(th);
            }
        }

        @Override // com.baidu.tieba.tac
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
                ebc.g(th, this, t);
            }
        }
    }

    public ybc(lbc<? super T, Boolean> lbcVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lbcVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = lbcVar;
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sac.b, com.baidu.tieba.lbc
    public yac<? super T> call(yac<? super Boolean> yacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yacVar)) == null) {
            SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(yacVar);
            a aVar = new a(this, singleDelayedProducer, yacVar);
            yacVar.b(aVar);
            yacVar.f(singleDelayedProducer);
            return aVar;
        }
        return (yac) invokeL.objValue;
    }
}
