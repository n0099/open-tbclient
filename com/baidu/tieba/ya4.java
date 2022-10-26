package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.searchbox.http.request.PostByteRequest;
import com.baidu.searchbox.http.request.PostStringRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes6.dex */
public class ya4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Object obj, Map map) {
        String str;
        int parseInt;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, obj, map) != null) || map == null || !map.containsKey("SWAN-TIMEOUT-SETTING") || (str = (String) map.remove("SWAN-TIMEOUT-SETTING")) == null || !TextUtils.isDigitsOnly(str) || (parseInt = Integer.parseInt(str)) <= 0) {
            return;
        }
        if (obj instanceof PostStringRequest.PostStringRequestBuilder) {
            PostStringRequest.PostStringRequestBuilder postStringRequestBuilder = (PostStringRequest.PostStringRequestBuilder) obj;
            postStringRequestBuilder.readTimeout(parseInt);
            postStringRequestBuilder.writeTimeout(parseInt);
            postStringRequestBuilder.connectionTimeout(parseInt);
        } else if (obj instanceof PostByteRequest.PostByteRequestBuilder) {
            PostByteRequest.PostByteRequestBuilder postByteRequestBuilder = (PostByteRequest.PostByteRequestBuilder) obj;
            postByteRequestBuilder.readTimeout(parseInt);
            postByteRequestBuilder.writeTimeout(parseInt);
            postByteRequestBuilder.connectionTimeout(parseInt);
        }
    }
}
