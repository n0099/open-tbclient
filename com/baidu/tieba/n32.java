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
/* loaded from: classes7.dex */
public class n32 extends m73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l32 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n32(m63 m63Var) {
        super(m63Var, "/swanAPI/perfCat");
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
            if (m73.b) {
                Log.d("SwanAppPropertyLogAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.m73
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, p53 p53Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, p53Var)) == null) {
            if (m73.b) {
                Log.d("SwanAppPropertyLogAction", "handleSubAction subAction: " + str);
            }
            if (!m73.b) {
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
            if (c != 0) {
                if (c != 1) {
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
                }
                JSONObject jSONObject = new JSONObject();
                l32 l32Var = this.c;
                if (l32Var == null) {
                    p22.c("SwanAppPropertyLogAction", "Property log never start");
                } else {
                    String i = l32Var.i();
                    this.c = null;
                    cr2.V().D();
                    try {
                        jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, cr2.V().D());
                        jSONObject.put("path", i);
                    } catch (JSONException e) {
                        if (m73.b) {
                            e.printStackTrace();
                        }
                    }
                    if (m73.b) {
                        Log.d("SwanAppPropertyLogAction", "Video dispatch Params : " + jSONObject.toString());
                    }
                    p22.i("SwanAppPropertyLogAction", "Stop property log");
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            }
            if (this.c == null) {
                this.c = new l32();
            }
            this.c.h();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            p22.i("SwanAppPropertyLogAction", " Start property log：");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
