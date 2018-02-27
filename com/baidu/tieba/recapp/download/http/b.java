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
    private HttpURLConnection aiN;
    private int gCL;
    private g gCM;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int gCK = 5;
    private long aiO = 0;
    private long aiP = 0;
    private long acF = 0;
    private long aiQ = 0;
    private long aiR = 0;
    private boolean aiS = false;
    private boolean aiT = true;
    private TimerTask aiU = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.mS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer aiV = new Timer();

    public long mO() {
        return this.aiO;
    }

    public boolean mR() {
        return this.aiS;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.gCM = gVar;
    }

    public void mS() {
        this.gCM.bou().ajv = true;
        com.baidu.adp.lib.g.a.f(this.aiN);
    }

    private URL a(String str, e eVar) throws Exception {
        a bor;
        URL url = new URL(str);
        if (this.aiT && (bor = a.bor()) != null) {
            String ao = bor.ao(str);
            if (!TextUtils.isEmpty(ao)) {
                this.gCM.bot().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ao));
                this.aiS = true;
                eVar.ajj = ao;
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
        String oT;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.baidu.adp.lib.util.j.oJ()) {
                if (com.baidu.adp.lib.util.j.oL() && (oT = com.baidu.adp.lib.util.j.oT()) != null && oT.length() > 0) {
                    if (com.baidu.adp.lib.util.j.aS(oT) && com.baidu.adp.lib.util.j.oV()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(oT);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.gCM.bot().o("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(oT, com.baidu.adp.lib.util.j.oU())));
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
        eVar.ajh = -1;
        if (this.gCM.bou().ajv) {
            throw new BdHttpCancelException();
        }
        String c = this.gCM.bot().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.gCM.bou().ajv) {
            throw new BdHttpCancelException();
        }
        eVar.ajh = -2;
        this.aiN = c(a);
        eVar.ajh = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.aiN == null) {
                throw new SocketException("network not available.");
            }
            this.aiN.setRequestMethod("GET");
            this.aiN.setConnectTimeout(i2);
            this.aiN.setReadTimeout(i);
            this.gCM.bot().d(this.aiN);
            if (this.gCM.bou().ajv) {
                throw new BdHttpCancelException();
            }
            eVar.aje = new Date().getTime() - currentTimeMillis;
            eVar.ajh = -4;
            this.aiN.connect();
            if (this.aiO <= 0) {
                this.aiO = System.currentTimeMillis();
            }
            this.aiP = System.currentTimeMillis();
            eVar.ajh = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.aje;
            if (this.gCM.bou().ajv) {
                throw new BdHttpCancelException();
            }
            String contentType = this.aiN.getContentType();
            this.acF = System.currentTimeMillis();
            if (f.as(contentType)) {
                this.aiN.disconnect();
                this.aiN.connect();
                if (this.gCM.bou().ajv) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.ajh = -8;
            this.gCM.bou().e(this.aiN);
            if (c.contains("c.tieba.baidu.com") && (map = this.gCM.bou().ajx) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.ajk = list.get(0);
                eVar.ajl = list.get(1);
            }
            eVar.ajg = this.gCM.bou().responseCode;
            eVar.aja = this.aiN.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.aiN);
            if (c2 != null) {
                eVar.aja += c2.length;
                this.gCM.bou().ajy = c(this.gCM.bou().contentEncoding, c2);
            }
            eVar.ajh = -9;
            eVar.ajb = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.aiN != null) {
                this.aiN.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.c(byteArrayInputStream, byteArrayOutputStream);
            this.aiR = System.currentTimeMillis();
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
                while (!this.gCM.bou().ajv && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.aiQ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.d(inputStream);
                        throw th;
                    }
                }
                if (this.gCM.bou().ajv) {
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
        this.aiQ = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.d(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.ajh = -1;
        try {
            String url = this.gCM.bot().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gCM.bou().ajv) {
                throw new BdHttpCancelException();
            }
            eVar.ajh = -2;
            this.aiN = c(a);
            eVar.ajh = -3;
            System.currentTimeMillis();
            if (this.aiN == null) {
                throw new SocketException("network not available.");
            }
            this.aiN.setRequestMethod("POST");
            this.aiN.setDoOutput(true);
            this.aiN.setDoInput(true);
            this.aiN.setConnectTimeout(i2);
            this.aiN.setReadTimeout(i);
            this.aiN.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.gCM.bou().ajv) {
                throw new BdHttpCancelException();
            }
            this.gCM.bot().d(this.aiN);
            if (this.gCM.bou().ajv) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.aje = new Date().getTime() - time;
            eVar.ajh = -4;
            this.aiN.connect();
            if (this.aiO <= 0) {
                this.aiO = System.currentTimeMillis();
            }
            this.aiP = System.currentTimeMillis();
            eVar.ajh = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.aje;
            if (this.gCM.bou().ajv) {
                throw new BdHttpCancelException();
            }
            if (this.aiV != null) {
                this.aiV.schedule(this.aiU, 45000L);
            }
            eVar.ajh = -6;
            this.gCM.bot().a(this.aiN, boundary, eVar);
            eVar.ajh = -7;
            String contentType = this.aiN.getContentType();
            this.acF = System.currentTimeMillis();
            if (f.as(contentType)) {
                this.aiN.disconnect();
                this.aiN.connect();
                if (this.gCM.bou().ajv) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.gCM.bou().ajv) {
                throw new BdHttpCancelException();
            }
            eVar.ajh = -8;
            this.gCM.bou().e(this.aiN);
            eVar.ajg = this.gCM.bou().responseCode;
            eVar.aja = this.aiN.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.aiN);
            if (c != null) {
                eVar.aja += c.length;
                this.gCM.bou().ajz = c.length;
                this.gCM.bou().ajy = c(this.gCM.bou().contentEncoding, c);
            }
            eVar.ajb = new Date().getTime() - time;
            eVar.ajh = -9;
        } finally {
            if (this.aiV != null) {
                this.aiV.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.aiN);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.gCL = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.gCM.bot().getUrl();
            eVar2.url = url;
            this.aiN = a(a(url, eVar2), i2, i);
            this.aiN.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.gCM.bou().ajv) {
                this.aiQ = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.f(this.aiN);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.aM(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.aK(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.gCM.bot().d(this.aiN);
                this.aiN.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.aiN.connect();
                if (this.aiO <= 0) {
                    this.aiO = System.currentTimeMillis();
                }
                this.aiP = System.currentTimeMillis();
                int responseCode = this.aiN.getResponseCode();
                while (uq(responseCode) && this.gCL <= 5) {
                    this.aiN = a(this.aiN, i2, i);
                    this.gCM.bot().d(this.aiN);
                    this.aiN.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.aiN.connect();
                    responseCode = this.aiN.getResponseCode();
                }
                this.acF = System.currentTimeMillis();
                this.gCM.bou().responseCode = responseCode;
                if (mT()) {
                    if (this.aiN.getContentType() != null && this.aiN.getContentType().contains("text/vnd.wap.wml")) {
                        this.aiN.disconnect();
                        this.gCM.bou().responseCode = 0;
                        boolean a = a(str, jVar, i, i2, z, eVar2, z2);
                        this.aiQ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.aiN);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.aiN.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.h(headerField2.substring(indexOf + 1), 0);
                    }
                    int h = (i3 == 0 && this.gCM.bou().responseCode == 200 && (headerField = this.aiN.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.h(headerField, 0) : i3;
                    this.gCM.bou().contentLength = String.valueOf(h);
                    eVar2.aiZ = url.getBytes().length;
                    eVar2.aja = this.aiN.getHeaderFields().toString().getBytes().length;
                    eVar2.aja += h;
                    if (this.gCM.bou().responseCode == 416 || this.gCM.bou().responseCode == 204) {
                        this.aiQ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.aiN);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (h != 0 && length >= h) {
                        this.aiQ = System.currentTimeMillis();
                        this.aiQ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.aiN);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.aiN.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = h > 0 ? h / 50 : 0;
                            int i6 = 0;
                            if (jVar != null && length > 0) {
                                jVar.an((int) length, h);
                            }
                            while (!this.gCM.bou().ajv) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i4 += read;
                                        i6 += read;
                                        if (jVar != null && (i6 > i5 || i4 == h)) {
                                            i6 = 0;
                                            jVar.an((int) (i4 + length), h);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i4) + length >= ((long) h);
                                this.aiQ = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.d(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.aiN);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.aiQ = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.d(inputStream);
                            com.baidu.adp.lib.g.a.f(this.aiN);
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
        this.gCL++;
        return a;
    }

    private boolean uq(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean mT() {
        return this.gCM.bou().responseCode == 200 || this.gCM.bou().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.ajh = -1;
        try {
            String url = this.gCM.bot().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gCM.bou().ajv) {
                throw new BdHttpCancelException();
            }
            eVar.ajh = -2;
            this.aiN = c(a);
            eVar.ajh = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.aiN == null) {
                throw new SocketException("network not available.");
            }
            this.aiN.setRequestMethod("POST");
            this.aiN.setDoOutput(true);
            this.aiN.setDoInput(true);
            this.aiN.setConnectTimeout(i2);
            this.aiN.setReadTimeout(i);
            this.aiN.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.gCM.bou().ajv) {
                throw new BdHttpCancelException();
            }
            this.gCM.bot().d(this.aiN);
            if (this.gCM.bou().ajv) {
                throw new BdHttpCancelException();
            }
            eVar.aje = System.currentTimeMillis() - currentTimeMillis;
            eVar.ajh = -4;
            this.aiN.connect();
            if (this.aiO <= 0) {
                this.aiO = System.currentTimeMillis();
            }
            this.aiP = System.currentTimeMillis();
            eVar.ajh = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.aje;
            if (this.gCM.bou().ajv) {
                throw new BdHttpCancelException();
            }
            eVar.ajh = -6;
            this.gCM.bot().a(this.aiN, eVar);
            eVar.ajh = -7;
            if (this.gCM.bou().ajv) {
                throw new BdHttpCancelException();
            }
            String contentType = this.aiN.getContentType();
            this.acF = System.currentTimeMillis();
            if (f.as(contentType)) {
                this.aiN.disconnect();
                this.aiN.connect();
                if (this.gCM.bou().ajv) {
                    throw new BdHttpCancelException();
                }
            }
            this.gCM.bou().e(this.aiN);
            eVar.ajh = -8;
            eVar.ajg = this.gCM.bou().responseCode;
            eVar.aja = this.aiN.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.aiN);
            if (c != null) {
                eVar.aja += c.length;
                this.gCM.bou().ajz = c.length;
                this.gCM.bou().ajy = c(this.gCM.bou().contentEncoding, c);
            }
            eVar.ajb = new Date().getTime() - currentTimeMillis;
            eVar.ajh = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.aiN);
        }
    }
}
