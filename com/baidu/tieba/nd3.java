package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.tieba.wp3;
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
/* loaded from: classes7.dex */
public class nd3 extends zd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements vq3<ch3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ JSONObject e;
        public final /* synthetic */ String f;
        public final /* synthetic */ nd3 g;

        public a(nd3 nd3Var, CallbackHandler callbackHandler, String str, String str2, Context context, JSONObject jSONObject, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd3Var, callbackHandler, str, str2, context, jSONObject, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = nd3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
            this.d = context;
            this.e = jSONObject;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(ch3 ch3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ch3Var) == null) {
                if (ch3Var != null && !ch3Var.d) {
                    if (this.g.m(ch3Var, this.c)) {
                        this.g.l(this.d, this.e, this.a, this.b, this.f);
                        return;
                    } else {
                        this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1003, "打开APP失败，打开App条件未满足").toString());
                        return;
                    }
                }
                if (zd3.b) {
                    Log.i("OpenAppAction", "no configuration of authority");
                }
                ah3.o(10005, this.a, this.b);
                vi3.r(10005, ch3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements wp3.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public b(nd3 nd3Var, CallbackHandler callbackHandler, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd3Var, callbackHandler, str, str2, str3};
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

        @Override // com.baidu.tieba.wp3.g
        public void a(boolean z) {
            int i;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    i = 0;
                } else {
                    i = 1001;
                }
                if (z) {
                    str = "打开APP成功";
                } else {
                    str = "打开APP失败，本地没有安装";
                }
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(i, str).toString());
                c.a("open", this.c, "confirm", this.d);
            }
        }

        @Override // com.baidu.tieba.wp3.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1004, "取消打开APP").toString());
                c.a("open", this.c, "cancel", this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(String str, String str2, String str3, String str4) {
            String str5;
            String str6;
            String str7;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(65536, null, str, str2, str3, str4) == null) {
                ej3 ej3Var = new ej3();
                cc3 b0 = cc3.b0();
                String str8 = "";
                if (b0 == null) {
                    str5 = "";
                    str6 = str5;
                    str7 = str6;
                } else {
                    str8 = vi3.n(b0.k());
                    str6 = b0.getAppId();
                    str7 = b0.Z();
                    str5 = b0.W().T();
                }
                String a = jv2.n().a();
                ej3Var.a = str8;
                ej3Var.b = str;
                ej3Var.e = str2;
                ej3Var.f = str6;
                ej3Var.c = str5;
                ej3Var.a("appName", str7);
                ej3Var.a("hostName", a);
                ej3Var.a("hostVersion", wp3.D());
                ej3Var.a(PushConstants.CLICK_TYPE, str3);
                try {
                    str4 = URLDecoder.decode(str4, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                }
                ej3Var.a("scheme", str4);
                ji3.i("2572", "90", ej3Var.f());
                if (zd3.b) {
                    Log.d("OpenAppAction", String.format("ubcId=%s && ceresId=%s , content:%s ", "2572", "90", ej3Var.f()));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nd3(zc3 zc3Var) {
        super(zc3Var, "/swanAPI/openApp");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zc3Var};
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

    @Override // com.baidu.tieba.zd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, cc3Var)) == null) {
            if (!jv2.a().d()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            } else if (cc3Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            } else {
                JSONObject a2 = zd3.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "invalid params");
                    return false;
                }
                String optString = a2.optString("cb");
                if (zd3.b) {
                    Log.i("OpenAppAction", "params is " + a2.toString());
                }
                String optString2 = a2.optString("open", "");
                String optString3 = a2.optString("invokeFrom", "");
                c.a(DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST, optString3, null, optString2);
                if (optString2.startsWith(BaiduIdentityManager.VALUE_OSNAME)) {
                    if (!jv2.a().c()) {
                        ub3.f(context, R.string.obfuscated_res_0x7f0f147b).G();
                        return false;
                    }
                    l(context, a2, callbackHandler, optString, optString3);
                } else {
                    cc3Var.e0().e("scope_open_app", new a(this, callbackHandler, optString, optString2, context, a2, optString3));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, callbackHandler, str, str2) == null) {
            String optString = jSONObject.optString("open");
            int i = 0;
            if (!TextUtils.isEmpty(optString)) {
                optString = Uri.decode(optString);
                jv2.P().a(optString, jSONObject.optJSONObject("extraParams"));
                if (zd3.b) {
                    Log.i("OpenAppAction", "openUrl:" + optString);
                }
                z = o(context, optString, callbackHandler, str, str2);
            } else {
                z = false;
            }
            boolean optBoolean = jSONObject.optBoolean("isNeedDownload", true);
            if (zd3.b) {
                Log.i("OpenAppAction", "open app result=" + z + "\nisNeedDownload=" + optBoolean);
            }
            if (!optBoolean) {
                if (!z) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1002, "打开APP失败，本地没有安装").toString());
                }
            } else if (!z) {
                boolean e = wp3.e(context, jSONObject.optString("download"));
                if (!e) {
                    i = 1001;
                }
                if (e) {
                    str3 = "下载APP成功";
                } else {
                    str3 = "下载APP失败";
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i, str3).toString());
                c.a("download", str2, null, optString);
            }
        }
    }

    public final boolean m(ch3 ch3Var, String str) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ch3Var, str)) == null) {
            if (ch3Var != null && !TextUtils.isEmpty(str)) {
                String T2 = bc3.K().q().W().T();
                if (TextUtils.isEmpty(T2)) {
                    T2 = "NA";
                }
                JSONObject jSONObject = ch3Var.o;
                if (jSONObject != null && jSONObject.keys() != null) {
                    if (zd3.b) {
                        Log.i("OpenAppAction", "source: " + T2 + " openUrl:" + str + " 配置数据:" + jSONObject);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("scene");
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("package_name");
                    if (optJSONArray == null) {
                        length = 0;
                    } else {
                        length = optJSONArray.length();
                    }
                    if (length > 0) {
                        boolean z = false;
                        for (int i = 0; i < length; i++) {
                            if (T2.equals(optJSONArray.optString(i))) {
                                z = true;
                            }
                        }
                        if (!z || !n(str, optJSONArray2)) {
                            return false;
                        }
                        return true;
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
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, jSONArray)) == null) {
            if (jSONArray == null) {
                length = 0;
            } else {
                length = jSONArray.length();
            }
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
            if (context != null && !TextUtils.isEmpty(str)) {
                return wp3.Z(context, str, new b(this, callbackHandler, str2, str3, str));
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }
}
