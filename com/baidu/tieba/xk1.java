package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.k93;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class xk1 extends c63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements yi3<i93<k93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f43 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ UnitedSchemeEntity g;
        public final /* synthetic */ xk1 h;

        public a(xk1 xk1Var, f43 f43Var, Context context, boolean z, String str, CallbackHandler callbackHandler, String str2, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk1Var, f43Var, context, Boolean.valueOf(z), str, callbackHandler, str2, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = xk1Var;
            this.a = f43Var;
            this.b = context;
            this.c = z;
            this.d = str;
            this.e = callbackHandler;
            this.f = str2;
            this.g = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(i93<k93.e> i93Var) {
            Context w;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i93Var) == null) {
                boolean e = this.a.N().e(this.b);
                if (!d93.h(i93Var)) {
                    if (!e && !this.c) {
                        ya3.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 5, this.d);
                    }
                    d93.q(i93Var, this.e, this.f);
                    return;
                }
                f12.i("chooseInvoiceTitle", OAuthResult.RESULT_MSG_SUCCESS);
                Context context = this.b;
                if (context instanceof Activity) {
                    w = (Activity) context;
                } else {
                    w = this.a.w();
                }
                Context context2 = w;
                if (context2 == null) {
                    UnitedSchemeUtility.safeCallback(this.e, this.g, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString(), this.f);
                    return;
                }
                if (e && !this.c) {
                    ya3.S("success", 5, this.d);
                }
                this.h.k(context2, this.e, this.g, this.a, this.f, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements yk1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ String c;

        public b(xk1 xk1Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk1Var, callbackHandler, unitedSchemeEntity, str};
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
        }

        @Override // com.baidu.tieba.yk1
        public void a(int i) {
            String jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 1) {
                    f12.i("chooseInvoiceTitle", "choose invoice cancel");
                    jSONObject = UnitedSchemeUtility.wrapCallbackParams(1002, "choose invoice cancel").toString();
                } else {
                    f12.i("chooseInvoiceTitle", "choose invoice failed");
                    jSONObject = UnitedSchemeUtility.wrapCallbackParams(1003, "choose invoice failed").toString();
                }
                UnitedSchemeUtility.safeCallback(this.a, this.b, jSONObject, this.c);
            }
        }

        @Override // com.baidu.tieba.yk1
        public void b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                f12.i("chooseInvoiceTitle", "choose success");
                UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xk1(c53 c53Var) {
        super(c53Var, "/swanAPI/chooseInvoiceTitle");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c53Var};
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

    @Override // com.baidu.tieba.c63
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, f43 f43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, f43Var)) == null) {
            f12.i("chooseInvoiceTitle", "发票调起");
            if (f43Var == null) {
                f12.c("chooseInvoiceTitle", "empty swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                return false;
            } else if (f43Var.n0()) {
                if (c63.b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    f12.c("chooseInvoiceTitle", "empty joParams");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    f12.c("chooseInvoiceTitle", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                String optString2 = optParamsAsJo.optString("invokeFrom");
                boolean e = f43Var.N().e(context);
                if (!e) {
                    ya3.S("show", 5, optString2);
                }
                f43Var.e0().h(context, "mapp_choose_invoice", d93.j(optParamsAsJo), new a(this, f43Var, context, e, optString2, callbackHandler, optString, unitedSchemeEntity));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, f43 f43Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, callbackHandler, unitedSchemeEntity, f43Var, str, str2}) == null) {
            mn2.k0().a(context, f43Var.b, f43Var.O(), new b(this, callbackHandler, unitedSchemeEntity, str));
        }
    }
}
