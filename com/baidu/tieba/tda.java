package com.baidu.tieba;

import com.baidu.tieba.tca;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class tda<T, R> implements tca.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final tca.a<T> a;
    public final tca.b<? extends R, ? super T> b;

    public tda(tca.a<T> aVar, tca.b<? extends R, ? super T> bVar) {
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

    public void call(zca<? super R> zcaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zcaVar) == null) {
            try {
                zca zcaVar2 = (zca) aha.n(this.b).call(zcaVar);
                zcaVar2.d();
                this.a.call(zcaVar2);
            } catch (Throwable th) {
                fda.e(th);
                zcaVar.onError(th);
            }
        }
    }

    @Override // com.baidu.tieba.tca.a, com.baidu.tieba.hda
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((zca) ((zca) obj));
    }
}
