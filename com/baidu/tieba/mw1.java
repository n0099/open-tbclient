package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.tieba.ku1;
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
public class mw1 extends kw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ku1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "SubscribeServiceApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements ku1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mw1 a;

        public a(mw1 mw1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mw1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mw1Var;
        }

        @Override // com.baidu.tieba.ku1.a
        public hy1 a(g63 g63Var, JSONObject jSONObject, String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, g63Var, jSONObject, str)) == null) {
                return this.a.F(g63Var, jSONObject, str);
            }
            return (hy1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ mw1 b;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public b(mw1 mw1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mw1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mw1Var;
            this.a = str;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                mw1 mw1Var = this.b;
                String str = this.a;
                if (exc == null) {
                    message = "";
                } else {
                    message = exc.getMessage();
                }
                mw1Var.C(str, message);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                this.b.d(this.a, this.b.E(response));
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mw1(@NonNull iu1 iu1Var) {
        super(iu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public hy1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            r("#subscribe params=" + str, false);
            return m(str, true, new a(this));
        }
        return (hy1) invokeL.objValue;
    }

    public final Pair<Request, Integer> A(@NonNull g63 g63Var, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, g63Var, jSONObject)) == null) {
            RequestBody D = D(g63Var, jSONObject);
            if (D == null) {
                return new Pair<>(null, 202);
            }
            return new Pair<>(new Request.Builder().url(np2.W().a()).post(D).build(), 0);
        }
        return (Pair) invokeLL.objValue;
    }

    public final RequestBody D(@NonNull g63 g63Var, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, g63Var, jSONObject)) == null) {
            String optString = jSONObject.optString("subscribeId");
            String P = g63Var.P();
            String optString2 = jSONObject.optString("templateId");
            if (!TextUtils.isEmpty(P) && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                return new FormBody.Builder().add("appkey", P).add("uniq_id", optString).add("type", jSONObject.optString("type", "query")).add("template_id", optString2).build();
            }
            return null;
        }
        return (RequestBody) invokeLL.objValue;
    }

    public final void B(@NonNull Request request, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, str) == null) {
            jd4 jd4Var = new jd4(request.url().toString(), request.body(), new b(this, str));
            jd4Var.i = request.tag();
            jd4Var.f = true;
            jd4Var.g = true;
            jd4Var.h = true;
            kd4.g().e(jd4Var);
        }
    }

    public final void C(@NonNull String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            d(str, new hy1(500106, str2));
        }
    }

    public hy1 E(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, response)) == null) {
            if (response != null && response.body() != null) {
                try {
                    JSONObject jSONObject = new JSONObject(response.body().string());
                    String optString = jSONObject.optString("errno");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (TextUtils.equals("0", optString) && optJSONObject != null) {
                        return new hy1(0, optJSONObject, false);
                    }
                    return new hy1(500106, "subscribe fail");
                } catch (Exception e) {
                    return new hy1(500106, Log.getStackTraceString(e));
                }
            }
            return new hy1(500106, "response body is null");
        }
        return (hy1) invokeL.objValue;
    }

    public final hy1 F(@NonNull g63 g63Var, @NonNull JSONObject jSONObject, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, g63Var, jSONObject, str)) == null) {
            Pair<Request, Integer> A = A(g63Var, jSONObject);
            Request request = (Request) A.first;
            if (request == null) {
                return new hy1(((Integer) A.second).intValue(), IActiveUploadListener.PARAM_ERR_MSG);
            }
            B(request, str);
            return new hy1(0, "success");
        }
        return (hy1) invokeLLL.objValue;
    }
}
