package com.baidu.tieba.util;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.hp.NetworkProxy;
import com.baidu.zeus.NotificationProxy;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class NetWorkCore {
    private static /* synthetic */ int[] A;
    private static String a = "\r\n";
    private static String b = "--";
    private static String c = "--------7da3d81520810*";
    private static int d = 2097152;
    private static Handler e = null;
    private static volatile String f = null;
    private static volatile boolean g = false;
    private static Pattern h = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    private static ArrayList y = new ArrayList();
    private static AtomicInteger z = new AtomicInteger(0);
    private HttpURLConnection i;
    private String j;
    private int k;
    private int l;
    private String m;
    private int n;
    private ArrayList o;
    private HashMap p;
    private boolean q;
    private Context r;
    private boolean s;
    private boolean t;
    private volatile boolean u;
    private boolean v = true;
    private boolean w = true;
    private int x = 0;

    /* loaded from: classes.dex */
    public enum NetworkState {
        UNAVAIL,
        WIFI,
        MOBILE;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetworkState[] valuesCustom() {
            NetworkState[] valuesCustom = values();
            int length = valuesCustom.length;
            NetworkState[] networkStateArr = new NetworkState[length];
            System.arraycopy(valuesCustom, 0, networkStateArr, 0, length);
            return networkStateArr;
        }
    }

    /* loaded from: classes.dex */
    public enum NetworkStateInfo {
        UNAVAIL,
        WIFI,
        TwoG,
        ThreeG;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetworkStateInfo[] valuesCustom() {
            NetworkStateInfo[] valuesCustom = values();
            int length = valuesCustom.length;
            NetworkStateInfo[] networkStateInfoArr = new NetworkStateInfo[length];
            System.arraycopy(valuesCustom, 0, networkStateInfoArr, 0, length);
            return networkStateInfoArr;
        }
    }

    static /* synthetic */ int[] u() {
        int[] iArr = A;
        if (iArr == null) {
            iArr = new int[NetworkStateInfo.valuesCustom().length];
            try {
                iArr[NetworkStateInfo.ThreeG.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[NetworkStateInfo.TwoG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[NetworkStateInfo.UNAVAIL.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[NetworkStateInfo.WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            A = iArr;
        }
        return iArr;
    }

    public static int a(int i) {
        return z.getAndSet(i);
    }

    public static int b(int i) {
        return z.addAndGet(i);
    }

    public static synchronized void a(v vVar) {
        synchronized (NetWorkCore.class) {
            if (vVar != null) {
                if (y.size() <= 20) {
                    y.add(vVar);
                }
            }
        }
    }

    public static synchronized v a() {
        v vVar;
        synchronized (NetWorkCore.class) {
            int size = y.size();
            vVar = size > 0 ? (v) y.remove(size - 1) : null;
        }
        return vVar;
    }

    private int a(NetworkStateInfo networkStateInfo) {
        switch (u()[networkStateInfo.ordinal()]) {
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            default:
                return 0;
        }
    }

    private void v() {
        this.i = null;
        this.j = null;
        this.k = 0;
        this.l = 0;
        this.m = null;
        this.o = null;
        this.r = null;
        this.q = true;
        this.n = 0;
        this.u = false;
        this.s = false;
        this.p = null;
        this.t = false;
        this.w = true;
        c();
    }

    public void a(boolean z2) {
        this.w = z2;
    }

    public String b() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.r.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    return "3";
                }
                String defaultHost = Proxy.getDefaultHost();
                if (defaultHost != null) {
                    if (defaultHost.length() > 0) {
                        return "2";
                    }
                }
                return "1";
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public static void c() {
        synchronized (NetWorkCore.class) {
            if (!g) {
                g = true;
                d();
            }
        }
    }

    public static synchronized void d() {
        synchronized (NetWorkCore.class) {
            try {
                Cursor query = TiebaApplication.f().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    f = "Basic " + y.b((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e2) {
            }
        }
    }

    public static void e() {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        } else {
            System.setProperty("http.keepAlive", "true");
        }
        e = new u();
    }

    public NetWorkCore() {
        v();
        this.r = TiebaApplication.f();
    }

    public NetWorkCore(String str) {
        v();
        this.r = TiebaApplication.f();
        this.j = str;
    }

    public void a(Boolean bool) {
        this.q = bool.booleanValue();
    }

    public static NetworkState a(Context context) {
        NetworkState networkState;
        NetworkState networkState2 = NetworkState.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                networkState = NetworkState.UNAVAIL;
            } else if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                networkState = NetworkState.WIFI;
            } else {
                networkState = NetworkState.MOBILE;
            }
            return networkState;
        } catch (Exception e2) {
            return networkState2;
        }
    }

    public void a(String str) {
        this.j = str;
    }

    public String f() {
        return this.j;
    }

    public boolean g() {
        return this.k == 200 && this.l == 0;
    }

    public boolean h() {
        return this.k == 200;
    }

    public int i() {
        return this.l;
    }

    public String j() {
        return this.m;
    }

    public void k() {
        this.m = "";
    }

    public void b(String str) {
        this.m = str;
    }

    public void l() {
        this.u = true;
        try {
            if (this.i != null) {
                this.i.disconnect();
            }
        } catch (Exception e2) {
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x00c1 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    private HttpURLConnection a(URL url) {
        ?? r0;
        Exception e2;
        String defaultHost;
        HttpURLConnection httpURLConnection = null;
        NetworkState a2 = a(this.r);
        this.t = false;
        try {
            if (a2 == NetworkState.UNAVAIL) {
                return null;
            }
            if (a2 == NetworkState.MOBILE && (defaultHost = Proxy.getDefaultHost()) != null && defaultHost.length() > 0) {
                r0 = d(defaultHost);
                try {
                    if (r0 != 0) {
                        this.t = true;
                        StringBuilder sb = new StringBuilder(80);
                        sb.append(com.baidu.loginshare.e.f);
                        sb.append(Proxy.getDefaultHost());
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        httpURLConnection2.setRequestProperty(HttpUtils.HEADER_NAME_CMWAP_ONLINE_HOST, url.getHost());
                        httpURLConnection = httpURLConnection2;
                    } else {
                        HttpURLConnection httpURLConnection3 = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort())));
                        if (f != null) {
                            httpURLConnection3.setRequestProperty("Proxy-Authorization", f);
                        }
                        httpURLConnection = httpURLConnection3;
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    z.b(getClass().getName(), "getConnect", "error = " + e2.getMessage());
                    return r0;
                }
            }
            if (httpURLConnection == null) {
                try {
                    return (HttpURLConnection) url.openConnection();
                } catch (Exception e4) {
                    r0 = httpURLConnection;
                    e2 = e4;
                    z.b(getClass().getName(), "getConnect", "error = " + e2.getMessage());
                    return r0;
                }
            }
            return httpURLConnection;
        } catch (Exception e5) {
            r0 = 0;
            e2 = e5;
        }
    }

    private boolean d(String str) {
        if (h.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [637=9, 638=9, 642=9, 643=9, 645=8] */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0202, code lost:
        if (r1 == null) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0204, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0143, code lost:
        if (0 == 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0145, code lost:
        r3.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03d8 A[Catch: Exception -> 0x03f7, TRY_LEAVE, TryCatch #5 {Exception -> 0x03f7, blocks: (B:181:0x03d4, B:183:0x03d8), top: B:227:0x03d4 }] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x03d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] m() {
        byte[] bArr;
        String str;
        InputStream inputStream;
        InputStream inputStream2;
        Exception e2;
        int read;
        String headerField;
        if (NetworkProxy.f(this, this.i, this.j, this.m, this.o, this.p)) {
            return NetworkProxy.g(this, this.i, this.j, this.m, this.o, this.p);
        }
        bArr = null;
        boolean z2 = true;
        try {
            if (this.o == null || this.o.size() <= 0) {
                str = this.j;
            } else {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.j);
                if (this.j.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.j.endsWith("?") && !this.j.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.o.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(((BasicNameValuePair) this.o.get(i)).getName());
                    sb.append("=");
                    sb.append(y.d(((BasicNameValuePair) this.o.get(i)).getValue()));
                }
                str = sb.toString();
            }
            URL url = new URL(str);
            if (com.baidu.tieba.data.g.s()) {
                z.e(getClass().getName(), "getNetData", str);
            }
            int i2 = 0;
            while (true) {
                if (this.u || !z2 || i2 >= 10) {
                    break;
                }
                InputStream inputStream3 = null;
                try {
                    this.i = a(url);
                } catch (SocketException e3) {
                } catch (SocketTimeoutException e4) {
                } catch (Exception e5) {
                    inputStream2 = null;
                    e2 = e5;
                } catch (Throwable th) {
                    th = th;
                    inputStream = null;
                }
                if (this.i == null) {
                    throw new SocketException();
                }
                this.i.setConnectTimeout(5000);
                this.i.setReadTimeout(30000);
                if (this.q && !this.s) {
                    this.i.setRequestProperty("Accept-Encoding", "gzip");
                }
                if (this.u) {
                    break;
                }
                long time = new Date().getTime();
                this.i.connect();
                this.k = this.i.getResponseCode();
                if (this.k != 200) {
                    throw new SocketException();
                }
                if (!this.i.getContentType().contains("text/vnd.wap.wml")) {
                    String contentEncoding = this.i.getContentEncoding();
                    inputStream = this.i.getInputStream();
                    try {
                        if (TiebaApplication.f().p() && (headerField = this.i.getHeaderField(HttpUtils.HEADER_NAME_CONTENT_LENGTH)) != null) {
                            try {
                                int parseInt = Integer.parseInt(headerField);
                                if (parseInt > d) {
                                    break;
                                }
                                int i3 = parseInt * 10;
                                if (i3 > 0) {
                                    if (com.baidu.adp.lib.c.b.a()) {
                                        com.baidu.adp.lib.c.b.c("pre-free memory for downloaded image:[" + this.j + "], size:" + i3);
                                    }
                                    if (!com.baidu.tbadk.a.e.a().c(i3)) {
                                        com.baidu.adp.lib.c.b.c("Image download cacelled. out of memory. url:[" + this.j + "], size:" + i3);
                                        break;
                                    }
                                }
                            } catch (Throwable th2) {
                            }
                        }
                        byte[] bArr2 = new byte[NotificationProxy.MAX_URL_LENGTH];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                        int i4 = 0;
                        if (this.s) {
                            byte[] bArr3 = new byte[23];
                            int read2 = inputStream.read(bArr3, 0, 23);
                            if (!new String(bArr3, 0, bArr3.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                                byteArrayOutputStream.write(bArr3, 0, read2);
                                i4 = 0 + read2;
                            }
                        }
                        while (!this.u && i4 < d && (read = inputStream.read(bArr2)) != -1) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                            i4 += read;
                        }
                        if (this.u) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e6) {
                                }
                            }
                            try {
                                if (this.i != null) {
                                    this.i.disconnect();
                                }
                            } catch (Exception e7) {
                            }
                        } else {
                            this.x = i4;
                            long time2 = new Date().getTime() - time;
                            z.a(getClass().getName(), "getNetData", "time = " + String.valueOf(time2) + "ms");
                            if (i4 < d) {
                                bArr = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                z.a(getClass().getName(), "getNetData", "data.zise = " + String.valueOf(i4));
                                if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                                    o.a(byteArrayInputStream, byteArrayOutputStream2);
                                    bArr = byteArrayOutputStream2.toByteArray();
                                }
                            } else {
                                this.k = -1;
                                this.m = this.r.getResources().getString(R.string.data_too_big);
                            }
                            v vVar = new v();
                            vVar.e = a(c(this.r));
                            vVar.c = this.x;
                            vVar.b = time2;
                            vVar.d = i2 + 1;
                            vVar.a = 2;
                            a(vVar);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e8) {
                                }
                            }
                            try {
                                if (this.i != null) {
                                    this.i.disconnect();
                                }
                            } catch (Exception e9) {
                            }
                        }
                    } catch (SocketException e10) {
                        inputStream3 = inputStream;
                        try {
                            this.k = 0;
                            z.incrementAndGet();
                            z2 = true;
                            this.m = this.r.getResources().getString(R.string.neterror);
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (Exception e11) {
                                }
                            }
                            try {
                                if (this.i != null) {
                                    this.i.disconnect();
                                }
                            } catch (Exception e12) {
                            }
                            i2++;
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = inputStream3;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e13) {
                                }
                            }
                            try {
                                if (this.i != null) {
                                    this.i.disconnect();
                                }
                            } catch (Exception e14) {
                            }
                            throw th;
                        }
                    } catch (SocketTimeoutException e15) {
                        inputStream3 = inputStream;
                        z.incrementAndGet();
                        this.k = 0;
                        z2 = true;
                        this.m = this.r.getResources().getString(R.string.neterror);
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Exception e16) {
                            }
                        }
                        try {
                            if (this.i != null) {
                                this.i.disconnect();
                            }
                        } catch (Exception e17) {
                        }
                        i2++;
                    } catch (Exception e18) {
                        e2 = e18;
                        inputStream2 = inputStream;
                        try {
                            this.k = 0;
                            z2 = false;
                            this.m = this.r.getResources().getString(R.string.neterror);
                            z.b(getClass().getName(), "getNetData", "error = " + e2.getMessage());
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e19) {
                                }
                            }
                            try {
                                if (this.i != null) {
                                    this.i.disconnect();
                                }
                            } catch (Exception e20) {
                            }
                            i2++;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = inputStream2;
                            if (inputStream != null) {
                            }
                            if (this.i != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        if (inputStream != null) {
                        }
                        if (this.i != null) {
                        }
                        throw th;
                    }
                } else if (this.n >= 1) {
                    break;
                } else {
                    this.i.disconnect();
                    this.n++;
                    this.k = 0;
                    i2--;
                    if (0 != 0) {
                        try {
                            inputStream3.close();
                        } catch (Exception e21) {
                        }
                    }
                    try {
                        if (this.i != null) {
                            this.i.disconnect();
                        }
                    } catch (Exception e22) {
                    }
                    i2++;
                }
            }
        } catch (Exception e23) {
            z.b(getClass().getName(), "getNetData", e23.getMessage());
            return null;
        }
        try {
            if (this.i != null) {
                this.i.disconnect();
            }
        } catch (Exception e24) {
        }
        return null;
        try {
            if (this.i != null) {
                this.i.disconnect();
            }
        } catch (Exception e25) {
        }
        this.n = 0;
        return bArr;
        return null;
        this.n = 0;
        return bArr;
    }

    private String w() {
        int indexOf;
        String str = null;
        if (this.i != null) {
            str = this.i.getContentType();
        }
        if (str == null || (indexOf = str.indexOf("charset")) == -1) {
            return BdUtil.UTF8;
        }
        int indexOf2 = str.indexOf(32, indexOf);
        if (indexOf2 == -1) {
            return str.substring(indexOf + 8);
        }
        return str.substring(indexOf + 8, indexOf2);
    }

    public void c(String str) {
        this.l = -1;
        if (str != null) {
            try {
                com.baidu.tieba.data.n nVar = new com.baidu.tieba.data.n();
                nVar.b(str);
                this.l = nVar.a();
                if (this.l == -1) {
                    this.m = this.r.getString(R.string.error_unkown);
                } else if (this.l != 0) {
                    this.m = nVar.b();
                }
            } catch (Exception e2) {
                z.b("NetWork", "parseServerCode", "error = " + e2.getMessage());
                this.m = this.r.getString(R.string.error_unkown);
            }
        }
    }

    public String n() {
        String str;
        Exception e2;
        if (NetworkProxy.d(this, this.i, this.j, this.m, this.o, this.p)) {
            return NetworkProxy.e(this, this.i, this.j, this.m, this.o, this.p);
        }
        byte[] m = m();
        if (this.k != 200) {
            return null;
        }
        try {
            str = new String(m, 0, m.length, w());
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        }
        try {
            c(str);
            return str;
        } catch (Exception e4) {
            e2 = e4;
            z.b(getClass().getName(), "getNetString", "error = " + e2.getMessage());
            return str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [888=9, 889=9, 893=9, 894=9, 896=9] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0410 A[Catch: Exception -> 0x042e, TRY_LEAVE, TryCatch #0 {Exception -> 0x042e, blocks: (B:156:0x040c, B:158:0x0410), top: B:197:0x040c }] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0409 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String o() {
        InputStream inputStream;
        InputStream inputStream2;
        Exception exc;
        InputStream inputStream3;
        SocketTimeoutException socketTimeoutException;
        InputStream inputStream4;
        SocketException socketException;
        int read;
        if (NetworkProxy.a((Object) this, this.i, this.j, this.m, this.o, this.p)) {
            return NetworkProxy.a(this, this.i, this.j, this.m, this.o, this.p);
        }
        StringBuilder sb = new StringBuilder((int) NotificationProxy.MAX_URL_LENGTH);
        StringBuilder sb2 = new StringBuilder((int) NotificationProxy.MAX_URL_LENGTH);
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.o == null || i2 >= this.o.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = (BasicNameValuePair) this.o.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                if (i2 != 0) {
                    sb.append("&");
                }
                sb.append(String.valueOf(name) + "=");
                sb.append(y.d(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
            i = i2 + 1;
        }
        if (this.v) {
            sb2.append("tiebaclient!!!");
            String a2 = y.a(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(a2);
        }
        String sb3 = sb.toString();
        if (com.baidu.tieba.data.g.s()) {
            z.e(getClass().getName(), "postNetData", String.valueOf(this.j) + "?" + sb3);
        }
        int i3 = 0;
        boolean z2 = true;
        String str = null;
        while (true) {
            if (this.u || !z2 || i3 >= 10) {
                break;
            }
            inputStream = null;
            try {
                try {
                    this.i = a(new URL(this.j));
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                    }
                    try {
                        if (this.i != null) {
                        }
                    } catch (Exception e2) {
                    }
                    throw th;
                }
            } catch (SocketException e3) {
                inputStream4 = null;
                socketException = e3;
            } catch (SocketTimeoutException e4) {
                inputStream3 = null;
                socketTimeoutException = e4;
            } catch (Exception e5) {
                inputStream2 = null;
                exc = e5;
            }
            if (this.i != null) {
                this.i.setConnectTimeout(5000);
                this.i.setReadTimeout(15000);
                this.i.setDoOutput(true);
                this.i.setDoInput(true);
                this.i.setRequestMethod("POST");
                this.i.setRequestProperty("Charset", "UTF-8");
                this.i.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                if (this.q) {
                    this.i.setRequestProperty("Accept-Encoding", "gzip");
                }
                if (this.u) {
                    break;
                }
                long time = new Date().getTime();
                this.i.connect();
                DataOutputStream dataOutputStream = new DataOutputStream(this.i.getOutputStream());
                if (!this.u) {
                    dataOutputStream.writeBytes(sb3);
                }
                dataOutputStream.flush();
                z.a("NetWork", "postNetData", "Post data.zise = " + String.valueOf(dataOutputStream.size()));
                dataOutputStream.close();
                this.k = this.i.getResponseCode();
                if (this.k != 200) {
                    throw new SocketException();
                }
                if (!this.v || !this.i.getContentType().contains("text/vnd.wap.wml")) {
                    String contentEncoding = this.i.getContentEncoding();
                    InputStream inputStream5 = this.i.getInputStream();
                    try {
                        byte[] bArr = new byte[NotificationProxy.MAX_URL_LENGTH];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                        int i4 = 0;
                        while (!this.u && (read = inputStream5.read(bArr)) != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                            i4 += read;
                        }
                        inputStream5.close();
                        this.i.disconnect();
                        if (this.u) {
                            if (inputStream5 != null) {
                                try {
                                    inputStream5.close();
                                } catch (Exception e6) {
                                }
                            }
                            try {
                                if (this.i != null) {
                                    this.i.disconnect();
                                }
                            } catch (Exception e7) {
                            }
                        } else {
                            this.x = i4;
                            long time2 = new Date().getTime() - time;
                            z.a(getClass().getName(), "postNetData", "time = " + String.valueOf(time2) + "ms");
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            z.a(getClass().getName(), "postNetData", "Get data.zise = " + String.valueOf(byteArray.length));
                            if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                                o.a(byteArrayInputStream, byteArrayOutputStream2);
                                byteArray = byteArrayOutputStream2.toByteArray();
                                z.a(getClass().getName(), "postNetData", "After ungzip data.zise = " + String.valueOf(byteArray.length));
                            }
                            byte[] bArr2 = byteArray;
                            String str2 = new String(bArr2, 0, bArr2.length, w());
                            try {
                                if (this.v && this.w) {
                                    c(str2);
                                }
                                v vVar = new v();
                                vVar.e = a(c(this.r));
                                vVar.c = this.x;
                                vVar.b = time2;
                                vVar.d = i3 + 1;
                                vVar.a = 1;
                                a(vVar);
                                if (inputStream5 != null) {
                                    try {
                                        inputStream5.close();
                                    } catch (Exception e8) {
                                    }
                                }
                                try {
                                    if (this.i != null) {
                                        this.i.disconnect();
                                        str = str2;
                                    } else {
                                        str = str2;
                                    }
                                } catch (Exception e9) {
                                    str = str2;
                                }
                            } catch (SocketException e10) {
                                inputStream4 = inputStream5;
                                socketException = e10;
                                str = str2;
                                z.incrementAndGet();
                                this.k = 0;
                                z2 = true;
                                this.m = this.r.getResources().getString(R.string.neterror);
                                z.b(getClass().getName(), "postNetData", "SocketException " + socketException.getMessage());
                                if (inputStream4 != null) {
                                    try {
                                        inputStream4.close();
                                    } catch (Exception e11) {
                                    }
                                }
                                try {
                                    if (this.i != null) {
                                        this.i.disconnect();
                                    }
                                } catch (Exception e12) {
                                }
                                i3++;
                            } catch (SocketTimeoutException e13) {
                                inputStream3 = inputStream5;
                                socketTimeoutException = e13;
                                str = str2;
                                try {
                                    z.incrementAndGet();
                                    this.k = 0;
                                    z2 = true;
                                    this.m = this.r.getResources().getString(R.string.neterror);
                                    z.b(getClass().getName(), "postNetData", "SocketTimeoutException " + socketTimeoutException.getMessage());
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (Exception e14) {
                                        }
                                    }
                                    try {
                                        if (this.i != null) {
                                            this.i.disconnect();
                                        }
                                    } catch (Exception e15) {
                                    }
                                    i3++;
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStream = inputStream3;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e16) {
                                        }
                                    }
                                    if (this.i != null) {
                                        this.i.disconnect();
                                    }
                                    throw th;
                                }
                            } catch (Exception e17) {
                                inputStream2 = inputStream5;
                                exc = e17;
                                str = str2;
                                this.k = 0;
                                z2 = false;
                                this.m = this.r.getResources().getString(R.string.neterror);
                                z.b(getClass().getName(), "postNetData", exc.getMessage());
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e18) {
                                    }
                                }
                                try {
                                    if (this.i != null) {
                                        this.i.disconnect();
                                    }
                                } catch (Exception e19) {
                                }
                                i3++;
                            }
                        }
                    } catch (SocketException e20) {
                        inputStream4 = inputStream5;
                        socketException = e20;
                    } catch (SocketTimeoutException e21) {
                        inputStream3 = inputStream5;
                        socketTimeoutException = e21;
                    } catch (Exception e22) {
                        inputStream2 = inputStream5;
                        exc = e22;
                    }
                } else if (this.n < 1) {
                    this.i.disconnect();
                    this.n++;
                    this.k = 0;
                    i3--;
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e23) {
                        }
                    }
                    try {
                        if (this.i != null) {
                            this.i.disconnect();
                        }
                    } catch (Exception e24) {
                    }
                    i3++;
                } else {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e25) {
                        }
                    }
                    try {
                        if (this.i != null) {
                            this.i.disconnect();
                        }
                    } catch (Exception e26) {
                    }
                }
            } else {
                this.m = this.r.getResources().getString(R.string.neterror);
                break;
            }
        }
        if (0 != 0) {
            try {
                inputStream.close();
            } catch (Exception e27) {
            }
        }
        try {
            if (this.i != null) {
                this.i.disconnect();
            }
        } catch (Exception e28) {
        }
        this.n = 0;
        return str;
    }

    public int p() {
        return this.x;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1058=9, 1059=9, 1061=9, 1063=9, 1064=9, 1066=5, 1068=9, 1069=9, 1071=9, 1072=9, 1073=9] */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
        if (0 == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
        r6.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02f7 A[Catch: Exception -> 0x04bd, TRY_LEAVE, TryCatch #40 {Exception -> 0x04bd, blocks: (B:102:0x02f3, B:104:0x02f7), top: B:326:0x02f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x046b A[Catch: Exception -> 0x04b2, TRY_LEAVE, TryCatch #4 {Exception -> 0x04b2, blocks: (B:181:0x0467, B:183:0x046b), top: B:283:0x0467 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0472 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0464 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x02fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x01aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x019c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:294:0x02f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x024b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x023d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:351:0x01b7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:352:0x01b7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:354:0x01b7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01a3 A[Catch: Exception -> 0x04f3, TRY_LEAVE, TryCatch #3 {Exception -> 0x04f3, blocks: (B:63:0x019f, B:65:0x01a3), top: B:281:0x019f }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0244 A[Catch: Exception -> 0x04da, TRY_LEAVE, TryCatch #11 {Exception -> 0x04da, blocks: (B:83:0x0240, B:85:0x0244), top: B:292:0x0240 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0252  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String q() {
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        Throwable th;
        String str;
        int i;
        Exception exc;
        DataOutputStream dataOutputStream3;
        InputStream inputStream;
        boolean z2;
        byte[] bArr;
        int read;
        if (NetworkProxy.b(this, this.i, this.j, this.m, this.o, this.p)) {
            return NetworkProxy.c(this, this.i, this.j, this.m, this.o, this.p);
        }
        String str2 = null;
        boolean z3 = true;
        int i2 = 0;
        while (true) {
            if (this.u || !z3 || i2 >= 10) {
                break;
            }
            InputStream inputStream2 = null;
            dataOutputStream = null;
            try {
                this.i = a(new URL(this.j));
            } catch (SocketException e2) {
                str = str2;
                dataOutputStream3 = null;
                i = i2;
                inputStream = null;
            } catch (SocketTimeoutException e3) {
                dataOutputStream2 = null;
                str = str2;
                i = i2;
            } catch (Exception e4) {
                dataOutputStream2 = null;
                str = str2;
                i = i2;
                exc = e4;
            } catch (Throwable th2) {
                dataOutputStream2 = null;
                th = th2;
            }
            if (this.i == null) {
                this.m = this.r.getResources().getString(R.string.neterror);
                break;
            }
            this.i.setConnectTimeout(5000);
            this.i.setReadTimeout(15000);
            this.i.setDoOutput(true);
            this.i.setDoInput(true);
            this.i.setRequestMethod("POST");
            this.i.setRequestProperty("Charset", "UTF-8");
            this.i.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + c);
            if (this.q) {
                this.i.setRequestProperty("Accept-Encoding", "gzip");
            }
            if (this.u) {
                break;
            }
            long time = new Date().getTime();
            this.i.connect();
            dataOutputStream2 = new DataOutputStream(this.i.getOutputStream());
            for (int i3 = 0; this.o != null && i3 < this.o.size() && !this.u; i3++) {
                try {
                    try {
                        BasicNameValuePair basicNameValuePair = (BasicNameValuePair) this.o.get(i3);
                        if (basicNameValuePair != null) {
                            String name = basicNameValuePair.getName();
                            String value = basicNameValuePair.getValue();
                            dataOutputStream2.writeBytes(String.valueOf(b) + c + a);
                            byte[] bytes = value.getBytes("UTF-8");
                            dataOutputStream2.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"" + a);
                            dataOutputStream2.writeBytes(a);
                            dataOutputStream2.write(bytes);
                            dataOutputStream2.writeBytes(a);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (SocketException e5) {
                    i = i2;
                    str = str2;
                    dataOutputStream3 = dataOutputStream2;
                    inputStream = null;
                } catch (SocketTimeoutException e6) {
                    i = i2;
                    str = str2;
                } catch (Exception e7) {
                    str = str2;
                    exc = e7;
                    i = i2;
                }
            }
            if (!this.u && this.p != null) {
                for (Map.Entry entry : this.p.entrySet()) {
                    String str3 = (String) entry.getKey();
                    byte[] bArr2 = (byte[]) entry.getValue();
                    if (this.u) {
                        break;
                    } else if (bArr2 != null) {
                        dataOutputStream2.writeBytes(String.valueOf(b) + c + a);
                        dataOutputStream2.writeBytes("Content-Disposition: form-data; name=\"" + str3 + "\"; filename=\"file\"" + a);
                        dataOutputStream2.writeBytes(a);
                        dataOutputStream2.write(bArr2);
                        dataOutputStream2.writeBytes(a);
                    }
                }
            }
            dataOutputStream2.writeBytes(String.valueOf(b) + c + b + a);
            dataOutputStream2.flush();
            z.a("NetWork", "postMultiNetData", "Post data.zise = " + String.valueOf(dataOutputStream2.size()));
            dataOutputStream2.close();
            if (e != null) {
                e.sendMessageDelayed(e.obtainMessage(0, this), 45000L);
            }
            this.k = this.i.getResponseCode();
            if (e != null) {
                e.removeMessages(0, this);
            }
            if (this.k != 200) {
                throw new SocketException();
                break;
            } else if (!this.i.getContentType().contains("text/vnd.wap.wml")) {
                String contentEncoding = this.i.getContentEncoding();
                InputStream inputStream3 = this.i.getInputStream();
                try {
                    try {
                        byte[] bArr3 = new byte[NotificationProxy.MAX_URL_LENGTH];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                        while (!this.u && (read = inputStream3.read(bArr3)) != -1) {
                            byteArrayOutputStream.write(bArr3, 0, read);
                        }
                        if (this.u) {
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (Exception e8) {
                                }
                            }
                            try {
                                if (this.i != null) {
                                    this.i.disconnect();
                                }
                            } catch (Exception e9) {
                            }
                            if (dataOutputStream2 != null) {
                                try {
                                    dataOutputStream2.close();
                                } catch (Exception e10) {
                                }
                            }
                            if (e != null) {
                                e.removeMessages(0, this);
                            }
                        } else {
                            inputStream3.close();
                            this.i.disconnect();
                            z.a("NetWork", "postMultiNetData", "time = " + String.valueOf(new Date().getTime() - time) + "ms");
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            z.a("NetWork", "postMultiNetData", "Get data.zise = " + String.valueOf(byteArray.length));
                            if (contentEncoding == null || !contentEncoding.contains("gzip")) {
                                bArr = byteArray;
                            } else {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                                o.a(byteArrayInputStream, byteArrayOutputStream2);
                                bArr = byteArrayOutputStream2.toByteArray();
                            }
                            String str4 = new String(bArr, 0, bArr.length, w());
                            try {
                                c(str4);
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (Exception e11) {
                                    }
                                }
                                try {
                                    if (this.i != null) {
                                        this.i.disconnect();
                                    }
                                } catch (Exception e12) {
                                }
                                if (dataOutputStream2 != null) {
                                    try {
                                        dataOutputStream2.close();
                                    } catch (Exception e13) {
                                    }
                                }
                                if (e != null) {
                                    e.removeMessages(0, this);
                                    str2 = str4;
                                } else {
                                    str2 = str4;
                                }
                            } catch (SocketException e14) {
                                dataOutputStream3 = dataOutputStream2;
                                str = str4;
                                i = i2;
                                inputStream = inputStream3;
                                z2 = true;
                                this.k = 0;
                                this.m = this.r.getResources().getString(R.string.neterror);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e15) {
                                    }
                                }
                                if (this.i != null) {
                                    this.i.disconnect();
                                }
                                if (dataOutputStream3 != null) {
                                    try {
                                        dataOutputStream3.close();
                                    } catch (Exception e16) {
                                    }
                                }
                                if (e == null) {
                                    e.removeMessages(0, this);
                                }
                                i2 = i + 1;
                                str2 = str;
                                z3 = z2;
                            } catch (SocketTimeoutException e17) {
                                inputStream2 = inputStream3;
                                str = str4;
                                i = i2;
                                this.k = 0;
                                z2 = true;
                                this.m = this.r.getResources().getString(R.string.neterror);
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e18) {
                                    }
                                }
                                if (this.i != null) {
                                    this.i.disconnect();
                                }
                                if (dataOutputStream2 != null) {
                                    try {
                                        dataOutputStream2.close();
                                    } catch (Exception e19) {
                                    }
                                }
                                if (e == null) {
                                    e.removeMessages(0, this);
                                }
                                i2 = i + 1;
                                str2 = str;
                                z3 = z2;
                            } catch (Exception e20) {
                                exc = e20;
                                inputStream2 = inputStream3;
                                str = str4;
                                i = i2;
                                this.k = 0;
                                z2 = false;
                                this.m = this.r.getResources().getString(R.string.neterror);
                                z.b("NetWork", "postMultiNetData", "error = " + exc.getMessage());
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e21) {
                                    }
                                }
                                if (this.i != null) {
                                    this.i.disconnect();
                                }
                                if (dataOutputStream2 != null) {
                                    try {
                                        dataOutputStream2.close();
                                    } catch (Exception e22) {
                                    }
                                }
                                if (e == null) {
                                    e.removeMessages(0, this);
                                }
                                i2 = i + 1;
                                str2 = str;
                                z3 = z2;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream2 = inputStream3;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e23) {
                            }
                        }
                        if (this.i != null) {
                            this.i.disconnect();
                        }
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                            } catch (Exception e24) {
                            }
                        }
                        if (e != null) {
                            e.removeMessages(0, this);
                        }
                        throw th;
                    }
                } catch (SocketException e25) {
                    i = i2;
                    str = str2;
                    dataOutputStream3 = dataOutputStream2;
                    inputStream = inputStream3;
                } catch (SocketTimeoutException e26) {
                    inputStream2 = inputStream3;
                    i = i2;
                    str = str2;
                } catch (Exception e27) {
                    inputStream2 = inputStream3;
                    str = str2;
                    exc = e27;
                    i = i2;
                }
            } else if (this.n < 1) {
                this.i.disconnect();
                this.n++;
                i = i2 - 1;
                try {
                    this.k = 0;
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (Exception e28) {
                        }
                    }
                    try {
                        if (this.i != null) {
                            this.i.disconnect();
                        }
                    } catch (Exception e29) {
                    }
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (Exception e30) {
                        }
                    }
                    if (e != null) {
                        e.removeMessages(0, this);
                        z2 = z3;
                        str = str2;
                    } else {
                        z2 = z3;
                        str = str2;
                    }
                } catch (SocketException e31) {
                    inputStream = null;
                    str = str2;
                    dataOutputStream3 = dataOutputStream2;
                    z2 = true;
                    try {
                        this.k = 0;
                        this.m = this.r.getResources().getString(R.string.neterror);
                        if (inputStream != null) {
                        }
                        try {
                            if (this.i != null) {
                            }
                        } catch (Exception e32) {
                        }
                        if (dataOutputStream3 != null) {
                        }
                        if (e == null) {
                        }
                        i2 = i + 1;
                        str2 = str;
                        z3 = z2;
                    } catch (Throwable th5) {
                        th = th5;
                        dataOutputStream2 = dataOutputStream3;
                        inputStream2 = inputStream;
                        if (inputStream2 != null) {
                        }
                        try {
                            if (this.i != null) {
                            }
                        } catch (Exception e33) {
                        }
                        if (dataOutputStream2 != null) {
                        }
                        if (e != null) {
                        }
                        throw th;
                    }
                } catch (SocketTimeoutException e34) {
                    str = str2;
                    this.k = 0;
                    z2 = true;
                    this.m = this.r.getResources().getString(R.string.neterror);
                    if (inputStream2 != null) {
                    }
                    try {
                        if (this.i != null) {
                        }
                    } catch (Exception e35) {
                    }
                    if (dataOutputStream2 != null) {
                    }
                    if (e == null) {
                    }
                    i2 = i + 1;
                    str2 = str;
                    z3 = z2;
                } catch (Exception e36) {
                    str = str2;
                    exc = e36;
                    this.k = 0;
                    z2 = false;
                    this.m = this.r.getResources().getString(R.string.neterror);
                    z.b("NetWork", "postMultiNetData", "error = " + exc.getMessage());
                    if (inputStream2 != null) {
                    }
                    try {
                        if (this.i != null) {
                        }
                    } catch (Exception e37) {
                    }
                    if (dataOutputStream2 != null) {
                    }
                    if (e == null) {
                    }
                    i2 = i + 1;
                    str2 = str;
                    z3 = z2;
                }
                i2 = i + 1;
                str2 = str;
                z3 = z2;
            } else {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e38) {
                    }
                }
                try {
                    if (this.i != null) {
                        this.i.disconnect();
                    }
                } catch (Exception e39) {
                }
                if (dataOutputStream2 != null) {
                    try {
                        dataOutputStream2.close();
                    } catch (Exception e40) {
                    }
                }
                if (e != null) {
                    e.removeMessages(0, this);
                }
            }
        }
        this.n = 0;
        return str2;
        try {
            if (this.i != null) {
                this.i.disconnect();
            }
        } catch (Exception e41) {
        }
        if (0 != 0) {
            try {
                dataOutputStream.close();
            } catch (Exception e42) {
            }
        }
        if (e != null) {
            e.removeMessages(0, this);
        }
        this.n = 0;
        return str2;
        if (0 != 0) {
        }
        if (e != null) {
        }
        this.n = 0;
        return str2;
        if (e != null) {
        }
        this.n = 0;
        return str2;
    }

    public boolean r() {
        return this.k == 200 || this.k == 206;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1207=7, 1209=7, 1210=7, 1214=7, 1215=7, 1219=7, 1220=7, 1222=7] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x035a A[Catch: Exception -> 0x0382, TRY_LEAVE, TryCatch #30 {Exception -> 0x0382, blocks: (B:164:0x0354, B:166:0x035a), top: B:256:0x0354 }] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0363 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0351 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Boolean a(String str, Handler handler, int i) {
        FileOutputStream fileOutputStream;
        Exception e2;
        InputStream inputStream;
        String headerField;
        int indexOf;
        InputStream inputStream2 = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                this.i = a(new URL(this.j));
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e3) {
            inputStream = null;
        } catch (Exception e4) {
            fileOutputStream = null;
            e2 = e4;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        if (this.i == null) {
            throw new SocketException();
        }
        this.i.setConnectTimeout(5000);
        this.i.setReadTimeout(30000);
        this.i.setInstanceFollowRedirects(false);
        if (this.u) {
            r2 = false;
            this.n = 0;
            if (0 != 0) {
                try {
                    inputStream2.close();
                } catch (Exception e5) {
                }
            }
            try {
                if (this.i != null) {
                    this.i.disconnect();
                }
            } catch (Exception e6) {
            }
            if (0 != 0) {
                try {
                    fileOutputStream2.close();
                } catch (Exception e7) {
                }
            }
        } else {
            long time = new Date().getTime();
            File f2 = m.f(str);
            if (f2 == null) {
                throw new FileNotFoundException();
            }
            long length = f2.length();
            fileOutputStream = new FileOutputStream(f2, true);
            try {
                if (this.t) {
                    this.i.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-" + String.valueOf(200000 + length));
                } else {
                    this.i.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                }
                this.i.connect();
                this.k = this.i.getResponseCode();
                if (!r()) {
                    throw new SocketException();
                }
                if (!this.i.getContentType().contains("text/vnd.wap.wml") || this.n >= 1) {
                    this.n = 0;
                    int i2 = 0;
                    String headerField2 = this.i.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i2 = Integer.valueOf(headerField2.substring(indexOf + 1)).intValue();
                    }
                    int intValue = (i2 == 0 && this.k == 200 && (headerField = this.i.getHeaderField(HttpUtils.HEADER_NAME_CONTENT_LENGTH)) != null) ? Integer.valueOf(headerField).intValue() : i2;
                    if (length >= intValue) {
                        r2 = true;
                        this.n = 0;
                        if (0 != 0) {
                            try {
                                inputStream2.close();
                            } catch (Exception e8) {
                            }
                        }
                        try {
                            if (this.i != null) {
                                this.i.disconnect();
                            }
                        } catch (Exception e9) {
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e10) {
                            }
                        }
                    } else {
                        InputStream inputStream3 = this.i.getInputStream();
                        try {
                            try {
                                byte[] bArr = new byte[NotificationProxy.MAX_URL_LENGTH];
                                int i3 = 0;
                                int i4 = intValue > 0 ? intValue / 50 : 0;
                                int i5 = 0;
                                if (handler != null && length > 0) {
                                    handler.sendMessage(handler.obtainMessage(i, (int) length, intValue));
                                }
                                while (!this.u) {
                                    int read = inputStream3.read(bArr);
                                    if (read != -1) {
                                        try {
                                            fileOutputStream.write(bArr, 0, read);
                                            i3 += read;
                                            i5 += read;
                                            if (handler != null && (i5 > i4 || i3 == intValue)) {
                                                i5 = 0;
                                                handler.sendMessage(handler.obtainMessage(i, (int) (i3 + length), intValue));
                                            }
                                        } catch (Exception e11) {
                                            throw new FileNotFoundException();
                                        }
                                    }
                                }
                                try {
                                    fileOutputStream.flush();
                                    z.a("NetWork", "downloadFile", "time = " + String.valueOf(new Date().getTime() - time) + "ms");
                                    if (intValue != -1) {
                                        z.a("NetWork", "downloadFile", "data.zise = " + String.valueOf(intValue));
                                    }
                                    r2 = ((long) i3) + length >= ((long) intValue);
                                    this.n = 0;
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (Exception e12) {
                                        }
                                    }
                                    try {
                                        if (this.i != null) {
                                            this.i.disconnect();
                                        }
                                    } catch (Exception e13) {
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Exception e14) {
                                        }
                                    }
                                } catch (Exception e15) {
                                    throw new FileNotFoundException();
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream2 = inputStream3;
                                this.n = 0;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e16) {
                                    }
                                }
                                try {
                                    if (this.i != null) {
                                        this.i.disconnect();
                                    }
                                } catch (Exception e17) {
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e18) {
                                    }
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException e19) {
                            inputStream = inputStream3;
                            fileOutputStream2 = fileOutputStream;
                            try {
                                this.k = -2;
                                this.m = this.r.getResources().getString(R.string.FileWriteError);
                                this.n = 0;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e20) {
                                    }
                                }
                                try {
                                    if (this.i != null) {
                                        this.i.disconnect();
                                    }
                                } catch (Exception e21) {
                                }
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (Exception e22) {
                                    }
                                }
                                return r2;
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream2 = inputStream;
                                fileOutputStream = fileOutputStream2;
                                this.n = 0;
                                if (inputStream2 != null) {
                                }
                                if (this.i != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                throw th;
                            }
                        } catch (Exception e23) {
                            inputStream2 = inputStream3;
                            e2 = e23;
                            this.k = 0;
                            this.m = this.r.getResources().getString(R.string.neterror);
                            z.b("NetWork", "downloadFile", "error = " + e2.getMessage());
                            this.n = 0;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e24) {
                                }
                            }
                            try {
                                if (this.i != null) {
                                    this.i.disconnect();
                                }
                            } catch (Exception e25) {
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e26) {
                                }
                            }
                            return r2;
                        }
                    }
                } else {
                    this.i.disconnect();
                    this.n++;
                    this.k = 0;
                    r2 = a(str, handler, i);
                    this.n = 0;
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (Exception e27) {
                        }
                    }
                    try {
                        if (this.i != null) {
                            this.i.disconnect();
                        }
                    } catch (Exception e28) {
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e29) {
                        }
                    }
                }
            } catch (FileNotFoundException e30) {
                fileOutputStream2 = fileOutputStream;
                inputStream = null;
            } catch (Exception e31) {
                e2 = e31;
            }
        }
        return r2;
    }

    public void b(Context context) {
        this.r = context;
    }

    public Context s() {
        return this.r;
    }

    public ArrayList t() {
        return this.o;
    }

    public void a(ArrayList arrayList) {
        if (this.o != null) {
            this.o.clear();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                a((BasicNameValuePair) arrayList.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    public void a(String str, byte[] bArr) {
        if (this.p == null) {
            this.p = new HashMap();
        }
        this.p.put(str, bArr);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.o == null) {
                this.o = new ArrayList();
            }
            int a2 = a(this.o, basicNameValuePair.getName());
            int size = this.o.size();
            if (a2 >= 0 && a2 < size) {
                if (basicNameValuePair.getName().equals(((BasicNameValuePair) this.o.get(a2)).getName())) {
                    this.o.set(a2, basicNameValuePair);
                } else {
                    this.o.add(a2, basicNameValuePair);
                }
            } else if (a2 == size) {
                this.o.add(a2, basicNameValuePair);
            }
        }
    }

    private int a(ArrayList arrayList, String str) {
        int i = 0;
        if (arrayList == null || str == null) {
            return -1;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            int compareTo = str.compareTo(((BasicNameValuePair) arrayList.get(i)).getName());
            if (compareTo < 0) {
                i2 = i;
                break;
            } else if (compareTo == 0) {
                return -1;
            } else {
                i2 = i;
                i++;
            }
        }
        return i >= size ? size : i2;
    }

    public void b(boolean z2) {
        this.s = z2;
    }

    public void c(boolean z2) {
        this.v = z2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0069 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0002 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.tieba.util.NetWorkCore$NetworkStateInfo] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    public static NetworkStateInfo c(Context context) {
        NetworkStateInfo networkStateInfo;
        ?? e2 = NetworkStateInfo.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                networkStateInfo = NetworkStateInfo.UNAVAIL;
                try {
                    e2 = "NetWorkCore";
                    z.a("NetWorkCore", "NetworkStateInfo", "UNAVAIL");
                } catch (Exception e3) {
                    e2 = e3;
                }
            } else if (activeNetworkInfo.getType() == 1) {
                z.a("NetWorkCore", "NetworkStateInfo", "WIFI");
                networkStateInfo = NetworkStateInfo.WIFI;
            } else {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        z.a("NetWorkCore", "NetworkStateInfo", "TwoG");
                        networkStateInfo = NetworkStateInfo.TwoG;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        z.a("NetWorkCore", "NetworkStateInfo", "ThreeG");
                        networkStateInfo = NetworkStateInfo.ThreeG;
                        break;
                    default:
                        z.a("NetWorkCore", "NetworkStateInfo-default", "TwoG");
                        networkStateInfo = NetworkStateInfo.TwoG;
                        break;
                }
            }
            return networkStateInfo;
        } catch (Exception e4) {
            return e2;
        }
    }
}
