package com.baidu.tieba;

import com.baidu.tieba.jjc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class nkc<T, R> implements jjc.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final jjc.a<T> a;
    public final jjc.b<? extends R, ? super T> b;

    public nkc(jjc.a<T> aVar, jjc.b<? extends R, ? super T> bVar) {
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
    @Override // com.baidu.tieba.xjc
    /* renamed from: a */
    public void call(pjc<? super R> pjcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pjcVar) == null) {
            try {
                pjc<? super T> call = znc.n(this.b).call(pjcVar);
                call.d();
                this.a.call(call);
            } catch (Throwable th) {
                vjc.e(th);
                pjcVar.onError(th);
            }
        }
    }
}
