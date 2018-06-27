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
    private int goa;
    private g gob;
    private HttpURLConnection zq;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int gnZ = 5;
    private long zr = 0;
    private long zs = 0;
    private long tr = 0;
    private long zt = 0;
    private long zu = 0;
    private boolean zv = false;
    private boolean zw = true;
    private TimerTask zx = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.hN();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer zy = new Timer();

    public long hJ() {
        return this.zr;
    }

    public boolean hM() {
        return this.zv;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.gob = gVar;
    }

    public void hN() {
        this.gob.bpa().zY = true;
        com.baidu.adp.lib.g.a.f(this.zq);
    }

    private URL a(String str, e eVar) throws Exception {
        a boX;
        URL url = new URL(str);
        if (this.zw && (boX = a.boX()) != null) {
            String ax = boX.ax(str);
            if (!TextUtils.isEmpty(ax)) {
                this.gob.boZ().q("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ax));
                this.zv = true;
                eVar.zM = ax;
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
        String jN;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.baidu.adp.lib.util.j.jD()) {
                if (com.baidu.adp.lib.util.j.jF() && (jN = com.baidu.adp.lib.util.j.jN()) != null && jN.length() > 0) {
                    if (com.baidu.adp.lib.util.j.bd(jN) && com.baidu.adp.lib.util.j.jP()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(jN);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.gob.boZ().q("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(jN, com.baidu.adp.lib.util.j.jO())));
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
        eVar.zK = -1;
        if (this.gob.bpa().zY) {
            throw new BdHttpCancelException();
        }
        String c = this.gob.boZ().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.gob.bpa().zY) {
            throw new BdHttpCancelException();
        }
        eVar.zK = -2;
        this.zq = c(a);
        eVar.zK = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.zq == null) {
                throw new SocketException("network not available.");
            }
            this.zq.setRequestMethod("GET");
            this.zq.setConnectTimeout(i2);
            this.zq.setReadTimeout(i);
            this.gob.boZ().d(this.zq);
            if (this.gob.bpa().zY) {
                throw new BdHttpCancelException();
            }
            eVar.zH = new Date().getTime() - currentTimeMillis;
            eVar.zK = -4;
            this.zq.connect();
            if (this.zr <= 0) {
                this.zr = System.currentTimeMillis();
            }
            this.zs = System.currentTimeMillis();
            eVar.zK = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.zH;
            if (this.gob.bpa().zY) {
                throw new BdHttpCancelException();
            }
            String contentType = this.zq.getContentType();
            this.tr = System.currentTimeMillis();
            if (f.aD(contentType)) {
                this.zq.disconnect();
                this.zq.connect();
                if (this.gob.bpa().zY) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.zK = -8;
            this.gob.bpa().e(this.zq);
            if (c.contains("c.tieba.baidu.com") && (map = this.gob.bpa().Aa) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.zN = list.get(0);
                eVar.zO = list.get(1);
            }
            eVar.zJ = this.gob.bpa().responseCode;
            eVar.zD = this.zq.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.zq);
            if (c2 != null) {
                eVar.zD += c2.length;
                this.gob.bpa().Ab = c(this.gob.bpa().contentEncoding, c2);
            }
            eVar.zK = -9;
            eVar.zE = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.zq != null) {
                this.zq.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.zu = System.currentTimeMillis();
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
                while (!this.gob.bpa().zY && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.zt = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.f(inputStream);
                        throw th;
                    }
                }
                if (this.gob.bpa().zY) {
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
        this.zt = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.f(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.zK = -1;
        try {
            String url = this.gob.boZ().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gob.bpa().zY) {
                throw new BdHttpCancelException();
            }
            eVar.zK = -2;
            this.zq = c(a);
            eVar.zK = -3;
            System.currentTimeMillis();
            if (this.zq == null) {
                throw new SocketException("network not available.");
            }
            this.zq.setRequestMethod("POST");
            this.zq.setDoOutput(true);
            this.zq.setDoInput(true);
            this.zq.setConnectTimeout(i2);
            this.zq.setReadTimeout(i);
            this.zq.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.gob.bpa().zY) {
                throw new BdHttpCancelException();
            }
            this.gob.boZ().d(this.zq);
            if (this.gob.bpa().zY) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.zH = new Date().getTime() - time;
            eVar.zK = -4;
            this.zq.connect();
            if (this.zr <= 0) {
                this.zr = System.currentTimeMillis();
            }
            this.zs = System.currentTimeMillis();
            eVar.zK = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.zH;
            if (this.gob.bpa().zY) {
                throw new BdHttpCancelException();
            }
            if (this.zy != null) {
                this.zy.schedule(this.zx, 45000L);
            }
            eVar.zK = -6;
            this.gob.boZ().a(this.zq, boundary, eVar);
            eVar.zK = -7;
            String contentType = this.zq.getContentType();
            this.tr = System.currentTimeMillis();
            if (f.aD(contentType)) {
                this.zq.disconnect();
                this.zq.connect();
                if (this.gob.bpa().zY) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.gob.bpa().zY) {
                throw new BdHttpCancelException();
            }
            eVar.zK = -8;
            this.gob.bpa().e(this.zq);
            eVar.zJ = this.gob.bpa().responseCode;
            eVar.zD = this.zq.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.zq);
            if (c != null) {
                eVar.zD += c.length;
                this.gob.bpa().Ac = c.length;
                this.gob.bpa().Ab = c(this.gob.bpa().contentEncoding, c);
            }
            eVar.zE = new Date().getTime() - time;
            eVar.zK = -9;
        } finally {
            if (this.zy != null) {
                this.zy.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.zq);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.goa = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.gob.boZ().getUrl();
            eVar2.url = url;
            this.zq = a(a(url, eVar2), i2, i);
            this.zq.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.gob.bpa().zY) {
                this.zt = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.f((InputStream) null);
                com.baidu.adp.lib.g.a.f(this.zq);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.aX(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.aV(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.gob.boZ().d(this.zq);
                this.zq.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.zq.connect();
                if (this.zr <= 0) {
                    this.zr = System.currentTimeMillis();
                }
                this.zs = System.currentTimeMillis();
                int responseCode = this.zq.getResponseCode();
                while (si(responseCode) && this.goa <= 5) {
                    this.zq = a(this.zq, i2, i);
                    this.gob.boZ().d(this.zq);
                    this.zq.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.zq.connect();
                    responseCode = this.zq.getResponseCode();
                }
                this.tr = System.currentTimeMillis();
                this.gob.bpa().responseCode = responseCode;
                if (hO()) {
                    if (this.zq.getContentType() != null && this.zq.getContentType().contains("text/vnd.wap.wml")) {
                        this.zq.disconnect();
                        this.gob.bpa().responseCode = 0;
                        boolean a = a(str, jVar, i, i2, z, eVar2, z2);
                        this.zt = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zq);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.zq.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.gob.bpa().responseCode == 200 && (headerField = this.zq.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.gob.bpa().contentLength = String.valueOf(g);
                    eVar2.zC = url.getBytes().length;
                    eVar2.zD = this.zq.getHeaderFields().toString().getBytes().length;
                    eVar2.zD += g;
                    if (this.gob.bpa().responseCode == 416 || this.gob.bpa().responseCode == 204) {
                        this.zt = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zq);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.zt = System.currentTimeMillis();
                        this.zt = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zq);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.zq.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (jVar != null && length > 0) {
                                jVar.m((int) length, g);
                            }
                            while (!this.gob.bpa().zY) {
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
                                this.zt = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.f(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.zq);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.zt = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.f(inputStream);
                            com.baidu.adp.lib.g.a.f(this.zq);
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
        this.goa++;
        return a;
    }

    private boolean si(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean hO() {
        return this.gob.bpa().responseCode == 200 || this.gob.bpa().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.zK = -1;
        try {
            String url = this.gob.boZ().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gob.bpa().zY) {
                throw new BdHttpCancelException();
            }
            eVar.zK = -2;
            this.zq = c(a);
            eVar.zK = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.zq == null) {
                throw new SocketException("network not available.");
            }
            this.zq.setRequestMethod("POST");
            this.zq.setDoOutput(true);
            this.zq.setDoInput(true);
            this.zq.setConnectTimeout(i2);
            this.zq.setReadTimeout(i);
            this.zq.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.gob.bpa().zY) {
                throw new BdHttpCancelException();
            }
            this.gob.boZ().d(this.zq);
            if (this.gob.bpa().zY) {
                throw new BdHttpCancelException();
            }
            eVar.zH = System.currentTimeMillis() - currentTimeMillis;
            eVar.zK = -4;
            this.zq.connect();
            if (this.zr <= 0) {
                this.zr = System.currentTimeMillis();
            }
            this.zs = System.currentTimeMillis();
            eVar.zK = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.zH;
            if (this.gob.bpa().zY) {
                throw new BdHttpCancelException();
            }
            eVar.zK = -6;
            this.gob.boZ().a(this.zq, eVar);
            eVar.zK = -7;
            if (this.gob.bpa().zY) {
                throw new BdHttpCancelException();
            }
            String contentType = this.zq.getContentType();
            this.tr = System.currentTimeMillis();
            if (f.aD(contentType)) {
                this.zq.disconnect();
                this.zq.connect();
                if (this.gob.bpa().zY) {
                    throw new BdHttpCancelException();
                }
            }
            this.gob.bpa().e(this.zq);
            eVar.zK = -8;
            eVar.zJ = this.gob.bpa().responseCode;
            eVar.zD = this.zq.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.zq);
            if (c != null) {
                eVar.zD += c.length;
                this.gob.bpa().Ac = c.length;
                this.gob.bpa().Ab = c(this.gob.bpa().contentEncoding, c);
            }
            eVar.zE = new Date().getTime() - currentTimeMillis;
            eVar.zK = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.zq);
        }
    }
}
