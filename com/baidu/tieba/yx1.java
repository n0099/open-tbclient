package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.tieba.wv1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yx1 extends wx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.wv1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "SubscribeServiceApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements wv1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx1 a;

        public a(yx1 yx1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx1Var;
        }

        @Override // com.baidu.tieba.wv1.a
        public tz1 a(t73 t73Var, JSONObject jSONObject, String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, t73Var, jSONObject, str)) == null) {
                return this.a.E(t73Var, jSONObject, str);
            }
            return (tz1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ yx1 b;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public b(yx1 yx1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yx1Var;
            this.a = str;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                yx1 yx1Var = this.b;
                String str = this.a;
                if (exc == null) {
                    message = "";
                } else {
                    message = exc.getMessage();
                }
                yx1Var.B(str, message);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                this.b.d(this.a, this.b.D(response));
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yx1(@NonNull uv1 uv1Var) {
        super(uv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uv1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((uv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public tz1 F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#subscribe params=" + str, false);
            return l(str, true, new a(this));
        }
        return (tz1) invokeL.objValue;
    }

    public final void A(@NonNull Request request, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, request, str) == null) {
            we4 we4Var = new we4(request.url().toString(), request.body(), new b(this, str));
            we4Var.i = request.tag();
            we4Var.f = true;
            we4Var.g = true;
            we4Var.h = true;
            xe4.g().e(we4Var);
        }
    }

    public final void B(@NonNull String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            d(str, new tz1(500106, str2));
        }
    }

    public final RequestBody C(@NonNull t73 t73Var, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, t73Var, jSONObject)) == null) {
            String optString = jSONObject.optString("subscribeId");
            String O = t73Var.O();
            String optString2 = jSONObject.optString("templateId");
            if (!TextUtils.isEmpty(O) && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                return new FormBody.Builder().add("appkey", O).add("uniq_id", optString).add("type", jSONObject.optString("type", "query")).add("template_id", optString2).build();
            }
            return null;
        }
        return (RequestBody) invokeLL.objValue;
    }

    public tz1 D(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, response)) == null) {
            if (response != null && response.body() != null) {
                try {
                    JSONObject jSONObject = new JSONObject(response.body().string());
                    String optString = jSONObject.optString("errno");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (TextUtils.equals("0", optString) && optJSONObject != null) {
                        return new tz1(0, optJSONObject, false);
                    }
                    return new tz1(500106, "subscribe fail");
                } catch (Exception e) {
                    return new tz1(500106, Log.getStackTraceString(e));
                }
            }
            return new tz1(500106, "response body is null");
        }
        return (tz1) invokeL.objValue;
    }

    public final tz1 E(@NonNull t73 t73Var, @NonNull JSONObject jSONObject, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, t73Var, jSONObject, str)) == null) {
            Pair<Request, Integer> z = z(t73Var, jSONObject);
            Request request = (Request) z.first;
            if (request == null) {
                return new tz1(((Integer) z.second).intValue(), IActiveUploadListener.PARAM_ERR_MSG);
            }
            A(request, str);
            return new tz1(0, "success");
        }
        return (tz1) invokeLLL.objValue;
    }

    public final Pair<Request, Integer> z(@NonNull t73 t73Var, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, t73Var, jSONObject)) == null) {
            RequestBody C = C(t73Var, jSONObject);
            if (C == null) {
                return new Pair<>(null, 202);
            }
            return new Pair<>(new Request.Builder().url(ar2.W().a()).post(C).build(), 0);
        }
        return (Pair) invokeLL.objValue;
    }
}
