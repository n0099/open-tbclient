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
    private UrlResponseInfo oEX;
    private boolean oFA;
    private String oFH;
    private String oFI;
    private final TurbonetEngine oGA;
    private UrlRequest oHC;
    private e oHD;
    private f oHE;
    private UrlRequestException oHF;
    private boolean oHG;
    private boolean oHH;
    private List<Map.Entry<String, String>> oHI;
    private Map<String, List<String>> oHJ;
    private boolean oHK;
    private int oHL;
    private boolean oHf;
    private final g oHt;
    private boolean oHv;
    private boolean oHw;

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.oHG = false;
        this.oHH = false;
        this.oHK = false;
        this.oHL = 0;
        this.oHv = false;
        this.oHw = false;
        this.oGA = turbonetEngine;
        this.oHt = new g(getURL().toString());
        this.oHD = new e(this);
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
            this.oHC.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        eeP();
        return this.oEX.eeB();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        eeP();
        return this.oEX.getHttpStatusCode();
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
        if (!this.instanceFollowRedirects && this.oHG) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.oEX.getHttpStatusCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        return this.oHD;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.oHE == null && this.doOutput) {
            if (this.connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (eeR()) {
                this.oHE = new b(this, this.chunkLength, this.oHt, this.oHv, this.oHw);
                eeO();
            } else {
                long eeN = eeN();
                if (eeN != -1) {
                    this.oHE = new c(this, eeN, this.oHt);
                    eeO();
                } else {
                    com.baidu.turbonet.base.a.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.oHE = new com.baidu.turbonet.net.a.a(this);
                    } else {
                        try {
                            this.oHE = new com.baidu.turbonet.net.a.a(this, Long.parseLong(requestProperty));
                        } catch (NumberFormatException e) {
                            com.baidu.turbonet.base.a.e("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                            this.oHE = new com.baidu.turbonet.net.a.a(this);
                        }
                    }
                }
            }
        }
        return this.oHE;
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
            UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.oHt, this.oGA);
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                }
                if (this.oHE != null) {
                    builder.b(this.oHE.eeJ(), this.oHt);
                    if (getRequestProperty("Content-Length") == null && !eeR()) {
                        addRequestProperty("Content-Length", Long.toString(this.oHE.eeJ().getLength()));
                    }
                    this.oHE.eeH();
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
            builder.VX(this.method);
            if (this.oHf) {
                builder.eex();
            }
            if (this.oFA) {
                builder.eey();
            }
            if (!TextUtils.isEmpty(this.oFH)) {
                builder.VY(this.oFH);
            }
            if (!TextUtils.isEmpty(this.oFI)) {
                builder.VZ(this.oFI);
            }
            builder.MD(getConnectTimeout());
            builder.ME(getReadTimeout());
            builder.MC(getRequestTimeout());
            this.connected = true;
            this.oHC = builder.eez();
            this.oHC.start();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            eeP();
            if (this.oEX.getHttpStatusCode() >= 400) {
                return this.oHD;
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
        int Wa = Wa(str);
        if (Wa >= 0) {
            if (z) {
                this.mRequestHeaders.remove(Wa);
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
        int Wa = Wa(str);
        if (Wa >= 0) {
            return (String) this.mRequestHeaders.get(Wa).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ByteBuffer byteBuffer) throws IOException {
        this.oHC.read(byteBuffer);
        this.oHt.MJ(getReadTimeout());
    }

    private int Wa(String str) {
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
            d.this.oEX = urlResponseInfo;
            d.this.oHt.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.oEX = urlResponseInfo;
            d.this.oHt.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.oHG = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(d.this.url.getProtocol());
                if (d.this.instanceFollowRedirects) {
                    d.this.url = url;
                }
                if (d.this.instanceFollowRedirects && (equals || d.this.oHK)) {
                    d.this.oHC.followRedirect();
                    return;
                }
            } catch (MalformedURLException e) {
            }
            d.this.oEX = urlResponseInfo;
            d.this.oHC.cancel();
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            com.baidu.turbonet.base.a.i("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.getUrl(), Integer.valueOf(urlResponseInfo.getHttpStatusCode()), Long.valueOf(urlResponseInfo.getReceivedBytesCount()));
            d.this.oEX = urlResponseInfo;
            c(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            com.baidu.turbonet.base.a.e("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
            d.this.oEX = urlResponseInfo;
            d.this.oHF = urlRequestException;
            c(d.this.oHF);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.oEX = urlResponseInfo;
            c(new IOException("stream closed"));
        }

        private void c(IOException iOException) {
            if (d.this.oHD != null) {
                d.this.oHD.c(iOException);
            }
            if (d.this.oHE != null) {
                d.this.oHE.d(iOException);
            }
            d.this.oHH = true;
            d.this.oHt.quit();
        }
    }

    private void eeP() throws IOException {
        if (this.oHE != null) {
            this.oHE.eeI();
            if (eeR()) {
                this.oHE.close();
            }
        }
        if (!this.oHH) {
            eeO();
            this.oHt.MJ(getReadTimeout());
            this.oHH = true;
        }
        eeQ();
    }

    private void eeQ() throws IOException {
        if (!this.oHH) {
            throw new IllegalStateException("No response.");
        }
        if (this.oHF != null) {
            throw this.oHF;
        }
        if (this.oEX == null) {
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
        if (this.oHJ != null) {
            return this.oHJ;
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
        this.oHJ = Collections.unmodifiableMap(treeMap);
        return this.oHJ;
    }

    private List<Map.Entry<String, String>> eeC() {
        if (this.oHI != null) {
            return this.oHI;
        }
        this.oHI = new ArrayList();
        for (Map.Entry<String, String> entry : this.oEX.eeC()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.oHI.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        this.oHI = Collections.unmodifiableList(this.oHI);
        return this.oHI;
    }

    public UrlResponseInfo eeT() {
        return this.oEX;
    }

    public void eeU() {
        this.oHK = true;
    }

    public int getRequestTimeout() {
        return this.oHL;
    }
}
