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
/* loaded from: classes7.dex */
public class p83 extends m73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p83(m63 m63Var) {
        super(m63Var, "/swanAPI/getMenuButtonBoundingClientRect");
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
            if (p53Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            if (m73.b) {
                Log.d("GetMenuButtonBounding", "handle entity: " + unitedSchemeEntity.toString());
            }
            y42 W = cr2.V().W();
            if (W == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            v42 m = W.m();
            if (m == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (p53Var.x0()) {
                View q = xo2.i().q(m);
                if (q == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                unitedSchemeEntity.result = j(q);
                return true;
            } else {
                SwanAppActionBar Q1 = m.Q1();
                if (Q1 == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                View rightMenu = Q1.getRightMenu();
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
            p53 M = p53.M();
            if (M != null) {
                z = M.x0();
            } else {
                z = false;
            }
            if (z) {
                P = 0;
            } else {
                P = (int) (gj3.P(gj3.t()) + 0.5f);
            }
            int P2 = (int) (gj3.P(view2.getLeft()) + 0.5f);
            int P3 = (int) (gj3.P(view2.getRight()) + 0.5f);
            int P4 = ((int) (gj3.P(view2.getTop()) + 0.5f)) + P;
            int P5 = ((int) (gj3.P(view2.getBottom()) + 0.5f)) + P;
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
                if (m73.b) {
                    e.printStackTrace();
                }
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
            }
            if (m73.b) {
                Log.e("GetMenuButtonBounding", wrapCallbackParams.toString());
            }
            return wrapCallbackParams;
        }
        return (JSONObject) invokeL.objValue;
    }
}
