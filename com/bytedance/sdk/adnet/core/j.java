package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.adnet.err.VAdError;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes4.dex */
public class j implements com.bytedance.sdk.adnet.e.a {

    /* renamed from: b  reason: collision with root package name */
    private final SSLSocketFactory f6337b;
    private final b ppu;

    /* loaded from: classes4.dex */
    public interface b {
        String a(String str);
    }

    public j() {
        this(null);
    }

    public j(b bVar) {
        this(bVar, null);
    }

    public j(b bVar, SSLSocketFactory sSLSocketFactory) {
        this.ppu = bVar;
        this.f6337b = sSLSocketFactory;
    }

    @Override // com.bytedance.sdk.adnet.e.a
    public com.bytedance.sdk.adnet.core.b a(Request<?> request, Map<String, String> map) throws IOException, VAdError {
        String str;
        boolean z;
        String url = request.getUrl();
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(request.getUserAgent())) {
            hashMap.put("User-Agent", request.getUserAgent());
        }
        hashMap.putAll(map);
        hashMap.putAll(request.getHeaders());
        if (this.ppu != null) {
            str = this.ppu.a(url);
            if (str == null) {
                throw new IOException("URL blocked by rewriter: " + url);
            }
        } else {
            str = url;
        }
        HttpURLConnection a2 = a(new URL(str), request);
        try {
            for (String str2 : hashMap.keySet()) {
                a2.setRequestProperty(str2, (String) hashMap.get(str2));
            }
            a(a2, request);
            int responseCode = a2.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if (!a(request.getMethod(), responseCode)) {
                com.bytedance.sdk.adnet.core.b bVar = new com.bytedance.sdk.adnet.core.b(responseCode, a(a2.getHeaderFields()));
                a2.disconnect();
                return bVar;
            }
            z = true;
            try {
                return new com.bytedance.sdk.adnet.core.b(responseCode, a(a2.getHeaderFields()), a2.getContentLength(), new a(a2));
            } catch (Throwable th) {
                th = th;
                if (!z) {
                    a2.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    @VisibleForTesting
    static List<com.bytedance.sdk.adnet.core.a> a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String str : entry.getValue()) {
                    arrayList.add(new com.bytedance.sdk.adnet.core.a(entry.getKey(), str));
                }
            }
        }
        return arrayList;
    }

    private static boolean a(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    /* loaded from: classes4.dex */
    static class a extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        private final HttpURLConnection f6338a;

        a(HttpURLConnection httpURLConnection) {
            super(j.f(httpURLConnection));
            this.f6338a = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            this.f6338a.disconnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream f(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException e) {
            return httpURLConnection.getErrorStream();
        }
    }

    protected HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = null;
        if (url != null) {
            String host = url.getHost();
            String a2 = com.bytedance.sdk.adnet.a.poD != null ? com.bytedance.sdk.adnet.a.poD.a(host) : null;
            if (!TextUtils.isEmpty(a2)) {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(url.toString().replaceFirst(host, a2)).openConnection();
                    httpURLConnection.setRequestProperty("Host", host);
                    if (httpURLConnection == null) {
                        httpURLConnection = (HttpURLConnection) url.openConnection();
                    }
                } catch (Exception e) {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                }
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        }
        return httpURLConnection;
    }

    private HttpURLConnection a(URL url, Request<?> request) throws IOException {
        HttpURLConnection a2 = a(url);
        b(request);
        int timeoutMs = request.getTimeoutMs();
        a2.setConnectTimeout(timeoutMs);
        a2.setReadTimeout(timeoutMs);
        a2.setUseCaches(false);
        a2.setDoInput(true);
        if ("https".equals(url.getProtocol())) {
            if (a(a2)) {
                r.b("connection verify by inner", new Object[0]);
            } else if (this.f6337b == null) {
                com.bytedance.sdk.adnet.d.b.a();
            } else {
                ((HttpsURLConnection) a2).setSSLSocketFactory(this.f6337b);
            }
        }
        return a2;
    }

    private void b(Request<?> request) {
        if (request != null) {
            request.setIpAddrStr(f(request));
        }
    }

    private String f(Request<?> request) {
        if (request == null || request.getUrl() == null) {
            return "";
        }
        try {
            return InetAddress.getByName(new URL(request.getUrl()).getHost()).getHostAddress();
        } catch (Exception e) {
            return "";
        }
    }

    protected boolean a(HttpURLConnection httpURLConnection) {
        return false;
    }

    static void a(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, com.bytedance.sdk.adnet.err.a {
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    httpURLConnection.setRequestMethod("POST");
                    a(httpURLConnection, request, postBody);
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                b(httpURLConnection, request);
                return;
            case 2:
                httpURLConnection.setRequestMethod(HttpPut.METHOD_NAME);
                b(httpURLConnection, request);
                return;
            case 3:
                httpURLConnection.setRequestMethod(HttpDelete.METHOD_NAME);
                return;
            case 4:
                httpURLConnection.setRequestMethod(HttpHead.METHOD_NAME);
                return;
            case 5:
                httpURLConnection.setRequestMethod(HttpOptions.METHOD_NAME);
                return;
            case 6:
                httpURLConnection.setRequestMethod(HttpTrace.METHOD_NAME);
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                b(httpURLConnection, request);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void b(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, com.bytedance.sdk.adnet.err.a {
        byte[] body = request.getBody();
        if (body != null) {
            a(httpURLConnection, request, body);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Request<?> request, byte[] bArr) throws IOException {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", request.getBodyContentType());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }
}
