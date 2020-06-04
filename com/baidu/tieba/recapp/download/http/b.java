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
/* loaded from: classes13.dex */
class b {
    private HttpURLConnection JL;
    private int kLH;
    private g kLI;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int kLG = 5;
    private long JM = 0;
    private long JN = 0;
    private long firstByteReachTime = 0;
    private long JO = 0;
    private long JP = 0;
    private boolean JQ = false;
    private boolean JR = true;
    private TimerTask JV = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
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

    public long ku() {
        return this.JM;
    }

    public boolean kx() {
        return this.JQ;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.kLI = gVar;
    }

    public void cancelNetConnect() {
        this.kLI.cUS().KE = true;
        com.baidu.adp.lib.f.a.close(this.JL);
    }

    private URL a(String str, e eVar) throws Exception {
        a cUP;
        URL url = new URL(str);
        if (this.JR && (cUP = a.cUP()) != null) {
            String bA = cUP.bA(str);
            if (!TextUtils.isEmpty(bA)) {
                this.kLI.cUR().s("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + bA));
                this.JQ = true;
                eVar.Kh = bA;
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
                            this.kLI.cUR().s("X-Online-Host", url.getHost());
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
        eVar.Kf = -1;
        if (this.kLI.cUS().KE) {
            throw new BdHttpCancelException();
        }
        String c = this.kLI.cUR().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.kLI.cUS().KE) {
            throw new BdHttpCancelException();
        }
        eVar.Kf = -2;
        this.JL = c(a);
        eVar.Kf = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.JL == null) {
                throw new SocketException("network not available.");
            }
            this.JL.setRequestMethod("GET");
            this.JL.setConnectTimeout(i2);
            this.JL.setReadTimeout(i);
            this.kLI.cUR().f(this.JL);
            if (this.kLI.cUS().KE) {
                throw new BdHttpCancelException();
            }
            eVar.dnsTime = new Date().getTime() - currentTimeMillis;
            eVar.Kf = -4;
            this.JL.connect();
            if (this.JM <= 0) {
                this.JM = System.currentTimeMillis();
            }
            this.JN = System.currentTimeMillis();
            eVar.Kf = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.dnsTime;
            if (this.kLI.cUS().KE) {
                throw new BdHttpCancelException();
            }
            String contentType = this.JL.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bN(contentType)) {
                this.JL.disconnect();
                this.JL.connect();
                if (this.kLI.cUS().KE) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.Kf = -8;
            this.kLI.cUS().g(this.JL);
            if (c.contains("c.tieba.baidu.com") && (map = this.kLI.cUS().KF) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.Km = list.get(0);
                eVar.Kn = list.get(1);
            }
            eVar.Ke = this.kLI.cUS().responseCode;
            eVar.downloadSize = this.JL.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.JL);
            if (e != null) {
                eVar.downloadSize += e.length;
                this.kLI.cUS().retBytes = c(this.kLI.cUS().contentEncoding, e);
            }
            eVar.Kf = -9;
            eVar.Kc = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.JL != null) {
                this.JL.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.JP = System.currentTimeMillis();
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
                while (!this.kLI.cUS().KE && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.JO = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.f.a.close(inputStream);
                        throw th;
                    }
                }
                if (this.kLI.cUS().KE) {
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
        this.JO = System.currentTimeMillis();
        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.f.a.close(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.Kf = -1;
        try {
            String url = this.kLI.cUR().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.kLI.cUS().KE) {
                throw new BdHttpCancelException();
            }
            eVar.Kf = -2;
            this.JL = c(a);
            eVar.Kf = -3;
            System.currentTimeMillis();
            if (this.JL == null) {
                throw new SocketException("network not available.");
            }
            this.JL.setRequestMethod("POST");
            this.JL.setDoOutput(true);
            this.JL.setDoInput(true);
            this.JL.setConnectTimeout(i2);
            this.JL.setReadTimeout(i);
            this.JL.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.kLI.cUS().KE) {
                throw new BdHttpCancelException();
            }
            this.kLI.cUR().f(this.JL);
            if (this.kLI.cUS().KE) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.dnsTime = new Date().getTime() - time;
            eVar.Kf = -4;
            this.JL.connect();
            if (this.JM <= 0) {
                this.JM = System.currentTimeMillis();
            }
            this.JN = System.currentTimeMillis();
            eVar.Kf = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.dnsTime;
            if (this.kLI.cUS().KE) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.JV, 45000L);
            }
            eVar.Kf = -6;
            this.kLI.cUR().a(this.JL, boundary, eVar);
            eVar.Kf = -7;
            String contentType = this.JL.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bN(contentType)) {
                this.JL.disconnect();
                this.JL.connect();
                if (this.kLI.cUS().KE) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.kLI.cUS().KE) {
                throw new BdHttpCancelException();
            }
            eVar.Kf = -8;
            this.kLI.cUS().g(this.JL);
            eVar.Ke = this.kLI.cUS().responseCode;
            eVar.downloadSize = this.JL.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.JL);
            if (e != null) {
                eVar.downloadSize += e.length;
                this.kLI.cUS().downSize = e.length;
                this.kLI.cUS().retBytes = c(this.kLI.cUS().contentEncoding, e);
            }
            eVar.Kc = new Date().getTime() - time;
            eVar.Kf = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.f.a.close(this.JL);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.kLH = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.kLI.cUR().getUrl();
            eVar2.url = url;
            this.JL = a(a(url, eVar2), i2, i);
            this.JL.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.kLI.cUS().KE) {
                this.JO = System.currentTimeMillis();
                com.baidu.adp.lib.f.a.close((InputStream) null);
                com.baidu.adp.lib.f.a.close(this.JL);
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
                this.kLI.cUR().f(this.JL);
                this.JL.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.JL.connect();
                if (this.JM <= 0) {
                    this.JM = System.currentTimeMillis();
                }
                this.JN = System.currentTimeMillis();
                int responseCode = this.JL.getResponseCode();
                while (Cn(responseCode) && this.kLH <= 5) {
                    this.JL = a(this.JL, i2, i);
                    this.kLI.cUR().f(this.JL);
                    this.JL.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.JL.connect();
                    responseCode = this.JL.getResponseCode();
                }
                this.firstByteReachTime = System.currentTimeMillis();
                this.kLI.cUS().responseCode = responseCode;
                if (isFileSegSuccess()) {
                    if (this.JL.getContentType() != null && this.JL.getContentType().contains("text/vnd.wap.wml")) {
                        this.JL.disconnect();
                        this.kLI.cUS().responseCode = 0;
                        boolean a = a(str, jVar, i, i2, z, eVar2, z2);
                        this.JO = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.JL);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.JL.getHeaderField(Headers.CONTENT_RANGE);
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.f.b.toInt(headerField2.substring(indexOf + 1), 0);
                    }
                    int i4 = (i3 == 0 && this.kLI.cUS().responseCode == 200 && (headerField = this.JL.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.f.b.toInt(headerField, 0) : i3;
                    this.kLI.cUS().contentLength = String.valueOf(i4);
                    eVar2.Kb = url.getBytes().length;
                    eVar2.downloadSize = this.JL.getHeaderFields().toString().getBytes().length;
                    eVar2.downloadSize += i4;
                    if (this.kLI.cUS().responseCode == 416 || this.kLI.cUS().responseCode == 204) {
                        this.JO = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.JL);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    } else if (i4 != 0 && length >= i4) {
                        this.JO = System.currentTimeMillis();
                        this.JO = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.JL);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.JL.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i5 = 0;
                            int i6 = i4 > 0 ? i4 / 50 : 0;
                            int i7 = 0;
                            if (jVar != null && length > 0) {
                                jVar.onProgress((int) length, i4);
                            }
                            while (!this.kLI.cUS().KE) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i5 += read;
                                        i7 += read;
                                        if (jVar != null && (i7 > i6 || i5 == i4)) {
                                            i7 = 0;
                                            jVar.onProgress((int) (i5 + length), i4);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i5) + length >= ((long) i4);
                                this.JO = System.currentTimeMillis();
                                com.baidu.adp.lib.f.a.close(inputStream2);
                                com.baidu.adp.lib.f.a.close(this.JL);
                                com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.JO = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close(inputStream);
                            com.baidu.adp.lib.f.a.close(this.JL);
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
        this.kLH++;
        return a;
    }

    private boolean Cn(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean isFileSegSuccess() {
        return this.kLI.cUS().responseCode == 200 || this.kLI.cUS().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.Kf = -1;
        try {
            String url = this.kLI.cUR().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.kLI.cUS().KE) {
                throw new BdHttpCancelException();
            }
            eVar.Kf = -2;
            this.JL = c(a);
            eVar.Kf = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.JL == null) {
                throw new SocketException("network not available.");
            }
            this.JL.setRequestMethod("POST");
            this.JL.setDoOutput(true);
            this.JL.setDoInput(true);
            this.JL.setConnectTimeout(i2);
            this.JL.setReadTimeout(i);
            this.JL.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.kLI.cUS().KE) {
                throw new BdHttpCancelException();
            }
            this.kLI.cUR().f(this.JL);
            if (this.kLI.cUS().KE) {
                throw new BdHttpCancelException();
            }
            eVar.dnsTime = System.currentTimeMillis() - currentTimeMillis;
            eVar.Kf = -4;
            this.JL.connect();
            if (this.JM <= 0) {
                this.JM = System.currentTimeMillis();
            }
            this.JN = System.currentTimeMillis();
            eVar.Kf = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.dnsTime;
            if (this.kLI.cUS().KE) {
                throw new BdHttpCancelException();
            }
            eVar.Kf = -6;
            this.kLI.cUR().a(this.JL, eVar);
            eVar.Kf = -7;
            if (this.kLI.cUS().KE) {
                throw new BdHttpCancelException();
            }
            String contentType = this.JL.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bN(contentType)) {
                this.JL.disconnect();
                this.JL.connect();
                if (this.kLI.cUS().KE) {
                    throw new BdHttpCancelException();
                }
            }
            this.kLI.cUS().g(this.JL);
            eVar.Kf = -8;
            eVar.Ke = this.kLI.cUS().responseCode;
            eVar.downloadSize = this.JL.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.JL);
            if (e != null) {
                eVar.downloadSize += e.length;
                this.kLI.cUS().downSize = e.length;
                this.kLI.cUS().retBytes = c(this.kLI.cUS().contentEncoding, e);
            }
            eVar.Kc = new Date().getTime() - currentTimeMillis;
            eVar.Kf = -9;
        } finally {
            com.baidu.adp.lib.f.a.close(this.JL);
        }
    }
}
