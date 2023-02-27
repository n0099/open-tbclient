package com.baidu.tieba;

import com.baidu.tieba.sma;
import com.baidu.tieba.wma;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class koa<T> implements sma.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final wma.c<T> a;

    public koa(wma.c<T> cVar) {
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

    public void call(yma<? super T> ymaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ymaVar) == null) {
            ioa ioaVar = new ioa(ymaVar);
            ymaVar.b(ioaVar);
            this.a.call(ioaVar);
        }
    }

    @Override // com.baidu.tieba.sma.a, com.baidu.tieba.gna
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yma) ((yma) obj));
    }
}
