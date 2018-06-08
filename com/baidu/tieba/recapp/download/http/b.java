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
    private int gkj;
    private g gkk;
    private HttpURLConnection zs;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int gki = 5;
    private long zt = 0;
    private long zu = 0;
    private long tt = 0;
    private long zv = 0;
    private long zw = 0;
    private boolean zx = false;
    private boolean zy = true;
    private TimerTask zz = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.hN();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer zA = new Timer();

    public long hJ() {
        return this.zt;
    }

    public boolean hM() {
        return this.zx;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.gkk = gVar;
    }

    public void hN() {
        this.gkk.boz().Aa = true;
        com.baidu.adp.lib.g.a.f(this.zs);
    }

    private URL a(String str, e eVar) throws Exception {
        a bow;
        URL url = new URL(str);
        if (this.zy && (bow = a.bow()) != null) {
            String ax = bow.ax(str);
            if (!TextUtils.isEmpty(ax)) {
                this.gkk.boy().q("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ax));
                this.zx = true;
                eVar.zO = ax;
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
                    if (com.baidu.adp.lib.util.j.bb(jN) && com.baidu.adp.lib.util.j.jP()) {
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
                            this.gkk.boy().q("X-Online-Host", url.getHost());
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
        eVar.zM = -1;
        if (this.gkk.boz().Aa) {
            throw new BdHttpCancelException();
        }
        String c = this.gkk.boy().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.gkk.boz().Aa) {
            throw new BdHttpCancelException();
        }
        eVar.zM = -2;
        this.zs = c(a);
        eVar.zM = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.zs == null) {
                throw new SocketException("network not available.");
            }
            this.zs.setRequestMethod("GET");
            this.zs.setConnectTimeout(i2);
            this.zs.setReadTimeout(i);
            this.gkk.boy().d(this.zs);
            if (this.gkk.boz().Aa) {
                throw new BdHttpCancelException();
            }
            eVar.zJ = new Date().getTime() - currentTimeMillis;
            eVar.zM = -4;
            this.zs.connect();
            if (this.zt <= 0) {
                this.zt = System.currentTimeMillis();
            }
            this.zu = System.currentTimeMillis();
            eVar.zM = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.zJ;
            if (this.gkk.boz().Aa) {
                throw new BdHttpCancelException();
            }
            String contentType = this.zs.getContentType();
            this.tt = System.currentTimeMillis();
            if (f.aB(contentType)) {
                this.zs.disconnect();
                this.zs.connect();
                if (this.gkk.boz().Aa) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.zM = -8;
            this.gkk.boz().e(this.zs);
            if (c.contains("c.tieba.baidu.com") && (map = this.gkk.boz().Ac) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.zP = list.get(0);
                eVar.zQ = list.get(1);
            }
            eVar.zL = this.gkk.boz().responseCode;
            eVar.zF = this.zs.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.zs);
            if (c2 != null) {
                eVar.zF += c2.length;
                this.gkk.boz().Ae = c(this.gkk.boz().contentEncoding, c2);
            }
            eVar.zM = -9;
            eVar.zG = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.zs != null) {
                this.zs.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.zw = System.currentTimeMillis();
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
                while (!this.gkk.boz().Aa && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.zv = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.f(inputStream);
                        throw th;
                    }
                }
                if (this.gkk.boz().Aa) {
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
        this.zv = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.f(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.zM = -1;
        try {
            String url = this.gkk.boy().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gkk.boz().Aa) {
                throw new BdHttpCancelException();
            }
            eVar.zM = -2;
            this.zs = c(a);
            eVar.zM = -3;
            System.currentTimeMillis();
            if (this.zs == null) {
                throw new SocketException("network not available.");
            }
            this.zs.setRequestMethod("POST");
            this.zs.setDoOutput(true);
            this.zs.setDoInput(true);
            this.zs.setConnectTimeout(i2);
            this.zs.setReadTimeout(i);
            this.zs.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.gkk.boz().Aa) {
                throw new BdHttpCancelException();
            }
            this.gkk.boy().d(this.zs);
            if (this.gkk.boz().Aa) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.zJ = new Date().getTime() - time;
            eVar.zM = -4;
            this.zs.connect();
            if (this.zt <= 0) {
                this.zt = System.currentTimeMillis();
            }
            this.zu = System.currentTimeMillis();
            eVar.zM = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.zJ;
            if (this.gkk.boz().Aa) {
                throw new BdHttpCancelException();
            }
            if (this.zA != null) {
                this.zA.schedule(this.zz, 45000L);
            }
            eVar.zM = -6;
            this.gkk.boy().a(this.zs, boundary, eVar);
            eVar.zM = -7;
            String contentType = this.zs.getContentType();
            this.tt = System.currentTimeMillis();
            if (f.aB(contentType)) {
                this.zs.disconnect();
                this.zs.connect();
                if (this.gkk.boz().Aa) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.gkk.boz().Aa) {
                throw new BdHttpCancelException();
            }
            eVar.zM = -8;
            this.gkk.boz().e(this.zs);
            eVar.zL = this.gkk.boz().responseCode;
            eVar.zF = this.zs.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.zs);
            if (c != null) {
                eVar.zF += c.length;
                this.gkk.boz().Af = c.length;
                this.gkk.boz().Ae = c(this.gkk.boz().contentEncoding, c);
            }
            eVar.zG = new Date().getTime() - time;
            eVar.zM = -9;
        } finally {
            if (this.zA != null) {
                this.zA.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.zs);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.gkj = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.gkk.boy().getUrl();
            eVar2.url = url;
            this.zs = a(a(url, eVar2), i2, i);
            this.zs.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.gkk.boz().Aa) {
                this.zv = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.f((InputStream) null);
                com.baidu.adp.lib.g.a.f(this.zs);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.aV(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.aT(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.gkk.boy().d(this.zs);
                this.zs.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.zs.connect();
                if (this.zt <= 0) {
                    this.zt = System.currentTimeMillis();
                }
                this.zu = System.currentTimeMillis();
                int responseCode = this.zs.getResponseCode();
                while (rY(responseCode) && this.gkj <= 5) {
                    this.zs = a(this.zs, i2, i);
                    this.gkk.boy().d(this.zs);
                    this.zs.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.zs.connect();
                    responseCode = this.zs.getResponseCode();
                }
                this.tt = System.currentTimeMillis();
                this.gkk.boz().responseCode = responseCode;
                if (hO()) {
                    if (this.zs.getContentType() != null && this.zs.getContentType().contains("text/vnd.wap.wml")) {
                        this.zs.disconnect();
                        this.gkk.boz().responseCode = 0;
                        boolean a = a(str, jVar, i, i2, z, eVar2, z2);
                        this.zv = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zs);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.zs.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.gkk.boz().responseCode == 200 && (headerField = this.zs.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.gkk.boz().contentLength = String.valueOf(g);
                    eVar2.zE = url.getBytes().length;
                    eVar2.zF = this.zs.getHeaderFields().toString().getBytes().length;
                    eVar2.zF += g;
                    if (this.gkk.boz().responseCode == 416 || this.gkk.boz().responseCode == 204) {
                        this.zv = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zs);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.zv = System.currentTimeMillis();
                        this.zv = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zs);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.zs.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (jVar != null && length > 0) {
                                jVar.m((int) length, g);
                            }
                            while (!this.gkk.boz().Aa) {
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
                                this.zv = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.f(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.zs);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.zv = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.f(inputStream);
                            com.baidu.adp.lib.g.a.f(this.zs);
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
        this.gkj++;
        return a;
    }

    private boolean rY(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean hO() {
        return this.gkk.boz().responseCode == 200 || this.gkk.boz().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.zM = -1;
        try {
            String url = this.gkk.boy().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gkk.boz().Aa) {
                throw new BdHttpCancelException();
            }
            eVar.zM = -2;
            this.zs = c(a);
            eVar.zM = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.zs == null) {
                throw new SocketException("network not available.");
            }
            this.zs.setRequestMethod("POST");
            this.zs.setDoOutput(true);
            this.zs.setDoInput(true);
            this.zs.setConnectTimeout(i2);
            this.zs.setReadTimeout(i);
            this.zs.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.gkk.boz().Aa) {
                throw new BdHttpCancelException();
            }
            this.gkk.boy().d(this.zs);
            if (this.gkk.boz().Aa) {
                throw new BdHttpCancelException();
            }
            eVar.zJ = System.currentTimeMillis() - currentTimeMillis;
            eVar.zM = -4;
            this.zs.connect();
            if (this.zt <= 0) {
                this.zt = System.currentTimeMillis();
            }
            this.zu = System.currentTimeMillis();
            eVar.zM = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.zJ;
            if (this.gkk.boz().Aa) {
                throw new BdHttpCancelException();
            }
            eVar.zM = -6;
            this.gkk.boy().a(this.zs, eVar);
            eVar.zM = -7;
            if (this.gkk.boz().Aa) {
                throw new BdHttpCancelException();
            }
            String contentType = this.zs.getContentType();
            this.tt = System.currentTimeMillis();
            if (f.aB(contentType)) {
                this.zs.disconnect();
                this.zs.connect();
                if (this.gkk.boz().Aa) {
                    throw new BdHttpCancelException();
                }
            }
            this.gkk.boz().e(this.zs);
            eVar.zM = -8;
            eVar.zL = this.gkk.boz().responseCode;
            eVar.zF = this.zs.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.zs);
            if (c != null) {
                eVar.zF += c.length;
                this.gkk.boz().Af = c.length;
                this.gkk.boz().Ae = c(this.gkk.boz().contentEncoding, c);
            }
            eVar.zG = new Date().getTime() - currentTimeMillis;
            eVar.zM = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.zs);
        }
    }
}
