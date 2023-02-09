package com.baidu.tieba;

import com.baidu.tieba.bea;
import com.baidu.tieba.xda;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class pfa<T> implements xda.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bea.c<T> a;

    public pfa(bea.c<T> cVar) {
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

    public void call(dea<? super T> deaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, deaVar) == null) {
            nfa nfaVar = new nfa(deaVar);
            deaVar.b(nfaVar);
            this.a.call(nfaVar);
        }
    }

    @Override // com.baidu.tieba.xda.a, com.baidu.tieba.lea
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((dea) ((dea) obj));
    }
}
