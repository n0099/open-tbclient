package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class zm4 extends pm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public zm4() {
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

    @Override // com.baidu.tieba.pm4, com.baidu.tieba.sm4
    public void b(JSONObject jSONObject, cj4 cj4Var, @Nullable cj4 cj4Var2, @Nullable cj4 cj4Var3) {
        wm4 d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, cj4Var, cj4Var2, cj4Var3) == null) && jSONObject != null && (d = xm4.c().d(jSONObject)) != null) {
            si4.b().D(d);
        }
    }
}
