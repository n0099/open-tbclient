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
    private UrlResponseInfo olE;
    private boolean omA;
    private String omH;
    private String omI;
    private final TurbonetEngine onV;
    private boolean ooK;
    private UrlRequestException opA;
    private boolean opB;
    private boolean opC;
    private List<Map.Entry<String, String>> opD;
    private Map<String, List<String>> opE;
    private boolean opF;
    private int opG;
    private final g opn;
    private boolean opp;
    private boolean opq;
    private UrlRequest opx;
    private e opy;
    private f opz;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.opB = false;
        this.opC = false;
        this.opF = false;
        this.opG = 0;
        this.opp = false;
        this.opq = false;
        this.onV = turbonetEngine;
        this.opn = new g(getURL().toString());
        this.opy = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        ecQ();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.opx.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        ecR();
        return this.olE.ecA();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        ecR();
        return this.olE.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            ecR();
            return ecU();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            ecR();
            Map<String, List<String>> ecU = ecU();
            if (ecU.containsKey(str)) {
                List<String> list = ecU.get(str);
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
        ecR();
        if (!this.instanceFollowRedirects && this.opB) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.olE.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.opy;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.opz == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (ecT()) {
                this.opz = new b(this, this.chunkLength, this.opn, this.opp, this.opq);
                ecQ();
            } else {
                long ecP = ecP();
                if (ecP != -1) {
                    this.opz = new c(this, ecP, this.opn);
                    ecQ();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.opz = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.opz = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.opz = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.opz;
    }

    private long ecP() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void ecQ() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.opn, this.onV);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.opz != null) {
                    builder.b(this.opz.ecL(), this.opn);
                    if (getRequestProperty("Content-Length") == null && !ecT()) {
                        addRequestProperty("Content-Length", Long.toString(this.opz.ecL().getLength()));
                    }
                    this.opz.ecJ();
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
                builder.ecv();
            }
            builder.Wx(this.method);
            if (this.ooK) {
                builder.ecw();
            }
            if (this.omA) {
                builder.ecx();
            }
            if (!TextUtils.isEmpty(this.omH)) {
                builder.Wy(this.omH);
            }
            if (!TextUtils.isEmpty(this.omI)) {
                builder.Wz(this.omI);
            }
            builder.MZ(getConnectTimeout());
            builder.Na(getReadTimeout());
            builder.MY(getRequestTimeout());
            this.connected = true;
            this.opx = builder.ecy();
            this.opx.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            ecR();
            if (this.olE.getHttpStatusCode() >= 400) {
                return this.opy;
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        G(str, str2, false);
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        G(str, str2, true);
    }

    private final void G(String str, String str2, boolean z) {
        if (this.connected) {
            throw new IllegalStateException("Cannot modify request property after connection is made.");
        }
        int WA = WA(str);
        if (WA >= 0) {
            if (z) {
                this.mRequestHeaders.remove(WA);
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
        int WA = WA(str);
        if (WA >= 0) {
            return (String) this.mRequestHeaders.get(WA).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(ByteBuffer byteBuffer) throws IOException {
        this.opx.n(byteBuffer);
        this.opn.Ng(getReadTimeout());
    }

    private int WA(String str) {
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
            d.this.olE = urlResponseInfo;
            d.this.opn.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.olE = urlResponseInfo;
            d.this.opn.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.opB = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.opF)) {
                    d.this.opx.ebC();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.olE = urlResponseInfo;
            d.this.opx.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.f("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.olE = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.olE = urlResponseInfo;
            d.this.opA = urlRequestException;
            c(d.this.opA);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.olE = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.opy != null) {
                d.this.opy.c(iOException);
            }
            if (d.this.opz != null) {
                d.this.opz.d(iOException);
            }
            d.this.opC = true;
            d.this.opn.quit();
        }
    }

    private void ecR() throws IOException {
        if (this.opz != null) {
            this.opz.ecK();
            if (ecT()) {
                this.opz.close();
            }
        }
        if (!this.opC) {
            ecQ();
            this.opn.Ng(getReadTimeout());
            this.opC = true;
        }
        ecS();
    }

    private void ecS() throws IOException {
        if (!this.opC) {
            throw new IllegalStateException("No response.");
        }
        if (this.opA != null) {
            throw this.opA;
        }
        if (this.olE == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> Nf(int i) {
        try {
            ecR();
            List<Map.Entry<String, String>> ecB = ecB();
            if (i >= ecB.size()) {
                return null;
            }
            return ecB.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean ecT() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> ecU() {
        if (this.opE != null) {
            return this.opE;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : ecB()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.opE = Collections.unmodifiableMap(treeMap);
        return this.opE;
    }

    private List<Map.Entry<String, String>> ecB() {
        if (this.opD != null) {
            return this.opD;
        }
        this.opD = new ArrayList();
        for (Map.Entry<String, String> entry : this.olE.ecB()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.opD.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.opD = Collections.unmodifiableList(this.opD);
        return this.opD;
    }

    public UrlResponseInfo ecV() {
        return this.olE;
    }

    public void ecW() {
        this.opF = true;
    }

    public int getRequestTimeout() {
        return this.opG;
    }
}
