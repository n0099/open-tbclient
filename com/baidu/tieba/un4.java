package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class un4 extends lm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public un4() {
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

    @Override // com.baidu.tieba.lm4, com.baidu.tieba.om4
    public void b(JSONObject jSONObject, yi4 yi4Var, @Nullable yi4 yi4Var2, @Nullable yi4 yi4Var3) {
        JSONObject optJSONObject;
        rn4 a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, yi4Var, yi4Var2, yi4Var3) == null) && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("base_info")) != null && (a = rn4.a(optJSONObject)) != null) {
            sn4.e().i(a);
            sn4.e().j(a.k);
        }
    }
}
