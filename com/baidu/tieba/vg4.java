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
public class vg4 extends nf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Map<String, String> map, Map<String, String> map2, rf4<String> rf4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65536, null, str, map, map2, rf4Var) != null) || d(str, rf4Var)) {
            return;
        }
        c(od4.g().getRequest(), str, map, map2, rf4Var);
    }

    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, rf4<String> rf4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65537, null, str, map, map2, jSONObject, rf4Var) != null) || d(str, rf4Var)) {
            return;
        }
        kd4 postStringRequest = od4.g().postStringRequest();
        wd4.a(postStringRequest, map);
        postStringRequest.content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6);
        c(postStringRequest, str, map, map2, rf4Var);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.baidu.searchbox.http.request.HttpRequestBuilder] */
    public static void c(HttpRequestBuilder<?> httpRequestBuilder, String str, Map<String, String> map, Map<String, String> map2, rf4<String> rf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, httpRequestBuilder, str, map, map2, rf4Var) == null) {
            httpRequestBuilder.url(sf4.j(str, map)).requestSubFrom(10).addHeaders(map2).userAgent(nf4.b).cookieManager(nf4.a).enableStat(true).build().executeStat(rf4Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean d(String str, rf4<String> rf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, rf4Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (rf4Var != null) {
                rf4Var.onStart();
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
