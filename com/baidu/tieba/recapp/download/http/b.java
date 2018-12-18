package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.webkit.internal.ABTestConstants;
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
    private HttpURLConnection Cs;
    private int gMx;
    private g gMy;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int gMw = 5;
    private long Ct = 0;
    private long Cu = 0;
    private long wx = 0;
    private long Cv = 0;
    private long Cw = 0;
    private boolean Cx = false;
    private boolean Cy = true;
    private TimerTask Cz = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.jg();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer CA = new Timer();

    public long jc() {
        return this.Ct;
    }

    public boolean jf() {
        return this.Cx;
    }

    static {
        System.setProperty("http.keepAlive", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.gMy = gVar;
    }

    public void jg() {
        this.gMy.buP().Dd = true;
        com.baidu.adp.lib.g.a.h(this.Cs);
    }

    private URL a(String str, e eVar) throws Exception {
        a buM;
        URL url = new URL(str);
        if (this.Cy && (buM = a.buM()) != null) {
            String aP = buM.aP(str);
            if (!TextUtils.isEmpty(aP)) {
                this.gMy.buO().y("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + aP));
                this.Cx = true;
                eVar.CP = aP;
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
        String le;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.baidu.adp.lib.util.j.kV()) {
                if (com.baidu.adp.lib.util.j.kX() && (le = com.baidu.adp.lib.util.j.le()) != null && le.length() > 0) {
                    if (com.baidu.adp.lib.util.j.bu(le) && com.baidu.adp.lib.util.j.lg()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(le);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.gMy.buO().y("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(le, com.baidu.adp.lib.util.j.lf())));
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
        eVar.CN = -1;
        if (this.gMy.buP().Dd) {
            throw new BdHttpCancelException();
        }
        String c = this.gMy.buO().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.gMy.buP().Dd) {
            throw new BdHttpCancelException();
        }
        eVar.CN = -2;
        this.Cs = c(a);
        eVar.CN = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.Cs == null) {
                throw new SocketException("network not available.");
            }
            this.Cs.setRequestMethod("GET");
            this.Cs.setConnectTimeout(i2);
            this.Cs.setReadTimeout(i);
            this.gMy.buO().f(this.Cs);
            if (this.gMy.buP().Dd) {
                throw new BdHttpCancelException();
            }
            eVar.CK = new Date().getTime() - currentTimeMillis;
            eVar.CN = -4;
            this.Cs.connect();
            if (this.Ct <= 0) {
                this.Ct = System.currentTimeMillis();
            }
            this.Cu = System.currentTimeMillis();
            eVar.CN = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.CK;
            if (this.gMy.buP().Dd) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Cs.getContentType();
            this.wx = System.currentTimeMillis();
            if (f.aU(contentType)) {
                this.Cs.disconnect();
                this.Cs.connect();
                if (this.gMy.buP().Dd) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.CN = -8;
            this.gMy.buP().g(this.Cs);
            if (c.contains("c.tieba.baidu.com") && (map = this.gMy.buP().Df) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.CQ = list.get(0);
                eVar.CT = list.get(1);
            }
            eVar.CM = this.gMy.buP().responseCode;
            eVar.CG = this.Cs.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Cs);
            if (e != null) {
                eVar.CG += e.length;
                this.gMy.buP().Dg = c(this.gMy.buP().contentEncoding, e);
            }
            eVar.CN = -9;
            eVar.CH = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.Cs != null) {
                this.Cs.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.Cw = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        }
        return bArr;
    }

    private byte[] e(HttpURLConnection httpURLConnection) throws Exception {
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
                while (!this.gMy.buP().Dd && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.Cv = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.h(inputStream);
                        throw th;
                    }
                }
                if (this.gMy.buP().Dd) {
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
        this.Cv = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.h(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.CN = -1;
        try {
            String url = this.gMy.buO().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gMy.buP().Dd) {
                throw new BdHttpCancelException();
            }
            eVar.CN = -2;
            this.Cs = c(a);
            eVar.CN = -3;
            System.currentTimeMillis();
            if (this.Cs == null) {
                throw new SocketException("network not available.");
            }
            this.Cs.setRequestMethod("POST");
            this.Cs.setDoOutput(true);
            this.Cs.setDoInput(true);
            this.Cs.setConnectTimeout(i2);
            this.Cs.setReadTimeout(i);
            this.Cs.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.gMy.buP().Dd) {
                throw new BdHttpCancelException();
            }
            this.gMy.buO().f(this.Cs);
            if (this.gMy.buP().Dd) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.CK = new Date().getTime() - time;
            eVar.CN = -4;
            this.Cs.connect();
            if (this.Ct <= 0) {
                this.Ct = System.currentTimeMillis();
            }
            this.Cu = System.currentTimeMillis();
            eVar.CN = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.CK;
            if (this.gMy.buP().Dd) {
                throw new BdHttpCancelException();
            }
            if (this.CA != null) {
                this.CA.schedule(this.Cz, 45000L);
            }
            eVar.CN = -6;
            this.gMy.buO().a(this.Cs, boundary, eVar);
            eVar.CN = -7;
            String contentType = this.Cs.getContentType();
            this.wx = System.currentTimeMillis();
            if (f.aU(contentType)) {
                this.Cs.disconnect();
                this.Cs.connect();
                if (this.gMy.buP().Dd) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.gMy.buP().Dd) {
                throw new BdHttpCancelException();
            }
            eVar.CN = -8;
            this.gMy.buP().g(this.Cs);
            eVar.CM = this.gMy.buP().responseCode;
            eVar.CG = this.Cs.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Cs);
            if (e != null) {
                eVar.CG += e.length;
                this.gMy.buP().Dh = e.length;
                this.gMy.buP().Dg = c(this.gMy.buP().contentEncoding, e);
            }
            eVar.CH = new Date().getTime() - time;
            eVar.CN = -9;
        } finally {
            if (this.CA != null) {
                this.CA.cancel();
            }
            com.baidu.adp.lib.g.a.h(this.Cs);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.gMx = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.gMy.buO().getUrl();
            eVar2.url = url;
            this.Cs = a(a(url, eVar2), i2, i);
            this.Cs.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.gMy.buP().Dd) {
                this.Cv = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.h((InputStream) null);
                com.baidu.adp.lib.g.a.h(this.Cs);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.bo(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.bm(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.gMy.buO().f(this.Cs);
                this.Cs.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.Cs.connect();
                if (this.Ct <= 0) {
                    this.Ct = System.currentTimeMillis();
                }
                this.Cu = System.currentTimeMillis();
                int responseCode = this.Cs.getResponseCode();
                while (tN(responseCode) && this.gMx <= 5) {
                    this.Cs = a(this.Cs, i2, i);
                    this.gMy.buO().f(this.Cs);
                    this.Cs.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.Cs.connect();
                    responseCode = this.Cs.getResponseCode();
                }
                this.wx = System.currentTimeMillis();
                this.gMy.buP().responseCode = responseCode;
                if (jh()) {
                    if (this.Cs.getContentType() != null && this.Cs.getContentType().contains("text/vnd.wap.wml")) {
                        this.Cs.disconnect();
                        this.gMy.buP().responseCode = 0;
                        boolean a = a(str, jVar, i, i2, z, eVar2, z2);
                        this.Cv = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.h((InputStream) null);
                        com.baidu.adp.lib.g.a.h(this.Cs);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.Cs.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.l(headerField2.substring(indexOf + 1), 0);
                    }
                    int l = (i3 == 0 && this.gMy.buP().responseCode == 200 && (headerField = this.Cs.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.l(headerField, 0) : i3;
                    this.gMy.buP().contentLength = String.valueOf(l);
                    eVar2.CF = url.getBytes().length;
                    eVar2.CG = this.Cs.getHeaderFields().toString().getBytes().length;
                    eVar2.CG += l;
                    if (this.gMy.buP().responseCode == 416 || this.gMy.buP().responseCode == 204) {
                        this.Cv = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.h((InputStream) null);
                        com.baidu.adp.lib.g.a.h(this.Cs);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (l != 0 && length >= l) {
                        this.Cv = System.currentTimeMillis();
                        this.Cv = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.h((InputStream) null);
                        com.baidu.adp.lib.g.a.h(this.Cs);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.Cs.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = l > 0 ? l / 50 : 0;
                            int i6 = 0;
                            if (jVar != null && length > 0) {
                                jVar.o((int) length, l);
                            }
                            while (!this.gMy.buP().Dd) {
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
                                this.Cv = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.h(inputStream2);
                                com.baidu.adp.lib.g.a.h(this.Cs);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.Cv = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.h(inputStream);
                            com.baidu.adp.lib.g.a.h(this.Cs);
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
        com.baidu.adp.lib.g.a.h(httpURLConnection);
        HttpURLConnection a = a(url, i, i2);
        this.gMx++;
        return a;
    }

    private boolean tN(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean jh() {
        return this.gMy.buP().responseCode == 200 || this.gMy.buP().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.CN = -1;
        try {
            String url = this.gMy.buO().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gMy.buP().Dd) {
                throw new BdHttpCancelException();
            }
            eVar.CN = -2;
            this.Cs = c(a);
            eVar.CN = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.Cs == null) {
                throw new SocketException("network not available.");
            }
            this.Cs.setRequestMethod("POST");
            this.Cs.setDoOutput(true);
            this.Cs.setDoInput(true);
            this.Cs.setConnectTimeout(i2);
            this.Cs.setReadTimeout(i);
            this.Cs.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.gMy.buP().Dd) {
                throw new BdHttpCancelException();
            }
            this.gMy.buO().f(this.Cs);
            if (this.gMy.buP().Dd) {
                throw new BdHttpCancelException();
            }
            eVar.CK = System.currentTimeMillis() - currentTimeMillis;
            eVar.CN = -4;
            this.Cs.connect();
            if (this.Ct <= 0) {
                this.Ct = System.currentTimeMillis();
            }
            this.Cu = System.currentTimeMillis();
            eVar.CN = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.CK;
            if (this.gMy.buP().Dd) {
                throw new BdHttpCancelException();
            }
            eVar.CN = -6;
            this.gMy.buO().a(this.Cs, eVar);
            eVar.CN = -7;
            if (this.gMy.buP().Dd) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Cs.getContentType();
            this.wx = System.currentTimeMillis();
            if (f.aU(contentType)) {
                this.Cs.disconnect();
                this.Cs.connect();
                if (this.gMy.buP().Dd) {
                    throw new BdHttpCancelException();
                }
            }
            this.gMy.buP().g(this.Cs);
            eVar.CN = -8;
            eVar.CM = this.gMy.buP().responseCode;
            eVar.CG = this.Cs.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Cs);
            if (e != null) {
                eVar.CG += e.length;
                this.gMy.buP().Dh = e.length;
                this.gMy.buP().Dg = c(this.gMy.buP().contentEncoding, e);
            }
            eVar.CH = new Date().getTime() - currentTimeMillis;
            eVar.CN = -9;
        } finally {
            com.baidu.adp.lib.g.a.h(this.Cs);
        }
    }
}
