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
public class ta3 extends q93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ta3(q83 q83Var) {
        super(q83Var, "/swanAPI/getMenuButtonBoundingClientRect");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q83Var};
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

    @Override // com.baidu.tieba.q93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, t73Var)) == null) {
            if (t73Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            if (q93.b) {
                Log.d("GetMenuButtonBounding", "handle entity: " + unitedSchemeEntity.toString());
            }
            c72 V = gt2.U().V();
            if (V == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            z62 m = V.m();
            if (m == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (t73Var.w0()) {
                View q = br2.i().q(m);
                if (q == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                unitedSchemeEntity.result = j(q);
                return true;
            } else {
                SwanAppActionBar N1 = m.N1();
                if (N1 == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                View rightMenu = N1.getRightMenu();
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
            t73 M = t73.M();
            if (M != null) {
                z = M.w0();
            } else {
                z = false;
            }
            if (z) {
                P = 0;
            } else {
                P = (int) (kl3.P(kl3.t()) + 0.5f);
            }
            int P2 = (int) (kl3.P(view2.getLeft()) + 0.5f);
            int P3 = (int) (kl3.P(view2.getRight()) + 0.5f);
            int P4 = ((int) (kl3.P(view2.getTop()) + 0.5f)) + P;
            int P5 = ((int) (kl3.P(view2.getBottom()) + 0.5f)) + P;
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
                if (q93.b) {
                    e.printStackTrace();
                }
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
            }
            if (q93.b) {
                Log.e("GetMenuButtonBounding", wrapCallbackParams.toString());
            }
            return wrapCallbackParams;
        }
        return (JSONObject) invokeL.objValue;
    }
}
