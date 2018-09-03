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
    private int gpn;
    private g gpo;
    private HttpURLConnection zm;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int gpm = 5;
    private long zn = 0;
    private long zo = 0;
    private long ti = 0;
    private long zp = 0;
    private long zq = 0;
    private boolean zr = false;
    private boolean zs = true;
    private TimerTask zt = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.hN();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer zu = new Timer();

    public long hJ() {
        return this.zn;
    }

    public boolean hM() {
        return this.zr;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.gpo = gVar;
    }

    public void hN() {
        this.gpo.bnF().zU = true;
        com.baidu.adp.lib.g.a.f(this.zm);
    }

    private URL a(String str, e eVar) throws Exception {
        a bnC;
        URL url = new URL(str);
        if (this.zs && (bnC = a.bnC()) != null) {
            String ay = bnC.ay(str);
            if (!TextUtils.isEmpty(ay)) {
                this.gpo.bnE().p("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ay));
                this.zr = true;
                eVar.zI = ay;
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
                            this.gpo.bnE().p("X-Online-Host", url.getHost());
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
        eVar.zG = -1;
        if (this.gpo.bnF().zU) {
            throw new BdHttpCancelException();
        }
        String c = this.gpo.bnE().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.gpo.bnF().zU) {
            throw new BdHttpCancelException();
        }
        eVar.zG = -2;
        this.zm = c(a);
        eVar.zG = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.zm == null) {
                throw new SocketException("network not available.");
            }
            this.zm.setRequestMethod("GET");
            this.zm.setConnectTimeout(i2);
            this.zm.setReadTimeout(i);
            this.gpo.bnE().d(this.zm);
            if (this.gpo.bnF().zU) {
                throw new BdHttpCancelException();
            }
            eVar.zD = new Date().getTime() - currentTimeMillis;
            eVar.zG = -4;
            this.zm.connect();
            if (this.zn <= 0) {
                this.zn = System.currentTimeMillis();
            }
            this.zo = System.currentTimeMillis();
            eVar.zG = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.zD;
            if (this.gpo.bnF().zU) {
                throw new BdHttpCancelException();
            }
            String contentType = this.zm.getContentType();
            this.ti = System.currentTimeMillis();
            if (f.aE(contentType)) {
                this.zm.disconnect();
                this.zm.connect();
                if (this.gpo.bnF().zU) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.zG = -8;
            this.gpo.bnF().e(this.zm);
            if (c.contains("c.tieba.baidu.com") && (map = this.gpo.bnF().zW) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.zJ = list.get(0);
                eVar.zK = list.get(1);
            }
            eVar.zF = this.gpo.bnF().responseCode;
            eVar.zz = this.zm.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.zm);
            if (c2 != null) {
                eVar.zz += c2.length;
                this.gpo.bnF().zX = c(this.gpo.bnF().contentEncoding, c2);
            }
            eVar.zG = -9;
            eVar.zA = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.zm != null) {
                this.zm.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.zq = System.currentTimeMillis();
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
                while (!this.gpo.bnF().zU && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.zp = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.f(inputStream);
                        throw th;
                    }
                }
                if (this.gpo.bnF().zU) {
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
        this.zp = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.f(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.zG = -1;
        try {
            String url = this.gpo.bnE().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gpo.bnF().zU) {
                throw new BdHttpCancelException();
            }
            eVar.zG = -2;
            this.zm = c(a);
            eVar.zG = -3;
            System.currentTimeMillis();
            if (this.zm == null) {
                throw new SocketException("network not available.");
            }
            this.zm.setRequestMethod("POST");
            this.zm.setDoOutput(true);
            this.zm.setDoInput(true);
            this.zm.setConnectTimeout(i2);
            this.zm.setReadTimeout(i);
            this.zm.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.gpo.bnF().zU) {
                throw new BdHttpCancelException();
            }
            this.gpo.bnE().d(this.zm);
            if (this.gpo.bnF().zU) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.zD = new Date().getTime() - time;
            eVar.zG = -4;
            this.zm.connect();
            if (this.zn <= 0) {
                this.zn = System.currentTimeMillis();
            }
            this.zo = System.currentTimeMillis();
            eVar.zG = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.zD;
            if (this.gpo.bnF().zU) {
                throw new BdHttpCancelException();
            }
            if (this.zu != null) {
                this.zu.schedule(this.zt, 45000L);
            }
            eVar.zG = -6;
            this.gpo.bnE().a(this.zm, boundary, eVar);
            eVar.zG = -7;
            String contentType = this.zm.getContentType();
            this.ti = System.currentTimeMillis();
            if (f.aE(contentType)) {
                this.zm.disconnect();
                this.zm.connect();
                if (this.gpo.bnF().zU) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.gpo.bnF().zU) {
                throw new BdHttpCancelException();
            }
            eVar.zG = -8;
            this.gpo.bnF().e(this.zm);
            eVar.zF = this.gpo.bnF().responseCode;
            eVar.zz = this.zm.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.zm);
            if (c != null) {
                eVar.zz += c.length;
                this.gpo.bnF().zY = c.length;
                this.gpo.bnF().zX = c(this.gpo.bnF().contentEncoding, c);
            }
            eVar.zA = new Date().getTime() - time;
            eVar.zG = -9;
        } finally {
            if (this.zu != null) {
                this.zu.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.zm);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.gpn = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.gpo.bnE().getUrl();
            eVar2.url = url;
            this.zm = a(a(url, eVar2), i2, i);
            this.zm.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.gpo.bnF().zU) {
                this.zp = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.f((InputStream) null);
                com.baidu.adp.lib.g.a.f(this.zm);
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
                this.gpo.bnE().d(this.zm);
                this.zm.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.zm.connect();
                if (this.zn <= 0) {
                    this.zn = System.currentTimeMillis();
                }
                this.zo = System.currentTimeMillis();
                int responseCode = this.zm.getResponseCode();
                while (sg(responseCode) && this.gpn <= 5) {
                    this.zm = a(this.zm, i2, i);
                    this.gpo.bnE().d(this.zm);
                    this.zm.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.zm.connect();
                    responseCode = this.zm.getResponseCode();
                }
                this.ti = System.currentTimeMillis();
                this.gpo.bnF().responseCode = responseCode;
                if (hO()) {
                    if (this.zm.getContentType() != null && this.zm.getContentType().contains("text/vnd.wap.wml")) {
                        this.zm.disconnect();
                        this.gpo.bnF().responseCode = 0;
                        boolean a = a(str, jVar, i, i2, z, eVar2, z2);
                        this.zp = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zm);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.zm.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.gpo.bnF().responseCode == 200 && (headerField = this.zm.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.gpo.bnF().contentLength = String.valueOf(g);
                    eVar2.zy = url.getBytes().length;
                    eVar2.zz = this.zm.getHeaderFields().toString().getBytes().length;
                    eVar2.zz += g;
                    if (this.gpo.bnF().responseCode == 416 || this.gpo.bnF().responseCode == 204) {
                        this.zp = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zm);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.zp = System.currentTimeMillis();
                        this.zp = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zm);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.zm.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (jVar != null && length > 0) {
                                jVar.m((int) length, g);
                            }
                            while (!this.gpo.bnF().zU) {
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
                                this.zp = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.f(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.zm);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.zp = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.f(inputStream);
                            com.baidu.adp.lib.g.a.f(this.zm);
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
        this.gpn++;
        return a;
    }

    private boolean sg(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean hO() {
        return this.gpo.bnF().responseCode == 200 || this.gpo.bnF().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.zG = -1;
        try {
            String url = this.gpo.bnE().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gpo.bnF().zU) {
                throw new BdHttpCancelException();
            }
            eVar.zG = -2;
            this.zm = c(a);
            eVar.zG = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.zm == null) {
                throw new SocketException("network not available.");
            }
            this.zm.setRequestMethod("POST");
            this.zm.setDoOutput(true);
            this.zm.setDoInput(true);
            this.zm.setConnectTimeout(i2);
            this.zm.setReadTimeout(i);
            this.zm.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.gpo.bnF().zU) {
                throw new BdHttpCancelException();
            }
            this.gpo.bnE().d(this.zm);
            if (this.gpo.bnF().zU) {
                throw new BdHttpCancelException();
            }
            eVar.zD = System.currentTimeMillis() - currentTimeMillis;
            eVar.zG = -4;
            this.zm.connect();
            if (this.zn <= 0) {
                this.zn = System.currentTimeMillis();
            }
            this.zo = System.currentTimeMillis();
            eVar.zG = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.zD;
            if (this.gpo.bnF().zU) {
                throw new BdHttpCancelException();
            }
            eVar.zG = -6;
            this.gpo.bnE().a(this.zm, eVar);
            eVar.zG = -7;
            if (this.gpo.bnF().zU) {
                throw new BdHttpCancelException();
            }
            String contentType = this.zm.getContentType();
            this.ti = System.currentTimeMillis();
            if (f.aE(contentType)) {
                this.zm.disconnect();
                this.zm.connect();
                if (this.gpo.bnF().zU) {
                    throw new BdHttpCancelException();
                }
            }
            this.gpo.bnF().e(this.zm);
            eVar.zG = -8;
            eVar.zF = this.gpo.bnF().responseCode;
            eVar.zz = this.zm.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.zm);
            if (c != null) {
                eVar.zz += c.length;
                this.gpo.bnF().zY = c.length;
                this.gpo.bnF().zX = c(this.gpo.bnF().contentEncoding, c);
            }
            eVar.zA = new Date().getTime() - currentTimeMillis;
            eVar.zG = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.zm);
        }
    }
}
