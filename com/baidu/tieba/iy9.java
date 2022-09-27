package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes4.dex */
public final class iy9<T> implements fx9.b<Boolean, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final xx9<? super T, Boolean> a;
    public final boolean b;

    /* loaded from: classes4.dex */
    public class a extends lx9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean e;
        public boolean f;
        public final /* synthetic */ SingleDelayedProducer g;
        public final /* synthetic */ lx9 h;
        public final /* synthetic */ iy9 i;

        public a(iy9 iy9Var, SingleDelayedProducer singleDelayedProducer, lx9 lx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iy9Var, singleDelayedProducer, lx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = iy9Var;
            this.g = singleDelayedProducer;
            this.h = lx9Var;
        }

        @Override // com.baidu.tieba.gx9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f) {
                return;
            }
            this.f = true;
            if (this.e) {
                this.g.setValue(Boolean.FALSE);
            } else {
                this.g.setValue(Boolean.valueOf(this.i.b));
            }
        }

        @Override // com.baidu.tieba.gx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (!this.f) {
                    this.f = true;
                    this.h.onError(th);
                    return;
                }
                m1a.j(th);
            }
        }

        @Override // com.baidu.tieba.gx9
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.f) {
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
                rx9.g(th, this, t);
            }
        }
    }

    public iy9(xx9<? super T, Boolean> xx9Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xx9Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = xx9Var;
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fx9.b, com.baidu.tieba.xx9
    public lx9<? super T> call(lx9<? super Boolean> lx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lx9Var)) == null) {
            SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(lx9Var);
            a aVar = new a(this, singleDelayedProducer, lx9Var);
            lx9Var.b(aVar);
            lx9Var.f(singleDelayedProducer);
            return aVar;
        }
        return (lx9) invokeL.objValue;
    }
}
