package com.baidu.tieba;

import com.baidu.tieba.p7c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class r8c<T, R> implements p7c.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final p7c.a<T> a;
    public final p7c.b<? extends R, ? super T> b;

    public r8c(p7c.a<T> aVar, p7c.b<? extends R, ? super T> bVar) {
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

    public void call(v7c<? super R> v7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v7cVar) == null) {
            try {
                v7c v7cVar2 = (v7c) dcc.n(this.b).call(v7cVar);
                v7cVar2.d();
                this.a.call(v7cVar2);
            } catch (Throwable th) {
                b8c.e(th);
                v7cVar.onError(th);
            }
        }
    }

    @Override // com.baidu.tieba.p7c.a, com.baidu.tieba.d8c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((v7c) ((v7c) obj));
    }
}
