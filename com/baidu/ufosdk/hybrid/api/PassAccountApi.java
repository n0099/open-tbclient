package com.baidu.ufosdk.hybrid.api;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.o;
import com.baidu.ufosdk.p;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PassAccountApi implements IBridgeApi {
    public static /* synthetic */ Interceptable $ic;
    public static Class<?> a;
    public static Object b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface b {
    }

    /* loaded from: classes7.dex */
    public static class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public PassAccountApi() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void combineLogin(Context context, p pVar, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, pVar, oVar) == null) {
            try {
                if (b == null) {
                    oVar.a("10103", "passport env disallow");
                }
                if (((Boolean) a.getMethod("isLogin", new Class[0]).invoke(b, new Object[0])).booleanValue()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("status", "1");
                    String str = (String) a.getMethod("getLoginInfo", new Class[0]).invoke(b, new Object[0]);
                    if (!TextUtils.isEmpty(str)) {
                        JSONObject jSONObject2 = new JSONObject(str);
                        jSONObject.put(TbEnum.SystemMessage.KEY_USER_NAME, jSONObject2.optString("displayname"));
                        jSONObject.put("uid", jSONObject2.optString("uid"));
                        jSONObject.put("bduss", jSONObject2.optString("bduss"));
                        jSONObject.put("nickName", jSONObject2.optString("nickname"));
                    }
                    oVar.a(jSONObject);
                    return;
                }
                a.getMethod("openLogin", Activity.class, b.class).invoke(b, (Activity) context, new a(oVar));
            } catch (Throwable unused) {
                oVar.a("10102", "Unknow Exception!");
            }
        }
    }

    public static void getLoginInfo(Context context, p pVar, o oVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, pVar, oVar) == null) {
            try {
                if (b == null) {
                    oVar.a("10103", "passport env disallow");
                }
                String str2 = (String) a.getMethod("getLoginInfo", new Class[0]).invoke(b, new Object[0]);
                JSONObject jSONObject = new JSONObject();
                if (TextUtils.isEmpty(str2)) {
                    str = "0";
                } else {
                    str = "1";
                }
                jSONObject.put("status", str);
                if (!TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    jSONObject.put(TbEnum.SystemMessage.KEY_USER_NAME, jSONObject2.optString("displayname"));
                    jSONObject.put("uid", jSONObject2.optString("uid"));
                    jSONObject.put("bduss", jSONObject2.optString("bduss"));
                    jSONObject.put("nickName", jSONObject2.optString("nickname"));
                }
                oVar.a(jSONObject);
            } catch (Throwable th) {
                th.printStackTrace();
                oVar.a("10102", "Unknow Exception!");
            }
        }
    }

    public static void isAccoutLogin(Context context, p pVar, o oVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, pVar, oVar) == null) {
            try {
                if (b == null) {
                    oVar.a("10103", "passport env disallow");
                }
                boolean booleanValue = ((Boolean) a.getMethod("isLogin", new Class[0]).invoke(b, new Object[0])).booleanValue();
                JSONObject jSONObject = new JSONObject();
                if (booleanValue) {
                    str = "1";
                } else {
                    str = "0";
                }
                jSONObject.put("status", str);
                oVar.a(jSONObject);
            } catch (Throwable unused) {
                oVar.a("10102", "Unknow Exception!");
            }
        }
    }

    public static void isEnvAllow(Context context, p pVar, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, pVar, oVar) == null) {
            try {
                Class<?> cls = Class.forName("com.baidu.ufosdk.plugin.PluginAccountManager");
                a = cls;
                Object invoke = cls.getMethod("getInstance", Context.class).invoke(null, context);
                b = invoke;
                if (invoke != null) {
                    oVar.a((JSONObject) null);
                }
            } catch (Throwable unused) {
                oVar.a("10103", "passport env disallow");
            }
        }
    }
}
