package com.baidu.tieba;

import com.baidu.tieba.rz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class r0a<T, R> implements rz9.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final rz9.a<T> a;
    public final rz9.b<? extends R, ? super T> b;

    public r0a(rz9.a<T> aVar, rz9.b<? extends R, ? super T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
        this.b = bVar;
    }

    public void call(xz9<? super R> xz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xz9Var) == null) {
            try {
                xz9 xz9Var2 = (xz9) y3a.n(this.b).call(xz9Var);
                xz9Var2.d();
                this.a.call(xz9Var2);
            } catch (Throwable th) {
                d0a.e(th);
                xz9Var.onError(th);
            }
        }
    }

    @Override // com.baidu.tieba.rz9.a, com.baidu.tieba.f0a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((xz9) ((xz9) obj));
    }
}
