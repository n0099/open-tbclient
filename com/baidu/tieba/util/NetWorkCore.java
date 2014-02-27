package com.baidu.tieba.util;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ErrorData;
import com.slidingmenu.lib.R;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;
import org.apache.http.message.BasicNameValuePair;
@Deprecated
/* loaded from: classes.dex */
public class NetWorkCore implements an {
    private static String a = IOUtils.LINE_SEPARATOR_WINDOWS;
    private static String b = "--";
    private static String c = "--------7da3d81520810*";
    private static int d = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private static Handler e = null;
    private static volatile String f = null;
    private static volatile boolean g = false;
    private static Pattern h = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    private static /* synthetic */ int[] z;
    private Context i;
    private bj o;
    private int n = 0;
    private boolean p = false;
    private boolean q = false;
    private String r = "other";
    private int s = 0;
    private int t = 0;
    private long u = 0;
    private long v = 0;
    private long w = 0;
    private int x = 0;
    private long y = 0;
    private HttpURLConnection j = null;
    private int k = 0;
    private volatile boolean m = false;
    private boolean l = false;

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

    private static /* synthetic */ int[] H() {
        int[] iArr = z;
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
            z = iArr;
        }
        return iArr;
    }

    public NetWorkCore(bj bjVar) {
        this.i = null;
        E();
        this.o = bjVar;
        this.i = TiebaApplication.g().b();
    }

    @Override // com.baidu.tieba.util.an
    public final long e() {
        return this.t;
    }

    @Override // com.baidu.tieba.util.an
    public final long f() {
        return this.n;
    }

    @Override // com.baidu.tieba.util.an
    public final long g() {
        return this.v;
    }

    @Override // com.baidu.tieba.util.an
    public final long h() {
        return this.u;
    }

    @Override // com.baidu.tieba.util.an
    public final long j() {
        return this.w;
    }

    @Override // com.baidu.tieba.util.an
    public final int i() {
        return this.x;
    }

    @Override // com.baidu.tieba.util.an
    public final String d() {
        if (this.o.a == null) {
            return null;
        }
        String str = com.baidu.tieba.data.i.a;
        if (this.o.a.startsWith(str)) {
            int indexOf = this.o.a.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.o.a.length();
            }
            return this.o.a.substring(str.length(), indexOf);
        }
        return this.o.a;
    }

    @Override // com.baidu.tieba.util.an
    public final long c() {
        return this.y;
    }

    private static int a(NetworkStateInfo networkStateInfo) {
        switch (H()[networkStateInfo.ordinal()]) {
            case 2:
            default:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
        }
    }

    @Override // com.baidu.tieba.util.an
    public final void c(boolean z2) {
        this.o.j = z2;
    }

    @Override // com.baidu.tieba.util.an
    public final String o() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.i.getSystemService("connectivity")).getActiveNetworkInfo();
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
                return SocialConstants.TRUE;
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    private static void E() {
        synchronized (NetWorkCore.class) {
            if (!g) {
                g = true;
                F();
            }
        }
    }

    private static synchronized void F() {
        synchronized (NetWorkCore.class) {
            try {
                Cursor query = TiebaApplication.g().b().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    f = "Basic " + bs.a((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e2) {
            }
        }
    }

    public static void D() {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        } else {
            System.setProperty("http.keepAlive", "true");
        }
        e = new bb();
    }

    @Override // com.baidu.tieba.util.an
    public final void a(Boolean bool) {
        this.o.g = bool.booleanValue();
    }

    private static NetworkState b(Context context) {
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

    @Override // com.baidu.tieba.util.an
    public final void b(String str) {
        this.o.a = str;
    }

    @Override // com.baidu.tieba.util.an
    public final boolean p() {
        return this.o.b == 200 && this.o.c == 0;
    }

    @Override // com.baidu.tieba.util.an
    public final boolean q() {
        return this.o.b == 200;
    }

    @Override // com.baidu.tieba.util.an
    public final int k() {
        return this.o.c;
    }

    @Override // com.baidu.tieba.util.an
    public final int A() {
        return this.o.b;
    }

    @Override // com.baidu.tieba.util.an
    public final String r() {
        return this.o.d;
    }

    @Override // com.baidu.tieba.util.an
    public final void v() {
        this.o.d = "";
    }

    @Override // com.baidu.tieba.util.an
    public final void c(String str) {
        this.o.d = str;
    }

    @Override // com.baidu.tieba.util.an
    public final boolean t() {
        return this.m;
    }

    @Override // com.baidu.tieba.util.an
    public final void s() {
        this.m = true;
        try {
            if (this.j != null) {
                this.j.disconnect();
                try {
                    int a2 = bg.a(this.o.a);
                    if (a2 > 0) {
                        bg.a().a(a2, 1);
                    }
                } catch (Exception e2) {
                    com.baidu.adp.lib.util.e.b(e2.getMessage());
                }
            }
        } catch (Exception e3) {
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x00d3 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:54:0x0013 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.net.HttpURLConnection] */
    private HttpURLConnection a(URL url) {
        Exception e2;
        String defaultHost;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        HttpURLConnection httpURLConnection3 = 1;
        NetworkState b2 = b(this.i);
        this.l = false;
        try {
            if (b2 == NetworkState.UNAVAIL) {
                return null;
            }
            try {
                if (b2 == NetworkState.MOBILE && (defaultHost = Proxy.getDefaultHost()) != null && defaultHost.length() > 0) {
                    if (h.matcher(defaultHost).find()) {
                        this.l = true;
                        StringBuilder sb = new StringBuilder(80);
                        sb.append(com.baidu.loginshare.e.f);
                        sb.append(Proxy.getDefaultHost());
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        httpURLConnection.setRequestProperty("X-Online-Host", url.getHost());
                        httpURLConnection.setRequestProperty("User-Agent", "BaiduTieba for Android " + com.baidu.tieba.data.i.u());
                        if (!TextUtils.isEmpty(TiebaApplication.v())) {
                            httpURLConnection.setRequestProperty("client_user_token", TiebaApplication.v());
                            httpURLConnection2 = httpURLConnection;
                        }
                    } else {
                        httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort())));
                        if (f != null) {
                            httpURLConnection.setRequestProperty("Proxy-Authorization", f);
                        }
                        httpURLConnection.setRequestProperty("User-Agent", "BaiduTieba for Android " + com.baidu.tieba.data.i.u());
                        if (!TextUtils.isEmpty(TiebaApplication.v())) {
                            httpURLConnection.setRequestProperty("client_user_token", TiebaApplication.v());
                        }
                    }
                    httpURLConnection2 = httpURLConnection;
                }
                if (httpURLConnection2 == null) {
                    try {
                        httpURLConnection3 = (HttpURLConnection) url.openConnection();
                    } catch (Exception e3) {
                        httpURLConnection3 = httpURLConnection2;
                        e2 = e3;
                        com.baidu.adp.lib.util.e.b(getClass().getName(), "getConnect", "error = " + e2.getMessage());
                        return httpURLConnection3;
                    }
                } else {
                    httpURLConnection3 = httpURLConnection2;
                }
                if (this.o != null) {
                    if (!TextUtils.isEmpty(this.o.m)) {
                        httpURLConnection3.setRequestProperty("sid", this.o.m);
                    }
                    if (!TextUtils.isEmpty(this.o.n)) {
                        httpURLConnection3.setRequestProperty(com.baidu.loginshare.e.e, this.o.n);
                        return httpURLConnection3;
                    }
                    return httpURLConnection3;
                }
                return httpURLConnection3;
            } catch (Exception e4) {
                e2 = e4;
            }
        } catch (Exception e5) {
            httpURLConnection3 = null;
            e2 = e5;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, IGET, INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [790=12, 791=8, 792=8, 797=12, 798=12] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v21 long)] */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0551, code lost:
        r17.x = r1 + 1;
        r17.y = r7;
        r3 = new com.baidu.tieba.util.bl();
        r3.e = a(c(r17.i));
        r3.c = r17.n;
        r3.b = r7;
        r3.d = r1 + 1;
        r3.a = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x057f, code lost:
        if (r7 <= 5000) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0581, code lost:
        com.baidu.tieba.log.a.a(com.baidu.tieba.log.j.a(r6.toString(), new java.lang.StringBuilder().append(r7).toString(), java.lang.String.valueOf(r3.c) + " |DNS Time" + r17.u + "|ConnectTime" + r17.v + "|current ip" + com.baidu.tieba.util.UtilHelper.b(com.baidu.tieba.util.UtilHelper.c(r6.toString())), "old network download OK, retryCount:" + r3.d, ""));
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x05ed, code lost:
        com.baidu.tieba.util.bk.a(r3);
        com.baidu.tieba.util.cb.a(r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x05f3, code lost:
        com.baidu.tieba.util.bg.c(r17.o.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x05fc, code lost:
        if (r4 == null) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x05fe, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x07c6, code lost:
        r2 = r3;
     */
    @Override // com.baidu.tieba.util.an
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] w() {
        String str;
        int i;
        int read;
        String headerField;
        byte[] bArr = null;
        try {
            int a2 = bg.a(this.o.a);
            if (a2 > 0) {
                bg.a().a(a2);
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.e.b(e2.getMessage());
        }
        try {
            if (this.o.e == null || this.o.e.size() <= 0 || this.p) {
                str = this.o.a;
            } else {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.o.a);
                if (this.o.a.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.o.a.endsWith("?") && !this.o.a.endsWith("&")) {
                    sb.append("&");
                }
                for (int i2 = 0; i2 < this.o.e.size(); i2++) {
                    if (i2 != 0) {
                        sb.append("&");
                    }
                    sb.append(this.o.e.get(i2).getName());
                    sb.append("=");
                    sb.append(bs.d(this.o.e.get(i2).getValue()));
                }
                str = sb.toString();
            }
            URL url = new URL(str);
            this.t = str.length();
            if (com.baidu.tieba.data.i.F()) {
                com.baidu.adp.lib.util.e.e(getClass().getName(), "getNetData", str);
            }
            int i3 = 0;
            while (true) {
                if (this.m || i3 >= 5) {
                    break;
                }
                InputStream inputStream = null;
                try {
                    try {
                        this.j = a(url);
                    } catch (Throwable th) {
                        try {
                            bg.c(this.o.a);
                            if (0 != 0) {
                                inputStream.close();
                            }
                        } catch (Exception e3) {
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e4) {
                        }
                        throw th;
                    }
                } catch (SocketException e5) {
                    e = e5;
                } catch (SocketTimeoutException e6) {
                    e = e6;
                } catch (Exception e7) {
                    e = e7;
                }
                if (this.j == null) {
                    throw new SocketException("network not available.");
                }
                this.j.setConnectTimeout(5000);
                this.j.setReadTimeout(30000);
                if ((this.o.g && !this.o.h) || this.p) {
                    this.j.setRequestProperty("Accept-Encoding", "gzip");
                }
                if (this.m) {
                    try {
                        bg.c(this.o.a);
                    } catch (Exception e8) {
                    }
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e9) {
                    }
                } else {
                    long time = new Date().getTime();
                    this.u = new Date().getTime() - time;
                    this.j.connect();
                    this.v = (new Date().getTime() - time) - this.u;
                    this.o.b = this.j.getResponseCode();
                    if (this.o.b != 200) {
                        this.o.l = String.valueOf(String.valueOf(this.o.b)) + "|retryCount:" + i3;
                        bk.a.incrementAndGet();
                        this.o.d = this.i.getResources().getString(R.string.neterror);
                        if (i3 == 0) {
                            cb.a(this);
                        }
                        try {
                            bg.c(this.o.a);
                        } catch (Exception e10) {
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e11) {
                        }
                    } else if (!this.j.getContentType().contains("text/vnd.wap.wml")) {
                        String contentEncoding = this.j.getContentEncoding();
                        inputStream = this.j.getInputStream();
                        if (TiebaApplication.g().l() && (headerField = this.j.getHeaderField("Content-Length")) != null) {
                            try {
                                int parseInt = Integer.parseInt(headerField);
                                if (parseInt > d) {
                                    bg.c(this.o.a);
                                    try {
                                        bg.c(this.o.a);
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (Exception e12) {
                                    }
                                    try {
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                    } catch (Exception e13) {
                                    }
                                    return null;
                                }
                                int i4 = parseInt * 10;
                                if (i4 > 0) {
                                    if (com.baidu.adp.lib.util.e.a()) {
                                        com.baidu.adp.lib.util.e.e("pre-free memory for downloaded image:[" + this.o.a + "], size:" + i4);
                                    }
                                    if (!com.baidu.tbadk.imageManager.e.a().b(i4)) {
                                        com.baidu.adp.lib.util.e.e("Image download cacelled. out of memory. url:[" + this.o.a + "], size:" + i4);
                                        bg.c(this.o.a);
                                        try {
                                            bg.c(this.o.a);
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                        } catch (Exception e14) {
                                        }
                                        try {
                                            if (this.j != null) {
                                                this.j.disconnect();
                                            }
                                        } catch (Exception e15) {
                                        }
                                        return null;
                                    }
                                }
                            } catch (Throwable th2) {
                            }
                        }
                        byte[] bArr2 = new byte[1024];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                        int i5 = 0;
                        String headerField2 = this.j.getHeaderField("imgsrc");
                        boolean z2 = false;
                        if (headerField2 != null && headerField2.length() > 0) {
                            z2 = true;
                        }
                        if (this.o.h || z2) {
                            byte[] bArr3 = new byte[23];
                            int read2 = inputStream.read(bArr3, 0, 23);
                            if (!new String(bArr3, 0, bArr3.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                                byteArrayOutputStream.write(bArr3, 0, read2);
                                i5 = read2 + 0;
                            }
                        }
                        if (a() && this.s == 1) {
                            this.s = 2;
                            i = i5;
                        } else {
                            i = i5;
                        }
                        while (!this.m && i < d && (read = inputStream.read(bArr2)) != -1) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                            i = read + i;
                        }
                        if (!this.m) {
                            this.n = i;
                            long time2 = new Date().getTime() - time;
                            this.w = (time2 - this.v) - this.u;
                            com.baidu.adp.lib.util.e.a(getClass().getName(), "getNetData", "time = " + String.valueOf(time2) + "ms");
                            if (i >= d) {
                                this.o.b = -11;
                                this.o.d = this.i.getResources().getString(R.string.data_too_big);
                                break;
                            }
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                                com.baidu.adp.lib.util.e.a(getClass().getName(), "getNetData", "data.zise = " + String.valueOf(i));
                                if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                    am.b(byteArrayInputStream, byteArrayOutputStream2);
                                    bArr = byteArrayOutputStream2.toByteArray();
                                    break;
                                }
                                break;
                            } catch (SocketException e16) {
                                bArr = byteArray;
                                e = e16;
                                this.o.l = String.valueOf(String.valueOf(this.o.b)) + "|retryCount:" + i3 + "|" + e.getClass() + "|" + e.getMessage();
                                this.o.b = -12;
                                bk.a.incrementAndGet();
                                this.o.d = this.i.getResources().getString(R.string.neterror);
                                if (i3 == 0) {
                                    cb.a(this);
                                }
                                try {
                                    bg.c(this.o.a);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (Exception e17) {
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                } catch (Exception e18) {
                                }
                                i3++;
                            } catch (SocketTimeoutException e19) {
                                bArr = byteArray;
                                e = e19;
                                bk.a.incrementAndGet();
                                this.o.l = String.valueOf(String.valueOf(this.o.b)) + "|retryCount:" + i3 + "|" + e.getClass() + "|" + e.getMessage();
                                this.o.b = -13;
                                this.o.d = this.i.getResources().getString(R.string.neterror);
                                if (i3 == 0) {
                                    cb.a(this);
                                }
                                try {
                                    bg.c(this.o.a);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (Exception e20) {
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                } catch (Exception e21) {
                                }
                                i3++;
                            } catch (Exception e22) {
                                bArr = byteArray;
                                e = e22;
                                this.o.l = String.valueOf(String.valueOf(this.o.b)) + "|retryCount:" + i3 + "|" + e.getClass() + "|" + e.getMessage();
                                this.o.b = -10;
                                this.o.d = this.i.getResources().getString(R.string.neterror);
                                com.baidu.adp.lib.util.e.b(getClass().getName(), "getNetData", "error = " + e.getMessage());
                                cb.a(this);
                                try {
                                    bg.c(this.o.a);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (Exception e23) {
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                } catch (Exception e24) {
                                }
                                this.k = 0;
                                return bArr;
                            }
                        } else {
                            try {
                                bg.c(this.o.a);
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } catch (Exception e25) {
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e26) {
                            }
                        }
                    } else if (this.k <= 0) {
                        this.j.disconnect();
                        this.k++;
                        this.o.b = 0;
                        i3--;
                        try {
                            bg.c(this.o.a);
                        } catch (Exception e27) {
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e28) {
                        }
                    } else {
                        try {
                            bg.c(this.o.a);
                        } catch (Exception e29) {
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e30) {
                        }
                    }
                    i3++;
                }
            }
            try {
                if (this.j != null) {
                    this.j.disconnect();
                }
            } catch (Exception e31) {
            }
            this.k = 0;
            return bArr;
        } catch (Exception e32) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "getNetData", e32.getMessage());
            this.o.l = String.valueOf(String.valueOf(this.o.b)) + e32.getClass() + e32.getMessage();
            bg.c(this.o.a);
            return null;
        }
    }

    private String G() {
        int indexOf;
        String str = null;
        if (this.j != null) {
            str = this.j.getContentType();
        }
        if (str == null || (indexOf = str.indexOf("charset")) == -1) {
            return "utf-8";
        }
        int indexOf2 = str.indexOf(32, indexOf);
        if (indexOf2 == -1) {
            return str.substring(indexOf + 8);
        }
        return str.substring(indexOf + 8, indexOf2);
    }

    private void d(String str) {
        this.o.c = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.o.c = errorData.getError_code();
                if (this.o.c == -1) {
                    this.o.d = this.i.getString(R.string.error_unkown_try_again);
                } else if (this.o.c != 0) {
                    this.o.d = errorData.getError_msg();
                }
            } catch (Exception e2) {
                com.baidu.adp.lib.util.e.b("NetWork", "parseServerCode", "error = " + e2.getMessage());
                this.o.d = this.i.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tieba.util.an
    public final String x() {
        String str;
        Exception e2;
        byte[] w = w();
        if (this.o.b != 200) {
            return null;
        }
        try {
            str = new String(w, 0, w.length, G());
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        }
        try {
            d(str);
            return str;
        } catch (Exception e4) {
            e2 = e4;
            com.baidu.adp.lib.util.e.b(getClass().getName(), "getNetString", "error = " + e2.getMessage());
            return str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1110=12, 1111=6, 1112=6, 1117=12, 1118=12, 1120=4] */
    @Override // com.baidu.tieba.util.an
    public final String u() {
        SocketTimeoutException socketTimeoutException;
        SocketException socketException;
        Throwable th;
        URL url;
        int read;
        StringBuilder sb = new StringBuilder(1024);
        StringBuilder sb2 = new StringBuilder(1024);
        try {
            int a2 = bg.a(this.o.a);
            if (a2 > 0) {
                bg.a().a(a2);
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.e.b(e2.getMessage());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.o.e == null || i2 >= this.o.e.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.o.e.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                if (i2 != 0) {
                    sb.append("&");
                }
                sb.append(String.valueOf(name) + "=");
                sb.append(bs.d(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
            i = i2 + 1;
        }
        if (this.o.i) {
            sb2.append("tiebaclient!!!");
            String a3 = bs.a(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(a3);
        }
        String sb3 = sb.toString();
        this.t = sb3.length();
        if (com.baidu.tieba.data.i.F()) {
            com.baidu.adp.lib.util.e.e(getClass().getName(), "postNetData", String.valueOf(this.o.a) + "?" + sb3);
        }
        int i3 = 0;
        String str = null;
        boolean z2 = true;
        while (true) {
            if (this.m || !z2 || i3 >= 5) {
                break;
            }
            InputStream inputStream = null;
            try {
                try {
                    try {
                        url = new URL(this.o.a);
                        this.j = a(url);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (SocketException e3) {
                socketException = e3;
            } catch (SocketTimeoutException e4) {
                socketTimeoutException = e4;
            }
            if (this.j == null) {
                this.o.d = this.i.getResources().getString(R.string.neterror);
                try {
                    bg.c(this.o.a);
                } catch (Exception e5) {
                }
                try {
                    if (this.j != null) {
                        this.j.disconnect();
                    }
                } catch (Exception e6) {
                }
            } else {
                this.j.setConnectTimeout(5000);
                this.j.setReadTimeout(15000);
                this.j.setDoOutput(true);
                this.j.setDoInput(true);
                this.j.setRequestMethod("POST");
                this.j.setRequestProperty("Charset", "UTF-8");
                this.j.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                if (this.o.g) {
                    this.j.setRequestProperty("Accept-Encoding", "gzip");
                }
                if (this.m) {
                    try {
                        bg.c(this.o.a);
                    } catch (Exception e7) {
                    }
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e8) {
                    }
                } else {
                    long time = new Date().getTime();
                    try {
                        InetAddress.getByName(url.getHost()).getHostAddress();
                    } catch (Exception e9) {
                        com.baidu.adp.lib.util.e.b(getClass().getName(), "checkDNS", e9.toString());
                    }
                    this.u = new Date().getTime() - time;
                    this.j.connect();
                    this.v = (new Date().getTime() - time) - this.u;
                    DataOutputStream dataOutputStream = new DataOutputStream(this.j.getOutputStream());
                    if (!this.m) {
                        dataOutputStream.writeBytes(sb3);
                    }
                    dataOutputStream.flush();
                    com.baidu.adp.lib.util.e.a("NetWork", "postNetData", "Post data.zise = " + String.valueOf(dataOutputStream.size()));
                    dataOutputStream.close();
                    this.o.b = this.j.getResponseCode();
                    if (this.o.b != 200) {
                        if (this.o.b != 202 && this.o.b != 201 && this.o.b != 205 && this.o.b != 304 && this.o.b != 305 && this.o.b != 408) {
                            if (this.o.b == 502 || this.o.b == 503 || this.o.b == 504) {
                                break;
                            }
                        } else {
                            this.o.l = String.valueOf(String.valueOf(this.o.b)) + "|retryCount:" + i3;
                            bk.a.incrementAndGet();
                            z2 = true;
                            this.o.d = this.i.getResources().getString(R.string.neterror);
                            if (i3 == 0) {
                                cb.a(this);
                            }
                            try {
                                bg.c(this.o.a);
                            } catch (Exception e10) {
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e11) {
                            }
                            i3++;
                        }
                    }
                    if (!this.o.i || !this.j.getContentType().contains("text/vnd.wap.wml")) {
                        String contentEncoding = this.j.getContentEncoding();
                        InputStream inputStream2 = this.j.getInputStream();
                        try {
                            try {
                                byte[] bArr = new byte[1024];
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                                int i4 = 0;
                                while (!this.m && (read = inputStream2.read(bArr)) != -1) {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                    i4 += read;
                                }
                                inputStream2.close();
                                this.j.disconnect();
                                if (this.m) {
                                    try {
                                        bg.c(this.o.a);
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                    } catch (Exception e12) {
                                    }
                                    try {
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                    } catch (Exception e13) {
                                    }
                                } else {
                                    this.n = i4;
                                    long time2 = new Date().getTime() - time;
                                    this.w = (time2 - this.v) - this.u;
                                    com.baidu.adp.lib.util.e.a(getClass().getName(), "postNetData", "time = " + String.valueOf(time2) + "ms");
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    com.baidu.adp.lib.util.e.a(getClass().getName(), "postNetData", "Get data.zise = " + String.valueOf(byteArray.length));
                                    if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                        am.b(byteArrayInputStream, byteArrayOutputStream2);
                                        byteArray = byteArrayOutputStream2.toByteArray();
                                        com.baidu.adp.lib.util.e.a(getClass().getName(), "postNetData", "After ungzip data.zise = " + String.valueOf(byteArray.length));
                                    }
                                    byte[] bArr2 = byteArray;
                                    String str2 = new String(bArr2, 0, bArr2.length, G());
                                    try {
                                        if (this.o.i && this.o.j) {
                                            d(str2);
                                        }
                                        this.x = i3 + 1;
                                        this.y = time2;
                                        bl blVar = new bl();
                                        blVar.e = a(c(this.i));
                                        blVar.c = this.n;
                                        blVar.b = time2;
                                        blVar.d = i3 + 1;
                                        blVar.a = 1;
                                        bk.a(blVar);
                                        cb.a(this);
                                        try {
                                            bg.c(this.o.a);
                                            if (inputStream2 != null) {
                                                inputStream2.close();
                                            }
                                        } catch (Exception e14) {
                                        }
                                        try {
                                            if (this.j != null) {
                                                this.j.disconnect();
                                                str = str2;
                                            } else {
                                                str = str2;
                                            }
                                        } catch (Exception e15) {
                                            str = str2;
                                        }
                                    } catch (SocketException e16) {
                                        inputStream = inputStream2;
                                        socketException = e16;
                                        str = str2;
                                        bk.a.incrementAndGet();
                                        this.o.b = -12;
                                        z2 = true;
                                        this.o.d = this.i.getResources().getString(R.string.neterror);
                                        com.baidu.adp.lib.util.e.b(getClass().getName(), "postNetData", "SocketException " + socketException.getMessage());
                                        if (i3 == 0) {
                                            cb.a(this);
                                        }
                                        try {
                                            bg.c(this.o.a);
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                        } catch (Exception e17) {
                                        }
                                        try {
                                            if (this.j != null) {
                                                this.j.disconnect();
                                            }
                                        } catch (Exception e18) {
                                        }
                                        i3++;
                                    } catch (SocketTimeoutException e19) {
                                        inputStream = inputStream2;
                                        socketTimeoutException = e19;
                                        str = str2;
                                        bk.a.incrementAndGet();
                                        this.o.b = -13;
                                        z2 = true;
                                        this.o.d = this.i.getResources().getString(R.string.neterror);
                                        com.baidu.adp.lib.util.e.b(getClass().getName(), "postNetData", "SocketTimeoutException " + socketTimeoutException.getMessage());
                                        if (i3 == 0) {
                                            cb.a(this);
                                        }
                                        try {
                                            bg.c(this.o.a);
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                        } catch (Exception e20) {
                                        }
                                        try {
                                            if (this.j != null) {
                                                this.j.disconnect();
                                            }
                                        } catch (Exception e21) {
                                        }
                                        i3++;
                                    } catch (Throwable th4) {
                                        inputStream = inputStream2;
                                        th = th4;
                                        str = str2;
                                        this.o.b = -10;
                                        z2 = false;
                                        this.o.d = this.i.getResources().getString(R.string.neterror);
                                        com.baidu.adp.lib.util.e.b(getClass().getName(), "postNetData", th.getMessage());
                                        cb.a(this);
                                        try {
                                            bg.c(this.o.a);
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                        } catch (Exception e22) {
                                        }
                                        try {
                                            if (this.j != null) {
                                                this.j.disconnect();
                                            }
                                        } catch (Exception e23) {
                                        }
                                        i3++;
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                inputStream = inputStream2;
                                try {
                                    bg.c(this.o.a);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (Exception e24) {
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                } catch (Exception e25) {
                                }
                                throw th;
                            }
                        } catch (SocketException e26) {
                            inputStream = inputStream2;
                            socketException = e26;
                        } catch (SocketTimeoutException e27) {
                            inputStream = inputStream2;
                            socketTimeoutException = e27;
                        } catch (Throwable th6) {
                            inputStream = inputStream2;
                            th = th6;
                        }
                    } else if (this.k <= 0) {
                        this.j.disconnect();
                        this.k++;
                        this.o.b = 0;
                        i3--;
                        try {
                            bg.c(this.o.a);
                        } catch (Exception e28) {
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e29) {
                        }
                        i3++;
                    } else {
                        try {
                            bg.c(this.o.a);
                        } catch (Exception e30) {
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e31) {
                        }
                    }
                }
            }
        }
        cb.a(this);
        bg.c(this.o.a);
        try {
            bg.c(this.o.a);
        } catch (Exception e32) {
        }
        try {
            if (this.j != null) {
                this.j.disconnect();
            }
        } catch (Exception e33) {
        }
        return null;
        this.k = 0;
        return str;
    }

    @Override // com.baidu.tieba.util.an
    public final int n() {
        return this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1318=6, 1319=11, 1324=6, 1325=11, 1330=9, 1331=6, 1335=9, 1336=11] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0444 A[Catch: all -> 0x050d, TRY_LEAVE, TryCatch #31 {all -> 0x050d, blocks: (B:33:0x00cf, B:35:0x00d5, B:37:0x00df, B:65:0x01d6, B:67:0x01e2, B:68:0x0239, B:39:0x00e3, B:41:0x00e7, B:43:0x00ed, B:44:0x00f9, B:69:0x023e, B:72:0x0256, B:46:0x00ff, B:48:0x014b, B:49:0x015a, B:51:0x0168, B:52:0x016e, B:54:0x0176, B:56:0x01b2, B:90:0x02e2, B:92:0x02f0, B:94:0x02f4, B:96:0x0301, B:166:0x046a, B:151:0x042a, B:153:0x0444, B:111:0x0338), top: B:314:0x00cf }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0450 A[Catch: Exception -> 0x0530, TRY_LEAVE, TryCatch #1 {Exception -> 0x0530, blocks: (B:156:0x044c, B:158:0x0450), top: B:276:0x044c }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x04a8 A[Catch: Exception -> 0x0513, TRY_LEAVE, TryCatch #30 {Exception -> 0x0513, blocks: (B:169:0x04a4, B:171:0x04a8), top: B:312:0x04a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x04c9 A[Catch: Exception -> 0x0507, TRY_LEAVE, TryCatch #39 {Exception -> 0x0507, blocks: (B:181:0x04c5, B:183:0x04c9), top: B:324:0x04c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x02d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:288:0x02c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x04a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0457 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0449 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:326:0x04d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:328:0x04c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:330:0x04af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x01cf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:348:0x01cf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:350:0x01cf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02c0 A[Catch: all -> 0x0509, TRY_LEAVE, TryCatch #27 {all -> 0x0509, blocks: (B:77:0x02a7, B:79:0x02c0), top: B:310:0x02a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02cc A[Catch: Exception -> 0x0548, TRY_LEAVE, TryCatch #38 {Exception -> 0x0548, blocks: (B:82:0x02c8, B:84:0x02cc), top: B:322:0x02c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02da  */
    @Override // com.baidu.tieba.util.an
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String y() {
        DataOutputStream dataOutputStream;
        Throwable th;
        int i;
        String str;
        Exception e2;
        InputStream inputStream;
        DataOutputStream dataOutputStream2;
        boolean z2;
        byte[] bArr;
        int read;
        String str2 = null;
        boolean z3 = true;
        int i2 = 0;
        while (true) {
            if (this.m || !z3 || i2 >= 5) {
                break;
            }
            InputStream inputStream2 = null;
            try {
                this.j = a(new URL(this.o.a));
            } catch (SocketException e3) {
                inputStream = null;
                str = str2;
                dataOutputStream2 = null;
                i = i2;
            } catch (SocketTimeoutException e4) {
                dataOutputStream = null;
                str = str2;
                i = i2;
            } catch (Exception e5) {
                dataOutputStream = null;
                i = i2;
                str = str2;
                e2 = e5;
            } catch (Throwable th2) {
                dataOutputStream = null;
                th = th2;
            }
            if (this.j == null) {
                this.o.d = this.i.getResources().getString(R.string.neterror);
                try {
                    if (this.j != null) {
                        this.j.disconnect();
                    }
                } catch (Exception e6) {
                }
                if (e != null) {
                    e.removeMessages(0, this);
                }
            } else {
                this.j.setConnectTimeout(5000);
                this.j.setReadTimeout(15000);
                this.j.setDoOutput(true);
                this.j.setDoInput(true);
                this.j.setRequestMethod("POST");
                this.j.setRequestProperty("Charset", "UTF-8");
                this.j.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + c);
                if (this.o.g) {
                    this.j.setRequestProperty("Accept-Encoding", "gzip");
                }
                if (this.m) {
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e7) {
                    }
                    if (e != null) {
                        e.removeMessages(0, this);
                    }
                } else {
                    long time = new Date().getTime();
                    this.j.connect();
                    dataOutputStream = new DataOutputStream(this.j.getOutputStream());
                    for (int i3 = 0; this.o.e != null && i3 < this.o.e.size() && !this.m; i3++) {
                        try {
                            try {
                                BasicNameValuePair basicNameValuePair = this.o.e.get(i3);
                                if (basicNameValuePair != null) {
                                    String name = basicNameValuePair.getName();
                                    String value = basicNameValuePair.getValue();
                                    dataOutputStream.writeBytes(String.valueOf(b) + c + a);
                                    byte[] bytes = value.getBytes("UTF-8");
                                    dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"" + a);
                                    dataOutputStream.writeBytes(a);
                                    dataOutputStream.write(bytes);
                                    dataOutputStream.writeBytes(a);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (SocketException e8) {
                            inputStream = null;
                            i = i2;
                            str = str2;
                            dataOutputStream2 = dataOutputStream;
                        } catch (SocketTimeoutException e9) {
                            i = i2;
                            str = str2;
                        } catch (Exception e10) {
                            str = str2;
                            e2 = e10;
                            i = i2;
                        }
                    }
                    if (!this.m && this.o.f != null) {
                        for (Map.Entry<String, byte[]> entry : this.o.f.entrySet()) {
                            String key = entry.getKey();
                            byte[] value2 = entry.getValue();
                            if (this.m) {
                                break;
                            } else if (value2 != null) {
                                dataOutputStream.writeBytes(String.valueOf(b) + c + a);
                                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"" + a);
                                dataOutputStream.writeBytes(a);
                                dataOutputStream.write(value2);
                                dataOutputStream.writeBytes(a);
                            }
                        }
                    }
                    dataOutputStream.writeBytes(String.valueOf(b) + c + b + a);
                    dataOutputStream.flush();
                    com.baidu.adp.lib.util.e.a("NetWork", "postMultiNetData", "Post data.zise = " + String.valueOf(dataOutputStream.size()));
                    dataOutputStream.close();
                    if (e != null) {
                        e.sendMessageDelayed(e.obtainMessage(0, this), 45000L);
                    }
                    this.o.b = this.j.getResponseCode();
                    if (e != null) {
                        e.removeMessages(0, this);
                    }
                    if (this.o.b != 200) {
                        this.o.l = String.valueOf(String.valueOf(this.o.b)) + "|retryCount:" + i2;
                        bk.a.incrementAndGet();
                        this.o.d = this.i.getResources().getString(R.string.neterror);
                        if (i2 == 0) {
                            cb.a(this);
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e11) {
                        }
                        try {
                            dataOutputStream.close();
                        } catch (Exception e12) {
                        }
                        if (e != null) {
                            e.removeMessages(0, this);
                            str = str2;
                            int i4 = i2;
                            z2 = true;
                            i = i4;
                        } else {
                            str = str2;
                            int i5 = i2;
                            z2 = true;
                            i = i5;
                        }
                    } else if (!this.j.getContentType().contains("text/vnd.wap.wml")) {
                        String contentEncoding = this.j.getContentEncoding();
                        InputStream inputStream3 = this.j.getInputStream();
                        try {
                            try {
                                byte[] bArr2 = new byte[1024];
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                                while (!this.m && (read = inputStream3.read(bArr2)) != -1) {
                                    byteArrayOutputStream.write(bArr2, 0, read);
                                }
                                if (this.m) {
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (Exception e13) {
                                        }
                                    }
                                    try {
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                    } catch (Exception e14) {
                                    }
                                    try {
                                        dataOutputStream.close();
                                    } catch (Exception e15) {
                                    }
                                    if (e != null) {
                                        e.removeMessages(0, this);
                                    }
                                } else {
                                    inputStream3.close();
                                    this.j.disconnect();
                                    com.baidu.adp.lib.util.e.a("NetWork", "postMultiNetData", "time = " + String.valueOf(new Date().getTime() - time) + "ms");
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    com.baidu.adp.lib.util.e.a("NetWork", "postMultiNetData", "Get data.zise = " + String.valueOf(byteArray.length));
                                    if (contentEncoding == null || !contentEncoding.contains("gzip")) {
                                        bArr = byteArray;
                                    } else {
                                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                        am.b(byteArrayInputStream, byteArrayOutputStream2);
                                        bArr = byteArrayOutputStream2.toByteArray();
                                    }
                                    String str3 = new String(bArr, 0, bArr.length, G());
                                    try {
                                        d(str3);
                                        cb.a(this);
                                        if (inputStream3 != null) {
                                            try {
                                                inputStream3.close();
                                            } catch (Exception e16) {
                                            }
                                        }
                                        try {
                                            if (this.j != null) {
                                                this.j.disconnect();
                                            }
                                        } catch (Exception e17) {
                                        }
                                        try {
                                            dataOutputStream.close();
                                        } catch (Exception e18) {
                                        }
                                        if (e != null) {
                                            e.removeMessages(0, this);
                                            str2 = str3;
                                        } else {
                                            str2 = str3;
                                        }
                                    } catch (SocketException e19) {
                                        dataOutputStream2 = dataOutputStream;
                                        inputStream = inputStream3;
                                        str = str3;
                                        i = i2;
                                        z2 = true;
                                        this.o.b = -12;
                                        this.o.d = this.i.getResources().getString(R.string.neterror);
                                        if (i == 0) {
                                            cb.a(this);
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e20) {
                                            }
                                        }
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                        if (dataOutputStream2 != null) {
                                            try {
                                                dataOutputStream2.close();
                                            } catch (Exception e21) {
                                            }
                                        }
                                        if (e == null) {
                                            e.removeMessages(0, this);
                                        }
                                        str2 = str;
                                        z3 = z2;
                                        i2 = i + 1;
                                    } catch (SocketTimeoutException e22) {
                                        inputStream2 = inputStream3;
                                        str = str3;
                                        i = i2;
                                        this.o.b = -13;
                                        z2 = true;
                                        this.o.d = this.i.getResources().getString(R.string.neterror);
                                        if (i == 0) {
                                            cb.a(this);
                                        }
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Exception e23) {
                                            }
                                        }
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (Exception e24) {
                                            }
                                        }
                                        if (e == null) {
                                            e.removeMessages(0, this);
                                        }
                                        str2 = str;
                                        z3 = z2;
                                        i2 = i + 1;
                                    } catch (Exception e25) {
                                        e2 = e25;
                                        inputStream2 = inputStream3;
                                        str = str3;
                                        i = i2;
                                        this.o.b = -10;
                                        z2 = false;
                                        this.o.d = this.i.getResources().getString(R.string.neterror);
                                        com.baidu.adp.lib.util.e.b("NetWork", "postMultiNetData", "error = " + e2.getMessage());
                                        cb.a(this);
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Exception e26) {
                                            }
                                        }
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (Exception e27) {
                                            }
                                        }
                                        if (e == null) {
                                            e.removeMessages(0, this);
                                        }
                                        str2 = str;
                                        z3 = z2;
                                        i2 = i + 1;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream2 = inputStream3;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e28) {
                                    }
                                }
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (Exception e29) {
                                    }
                                }
                                if (e != null) {
                                    e.removeMessages(0, this);
                                }
                                throw th;
                            }
                        } catch (SocketException e30) {
                            inputStream = inputStream3;
                            i = i2;
                            str = str2;
                            dataOutputStream2 = dataOutputStream;
                        } catch (SocketTimeoutException e31) {
                            inputStream2 = inputStream3;
                            i = i2;
                            str = str2;
                        } catch (Exception e32) {
                            inputStream2 = inputStream3;
                            str = str2;
                            e2 = e32;
                            i = i2;
                        }
                    } else if (this.k <= 0) {
                        this.j.disconnect();
                        this.k++;
                        i = i2 - 1;
                        try {
                            this.o.b = 0;
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e33) {
                            }
                            try {
                                dataOutputStream.close();
                            } catch (Exception e34) {
                            }
                            if (e != null) {
                                e.removeMessages(0, this);
                                str = str2;
                                z2 = z3;
                            } else {
                                str = str2;
                                z2 = z3;
                            }
                        } catch (SocketException e35) {
                            inputStream = null;
                            str = str2;
                            dataOutputStream2 = dataOutputStream;
                            z2 = true;
                            try {
                                this.o.b = -12;
                                this.o.d = this.i.getResources().getString(R.string.neterror);
                                if (i == 0) {
                                }
                                if (inputStream != null) {
                                }
                                try {
                                    if (this.j != null) {
                                    }
                                } catch (Exception e36) {
                                }
                                if (dataOutputStream2 != null) {
                                }
                                if (e == null) {
                                }
                                str2 = str;
                                z3 = z2;
                                i2 = i + 1;
                            } catch (Throwable th5) {
                                th = th5;
                                dataOutputStream = dataOutputStream2;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                }
                                try {
                                    if (this.j != null) {
                                    }
                                } catch (Exception e37) {
                                }
                                if (dataOutputStream != null) {
                                }
                                if (e != null) {
                                }
                                throw th;
                            }
                        } catch (SocketTimeoutException e38) {
                            str = str2;
                            this.o.b = -13;
                            z2 = true;
                            this.o.d = this.i.getResources().getString(R.string.neterror);
                            if (i == 0) {
                            }
                            if (inputStream2 != null) {
                            }
                            try {
                                if (this.j != null) {
                                }
                            } catch (Exception e39) {
                            }
                            if (dataOutputStream != null) {
                            }
                            if (e == null) {
                            }
                            str2 = str;
                            z3 = z2;
                            i2 = i + 1;
                        } catch (Exception e40) {
                            str = str2;
                            e2 = e40;
                            this.o.b = -10;
                            z2 = false;
                            this.o.d = this.i.getResources().getString(R.string.neterror);
                            com.baidu.adp.lib.util.e.b("NetWork", "postMultiNetData", "error = " + e2.getMessage());
                            cb.a(this);
                            if (inputStream2 != null) {
                            }
                            try {
                                if (this.j != null) {
                                }
                            } catch (Exception e41) {
                            }
                            if (dataOutputStream != null) {
                            }
                            if (e == null) {
                            }
                            str2 = str;
                            z3 = z2;
                            i2 = i + 1;
                        }
                    } else {
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e42) {
                        }
                        try {
                            dataOutputStream.close();
                        } catch (Exception e43) {
                        }
                        if (e != null) {
                            e.removeMessages(0, this);
                        }
                    }
                    str2 = str;
                    z3 = z2;
                    i2 = i + 1;
                }
            }
        }
        this.k = 0;
        return str2;
    }

    @Override // com.baidu.tieba.util.an
    public final boolean z() {
        return this.o.b == 200 || this.o.b == 206;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1491=8, 1493=4, 1494=8, 1499=4, 1500=8, 1505=7, 1506=4] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0363 A[Catch: Exception -> 0x0388, TRY_LEAVE, TryCatch #25 {Exception -> 0x0388, blocks: (B:149:0x035d, B:151:0x0363), top: B:233:0x035d }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x035a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x036c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.tieba.util.an
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(String str, Handler handler, int i, int i2, int i3) {
        FileOutputStream fileOutputStream;
        Exception e2;
        InputStream inputStream;
        String headerField;
        int indexOf;
        InputStream inputStream2 = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                this.j = a(new URL(this.o.a));
                if (this.j == null) {
                    throw new SocketException();
                }
                this.j.setConnectTimeout(5000);
                this.j.setReadTimeout(30000);
                this.j.setInstanceFollowRedirects(false);
                if (this.m) {
                    this.k = 0;
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e3) {
                    }
                    return false;
                }
                long time = new Date().getTime();
                File g2 = af.g(str);
                if (g2 == null) {
                    throw new FileNotFoundException();
                }
                long length = g2.length();
                fileOutputStream = new FileOutputStream(g2, true);
                try {
                    if (this.l) {
                        this.j.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-" + String.valueOf(200000 + length));
                    } else {
                        this.j.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                    }
                    this.j.connect();
                    this.o.b = this.j.getResponseCode();
                    if (!z()) {
                        this.o.d = this.i.getResources().getString(R.string.neterror);
                        cb.a(this);
                        this.k = 0;
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e4) {
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Exception e5) {
                        }
                        return false;
                    } else if (this.j.getContentType().contains("text/vnd.wap.wml") && this.k <= 0) {
                        this.j.disconnect();
                        this.k++;
                        this.o.b = 0;
                        boolean a2 = a(str, handler, i, i2, i3);
                        this.k = 0;
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e6) {
                        }
                        try {
                            fileOutputStream.close();
                            return a2;
                        } catch (Exception e7) {
                            return a2;
                        }
                    } else {
                        this.k = 0;
                        int i4 = 0;
                        String headerField2 = this.j.getHeaderField("Content-Range");
                        if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                            i4 = com.baidu.adp.lib.f.b.a(headerField2.substring(indexOf + 1), 0);
                        }
                        int a3 = (i4 == 0 && this.o.b == 200 && (headerField = this.j.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.f.b.a(headerField, 0) : i4;
                        if (length >= a3) {
                            this.k = 0;
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e8) {
                            }
                            try {
                                fileOutputStream.close();
                            } catch (Exception e9) {
                            }
                            return true;
                        }
                        InputStream inputStream3 = this.j.getInputStream();
                        try {
                            try {
                                byte[] bArr = new byte[1024];
                                int i5 = 0;
                                int i6 = a3 > 0 ? a3 / 50 : 0;
                                int i7 = 0;
                                if (handler != null && length > 0) {
                                    handler.sendMessage(handler.obtainMessage(i, (int) length, a3));
                                }
                                while (!this.m) {
                                    int read = inputStream3.read(bArr);
                                    if (read != -1) {
                                        try {
                                            fileOutputStream.write(bArr, 0, read);
                                            i5 += read;
                                            i7 += read;
                                            if (handler != null && (i7 > i6 || i5 == a3)) {
                                                i7 = 0;
                                                handler.sendMessage(handler.obtainMessage(i, (int) (i5 + length), a3));
                                            }
                                        } catch (Exception e10) {
                                            throw new FileNotFoundException();
                                        }
                                    }
                                }
                                try {
                                    fileOutputStream.flush();
                                    com.baidu.adp.lib.util.e.a("NetWork", "downloadFile", "time = " + String.valueOf(new Date().getTime() - time) + "ms");
                                    if (a3 != -1) {
                                        com.baidu.adp.lib.util.e.a("NetWork", "downloadFile", "data.zise = " + String.valueOf(a3));
                                    }
                                    boolean z2 = ((long) i5) + length >= ((long) a3);
                                    this.k = 0;
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (Exception e11) {
                                        }
                                    }
                                    try {
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                    } catch (Exception e12) {
                                    }
                                    try {
                                        fileOutputStream.close();
                                        return z2;
                                    } catch (Exception e13) {
                                        return z2;
                                    }
                                } catch (Exception e14) {
                                    throw new FileNotFoundException();
                                }
                            } catch (Throwable th) {
                                th = th;
                                inputStream2 = inputStream3;
                                this.k = 0;
                                if (inputStream2 != null) {
                                }
                                try {
                                    if (this.j != null) {
                                    }
                                } catch (Exception e15) {
                                }
                                if (fileOutputStream != null) {
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException e16) {
                            inputStream = inputStream3;
                            fileOutputStream2 = fileOutputStream;
                            try {
                                cb.a(this);
                                this.o.b = -100;
                                this.o.d = this.i.getResources().getString(R.string.FileWriteError);
                                this.k = 0;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e17) {
                                    }
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                } catch (Exception e18) {
                                }
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                        return false;
                                    } catch (Exception e19) {
                                        return false;
                                    }
                                }
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream2 = inputStream;
                                fileOutputStream = fileOutputStream2;
                                this.k = 0;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e20) {
                                    }
                                }
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e21) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e22) {
                            inputStream2 = inputStream3;
                            e2 = e22;
                            cb.a(this);
                            this.o.b = -10;
                            this.o.d = this.i.getResources().getString(R.string.neterror);
                            com.baidu.adp.lib.util.e.b("NetWork", "downloadFile", "error = " + e2.getMessage());
                            this.k = 0;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e23) {
                                }
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e24) {
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    return false;
                                } catch (Exception e25) {
                                    return false;
                                }
                            }
                            return false;
                        }
                    }
                } catch (FileNotFoundException e26) {
                    fileOutputStream2 = fileOutputStream;
                    inputStream = null;
                } catch (Exception e27) {
                    e2 = e27;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException e28) {
            inputStream = null;
        } catch (Exception e29) {
            fileOutputStream = null;
            e2 = e29;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    @Override // com.baidu.tieba.util.an
    public final void a(Context context) {
        this.i = context;
    }

    @Override // com.baidu.tieba.util.an
    public final Context l() {
        return this.i;
    }

    @Override // com.baidu.tieba.util.an
    public final ArrayList<BasicNameValuePair> m() {
        return this.o.e;
    }

    @Override // com.baidu.tieba.util.an
    public final void a(ArrayList<BasicNameValuePair> arrayList) {
        if (this.o.e != null) {
            this.o.e.clear();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                a(arrayList.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.util.an
    public final void a(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tieba.util.an
    public final void a(String str, byte[] bArr) {
        if (this.o.f == null) {
            this.o.f = new HashMap<>();
        }
        this.o.f.put(str, bArr);
    }

    @Override // com.baidu.tieba.util.an
    public final void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.o.e == null) {
                this.o.e = new ArrayList<>();
            }
            int a2 = a(this.o.e, basicNameValuePair.getName());
            int size = this.o.e.size();
            if (a2 >= 0 && a2 < size) {
                if (basicNameValuePair.getName().equals(this.o.e.get(a2).getName())) {
                    this.o.e.set(a2, basicNameValuePair);
                } else {
                    this.o.e.add(a2, basicNameValuePair);
                }
            } else if (a2 == size) {
                this.o.e.add(a2, basicNameValuePair);
            }
        }
    }

    private static int a(ArrayList<BasicNameValuePair> arrayList, String str) {
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
            int compareTo = str.compareTo(arrayList.get(i).getName());
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

    @Override // com.baidu.tieba.util.an
    public final void d(boolean z2) {
        this.o.h = z2;
    }

    @Override // com.baidu.tieba.util.an
    public final void e(boolean z2) {
        this.o.i = false;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0069 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0002 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.tieba.util.NetWorkCore$NetworkStateInfo] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    private static NetworkStateInfo c(Context context) {
        NetworkStateInfo networkStateInfo;
        ?? e2 = NetworkStateInfo.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                networkStateInfo = NetworkStateInfo.UNAVAIL;
                try {
                    e2 = "NetWorkCore";
                    com.baidu.adp.lib.util.e.a("NetWorkCore", "NetworkStateInfo", "UNAVAIL");
                } catch (Exception e3) {
                    e2 = e3;
                }
            } else if (activeNetworkInfo.getType() == 1) {
                com.baidu.adp.lib.util.e.a("NetWorkCore", "NetworkStateInfo", "WIFI");
                networkStateInfo = NetworkStateInfo.WIFI;
            } else {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        com.baidu.adp.lib.util.e.a("NetWorkCore", "NetworkStateInfo", "TwoG");
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
                        com.baidu.adp.lib.util.e.a("NetWorkCore", "NetworkStateInfo", "ThreeG");
                        networkStateInfo = NetworkStateInfo.ThreeG;
                        break;
                    default:
                        com.baidu.adp.lib.util.e.a("NetWorkCore", "NetworkStateInfo-default", "TwoG");
                        networkStateInfo = NetworkStateInfo.TwoG;
                        break;
                }
            }
            return networkStateInfo;
        } catch (Exception e4) {
            return e2;
        }
    }

    @Override // com.baidu.tieba.util.an
    public final void a(boolean z2) {
        this.p = z2;
    }

    @Override // com.baidu.tieba.util.an
    public final boolean a() {
        return this.j != null && "image/gif".equalsIgnoreCase(this.j.getHeaderField("Src-Content-Type"));
    }

    @Override // com.baidu.tieba.util.an
    public final boolean b() {
        return this.q;
    }

    @Override // com.baidu.tieba.util.an
    public final void b(boolean z2) {
        this.q = true;
    }

    @Override // com.baidu.tieba.util.an
    public final void a(int i) {
        this.s = i;
    }

    @Override // com.baidu.tieba.util.an
    public final void a(String str) {
        this.r = str;
    }

    @Override // com.baidu.tieba.util.an
    public final String B() {
        return this.o.l;
    }

    @Override // com.baidu.tieba.util.an
    public final String C() {
        if (this.o != null) {
            return this.o.m;
        }
        return null;
    }
}
