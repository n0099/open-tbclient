package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.gb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes8.dex */
public class ve3 extends wd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ve3(wc3 wc3Var) {
        super(wc3Var, "/swanAPI/showLoading");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wc3Var};
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

    @Override // com.baidu.tieba.wd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, zb3Var)) == null) {
            if (wd3.b) {
                Log.d("ShowLoadingAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            if (zb3Var != null && zb3Var.n0()) {
                if (wd3.b) {
                    Log.d("ShowLoadingAction", "ShowLoadingAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                return false;
            } else if (!(context instanceof SwanAppActivity)) {
                z82.c("showLoading", "context not support");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    z82.c("showLoading", "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                z82.i("showLoading", "handleShowLoading : joParams = \n" + optParamsAsJo);
                String optString = optParamsAsJo.optString("title");
                if (TextUtils.isEmpty(optString)) {
                    z82.c("showLoading", "none title");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                boolean optBoolean = optParamsAsJo.optBoolean("mask", false);
                ib2 Y = ((SwanAppActivity) context).Y();
                if (Y == null) {
                    z82.c("showLoading", "none fragment");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none fragment");
                    return false;
                }
                fb2 m = Y.m();
                if (!(m instanceof gb3.a)) {
                    z82.c("showLoading", "fragment not support");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment not support");
                    return false;
                }
                gb3 floatLayer = ((gb3.a) m).getFloatLayer();
                if (floatLayer == null) {
                    z82.c("showLoading", "can't get floatLayer");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can't create floatLayer");
                    return false;
                }
                hb3.f(floatLayer, context, optString, optBoolean);
                z82.i("showLoading", "show loading success");
                unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
