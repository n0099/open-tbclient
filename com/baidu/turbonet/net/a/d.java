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
    private UrlResponseInfo ocA;
    private String odD;
    private String odE;
    private boolean odw;
    private final TurbonetEngine oeQ;
    private boolean ofG;
    private boolean ogA;
    private int ogB;
    private final g ogj;
    private boolean ogl;
    private boolean ogm;
    private UrlRequest ogs;
    private e ogt;
    private f ogu;
    private UrlRequestException ogv;
    private boolean ogw;
    private boolean ogx;
    private List<Map.Entry<String, String>> ogy;
    private Map<String, List<String>> ogz;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.ogw = false;
        this.ogx = false;
        this.ogA = false;
        this.ogB = 0;
        this.ogl = false;
        this.ogm = false;
        this.oeQ = turbonetEngine;
        this.ogj = new g(getURL().toString());
        this.ogt = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        dZi();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.ogs.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        dZj();
        return this.ocA.dYS();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        dZj();
        return this.ocA.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            dZj();
            return dZm();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            dZj();
            Map<String, List<String>> dZm = dZm();
            if (dZm.containsKey(str)) {
                List<String> list = dZm.get(str);
                return list.get(list.size() - 1);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        Map.Entry<String, String> MM = MM(i);
        if (MM == null) {
            return null;
        }
        return MM.getKey();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        Map.Entry<String, String> MM = MM(i);
        if (MM == null) {
            return null;
        }
        return MM.getValue();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        dZj();
        if (!this.instanceFollowRedirects && this.ogw) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.ocA.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.ogt;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.ogu == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (dZl()) {
                this.ogu = new b(this, this.chunkLength, this.ogj, this.ogl, this.ogm);
                dZi();
            } else {
                long dZh = dZh();
                if (dZh != -1) {
                    this.ogu = new c(this, dZh, this.ogj);
                    dZi();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.ogu = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.ogu = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.ogu = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.ogu;
    }

    private long dZh() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void dZi() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.ogj, this.oeQ);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.ogu != null) {
                    builder.b(this.ogu.dZd(), this.ogj);
                    if (getRequestProperty("Content-Length") == null && !dZl()) {
                        addRequestProperty("Content-Length", Long.toString(this.ogu.dZd().getLength()));
                    }
                    this.ogu.dZb();
                } else if (getRequestProperty("Content-Length") == null) {
                    addRequestProperty("Content-Length", "0");
                }
                if (getRequestProperty("Content-Type") == null) {
                    addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
            }
            for (Pair<String, String> pair : this.mRequestHeaders) {
                builder.gO((String) pair.first, (String) pair.second);
            }
            if (!getUseCaches()) {
                builder.dYN();
            }
            builder.VU(this.method);
            if (this.ofG) {
                builder.dYO();
            }
            if (this.odw) {
                builder.dYP();
            }
            if (!TextUtils.isEmpty(this.odD)) {
                builder.VV(this.odD);
            }
            if (!TextUtils.isEmpty(this.odE)) {
                builder.VW(this.odE);
            }
            builder.MG(getConnectTimeout());
            builder.MH(getReadTimeout());
            builder.MF(getRequestTimeout());
            this.connected = true;
            this.ogs = builder.dYQ();
            this.ogs.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            dZj();
            if (this.ocA.getHttpStatusCode() >= 400) {
                return this.ogt;
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
        int VX = VX(str);
        if (VX >= 0) {
            if (z) {
                this.mRequestHeaders.remove(VX);
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
        int VX = VX(str);
        if (VX >= 0) {
            return (String) this.mRequestHeaders.get(VX).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(ByteBuffer byteBuffer) throws IOException {
        this.ogs.n(byteBuffer);
        this.ogj.MN(getReadTimeout());
    }

    private int VX(String str) {
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
            d.this.ocA = urlResponseInfo;
            d.this.ogj.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.ocA = urlResponseInfo;
            d.this.ogj.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.ogw = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.ogA)) {
                    d.this.ogs.dXU();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.ocA = urlResponseInfo;
            d.this.ogs.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.f("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.ocA = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.ocA = urlResponseInfo;
            d.this.ogv = urlRequestException;
            c(d.this.ogv);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.ocA = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.ogt != null) {
                d.this.ogt.c(iOException);
            }
            if (d.this.ogu != null) {
                d.this.ogu.d(iOException);
            }
            d.this.ogx = true;
            d.this.ogj.quit();
        }
    }

    private void dZj() throws IOException {
        if (this.ogu != null) {
            this.ogu.dZc();
            if (dZl()) {
                this.ogu.close();
            }
        }
        if (!this.ogx) {
            dZi();
            this.ogj.MN(getReadTimeout());
            this.ogx = true;
        }
        dZk();
    }

    private void dZk() throws IOException {
        if (!this.ogx) {
            throw new IllegalStateException("No response.");
        }
        if (this.ogv != null) {
            throw this.ogv;
        }
        if (this.ocA == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> MM(int i) {
        try {
            dZj();
            List<Map.Entry<String, String>> dYT = dYT();
            if (i >= dYT.size()) {
                return null;
            }
            return dYT.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean dZl() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> dZm() {
        if (this.ogz != null) {
            return this.ogz;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : dYT()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.ogz = Collections.unmodifiableMap(treeMap);
        return this.ogz;
    }

    private List<Map.Entry<String, String>> dYT() {
        if (this.ogy != null) {
            return this.ogy;
        }
        this.ogy = new ArrayList();
        for (Map.Entry<String, String> entry : this.ocA.dYT()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.ogy.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.ogy = Collections.unmodifiableList(this.ogy);
        return this.ogy;
    }

    public UrlResponseInfo dZn() {
        return this.ocA;
    }

    public void dZo() {
        this.ogA = true;
    }

    public int getRequestTimeout() {
        return this.ogB;
    }
}
