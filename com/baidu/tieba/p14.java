package com.baidu.tieba;

import android.net.http.Headers;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpMethod;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.json.JSONException;
/* loaded from: classes5.dex */
public class p14 extends e14 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> h;
    public static final Set<String> i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ f14 d;
        public final /* synthetic */ p14 e;

        public a(p14 p14Var, String str, long j, String str2, f14 f14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p14Var, str, Long.valueOf(j), str2, f14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = p14Var;
            this.a = str;
            this.b = j;
            this.c = str2;
            this.d = f14Var;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.d.cancelTag(this.e.c);
                this.e.W(this.a, 0, iOException.getMessage(), this.b);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!response.isSuccessful()) {
                    this.e.W(this.a, response.code(), response.message(), this.b);
                    return;
                }
                try {
                    JSEvent jSEvent = new JSEvent("headersReceived");
                    jSEvent.data = new r14(this.e.I(response.headers()));
                    this.e.dispatchEvent(jSEvent);
                } catch (JSONException e) {
                    if (e14.e) {
                        e.printStackTrace();
                    }
                }
                String str = this.c;
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 3556653) {
                    if (hashCode == 1154818009 && str.equals("arraybuffer")) {
                        c = 0;
                    }
                } else if (str.equals("text")) {
                    c = 1;
                }
                if (c != 0) {
                    this.e.X(this.a, response);
                } else {
                    this.e.V(this.a, response);
                }
                int code = response.code();
                String message = response.message();
                if (e14.e) {
                    Log.d("RequestTask", "onResponse: id:" + this.e.c + ",respCode: " + code + ", url=" + this.a + ", msg=" + message);
                }
                r93.O(code, this.a, 1, message, this.b, System.currentTimeMillis());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948009174, "Lcom/baidu/tieba/p14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948009174, "Lcom/baidu/tieba/p14;");
                return;
            }
        }
        h = Sets.newHashSet("text", "arraybuffer");
        i = Sets.newHashSet(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p14(ia2 ia2Var, fv1 fv1Var) {
        super(ia2Var, fv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ia2Var, fv1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ia2) objArr2[0], (fv1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 1;
    }

    @NonNull
    public static String U(@NonNull fv1 fv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, fv1Var)) == null) {
            String lowerCase = fv1Var.B("responseType").toLowerCase(Locale.US);
            return !h.contains(lowerCase) ? "text" : lowerCase;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.e14
    public void C(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.C(str, i2, str2);
            s34.h(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public final Request R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String z = z();
            if (TextUtils.isEmpty(z)) {
                if (e14.e) {
                    Log.d("RequestTask", "buildRequest url =" + z);
                }
                return null;
            }
            String B = this.b.B("method");
            if (TextUtils.isEmpty(B)) {
                B = "GET";
            }
            String upperCase = B.toUpperCase(Locale.US);
            if (!i.contains(upperCase)) {
                C(z, -1, "request:method is invalid");
                return null;
            }
            HashMap hashMap = new HashMap();
            Request.Builder builder = new Request.Builder();
            G(builder, this.b.w("header"), hashMap, true);
            if (e14.e) {
                Log.d("RequestTask", "lowerCaseHeaderMap =" + hashMap);
            }
            Object C = this.b.C("data", null);
            if (C == null) {
                C = this.b.t("data", null);
            }
            boolean z2 = C != null;
            if (z2 && !HttpMethod.permitsRequestBody(upperCase)) {
                return builder.url(z).method(upperCase, null).tag(this.c).build();
            }
            RequestBody S = (z2 || HttpMethod.requiresRequestBody(upperCase)) ? S(C, hashMap) : null;
            if (HttpMethod.requiresRequestBody(upperCase) && S == null) {
                return null;
            }
            return builder.url(z).method(upperCase, S).tag(this.c).build();
        }
        return (Request) invokeV.objValue;
    }

    @Nullable
    public final RequestBody S(Object obj, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, map)) == null) {
            String str = map.get(Headers.CONTENT_TYPE);
            MediaType mediaType = fu2.a;
            if (!TextUtils.isEmpty(str)) {
                mediaType = MediaType.parse(str);
            }
            if (obj instanceof JsArrayBuffer) {
                byte[] buffer = ((JsArrayBuffer) obj).buffer();
                if (buffer == null) {
                    return RequestBody.create(mediaType, "");
                }
                return RequestBody.create(mediaType, buffer);
            } else if (obj instanceof String) {
                if (e14.e) {
                    Log.d("RequestTask", "createBody = " + obj);
                }
                return RequestBody.create(mediaType, (String) obj);
            } else {
                return RequestBody.create(mediaType, "");
            }
        }
        return (RequestBody) invokeLL.objValue;
    }

    public void T(Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, request) == null) {
            String U = U(this.b);
            String httpUrl = request.url().toString();
            if (y23.M() == null) {
                C("", -1, "request:swanApp is null");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            r93.B(httpUrl, 1, null);
            f14 f14Var = (f14) y23.M().i0();
            f14Var.call(request, new a(this, httpUrl, currentTimeMillis, U, f14Var));
        }
    }

    public final void V(String str, Response response) {
        byte[] bytes;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, response) == null) || response == null) {
            return;
        }
        try {
            n14 n14Var = new n14();
            n14Var.statusCode = response.code();
            n14Var.header = I(response.headers());
            ResponseBody body = response.body();
            if (body != null && (bytes = body.bytes()) != null) {
                n14Var.data = new JsArrayBuffer(bytes, bytes.length);
            }
            D(n14Var);
        } catch (IOException | JSONException e) {
            if (e14.e) {
                Log.d("RequestTask", Log.getStackTraceString(e));
            }
            C(str, -1, e.getMessage());
        }
    }

    public final void W(String str, int i2, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Integer.valueOf(i2), str2, Long.valueOf(j)}) == null) {
            if (e14.e) {
                Log.d("RequestTask", "onFailure: " + str2);
            }
            if ("Canceled".equalsIgnoreCase(str2)) {
                str2 = "request:fail abort";
            }
            String str3 = str2;
            C(str, i2, str3);
            if (SwanAppNetworkUtils.i(null)) {
                r93.O(i2, str, 1, str3, j, System.currentTimeMillis());
            }
        }
    }

    public final void X(String str, Response response) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, response) == null) || response == null) {
            return;
        }
        ResponseBody body = response.body();
        try {
            q14 q14Var = new q14();
            q14Var.statusCode = response.code();
            q14Var.header = I(response.headers());
            if (body != null) {
                q14Var.data = body.string();
                if (e14.e) {
                    Log.d("RequestTask", "onStringResponse = " + q14Var.data);
                }
            }
            D(q14Var);
        } catch (IOException | JSONException e) {
            if (e14.e) {
                Log.d("RequestTask", Log.getStackTraceString(e));
            }
            C(str, -1, e.getMessage());
        }
    }

    public void start() {
        Request R;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.b == null || (R = R()) == null) {
            return;
        }
        T(R);
    }
}
