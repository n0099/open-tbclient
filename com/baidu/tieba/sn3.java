package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.rn3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class sn3 extends m73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements rn3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;

        public a(sn3 sn3Var, Context context, JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sn3Var, context, jSONObject, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = jSONObject;
            this.c = callbackHandler;
            this.d = str;
        }

        @Override // com.baidu.tieba.rn3.b
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    rn3.d(this.a);
                }
                try {
                    this.b.put("canceled", z);
                } catch (JSONException e) {
                    if (m73.b) {
                        e.printStackTrace();
                    }
                }
                this.c.handleSchemeDispatchCallback(this.d, UnitedSchemeUtility.wrapCallbackParams(this.b, 0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sn3(m63 m63Var) {
        super(m63Var, "/swanAPI/guidePushSetting");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m63Var};
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

    @Override // com.baidu.tieba.m73
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, p53Var)) == null) {
            if (p53Var == null) {
                p22.c("GuidePushSettingAction", "illegal swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                p22.c("GuidePushSettingAction", "illegal params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (TextUtils.isEmpty(optParamsAsJo.optString("source"))) {
                p22.c("GuidePushSettingAction", "openPushGuide source empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (!(context instanceof Activity)) {
                p22.c("GuidePushSettingAction", "illegal context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal context");
                return false;
            } else {
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                boolean b = rn3.b(context);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("authorized", b);
                } catch (JSONException e) {
                    if (m73.b) {
                        e.printStackTrace();
                    }
                }
                if (b) {
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                } else {
                    rn3.e(context, k(context, jSONObject, optString, callbackHandler));
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("authorized", b);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0));
                    return true;
                } catch (JSONException e2) {
                    if (m73.b) {
                        e2.printStackTrace();
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final rn3.b k(Context context, JSONObject jSONObject, String str, CallbackHandler callbackHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, str, callbackHandler)) == null) {
            return new a(this, context, jSONObject, callbackHandler, str);
        }
        return (rn3.b) invokeLLLL.objValue;
    }
}
