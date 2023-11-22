package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.fr5;
import com.baidu.tieba.gr5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public abstract class yr5<Q extends fr5, P extends gr5> extends xr5 implements bs5<P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h(BdUniqueId bdUniqueId);

    public abstract void i(fq5 fq5Var);

    public yr5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
