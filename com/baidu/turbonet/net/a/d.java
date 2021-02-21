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
/* loaded from: classes6.dex */
public class d extends HttpURLConnection {
    private final List<Pair<String, String>> mRequestHeaders;
    private UrlResponseInfo oPH;
    private boolean oQk;
    private String oQq;
    private String oQr;
    private boolean oRO;
    private final TurbonetEngine oRj;
    private final g oSc;
    private boolean oSe;
    private boolean oSf;
    private UrlRequest oSl;
    private e oSm;
    private f oSn;
    private UrlRequestException oSo;
    private boolean oSp;
    private boolean oSq;
    private List<Map.Entry<String, String>> oSr;
    private Map<String, List<String>> oSs;
    private boolean oSt;
    private int oSu;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.oSp = false;
        this.oSq = false;
        this.oSt = false;
        this.oSu = 0;
        this.oSe = false;
        this.oSf = false;
        this.oRj = turbonetEngine;
        this.oSc = new g(getURL().toString());
        this.oSm = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        eho();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.oSl.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        ehp();
        return this.oPH.ehb();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        ehp();
        return this.oPH.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            ehp();
            return ehs();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            ehp();
            Map<String, List<String>> ehs = ehs();
            if (ehs.containsKey(str)) {
                List<String> list = ehs.get(str);
                return list.get(list.size() - 1);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        Map.Entry<String, String> Nf = Nf(i);
        if (Nf == null) {
            return null;
        }
        return Nf.getKey();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        Map.Entry<String, String> Nf = Nf(i);
        if (Nf == null) {
            return null;
        }
        return Nf.getValue();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        ehp();
        if (!this.instanceFollowRedirects && this.oSp) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.oPH.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.oSm;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.oSn == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (ehr()) {
                this.oSn = new b(this, this.chunkLength, this.oSc, this.oSe, this.oSf);
                eho();
            } else {
                long ehn = ehn();
                if (ehn != -1) {
                    this.oSn = new c(this, ehn, this.oSc);
                    eho();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.oSn = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.oSn = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.e("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.oSn = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.oSn;
    }

    private long ehn() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void eho() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.oSc, this.oRj);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.oSn != null) {
                    builder.b(this.oSn.ehj(), this.oSc);
                    if (getRequestProperty("Content-Length") == null && !ehr()) {
                        addRequestProperty("Content-Length", Long.toString(this.oSn.ehj().getLength()));
                    }
                    this.oSn.ehh();
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
                builder.egW();
            }
            builder.Xj(this.method);
            if (this.oRO) {
                builder.egX();
            }
            if (this.oQk) {
                builder.egY();
            }
            if (!TextUtils.isEmpty(this.oQq)) {
                builder.Xk(this.oQq);
            }
            if (!TextUtils.isEmpty(this.oQr)) {
                builder.Xl(this.oQr);
            }
            builder.Na(getConnectTimeout());
            builder.Nb(getReadTimeout());
            builder.MZ(getRequestTimeout());
            this.connected = true;
            this.oSl = builder.egZ();
            this.oSl.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            ehp();
            if (this.oPH.getHttpStatusCode() >= 400) {
                return this.oSm;
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
        int Xm = Xm(str);
        if (Xm >= 0) {
            if (z) {
                this.mRequestHeaders.remove(Xm);
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
        int Xm = Xm(str);
        if (Xm >= 0) {
            return (String) this.mRequestHeaders.get(Xm).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ByteBuffer byteBuffer) throws IOException {
        this.oSl.read(byteBuffer);
        this.oSc.Ng(getReadTimeout());
    }

    private int Xm(String str) {
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
    /* loaded from: classes6.dex */
    public class a extends UrlRequest.Callback {
        public a() {
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.oPH = urlResponseInfo;
            d.this.oSc.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.oPH = urlResponseInfo;
            d.this.oSc.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.oSp = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.oSt)) {
                    d.this.oSl.followRedirect();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.oPH = urlResponseInfo;
            d.this.oSl.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.i("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.oPH = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.e("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.oPH = urlResponseInfo;
            d.this.oSo = urlRequestException;
            c(d.this.oSo);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.oPH = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.oSm != null) {
                d.this.oSm.c(iOException);
            }
            if (d.this.oSn != null) {
                d.this.oSn.d(iOException);
            }
            d.this.oSq = true;
            d.this.oSc.quit();
        }
    }

    private void ehp() throws IOException {
        if (this.oSn != null) {
            this.oSn.ehi();
            if (ehr()) {
                this.oSn.close();
            }
        }
        if (!this.oSq) {
            eho();
            this.oSc.Ng(getReadTimeout());
            this.oSq = true;
        }
        ehq();
    }

    private void ehq() throws IOException {
        if (!this.oSq) {
            throw new IllegalStateException("No response.");
        }
        if (this.oSo != null) {
            throw this.oSo;
        }
        if (this.oPH == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> Nf(int i) {
        try {
            ehp();
            List<Map.Entry<String, String>> ehc = ehc();
            if (i >= ehc.size()) {
                return null;
            }
            return ehc.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean ehr() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> ehs() {
        if (this.oSs != null) {
            return this.oSs;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : ehc()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.oSs = Collections.unmodifiableMap(treeMap);
        return this.oSs;
    }

    private List<Map.Entry<String, String>> ehc() {
        if (this.oSr != null) {
            return this.oSr;
        }
        this.oSr = new ArrayList();
        for (Map.Entry<String, String> entry : this.oPH.ehc()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.oSr.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.oSr = Collections.unmodifiableList(this.oSr);
        return this.oSr;
    }

    public UrlResponseInfo eht() {
        return this.oPH;
    }

    public void ehu() {
        this.oSt = true;
    }

    public int getRequestTimeout() {
        return this.oSu;
    }
}
