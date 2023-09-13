package com.baidu.tieba;

import com.baidu.tieba.sac;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class ubc<T, R> implements sac.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final sac.a<T> a;
    public final sac.b<? extends R, ? super T> b;

    public ubc(sac.a<T> aVar, sac.b<? extends R, ? super T> bVar) {
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

    public void call(yac<? super R> yacVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yacVar) == null) {
            try {
                yac yacVar2 = (yac) gfc.n(this.b).call(yacVar);
                yacVar2.d();
                this.a.call(yacVar2);
            } catch (Throwable th) {
                ebc.e(th);
                yacVar.onError(th);
            }
        }
    }

    @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yac) ((yac) obj));
    }
}
