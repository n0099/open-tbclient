package com.baidu.tieba;

import com.baidu.tieba.x0c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class y1c<T, R> implements x0c.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final x0c.a<T> a;
    public final x0c.b<? extends R, ? super T> b;

    public y1c(x0c.a<T> aVar, x0c.b<? extends R, ? super T> bVar) {
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

    public void call(d1c<? super R> d1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d1cVar) == null) {
            try {
                d1c d1cVar2 = (d1c) k5c.n(this.b).call(d1cVar);
                d1cVar2.d();
                this.a.call(d1cVar2);
            } catch (Throwable th) {
                j1c.e(th);
                d1cVar.onError(th);
            }
        }
    }

    @Override // com.baidu.tieba.x0c.a, com.baidu.tieba.l1c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((d1c) ((d1c) obj));
    }
}
