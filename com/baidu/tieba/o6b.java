package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.j5b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.internal.util.UtilityFunctions;
/* loaded from: classes5.dex */
public final class o6b<T, U> implements j5b.b<T, T>, c6b<U, U, Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b6b<? super T, ? extends U> a;
    public final c6b<? super U, ? super U, Boolean> b;

    /* loaded from: classes5.dex */
    public class a extends p5b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public U e;
        public boolean f;
        public final /* synthetic */ p5b g;
        public final /* synthetic */ o6b h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o6b o6bVar, p5b p5bVar, p5b p5bVar2) {
            super(p5bVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o6bVar, p5bVar, p5bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((p5b) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = o6bVar;
            this.g = p5bVar2;
        }

        @Override // com.baidu.tieba.k5b
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.onCompleted();
            }
        }

        @Override // com.baidu.tieba.k5b
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.g.onError(th);
            }
        }

        @Override // com.baidu.tieba.k5b
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
                            v5b.g(th, this.g, obj);
                            return;
                        }
                    }
                    this.f = true;
                    this.g.onNext(t);
                } catch (Throwable th2) {
                    v5b.g(th2, this.g, t);
                }
            }
        }
    }

    public o6b(c6b<? super U, ? super U, Boolean> c6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c6bVar};
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
        this.b = c6bVar;
    }

    public p5b<? super T> call(p5b<? super T> p5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, p5bVar)) == null) {
            return new a(this, p5bVar, p5bVar);
        }
        return (p5b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.c6b
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

    @Override // com.baidu.tieba.j5b.b, com.baidu.tieba.b6b
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((p5b) ((p5b) obj));
    }
}
