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
    private HttpURLConnection LD;
    private int mTa;
    private g mTb;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int mSZ = 5;
    private long LH = 0;
    private long LI = 0;
    private long firstByteReachTime = 0;
    private long LJ = 0;
    private long LK = 0;
    private boolean LM = false;
    private boolean LN = true;
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

    public long lL() {
        return this.LH;
    }

    public boolean lO() {
        return this.LM;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.mTb = gVar;
    }

    public void cancelNetConnect() {
        this.mTb.dDL().MD = true;
        com.baidu.adp.lib.f.a.close(this.LD);
    }

    private URL a(String str, e eVar) throws Exception {
        a dDI;
        URL url = new URL(str);
        if (this.LN && (dDI = a.dDI()) != null) {
            String bF = dDI.bF(str);
            if (!TextUtils.isEmpty(bF)) {
                this.mTb.dDK().s("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + bF));
                this.LM = true;
                eVar.Mf = bF;
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
                            this.mTb.dDK().s("X-Online-Host", url.getHost());
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
        eVar.Md = -1;
        if (this.mTb.dDL().MD) {
            throw new BdHttpCancelException();
        }
        String c = this.mTb.dDK().c(eVar);
        eVar.url = c;
        URL a2 = a(c, eVar);
        if (this.mTb.dDL().MD) {
            throw new BdHttpCancelException();
        }
        eVar.Md = -2;
        this.LD = c(a2);
        eVar.Md = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.LD == null) {
                throw new SocketException("network not available.");
            }
            this.LD.setRequestMethod("GET");
            this.LD.setConnectTimeout(i2);
            this.LD.setReadTimeout(i);
            this.mTb.dDK().d(this.LD);
            if (this.mTb.dDL().MD) {
                throw new BdHttpCancelException();
            }
            eVar.dnsTime = new Date().getTime() - currentTimeMillis;
            eVar.Md = -4;
            this.LD.connect();
            if (this.LH <= 0) {
                this.LH = System.currentTimeMillis();
            }
            this.LI = System.currentTimeMillis();
            eVar.Md = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.dnsTime;
            if (this.mTb.dDL().MD) {
                throw new BdHttpCancelException();
            }
            String contentType = this.LD.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bQ(contentType)) {
                this.LD.disconnect();
                this.LD.connect();
                if (this.mTb.dDL().MD) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.Md = -8;
            this.mTb.dDL().e(this.LD);
            if (c.contains("c.tieba.baidu.com") && (map = this.mTb.dDL().ME) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.Mk = list.get(0);
                eVar.Ml = list.get(1);
            }
            eVar.Mc = this.mTb.dDL().responseCode;
            eVar.downloadSize = this.LD.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.LD);
            if (c2 != null) {
                eVar.downloadSize += c2.length;
                this.mTb.dDL().retBytes = e(this.mTb.dDL().contentEncoding, c2);
            }
            eVar.Md = -9;
            eVar.Ma = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.LD != null) {
                this.LD.disconnect();
            }
        }
    }

    protected final byte[] e(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.LK = System.currentTimeMillis();
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
                while (!this.mTb.dDL().MD && (read = inputStream.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream2 = inputStream;
                        this.LJ = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.f.a.close(inputStream2);
                        throw th;
                    }
                }
                if (this.mTb.dDL().MD) {
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
        this.LJ = System.currentTimeMillis();
        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.f.a.close(inputStream);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.Md = -1;
        try {
            String url = this.mTb.dDK().getUrl();
            eVar.url = url;
            URL a2 = a(url, eVar);
            if (this.mTb.dDL().MD) {
                throw new BdHttpCancelException();
            }
            eVar.Md = -2;
            this.LD = c(a2);
            eVar.Md = -3;
            System.currentTimeMillis();
            if (this.LD == null) {
                throw new SocketException("network not available.");
            }
            this.LD.setRequestMethod("POST");
            this.LD.setDoOutput(true);
            this.LD.setDoInput(true);
            this.LD.setConnectTimeout(i2);
            this.LD.setReadTimeout(i);
            this.LD.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.mTb.dDL().MD) {
                throw new BdHttpCancelException();
            }
            this.mTb.dDK().d(this.LD);
            if (this.mTb.dDL().MD) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.dnsTime = new Date().getTime() - time;
            eVar.Md = -4;
            this.LD.connect();
            if (this.LH <= 0) {
                this.LH = System.currentTimeMillis();
            }
            this.LI = System.currentTimeMillis();
            eVar.Md = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.dnsTime;
            if (this.mTb.dDL().MD) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.timerTask, 45000L);
            }
            eVar.Md = -6;
            this.mTb.dDK().a(this.LD, boundary, eVar);
            eVar.Md = -7;
            String contentType = this.LD.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bQ(contentType)) {
                this.LD.disconnect();
                this.LD.connect();
                if (this.mTb.dDL().MD) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.mTb.dDL().MD) {
                throw new BdHttpCancelException();
            }
            eVar.Md = -8;
            this.mTb.dDL().e(this.LD);
            eVar.Mc = this.mTb.dDL().responseCode;
            eVar.downloadSize = this.LD.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.LD);
            if (c != null) {
                eVar.downloadSize += c.length;
                this.mTb.dDL().downSize = c.length;
                this.mTb.dDL().retBytes = e(this.mTb.dDL().contentEncoding, c);
            }
            eVar.Ma = new Date().getTime() - time;
            eVar.Md = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.f.a.close(this.LD);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.mTa = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.mTb.dDK().getUrl();
            eVar2.url = url;
            this.LD = a(a(url, eVar2), i2, i);
            this.LD.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.mTb.dDL().MD) {
                this.LJ = System.currentTimeMillis();
                com.baidu.adp.lib.f.a.close((InputStream) null);
                com.baidu.adp.lib.f.a.close(this.LD);
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
                this.mTb.dDK().d(this.LD);
                this.LD.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.LD.connect();
                if (this.LH <= 0) {
                    this.LH = System.currentTimeMillis();
                }
                this.LI = System.currentTimeMillis();
                int responseCode = this.LD.getResponseCode();
                while (HO(responseCode) && this.mTa <= 5) {
                    this.LD = a(this.LD, i2, i);
                    this.mTb.dDK().d(this.LD);
                    this.LD.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.LD.connect();
                    responseCode = this.LD.getResponseCode();
                }
                this.firstByteReachTime = System.currentTimeMillis();
                this.mTb.dDL().responseCode = responseCode;
                if (isFileSegSuccess()) {
                    if (this.LD.getContentType() != null && this.LD.getContentType().contains("text/vnd.wap.wml")) {
                        this.LD.disconnect();
                        this.mTb.dDL().responseCode = 0;
                        boolean a2 = a(str, jVar, i, i2, z, eVar2, z2);
                        this.LJ = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.LD);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.LD.getHeaderField(Headers.CONTENT_RANGE);
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.f.b.toInt(headerField2.substring(indexOf + 1), 0);
                    }
                    int i4 = (i3 == 0 && this.mTb.dDL().responseCode == 200 && (headerField = this.LD.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.f.b.toInt(headerField, 0) : i3;
                    this.mTb.dDL().contentLength = String.valueOf(i4);
                    eVar2.LZ = url.getBytes().length;
                    eVar2.downloadSize = this.LD.getHeaderFields().toString().getBytes().length;
                    eVar2.downloadSize += i4;
                    if (this.mTb.dDL().responseCode == 416 || this.mTb.dDL().responseCode == 204) {
                        this.LJ = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.LD);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    } else if (i4 != 0 && length >= i4) {
                        this.LJ = System.currentTimeMillis();
                        this.LJ = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.LD);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        inputStream = this.LD.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i5 = 0;
                            int i6 = i4 > 0 ? i4 / 50 : 0;
                            int i7 = 0;
                            if (jVar != null && length > 0) {
                                jVar.onProgress((int) length, i4);
                            }
                            while (!this.mTb.dDL().MD) {
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
                                this.LJ = System.currentTimeMillis();
                                com.baidu.adp.lib.f.a.close(inputStream);
                                com.baidu.adp.lib.f.a.close(this.LD);
                                com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            this.LJ = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close(inputStream);
                            com.baidu.adp.lib.f.a.close(this.LD);
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
        this.mTa++;
        return a2;
    }

    private boolean HO(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean isFileSegSuccess() {
        return this.mTb.dDL().responseCode == 200 || this.mTb.dDL().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.Md = -1;
        try {
            String url = this.mTb.dDK().getUrl();
            eVar.url = url;
            URL a2 = a(url, eVar);
            if (this.mTb.dDL().MD) {
                throw new BdHttpCancelException();
            }
            eVar.Md = -2;
            this.LD = c(a2);
            eVar.Md = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.LD == null) {
                throw new SocketException("network not available.");
            }
            this.LD.setRequestMethod("POST");
            this.LD.setDoOutput(true);
            this.LD.setDoInput(true);
            this.LD.setConnectTimeout(i2);
            this.LD.setReadTimeout(i);
            this.LD.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.mTb.dDL().MD) {
                throw new BdHttpCancelException();
            }
            this.mTb.dDK().d(this.LD);
            if (this.mTb.dDL().MD) {
                throw new BdHttpCancelException();
            }
            eVar.dnsTime = System.currentTimeMillis() - currentTimeMillis;
            eVar.Md = -4;
            this.LD.connect();
            if (this.LH <= 0) {
                this.LH = System.currentTimeMillis();
            }
            this.LI = System.currentTimeMillis();
            eVar.Md = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.dnsTime;
            if (this.mTb.dDL().MD) {
                throw new BdHttpCancelException();
            }
            eVar.Md = -6;
            this.mTb.dDK().a(this.LD, eVar);
            eVar.Md = -7;
            if (this.mTb.dDL().MD) {
                throw new BdHttpCancelException();
            }
            String contentType = this.LD.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bQ(contentType)) {
                this.LD.disconnect();
                this.LD.connect();
                if (this.mTb.dDL().MD) {
                    throw new BdHttpCancelException();
                }
            }
            this.mTb.dDL().e(this.LD);
            eVar.Md = -8;
            eVar.Mc = this.mTb.dDL().responseCode;
            eVar.downloadSize = this.LD.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.LD);
            if (c != null) {
                eVar.downloadSize += c.length;
                this.mTb.dDL().downSize = c.length;
                this.mTb.dDL().retBytes = e(this.mTb.dDL().contentEncoding, c);
            }
            eVar.Ma = new Date().getTime() - currentTimeMillis;
            eVar.Md = -9;
        } finally {
            com.baidu.adp.lib.f.a.close(this.LD);
        }
    }
}
