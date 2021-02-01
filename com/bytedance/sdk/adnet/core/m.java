package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.ac;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.a.b.z;
import com.bytedance.sdk.adnet.err.VAdError;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes6.dex */
public class m implements com.bytedance.sdk.adnet.e.a {

    /* renamed from: a  reason: collision with root package name */
    private final z f6044a;

    public m() {
        this.f6044a = new z.a().d(10000L, TimeUnit.MILLISECONDS).e(10000L, TimeUnit.MILLISECONDS).f(10000L, TimeUnit.MILLISECONDS).eqs();
    }

    public m(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager, HostnameVerifier hostnameVerifier) {
        this.f6044a = new z.a().d(10000L, TimeUnit.MILLISECONDS).e(10000L, TimeUnit.MILLISECONDS).f(10000L, TimeUnit.MILLISECONDS).a(hostnameVerifier == null ? com.bytedance.sdk.a.b.a.i.e.pqO : hostnameVerifier).a(sSLSocketFactory == null ? new com.bytedance.sdk.adnet.d.h() : sSLSocketFactory, x509TrustManager == null ? com.bytedance.sdk.adnet.d.h.f6058a : x509TrustManager).eqs();
    }

    @Override // com.bytedance.sdk.adnet.e.a
    public b a(Request<?> request, Map<String, String> map) throws IOException, VAdError {
        int timeoutMs = request.getTimeoutMs();
        z eqs = this.f6044a.eqr().d(timeoutMs, TimeUnit.MILLISECONDS).e(timeoutMs, TimeUnit.MILLISECONDS).f(timeoutMs, TimeUnit.MILLISECONDS).Bd(true).Bc(true).eqs();
        ab.a h = h(request);
        if (h == null) {
            throw new IllegalArgumentException("request params maybe null");
        }
        b(request);
        if (!TextUtils.isEmpty(request.getUserAgent())) {
            h.YP("User-Agent").hn("User-Agent", request.getUserAgent() + " " + com.bytedance.sdk.a.b.a.d.a());
        }
        Map<String, String> headers = request.getHeaders();
        if (headers != null) {
            for (String str : headers.keySet()) {
                h.hn(str, headers.get(str));
            }
        }
        if (map != null) {
            for (String str2 : map.keySet()) {
                h.hm(str2, map.get(str2));
            }
        }
        a(h, request);
        com.bytedance.sdk.a.b.b epJ = eqs.g(h.eqB()).epJ();
        com.bytedance.sdk.a.b.a.c.k g = com.bytedance.sdk.a.b.a.c.k.g(epJ);
        com.bytedance.sdk.a.b.c epF = epJ.epF();
        boolean z = false;
        try {
            int i = g.f5887b;
            if (i == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if (!a(request.getMethod(), i)) {
                b bVar = new b(i, f(epJ.epE()));
                epF.close();
                return bVar;
            }
            try {
                return new b(i, f(epJ.epE()), (int) epF.b(), new a(epF));
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    epF.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
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

    private ab.a h(Request request) throws IOException {
        boolean z;
        if (request == null || request.getUrl() == null) {
            return null;
        }
        ab.a aVar = new ab.a();
        URL url = new URL(request.getUrl());
        String host = url.getHost();
        String a2 = com.bytedance.sdk.adnet.a.puo != null ? com.bytedance.sdk.adnet.a.puo.a(host) : null;
        if (TextUtils.isEmpty(a2)) {
            z = false;
        } else {
            try {
                aVar.e(new URL(url.toString().replaceFirst(host, a2))).hn("Host", host);
                z = true;
            } catch (Exception e) {
                z = false;
            }
        }
        if (!z) {
            aVar.e(url);
        }
        return aVar;
    }

    private static boolean a(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    private static List<com.bytedance.sdk.adnet.core.a> f(v vVar) {
        if (vVar == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(vVar.a());
        int a2 = vVar.a();
        for (int i = 0; i < a2; i++) {
            String a3 = vVar.a(i);
            String b2 = vVar.b(i);
            if (a3 != null) {
                arrayList.add(new com.bytedance.sdk.adnet.core.a(a3, b2));
            }
        }
        return arrayList;
    }

    private static void a(ab.a aVar, Request<?> request) throws IOException, com.bytedance.sdk.adnet.err.a {
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    aVar.a(ac.b(y.YN(request.getBodyContentType()), postBody));
                    return;
                }
                return;
            case 0:
                aVar.eqy();
                return;
            case 1:
                aVar.a(i(request));
                return;
            case 2:
                aVar.c(i(request));
                return;
            case 3:
                aVar.eqA();
                return;
            case 4:
                aVar.eqz();
                return;
            case 5:
                aVar.a(HttpOptions.METHOD_NAME, null);
                return;
            case 6:
                aVar.a(HttpTrace.METHOD_NAME, null);
                return;
            case 7:
                aVar.d(i(request));
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static ac i(Request request) throws com.bytedance.sdk.adnet.err.a {
        byte[] body = request.getBody();
        if (body == null) {
            if (request.getMethod() == 1) {
                body = "".getBytes();
            } else {
                return null;
            }
        }
        return ac.b(y.YN(request.getBodyContentType()), body);
    }

    /* loaded from: classes6.dex */
    static class a extends FilterInputStream {
        private final com.bytedance.sdk.a.b.c pvi;

        a(com.bytedance.sdk.a.b.c cVar) {
            super(m.b(cVar));
            this.pvi = cVar;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            try {
                this.pvi.close();
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream b(com.bytedance.sdk.a.b.c cVar) {
        if (cVar == null) {
            return null;
        }
        return cVar.c();
    }
}
