package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class nd3 extends kd3 {
    public static /* synthetic */ Interceptable $ic;
    public static final String e;
    public static final String f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kd3
    public boolean j(gb3 gb3Var, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gb3Var, unitedSchemeEntity)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947998572, "Lcom/baidu/tieba/nd3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947998572, "Lcom/baidu/tieba/nd3;");
                return;
            }
        }
        e = SchemeConfig.getSchemeHead() + "://v19/swan/launch?params={\"appid\":\"";
        f = SchemeConfig.getSchemeHead() + "://swangame/%s";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nd3(dc3 dc3Var) {
        super(dc3Var, "/swanAPI/getFavor");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dc3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((dc3) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.kd3
    public void k(gb3 gb3Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gb3Var, unitedSchemeEntity, callbackHandler, str) == null) {
            JSONArray jSONArray = new JSONArray();
            List<SwanFavorItemData> i = SwanFavorDataManager.h().i();
            if (i.size() > 0) {
                for (SwanFavorItemData swanFavorItemData : i) {
                    jSONArray.put(p(swanFavorItemData));
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("favors", jSONArray);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
        }
    }

    public final JSONObject p(SwanFavorItemData swanFavorItemData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanFavorItemData)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", swanFavorItemData.getAppKey());
                jSONObject.put("type", swanFavorItemData.getAppType());
                jSONObject.put(GameAssistConstKt.KEY_ICONURL, swanFavorItemData.getIconUrl());
                jSONObject.put("title", swanFavorItemData.getAppName());
                jSONObject.put("frameType", swanFavorItemData.getAppFrameType());
                jSONObject.put("payProtected", swanFavorItemData.getPayProtected());
                if (swanFavorItemData.getAppFrameType() == 1) {
                    str = String.format(f, swanFavorItemData.getAppKey());
                } else {
                    str = e + swanFavorItemData.getAppKey() + "\"}";
                }
                jSONObject.put("scheme", str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
