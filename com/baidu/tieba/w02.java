package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class w02 extends v43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u02 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w02(v33 v33Var) {
        super(v33Var, "/swanAPI/perfCat");
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
                Log.d("SwanAppPropertyLogAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.v43
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, y23 y23Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, y23Var)) == null) {
            if (v43.b) {
                Log.d("SwanAppPropertyLogAction", "handleSubAction subAction: " + str);
            }
            if (!v43.b) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(403));
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -322942229) {
                if (hashCode != 227833272) {
                    if (hashCode == 977180790 && str.equals("/swanAPI/perfCat/on")) {
                        c = 0;
                    }
                } else if (str.equals("/swanAPI/perfCat/off")) {
                    c = 1;
                }
            } else if (str.equals("/swanAPI/perfCat/duration")) {
                c = 2;
            }
            if (c == 0) {
                if (this.c == null) {
                    this.c = new u02();
                }
                this.c.h();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                yz1.i("SwanAppPropertyLogAction", " Start property log：");
                return true;
            } else if (c != 1) {
                if (c != 2) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
                    return false;
                }
                if (optParamsAsJo == null) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(202));
                } else {
                    if (this.c != null) {
                        this.c.g(optParamsAsJo.optInt("duration"));
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                }
                return true;
            } else {
                JSONObject jSONObject = new JSONObject();
                u02 u02Var = this.c;
                if (u02Var == null) {
                    yz1.c("SwanAppPropertyLogAction", "Property log never start");
                } else {
                    String i = u02Var.i();
                    this.c = null;
                    lo2.U().C();
                    try {
                        jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, lo2.U().C());
                        jSONObject.put("path", i);
                    } catch (JSONException e) {
                        if (v43.b) {
                            e.printStackTrace();
                        }
                    }
                    if (v43.b) {
                        Log.d("SwanAppPropertyLogAction", "Video dispatch Params : " + jSONObject.toString());
                    }
                    yz1.i("SwanAppPropertyLogAction", "Stop property log");
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            }
        }
        return invokeLLLLL.booleanValue;
    }
}
