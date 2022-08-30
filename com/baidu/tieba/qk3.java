package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class qk3 extends pk3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;
    public Callback d;
    public JSONObject e;
    public String f;
    public String g;
    public String h;
    public String i;
    public int j;

    /* loaded from: classes5.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qk3 a;

        public a(qk3 qk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qk3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qk3Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (vj3.a) {
                    Log.d("BDTLS", "Bdtls Request API onFailure = " + exc.getMessage());
                }
                if (this.a.d != null) {
                    if (exc instanceof IOException) {
                        this.a.d.onFailure(null, (IOException) exc);
                    } else {
                        this.a.d.onFailure(null, new IOException(exc));
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                this.a.n(null, response);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948094672, "Lcom/baidu/tieba/qk3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948094672, "Lcom/baidu/tieba/qk3;");
                return;
            }
        }
        k = kh1.a;
    }

    public qk3(a13 a13Var, JSONObject jSONObject, String str, Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a13Var, jSONObject, str, callback};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = callback;
        this.f = str;
        m(jSONObject);
        d(this.e.optString("method"));
    }

    @Override // com.baidu.tieba.pk3
    public void e(IOException iOException) {
        Callback callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iOException) == null) || (callback = this.d) == null) {
            return;
        }
        callback.onFailure(null, iOException);
    }

    @Override // com.baidu.tieba.pk3
    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (vj3.a) {
                Log.d("BdtlsRequestApi", "onRequestError=" + i);
            }
            Callback callback = this.d;
            if (callback != null) {
                callback.onFailure(null, new IOException("request error  code : " + i));
            }
        }
    }

    @Override // com.baidu.tieba.pk3
    public void h(byte[] bArr) {
        JSONObject jSONObject;
        HttpRequest httpRequest;
        Callback callback;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject = new JSONObject(this.e.toString());
                try {
                    Uri parse = Uri.parse(this.h);
                    String path = parse.getPath();
                    String query = parse.getQuery();
                    if (TextUtils.isEmpty(this.i)) {
                        str = wj3.b;
                    } else {
                        str = this.i + "/bdtls";
                    }
                    StringBuilder sb = new StringBuilder(str + "/" + this.g);
                    String str3 = "";
                    if (TextUtils.isEmpty(path)) {
                        path = "";
                    }
                    sb.append(path);
                    if (!TextUtils.isEmpty(query)) {
                        str3 = "?" + query;
                    }
                    sb.append(str3);
                    if (k) {
                        Log.d("BdtlsRequestApi", "bdtls url is : " + sb.toString());
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("header");
                    if (this.a) {
                        if (TextUtils.equals(b(), "GET")) {
                            str2 = Base64.encodeToString(bArr, 2);
                        } else {
                            jSONObject.putOpt("data", bArr);
                            str2 = "Bdtls";
                        }
                        optJSONObject.put("Bdtls", str2);
                    }
                    jSONObject.putOpt("header", optJSONObject);
                    jSONObject.putOpt("url", sb.toString());
                } catch (JSONException e) {
                    e = e;
                    jSONObject2 = jSONObject;
                    if (k) {
                        Log.e("BdtlsRequestApi", "Bdtls request data is invalid", e);
                    }
                    jSONObject = jSONObject2;
                    httpRequest = (HttpRequest) oq1.C(jSONObject, this.f).first;
                    if (httpRequest == null) {
                        callback.onFailure(null, new IOException("request build fail, maybe your url is invalid"));
                    }
                    l(httpRequest);
                }
            } catch (JSONException e2) {
                e = e2;
            }
            httpRequest = (HttpRequest) oq1.C(jSONObject, this.f).first;
            if (httpRequest == null && (callback = this.d) != null) {
                callback.onFailure(null, new IOException("request build fail, maybe your url is invalid"));
            }
            l(httpRequest);
        }
    }

    public final void l(HttpRequest httpRequest) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, httpRequest) == null) || httpRequest == null) {
            return;
        }
        httpRequest.executeAsync(new a(this));
    }

    public final void m(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            this.e = jSONObject;
            this.h = jSONObject.optString("url");
            JSONObject optJSONObject = this.e.optJSONObject("ext");
            if (optJSONObject != null) {
                this.i = optJSONObject.optString("customHost");
            }
        }
    }

    public final void n(Call call, Response response) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, call, response) == null) {
            Headers headers = response.headers();
            if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
                bk3.l().m().s(0);
                if (bk3.l().m().b()) {
                    bk3.l().m().a();
                    i(true);
                    p();
                    return;
                }
                this.d.onFailure(call, new IOException("Exceeded the limit of continuous recovery"));
                return;
            }
            bk3.l().m().k();
            if (this.a) {
                ResponseBody body = response.body();
                String g = g(body.bytes());
                if (vj3.a) {
                    Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + g);
                }
                if (this.b == 1) {
                    Buffer buffer = new Buffer();
                    buffer.writeString(g, Charset.forName(IMAudioTransRequest.CHARSET));
                    Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                    Callback callback = this.d;
                    if (callback != null) {
                        callback.onResponse(call, build);
                    }
                    this.j = 0;
                    return;
                } else if (this.j < 3) {
                    p();
                    return;
                } else {
                    this.d.onFailure(call, new IOException("Url or serviceId is invalid"));
                    this.j = 0;
                    return;
                }
            }
            Callback callback2 = this.d;
            if (callback2 != null) {
                callback2.onResponse(call, response);
            }
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.g = str;
            JSONObject jSONObject = this.e;
            a(jSONObject != null ? jSONObject.optString("data") : "");
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.j++;
            o(this.g);
        }
    }
}
