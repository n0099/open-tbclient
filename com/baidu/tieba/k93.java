package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k93 extends h83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k93(h73 h73Var) {
        super(h73Var, "/swanAPI/getMenuButtonBoundingClientRect");
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, k63Var)) == null) {
            if (k63Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            if (h83.b) {
                Log.d("GetMenuButtonBounding", "handle entity: " + unitedSchemeEntity.toString());
            }
            t52 W = xr2.V().W();
            if (W == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            q52 m = W.m();
            if (m == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (k63Var.x0()) {
                View q = sp2.i().q(m);
                if (q == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                unitedSchemeEntity.result = j(q);
                return true;
            } else {
                SwanAppActionBar P1 = m.P1();
                if (P1 == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                View rightMenu = P1.getRightMenu();
                if (rightMenu == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                unitedSchemeEntity.result = j(rightMenu);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final JSONObject j(View view2) {
        InterceptResult invokeL;
        boolean z;
        int P;
        JSONObject wrapCallbackParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            k63 M = k63.M();
            if (M != null) {
                z = M.x0();
            } else {
                z = false;
            }
            if (z) {
                P = 0;
            } else {
                P = (int) (bk3.P(bk3.t()) + 0.5f);
            }
            int P2 = (int) (bk3.P(view2.getLeft()) + 0.5f);
            int P3 = (int) (bk3.P(view2.getRight()) + 0.5f);
            int P4 = ((int) (bk3.P(view2.getTop()) + 0.5f)) + P;
            int P5 = ((int) (bk3.P(view2.getBottom()) + 0.5f)) + P;
            int i = P3 - P2;
            int i2 = P5 - P4;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("width", i);
                jSONObject.put("height", i2);
                jSONObject.put("left", P2);
                jSONObject.put("right", P3);
                jSONObject.put("top", P4);
                jSONObject.put("bottom", P5);
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            } catch (JSONException e) {
                if (h83.b) {
                    e.printStackTrace();
                }
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
            }
            if (h83.b) {
                Log.e("GetMenuButtonBounding", wrapCallbackParams.toString());
            }
            return wrapCallbackParams;
        }
        return (JSONObject) invokeL.objValue;
    }
}
