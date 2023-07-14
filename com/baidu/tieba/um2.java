package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.ah3;
import com.baidu.tieba.pi2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class um2 extends sd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements oq3<yg3<ah3.e>> {
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
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(yg3<ah3.e> yg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg3Var) == null) {
                if (!tg3.h(yg3Var)) {
                    tg3.p(yg3Var, this.a, this.b);
                    return;
                }
                if (this.c.has("emitLive")) {
                    u73.Q(jm2.b(this.c.optInt("emitLive")));
                }
                if (this.c.has("emitHttps")) {
                    u73.N(jm2.b(this.c.optInt("emitHttps")));
                }
                if (this.c.has("emitDomain")) {
                    u73.T(!jm2.b(this.c.optInt("emitDomain")));
                    u73.W(!jm2.b(this.c.optInt("emitDomain")));
                }
                if (this.c.has("emitWss")) {
                    u73.P(jm2.b(this.c.optInt("emitWss")));
                }
                if (this.c.has("emitLaunchMode")) {
                    u73.U(jm2.b(this.c.optInt("emitLaunchMode")));
                }
                if (this.c.has("debugEnvData")) {
                    u73.K(this.c.optString("debugEnvData"));
                }
                if (this.c.has("emitReplaceJsNative")) {
                    u73.O(jm2.b(this.c.optInt("emitReplaceJsNative")));
                }
                if (this.c.has("emitReplaceV8Core")) {
                    pi2.v.e(pi2.v.b(this.c.optInt("emitReplaceV8Core")));
                }
                if (this.c.has("emitHostEnv")) {
                    u73.S(this.c.optInt("emitHostEnv"));
                }
                if (this.c.has("openStabilityCollector")) {
                    om2.b(jm2.b(this.c.optInt("openStabilityCollector")));
                }
                if (this.c.has("openPerformanceTesting")) {
                    nm2.b(jm2.b(this.c.optInt("openPerformanceTesting")));
                }
                UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(0));
                u73.Z();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public um2(sc3 sc3Var) {
        super(sc3Var, "/swanAPI/debug/setDebugConfig");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sc3Var};
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

    public static boolean j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, context, unitedSchemeEntity, callbackHandler, vb3Var, jSONObject)) == null) {
            vb3Var.e0().g(context, "mapp_cts_debug", new a(callbackHandler, unitedSchemeEntity, jSONObject));
            return true;
        }
        return invokeLLLLL.booleanValue;
    }

    public static boolean k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, unitedSchemeEntity, callbackHandler, jSONObject, jSONObject2)) == null) {
            if (!sd3.b) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            } else if (!TextUtils.equals(jSONObject.optString("category"), "swanGame")) {
                v82.c("setDebugConfig", "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                if (jSONObject2.has("emitHttps")) {
                    u73.N(jm2.b(jSONObject2.optInt("emitHttps")));
                }
                if (jSONObject2.has("emitWss")) {
                    u73.P(jm2.b(jSONObject2.optInt("emitWss")));
                }
                if (jSONObject2.has("debugEnvData")) {
                    u73.K(jSONObject2.optString("debugEnvData"));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                u73.Z();
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.sd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, vb3Var)) == null) {
            JSONObject a2 = sd3.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                v82.c("setDebugConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            JSONObject optJSONObject = a2.optJSONObject("config");
            if (optJSONObject == null) {
                v82.c("setDebugConfig", "config is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            int k = ub3.K().k();
            if (k != 0) {
                if (k != 1) {
                    v82.c("setDebugConfig", "frame type error");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                return k(unitedSchemeEntity, callbackHandler, a2, optJSONObject);
            }
            return j(context, unitedSchemeEntity, callbackHandler, vb3Var, optJSONObject);
        }
        return invokeLLLL.booleanValue;
    }
}
