package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class mo4 extends dn4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public mo4() {
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

    @Override // com.baidu.tieba.dn4, com.baidu.tieba.gn4
    public void b(JSONObject jSONObject, qj4 qj4Var, @Nullable qj4 qj4Var2, @Nullable qj4 qj4Var3) {
        JSONObject optJSONObject;
        jo4 a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, qj4Var, qj4Var2, qj4Var3) == null) && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("base_info")) != null && (a = jo4.a(optJSONObject)) != null) {
            ko4.e().i(a);
            ko4.e().j(a.k);
        }
    }
}
