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
import com.baidu.tieba.ig3;
import com.baidu.tieba.lz1;
import com.baidu.tieba.mg3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ys3 extends ad3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ db3 e;
        public final /* synthetic */ lz1.d f;
        public final /* synthetic */ Bundle g;
        public final /* synthetic */ ys3 h;

        public a(ys3 ys3Var, CallbackHandler callbackHandler, String str, Context context, String str2, db3 db3Var, lz1.d dVar, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ys3Var, callbackHandler, str, context, str2, db3Var, dVar, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = ys3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = context;
            this.d = str2;
            this.e = db3Var;
            this.f = dVar;
            this.g = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (!bg3.h(gg3Var)) {
                    bg3.q(gg3Var, this.a, this.b);
                } else if (this.h.o(this.c, this.d)) {
                    this.h.m(this.e, (Activity) this.c, this.f, this.a, this.b, this.g);
                } else {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(10008, "app not installed").toString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements wp3<gg3<mg3.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lz1.d a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ String c;

        public b(ys3 ys3Var, lz1.d dVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ys3Var, dVar, callbackHandler, str};
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
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<mg3.d> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (!gg3Var.c()) {
                    d82.o("ThirdPartyLoginAction", gg3Var.b() + " " + this.a.toString());
                    String f = bg3.f(gg3Var.b());
                    if (!TextUtils.isEmpty(f)) {
                        this.b.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(gg3Var.b(), f).toString());
                    } else {
                        this.b.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(gg3Var.b()).toString());
                    }
                } else if (TextUtils.isEmpty(gg3Var.a.a)) {
                    this.b.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                } else {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("code", gg3Var.a.a);
                        this.b.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, gg3Var.b()).toString());
                    } catch (JSONException e) {
                        if (ad3.b) {
                            e.printStackTrace();
                        }
                        this.b.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ys3(ac3 ac3Var) {
        super(ac3Var, "/swanAPI/thirdPartyLogin");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ac3Var};
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

    @Override // com.baidu.tieba.ad3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, db3Var)) == null) {
            if (db3Var == null) {
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
            lz1.d dVar = new lz1.d(optParamsAsJo);
            Bundle bundle = new Bundle();
            bundle.putInt("key_login_mode", n);
            db3Var.e0().g(context, "mapp_i_login", new a(this, callbackHandler, optString, context, optString2, db3Var, dVar, bundle));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(db3 db3Var, Activity activity, lz1.d dVar, CallbackHandler callbackHandler, String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{db3Var, activity, dVar, callbackHandler, str, bundle}) == null) {
            db3Var.e0().r(activity, dVar, bundle, new b(this, dVar, callbackHandler, str), "SwanThirdPartLogin");
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
                    return xo3.F(context, "com.sina.weibo");
                }
                return xo3.F(context, "com.tencent.mobileqq");
            }
            return xo3.F(context, "com.tencent.mm");
        }
        return invokeLL.booleanValue;
    }
}
