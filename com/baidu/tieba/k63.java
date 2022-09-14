package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.h22;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes4.dex */
public class k63 extends v43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k63(v33 v33Var) {
        super(v33Var, "/swanAPI/navigateBack");
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
        int optInt;
        ys2 ys2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, y23Var)) == null) {
            if (v43.b) {
                Log.d("NavigateBackAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            ew2.b(uuid);
            String str = unitedSchemeEntity.getParams().get("params");
            if (TextUtils.isEmpty(str)) {
                optInt = 1;
            } else {
                try {
                    optInt = new JSONObject(str).optInt("delta", 1);
                } catch (JSONException e) {
                    if (v43.b) {
                        e.printStackTrace();
                    }
                    yz1.c("navigateBack", "params parse fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
            }
            h22 V = lo2.U().V();
            if (V == null) {
                yz1.c("navigateBack", "fragmentManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            int k = V.k();
            if (v43.b) {
                Log.d("NavigateBackAction", "back delta: " + optInt);
            }
            if (k == 1) {
                yz1.c("NavigateBackAction", "navigateBack api can only work when slave's count greater than 1");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "navigateBack api can only work when slave's count greater than 1");
                return false;
            }
            if (optInt >= k) {
                optInt = k - 1;
            }
            if (v43.b) {
                Log.d("NavigateBackAction", "real back delta: " + optInt);
            }
            e22 j = V.j((k - optInt) - 1);
            if (j instanceof g22) {
                ys2Var = ((g22) j).m3();
                ys2Var.e = "1";
                ys2Var.f = uuid;
            } else {
                ys2Var = null;
            }
            m93.g(ys2Var);
            ew2.c(1, uuid);
            if3.a(V, context);
            h22.b i = V.i("navigateBack");
            i.n(h22.i, h22.h);
            i.h(optInt);
            i.a();
            g22 o = V.o();
            ys2 m3 = o != null ? o.m3() : null;
            dw2.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
            ew2.a(uuid, m3);
            if (!(V.m() instanceof g22)) {
                yz1.c("navigateBack", "top fragment error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                m93.i(ys2Var);
                return false;
            }
            g22 g22Var = (g22) V.m();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(h63.c(g22Var != null ? g22Var.t3() : ""), 0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
