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
/* loaded from: classes5.dex */
public class d extends HttpURLConnection {
    private final List<Pair<String, String>> mRequestHeaders;
    private UrlResponseInfo oRM;
    private boolean oSp;
    private String oSv;
    private String oSw;
    private boolean oTT;
    private final TurbonetEngine oTo;
    private final g oUh;
    private boolean oUj;
    private boolean oUk;
    private UrlRequest oUq;
    private e oUr;
    private f oUs;
    private UrlRequestException oUt;
    private boolean oUu;
    private boolean oUv;
    private List<Map.Entry<String, String>> oUw;
    private Map<String, List<String>> oUx;
    private boolean oUy;
    private int oUz;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.oUu = false;
        this.oUv = false;
        this.oUy = false;
        this.oUz = 0;
        this.oUj = false;
        this.oUk = false;
        this.oTo = turbonetEngine;
        this.oUh = new g(getURL().toString());
        this.oUr = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        ehw();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.oUq.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        ehx();
        return this.oRM.ehj();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        ehx();
        return this.oRM.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            ehx();
            return ehA();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            ehx();
            Map<String, List<String>> ehA = ehA();
            if (ehA.containsKey(str)) {
                List<String> list = ehA.get(str);
                return list.get(list.size() - 1);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        Map.Entry<String, String> Nj = Nj(i);
        if (Nj == null) {
            return null;
        }
        return Nj.getKey();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        Map.Entry<String, String> Nj = Nj(i);
        if (Nj == null) {
            return null;
        }
        return Nj.getValue();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        ehx();
        if (!this.instanceFollowRedirects && this.oUu) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.oRM.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.oUr;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.oUs == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (ehz()) {
                this.oUs = new b(this, this.chunkLength, this.oUh, this.oUj, this.oUk);
                ehw();
            } else {
                long ehv = ehv();
                if (ehv != -1) {
                    this.oUs = new c(this, ehv, this.oUh);
                    ehw();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.oUs = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.oUs = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.e("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.oUs = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.oUs;
    }

    private long ehv() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void ehw() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.oUh, this.oTo);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.oUs != null) {
                    builder.b(this.oUs.ehr(), this.oUh);
                    if (getRequestProperty("Content-Length") == null && !ehz()) {
                        addRequestProperty("Content-Length", Long.toString(this.oUs.ehr().getLength()));
                    }
                    this.oUs.ehp();
                } else if (getRequestProperty("Content-Length") == null) {
                    addRequestProperty("Content-Length", "0");
                }
                if (getRequestProperty("Content-Type") == null) {
                    addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
            }
            for (Pair<String, String> pair : this.mRequestHeaders) {
                builder.hb((String) pair.first, (String) pair.second);
            }
            if (!getUseCaches()) {
                builder.ehe();
            }
            builder.Xq(this.method);
            if (this.oTT) {
                builder.ehf();
            }
            if (this.oSp) {
                builder.ehg();
            }
            if (!TextUtils.isEmpty(this.oSv)) {
                builder.Xr(this.oSv);
            }
            if (!TextUtils.isEmpty(this.oSw)) {
                builder.Xs(this.oSw);
            }
            builder.Ne(getConnectTimeout());
            builder.Nf(getReadTimeout());
            builder.Nd(getRequestTimeout());
            this.connected = true;
            this.oUq = builder.ehh();
            this.oUq.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            ehx();
            if (this.oRM.getHttpStatusCode() >= 400) {
                return this.oUr;
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        K(str, str2, false);
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        K(str, str2, true);
    }

    private final void K(String str, String str2, boolean z) {
        if (this.connected) {
            throw new IllegalStateException("Cannot modify request property after connection is made.");
        }
        int Xt = Xt(str);
        if (Xt >= 0) {
            if (z) {
                this.mRequestHeaders.remove(Xt);
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
        int Xt = Xt(str);
        if (Xt >= 0) {
            return (String) this.mRequestHeaders.get(Xt).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ByteBuffer byteBuffer) throws IOException {
        this.oUq.read(byteBuffer);
        this.oUh.Nk(getReadTimeout());
    }

    private int Xt(String str) {
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
    /* loaded from: classes5.dex */
    public class a extends UrlRequest.Callback {
        public a() {
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.oRM = urlResponseInfo;
            d.this.oUh.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.oRM = urlResponseInfo;
            d.this.oUh.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.oUu = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.oUy)) {
                    d.this.oUq.followRedirect();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.oRM = urlResponseInfo;
            d.this.oUq.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.i("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.oRM = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.e("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.oRM = urlResponseInfo;
            d.this.oUt = urlRequestException;
            c(d.this.oUt);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.oRM = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.oUr != null) {
                d.this.oUr.c(iOException);
            }
            if (d.this.oUs != null) {
                d.this.oUs.d(iOException);
            }
            d.this.oUv = true;
            d.this.oUh.quit();
        }
    }

    private void ehx() throws IOException {
        if (this.oUs != null) {
            this.oUs.ehq();
            if (ehz()) {
                this.oUs.close();
            }
        }
        if (!this.oUv) {
            ehw();
            this.oUh.Nk(getReadTimeout());
            this.oUv = true;
        }
        ehy();
    }

    private void ehy() throws IOException {
        if (!this.oUv) {
            throw new IllegalStateException("No response.");
        }
        if (this.oUt != null) {
            throw this.oUt;
        }
        if (this.oRM == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> Nj(int i) {
        try {
            ehx();
            List<Map.Entry<String, String>> ehk = ehk();
            if (i >= ehk.size()) {
                return null;
            }
            return ehk.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean ehz() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> ehA() {
        if (this.oUx != null) {
            return this.oUx;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : ehk()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.oUx = Collections.unmodifiableMap(treeMap);
        return this.oUx;
    }

    private List<Map.Entry<String, String>> ehk() {
        if (this.oUw != null) {
            return this.oUw;
        }
        this.oUw = new ArrayList();
        for (Map.Entry<String, String> entry : this.oRM.ehk()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.oUw.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.oUw = Collections.unmodifiableList(this.oUw);
        return this.oUw;
    }

    public UrlResponseInfo ehB() {
        return this.oRM;
    }

    public void ehC() {
        this.oUy = true;
    }

    public int getRequestTimeout() {
        return this.oUz;
    }
}
