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
    private boolean mcZ;
    private UrlResponseInfo mcd;
    private String mdg;
    private String mdh;
    private final TurbonetEngine met;
    private final g mfL;
    private boolean mfN;
    private boolean mfO;
    private UrlRequest mfU;
    private e mfV;
    private f mfW;
    private UrlRequestException mfX;
    private boolean mfY;
    private boolean mfZ;
    private boolean mfi;
    private List<Map.Entry<String, String>> mga;
    private Map<String, List<String>> mgb;
    private boolean mgc;
    private int mgd;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.mfY = false;
        this.mfZ = false;
        this.mgc = false;
        this.mgd = 0;
        this.mfN = false;
        this.mfO = false;
        this.met = turbonetEngine;
        this.mfL = new g(getURL().toString());
        this.mfV = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        drA();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.mfU.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        drB();
        return this.mcd.drk();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        drB();
        return this.mcd.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            drB();
            return drE();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            drB();
            Map<String, List<String>> drE = drE();
            if (drE.containsKey(str)) {
                List<String> list = drE.get(str);
                return list.get(list.size() - 1);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        Map.Entry<String, String> Gv = Gv(i);
        if (Gv == null) {
            return null;
        }
        return Gv.getKey();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        Map.Entry<String, String> Gv = Gv(i);
        if (Gv == null) {
            return null;
        }
        return Gv.getValue();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        drB();
        if (!this.instanceFollowRedirects && this.mfY) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.mcd.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.mfV;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.mfW == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (drD()) {
                this.mfW = new b(this, this.chunkLength, this.mfL, this.mfN, this.mfO);
                drA();
            } else {
                long drz = drz();
                if (drz != -1) {
                    this.mfW = new c(this, drz, this.mfL);
                    drA();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.mfW = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.mfW = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.h("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.mfW = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.mfW;
    }

    private long drz() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void drA() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.mfL, this.met);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.mfW != null) {
                    builder.b(this.mfW.drv(), this.mfL);
                    if (getRequestProperty("Content-Length") == null && !drD()) {
                        addRequestProperty("Content-Length", Long.toString(this.mfW.drv().getLength()));
                    }
                    this.mfW.drt();
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
                builder.drf();
            }
            builder.OV(this.method);
            if (this.mfi) {
                builder.drg();
            }
            if (this.mcZ) {
                builder.drh();
            }
            if (!TextUtils.isEmpty(this.mdg)) {
                builder.OW(this.mdg);
            }
            if (!TextUtils.isEmpty(this.mdh)) {
                builder.OX(this.mdh);
            }
            builder.Gp(getConnectTimeout());
            builder.Gq(getReadTimeout());
            builder.Go(getRequestTimeout());
            this.connected = true;
            this.mfU = builder.dri();
            this.mfU.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            drB();
            if (this.mcd.getHttpStatusCode() >= 400) {
                return this.mfV;
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
        int OY = OY(str);
        if (OY >= 0) {
            if (z) {
                this.mRequestHeaders.remove(OY);
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
        int OY = OY(str);
        if (OY >= 0) {
            return (String) this.mRequestHeaders.get(OY).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ByteBuffer byteBuffer) throws IOException {
        this.mfU.m(byteBuffer);
        this.mfL.Gw(getReadTimeout());
    }

    private int OY(String str) {
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
            d.this.mcd = urlResponseInfo;
            d.this.mfL.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.mcd = urlResponseInfo;
            d.this.mfL.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.mfY = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.mgc)) {
                    d.this.mfU.dql();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.mcd = urlResponseInfo;
            d.this.mfU.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.g("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.mcd = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.h("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.mcd = urlResponseInfo;
            d.this.mfX = urlRequestException;
            c(d.this.mfX);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.mcd = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.mfV != null) {
                d.this.mfV.c(iOException);
            }
            if (d.this.mfW != null) {
                d.this.mfW.d(iOException);
            }
            d.this.mfZ = true;
            d.this.mfL.quit();
        }
    }

    private void drB() throws IOException {
        if (this.mfW != null) {
            this.mfW.dru();
            if (drD()) {
                this.mfW.close();
            }
        }
        if (!this.mfZ) {
            drA();
            this.mfL.Gw(getReadTimeout());
            this.mfZ = true;
        }
        drC();
    }

    private void drC() throws IOException {
        if (!this.mfZ) {
            throw new IllegalStateException("No response.");
        }
        if (this.mfX != null) {
            throw this.mfX;
        }
        if (this.mcd == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> Gv(int i) {
        try {
            drB();
            List<Map.Entry<String, String>> drl = drl();
            if (i >= drl.size()) {
                return null;
            }
            return drl.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean drD() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> drE() {
        if (this.mgb != null) {
            return this.mgb;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : drl()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.mgb = Collections.unmodifiableMap(treeMap);
        return this.mgb;
    }

    private List<Map.Entry<String, String>> drl() {
        if (this.mga != null) {
            return this.mga;
        }
        this.mga = new ArrayList();
        for (Map.Entry<String, String> entry : this.mcd.drl()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.mga.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.mga = Collections.unmodifiableList(this.mga);
        return this.mga;
    }

    public UrlResponseInfo drF() {
        return this.mcd;
    }

    public void drG() {
        this.mgc = true;
    }

    public int getRequestTimeout() {
        return this.mgd;
    }
}
