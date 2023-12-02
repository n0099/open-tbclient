package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.t52;
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
public class w93 extends h83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w93(h73 h73Var) {
        super(h73Var, "/swanAPI/navigateBack");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h73Var};
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

    @Override // com.baidu.tieba.h83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var) {
        InterceptResult invokeLLLL;
        int optInt;
        kw2 kw2Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, k63Var)) == null) {
            if (h83.b) {
                Log.d("NavigateBackAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            qz2.b(uuid);
            String str2 = unitedSchemeEntity.getParams().get("params");
            if (!TextUtils.isEmpty(str2)) {
                try {
                    optInt = new JSONObject(str2).optInt("delta", 1);
                } catch (JSONException e) {
                    if (h83.b) {
                        e.printStackTrace();
                    }
                    k32.c("navigateBack", "params parse fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
            } else {
                optInt = 1;
            }
            t52 W = xr2.V().W();
            if (W == null) {
                k32.c("navigateBack", "fragmentManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            int k = W.k();
            if (h83.b) {
                Log.d("NavigateBackAction", "back delta: " + optInt);
            }
            if (k == 1) {
                k32.c("NavigateBackAction", "navigateBack api can only work when slave's count greater than 1");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "navigateBack api can only work when slave's count greater than 1");
                return false;
            }
            if (optInt >= k) {
                optInt = k - 1;
            }
            if (h83.b) {
                Log.d("NavigateBackAction", "real back delta: " + optInt);
            }
            q52 j = W.j((k - optInt) - 1);
            kw2 kw2Var2 = null;
            if (j instanceof s52) {
                kw2Var = ((s52) j).t3();
                kw2Var.e = "1";
                kw2Var.f = uuid;
            } else {
                kw2Var = null;
            }
            yc3.g(kw2Var);
            qz2.c(1, uuid);
            ui3.a(W, context);
            t52.b i = W.i("navigateBack");
            i.n(t52.i, t52.h);
            i.h(optInt);
            i.a();
            s52 o = W.o();
            if (o != null) {
                kw2Var2 = o.t3();
            }
            pz2.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
            qz2.a(uuid, kw2Var2);
            if (!(W.m() instanceof s52)) {
                k32.c("navigateBack", "top fragment error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                yc3.i(kw2Var);
                return false;
            }
            s52 s52Var = (s52) W.m();
            if (s52Var != null) {
                str = s52Var.A3();
            } else {
                str = "";
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(t93.c(str), 0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
