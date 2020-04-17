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
    private UrlResponseInfo lII;
    private boolean lJE;
    private String lJL;
    private String lJM;
    private boolean lLP;
    private final TurbonetEngine lLa;
    private UrlRequest lMB;
    private e lMC;
    private f lMD;
    private UrlRequestException lME;
    private boolean lMF;
    private boolean lMG;
    private List<Map.Entry<String, String>> lMH;
    private Map<String, List<String>> lMI;
    private boolean lMJ;
    private int lMK;
    private final g lMs;
    private boolean lMu;
    private boolean lMv;
    private final List<Pair<String, String>> mRequestHeaders;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.lMF = false;
        this.lMG = false;
        this.lMJ = false;
        this.lMK = 0;
        this.lMu = false;
        this.lMv = false;
        this.lLa = turbonetEngine;
        this.lMs = new g(getURL().toString());
        this.lMC = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        dkm();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.lMB.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        dkn();
        return this.lII.djW();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        dkn();
        return this.lII.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            dkn();
            return dkq();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            dkn();
            Map<String, List<String>> dkq = dkq();
            if (dkq.containsKey(str)) {
                List<String> list = dkq.get(str);
                return list.get(list.size() - 1);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        Map.Entry<String, String> FI = FI(i);
        if (FI == null) {
            return null;
        }
        return FI.getKey();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        Map.Entry<String, String> FI = FI(i);
        if (FI == null) {
            return null;
        }
        return FI.getValue();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        dkn();
        if (!this.instanceFollowRedirects && this.lMF) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.lII.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.lMC;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.lMD == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (dkp()) {
                this.lMD = new b(this, this.chunkLength, this.lMs, this.lMu, this.lMv);
                dkm();
            } else {
                long dkl = dkl();
                if (dkl != -1) {
                    this.lMD = new c(this, dkl, this.lMs);
                    dkm();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.lMD = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.lMD = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.h("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.lMD = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.lMD;
    }

    private long dkl() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void dkm() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.lMs, this.lLa);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.lMD != null) {
                    builder.b(this.lMD.dkh(), this.lMs);
                    if (getRequestProperty("Content-Length") == null && !dkp()) {
                        addRequestProperty("Content-Length", Long.toString(this.lMD.dkh().getLength()));
                    }
                    this.lMD.dkf();
                } else if (getRequestProperty("Content-Length") == null) {
                    addRequestProperty("Content-Length", "0");
                }
                if (getRequestProperty("Content-Type") == null) {
                    addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
            }
            for (Pair<String, String> pair : this.mRequestHeaders) {
                builder.fe((String) pair.first, (String) pair.second);
            }
            if (!getUseCaches()) {
                builder.djR();
            }
            builder.Nf(this.method);
            if (this.lLP) {
                builder.djS();
            }
            if (this.lJE) {
                builder.djT();
            }
            if (!TextUtils.isEmpty(this.lJL)) {
                builder.Ng(this.lJL);
            }
            if (!TextUtils.isEmpty(this.lJM)) {
                builder.Nh(this.lJM);
            }
            builder.FC(getConnectTimeout());
            builder.FD(getReadTimeout());
            builder.FB(getRequestTimeout());
            this.connected = true;
            this.lMB = builder.djU();
            this.lMB.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            dkn();
            if (this.lII.getHttpStatusCode() >= 400) {
                return this.lMC;
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        C(str, str2, false);
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        C(str, str2, true);
    }

    private final void C(String str, String str2, boolean z) {
        if (this.connected) {
            throw new IllegalStateException("Cannot modify request property after connection is made.");
        }
        int Ni = Ni(str);
        if (Ni >= 0) {
            if (z) {
                this.mRequestHeaders.remove(Ni);
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
        int Ni = Ni(str);
        if (Ni >= 0) {
            return (String) this.mRequestHeaders.get(Ni).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ByteBuffer byteBuffer) throws IOException {
        this.lMB.h(byteBuffer);
        this.lMs.FJ(getReadTimeout());
    }

    private int Ni(String str) {
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
            d.this.lII = urlResponseInfo;
            d.this.lMs.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.lII = urlResponseInfo;
            d.this.lMs.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.lMF = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.lMJ)) {
                    d.this.lMB.diX();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.lII = urlResponseInfo;
            d.this.lMB.cancel();
            b(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.lII = urlResponseInfo;
            b(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.h("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.lII = urlResponseInfo;
            d.this.lME = urlRequestException;
            b(d.this.lME);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.lII = urlResponseInfo;
            b(new IOException("stream closed"));
        }

        private void b(IOException iOException) {
            if (d.this.lMC != null) {
                d.this.lMC.b(iOException);
            }
            if (d.this.lMD != null) {
                d.this.lMD.c(iOException);
            }
            d.this.lMG = true;
            d.this.lMs.quit();
        }
    }

    private void dkn() throws IOException {
        if (this.lMD != null) {
            this.lMD.dkg();
            if (dkp()) {
                this.lMD.close();
            }
        }
        if (!this.lMG) {
            dkm();
            this.lMs.FJ(getReadTimeout());
            this.lMG = true;
        }
        dko();
    }

    private void dko() throws IOException {
        if (!this.lMG) {
            throw new IllegalStateException("No response.");
        }
        if (this.lME != null) {
            throw this.lME;
        }
        if (this.lII == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> FI(int i) {
        try {
            dkn();
            List<Map.Entry<String, String>> djX = djX();
            if (i >= djX.size()) {
                return null;
            }
            return djX.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean dkp() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> dkq() {
        if (this.lMI != null) {
            return this.lMI;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : djX()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.lMI = Collections.unmodifiableMap(treeMap);
        return this.lMI;
    }

    private List<Map.Entry<String, String>> djX() {
        if (this.lMH != null) {
            return this.lMH;
        }
        this.lMH = new ArrayList();
        for (Map.Entry<String, String> entry : this.lII.djX()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.lMH.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.lMH = Collections.unmodifiableList(this.lMH);
        return this.lMH;
    }

    public UrlResponseInfo dkr() {
        return this.lII;
    }

    public void dks() {
        this.lMJ = true;
    }

    public int getRequestTimeout() {
        return this.lMK;
    }
}
