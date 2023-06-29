package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.tieba.ll4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes7.dex */
public class ox3 implements mm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ox3() {
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

    @Override // com.baidu.tieba.ll4
    public void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, ll4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
            if (PMSConstants.a(nj4.b())) {
                fl4.b(str, map, map2, jSONObject, new fv3(aVar));
            } else {
                fl4.b(str, map, map2, jSONObject, new ml4(aVar));
            }
        }
    }

    @Override // com.baidu.tieba.mm4
    public yl4 c(String str, int i) throws Exception {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            return wl4.a(str, i);
        }
        return (yl4) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.ll4
    public void z(String str, Map<String, String> map, Map<String, String> map2, ll4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, map, map2, aVar) == null) {
            if (PMSConstants.a(nj4.b())) {
                fl4.a(str, map, map2, new fv3(aVar));
            } else {
                fl4.a(str, map, map2, new ml4(aVar));
            }
        }
    }
}
