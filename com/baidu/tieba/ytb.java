package com.baidu.tieba;

import com.baidu.tieba.xsb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class ytb<T, R> implements xsb.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final xsb.a<T> a;
    public final xsb.b<? extends R, ? super T> b;

    public ytb(xsb.a<T> aVar, xsb.b<? extends R, ? super T> bVar) {
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

    public void call(dtb<? super R> dtbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dtbVar) == null) {
            try {
                dtb dtbVar2 = (dtb) kxb.n(this.b).call(dtbVar);
                dtbVar2.d();
                this.a.call(dtbVar2);
            } catch (Throwable th) {
                jtb.e(th);
                dtbVar.onError(th);
            }
        }
    }

    @Override // com.baidu.tieba.xsb.a, com.baidu.tieba.ltb
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((dtb) ((dtb) obj));
    }
}
