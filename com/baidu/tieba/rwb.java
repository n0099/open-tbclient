package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public final class rwb<TResult> implements kxb<TResult> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nxb<TResult> a;
    public Executor b;
    public final Object c;

    public rwb(Executor executor, nxb<TResult> nxbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executor, nxbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new Object();
        this.a = nxbVar;
        this.b = executor;
    }

    @Override // com.baidu.tieba.kxb
    public final void a(wwb<TResult> wwbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, wwbVar) == null) && wwbVar.f()) {
            wwbVar.e();
            this.b.execute(new pwb(this, wwbVar));
        }
    }
}
