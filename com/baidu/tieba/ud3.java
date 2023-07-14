package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes8.dex */
public class ud3 extends sd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ud3(sc3 sc3Var) {
        super(sc3Var, "/swanAPI/ubcFlowJar");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sc3Var};
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

    @Override // com.baidu.tieba.sd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, vb3Var)) == null) {
            if (sd3.b) {
                Log.d("SwanAppAction", "start ubc flor jar");
            }
            if (vb3Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("flowId");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty flowId");
                return false;
            }
            char c = 65535;
            switch (optString.hashCode()) {
                case 53647:
                    if (optString.equals("670")) {
                        c = 0;
                        break;
                    }
                    break;
                case 53648:
                    if (optString.equals("671")) {
                        c = 2;
                        break;
                    }
                    break;
                case 55357:
                    if (optString.equals("805")) {
                        c = 1;
                        break;
                    }
                    break;
                case 56506:
                    if (optString.equals("967")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1508542:
                    if (optString.equals("1153")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1529139648:
                    if (optString.equals("renderMonitorLog")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            if (c != 4) {
                                if (c != 5) {
                                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "unknown flowId");
                                    return false;
                                }
                                g32.C(optParamsAsJo);
                            } else if (vb3Var.W().p0()) {
                                e92.g(optParamsAsJo.optJSONArray("data"));
                            } else {
                                l92.i(optParamsAsJo.optJSONArray("data"));
                            }
                        } else {
                            g32.D(optParamsAsJo);
                        }
                    } else {
                        g32.E(optParamsAsJo.optJSONArray("data"));
                    }
                } else {
                    g32.F(optParamsAsJo.optJSONArray("data"));
                }
            } else {
                g32.B(optParamsAsJo, vb3Var);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
