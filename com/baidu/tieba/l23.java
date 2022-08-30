package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tieba.ue3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l23 extends x23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements tf3<a63> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ JSONObject e;
        public final /* synthetic */ String f;
        public final /* synthetic */ l23 g;

        public a(l23 l23Var, CallbackHandler callbackHandler, String str, String str2, Context context, JSONObject jSONObject, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l23Var, callbackHandler, str, str2, context, jSONObject, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = l23Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
            this.d = context;
            this.e = jSONObject;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tf3
        /* renamed from: b */
        public void a(a63 a63Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a63Var) == null) {
                if (a63Var != null && !a63Var.d) {
                    if (this.g.m(a63Var, this.c)) {
                        this.g.l(this.d, this.e, this.a, this.b, this.f);
                        return;
                    } else {
                        this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1003, "打开APP失败，打开App条件未满足").toString());
                        return;
                    }
                }
                if (x23.b) {
                    Log.i("OpenAppAction", "no configuration of authority");
                }
                y53.o(10005, this.a, this.b);
                t73.r(10005, a63Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ue3.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public b(l23 l23Var, CallbackHandler callbackHandler, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l23Var, callbackHandler, str, str2, str3};
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
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        @Override // com.baidu.tieba.ue3.g
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(z ? 0 : 1001, z ? "打开APP成功" : "打开APP失败，本地没有安装").toString());
                c.a("open", this.c, "confirm", this.d);
            }
        }

        @Override // com.baidu.tieba.ue3.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1004, "取消打开APP").toString());
                c.a("open", this.c, "cancel", this.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(String str, String str2, String str3, String str4) {
            String str5;
            String str6;
            String str7;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(65536, null, str, str2, str3, str4) == null) {
                c83 c83Var = new c83();
                a13 b0 = a13.b0();
                String str8 = "";
                if (b0 != null) {
                    str8 = t73.n(b0.k());
                    str6 = b0.getAppId();
                    str7 = b0.Z();
                    str5 = b0.W().T();
                } else {
                    str5 = "";
                    str6 = str5;
                    str7 = str6;
                }
                String a = hk2.n().a();
                c83Var.a = str8;
                c83Var.b = str;
                c83Var.e = str2;
                c83Var.f = str6;
                c83Var.c = str5;
                c83Var.a("appName", str7);
                c83Var.a("hostName", a);
                c83Var.a("hostVersion", ue3.D());
                c83Var.a(PushConstants.CLICK_TYPE, str3);
                try {
                    str4 = URLDecoder.decode(str4, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                }
                c83Var.a("scheme", str4);
                h73.i("2572", "90", c83Var.f());
                if (x23.b) {
                    Log.d("OpenAppAction", String.format("ubcId=%s && ceresId=%s , content:%s ", "2572", "90", c83Var.f()));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l23(x13 x13Var) {
        super(x13Var, "/swanAPI/openApp");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x13Var};
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

    @Override // com.baidu.tieba.x23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, a13 a13Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, a13Var)) == null) {
            if (!hk2.a().d()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            } else if (a13Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            } else {
                JSONObject a2 = x23.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "invalid params");
                    return false;
                }
                String optString = a2.optString("cb");
                if (x23.b) {
                    Log.i("OpenAppAction", "params is " + a2.toString());
                }
                String optString2 = a2.optString("open", "");
                String optString3 = a2.optString("invokeFrom", "");
                c.a("invoke", optString3, null, optString2);
                if (optString2.startsWith(BaseWebViewActivity.SHOUBAI_SCHEME)) {
                    if (!hk2.a().c()) {
                        s03.f(context, R.string.obfuscated_res_0x7f0f1230).G();
                        return false;
                    }
                    l(context, a2, callbackHandler, optString, optString3);
                } else {
                    a13Var.e0().e("scope_open_app", new a(this, callbackHandler, optString, optString2, context, a2, optString3));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, callbackHandler, str, str2) == null) {
            String optString = jSONObject.optString("open");
            if (TextUtils.isEmpty(optString)) {
                z = false;
            } else {
                optString = Uri.decode(optString);
                hk2.P().a(optString, jSONObject.optJSONObject("extraParams"));
                if (x23.b) {
                    Log.i("OpenAppAction", "openUrl:" + optString);
                }
                z = o(context, optString, callbackHandler, str, str2);
            }
            boolean optBoolean = jSONObject.optBoolean("isNeedDownload", true);
            if (x23.b) {
                Log.i("OpenAppAction", "open app result=" + z + "\nisNeedDownload=" + optBoolean);
            }
            if (!optBoolean) {
                if (z) {
                    return;
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1002, "打开APP失败，本地没有安装").toString());
            } else if (z) {
            } else {
                boolean e = ue3.e(context, jSONObject.optString("download"));
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(e ? 0 : 1001, e ? "下载APP成功" : "下载APP失败").toString());
                c.a("download", str2, null, optString);
            }
        }
    }

    public final boolean m(a63 a63Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, a63Var, str)) == null) {
            if (a63Var != null && !TextUtils.isEmpty(str)) {
                String T = z03.K().q().W().T();
                if (TextUtils.isEmpty(T)) {
                    T = "NA";
                }
                JSONObject jSONObject = a63Var.o;
                if (jSONObject != null && jSONObject.keys() != null) {
                    if (x23.b) {
                        Log.i("OpenAppAction", "source: " + T + " openUrl:" + str + " 配置数据:" + jSONObject);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("scene");
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("package_name");
                    int length = optJSONArray == null ? 0 : optJSONArray.length();
                    if (length > 0) {
                        boolean z = false;
                        for (int i = 0; i < length; i++) {
                            if (T.equals(optJSONArray.optString(i))) {
                                z = true;
                            }
                        }
                        return z && n(str, optJSONArray2);
                    }
                    return n(str, optJSONArray2);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean n(String str, JSONArray jSONArray) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, jSONArray)) == null) {
            int length = jSONArray == null ? 0 : jSONArray.length();
            if (length > 0 && !TextUtils.isEmpty(str)) {
                for (int i = 0; i < length; i++) {
                    String optString = jSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        String decode = Uri.decode(optString);
                        int indexOf = decode.indexOf(":");
                        if (indexOf > 0) {
                            decode = decode.substring(0, indexOf);
                        }
                        if (str.startsWith(decode)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean o(Context context, String str, CallbackHandler callbackHandler, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, context, str, callbackHandler, str2, str3)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return false;
            }
            return ue3.Z(context, str, new b(this, callbackHandler, str2, str3, str));
        }
        return invokeLLLLL.booleanValue;
    }
}
