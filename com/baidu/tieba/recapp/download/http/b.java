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
    private int gpk;
    private g gpl;
    private HttpURLConnection zl;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int gpj = 5;
    private long zm = 0;
    private long zn = 0;
    private long th = 0;
    private long zo = 0;
    private long zp = 0;
    private boolean zq = false;
    private boolean zr = true;
    private TimerTask zs = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.hN();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer zt = new Timer();

    public long hJ() {
        return this.zm;
    }

    public boolean hM() {
        return this.zq;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.gpl = gVar;
    }

    public void hN() {
        this.gpl.bnE().zT = true;
        com.baidu.adp.lib.g.a.f(this.zl);
    }

    private URL a(String str, e eVar) throws Exception {
        a bnB;
        URL url = new URL(str);
        if (this.zr && (bnB = a.bnB()) != null) {
            String ay = bnB.ay(str);
            if (!TextUtils.isEmpty(ay)) {
                this.gpl.bnD().p("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ay));
                this.zq = true;
                eVar.zH = ay;
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
        String jO;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.baidu.adp.lib.util.j.jE()) {
                if (com.baidu.adp.lib.util.j.jG() && (jO = com.baidu.adp.lib.util.j.jO()) != null && jO.length() > 0) {
                    if (com.baidu.adp.lib.util.j.be(jO) && com.baidu.adp.lib.util.j.jQ()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(jO);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.gpl.bnD().p("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(jO, com.baidu.adp.lib.util.j.jP())));
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
        eVar.zF = -1;
        if (this.gpl.bnE().zT) {
            throw new BdHttpCancelException();
        }
        String c = this.gpl.bnD().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.gpl.bnE().zT) {
            throw new BdHttpCancelException();
        }
        eVar.zF = -2;
        this.zl = c(a);
        eVar.zF = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.zl == null) {
                throw new SocketException("network not available.");
            }
            this.zl.setRequestMethod("GET");
            this.zl.setConnectTimeout(i2);
            this.zl.setReadTimeout(i);
            this.gpl.bnD().d(this.zl);
            if (this.gpl.bnE().zT) {
                throw new BdHttpCancelException();
            }
            eVar.zC = new Date().getTime() - currentTimeMillis;
            eVar.zF = -4;
            this.zl.connect();
            if (this.zm <= 0) {
                this.zm = System.currentTimeMillis();
            }
            this.zn = System.currentTimeMillis();
            eVar.zF = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.zC;
            if (this.gpl.bnE().zT) {
                throw new BdHttpCancelException();
            }
            String contentType = this.zl.getContentType();
            this.th = System.currentTimeMillis();
            if (f.aE(contentType)) {
                this.zl.disconnect();
                this.zl.connect();
                if (this.gpl.bnE().zT) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.zF = -8;
            this.gpl.bnE().e(this.zl);
            if (c.contains("c.tieba.baidu.com") && (map = this.gpl.bnE().zV) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.zI = list.get(0);
                eVar.zJ = list.get(1);
            }
            eVar.zE = this.gpl.bnE().responseCode;
            eVar.zy = this.zl.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.zl);
            if (c2 != null) {
                eVar.zy += c2.length;
                this.gpl.bnE().zW = c(this.gpl.bnE().contentEncoding, c2);
            }
            eVar.zF = -9;
            eVar.zz = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.zl != null) {
                this.zl.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.zp = System.currentTimeMillis();
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
                while (!this.gpl.bnE().zT && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.zo = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.f(inputStream);
                        throw th;
                    }
                }
                if (this.gpl.bnE().zT) {
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
        this.zo = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.f(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.zF = -1;
        try {
            String url = this.gpl.bnD().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gpl.bnE().zT) {
                throw new BdHttpCancelException();
            }
            eVar.zF = -2;
            this.zl = c(a);
            eVar.zF = -3;
            System.currentTimeMillis();
            if (this.zl == null) {
                throw new SocketException("network not available.");
            }
            this.zl.setRequestMethod("POST");
            this.zl.setDoOutput(true);
            this.zl.setDoInput(true);
            this.zl.setConnectTimeout(i2);
            this.zl.setReadTimeout(i);
            this.zl.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.gpl.bnE().zT) {
                throw new BdHttpCancelException();
            }
            this.gpl.bnD().d(this.zl);
            if (this.gpl.bnE().zT) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.zC = new Date().getTime() - time;
            eVar.zF = -4;
            this.zl.connect();
            if (this.zm <= 0) {
                this.zm = System.currentTimeMillis();
            }
            this.zn = System.currentTimeMillis();
            eVar.zF = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.zC;
            if (this.gpl.bnE().zT) {
                throw new BdHttpCancelException();
            }
            if (this.zt != null) {
                this.zt.schedule(this.zs, 45000L);
            }
            eVar.zF = -6;
            this.gpl.bnD().a(this.zl, boundary, eVar);
            eVar.zF = -7;
            String contentType = this.zl.getContentType();
            this.th = System.currentTimeMillis();
            if (f.aE(contentType)) {
                this.zl.disconnect();
                this.zl.connect();
                if (this.gpl.bnE().zT) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.gpl.bnE().zT) {
                throw new BdHttpCancelException();
            }
            eVar.zF = -8;
            this.gpl.bnE().e(this.zl);
            eVar.zE = this.gpl.bnE().responseCode;
            eVar.zy = this.zl.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.zl);
            if (c != null) {
                eVar.zy += c.length;
                this.gpl.bnE().zX = c.length;
                this.gpl.bnE().zW = c(this.gpl.bnE().contentEncoding, c);
            }
            eVar.zz = new Date().getTime() - time;
            eVar.zF = -9;
        } finally {
            if (this.zt != null) {
                this.zt.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.zl);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.gpk = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.gpl.bnD().getUrl();
            eVar2.url = url;
            this.zl = a(a(url, eVar2), i2, i);
            this.zl.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.gpl.bnE().zT) {
                this.zo = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.f((InputStream) null);
                com.baidu.adp.lib.g.a.f(this.zl);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.aY(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.aW(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.gpl.bnD().d(this.zl);
                this.zl.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.zl.connect();
                if (this.zm <= 0) {
                    this.zm = System.currentTimeMillis();
                }
                this.zn = System.currentTimeMillis();
                int responseCode = this.zl.getResponseCode();
                while (sg(responseCode) && this.gpk <= 5) {
                    this.zl = a(this.zl, i2, i);
                    this.gpl.bnD().d(this.zl);
                    this.zl.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.zl.connect();
                    responseCode = this.zl.getResponseCode();
                }
                this.th = System.currentTimeMillis();
                this.gpl.bnE().responseCode = responseCode;
                if (hO()) {
                    if (this.zl.getContentType() != null && this.zl.getContentType().contains("text/vnd.wap.wml")) {
                        this.zl.disconnect();
                        this.gpl.bnE().responseCode = 0;
                        boolean a = a(str, jVar, i, i2, z, eVar2, z2);
                        this.zo = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zl);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.zl.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.gpl.bnE().responseCode == 200 && (headerField = this.zl.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.gpl.bnE().contentLength = String.valueOf(g);
                    eVar2.zx = url.getBytes().length;
                    eVar2.zy = this.zl.getHeaderFields().toString().getBytes().length;
                    eVar2.zy += g;
                    if (this.gpl.bnE().responseCode == 416 || this.gpl.bnE().responseCode == 204) {
                        this.zo = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zl);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.zo = System.currentTimeMillis();
                        this.zo = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zl);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.zl.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (jVar != null && length > 0) {
                                jVar.m((int) length, g);
                            }
                            while (!this.gpl.bnE().zT) {
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
                                this.zo = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.f(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.zl);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.zo = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.f(inputStream);
                            com.baidu.adp.lib.g.a.f(this.zl);
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
        URL url = httpURLConnection.getURL().toURI().resolve(httpURLConnection.getHeaderField("Location")).toURL();
        com.baidu.adp.lib.g.a.f(httpURLConnection);
        HttpURLConnection a = a(url, i, i2);
        this.gpk++;
        return a;
    }

    private boolean sg(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean hO() {
        return this.gpl.bnE().responseCode == 200 || this.gpl.bnE().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.zF = -1;
        try {
            String url = this.gpl.bnD().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gpl.bnE().zT) {
                throw new BdHttpCancelException();
            }
            eVar.zF = -2;
            this.zl = c(a);
            eVar.zF = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.zl == null) {
                throw new SocketException("network not available.");
            }
            this.zl.setRequestMethod("POST");
            this.zl.setDoOutput(true);
            this.zl.setDoInput(true);
            this.zl.setConnectTimeout(i2);
            this.zl.setReadTimeout(i);
            this.zl.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.gpl.bnE().zT) {
                throw new BdHttpCancelException();
            }
            this.gpl.bnD().d(this.zl);
            if (this.gpl.bnE().zT) {
                throw new BdHttpCancelException();
            }
            eVar.zC = System.currentTimeMillis() - currentTimeMillis;
            eVar.zF = -4;
            this.zl.connect();
            if (this.zm <= 0) {
                this.zm = System.currentTimeMillis();
            }
            this.zn = System.currentTimeMillis();
            eVar.zF = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.zC;
            if (this.gpl.bnE().zT) {
                throw new BdHttpCancelException();
            }
            eVar.zF = -6;
            this.gpl.bnD().a(this.zl, eVar);
            eVar.zF = -7;
            if (this.gpl.bnE().zT) {
                throw new BdHttpCancelException();
            }
            String contentType = this.zl.getContentType();
            this.th = System.currentTimeMillis();
            if (f.aE(contentType)) {
                this.zl.disconnect();
                this.zl.connect();
                if (this.gpl.bnE().zT) {
                    throw new BdHttpCancelException();
                }
            }
            this.gpl.bnE().e(this.zl);
            eVar.zF = -8;
            eVar.zE = this.gpl.bnE().responseCode;
            eVar.zy = this.zl.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.zl);
            if (c != null) {
                eVar.zy += c.length;
                this.gpl.bnE().zX = c.length;
                this.gpl.bnE().zW = c(this.gpl.bnE().contentEncoding, c);
            }
            eVar.zz = new Date().getTime() - currentTimeMillis;
            eVar.zF = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.zl);
        }
    }
}
