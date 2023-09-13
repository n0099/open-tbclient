package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.g12;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes8.dex */
public class vf3 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements aq3<kg3<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ String c;
        public final /* synthetic */ hb3 d;

        public a(vf3 vf3Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, hb3 hb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf3Var, callbackHandler, unitedSchemeEntity, str, hb3Var};
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
            this.c = str;
            this.d = hb3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<JSONObject> kg3Var) {
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (kg3Var.c() && (jSONObject = kg3Var.a) != null) {
                    UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.c);
                    hb3 hb3Var = this.d;
                    if (hb3Var != null) {
                        this.d.e0().B(g12.h.a(hb3Var), kg3Var.a.toString());
                    }
                    h82.i("getSwanId", "getSwanId success");
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(10001, "internal_error").toString(), this.c);
                h82.c("getSwanId", "getSwanId failed: internal_error");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vf3(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/getSwanId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
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

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (hb3Var == null) {
                h82.c("getSwanId", "illegal swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                h82.c("getSwanId", "empty joParams");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                h82.c("getSwanId", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            if (f53.e()) {
                String q = hb3Var.e0().q(g12.h.a(hb3Var), null);
                if (TextUtils.isEmpty(q)) {
                    j(context, unitedSchemeEntity, callbackHandler, hb3Var, optString);
                } else {
                    JSONObject d = ho3.d(q);
                    JSONObject optJSONObject = d.optJSONObject("data");
                    if (optJSONObject != null) {
                        String optString2 = optJSONObject.optString("swanid");
                        if (!TextUtils.isEmpty(optString2) && !TextUtils.equals(StringUtil.NULL_STRING, optString2)) {
                            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(d, 0).toString(), optString);
                            h82.i("getSwanId", "getSwanId success");
                        } else {
                            j(context, unitedSchemeEntity, callbackHandler, hb3Var, optString);
                        }
                    } else {
                        j(context, unitedSchemeEntity, callbackHandler, hb3Var, optString);
                    }
                }
            } else {
                j(context, unitedSchemeEntity, callbackHandler, hb3Var, optString);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, hb3Var, str) == null) {
            h82.i("getSwanId", "getSwanId start");
            if (!SwanAppNetworkUtils.i(context)) {
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10002, "network_error").toString(), str);
                h82.c("getSwanId", "network_error");
                return;
            }
            pg3 e = gb3.K().x().a().b().e(context);
            e.o(new a(this, callbackHandler, unitedSchemeEntity, str, hb3Var));
            e.call();
        }
    }
}
