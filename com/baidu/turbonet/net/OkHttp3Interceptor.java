package com.baidu.turbonet.net;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.he9;
import com.baidu.tieba.ke9;
import com.baidu.tieba.le9;
import com.baidu.tieba.pe9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
/* loaded from: classes7.dex */
public class OkHttp3Interceptor implements Interceptor {
    public static /* synthetic */ Interceptable $ic;
    public static Field c;
    public static boolean d;
    public static Constructor<RealResponseBody> e;
    public transient /* synthetic */ FieldHolder $fh;
    public CookieJar a;
    public TurbonetEngine b;

    /* loaded from: classes7.dex */
    public class a implements le9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pe9 a;

        public a(OkHttp3Interceptor okHttp3Interceptor, pe9 pe9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {okHttp3Interceptor, pe9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pe9Var;
        }

        @Override // com.baidu.tieba.le9
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.a.disconnect();
            }
        }

        @Override // com.baidu.tieba.le9
        public void onComplete(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                this.a.disconnect();
            }
        }

        @Override // com.baidu.tieba.le9
        public void b(Exception exc, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc, j) == null) {
                this.a.disconnect();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements le9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he9 a;
        public final /* synthetic */ OkHttp3Interceptor b;

        public b(OkHttp3Interceptor okHttp3Interceptor, he9 he9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {okHttp3Interceptor, he9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = okHttp3Interceptor;
            this.a = he9Var;
        }

        @Override // com.baidu.tieba.le9
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                he9 he9Var = this.a;
                he9Var.e = j;
                he9Var.c();
                he9 he9Var2 = this.a;
                he9Var2.c = -12;
                he9Var2.d(this.b.b);
            }
        }

        @Override // com.baidu.tieba.le9
        public void onComplete(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                he9 he9Var = this.a;
                he9Var.e = j;
                he9Var.c();
                he9 he9Var2 = this.a;
                he9Var2.c = 0;
                he9Var2.d(this.b.b);
            }
        }

        @Override // com.baidu.tieba.le9
        public void b(Exception exc, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc, j) == null) {
                he9 he9Var = this.a;
                he9Var.e = j;
                he9Var.c();
                this.a.a(exc);
                this.a.d(this.b.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1481403569, "Lcom/baidu/turbonet/net/OkHttp3Interceptor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1481403569, "Lcom/baidu/turbonet/net/OkHttp3Interceptor;");
                return;
            }
        }
        try {
            Field declaredField = RealResponseBody.class.getDeclaredField("source");
            c = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            Log.e("tn_OkHttp3Intercept", "Can not find source field from RealResponseBody.", e2);
            c = null;
        }
        try {
            boolean c2 = OkHttpVersionUtil.c();
            d = c2;
            if (c2) {
                e = RealResponseBody.class.getConstructor(String.class, Long.TYPE, BufferedSource.class);
                Log.d("tn_OkHttp3Intercept", "found okhttp 3.9+");
                return;
            }
            e = RealResponseBody.class.getConstructor(Headers.class, BufferedSource.class);
            Log.d("tn_OkHttp3Intercept", "found okhttp 3.8-");
        } catch (IllegalArgumentException e3) {
            Log.e("tn_OkHttp3Intercept", "severe error: found unsupported okhttp version", e3);
            e = null;
        } catch (NoSuchMethodException e4) {
            Log.e("tn_OkHttp3Intercept", "severe error: found unsupported okhttp version", e4);
            e = null;
        } catch (NoSuchElementException e5) {
            Log.e("tn_OkHttp3Intercept", "severe error: found unsupported okhttp version", e5);
            e = null;
        }
    }

    public OkHttp3Interceptor(TurbonetContext turbonetContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {turbonetContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = CookieJar.NO_COOKIES;
        TurbonetEngine b2 = turbonetContext.b();
        this.b = b2;
        if (b2 != null) {
            return;
        }
        throw new NullPointerException("TurbonetEngine is null.");
    }

    public final String b(List<Cookie> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    sb.append("; ");
                }
                Cookie cookie = list.get(i);
                sb.append(cookie.name());
                sb.append(com.alipay.sdk.encrypt.a.h);
                sb.append(cookie.value());
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public final Response c(Interceptor.Chain chain, Request request) throws IOException {
        InterceptResult invokeLL;
        RealResponseBody realResponseBody;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chain, request)) == null) {
            if (c == null) {
                return chain.proceed(request);
            }
            he9 he9Var = new he9(request.url().toString());
            he9Var.b = request.method();
            Request.Builder newBuilder = request.newBuilder();
            RequestBody body = request.body();
            if (body != null) {
                MediaType contentType = body.contentType();
                if (contentType != null) {
                    newBuilder.header("Content-Type", contentType.toString());
                }
                long contentLength = body.contentLength();
                if (contentLength != -1) {
                    newBuilder.header("Content-Length", Long.toString(contentLength));
                    newBuilder.removeHeader("Transfer-Encoding");
                } else {
                    newBuilder.header("Transfer-Encoding", "chunked");
                    newBuilder.removeHeader("Content-Length");
                }
            }
            if (request.header("User-Agent") == null) {
                newBuilder.header("User-Agent", okhttp3.internal.Version.userAgent());
            }
            List<Cookie> loadForRequest = this.a.loadForRequest(request.url());
            if (!loadForRequest.isEmpty()) {
                newBuilder.header("Cookie", b(loadForRequest));
            }
            Response proceed = chain.proceed(newBuilder.build());
            he9Var.b();
            he9Var.d = proceed.code();
            ResponseBody body2 = proceed.body();
            if (body2 instanceof RealResponseBody) {
                realResponseBody = (RealResponseBody) body2;
            } else {
                realResponseBody = null;
            }
            if (this.a != CookieJar.NO_COOKIES) {
                List<Cookie> parseAll = Cookie.parseAll(request.url(), proceed.headers());
                if (!parseAll.isEmpty()) {
                    this.a.saveFromResponse(request.url(), parseAll);
                }
            }
            if (realResponseBody != null) {
                try {
                    c.set(realResponseBody, Okio.buffer(Okio.source(new ke9(body2.source().inputStream(), new b(this, he9Var)))));
                } catch (IllegalAccessException e2) {
                    Log.e("tn_OkHttp3Intercept", "Can not set ProxyInputStream to Okio's InputStream", e2);
                }
            }
            return proceed;
        }
        return (Response) invokeLL.objValue;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InterceptResult invokeL;
        Protocol protocol;
        InputStream errorStream;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chain)) == null) {
            Request request = chain.request();
            if (e != null && !this.b.f() && (!d || chain.call() != null)) {
                pe9 pe9Var = new pe9(new URL(request.url().toString()), this.b);
                pe9Var.p();
                if (d && chain.call().isCanceled()) {
                    pe9Var.disconnect();
                    return c(chain, request);
                }
                if (d) {
                    pe9Var.setReadTimeout(chain.readTimeoutMillis());
                    pe9Var.setConnectTimeout(chain.connectTimeoutMillis());
                }
                Headers headers = request.headers();
                for (String str : headers.names()) {
                    pe9Var.addRequestProperty(str, headers.get(str));
                }
                List<Cookie> loadForRequest = this.a.loadForRequest(request.url());
                if (loadForRequest != null && !loadForRequest.isEmpty()) {
                    pe9Var.addRequestProperty("Cookie", b(loadForRequest));
                }
                pe9Var.setRequestMethod(request.method());
                try {
                    if (request.body() != null) {
                        if (request.body().contentType() != null) {
                            pe9Var.setRequestProperty("Content-Type", request.body().contentType().toString());
                        }
                        pe9Var.setDoOutput(true);
                        OutputStream outputStream = pe9Var.getOutputStream();
                        BufferedSink buffer = Okio.buffer(Okio.sink(outputStream));
                        request.body().writeTo(buffer);
                        buffer.flush();
                        outputStream.close();
                    }
                    int responseCode = pe9Var.getResponseCode();
                    if (d && chain.call().isCanceled()) {
                        pe9Var.disconnect();
                        return c(chain, request);
                    }
                    String str2 = pe9Var.y().e().toString();
                    try {
                        protocol = Protocol.get(str2);
                    } catch (IOException unused) {
                        Log.e("tn_OkHttp3Intercept", "Unexpected protocol: " + str2);
                        protocol = Protocol.HTTP_1_1;
                    }
                    Response.Builder builder = new Response.Builder();
                    builder.request(request).protocol(protocol).code(responseCode).message(pe9Var.getResponseMessage());
                    Headers.Builder builder2 = new Headers.Builder();
                    for (Map.Entry<String, List<String>> entry : pe9Var.getHeaderFields().entrySet()) {
                        for (String str3 : entry.getValue()) {
                            if (entry.getKey() != null && !entry.getKey().isEmpty() && entry.getValue() != null) {
                                builder.addHeader(entry.getKey(), str3);
                                builder2.add(entry.getKey(), str3);
                            }
                        }
                    }
                    Headers build = builder2.build();
                    if (this.a != CookieJar.NO_COOKIES) {
                        List<Cookie> parseAll = Cookie.parseAll(request.url(), build);
                        if (!parseAll.isEmpty()) {
                            this.a.saveFromResponse(request.url(), parseAll);
                        }
                    }
                    if (responseCode >= 200 && responseCode < 400) {
                        errorStream = pe9Var.getInputStream();
                    } else {
                        errorStream = pe9Var.getErrorStream();
                    }
                    BufferedSource buffer2 = Okio.buffer(Okio.source(new ke9(errorStream, new a(this, pe9Var))));
                    if (builder2.get("Content-Length") == null) {
                        j = -1L;
                    } else {
                        try {
                            j = Long.valueOf(builder2.get("Content-Length"));
                        } catch (NumberFormatException e2) {
                            Log.e("tn_OkHttp3Intercept", "invalid content length: " + builder2.get("Content-Length").toString(), e2);
                            j = 0L;
                        }
                    }
                    try {
                        if (d) {
                            builder.body(e.newInstance(builder2.get("Content-Type"), j, buffer2));
                        } else {
                            builder.body(e.newInstance(builder2.build(), buffer2));
                        }
                    } catch (Exception e3) {
                        Log.e("tn_OkHttp3Intercept", "unexpected error:" + e3.toString());
                    }
                    String responseMessage = pe9Var.getResponseMessage();
                    if (responseMessage == null) {
                        responseMessage = "";
                    }
                    return builder.message(responseMessage).build();
                } catch (IOException e4) {
                    Log.e("tn_OkHttp3Intercept", "Write data or build connection caught exception: " + e4.toString());
                    pe9Var.disconnect();
                    return c(chain, request);
                }
            }
            return c(chain, request);
        }
        return (Response) invokeL.objValue;
    }
}
