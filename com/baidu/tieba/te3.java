package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.qa2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes8.dex */
public class te3 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public te3(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/navigateBack");
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
        int optInt;
        h13 h13Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (ed3.b) {
                Log.d("NavigateBackAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            n43.b(uuid);
            String str2 = unitedSchemeEntity.getParams().get("params");
            if (!TextUtils.isEmpty(str2)) {
                try {
                    optInt = new JSONObject(str2).optInt("delta", 1);
                } catch (JSONException e) {
                    if (ed3.b) {
                        e.printStackTrace();
                    }
                    h82.c("navigateBack", "params parse fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
            } else {
                optInt = 1;
            }
            qa2 U = uw2.T().U();
            if (U == null) {
                h82.c("navigateBack", "fragmentManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            int k = U.k();
            if (ed3.b) {
                Log.d("NavigateBackAction", "back delta: " + optInt);
            }
            if (k == 1) {
                h82.c("NavigateBackAction", "navigateBack api can only work when slave's count greater than 1");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "navigateBack api can only work when slave's count greater than 1");
                return false;
            }
            if (optInt >= k) {
                optInt = k - 1;
            }
            if (ed3.b) {
                Log.d("NavigateBackAction", "real back delta: " + optInt);
            }
            na2 j = U.j((k - optInt) - 1);
            h13 h13Var2 = null;
            if (j instanceof pa2) {
                h13Var = ((pa2) j).o3();
                h13Var.e = "1";
                h13Var.f = uuid;
            } else {
                h13Var = null;
            }
            vh3.g(h13Var);
            n43.c(1, uuid);
            rn3.a(U, context);
            qa2.b i = U.i("navigateBack");
            i.n(qa2.i, qa2.h);
            i.h(optInt);
            i.a();
            pa2 o = U.o();
            if (o != null) {
                h13Var2 = o.o3();
            }
            m43.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
            n43.a(uuid, h13Var2);
            if (!(U.m() instanceof pa2)) {
                h82.c("navigateBack", "top fragment error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                vh3.i(h13Var);
                return false;
            }
            pa2 pa2Var = (pa2) U.m();
            if (pa2Var != null) {
                str = pa2Var.v3();
            } else {
                str = "";
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(qe3.c(str), 0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
