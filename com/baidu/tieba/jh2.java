package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.ed2;
import com.baidu.tieba.pb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jh2 extends h83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ JSONObject c;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, unitedSchemeEntity, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (!ib3.h(nb3Var)) {
                    ib3.p(nb3Var, this.a, this.b);
                    return;
                }
                if (this.c.has("emitLive")) {
                    j23.Q(yg2.b(this.c.optInt("emitLive")));
                }
                if (this.c.has("emitHttps")) {
                    j23.N(yg2.b(this.c.optInt("emitHttps")));
                }
                if (this.c.has("emitDomain")) {
                    j23.T(!yg2.b(this.c.optInt("emitDomain")));
                    j23.W(!yg2.b(this.c.optInt("emitDomain")));
                }
                if (this.c.has("emitWss")) {
                    j23.P(yg2.b(this.c.optInt("emitWss")));
                }
                if (this.c.has("emitLaunchMode")) {
                    j23.U(yg2.b(this.c.optInt("emitLaunchMode")));
                }
                if (this.c.has("debugEnvData")) {
                    j23.K(this.c.optString("debugEnvData"));
                }
                if (this.c.has("emitReplaceJsNative")) {
                    j23.O(yg2.b(this.c.optInt("emitReplaceJsNative")));
                }
                if (this.c.has("emitReplaceV8Core")) {
                    ed2.v.e(ed2.v.b(this.c.optInt("emitReplaceV8Core")));
                }
                if (this.c.has("emitHostEnv")) {
                    j23.S(this.c.optInt("emitHostEnv"));
                }
                if (this.c.has("openStabilityCollector")) {
                    dh2.b(yg2.b(this.c.optInt("openStabilityCollector")));
                }
                if (this.c.has("openPerformanceTesting")) {
                    ch2.b(yg2.b(this.c.optInt("openPerformanceTesting")));
                }
                UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(0));
                j23.Z();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jh2(h73 h73Var) {
        super(h73Var, "/swanAPI/debug/setDebugConfig");
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

    public static boolean j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, context, unitedSchemeEntity, callbackHandler, k63Var, jSONObject)) == null) {
            k63Var.f0().g(context, "mapp_cts_debug", new a(callbackHandler, unitedSchemeEntity, jSONObject));
            return true;
        }
        return invokeLLLLL.booleanValue;
    }

    public static boolean k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, unitedSchemeEntity, callbackHandler, jSONObject, jSONObject2)) == null) {
            if (!h83.b) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            } else if (!TextUtils.equals(jSONObject.optString("category"), "swanGame")) {
                k32.c("setDebugConfig", "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                if (jSONObject2.has("emitHttps")) {
                    j23.N(yg2.b(jSONObject2.optInt("emitHttps")));
                }
                if (jSONObject2.has("emitWss")) {
                    j23.P(yg2.b(jSONObject2.optInt("emitWss")));
                }
                if (jSONObject2.has("debugEnvData")) {
                    j23.K(jSONObject2.optString("debugEnvData"));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                j23.Z();
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.h83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, k63Var)) == null) {
            JSONObject a2 = h83.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                k32.c("setDebugConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            JSONObject optJSONObject = a2.optJSONObject("config");
            if (optJSONObject == null) {
                k32.c("setDebugConfig", "config is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            int k = j63.K().k();
            if (k != 0) {
                if (k != 1) {
                    k32.c("setDebugConfig", "frame type error");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                return k(unitedSchemeEntity, callbackHandler, a2, optJSONObject);
            }
            return j(context, unitedSchemeEntity, callbackHandler, k63Var, optJSONObject);
        }
        return invokeLLLL.booleanValue;
    }
}
