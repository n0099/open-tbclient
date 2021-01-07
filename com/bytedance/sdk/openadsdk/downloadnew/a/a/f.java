package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import android.net.http.Headers;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.ss.android.socialbase.downloader.i.g;
import com.ss.android.socialbase.downloader.i.h;
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
/* loaded from: classes4.dex */
public class f implements h {

    /* renamed from: a  reason: collision with root package name */
    protected final WeakReference<Context> f7380a;

    public f(Context context) {
        this.f7380a = new WeakReference<>(context);
    }

    @Override // com.ss.android.socialbase.downloader.i.h
    public g a(int i, String str, List<com.ss.android.socialbase.downloader.g.e> list) throws IOException {
        final int responseCode;
        final HttpURLConnection a2 = a(str, list);
        if (a2 != null && (responseCode = a2.getResponseCode()) >= 200 && responseCode < 300) {
            final Map<String, String> a3 = a(a2);
            InputStream inputStream = a2.getInputStream();
            String contentEncoding = a2.getContentEncoding();
            final InputStream gZIPInputStream = (TextUtils.isEmpty(contentEncoding) || !contentEncoding.contains("gzip")) ? inputStream : new GZIPInputStream(inputStream);
            return new g() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.f.1
                @Override // com.ss.android.socialbase.downloader.i.g
                public InputStream a() {
                    return gZIPInputStream;
                }

                @Override // com.ss.android.socialbase.downloader.i.e
                public String a(String str2) {
                    return (String) a3.get(str2);
                }

                @Override // com.ss.android.socialbase.downloader.i.e
                public int b() {
                    return responseCode;
                }

                @Override // com.ss.android.socialbase.downloader.i.e
                public void c() {
                }

                @Override // com.ss.android.socialbase.downloader.i.g
                public void d() {
                    try {
                        a2.disconnect();
                    } catch (Exception e) {
                    }
                }
            };
        }
        return null;
    }

    @Nullable
    private HttpURLConnection a(String str, List<com.ss.android.socialbase.downloader.g.e> list) {
        HttpURLConnection httpURLConnection;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith("https")) {
                com.bytedance.sdk.adnet.d.b.a();
            }
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setInstanceFollowRedirects(false);
                httpURLConnection2.setRequestProperty(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, "*/*");
                httpURLConnection2.setRequestProperty(Headers.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                if (list != null && !list.isEmpty()) {
                    for (com.ss.android.socialbase.downloader.g.e eVar : list) {
                        httpURLConnection2.setRequestProperty(eVar.a(), eVar.b());
                    }
                }
                httpURLConnection2.connect();
                int responseCode = httpURLConnection2.getResponseCode();
                if ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) {
                    return a(httpURLConnection2.getHeaderField(com.baidubce.http.Headers.LOCATION), list);
                }
                return httpURLConnection2;
            } catch (Exception e) {
                return httpURLConnection;
            }
        } catch (Exception e2) {
            return null;
        }
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
