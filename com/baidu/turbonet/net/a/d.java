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
/* loaded from: classes15.dex */
public class d extends HttpURLConnection {
    private final List<Pair<String, String>> mRequestHeaders;
    private UrlResponseInfo nkC;
    private String nlF;
    private String nlG;
    private boolean nly;
    private final TurbonetEngine nmS;
    private boolean nnI;
    private boolean noA;
    private boolean noB;
    private List<Map.Entry<String, String>> noC;
    private Map<String, List<String>> noD;
    private boolean noE;
    private int noF;
    private final g nol;
    private boolean non;
    private boolean noo;
    private UrlRequest nov;
    private e nox;
    private f noy;
    private UrlRequestException noz;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.noA = false;
        this.noB = false;
        this.noE = false;
        this.noF = 0;
        this.non = false;
        this.noo = false;
        this.nmS = turbonetEngine;
        this.nol = new g(getURL().toString());
        this.nox = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        dPF();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.nov.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        dPG();
        return this.nkC.dPp();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        dPG();
        return this.nkC.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            dPG();
            return dPJ();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            dPG();
            Map<String, List<String>> dPJ = dPJ();
            if (dPJ.containsKey(str)) {
                List<String> list = dPJ.get(str);
                return list.get(list.size() - 1);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        Map.Entry<String, String> Le = Le(i);
        if (Le == null) {
            return null;
        }
        return Le.getKey();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        Map.Entry<String, String> Le = Le(i);
        if (Le == null) {
            return null;
        }
        return Le.getValue();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        dPG();
        if (!this.instanceFollowRedirects && this.noA) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.nkC.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.nox;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.noy == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (dPI()) {
                this.noy = new b(this, this.chunkLength, this.nol, this.non, this.noo);
                dPF();
            } else {
                long dPE = dPE();
                if (dPE != -1) {
                    this.noy = new c(this, dPE, this.nol);
                    dPF();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.noy = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.noy = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.noy = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.noy;
    }

    private long dPE() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void dPF() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.nol, this.nmS);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.noy != null) {
                    builder.b(this.noy.dPA(), this.nol);
                    if (getRequestProperty("Content-Length") == null && !dPI()) {
                        addRequestProperty("Content-Length", Long.toString(this.noy.dPA().getLength()));
                    }
                    this.noy.dPy();
                } else if (getRequestProperty("Content-Length") == null) {
                    addRequestProperty("Content-Length", "0");
                }
                if (getRequestProperty("Content-Type") == null) {
                    addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
            }
            for (Pair<String, String> pair : this.mRequestHeaders) {
                builder.gv((String) pair.first, (String) pair.second);
            }
            if (!getUseCaches()) {
                builder.dPk();
            }
            builder.TS(this.method);
            if (this.nnI) {
                builder.dPl();
            }
            if (this.nly) {
                builder.dPm();
            }
            if (!TextUtils.isEmpty(this.nlF)) {
                builder.TT(this.nlF);
            }
            if (!TextUtils.isEmpty(this.nlG)) {
                builder.TU(this.nlG);
            }
            builder.KY(getConnectTimeout());
            builder.KZ(getReadTimeout());
            builder.KX(getRequestTimeout());
            this.connected = true;
            this.nov = builder.dPn();
            this.nov.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            dPG();
            if (this.nkC.getHttpStatusCode() >= 400) {
                return this.nox;
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
        int TV = TV(str);
        if (TV >= 0) {
            if (z) {
                this.mRequestHeaders.remove(TV);
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
        int TV = TV(str);
        if (TV >= 0) {
            return (String) this.mRequestHeaders.get(TV).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ByteBuffer byteBuffer) throws IOException {
        this.nov.m(byteBuffer);
        this.nol.Lf(getReadTimeout());
    }

    private int TV(String str) {
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
    /* loaded from: classes15.dex */
    public class a extends UrlRequest.Callback {
        public a() {
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.nkC = urlResponseInfo;
            d.this.nol.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.nkC = urlResponseInfo;
            d.this.nol.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.noA = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.noE)) {
                    d.this.nov.dOq();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.nkC = urlResponseInfo;
            d.this.nov.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.f("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.nkC = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.nkC = urlResponseInfo;
            d.this.noz = urlRequestException;
            c(d.this.noz);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.nkC = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.nox != null) {
                d.this.nox.c(iOException);
            }
            if (d.this.noy != null) {
                d.this.noy.d(iOException);
            }
            d.this.noB = true;
            d.this.nol.quit();
        }
    }

    private void dPG() throws IOException {
        if (this.noy != null) {
            this.noy.dPz();
            if (dPI()) {
                this.noy.close();
            }
        }
        if (!this.noB) {
            dPF();
            this.nol.Lf(getReadTimeout());
            this.noB = true;
        }
        dPH();
    }

    private void dPH() throws IOException {
        if (!this.noB) {
            throw new IllegalStateException("No response.");
        }
        if (this.noz != null) {
            throw this.noz;
        }
        if (this.nkC == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> Le(int i) {
        try {
            dPG();
            List<Map.Entry<String, String>> dPq = dPq();
            if (i >= dPq.size()) {
                return null;
            }
            return dPq.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean dPI() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> dPJ() {
        if (this.noD != null) {
            return this.noD;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : dPq()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.noD = Collections.unmodifiableMap(treeMap);
        return this.noD;
    }

    private List<Map.Entry<String, String>> dPq() {
        if (this.noC != null) {
            return this.noC;
        }
        this.noC = new ArrayList();
        for (Map.Entry<String, String> entry : this.nkC.dPq()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.noC.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.noC = Collections.unmodifiableList(this.noC);
        return this.noC;
    }

    public UrlResponseInfo dPK() {
        return this.nkC;
    }

    public void dPL() {
        this.noE = true;
    }

    public int getRequestTimeout() {
        return this.noF;
    }
}
