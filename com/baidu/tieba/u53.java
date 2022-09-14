package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.f23;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes6.dex */
public class u53 extends v43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u53(v33 v33Var) {
        super(v33Var, "/swanAPI/showLoading");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v33Var};
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

    @Override // com.baidu.tieba.v43
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, y23Var)) == null) {
            if (v43.b) {
                Log.d("ShowLoadingAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            if (y23Var != null && y23Var.n0()) {
                if (v43.b) {
                    Log.d("ShowLoadingAction", "ShowLoadingAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                return false;
            } else if (!(context instanceof SwanAppActivity)) {
                yz1.c("showLoading", "context not support");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    yz1.c("showLoading", "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                yz1.i("showLoading", "handleShowLoading : joParams = \n" + optParamsAsJo);
                String optString = optParamsAsJo.optString("title");
                if (TextUtils.isEmpty(optString)) {
                    yz1.c("showLoading", "none title");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                boolean optBoolean = optParamsAsJo.optBoolean("mask", false);
                h22 X = ((SwanAppActivity) context).X();
                if (X == null) {
                    yz1.c("showLoading", "none fragment");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none fragment");
                    return false;
                }
                e22 m = X.m();
                if (!(m instanceof f23.a)) {
                    yz1.c("showLoading", "fragment not support");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment not support");
                    return false;
                }
                f23 d = ((f23.a) m).d();
                if (d == null) {
                    yz1.c("showLoading", "can't get floatLayer");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can't create floatLayer");
                    return false;
                }
                g23.f(d, context, optString, optBoolean);
                yz1.i("showLoading", "show loading success");
                unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
