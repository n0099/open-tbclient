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
/* loaded from: classes25.dex */
class b {
    private HttpURLConnection KY;
    private int lMx;
    private g lMy;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int lMw = 5;
    private long KZ = 0;
    private long La = 0;
    private long firstByteReachTime = 0;
    private long Lb = 0;
    private long Lc = 0;
    private boolean Ld = false;
    private boolean Le = true;
    private TimerTask Li = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
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

    public long mn() {
        return this.KZ;
    }

    public boolean mq() {
        return this.Ld;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.lMy = gVar;
    }

    public void cancelNetConnect() {
        this.lMy.drk().LX = true;
        com.baidu.adp.lib.f.a.close(this.KY);
    }

    private URL a(String str, e eVar) throws Exception {
        a drh;
        URL url = new URL(str);
        if (this.Le && (drh = a.drh()) != null) {
            String bI = drh.bI(str);
            if (!TextUtils.isEmpty(bI)) {
                this.lMy.drj().u("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + bI));
                this.Ld = true;
                eVar.Lv = bI;
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
                            this.lMy.drj().u("X-Online-Host", url.getHost());
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
        eVar.Lt = -1;
        if (this.lMy.drk().LX) {
            throw new BdHttpCancelException();
        }
        String c = this.lMy.drj().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.lMy.drk().LX) {
            throw new BdHttpCancelException();
        }
        eVar.Lt = -2;
        this.KY = c(a);
        eVar.Lt = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.KY == null) {
                throw new SocketException("network not available.");
            }
            this.KY.setRequestMethod("GET");
            this.KY.setConnectTimeout(i2);
            this.KY.setReadTimeout(i);
            this.lMy.drj().f(this.KY);
            if (this.lMy.drk().LX) {
                throw new BdHttpCancelException();
            }
            eVar.dnsTime = new Date().getTime() - currentTimeMillis;
            eVar.Lt = -4;
            this.KY.connect();
            if (this.KZ <= 0) {
                this.KZ = System.currentTimeMillis();
            }
            this.La = System.currentTimeMillis();
            eVar.Lt = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.dnsTime;
            if (this.lMy.drk().LX) {
                throw new BdHttpCancelException();
            }
            String contentType = this.KY.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bT(contentType)) {
                this.KY.disconnect();
                this.KY.connect();
                if (this.lMy.drk().LX) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.Lt = -8;
            this.lMy.drk().g(this.KY);
            if (c.contains("c.tieba.baidu.com") && (map = this.lMy.drk().LY) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.LA = list.get(0);
                eVar.LB = list.get(1);
            }
            eVar.Ls = this.lMy.drk().responseCode;
            eVar.downloadSize = this.KY.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.KY);
            if (e != null) {
                eVar.downloadSize += e.length;
                this.lMy.drk().retBytes = c(this.lMy.drk().contentEncoding, e);
            }
            eVar.Lt = -9;
            eVar.Lq = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.KY != null) {
                this.KY.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.Lc = System.currentTimeMillis();
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
                while (!this.lMy.drk().LX && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.Lb = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.f.a.close(inputStream);
                        throw th;
                    }
                }
                if (this.lMy.drk().LX) {
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
        this.Lb = System.currentTimeMillis();
        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.f.a.close(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.Lt = -1;
        try {
            String url = this.lMy.drj().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.lMy.drk().LX) {
                throw new BdHttpCancelException();
            }
            eVar.Lt = -2;
            this.KY = c(a);
            eVar.Lt = -3;
            System.currentTimeMillis();
            if (this.KY == null) {
                throw new SocketException("network not available.");
            }
            this.KY.setRequestMethod("POST");
            this.KY.setDoOutput(true);
            this.KY.setDoInput(true);
            this.KY.setConnectTimeout(i2);
            this.KY.setReadTimeout(i);
            this.KY.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.lMy.drk().LX) {
                throw new BdHttpCancelException();
            }
            this.lMy.drj().f(this.KY);
            if (this.lMy.drk().LX) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.dnsTime = new Date().getTime() - time;
            eVar.Lt = -4;
            this.KY.connect();
            if (this.KZ <= 0) {
                this.KZ = System.currentTimeMillis();
            }
            this.La = System.currentTimeMillis();
            eVar.Lt = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.dnsTime;
            if (this.lMy.drk().LX) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.Li, 45000L);
            }
            eVar.Lt = -6;
            this.lMy.drj().a(this.KY, boundary, eVar);
            eVar.Lt = -7;
            String contentType = this.KY.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bT(contentType)) {
                this.KY.disconnect();
                this.KY.connect();
                if (this.lMy.drk().LX) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.lMy.drk().LX) {
                throw new BdHttpCancelException();
            }
            eVar.Lt = -8;
            this.lMy.drk().g(this.KY);
            eVar.Ls = this.lMy.drk().responseCode;
            eVar.downloadSize = this.KY.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.KY);
            if (e != null) {
                eVar.downloadSize += e.length;
                this.lMy.drk().downSize = e.length;
                this.lMy.drk().retBytes = c(this.lMy.drk().contentEncoding, e);
            }
            eVar.Lq = new Date().getTime() - time;
            eVar.Lt = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.f.a.close(this.KY);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.lMx = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.lMy.drj().getUrl();
            eVar2.url = url;
            this.KY = a(a(url, eVar2), i2, i);
            this.KY.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.lMy.drk().LX) {
                this.Lb = System.currentTimeMillis();
                com.baidu.adp.lib.f.a.close((InputStream) null);
                com.baidu.adp.lib.f.a.close(this.KY);
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
                this.lMy.drj().f(this.KY);
                this.KY.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.KY.connect();
                if (this.KZ <= 0) {
                    this.KZ = System.currentTimeMillis();
                }
                this.La = System.currentTimeMillis();
                int responseCode = this.KY.getResponseCode();
                while (GH(responseCode) && this.lMx <= 5) {
                    this.KY = a(this.KY, i2, i);
                    this.lMy.drj().f(this.KY);
                    this.KY.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.KY.connect();
                    responseCode = this.KY.getResponseCode();
                }
                this.firstByteReachTime = System.currentTimeMillis();
                this.lMy.drk().responseCode = responseCode;
                if (isFileSegSuccess()) {
                    if (this.KY.getContentType() != null && this.KY.getContentType().contains("text/vnd.wap.wml")) {
                        this.KY.disconnect();
                        this.lMy.drk().responseCode = 0;
                        boolean a = a(str, jVar, i, i2, z, eVar2, z2);
                        this.Lb = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.KY);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.KY.getHeaderField(Headers.CONTENT_RANGE);
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.f.b.toInt(headerField2.substring(indexOf + 1), 0);
                    }
                    int i4 = (i3 == 0 && this.lMy.drk().responseCode == 200 && (headerField = this.KY.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.f.b.toInt(headerField, 0) : i3;
                    this.lMy.drk().contentLength = String.valueOf(i4);
                    eVar2.Lp = url.getBytes().length;
                    eVar2.downloadSize = this.KY.getHeaderFields().toString().getBytes().length;
                    eVar2.downloadSize += i4;
                    if (this.lMy.drk().responseCode == 416 || this.lMy.drk().responseCode == 204) {
                        this.Lb = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.KY);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    } else if (i4 != 0 && length >= i4) {
                        this.Lb = System.currentTimeMillis();
                        this.Lb = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.KY);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.KY.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i5 = 0;
                            int i6 = i4 > 0 ? i4 / 50 : 0;
                            int i7 = 0;
                            if (jVar != null && length > 0) {
                                jVar.onProgress((int) length, i4);
                            }
                            while (!this.lMy.drk().LX) {
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
                                this.Lb = System.currentTimeMillis();
                                com.baidu.adp.lib.f.a.close(inputStream2);
                                com.baidu.adp.lib.f.a.close(this.KY);
                                com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.Lb = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close(inputStream);
                            com.baidu.adp.lib.f.a.close(this.KY);
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
        this.lMx++;
        return a;
    }

    private boolean GH(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean isFileSegSuccess() {
        return this.lMy.drk().responseCode == 200 || this.lMy.drk().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.Lt = -1;
        try {
            String url = this.lMy.drj().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.lMy.drk().LX) {
                throw new BdHttpCancelException();
            }
            eVar.Lt = -2;
            this.KY = c(a);
            eVar.Lt = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.KY == null) {
                throw new SocketException("network not available.");
            }
            this.KY.setRequestMethod("POST");
            this.KY.setDoOutput(true);
            this.KY.setDoInput(true);
            this.KY.setConnectTimeout(i2);
            this.KY.setReadTimeout(i);
            this.KY.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.lMy.drk().LX) {
                throw new BdHttpCancelException();
            }
            this.lMy.drj().f(this.KY);
            if (this.lMy.drk().LX) {
                throw new BdHttpCancelException();
            }
            eVar.dnsTime = System.currentTimeMillis() - currentTimeMillis;
            eVar.Lt = -4;
            this.KY.connect();
            if (this.KZ <= 0) {
                this.KZ = System.currentTimeMillis();
            }
            this.La = System.currentTimeMillis();
            eVar.Lt = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.dnsTime;
            if (this.lMy.drk().LX) {
                throw new BdHttpCancelException();
            }
            eVar.Lt = -6;
            this.lMy.drj().a(this.KY, eVar);
            eVar.Lt = -7;
            if (this.lMy.drk().LX) {
                throw new BdHttpCancelException();
            }
            String contentType = this.KY.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bT(contentType)) {
                this.KY.disconnect();
                this.KY.connect();
                if (this.lMy.drk().LX) {
                    throw new BdHttpCancelException();
                }
            }
            this.lMy.drk().g(this.KY);
            eVar.Lt = -8;
            eVar.Ls = this.lMy.drk().responseCode;
            eVar.downloadSize = this.KY.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.KY);
            if (e != null) {
                eVar.downloadSize += e.length;
                this.lMy.drk().downSize = e.length;
                this.lMy.drk().retBytes = c(this.lMy.drk().contentEncoding, e);
            }
            eVar.Lq = new Date().getTime() - currentTimeMillis;
            eVar.Lt = -9;
        } finally {
            com.baidu.adp.lib.f.a.close(this.KY);
        }
    }
}
