package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qk4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class tl4 extends ql4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public tl4() {
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

    @Override // com.baidu.tieba.qk4
    public void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, qk4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
            sl4.b(str, map, map2, jSONObject, new rk4(aVar));
        }
    }

    @Override // com.baidu.tieba.qk4
    public void z(String str, Map<String, String> map, Map<String, String> map2, qk4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, map2, aVar) == null) {
            sl4.a(str, map, map2, new rk4(aVar));
        }
    }
}
