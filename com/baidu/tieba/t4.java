package com.baidu.tieba;

import com.badlogic.gdx.utils.JsonValue;
import com.baidu.tieba.y6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class t4 extends o4 implements y6.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t4() {
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

    @Override // com.baidu.tieba.o4, com.baidu.tieba.y6.c
    public void a(y6 y6Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, y6Var, jsonValue) == null) {
            ((Integer) y6Var.l("minParticleCount", Integer.TYPE, jsonValue)).intValue();
            ((Integer) y6Var.l("maxParticleCount", Integer.TYPE, jsonValue)).intValue();
        }
    }
}
