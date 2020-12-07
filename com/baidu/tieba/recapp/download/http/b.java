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
/* loaded from: classes26.dex */
class b {
    private HttpURLConnection Mm;
    private int mIM;
    private g mIN;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int mIL = 5;
    private long Mn = 0;
    private long Mo = 0;
    private long firstByteReachTime = 0;
    private long Mp = 0;
    private long Mq = 0;
    private boolean Mr = false;
    private boolean Ms = true;
    private TimerTask Mw = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
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

    public long mo() {
        return this.Mn;
    }

    public boolean mr() {
        return this.Mr;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.mIN = gVar;
    }

    public void cancelNetConnect() {
        this.mIN.dFv().Nj = true;
        com.baidu.adp.lib.f.a.close(this.Mm);
    }

    private URL a(String str, e eVar) throws Exception {
        a dFs;
        URL url = new URL(str);
        if (this.Ms && (dFs = a.dFs()) != null) {
            String bL = dFs.bL(str);
            if (!TextUtils.isEmpty(bL)) {
                this.mIN.dFu().u("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + bL));
                this.Mr = true;
                eVar.MK = bL;
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
                            this.mIN.dFu().u("X-Online-Host", url.getHost());
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
        eVar.MI = -1;
        if (this.mIN.dFv().Nj) {
            throw new BdHttpCancelException();
        }
        String c = this.mIN.dFu().c(eVar);
        eVar.url = c;
        URL a2 = a(c, eVar);
        if (this.mIN.dFv().Nj) {
            throw new BdHttpCancelException();
        }
        eVar.MI = -2;
        this.Mm = c(a2);
        eVar.MI = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.Mm == null) {
                throw new SocketException("network not available.");
            }
            this.Mm.setRequestMethod("GET");
            this.Mm.setConnectTimeout(i2);
            this.Mm.setReadTimeout(i);
            this.mIN.dFu().f(this.Mm);
            if (this.mIN.dFv().Nj) {
                throw new BdHttpCancelException();
            }
            eVar.dnsTime = new Date().getTime() - currentTimeMillis;
            eVar.MI = -4;
            this.Mm.connect();
            if (this.Mn <= 0) {
                this.Mn = System.currentTimeMillis();
            }
            this.Mo = System.currentTimeMillis();
            eVar.MI = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.dnsTime;
            if (this.mIN.dFv().Nj) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Mm.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bW(contentType)) {
                this.Mm.disconnect();
                this.Mm.connect();
                if (this.mIN.dFv().Nj) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.MI = -8;
            this.mIN.dFv().g(this.Mm);
            if (c.contains("c.tieba.baidu.com") && (map = this.mIN.dFv().Nk) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.MR = list.get(0);
                eVar.MS = list.get(1);
            }
            eVar.MH = this.mIN.dFv().responseCode;
            eVar.downloadSize = this.Mm.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Mm);
            if (e != null) {
                eVar.downloadSize += e.length;
                this.mIN.dFv().retBytes = c(this.mIN.dFv().contentEncoding, e);
            }
            eVar.MI = -9;
            eVar.MF = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.Mm != null) {
                this.Mm.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.Mq = System.currentTimeMillis();
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
                while (!this.mIN.dFv().Nj && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.Mp = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.f.a.close(inputStream);
                        throw th;
                    }
                }
                if (this.mIN.dFv().Nj) {
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
        this.Mp = System.currentTimeMillis();
        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.f.a.close(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.MI = -1;
        try {
            String url = this.mIN.dFu().getUrl();
            eVar.url = url;
            URL a2 = a(url, eVar);
            if (this.mIN.dFv().Nj) {
                throw new BdHttpCancelException();
            }
            eVar.MI = -2;
            this.Mm = c(a2);
            eVar.MI = -3;
            System.currentTimeMillis();
            if (this.Mm == null) {
                throw new SocketException("network not available.");
            }
            this.Mm.setRequestMethod("POST");
            this.Mm.setDoOutput(true);
            this.Mm.setDoInput(true);
            this.Mm.setConnectTimeout(i2);
            this.Mm.setReadTimeout(i);
            this.Mm.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.mIN.dFv().Nj) {
                throw new BdHttpCancelException();
            }
            this.mIN.dFu().f(this.Mm);
            if (this.mIN.dFv().Nj) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.dnsTime = new Date().getTime() - time;
            eVar.MI = -4;
            this.Mm.connect();
            if (this.Mn <= 0) {
                this.Mn = System.currentTimeMillis();
            }
            this.Mo = System.currentTimeMillis();
            eVar.MI = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.dnsTime;
            if (this.mIN.dFv().Nj) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.Mw, 45000L);
            }
            eVar.MI = -6;
            this.mIN.dFu().a(this.Mm, boundary, eVar);
            eVar.MI = -7;
            String contentType = this.Mm.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bW(contentType)) {
                this.Mm.disconnect();
                this.Mm.connect();
                if (this.mIN.dFv().Nj) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.mIN.dFv().Nj) {
                throw new BdHttpCancelException();
            }
            eVar.MI = -8;
            this.mIN.dFv().g(this.Mm);
            eVar.MH = this.mIN.dFv().responseCode;
            eVar.downloadSize = this.Mm.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Mm);
            if (e != null) {
                eVar.downloadSize += e.length;
                this.mIN.dFv().downSize = e.length;
                this.mIN.dFv().retBytes = c(this.mIN.dFv().contentEncoding, e);
            }
            eVar.MF = new Date().getTime() - time;
            eVar.MI = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.f.a.close(this.Mm);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.mIM = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.mIN.dFu().getUrl();
            eVar2.url = url;
            this.Mm = a(a(url, eVar2), i2, i);
            this.Mm.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.mIN.dFv().Nj) {
                this.Mp = System.currentTimeMillis();
                com.baidu.adp.lib.f.a.close((InputStream) null);
                com.baidu.adp.lib.f.a.close(this.Mm);
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
                this.mIN.dFu().f(this.Mm);
                this.Mm.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.Mm.connect();
                if (this.Mn <= 0) {
                    this.Mn = System.currentTimeMillis();
                }
                this.Mo = System.currentTimeMillis();
                int responseCode = this.Mm.getResponseCode();
                while (Ji(responseCode) && this.mIM <= 5) {
                    this.Mm = a(this.Mm, i2, i);
                    this.mIN.dFu().f(this.Mm);
                    this.Mm.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.Mm.connect();
                    responseCode = this.Mm.getResponseCode();
                }
                this.firstByteReachTime = System.currentTimeMillis();
                this.mIN.dFv().responseCode = responseCode;
                if (isFileSegSuccess()) {
                    if (this.Mm.getContentType() != null && this.Mm.getContentType().contains("text/vnd.wap.wml")) {
                        this.Mm.disconnect();
                        this.mIN.dFv().responseCode = 0;
                        boolean a2 = a(str, jVar, i, i2, z, eVar2, z2);
                        this.Mp = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.Mm);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.Mm.getHeaderField(Headers.CONTENT_RANGE);
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.f.b.toInt(headerField2.substring(indexOf + 1), 0);
                    }
                    int i4 = (i3 == 0 && this.mIN.dFv().responseCode == 200 && (headerField = this.Mm.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.f.b.toInt(headerField, 0) : i3;
                    this.mIN.dFv().contentLength = String.valueOf(i4);
                    eVar2.ME = url.getBytes().length;
                    eVar2.downloadSize = this.Mm.getHeaderFields().toString().getBytes().length;
                    eVar2.downloadSize += i4;
                    if (this.mIN.dFv().responseCode == 416 || this.mIN.dFv().responseCode == 204) {
                        this.Mp = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.Mm);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    } else if (i4 != 0 && length >= i4) {
                        this.Mp = System.currentTimeMillis();
                        this.Mp = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.Mm);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.Mm.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i5 = 0;
                            int i6 = i4 > 0 ? i4 / 50 : 0;
                            int i7 = 0;
                            if (jVar != null && length > 0) {
                                jVar.onProgress((int) length, i4);
                            }
                            while (!this.mIN.dFv().Nj) {
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
                                this.Mp = System.currentTimeMillis();
                                com.baidu.adp.lib.f.a.close(inputStream2);
                                com.baidu.adp.lib.f.a.close(this.Mm);
                                com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.Mp = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close(inputStream);
                            com.baidu.adp.lib.f.a.close(this.Mm);
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
        this.mIM++;
        return a2;
    }

    private boolean Ji(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean isFileSegSuccess() {
        return this.mIN.dFv().responseCode == 200 || this.mIN.dFv().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.MI = -1;
        try {
            String url = this.mIN.dFu().getUrl();
            eVar.url = url;
            URL a2 = a(url, eVar);
            if (this.mIN.dFv().Nj) {
                throw new BdHttpCancelException();
            }
            eVar.MI = -2;
            this.Mm = c(a2);
            eVar.MI = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.Mm == null) {
                throw new SocketException("network not available.");
            }
            this.Mm.setRequestMethod("POST");
            this.Mm.setDoOutput(true);
            this.Mm.setDoInput(true);
            this.Mm.setConnectTimeout(i2);
            this.Mm.setReadTimeout(i);
            this.Mm.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.mIN.dFv().Nj) {
                throw new BdHttpCancelException();
            }
            this.mIN.dFu().f(this.Mm);
            if (this.mIN.dFv().Nj) {
                throw new BdHttpCancelException();
            }
            eVar.dnsTime = System.currentTimeMillis() - currentTimeMillis;
            eVar.MI = -4;
            this.Mm.connect();
            if (this.Mn <= 0) {
                this.Mn = System.currentTimeMillis();
            }
            this.Mo = System.currentTimeMillis();
            eVar.MI = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.dnsTime;
            if (this.mIN.dFv().Nj) {
                throw new BdHttpCancelException();
            }
            eVar.MI = -6;
            this.mIN.dFu().a(this.Mm, eVar);
            eVar.MI = -7;
            if (this.mIN.dFv().Nj) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Mm.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bW(contentType)) {
                this.Mm.disconnect();
                this.Mm.connect();
                if (this.mIN.dFv().Nj) {
                    throw new BdHttpCancelException();
                }
            }
            this.mIN.dFv().g(this.Mm);
            eVar.MI = -8;
            eVar.MH = this.mIN.dFv().responseCode;
            eVar.downloadSize = this.Mm.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Mm);
            if (e != null) {
                eVar.downloadSize += e.length;
                this.mIN.dFv().downSize = e.length;
                this.mIN.dFv().retBytes = c(this.mIN.dFv().contentEncoding, e);
            }
            eVar.MF = new Date().getTime() - currentTimeMillis;
            eVar.MI = -9;
        } finally {
            com.baidu.adp.lib.f.a.close(this.Mm);
        }
    }
}
