package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class pm4 implements sm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.sm4
    public void a(JSONArray jSONArray, cj4 cj4Var, @Nullable cj4 cj4Var2, @Nullable cj4 cj4Var3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, cj4Var, cj4Var2, cj4Var3) == null) {
        }
    }

    @Override // com.baidu.tieba.sm4
    public void b(JSONObject jSONObject, cj4 cj4Var, @Nullable cj4 cj4Var2, @Nullable cj4 cj4Var3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, cj4Var, cj4Var2, cj4Var3) == null) {
        }
    }

    public pm4() {
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
