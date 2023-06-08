package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.pu5;
import com.baidu.tieba.qu5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class iv5<Q extends pu5, P extends qu5> extends hv5 implements lv5<P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i(BdUniqueId bdUniqueId);

    public abstract void j(pt5 pt5Var);

    public iv5() {
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
