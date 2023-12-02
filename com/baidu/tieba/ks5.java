package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.rr5;
import com.baidu.tieba.sr5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class ks5<Q extends rr5, P extends sr5> extends js5 implements ns5<P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h(BdUniqueId bdUniqueId);

    public abstract void i(rq5 rq5Var);

    public ks5() {
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
