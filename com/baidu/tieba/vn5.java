package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.cn5;
import com.baidu.tieba.dn5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class vn5<Q extends cn5, P extends dn5> extends un5 implements yn5<P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i(BdUniqueId bdUniqueId);

    public abstract void j(cm5 cm5Var);

    public vn5() {
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
