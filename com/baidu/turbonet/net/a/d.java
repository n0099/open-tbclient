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
/* loaded from: classes.dex */
public class d extends HttpURLConnection {
    private UrlResponseInfo lIM;
    private boolean lJI;
    private String lJP;
    private String lJQ;
    private boolean lLT;
    private final TurbonetEngine lLe;
    private UrlRequest lMF;
    private e lMG;
    private f lMH;
    private UrlRequestException lMI;
    private boolean lMJ;
    private boolean lMK;
    private List<Map.Entry<String, String>> lML;
    private Map<String, List<String>> lMM;
    private boolean lMN;
    private int lMO;
    private final g lMw;
    private boolean lMy;
    private boolean lMz;
    private final List<Pair<String, String>> mRequestHeaders;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.lMJ = false;
        this.lMK = false;
        this.lMN = false;
        this.lMO = 0;
        this.lMy = false;
        this.lMz = false;
        this.lLe = turbonetEngine;
        this.lMw = new g(getURL().toString());
        this.lMG = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        dkj();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.lMF.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        dkk();
        return this.lIM.djT();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        dkk();
        return this.lIM.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            dkk();
            return dkn();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            dkk();
            Map<String, List<String>> dkn = dkn();
            if (dkn.containsKey(str)) {
                List<String> list = dkn.get(str);
                return list.get(list.size() - 1);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        Map.Entry<String, String> FI = FI(i);
        if (FI == null) {
            return null;
        }
        return FI.getKey();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        Map.Entry<String, String> FI = FI(i);
        if (FI == null) {
            return null;
        }
        return FI.getValue();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        dkk();
        if (!this.instanceFollowRedirects && this.lMJ) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.lIM.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.lMG;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.lMH == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (dkm()) {
                this.lMH = new b(this, this.chunkLength, this.lMw, this.lMy, this.lMz);
                dkj();
            } else {
                long dki = dki();
                if (dki != -1) {
                    this.lMH = new c(this, dki, this.lMw);
                    dkj();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.lMH = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.lMH = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.h("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.lMH = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.lMH;
    }

    private long dki() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void dkj() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.lMw, this.lLe);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.lMH != null) {
                    builder.b(this.lMH.dke(), this.lMw);
                    if (getRequestProperty("Content-Length") == null && !dkm()) {
                        addRequestProperty("Content-Length", Long.toString(this.lMH.dke().getLength()));
                    }
                    this.lMH.dkc();
                } else if (getRequestProperty("Content-Length") == null) {
                    addRequestProperty("Content-Length", "0");
                }
                if (getRequestProperty("Content-Type") == null) {
                    addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
            }
            for (Pair<String, String> pair : this.mRequestHeaders) {
                builder.fe((String) pair.first, (String) pair.second);
            }
            if (!getUseCaches()) {
                builder.djO();
            }
            builder.Ni(this.method);
            if (this.lLT) {
                builder.djP();
            }
            if (this.lJI) {
                builder.djQ();
            }
            if (!TextUtils.isEmpty(this.lJP)) {
                builder.Nj(this.lJP);
            }
            if (!TextUtils.isEmpty(this.lJQ)) {
                builder.Nk(this.lJQ);
            }
            builder.FC(getConnectTimeout());
            builder.FD(getReadTimeout());
            builder.FB(getRequestTimeout());
            this.connected = true;
            this.lMF = builder.djR();
            this.lMF.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            dkk();
            if (this.lIM.getHttpStatusCode() >= 400) {
                return this.lMG;
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        C(str, str2, false);
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        C(str, str2, true);
    }

    private final void C(String str, String str2, boolean z) {
        if (this.connected) {
            throw new IllegalStateException("Cannot modify request property after connection is made.");
        }
        int Nl = Nl(str);
        if (Nl >= 0) {
            if (z) {
                this.mRequestHeaders.remove(Nl);
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
        int Nl = Nl(str);
        if (Nl >= 0) {
            return (String) this.mRequestHeaders.get(Nl).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ByteBuffer byteBuffer) throws IOException {
        this.lMF.h(byteBuffer);
        this.lMw.FJ(getReadTimeout());
    }

    private int Nl(String str) {
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
    /* loaded from: classes.dex */
    public class a extends UrlRequest.Callback {
        public a() {
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.lIM = urlResponseInfo;
            d.this.lMw.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.lIM = urlResponseInfo;
            d.this.lMw.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.lMJ = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.lMN)) {
                    d.this.lMF.diU();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.lIM = urlResponseInfo;
            d.this.lMF.cancel();
            b(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.lIM = urlResponseInfo;
            b(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.h("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.lIM = urlResponseInfo;
            d.this.lMI = urlRequestException;
            b(d.this.lMI);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.lIM = urlResponseInfo;
            b(new IOException("stream closed"));
        }

        private void b(IOException iOException) {
            if (d.this.lMG != null) {
                d.this.lMG.b(iOException);
            }
            if (d.this.lMH != null) {
                d.this.lMH.c(iOException);
            }
            d.this.lMK = true;
            d.this.lMw.quit();
        }
    }

    private void dkk() throws IOException {
        if (this.lMH != null) {
            this.lMH.dkd();
            if (dkm()) {
                this.lMH.close();
            }
        }
        if (!this.lMK) {
            dkj();
            this.lMw.FJ(getReadTimeout());
            this.lMK = true;
        }
        dkl();
    }

    private void dkl() throws IOException {
        if (!this.lMK) {
            throw new IllegalStateException("No response.");
        }
        if (this.lMI != null) {
            throw this.lMI;
        }
        if (this.lIM == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> FI(int i) {
        try {
            dkk();
            List<Map.Entry<String, String>> djU = djU();
            if (i >= djU.size()) {
                return null;
            }
            return djU.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean dkm() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> dkn() {
        if (this.lMM != null) {
            return this.lMM;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : djU()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.lMM = Collections.unmodifiableMap(treeMap);
        return this.lMM;
    }

    private List<Map.Entry<String, String>> djU() {
        if (this.lML != null) {
            return this.lML;
        }
        this.lML = new ArrayList();
        for (Map.Entry<String, String> entry : this.lIM.djU()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.lML.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.lML = Collections.unmodifiableList(this.lML);
        return this.lML;
    }

    public UrlResponseInfo dko() {
        return this.lIM;
    }

    public void dkp() {
        this.lMN = true;
    }

    public int getRequestTimeout() {
        return this.lMO;
    }
}
