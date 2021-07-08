package com.bytedance.sdk.openadsdk.core.c;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.callback.NetCallback;
import com.bytedance.sdk.component.net.executor.NetExecutor;
import com.bytedance.sdk.component.net.executor.PostExecutor;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.l.e;
import com.bytedance.sdk.openadsdk.r.n;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, str, Long.valueOf(j)}) == null) {
            JSONObject a2 = a(str, j);
            PostExecutor postExecutor = e.b().c().getPostExecutor();
            postExecutor.setUrl(n.b("https://i.snssdk.com/api/ad/union/sdk/stats/"));
            postExecutor.setJson(a2.toString());
            postExecutor.enqueue(new NetCallback() { // from class: com.bytedance.sdk.openadsdk.core.c.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.net.callback.NetCallback
                public void onFailure(NetExecutor netExecutor, IOException iOException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netExecutor, iOException) == null) {
                        j.c("FrequentCallEventHelper", iOException.getMessage());
                    }
                }

                @Override // com.bytedance.sdk.component.net.callback.NetCallback
                public void onResponse(NetExecutor netExecutor, NetResponse netResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netExecutor, netResponse) == null) {
                        if (netResponse != null) {
                            j.b("FrequentCallEventHelper", Boolean.valueOf(netResponse.isSuccess()), netResponse.getBody());
                        } else {
                            j.c("FrequentCallEventHelper", "NetResponse is null");
                        }
                    }
                }
            });
        }
    }

    public static JSONObject a(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65536, null, str, j)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "over_freq");
                jSONObject.put("rit", str);
                jSONObject.put("ad_sdk_version", "3.6.1.3");
                jSONObject.put("timestamp", j);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLJ.objValue;
    }
}
