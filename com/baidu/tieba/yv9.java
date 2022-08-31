package com.baidu.tieba;

import com.baidu.tieba.yu9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class yv9<T, R> implements yu9.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yu9.a<T> a;
    public final yu9.b<? extends R, ? super T> b;

    public yv9(yu9.a<T> aVar, yu9.b<? extends R, ? super T> bVar) {
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

    @Override // com.baidu.tieba.yu9.a, com.baidu.tieba.mv9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ev9) ((ev9) obj));
    }

    public void call(ev9<? super R> ev9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ev9Var) == null) {
            try {
                ev9 ev9Var2 = (ev9) fz9.n(this.b).call(ev9Var);
                ev9Var2.d();
                this.a.call(ev9Var2);
            } catch (Throwable th) {
                kv9.e(th);
                ev9Var.onError(th);
            }
        }
    }
}
