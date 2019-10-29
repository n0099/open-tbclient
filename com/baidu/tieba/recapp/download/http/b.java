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
    private int iJd;
    private g iJe;
    private HttpURLConnection oG;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int iJc = 5;
    private long oH = 0;
    private long oI = 0;
    private long firstByteReachTime = 0;
    private long oJ = 0;
    private long oK = 0;
    private boolean oL = false;
    private boolean oM = true;
    private TimerTask oO = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
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
        return this.oH;
    }

    public boolean fD() {
        return this.oL;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.iJe = gVar;
    }

    public void cancelNetConnect() {
        this.iJe.cgc().pz = true;
        com.baidu.adp.lib.g.a.close(this.oG);
    }

    private URL a(String str, e eVar) throws Exception {
        a cfZ;
        URL url = new URL(str);
        if (this.oM && (cfZ = a.cfZ()) != null) {
            String ag = cfZ.ag(str);
            if (!TextUtils.isEmpty(ag)) {
                this.iJe.cgb().l(HTTP.TARGET_HOST, url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ag));
                this.oL = true;
                eVar.pd = ag;
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
                            this.iJe.cgb().l("X-Online-Host", url.getHost());
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
        eVar.oZ = -1;
        if (this.iJe.cgc().pz) {
            throw new BdHttpCancelException();
        }
        String c = this.iJe.cgb().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.iJe.cgc().pz) {
            throw new BdHttpCancelException();
        }
        eVar.oZ = -2;
        this.oG = c(a);
        eVar.oZ = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.oG == null) {
                throw new SocketException("network not available.");
            }
            this.oG.setRequestMethod("GET");
            this.oG.setConnectTimeout(i2);
            this.oG.setReadTimeout(i);
            this.iJe.cgb().d(this.oG);
            if (this.iJe.cgc().pz) {
                throw new BdHttpCancelException();
            }
            eVar.oX = new Date().getTime() - currentTimeMillis;
            eVar.oZ = -4;
            this.oG.connect();
            if (this.oH <= 0) {
                this.oH = System.currentTimeMillis();
            }
            this.oI = System.currentTimeMillis();
            eVar.oZ = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.oX;
            if (this.iJe.cgc().pz) {
                throw new BdHttpCancelException();
            }
            String contentType = this.oG.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.al(contentType)) {
                this.oG.disconnect();
                this.oG.connect();
                if (this.iJe.cgc().pz) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.oZ = -8;
            this.iJe.cgc().e(this.oG);
            if (c.contains("c.tieba.baidu.com") && (map = this.iJe.cgc().pA) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.pf = list.get(0);
                eVar.pg = list.get(1);
            }
            eVar.oY = this.iJe.cgc().responseCode;
            eVar.downloadSize = this.oG.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.oG);
            if (c2 != null) {
                eVar.downloadSize += c2.length;
                this.iJe.cgc().retBytes = c(this.iJe.cgc().contentEncoding, c2);
            }
            eVar.oZ = -9;
            eVar.oU = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.oG != null) {
                this.oG.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.oK = System.currentTimeMillis();
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
                while (!this.iJe.cgc().pz && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.oJ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.close(inputStream);
                        throw th;
                    }
                }
                if (this.iJe.cgc().pz) {
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
        this.oJ = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.close(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.oZ = -1;
        try {
            String url = this.iJe.cgb().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.iJe.cgc().pz) {
                throw new BdHttpCancelException();
            }
            eVar.oZ = -2;
            this.oG = c(a);
            eVar.oZ = -3;
            System.currentTimeMillis();
            if (this.oG == null) {
                throw new SocketException("network not available.");
            }
            this.oG.setRequestMethod("POST");
            this.oG.setDoOutput(true);
            this.oG.setDoInput(true);
            this.oG.setConnectTimeout(i2);
            this.oG.setReadTimeout(i);
            this.oG.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.iJe.cgc().pz) {
                throw new BdHttpCancelException();
            }
            this.iJe.cgb().d(this.oG);
            if (this.iJe.cgc().pz) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.oX = new Date().getTime() - time;
            eVar.oZ = -4;
            this.oG.connect();
            if (this.oH <= 0) {
                this.oH = System.currentTimeMillis();
            }
            this.oI = System.currentTimeMillis();
            eVar.oZ = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.oX;
            if (this.iJe.cgc().pz) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.oO, 45000L);
            }
            eVar.oZ = -6;
            this.iJe.cgb().a(this.oG, boundary, eVar);
            eVar.oZ = -7;
            String contentType = this.oG.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.al(contentType)) {
                this.oG.disconnect();
                this.oG.connect();
                if (this.iJe.cgc().pz) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.iJe.cgc().pz) {
                throw new BdHttpCancelException();
            }
            eVar.oZ = -8;
            this.iJe.cgc().e(this.oG);
            eVar.oY = this.iJe.cgc().responseCode;
            eVar.downloadSize = this.oG.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.oG);
            if (c != null) {
                eVar.downloadSize += c.length;
                this.iJe.cgc().downSize = c.length;
                this.iJe.cgc().retBytes = c(this.iJe.cgc().contentEncoding, c);
            }
            eVar.oU = new Date().getTime() - time;
            eVar.oZ = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.g.a.close(this.oG);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.iJd = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.iJe.cgb().getUrl();
            eVar2.url = url;
            this.oG = a(a(url, eVar2), i2, i);
            this.oG.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.iJe.cgc().pz) {
                this.oJ = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.close((InputStream) null);
                com.baidu.adp.lib.g.a.close(this.oG);
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
                this.iJe.cgb().d(this.oG);
                this.oG.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.oG.connect();
                if (this.oH <= 0) {
                    this.oH = System.currentTimeMillis();
                }
                this.oI = System.currentTimeMillis();
                int responseCode = this.oG.getResponseCode();
                while (yk(responseCode) && this.iJd <= 5) {
                    this.oG = a(this.oG, i2, i);
                    this.iJe.cgb().d(this.oG);
                    this.oG.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.oG.connect();
                    responseCode = this.oG.getResponseCode();
                }
                this.firstByteReachTime = System.currentTimeMillis();
                this.iJe.cgc().responseCode = responseCode;
                if (isFileSegSuccess()) {
                    if (this.oG.getContentType() != null && this.oG.getContentType().contains("text/vnd.wap.wml")) {
                        this.oG.disconnect();
                        this.iJe.cgc().responseCode = 0;
                        boolean a = a(str, jVar, i, i2, z, eVar2, z2);
                        this.oJ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.close((InputStream) null);
                        com.baidu.adp.lib.g.a.close(this.oG);
                        com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.oG.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.toInt(headerField2.substring(indexOf + 1), 0);
                    }
                    int i4 = (i3 == 0 && this.iJe.cgc().responseCode == 200 && (headerField = this.oG.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.toInt(headerField, 0) : i3;
                    this.iJe.cgc().contentLength = String.valueOf(i4);
                    eVar2.oT = url.getBytes().length;
                    eVar2.downloadSize = this.oG.getHeaderFields().toString().getBytes().length;
                    eVar2.downloadSize += i4;
                    if (this.iJe.cgc().responseCode == 416 || this.iJe.cgc().responseCode == 204) {
                        this.oJ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.close((InputStream) null);
                        com.baidu.adp.lib.g.a.close(this.oG);
                        com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream2);
                        return true;
                    } else if (i4 != 0 && length >= i4) {
                        this.oJ = System.currentTimeMillis();
                        this.oJ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.close((InputStream) null);
                        com.baidu.adp.lib.g.a.close(this.oG);
                        com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.oG.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i5 = 0;
                            int i6 = i4 > 0 ? i4 / 50 : 0;
                            int i7 = 0;
                            if (jVar != null && length > 0) {
                                jVar.j((int) length, i4);
                            }
                            while (!this.iJe.cgc().pz) {
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
                                this.oJ = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.close(inputStream2);
                                com.baidu.adp.lib.g.a.close(this.oG);
                                com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.oJ = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.close(inputStream);
                            com.baidu.adp.lib.g.a.close(this.oG);
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
        this.iJd++;
        return a;
    }

    private boolean yk(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean isFileSegSuccess() {
        return this.iJe.cgc().responseCode == 200 || this.iJe.cgc().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.oZ = -1;
        try {
            String url = this.iJe.cgb().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.iJe.cgc().pz) {
                throw new BdHttpCancelException();
            }
            eVar.oZ = -2;
            this.oG = c(a);
            eVar.oZ = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.oG == null) {
                throw new SocketException("network not available.");
            }
            this.oG.setRequestMethod("POST");
            this.oG.setDoOutput(true);
            this.oG.setDoInput(true);
            this.oG.setConnectTimeout(i2);
            this.oG.setReadTimeout(i);
            this.oG.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.iJe.cgc().pz) {
                throw new BdHttpCancelException();
            }
            this.iJe.cgb().d(this.oG);
            if (this.iJe.cgc().pz) {
                throw new BdHttpCancelException();
            }
            eVar.oX = System.currentTimeMillis() - currentTimeMillis;
            eVar.oZ = -4;
            this.oG.connect();
            if (this.oH <= 0) {
                this.oH = System.currentTimeMillis();
            }
            this.oI = System.currentTimeMillis();
            eVar.oZ = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.oX;
            if (this.iJe.cgc().pz) {
                throw new BdHttpCancelException();
            }
            eVar.oZ = -6;
            this.iJe.cgb().a(this.oG, eVar);
            eVar.oZ = -7;
            if (this.iJe.cgc().pz) {
                throw new BdHttpCancelException();
            }
            String contentType = this.oG.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (f.al(contentType)) {
                this.oG.disconnect();
                this.oG.connect();
                if (this.iJe.cgc().pz) {
                    throw new BdHttpCancelException();
                }
            }
            this.iJe.cgc().e(this.oG);
            eVar.oZ = -8;
            eVar.oY = this.iJe.cgc().responseCode;
            eVar.downloadSize = this.oG.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.oG);
            if (c != null) {
                eVar.downloadSize += c.length;
                this.iJe.cgc().downSize = c.length;
                this.iJe.cgc().retBytes = c(this.iJe.cgc().contentEncoding, c);
            }
            eVar.oU = new Date().getTime() - currentTimeMillis;
            eVar.oZ = -9;
        } finally {
            com.baidu.adp.lib.g.a.close(this.oG);
        }
    }
}
