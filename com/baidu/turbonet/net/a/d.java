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
    private final List<Pair<String, String>> mRequestHeaders;
    private UrlResponseInfo mdn;
    private boolean mej;
    private String meq;
    private String mer;
    private final TurbonetEngine mfD;
    private final g mgV;
    private boolean mgX;
    private boolean mgY;
    private boolean mgs;
    private UrlRequest mhe;
    private e mhf;
    private f mhg;
    private UrlRequestException mhh;
    private boolean mhi;
    private boolean mhj;
    private List<Map.Entry<String, String>> mhk;
    private Map<String, List<String>> mhl;
    private boolean mhm;
    private int mhn;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.mhi = false;
        this.mhj = false;
        this.mhm = false;
        this.mhn = 0;
        this.mgX = false;
        this.mgY = false;
        this.mfD = turbonetEngine;
        this.mgV = new g(getURL().toString());
        this.mhf = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        drO();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.mhe.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        drP();
        return this.mdn.dry();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        drP();
        return this.mdn.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            drP();
            return drS();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            drP();
            Map<String, List<String>> drS = drS();
            if (drS.containsKey(str)) {
                List<String> list = drS.get(str);
                return list.get(list.size() - 1);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        Map.Entry<String, String> Gx = Gx(i);
        if (Gx == null) {
            return null;
        }
        return Gx.getKey();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        Map.Entry<String, String> Gx = Gx(i);
        if (Gx == null) {
            return null;
        }
        return Gx.getValue();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        drP();
        if (!this.instanceFollowRedirects && this.mhi) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.mdn.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.mhf;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.mhg == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (drR()) {
                this.mhg = new b(this, this.chunkLength, this.mgV, this.mgX, this.mgY);
                drO();
            } else {
                long drN = drN();
                if (drN != -1) {
                    this.mhg = new c(this, drN, this.mgV);
                    drO();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.mhg = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.mhg = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.h("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.mhg = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.mhg;
    }

    private long drN() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void drO() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.mgV, this.mfD);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.mhg != null) {
                    builder.b(this.mhg.drJ(), this.mgV);
                    if (getRequestProperty("Content-Length") == null && !drR()) {
                        addRequestProperty("Content-Length", Long.toString(this.mhg.drJ().getLength()));
                    }
                    this.mhg.drH();
                } else if (getRequestProperty("Content-Length") == null) {
                    addRequestProperty("Content-Length", "0");
                }
                if (getRequestProperty("Content-Type") == null) {
                    addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
            }
            for (Pair<String, String> pair : this.mRequestHeaders) {
                builder.fF((String) pair.first, (String) pair.second);
            }
            if (!getUseCaches()) {
                builder.drt();
            }
            builder.OW(this.method);
            if (this.mgs) {
                builder.dru();
            }
            if (this.mej) {
                builder.drv();
            }
            if (!TextUtils.isEmpty(this.meq)) {
                builder.OX(this.meq);
            }
            if (!TextUtils.isEmpty(this.mer)) {
                builder.OY(this.mer);
            }
            builder.Gr(getConnectTimeout());
            builder.Gs(getReadTimeout());
            builder.Gq(getRequestTimeout());
            this.connected = true;
            this.mhe = builder.drw();
            this.mhe.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            drP();
            if (this.mdn.getHttpStatusCode() >= 400) {
                return this.mhf;
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
        int OZ = OZ(str);
        if (OZ >= 0) {
            if (z) {
                this.mRequestHeaders.remove(OZ);
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
        int OZ = OZ(str);
        if (OZ >= 0) {
            return (String) this.mRequestHeaders.get(OZ).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ByteBuffer byteBuffer) throws IOException {
        this.mhe.m(byteBuffer);
        this.mgV.Gy(getReadTimeout());
    }

    private int OZ(String str) {
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
            d.this.mdn = urlResponseInfo;
            d.this.mgV.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.mdn = urlResponseInfo;
            d.this.mgV.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.mhi = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.mhm)) {
                    d.this.mhe.dqz();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.mdn = urlResponseInfo;
            d.this.mhe.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.mdn = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.h("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.mdn = urlResponseInfo;
            d.this.mhh = urlRequestException;
            c(d.this.mhh);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.mdn = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.mhf != null) {
                d.this.mhf.c(iOException);
            }
            if (d.this.mhg != null) {
                d.this.mhg.d(iOException);
            }
            d.this.mhj = true;
            d.this.mgV.quit();
        }
    }

    private void drP() throws IOException {
        if (this.mhg != null) {
            this.mhg.drI();
            if (drR()) {
                this.mhg.close();
            }
        }
        if (!this.mhj) {
            drO();
            this.mgV.Gy(getReadTimeout());
            this.mhj = true;
        }
        drQ();
    }

    private void drQ() throws IOException {
        if (!this.mhj) {
            throw new IllegalStateException("No response.");
        }
        if (this.mhh != null) {
            throw this.mhh;
        }
        if (this.mdn == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> Gx(int i) {
        try {
            drP();
            List<Map.Entry<String, String>> drz = drz();
            if (i >= drz.size()) {
                return null;
            }
            return drz.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean drR() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> drS() {
        if (this.mhl != null) {
            return this.mhl;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : drz()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.mhl = Collections.unmodifiableMap(treeMap);
        return this.mhl;
    }

    private List<Map.Entry<String, String>> drz() {
        if (this.mhk != null) {
            return this.mhk;
        }
        this.mhk = new ArrayList();
        for (Map.Entry<String, String> entry : this.mdn.drz()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.mhk.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.mhk = Collections.unmodifiableList(this.mhk);
        return this.mhk;
    }

    public UrlResponseInfo drT() {
        return this.mdn;
    }

    public void drU() {
        this.mhm = true;
    }

    public int getRequestTimeout() {
        return this.mhn;
    }
}
