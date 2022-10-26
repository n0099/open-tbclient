package com.baidu.tieba;

import com.baidu.tieba.ay9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class zz9 implements ky9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ky9 a;
    public final ay9.a b;
    public final long c;

    public zz9(ky9 ky9Var, ay9.a aVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ky9Var, aVar, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ky9Var;
        this.b = aVar;
        this.c = j;
    }

    @Override // com.baidu.tieba.ky9
    public void call() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.isUnsubscribed()) {
            return;
        }
        long a = this.c - this.b.a();
        if (a > 0) {
            try {
                Thread.sleep(a);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                jy9.c(e);
                throw null;
            }
        }
        if (this.b.isUnsubscribed()) {
            return;
        }
        this.a.call();
    }
}
