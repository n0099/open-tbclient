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
    private HttpURLConnection Jy;
    private int ksA;
    private g ksB;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int ksz = 5;
    private long Jz = 0;
    private long JA = 0;
    private long firstByteReachTime = 0;
    private long JB = 0;
    private long JC = 0;
    private boolean JD = false;
    private boolean JE = true;
    private TimerTask JH = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
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

    public long ks() {
        return this.Jz;
    }

    public boolean kv() {
        return this.JD;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.ksB = gVar;
    }

    public void cancelNetConnect() {
        this.ksB.cNE().Kp = true;
        com.baidu.adp.lib.f.a.close(this.Jy);
    }

    private URL a(String str, e eVar) throws Exception {
        a cNB;
        URL url = new URL(str);
        if (this.JE && (cNB = a.cNB()) != null) {
            String bz = cNB.bz(str);
            if (!TextUtils.isEmpty(bz)) {
                this.ksB.cND().s("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + bz));
                this.JD = true;
                eVar.JS = bz;
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
                            this.ksB.cND().s("X-Online-Host", url.getHost());
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
        eVar.JQ = -1;
        if (this.ksB.cNE().Kp) {
            throw new BdHttpCancelException();
        }
        String c = this.ksB.cND().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.ksB.cNE().Kp) {
            throw new BdHttpCancelException();
        }
        eVar.JQ = -2;
        this.Jy = c(a);
        eVar.JQ = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.Jy == null) {
                throw new SocketException("network not available.");
            }
            this.Jy.setRequestMethod("GET");
            this.Jy.setConnectTimeout(i2);
            this.Jy.setReadTimeout(i);
            this.ksB.cND().f(this.Jy);
            if (this.ksB.cNE().Kp) {
                throw new BdHttpCancelException();
            }
            eVar.dnsTime = new Date().getTime() - currentTimeMillis;
            eVar.JQ = -4;
            this.Jy.connect();
            if (this.Jz <= 0) {
                this.Jz = System.currentTimeMillis();
            }
            this.JA = System.currentTimeMillis();
            eVar.JQ = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.dnsTime;
            if (this.ksB.cNE().Kp) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Jy.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bM(contentType)) {
                this.Jy.disconnect();
                this.Jy.connect();
                if (this.ksB.cNE().Kp) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.JQ = -8;
            this.ksB.cNE().g(this.Jy);
            if (c.contains("c.tieba.baidu.com") && (map = this.ksB.cNE().Kq) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.JX = list.get(0);
                eVar.JY = list.get(1);
            }
            eVar.JP = this.ksB.cNE().responseCode;
            eVar.downloadSize = this.Jy.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Jy);
            if (e != null) {
                eVar.downloadSize += e.length;
                this.ksB.cNE().retBytes = c(this.ksB.cNE().contentEncoding, e);
            }
            eVar.JQ = -9;
            eVar.JN = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.Jy != null) {
                this.Jy.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.JC = System.currentTimeMillis();
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
                while (!this.ksB.cNE().Kp && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.JB = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.f.a.close(inputStream);
                        throw th;
                    }
                }
                if (this.ksB.cNE().Kp) {
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
        this.JB = System.currentTimeMillis();
        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.f.a.close(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.JQ = -1;
        try {
            String url = this.ksB.cND().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.ksB.cNE().Kp) {
                throw new BdHttpCancelException();
            }
            eVar.JQ = -2;
            this.Jy = c(a);
            eVar.JQ = -3;
            System.currentTimeMillis();
            if (this.Jy == null) {
                throw new SocketException("network not available.");
            }
            this.Jy.setRequestMethod("POST");
            this.Jy.setDoOutput(true);
            this.Jy.setDoInput(true);
            this.Jy.setConnectTimeout(i2);
            this.Jy.setReadTimeout(i);
            this.Jy.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.ksB.cNE().Kp) {
                throw new BdHttpCancelException();
            }
            this.ksB.cND().f(this.Jy);
            if (this.ksB.cNE().Kp) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.dnsTime = new Date().getTime() - time;
            eVar.JQ = -4;
            this.Jy.connect();
            if (this.Jz <= 0) {
                this.Jz = System.currentTimeMillis();
            }
            this.JA = System.currentTimeMillis();
            eVar.JQ = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.dnsTime;
            if (this.ksB.cNE().Kp) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.JH, 45000L);
            }
            eVar.JQ = -6;
            this.ksB.cND().a(this.Jy, boundary, eVar);
            eVar.JQ = -7;
            String contentType = this.Jy.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bM(contentType)) {
                this.Jy.disconnect();
                this.Jy.connect();
                if (this.ksB.cNE().Kp) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.ksB.cNE().Kp) {
                throw new BdHttpCancelException();
            }
            eVar.JQ = -8;
            this.ksB.cNE().g(this.Jy);
            eVar.JP = this.ksB.cNE().responseCode;
            eVar.downloadSize = this.Jy.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Jy);
            if (e != null) {
                eVar.downloadSize += e.length;
                this.ksB.cNE().downSize = e.length;
                this.ksB.cNE().retBytes = c(this.ksB.cNE().contentEncoding, e);
            }
            eVar.JN = new Date().getTime() - time;
            eVar.JQ = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.f.a.close(this.Jy);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.ksA = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.ksB.cND().getUrl();
            eVar2.url = url;
            this.Jy = a(a(url, eVar2), i2, i);
            this.Jy.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.ksB.cNE().Kp) {
                this.JB = System.currentTimeMillis();
                com.baidu.adp.lib.f.a.close((InputStream) null);
                com.baidu.adp.lib.f.a.close(this.Jy);
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
                this.ksB.cND().f(this.Jy);
                this.Jy.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.Jy.connect();
                if (this.Jz <= 0) {
                    this.Jz = System.currentTimeMillis();
                }
                this.JA = System.currentTimeMillis();
                int responseCode = this.Jy.getResponseCode();
                while (BB(responseCode) && this.ksA <= 5) {
                    this.Jy = a(this.Jy, i2, i);
                    this.ksB.cND().f(this.Jy);
                    this.Jy.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.Jy.connect();
                    responseCode = this.Jy.getResponseCode();
                }
                this.firstByteReachTime = System.currentTimeMillis();
                this.ksB.cNE().responseCode = responseCode;
                if (isFileSegSuccess()) {
                    if (this.Jy.getContentType() != null && this.Jy.getContentType().contains("text/vnd.wap.wml")) {
                        this.Jy.disconnect();
                        this.ksB.cNE().responseCode = 0;
                        boolean a = a(str, jVar, i, i2, z, eVar2, z2);
                        this.JB = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.Jy);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.Jy.getHeaderField(Headers.CONTENT_RANGE);
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.f.b.toInt(headerField2.substring(indexOf + 1), 0);
                    }
                    int i4 = (i3 == 0 && this.ksB.cNE().responseCode == 200 && (headerField = this.Jy.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.f.b.toInt(headerField, 0) : i3;
                    this.ksB.cNE().contentLength = String.valueOf(i4);
                    eVar2.JM = url.getBytes().length;
                    eVar2.downloadSize = this.Jy.getHeaderFields().toString().getBytes().length;
                    eVar2.downloadSize += i4;
                    if (this.ksB.cNE().responseCode == 416 || this.ksB.cNE().responseCode == 204) {
                        this.JB = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.Jy);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    } else if (i4 != 0 && length >= i4) {
                        this.JB = System.currentTimeMillis();
                        this.JB = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.Jy);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.Jy.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i5 = 0;
                            int i6 = i4 > 0 ? i4 / 50 : 0;
                            int i7 = 0;
                            if (jVar != null && length > 0) {
                                jVar.onProgress((int) length, i4);
                            }
                            while (!this.ksB.cNE().Kp) {
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
                                this.JB = System.currentTimeMillis();
                                com.baidu.adp.lib.f.a.close(inputStream2);
                                com.baidu.adp.lib.f.a.close(this.Jy);
                                com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.JB = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close(inputStream);
                            com.baidu.adp.lib.f.a.close(this.Jy);
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
        this.ksA++;
        return a;
    }

    private boolean BB(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean isFileSegSuccess() {
        return this.ksB.cNE().responseCode == 200 || this.ksB.cNE().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.JQ = -1;
        try {
            String url = this.ksB.cND().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.ksB.cNE().Kp) {
                throw new BdHttpCancelException();
            }
            eVar.JQ = -2;
            this.Jy = c(a);
            eVar.JQ = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.Jy == null) {
                throw new SocketException("network not available.");
            }
            this.Jy.setRequestMethod("POST");
            this.Jy.setDoOutput(true);
            this.Jy.setDoInput(true);
            this.Jy.setConnectTimeout(i2);
            this.Jy.setReadTimeout(i);
            this.Jy.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.ksB.cNE().Kp) {
                throw new BdHttpCancelException();
            }
            this.ksB.cND().f(this.Jy);
            if (this.ksB.cNE().Kp) {
                throw new BdHttpCancelException();
            }
            eVar.dnsTime = System.currentTimeMillis() - currentTimeMillis;
            eVar.JQ = -4;
            this.Jy.connect();
            if (this.Jz <= 0) {
                this.Jz = System.currentTimeMillis();
            }
            this.JA = System.currentTimeMillis();
            eVar.JQ = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.dnsTime;
            if (this.ksB.cNE().Kp) {
                throw new BdHttpCancelException();
            }
            eVar.JQ = -6;
            this.ksB.cND().a(this.Jy, eVar);
            eVar.JQ = -7;
            if (this.ksB.cNE().Kp) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Jy.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bM(contentType)) {
                this.Jy.disconnect();
                this.Jy.connect();
                if (this.ksB.cNE().Kp) {
                    throw new BdHttpCancelException();
                }
            }
            this.ksB.cNE().g(this.Jy);
            eVar.JQ = -8;
            eVar.JP = this.ksB.cNE().responseCode;
            eVar.downloadSize = this.Jy.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Jy);
            if (e != null) {
                eVar.downloadSize += e.length;
                this.ksB.cNE().downSize = e.length;
                this.ksB.cNE().retBytes = c(this.ksB.cNE().contentEncoding, e);
            }
            eVar.JN = new Date().getTime() - currentTimeMillis;
            eVar.JQ = -9;
        } finally {
            com.baidu.adp.lib.f.a.close(this.Jy);
        }
    }
}
