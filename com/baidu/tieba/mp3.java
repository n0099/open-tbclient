package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.xc3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class mp3 extends q93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements mm3<tc3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ mp3 c;

        public a(mp3 mp3Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp3Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mp3Var;
            this.a = callbackHandler;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(tc3 tc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tc3Var) == null) {
                if (tc3Var == null || tc3Var.d) {
                    this.c.n(false, null, this.a, this.b, 10005, "system deny");
                    me3.r(10005, tc3Var);
                    return;
                }
                this.c.p(tc3Var, this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements fo1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tc3 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ String c;
        public final /* synthetic */ mp3 d;

        public b(mp3 mp3Var, tc3 tc3Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp3Var, tc3Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = mp3Var;
            this.a = tc3Var;
            this.b = callbackHandler;
            this.c = str;
        }

        @Override // com.baidu.tieba.fo1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (q93.b) {
                    Log.d("LoginAndGetMobileAction", "onResult: loginStatusCode = " + i);
                }
                if (i == -2) {
                    this.d.n(false, null, this.b, this.c, 20050002, "user did cancel login");
                } else if (i != 0) {
                    this.d.n(false, null, this.b, this.c, 20050003, "user fail to login");
                } else {
                    this.d.o(this.a.c, gt2.U().getActivity(), this.b, this.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements mm3<wc3<xc3.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ mp3 c;

        public c(mp3 mp3Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp3Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mp3Var;
            this.a = callbackHandler;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(wc3<xc3.b> wc3Var) {
            xc3.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wc3Var) == null) {
                if (wc3Var == null || !wc3Var.c() || (bVar = wc3Var.a) == null || bVar.c == null) {
                    this.c.n(true, null, this.a, this.b, 20050004, "user fail to get mobile information");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("data", wc3Var.a.c.optString("data"));
                    jSONObject.put("iv", wc3Var.a.c.optString("iv"));
                    this.c.n(true, jSONObject, this.a, this.b, 0, "success");
                } catch (JSONException unused) {
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mp3(q83 q83Var) {
        super(q83Var, "/swanAPI/getPhoneNumberByLogin");
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
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty params");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            go1 N = s73.K().q().N();
            if (N == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty account");
                return false;
            }
            if (N.e(context)) {
                n(true, null, callbackHandler, optString, 20050001, "user already login");
            } else {
                t73Var.e0().e("login_with_mobile", new a(this, callbackHandler, optString));
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(boolean z, JSONObject jSONObject, CallbackHandler callbackHandler, String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), jSONObject, callbackHandler, str, Integer.valueOf(i), str2}) == null) {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject2.put("loginState", z);
                if (jSONObject != null) {
                    jSONObject2.put("mobile", jSONObject);
                }
                jSONObject3 = UnitedSchemeUtility.wrapCallbackParams(jSONObject2, i, str2);
            } catch (JSONException unused) {
            }
            callbackHandler.handleSchemeDispatchCallback(str, jSONObject3.toString());
        }
    }

    public final void o(boolean z, FragmentActivity fragmentActivity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), fragmentActivity, callbackHandler, str}) == null) {
            if (z) {
                xc3 a2 = s73.K().x().a().b().a(fragmentActivity, z, "login_with_mobile", null);
                a2.o(new c(this, callbackHandler, str));
                a2.call();
                return;
            }
            n(true, null, callbackHandler, str, 20050004, "user fail to get mobile information");
        }
    }

    public final void p(tc3 tc3Var, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, tc3Var, callbackHandler, str) == null) {
            new pp3().h(new b(this, tc3Var, callbackHandler, str));
        }
    }
}
