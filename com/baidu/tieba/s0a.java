package com.baidu.tieba;

import com.baidu.tieba.sz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class s0a<T, R> implements sz9.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final sz9.a<T> a;
    public final sz9.b<? extends R, ? super T> b;

    public s0a(sz9.a<T> aVar, sz9.b<? extends R, ? super T> bVar) {
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

    public void call(yz9<? super R> yz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yz9Var) == null) {
            try {
                yz9 yz9Var2 = (yz9) z3a.n(this.b).call(yz9Var);
                yz9Var2.d();
                this.a.call(yz9Var2);
            } catch (Throwable th) {
                e0a.e(th);
                yz9Var.onError(th);
            }
        }
    }

    @Override // com.baidu.tieba.sz9.a, com.baidu.tieba.g0a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yz9) ((yz9) obj));
    }
}
