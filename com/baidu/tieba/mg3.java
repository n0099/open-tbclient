package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.tieba.hh3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class mg3 extends zd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements vq3<fh3<hh3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ mg3 d;

        public a(mg3 mg3Var, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg3Var, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = mg3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(fh3<hh3.e> fh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fh3Var) != null) {
                return;
            }
            this.d.k(this.a, this.b, this.c, fh3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947971664, "Lcom/baidu/tieba/mg3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947971664, "Lcom/baidu/tieba/mg3;");
                return;
            }
        }
        boolean z = ms1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mg3(zc3 zc3Var) {
        super(zc3Var, "/swanAPI/authorize");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zc3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.zd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, cc3Var)) == null) {
            if (cc3Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                kv2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null").toString());
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty joParams");
                kv2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty joParams").toString());
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty cb");
                kv2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty cb").toString());
                return false;
            }
            String c = ch3.c(optParamsAsJo.optString("scope"));
            if (TextUtils.isEmpty(c)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty scope");
                kv2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty scope").toString());
                return false;
            }
            cc3Var.e0().c(context, c, false, new a(this, callbackHandler, c, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a7, code lost:
        r8 = 10001;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(CallbackHandler callbackHandler, String str, String str2, fh3<hh3.e> fh3Var) {
        String str3;
        int i;
        String message;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callbackHandler, str, str2, fh3Var) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("scope", ch3.d(str));
                if (fh3Var != null && fh3Var.a != null) {
                    if (!fh3Var.c()) {
                        OAuthException a2 = fh3Var.a();
                        if (a2 == null) {
                            message = "";
                        } else {
                            message = a2.getMessage();
                        }
                        jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, message);
                        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(fh3Var.b()).toString());
                        kv2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, fh3Var.b()).toString());
                        return;
                    }
                    jSONObject.put("code", fh3Var.a.a);
                    if (fh3Var.a.b) {
                        str3 = "authorize:ok";
                    } else {
                        str3 = "user deny";
                    }
                    jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, str3);
                    if (fh3Var.a.b) {
                        i = 0;
                    } else {
                        i = 10003;
                    }
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i).toString());
                    if (!fh3Var.a.b) {
                        kv2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, fh3Var.b()).toString());
                        return;
                    }
                    return;
                }
                int b = fh3Var.b();
                ah3.k("empty auth result", Boolean.TRUE);
                jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, ah3.f(b));
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, b).toString());
                ah3.t("AuthorizeAction", "null == result || null == result.mData");
                kv2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, b).toString());
            } catch (JSONException unused) {
                ah3.k("json exception", Boolean.TRUE);
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(10001, "internal error").toString());
                kv2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 10001, "internal error").toString());
            }
        }
    }
}
