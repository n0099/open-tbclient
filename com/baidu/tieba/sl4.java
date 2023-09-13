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
/* loaded from: classes8.dex */
public class sl4 extends kk4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Map<String, String> map, Map<String, String> map2, ok4<String> ok4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65536, null, str, map, map2, ok4Var) != null) || d(str, ok4Var)) {
            return;
        }
        c(li4.g().getRequest(), str, map, map2, ok4Var);
    }

    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, ok4<String> ok4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65537, null, str, map, map2, jSONObject, ok4Var) != null) || d(str, ok4Var)) {
            return;
        }
        hi4 postStringRequest = li4.g().postStringRequest();
        ti4.a(postStringRequest, map);
        postStringRequest.content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6);
        c(postStringRequest, str, map, map2, ok4Var);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.baidu.searchbox.http.request.HttpRequestBuilder] */
    public static void c(HttpRequestBuilder<?> httpRequestBuilder, String str, Map<String, String> map, Map<String, String> map2, ok4<String> ok4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, httpRequestBuilder, str, map, map2, ok4Var) == null) {
            httpRequestBuilder.url(pk4.j(str, map)).requestSubFrom(10).addHeaders(map2).userAgent(kk4.b).cookieManager(kk4.a).enableStat(true).build().executeStat(ok4Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean d(String str, ok4<String> ok4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, ok4Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (ok4Var != null) {
                ok4Var.onStart();
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
