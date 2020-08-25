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
    private UrlResponseInfo nal;
    private boolean nbh;
    private String nbo;
    private String nbp;
    private final TurbonetEngine ncB;
    private final g ndU;
    private boolean ndW;
    private boolean ndX;
    private boolean ndr;
    private UrlRequest ned;
    private e nee;
    private f nef;
    private UrlRequestException neg;
    private boolean neh;
    private boolean nei;
    private List<Map.Entry<String, String>> nej;
    private Map<String, List<String>> nek;
    private boolean nel;
    private int nem;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.neh = false;
        this.nei = false;
        this.nel = false;
        this.nem = 0;
        this.ndW = false;
        this.ndX = false;
        this.ncB = turbonetEngine;
        this.ndU = new g(getURL().toString());
        this.nee = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        dLy();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.ned.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        dLz();
        return this.nal.dLi();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        dLz();
        return this.nal.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            dLz();
            return dLC();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            dLz();
            Map<String, List<String>> dLC = dLC();
            if (dLC.containsKey(str)) {
                List<String> list = dLC.get(str);
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
        dLz();
        if (!this.instanceFollowRedirects && this.neh) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.nal.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.nee;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.nef == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (dLB()) {
                this.nef = new b(this, this.chunkLength, this.ndU, this.ndW, this.ndX);
                dLy();
            } else {
                long dLx = dLx();
                if (dLx != -1) {
                    this.nef = new c(this, dLx, this.ndU);
                    dLy();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.nef = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.nef = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.nef = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.nef;
    }

    private long dLx() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void dLy() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.ndU, this.ncB);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.nef != null) {
                    builder.b(this.nef.dLt(), this.ndU);
                    if (getRequestProperty("Content-Length") == null && !dLB()) {
                        addRequestProperty("Content-Length", Long.toString(this.nef.dLt().getLength()));
                    }
                    this.nef.dLr();
                } else if (getRequestProperty("Content-Length") == null) {
                    addRequestProperty("Content-Length", "0");
                }
                if (getRequestProperty("Content-Type") == null) {
                    addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
            }
            for (Pair<String, String> pair : this.mRequestHeaders) {
                builder.gi((String) pair.first, (String) pair.second);
            }
            if (!getUseCaches()) {
                builder.dLd();
            }
            builder.Tt(this.method);
            if (this.ndr) {
                builder.dLe();
            }
            if (this.nbh) {
                builder.dLf();
            }
            if (!TextUtils.isEmpty(this.nbo)) {
                builder.Tu(this.nbo);
            }
            if (!TextUtils.isEmpty(this.nbp)) {
                builder.Tv(this.nbp);
            }
            builder.Kt(getConnectTimeout());
            builder.Ku(getReadTimeout());
            builder.Ks(getRequestTimeout());
            this.connected = true;
            this.ned = builder.dLg();
            this.ned.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            dLz();
            if (this.nal.getHttpStatusCode() >= 400) {
                return this.nee;
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
        this.ned.m(byteBuffer);
        this.ndU.KA(getReadTimeout());
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
            d.this.nal = urlResponseInfo;
            d.this.ndU.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.nal = urlResponseInfo;
            d.this.ndU.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.neh = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.nel)) {
                    d.this.ned.dKj();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.nal = urlResponseInfo;
            d.this.ned.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.f("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.nal = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.nal = urlResponseInfo;
            d.this.neg = urlRequestException;
            c(d.this.neg);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.nal = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.nee != null) {
                d.this.nee.c(iOException);
            }
            if (d.this.nef != null) {
                d.this.nef.d(iOException);
            }
            d.this.nei = true;
            d.this.ndU.quit();
        }
    }

    private void dLz() throws IOException {
        if (this.nef != null) {
            this.nef.dLs();
            if (dLB()) {
                this.nef.close();
            }
        }
        if (!this.nei) {
            dLy();
            this.ndU.KA(getReadTimeout());
            this.nei = true;
        }
        dLA();
    }

    private void dLA() throws IOException {
        if (!this.nei) {
            throw new IllegalStateException("No response.");
        }
        if (this.neg != null) {
            throw this.neg;
        }
        if (this.nal == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> Kz(int i) {
        try {
            dLz();
            List<Map.Entry<String, String>> dLj = dLj();
            if (i >= dLj.size()) {
                return null;
            }
            return dLj.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean dLB() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> dLC() {
        if (this.nek != null) {
            return this.nek;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : dLj()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.nek = Collections.unmodifiableMap(treeMap);
        return this.nek;
    }

    private List<Map.Entry<String, String>> dLj() {
        if (this.nej != null) {
            return this.nej;
        }
        this.nej = new ArrayList();
        for (Map.Entry<String, String> entry : this.nal.dLj()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.nej.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.nej = Collections.unmodifiableList(this.nej);
        return this.nej;
    }

    public UrlResponseInfo dLD() {
        return this.nal;
    }

    public void dLE() {
        this.nel = true;
    }

    public int getRequestTimeout() {
        return this.nem;
    }
}
