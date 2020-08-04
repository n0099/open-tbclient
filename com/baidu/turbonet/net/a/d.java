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
    private UrlResponseInfo mHm;
    private boolean mIj;
    private String mIr;
    private String mIt;
    private final TurbonetEngine mJG;
    private final g mKZ;
    private boolean mKw;
    private boolean mLb;
    private boolean mLc;
    private UrlRequest mLi;
    private e mLj;
    private f mLk;
    private UrlRequestException mLl;
    private boolean mLm;
    private boolean mLn;
    private List<Map.Entry<String, String>> mLo;
    private Map<String, List<String>> mLp;
    private boolean mLq;
    private int mLr;
    private final List<Pair<String, String>> mRequestHeaders;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.mLm = false;
        this.mLn = false;
        this.mLq = false;
        this.mLr = 0;
        this.mLb = false;
        this.mLc = false;
        this.mJG = turbonetEngine;
        this.mKZ = new g(getURL().toString());
        this.mLj = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        dzL();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.mLi.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        dzM();
        return this.mHm.dzv();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        dzM();
        return this.mHm.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            dzM();
            return dzP();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            dzM();
            Map<String, List<String>> dzP = dzP();
            if (dzP.containsKey(str)) {
                List<String> list = dzP.get(str);
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
        dzM();
        if (!this.instanceFollowRedirects && this.mLm) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.mHm.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.mLj;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.mLk == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (dzO()) {
                this.mLk = new b(this, this.chunkLength, this.mKZ, this.mLb, this.mLc);
                dzL();
            } else {
                long dzK = dzK();
                if (dzK != -1) {
                    this.mLk = new c(this, dzK, this.mKZ);
                    dzL();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.mLk = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.mLk = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.h("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.mLk = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.mLk;
    }

    private long dzK() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void dzL() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.mKZ, this.mJG);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.mLk != null) {
                    builder.b(this.mLk.dzG(), this.mKZ);
                    if (getRequestProperty("Content-Length") == null && !dzO()) {
                        addRequestProperty("Content-Length", Long.toString(this.mLk.dzG().getLength()));
                    }
                    this.mLk.dzE();
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
                builder.dzq();
            }
            builder.Qu(this.method);
            if (this.mKw) {
                builder.dzr();
            }
            if (this.mIj) {
                builder.dzs();
            }
            if (!TextUtils.isEmpty(this.mIr)) {
                builder.Qv(this.mIr);
            }
            if (!TextUtils.isEmpty(this.mIt)) {
                builder.Qw(this.mIt);
            }
            builder.HT(getConnectTimeout());
            builder.HU(getReadTimeout());
            builder.HS(getRequestTimeout());
            this.connected = true;
            this.mLi = builder.dzt();
            this.mLi.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            dzM();
            if (this.mHm.getHttpStatusCode() >= 400) {
                return this.mLj;
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
        this.mLi.m(byteBuffer);
        this.mKZ.Ia(getReadTimeout());
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
            d.this.mHm = urlResponseInfo;
            d.this.mKZ.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.mHm = urlResponseInfo;
            d.this.mKZ.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.mLm = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.mLq)) {
                    d.this.mLi.dyw();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.mHm = urlResponseInfo;
            d.this.mLi.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.mHm = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.h("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.mHm = urlResponseInfo;
            d.this.mLl = urlRequestException;
            c(d.this.mLl);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.mHm = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.mLj != null) {
                d.this.mLj.c(iOException);
            }
            if (d.this.mLk != null) {
                d.this.mLk.d(iOException);
            }
            d.this.mLn = true;
            d.this.mKZ.quit();
        }
    }

    private void dzM() throws IOException {
        if (this.mLk != null) {
            this.mLk.dzF();
            if (dzO()) {
                this.mLk.close();
            }
        }
        if (!this.mLn) {
            dzL();
            this.mKZ.Ia(getReadTimeout());
            this.mLn = true;
        }
        dzN();
    }

    private void dzN() throws IOException {
        if (!this.mLn) {
            throw new IllegalStateException("No response.");
        }
        if (this.mLl != null) {
            throw this.mLl;
        }
        if (this.mHm == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> HZ(int i) {
        try {
            dzM();
            List<Map.Entry<String, String>> dzw = dzw();
            if (i >= dzw.size()) {
                return null;
            }
            return dzw.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean dzO() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> dzP() {
        if (this.mLp != null) {
            return this.mLp;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : dzw()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.mLp = Collections.unmodifiableMap(treeMap);
        return this.mLp;
    }

    private List<Map.Entry<String, String>> dzw() {
        if (this.mLo != null) {
            return this.mLo;
        }
        this.mLo = new ArrayList();
        for (Map.Entry<String, String> entry : this.mHm.dzw()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.mLo.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.mLo = Collections.unmodifiableList(this.mLo);
        return this.mLo;
    }

    public UrlResponseInfo dzQ() {
        return this.mHm;
    }

    public void dzR() {
        this.mLq = true;
    }

    public int getRequestTimeout() {
        return this.mLr;
    }
}
