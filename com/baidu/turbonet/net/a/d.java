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
/* loaded from: classes12.dex */
public class d extends HttpURLConnection {
    private final List<Pair<String, String>> mRequestHeaders;
    private UrlResponseInfo oni;
    private boolean ooe;
    private String ool;
    private String oom;
    private final TurbonetEngine opz;
    private final g oqR;
    private boolean oqT;
    private boolean oqU;
    private boolean oqo;
    private UrlRequest ora;
    private e orb;
    private f orc;
    private UrlRequestException ord;
    private boolean ore;
    private boolean orf;
    private List<Map.Entry<String, String>> orh;
    private Map<String, List<String>> ori;
    private boolean orj;
    private int ork;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.ore = false;
        this.orf = false;
        this.orj = false;
        this.ork = 0;
        this.oqT = false;
        this.oqU = false;
        this.opz = turbonetEngine;
        this.oqR = new g(getURL().toString());
        this.orb = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        ecP();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.ora.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        ecQ();
        return this.oni.ecz();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        ecQ();
        return this.oni.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            ecQ();
            return ecT();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            ecQ();
            Map<String, List<String>> ecT = ecT();
            if (ecT.containsKey(str)) {
                List<String> list = ecT.get(str);
                return list.get(list.size() - 1);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        Map.Entry<String, String> NI = NI(i);
        if (NI == null) {
            return null;
        }
        return NI.getKey();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        Map.Entry<String, String> NI = NI(i);
        if (NI == null) {
            return null;
        }
        return NI.getValue();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        ecQ();
        if (!this.instanceFollowRedirects && this.ore) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.oni.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.orb;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.orc == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (ecS()) {
                this.orc = new b(this, this.chunkLength, this.oqR, this.oqT, this.oqU);
                ecP();
            } else {
                long ecO = ecO();
                if (ecO != -1) {
                    this.orc = new c(this, ecO, this.oqR);
                    ecP();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.orc = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.orc = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.orc = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.orc;
    }

    private long ecO() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void ecP() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.oqR, this.opz);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.orc != null) {
                    builder.b(this.orc.ecK(), this.oqR);
                    if (getRequestProperty("Content-Length") == null && !ecS()) {
                        addRequestProperty("Content-Length", Long.toString(this.orc.ecK().getLength()));
                    }
                    this.orc.ecI();
                } else if (getRequestProperty("Content-Length") == null) {
                    addRequestProperty("Content-Length", "0");
                }
                if (getRequestProperty("Content-Type") == null) {
                    addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
            }
            for (Pair<String, String> pair : this.mRequestHeaders) {
                builder.gQ((String) pair.first, (String) pair.second);
            }
            if (!getUseCaches()) {
                builder.ecu();
            }
            builder.Wi(this.method);
            if (this.oqo) {
                builder.ecv();
            }
            if (this.ooe) {
                builder.ecw();
            }
            if (!TextUtils.isEmpty(this.ool)) {
                builder.Wj(this.ool);
            }
            if (!TextUtils.isEmpty(this.oom)) {
                builder.Wk(this.oom);
            }
            builder.NC(getConnectTimeout());
            builder.ND(getReadTimeout());
            builder.NB(getRequestTimeout());
            this.connected = true;
            this.ora = builder.ecx();
            this.ora.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            ecQ();
            if (this.oni.getHttpStatusCode() >= 400) {
                return this.orb;
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        H(str, str2, false);
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        H(str, str2, true);
    }

    private final void H(String str, String str2, boolean z) {
        if (this.connected) {
            throw new IllegalStateException("Cannot modify request property after connection is made.");
        }
        int Wl = Wl(str);
        if (Wl >= 0) {
            if (z) {
                this.mRequestHeaders.remove(Wl);
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
        int Wl = Wl(str);
        if (Wl >= 0) {
            return (String) this.mRequestHeaders.get(Wl).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(ByteBuffer byteBuffer) throws IOException {
        this.ora.n(byteBuffer);
        this.oqR.NJ(getReadTimeout());
    }

    private int Wl(String str) {
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
    /* loaded from: classes12.dex */
    public class a extends UrlRequest.Callback {
        public a() {
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.oni = urlResponseInfo;
            d.this.oqR.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.oni = urlResponseInfo;
            d.this.oqR.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.ore = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.orj)) {
                    d.this.ora.ebB();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.oni = urlResponseInfo;
            d.this.ora.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.f("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.oni = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.oni = urlResponseInfo;
            d.this.ord = urlRequestException;
            c(d.this.ord);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.oni = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.orb != null) {
                d.this.orb.c(iOException);
            }
            if (d.this.orc != null) {
                d.this.orc.d(iOException);
            }
            d.this.orf = true;
            d.this.oqR.quit();
        }
    }

    private void ecQ() throws IOException {
        if (this.orc != null) {
            this.orc.ecJ();
            if (ecS()) {
                this.orc.close();
            }
        }
        if (!this.orf) {
            ecP();
            this.oqR.NJ(getReadTimeout());
            this.orf = true;
        }
        ecR();
    }

    private void ecR() throws IOException {
        if (!this.orf) {
            throw new IllegalStateException("No response.");
        }
        if (this.ord != null) {
            throw this.ord;
        }
        if (this.oni == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> NI(int i) {
        try {
            ecQ();
            List<Map.Entry<String, String>> ecA = ecA();
            if (i >= ecA.size()) {
                return null;
            }
            return ecA.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean ecS() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> ecT() {
        if (this.ori != null) {
            return this.ori;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : ecA()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.ori = Collections.unmodifiableMap(treeMap);
        return this.ori;
    }

    private List<Map.Entry<String, String>> ecA() {
        if (this.orh != null) {
            return this.orh;
        }
        this.orh = new ArrayList();
        for (Map.Entry<String, String> entry : this.oni.ecA()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.orh.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.orh = Collections.unmodifiableList(this.orh);
        return this.orh;
    }

    public UrlResponseInfo ecU() {
        return this.oni;
    }

    public void ecV() {
        this.orj = true;
    }

    public int getRequestTimeout() {
        return this.ork;
    }
}
