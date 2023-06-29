package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ll4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class mf2 extends kc3 implements qf2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mf2(bc3 bc3Var) {
        super(bc3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bc3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((fc3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static final Map<String, String> I(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bundle)) == null) {
            HashMap hashMap = new HashMap();
            if (bundle != null && !bundle.isEmpty()) {
                for (String str : bundle.keySet()) {
                    hashMap.put(str, bundle.getString(str));
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static final Bundle J(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            Bundle bundle = new Bundle();
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    bundle.putString(entry.getKey(), entry.getValue());
                }
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ll4
    public void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, ll4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
            jv2.r0().b(str, map, map2, jSONObject, aVar);
        }
    }

    @Override // com.baidu.tieba.ll4
    public void z(String str, Map<String, String> map, Map<String, String> map2, ll4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, map2, aVar) == null) {
            jv2.r0().z(str, map, map2, aVar);
        }
    }
}
