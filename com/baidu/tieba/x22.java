package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.swan.apps.commonsync.CommonSyncServerData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class x22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static int b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends ResponseCallback<CommonSyncServerData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z22 a;

        public a(z22 z22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z22Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            z22 z22Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) && (z22Var = this.a) != null) {
                z22Var.onFail();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(CommonSyncServerData commonSyncServerData, int i) {
            z22 z22Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, commonSyncServerData, i) == null) && (z22Var = this.a) != null) {
                z22Var.a(commonSyncServerData);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public CommonSyncServerData parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                if (response != null && response.body() != null) {
                    String string = response.body().string();
                    if (TextUtils.isEmpty(string)) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(string);
                    int optInt = jSONObject.optInt("errno");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optInt == x22.b && optJSONObject != null) {
                        return CommonSyncServerData.parseFromJson(optJSONObject);
                    }
                }
                return null;
            }
            return (CommonSyncServerData) invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948248401, "Lcom/baidu/tieba/x22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948248401, "Lcom/baidu/tieba/x22;");
                return;
            }
        }
        a = eo1.a;
        b = 0;
    }

    public static void b(z22 z22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, z22Var) == null) {
            if (SwanAppNetworkUtils.h()) {
                ye4.g().getRequest().cookieManager(br2.q().a()).url(br2.m().processUrl(y22.a())).build().executeAsync(new a(z22Var));
            } else if (z22Var != null) {
                z22Var.onFail();
            }
        }
    }

    public static RequestBody c(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, map)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (map != null && map.size() > 0) {
                for (String str : map.keySet()) {
                    try {
                        jSONObject.put(str, map.get(str));
                    } catch (JSONException e) {
                        if (a) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return RequestBody.create(bz2.a, jSONObject.toString());
        }
        return (RequestBody) invokeL.objValue;
    }

    public static void d(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, map) == null) && SwanAppNetworkUtils.h()) {
            ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) ye4.g().postRequest().cookieManager(br2.q().a())).url(br2.m().processUrl(y22.b()))).requestBody(c(map)).build().executeAsync(null);
        }
    }

    public static void e(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, map) == null) && SwanAppNetworkUtils.h()) {
            ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) ye4.g().postRequest().cookieManager(br2.q().a())).url(br2.m().processUrl(y22.c()))).requestBody(c(map)).build().executeAsync(null);
        }
    }
}
