package com.baidu.tieba;

import com.baidu.tieba.qw9;
import com.baidu.tieba.uw9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class iy9<T> implements qw9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final uw9.c<T> a;

    public iy9(uw9.c<T> cVar) {
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

    @Override // com.baidu.tieba.qw9.a, com.baidu.tieba.ex9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ww9) ((ww9) obj));
    }

    public void call(ww9<? super T> ww9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ww9Var) == null) {
            gy9 gy9Var = new gy9(ww9Var);
            ww9Var.b(gy9Var);
            this.a.call(gy9Var);
        }
    }
}
