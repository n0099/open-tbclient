package com.baidu.turbonet.net;

import android.util.Log;
import com.baidu.turbonet.net.a.d;
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
import org.apache.http.cookie.SM;
import org.apache.http.protocol.HTTP;
/* loaded from: classes14.dex */
public class OkHttp3Interceptor implements Interceptor {
    private static Field onR;
    private static boolean onT;
    private static Constructor<RealResponseBody> onU;
    private CookieJar onS = CookieJar.NO_COOKIES;
    private TurbonetEngine onV;

    static {
        onT = false;
        try {
            onR = RealResponseBody.class.getDeclaredField("source");
            onR.setAccessible(true);
        } catch (NoSuchFieldException e) {
            Log.e("tn_OkHttp3Intercept", "Can not find source field from RealResponseBody.", e);
            onR = null;
        }
        try {
            onT = OkHttpVersionUtil.eca();
            if (onT) {
                onU = RealResponseBody.class.getConstructor(String.class, Long.TYPE, BufferedSource.class);
                Log.d("tn_OkHttp3Intercept", "found okhttp 3.9+");
                return;
            }
            onU = RealResponseBody.class.getConstructor(Headers.class, BufferedSource.class);
            Log.d("tn_OkHttp3Intercept", "found okhttp 3.8-");
        } catch (IllegalArgumentException e2) {
            Log.e("tn_OkHttp3Intercept", "severe error: found unsupported okhttp version", e2);
            onU = null;
        } catch (NoSuchMethodException e3) {
            Log.e("tn_OkHttp3Intercept", "severe error: found unsupported okhttp version", e3);
            onU = null;
        } catch (NoSuchElementException e4) {
            Log.e("tn_OkHttp3Intercept", "severe error: found unsupported okhttp version", e4);
            onU = null;
        }
    }

    public OkHttp3Interceptor(TurbonetContext turbonetContext) {
        this.onV = turbonetContext.eck();
        if (this.onV == null) {
            throw new NullPointerException("TurbonetEngine is null.");
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Protocol protocol;
        InputStream errorStream;
        long j;
        Request request = chain.request();
        if (onU == null || this.onV.ebO() || (onT && chain.call() == null)) {
            return a(chain, request);
        }
        final d dVar = new d(new URL(request.url().toString()), this.onV);
        dVar.ecW();
        if (onT && chain.call().isCanceled()) {
            dVar.disconnect();
            return a(chain, request);
        }
        if (onT) {
            dVar.setReadTimeout(chain.readTimeoutMillis());
            dVar.setConnectTimeout(chain.connectTimeoutMillis());
        }
        Headers headers = request.headers();
        for (String str : headers.names()) {
            dVar.addRequestProperty(str, headers.get(str));
        }
        List<Cookie> loadForRequest = this.onS.loadForRequest(request.url());
        if (loadForRequest != null && !loadForRequest.isEmpty()) {
            dVar.addRequestProperty(SM.COOKIE, cookieHeader(loadForRequest));
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
            if (onT && chain.call().isCanceled()) {
                dVar.disconnect();
                return a(chain, request);
            }
            String str2 = dVar.ecV().ecD().toString();
            try {
                protocol = Protocol.get(str2);
            } catch (IOException e) {
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
            if (this.onS != CookieJar.NO_COOKIES) {
                List<Cookie> parseAll = Cookie.parseAll(request.url(), build);
                if (!parseAll.isEmpty()) {
                    this.onS.saveFromResponse(request.url(), parseAll);
                }
            }
            if (responseCode >= 200 && responseCode < 400) {
                errorStream = dVar.getInputStream();
            } else {
                errorStream = dVar.getErrorStream();
            }
            BufferedSource buffer2 = Okio.buffer(Okio.source(new com.baidu.turbonet.net.proxy.a(errorStream, new com.baidu.turbonet.net.proxy.b() { // from class: com.baidu.turbonet.net.OkHttp3Interceptor.1
                @Override // com.baidu.turbonet.net.proxy.b
                public void a(Exception exc, long j2) {
                    dVar.disconnect();
                }

                @Override // com.baidu.turbonet.net.proxy.b
                public void onComplete(long j2) {
                    dVar.disconnect();
                }

                @Override // com.baidu.turbonet.net.proxy.b
                public void hn(long j2) {
                    dVar.disconnect();
                }
            })));
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
                if (onT) {
                    builder.body(onU.newInstance(builder2.get("Content-Type"), j, buffer2));
                } else {
                    builder.body(onU.newInstance(builder2.build(), buffer2));
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
            return a(chain, request);
        }
    }

    private String cookieHeader(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            Cookie cookie = list.get(i);
            sb.append(cookie.name()).append('=').append(cookie.value());
        }
        return sb.toString();
    }

    private Response a(Interceptor.Chain chain, Request request) throws IOException {
        if (onR == null) {
            return chain.proceed(request);
        }
        final a aVar = new a(request.url().toString());
        aVar.dSu = request.method();
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
                newBuilder.header("Transfer-Encoding", HTTP.CHUNK_CODING);
                newBuilder.removeHeader("Content-Length");
            }
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", okhttp3.internal.Version.userAgent());
        }
        List<Cookie> loadForRequest = this.onS.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header(SM.COOKIE, cookieHeader(loadForRequest));
        }
        Response proceed = chain.proceed(newBuilder.build());
        aVar.ebP();
        aVar.ont = proceed.code();
        ResponseBody body2 = proceed.body();
        RealResponseBody realResponseBody = body2 instanceof RealResponseBody ? (RealResponseBody) body2 : null;
        if (this.onS != CookieJar.NO_COOKIES) {
            List<Cookie> parseAll = Cookie.parseAll(request.url(), proceed.headers());
            if (!parseAll.isEmpty()) {
                this.onS.saveFromResponse(request.url(), parseAll);
            }
        }
        if (realResponseBody != null) {
            try {
                onR.set(realResponseBody, Okio.buffer(Okio.source(new com.baidu.turbonet.net.proxy.a(body2.source().inputStream(), new com.baidu.turbonet.net.proxy.b() { // from class: com.baidu.turbonet.net.OkHttp3Interceptor.2
                    @Override // com.baidu.turbonet.net.proxy.b
                    public void a(Exception exc, long j) {
                        aVar.onu = j;
                        aVar.ebQ();
                        aVar.A(exc);
                        aVar.a(OkHttp3Interceptor.this.onV);
                    }

                    @Override // com.baidu.turbonet.net.proxy.b
                    public void onComplete(long j) {
                        aVar.onu = j;
                        aVar.ebQ();
                        aVar.ons = 0;
                        aVar.a(OkHttp3Interceptor.this.onV);
                    }

                    @Override // com.baidu.turbonet.net.proxy.b
                    public void hn(long j) {
                        aVar.onu = j;
                        aVar.ebQ();
                        aVar.ons = -12;
                        aVar.a(OkHttp3Interceptor.this.onV);
                    }
                }))));
            } catch (IllegalAccessException e) {
                Log.e("tn_OkHttp3Intercept", "Can not set ProxyInputStream to Okio's InputStream", e);
            }
        }
        return proceed;
    }
}
