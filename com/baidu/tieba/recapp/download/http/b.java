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
/* loaded from: classes7.dex */
class b {
    private HttpURLConnection Ne;
    private int mVh;
    private g mVi;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int mVg = 5;
    private long Nf = 0;
    private long Ng = 0;
    private long firstByteReachTime = 0;
    private long Nh = 0;
    private long Ni = 0;
    private boolean Nj = false;
    private boolean Nk = true;
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
        return this.Nf;
    }

    public boolean lO() {
        return this.Nj;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.mVi = gVar;
    }

    public void cancelNetConnect() {
        this.mVi.dDT().Od = true;
        com.baidu.adp.lib.f.a.close(this.Ne);
    }

    private URL a(String str, e eVar) throws Exception {
        a dDQ;
        URL url = new URL(str);
        if (this.Nk && (dDQ = a.dDQ()) != null) {
            String bJ = dDQ.bJ(str);
            if (!TextUtils.isEmpty(bJ)) {
                this.mVi.dDS().s("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + bJ));
                this.Nj = true;
                eVar.NC = bJ;
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
                            this.mVi.dDS().s("X-Online-Host", url.getHost());
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
        eVar.Ny = -1;
        if (this.mVi.dDT().Od) {
            throw new BdHttpCancelException();
        }
        String c = this.mVi.dDS().c(eVar);
        eVar.url = c;
        URL a2 = a(c, eVar);
        if (this.mVi.dDT().Od) {
            throw new BdHttpCancelException();
        }
        eVar.Ny = -2;
        this.Ne = c(a2);
        eVar.Ny = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.Ne == null) {
                throw new SocketException("network not available.");
            }
            this.Ne.setRequestMethod("GET");
            this.Ne.setConnectTimeout(i2);
            this.Ne.setReadTimeout(i);
            this.mVi.dDS().d(this.Ne);
            if (this.mVi.dDT().Od) {
                throw new BdHttpCancelException();
            }
            eVar.dnsTime = new Date().getTime() - currentTimeMillis;
            eVar.Ny = -4;
            this.Ne.connect();
            if (this.Nf <= 0) {
                this.Nf = System.currentTimeMillis();
            }
            this.Ng = System.currentTimeMillis();
            eVar.Ny = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.dnsTime;
            if (this.mVi.dDT().Od) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Ne.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bU(contentType)) {
                this.Ne.disconnect();
                this.Ne.connect();
                if (this.mVi.dDT().Od) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.Ny = -8;
            this.mVi.dDT().e(this.Ne);
            if (c.contains("c.tieba.baidu.com") && (map = this.mVi.dDT().Oe) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.NI = list.get(0);
                eVar.NJ = list.get(1);
            }
            eVar.Nx = this.mVi.dDT().responseCode;
            eVar.downloadSize = this.Ne.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.Ne);
            if (c2 != null) {
                eVar.downloadSize += c2.length;
                this.mVi.dDT().retBytes = d(this.mVi.dDT().contentEncoding, c2);
            }
            eVar.Ny = -9;
            eVar.Nv = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.Ne != null) {
                this.Ne.disconnect();
            }
        }
    }

    protected final byte[] d(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.Ni = System.currentTimeMillis();
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
                while (!this.mVi.dDT().Od && (read = inputStream.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream2 = inputStream;
                        this.Nh = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.f.a.close(inputStream2);
                        throw th;
                    }
                }
                if (this.mVi.dDT().Od) {
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
        this.Nh = System.currentTimeMillis();
        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.f.a.close(inputStream);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.Ny = -1;
        try {
            String url = this.mVi.dDS().getUrl();
            eVar.url = url;
            URL a2 = a(url, eVar);
            if (this.mVi.dDT().Od) {
                throw new BdHttpCancelException();
            }
            eVar.Ny = -2;
            this.Ne = c(a2);
            eVar.Ny = -3;
            System.currentTimeMillis();
            if (this.Ne == null) {
                throw new SocketException("network not available.");
            }
            this.Ne.setRequestMethod("POST");
            this.Ne.setDoOutput(true);
            this.Ne.setDoInput(true);
            this.Ne.setConnectTimeout(i2);
            this.Ne.setReadTimeout(i);
            this.Ne.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.mVi.dDT().Od) {
                throw new BdHttpCancelException();
            }
            this.mVi.dDS().d(this.Ne);
            if (this.mVi.dDT().Od) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.dnsTime = new Date().getTime() - time;
            eVar.Ny = -4;
            this.Ne.connect();
            if (this.Nf <= 0) {
                this.Nf = System.currentTimeMillis();
            }
            this.Ng = System.currentTimeMillis();
            eVar.Ny = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.dnsTime;
            if (this.mVi.dDT().Od) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.timerTask, 45000L);
            }
            eVar.Ny = -6;
            this.mVi.dDS().a(this.Ne, boundary, eVar);
            eVar.Ny = -7;
            String contentType = this.Ne.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bU(contentType)) {
                this.Ne.disconnect();
                this.Ne.connect();
                if (this.mVi.dDT().Od) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.mVi.dDT().Od) {
                throw new BdHttpCancelException();
            }
            eVar.Ny = -8;
            this.mVi.dDT().e(this.Ne);
            eVar.Nx = this.mVi.dDT().responseCode;
            eVar.downloadSize = this.Ne.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.Ne);
            if (c != null) {
                eVar.downloadSize += c.length;
                this.mVi.dDT().downSize = c.length;
                this.mVi.dDT().retBytes = d(this.mVi.dDT().contentEncoding, c);
            }
            eVar.Nv = new Date().getTime() - time;
            eVar.Ny = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.f.a.close(this.Ne);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.mVh = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.mVi.dDS().getUrl();
            eVar2.url = url;
            this.Ne = a(a(url, eVar2), i2, i);
            this.Ne.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.mVi.dDT().Od) {
                this.Nh = System.currentTimeMillis();
                com.baidu.adp.lib.f.a.close((InputStream) null);
                com.baidu.adp.lib.f.a.close(this.Ne);
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
                this.mVi.dDS().d(this.Ne);
                this.Ne.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.Ne.connect();
                if (this.Nf <= 0) {
                    this.Nf = System.currentTimeMillis();
                }
                this.Ng = System.currentTimeMillis();
                int responseCode = this.Ne.getResponseCode();
                while (HR(responseCode) && this.mVh <= 5) {
                    this.Ne = a(this.Ne, i2, i);
                    this.mVi.dDS().d(this.Ne);
                    this.Ne.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.Ne.connect();
                    responseCode = this.Ne.getResponseCode();
                }
                this.firstByteReachTime = System.currentTimeMillis();
                this.mVi.dDT().responseCode = responseCode;
                if (isFileSegSuccess()) {
                    if (this.Ne.getContentType() != null && this.Ne.getContentType().contains("text/vnd.wap.wml")) {
                        this.Ne.disconnect();
                        this.mVi.dDT().responseCode = 0;
                        boolean a2 = a(str, jVar, i, i2, z, eVar2, z2);
                        this.Nh = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.Ne);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.Ne.getHeaderField(Headers.CONTENT_RANGE);
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.f.b.toInt(headerField2.substring(indexOf + 1), 0);
                    }
                    int i4 = (i3 == 0 && this.mVi.dDT().responseCode == 200 && (headerField = this.Ne.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.f.b.toInt(headerField, 0) : i3;
                    this.mVi.dDT().contentLength = String.valueOf(i4);
                    eVar2.Nu = url.getBytes().length;
                    eVar2.downloadSize = this.Ne.getHeaderFields().toString().getBytes().length;
                    eVar2.downloadSize += i4;
                    if (this.mVi.dDT().responseCode == 416 || this.mVi.dDT().responseCode == 204) {
                        this.Nh = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.Ne);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    } else if (i4 != 0 && length >= i4) {
                        this.Nh = System.currentTimeMillis();
                        this.Nh = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.Ne);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        inputStream = this.Ne.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i5 = 0;
                            int i6 = i4 > 0 ? i4 / 50 : 0;
                            int i7 = 0;
                            if (jVar != null && length > 0) {
                                jVar.onProgress((int) length, i4);
                            }
                            while (!this.mVi.dDT().Od) {
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
                                this.Nh = System.currentTimeMillis();
                                com.baidu.adp.lib.f.a.close(inputStream);
                                com.baidu.adp.lib.f.a.close(this.Ne);
                                com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            this.Nh = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close(inputStream);
                            com.baidu.adp.lib.f.a.close(this.Ne);
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
        this.mVh++;
        return a2;
    }

    private boolean HR(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean isFileSegSuccess() {
        return this.mVi.dDT().responseCode == 200 || this.mVi.dDT().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.Ny = -1;
        try {
            String url = this.mVi.dDS().getUrl();
            eVar.url = url;
            URL a2 = a(url, eVar);
            if (this.mVi.dDT().Od) {
                throw new BdHttpCancelException();
            }
            eVar.Ny = -2;
            this.Ne = c(a2);
            eVar.Ny = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.Ne == null) {
                throw new SocketException("network not available.");
            }
            this.Ne.setRequestMethod("POST");
            this.Ne.setDoOutput(true);
            this.Ne.setDoInput(true);
            this.Ne.setConnectTimeout(i2);
            this.Ne.setReadTimeout(i);
            this.Ne.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.mVi.dDT().Od) {
                throw new BdHttpCancelException();
            }
            this.mVi.dDS().d(this.Ne);
            if (this.mVi.dDT().Od) {
                throw new BdHttpCancelException();
            }
            eVar.dnsTime = System.currentTimeMillis() - currentTimeMillis;
            eVar.Ny = -4;
            this.Ne.connect();
            if (this.Nf <= 0) {
                this.Nf = System.currentTimeMillis();
            }
            this.Ng = System.currentTimeMillis();
            eVar.Ny = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.dnsTime;
            if (this.mVi.dDT().Od) {
                throw new BdHttpCancelException();
            }
            eVar.Ny = -6;
            this.mVi.dDS().a(this.Ne, eVar);
            eVar.Ny = -7;
            if (this.mVi.dDT().Od) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Ne.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.bU(contentType)) {
                this.Ne.disconnect();
                this.Ne.connect();
                if (this.mVi.dDT().Od) {
                    throw new BdHttpCancelException();
                }
            }
            this.mVi.dDT().e(this.Ne);
            eVar.Ny = -8;
            eVar.Nx = this.mVi.dDT().responseCode;
            eVar.downloadSize = this.Ne.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.Ne);
            if (c != null) {
                eVar.downloadSize += c.length;
                this.mVi.dDT().downSize = c.length;
                this.mVi.dDT().retBytes = d(this.mVi.dDT().contentEncoding, c);
            }
            eVar.Nv = new Date().getTime() - currentTimeMillis;
            eVar.Ny = -9;
        } finally {
            com.baidu.adp.lib.f.a.close(this.Ne);
        }
    }
}
