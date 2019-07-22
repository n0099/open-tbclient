package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
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
    private HttpURLConnection Ag;
    private int iGM;
    private g iGN;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int iGL = 5;
    private long Ah = 0;
    private long Ai = 0;
    private long ud = 0;
    private long Aj = 0;
    private long Ak = 0;
    private boolean Al = false;
    private boolean Am = true;
    private TimerTask Ao = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.ik();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer Ap = new Timer();

    public long ig() {
        return this.Ah;
    }

    public boolean ij() {
        return this.Al;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.iGN = gVar;
    }

    public void ik() {
        this.iGN.chU().AQ = true;
        com.baidu.adp.lib.g.a.f(this.Ag);
    }

    private URL a(String str, e eVar) throws Exception {
        a chR;
        URL url = new URL(str);
        if (this.Am && (chR = a.chR()) != null) {
            String aA = chR.aA(str);
            if (!TextUtils.isEmpty(aA)) {
                this.iGN.chT().q(HTTP.TARGET_HOST, url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + aA));
                this.Al = true;
                eVar.AD = aA;
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
        String kl;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.baidu.adp.lib.util.j.kc()) {
                if (com.baidu.adp.lib.util.j.ke() && (kl = com.baidu.adp.lib.util.j.kl()) != null && kl.length() > 0) {
                    if (com.baidu.adp.lib.util.j.bf(kl) && com.baidu.adp.lib.util.j.kn()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(kl);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.iGN.chT().q("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(kl, com.baidu.adp.lib.util.j.km())));
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
        eVar.AB = -1;
        if (this.iGN.chU().AQ) {
            throw new BdHttpCancelException();
        }
        String c = this.iGN.chT().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.iGN.chU().AQ) {
            throw new BdHttpCancelException();
        }
        eVar.AB = -2;
        this.Ag = c(a);
        eVar.AB = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.Ag == null) {
                throw new SocketException("network not available.");
            }
            this.Ag.setRequestMethod("GET");
            this.Ag.setConnectTimeout(i2);
            this.Ag.setReadTimeout(i);
            this.iGN.chT().d(this.Ag);
            if (this.iGN.chU().AQ) {
                throw new BdHttpCancelException();
            }
            eVar.Ay = new Date().getTime() - currentTimeMillis;
            eVar.AB = -4;
            this.Ag.connect();
            if (this.Ah <= 0) {
                this.Ah = System.currentTimeMillis();
            }
            this.Ai = System.currentTimeMillis();
            eVar.AB = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.Ay;
            if (this.iGN.chU().AQ) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Ag.getContentType();
            this.ud = System.currentTimeMillis();
            if (f.aG(contentType)) {
                this.Ag.disconnect();
                this.Ag.connect();
                if (this.iGN.chU().AQ) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.AB = -8;
            this.iGN.chU().e(this.Ag);
            if (c.contains("c.tieba.baidu.com") && (map = this.iGN.chU().AT) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.AE = list.get(0);
                eVar.AF = list.get(1);
            }
            eVar.AA = this.iGN.chU().responseCode;
            eVar.Au = this.Ag.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.Ag);
            if (c2 != null) {
                eVar.Au += c2.length;
                this.iGN.chU().AU = c(this.iGN.chU().contentEncoding, c2);
            }
            eVar.AB = -9;
            eVar.Av = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.Ag != null) {
                this.Ag.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.Ak = System.currentTimeMillis();
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
                while (!this.iGN.chU().AQ && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.Aj = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.c(byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.g(inputStream);
                        throw th;
                    }
                }
                if (this.iGN.chU().AQ) {
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
        this.Aj = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.c(byteArrayOutputStream);
        com.baidu.adp.lib.g.a.g(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.AB = -1;
        try {
            String url = this.iGN.chT().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.iGN.chU().AQ) {
                throw new BdHttpCancelException();
            }
            eVar.AB = -2;
            this.Ag = c(a);
            eVar.AB = -3;
            System.currentTimeMillis();
            if (this.Ag == null) {
                throw new SocketException("network not available.");
            }
            this.Ag.setRequestMethod("POST");
            this.Ag.setDoOutput(true);
            this.Ag.setDoInput(true);
            this.Ag.setConnectTimeout(i2);
            this.Ag.setReadTimeout(i);
            this.Ag.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.iGN.chU().AQ) {
                throw new BdHttpCancelException();
            }
            this.iGN.chT().d(this.Ag);
            if (this.iGN.chU().AQ) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.Ay = new Date().getTime() - time;
            eVar.AB = -4;
            this.Ag.connect();
            if (this.Ah <= 0) {
                this.Ah = System.currentTimeMillis();
            }
            this.Ai = System.currentTimeMillis();
            eVar.AB = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.Ay;
            if (this.iGN.chU().AQ) {
                throw new BdHttpCancelException();
            }
            if (this.Ap != null) {
                this.Ap.schedule(this.Ao, 45000L);
            }
            eVar.AB = -6;
            this.iGN.chT().a(this.Ag, boundary, eVar);
            eVar.AB = -7;
            String contentType = this.Ag.getContentType();
            this.ud = System.currentTimeMillis();
            if (f.aG(contentType)) {
                this.Ag.disconnect();
                this.Ag.connect();
                if (this.iGN.chU().AQ) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.iGN.chU().AQ) {
                throw new BdHttpCancelException();
            }
            eVar.AB = -8;
            this.iGN.chU().e(this.Ag);
            eVar.AA = this.iGN.chU().responseCode;
            eVar.Au = this.Ag.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.Ag);
            if (c != null) {
                eVar.Au += c.length;
                this.iGN.chU().AV = c.length;
                this.iGN.chU().AU = c(this.iGN.chU().contentEncoding, c);
            }
            eVar.Av = new Date().getTime() - time;
            eVar.AB = -9;
        } finally {
            if (this.Ap != null) {
                this.Ap.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.Ag);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.iGM = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.iGN.chT().getUrl();
            eVar2.url = url;
            this.Ag = a(a(url, eVar2), i2, i);
            this.Ag.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.iGN.chU().AQ) {
                this.Aj = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.g(null);
                com.baidu.adp.lib.g.a.f(this.Ag);
                com.baidu.adp.lib.g.a.c(null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.aZ(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.aY(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.iGN.chT().d(this.Ag);
                this.Ag.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.Ag.connect();
                if (this.Ah <= 0) {
                    this.Ah = System.currentTimeMillis();
                }
                this.Ai = System.currentTimeMillis();
                int responseCode = this.Ag.getResponseCode();
                while (zz(responseCode) && this.iGM <= 5) {
                    this.Ag = a(this.Ag, i2, i);
                    this.iGN.chT().d(this.Ag);
                    this.Ag.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.Ag.connect();
                    responseCode = this.Ag.getResponseCode();
                }
                this.ud = System.currentTimeMillis();
                this.iGN.chU().responseCode = responseCode;
                if (il()) {
                    if (this.Ag.getContentType() != null && this.Ag.getContentType().contains("text/vnd.wap.wml")) {
                        this.Ag.disconnect();
                        this.iGN.chU().responseCode = 0;
                        boolean a = a(str, jVar, i, i2, z, eVar2, z2);
                        this.Aj = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.g(null);
                        com.baidu.adp.lib.g.a.f(this.Ag);
                        com.baidu.adp.lib.g.a.c(fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.Ag.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.f(headerField2.substring(indexOf + 1), 0);
                    }
                    int f = (i3 == 0 && this.iGN.chU().responseCode == 200 && (headerField = this.Ag.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.f(headerField, 0) : i3;
                    this.iGN.chU().contentLength = String.valueOf(f);
                    eVar2.At = url.getBytes().length;
                    eVar2.Au = this.Ag.getHeaderFields().toString().getBytes().length;
                    eVar2.Au += f;
                    if (this.iGN.chU().responseCode == 416 || this.iGN.chU().responseCode == 204) {
                        this.Aj = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.g(null);
                        com.baidu.adp.lib.g.a.f(this.Ag);
                        com.baidu.adp.lib.g.a.c(fileOutputStream2);
                        return true;
                    } else if (f != 0 && length >= f) {
                        this.Aj = System.currentTimeMillis();
                        this.Aj = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.g(null);
                        com.baidu.adp.lib.g.a.f(this.Ag);
                        com.baidu.adp.lib.g.a.c(fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.Ag.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = f > 0 ? f / 50 : 0;
                            int i6 = 0;
                            if (jVar != null && length > 0) {
                                jVar.o((int) length, f);
                            }
                            while (!this.iGN.chU().AQ) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i4 += read;
                                        i6 += read;
                                        if (jVar != null && (i6 > i5 || i4 == f)) {
                                            i6 = 0;
                                            jVar.o((int) (i4 + length), f);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i4) + length >= ((long) f);
                                this.Aj = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.g(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.Ag);
                                com.baidu.adp.lib.g.a.c(fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.Aj = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.g(inputStream);
                            com.baidu.adp.lib.g.a.f(this.Ag);
                            com.baidu.adp.lib.g.a.c(fileOutputStream);
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
        this.iGM++;
        return a;
    }

    private boolean zz(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean il() {
        return this.iGN.chU().responseCode == 200 || this.iGN.chU().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.AB = -1;
        try {
            String url = this.iGN.chT().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.iGN.chU().AQ) {
                throw new BdHttpCancelException();
            }
            eVar.AB = -2;
            this.Ag = c(a);
            eVar.AB = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.Ag == null) {
                throw new SocketException("network not available.");
            }
            this.Ag.setRequestMethod("POST");
            this.Ag.setDoOutput(true);
            this.Ag.setDoInput(true);
            this.Ag.setConnectTimeout(i2);
            this.Ag.setReadTimeout(i);
            this.Ag.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.iGN.chU().AQ) {
                throw new BdHttpCancelException();
            }
            this.iGN.chT().d(this.Ag);
            if (this.iGN.chU().AQ) {
                throw new BdHttpCancelException();
            }
            eVar.Ay = System.currentTimeMillis() - currentTimeMillis;
            eVar.AB = -4;
            this.Ag.connect();
            if (this.Ah <= 0) {
                this.Ah = System.currentTimeMillis();
            }
            this.Ai = System.currentTimeMillis();
            eVar.AB = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.Ay;
            if (this.iGN.chU().AQ) {
                throw new BdHttpCancelException();
            }
            eVar.AB = -6;
            this.iGN.chT().a(this.Ag, eVar);
            eVar.AB = -7;
            if (this.iGN.chU().AQ) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Ag.getContentType();
            this.ud = System.currentTimeMillis();
            if (f.aG(contentType)) {
                this.Ag.disconnect();
                this.Ag.connect();
                if (this.iGN.chU().AQ) {
                    throw new BdHttpCancelException();
                }
            }
            this.iGN.chU().e(this.Ag);
            eVar.AB = -8;
            eVar.AA = this.iGN.chU().responseCode;
            eVar.Au = this.Ag.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.Ag);
            if (c != null) {
                eVar.Au += c.length;
                this.iGN.chU().AV = c.length;
                this.iGN.chU().AU = c(this.iGN.chU().contentEncoding, c);
            }
            eVar.Av = new Date().getTime() - currentTimeMillis;
            eVar.AB = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.Ag);
        }
    }
}
