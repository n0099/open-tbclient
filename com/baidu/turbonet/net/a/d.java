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
/* loaded from: classes4.dex */
public class d extends HttpURLConnection {
    private final List<Pair<String, String>> mRequestHeaders;
    private UrlResponseInfo oEY;
    private boolean oFB;
    private String oFI;
    private String oFJ;
    private final TurbonetEngine oGB;
    private UrlRequest oHD;
    private e oHE;
    private f oHF;
    private UrlRequestException oHG;
    private boolean oHH;
    private boolean oHI;
    private List<Map.Entry<String, String>> oHJ;
    private Map<String, List<String>> oHK;
    private boolean oHL;
    private int oHM;
    private boolean oHg;
    private final g oHu;
    private boolean oHw;
    private boolean oHx;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.oHH = false;
        this.oHI = false;
        this.oHL = false;
        this.oHM = 0;
        this.oHw = false;
        this.oHx = false;
        this.oGB = turbonetEngine;
        this.oHu = new g(getURL().toString());
        this.oHE = new e(this);
        this.mRequestHeaders = new ArrayList();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        eeO();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected) {
            this.oHD.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        eeP();
        return this.oEY.eeB();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        eeP();
        return this.oEY.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            eeP();
            return eeS();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            eeP();
            Map<String, List<String>> eeS = eeS();
            if (eeS.containsKey(str)) {
                List<String> list = eeS.get(str);
                return list.get(list.size() - 1);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        Map.Entry<String, String> MI = MI(i);
        if (MI == null) {
            return null;
        }
        return MI.getKey();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        Map.Entry<String, String> MI = MI(i);
        if (MI == null) {
            return null;
        }
        return MI.getValue();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        eeP();
        if (!this.instanceFollowRedirects && this.oHH) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.oEY.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.oHE;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.oHF == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (eeR()) {
                this.oHF = new b(this, this.chunkLength, this.oHu, this.oHw, this.oHx);
                eeO();
            } else {
                long eeN = eeN();
                if (eeN != -1) {
                    this.oHF = new c(this, eeN, this.oHu);
                    eeO();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.oHF = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.oHF = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.e("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.oHF = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.oHF;
    }

    private long eeN() {
        long j = this.fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception e) {
            return j;
        }
    }

    private void eeO() throws IOException {
        if (!this.connected) {
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.oHu, this.oGB);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.oHF != null) {
                    builder.b(this.oHF.eeJ(), this.oHu);
                    if (getRequestProperty("Content-Length") == null && !eeR()) {
                        addRequestProperty("Content-Length", Long.toString(this.oHF.eeJ().getLength()));
                    }
                    this.oHF.eeH();
                } else if (getRequestProperty("Content-Length") == null) {
                    addRequestProperty("Content-Length", "0");
                }
                if (getRequestProperty("Content-Type") == null) {
                    addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
            }
            for (Pair<String, String> pair : this.mRequestHeaders) {
                builder.gS((String) pair.first, (String) pair.second);
            }
            if (!getUseCaches()) {
                builder.eew();
            }
            builder.VY(this.method);
            if (this.oHg) {
                builder.eex();
            }
            if (this.oFB) {
                builder.eey();
            }
            if (!TextUtils.isEmpty(this.oFI)) {
                builder.VZ(this.oFI);
            }
            if (!TextUtils.isEmpty(this.oFJ)) {
                builder.Wa(this.oFJ);
            }
            builder.MD(getConnectTimeout());
            builder.ME(getReadTimeout());
            builder.MC(getRequestTimeout());
            this.connected = true;
            this.oHD = builder.eez();
            this.oHD.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            eeP();
            if (this.oEY.getHttpStatusCode() >= 400) {
                return this.oHE;
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
        int Wb = Wb(str);
        if (Wb >= 0) {
            if (z) {
                this.mRequestHeaders.remove(Wb);
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
        int Wb = Wb(str);
        if (Wb >= 0) {
            return (String) this.mRequestHeaders.get(Wb).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ByteBuffer byteBuffer) throws IOException {
        this.oHD.read(byteBuffer);
        this.oHu.MJ(getReadTimeout());
    }

    private int Wb(String str) {
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
    /* loaded from: classes4.dex */
    public class a extends UrlRequest.Callback {
        public a() {
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.oEY = urlResponseInfo;
            d.this.oHu.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.oEY = urlResponseInfo;
            d.this.oHu.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.oHH = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.oHL)) {
                    d.this.oHD.followRedirect();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.oEY = urlResponseInfo;
            d.this.oHD.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.i("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.oEY = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.e("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.oEY = urlResponseInfo;
            d.this.oHG = urlRequestException;
            c(d.this.oHG);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.oEY = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.oHE != null) {
                d.this.oHE.c(iOException);
            }
            if (d.this.oHF != null) {
                d.this.oHF.d(iOException);
            }
            d.this.oHI = true;
            d.this.oHu.quit();
        }
    }

    private void eeP() throws IOException {
        if (this.oHF != null) {
            this.oHF.eeI();
            if (eeR()) {
                this.oHF.close();
            }
        }
        if (!this.oHI) {
            eeO();
            this.oHu.MJ(getReadTimeout());
            this.oHI = true;
        }
        eeQ();
    }

    private void eeQ() throws IOException {
        if (!this.oHI) {
            throw new IllegalStateException("No response.");
        }
        if (this.oHG != null) {
            throw this.oHG;
        }
        if (this.oEY == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private Map.Entry<String, String> MI(int i) {
        try {
            eeP();
            List<Map.Entry<String, String>> eeC = eeC();
            if (i >= eeC.size()) {
                return null;
            }
            return eeC.get(i);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean eeR() {
        return this.chunkLength > 0;
    }

    private Map<String, List<String>> eeS() {
        if (this.oHK != null) {
            return this.oHK;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : eeC()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.oHK = Collections.unmodifiableMap(treeMap);
        return this.oHK;
    }

    private List<Map.Entry<String, String>> eeC() {
        if (this.oHJ != null) {
            return this.oHJ;
        }
        this.oHJ = new ArrayList();
        for (Map.Entry<String, String> entry : this.oEY.eeC()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.oHJ.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.oHJ = Collections.unmodifiableList(this.oHJ);
        return this.oHJ;
    }

    public UrlResponseInfo eeT() {
        return this.oEY;
    }

    public void eeU() {
        this.oHL = true;
    }

    public int getRequestTimeout() {
        return this.oHM;
    }
}
