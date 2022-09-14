package com.baidu.ufosdk;

import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes6.dex */
public class d0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Charset a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1174230506, "Lcom/baidu/ufosdk/d0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1174230506, "Lcom/baidu/ufosdk/d0;");
                return;
            }
        }
        a = StandardCharsets.UTF_8;
    }

    public static RequestBody a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            FormBody.Builder builder = new FormBody.Builder(a);
            if (map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    builder.add(entry.getKey(), entry.getValue());
                }
            }
            return builder.build();
        }
        return (RequestBody) invokeL.objValue;
    }

    public static String a(String str, RequestBody requestBody) {
        InterceptResult invokeLL;
        ResponseBody body;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, requestBody)) == null) {
            try {
                Request.Builder addHeader = new Request.Builder().url(str).post(requestBody).addHeader("Accept-Charset", IMAudioTransRequest.CHARSET).addHeader(CameraActivityConfig.KEY_CONTENT_TYPE, IMAudioTransRequest.CHARSET);
                if (b == null) {
                    b = "UfoSDK/4.1.9.1 (" + c.a() + " " + c.b() + SmallTailInfo.EMOTION_SUFFIX;
                }
                Response execute = new OkHttpClient().newBuilder().connectTimeout(3L, TimeUnit.SECONDS).readTimeout(5L, TimeUnit.SECONDS).build().newCall(addHeader.addHeader("User-Agent", b).build()).execute();
                return (execute == null || !execute.isSuccessful() || (body = execute.body()) == null) ? "" : body.string();
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }
}
