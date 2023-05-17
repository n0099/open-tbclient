package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.h7b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.internal.util.UtilityFunctions;
/* loaded from: classes6.dex */
public final class n8b<T, U> implements h7b.b<T, T>, a8b<U, U, Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final z7b<? super T, ? extends U> a;
    public final a8b<? super U, ? super U, Boolean> b;

    /* loaded from: classes6.dex */
    public class a extends n7b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public U e;
        public boolean f;
        public final /* synthetic */ n7b g;
        public final /* synthetic */ n8b h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n8b n8bVar, n7b n7bVar, n7b n7bVar2) {
            super(n7bVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n8bVar, n7bVar, n7bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((n7b) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = n8bVar;
            this.g = n7bVar2;
        }

        @Override // com.baidu.tieba.i7b
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.onCompleted();
            }
        }

        @Override // com.baidu.tieba.i7b
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.g.onError(th);
            }
        }

        @Override // com.baidu.tieba.i7b
        public void onNext(T t) {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                try {
                    U call = this.h.a.call(t);
                    U u = this.e;
                    this.e = call;
                    if (this.f) {
                        try {
                            if (!this.h.b.call(u, call).booleanValue()) {
                                this.g.onNext(t);
                                return;
                            } else {
                                e(1L);
                                return;
                            }
                        } catch (Throwable th) {
                            t7b.g(th, this.g, obj);
                            return;
                        }
                    }
                    this.f = true;
                    this.g.onNext(t);
                } catch (Throwable th2) {
                    t7b.g(th2, this.g, t);
                }
            }
        }
    }

    public n8b(a8b<? super U, ? super U, Boolean> a8bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a8bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = UtilityFunctions.b();
        this.b = a8bVar;
    }

    public n7b<? super T> call(n7b<? super T> n7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, n7bVar)) == null) {
            return new a(this, n7bVar, n7bVar);
        }
        return (n7b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.a8b
    public Boolean call(U u, U u2) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u, u2)) == null) {
            if (u != u2 && (u == null || !u.equals(u2))) {
                z = false;
            } else {
                z = true;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.h7b.b, com.baidu.tieba.z7b
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((n7b) ((n7b) obj));
    }
}
