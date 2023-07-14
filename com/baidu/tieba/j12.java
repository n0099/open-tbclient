package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.net.http.Headers;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tieba.yz1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpMethod;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j12 extends b12 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> f;
    public static final Set<String> g;
    public static final Set<String> h;
    public static final Set<String> i;
    public static final List<String> j;
    @SuppressLint({"BDOfflineUrl"})
    public static final String[] k;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface f {
        void a(JSONObject jSONObject);
    }

    @Override // com.baidu.tieba.yz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "RequestApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements yz1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j12 a;

        public a(j12 j12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j12Var;
        }

        @Override // com.baidu.tieba.yz1.a
        public v32 a(vb3 vb3Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            zi4 g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, vb3Var, jSONObject, str)) == null) {
                String optString = jSONObject.optString("cancelTag");
                if (TextUtils.isEmpty(optString)) {
                    return new v32(202, "illegal cancelTag");
                }
                j12 j12Var = this.a;
                j12Var.q("#cancelRequest cancelTag=" + optString, false);
                if (j12.j.remove(optString)) {
                    g = zi4.l();
                } else {
                    g = zi4.g();
                }
                SwanAppNetworkUtils.a(g.getOkHttpClient(), optString);
                return v32.f();
            }
            return (v32) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vb3 a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ j12 e;

        public b(j12 j12Var, vb3 vb3Var, JSONObject jSONObject, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j12Var, vb3Var, jSONObject, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = j12Var;
            this.a = vb3Var;
            this.b = jSONObject;
            this.c = str;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.e.N(this.a, this.b, this.c, this.d);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements StatResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ HttpUrl b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ long e;
        public final /* synthetic */ e f;

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public c(j12 j12Var, String str, HttpUrl httpUrl, String str2, int i, long j, e eVar, HttpRequest httpRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j12Var, str, httpUrl, str2, Integer.valueOf(i), Long.valueOf(j), eVar, httpRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = httpUrl;
            this.c = str2;
            this.d = i;
            this.e = j;
            this.f = eVar;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                oi3.C(this.c, this.d, null, this.e, System.currentTimeMillis(), this.a);
                if (exc instanceof IOException) {
                    this.f.onFailure(null, (IOException) exc);
                } else {
                    this.f.onFailure(null, new IOException("request fail"));
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public Object parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, response, i, networkStatRecord)) == null) {
                fh2.k().C(this.a, this.b, networkStatRecord);
                oi3.C(this.c, this.d, networkStatRecord, this.e, System.currentTimeMillis(), this.a);
                this.f.onResponse(null, response);
                return response;
            }
            return invokeLIL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements oq3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ j12 b;

        public d(j12 j12Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j12Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j12Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.b.d(this.a, new v32(1001, str));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public vb3 a;
        public JSONObject b;
        public String c;
        public String d;
        public f e;
        public String f;
        public long g;
        public final /* synthetic */ j12 h;

        public e(@NonNull j12 j12Var, @NonNull vb3 vb3Var, @NonNull JSONObject jSONObject, @NonNull String str, String str2, @NonNull f fVar, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j12Var, vb3Var, jSONObject, str, str2, fVar, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = j12Var;
            this.a = vb3Var;
            this.b = jSONObject;
            this.c = str;
            this.d = str2;
            this.e = fVar;
            this.f = str3;
            this.g = System.currentTimeMillis();
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            zi4 g;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                int G = this.a.Y().G();
                String l = oi3.l();
                String e = pp3.n().e();
                if (j12.j.remove(this.d)) {
                    g = zi4.l();
                } else {
                    g = zi4.g();
                }
                SwanAppNetworkUtils.a(g.getOkHttpClient(), this.d);
                this.h.d(this.f, new v32(1001, iOException.getMessage()));
                oi3.Q(0, this.c, G, iOException.getMessage(), l, e, this.g, System.currentTimeMillis(), this.d);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!oi3.o(this.c)) {
                    rk3.l().x(this.c, response.headers("Set-cookie"));
                }
                String J = j12.J(this.b);
                String L = j12.L(this.b);
                int G = this.a.Y().G();
                long currentTimeMillis = System.currentTimeMillis();
                String l = oi3.l();
                String e = pp3.n().e();
                try {
                    long K = j12.K(response);
                    if (K <= Config.FULL_TRACE_LOG_LIMIT) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("statusCode", response.code());
                        jSONObject.put("header", k12.g(response.headers()));
                        j12.R(jSONObject, response.body(), J, L);
                        if (this.e != null) {
                            this.e.a(jSONObject);
                        }
                        this.h.d(this.f, new v32(0, jSONObject, true));
                    } else {
                        this.h.d(this.f, new v32(201, "response json length over limits"));
                        j12.S(this.a, this.c, K, currentTimeMillis);
                    }
                } catch (IOException | JSONException e2) {
                    this.h.d(this.f, new v32(201, e2.getMessage()));
                }
                oi3.Q(response.code(), this.c, G, response.message(), l, e, this.g, System.currentTimeMillis(), this.d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947830366, "Lcom/baidu/tieba/j12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947830366, "Lcom/baidu/tieba/j12;");
                return;
            }
        }
        f = Sets.newHashSet(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");
        g = Sets.newHashSet("json", EMABTest.TYPE_STRING);
        h = Sets.newHashSet("text", "arraybuffer");
        i = Sets.newHashSet("REFERER");
        j = Collections.synchronizedList(new ArrayList());
        k = new String[]{"https://hmma.baidu.com/mini.gif", "https://eclick.baidu.com/", "https://miniapp-ad.cdn.bcebos.com/", "https://mobads.baidu.com/", "https://als.baidu.com/", "https://wn.pos.baidu.com/"};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j12(@NonNull wz1 wz1Var) {
        super(wz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wz1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((wz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @NonNull
    public static v32 Y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i2)) == null) {
            String str = "illegal request";
            int i3 = 202;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 == 4) {
                                str = "HTTP method is invalid";
                            }
                        } else {
                            str = "request:fail parameter error: arrayBuffer of data exceed size limit.";
                        }
                    } else {
                        str = "request url header must be https or wss";
                    }
                }
            } else {
                i3 = 0;
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return new v32(i3);
            }
            return new v32(i3, str);
        }
        return (v32) invokeI.objValue;
    }

    public static void A(@NonNull HttpRequestBuilder httpRequestBuilder, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, httpRequestBuilder, str, str2) != null) || oi3.o(str)) {
            return;
        }
        String f2 = rk3.l().f(str, str2);
        if (!TextUtils.isEmpty(f2)) {
            httpRequestBuilder.setHeader("Cookie", f2);
        }
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public static HttpUrl B(@NonNull HttpUrl httpUrl, @NonNull Object obj, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, httpUrl, obj, str)) == null) {
            HttpUrl.Builder newBuilder = httpUrl.newBuilder();
            if (TextUtils.equals("JSONToString", str) && (obj instanceof String)) {
                try {
                    obj = new JSONObject((String) obj);
                } catch (JSONException unused) {
                }
            }
            if (!(obj instanceof JSONObject)) {
                return httpUrl;
            }
            boolean z = false;
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    String optString = jSONObject.optString(next);
                    if (TextUtils.isEmpty(optString)) {
                        optString = "";
                    }
                    newBuilder.addQueryParameter(next, optString);
                    z = true;
                }
            }
            if (z) {
                return newBuilder.build();
            }
            return httpUrl;
        }
        return (HttpUrl) invokeLLL.objValue;
    }

    @Nullable
    public static RequestBody G(@Nullable Object obj, Map<String, String> map, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, obj, map, str)) == null) {
            String str2 = map.get(Headers.CONTENT_TYPE);
            String str3 = "";
            if (TextUtils.isEmpty(str2)) {
                if (obj instanceof byte[]) {
                    return F(c33.a, (byte[]) obj);
                }
                MediaType mediaType = c33.a;
                if (obj != null) {
                    str3 = obj.toString();
                }
                return RequestBody.create(mediaType, str3);
            }
            MediaType parse = MediaType.parse(str2);
            if (c33.a.equals(parse)) {
                if (obj instanceof byte[]) {
                    return F(c33.a, (byte[]) obj);
                }
                MediaType mediaType2 = c33.a;
                if (obj != null) {
                    str3 = obj.toString();
                }
                return RequestBody.create(mediaType2, str3);
            }
            return H(obj, parse, str);
        }
        return (RequestBody) invokeLLL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static RequestBody H(@Nullable Object obj, MediaType mediaType, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, obj, mediaType, str)) == null) {
            FormBody.Builder builder = new FormBody.Builder();
            if (obj instanceof byte[]) {
                return F(mediaType, (byte[]) obj);
            }
            if (TextUtils.equals("JSONToString", str) && (obj instanceof String)) {
                try {
                    obj = new JSONObject((String) obj);
                } catch (JSONException unused) {
                }
            }
            if (obj != null && obj.toString().length() != 0) {
                if (obj instanceof String) {
                    return RequestBody.create(mediaType, (String) obj);
                }
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) obj;
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            builder.add(next, jSONObject.optString(next));
                        }
                    }
                }
                return a33.a(builder.build(), mediaType);
            }
            return builder.build();
        }
        return (RequestBody) invokeLLL.objValue;
    }

    public final v32 U(@NonNull vb3 vb3Var, @NonNull JSONObject jSONObject, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, vb3Var, jSONObject, str)) == null) {
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                p("#request illegal url", new Exception("stack"), true);
                return new v32(1001, "illegal url");
            }
            q("#request url=" + optString, false);
            String a2 = k12.a(vb3Var.b);
            JSONObject c2 = k12.c(a2);
            h32.d().c(new q32(this, vb3Var, jSONObject, a2, str));
            return new v32(0, c2);
        }
        return (v32) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<HttpRequest, Integer> C(@Nullable JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        zi4 g2;
        int i2;
        HttpUrl httpUrl;
        boolean z;
        HttpUrl httpUrl2;
        RequestBody G;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, str)) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                HttpUrl f2 = k12.f(jSONObject.optString("url"));
                if (f2 == null) {
                    return new Pair<>(null, 0);
                }
                String httpUrl3 = f2.toString();
                if (t53.a() == 1) {
                    String[] strArr = k;
                    int length = strArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            if (httpUrl3.startsWith(strArr[i3])) {
                                z2 = true;
                                break;
                            }
                            i3++;
                        } else {
                            z2 = false;
                            break;
                        }
                    }
                    if (z2) {
                        j.add(str);
                    }
                    if (z2) {
                        g2 = zi4.l();
                    } else {
                        g2 = zi4.g();
                    }
                } else {
                    g2 = zi4.g();
                }
                String optString = jSONObject.optString("__plugin__");
                boolean optBoolean = jSONObject.optBoolean("ping", false);
                if (!optBoolean) {
                    i2 = mc3.c("request", httpUrl3, optString);
                    if (i2 != 0) {
                        return new Pair<>(null, Integer.valueOf(i2));
                    }
                } else {
                    i2 = 0;
                }
                String optString2 = jSONObject.optString("method");
                if (TextUtils.isEmpty(optString2)) {
                    optString2 = "GET";
                }
                String upperCase = optString2.toUpperCase();
                if (!f.contains(upperCase)) {
                    return new Pair<>(null, 4);
                }
                HashMap hashMap = new HashMap();
                yi4 yi4Var = new yi4();
                yi4Var.b = upperCase;
                HttpRequestBuilder b2 = aj4.b(yi4Var, g2);
                W(httpUrl3, b2, jSONObject.optJSONObject("header"), hashMap);
                b2.setHeader("Referer", k12.d());
                if (!TextUtils.isEmpty(optString)) {
                    b2.setHeader("X-SWAN-HOSTSIGN", s73.b(t73.h(optString)));
                }
                String optString3 = jSONObject.optString("__requestDataType__");
                Object Q = Q(jSONObject, optString3);
                if (Q instanceof byte[]) {
                    httpUrl = f2;
                    if (((byte[]) Q).length > Config.FULL_TRACE_LOG_LIMIT) {
                        return new Pair<>(null, 3);
                    }
                } else {
                    httpUrl = f2;
                }
                if (Q != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && !HttpMethod.permitsRequestBody(upperCase)) {
                    httpUrl2 = B(httpUrl, Q, optString3);
                } else {
                    httpUrl2 = httpUrl;
                    if (z || HttpMethod.requiresRequestBody(upperCase)) {
                        G = G(Q, hashMap, optString3);
                        if (!HttpMethod.requiresRequestBody(upperCase) && G == null) {
                            return new Pair<>(null, Integer.valueOf(i2));
                        }
                        if (b2 instanceof HttpCommonRequestBuilder) {
                            ((HttpCommonRequestBuilder) b2).requestBody(G);
                        }
                        yi4Var.a = httpUrl2.toString();
                        yi4Var.f = X();
                        yi4Var.g = false;
                        yi4Var.h = true;
                        yi4Var.i = str;
                        yi4Var.k = 3;
                        g2.u(b2, yi4Var);
                        HttpRequest build = b2.build();
                        if (!optBoolean) {
                            build = n33.e(build, "request", optString);
                        }
                        fh2.k().r(str, httpUrl2);
                        return new Pair<>(build, Integer.valueOf(i2));
                    }
                }
                G = null;
                if (!HttpMethod.requiresRequestBody(upperCase)) {
                }
                if (b2 instanceof HttpCommonRequestBuilder) {
                }
                yi4Var.a = httpUrl2.toString();
                yi4Var.f = X();
                yi4Var.g = false;
                yi4Var.h = true;
                yi4Var.i = str;
                yi4Var.k = 3;
                g2.u(b2, yi4Var);
                HttpRequest build2 = b2.build();
                if (!optBoolean) {
                }
                fh2.k().r(str, httpUrl2);
                return new Pair<>(build2, Integer.valueOf(i2));
            }
            return new Pair<>(null, 0);
        }
        return (Pair) invokeLL.objValue;
    }

    public static RequestBody F(MediaType mediaType, @NonNull byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, mediaType, bArr)) == null) {
            return RequestBody.create(mediaType, bArr);
        }
        return (RequestBody) invokeLL.objValue;
    }

    @NonNull
    public static String J(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jSONObject)) == null) {
            String optString = jSONObject.optString("dataType");
            if (TextUtils.isEmpty(optString)) {
                return "json";
            }
            if (!g.contains(optString)) {
                return EMABTest.TYPE_STRING;
            }
            return optString;
        }
        return (String) invokeL.objValue;
    }

    public static long K(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, response)) == null) {
            if (response.body() != null) {
                return response.body().contentLength();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    @NonNull
    public static String L(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, jSONObject)) == null) {
            String optString = jSONObject.optString("responseType");
            if (!h.contains(optString)) {
                return "text";
            }
            return optString;
        }
        return (String) invokeL.objValue;
    }

    public static boolean O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.trim().startsWith(PreferencesUtil.LEFT_MOUNT);
        }
        return invokeL.booleanValue;
    }

    public v32 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#cancelRequest", false);
            return l(str, false, new a(this));
        }
        return (v32) invokeL.objValue;
    }

    public static boolean P(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if ((!str.trim().startsWith("{") || !str.trim().endsWith("}")) && (!str.trim().startsWith(PreferencesUtil.LEFT_MOUNT) || !str.trim().endsWith(PreferencesUtil.RIGHT_MOUNT))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static Object Q(@NonNull JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, jSONObject, str)) == null) {
            Object opt = jSONObject.opt("data");
            if (TextUtils.equals(str, "base64")) {
                if (opt instanceof String) {
                    return Base64.decode((String) opt, 2);
                }
                return opt;
            } else if (opt instanceof JsArrayBuffer) {
                return ((JsArrayBuffer) opt).buffer();
            } else {
                return opt;
            }
        }
        return invokeLL.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v7, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r6v9, types: [org.json.JSONArray] */
    public static void R(@NonNull JSONObject jSONObject, @Nullable ResponseBody responseBody, @NonNull String str, @NonNull String str2) throws IOException, JSONException {
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65550, null, jSONObject, responseBody, str, str2) != null) || responseBody == null) {
            return;
        }
        char c2 = 65535;
        int hashCode = str2.hashCode();
        if (hashCode != 3556653) {
            if (hashCode == 1154818009 && str2.equals("arraybuffer")) {
                c2 = 0;
            }
        } else if (str2.equals("text")) {
            c2 = 1;
        }
        if (c2 != 0) {
            str3 = responseBody.string();
        } else {
            byte[] bytes = responseBody.bytes();
            if (bytes == null) {
                str3 = null;
            } else {
                str3 = new String(Base64.encode(bytes, 2));
            }
            str = EMABTest.TYPE_STRING;
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        if (TextUtils.equals(str, "json")) {
            try {
                if (P(str3)) {
                    if (O(str3)) {
                        str4 = new JSONArray(str3);
                    } else {
                        str4 = new JSONObject(str3);
                    }
                    str3 = str4;
                }
            } catch (JSONException unused) {
            }
        }
        jSONObject.put("data", str3);
    }

    public static void W(String str, @NonNull HttpRequestBuilder httpRequestBuilder, @Nullable JSONObject jSONObject, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65552, null, str, httpRequestBuilder, jSONObject, map) == null) {
            if (jSONObject != null && jSONObject.length() >= 1) {
                Iterator<String> keys = jSONObject.keys();
                String str2 = "";
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next) && !i.contains(next.toUpperCase())) {
                        String f2 = pp3.f(jSONObject.optString(next));
                        if (TextUtils.isEmpty(f2)) {
                            f2 = "";
                        }
                        if (map != null) {
                            map.put(next.toLowerCase(), f2);
                        }
                        if ("Cookie".equalsIgnoreCase(next)) {
                            str2 = f2;
                        }
                        httpRequestBuilder.addHeader(next, f2);
                    }
                }
                A(httpRequestBuilder, str, str2);
                return;
            }
            A(httpRequestBuilder, str, "");
        }
    }

    public static void S(vb3 vb3Var, String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{vb3Var, str, Long.valueOf(j2), Long.valueOf(j3)}) == null) && vb3Var != null && !TextUtils.isEmpty(str) && j2 >= 0) {
            on3 on3Var = new on3();
            on3Var.k(5L);
            on3Var.i(39L);
            wi3 wi3Var = new wi3();
            wi3Var.p(on3Var);
            wi3Var.r(vb3Var.W());
            wi3Var.q(oi3.n(ub3.K().k()));
            wi3Var.m(ub3.K().getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("exceptionUrl", str);
                jSONObject.put("exceptionAppID", vb3Var.O());
                jSONObject.put("exceptionLength", j2);
                jSONObject.put("exceptionRequestTime", j3);
                jSONObject.put("exceptionResponseTime", System.currentTimeMillis());
                wi3Var.e(jSONObject);
            } catch (JSONException unused) {
            }
            oi3.R(wi3Var);
        }
    }

    public static boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            vb3 M = vb3.M();
            if (M != null && M.e0().f("mapp_set_user_agent")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean E(@NonNull vb3 vb3Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, f fVar, @NonNull String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{vb3Var, jSONObject, str, str2, fVar, str3})) == null) {
            return cv2.e().i(vb3Var, jSONObject, str, str2, new e(this, vb3Var, jSONObject, str, str2, fVar, str3), new d(this, str3));
        }
        return invokeCommon.booleanValue;
    }

    public void I(vb3 vb3Var, JSONObject jSONObject, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, vb3Var, jSONObject, str, str2) == null) {
            if (w53.i()) {
                N(vb3Var, jSONObject, str, str2);
            } else {
                ExecutorUtilsExt.postOnElastic(new b(this, vb3Var, jSONObject, str, str2), "doRequest", 0);
            }
        }
    }

    public final void M(@NonNull vb3 vb3Var, @NonNull JSONObject jSONObject, @NonNull HttpRequest httpRequest, @NonNull String str, f fVar, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{vb3Var, jSONObject, httpRequest, str, fVar, str2}) == null) {
            HttpUrl url = httpRequest.getOkRequest().url();
            String httpUrl = url.toString();
            if (E(vb3Var, jSONObject, httpUrl, str, fVar, str2)) {
                return;
            }
            httpRequest.executeStat(new c(this, str, url, httpUrl, vb3Var.Y().G(), System.currentTimeMillis(), new e(this, vb3Var, jSONObject, httpUrl, str, fVar, str2), httpRequest));
        }
    }

    public final void N(vb3 vb3Var, JSONObject jSONObject, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, vb3Var, jSONObject, str, str2) == null) {
            Pair<HttpRequest, Integer> C = C(jSONObject, str);
            HttpRequest httpRequest = (HttpRequest) C.first;
            if (httpRequest == null) {
                d(str2, Y(((Integer) C.second).intValue()));
            } else {
                M(vb3Var, jSONObject, httpRequest, str, null, str2);
            }
        }
    }

    public v32 T(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            Pair<u32, JSONObject> t = yz1.t(jsObject);
            if (!((u32) t.first).isSuccess()) {
                p("#request parseParams fail", null, false);
                return (v32) t.first;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            if (jSONObject == null) {
                p("#request params parsed as JSONObject is null", null, true);
                return (v32) u32.a;
            }
            vb3 M = vb3.M();
            if (M == null) {
                p("#request swan app is null", null, false);
                return new v32(1001, "swan app is null");
            }
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p("#request cb is empty", null, true);
                return new v32(1001, "cb is empty");
            }
            return U(M, jSONObject, optString);
        }
        return (v32) invokeL.objValue;
    }

    public v32 V(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jSONObject)) == null) {
            vb3 b0 = vb3.b0();
            if (b0 == null) {
                p("#request swan app is null", null, false);
                return new v32(1001, "swan app is null");
            }
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p("#request cb is empty", null, true);
                return new v32(202, "cb is empty");
            }
            return U(b0, jSONObject, optString);
        }
        return (v32) invokeL.objValue;
    }
}
