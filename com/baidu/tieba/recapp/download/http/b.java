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
/* loaded from: classes8.dex */
class b {
    private HttpURLConnection LK;
    private int mNV;
    private g mNW;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int mNU = 5;
    private long LM = 0;
    private long LN = 0;
    private long firstByteReachTime = 0;
    private long LO = 0;
    private long LQ = 0;
    private boolean LR = false;
    private boolean LS = true;
    private TimerTask timerTask = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
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

    public long lM() {
        return this.LM;
    }

    public boolean lP() {
        return this.LR;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.mNW = gVar;
    }

    public void cancelNetConnect() {
        this.mNW.dFm().MH = true;
        com.baidu.adp.lib.f.a.close(this.LK);
    }

    private URL a(String str, e eVar) throws Exception {
        a dFj;
        URL url = new URL(str);
        if (this.LS && (dFj = a.dFj()) != null) {
            String bF = dFj.bF(str);
            if (!TextUtils.isEmpty(bF)) {
                this.mNW.dFl().u("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + bF));
                this.LR = true;
                eVar.Mj = bF;
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
                            this.mNW.dFl().u("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e) {
                            e = e;
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
                    } catch (Exception e2) {
                        e = e2;
                        httpURLConnection = httpURLConnection2;
                        e.printStackTrace();
                        return httpURLConnection;
                    }
                }
                return httpURLConnection2;
            }
            return null;
        } catch (Exception e3) {
            e = e3;
            httpURLConnection = null;
        }
    }

    public void a(int i, int i2, e eVar) throws Exception {
        Map<String, List<String>> map;
        List<String> list;
        eVar.Mh = -1;
        if (this.mNW.dFm().MH) {
            throw new BdHttpCancelException();
        }
        String c = this.mNW.dFl().c(eVar);
        eVar.url = c;
        URL a2 = a(c, eVar);
        if (this.mNW.dFm().MH) {
            throw new BdHttpCancelException();
        }
        eVar.Mh = -2;
        this.LK = c(a2);
        eVar.Mh = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.LK == null) {
                throw new SocketException("network not available.");
            }
            this.LK.setRequestMethod("GET");
            this.LK.setConnectTimeout(i2);
            this.LK.setReadTimeout(i);
            this.mNW.dFl().d(this.LK);
            if (this.mNW.dFm().MH) {
                throw new BdHttpCancelException();
            }
            eVar.dnsTime = new Date().getTime() - currentTimeMillis;
            eVar.Mh = -4;
            this.LK.connect();
            if (this.LM <= 0) {
                this.LM = System.currentTimeMillis();
            }
            this.LN = System.currentTimeMillis();
            eVar.Mh = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.dnsTime;
            if (this.mNW.dFm().MH) {
                throw new BdHttpCancelException();
            }
            String contentType = this.LK.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bQ(contentType)) {
                this.LK.disconnect();
                this.LK.connect();
                if (this.mNW.dFm().MH) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.Mh = -8;
            this.mNW.dFm().e(this.LK);
            if (c.contains("c.tieba.baidu.com") && (map = this.mNW.dFm().MI) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.Mo = list.get(0);
                eVar.Mp = list.get(1);
            }
            eVar.Mg = this.mNW.dFm().responseCode;
            eVar.downloadSize = this.LK.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.LK);
            if (c2 != null) {
                eVar.downloadSize += c2.length;
                this.mNW.dFm().retBytes = e(this.mNW.dFm().contentEncoding, c2);
            }
            eVar.Mh = -9;
            eVar.Me = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.LK != null) {
                this.LK.disconnect();
            }
        }
    }

    protected final byte[] e(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.LQ = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        }
        return bArr;
    }

    private byte[] c(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStream;
        byte[] bArr;
        Throwable th;
        InputStream inputStream2;
        int read;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        if (httpURLConnection != null) {
            try {
                byte[] bArr2 = new byte[1024];
                inputStream = httpURLConnection.getInputStream();
                while (!this.mNW.dFm().MH && (read = inputStream.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream2 = inputStream;
                        this.LO = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.f.a.close(inputStream2);
                        throw th;
                    }
                }
                if (this.mNW.dFm().MH) {
                    throw new BdHttpCancelException();
                }
                bArr = byteArrayOutputStream.toByteArray();
            } catch (Throwable th3) {
                th = th3;
                inputStream2 = null;
            }
        } else {
            inputStream = null;
            bArr = null;
        }
        this.LO = System.currentTimeMillis();
        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.f.a.close(inputStream);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.Mh = -1;
        try {
            String url = this.mNW.dFl().getUrl();
            eVar.url = url;
            URL a2 = a(url, eVar);
            if (this.mNW.dFm().MH) {
                throw new BdHttpCancelException();
            }
            eVar.Mh = -2;
            this.LK = c(a2);
            eVar.Mh = -3;
            System.currentTimeMillis();
            if (this.LK == null) {
                throw new SocketException("network not available.");
            }
            this.LK.setRequestMethod("POST");
            this.LK.setDoOutput(true);
            this.LK.setDoInput(true);
            this.LK.setConnectTimeout(i2);
            this.LK.setReadTimeout(i);
            this.LK.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.mNW.dFm().MH) {
                throw new BdHttpCancelException();
            }
            this.mNW.dFl().d(this.LK);
            if (this.mNW.dFm().MH) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.dnsTime = new Date().getTime() - time;
            eVar.Mh = -4;
            this.LK.connect();
            if (this.LM <= 0) {
                this.LM = System.currentTimeMillis();
            }
            this.LN = System.currentTimeMillis();
            eVar.Mh = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.dnsTime;
            if (this.mNW.dFm().MH) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.timerTask, 45000L);
            }
            eVar.Mh = -6;
            this.mNW.dFl().a(this.LK, boundary, eVar);
            eVar.Mh = -7;
            String contentType = this.LK.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bQ(contentType)) {
                this.LK.disconnect();
                this.LK.connect();
                if (this.mNW.dFm().MH) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.mNW.dFm().MH) {
                throw new BdHttpCancelException();
            }
            eVar.Mh = -8;
            this.mNW.dFm().e(this.LK);
            eVar.Mg = this.mNW.dFm().responseCode;
            eVar.downloadSize = this.LK.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.LK);
            if (c != null) {
                eVar.downloadSize += c.length;
                this.mNW.dFm().downSize = c.length;
                this.mNW.dFm().retBytes = e(this.mNW.dFm().contentEncoding, c);
            }
            eVar.Me = new Date().getTime() - time;
            eVar.Mh = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.f.a.close(this.LK);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.mNV = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.mNW.dFl().getUrl();
            eVar2.url = url;
            this.LK = a(a(url, eVar2), i2, i);
            this.LK.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.mNW.dFm().MH) {
                this.LO = System.currentTimeMillis();
                com.baidu.adp.lib.f.a.close((InputStream) null);
                com.baidu.adp.lib.f.a.close(this.LK);
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
                this.mNW.dFl().d(this.LK);
                this.LK.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.LK.connect();
                if (this.LM <= 0) {
                    this.LM = System.currentTimeMillis();
                }
                this.LN = System.currentTimeMillis();
                int responseCode = this.LK.getResponseCode();
                while (Jc(responseCode) && this.mNV <= 5) {
                    this.LK = a(this.LK, i2, i);
                    this.mNW.dFl().d(this.LK);
                    this.LK.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.LK.connect();
                    responseCode = this.LK.getResponseCode();
                }
                this.firstByteReachTime = System.currentTimeMillis();
                this.mNW.dFm().responseCode = responseCode;
                if (isFileSegSuccess()) {
                    if (this.LK.getContentType() != null && this.LK.getContentType().contains("text/vnd.wap.wml")) {
                        this.LK.disconnect();
                        this.mNW.dFm().responseCode = 0;
                        boolean a2 = a(str, jVar, i, i2, z, eVar2, z2);
                        this.LO = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.LK);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.LK.getHeaderField(Headers.CONTENT_RANGE);
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.f.b.toInt(headerField2.substring(indexOf + 1), 0);
                    }
                    int i4 = (i3 == 0 && this.mNW.dFm().responseCode == 200 && (headerField = this.LK.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.f.b.toInt(headerField, 0) : i3;
                    this.mNW.dFm().contentLength = String.valueOf(i4);
                    eVar2.Md = url.getBytes().length;
                    eVar2.downloadSize = this.LK.getHeaderFields().toString().getBytes().length;
                    eVar2.downloadSize += i4;
                    if (this.mNW.dFm().responseCode == 416 || this.mNW.dFm().responseCode == 204) {
                        this.LO = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.LK);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    } else if (i4 != 0 && length >= i4) {
                        this.LO = System.currentTimeMillis();
                        this.LO = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.LK);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        inputStream = this.LK.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i5 = 0;
                            int i6 = i4 > 0 ? i4 / 50 : 0;
                            int i7 = 0;
                            if (jVar != null && length > 0) {
                                jVar.onProgress((int) length, i4);
                            }
                            while (!this.mNW.dFm().MH) {
                                int read = inputStream.read(bArr);
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
                                this.LO = System.currentTimeMillis();
                                com.baidu.adp.lib.f.a.close(inputStream);
                                com.baidu.adp.lib.f.a.close(this.LK);
                                com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            this.LO = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close(inputStream);
                            com.baidu.adp.lib.f.a.close(this.LK);
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
        HttpURLConnection a2 = a(url, i, i2);
        this.mNV++;
        return a2;
    }

    private boolean Jc(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean isFileSegSuccess() {
        return this.mNW.dFm().responseCode == 200 || this.mNW.dFm().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.Mh = -1;
        try {
            String url = this.mNW.dFl().getUrl();
            eVar.url = url;
            URL a2 = a(url, eVar);
            if (this.mNW.dFm().MH) {
                throw new BdHttpCancelException();
            }
            eVar.Mh = -2;
            this.LK = c(a2);
            eVar.Mh = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.LK == null) {
                throw new SocketException("network not available.");
            }
            this.LK.setRequestMethod("POST");
            this.LK.setDoOutput(true);
            this.LK.setDoInput(true);
            this.LK.setConnectTimeout(i2);
            this.LK.setReadTimeout(i);
            this.LK.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.mNW.dFm().MH) {
                throw new BdHttpCancelException();
            }
            this.mNW.dFl().d(this.LK);
            if (this.mNW.dFm().MH) {
                throw new BdHttpCancelException();
            }
            eVar.dnsTime = System.currentTimeMillis() - currentTimeMillis;
            eVar.Mh = -4;
            this.LK.connect();
            if (this.LM <= 0) {
                this.LM = System.currentTimeMillis();
            }
            this.LN = System.currentTimeMillis();
            eVar.Mh = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.dnsTime;
            if (this.mNW.dFm().MH) {
                throw new BdHttpCancelException();
            }
            eVar.Mh = -6;
            this.mNW.dFl().a(this.LK, eVar);
            eVar.Mh = -7;
            if (this.mNW.dFm().MH) {
                throw new BdHttpCancelException();
            }
            String contentType = this.LK.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bQ(contentType)) {
                this.LK.disconnect();
                this.LK.connect();
                if (this.mNW.dFm().MH) {
                    throw new BdHttpCancelException();
                }
            }
            this.mNW.dFm().e(this.LK);
            eVar.Mh = -8;
            eVar.Mg = this.mNW.dFm().responseCode;
            eVar.downloadSize = this.LK.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.LK);
            if (c != null) {
                eVar.downloadSize += c.length;
                this.mNW.dFm().downSize = c.length;
                this.mNW.dFm().retBytes = e(this.mNW.dFm().contentEncoding, c);
            }
            eVar.Me = new Date().getTime() - currentTimeMillis;
            eVar.Mh = -9;
        } finally {
            com.baidu.adp.lib.f.a.close(this.LK);
        }
    }
}
