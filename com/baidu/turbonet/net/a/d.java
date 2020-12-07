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
/* loaded from: classes14.dex */
public class d extends HttpURLConnection {
    private final List<Pair<String, String>> mRequestHeaders;
    private UrlResponseInfo oCg;
    private boolean oDc;
    private String oDj;
    private String oDk;
    private final TurbonetEngine oEw;
    private final g oFN;
    private boolean oFP;
    private boolean oFQ;
    private UrlRequest oFW;
    private e oFX;
    private f oFY;
    private UrlRequestException oFZ;
    private boolean oFk;
    private boolean oGa;
    private boolean oGb;
    private List<Map.Entry<String, String>> oGc;
    private Map<String, List<String>> oGd;
    private boolean oGe;
    private int oGf;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.oGa = false;
        this.oGb = false;
        this.oGe = false;
        this.oGf = 0;
        this.oFP = false;
        this.oFQ = false;
        this.oEw = turbonetEngine;
        this.oFN = new g(getURL().toString());
        this.oFX = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        eiu();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.oFW.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        eiv();
        return this.oCg.eie();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        eiv();
        return this.oCg.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            eiv();
            return eiy();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            eiv();
            Map<String, List<String>> eiy = eiy();
            if (eiy.containsKey(str)) {
                List<String> list = eiy.get(str);
                return list.get(list.size() - 1);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        Map.Entry<String, String> OA = OA(i);
        if (OA == null) {
            return null;
        }
        return OA.getKey();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        Map.Entry<String, String> OA = OA(i);
        if (OA == null) {
            return null;
        }
        return OA.getValue();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        eiv();
        if (!this.instanceFollowRedirects && this.oGa) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.oCg.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.oFX;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.oFY == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (eix()) {
                this.oFY = new b(this, this.chunkLength, this.oFN, this.oFP, this.oFQ);
                eiu();
            } else {
                long eit = eit();
                if (eit != -1) {
                    this.oFY = new c(this, eit, this.oFN);
                    eiu();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.oFY = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.oFY = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.oFY = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.oFY;
    }

    private long eit() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void eiu() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.oFN, this.oEw);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.oFY != null) {
                    builder.b(this.oFY.eip(), this.oFN);
                    if (getRequestProperty("Content-Length") == null && !eix()) {
                        addRequestProperty("Content-Length", Long.toString(this.oFY.eip().getLength()));
                    }
                    this.oFY.ein();
                } else if (getRequestProperty("Content-Length") == null) {
                    addRequestProperty("Content-Length", "0");
                }
                if (getRequestProperty("Content-Type") == null) {
                    addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
            }
            for (Pair<String, String> pair : this.mRequestHeaders) {
                builder.gV((String) pair.first, (String) pair.second);
            }
            if (!getUseCaches()) {
                builder.ehZ();
            }
            builder.Xx(this.method);
            if (this.oFk) {
                builder.eia();
            }
            if (this.oDc) {
                builder.eib();
            }
            if (!TextUtils.isEmpty(this.oDj)) {
                builder.Xy(this.oDj);
            }
            if (!TextUtils.isEmpty(this.oDk)) {
                builder.Xz(this.oDk);
            }
            builder.Ou(getConnectTimeout());
            builder.Ov(getReadTimeout());
            builder.Ot(getRequestTimeout());
            this.connected = true;
            this.oFW = builder.eic();
            this.oFW.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            eiv();
            if (this.oCg.getHttpStatusCode() >= 400) {
                return this.oFX;
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        I(str, str2, false);
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        I(str, str2, true);
    }

    private final void I(String str, String str2, boolean z) {
        if (this.connected) {
            throw new IllegalStateException("Cannot modify request property after connection is made.");
        }
        int XA = XA(str);
        if (XA >= 0) {
            if (z) {
                this.mRequestHeaders.remove(XA);
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
        int XA = XA(str);
        if (XA >= 0) {
            return (String) this.mRequestHeaders.get(XA).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(ByteBuffer byteBuffer) throws IOException {
        this.oFW.n(byteBuffer);
        this.oFN.OB(getReadTimeout());
    }

    private int XA(String str) {
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
    /* loaded from: classes14.dex */
    public class a extends UrlRequest.Callback {
        public a() {
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.oCg = urlResponseInfo;
            d.this.oFN.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.oCg = urlResponseInfo;
            d.this.oFN.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.oGa = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.oGe)) {
                    d.this.oFW.ehg();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.oCg = urlResponseInfo;
            d.this.oFW.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.f("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.oCg = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.oCg = urlResponseInfo;
            d.this.oFZ = urlRequestException;
            c(d.this.oFZ);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.oCg = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.oFX != null) {
                d.this.oFX.c(iOException);
            }
            if (d.this.oFY != null) {
                d.this.oFY.d(iOException);
            }
            d.this.oGb = true;
            d.this.oFN.quit();
        }
    }

    private void eiv() throws IOException {
        if (this.oFY != null) {
            this.oFY.eio();
            if (eix()) {
                this.oFY.close();
            }
        }
        if (!this.oGb) {
            eiu();
            this.oFN.OB(getReadTimeout());
            this.oGb = true;
        }
        eiw();
    }

    private void eiw() throws IOException {
        if (!this.oGb) {
            throw new IllegalStateException("No response.");
        }
        if (this.oFZ != null) {
            throw this.oFZ;
        }
        if (this.oCg == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> OA(int i) {
        try {
            eiv();
            List<Map.Entry<String, String>> eif = eif();
            if (i >= eif.size()) {
                return null;
            }
            return eif.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean eix() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> eiy() {
        if (this.oGd != null) {
            return this.oGd;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : eif()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.oGd = Collections.unmodifiableMap(treeMap);
        return this.oGd;
    }

    private List<Map.Entry<String, String>> eif() {
        if (this.oGc != null) {
            return this.oGc;
        }
        this.oGc = new ArrayList();
        for (Map.Entry<String, String> entry : this.oCg.eif()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.oGc.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.oGc = Collections.unmodifiableList(this.oGc);
        return this.oGc;
    }

    public UrlResponseInfo eiz() {
        return this.oCg;
    }

    public void eiA() {
        this.oGe = true;
    }

    public int getRequestTimeout() {
        return this.oGf;
    }
}
