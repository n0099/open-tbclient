package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.ma2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes7.dex */
public class pe3 extends ad3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pe3(ac3 ac3Var) {
        super(ac3Var, "/swanAPI/navigateBack");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ac3Var};
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

    @Override // com.baidu.tieba.ad3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var) {
        InterceptResult invokeLLLL;
        int optInt;
        d13 d13Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, db3Var)) == null) {
            if (ad3.b) {
                Log.d("NavigateBackAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            j43.b(uuid);
            String str2 = unitedSchemeEntity.getParams().get("params");
            if (!TextUtils.isEmpty(str2)) {
                try {
                    optInt = new JSONObject(str2).optInt("delta", 1);
                } catch (JSONException e) {
                    if (ad3.b) {
                        e.printStackTrace();
                    }
                    d82.c("navigateBack", "params parse fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
            } else {
                optInt = 1;
            }
            ma2 U = qw2.T().U();
            if (U == null) {
                d82.c("navigateBack", "fragmentManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            int k = U.k();
            if (ad3.b) {
                Log.d("NavigateBackAction", "back delta: " + optInt);
            }
            if (k == 1) {
                d82.c("NavigateBackAction", "navigateBack api can only work when slave's count greater than 1");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "navigateBack api can only work when slave's count greater than 1");
                return false;
            }
            if (optInt >= k) {
                optInt = k - 1;
            }
            if (ad3.b) {
                Log.d("NavigateBackAction", "real back delta: " + optInt);
            }
            ja2 j = U.j((k - optInt) - 1);
            d13 d13Var2 = null;
            if (j instanceof la2) {
                d13Var = ((la2) j).o3();
                d13Var.e = "1";
                d13Var.f = uuid;
            } else {
                d13Var = null;
            }
            rh3.g(d13Var);
            j43.c(1, uuid);
            nn3.a(U, context);
            ma2.b i = U.i("navigateBack");
            i.n(ma2.i, ma2.h);
            i.h(optInt);
            i.a();
            la2 o = U.o();
            if (o != null) {
                d13Var2 = o.o3();
            }
            i43.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
            j43.a(uuid, d13Var2);
            if (!(U.m() instanceof la2)) {
                d82.c("navigateBack", "top fragment error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                rh3.i(d13Var);
                return false;
            }
            la2 la2Var = (la2) U.m();
            if (la2Var != null) {
                str = la2Var.v3();
            } else {
                str = "";
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(me3.c(str), 0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
