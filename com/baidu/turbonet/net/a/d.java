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
/* loaded from: classes10.dex */
public class d extends HttpURLConnection {
    private final List<Pair<String, String>> mRequestHeaders;
    private UrlResponseInfo naD;
    private String nbG;
    private String nbH;
    private boolean nbz;
    private final TurbonetEngine ncT;
    private boolean ndJ;
    private boolean neA;
    private boolean neB;
    private List<Map.Entry<String, String>> neC;
    private Map<String, List<String>> neD;
    private boolean neE;
    private int neF;
    private final g nem;
    private boolean neo;
    private boolean nep;

    /* renamed from: new  reason: not valid java name */
    private UrlRequest f6new;
    private e nex;
    private f ney;
    private UrlRequestException nez;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.neA = false;
        this.neB = false;
        this.neE = false;
        this.neF = 0;
        this.neo = false;
        this.nep = false;
        this.ncT = turbonetEngine;
        this.nem = new g(getURL().toString());
        this.nex = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        dLH();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.f6new.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        dLI();
        return this.naD.dLr();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        dLI();
        return this.naD.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            dLI();
            return dLL();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            dLI();
            Map<String, List<String>> dLL = dLL();
            if (dLL.containsKey(str)) {
                List<String> list = dLL.get(str);
                return list.get(list.size() - 1);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        Map.Entry<String, String> Kz = Kz(i);
        if (Kz == null) {
            return null;
        }
        return Kz.getKey();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        Map.Entry<String, String> Kz = Kz(i);
        if (Kz == null) {
            return null;
        }
        return Kz.getValue();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        dLI();
        if (!this.instanceFollowRedirects && this.neA) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.naD.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.nex;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.ney == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (dLK()) {
                this.ney = new b(this, this.chunkLength, this.nem, this.neo, this.nep);
                dLH();
            } else {
                long dLG = dLG();
                if (dLG != -1) {
                    this.ney = new c(this, dLG, this.nem);
                    dLH();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.ney = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.ney = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.ney = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.ney;
    }

    private long dLG() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void dLH() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.nem, this.ncT);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.ney != null) {
                    builder.b(this.ney.dLC(), this.nem);
                    if (getRequestProperty("Content-Length") == null && !dLK()) {
                        addRequestProperty("Content-Length", Long.toString(this.ney.dLC().getLength()));
                    }
                    this.ney.dLA();
                } else if (getRequestProperty("Content-Length") == null) {
                    addRequestProperty("Content-Length", "0");
                }
                if (getRequestProperty("Content-Type") == null) {
                    addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
            }
            for (Pair<String, String> pair : this.mRequestHeaders) {
                builder.gj((String) pair.first, (String) pair.second);
            }
            if (!getUseCaches()) {
                builder.dLm();
            }
            builder.Tt(this.method);
            if (this.ndJ) {
                builder.dLn();
            }
            if (this.nbz) {
                builder.dLo();
            }
            if (!TextUtils.isEmpty(this.nbG)) {
                builder.Tu(this.nbG);
            }
            if (!TextUtils.isEmpty(this.nbH)) {
                builder.Tv(this.nbH);
            }
            builder.Kt(getConnectTimeout());
            builder.Ku(getReadTimeout());
            builder.Ks(getRequestTimeout());
            this.connected = true;
            this.f6new = builder.dLp();
            this.f6new.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            dLI();
            if (this.naD.getHttpStatusCode() >= 400) {
                return this.nex;
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
        int Tw = Tw(str);
        if (Tw >= 0) {
            if (z) {
                this.mRequestHeaders.remove(Tw);
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
        int Tw = Tw(str);
        if (Tw >= 0) {
            return (String) this.mRequestHeaders.get(Tw).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ByteBuffer byteBuffer) throws IOException {
        this.f6new.m(byteBuffer);
        this.nem.KA(getReadTimeout());
    }

    private int Tw(String str) {
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
    /* loaded from: classes10.dex */
    public class a extends UrlRequest.Callback {
        public a() {
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.naD = urlResponseInfo;
            d.this.nem.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.naD = urlResponseInfo;
            d.this.nem.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.neA = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.neE)) {
                    d.this.f6new.dKs();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.naD = urlResponseInfo;
            d.this.f6new.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.f("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.naD = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.naD = urlResponseInfo;
            d.this.nez = urlRequestException;
            c(d.this.nez);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.naD = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.nex != null) {
                d.this.nex.c(iOException);
            }
            if (d.this.ney != null) {
                d.this.ney.d(iOException);
            }
            d.this.neB = true;
            d.this.nem.quit();
        }
    }

    private void dLI() throws IOException {
        if (this.ney != null) {
            this.ney.dLB();
            if (dLK()) {
                this.ney.close();
            }
        }
        if (!this.neB) {
            dLH();
            this.nem.KA(getReadTimeout());
            this.neB = true;
        }
        dLJ();
    }

    private void dLJ() throws IOException {
        if (!this.neB) {
            throw new IllegalStateException("No response.");
        }
        if (this.nez != null) {
            throw this.nez;
        }
        if (this.naD == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> Kz(int i) {
        try {
            dLI();
            List<Map.Entry<String, String>> dLs = dLs();
            if (i >= dLs.size()) {
                return null;
            }
            return dLs.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean dLK() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> dLL() {
        if (this.neD != null) {
            return this.neD;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : dLs()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.neD = Collections.unmodifiableMap(treeMap);
        return this.neD;
    }

    private List<Map.Entry<String, String>> dLs() {
        if (this.neC != null) {
            return this.neC;
        }
        this.neC = new ArrayList();
        for (Map.Entry<String, String> entry : this.naD.dLs()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.neC.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.neC = Collections.unmodifiableList(this.neC);
        return this.neC;
    }

    public UrlResponseInfo dLM() {
        return this.naD;
    }

    public void dLN() {
        this.neE = true;
    }

    public int getRequestTimeout() {
        return this.neF;
    }
}
