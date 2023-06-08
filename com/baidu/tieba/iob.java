package com.baidu.tieba;

import com.baidu.tieba.nmb;
import com.baidu.tieba.rmb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class iob<T> implements nmb.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final rmb.c<T> a;

    public iob(rmb.c<T> cVar) {
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

    public void call(tmb<? super T> tmbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tmbVar) == null) {
            gob gobVar = new gob(tmbVar);
            tmbVar.b(gobVar);
            this.a.call(gobVar);
        }
    }

    @Override // com.baidu.tieba.nmb.a, com.baidu.tieba.bnb
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((tmb) ((tmb) obj));
    }
}
