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
    private boolean oPK;
    private String oPQ;
    private String oPR;
    private UrlResponseInfo oPh;
    private final TurbonetEngine oQJ;
    private final g oRC;
    private boolean oRE;
    private boolean oRF;
    private UrlRequest oRL;
    private e oRM;
    private f oRN;
    private UrlRequestException oRO;
    private boolean oRP;
    private boolean oRQ;
    private List<Map.Entry<String, String>> oRR;
    private Map<String, List<String>> oRS;
    private boolean oRT;
    private int oRU;
    private boolean oRo;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.oRP = false;
        this.oRQ = false;
        this.oRT = false;
        this.oRU = 0;
        this.oRE = false;
        this.oRF = false;
        this.oQJ = turbonetEngine;
        this.oRC = new g(getURL().toString());
        this.oRM = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        ehg();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.oRL.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        ehh();
        return this.oPh.egT();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        ehh();
        return this.oPh.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            ehh();
            return ehk();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            ehh();
            Map<String, List<String>> ehk = ehk();
            if (ehk.containsKey(str)) {
                List<String> list = ehk.get(str);
                return list.get(list.size() - 1);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        Map.Entry<String, String> Ne = Ne(i);
        if (Ne == null) {
            return null;
        }
        return Ne.getKey();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        Map.Entry<String, String> Ne = Ne(i);
        if (Ne == null) {
            return null;
        }
        return Ne.getValue();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        ehh();
        if (!this.instanceFollowRedirects && this.oRP) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.oPh.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.oRM;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.oRN == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (ehj()) {
                this.oRN = new b(this, this.chunkLength, this.oRC, this.oRE, this.oRF);
                ehg();
            } else {
                long ehf = ehf();
                if (ehf != -1) {
                    this.oRN = new c(this, ehf, this.oRC);
                    ehg();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.oRN = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.oRN = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.e("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.oRN = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.oRN;
    }

    private long ehf() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void ehg() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.oRC, this.oQJ);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.oRN != null) {
                    builder.b(this.oRN.ehb(), this.oRC);
                    if (getRequestProperty("Content-Length") == null && !ehj()) {
                        addRequestProperty("Content-Length", Long.toString(this.oRN.ehb().getLength()));
                    }
                    this.oRN.egZ();
                } else if (getRequestProperty("Content-Length") == null) {
                    addRequestProperty("Content-Length", "0");
                }
                if (getRequestProperty("Content-Type") == null) {
                    addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
            }
            for (Pair<String, String> pair : this.mRequestHeaders) {
                builder.gZ((String) pair.first, (String) pair.second);
            }
            if (!getUseCaches()) {
                builder.egO();
            }
            builder.WX(this.method);
            if (this.oRo) {
                builder.egP();
            }
            if (this.oPK) {
                builder.egQ();
            }
            if (!TextUtils.isEmpty(this.oPQ)) {
                builder.WY(this.oPQ);
            }
            if (!TextUtils.isEmpty(this.oPR)) {
                builder.WZ(this.oPR);
            }
            builder.MZ(getConnectTimeout());
            builder.Na(getReadTimeout());
            builder.MY(getRequestTimeout());
            this.connected = true;
            this.oRL = builder.egR();
            this.oRL.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            ehh();
            if (this.oPh.getHttpStatusCode() >= 400) {
                return this.oRM;
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
        int Xa = Xa(str);
        if (Xa >= 0) {
            if (z) {
                this.mRequestHeaders.remove(Xa);
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
        int Xa = Xa(str);
        if (Xa >= 0) {
            return (String) this.mRequestHeaders.get(Xa).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ByteBuffer byteBuffer) throws IOException {
        this.oRL.read(byteBuffer);
        this.oRC.Nf(getReadTimeout());
    }

    private int Xa(String str) {
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
            d.this.oPh = urlResponseInfo;
            d.this.oRC.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.oPh = urlResponseInfo;
            d.this.oRC.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.oRP = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.oRT)) {
                    d.this.oRL.followRedirect();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.oPh = urlResponseInfo;
            d.this.oRL.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.i("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.oPh = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.e("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.oPh = urlResponseInfo;
            d.this.oRO = urlRequestException;
            c(d.this.oRO);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.oPh = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.oRM != null) {
                d.this.oRM.c(iOException);
            }
            if (d.this.oRN != null) {
                d.this.oRN.d(iOException);
            }
            d.this.oRQ = true;
            d.this.oRC.quit();
        }
    }

    private void ehh() throws IOException {
        if (this.oRN != null) {
            this.oRN.eha();
            if (ehj()) {
                this.oRN.close();
            }
        }
        if (!this.oRQ) {
            ehg();
            this.oRC.Nf(getReadTimeout());
            this.oRQ = true;
        }
        ehi();
    }

    private void ehi() throws IOException {
        if (!this.oRQ) {
            throw new IllegalStateException("No response.");
        }
        if (this.oRO != null) {
            throw this.oRO;
        }
        if (this.oPh == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> Ne(int i) {
        try {
            ehh();
            List<Map.Entry<String, String>> egU = egU();
            if (i >= egU.size()) {
                return null;
            }
            return egU.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean ehj() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> ehk() {
        if (this.oRS != null) {
            return this.oRS;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : egU()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.oRS = Collections.unmodifiableMap(treeMap);
        return this.oRS;
    }

    private List<Map.Entry<String, String>> egU() {
        if (this.oRR != null) {
            return this.oRR;
        }
        this.oRR = new ArrayList();
        for (Map.Entry<String, String> entry : this.oPh.egU()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.oRR.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.oRR = Collections.unmodifiableList(this.oRR);
        return this.oRR;
    }

    public UrlResponseInfo ehl() {
        return this.oPh;
    }

    public void ehm() {
        this.oRT = true;
    }

    public int getRequestTimeout() {
        return this.oRU;
    }
}
