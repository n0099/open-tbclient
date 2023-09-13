package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class se4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            }
        }

        public a() {
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
    }

    public static Map<String, String> a(@NonNull hb3 hb3Var, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, hb3Var, i, str)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(GameGuideConfigInfo.KEY_APP_KEY, hb3Var.O());
            treeMap.put("to_app_key", str);
            treeMap.put("source", String.valueOf(i));
            treeMap.put("timestamp", c());
            StringBuilder sb = new StringBuilder();
            for (String str2 : treeMap.keySet()) {
                sb.append(str2);
                sb.append("=");
                sb.append((String) treeMap.get(str2));
                sb.append("&");
            }
            sb.append("dsb9Ao44");
            treeMap.put("sign", nr4.d(sb.toString().getBytes(), false));
            return treeMap;
        }
        return (Map) invokeLIL.objValue;
    }

    public static void b(int i, @NonNull ResponseCallback responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65537, null, i, responseCallback) == null) {
            hb3 M = hb3.M();
            if (M == null) {
                responseCallback.onFail(new Exception("framework error: swan app is null."));
                return;
            }
            M.i0().getRequest().cookieManager(ou2.q().a()).url(y74.b().p()).addUrlParam(GameGuideConfigInfo.KEY_APP_KEY, M.O()).addUrlParam(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(5)).addUrlParam("source", String.valueOf(i)).requestFrom(16).requestFrom(1607).build().executeAsync(responseCallback);
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return String.valueOf(System.currentTimeMillis() / 1000);
        }
        return (String) invokeV.objValue;
    }

    public static void d(int i, String str) {
        hb3 M;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(65539, null, i, str) != null) || (M = hb3.M()) == null) {
            return;
        }
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) M.i0().postFormRequest().cookieManager(ou2.q().a())).url(y74.b().g())).addParams(a(M, i, str)).requestFrom(16)).requestFrom(1607)).build().executeAsync(new a());
    }
}
