package com.baidu.tieba;

import com.baidu.tieba.xx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class xy9 implements xx9.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final xx9.a a;
    public final xx9.b b;

    public xy9(xx9.a aVar, xx9.b bVar) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xx9.a, com.baidu.tieba.ly9
    public void call(dy9 dy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dy9Var) == null) {
            try {
                dy9 dy9Var2 = (dy9) e2a.n(this.b).call(dy9Var);
                dy9Var2.d();
                this.a.call(dy9Var2);
            } catch (Throwable th) {
                jy9.e(th);
                dy9Var.onError(th);
            }
        }
    }
}
