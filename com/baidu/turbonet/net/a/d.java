package com.baidu.turbonet.net.a;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.turbonet.net.TurbonetEngine;
import com.baidu.turbonet.net.UrlRequest;
import com.baidu.turbonet.net.UrlRequestException;
import com.baidu.turbonet.net.UrlResponseInfo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes19.dex */
public class d extends HttpURLConnection {
    private UrlResponseInfo mHk;
    private boolean mIh;
    private String mIo;
    private String mIq;
    private final TurbonetEngine mJE;
    private final g mKX;
    private boolean mKZ;
    private boolean mKu;
    private boolean mLa;
    private UrlRequest mLg;
    private e mLh;
    private f mLi;
    private UrlRequestException mLj;
    private boolean mLk;
    private boolean mLl;
    private List<Map.Entry<String, String>> mLm;
    private Map<String, List<String>> mLn;
    private boolean mLo;
    private int mLp;
    private final List<Pair<String, String>> mRequestHeaders;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.mLk = false;
        this.mLl = false;
        this.mLo = false;
        this.mLp = 0;
        this.mKZ = false;
        this.mLa = false;
        this.mJE = turbonetEngine;
        this.mKX = new g(getURL().toString());
        this.mLh = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        dzK();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.mLg.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        dzL();
        return this.mHk.dzu();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        dzL();
        return this.mHk.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            dzL();
            return dzO();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            dzL();
            Map<String, List<String>> dzO = dzO();
            if (dzO.containsKey(str)) {
                List<String> list = dzO.get(str);
                return list.get(list.size() - 1);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        Map.Entry<String, String> HZ = HZ(i);
        if (HZ == null) {
            return null;
        }
        return HZ.getKey();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        Map.Entry<String, String> HZ = HZ(i);
        if (HZ == null) {
            return null;
        }
        return HZ.getValue();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        dzL();
        if (!this.instanceFollowRedirects && this.mLk) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.mHk.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.mLh;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.mLi == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (dzN()) {
                this.mLi = new b(this, this.chunkLength, this.mKX, this.mKZ, this.mLa);
                dzK();
            } else {
                long dzJ = dzJ();
                if (dzJ != -1) {
                    this.mLi = new c(this, dzJ, this.mKX);
                    dzK();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.mLi = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.mLi = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.h("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.mLi = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.mLi;
    }

    private long dzJ() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void dzK() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.mKX, this.mJE);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.mLi != null) {
                    builder.b(this.mLi.dzF(), this.mKX);
                    if (getRequestProperty("Content-Length") == null && !dzN()) {
                        addRequestProperty("Content-Length", Long.toString(this.mLi.dzF().getLength()));
                    }
                    this.mLi.dzD();
                } else if (getRequestProperty("Content-Length") == null) {
                    addRequestProperty("Content-Length", "0");
                }
                if (getRequestProperty("Content-Type") == null) {
                    addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
            }
            for (Pair<String, String> pair : this.mRequestHeaders) {
                builder.fR((String) pair.first, (String) pair.second);
            }
            if (!getUseCaches()) {
                builder.dzp();
            }
            builder.Qu(this.method);
            if (this.mKu) {
                builder.dzq();
            }
            if (this.mIh) {
                builder.dzr();
            }
            if (!TextUtils.isEmpty(this.mIo)) {
                builder.Qv(this.mIo);
            }
            if (!TextUtils.isEmpty(this.mIq)) {
                builder.Qw(this.mIq);
            }
            builder.HT(getConnectTimeout());
            builder.HU(getReadTimeout());
            builder.HS(getRequestTimeout());
            this.connected = true;
            this.mLg = builder.dzs();
            this.mLg.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            dzL();
            if (this.mHk.getHttpStatusCode() >= 400) {
                return this.mLh;
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        F(str, str2, false);
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        F(str, str2, true);
    }

    private final void F(String str, String str2, boolean z) {
        if (this.connected) {
            throw new IllegalStateException("Cannot modify request property after connection is made.");
        }
        int Qx = Qx(str);
        if (Qx >= 0) {
            if (z) {
                this.mRequestHeaders.remove(Qx);
            } else {
                throw new UnsupportedOperationException("Cannot add multiple headers of the same key, " + str + ". crbug.com/432719.");
            }
        }
        this.mRequestHeaders.add(Pair.create(str, str2));
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        if (this.connected) {
            throw new IllegalStateException("Cannot access request headers after connection is set.");
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Pair<String, String> pair : this.mRequestHeaders) {
            if (treeMap.containsKey(pair.first)) {
                throw new IllegalStateException("Should not have multiple values.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(pair.second);
            treeMap.put(pair.first, Collections.unmodifiableList(arrayList));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        int Qx = Qx(str);
        if (Qx >= 0) {
            return (String) this.mRequestHeaders.get(Qx).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ByteBuffer byteBuffer) throws IOException {
        this.mLg.m(byteBuffer);
        this.mKX.Ia(getReadTimeout());
    }

    private int Qx(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mRequestHeaders.size()) {
                if (!((String) this.mRequestHeaders.get(i2).first).equalsIgnoreCase(str)) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class a extends UrlRequest.Callback {
        public a() {
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.mHk = urlResponseInfo;
            d.this.mKX.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.mHk = urlResponseInfo;
            d.this.mKX.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.mLk = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.mLo)) {
                    d.this.mLg.dyv();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.mHk = urlResponseInfo;
            d.this.mLg.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.mHk = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.h("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.mHk = urlResponseInfo;
            d.this.mLj = urlRequestException;
            c(d.this.mLj);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.mHk = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.mLh != null) {
                d.this.mLh.c(iOException);
            }
            if (d.this.mLi != null) {
                d.this.mLi.d(iOException);
            }
            d.this.mLl = true;
            d.this.mKX.quit();
        }
    }

    private void dzL() throws IOException {
        if (this.mLi != null) {
            this.mLi.dzE();
            if (dzN()) {
                this.mLi.close();
            }
        }
        if (!this.mLl) {
            dzK();
            this.mKX.Ia(getReadTimeout());
            this.mLl = true;
        }
        dzM();
    }

    private void dzM() throws IOException {
        if (!this.mLl) {
            throw new IllegalStateException("No response.");
        }
        if (this.mLj != null) {
            throw this.mLj;
        }
        if (this.mHk == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> HZ(int i) {
        try {
            dzL();
            List<Map.Entry<String, String>> dzv = dzv();
            if (i >= dzv.size()) {
                return null;
            }
            return dzv.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean dzN() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> dzO() {
        if (this.mLn != null) {
            return this.mLn;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : dzv()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.mLn = Collections.unmodifiableMap(treeMap);
        return this.mLn;
    }

    private List<Map.Entry<String, String>> dzv() {
        if (this.mLm != null) {
            return this.mLm;
        }
        this.mLm = new ArrayList();
        for (Map.Entry<String, String> entry : this.mHk.dzv()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.mLm.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.mLm = Collections.unmodifiableList(this.mLm);
        return this.mLm;
    }

    public UrlResponseInfo dzP() {
        return this.mHk;
    }

    public void dzQ() {
        this.mLo = true;
    }

    public int getRequestTimeout() {
        return this.mLp;
    }
}
