package com.baidu.tieba;

import com.baidu.tieba.n1b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class n2b<T, R> implements n1b.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final n1b.a<T> a;
    public final n1b.b<? extends R, ? super T> b;

    public n2b(n1b.a<T> aVar, n1b.b<? extends R, ? super T> bVar) {
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

    public void call(t1b<? super R> t1bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t1bVar) == null) {
            try {
                t1b t1bVar2 = (t1b) u5b.n(this.b).call(t1bVar);
                t1bVar2.d();
                this.a.call(t1bVar2);
            } catch (Throwable th) {
                z1b.e(th);
                t1bVar.onError(th);
            }
        }
    }

    @Override // com.baidu.tieba.n1b.a, com.baidu.tieba.b2b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((t1b) ((t1b) obj));
    }
}
