package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class vg4 extends mf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vg4() {
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

    @Override // com.baidu.tieba.mf4, com.baidu.tieba.pf4
    public void b(JSONObject jSONObject, zb4 zb4Var, @Nullable zb4 zb4Var2, @Nullable zb4 zb4Var3) {
        JSONObject optJSONObject;
        sg4 a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, zb4Var, zb4Var2, zb4Var3) == null) && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("base_info")) != null && (a = sg4.a(optJSONObject)) != null) {
            tg4.e().i(a);
            tg4.e().j(a.k);
        }
    }
}
