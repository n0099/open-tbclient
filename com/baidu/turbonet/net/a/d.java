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
    private UrlResponseInfo oCi;
    private boolean oDe;
    private String oDl;
    private String oDm;
    private final TurbonetEngine oEy;
    private final g oFP;
    private boolean oFR;
    private boolean oFS;
    private UrlRequest oFY;
    private e oFZ;
    private boolean oFm;
    private f oGa;
    private UrlRequestException oGb;
    private boolean oGc;
    private boolean oGd;
    private List<Map.Entry<String, String>> oGe;
    private Map<String, List<String>> oGf;
    private boolean oGg;
    private int oGh;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.oGc = false;
        this.oGd = false;
        this.oGg = false;
        this.oGh = 0;
        this.oFR = false;
        this.oFS = false;
        this.oEy = turbonetEngine;
        this.oFP = new g(getURL().toString());
        this.oFZ = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        eiv();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.oFY.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        eiw();
        return this.oCi.eif();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        eiw();
        return this.oCi.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            eiw();
            return eiz();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            eiw();
            Map<String, List<String>> eiz = eiz();
            if (eiz.containsKey(str)) {
                List<String> list = eiz.get(str);
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
        eiw();
        if (!this.instanceFollowRedirects && this.oGc) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.oCi.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.oFZ;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.oGa == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (eiy()) {
                this.oGa = new b(this, this.chunkLength, this.oFP, this.oFR, this.oFS);
                eiv();
            } else {
                long eiu = eiu();
                if (eiu != -1) {
                    this.oGa = new c(this, eiu, this.oFP);
                    eiv();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.oGa = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.oGa = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.oGa = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.oGa;
    }

    private long eiu() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void eiv() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.oFP, this.oEy);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.oGa != null) {
                    builder.b(this.oGa.eiq(), this.oFP);
                    if (getRequestProperty("Content-Length") == null && !eiy()) {
                        addRequestProperty("Content-Length", Long.toString(this.oGa.eiq().getLength()));
                    }
                    this.oGa.eio();
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
                builder.eia();
            }
            builder.Xx(this.method);
            if (this.oFm) {
                builder.eib();
            }
            if (this.oDe) {
                builder.eic();
            }
            if (!TextUtils.isEmpty(this.oDl)) {
                builder.Xy(this.oDl);
            }
            if (!TextUtils.isEmpty(this.oDm)) {
                builder.Xz(this.oDm);
            }
            builder.Ou(getConnectTimeout());
            builder.Ov(getReadTimeout());
            builder.Ot(getRequestTimeout());
            this.connected = true;
            this.oFY = builder.eid();
            this.oFY.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            eiw();
            if (this.oCi.getHttpStatusCode() >= 400) {
                return this.oFZ;
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
        this.oFY.n(byteBuffer);
        this.oFP.OB(getReadTimeout());
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
            d.this.oCi = urlResponseInfo;
            d.this.oFP.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.oCi = urlResponseInfo;
            d.this.oFP.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.oGc = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.oGg)) {
                    d.this.oFY.ehh();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.oCi = urlResponseInfo;
            d.this.oFY.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.f("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.oCi = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.oCi = urlResponseInfo;
            d.this.oGb = urlRequestException;
            c(d.this.oGb);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.oCi = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.oFZ != null) {
                d.this.oFZ.c(iOException);
            }
            if (d.this.oGa != null) {
                d.this.oGa.d(iOException);
            }
            d.this.oGd = true;
            d.this.oFP.quit();
        }
    }

    private void eiw() throws IOException {
        if (this.oGa != null) {
            this.oGa.eip();
            if (eiy()) {
                this.oGa.close();
            }
        }
        if (!this.oGd) {
            eiv();
            this.oFP.OB(getReadTimeout());
            this.oGd = true;
        }
        eix();
    }

    private void eix() throws IOException {
        if (!this.oGd) {
            throw new IllegalStateException("No response.");
        }
        if (this.oGb != null) {
            throw this.oGb;
        }
        if (this.oCi == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> OA(int i) {
        try {
            eiw();
            List<Map.Entry<String, String>> eig = eig();
            if (i >= eig.size()) {
                return null;
            }
            return eig.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean eiy() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> eiz() {
        if (this.oGf != null) {
            return this.oGf;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : eig()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.oGf = Collections.unmodifiableMap(treeMap);
        return this.oGf;
    }

    private List<Map.Entry<String, String>> eig() {
        if (this.oGe != null) {
            return this.oGe;
        }
        this.oGe = new ArrayList();
        for (Map.Entry<String, String> entry : this.oCi.eig()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.oGe.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.oGe = Collections.unmodifiableList(this.oGe);
        return this.oGe;
    }

    public UrlResponseInfo eiA() {
        return this.oCi;
    }

    public void eiB() {
        this.oGg = true;
    }

    public int getRequestTimeout() {
        return this.oGh;
    }
}
