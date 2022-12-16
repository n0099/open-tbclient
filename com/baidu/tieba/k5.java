package com.baidu.tieba;

import com.badlogic.gdx.utils.JsonValue;
import com.baidu.tieba.p7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class k5 extends f5 implements p7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k5() {
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

    @Override // com.baidu.tieba.f5, com.baidu.tieba.p7.c
    public void a(p7 p7Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, p7Var, jsonValue) == null) {
            ((Integer) p7Var.l("minParticleCount", Integer.TYPE, jsonValue)).intValue();
            ((Integer) p7Var.l("maxParticleCount", Integer.TYPE, jsonValue)).intValue();
        }
    }
}
