package com.baidu.tieba;

import com.baidu.tieba.k8a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class k9a<T, R> implements k8a.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final k8a.a<T> a;
    public final k8a.b<? extends R, ? super T> b;

    public k9a(k8a.a<T> aVar, k8a.b<? extends R, ? super T> bVar) {
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

    public void call(q8a<? super R> q8aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, q8aVar) == null) {
            try {
                q8a q8aVar2 = (q8a) rca.n(this.b).call(q8aVar);
                q8aVar2.d();
                this.a.call(q8aVar2);
            } catch (Throwable th) {
                w8a.e(th);
                q8aVar.onError(th);
            }
        }
    }

    @Override // com.baidu.tieba.k8a.a, com.baidu.tieba.y8a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((q8a) ((q8a) obj));
    }
}
