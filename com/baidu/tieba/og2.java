package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.jc2;
import com.baidu.tieba.ua3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class og2 extends m73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements ik3<sa3<ua3.e>> {
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
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(sa3<ua3.e> sa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sa3Var) == null) {
                if (!na3.h(sa3Var)) {
                    na3.p(sa3Var, this.a, this.b);
                    return;
                }
                if (this.c.has("emitLive")) {
                    o13.Q(dg2.b(this.c.optInt("emitLive")));
                }
                if (this.c.has("emitHttps")) {
                    o13.N(dg2.b(this.c.optInt("emitHttps")));
                }
                if (this.c.has("emitDomain")) {
                    o13.T(!dg2.b(this.c.optInt("emitDomain")));
                    o13.W(!dg2.b(this.c.optInt("emitDomain")));
                }
                if (this.c.has("emitWss")) {
                    o13.P(dg2.b(this.c.optInt("emitWss")));
                }
                if (this.c.has("emitLaunchMode")) {
                    o13.U(dg2.b(this.c.optInt("emitLaunchMode")));
                }
                if (this.c.has("debugEnvData")) {
                    o13.K(this.c.optString("debugEnvData"));
                }
                if (this.c.has("emitReplaceJsNative")) {
                    o13.O(dg2.b(this.c.optInt("emitReplaceJsNative")));
                }
                if (this.c.has("emitReplaceV8Core")) {
                    jc2.v.e(jc2.v.b(this.c.optInt("emitReplaceV8Core")));
                }
                if (this.c.has("emitHostEnv")) {
                    o13.S(this.c.optInt("emitHostEnv"));
                }
                if (this.c.has("openStabilityCollector")) {
                    ig2.b(dg2.b(this.c.optInt("openStabilityCollector")));
                }
                if (this.c.has("openPerformanceTesting")) {
                    hg2.b(dg2.b(this.c.optInt("openPerformanceTesting")));
                }
                UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(0));
                o13.Z();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public og2(m63 m63Var) {
        super(m63Var, "/swanAPI/debug/setDebugConfig");
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

    public static boolean j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, context, unitedSchemeEntity, callbackHandler, p53Var, jSONObject)) == null) {
            p53Var.f0().g(context, "mapp_cts_debug", new a(callbackHandler, unitedSchemeEntity, jSONObject));
            return true;
        }
        return invokeLLLLL.booleanValue;
    }

    public static boolean k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, unitedSchemeEntity, callbackHandler, jSONObject, jSONObject2)) == null) {
            if (!m73.b) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            } else if (!TextUtils.equals(jSONObject.optString("category"), "swanGame")) {
                p22.c("setDebugConfig", "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                if (jSONObject2.has("emitHttps")) {
                    o13.N(dg2.b(jSONObject2.optInt("emitHttps")));
                }
                if (jSONObject2.has("emitWss")) {
                    o13.P(dg2.b(jSONObject2.optInt("emitWss")));
                }
                if (jSONObject2.has("debugEnvData")) {
                    o13.K(jSONObject2.optString("debugEnvData"));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                o13.Z();
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.m73
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, p53Var)) == null) {
            JSONObject a2 = m73.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                p22.c("setDebugConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            JSONObject optJSONObject = a2.optJSONObject("config");
            if (optJSONObject == null) {
                p22.c("setDebugConfig", "config is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            int k = o53.K().k();
            if (k != 0) {
                if (k != 1) {
                    p22.c("setDebugConfig", "frame type error");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                return k(unitedSchemeEntity, callbackHandler, a2, optJSONObject);
            }
            return j(context, unitedSchemeEntity, callbackHandler, p53Var, optJSONObject);
        }
        return invokeLLLL.booleanValue;
    }
}
