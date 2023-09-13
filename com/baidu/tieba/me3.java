package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
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
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class me3 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public me3(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/prefetchAppData");
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

    public final PrefetchEvent j(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            PrefetchEvent.b bVar = new PrefetchEvent.b();
            bVar.e(jSONObject.optString("state"));
            bVar.d(jSONObject.optString("schema"));
            bVar.c(jSONObject.optString("scene"));
            bVar.a(jSONObject.optString("appKey"));
            return bVar.b();
        }
        return (PrefetchEvent) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (ed3.b) {
                Log.d("PrefetchAppData", "handle entity: " + unitedSchemeEntity.getUri().toString());
            }
            String param = unitedSchemeEntity.getParam("params");
            JSONObject d = ho3.d(param);
            PrefetchEvent j = j(d);
            if (j != null && j.isValid()) {
                if (!x92.c(d.optString("netconf", "1"))) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Network limitation");
                    return false;
                }
                gf2.g().f(j);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "invalid params: " + param);
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
