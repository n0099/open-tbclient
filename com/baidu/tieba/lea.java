package com.baidu.tieba;

import com.baidu.tieba.tca;
import com.baidu.tieba.xca;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class lea<T> implements tca.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final xca.c<T> a;

    public lea(xca.c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cVar;
    }

    public void call(zca<? super T> zcaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zcaVar) == null) {
            jea jeaVar = new jea(zcaVar);
            zcaVar.b(jeaVar);
            this.a.call(jeaVar);
        }
    }

    @Override // com.baidu.tieba.tca.a, com.baidu.tieba.hda
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((zca) ((zca) obj));
    }
}
