package com.baidu.tieba;

import com.baidu.tieba.ora;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class osa<T, R> implements ora.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ora.a<T> a;
    public final ora.b<? extends R, ? super T> b;

    public osa(ora.a<T> aVar, ora.b<? extends R, ? super T> bVar) {
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

    public void call(ura<? super R> uraVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, uraVar) == null) {
            try {
                ura uraVar2 = (ura) vva.n(this.b).call(uraVar);
                uraVar2.d();
                this.a.call(uraVar2);
            } catch (Throwable th) {
                asa.e(th);
                uraVar.onError(th);
            }
        }
    }

    @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ura) ((ura) obj));
    }
}
