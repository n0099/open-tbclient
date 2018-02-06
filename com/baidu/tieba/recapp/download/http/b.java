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
    private HttpURLConnection aiT;
    private int gDa;
    private g gDb;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private final int gCZ = 5;
    private long aiU = 0;
    private long aiV = 0;
    private long acL = 0;
    private long aiW = 0;
    private long aiX = 0;
    private boolean aiY = false;
    private boolean aiZ = true;
    private TimerTask aja = new TimerTask() { // from class: com.baidu.tieba.recapp.download.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.mS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer ajb = new Timer();

    public long mO() {
        return this.aiU;
    }

    public boolean mR() {
        return this.aiY;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.gDb = gVar;
    }

    public void mS() {
        this.gDb.bov().ajB = true;
        com.baidu.adp.lib.g.a.f(this.aiT);
    }

    private URL a(String str, e eVar) throws Exception {
        a bos;
        URL url = new URL(str);
        if (this.aiZ && (bos = a.bos()) != null) {
            String ao = bos.ao(str);
            if (!TextUtils.isEmpty(ao)) {
                this.gDb.bou().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ao));
                this.aiY = true;
                eVar.ajp = ao;
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
                            this.gDb.bou().o("X-Online-Host", url.getHost());
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
        eVar.ajn = -1;
        if (this.gDb.bov().ajB) {
            throw new BdHttpCancelException();
        }
        String c = this.gDb.bou().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.gDb.bov().ajB) {
            throw new BdHttpCancelException();
        }
        eVar.ajn = -2;
        this.aiT = c(a);
        eVar.ajn = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.aiT == null) {
                throw new SocketException("network not available.");
            }
            this.aiT.setRequestMethod("GET");
            this.aiT.setConnectTimeout(i2);
            this.aiT.setReadTimeout(i);
            this.gDb.bou().d(this.aiT);
            if (this.gDb.bov().ajB) {
                throw new BdHttpCancelException();
            }
            eVar.ajk = new Date().getTime() - currentTimeMillis;
            eVar.ajn = -4;
            this.aiT.connect();
            if (this.aiU <= 0) {
                this.aiU = System.currentTimeMillis();
            }
            this.aiV = System.currentTimeMillis();
            eVar.ajn = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.ajk;
            if (this.gDb.bov().ajB) {
                throw new BdHttpCancelException();
            }
            String contentType = this.aiT.getContentType();
            this.acL = System.currentTimeMillis();
            if (f.as(contentType)) {
                this.aiT.disconnect();
                this.aiT.connect();
                if (this.gDb.bov().ajB) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.ajn = -8;
            this.gDb.bov().e(this.aiT);
            if (c.contains("c.tieba.baidu.com") && (map = this.gDb.bov().ajD) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.ajq = list.get(0);
                eVar.ajr = list.get(1);
            }
            eVar.ajm = this.gDb.bov().responseCode;
            eVar.ajg = this.aiT.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.aiT);
            if (c2 != null) {
                eVar.ajg += c2.length;
                this.gDb.bov().ajE = c(this.gDb.bov().contentEncoding, c2);
            }
            eVar.ajn = -9;
            eVar.ajh = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.aiT != null) {
                this.aiT.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.c(byteArrayInputStream, byteArrayOutputStream);
            this.aiX = System.currentTimeMillis();
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
                while (!this.gDb.bov().ajB && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.aiW = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.d(inputStream);
                        throw th;
                    }
                }
                if (this.gDb.bov().ajB) {
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
        this.aiW = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.d(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.ajn = -1;
        try {
            String url = this.gDb.bou().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gDb.bov().ajB) {
                throw new BdHttpCancelException();
            }
            eVar.ajn = -2;
            this.aiT = c(a);
            eVar.ajn = -3;
            System.currentTimeMillis();
            if (this.aiT == null) {
                throw new SocketException("network not available.");
            }
            this.aiT.setRequestMethod("POST");
            this.aiT.setDoOutput(true);
            this.aiT.setDoInput(true);
            this.aiT.setConnectTimeout(i2);
            this.aiT.setReadTimeout(i);
            this.aiT.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.gDb.bov().ajB) {
                throw new BdHttpCancelException();
            }
            this.gDb.bou().d(this.aiT);
            if (this.gDb.bov().ajB) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.ajk = new Date().getTime() - time;
            eVar.ajn = -4;
            this.aiT.connect();
            if (this.aiU <= 0) {
                this.aiU = System.currentTimeMillis();
            }
            this.aiV = System.currentTimeMillis();
            eVar.ajn = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.ajk;
            if (this.gDb.bov().ajB) {
                throw new BdHttpCancelException();
            }
            if (this.ajb != null) {
                this.ajb.schedule(this.aja, 45000L);
            }
            eVar.ajn = -6;
            this.gDb.bou().a(this.aiT, boundary, eVar);
            eVar.ajn = -7;
            String contentType = this.aiT.getContentType();
            this.acL = System.currentTimeMillis();
            if (f.as(contentType)) {
                this.aiT.disconnect();
                this.aiT.connect();
                if (this.gDb.bov().ajB) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.gDb.bov().ajB) {
                throw new BdHttpCancelException();
            }
            eVar.ajn = -8;
            this.gDb.bov().e(this.aiT);
            eVar.ajm = this.gDb.bov().responseCode;
            eVar.ajg = this.aiT.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.aiT);
            if (c != null) {
                eVar.ajg += c.length;
                this.gDb.bov().ajF = c.length;
                this.gDb.bov().ajE = c(this.gDb.bov().contentEncoding, c);
            }
            eVar.ajh = new Date().getTime() - time;
            eVar.ajn = -9;
        } finally {
            if (this.ajb != null) {
                this.ajb.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.aiT);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=8, 679=6, 680=6, 681=6] */
    public boolean a(String str, j jVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        this.gDa = 0;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.gDb.bou().getUrl();
            eVar2.url = url;
            this.aiT = a(a(url, eVar2), i2, i);
            this.aiT.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
            if (this.gDb.bov().ajB) {
                this.aiW = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.f(this.aiT);
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
                this.gDb.bou().d(this.aiT);
                this.aiT.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.aiT.connect();
                if (this.aiU <= 0) {
                    this.aiU = System.currentTimeMillis();
                }
                this.aiV = System.currentTimeMillis();
                int responseCode = this.aiT.getResponseCode();
                while (up(responseCode) && this.gDa <= 5) {
                    this.aiT = a(this.aiT, i2, i);
                    this.gDb.bou().d(this.aiT);
                    this.aiT.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.aiT.connect();
                    responseCode = this.aiT.getResponseCode();
                }
                this.acL = System.currentTimeMillis();
                this.gDb.bov().responseCode = responseCode;
                if (mT()) {
                    if (this.aiT.getContentType() != null && this.aiT.getContentType().contains("text/vnd.wap.wml")) {
                        this.aiT.disconnect();
                        this.gDb.bov().responseCode = 0;
                        boolean a = a(str, jVar, i, i2, z, eVar2, z2);
                        this.aiW = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.aiT);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.aiT.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.h(headerField2.substring(indexOf + 1), 0);
                    }
                    int h = (i3 == 0 && this.gDb.bov().responseCode == 200 && (headerField = this.aiT.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.h(headerField, 0) : i3;
                    this.gDb.bov().contentLength = String.valueOf(h);
                    eVar2.ajf = url.getBytes().length;
                    eVar2.ajg = this.aiT.getHeaderFields().toString().getBytes().length;
                    eVar2.ajg += h;
                    if (this.gDb.bov().responseCode == 416 || this.gDb.bov().responseCode == 204) {
                        this.aiW = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.aiT);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (h != 0 && length >= h) {
                        this.aiW = System.currentTimeMillis();
                        this.aiW = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.aiT);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.aiT.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = h > 0 ? h / 50 : 0;
                            int i6 = 0;
                            if (jVar != null && length > 0) {
                                jVar.an((int) length, h);
                            }
                            while (!this.gDb.bov().ajB) {
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
                                this.aiW = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.d(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.aiT);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.aiW = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.d(inputStream);
                            com.baidu.adp.lib.g.a.f(this.aiT);
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
        this.gDa++;
        return a;
    }

    private boolean up(int i) {
        return i == 302 || i == 301 || i == 304 || i == 300 || i == 307 || i == 308 || i == 303;
    }

    private boolean mT() {
        return this.gDb.bov().responseCode == 200 || this.gDb.bov().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.ajn = -1;
        try {
            String url = this.gDb.bou().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gDb.bov().ajB) {
                throw new BdHttpCancelException();
            }
            eVar.ajn = -2;
            this.aiT = c(a);
            eVar.ajn = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.aiT == null) {
                throw new SocketException("network not available.");
            }
            this.aiT.setRequestMethod("POST");
            this.aiT.setDoOutput(true);
            this.aiT.setDoInput(true);
            this.aiT.setConnectTimeout(i2);
            this.aiT.setReadTimeout(i);
            this.aiT.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.gDb.bov().ajB) {
                throw new BdHttpCancelException();
            }
            this.gDb.bou().d(this.aiT);
            if (this.gDb.bov().ajB) {
                throw new BdHttpCancelException();
            }
            eVar.ajk = System.currentTimeMillis() - currentTimeMillis;
            eVar.ajn = -4;
            this.aiT.connect();
            if (this.aiU <= 0) {
                this.aiU = System.currentTimeMillis();
            }
            this.aiV = System.currentTimeMillis();
            eVar.ajn = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.ajk;
            if (this.gDb.bov().ajB) {
                throw new BdHttpCancelException();
            }
            eVar.ajn = -6;
            this.gDb.bou().a(this.aiT, eVar);
            eVar.ajn = -7;
            if (this.gDb.bov().ajB) {
                throw new BdHttpCancelException();
            }
            String contentType = this.aiT.getContentType();
            this.acL = System.currentTimeMillis();
            if (f.as(contentType)) {
                this.aiT.disconnect();
                this.aiT.connect();
                if (this.gDb.bov().ajB) {
                    throw new BdHttpCancelException();
                }
            }
            this.gDb.bov().e(this.aiT);
            eVar.ajn = -8;
            eVar.ajm = this.gDb.bov().responseCode;
            eVar.ajg = this.aiT.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.aiT);
            if (c != null) {
                eVar.ajg += c.length;
                this.gDb.bov().ajF = c.length;
                this.gDb.bov().ajE = c(this.gDb.bov().contentEncoding, c);
            }
            eVar.ajh = new Date().getTime() - currentTimeMillis;
            eVar.ajn = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.aiT);
        }
    }
}
