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
    private int iAu;
    private g iAv;
    private HttpURLConnection zZ;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int iAt = 5;
    private long Aa = 0;
    private long Ab = 0;
    private long tZ = 0;
    private long Ac = 0;
    private long Ae = 0;
    private boolean Af = false;
    private boolean Ag = true;
    private TimerTask Ai = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.ia();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer Aj = new Timer();

    public long hW() {
        return this.Aa;
    }

    public boolean hZ() {
        return this.Af;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.iAv = gVar;
    }

    public void ia() {
        this.iAv.cfd().AJ = true;
        com.baidu.adp.lib.g.a.f(this.zZ);
    }

    private URL a(String str, e eVar) throws Exception {
        a cfa;
        URL url = new URL(str);
        if (this.Ag && (cfa = a.cfa()) != null) {
            String az = cfa.az(str);
            if (!TextUtils.isEmpty(az)) {
                this.iAv.cfc().q(HTTP.TARGET_HOST, url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + az));
                this.Af = true;
                eVar.Ax = az;
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
                            this.iAv.cfc().q("X-Online-Host", url.getHost());
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
        eVar.Av = -1;
        if (this.iAv.cfd().AJ) {
            throw new BdHttpCancelException();
        }
        String c = this.iAv.cfc().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.iAv.cfd().AJ) {
            throw new BdHttpCancelException();
        }
        eVar.Av = -2;
        this.zZ = c(a);
        eVar.Av = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.zZ == null) {
                throw new SocketException("network not available.");
            }
            this.zZ.setRequestMethod("GET");
            this.zZ.setConnectTimeout(i2);
            this.zZ.setReadTimeout(i);
            this.iAv.cfc().d(this.zZ);
            if (this.iAv.cfd().AJ) {
                throw new BdHttpCancelException();
            }
            eVar.As = new Date().getTime() - currentTimeMillis;
            eVar.Av = -4;
            this.zZ.connect();
            if (this.Aa <= 0) {
                this.Aa = System.currentTimeMillis();
            }
            this.Ab = System.currentTimeMillis();
            eVar.Av = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.As;
            if (this.iAv.cfd().AJ) {
                throw new BdHttpCancelException();
            }
            String contentType = this.zZ.getContentType();
            this.tZ = System.currentTimeMillis();
            if (f.aF(contentType)) {
                this.zZ.disconnect();
                this.zZ.connect();
                if (this.iAv.cfd().AJ) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.Av = -8;
            this.iAv.cfd().e(this.zZ);
            if (c.contains("c.tieba.baidu.com") && (map = this.iAv.cfd().AM) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.Ay = list.get(0);
                eVar.Az = list.get(1);
            }
            eVar.Au = this.iAv.cfd().responseCode;
            eVar.Ao = this.zZ.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.zZ);
            if (c2 != null) {
                eVar.Ao += c2.length;
                this.iAv.cfd().AN = c(this.iAv.cfd().contentEncoding, c2);
            }
            eVar.Av = -9;
            eVar.Ap = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.zZ != null) {
                this.zZ.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.Ae = System.currentTimeMillis();
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
                while (!this.iAv.cfd().AJ && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.Ac = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.g(inputStream);
                        throw th;
                    }
                }
                if (this.iAv.cfd().AJ) {
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
        this.Ac = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.g(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.Av = -1;
        try {
            String url = this.iAv.cfc().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.iAv.cfd().AJ) {
                throw new BdHttpCancelException();
            }
            eVar.Av = -2;
            this.zZ = c(a);
            eVar.Av = -3;
            System.currentTimeMillis();
            if (this.zZ == null) {
                throw new SocketException("network not available.");
            }
            this.zZ.setRequestMethod("POST");
            this.zZ.setDoOutput(true);
            this.zZ.setDoInput(true);
            this.zZ.setConnectTimeout(i2);
            this.zZ.setReadTimeout(i);
            this.zZ.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.iAv.cfd().AJ) {
                throw new BdHttpCancelException();
            }
            this.iAv.cfc().d(this.zZ);
            if (this.iAv.cfd().AJ) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.As = new Date().getTime() - time;
            eVar.Av = -4;
            this.zZ.connect();
            if (this.Aa <= 0) {
                this.Aa = System.currentTimeMillis();
            }
            this.Ab = System.currentTimeMillis();
            eVar.Av = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.As;
            if (this.iAv.cfd().AJ) {
                throw new BdHttpCancelException();
            }
            if (this.Aj != null) {
                this.Aj.schedule(this.Ai, 45000L);
            }
            eVar.Av = -6;
            this.iAv.cfc().a(this.zZ, boundary, eVar);
            eVar.Av = -7;
            String contentType = this.zZ.getContentType();
            this.tZ = System.currentTimeMillis();
            if (f.aF(contentType)) {
                this.zZ.disconnect();
                this.zZ.connect();
                if (this.iAv.cfd().AJ) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.iAv.cfd().AJ) {
                throw new BdHttpCancelException();
            }
            eVar.Av = -8;
            this.iAv.cfd().e(this.zZ);
            eVar.Au = this.iAv.cfd().responseCode;
            eVar.Ao = this.zZ.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.zZ);
            if (c != null) {
                eVar.Ao += c.length;
                this.iAv.cfd().AO = c.length;
                this.iAv.cfd().AN = c(this.iAv.cfd().contentEncoding, c);
            }
            eVar.Ap = new Date().getTime() - time;
            eVar.Av = -9;
        } finally {
            if (this.Aj != null) {
                this.Aj.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.zZ);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.iAu = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.iAv.cfc().getUrl();
            eVar2.url = url;
            this.zZ = a(a(url, eVar2), i2, i);
            this.zZ.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.iAv.cfd().AJ) {
                this.Ac = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.g(null);
                com.baidu.adp.lib.g.a.f(this.zZ);
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
                this.iAv.cfc().d(this.zZ);
                this.zZ.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.zZ.connect();
                if (this.Aa <= 0) {
                    this.Aa = System.currentTimeMillis();
                }
                this.Ab = System.currentTimeMillis();
                int responseCode = this.zZ.getResponseCode();
                while (yU(responseCode) && this.iAu <= 5) {
                    this.zZ = a(this.zZ, i2, i);
                    this.iAv.cfc().d(this.zZ);
                    this.zZ.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.zZ.connect();
                    responseCode = this.zZ.getResponseCode();
                }
                this.tZ = System.currentTimeMillis();
                this.iAv.cfd().responseCode = responseCode;
                if (ib()) {
                    if (this.zZ.getContentType() != null && this.zZ.getContentType().contains("text/vnd.wap.wml")) {
                        this.zZ.disconnect();
                        this.iAv.cfd().responseCode = 0;
                        boolean a = a(str, jVar, i, i2, z, eVar2, z2);
                        this.Ac = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.g(null);
                        com.baidu.adp.lib.g.a.f(this.zZ);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.zZ.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.f(headerField2.substring(indexOf + 1), 0);
                    }
                    int f = (i3 == 0 && this.iAv.cfd().responseCode == 200 && (headerField = this.zZ.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.f(headerField, 0) : i3;
                    this.iAv.cfd().contentLength = String.valueOf(f);
                    eVar2.An = url.getBytes().length;
                    eVar2.Ao = this.zZ.getHeaderFields().toString().getBytes().length;
                    eVar2.Ao += f;
                    if (this.iAv.cfd().responseCode == 416 || this.iAv.cfd().responseCode == 204) {
                        this.Ac = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.g(null);
                        com.baidu.adp.lib.g.a.f(this.zZ);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (f != 0 && length >= f) {
                        this.Ac = System.currentTimeMillis();
                        this.Ac = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.g(null);
                        com.baidu.adp.lib.g.a.f(this.zZ);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.zZ.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = f > 0 ? f / 50 : 0;
                            int i6 = 0;
                            if (jVar != null && length > 0) {
                                jVar.m((int) length, f);
                            }
                            while (!this.iAv.cfd().AJ) {
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
                                this.Ac = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.g(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.zZ);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.Ac = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.g(inputStream);
                            com.baidu.adp.lib.g.a.f(this.zZ);
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
        this.iAu++;
        return a;
    }

    private boolean yU(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean ib() {
        return this.iAv.cfd().responseCode == 200 || this.iAv.cfd().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.Av = -1;
        try {
            String url = this.iAv.cfc().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.iAv.cfd().AJ) {
                throw new BdHttpCancelException();
            }
            eVar.Av = -2;
            this.zZ = c(a);
            eVar.Av = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.zZ == null) {
                throw new SocketException("network not available.");
            }
            this.zZ.setRequestMethod("POST");
            this.zZ.setDoOutput(true);
            this.zZ.setDoInput(true);
            this.zZ.setConnectTimeout(i2);
            this.zZ.setReadTimeout(i);
            this.zZ.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.iAv.cfd().AJ) {
                throw new BdHttpCancelException();
            }
            this.iAv.cfc().d(this.zZ);
            if (this.iAv.cfd().AJ) {
                throw new BdHttpCancelException();
            }
            eVar.As = System.currentTimeMillis() - currentTimeMillis;
            eVar.Av = -4;
            this.zZ.connect();
            if (this.Aa <= 0) {
                this.Aa = System.currentTimeMillis();
            }
            this.Ab = System.currentTimeMillis();
            eVar.Av = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.As;
            if (this.iAv.cfd().AJ) {
                throw new BdHttpCancelException();
            }
            eVar.Av = -6;
            this.iAv.cfc().a(this.zZ, eVar);
            eVar.Av = -7;
            if (this.iAv.cfd().AJ) {
                throw new BdHttpCancelException();
            }
            String contentType = this.zZ.getContentType();
            this.tZ = System.currentTimeMillis();
            if (f.aF(contentType)) {
                this.zZ.disconnect();
                this.zZ.connect();
                if (this.iAv.cfd().AJ) {
                    throw new BdHttpCancelException();
                }
            }
            this.iAv.cfd().e(this.zZ);
            eVar.Av = -8;
            eVar.Au = this.iAv.cfd().responseCode;
            eVar.Ao = this.zZ.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.zZ);
            if (c != null) {
                eVar.Ao += c.length;
                this.iAv.cfd().AO = c.length;
                this.iAv.cfd().AN = c(this.iAv.cfd().contentEncoding, c);
            }
            eVar.Ap = new Date().getTime() - currentTimeMillis;
            eVar.Av = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.zZ);
        }
    }
}
