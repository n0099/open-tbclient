package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class r93 extends u93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r93(u83 u83Var) {
        super(u83Var, "/swanAPI/preventPullDownRefresh");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u83Var};
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

    @Override // com.baidu.tieba.u93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, x73 x73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, x73Var)) == null) {
            if (u93.b) {
                Log.d("PreventPullDownRefresh", "handle entity: " + unitedSchemeEntity.toString());
            }
            JSONObject a = u93.a(unitedSchemeEntity, "params");
            if (a == null) {
                x42.c("preventPullDownRefresh", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
                return false;
            }
            String optString = a.optString("slaveId");
            if (TextUtils.isEmpty(optString)) {
                x42.c("preventPullDownRefresh", "slaveId null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "slaveId null");
                return false;
            }
            kt2 U = kt2.U();
            fu1 A = U.A(optString);
            if (!(A instanceof du1)) {
                x42.c("preventPullDownRefresh", "webViewManager not a SwanAppSlaveManager");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "webViewManager not a SwanAppSlaveManager");
                return false;
            }
            g72 V = U.V();
            if (V == null) {
                x42.c("PreventPullDownRefresh", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            f72 o = V.o();
            if (o == null) {
                x42.c("PreventPullDownRefresh", "slave container is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (TextUtils.equals("7", o.Q1().l())) {
                x42.c("PreventPullDownRefresh", "this page is from showModalPage api");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(402);
                return false;
            } else {
                boolean optBoolean = a.optBoolean("prevent", false);
                PullToRefreshBaseWebView h0 = ((du1) A).h0();
                if (h0 != null) {
                    h0.setIsPreventPullToRefresh(optBoolean);
                    return true;
                }
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
