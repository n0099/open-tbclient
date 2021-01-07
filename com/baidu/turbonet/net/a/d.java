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
    private UrlResponseInfo oJC;
    private boolean oKf;
    private String oKm;
    private String oKn;
    private boolean oLK;
    private final g oLY;
    private final TurbonetEngine oLf;
    private boolean oMa;
    private boolean oMb;
    private UrlRequest oMh;
    private e oMi;
    private f oMj;
    private UrlRequestException oMk;
    private boolean oMl;
    private boolean oMm;
    private List<Map.Entry<String, String>> oMn;
    private Map<String, List<String>> oMo;
    private boolean oMp;
    private int oMq;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.oMl = false;
        this.oMm = false;
        this.oMp = false;
        this.oMq = 0;
        this.oMa = false;
        this.oMb = false;
        this.oLf = turbonetEngine;
        this.oLY = new g(getURL().toString());
        this.oMi = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        eiG();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.oMh.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        eiH();
        return this.oJC.eit();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        eiH();
        return this.oJC.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            eiH();
            return eiK();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            eiH();
            Map<String, List<String>> eiK = eiK();
            if (eiK.containsKey(str)) {
                List<String> list = eiK.get(str);
                return list.get(list.size() - 1);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        Map.Entry<String, String> Op = Op(i);
        if (Op == null) {
            return null;
        }
        return Op.getKey();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        Map.Entry<String, String> Op = Op(i);
        if (Op == null) {
            return null;
        }
        return Op.getValue();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        eiH();
        if (!this.instanceFollowRedirects && this.oMl) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.oJC.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.oMi;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.oMj == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (eiJ()) {
                this.oMj = new b(this, this.chunkLength, this.oLY, this.oMa, this.oMb);
                eiG();
            } else {
                long eiF = eiF();
                if (eiF != -1) {
                    this.oMj = new c(this, eiF, this.oLY);
                    eiG();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.oMj = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.oMj = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.e("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.oMj = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.oMj;
    }

    private long eiF() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void eiG() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.oLY, this.oLf);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.oMj != null) {
                    builder.b(this.oMj.eiB(), this.oLY);
                    if (getRequestProperty("Content-Length") == null && !eiJ()) {
                        addRequestProperty("Content-Length", Long.toString(this.oMj.eiB().getLength()));
                    }
                    this.oMj.eiz();
                } else if (getRequestProperty("Content-Length") == null) {
                    addRequestProperty("Content-Length", "0");
                }
                if (getRequestProperty("Content-Type") == null) {
                    addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
            }
            for (Pair<String, String> pair : this.mRequestHeaders) {
                builder.gT((String) pair.first, (String) pair.second);
            }
            if (!getUseCaches()) {
                builder.eio();
            }
            builder.Xf(this.method);
            if (this.oLK) {
                builder.eip();
            }
            if (this.oKf) {
                builder.eiq();
            }
            if (!TextUtils.isEmpty(this.oKm)) {
                builder.Xg(this.oKm);
            }
            if (!TextUtils.isEmpty(this.oKn)) {
                builder.Xh(this.oKn);
            }
            builder.Ok(getConnectTimeout());
            builder.Ol(getReadTimeout());
            builder.Oj(getRequestTimeout());
            this.connected = true;
            this.oMh = builder.eir();
            this.oMh.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            eiH();
            if (this.oJC.getHttpStatusCode() >= 400) {
                return this.oMi;
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
        int Xi = Xi(str);
        if (Xi >= 0) {
            if (z) {
                this.mRequestHeaders.remove(Xi);
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
        int Xi = Xi(str);
        if (Xi >= 0) {
            return (String) this.mRequestHeaders.get(Xi).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ByteBuffer byteBuffer) throws IOException {
        this.oMh.read(byteBuffer);
        this.oLY.Oq(getReadTimeout());
    }

    private int Xi(String str) {
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
            d.this.oJC = urlResponseInfo;
            d.this.oLY.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.oJC = urlResponseInfo;
            d.this.oLY.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.oMl = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.oMp)) {
                    d.this.oMh.followRedirect();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.oJC = urlResponseInfo;
            d.this.oMh.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.i("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.oJC = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.e("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.oJC = urlResponseInfo;
            d.this.oMk = urlRequestException;
            c(d.this.oMk);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.oJC = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.oMi != null) {
                d.this.oMi.c(iOException);
            }
            if (d.this.oMj != null) {
                d.this.oMj.d(iOException);
            }
            d.this.oMm = true;
            d.this.oLY.quit();
        }
    }

    private void eiH() throws IOException {
        if (this.oMj != null) {
            this.oMj.eiA();
            if (eiJ()) {
                this.oMj.close();
            }
        }
        if (!this.oMm) {
            eiG();
            this.oLY.Oq(getReadTimeout());
            this.oMm = true;
        }
        eiI();
    }

    private void eiI() throws IOException {
        if (!this.oMm) {
            throw new IllegalStateException("No response.");
        }
        if (this.oMk != null) {
            throw this.oMk;
        }
        if (this.oJC == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> Op(int i) {
        try {
            eiH();
            List<Map.Entry<String, String>> eiu = eiu();
            if (i >= eiu.size()) {
                return null;
            }
            return eiu.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean eiJ() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> eiK() {
        if (this.oMo != null) {
            return this.oMo;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : eiu()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.oMo = Collections.unmodifiableMap(treeMap);
        return this.oMo;
    }

    private List<Map.Entry<String, String>> eiu() {
        if (this.oMn != null) {
            return this.oMn;
        }
        this.oMn = new ArrayList();
        for (Map.Entry<String, String> entry : this.oJC.eiu()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.oMn.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.oMn = Collections.unmodifiableList(this.oMn);
        return this.oMn;
    }

    public UrlResponseInfo eiL() {
        return this.oJC;
    }

    public void eiM() {
        this.oMp = true;
    }

    public int getRequestTimeout() {
        return this.oMq;
    }
}
