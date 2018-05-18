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
    private int fYR;
    private g fYS;
    private HttpURLConnection tj;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int fYQ = 5;
    private long tk = 0;
    private long tl = 0;
    private long mW = 0;
    private long tm = 0;
    private long tp = 0;
    private boolean tq = false;
    private boolean tr = true;
    private TimerTask ts = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.eW();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer tt = new Timer();

    public long eS() {
        return this.tk;
    }

    public boolean eV() {
        return this.tq;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.fYS = gVar;
    }

    public void eW() {
        this.fYS.bjA().tV = true;
        com.baidu.adp.lib.g.a.f(this.tj);
    }

    private URL a(String str, e eVar) throws Exception {
        a bjx;
        URL url = new URL(str);
        if (this.tr && (bjx = a.bjx()) != null) {
            String al = bjx.al(str);
            if (!TextUtils.isEmpty(al)) {
                this.fYS.bjz().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + al));
                this.tq = true;
                eVar.tJ = al;
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
        String gZ;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.baidu.adp.lib.util.j.gP()) {
                if (com.baidu.adp.lib.util.j.gR() && (gZ = com.baidu.adp.lib.util.j.gZ()) != null && gZ.length() > 0) {
                    if (com.baidu.adp.lib.util.j.aP(gZ) && com.baidu.adp.lib.util.j.hb()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(gZ);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.fYS.bjz().o("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(gZ, com.baidu.adp.lib.util.j.ha())));
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
        eVar.tH = -1;
        if (this.fYS.bjA().tV) {
            throw new BdHttpCancelException();
        }
        String c = this.fYS.bjz().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.fYS.bjA().tV) {
            throw new BdHttpCancelException();
        }
        eVar.tH = -2;
        this.tj = c(a);
        eVar.tH = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.tj == null) {
                throw new SocketException("network not available.");
            }
            this.tj.setRequestMethod("GET");
            this.tj.setConnectTimeout(i2);
            this.tj.setReadTimeout(i);
            this.fYS.bjz().d(this.tj);
            if (this.fYS.bjA().tV) {
                throw new BdHttpCancelException();
            }
            eVar.tE = new Date().getTime() - currentTimeMillis;
            eVar.tH = -4;
            this.tj.connect();
            if (this.tk <= 0) {
                this.tk = System.currentTimeMillis();
            }
            this.tl = System.currentTimeMillis();
            eVar.tH = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.tE;
            if (this.fYS.bjA().tV) {
                throw new BdHttpCancelException();
            }
            String contentType = this.tj.getContentType();
            this.mW = System.currentTimeMillis();
            if (f.ap(contentType)) {
                this.tj.disconnect();
                this.tj.connect();
                if (this.fYS.bjA().tV) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.tH = -8;
            this.fYS.bjA().e(this.tj);
            if (c.contains("c.tieba.baidu.com") && (map = this.fYS.bjA().tX) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.tK = list.get(0);
                eVar.tL = list.get(1);
            }
            eVar.tG = this.fYS.bjA().responseCode;
            eVar.tA = this.tj.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.tj);
            if (c2 != null) {
                eVar.tA += c2.length;
                this.fYS.bjA().tY = c(this.fYS.bjA().contentEncoding, c2);
            }
            eVar.tH = -9;
            eVar.tB = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.tj != null) {
                this.tj.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.tp = System.currentTimeMillis();
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
                while (!this.fYS.bjA().tV && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.tm = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.d(inputStream);
                        throw th;
                    }
                }
                if (this.fYS.bjA().tV) {
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
        this.tm = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.d(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.tH = -1;
        try {
            String url = this.fYS.bjz().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.fYS.bjA().tV) {
                throw new BdHttpCancelException();
            }
            eVar.tH = -2;
            this.tj = c(a);
            eVar.tH = -3;
            System.currentTimeMillis();
            if (this.tj == null) {
                throw new SocketException("network not available.");
            }
            this.tj.setRequestMethod("POST");
            this.tj.setDoOutput(true);
            this.tj.setDoInput(true);
            this.tj.setConnectTimeout(i2);
            this.tj.setReadTimeout(i);
            this.tj.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.fYS.bjA().tV) {
                throw new BdHttpCancelException();
            }
            this.fYS.bjz().d(this.tj);
            if (this.fYS.bjA().tV) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.tE = new Date().getTime() - time;
            eVar.tH = -4;
            this.tj.connect();
            if (this.tk <= 0) {
                this.tk = System.currentTimeMillis();
            }
            this.tl = System.currentTimeMillis();
            eVar.tH = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.tE;
            if (this.fYS.bjA().tV) {
                throw new BdHttpCancelException();
            }
            if (this.tt != null) {
                this.tt.schedule(this.ts, 45000L);
            }
            eVar.tH = -6;
            this.fYS.bjz().a(this.tj, boundary, eVar);
            eVar.tH = -7;
            String contentType = this.tj.getContentType();
            this.mW = System.currentTimeMillis();
            if (f.ap(contentType)) {
                this.tj.disconnect();
                this.tj.connect();
                if (this.fYS.bjA().tV) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.fYS.bjA().tV) {
                throw new BdHttpCancelException();
            }
            eVar.tH = -8;
            this.fYS.bjA().e(this.tj);
            eVar.tG = this.fYS.bjA().responseCode;
            eVar.tA = this.tj.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.tj);
            if (c != null) {
                eVar.tA += c.length;
                this.fYS.bjA().tZ = c.length;
                this.fYS.bjA().tY = c(this.fYS.bjA().contentEncoding, c);
            }
            eVar.tB = new Date().getTime() - time;
            eVar.tH = -9;
        } finally {
            if (this.tt != null) {
                this.tt.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.tj);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.fYR = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.fYS.bjz().getUrl();
            eVar2.url = url;
            this.tj = a(a(url, eVar2), i2, i);
            this.tj.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.fYS.bjA().tV) {
                this.tm = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.f(this.tj);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.aJ(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.aH(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.fYS.bjz().d(this.tj);
                this.tj.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.tj.connect();
                if (this.tk <= 0) {
                    this.tk = System.currentTimeMillis();
                }
                this.tl = System.currentTimeMillis();
                int responseCode = this.tj.getResponseCode();
                while (rM(responseCode) && this.fYR <= 5) {
                    this.tj = a(this.tj, i2, i);
                    this.fYS.bjz().d(this.tj);
                    this.tj.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.tj.connect();
                    responseCode = this.tj.getResponseCode();
                }
                this.mW = System.currentTimeMillis();
                this.fYS.bjA().responseCode = responseCode;
                if (eX()) {
                    if (this.tj.getContentType() != null && this.tj.getContentType().contains("text/vnd.wap.wml")) {
                        this.tj.disconnect();
                        this.fYS.bjA().responseCode = 0;
                        boolean a = a(str, jVar, i, i2, z, eVar2, z2);
                        this.tm = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.tj);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.tj.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.fYS.bjA().responseCode == 200 && (headerField = this.tj.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.fYS.bjA().contentLength = String.valueOf(g);
                    eVar2.tz = url.getBytes().length;
                    eVar2.tA = this.tj.getHeaderFields().toString().getBytes().length;
                    eVar2.tA += g;
                    if (this.fYS.bjA().responseCode == 416 || this.fYS.bjA().responseCode == 204) {
                        this.tm = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.tj);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.tm = System.currentTimeMillis();
                        this.tm = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.tj);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.tj.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (jVar != null && length > 0) {
                                jVar.m((int) length, g);
                            }
                            while (!this.fYS.bjA().tV) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i4 += read;
                                        i6 += read;
                                        if (jVar != null && (i6 > i5 || i4 == g)) {
                                            i6 = 0;
                                            jVar.m((int) (i4 + length), g);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i4) + length >= ((long) g);
                                this.tm = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.d(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.tj);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.tm = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.d(inputStream);
                            com.baidu.adp.lib.g.a.f(this.tj);
                            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
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
        httpURLConnection.getResponseCode();
        URL url = httpURLConnection.getURL().toURI().resolve(httpURLConnection.getHeaderField("Location")).toURL();
        com.baidu.adp.lib.g.a.f(httpURLConnection);
        HttpURLConnection a = a(url, i, i2);
        this.fYR++;
        return a;
    }

    private boolean rM(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean eX() {
        return this.fYS.bjA().responseCode == 200 || this.fYS.bjA().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.tH = -1;
        try {
            String url = this.fYS.bjz().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.fYS.bjA().tV) {
                throw new BdHttpCancelException();
            }
            eVar.tH = -2;
            this.tj = c(a);
            eVar.tH = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.tj == null) {
                throw new SocketException("network not available.");
            }
            this.tj.setRequestMethod("POST");
            this.tj.setDoOutput(true);
            this.tj.setDoInput(true);
            this.tj.setConnectTimeout(i2);
            this.tj.setReadTimeout(i);
            this.tj.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.fYS.bjA().tV) {
                throw new BdHttpCancelException();
            }
            this.fYS.bjz().d(this.tj);
            if (this.fYS.bjA().tV) {
                throw new BdHttpCancelException();
            }
            eVar.tE = System.currentTimeMillis() - currentTimeMillis;
            eVar.tH = -4;
            this.tj.connect();
            if (this.tk <= 0) {
                this.tk = System.currentTimeMillis();
            }
            this.tl = System.currentTimeMillis();
            eVar.tH = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.tE;
            if (this.fYS.bjA().tV) {
                throw new BdHttpCancelException();
            }
            eVar.tH = -6;
            this.fYS.bjz().a(this.tj, eVar);
            eVar.tH = -7;
            if (this.fYS.bjA().tV) {
                throw new BdHttpCancelException();
            }
            String contentType = this.tj.getContentType();
            this.mW = System.currentTimeMillis();
            if (f.ap(contentType)) {
                this.tj.disconnect();
                this.tj.connect();
                if (this.fYS.bjA().tV) {
                    throw new BdHttpCancelException();
                }
            }
            this.fYS.bjA().e(this.tj);
            eVar.tH = -8;
            eVar.tG = this.fYS.bjA().responseCode;
            eVar.tA = this.tj.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.tj);
            if (c != null) {
                eVar.tA += c.length;
                this.fYS.bjA().tZ = c.length;
                this.fYS.bjA().tY = c(this.fYS.bjA().contentEncoding, c);
            }
            eVar.tB = new Date().getTime() - currentTimeMillis;
            eVar.tH = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.tj);
        }
    }
}
