package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qk4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class te2 extends re2 implements qk4 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948178248, "Lcom/baidu/tieba/te2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948178248, "Lcom/baidu/tieba/te2;");
                return;
            }
        }
        ou2.g0().getSwitch("swan_pms_http_request_retry_use_default_net_lib", false);
        b = false;
    }

    @NonNull
    public static rl4 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b) {
                return ou2.r0();
            }
            return new tl4();
        }
        return (rl4) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public te2(gb3 gb3Var) {
        super(gb3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gb3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((gb3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.re2, com.baidu.tieba.qk4
    public void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, qk4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
            K().b(str, map, map2, jSONObject, aVar);
        }
    }

    @Override // com.baidu.tieba.re2, com.baidu.tieba.qk4
    public void z(String str, Map<String, String> map, Map<String, String> map2, qk4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, map2, aVar) == null) {
            String b2 = h53.b();
            if (b2 != null) {
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put("launchid", b2);
            }
            K().z(str, map, map2, aVar);
        }
    }
}
