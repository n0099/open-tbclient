package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.st5;
import com.baidu.tieba.tt5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class lu5<Q extends st5, P extends tt5> extends ku5 implements ou5<P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h(BdUniqueId bdUniqueId);

    public abstract void i(ss5 ss5Var);

    public lu5() {
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
