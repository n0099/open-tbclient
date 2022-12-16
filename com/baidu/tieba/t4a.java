package com.baidu.tieba;

import com.baidu.tieba.b3a;
import com.baidu.tieba.f3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class t4a<T> implements b3a.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f3a.c<T> a;

    public t4a(f3a.c<T> cVar) {
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

    public void call(h3a<? super T> h3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, h3aVar) == null) {
            r4a r4aVar = new r4a(h3aVar);
            h3aVar.b(r4aVar);
            this.a.call(r4aVar);
        }
    }

    @Override // com.baidu.tieba.b3a.a, com.baidu.tieba.p3a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((h3a) ((h3a) obj));
    }
}
