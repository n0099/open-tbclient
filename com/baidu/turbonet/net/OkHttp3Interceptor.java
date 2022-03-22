package com.baidu.turbonet.net;

import android.util.Log;
import c.a.q0.b.e.d;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes6.dex */
public class OkHttp3Interceptor implements Interceptor {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static Field f37725c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f37726d;

    /* renamed from: e  reason: collision with root package name */
    public static Constructor<RealResponseBody> f37727e;
    public transient /* synthetic */ FieldHolder $fh;
    public CookieJar a;

    /* renamed from: b  reason: collision with root package name */
    public TurbonetEngine f37728b;

    /* loaded from: classes6.dex */
    public class a implements c.a.q0.b.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(OkHttp3Interceptor okHttp3Interceptor, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {okHttp3Interceptor, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.q0.b.d.b
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.a.disconnect();
            }
        }

        @Override // c.a.q0.b.d.b
        public void b(Exception exc, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc, j) == null) {
                this.a.disconnect();
            }
        }

        @Override // c.a.q0.b.d.b
        public void onComplete(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                this.a.disconnect();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c.a.q0.b.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.q0.b.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OkHttp3Interceptor f37729b;

        public b(OkHttp3Interceptor okHttp3Interceptor, c.a.q0.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {okHttp3Interceptor, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37729b = okHttp3Interceptor;
            this.a = aVar;
        }

        @Override // c.a.q0.b.d.b
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                c.a.q0.b.a aVar = this.a;
                aVar.f21016e = j;
                aVar.c();
                c.a.q0.b.a aVar2 = this.a;
                aVar2.f21014c = -12;
                aVar2.d(this.f37729b.f37728b);
            }
        }

        @Override // c.a.q0.b.d.b
        public void b(Exception exc, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc, j) == null) {
                c.a.q0.b.a aVar = this.a;
                aVar.f21016e = j;
                aVar.c();
                this.a.a(exc);
                this.a.d(this.f37729b.f37728b);
            }
        }

        @Override // c.a.q0.b.d.b
        public void onComplete(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                c.a.q0.b.a aVar = this.a;
                aVar.f21016e = j;
                aVar.c();
                c.a.q0.b.a aVar2 = this.a;
                aVar2.f21014c = 0;
                aVar2.d(this.f37729b.f37728b);
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
            f37725c = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            Log.e("tn_OkHttp3Intercept", "Can not find source field from RealResponseBody.", e2);
            f37725c = null;
        }
        try {
            boolean c2 = OkHttpVersionUtil.c();
            f37726d = c2;
            if (c2) {
                f37727e = RealResponseBody.class.getConstructor(String.class, Long.TYPE, BufferedSource.class);
                Log.d("tn_OkHttp3Intercept", "found okhttp 3.9+");
                return;
            }
            f37727e = RealResponseBody.class.getConstructor(Headers.class, BufferedSource.class);
            Log.d("tn_OkHttp3Intercept", "found okhttp 3.8-");
        } catch (IllegalArgumentException e3) {
            Log.e("tn_OkHttp3Intercept", "severe error: found unsupported okhttp version", e3);
            f37727e = null;
        } catch (NoSuchMethodException e4) {
            Log.e("tn_OkHttp3Intercept", "severe error: found unsupported okhttp version", e4);
            f37727e = null;
        } catch (NoSuchElementException e5) {
            Log.e("tn_OkHttp3Intercept", "severe error: found unsupported okhttp version", e5);
            f37727e = null;
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
        this.f37728b = b2;
        if (b2 == null) {
            throw new NullPointerException("TurbonetEngine is null.");
        }
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
                sb.append('=');
                sb.append(cookie.value());
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public final Response c(Interceptor.Chain chain, Request request) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chain, request)) == null) {
            if (f37725c == null) {
                return chain.proceed(request);
            }
            c.a.q0.b.a aVar = new c.a.q0.b.a(request.url().toString());
            aVar.f21013b = request.method();
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
            aVar.b();
            aVar.f21015d = proceed.code();
            ResponseBody body2 = proceed.body();
            RealResponseBody realResponseBody = body2 instanceof RealResponseBody ? (RealResponseBody) body2 : null;
            if (this.a != CookieJar.NO_COOKIES) {
                List<Cookie> parseAll = Cookie.parseAll(request.url(), proceed.headers());
                if (!parseAll.isEmpty()) {
                    this.a.saveFromResponse(request.url(), parseAll);
                }
            }
            if (realResponseBody != null) {
                try {
                    f37725c.set(realResponseBody, Okio.buffer(Okio.source(new c.a.q0.b.d.a(body2.source().inputStream(), new b(this, aVar)))));
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
            if (f37727e != null && !this.f37728b.f() && (!f37726d || chain.call() != null)) {
                d dVar = new d(new URL(request.url().toString()), this.f37728b);
                dVar.p();
                if (f37726d && chain.call().isCanceled()) {
                    dVar.disconnect();
                    return c(chain, request);
                }
                if (f37726d) {
                    dVar.setReadTimeout(chain.readTimeoutMillis());
                    dVar.setConnectTimeout(chain.connectTimeoutMillis());
                }
                Headers headers = request.headers();
                for (String str : headers.names()) {
                    dVar.addRequestProperty(str, headers.get(str));
                }
                List<Cookie> loadForRequest = this.a.loadForRequest(request.url());
                if (loadForRequest != null && !loadForRequest.isEmpty()) {
                    dVar.addRequestProperty("Cookie", b(loadForRequest));
                }
                dVar.setRequestMethod(request.method());
                try {
                    if (request.body() != null) {
                        if (request.body().contentType() != null) {
                            dVar.setRequestProperty("Content-Type", request.body().contentType().toString());
                        }
                        dVar.setDoOutput(true);
                        OutputStream outputStream = dVar.getOutputStream();
                        BufferedSink buffer = Okio.buffer(Okio.sink(outputStream));
                        request.body().writeTo(buffer);
                        buffer.flush();
                        outputStream.close();
                    }
                    int responseCode = dVar.getResponseCode();
                    if (f37726d && chain.call().isCanceled()) {
                        dVar.disconnect();
                        return c(chain, request);
                    }
                    String str2 = dVar.y().e().toString();
                    try {
                        protocol = Protocol.get(str2);
                    } catch (IOException unused) {
                        Log.e("tn_OkHttp3Intercept", "Unexpected protocol: " + str2);
                        protocol = Protocol.HTTP_1_1;
                    }
                    Response.Builder builder = new Response.Builder();
                    builder.request(request).protocol(protocol).code(responseCode).message(dVar.getResponseMessage());
                    Headers.Builder builder2 = new Headers.Builder();
                    for (Map.Entry<String, List<String>> entry : dVar.getHeaderFields().entrySet()) {
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
                        errorStream = dVar.getInputStream();
                    } else {
                        errorStream = dVar.getErrorStream();
                    }
                    BufferedSource buffer2 = Okio.buffer(Okio.source(new c.a.q0.b.d.a(errorStream, new a(this, dVar))));
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
                        if (f37726d) {
                            builder.body(f37727e.newInstance(builder2.get("Content-Type"), j, buffer2));
                        } else {
                            builder.body(f37727e.newInstance(builder2.build(), buffer2));
                        }
                    } catch (Exception e3) {
                        Log.e("tn_OkHttp3Intercept", "unexpected error:" + e3.toString());
                    }
                    String responseMessage = dVar.getResponseMessage();
                    if (responseMessage == null) {
                        responseMessage = "";
                    }
                    return builder.message(responseMessage).build();
                } catch (IOException e4) {
                    Log.e("tn_OkHttp3Intercept", "Write data or build connection caught exception: " + e4.toString());
                    dVar.disconnect();
                    return c(chain, request);
                }
            }
            return c(chain, request);
        }
        return (Response) invokeL.objValue;
    }
}
