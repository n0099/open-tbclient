package com.baidu.webkit.logsdk.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDjTe6LTkPFvWowhciLFGS+nqhc\nhfaYCwBhVIkmZXNNiqdBMcNBUmqaAIKYB8lh1+UFf/KmuO14QbAKqzE/FjHWAV51\n68IJCk+DLxu885hYRiNH+kJDRuzDVMOv4NudroOwY1zB3c8VOjjLuz7xE7rRet7d\nAjH9k8YPZuedladalwIDAQAB";
    public static String c = "1_0";
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public HashMap<String, a> d;
    public HashMap<String, String> e;
    public HashMap<String, c> f;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new HashMap<>();
        this.e = new HashMap<>();
        this.f = new HashMap<>();
        this.d.clear();
        this.e.clear();
    }

    public static SharedPreferences a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? com.baidu.webkit.logsdk.a.b.d().getSharedPreferences("log_config_pref", 0) : (SharedPreferences) invokeV.objValue;
    }

    public static a a(String str, int i, JSONObject jSONObject) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, str, i, jSONObject)) == null) {
            a aVar = new a(str);
            aVar.d = d();
            aVar.c = f();
            String str2 = "full";
            if (jSONObject != null && jSONObject.length() > 0) {
                i = jSONObject.optInt("log_level", i);
                str2 = jSONObject.optString(EditNickNameActivityConfig.PARAM_TYPE, "full");
            }
            aVar.b = i;
            aVar.e = str2;
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "createConfig type = " + str + ", level = " + i + ", params = " + str2);
            if (i == 3) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? a().getInt(DpStatConstants.KEY_NET_LEVEL, 3) : invokeV.intValue;
    }

    public static long b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? a().getLong("upload_".concat(String.valueOf(str)), 0L) : invokeL.longValue;
    }

    public static long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a().getLong(com.alipay.sdk.data.a.O, 604800000L) : invokeV.longValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? a().getString("publickey", b) : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? a().getString("f1", "1_0") : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? a().getString("f2", c) : (String) invokeV.objValue;
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
            if (this.d.containsKey(str)) {
                return this.d.get(str);
            }
            SharedPreferences a = a();
            int i = 1;
            if ("frame_pv".equals(str)) {
                i = 2;
            } else if ("frame_event".equals(str)) {
                i = 3;
            }
            try {
                str2 = a.getString(str, "");
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "getConfig = ".concat(String.valueOf(str2)));
            } catch (ClassCastException unused) {
                i = a.getInt(str, i);
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "getConfig level = ".concat(String.valueOf(str2)));
            }
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(str2);
            } catch (JSONException e) {
                com.baidu.webkit.logsdk.d.c.a(e);
            }
            a a2 = a(str, i, jSONObject);
            this.d.put(str, a2);
            return a2;
        }
        return (a) invokeL.objValue;
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.d.put(aVar.a, aVar);
        }
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.e.put(str, str2);
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
                if (jSONObject3.has(TtmlNode.TAG_BODY)) {
                    JSONArray jSONArray = jSONObject3.getJSONArray(TtmlNode.TAG_BODY);
                    cVar.b(jSONArray);
                    editor.putString(next + "@body", jSONArray.toString());
                }
                if (jSONObject3.has("url")) {
                    JSONArray jSONArray2 = jSONObject3.getJSONArray("url");
                    cVar.a(jSONArray2);
                    editor.putString(next + "@url", jSONArray2.toString());
                }
                this.f.put(next, cVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(JSONObject jSONObject, boolean z, SharedPreferences.Editor editor) throws JSONException {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{jSONObject, Boolean.valueOf(z), editor}) == null) && jSONObject.has("array")) {
            JSONArray jSONArray = jSONObject.getJSONArray("array");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                if (jSONObject2.has("log_type")) {
                    String string = jSONObject2.getString("log_type");
                    if (!TextUtils.isEmpty(string)) {
                        int i3 = 1;
                        if (z && jSONObject2.has("master")) {
                            String string2 = jSONObject2.getString("master");
                            if (!TextUtils.isEmpty(string2)) {
                                i = !string2.equals("0");
                                JSONObject jSONObject3 = new JSONObject();
                                if (i > 0 || !jSONObject2.has("log_level") || ((i = jSONObject2.getInt("log_level")) >= 0 && i <= 3)) {
                                    i3 = i;
                                }
                                jSONObject3.put("log_level", i3);
                                if (jSONObject2.has(EditNickNameActivityConfig.PARAM_TYPE)) {
                                    String string3 = jSONObject2.getString(EditNickNameActivityConfig.PARAM_TYPE);
                                    if (TextUtils.isEmpty(string3)) {
                                        string3 = "full";
                                    }
                                    jSONObject3.put(EditNickNameActivityConfig.PARAM_TYPE, string3);
                                }
                                editor.putString(string, jSONObject3.toString());
                                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "setConfig: " + string + " = " + i3 + ", extra = " + jSONObject3);
                                this.d.put(string, a(string, i3, jSONObject3));
                            }
                        }
                        i = z ? 1 : 0;
                        JSONObject jSONObject32 = new JSONObject();
                        if (i > 0) {
                        }
                        i3 = i;
                        jSONObject32.put("log_level", i3);
                        if (jSONObject2.has(EditNickNameActivityConfig.PARAM_TYPE)) {
                        }
                        editor.putString(string, jSONObject32.toString());
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "setConfig: " + string + " = " + i3 + ", extra = " + jSONObject32);
                        this.d.put(string, a(string, i3, jSONObject32));
                    }
                }
            }
        }
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.e.get(str) : (String) invokeL.objValue;
    }

    public final c d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (this.f.containsKey(str)) {
                return this.f.get(str);
            }
            SharedPreferences a = a();
            String string = a.getString(str + "@body", "");
            String string2 = a.getString(str + "@url", "");
            if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2)) {
                try {
                    c cVar = new c(str);
                    cVar.b(new JSONArray(string));
                    cVar.a(new JSONArray(string2));
                    this.f.put(str, cVar);
                    return cVar;
                } catch (JSONException e) {
                    com.baidu.webkit.logsdk.d.c.a(e);
                }
            }
            return new c("full");
        }
        return (c) invokeL.objValue;
    }
}
