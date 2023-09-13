package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class r32 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r32(ec3 ec3Var, String str) {
        super(ec3Var, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void j(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap<String, String> hashMap, String str) {
        HashMap<String, String> params;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, unitedSchemeEntity, callbackHandler, hashMap, str) == null) && (params = unitedSchemeEntity.getParams()) != null && !params.isEmpty() && hashMap != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    jSONObject.putOpt(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
                if (ed3.b) {
                    e.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(str)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            } else {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
            }
        }
    }

    public void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity, callbackHandler, z) == null) {
            if (z) {
                i = 0;
            } else {
                i = -1;
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, i);
        }
    }

    public String l(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity)) == null) {
            return unitedSchemeEntity.getParams().get("params");
        }
        return (String) invokeL.objValue;
    }
}
