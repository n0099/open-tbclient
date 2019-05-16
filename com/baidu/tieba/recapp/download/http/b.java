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
    private HttpURLConnection Aa;
    private int iAr;
    private g iAs;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int iAq = 5;
    private long Ab = 0;
    private long Ac = 0;
    private long ub = 0;
    private long Ae = 0;
    private long Af = 0;
    private boolean Ag = false;
    private boolean Ah = true;
    private TimerTask Aj = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.ia();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer Ak = new Timer();

    public long hW() {
        return this.Ab;
    }

    public boolean hZ() {
        return this.Ag;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.iAs = gVar;
    }

    public void ia() {
        this.iAs.cfa().AK = true;
        com.baidu.adp.lib.g.a.f(this.Aa);
    }

    private URL a(String str, e eVar) throws Exception {
        a ceX;
        URL url = new URL(str);
        if (this.Ah && (ceX = a.ceX()) != null) {
            String az = ceX.az(str);
            if (!TextUtils.isEmpty(az)) {
                this.iAs.ceZ().q(HTTP.TARGET_HOST, url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + az));
                this.Ag = true;
                eVar.Ay = az;
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
        String kb;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.baidu.adp.lib.util.j.jS()) {
                if (com.baidu.adp.lib.util.j.jU() && (kb = com.baidu.adp.lib.util.j.kb()) != null && kb.length() > 0) {
                    if (com.baidu.adp.lib.util.j.be(kb) && com.baidu.adp.lib.util.j.kd()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(kb);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.iAs.ceZ().q("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(kb, com.baidu.adp.lib.util.j.kc())));
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
        eVar.Aw = -1;
        if (this.iAs.cfa().AK) {
            throw new BdHttpCancelException();
        }
        String c = this.iAs.ceZ().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.iAs.cfa().AK) {
            throw new BdHttpCancelException();
        }
        eVar.Aw = -2;
        this.Aa = c(a);
        eVar.Aw = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.Aa == null) {
                throw new SocketException("network not available.");
            }
            this.Aa.setRequestMethod("GET");
            this.Aa.setConnectTimeout(i2);
            this.Aa.setReadTimeout(i);
            this.iAs.ceZ().d(this.Aa);
            if (this.iAs.cfa().AK) {
                throw new BdHttpCancelException();
            }
            eVar.At = new Date().getTime() - currentTimeMillis;
            eVar.Aw = -4;
            this.Aa.connect();
            if (this.Ab <= 0) {
                this.Ab = System.currentTimeMillis();
            }
            this.Ac = System.currentTimeMillis();
            eVar.Aw = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.At;
            if (this.iAs.cfa().AK) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Aa.getContentType();
            this.ub = System.currentTimeMillis();
            if (f.aF(contentType)) {
                this.Aa.disconnect();
                this.Aa.connect();
                if (this.iAs.cfa().AK) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.Aw = -8;
            this.iAs.cfa().e(this.Aa);
            if (c.contains("c.tieba.baidu.com") && (map = this.iAs.cfa().AN) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.Az = list.get(0);
                eVar.AA = list.get(1);
            }
            eVar.Av = this.iAs.cfa().responseCode;
            eVar.Ap = this.Aa.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.Aa);
            if (c2 != null) {
                eVar.Ap += c2.length;
                this.iAs.cfa().AO = c(this.iAs.cfa().contentEncoding, c2);
            }
            eVar.Aw = -9;
            eVar.Aq = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.Aa != null) {
                this.Aa.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.Af = System.currentTimeMillis();
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
                while (!this.iAs.cfa().AK && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.Ae = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.g(inputStream);
                        throw th;
                    }
                }
                if (this.iAs.cfa().AK) {
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
        this.Ae = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.g(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.Aw = -1;
        try {
            String url = this.iAs.ceZ().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.iAs.cfa().AK) {
                throw new BdHttpCancelException();
            }
            eVar.Aw = -2;
            this.Aa = c(a);
            eVar.Aw = -3;
            System.currentTimeMillis();
            if (this.Aa == null) {
                throw new SocketException("network not available.");
            }
            this.Aa.setRequestMethod("POST");
            this.Aa.setDoOutput(true);
            this.Aa.setDoInput(true);
            this.Aa.setConnectTimeout(i2);
            this.Aa.setReadTimeout(i);
            this.Aa.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.iAs.cfa().AK) {
                throw new BdHttpCancelException();
            }
            this.iAs.ceZ().d(this.Aa);
            if (this.iAs.cfa().AK) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.At = new Date().getTime() - time;
            eVar.Aw = -4;
            this.Aa.connect();
            if (this.Ab <= 0) {
                this.Ab = System.currentTimeMillis();
            }
            this.Ac = System.currentTimeMillis();
            eVar.Aw = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.At;
            if (this.iAs.cfa().AK) {
                throw new BdHttpCancelException();
            }
            if (this.Ak != null) {
                this.Ak.schedule(this.Aj, 45000L);
            }
            eVar.Aw = -6;
            this.iAs.ceZ().a(this.Aa, boundary, eVar);
            eVar.Aw = -7;
            String contentType = this.Aa.getContentType();
            this.ub = System.currentTimeMillis();
            if (f.aF(contentType)) {
                this.Aa.disconnect();
                this.Aa.connect();
                if (this.iAs.cfa().AK) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.iAs.cfa().AK) {
                throw new BdHttpCancelException();
            }
            eVar.Aw = -8;
            this.iAs.cfa().e(this.Aa);
            eVar.Av = this.iAs.cfa().responseCode;
            eVar.Ap = this.Aa.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.Aa);
            if (c != null) {
                eVar.Ap += c.length;
                this.iAs.cfa().AP = c.length;
                this.iAs.cfa().AO = c(this.iAs.cfa().contentEncoding, c);
            }
            eVar.Aq = new Date().getTime() - time;
            eVar.Aw = -9;
        } finally {
            if (this.Ak != null) {
                this.Ak.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.Aa);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.iAr = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.iAs.ceZ().getUrl();
            eVar2.url = url;
            this.Aa = a(a(url, eVar2), i2, i);
            this.Aa.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.iAs.cfa().AK) {
                this.Ae = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.g(null);
                com.baidu.adp.lib.g.a.f(this.Aa);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.aY(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.aX(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.iAs.ceZ().d(this.Aa);
                this.Aa.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.Aa.connect();
                if (this.Ab <= 0) {
                    this.Ab = System.currentTimeMillis();
                }
                this.Ac = System.currentTimeMillis();
                int responseCode = this.Aa.getResponseCode();
                while (yU(responseCode) && this.iAr <= 5) {
                    this.Aa = a(this.Aa, i2, i);
                    this.iAs.ceZ().d(this.Aa);
                    this.Aa.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.Aa.connect();
                    responseCode = this.Aa.getResponseCode();
                }
                this.ub = System.currentTimeMillis();
                this.iAs.cfa().responseCode = responseCode;
                if (ib()) {
                    if (this.Aa.getContentType() != null && this.Aa.getContentType().contains("text/vnd.wap.wml")) {
                        this.Aa.disconnect();
                        this.iAs.cfa().responseCode = 0;
                        boolean a = a(str, jVar, i, i2, z, eVar2, z2);
                        this.Ae = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.g(null);
                        com.baidu.adp.lib.g.a.f(this.Aa);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.Aa.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.f(headerField2.substring(indexOf + 1), 0);
                    }
                    int f = (i3 == 0 && this.iAs.cfa().responseCode == 200 && (headerField = this.Aa.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.f(headerField, 0) : i3;
                    this.iAs.cfa().contentLength = String.valueOf(f);
                    eVar2.Ao = url.getBytes().length;
                    eVar2.Ap = this.Aa.getHeaderFields().toString().getBytes().length;
                    eVar2.Ap += f;
                    if (this.iAs.cfa().responseCode == 416 || this.iAs.cfa().responseCode == 204) {
                        this.Ae = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.g(null);
                        com.baidu.adp.lib.g.a.f(this.Aa);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (f != 0 && length >= f) {
                        this.Ae = System.currentTimeMillis();
                        this.Ae = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.g(null);
                        com.baidu.adp.lib.g.a.f(this.Aa);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.Aa.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = f > 0 ? f / 50 : 0;
                            int i6 = 0;
                            if (jVar != null && length > 0) {
                                jVar.m((int) length, f);
                            }
                            while (!this.iAs.cfa().AK) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i4 += read;
                                        i6 += read;
                                        if (jVar != null && (i6 > i5 || i4 == f)) {
                                            i6 = 0;
                                            jVar.m((int) (i4 + length), f);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i4) + length >= ((long) f);
                                this.Ae = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.g(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.Aa);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.Ae = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.g(inputStream);
                            com.baidu.adp.lib.g.a.f(this.Aa);
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
        this.iAr++;
        return a;
    }

    private boolean yU(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean ib() {
        return this.iAs.cfa().responseCode == 200 || this.iAs.cfa().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.Aw = -1;
        try {
            String url = this.iAs.ceZ().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.iAs.cfa().AK) {
                throw new BdHttpCancelException();
            }
            eVar.Aw = -2;
            this.Aa = c(a);
            eVar.Aw = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.Aa == null) {
                throw new SocketException("network not available.");
            }
            this.Aa.setRequestMethod("POST");
            this.Aa.setDoOutput(true);
            this.Aa.setDoInput(true);
            this.Aa.setConnectTimeout(i2);
            this.Aa.setReadTimeout(i);
            this.Aa.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.iAs.cfa().AK) {
                throw new BdHttpCancelException();
            }
            this.iAs.ceZ().d(this.Aa);
            if (this.iAs.cfa().AK) {
                throw new BdHttpCancelException();
            }
            eVar.At = System.currentTimeMillis() - currentTimeMillis;
            eVar.Aw = -4;
            this.Aa.connect();
            if (this.Ab <= 0) {
                this.Ab = System.currentTimeMillis();
            }
            this.Ac = System.currentTimeMillis();
            eVar.Aw = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.At;
            if (this.iAs.cfa().AK) {
                throw new BdHttpCancelException();
            }
            eVar.Aw = -6;
            this.iAs.ceZ().a(this.Aa, eVar);
            eVar.Aw = -7;
            if (this.iAs.cfa().AK) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Aa.getContentType();
            this.ub = System.currentTimeMillis();
            if (f.aF(contentType)) {
                this.Aa.disconnect();
                this.Aa.connect();
                if (this.iAs.cfa().AK) {
                    throw new BdHttpCancelException();
                }
            }
            this.iAs.cfa().e(this.Aa);
            eVar.Aw = -8;
            eVar.Av = this.iAs.cfa().responseCode;
            eVar.Ap = this.Aa.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.Aa);
            if (c != null) {
                eVar.Ap += c.length;
                this.iAs.cfa().AP = c.length;
                this.iAs.cfa().AO = c(this.iAs.cfa().contentEncoding, c);
            }
            eVar.Aq = new Date().getTime() - currentTimeMillis;
            eVar.Aw = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.Aa);
        }
    }
}
