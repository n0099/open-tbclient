package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.live.interfaces.DI;
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
@Deprecated
/* loaded from: classes7.dex */
public class mc3 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mc3(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/getAppInfoSync");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
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

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (ed3.b) {
                Log.d("GetAppInfoSyncAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            if (hb3Var == null) {
                h82.c(DI.APP_INFO_NAME, "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            try {
                JSONObject D = g12.D(hb3Var, context);
                if (ed3.b && D != null) {
                    Log.d("GetAppInfoSyncAction", "data: " + D.toString());
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(D, 0);
                return true;
            } catch (JSONException e) {
                if (ed3.b) {
                    Log.d("GetAppInfoSyncAction", Log.getStackTraceString(e));
                }
                h82.c(DI.APP_INFO_NAME, Log.getStackTraceString(e));
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
