package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.tieba.hs1;
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
/* loaded from: classes4.dex */
public class ju1 extends hu1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.hs1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "SubscribeServiceApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements hs1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju1 a;

        public a(ju1 ju1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ju1Var;
        }

        @Override // com.baidu.tieba.hs1.a
        public ew1 a(e43 e43Var, JSONObject jSONObject, String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, e43Var, jSONObject, str)) == null) {
                return this.a.E(e43Var, jSONObject, str);
            }
            return (ew1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ju1 b;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public b(ju1 ju1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ju1Var;
            this.a = str;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                ju1 ju1Var = this.b;
                String str = this.a;
                if (exc == null) {
                    message = "";
                } else {
                    message = exc.getMessage();
                }
                ju1Var.B(str, message);
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
    public ju1(@NonNull fs1 fs1Var) {
        super(fs1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fs1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((fs1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public ew1 F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#subscribe params=" + str, false);
            return l(str, true, new a(this));
        }
        return (ew1) invokeL.objValue;
    }

    public final void A(@NonNull Request request, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, request, str) == null) {
            hb4 hb4Var = new hb4(request.url().toString(), request.body(), new b(this, str));
            hb4Var.i = request.tag();
            hb4Var.f = true;
            hb4Var.g = true;
            hb4Var.h = true;
            ib4.g().e(hb4Var);
        }
    }

    public final void B(@NonNull String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            d(str, new ew1(500106, str2));
        }
    }

    public final RequestBody C(@NonNull e43 e43Var, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, e43Var, jSONObject)) == null) {
            String optString = jSONObject.optString("subscribeId");
            String O = e43Var.O();
            String optString2 = jSONObject.optString("templateId");
            if (!TextUtils.isEmpty(O) && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                return new FormBody.Builder().add("appkey", O).add("uniq_id", optString).add("type", jSONObject.optString("type", "query")).add("template_id", optString2).build();
            }
            return null;
        }
        return (RequestBody) invokeLL.objValue;
    }

    public final Pair<Request, Integer> z(@NonNull e43 e43Var, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, e43Var, jSONObject)) == null) {
            RequestBody C = C(e43Var, jSONObject);
            if (C == null) {
                return new Pair<>(null, 202);
            }
            return new Pair<>(new Request.Builder().url(ln2.W().a()).post(C).build(), 0);
        }
        return (Pair) invokeLL.objValue;
    }

    public ew1 D(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, response)) == null) {
            if (response != null && response.body() != null) {
                try {
                    JSONObject jSONObject = new JSONObject(response.body().string());
                    String optString = jSONObject.optString("errno");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (TextUtils.equals("0", optString) && optJSONObject != null) {
                        return new ew1(0, optJSONObject, false);
                    }
                    return new ew1(500106, "subscribe fail");
                } catch (Exception e) {
                    return new ew1(500106, Log.getStackTraceString(e));
                }
            }
            return new ew1(500106, "response body is null");
        }
        return (ew1) invokeL.objValue;
    }

    public final ew1 E(@NonNull e43 e43Var, @NonNull JSONObject jSONObject, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, e43Var, jSONObject, str)) == null) {
            Pair<Request, Integer> z = z(e43Var, jSONObject);
            Request request = (Request) z.first;
            if (request == null) {
                return new ew1(((Integer) z.second).intValue(), IActiveUploadListener.PARAM_ERR_MSG);
            }
            A(request, str);
            return new ew1(0, "success");
        }
        return (ew1) invokeLLL.objValue;
    }
}
