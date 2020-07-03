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
    private String mAf;
    private String mAg;
    private final TurbonetEngine mBt;
    private final g mCN;
    private boolean mCP;
    private boolean mCQ;
    private UrlRequest mCW;
    private e mCX;
    private f mCY;
    private UrlRequestException mCZ;
    private boolean mCj;
    private boolean mDa;
    private boolean mDc;
    private List<Map.Entry<String, String>> mDd;
    private Map<String, List<String>> mDe;
    private boolean mDf;
    private int mDg;
    private final List<Pair<String, String>> mRequestHeaders;
    private boolean mzY;
    private UrlResponseInfo mzc;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.mDa = false;
        this.mDc = false;
        this.mDf = false;
        this.mDg = 0;
        this.mCP = false;
        this.mCQ = false;
        this.mBt = turbonetEngine;
        this.mCN = new g(getURL().toString());
        this.mCX = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        dwt();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.mCW.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        dwu();
        return this.mzc.dwd();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        dwu();
        return this.mzc.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            dwu();
            return dwx();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            dwu();
            Map<String, List<String>> dwx = dwx();
            if (dwx.containsKey(str)) {
                List<String> list = dwx.get(str);
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
        dwu();
        if (!this.instanceFollowRedirects && this.mDa) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.mzc.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.mCX;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.mCY == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (dww()) {
                this.mCY = new b(this, this.chunkLength, this.mCN, this.mCP, this.mCQ);
                dwt();
            } else {
                long dws = dws();
                if (dws != -1) {
                    this.mCY = new c(this, dws, this.mCN);
                    dwt();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.mCY = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.mCY = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.h("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.mCY = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.mCY;
    }

    private long dws() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void dwt() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.mCN, this.mBt);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.mCY != null) {
                    builder.b(this.mCY.dwo(), this.mCN);
                    if (getRequestProperty("Content-Length") == null && !dww()) {
                        addRequestProperty("Content-Length", Long.toString(this.mCY.dwo().getLength()));
                    }
                    this.mCY.dwm();
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
                builder.dvY();
            }
            builder.PI(this.method);
            if (this.mCj) {
                builder.dvZ();
            }
            if (this.mzY) {
                builder.dwa();
            }
            if (!TextUtils.isEmpty(this.mAf)) {
                builder.PJ(this.mAf);
            }
            if (!TextUtils.isEmpty(this.mAg)) {
                builder.PK(this.mAg);
            }
            builder.Hy(getConnectTimeout());
            builder.Hz(getReadTimeout());
            builder.Hx(getRequestTimeout());
            this.connected = true;
            this.mCW = builder.dwb();
            this.mCW.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            dwu();
            if (this.mzc.getHttpStatusCode() >= 400) {
                return this.mCX;
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
        int PL = PL(str);
        if (PL >= 0) {
            if (z) {
                this.mRequestHeaders.remove(PL);
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
        int PL = PL(str);
        if (PL >= 0) {
            return (String) this.mRequestHeaders.get(PL).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ByteBuffer byteBuffer) throws IOException {
        this.mCW.m(byteBuffer);
        this.mCN.HF(getReadTimeout());
    }

    private int PL(String str) {
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
            d.this.mzc = urlResponseInfo;
            d.this.mCN.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.mzc = urlResponseInfo;
            d.this.mCN.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.mDa = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.mDf)) {
                    d.this.mCW.dve();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.mzc = urlResponseInfo;
            d.this.mCW.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.mzc = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.h("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.mzc = urlResponseInfo;
            d.this.mCZ = urlRequestException;
            c(d.this.mCZ);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.mzc = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.mCX != null) {
                d.this.mCX.c(iOException);
            }
            if (d.this.mCY != null) {
                d.this.mCY.d(iOException);
            }
            d.this.mDc = true;
            d.this.mCN.quit();
        }
    }

    private void dwu() throws IOException {
        if (this.mCY != null) {
            this.mCY.dwn();
            if (dww()) {
                this.mCY.close();
            }
        }
        if (!this.mDc) {
            dwt();
            this.mCN.HF(getReadTimeout());
            this.mDc = true;
        }
        dwv();
    }

    private void dwv() throws IOException {
        if (!this.mDc) {
            throw new IllegalStateException("No response.");
        }
        if (this.mCZ != null) {
            throw this.mCZ;
        }
        if (this.mzc == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> HE(int i) {
        try {
            dwu();
            List<Map.Entry<String, String>> dwe = dwe();
            if (i >= dwe.size()) {
                return null;
            }
            return dwe.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean dww() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> dwx() {
        if (this.mDe != null) {
            return this.mDe;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : dwe()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.mDe = Collections.unmodifiableMap(treeMap);
        return this.mDe;
    }

    private List<Map.Entry<String, String>> dwe() {
        if (this.mDd != null) {
            return this.mDd;
        }
        this.mDd = new ArrayList();
        for (Map.Entry<String, String> entry : this.mzc.dwe()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.mDd.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.mDd = Collections.unmodifiableList(this.mDd);
        return this.mDd;
    }

    public UrlResponseInfo dwy() {
        return this.mzc;
    }

    public void dwz() {
        this.mDf = true;
    }

    public int getRequestTimeout() {
        return this.mDg;
    }
}
