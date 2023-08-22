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
/* loaded from: classes8.dex */
public class u94 extends j94 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> h;
    public static final Set<String> i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ k94 d;
        public final /* synthetic */ u94 e;

        public a(u94 u94Var, String str, long j, String str2, k94 k94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u94Var, str, Long.valueOf(j), str2, k94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = u94Var;
            this.a = str;
            this.b = j;
            this.c = str2;
            this.d = k94Var;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.d.cancelTag(this.e.c);
                this.e.V(this.a, 0, iOException.getMessage(), this.b);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!response.isSuccessful()) {
                    this.e.V(this.a, response.code(), response.message(), this.b);
                    return;
                }
                try {
                    JSEvent jSEvent = new JSEvent("headersReceived");
                    jSEvent.data = new w94(this.e.H(response.headers()));
                    this.e.dispatchEvent(jSEvent);
                } catch (JSONException e) {
                    if (j94.e) {
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
                    this.e.W(this.a, response);
                } else {
                    this.e.U(this.a, response);
                }
                int code = response.code();
                String message = response.message();
                if (j94.e) {
                    Log.d("RequestTask", "onResponse: id:" + this.e.c + ",respCode: " + code + ", url=" + this.a + ", msg=" + message);
                }
                wh3.O(code, this.a, 1, message, this.b, System.currentTimeMillis());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948165817, "Lcom/baidu/tieba/u94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948165817, "Lcom/baidu/tieba/u94;");
                return;
            }
        }
        h = Sets.newHashSet("text", "arraybuffer");
        i = Sets.newHashSet(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u94(ni2 ni2Var, k32 k32Var) {
        super(ni2Var, k32Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ni2Var, k32Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ni2) objArr2[0], (k32) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 1;
    }

    public void start() {
        Request Q;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.b == null || (Q = Q()) == null) {
            return;
        }
        S(Q);
    }

    @Override // com.baidu.tieba.j94
    public void B(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.B(str, i2, str2);
            xb4.h(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    @NonNull
    public static String T(@NonNull k32 k32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, k32Var)) == null) {
            String lowerCase = k32Var.B("responseType").toLowerCase(Locale.US);
            if (!h.contains(lowerCase)) {
                return "text";
            }
            return lowerCase;
        }
        return (String) invokeL.objValue;
    }

    public final Request Q() {
        InterceptResult invokeV;
        RequestBody R;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String y = y();
            if (TextUtils.isEmpty(y)) {
                if (j94.e) {
                    Log.d("RequestTask", "buildRequest url =" + y);
                }
                return null;
            }
            String B = this.b.B("method");
            if (TextUtils.isEmpty(B)) {
                B = "GET";
            }
            String upperCase = B.toUpperCase(Locale.US);
            if (!i.contains(upperCase)) {
                B(y, -1, "request:method is invalid");
                return null;
            }
            HashMap hashMap = new HashMap();
            Request.Builder builder = new Request.Builder();
            boolean z = true;
            F(builder, this.b.w("header"), hashMap, true);
            if (j94.e) {
                Log.d("RequestTask", "lowerCaseHeaderMap =" + hashMap);
            }
            Object C = this.b.C("data", null);
            if (C == null) {
                C = this.b.t("data", null);
            }
            if (C == null) {
                z = false;
            }
            if (z && !HttpMethod.permitsRequestBody(upperCase)) {
                return builder.url(y).method(upperCase, null).tag(this.c).build();
            }
            if (!z && !HttpMethod.requiresRequestBody(upperCase)) {
                R = null;
            } else {
                R = R(C, hashMap);
            }
            if (HttpMethod.requiresRequestBody(upperCase) && R == null) {
                return null;
            }
            return builder.url(y).method(upperCase, R).tag(this.c).build();
        }
        return (Request) invokeV.objValue;
    }

    @Nullable
    public final RequestBody R(Object obj, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, map)) == null) {
            String str = map.get(Headers.CONTENT_TYPE);
            MediaType mediaType = k23.a;
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
                if (j94.e) {
                    Log.d("RequestTask", "createBody = " + obj);
                }
                return RequestBody.create(mediaType, (String) obj);
            } else {
                return RequestBody.create(mediaType, "");
            }
        }
        return (RequestBody) invokeLL.objValue;
    }

    public final void W(String str, Response response) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, str, response) != null) || response == null) {
            return;
        }
        ResponseBody body = response.body();
        try {
            v94 v94Var = new v94();
            v94Var.statusCode = response.code();
            v94Var.header = H(response.headers());
            if (body != null) {
                v94Var.data = body.string();
                if (j94.e) {
                    Log.d("RequestTask", "onStringResponse = " + v94Var.data);
                }
            }
            C(v94Var);
        } catch (IOException | JSONException e) {
            if (j94.e) {
                Log.d("RequestTask", Log.getStackTraceString(e));
            }
            B(str, -1, e.getMessage());
        }
    }

    public void S(Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, request) == null) {
            String T2 = T(this.b);
            String httpUrl = request.url().toString();
            if (db3.M() == null) {
                B("", -1, "request:swanApp is null");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            wh3.B(httpUrl, 1, null);
            k94 k94Var = (k94) db3.M().i0();
            k94Var.call(request, new a(this, httpUrl, currentTimeMillis, T2, k94Var));
        }
    }

    public final void U(String str, Response response) {
        byte[] bytes;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, str, response) != null) || response == null) {
            return;
        }
        try {
            s94 s94Var = new s94();
            s94Var.statusCode = response.code();
            s94Var.header = H(response.headers());
            ResponseBody body = response.body();
            if (body != null && (bytes = body.bytes()) != null) {
                s94Var.data = new JsArrayBuffer(bytes, bytes.length);
            }
            C(s94Var);
        } catch (IOException | JSONException e) {
            if (j94.e) {
                Log.d("RequestTask", Log.getStackTraceString(e));
            }
            B(str, -1, e.getMessage());
        }
    }

    public final void V(String str, int i2, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Integer.valueOf(i2), str2, Long.valueOf(j)}) == null) {
            if (j94.e) {
                Log.d("RequestTask", "onFailure: " + str2);
            }
            if ("Canceled".equalsIgnoreCase(str2)) {
                str2 = "request:fail abort";
            }
            String str3 = str2;
            B(str, i2, str3);
            if (SwanAppNetworkUtils.i(null)) {
                wh3.O(i2, str, 1, str3, j, System.currentTimeMillis());
            }
        }
    }
}
