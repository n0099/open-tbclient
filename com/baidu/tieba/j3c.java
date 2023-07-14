package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u1c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class j3c<T> implements u1c.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* loaded from: classes6.dex */
    public class a extends a2c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int e;
        public final /* synthetic */ a2c f;
        public final /* synthetic */ j3c g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j3c j3cVar, a2c a2cVar, a2c a2cVar2) {
            super(a2cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j3cVar, a2cVar, a2cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a2c) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = j3cVar;
            this.f = a2cVar2;
        }

        @Override // com.baidu.tieba.a2c
        public void f(w1c w1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, w1cVar) == null) {
                this.f.f(w1cVar);
                w1cVar.request(this.g.a);
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.f.onError(th);
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                int i = this.e;
                if (i >= this.g.a) {
                    this.f.onNext(t);
                } else {
                    this.e = i + 1;
                }
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f.onCompleted();
            }
        }
    }

    public j3c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (i >= 0) {
            this.a = i;
            return;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + i);
    }

    public a2c<? super T> call(a2c<? super T> a2cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, a2cVar)) == null) {
            return new a(this, a2cVar, a2cVar);
        }
        return (a2c) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u1c.b, com.baidu.tieba.m2c
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((a2c) ((a2c) obj));
    }
}
