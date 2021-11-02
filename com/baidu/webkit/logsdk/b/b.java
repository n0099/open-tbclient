package com.baidu.webkit.logsdk.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f61061b = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDjTe6LTkPFvWowhciLFGS+nqhc\nhfaYCwBhVIkmZXNNiqdBMcNBUmqaAIKYB8lh1+UFf/KmuO14QbAKqzE/FjHWAV51\n68IJCk+DLxu885hYRiNH+kJDRuzDVMOv4NudroOwY1zB3c8VOjjLuz7xE7rRet7d\nAjH9k8YPZuedladalwIDAQAB";

    /* renamed from: c  reason: collision with root package name */
    public static String f61062c = "1_0";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f61063a;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, a> f61064d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f61065e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, c> f61066f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1207449824, "Lcom/baidu/webkit/logsdk/b/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1207449824, "Lcom/baidu/webkit/logsdk/b/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f61064d = new HashMap<>();
        this.f61065e = new HashMap<>();
        this.f61066f = new HashMap<>();
        this.f61064d.clear();
        this.f61065e.clear();
    }

    public static SharedPreferences a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? com.baidu.webkit.logsdk.a.b.d().getSharedPreferences("log_config_pref", 0) : (SharedPreferences) invokeV.objValue;
    }

    public static a a(String str, int i2, JSONObject jSONObject) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, str, i2, jSONObject)) == null) {
            a aVar = new a(str);
            aVar.f61059d = d();
            aVar.f61058c = f();
            String str2 = "full";
            if (jSONObject != null && jSONObject.length() > 0) {
                i2 = jSONObject.optInt("log_level", i2);
                str2 = jSONObject.optString(EditNickNameActivityConfig.PARAM_TYPE, "full");
            }
            aVar.f61057b = i2;
            aVar.f61060e = str2;
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "createConfig type = " + str + ", level = " + i2 + ", params = " + str2);
            if (i2 == 3) {
                com.baidu.webkit.logsdk.a.b.a().h().b().a(str, false);
            }
            return aVar;
        }
        return (a) invokeLIL.objValue;
    }

    public static void a(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, j) == null) {
            SharedPreferences.Editor edit = a().edit();
            edit.putLong("upload_".concat(String.valueOf(str)), j);
            edit.apply();
        }
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? a().getInt(DpStatConstants.KEY_NET_LEVEL, 3) : invokeV.intValue;
    }

    public static long b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? a().getLong("upload_".concat(String.valueOf(str)), 0L) : invokeL.longValue;
    }

    public static long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a().getLong("timeout", 604800000L) : invokeV.longValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? a().getString("publickey", f61061b) : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? a().getString("f1", "1_0") : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? a().getString("f2", f61062c) : (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? a().getString("f3", "") : (String) invokeV.objValue;
    }

    public final a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str2 = "";
            if (this.f61064d.containsKey(str)) {
                return this.f61064d.get(str);
            }
            SharedPreferences a2 = a();
            int i2 = 1;
            if ("frame_pv".equals(str)) {
                i2 = 2;
            } else if ("frame_event".equals(str)) {
                i2 = 3;
            }
            try {
                str2 = a2.getString(str, "");
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "getConfig = ".concat(String.valueOf(str2)));
            } catch (ClassCastException unused) {
                i2 = a2.getInt(str, i2);
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "getConfig level = ".concat(String.valueOf(str2)));
            }
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(str2);
            } catch (JSONException e2) {
                com.baidu.webkit.logsdk.d.c.a(e2);
            }
            a a3 = a(str, i2, jSONObject);
            this.f61064d.put(str, a3);
            return a3;
        }
        return (a) invokeL.objValue;
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f61064d.put(aVar.f61056a, aVar);
        }
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f61065e.put(str, str2);
    }

    public final void a(JSONObject jSONObject, SharedPreferences.Editor editor) throws JSONException {
        JSONObject jSONObject2;
        Iterator<String> keys;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, jSONObject, editor) == null) && jSONObject.has("params") && (keys = (jSONObject2 = jSONObject.getJSONObject("params")).keys()) != null) {
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                c cVar = new c(next);
                if (jSONObject3.has("body")) {
                    JSONArray jSONArray = jSONObject3.getJSONArray("body");
                    cVar.b(jSONArray);
                    editor.putString(next + "@body", jSONArray.toString());
                }
                if (jSONObject3.has("url")) {
                    JSONArray jSONArray2 = jSONObject3.getJSONArray("url");
                    cVar.a(jSONArray2);
                    editor.putString(next + "@url", jSONArray2.toString());
                }
                this.f61066f.put(next, cVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(JSONObject jSONObject, boolean z, SharedPreferences.Editor editor) throws JSONException {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{jSONObject, Boolean.valueOf(z), editor}) == null) && jSONObject.has("array")) {
            JSONArray jSONArray = jSONObject.getJSONArray("array");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                if (jSONObject2.has("log_type")) {
                    String string = jSONObject2.getString("log_type");
                    if (!TextUtils.isEmpty(string)) {
                        int i4 = 1;
                        if (z && jSONObject2.has("master")) {
                            String string2 = jSONObject2.getString("master");
                            if (!TextUtils.isEmpty(string2)) {
                                i2 = !string2.equals("0");
                                JSONObject jSONObject3 = new JSONObject();
                                if (i2 > 0 || !jSONObject2.has("log_level") || ((i2 = jSONObject2.getInt("log_level")) >= 0 && i2 <= 3)) {
                                    i4 = i2;
                                }
                                jSONObject3.put("log_level", i4);
                                if (jSONObject2.has(EditNickNameActivityConfig.PARAM_TYPE)) {
                                    String string3 = jSONObject2.getString(EditNickNameActivityConfig.PARAM_TYPE);
                                    if (TextUtils.isEmpty(string3)) {
                                        string3 = "full";
                                    }
                                    jSONObject3.put(EditNickNameActivityConfig.PARAM_TYPE, string3);
                                }
                                editor.putString(string, jSONObject3.toString());
                                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "setConfig: " + string + " = " + i4 + ", extra = " + jSONObject3);
                                this.f61064d.put(string, a(string, i4, jSONObject3));
                            }
                        }
                        i2 = z ? 1 : 0;
                        JSONObject jSONObject32 = new JSONObject();
                        if (i2 > 0) {
                        }
                        i4 = i2;
                        jSONObject32.put("log_level", i4);
                        if (jSONObject2.has(EditNickNameActivityConfig.PARAM_TYPE)) {
                        }
                        editor.putString(string, jSONObject32.toString());
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "setConfig: " + string + " = " + i4 + ", extra = " + jSONObject32);
                        this.f61064d.put(string, a(string, i4, jSONObject32));
                    }
                }
            }
        }
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.f61065e.get(str) : (String) invokeL.objValue;
    }

    public final c d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (this.f61066f.containsKey(str)) {
                return this.f61066f.get(str);
            }
            SharedPreferences a2 = a();
            String string = a2.getString(str + "@body", "");
            String string2 = a2.getString(str + "@url", "");
            if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2)) {
                try {
                    c cVar = new c(str);
                    cVar.b(new JSONArray(string));
                    cVar.a(new JSONArray(string2));
                    this.f61066f.put(str, cVar);
                    return cVar;
                } catch (JSONException e2) {
                    com.baidu.webkit.logsdk.d.c.a(e2);
                }
            }
            return new c("full");
        }
        return (c) invokeL.objValue;
    }
}
