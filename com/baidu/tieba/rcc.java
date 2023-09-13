package com.baidu.tieba;

import com.baidu.tieba.sac;
import com.baidu.tieba.wac;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class rcc<T> implements sac.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final wac.c<T> a;

    public rcc(wac.c<T> cVar) {
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

    public void call(yac<? super T> yacVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yacVar) == null) {
            pcc pccVar = new pcc(yacVar);
            yacVar.b(pccVar);
            this.a.call(pccVar);
        }
    }

    @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yac) ((yac) obj));
    }
}
