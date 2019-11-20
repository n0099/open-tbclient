package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
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
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
class b {
    private int iIm;
    private g iIn;
    private HttpURLConnection oe;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int iIl = 5;
    private long of = 0;
    private long og = 0;
    private long firstByteReachTime = 0;
    private long oh = 0;
    private long oi = 0;
    private boolean oj = false;
    private boolean ol = true;
    private TimerTask on = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
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

    public long fA() {
        return this.of;
    }

    public boolean fD() {
        return this.oj;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.iIn = gVar;
    }

    public void cancelNetConnect() {
        this.iIn.cga().oT = true;
        com.baidu.adp.lib.g.a.close(this.oe);
    }

    private URL a(String str, e eVar) throws Exception {
        a cfX;
        URL url = new URL(str);
        if (this.ol && (cfX = a.cfX()) != null) {
            String ag = cfX.ag(str);
            if (!TextUtils.isEmpty(ag)) {
                this.iIn.cfZ().l(HTTP.TARGET_HOST, url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ag));
                this.oj = true;
                eVar.oC = ag;
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
                            this.iIn.cfZ().l("X-Online-Host", url.getHost());
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
        eVar.oA = -1;
        if (this.iIn.cga().oT) {
            throw new BdHttpCancelException();
        }
        String c = this.iIn.cfZ().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.iIn.cga().oT) {
            throw new BdHttpCancelException();
        }
        eVar.oA = -2;
        this.oe = c(a);
        eVar.oA = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.oe == null) {
                throw new SocketException("network not available.");
            }
            this.oe.setRequestMethod("GET");
            this.oe.setConnectTimeout(i2);
            this.oe.setReadTimeout(i);
            this.iIn.cfZ().d(this.oe);
            if (this.iIn.cga().oT) {
                throw new BdHttpCancelException();
            }
            eVar.oy = new Date().getTime() - currentTimeMillis;
            eVar.oA = -4;
            this.oe.connect();
            if (this.of <= 0) {
                this.of = System.currentTimeMillis();
            }
            this.og = System.currentTimeMillis();
            eVar.oA = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.oy;
            if (this.iIn.cga().oT) {
                throw new BdHttpCancelException();
            }
            String contentType = this.oe.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.al(contentType)) {
                this.oe.disconnect();
                this.oe.connect();
                if (this.iIn.cga().oT) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.oA = -8;
            this.iIn.cga().e(this.oe);
            if (c.contains("c.tieba.baidu.com") && (map = this.iIn.cga().oU) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.oE = list.get(0);
                eVar.oF = list.get(1);
            }
            eVar.oz = this.iIn.cga().responseCode;
            eVar.downloadSize = this.oe.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.oe);
            if (c2 != null) {
                eVar.downloadSize += c2.length;
                this.iIn.cga().retBytes = c(this.iIn.cga().contentEncoding, c2);
            }
            eVar.oA = -9;
            eVar.ov = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.oe != null) {
                this.oe.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.oi = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        }
        return bArr;
    }

    private byte[] c(HttpURLConnection httpURLConnection) throws Exception {
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
                while (!this.iIn.cga().oT && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.oh = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.close(inputStream);
                        throw th;
                    }
                }
                if (this.iIn.cga().oT) {
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
        this.oh = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.close(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.oA = -1;
        try {
            String url = this.iIn.cfZ().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.iIn.cga().oT) {
                throw new BdHttpCancelException();
            }
            eVar.oA = -2;
            this.oe = c(a);
            eVar.oA = -3;
            System.currentTimeMillis();
            if (this.oe == null) {
                throw new SocketException("network not available.");
            }
            this.oe.setRequestMethod("POST");
            this.oe.setDoOutput(true);
            this.oe.setDoInput(true);
            this.oe.setConnectTimeout(i2);
            this.oe.setReadTimeout(i);
            this.oe.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.iIn.cga().oT) {
                throw new BdHttpCancelException();
            }
            this.iIn.cfZ().d(this.oe);
            if (this.iIn.cga().oT) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.oy = new Date().getTime() - time;
            eVar.oA = -4;
            this.oe.connect();
            if (this.of <= 0) {
                this.of = System.currentTimeMillis();
            }
            this.og = System.currentTimeMillis();
            eVar.oA = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.oy;
            if (this.iIn.cga().oT) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.on, 45000L);
            }
            eVar.oA = -6;
            this.iIn.cfZ().a(this.oe, boundary, eVar);
            eVar.oA = -7;
            String contentType = this.oe.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.al(contentType)) {
                this.oe.disconnect();
                this.oe.connect();
                if (this.iIn.cga().oT) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.iIn.cga().oT) {
                throw new BdHttpCancelException();
            }
            eVar.oA = -8;
            this.iIn.cga().e(this.oe);
            eVar.oz = this.iIn.cga().responseCode;
            eVar.downloadSize = this.oe.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.oe);
            if (c != null) {
                eVar.downloadSize += c.length;
                this.iIn.cga().downSize = c.length;
                this.iIn.cga().retBytes = c(this.iIn.cga().contentEncoding, c);
            }
            eVar.ov = new Date().getTime() - time;
            eVar.oA = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.g.a.close(this.oe);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.iIm = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.iIn.cfZ().getUrl();
            eVar2.url = url;
            this.oe = a(a(url, eVar2), i2, i);
            this.oe.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.iIn.cga().oT) {
                this.oh = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.close((InputStream) null);
                com.baidu.adp.lib.g.a.close(this.oe);
                com.baidu.adp.lib.g.a.close((OutputStream) null);
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
                this.iIn.cfZ().d(this.oe);
                this.oe.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.oe.connect();
                if (this.of <= 0) {
                    this.of = System.currentTimeMillis();
                }
                this.og = System.currentTimeMillis();
                int responseCode = this.oe.getResponseCode();
                while (yj(responseCode) && this.iIm <= 5) {
                    this.oe = a(this.oe, i2, i);
                    this.iIn.cfZ().d(this.oe);
                    this.oe.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.oe.connect();
                    responseCode = this.oe.getResponseCode();
                }
                this.firstByteReachTime = System.currentTimeMillis();
                this.iIn.cga().responseCode = responseCode;
                if (isFileSegSuccess()) {
                    if (this.oe.getContentType() != null && this.oe.getContentType().contains("text/vnd.wap.wml")) {
                        this.oe.disconnect();
                        this.iIn.cga().responseCode = 0;
                        boolean a = a(str, jVar, i, i2, z, eVar2, z2);
                        this.oh = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.close((InputStream) null);
                        com.baidu.adp.lib.g.a.close(this.oe);
                        com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.oe.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.toInt(headerField2.substring(indexOf + 1), 0);
                    }
                    int i4 = (i3 == 0 && this.iIn.cga().responseCode == 200 && (headerField = this.oe.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.toInt(headerField, 0) : i3;
                    this.iIn.cga().contentLength = String.valueOf(i4);
                    eVar2.ou = url.getBytes().length;
                    eVar2.downloadSize = this.oe.getHeaderFields().toString().getBytes().length;
                    eVar2.downloadSize += i4;
                    if (this.iIn.cga().responseCode == 416 || this.iIn.cga().responseCode == 204) {
                        this.oh = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.close((InputStream) null);
                        com.baidu.adp.lib.g.a.close(this.oe);
                        com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream2);
                        return true;
                    } else if (i4 != 0 && length >= i4) {
                        this.oh = System.currentTimeMillis();
                        this.oh = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.close((InputStream) null);
                        com.baidu.adp.lib.g.a.close(this.oe);
                        com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.oe.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i5 = 0;
                            int i6 = i4 > 0 ? i4 / 50 : 0;
                            int i7 = 0;
                            if (jVar != null && length > 0) {
                                jVar.h((int) length, i4);
                            }
                            while (!this.iIn.cga().oT) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i5 += read;
                                        i7 += read;
                                        if (jVar != null && (i7 > i6 || i5 == i4)) {
                                            i7 = 0;
                                            jVar.h((int) (i5 + length), i4);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i5) + length >= ((long) i4);
                                this.oh = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.close(inputStream2);
                                com.baidu.adp.lib.g.a.close(this.oe);
                                com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.oh = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.close(inputStream);
                            com.baidu.adp.lib.g.a.close(this.oe);
                            com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream);
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
        URL url = httpURLConnection.getURL().toURI().resolve(httpURLConnection.getHeaderField("Location")).toURL();
        com.baidu.adp.lib.g.a.close(httpURLConnection);
        HttpURLConnection a = a(url, i, i2);
        this.iIm++;
        return a;
    }

    private boolean yj(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean isFileSegSuccess() {
        return this.iIn.cga().responseCode == 200 || this.iIn.cga().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.oA = -1;
        try {
            String url = this.iIn.cfZ().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.iIn.cga().oT) {
                throw new BdHttpCancelException();
            }
            eVar.oA = -2;
            this.oe = c(a);
            eVar.oA = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.oe == null) {
                throw new SocketException("network not available.");
            }
            this.oe.setRequestMethod("POST");
            this.oe.setDoOutput(true);
            this.oe.setDoInput(true);
            this.oe.setConnectTimeout(i2);
            this.oe.setReadTimeout(i);
            this.oe.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.iIn.cga().oT) {
                throw new BdHttpCancelException();
            }
            this.iIn.cfZ().d(this.oe);
            if (this.iIn.cga().oT) {
                throw new BdHttpCancelException();
            }
            eVar.oy = System.currentTimeMillis() - currentTimeMillis;
            eVar.oA = -4;
            this.oe.connect();
            if (this.of <= 0) {
                this.of = System.currentTimeMillis();
            }
            this.og = System.currentTimeMillis();
            eVar.oA = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.oy;
            if (this.iIn.cga().oT) {
                throw new BdHttpCancelException();
            }
            eVar.oA = -6;
            this.iIn.cfZ().a(this.oe, eVar);
            eVar.oA = -7;
            if (this.iIn.cga().oT) {
                throw new BdHttpCancelException();
            }
            String contentType = this.oe.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.al(contentType)) {
                this.oe.disconnect();
                this.oe.connect();
                if (this.iIn.cga().oT) {
                    throw new BdHttpCancelException();
                }
            }
            this.iIn.cga().e(this.oe);
            eVar.oA = -8;
            eVar.oz = this.iIn.cga().responseCode;
            eVar.downloadSize = this.oe.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.oe);
            if (c != null) {
                eVar.downloadSize += c.length;
                this.iIn.cga().downSize = c.length;
                this.iIn.cga().retBytes = c(this.iIn.cga().contentEncoding, c);
            }
            eVar.ov = new Date().getTime() - currentTimeMillis;
            eVar.oA = -9;
        } finally {
            com.baidu.adp.lib.g.a.close(this.oe);
        }
    }
}
