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
    private int fXL;
    private g fXM;
    private HttpURLConnection tk;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int fXK = 5;
    private long tl = 0;
    private long tm = 0;
    private long mW = 0;
    private long tp = 0;
    private long tq = 0;
    private boolean tr = false;
    private boolean ts = true;
    private TimerTask tt = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.eW();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer tu = new Timer();

    public long eS() {
        return this.tl;
    }

    public boolean eV() {
        return this.tr;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.fXM = gVar;
    }

    public void eW() {
        this.fXM.bjB().tW = true;
        com.baidu.adp.lib.g.a.f(this.tk);
    }

    private URL a(String str, e eVar) throws Exception {
        a bjy;
        URL url = new URL(str);
        if (this.ts && (bjy = a.bjy()) != null) {
            String al = bjy.al(str);
            if (!TextUtils.isEmpty(al)) {
                this.fXM.bjA().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + al));
                this.tr = true;
                eVar.tK = al;
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
                            this.fXM.bjA().o("X-Online-Host", url.getHost());
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
        eVar.tI = -1;
        if (this.fXM.bjB().tW) {
            throw new BdHttpCancelException();
        }
        String c = this.fXM.bjA().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.fXM.bjB().tW) {
            throw new BdHttpCancelException();
        }
        eVar.tI = -2;
        this.tk = c(a);
        eVar.tI = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.tk == null) {
                throw new SocketException("network not available.");
            }
            this.tk.setRequestMethod("GET");
            this.tk.setConnectTimeout(i2);
            this.tk.setReadTimeout(i);
            this.fXM.bjA().d(this.tk);
            if (this.fXM.bjB().tW) {
                throw new BdHttpCancelException();
            }
            eVar.tF = new Date().getTime() - currentTimeMillis;
            eVar.tI = -4;
            this.tk.connect();
            if (this.tl <= 0) {
                this.tl = System.currentTimeMillis();
            }
            this.tm = System.currentTimeMillis();
            eVar.tI = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.tF;
            if (this.fXM.bjB().tW) {
                throw new BdHttpCancelException();
            }
            String contentType = this.tk.getContentType();
            this.mW = System.currentTimeMillis();
            if (f.ap(contentType)) {
                this.tk.disconnect();
                this.tk.connect();
                if (this.fXM.bjB().tW) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.tI = -8;
            this.fXM.bjB().e(this.tk);
            if (c.contains("c.tieba.baidu.com") && (map = this.fXM.bjB().tY) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.tL = list.get(0);
                eVar.tM = list.get(1);
            }
            eVar.tH = this.fXM.bjB().responseCode;
            eVar.tB = this.tk.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.tk);
            if (c2 != null) {
                eVar.tB += c2.length;
                this.fXM.bjB().tZ = c(this.fXM.bjB().contentEncoding, c2);
            }
            eVar.tI = -9;
            eVar.tC = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.tk != null) {
                this.tk.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.tq = System.currentTimeMillis();
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
                while (!this.fXM.bjB().tW && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.tp = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.d(inputStream);
                        throw th;
                    }
                }
                if (this.fXM.bjB().tW) {
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
        this.tp = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.d(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.tI = -1;
        try {
            String url = this.fXM.bjA().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.fXM.bjB().tW) {
                throw new BdHttpCancelException();
            }
            eVar.tI = -2;
            this.tk = c(a);
            eVar.tI = -3;
            System.currentTimeMillis();
            if (this.tk == null) {
                throw new SocketException("network not available.");
            }
            this.tk.setRequestMethod("POST");
            this.tk.setDoOutput(true);
            this.tk.setDoInput(true);
            this.tk.setConnectTimeout(i2);
            this.tk.setReadTimeout(i);
            this.tk.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.fXM.bjB().tW) {
                throw new BdHttpCancelException();
            }
            this.fXM.bjA().d(this.tk);
            if (this.fXM.bjB().tW) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.tF = new Date().getTime() - time;
            eVar.tI = -4;
            this.tk.connect();
            if (this.tl <= 0) {
                this.tl = System.currentTimeMillis();
            }
            this.tm = System.currentTimeMillis();
            eVar.tI = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.tF;
            if (this.fXM.bjB().tW) {
                throw new BdHttpCancelException();
            }
            if (this.tu != null) {
                this.tu.schedule(this.tt, 45000L);
            }
            eVar.tI = -6;
            this.fXM.bjA().a(this.tk, boundary, eVar);
            eVar.tI = -7;
            String contentType = this.tk.getContentType();
            this.mW = System.currentTimeMillis();
            if (f.ap(contentType)) {
                this.tk.disconnect();
                this.tk.connect();
                if (this.fXM.bjB().tW) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.fXM.bjB().tW) {
                throw new BdHttpCancelException();
            }
            eVar.tI = -8;
            this.fXM.bjB().e(this.tk);
            eVar.tH = this.fXM.bjB().responseCode;
            eVar.tB = this.tk.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.tk);
            if (c != null) {
                eVar.tB += c.length;
                this.fXM.bjB().ub = c.length;
                this.fXM.bjB().tZ = c(this.fXM.bjB().contentEncoding, c);
            }
            eVar.tC = new Date().getTime() - time;
            eVar.tI = -9;
        } finally {
            if (this.tu != null) {
                this.tu.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.tk);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.fXL = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.fXM.bjA().getUrl();
            eVar2.url = url;
            this.tk = a(a(url, eVar2), i2, i);
            this.tk.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.fXM.bjB().tW) {
                this.tp = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.f(this.tk);
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
                this.fXM.bjA().d(this.tk);
                this.tk.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.tk.connect();
                if (this.tl <= 0) {
                    this.tl = System.currentTimeMillis();
                }
                this.tm = System.currentTimeMillis();
                int responseCode = this.tk.getResponseCode();
                while (rN(responseCode) && this.fXL <= 5) {
                    this.tk = a(this.tk, i2, i);
                    this.fXM.bjA().d(this.tk);
                    this.tk.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.tk.connect();
                    responseCode = this.tk.getResponseCode();
                }
                this.mW = System.currentTimeMillis();
                this.fXM.bjB().responseCode = responseCode;
                if (eX()) {
                    if (this.tk.getContentType() != null && this.tk.getContentType().contains("text/vnd.wap.wml")) {
                        this.tk.disconnect();
                        this.fXM.bjB().responseCode = 0;
                        boolean a = a(str, jVar, i, i2, z, eVar2, z2);
                        this.tp = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.tk);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.tk.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.fXM.bjB().responseCode == 200 && (headerField = this.tk.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.fXM.bjB().contentLength = String.valueOf(g);
                    eVar2.tA = url.getBytes().length;
                    eVar2.tB = this.tk.getHeaderFields().toString().getBytes().length;
                    eVar2.tB += g;
                    if (this.fXM.bjB().responseCode == 416 || this.fXM.bjB().responseCode == 204) {
                        this.tp = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.tk);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.tp = System.currentTimeMillis();
                        this.tp = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.tk);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.tk.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (jVar != null && length > 0) {
                                jVar.m((int) length, g);
                            }
                            while (!this.fXM.bjB().tW) {
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
                                this.tp = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.d(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.tk);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.tp = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.d(inputStream);
                            com.baidu.adp.lib.g.a.f(this.tk);
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
        this.fXL++;
        return a;
    }

    private boolean rN(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean eX() {
        return this.fXM.bjB().responseCode == 200 || this.fXM.bjB().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.tI = -1;
        try {
            String url = this.fXM.bjA().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.fXM.bjB().tW) {
                throw new BdHttpCancelException();
            }
            eVar.tI = -2;
            this.tk = c(a);
            eVar.tI = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.tk == null) {
                throw new SocketException("network not available.");
            }
            this.tk.setRequestMethod("POST");
            this.tk.setDoOutput(true);
            this.tk.setDoInput(true);
            this.tk.setConnectTimeout(i2);
            this.tk.setReadTimeout(i);
            this.tk.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.fXM.bjB().tW) {
                throw new BdHttpCancelException();
            }
            this.fXM.bjA().d(this.tk);
            if (this.fXM.bjB().tW) {
                throw new BdHttpCancelException();
            }
            eVar.tF = System.currentTimeMillis() - currentTimeMillis;
            eVar.tI = -4;
            this.tk.connect();
            if (this.tl <= 0) {
                this.tl = System.currentTimeMillis();
            }
            this.tm = System.currentTimeMillis();
            eVar.tI = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.tF;
            if (this.fXM.bjB().tW) {
                throw new BdHttpCancelException();
            }
            eVar.tI = -6;
            this.fXM.bjA().a(this.tk, eVar);
            eVar.tI = -7;
            if (this.fXM.bjB().tW) {
                throw new BdHttpCancelException();
            }
            String contentType = this.tk.getContentType();
            this.mW = System.currentTimeMillis();
            if (f.ap(contentType)) {
                this.tk.disconnect();
                this.tk.connect();
                if (this.fXM.bjB().tW) {
                    throw new BdHttpCancelException();
                }
            }
            this.fXM.bjB().e(this.tk);
            eVar.tI = -8;
            eVar.tH = this.fXM.bjB().responseCode;
            eVar.tB = this.tk.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.tk);
            if (c != null) {
                eVar.tB += c.length;
                this.fXM.bjB().ub = c.length;
                this.fXM.bjB().tZ = c(this.fXM.bjB().contentEncoding, c);
            }
            eVar.tC = new Date().getTime() - currentTimeMillis;
            eVar.tI = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.tk);
        }
    }
}
