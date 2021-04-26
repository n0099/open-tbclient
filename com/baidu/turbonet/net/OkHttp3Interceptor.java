package com.baidu.turbonet.net;

import android.util.Log;
import d.a.k0.b.e.d;
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
/* loaded from: classes5.dex */
public class OkHttp3Interceptor implements Interceptor {

    /* renamed from: c  reason: collision with root package name */
    public static Field f23176c = null;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f23177d = false;

    /* renamed from: e  reason: collision with root package name */
    public static Constructor<RealResponseBody> f23178e;

    /* renamed from: a  reason: collision with root package name */
    public CookieJar f23179a = CookieJar.NO_COOKIES;

    /* renamed from: b  reason: collision with root package name */
    public TurbonetEngine f23180b;

    /* loaded from: classes5.dex */
    public class a implements d.a.k0.b.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f23181a;

        public a(OkHttp3Interceptor okHttp3Interceptor, d dVar) {
            this.f23181a = dVar;
        }

        @Override // d.a.k0.b.d.b
        public void a(long j) {
            this.f23181a.disconnect();
        }

        @Override // d.a.k0.b.d.b
        public void b(Exception exc, long j) {
            this.f23181a.disconnect();
        }

        @Override // d.a.k0.b.d.b
        public void onComplete(long j) {
            this.f23181a.disconnect();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.a.k0.b.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.b.a f23182a;

        public b(d.a.k0.b.a aVar) {
            this.f23182a = aVar;
        }

        @Override // d.a.k0.b.d.b
        public void a(long j) {
            d.a.k0.b.a aVar = this.f23182a;
            aVar.f63087e = j;
            aVar.c();
            d.a.k0.b.a aVar2 = this.f23182a;
            aVar2.f63085c = -12;
            aVar2.d(OkHttp3Interceptor.this.f23180b);
        }

        @Override // d.a.k0.b.d.b
        public void b(Exception exc, long j) {
            d.a.k0.b.a aVar = this.f23182a;
            aVar.f63087e = j;
            aVar.c();
            this.f23182a.a(exc);
            this.f23182a.d(OkHttp3Interceptor.this.f23180b);
        }

        @Override // d.a.k0.b.d.b
        public void onComplete(long j) {
            d.a.k0.b.a aVar = this.f23182a;
            aVar.f63087e = j;
            aVar.c();
            d.a.k0.b.a aVar2 = this.f23182a;
            aVar2.f63085c = 0;
            aVar2.d(OkHttp3Interceptor.this.f23180b);
        }
    }

    static {
        try {
            Field declaredField = RealResponseBody.class.getDeclaredField("source");
            f23176c = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            Log.e("tn_OkHttp3Intercept", "Can not find source field from RealResponseBody.", e2);
            f23176c = null;
        }
        try {
            boolean c2 = OkHttpVersionUtil.c();
            f23177d = c2;
            if (c2) {
                f23178e = RealResponseBody.class.getConstructor(String.class, Long.TYPE, BufferedSource.class);
                Log.d("tn_OkHttp3Intercept", "found okhttp 3.9+");
                return;
            }
            f23178e = RealResponseBody.class.getConstructor(Headers.class, BufferedSource.class);
            Log.d("tn_OkHttp3Intercept", "found okhttp 3.8-");
        } catch (IllegalArgumentException e3) {
            Log.e("tn_OkHttp3Intercept", "severe error: found unsupported okhttp version", e3);
            f23178e = null;
        } catch (NoSuchMethodException e4) {
            Log.e("tn_OkHttp3Intercept", "severe error: found unsupported okhttp version", e4);
            f23178e = null;
        } catch (NoSuchElementException e5) {
            Log.e("tn_OkHttp3Intercept", "severe error: found unsupported okhttp version", e5);
            f23178e = null;
        }
    }

    public OkHttp3Interceptor(TurbonetContext turbonetContext) {
        TurbonetEngine b2 = turbonetContext.b();
        this.f23180b = b2;
        if (b2 == null) {
            throw new NullPointerException("TurbonetEngine is null.");
        }
    }

    public final String b(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                sb.append("; ");
            }
            Cookie cookie = list.get(i2);
            sb.append(cookie.name());
            sb.append(com.alipay.sdk.encrypt.a.f1873h);
            sb.append(cookie.value());
        }
        return sb.toString();
    }

    public final Response c(Interceptor.Chain chain, Request request) throws IOException {
        if (f23176c == null) {
            return chain.proceed(request);
        }
        d.a.k0.b.a aVar = new d.a.k0.b.a(request.url().toString());
        aVar.f63084b = request.method();
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
        List<Cookie> loadForRequest = this.f23179a.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header("Cookie", b(loadForRequest));
        }
        Response proceed = chain.proceed(newBuilder.build());
        aVar.b();
        aVar.f63086d = proceed.code();
        ResponseBody body2 = proceed.body();
        RealResponseBody realResponseBody = body2 instanceof RealResponseBody ? (RealResponseBody) body2 : null;
        if (this.f23179a != CookieJar.NO_COOKIES) {
            List<Cookie> parseAll = Cookie.parseAll(request.url(), proceed.headers());
            if (!parseAll.isEmpty()) {
                this.f23179a.saveFromResponse(request.url(), parseAll);
            }
        }
        if (realResponseBody != null) {
            try {
                f23176c.set(realResponseBody, Okio.buffer(Okio.source(new d.a.k0.b.d.a(body2.source().inputStream(), new b(aVar)))));
            } catch (IllegalAccessException e2) {
                Log.e("tn_OkHttp3Intercept", "Can not set ProxyInputStream to Okio's InputStream", e2);
            }
        }
        return proceed;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Protocol protocol;
        InputStream errorStream;
        long j;
        Request request = chain.request();
        if (f23178e != null && !this.f23180b.f() && (!f23177d || chain.call() != null)) {
            d dVar = new d(new URL(request.url().toString()), this.f23180b);
            dVar.p();
            if (f23177d && chain.call().isCanceled()) {
                dVar.disconnect();
                return c(chain, request);
            }
            if (f23177d) {
                dVar.setReadTimeout(chain.readTimeoutMillis());
                dVar.setConnectTimeout(chain.connectTimeoutMillis());
            }
            Headers headers = request.headers();
            for (String str : headers.names()) {
                dVar.addRequestProperty(str, headers.get(str));
            }
            List<Cookie> loadForRequest = this.f23179a.loadForRequest(request.url());
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
                if (f23177d && chain.call().isCanceled()) {
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
                if (this.f23179a != CookieJar.NO_COOKIES) {
                    List<Cookie> parseAll = Cookie.parseAll(request.url(), build);
                    if (!parseAll.isEmpty()) {
                        this.f23179a.saveFromResponse(request.url(), parseAll);
                    }
                }
                if (responseCode >= 200 && responseCode < 400) {
                    errorStream = dVar.getInputStream();
                } else {
                    errorStream = dVar.getErrorStream();
                }
                BufferedSource buffer2 = Okio.buffer(Okio.source(new d.a.k0.b.d.a(errorStream, new a(this, dVar))));
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
                    if (f23177d) {
                        builder.body(f23178e.newInstance(builder2.get("Content-Type"), j, buffer2));
                    } else {
                        builder.body(f23178e.newInstance(builder2.build(), buffer2));
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
}
