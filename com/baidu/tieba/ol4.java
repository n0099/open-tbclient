package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidubce.AbstractBceClient;
import java.util.Map;
import okhttp3.MediaType;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ol4 extends gk4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Map<String, String> map, Map<String, String> map2, kk4<String> kk4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65536, null, str, map, map2, kk4Var) != null) || d(str, kk4Var)) {
            return;
        }
        c(hi4.g().getRequest(), str, map, map2, kk4Var);
    }

    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, kk4<String> kk4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65537, null, str, map, map2, jSONObject, kk4Var) != null) || d(str, kk4Var)) {
            return;
        }
        di4 postStringRequest = hi4.g().postStringRequest();
        pi4.a(postStringRequest, map);
        postStringRequest.content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6);
        c(postStringRequest, str, map, map2, kk4Var);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.baidu.searchbox.http.request.HttpRequestBuilder] */
    public static void c(HttpRequestBuilder<?> httpRequestBuilder, String str, Map<String, String> map, Map<String, String> map2, kk4<String> kk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, httpRequestBuilder, str, map, map2, kk4Var) == null) {
            httpRequestBuilder.url(lk4.j(str, map)).requestSubFrom(10).addHeaders(map2).userAgent(gk4.b).cookieManager(gk4.a).enableStat(true).build().executeStat(kk4Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean d(String str, kk4<String> kk4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, kk4Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (kk4Var != null) {
                kk4Var.onStart();
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
