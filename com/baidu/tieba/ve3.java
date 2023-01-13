package com.baidu.tieba;

import android.content.Context;
import android.provider.Settings;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ve3 extends g63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ve3(g53 g53Var) {
        super(g53Var, "/swanAPI/getAutoRotationSync");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g53Var};
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

    @Override // com.baidu.tieba.g63
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, j43 j43Var) {
        InterceptResult invokeLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, j43Var)) == null) {
            if (j43Var == null) {
                j12.c("getAutoRotationSync", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (g63.b) {
                    Log.e("SwanAppAction", "getAutoRotationSync --- illegal swanApp");
                }
                return false;
            } else if (context == null) {
                j12.c("getAutoRotationSync", "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
                if (g63.b) {
                    Log.e("SwanAppAction", "getAutoRotationSync --- illegal context");
                }
                return false;
            } else {
                try {
                    int i = Settings.System.getInt(context.getApplicationContext().getContentResolver(), "accelerometer_rotation");
                    if (g63.b) {
                        Log.d("SwanAppAction", "getAutoRotationSync --- isRotateOn: " + i);
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (i != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    try {
                        jSONObject.put("isRotateOn", z);
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                        return true;
                    } catch (JSONException unused) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "json exception");
                        if (g63.b) {
                            Log.e("SwanAppAction", "getAutoRotationSync --- json exception");
                        }
                        return false;
                    }
                } catch (Exception e) {
                    if (g63.b) {
                        e.printStackTrace();
                        Log.e("SwanAppAction", "getAutoRotationSync --- can't get setting");
                    }
                    return false;
                }
            }
        }
        return invokeLLLL.booleanValue;
    }
}
