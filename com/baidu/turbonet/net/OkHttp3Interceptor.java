package com.baidu.turbonet.net;

import android.util.Log;
import d.b.j0.b.e.d;
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
    public static Field f22472c = null;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f22473d = false;

    /* renamed from: e  reason: collision with root package name */
    public static Constructor<RealResponseBody> f22474e;

    /* renamed from: a  reason: collision with root package name */
    public CookieJar f22475a = CookieJar.NO_COOKIES;

    /* renamed from: b  reason: collision with root package name */
    public TurbonetEngine f22476b;

    /* loaded from: classes5.dex */
    public class a implements d.b.j0.b.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f22477a;

        public a(OkHttp3Interceptor okHttp3Interceptor, d dVar) {
            this.f22477a = dVar;
        }

        @Override // d.b.j0.b.d.b
        public void a(Exception exc, long j) {
            this.f22477a.disconnect();
        }

        @Override // d.b.j0.b.d.b
        public void b(long j) {
            this.f22477a.disconnect();
        }

        @Override // d.b.j0.b.d.b
        public void onComplete(long j) {
            this.f22477a.disconnect();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.b.j0.b.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.b.a f22478a;

        public b(d.b.j0.b.a aVar) {
            this.f22478a = aVar;
        }

        @Override // d.b.j0.b.d.b
        public void a(Exception exc, long j) {
            d.b.j0.b.a aVar = this.f22478a;
            aVar.f64496e = j;
            aVar.c();
            this.f22478a.a(exc);
            this.f22478a.d(OkHttp3Interceptor.this.f22476b);
        }

        @Override // d.b.j0.b.d.b
        public void b(long j) {
            d.b.j0.b.a aVar = this.f22478a;
            aVar.f64496e = j;
            aVar.c();
            d.b.j0.b.a aVar2 = this.f22478a;
            aVar2.f64494c = -12;
            aVar2.d(OkHttp3Interceptor.this.f22476b);
        }

        @Override // d.b.j0.b.d.b
        public void onComplete(long j) {
            d.b.j0.b.a aVar = this.f22478a;
            aVar.f64496e = j;
            aVar.c();
            d.b.j0.b.a aVar2 = this.f22478a;
            aVar2.f64494c = 0;
            aVar2.d(OkHttp3Interceptor.this.f22476b);
        }
    }

    static {
        try {
            Field declaredField = RealResponseBody.class.getDeclaredField("source");
            f22472c = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            Log.e("tn_OkHttp3Intercept", "Can not find source field from RealResponseBody.", e2);
            f22472c = null;
        }
        try {
            boolean c2 = OkHttpVersionUtil.c();
            f22473d = c2;
            if (c2) {
                f22474e = RealResponseBody.class.getConstructor(String.class, Long.TYPE, BufferedSource.class);
                Log.d("tn_OkHttp3Intercept", "found okhttp 3.9+");
                return;
            }
            f22474e = RealResponseBody.class.getConstructor(Headers.class, BufferedSource.class);
            Log.d("tn_OkHttp3Intercept", "found okhttp 3.8-");
        } catch (IllegalArgumentException e3) {
            Log.e("tn_OkHttp3Intercept", "severe error: found unsupported okhttp version", e3);
            f22474e = null;
        } catch (NoSuchMethodException e4) {
            Log.e("tn_OkHttp3Intercept", "severe error: found unsupported okhttp version", e4);
            f22474e = null;
        } catch (NoSuchElementException e5) {
            Log.e("tn_OkHttp3Intercept", "severe error: found unsupported okhttp version", e5);
            f22474e = null;
        }
    }

    public OkHttp3Interceptor(TurbonetContext turbonetContext) {
        TurbonetEngine b2 = turbonetContext.b();
        this.f22476b = b2;
        if (b2 == null) {
            throw new NullPointerException("TurbonetEngine is null.");
        }
    }

    public final String b(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            Cookie cookie = list.get(i);
            sb.append(cookie.name());
            sb.append(com.alipay.sdk.encrypt.a.f1922h);
            sb.append(cookie.value());
        }
        return sb.toString();
    }

    public final Response c(Interceptor.Chain chain, Request request) throws IOException {
        if (f22472c == null) {
            return chain.proceed(request);
        }
        d.b.j0.b.a aVar = new d.b.j0.b.a(request.url().toString());
        aVar.f64493b = request.method();
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
        List<Cookie> loadForRequest = this.f22475a.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header("Cookie", b(loadForRequest));
        }
        Response proceed = chain.proceed(newBuilder.build());
        aVar.b();
        aVar.f64495d = proceed.code();
        ResponseBody body2 = proceed.body();
        RealResponseBody realResponseBody = body2 instanceof RealResponseBody ? (RealResponseBody) body2 : null;
        if (this.f22475a != CookieJar.NO_COOKIES) {
            List<Cookie> parseAll = Cookie.parseAll(request.url(), proceed.headers());
            if (!parseAll.isEmpty()) {
                this.f22475a.saveFromResponse(request.url(), parseAll);
            }
        }
        if (realResponseBody != null) {
            try {
                f22472c.set(realResponseBody, Okio.buffer(Okio.source(new d.b.j0.b.d.a(body2.source().inputStream(), new b(aVar)))));
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
        if (f22474e != null && !this.f22476b.f() && (!f22473d || chain.call() != null)) {
            d dVar = new d(new URL(request.url().toString()), this.f22476b);
            dVar.p();
            if (f22473d && chain.call().isCanceled()) {
                dVar.disconnect();
                return c(chain, request);
            }
            if (f22473d) {
                dVar.setReadTimeout(chain.readTimeoutMillis());
                dVar.setConnectTimeout(chain.connectTimeoutMillis());
            }
            Headers headers = request.headers();
            for (String str : headers.names()) {
                dVar.addRequestProperty(str, headers.get(str));
            }
            List<Cookie> loadForRequest = this.f22475a.loadForRequest(request.url());
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
                if (f22473d && chain.call().isCanceled()) {
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
                if (this.f22475a != CookieJar.NO_COOKIES) {
                    List<Cookie> parseAll = Cookie.parseAll(request.url(), build);
                    if (!parseAll.isEmpty()) {
                        this.f22475a.saveFromResponse(request.url(), parseAll);
                    }
                }
                if (responseCode >= 200 && responseCode < 400) {
                    errorStream = dVar.getInputStream();
                } else {
                    errorStream = dVar.getErrorStream();
                }
                BufferedSource buffer2 = Okio.buffer(Okio.source(new d.b.j0.b.d.a(errorStream, new a(this, dVar))));
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
                    if (f22473d) {
                        builder.body(f22474e.newInstance(builder2.get("Content-Type"), j, buffer2));
                    } else {
                        builder.body(f22474e.newInstance(builder2.build(), buffer2));
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
