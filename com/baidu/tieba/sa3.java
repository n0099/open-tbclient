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
import com.baidu.tieba.lb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class sa3 extends d83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements zk3<jb3<lb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ sa3 f;

        public a(sa3 sa3Var, CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sa3Var, callbackHandler, str, activity, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = sa3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = activity;
            this.d = str2;
            this.e = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(jb3<lb3.e> jb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jb3Var) == null) {
                if (eb3.h(jb3Var)) {
                    if (d83.b) {
                        Log.i("SwanAppAction", "onCallback: has permission scope_mobile_api");
                    }
                    this.f.m(this.a, this.b, this.c, this.d, this.e, false);
                    return;
                }
                g32.k("SwanAppAction", "onCallback: no permission scope_mobile_api");
                zc3.U(this.e, "fail", "onCallback: no permission ");
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(402).toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements zk3<sb3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ boolean g;
        public final /* synthetic */ sa3 h;

        public b(sa3 sa3Var, Activity activity, boolean z, String str, CallbackHandler callbackHandler, String str2, String str3, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sa3Var, activity, Boolean.valueOf(z), str, callbackHandler, str2, str3, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = sa3Var;
            this.a = activity;
            this.b = z;
            this.c = str;
            this.d = callbackHandler;
            this.e = str2;
            this.f = str3;
            this.g = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(sb3 sb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sb3Var) == null) {
                g32.b("OpenData", "onOpenDataCallback:: ", sb3Var);
                g63 c = this.h.c();
                if (!sb3Var.D()) {
                    if (c != null && !c.N().e(this.a) && !this.b) {
                        zc3.S("fail", 2, this.c);
                    }
                    if (d83.b) {
                        Log.i("SwanAppAction", "onCallback: no open datamobile");
                    }
                    eb3.n(sb3Var, this.d, this.e);
                    zc3.U(this.f, "fail", "onCallback: no open data");
                    if (this.g) {
                        zc3.s("click", "telLogin", "fail");
                        return;
                    }
                    return;
                }
                g32.k("SwanAppAction", "onCallback: got open datamobile");
                if (c != null && c.N().e(this.a) && !this.b) {
                    zc3.S("success", 2, this.c);
                }
                zc3.T(this.f, "success");
                if (this.g) {
                    zc3.s("click", "telLogin", "succ_agree");
                }
                this.d.handleSchemeDispatchCallback(this.e, UnitedSchemeUtility.wrapCallbackParams(sb3Var.g, 0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sa3(d73 d73Var) {
        super(d73Var, "/swanAPI/getPhoneNumber");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d73Var};
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

    @Override // com.baidu.tieba.d83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, g63 g63Var) {
        InterceptResult invokeLLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, g63Var)) == null) {
            if (g63Var == null) {
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
            zc3.T(str2, "create");
            String optString2 = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                zc3.U(str2, "fail", "empty cb");
                return false;
            }
            SwanAppActivity w = f63.K().w();
            if (w == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
                zc3.U(str2, "fail", "the context is not an activity");
                return false;
            }
            if (!g63Var.N().e(context)) {
                zc3.S("show", 2, optString);
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
            boolean e = f63.K().q().N().e(activity);
            zc3.T(str3, "checkScope");
            if (z) {
                zc3.s("show", "telLogin", null);
            }
            sb3.B(activity, "mobile", null, false, str3, new b(this, activity, e, str2, callbackHandler, str, str3, z));
        }
    }

    public final void n(CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, callbackHandler, str, activity, str2, str3) == null) {
            zc3.T(str3, "checkScope");
            f63.K().q().f0().g(c(), "scope_mobile_api", new a(this, callbackHandler, str, activity, str2, str3));
        }
    }
}
