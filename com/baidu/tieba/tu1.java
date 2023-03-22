package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class tu1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mm3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public a(mm3 mm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mm3Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.a.a(null);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                tu1.i(response, this.a);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mm3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public b(mm3 mm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mm3Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.a.a(null);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                tu1.g(response, this.a);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948193593, "Lcom/baidu/tieba/tu1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948193593, "Lcom/baidu/tieba/tu1;");
                return;
            }
        }
        a = do1.a;
    }

    @Nullable
    public static Request c(t73 t73Var, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, t73Var, jSONObject, unitedSchemeEntity)) == null) {
            if (jSONObject == null) {
                q(unitedSchemeEntity, 202, "illegal entity");
                return null;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("stringMap");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("fileMap");
            String optString = jSONObject.optString("service");
            String optString2 = jSONObject.optString("api");
            if (t73Var != null && optJSONObject != null && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    type.addFormDataPart(next, optJSONObject.optString(next));
                }
                if (optJSONObject2 != null) {
                    Iterator<String> keys2 = optJSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        String M = bf3.M(optJSONObject2.optString(next2), t73.g0());
                        if (!TextUtils.isEmpty(M)) {
                            File file = new File(M);
                            if (!file.exists()) {
                                q(unitedSchemeEntity, 1001, "upload file not exist");
                                return null;
                            } else if (file.length() > Config.FULL_TRACE_LOG_LIMIT) {
                                q(unitedSchemeEntity, 1001, "upload file too large");
                                return null;
                            } else {
                                type.addFormDataPart(next2, file.getName(), new av1(file));
                            }
                        }
                    }
                }
                String O = t73Var.O();
                long a2 = ar2.l().a(AppRuntime.getAppContext());
                String r = r(optJSONObject, O, a2, ar2.h0().f(AppRuntime.getAppContext()));
                if (r == null) {
                    q(unitedSchemeEntity, 1001, "sign error");
                    return null;
                }
                HttpUrl parse = HttpUrl.parse(ar2.m().processUrl(ar2.o().O() + "/" + optString + optString2));
                if (parse == null) {
                    q(unitedSchemeEntity, 1001, "request url error");
                    return null;
                }
                HttpUrl.Builder newBuilder = parse.newBuilder();
                newBuilder.addQueryParameter("ai_sign", r);
                newBuilder.addQueryParameter("api_key", O);
                newBuilder.addQueryParameter("timestamp", String.valueOf(a2));
                newBuilder.addQueryParameter("host_app", ef4.b().c());
                newBuilder.addQueryParameter("host_app_ver", ef4.b().h());
                newBuilder.addQueryParameter("sdk_ver", ef4.b().b());
                newBuilder.addQueryParameter("host_os", un4.f());
                newBuilder.addQueryParameter("host_os_ver", un4.g());
                Request.Builder post = new Request.Builder().url(newBuilder.build()).post(type.build());
                String d = ar2.h0().d(AppRuntime.getAppContext());
                String str = "BDUSS=" + d;
                if (!TextUtils.isEmpty(d)) {
                    post.addHeader("Cookie", str);
                }
                return post.build();
            }
            q(unitedSchemeEntity, 202, "illegal request");
            return null;
        }
        return (Request) invokeLLL.objValue;
    }

    public static void d(String str, mm3<String> mm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, mm3Var) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("cloud")) {
                URI create = URI.create(str);
                String host = create.getHost();
                if (TextUtils.isEmpty(create.toString()) && TextUtils.isEmpty(host)) {
                    mm3Var.a(null);
                    return;
                }
                Request c = c(t73.M(), h(str), null);
                if (t73.M() == null) {
                    mm3Var.a(null);
                    return;
                } else {
                    p(c.url().toString(), c.body(), new a(mm3Var));
                    return;
                }
            }
            mm3Var.a(null);
        }
    }

    public static void g(Response response, mm3<String> mm3Var) {
        String header;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65543, null, response, mm3Var) == null) && (header = response.header("Content-Type", "")) != null && header.contains("application/json")) {
            JSONObject jSONObject = new JSONObject();
            if (response.body() != null) {
                try {
                    jSONObject = new JSONObject(response.body().string());
                } catch (IOException e) {
                    if (a) {
                        e.printStackTrace();
                    }
                    mm3Var.a(null);
                } catch (JSONException e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                    mm3Var.a(null);
                }
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("fileList");
            if (optJSONArray == null) {
                mm3Var.a(null);
            } else {
                mm3Var.a(optJSONArray.toString());
            }
        }
    }

    public static void e(JSONArray jSONArray, mm3<String> mm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, jSONArray, mm3Var) == null) {
            if (jSONArray != null && jSONArray.length() > 0) {
                Request c = c(t73.M(), f(jSONArray.toString()), null);
                if (t73.M() == null) {
                    mm3Var.a(null);
                    return;
                } else {
                    p(c.url().toString(), c.body(), new b(mm3Var));
                    return;
                }
            }
            mm3Var.a(null);
        }
    }

    public static void i(Response response, mm3<String> mm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, response, mm3Var) == null) {
            try {
                String header = response.header("Content-Type", "");
                if (header != null && header.contains("application/json")) {
                    JSONObject jSONObject = new JSONObject();
                    if (response.body() != null) {
                        jSONObject = new JSONObject(response.body().string());
                    }
                    String optString = jSONObject.optString("DownloadUrl");
                    if (!TextUtils.isEmpty(optString)) {
                        mm3Var.a(optString);
                    } else {
                        mm3Var.a(null);
                    }
                }
            } catch (Exception unused) {
                mm3Var.a(null);
            }
        }
    }

    public static JSONObject l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject2.put("fileID", str2);
                    jSONObject.put("api", "/v1/workspace/storage/request-download");
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("api", "/v1/workspace/storage/batch-download");
                    jSONObject2.put("fileList", str);
                }
                jSONObject.put("service", "cloud");
                jSONObject.put("stringMap", jSONObject2);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static JSONObject f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            return l(str, null);
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            return l(null, str);
        }
        return (JSONObject) invokeL.objValue;
    }

    public static int j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 1001;
            }
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                if (a) {
                    e.printStackTrace();
                }
                return 1001;
            }
        }
        return invokeL.intValue;
    }

    public static String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "请求失败";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (j(str) != 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static JSONObject m(Response response) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, response)) == null) {
            try {
                if (response.body() != null) {
                    str = response.body().string();
                } else {
                    str = null;
                }
                return new JSONObject(str);
            } catch (IOException e) {
                if (a) {
                    e.printStackTrace();
                }
                return null;
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject n(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, str, str2, str3)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, str3);
                jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, 200);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("fileID", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("tempFilePath", str2);
                }
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public static void p(String str, RequestBody requestBody, ResponseCallback responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, str, requestBody, responseCallback) == null) {
            we4 we4Var = new we4(str, requestBody, responseCallback);
            we4Var.f = true;
            we4Var.g = true;
            we4Var.h = true;
            xe4.g().e(we4Var);
        }
    }

    public static void q(UnitedSchemeEntity unitedSchemeEntity, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65553, null, unitedSchemeEntity, i, str) != null) || unitedSchemeEntity == null) {
            return;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(i, str);
    }

    public static String r(JSONObject jSONObject, String str, long j, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{jSONObject, str, Long.valueOf(j), str2})) == null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                ArrayList<String> arrayList = new ArrayList();
                while (keys.hasNext()) {
                    arrayList.add(keys.next());
                }
                Collections.sort(arrayList);
                StringBuilder sb = new StringBuilder();
                for (String str3 : arrayList) {
                    String optString = jSONObject.optString(str3);
                    sb.append(URLEncoder.encode(str3));
                    sb.append("=");
                    sb.append(URLEncoder.encode(optString));
                    sb.append("&");
                }
                String sb2 = sb.toString();
                if (sb2.endsWith("&")) {
                    sb2 = sb2.substring(0, sb2.length() - 1);
                }
                String d = zn4.d(sb2.getBytes(), false);
                byte[] copyOf = Arrays.copyOf(Base64.decode(zn4.d(str.getBytes(), false), 0), 24);
                byte[] copyOf2 = Arrays.copyOf(Base64.decode(zn4.d(String.format("%s%d", str2, Long.valueOf(j)).getBytes(), false).getBytes(), 0), 16);
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                cipher.init(1, new SecretKeySpec(copyOf, "AES"), new IvParameterSpec(copyOf2));
                String str4 = new String(Base64.encode(cipher.doFinal(d.getBytes()), 0), StandardCharsets.UTF_8);
                if (str4.endsWith("\n")) {
                    return str4.substring(0, str4.length() - 1);
                }
                return str4;
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeCommon.objValue;
    }
}
