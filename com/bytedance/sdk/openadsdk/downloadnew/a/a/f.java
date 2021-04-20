package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import d.o.a.e.b.o.k;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public class f implements d.o.a.e.b.o.a {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f28893a;

    public f(Context context) {
        this.f28893a = new WeakReference<>(context);
    }

    @Nullable
    private HttpURLConnection a(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        HttpURLConnection httpURLConnection3 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception unused) {
        }
        try {
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty(BOSTokenRequest.ACCEPT, "*/*");
            httpURLConnection.setRequestProperty("connection", HTTP.CONN_KEEP_ALIVE);
            if (list != null && !list.isEmpty()) {
                for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                    httpURLConnection.setRequestProperty(cVar.a(), cVar.b());
                }
            }
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? a(httpURLConnection.getHeaderField("Location"), list) : httpURLConnection;
        } catch (Exception unused2) {
            httpURLConnection3 = httpURLConnection2;
            return httpURLConnection3;
        }
    }

    @Override // d.o.a.e.b.o.a
    public k downloadWithConnection(int i, String str, List<com.ss.android.socialbase.downloader.model.c> list) throws IOException {
        final int responseCode;
        final HttpURLConnection a2 = a(str, list);
        if (a2 != null && (responseCode = a2.getResponseCode()) >= 200 && responseCode < 300) {
            final Map<String, String> a3 = a(a2);
            InputStream inputStream = a2.getInputStream();
            String contentEncoding = a2.getContentEncoding();
            final GZIPInputStream gZIPInputStream = (TextUtils.isEmpty(contentEncoding) || !contentEncoding.contains(AsyncHttpClient.ENCODING_GZIP)) ? inputStream : new GZIPInputStream(inputStream);
            return new k() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.f.1
                @Override // d.o.a.e.b.o.k
                public InputStream a() {
                    return gZIPInputStream;
                }

                @Override // d.o.a.e.b.o.i
                public int b() {
                    return responseCode;
                }

                @Override // d.o.a.e.b.o.i
                public void c() {
                }

                @Override // d.o.a.e.b.o.k
                public void d() {
                    try {
                        a2.disconnect();
                    } catch (Exception unused) {
                    }
                }

                @Override // d.o.a.e.b.o.i
                public String a(String str2) {
                    return (String) a3.get(str2);
                }
            };
        }
        return null;
    }

    private Map<String, String> a(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i = 0; i < size; i++) {
            hashMap.put(httpURLConnection.getHeaderFieldKey(i), httpURLConnection.getHeaderField(i));
        }
        return hashMap;
    }
}
