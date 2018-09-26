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
    private HttpURLConnection BH;
    private int gwF;
    private g gwG;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int gwE = 5;
    private long BI = 0;
    private long BJ = 0;
    private long vH = 0;
    private long BK = 0;
    private long BL = 0;
    private boolean BM = false;
    private boolean BN = true;
    private TimerTask BO = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.iT();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer BP = new Timer();

    public long iP() {
        return this.BI;
    }

    public boolean iS() {
        return this.BM;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.gwG = gVar;
    }

    public void iT() {
        this.gwG.bqm().Cp = true;
        com.baidu.adp.lib.g.a.f(this.BH);
    }

    private URL a(String str, e eVar) throws Exception {
        a bqj;
        URL url = new URL(str);
        if (this.BN && (bqj = a.bqj()) != null) {
            String aP = bqj.aP(str);
            if (!TextUtils.isEmpty(aP)) {
                this.gwG.bql().x("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + aP));
                this.BM = true;
                eVar.Cd = aP;
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
        String kU;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.baidu.adp.lib.util.j.kK()) {
                if (com.baidu.adp.lib.util.j.kM() && (kU = com.baidu.adp.lib.util.j.kU()) != null && kU.length() > 0) {
                    if (com.baidu.adp.lib.util.j.bv(kU) && com.baidu.adp.lib.util.j.kW()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(kU);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.gwG.bql().x("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(kU, com.baidu.adp.lib.util.j.kV())));
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
        eVar.Cb = -1;
        if (this.gwG.bqm().Cp) {
            throw new BdHttpCancelException();
        }
        String c = this.gwG.bql().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.gwG.bqm().Cp) {
            throw new BdHttpCancelException();
        }
        eVar.Cb = -2;
        this.BH = c(a);
        eVar.Cb = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.BH == null) {
                throw new SocketException("network not available.");
            }
            this.BH.setRequestMethod("GET");
            this.BH.setConnectTimeout(i2);
            this.BH.setReadTimeout(i);
            this.gwG.bql().d(this.BH);
            if (this.gwG.bqm().Cp) {
                throw new BdHttpCancelException();
            }
            eVar.BY = new Date().getTime() - currentTimeMillis;
            eVar.Cb = -4;
            this.BH.connect();
            if (this.BI <= 0) {
                this.BI = System.currentTimeMillis();
            }
            this.BJ = System.currentTimeMillis();
            eVar.Cb = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.BY;
            if (this.gwG.bqm().Cp) {
                throw new BdHttpCancelException();
            }
            String contentType = this.BH.getContentType();
            this.vH = System.currentTimeMillis();
            if (f.aV(contentType)) {
                this.BH.disconnect();
                this.BH.connect();
                if (this.gwG.bqm().Cp) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.Cb = -8;
            this.gwG.bqm().e(this.BH);
            if (c.contains("c.tieba.baidu.com") && (map = this.gwG.bqm().Cr) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.Ce = list.get(0);
                eVar.Cf = list.get(1);
            }
            eVar.Ca = this.gwG.bqm().responseCode;
            eVar.BU = this.BH.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.BH);
            if (c2 != null) {
                eVar.BU += c2.length;
                this.gwG.bqm().Cs = c(this.gwG.bqm().contentEncoding, c2);
            }
            eVar.Cb = -9;
            eVar.BV = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.BH != null) {
                this.BH.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.BL = System.currentTimeMillis();
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
                while (!this.gwG.bqm().Cp && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.BK = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.h(inputStream);
                        throw th;
                    }
                }
                if (this.gwG.bqm().Cp) {
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
        this.BK = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.h(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.Cb = -1;
        try {
            String url = this.gwG.bql().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gwG.bqm().Cp) {
                throw new BdHttpCancelException();
            }
            eVar.Cb = -2;
            this.BH = c(a);
            eVar.Cb = -3;
            System.currentTimeMillis();
            if (this.BH == null) {
                throw new SocketException("network not available.");
            }
            this.BH.setRequestMethod("POST");
            this.BH.setDoOutput(true);
            this.BH.setDoInput(true);
            this.BH.setConnectTimeout(i2);
            this.BH.setReadTimeout(i);
            this.BH.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.gwG.bqm().Cp) {
                throw new BdHttpCancelException();
            }
            this.gwG.bql().d(this.BH);
            if (this.gwG.bqm().Cp) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.BY = new Date().getTime() - time;
            eVar.Cb = -4;
            this.BH.connect();
            if (this.BI <= 0) {
                this.BI = System.currentTimeMillis();
            }
            this.BJ = System.currentTimeMillis();
            eVar.Cb = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.BY;
            if (this.gwG.bqm().Cp) {
                throw new BdHttpCancelException();
            }
            if (this.BP != null) {
                this.BP.schedule(this.BO, 45000L);
            }
            eVar.Cb = -6;
            this.gwG.bql().a(this.BH, boundary, eVar);
            eVar.Cb = -7;
            String contentType = this.BH.getContentType();
            this.vH = System.currentTimeMillis();
            if (f.aV(contentType)) {
                this.BH.disconnect();
                this.BH.connect();
                if (this.gwG.bqm().Cp) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.gwG.bqm().Cp) {
                throw new BdHttpCancelException();
            }
            eVar.Cb = -8;
            this.gwG.bqm().e(this.BH);
            eVar.Ca = this.gwG.bqm().responseCode;
            eVar.BU = this.BH.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.BH);
            if (c != null) {
                eVar.BU += c.length;
                this.gwG.bqm().Ct = c.length;
                this.gwG.bqm().Cs = c(this.gwG.bqm().contentEncoding, c);
            }
            eVar.BV = new Date().getTime() - time;
            eVar.Cb = -9;
        } finally {
            if (this.BP != null) {
                this.BP.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.BH);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.gwF = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.gwG.bql().getUrl();
            eVar2.url = url;
            this.BH = a(a(url, eVar2), i2, i);
            this.BH.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.gwG.bqm().Cp) {
                this.BK = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.h(null);
                com.baidu.adp.lib.g.a.f(this.BH);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.bp(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.bn(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.gwG.bql().d(this.BH);
                this.BH.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.BH.connect();
                if (this.BI <= 0) {
                    this.BI = System.currentTimeMillis();
                }
                this.BJ = System.currentTimeMillis();
                int responseCode = this.BH.getResponseCode();
                while (sD(responseCode) && this.gwF <= 5) {
                    this.BH = a(this.BH, i2, i);
                    this.gwG.bql().d(this.BH);
                    this.BH.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.BH.connect();
                    responseCode = this.BH.getResponseCode();
                }
                this.vH = System.currentTimeMillis();
                this.gwG.bqm().responseCode = responseCode;
                if (iU()) {
                    if (this.BH.getContentType() != null && this.BH.getContentType().contains("text/vnd.wap.wml")) {
                        this.BH.disconnect();
                        this.gwG.bqm().responseCode = 0;
                        boolean a = a(str, jVar, i, i2, z, eVar2, z2);
                        this.BK = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.h(null);
                        com.baidu.adp.lib.g.a.f(this.BH);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.BH.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.l(headerField2.substring(indexOf + 1), 0);
                    }
                    int l = (i3 == 0 && this.gwG.bqm().responseCode == 200 && (headerField = this.BH.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.l(headerField, 0) : i3;
                    this.gwG.bqm().contentLength = String.valueOf(l);
                    eVar2.BT = url.getBytes().length;
                    eVar2.BU = this.BH.getHeaderFields().toString().getBytes().length;
                    eVar2.BU += l;
                    if (this.gwG.bqm().responseCode == 416 || this.gwG.bqm().responseCode == 204) {
                        this.BK = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.h(null);
                        com.baidu.adp.lib.g.a.f(this.BH);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (l != 0 && length >= l) {
                        this.BK = System.currentTimeMillis();
                        this.BK = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.h(null);
                        com.baidu.adp.lib.g.a.f(this.BH);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.BH.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = l > 0 ? l / 50 : 0;
                            int i6 = 0;
                            if (jVar != null && length > 0) {
                                jVar.o((int) length, l);
                            }
                            while (!this.gwG.bqm().Cp) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i4 += read;
                                        i6 += read;
                                        if (jVar != null && (i6 > i5 || i4 == l)) {
                                            i6 = 0;
                                            jVar.o((int) (i4 + length), l);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i4) + length >= ((long) l);
                                this.BK = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.h(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.BH);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.BK = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.h(inputStream);
                            com.baidu.adp.lib.g.a.f(this.BH);
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
        this.gwF++;
        return a;
    }

    private boolean sD(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean iU() {
        return this.gwG.bqm().responseCode == 200 || this.gwG.bqm().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.Cb = -1;
        try {
            String url = this.gwG.bql().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gwG.bqm().Cp) {
                throw new BdHttpCancelException();
            }
            eVar.Cb = -2;
            this.BH = c(a);
            eVar.Cb = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.BH == null) {
                throw new SocketException("network not available.");
            }
            this.BH.setRequestMethod("POST");
            this.BH.setDoOutput(true);
            this.BH.setDoInput(true);
            this.BH.setConnectTimeout(i2);
            this.BH.setReadTimeout(i);
            this.BH.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.gwG.bqm().Cp) {
                throw new BdHttpCancelException();
            }
            this.gwG.bql().d(this.BH);
            if (this.gwG.bqm().Cp) {
                throw new BdHttpCancelException();
            }
            eVar.BY = System.currentTimeMillis() - currentTimeMillis;
            eVar.Cb = -4;
            this.BH.connect();
            if (this.BI <= 0) {
                this.BI = System.currentTimeMillis();
            }
            this.BJ = System.currentTimeMillis();
            eVar.Cb = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.BY;
            if (this.gwG.bqm().Cp) {
                throw new BdHttpCancelException();
            }
            eVar.Cb = -6;
            this.gwG.bql().a(this.BH, eVar);
            eVar.Cb = -7;
            if (this.gwG.bqm().Cp) {
                throw new BdHttpCancelException();
            }
            String contentType = this.BH.getContentType();
            this.vH = System.currentTimeMillis();
            if (f.aV(contentType)) {
                this.BH.disconnect();
                this.BH.connect();
                if (this.gwG.bqm().Cp) {
                    throw new BdHttpCancelException();
                }
            }
            this.gwG.bqm().e(this.BH);
            eVar.Cb = -8;
            eVar.Ca = this.gwG.bqm().responseCode;
            eVar.BU = this.BH.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.BH);
            if (c != null) {
                eVar.BU += c.length;
                this.gwG.bqm().Ct = c.length;
                this.gwG.bqm().Cs = c(this.gwG.bqm().contentEncoding, c);
            }
            eVar.BV = new Date().getTime() - currentTimeMillis;
            eVar.Cb = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.BH);
        }
    }
}
