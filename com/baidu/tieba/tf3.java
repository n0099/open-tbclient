package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.mg3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class tf3 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ tf3 f;

        public a(tf3 tf3Var, CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tf3Var, callbackHandler, str, activity, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = tf3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = activity;
            this.d = str2;
            this.e = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (fg3.h(kg3Var)) {
                    if (ed3.b) {
                        Log.i("SwanAppAction", "onCallback: has permission scope_mobile_api");
                    }
                    this.f.m(this.a, this.b, this.c, this.d, this.e, false);
                    return;
                }
                h82.k("SwanAppAction", "onCallback: no permission scope_mobile_api");
                ai3.U(this.e, "fail", "onCallback: no permission ");
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(402).toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements aq3<tg3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ boolean g;
        public final /* synthetic */ tf3 h;

        public b(tf3 tf3Var, Activity activity, boolean z, String str, CallbackHandler callbackHandler, String str2, String str3, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tf3Var, activity, Boolean.valueOf(z), str, callbackHandler, str2, str3, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = tf3Var;
            this.a = activity;
            this.b = z;
            this.c = str;
            this.d = callbackHandler;
            this.e = str2;
            this.f = str3;
            this.g = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(tg3 tg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tg3Var) == null) {
                h82.b("OpenData", "onOpenDataCallback:: ", tg3Var);
                hb3 c = this.h.c();
                if (!tg3Var.D()) {
                    if (c != null && !c.N().e(this.a) && !this.b) {
                        ai3.S("fail", 2, this.c);
                    }
                    if (ed3.b) {
                        Log.i("SwanAppAction", "onCallback: no open datamobile");
                    }
                    fg3.n(tg3Var, this.d, this.e);
                    ai3.U(this.f, "fail", "onCallback: no open data");
                    if (this.g) {
                        ai3.s("click", "telLogin", "fail");
                        return;
                    }
                    return;
                }
                h82.k("SwanAppAction", "onCallback: got open datamobile");
                if (c != null && c.N().e(this.a) && !this.b) {
                    ai3.S("success", 2, this.c);
                }
                ai3.T(this.f, "success");
                if (this.g) {
                    ai3.s("click", "telLogin", "succ_agree");
                }
                this.d.handleSchemeDispatchCallback(this.e, UnitedSchemeUtility.wrapCallbackParams(tg3Var.g, 0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tf3(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/getPhoneNumber");
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
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (hb3Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("invokeFrom");
            if (optString.equals("component")) {
                str = "getPhoneNumberButton";
            } else {
                str = "getPhoneNumberApi";
            }
            String str2 = str;
            ai3.T(str2, "create");
            String optString2 = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                ai3.U(str2, "fail", "empty cb");
                return false;
            }
            SwanAppActivity w = gb3.K().w();
            if (w == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
                ai3.U(str2, "fail", "the context is not an activity");
                return false;
            }
            if (!hb3Var.N().e(context)) {
                ai3.S("show", 2, optString);
            }
            if (optParamsAsJo.optString("invokeFrom").equals("api")) {
                n(callbackHandler, optString2, w, optString, str2);
            } else {
                m(callbackHandler, optString2, w, optString, str2, TextUtils.equals("login", optParamsAsJo.optString("from")));
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{callbackHandler, str, activity, str2, str3, Boolean.valueOf(z)}) == null) {
            boolean e = gb3.K().q().N().e(activity);
            ai3.T(str3, "checkScope");
            if (z) {
                ai3.s("show", "telLogin", null);
            }
            tg3.B(activity, "mobile", null, false, str3, new b(this, activity, e, str2, callbackHandler, str, str3, z));
        }
    }

    public final void n(CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, callbackHandler, str, activity, str2, str3) == null) {
            ai3.T(str3, "checkScope");
            gb3.K().q().e0().g(c(), "scope_mobile_api", new a(this, callbackHandler, str, activity, str2, str3));
        }
    }
}
