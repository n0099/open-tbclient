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
/* loaded from: classes.dex */
public class d extends HttpURLConnection {
    private boolean mAb;
    private String mAi;
    private String mAj;
    private final TurbonetEngine mBw;
    private final g mCQ;
    private boolean mCS;
    private boolean mCT;
    private UrlRequest mCZ;
    private boolean mCm;
    private e mDa;
    private f mDc;
    private UrlRequestException mDd;
    private boolean mDe;
    private boolean mDf;
    private List<Map.Entry<String, String>> mDg;
    private Map<String, List<String>> mDh;
    private boolean mDi;
    private int mDj;
    private final List<Pair<String, String>> mRequestHeaders;
    private UrlResponseInfo mzf;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.mDe = false;
        this.mDf = false;
        this.mDi = false;
        this.mDj = 0;
        this.mCS = false;
        this.mCT = false;
        this.mBw = turbonetEngine;
        this.mCQ = new g(getURL().toString());
        this.mDa = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        dwx();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.mCZ.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        dwy();
        return this.mzf.dwh();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        dwy();
        return this.mzf.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            dwy();
            return dwB();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            dwy();
            Map<String, List<String>> dwB = dwB();
            if (dwB.containsKey(str)) {
                List<String> list = dwB.get(str);
                return list.get(list.size() - 1);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        Map.Entry<String, String> HE = HE(i);
        if (HE == null) {
            return null;
        }
        return HE.getKey();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        Map.Entry<String, String> HE = HE(i);
        if (HE == null) {
            return null;
        }
        return HE.getValue();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        dwy();
        if (!this.instanceFollowRedirects && this.mDe) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.mzf.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.mDa;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.mDc == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (dwA()) {
                this.mDc = new b(this, this.chunkLength, this.mCQ, this.mCS, this.mCT);
                dwx();
            } else {
                long dww = dww();
                if (dww != -1) {
                    this.mDc = new c(this, dww, this.mCQ);
                    dwx();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.mDc = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.mDc = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.h("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.mDc = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.mDc;
    }

    private long dww() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void dwx() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.mCQ, this.mBw);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.mDc != null) {
                    builder.b(this.mDc.dws(), this.mCQ);
                    if (getRequestProperty("Content-Length") == null && !dwA()) {
                        addRequestProperty("Content-Length", Long.toString(this.mDc.dws().getLength()));
                    }
                    this.mDc.dwq();
                } else if (getRequestProperty("Content-Length") == null) {
                    addRequestProperty("Content-Length", "0");
                }
                if (getRequestProperty("Content-Type") == null) {
                    addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
            }
            for (Pair<String, String> pair : this.mRequestHeaders) {
                builder.fP((String) pair.first, (String) pair.second);
            }
            if (!getUseCaches()) {
                builder.dwc();
            }
            builder.PJ(this.method);
            if (this.mCm) {
                builder.dwd();
            }
            if (this.mAb) {
                builder.dwe();
            }
            if (!TextUtils.isEmpty(this.mAi)) {
                builder.PK(this.mAi);
            }
            if (!TextUtils.isEmpty(this.mAj)) {
                builder.PL(this.mAj);
            }
            builder.Hy(getConnectTimeout());
            builder.Hz(getReadTimeout());
            builder.Hx(getRequestTimeout());
            this.connected = true;
            this.mCZ = builder.dwf();
            this.mCZ.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            dwy();
            if (this.mzf.getHttpStatusCode() >= 400) {
                return this.mDa;
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
        int PM = PM(str);
        if (PM >= 0) {
            if (z) {
                this.mRequestHeaders.remove(PM);
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
        int PM = PM(str);
        if (PM >= 0) {
            return (String) this.mRequestHeaders.get(PM).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ByteBuffer byteBuffer) throws IOException {
        this.mCZ.m(byteBuffer);
        this.mCQ.HF(getReadTimeout());
    }

    private int PM(String str) {
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
    /* loaded from: classes.dex */
    public class a extends UrlRequest.Callback {
        public a() {
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.mzf = urlResponseInfo;
            d.this.mCQ.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.mzf = urlResponseInfo;
            d.this.mCQ.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.mDe = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.mDi)) {
                    d.this.mCZ.dvi();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.mzf = urlResponseInfo;
            d.this.mCZ.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.mzf = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.h("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.mzf = urlResponseInfo;
            d.this.mDd = urlRequestException;
            c(d.this.mDd);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.mzf = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.mDa != null) {
                d.this.mDa.c(iOException);
            }
            if (d.this.mDc != null) {
                d.this.mDc.d(iOException);
            }
            d.this.mDf = true;
            d.this.mCQ.quit();
        }
    }

    private void dwy() throws IOException {
        if (this.mDc != null) {
            this.mDc.dwr();
            if (dwA()) {
                this.mDc.close();
            }
        }
        if (!this.mDf) {
            dwx();
            this.mCQ.HF(getReadTimeout());
            this.mDf = true;
        }
        dwz();
    }

    private void dwz() throws IOException {
        if (!this.mDf) {
            throw new IllegalStateException("No response.");
        }
        if (this.mDd != null) {
            throw this.mDd;
        }
        if (this.mzf == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> HE(int i) {
        try {
            dwy();
            List<Map.Entry<String, String>> dwi = dwi();
            if (i >= dwi.size()) {
                return null;
            }
            return dwi.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean dwA() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> dwB() {
        if (this.mDh != null) {
            return this.mDh;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : dwi()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.mDh = Collections.unmodifiableMap(treeMap);
        return this.mDh;
    }

    private List<Map.Entry<String, String>> dwi() {
        if (this.mDg != null) {
            return this.mDg;
        }
        this.mDg = new ArrayList();
        for (Map.Entry<String, String> entry : this.mzf.dwi()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.mDg.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.mDg = Collections.unmodifiableList(this.mDg);
        return this.mDg;
    }

    public UrlResponseInfo dwC() {
        return this.mzf;
    }

    public void dwD() {
        this.mDi = true;
    }

    public int getRequestTimeout() {
        return this.mDj;
    }
}
