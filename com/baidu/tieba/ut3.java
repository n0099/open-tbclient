package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.eh3;
import com.baidu.tieba.h02;
import com.baidu.tieba.ih3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ut3 extends wd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements sq3<ch3<eh3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ zb3 e;
        public final /* synthetic */ h02.d f;
        public final /* synthetic */ Bundle g;
        public final /* synthetic */ ut3 h;

        public a(ut3 ut3Var, CallbackHandler callbackHandler, String str, Context context, String str2, zb3 zb3Var, h02.d dVar, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ut3Var, callbackHandler, str, context, str2, zb3Var, dVar, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = ut3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = context;
            this.d = str2;
            this.e = zb3Var;
            this.f = dVar;
            this.g = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(ch3<eh3.e> ch3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ch3Var) == null) {
                if (!xg3.h(ch3Var)) {
                    xg3.q(ch3Var, this.a, this.b);
                } else if (this.h.o(this.c, this.d)) {
                    this.h.m(this.e, (Activity) this.c, this.f, this.a, this.b, this.g);
                } else {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(10008, "app not installed").toString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements sq3<ch3<ih3.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h02.d a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ String c;

        public b(ut3 ut3Var, h02.d dVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ut3Var, dVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.b = callbackHandler;
            this.c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(ch3<ih3.d> ch3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ch3Var) == null) {
                if (!ch3Var.c()) {
                    z82.o("ThirdPartyLoginAction", ch3Var.b() + " " + this.a.toString());
                    String f = xg3.f(ch3Var.b());
                    if (!TextUtils.isEmpty(f)) {
                        this.b.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(ch3Var.b(), f).toString());
                    } else {
                        this.b.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(ch3Var.b()).toString());
                    }
                } else if (TextUtils.isEmpty(ch3Var.a.a)) {
                    this.b.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                } else {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("code", ch3Var.a.a);
                        this.b.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, ch3Var.b()).toString());
                    } catch (JSONException e) {
                        if (wd3.b) {
                            e.printStackTrace();
                        }
                        this.b.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ut3(wc3 wc3Var) {
        super(wc3Var, "/swanAPI/thirdPartyLogin");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wc3Var};
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

    @Override // com.baidu.tieba.wd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, zb3Var)) == null) {
            if (zb3Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            String optString2 = optParamsAsJo.optString("type", "");
            int n = n(optString2);
            h02.d dVar = new h02.d(optParamsAsJo);
            Bundle bundle = new Bundle();
            bundle.putInt("key_login_mode", n);
            zb3Var.e0().g(context, "mapp_i_login", new a(this, callbackHandler, optString, context, optString2, zb3Var, dVar, bundle));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(zb3 zb3Var, Activity activity, h02.d dVar, CallbackHandler callbackHandler, String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{zb3Var, activity, dVar, callbackHandler, str, bundle}) == null) {
            zb3Var.e0().r(activity, dVar, bundle, new b(this, dVar, callbackHandler, str), "SwanThirdPartLogin");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int n(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            switch (str.hashCode()) {
                case -791575966:
                    if (str.equals(ThirdPartyUtil.TYPE_WEIXIN)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -265713450:
                    if (str.equals("username")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3616:
                    if (str.equals(LoginConstants.QQ_LOGIN)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 114009:
                    if (str.equals(LoginConstants.SMS_LOGIN)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 113011944:
                    if (str.equals("weibo")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                return 0;
            }
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        if (c == 4) {
                            return 4;
                        }
                    } else {
                        return 3;
                    }
                } else {
                    return 2;
                }
            }
            return 1;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final boolean o(Context context, String str) {
        InterceptResult invokeLL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
            switch (str.hashCode()) {
                case -791575966:
                    if (str.equals(ThirdPartyUtil.TYPE_WEIXIN)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -265713450:
                    if (str.equals("username")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 3616:
                    if (str.equals(LoginConstants.QQ_LOGIN)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 114009:
                    if (str.equals(LoginConstants.SMS_LOGIN)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 113011944:
                    if (str.equals("weibo")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3 && c != 4) {
                            return false;
                        }
                        return true;
                    }
                    return tp3.F(context, "com.sina.weibo");
                }
                return tp3.F(context, "com.tencent.mobileqq");
            }
            return tp3.F(context, "com.tencent.mm");
        }
        return invokeLL.booleanValue;
    }
}
