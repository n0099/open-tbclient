package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class oc3 extends u93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oc3(u83 u83Var) {
        super(u83Var, "/swanAPI/login");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u83Var};
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

    @Override // com.baidu.tieba.u93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, x73 x73Var) {
        InterceptResult invokeLLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, x73Var)) == null) {
            if (x73Var != null && x73Var.n0()) {
                if (u93.b) {
                    Log.d("LoginAction", "LoginAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                return false;
            } else if (x73Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                fr2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception").toString());
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
                    fr2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "params is null").toString());
                    fw1.J(x73Var, 1, 201, "params is null");
                    return false;
                }
                String optString = optParamsAsJo.optString("invokeFrom");
                if (optString.equals(NativeConstants.COMPONENT)) {
                    str = "loginButton";
                } else {
                    str = "loginApi";
                }
                String str2 = str;
                qe3.T(str2, "create");
                String optString2 = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    fr2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                    fw1.J(x73Var, 1, 201, "empty cb");
                    return false;
                } else if (!optParamsAsJo.optBoolean(TTDownloadField.TT_FORCE, true) && !x73Var.N().e(context)) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                    fr2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                    fw1.J(x73Var, 43, 10004, "user not logged in");
                    return true;
                } else {
                    if (!x73Var.N().e(context)) {
                        qe3.S("show", 1, optString);
                    }
                    if (!w73.K().q().N().e(context)) {
                        qe3.T(str2, "passLogin");
                    }
                    fw1.D(x73Var, (Activity) context, optParamsAsJo, callbackHandler, optString2, true, str2);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
            }
        }
        return invokeLLLL.booleanValue;
    }
}
