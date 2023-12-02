package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.doc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class vpc<T> implements doc.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* loaded from: classes8.dex */
    public class a extends joc<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int e;
        public final /* synthetic */ joc f;
        public final /* synthetic */ vpc g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(vpc vpcVar, joc jocVar, joc jocVar2) {
            super(jocVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vpcVar, jocVar, jocVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((joc) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = vpcVar;
            this.f = jocVar2;
        }

        @Override // com.baidu.tieba.joc
        public void f(foc focVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, focVar) == null) {
                this.f.f(focVar);
                focVar.request(this.g.a);
            }
        }

        @Override // com.baidu.tieba.eoc
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.f.onError(th);
            }
        }

        @Override // com.baidu.tieba.eoc
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

        @Override // com.baidu.tieba.eoc
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f.onCompleted();
            }
        }
    }

    public vpc(int i) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.woc
    /* renamed from: a */
    public joc<? super T> call(joc<? super T> jocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jocVar)) == null) {
            return new a(this, jocVar, jocVar);
        }
        return (joc) invokeL.objValue;
    }
}
