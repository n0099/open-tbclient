package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidubce.http.Headers;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
class b {
    private int jCD;
    private g jCE;
    private HttpURLConnection qA;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int jCC = 5;
    private long qB = 0;
    private long qC = 0;
    private long firstByteReachTime = 0;
    private long qD = 0;
    private long qE = 0;
    private boolean qF = false;
    private boolean qG = true;
    private TimerTask qI = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.cancelNetConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer timer = new Timer();

    public long fO() {
        return this.qB;
    }

    public boolean fR() {
        return this.qF;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.jCE = gVar;
    }

    public void cancelNetConnect() {
        this.jCE.cAe().ro = true;
        com.baidu.adp.lib.f.a.close(this.qA);
    }

    private URL a(String str, e eVar) throws Exception {
        a cAb;
        URL url = new URL(str);
        if (this.qG && (cAb = a.cAb()) != null) {
            String ak = cAb.ak(str);
            if (!TextUtils.isEmpty(ak)) {
                this.jCE.cAd().m("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ak));
                this.qF = true;
                eVar.qT = ak;
                return url2;
            }
        }
        return url;
    }

    private HttpURLConnection a(URL url, int i, int i2) throws SocketException {
        HttpURLConnection c = c(url);
        if (c != null) {
            c.setConnectTimeout(i);
            c.setReadTimeout(i2);
            return c;
        }
        throw new SocketException();
    }

    private HttpURLConnection c(URL url) {
        HttpURLConnection httpURLConnection;
        Exception e;
        String curMobileProxyHost;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (com.baidu.adp.lib.util.j.isMobileNet() && (curMobileProxyHost = com.baidu.adp.lib.util.j.curMobileProxyHost()) != null && curMobileProxyHost.length() > 0) {
                    if (com.baidu.adp.lib.util.j.isWap(curMobileProxyHost) && com.baidu.adp.lib.util.j.isSupportWap()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(curMobileProxyHost);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.jCE.cAd().m("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(curMobileProxyHost, com.baidu.adp.lib.util.j.curMobileProxyPort())));
                    }
                }
                if (httpURLConnection2 == null) {
                    try {
                        return (HttpURLConnection) url.openConnection();
                    } catch (Exception e3) {
                        httpURLConnection = httpURLConnection2;
                        e = e3;
                        e.printStackTrace();
                        return httpURLConnection;
                    }
                }
                return httpURLConnection2;
            }
            return null;
        } catch (Exception e4) {
            httpURLConnection = null;
            e = e4;
        }
    }

    public void a(int i, int i2, e eVar) throws Exception {
        Map<String, List<String>> map;
        List<String> list;
        eVar.qR = -1;
        if (this.jCE.cAe().ro) {
            throw new BdHttpCancelException();
        }
        String c = this.jCE.cAd().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.jCE.cAe().ro) {
            throw new BdHttpCancelException();
        }
        eVar.qR = -2;
        this.qA = c(a);
        eVar.qR = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.qA == null) {
                throw new SocketException("network not available.");
            }
            this.qA.setRequestMethod("GET");
            this.qA.setConnectTimeout(i2);
            this.qA.setReadTimeout(i);
            this.jCE.cAd().f(this.qA);
            if (this.jCE.cAe().ro) {
                throw new BdHttpCancelException();
            }
            eVar.dnsTime = new Date().getTime() - currentTimeMillis;
            eVar.qR = -4;
            this.qA.connect();
            if (this.qB <= 0) {
                this.qB = System.currentTimeMillis();
            }
            this.qC = System.currentTimeMillis();
            eVar.qR = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.dnsTime;
            if (this.jCE.cAe().ro) {
                throw new BdHttpCancelException();
            }
            String contentType = this.qA.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.ax(contentType)) {
                this.qA.disconnect();
                this.qA.connect();
                if (this.jCE.cAe().ro) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.qR = -8;
            this.jCE.cAe().g(this.qA);
            if (c.contains("c.tieba.baidu.com") && (map = this.jCE.cAe().rp) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.qW = list.get(0);
                eVar.qX = list.get(1);
            }
            eVar.qQ = this.jCE.cAe().responseCode;
            eVar.downloadSize = this.qA.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.qA);
            if (e != null) {
                eVar.downloadSize += e.length;
                this.jCE.cAe().retBytes = c(this.jCE.cAe().contentEncoding, e);
            }
            eVar.qR = -9;
            eVar.qO = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.qA != null) {
                this.qA.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.qE = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        }
        return bArr;
    }

    private byte[] e(HttpURLConnection httpURLConnection) throws Exception {
        byte[] bArr;
        InputStream inputStream;
        Throwable th;
        int read;
        InputStream inputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        if (httpURLConnection != null) {
            try {
                byte[] bArr2 = new byte[1024];
                inputStream2 = httpURLConnection.getInputStream();
                while (!this.jCE.cAe().ro && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.qD = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.f.a.close(inputStream);
                        throw th;
                    }
                }
                if (this.jCE.cAe().ro) {
                    throw new BdHttpCancelException();
                }
                bArr = byteArrayOutputStream.toByteArray();
            } catch (Throwable th3) {
                inputStream = null;
                th = th3;
            }
        } else {
            bArr = null;
        }
        this.qD = System.currentTimeMillis();
        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.f.a.close(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.qR = -1;
        try {
            String url = this.jCE.cAd().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.jCE.cAe().ro) {
                throw new BdHttpCancelException();
            }
            eVar.qR = -2;
            this.qA = c(a);
            eVar.qR = -3;
            System.currentTimeMillis();
            if (this.qA == null) {
                throw new SocketException("network not available.");
            }
            this.qA.setRequestMethod("POST");
            this.qA.setDoOutput(true);
            this.qA.setDoInput(true);
            this.qA.setConnectTimeout(i2);
            this.qA.setReadTimeout(i);
            this.qA.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.jCE.cAe().ro) {
                throw new BdHttpCancelException();
            }
            this.jCE.cAd().f(this.qA);
            if (this.jCE.cAe().ro) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.dnsTime = new Date().getTime() - time;
            eVar.qR = -4;
            this.qA.connect();
            if (this.qB <= 0) {
                this.qB = System.currentTimeMillis();
            }
            this.qC = System.currentTimeMillis();
            eVar.qR = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.dnsTime;
            if (this.jCE.cAe().ro) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.qI, 45000L);
            }
            eVar.qR = -6;
            this.jCE.cAd().a(this.qA, boundary, eVar);
            eVar.qR = -7;
            String contentType = this.qA.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.ax(contentType)) {
                this.qA.disconnect();
                this.qA.connect();
                if (this.jCE.cAe().ro) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.jCE.cAe().ro) {
                throw new BdHttpCancelException();
            }
            eVar.qR = -8;
            this.jCE.cAe().g(this.qA);
            eVar.qQ = this.jCE.cAe().responseCode;
            eVar.downloadSize = this.qA.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.qA);
            if (e != null) {
                eVar.downloadSize += e.length;
                this.jCE.cAe().downSize = e.length;
                this.jCE.cAe().retBytes = c(this.jCE.cAe().contentEncoding, e);
            }
            eVar.qO = new Date().getTime() - time;
            eVar.qR = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.f.a.close(this.qA);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.jCD = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.jCE.cAd().getUrl();
            eVar2.url = url;
            this.qA = a(a(url, eVar2), i2, i);
            this.qA.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.jCE.cAe().ro) {
                this.qD = System.currentTimeMillis();
                com.baidu.adp.lib.f.a.close((InputStream) null);
                com.baidu.adp.lib.f.a.close(this.qA);
                com.baidu.adp.lib.f.a.close((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.delFile(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.createFileIfNotFound(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.jCE.cAd().f(this.qA);
                this.qA.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.qA.connect();
                if (this.qB <= 0) {
                    this.qB = System.currentTimeMillis();
                }
                this.qC = System.currentTimeMillis();
                int responseCode = this.qA.getResponseCode();
                while (AF(responseCode) && this.jCD <= 5) {
                    this.qA = a(this.qA, i2, i);
                    this.jCE.cAd().f(this.qA);
                    this.qA.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.qA.connect();
                    responseCode = this.qA.getResponseCode();
                }
                this.firstByteReachTime = System.currentTimeMillis();
                this.jCE.cAe().responseCode = responseCode;
                if (isFileSegSuccess()) {
                    if (this.qA.getContentType() != null && this.qA.getContentType().contains("text/vnd.wap.wml")) {
                        this.qA.disconnect();
                        this.jCE.cAe().responseCode = 0;
                        boolean a = a(str, jVar, i, i2, z, eVar2, z2);
                        this.qD = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.qA);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.qA.getHeaderField(Headers.CONTENT_RANGE);
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.f.b.toInt(headerField2.substring(indexOf + 1), 0);
                    }
                    int i4 = (i3 == 0 && this.jCE.cAe().responseCode == 200 && (headerField = this.qA.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.f.b.toInt(headerField, 0) : i3;
                    this.jCE.cAe().contentLength = String.valueOf(i4);
                    eVar2.qN = url.getBytes().length;
                    eVar2.downloadSize = this.qA.getHeaderFields().toString().getBytes().length;
                    eVar2.downloadSize += i4;
                    if (this.jCE.cAe().responseCode == 416 || this.jCE.cAe().responseCode == 204) {
                        this.qD = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.qA);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    } else if (i4 != 0 && length >= i4) {
                        this.qD = System.currentTimeMillis();
                        this.qD = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.qA);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.qA.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i5 = 0;
                            int i6 = i4 > 0 ? i4 / 50 : 0;
                            int i7 = 0;
                            if (jVar != null && length > 0) {
                                jVar.j((int) length, i4);
                            }
                            while (!this.jCE.cAe().ro) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i5 += read;
                                        i7 += read;
                                        if (jVar != null && (i7 > i6 || i5 == i4)) {
                                            i7 = 0;
                                            jVar.j((int) (i5 + length), i4);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i5) + length >= ((long) i4);
                                this.qD = System.currentTimeMillis();
                                com.baidu.adp.lib.f.a.close(inputStream2);
                                com.baidu.adp.lib.f.a.close(this.qA);
                                com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.qD = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close(inputStream);
                            com.baidu.adp.lib.f.a.close(this.qA);
                            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
                            throw th;
                        }
                    }
                }
                throw new UnsupportedOperationException();
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                inputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection, int i, int i2) throws Exception {
        if (httpURLConnection == null) {
            return null;
        }
        URL url = httpURLConnection.getURL().toURI().resolve(httpURLConnection.getHeaderField(Headers.LOCATION)).toURL();
        com.baidu.adp.lib.f.a.close(httpURLConnection);
        HttpURLConnection a = a(url, i, i2);
        this.jCD++;
        return a;
    }

    private boolean AF(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean isFileSegSuccess() {
        return this.jCE.cAe().responseCode == 200 || this.jCE.cAe().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.qR = -1;
        try {
            String url = this.jCE.cAd().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.jCE.cAe().ro) {
                throw new BdHttpCancelException();
            }
            eVar.qR = -2;
            this.qA = c(a);
            eVar.qR = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.qA == null) {
                throw new SocketException("network not available.");
            }
            this.qA.setRequestMethod("POST");
            this.qA.setDoOutput(true);
            this.qA.setDoInput(true);
            this.qA.setConnectTimeout(i2);
            this.qA.setReadTimeout(i);
            this.qA.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.jCE.cAe().ro) {
                throw new BdHttpCancelException();
            }
            this.jCE.cAd().f(this.qA);
            if (this.jCE.cAe().ro) {
                throw new BdHttpCancelException();
            }
            eVar.dnsTime = System.currentTimeMillis() - currentTimeMillis;
            eVar.qR = -4;
            this.qA.connect();
            if (this.qB <= 0) {
                this.qB = System.currentTimeMillis();
            }
            this.qC = System.currentTimeMillis();
            eVar.qR = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.dnsTime;
            if (this.jCE.cAe().ro) {
                throw new BdHttpCancelException();
            }
            eVar.qR = -6;
            this.jCE.cAd().a(this.qA, eVar);
            eVar.qR = -7;
            if (this.jCE.cAe().ro) {
                throw new BdHttpCancelException();
            }
            String contentType = this.qA.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.ax(contentType)) {
                this.qA.disconnect();
                this.qA.connect();
                if (this.jCE.cAe().ro) {
                    throw new BdHttpCancelException();
                }
            }
            this.jCE.cAe().g(this.qA);
            eVar.qR = -8;
            eVar.qQ = this.jCE.cAe().responseCode;
            eVar.downloadSize = this.qA.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.qA);
            if (e != null) {
                eVar.downloadSize += e.length;
                this.jCE.cAe().downSize = e.length;
                this.jCE.cAe().retBytes = c(this.jCE.cAe().contentEncoding, e);
            }
            eVar.qO = new Date().getTime() - currentTimeMillis;
            eVar.qR = -9;
        } finally {
            com.baidu.adp.lib.f.a.close(this.qA);
        }
    }
}
