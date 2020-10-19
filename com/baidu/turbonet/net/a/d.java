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
/* loaded from: classes17.dex */
public class d extends HttpURLConnection {
    private final List<Pair<String, String>> mRequestHeaders;
    private boolean nAV;
    private String nBc;
    private String nBd;
    private final TurbonetEngine nCp;
    private final g nDH;
    private boolean nDJ;
    private boolean nDK;
    private UrlRequest nDQ;
    private e nDR;
    private f nDS;
    private UrlRequestException nDT;
    private boolean nDU;
    private boolean nDV;
    private List<Map.Entry<String, String>> nDW;
    private Map<String, List<String>> nDX;
    private boolean nDY;
    private int nDZ;
    private boolean nDe;
    private UrlResponseInfo nzZ;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.nDU = false;
        this.nDV = false;
        this.nDY = false;
        this.nDZ = 0;
        this.nDJ = false;
        this.nDK = false;
        this.nCp = turbonetEngine;
        this.nDH = new g(getURL().toString());
        this.nDR = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        dTq();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.nDQ.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        dTr();
        return this.nzZ.dTa();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        dTr();
        return this.nzZ.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            dTr();
            return dTu();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            dTr();
            Map<String, List<String>> dTu = dTu();
            if (dTu.containsKey(str)) {
                List<String> list = dTu.get(str);
                return list.get(list.size() - 1);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        Map.Entry<String, String> LK = LK(i);
        if (LK == null) {
            return null;
        }
        return LK.getKey();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        Map.Entry<String, String> LK = LK(i);
        if (LK == null) {
            return null;
        }
        return LK.getValue();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        dTr();
        if (!this.instanceFollowRedirects && this.nDU) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.nzZ.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.nDR;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.nDS == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (dTt()) {
                this.nDS = new b(this, this.chunkLength, this.nDH, this.nDJ, this.nDK);
                dTq();
            } else {
                long dTp = dTp();
                if (dTp != -1) {
                    this.nDS = new c(this, dTp, this.nDH);
                    dTq();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.nDS = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.nDS = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.nDS = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.nDS;
    }

    private long dTp() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void dTq() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.nDH, this.nCp);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.nDS != null) {
                    builder.b(this.nDS.dTl(), this.nDH);
                    if (getRequestProperty("Content-Length") == null && !dTt()) {
                        addRequestProperty("Content-Length", Long.toString(this.nDS.dTl().getLength()));
                    }
                    this.nDS.dTj();
                } else if (getRequestProperty("Content-Length") == null) {
                    addRequestProperty("Content-Length", "0");
                }
                if (getRequestProperty("Content-Type") == null) {
                    addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
            }
            for (Pair<String, String> pair : this.mRequestHeaders) {
                builder.gC((String) pair.first, (String) pair.second);
            }
            if (!getUseCaches()) {
                builder.dSV();
            }
            builder.UG(this.method);
            if (this.nDe) {
                builder.dSW();
            }
            if (this.nAV) {
                builder.dSX();
            }
            if (!TextUtils.isEmpty(this.nBc)) {
                builder.UH(this.nBc);
            }
            if (!TextUtils.isEmpty(this.nBd)) {
                builder.UI(this.nBd);
            }
            builder.LE(getConnectTimeout());
            builder.LF(getReadTimeout());
            builder.LD(getRequestTimeout());
            this.connected = true;
            this.nDQ = builder.dSY();
            this.nDQ.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            dTr();
            if (this.nzZ.getHttpStatusCode() >= 400) {
                return this.nDR;
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        E(str, str2, false);
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        E(str, str2, true);
    }

    private final void E(String str, String str2, boolean z) {
        if (this.connected) {
            throw new IllegalStateException("Cannot modify request property after connection is made.");
        }
        int UJ = UJ(str);
        if (UJ >= 0) {
            if (z) {
                this.mRequestHeaders.remove(UJ);
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
        int UJ = UJ(str);
        if (UJ >= 0) {
            return (String) this.mRequestHeaders.get(UJ).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(ByteBuffer byteBuffer) throws IOException {
        this.nDQ.o(byteBuffer);
        this.nDH.LL(getReadTimeout());
    }

    private int UJ(String str) {
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
    /* loaded from: classes17.dex */
    public class a extends UrlRequest.Callback {
        public a() {
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.nzZ = urlResponseInfo;
            d.this.nDH.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.nzZ = urlResponseInfo;
            d.this.nDH.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.nDU = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.nDY)) {
                    d.this.nDQ.dSc();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.nzZ = urlResponseInfo;
            d.this.nDQ.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.f("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.nzZ = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.nzZ = urlResponseInfo;
            d.this.nDT = urlRequestException;
            c(d.this.nDT);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.nzZ = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.nDR != null) {
                d.this.nDR.c(iOException);
            }
            if (d.this.nDS != null) {
                d.this.nDS.d(iOException);
            }
            d.this.nDV = true;
            d.this.nDH.quit();
        }
    }

    private void dTr() throws IOException {
        if (this.nDS != null) {
            this.nDS.dTk();
            if (dTt()) {
                this.nDS.close();
            }
        }
        if (!this.nDV) {
            dTq();
            this.nDH.LL(getReadTimeout());
            this.nDV = true;
        }
        dTs();
    }

    private void dTs() throws IOException {
        if (!this.nDV) {
            throw new IllegalStateException("No response.");
        }
        if (this.nDT != null) {
            throw this.nDT;
        }
        if (this.nzZ == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> LK(int i) {
        try {
            dTr();
            List<Map.Entry<String, String>> dTb = dTb();
            if (i >= dTb.size()) {
                return null;
            }
            return dTb.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean dTt() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> dTu() {
        if (this.nDX != null) {
            return this.nDX;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : dTb()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.nDX = Collections.unmodifiableMap(treeMap);
        return this.nDX;
    }

    private List<Map.Entry<String, String>> dTb() {
        if (this.nDW != null) {
            return this.nDW;
        }
        this.nDW = new ArrayList();
        for (Map.Entry<String, String> entry : this.nzZ.dTb()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.nDW.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.nDW = Collections.unmodifiableList(this.nDW);
        return this.nDW;
    }

    public UrlResponseInfo dTv() {
        return this.nzZ;
    }

    public void dTw() {
        this.nDY = true;
    }

    public int getRequestTimeout() {
        return this.nDZ;
    }
}
