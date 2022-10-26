package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidubce.AbstractBceClient;
import java.util.Map;
import okhttp3.MediaType;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class xd4 extends pc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Map map, Map map2, tc4 tc4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65536, null, str, map, map2, tc4Var) != null) || d(str, tc4Var)) {
            return;
        }
        c(qa4.g().getRequest(), str, map, map2, tc4Var);
    }

    public static void b(String str, Map map, Map map2, JSONObject jSONObject, tc4 tc4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65537, null, str, map, map2, jSONObject, tc4Var) != null) || d(str, tc4Var)) {
            return;
        }
        ma4 postStringRequest = qa4.g().postStringRequest();
        ya4.a(postStringRequest, map);
        postStringRequest.content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6);
        c(postStringRequest, str, map, map2, tc4Var);
    }

    public static void c(HttpRequestBuilder httpRequestBuilder, String str, Map map, Map map2, tc4 tc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, httpRequestBuilder, str, map, map2, tc4Var) == null) {
            httpRequestBuilder.url(uc4.j(str, map)).requestSubFrom(10).addHeaders(map2).userAgent(pc4.b).cookieManager(pc4.a).enableStat(true).build().executeStat(tc4Var);
        }
    }

    public static boolean d(String str, tc4 tc4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, tc4Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (tc4Var != null) {
                tc4Var.onStart();
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
