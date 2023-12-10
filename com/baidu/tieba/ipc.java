package com.baidu.tieba;

import com.baidu.tieba.eoc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class ipc<T, R> implements eoc.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final eoc.a<T> a;
    public final eoc.b<? extends R, ? super T> b;

    public ipc(eoc.a<T> aVar, eoc.b<? extends R, ? super T> bVar) {
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
    @Override // com.baidu.tieba.soc
    /* renamed from: a */
    public void call(koc<? super R> kocVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kocVar) == null) {
            try {
                koc<? super T> call = usc.n(this.b).call(kocVar);
                call.d();
                this.a.call(call);
            } catch (Throwable th) {
                qoc.e(th);
                kocVar.onError(th);
            }
        }
    }
}
