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
import com.baidu.tieba.ou1;
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
/* loaded from: classes9.dex */
public class zv1 extends rv1 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> f;
    public static final Set<String> g;
    public static final Set<String> h;
    public static final Set<String> i;
    public static final List<String> j;
    @SuppressLint({"BDOfflineUrl"})
    public static final String[] k;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public interface f {
        void a(JSONObject jSONObject);
    }

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "RequestApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public class a implements ou1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv1 a;

        public a(zv1 zv1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv1Var;
        }

        @Override // com.baidu.tieba.ou1.a
        public ly1 a(k63 k63Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            od4 g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, k63Var, jSONObject, str)) == null) {
                String optString = jSONObject.optString("cancelTag");
                if (TextUtils.isEmpty(optString)) {
                    return new ly1(202, "illegal cancelTag");
                }
                zv1 zv1Var = this.a;
                zv1Var.r("#cancelRequest cancelTag=" + optString, false);
                if (zv1.j.remove(optString)) {
                    g = od4.l();
                } else {
                    g = od4.g();
                }
                SwanAppNetworkUtils.a(g.getOkHttpClient(), optString);
                return ly1.f();
            }
            return (ly1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k63 a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ zv1 e;

        public b(zv1 zv1Var, k63 k63Var, JSONObject jSONObject, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv1Var, k63Var, jSONObject, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zv1Var;
            this.a = k63Var;
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
            this.e.O(this.a, this.b, this.c, this.d);
        }
    }

    /* loaded from: classes9.dex */
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

        public c(zv1 zv1Var, String str, HttpUrl httpUrl, String str2, int i, long j, e eVar, HttpRequest httpRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv1Var, str, httpUrl, str2, Integer.valueOf(i), Long.valueOf(j), eVar, httpRequest};
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

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback, com.baidu.tieba.tf4.a
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                dd3.C(this.c, this.d, null, this.e, System.currentTimeMillis(), this.a);
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
                ub2.k().C(this.a, this.b, networkStatRecord);
                dd3.C(this.c, this.d, networkStatRecord, this.e, System.currentTimeMillis(), this.a);
                this.f.onResponse(null, response);
                return response;
            }
            return invokeLIL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d implements dl3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ zv1 b;

        public d(zv1 zv1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zv1Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.b.d(this.a, new ly1(1001, str));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public k63 a;
        public JSONObject b;
        public String c;
        public String d;
        public f e;
        public String f;
        public long g;
        public final /* synthetic */ zv1 h;

        public e(@NonNull zv1 zv1Var, @NonNull k63 k63Var, @NonNull JSONObject jSONObject, @NonNull String str, String str2, @NonNull f fVar, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv1Var, k63Var, jSONObject, str, str2, fVar, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = zv1Var;
            this.a = k63Var;
            this.b = jSONObject;
            this.c = str;
            this.d = str2;
            this.e = fVar;
            this.f = str3;
            this.g = System.currentTimeMillis();
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            od4 g;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                int H = this.a.Z().H();
                String l = dd3.l();
                String e = ek3.n().e();
                if (zv1.j.remove(this.d)) {
                    g = od4.l();
                } else {
                    g = od4.g();
                }
                SwanAppNetworkUtils.a(g.getOkHttpClient(), this.d);
                this.h.d(this.f, new ly1(1001, iOException.getMessage()));
                dd3.Q(0, this.c, H, iOException.getMessage(), l, e, this.g, System.currentTimeMillis(), this.d);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!dd3.o(this.c)) {
                    gf3.l().x(this.c, response.headers("Set-cookie"));
                }
                String K = zv1.K(this.b);
                String M = zv1.M(this.b);
                int H = this.a.Z().H();
                long currentTimeMillis = System.currentTimeMillis();
                String l = dd3.l();
                String e = ek3.n().e();
                try {
                    long L = zv1.L(response);
                    if (L <= Config.FULL_TRACE_LOG_LIMIT) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("statusCode", response.code());
                        jSONObject.put("header", aw1.g(response.headers()));
                        zv1.S(jSONObject, response.body(), K, M);
                        if (this.e != null) {
                            this.e.a(jSONObject);
                        }
                        this.h.d(this.f, new ly1(0, jSONObject, true));
                    } else {
                        this.h.d(this.f, new ly1(201, "response json length over limits"));
                        zv1.T(this.a, this.c, L, currentTimeMillis);
                    }
                } catch (IOException | JSONException e2) {
                    this.h.d(this.f, new ly1(201, e2.getMessage()));
                }
                dd3.Q(response.code(), this.c, H, response.message(), l, e, this.g, System.currentTimeMillis(), this.d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948373300, "Lcom/baidu/tieba/zv1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948373300, "Lcom/baidu/tieba/zv1;");
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
    public zv1(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @NonNull
    public static ly1 Z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65555, null, i2)) == null) {
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
                return new ly1(i3);
            }
            return new ly1(i3, str);
        }
        return (ly1) invokeI.objValue;
    }

    public static void B(@NonNull HttpRequestBuilder httpRequestBuilder, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65539, null, httpRequestBuilder, str, str2) != null) || dd3.o(str)) {
            return;
        }
        String f2 = gf3.l().f(str, str2);
        if (!TextUtils.isEmpty(f2)) {
            httpRequestBuilder.setHeader("Cookie", f2);
        }
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public static HttpUrl C(@NonNull HttpUrl httpUrl, @NonNull Object obj, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, httpUrl, obj, str)) == null) {
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
    public static RequestBody H(@Nullable Object obj, Map<String, String> map, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, obj, map, str)) == null) {
            String str2 = map.get(Headers.CONTENT_TYPE);
            String str3 = "";
            if (TextUtils.isEmpty(str2)) {
                if (obj instanceof byte[]) {
                    return G(rx2.a, (byte[]) obj);
                }
                MediaType mediaType = rx2.a;
                if (obj != null) {
                    str3 = obj.toString();
                }
                return RequestBody.create(mediaType, str3);
            }
            MediaType parse = MediaType.parse(str2);
            if (rx2.a.equals(parse)) {
                if (obj instanceof byte[]) {
                    return G(rx2.a, (byte[]) obj);
                }
                MediaType mediaType2 = rx2.a;
                if (obj != null) {
                    str3 = obj.toString();
                }
                return RequestBody.create(mediaType2, str3);
            }
            return I(obj, parse, str);
        }
        return (RequestBody) invokeLLL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static RequestBody I(@Nullable Object obj, MediaType mediaType, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, obj, mediaType, str)) == null) {
            FormBody.Builder builder = new FormBody.Builder();
            if (obj instanceof byte[]) {
                return G(mediaType, (byte[]) obj);
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
                return px2.a(builder.build(), mediaType);
            }
            return builder.build();
        }
        return (RequestBody) invokeLLL.objValue;
    }

    public final ly1 V(@NonNull k63 k63Var, @NonNull JSONObject jSONObject, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, k63Var, jSONObject, str)) == null) {
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                q("#request illegal url", new Exception("stack"), true);
                return new ly1(1001, "illegal url");
            }
            r("#request url=" + optString, false);
            String a2 = aw1.a(k63Var.b);
            JSONObject c2 = aw1.c(a2);
            xx1.d().c(new gy1(this, k63Var, jSONObject, a2, str));
            return new ly1(0, c2);
        }
        return (ly1) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<HttpRequest, Integer> D(@Nullable JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        od4 g2;
        int i2;
        HttpUrl httpUrl;
        boolean z;
        HttpUrl httpUrl2;
        RequestBody H;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, jSONObject, str)) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                HttpUrl f2 = aw1.f(jSONObject.optString("url"));
                if (f2 == null) {
                    return new Pair<>(null, 0);
                }
                String httpUrl3 = f2.toString();
                if (i03.a() == 1) {
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
                        g2 = od4.l();
                    } else {
                        g2 = od4.g();
                    }
                } else {
                    g2 = od4.g();
                }
                String optString = jSONObject.optString("__plugin__");
                boolean optBoolean = jSONObject.optBoolean("ping", false);
                if (!optBoolean) {
                    i2 = b73.c("request", httpUrl3, optString);
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
                nd4 nd4Var = new nd4();
                nd4Var.b = upperCase;
                HttpRequestBuilder b2 = pd4.b(nd4Var, g2);
                X(httpUrl3, b2, jSONObject.optJSONObject("header"), hashMap);
                b2.setHeader("Referer", aw1.d());
                if (!TextUtils.isEmpty(optString)) {
                    b2.setHeader("X-SWAN-HOSTSIGN", h23.b(i23.h(optString)));
                }
                String optString3 = jSONObject.optString("__requestDataType__");
                Object R = R(jSONObject, optString3);
                if (R instanceof byte[]) {
                    httpUrl = f2;
                    if (((byte[]) R).length > Config.FULL_TRACE_LOG_LIMIT) {
                        return new Pair<>(null, 3);
                    }
                } else {
                    httpUrl = f2;
                }
                if (R != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && !HttpMethod.permitsRequestBody(upperCase)) {
                    httpUrl2 = C(httpUrl, R, optString3);
                } else {
                    httpUrl2 = httpUrl;
                    if (z || HttpMethod.requiresRequestBody(upperCase)) {
                        H = H(R, hashMap, optString3);
                        if (!HttpMethod.requiresRequestBody(upperCase) && H == null) {
                            return new Pair<>(null, Integer.valueOf(i2));
                        }
                        if (b2 instanceof HttpCommonRequestBuilder) {
                            ((HttpCommonRequestBuilder) b2).requestBody(H);
                        }
                        nd4Var.a = httpUrl2.toString();
                        nd4Var.f = Y();
                        nd4Var.g = false;
                        nd4Var.h = true;
                        nd4Var.i = str;
                        nd4Var.k = 3;
                        g2.u(b2, nd4Var);
                        HttpRequest build = b2.build();
                        if (!optBoolean) {
                            build = cy2.e(build, "request", optString);
                        }
                        ub2.k().r(str, httpUrl2);
                        return new Pair<>(build, Integer.valueOf(i2));
                    }
                }
                H = null;
                if (!HttpMethod.requiresRequestBody(upperCase)) {
                }
                if (b2 instanceof HttpCommonRequestBuilder) {
                }
                nd4Var.a = httpUrl2.toString();
                nd4Var.f = Y();
                nd4Var.g = false;
                nd4Var.h = true;
                nd4Var.i = str;
                nd4Var.k = 3;
                g2.u(b2, nd4Var);
                HttpRequest build2 = b2.build();
                if (!optBoolean) {
                }
                ub2.k().r(str, httpUrl2);
                return new Pair<>(build2, Integer.valueOf(i2));
            }
            return new Pair<>(null, 0);
        }
        return (Pair) invokeLL.objValue;
    }

    public static RequestBody G(MediaType mediaType, @NonNull byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, mediaType, bArr)) == null) {
            return RequestBody.create(mediaType, bArr);
        }
        return (RequestBody) invokeLL.objValue;
    }

    @NonNull
    public static String K(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jSONObject)) == null) {
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

    public static long L(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, response)) == null) {
            if (response.body() != null) {
                return response.body().contentLength();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    @NonNull
    public static String M(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, jSONObject)) == null) {
            String optString = jSONObject.optString("responseType");
            if (!h.contains(optString)) {
                return "text";
            }
            return optString;
        }
        return (String) invokeL.objValue;
    }

    public static boolean P(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.trim().startsWith(PreferencesUtil.LEFT_MOUNT);
        }
        return invokeL.booleanValue;
    }

    public ly1 E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            r("#cancelRequest", false);
            return m(str, false, new a(this));
        }
        return (ly1) invokeL.objValue;
    }

    public static boolean Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
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
    public static Object R(@NonNull JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, jSONObject, str)) == null) {
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
    public static void S(@NonNull JSONObject jSONObject, @Nullable ResponseBody responseBody, @NonNull String str, @NonNull String str2) throws IOException, JSONException {
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65551, null, jSONObject, responseBody, str, str2) != null) || responseBody == null) {
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
                if (Q(str3)) {
                    if (P(str3)) {
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

    public static void X(String str, @NonNull HttpRequestBuilder httpRequestBuilder, @Nullable JSONObject jSONObject, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65553, null, str, httpRequestBuilder, jSONObject, map) == null) {
            if (jSONObject != null && jSONObject.length() >= 1) {
                Iterator<String> keys = jSONObject.keys();
                String str2 = "";
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next) && !i.contains(next.toUpperCase())) {
                        String f2 = ek3.f(jSONObject.optString(next));
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
                B(httpRequestBuilder, str, str2);
                return;
            }
            B(httpRequestBuilder, str, "");
        }
    }

    public static void T(k63 k63Var, String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{k63Var, str, Long.valueOf(j2), Long.valueOf(j3)}) == null) && k63Var != null && !TextUtils.isEmpty(str) && j2 >= 0) {
            di3 di3Var = new di3();
            di3Var.k(5L);
            di3Var.i(39L);
            ld3 ld3Var = new ld3();
            ld3Var.p(di3Var);
            ld3Var.r(k63Var.X());
            ld3Var.q(dd3.n(j63.K().k()));
            ld3Var.m(j63.K().getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("exceptionUrl", str);
                jSONObject.put("exceptionAppID", k63Var.P());
                jSONObject.put("exceptionLength", j2);
                jSONObject.put("exceptionRequestTime", j3);
                jSONObject.put("exceptionResponseTime", System.currentTimeMillis());
                ld3Var.e(jSONObject);
            } catch (JSONException unused) {
            }
            dd3.R(ld3Var);
        }
    }

    public static boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            k63 M = k63.M();
            if (M != null && M.f0().f("mapp_set_user_agent")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean F(@NonNull k63 k63Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, f fVar, @NonNull String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{k63Var, jSONObject, str, str2, fVar, str3})) == null) {
            return rp2.e().i(k63Var, jSONObject, str, str2, new e(this, k63Var, jSONObject, str, str2, fVar, str3), new d(this, str3));
        }
        return invokeCommon.booleanValue;
    }

    public void J(k63 k63Var, JSONObject jSONObject, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, k63Var, jSONObject, str, str2) == null) {
            if (l03.i()) {
                O(k63Var, jSONObject, str, str2);
            } else {
                ExecutorUtilsExt.postOnElastic(new b(this, k63Var, jSONObject, str, str2), "doRequest", 0);
            }
        }
    }

    public final void N(@NonNull k63 k63Var, @NonNull JSONObject jSONObject, @NonNull HttpRequest httpRequest, @NonNull String str, f fVar, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{k63Var, jSONObject, httpRequest, str, fVar, str2}) == null) {
            HttpUrl url = httpRequest.getOkRequest().url();
            String httpUrl = url.toString();
            if (F(k63Var, jSONObject, httpUrl, str, fVar, str2)) {
                return;
            }
            httpRequest.executeStat(new c(this, str, url, httpUrl, k63Var.Z().H(), System.currentTimeMillis(), new e(this, k63Var, jSONObject, httpUrl, str, fVar, str2), httpRequest));
        }
    }

    public final void O(k63 k63Var, JSONObject jSONObject, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, k63Var, jSONObject, str, str2) == null) {
            Pair<HttpRequest, Integer> D = D(jSONObject, str);
            HttpRequest httpRequest = (HttpRequest) D.first;
            if (httpRequest == null) {
                d(str2, Z(((Integer) D.second).intValue()));
            } else {
                N(k63Var, jSONObject, httpRequest, str, null, str2);
            }
        }
    }

    public ly1 U(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            Pair<ky1, JSONObject> u = ou1.u(jsObject);
            if (!((ky1) u.first).isSuccess()) {
                q("#request parseParams fail", null, false);
                return (ly1) u.first;
            }
            JSONObject jSONObject = (JSONObject) u.second;
            if (jSONObject == null) {
                q("#request params parsed as JSONObject is null", null, true);
                return (ly1) ky1.a;
            }
            k63 M = k63.M();
            if (M == null) {
                q("#request swan app is null", null, false);
                return new ly1(1001, "swan app is null");
            }
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                q("#request cb is empty", null, true);
                return new ly1(1001, "cb is empty");
            }
            return V(M, jSONObject, optString);
        }
        return (ly1) invokeL.objValue;
    }

    public ly1 W(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jSONObject)) == null) {
            k63 c0 = k63.c0();
            if (c0 == null) {
                q("#request swan app is null", null, false);
                return new ly1(1001, "swan app is null");
            }
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                q("#request cb is empty", null, true);
                return new ly1(202, "cb is empty");
            }
            return V(c0, jSONObject, optString);
        }
        return (ly1) invokeL.objValue;
    }
}
