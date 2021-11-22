package com.baidu.turbonet.net;

import b.a.s0.b.e.d;
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
/* loaded from: classes9.dex */
public class OkHttp3Interceptor implements Interceptor {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static Field f57441c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f57442d;

    /* renamed from: e  reason: collision with root package name */
    public static Constructor<RealResponseBody> f57443e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CookieJar f57444a;

    /* renamed from: b  reason: collision with root package name */
    public TurbonetEngine f57445b;

    /* loaded from: classes9.dex */
    public class a implements b.a.s0.b.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f57446a;

        public a(OkHttp3Interceptor okHttp3Interceptor, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {okHttp3Interceptor, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57446a = dVar;
        }

        @Override // b.a.s0.b.d.b
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f57446a.disconnect();
            }
        }

        @Override // b.a.s0.b.d.b
        public void b(Exception exc, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc, j) == null) {
                this.f57446a.disconnect();
            }
        }

        @Override // b.a.s0.b.d.b
        public void onComplete(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                this.f57446a.disconnect();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements b.a.s0.b.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.s0.b.a f57447a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OkHttp3Interceptor f57448b;

        public b(OkHttp3Interceptor okHttp3Interceptor, b.a.s0.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {okHttp3Interceptor, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57448b = okHttp3Interceptor;
            this.f57447a = aVar;
        }

        @Override // b.a.s0.b.d.b
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                b.a.s0.b.a aVar = this.f57447a;
                aVar.f29497e = j;
                aVar.c();
                b.a.s0.b.a aVar2 = this.f57447a;
                aVar2.f29495c = -12;
                aVar2.d(this.f57448b.f57445b);
            }
        }

        @Override // b.a.s0.b.d.b
        public void b(Exception exc, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc, j) == null) {
                b.a.s0.b.a aVar = this.f57447a;
                aVar.f29497e = j;
                aVar.c();
                this.f57447a.a(exc);
                this.f57447a.d(this.f57448b.f57445b);
            }
        }

        @Override // b.a.s0.b.d.b
        public void onComplete(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                b.a.s0.b.a aVar = this.f57447a;
                aVar.f29497e = j;
                aVar.c();
                b.a.s0.b.a aVar2 = this.f57447a;
                aVar2.f29495c = 0;
                aVar2.d(this.f57448b.f57445b);
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
            f57441c = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
            f57441c = null;
        }
        try {
            boolean c2 = OkHttpVersionUtil.c();
            f57442d = c2;
            if (c2) {
                f57443e = RealResponseBody.class.getConstructor(String.class, Long.TYPE, BufferedSource.class);
            } else {
                f57443e = RealResponseBody.class.getConstructor(Headers.class, BufferedSource.class);
            }
        } catch (IllegalArgumentException unused2) {
            f57443e = null;
        } catch (NoSuchMethodException unused3) {
            f57443e = null;
        } catch (NoSuchElementException unused4) {
            f57443e = null;
        }
    }

    public OkHttp3Interceptor(TurbonetContext turbonetContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {turbonetContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57444a = CookieJar.NO_COOKIES;
        TurbonetEngine b2 = turbonetContext.b();
        this.f57445b = b2;
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
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 > 0) {
                    sb.append("; ");
                }
                Cookie cookie = list.get(i2);
                sb.append(cookie.name());
                sb.append(com.alipay.sdk.encrypt.a.f34958h);
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
            if (f57441c == null) {
                return chain.proceed(request);
            }
            b.a.s0.b.a aVar = new b.a.s0.b.a(request.url().toString());
            aVar.f29494b = request.method();
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
            List<Cookie> loadForRequest = this.f57444a.loadForRequest(request.url());
            if (!loadForRequest.isEmpty()) {
                newBuilder.header("Cookie", b(loadForRequest));
            }
            Response proceed = chain.proceed(newBuilder.build());
            aVar.b();
            aVar.f29496d = proceed.code();
            ResponseBody body2 = proceed.body();
            RealResponseBody realResponseBody = body2 instanceof RealResponseBody ? (RealResponseBody) body2 : null;
            if (this.f57444a != CookieJar.NO_COOKIES) {
                List<Cookie> parseAll = Cookie.parseAll(request.url(), proceed.headers());
                if (!parseAll.isEmpty()) {
                    this.f57444a.saveFromResponse(request.url(), parseAll);
                }
            }
            if (realResponseBody != null) {
                try {
                    f57441c.set(realResponseBody, Okio.buffer(Okio.source(new b.a.s0.b.d.a(body2.source().inputStream(), new b(this, aVar)))));
                } catch (IllegalAccessException unused) {
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
            if (f57443e != null && !this.f57445b.f() && (!f57442d || chain.call() != null)) {
                d dVar = new d(new URL(request.url().toString()), this.f57445b);
                dVar.p();
                if (f57442d && chain.call().isCanceled()) {
                    dVar.disconnect();
                    return c(chain, request);
                }
                if (f57442d) {
                    dVar.setReadTimeout(chain.readTimeoutMillis());
                    dVar.setConnectTimeout(chain.connectTimeoutMillis());
                }
                Headers headers = request.headers();
                for (String str : headers.names()) {
                    dVar.addRequestProperty(str, headers.get(str));
                }
                List<Cookie> loadForRequest = this.f57444a.loadForRequest(request.url());
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
                    if (f57442d && chain.call().isCanceled()) {
                        dVar.disconnect();
                        return c(chain, request);
                    }
                    String str2 = dVar.y().e().toString();
                    try {
                        protocol = Protocol.get(str2);
                    } catch (IOException unused) {
                        String str3 = "Unexpected protocol: " + str2;
                        protocol = Protocol.HTTP_1_1;
                    }
                    Response.Builder builder = new Response.Builder();
                    builder.request(request).protocol(protocol).code(responseCode).message(dVar.getResponseMessage());
                    Headers.Builder builder2 = new Headers.Builder();
                    for (Map.Entry<String, List<String>> entry : dVar.getHeaderFields().entrySet()) {
                        for (String str4 : entry.getValue()) {
                            if (entry.getKey() != null && !entry.getKey().isEmpty() && entry.getValue() != null) {
                                builder.addHeader(entry.getKey(), str4);
                                builder2.add(entry.getKey(), str4);
                            }
                        }
                    }
                    Headers build = builder2.build();
                    if (this.f57444a != CookieJar.NO_COOKIES) {
                        List<Cookie> parseAll = Cookie.parseAll(request.url(), build);
                        if (!parseAll.isEmpty()) {
                            this.f57444a.saveFromResponse(request.url(), parseAll);
                        }
                    }
                    if (responseCode >= 200 && responseCode < 400) {
                        errorStream = dVar.getInputStream();
                    } else {
                        errorStream = dVar.getErrorStream();
                    }
                    BufferedSource buffer2 = Okio.buffer(Okio.source(new b.a.s0.b.d.a(errorStream, new a(this, dVar))));
                    if (builder2.get("Content-Length") == null) {
                        j = -1L;
                    } else {
                        try {
                            j = Long.valueOf(builder2.get("Content-Length"));
                        } catch (NumberFormatException unused2) {
                            String str5 = "invalid content length: " + builder2.get("Content-Length").toString();
                            j = 0L;
                        }
                    }
                    try {
                        if (f57442d) {
                            builder.body(f57443e.newInstance(builder2.get("Content-Type"), j, buffer2));
                        } else {
                            builder.body(f57443e.newInstance(builder2.build(), buffer2));
                        }
                    } catch (Exception e2) {
                        String str6 = "unexpected error:" + e2.toString();
                    }
                    String responseMessage = dVar.getResponseMessage();
                    if (responseMessage == null) {
                        responseMessage = "";
                    }
                    return builder.message(responseMessage).build();
                } catch (IOException e3) {
                    String str7 = "Write data or build connection caught exception: " + e3.toString();
                    dVar.disconnect();
                    return c(chain, request);
                }
            }
            return c(chain, request);
        }
        return (Response) invokeL.objValue;
    }
}
