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
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
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
import org.apache.http.message.BasicNameValuePair;
@Deprecated
/* loaded from: classes.dex */
public class NetWorkCore implements s {

    /* renamed from: a  reason: collision with root package name */
    private static String f1882a = "\r\n";
    private static String b = "--";
    private static String c = "--------7da3d81520810*";
    private static int d = 2097152;
    private static Handler e = null;
    private static volatile String f = null;
    private static volatile boolean g = false;
    private static Pattern h = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    private static /* synthetic */ int[] w;
    private Context i;
    private HttpURLConnection j;
    private int k;
    private boolean l;
    private volatile boolean m;
    private ah o;
    private int n = 0;
    private boolean p = false;
    private int q = 0;
    private long r = 0;
    private long s = 0;
    private long t = 0;
    private int u = 0;
    private long v = 0;

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

    static /* synthetic */ int[] B() {
        int[] iArr = w;
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
            w = iArr;
        }
        return iArr;
    }

    public NetWorkCore(ah ahVar) {
        C();
        this.o = ahVar;
        this.i = TiebaApplication.g();
    }

    @Override // com.baidu.tieba.util.s
    public long d() {
        return this.q;
    }

    @Override // com.baidu.tieba.util.s
    public long e() {
        return this.n;
    }

    @Override // com.baidu.tieba.util.s
    public long f() {
        return this.s;
    }

    @Override // com.baidu.tieba.util.s
    public long g() {
        return this.r;
    }

    @Override // com.baidu.tieba.util.s
    public long i() {
        return this.t;
    }

    @Override // com.baidu.tieba.util.s
    public int h() {
        return this.u;
    }

    @Override // com.baidu.tieba.util.s
    public String c() {
        if (this.o.f1897a == null) {
            return null;
        }
        String str = com.baidu.tieba.data.g.f1032a;
        if (this.o.f1897a.startsWith(str)) {
            int indexOf = this.o.f1897a.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.o.f1897a.length();
            }
            return this.o.f1897a.substring(str.length(), indexOf);
        }
        return this.o.f1897a;
    }

    @Override // com.baidu.tieba.util.s
    public long b() {
        return this.v;
    }

    private int a(NetworkStateInfo networkStateInfo) {
        switch (B()[networkStateInfo.ordinal()]) {
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

    private void C() {
        this.j = null;
        this.i = null;
        this.k = 0;
        this.m = false;
        this.l = false;
        y();
    }

    @Override // com.baidu.tieba.util.s
    public void b(boolean z) {
        this.o.j = z;
    }

    @Override // com.baidu.tieba.util.s
    public String n() {
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
                return "1";
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public static void y() {
        synchronized (NetWorkCore.class) {
            if (!g) {
                g = true;
                z();
            }
        }
    }

    public static synchronized void z() {
        synchronized (NetWorkCore.class) {
            try {
                Cursor query = TiebaApplication.g().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    f = "Basic " + at.b((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e2) {
            }
        }
    }

    public static void A() {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        } else {
            System.setProperty("http.keepAlive", "true");
        }
        e = new ac();
    }

    @Override // com.baidu.tieba.util.s
    public void a(Boolean bool) {
        this.o.g = bool.booleanValue();
    }

    public static NetworkState b(Context context) {
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

    @Override // com.baidu.tieba.util.s
    public void a(String str) {
        this.o.f1897a = str;
    }

    @Override // com.baidu.tieba.util.s
    public boolean o() {
        return this.o.b == 200 && this.o.c == 0;
    }

    @Override // com.baidu.tieba.util.s
    public boolean p() {
        return this.o.b == 200;
    }

    @Override // com.baidu.tieba.util.s
    public int j() {
        return this.o.c;
    }

    @Override // com.baidu.tieba.util.s
    public String q() {
        return this.o.d;
    }

    @Override // com.baidu.tieba.util.s
    public void t() {
        this.o.d = "";
    }

    @Override // com.baidu.tieba.util.s
    public void b(String str) {
        this.o.d = str;
    }

    @Override // com.baidu.tieba.util.s
    public void r() {
        this.m = true;
        try {
            if (this.j != null) {
                this.j.disconnect();
            }
        } catch (Exception e2) {
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x00f1 */
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
        NetworkState b2 = b(this.i);
        this.l = false;
        try {
            if (b2 == NetworkState.UNAVAIL) {
                return null;
            }
            if (b2 == NetworkState.MOBILE && (defaultHost = Proxy.getDefaultHost()) != null && defaultHost.length() > 0) {
                r0 = d(defaultHost);
                try {
                    if (r0 != 0) {
                        this.l = true;
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
                        httpURLConnection2.setRequestProperty(HttpUtils.HEADER_NAME_USER_AGENT, "BaiduTieba for Android " + com.baidu.tieba.data.g.j());
                        httpURLConnection = httpURLConnection2;
                    } else {
                        HttpURLConnection httpURLConnection3 = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort())));
                        if (f != null) {
                            httpURLConnection3.setRequestProperty("Proxy-Authorization", f);
                        }
                        httpURLConnection3.setRequestProperty(HttpUtils.HEADER_NAME_USER_AGENT, "BaiduTieba for Android " + com.baidu.tieba.data.g.j());
                        httpURLConnection = httpURLConnection3;
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    av.b(getClass().getName(), "getConnect", "error = " + e2.getMessage());
                    return r0;
                }
            }
            if (httpURLConnection == null) {
                try {
                    return (HttpURLConnection) url.openConnection();
                } catch (Exception e4) {
                    r0 = httpURLConnection;
                    e2 = e4;
                    av.b(getClass().getName(), "getConnect", "error = " + e2.getMessage());
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [626=9, 627=9, 631=9, 632=9, 634=8] */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0232, code lost:
        if (r1 == null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0234, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x014b, code lost:
        if (0 == 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x014d, code lost:
        r3.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:187:0x043c A[Catch: Exception -> 0x045b, TRY_LEAVE, TryCatch #7 {Exception -> 0x045b, blocks: (B:185:0x0438, B:187:0x043c), top: B:231:0x0438 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0435 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.tieba.util.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] u() {
        String str;
        InputStream inputStream;
        InputStream inputStream2;
        Exception e2;
        int read;
        String headerField;
        byte[] bArr = null;
        boolean z = true;
        try {
            if (this.o.e == null || this.o.e.size() <= 0 || this.p) {
                str = this.o.f1897a;
            } else {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.o.f1897a);
                if (this.o.f1897a.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.o.f1897a.endsWith("?") && !this.o.f1897a.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.o.e.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.o.e.get(i).getName());
                    sb.append("=");
                    sb.append(at.d(this.o.e.get(i).getValue()));
                }
                str = sb.toString();
            }
            URL url = new URL(str);
            this.q = str.length();
            if (com.baidu.tieba.data.g.s()) {
                av.e(getClass().getName(), "getNetData", str);
            }
            int i2 = 0;
            while (true) {
                if (this.m || !z || i2 >= 10) {
                    break;
                }
                InputStream inputStream3 = null;
                try {
                    this.j = a(url);
                } catch (SocketException e3) {
                } catch (SocketTimeoutException e4) {
                } catch (Exception e5) {
                    inputStream2 = null;
                    e2 = e5;
                } catch (Throwable th) {
                    th = th;
                    inputStream = null;
                }
                if (this.j == null) {
                    throw new SocketException();
                }
                this.j.setConnectTimeout(5000);
                this.j.setReadTimeout(30000);
                if ((this.o.g && !this.o.h) || this.p) {
                    this.j.setRequestProperty("Accept-Encoding", "gzip");
                }
                if (this.m) {
                    break;
                }
                long time = new Date().getTime();
                b(url);
                this.r = new Date().getTime() - time;
                this.j.connect();
                this.s = (new Date().getTime() - time) - this.r;
                this.o.b = this.j.getResponseCode();
                if (this.o.b != 200) {
                    throw new SocketException();
                }
                if (!this.j.getContentType().contains("text/vnd.wap.wml")) {
                    String contentEncoding = this.j.getContentEncoding();
                    inputStream = this.j.getInputStream();
                    try {
                        if (TiebaApplication.g().q() && (headerField = this.j.getHeaderField(HttpUtils.HEADER_NAME_CONTENT_LENGTH)) != null) {
                            try {
                                int parseInt = Integer.parseInt(headerField);
                                if (parseInt > d) {
                                    break;
                                }
                                int i3 = parseInt * 10;
                                if (i3 > 0) {
                                    if (com.baidu.adp.lib.f.d.a()) {
                                        com.baidu.adp.lib.f.d.c("pre-free memory for downloaded image:[" + this.o.f1897a + "], size:" + i3);
                                    }
                                    if (!com.baidu.tbadk.a.e.a().c(i3)) {
                                        com.baidu.adp.lib.f.d.c("Image download cacelled. out of memory. url:[" + this.o.f1897a + "], size:" + i3);
                                        break;
                                    }
                                }
                            } catch (Throwable th2) {
                            }
                        }
                        byte[] bArr2 = new byte[1024];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                        int i4 = 0;
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
                                i4 = 0 + read2;
                            }
                        }
                        while (!this.m && i4 < d && (read = inputStream.read(bArr2)) != -1) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                            i4 += read;
                        }
                        if (this.m) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e6) {
                                }
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e7) {
                            }
                        } else {
                            this.n = i4;
                            long time2 = new Date().getTime() - time;
                            this.t = (time2 - this.s) - this.r;
                            av.a(getClass().getName(), "getNetData", "time = " + String.valueOf(time2) + LocaleUtil.MALAY);
                            if (i4 < d) {
                                bArr = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                av.a(getClass().getName(), "getNetData", "data.zise = " + String.valueOf(i4));
                                if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                    r.a(byteArrayInputStream, byteArrayOutputStream2);
                                    bArr = byteArrayOutputStream2.toByteArray();
                                }
                            } else {
                                this.o.b = -1;
                                this.o.d = this.i.getResources().getString(R.string.data_too_big);
                            }
                            this.u = i2 + 1;
                            this.v = time2;
                            aj ajVar = new aj();
                            ajVar.e = a(c(this.i));
                            ajVar.c = this.n;
                            ajVar.b = time2;
                            ajVar.d = i2 + 1;
                            ajVar.f1899a = 2;
                            ai.a(ajVar);
                            aw.a(this);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e8) {
                                }
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e9) {
                            }
                        }
                    } catch (SocketException e10) {
                        inputStream3 = inputStream;
                        try {
                            this.o.b = 0;
                            ai.f1898a.incrementAndGet();
                            z = true;
                            this.o.d = this.i.getResources().getString(R.string.neterror);
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
                            i2++;
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = inputStream3;
                            if (inputStream != null) {
                            }
                            try {
                                if (this.j != null) {
                                }
                            } catch (Exception e13) {
                            }
                            throw th;
                        }
                    } catch (SocketTimeoutException e14) {
                        inputStream3 = inputStream;
                        ai.f1898a.incrementAndGet();
                        this.o.b = 0;
                        z = true;
                        this.o.d = this.i.getResources().getString(R.string.neterror);
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Exception e15) {
                            }
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e16) {
                        }
                        i2++;
                    } catch (Exception e17) {
                        e2 = e17;
                        inputStream2 = inputStream;
                        try {
                            this.o.b = 0;
                            z = false;
                            this.o.d = this.i.getResources().getString(R.string.neterror);
                            av.b(getClass().getName(), "getNetData", "error = " + e2.getMessage());
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e18) {
                                }
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e19) {
                            }
                            i2++;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = inputStream2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e20) {
                                }
                            }
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        if (inputStream != null) {
                        }
                        if (this.j != null) {
                        }
                        throw th;
                    }
                } else if (this.k >= 1) {
                    break;
                } else {
                    this.j.disconnect();
                    this.k++;
                    this.o.b = 0;
                    i2--;
                    if (0 != 0) {
                        try {
                            inputStream3.close();
                        } catch (Exception e21) {
                        }
                    }
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e22) {
                    }
                    i2++;
                }
            }
            this.k = 0;
            return bArr;
            return null;
            try {
                if (this.j != null) {
                    this.j.disconnect();
                }
            } catch (Exception e23) {
            }
            this.k = 0;
            return bArr;
            try {
                if (this.j != null) {
                    this.j.disconnect();
                }
            } catch (Exception e24) {
            }
            return null;
        } catch (Exception e25) {
            av.b(getClass().getName(), "getNetData", e25.getMessage());
            return null;
        }
    }

    private String D() {
        int indexOf;
        String str = null;
        if (this.j != null) {
            str = this.j.getContentType();
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
        this.o.c = -1;
        if (str != null) {
            try {
                com.baidu.tieba.data.r rVar = new com.baidu.tieba.data.r();
                rVar.b(str);
                this.o.c = rVar.a();
                if (this.o.c == -1) {
                    this.o.d = this.i.getString(R.string.error_unkown_try_again);
                } else if (this.o.c != 0) {
                    this.o.d = rVar.b();
                }
            } catch (Exception e2) {
                av.b("NetWork", "parseServerCode", "error = " + e2.getMessage());
                this.o.d = this.i.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tieba.util.s
    public String v() {
        String str;
        Exception e2;
        byte[] u = u();
        if (this.o.b != 200) {
            return null;
        }
        try {
            str = new String(u, 0, u.length, D());
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        }
        try {
            c(str);
            return str;
        } catch (Exception e4) {
            e2 = e4;
            av.b(getClass().getName(), "getNetString", "error = " + e2.getMessage());
            return str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [875=9, 876=9, 880=9, 881=9, 883=9] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x044e A[Catch: Exception -> 0x046c, TRY_LEAVE, TryCatch #4 {Exception -> 0x046c, blocks: (B:152:0x044a, B:154:0x044e), top: B:199:0x044a }] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0447 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.tieba.util.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String s() {
        InputStream inputStream;
        InputStream inputStream2;
        Exception exc;
        InputStream inputStream3;
        SocketTimeoutException socketTimeoutException;
        InputStream inputStream4;
        SocketException socketException;
        URL url;
        int read;
        StringBuilder sb = new StringBuilder(1024);
        StringBuilder sb2 = new StringBuilder(1024);
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
                sb.append(at.d(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
            i = i2 + 1;
        }
        if (this.o.i) {
            sb2.append("tiebaclient!!!");
            String a2 = at.a(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(a2);
        }
        String sb3 = sb.toString();
        this.q = sb3.length();
        if (com.baidu.tieba.data.g.s()) {
            av.e(getClass().getName(), "postNetData", String.valueOf(this.o.f1897a) + "?" + sb3);
        }
        int i3 = 0;
        boolean z = true;
        String str = null;
        while (true) {
            if (this.m || !z || i3 >= 10) {
                break;
            }
            inputStream = null;
            try {
                try {
                    url = new URL(this.o.f1897a);
                    this.j = a(url);
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                    }
                    try {
                        if (this.j != null) {
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
            if (this.j != null) {
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
                    break;
                }
                long time = new Date().getTime();
                b(url);
                this.r = new Date().getTime() - time;
                this.j.connect();
                this.s = (new Date().getTime() - time) - this.r;
                DataOutputStream dataOutputStream = new DataOutputStream(this.j.getOutputStream());
                if (!this.m) {
                    dataOutputStream.writeBytes(sb3);
                }
                dataOutputStream.flush();
                av.a("NetWork", "postNetData", "Post data.zise = " + String.valueOf(dataOutputStream.size()));
                dataOutputStream.close();
                this.o.b = this.j.getResponseCode();
                if (this.o.b != 200) {
                    throw new SocketException();
                }
                if (!this.o.i || !this.j.getContentType().contains("text/vnd.wap.wml")) {
                    String contentEncoding = this.j.getContentEncoding();
                    InputStream inputStream5 = this.j.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                        int i4 = 0;
                        while (!this.m && (read = inputStream5.read(bArr)) != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                            i4 += read;
                        }
                        inputStream5.close();
                        this.j.disconnect();
                        if (this.m) {
                            if (inputStream5 != null) {
                                try {
                                    inputStream5.close();
                                } catch (Exception e6) {
                                }
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e7) {
                            }
                        } else {
                            this.n = i4;
                            long time2 = new Date().getTime() - time;
                            this.t = (time2 - this.s) - this.r;
                            av.a(getClass().getName(), "postNetData", "time = " + String.valueOf(time2) + LocaleUtil.MALAY);
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            av.a(getClass().getName(), "postNetData", "Get data.zise = " + String.valueOf(byteArray.length));
                            if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                r.a(byteArrayInputStream, byteArrayOutputStream2);
                                byteArray = byteArrayOutputStream2.toByteArray();
                                av.a(getClass().getName(), "postNetData", "After ungzip data.zise = " + String.valueOf(byteArray.length));
                            }
                            byte[] bArr2 = byteArray;
                            String str2 = new String(bArr2, 0, bArr2.length, D());
                            try {
                                if (this.o.i && this.o.j) {
                                    c(str2);
                                }
                                this.u = i3 + 1;
                                this.v = time2;
                                aj ajVar = new aj();
                                ajVar.e = a(c(this.i));
                                ajVar.c = this.n;
                                ajVar.b = time2;
                                ajVar.d = i3 + 1;
                                ajVar.f1899a = 1;
                                ai.a(ajVar);
                                aw.a(this);
                                if (inputStream5 != null) {
                                    try {
                                        inputStream5.close();
                                    } catch (Exception e8) {
                                    }
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
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
                                ai.f1898a.incrementAndGet();
                                this.o.b = 0;
                                z = true;
                                this.o.d = this.i.getResources().getString(R.string.neterror);
                                av.b(getClass().getName(), "postNetData", "SocketException " + socketException.getMessage());
                                if (inputStream4 != null) {
                                    try {
                                        inputStream4.close();
                                    } catch (Exception e11) {
                                    }
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                } catch (Exception e12) {
                                }
                                i3++;
                            } catch (SocketTimeoutException e13) {
                                inputStream3 = inputStream5;
                                socketTimeoutException = e13;
                                str = str2;
                                try {
                                    ai.f1898a.incrementAndGet();
                                    this.o.b = 0;
                                    z = true;
                                    this.o.d = this.i.getResources().getString(R.string.neterror);
                                    av.b(getClass().getName(), "postNetData", "SocketTimeoutException " + socketTimeoutException.getMessage());
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (Exception e14) {
                                        }
                                    }
                                    try {
                                        if (this.j != null) {
                                            this.j.disconnect();
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
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                    throw th;
                                }
                            } catch (Exception e17) {
                                inputStream2 = inputStream5;
                                exc = e17;
                                str = str2;
                                this.o.b = 0;
                                z = false;
                                this.o.d = this.i.getResources().getString(R.string.neterror);
                                av.b(getClass().getName(), "postNetData", exc.getMessage());
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e18) {
                                    }
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
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
                } else if (this.k < 1) {
                    this.j.disconnect();
                    this.k++;
                    this.o.b = 0;
                    i3--;
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e23) {
                        }
                    }
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
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
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e26) {
                    }
                }
            } else {
                this.o.d = this.i.getResources().getString(R.string.neterror);
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
            if (this.j != null) {
                this.j.disconnect();
            }
        } catch (Exception e28) {
        }
        this.k = 0;
        return str;
    }

    @Override // com.baidu.tieba.util.s
    public int m() {
        return this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1040=9, 1041=9, 1043=9, 1045=9, 1046=9, 1048=5, 1050=9, 1051=9, 1053=9, 1054=9, 1055=9] */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
        if (0 == 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
        r6.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x046c A[Catch: Exception -> 0x04b3, TRY_LEAVE, TryCatch #6 {Exception -> 0x04b3, blocks: (B:176:0x0468, B:178:0x046c), top: B:280:0x0468 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0465 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x02fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x02ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0473 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:284:0x019f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0191 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0246 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0238 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x01ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:346:0x01ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:348:0x01ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0198 A[Catch: Exception -> 0x04f4, TRY_LEAVE, TryCatch #5 {Exception -> 0x04f4, blocks: (B:60:0x0194, B:62:0x0198), top: B:278:0x0194 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x023f A[Catch: Exception -> 0x04db, TRY_LEAVE, TryCatch #12 {Exception -> 0x04db, blocks: (B:79:0x023b, B:81:0x023f), top: B:290:0x023b }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02f6 A[Catch: Exception -> 0x04be, TRY_LEAVE, TryCatch #40 {Exception -> 0x04be, blocks: (B:97:0x02f2, B:99:0x02f6), top: B:321:0x02f2 }] */
    @Override // com.baidu.tieba.util.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String w() {
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        Throwable th;
        String str;
        int i;
        Exception exc;
        DataOutputStream dataOutputStream3;
        InputStream inputStream;
        boolean z;
        byte[] bArr;
        int read;
        String str2 = null;
        boolean z2 = true;
        int i2 = 0;
        while (true) {
            if (this.m || !z2 || i2 >= 10) {
                break;
            }
            InputStream inputStream2 = null;
            dataOutputStream = null;
            try {
                this.j = a(new URL(this.o.f1897a));
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
            if (this.j == null) {
                this.o.d = this.i.getResources().getString(R.string.neterror);
                break;
            }
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
                break;
            }
            long time = new Date().getTime();
            this.j.connect();
            dataOutputStream2 = new DataOutputStream(this.j.getOutputStream());
            for (int i3 = 0; this.o.e != null && i3 < this.o.e.size() && !this.m; i3++) {
                try {
                    try {
                        BasicNameValuePair basicNameValuePair = this.o.e.get(i3);
                        if (basicNameValuePair != null) {
                            String name = basicNameValuePair.getName();
                            String value = basicNameValuePair.getValue();
                            dataOutputStream2.writeBytes(String.valueOf(b) + c + f1882a);
                            byte[] bytes = value.getBytes("UTF-8");
                            dataOutputStream2.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"" + f1882a);
                            dataOutputStream2.writeBytes(f1882a);
                            dataOutputStream2.write(bytes);
                            dataOutputStream2.writeBytes(f1882a);
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
            if (!this.m && this.o.f != null) {
                for (Map.Entry<String, byte[]> entry : this.o.f.entrySet()) {
                    String key = entry.getKey();
                    byte[] value2 = entry.getValue();
                    if (this.m) {
                        break;
                    } else if (value2 != null) {
                        dataOutputStream2.writeBytes(String.valueOf(b) + c + f1882a);
                        dataOutputStream2.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"" + f1882a);
                        dataOutputStream2.writeBytes(f1882a);
                        dataOutputStream2.write(value2);
                        dataOutputStream2.writeBytes(f1882a);
                    }
                }
            }
            dataOutputStream2.writeBytes(String.valueOf(b) + c + b + f1882a);
            dataOutputStream2.flush();
            av.a("NetWork", "postMultiNetData", "Post data.zise = " + String.valueOf(dataOutputStream2.size()));
            dataOutputStream2.close();
            if (e != null) {
                e.sendMessageDelayed(e.obtainMessage(0, this), 45000L);
            }
            this.o.b = this.j.getResponseCode();
            if (e != null) {
                e.removeMessages(0, this);
            }
            if (this.o.b != 200) {
                throw new SocketException();
            }
            if (!this.j.getContentType().contains("text/vnd.wap.wml")) {
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
                                } catch (Exception e8) {
                                }
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
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
                            this.j.disconnect();
                            av.a("NetWork", "postMultiNetData", "time = " + String.valueOf(new Date().getTime() - time) + LocaleUtil.MALAY);
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            av.a("NetWork", "postMultiNetData", "Get data.zise = " + String.valueOf(byteArray.length));
                            if (contentEncoding == null || !contentEncoding.contains("gzip")) {
                                bArr = byteArray;
                            } else {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                r.a(byteArrayInputStream, byteArrayOutputStream2);
                                bArr = byteArrayOutputStream2.toByteArray();
                            }
                            String str3 = new String(bArr, 0, bArr.length, D());
                            try {
                                c(str3);
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
                                if (dataOutputStream2 != null) {
                                    try {
                                        dataOutputStream2.close();
                                    } catch (Exception e13) {
                                    }
                                }
                                if (e != null) {
                                    e.removeMessages(0, this);
                                    str2 = str3;
                                } else {
                                    str2 = str3;
                                }
                            } catch (SocketException e14) {
                                dataOutputStream3 = dataOutputStream2;
                                str = str3;
                                i = i2;
                                inputStream = inputStream3;
                                z = true;
                                this.o.b = 0;
                                this.o.d = this.i.getResources().getString(R.string.neterror);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e15) {
                                    }
                                }
                                if (this.j != null) {
                                    this.j.disconnect();
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
                                z2 = z;
                            } catch (SocketTimeoutException e17) {
                                inputStream2 = inputStream3;
                                str = str3;
                                i = i2;
                                this.o.b = 0;
                                z = true;
                                this.o.d = this.i.getResources().getString(R.string.neterror);
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e18) {
                                    }
                                }
                                if (this.j != null) {
                                    this.j.disconnect();
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
                                z2 = z;
                            } catch (Exception e20) {
                                exc = e20;
                                inputStream2 = inputStream3;
                                str = str3;
                                i = i2;
                                this.o.b = 0;
                                z = false;
                                this.o.d = this.i.getResources().getString(R.string.neterror);
                                av.b("NetWork", "postMultiNetData", "error = " + exc.getMessage());
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e21) {
                                    }
                                }
                                if (this.j != null) {
                                    this.j.disconnect();
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
                                z2 = z;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream2 = inputStream3;
                        if (inputStream2 != null) {
                        }
                        if (this.j != null) {
                        }
                        if (dataOutputStream2 != null) {
                        }
                        if (e != null) {
                        }
                        throw th;
                    }
                } catch (SocketException e23) {
                    i = i2;
                    str = str2;
                    dataOutputStream3 = dataOutputStream2;
                    inputStream = inputStream3;
                } catch (SocketTimeoutException e24) {
                    inputStream2 = inputStream3;
                    i = i2;
                    str = str2;
                } catch (Exception e25) {
                    inputStream2 = inputStream3;
                    str = str2;
                    exc = e25;
                    i = i2;
                }
            } else if (this.k < 1) {
                this.j.disconnect();
                this.k++;
                i = i2 - 1;
                try {
                    this.o.b = 0;
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (Exception e26) {
                        }
                    }
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e27) {
                    }
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (Exception e28) {
                        }
                    }
                    if (e != null) {
                        e.removeMessages(0, this);
                        z = z2;
                        str = str2;
                    } else {
                        z = z2;
                        str = str2;
                    }
                } catch (SocketException e29) {
                    inputStream = null;
                    str = str2;
                    dataOutputStream3 = dataOutputStream2;
                    z = true;
                    try {
                        this.o.b = 0;
                        this.o.d = this.i.getResources().getString(R.string.neterror);
                        if (inputStream != null) {
                        }
                        try {
                            if (this.j != null) {
                            }
                        } catch (Exception e30) {
                        }
                        if (dataOutputStream3 != null) {
                        }
                        if (e == null) {
                        }
                        i2 = i + 1;
                        str2 = str;
                        z2 = z;
                    } catch (Throwable th5) {
                        th = th5;
                        dataOutputStream2 = dataOutputStream3;
                        inputStream2 = inputStream;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e31) {
                            }
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e32) {
                        }
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                            } catch (Exception e33) {
                            }
                        }
                        if (e != null) {
                            e.removeMessages(0, this);
                        }
                        throw th;
                    }
                } catch (SocketTimeoutException e34) {
                    str = str2;
                    this.o.b = 0;
                    z = true;
                    this.o.d = this.i.getResources().getString(R.string.neterror);
                    if (inputStream2 != null) {
                    }
                    try {
                        if (this.j != null) {
                        }
                    } catch (Exception e35) {
                    }
                    if (dataOutputStream2 != null) {
                    }
                    if (e == null) {
                    }
                    i2 = i + 1;
                    str2 = str;
                    z2 = z;
                } catch (Exception e36) {
                    str = str2;
                    exc = e36;
                    this.o.b = 0;
                    z = false;
                    this.o.d = this.i.getResources().getString(R.string.neterror);
                    av.b("NetWork", "postMultiNetData", "error = " + exc.getMessage());
                    if (inputStream2 != null) {
                    }
                    try {
                        if (this.j != null) {
                        }
                    } catch (Exception e37) {
                    }
                    if (dataOutputStream2 != null) {
                    }
                    if (e == null) {
                    }
                    i2 = i + 1;
                    str2 = str;
                    z2 = z;
                }
                i2 = i + 1;
                str2 = str;
                z2 = z;
            } else {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e38) {
                    }
                }
                try {
                    if (this.j != null) {
                        this.j.disconnect();
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
        this.k = 0;
        return str2;
        if (0 != 0) {
            try {
                dataOutputStream.close();
            } catch (Exception e41) {
            }
        }
        if (e != null) {
            e.removeMessages(0, this);
        }
        this.k = 0;
        return str2;
        if (e != null) {
        }
        this.k = 0;
        return str2;
        try {
            if (this.j != null) {
                this.j.disconnect();
            }
        } catch (Exception e42) {
        }
        if (0 != 0) {
        }
        if (e != null) {
        }
        this.k = 0;
        return str2;
    }

    @Override // com.baidu.tieba.util.s
    public boolean x() {
        return this.o.b == 200 || this.o.b == 206;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1189=7, 1191=7, 1192=7, 1196=7, 1197=7, 1201=7, 1202=7, 1204=7] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x036a A[Catch: Exception -> 0x0392, TRY_LEAVE, TryCatch #18 {Exception -> 0x0392, blocks: (B:162:0x0364, B:164:0x036a), top: B:238:0x0364 }] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0373 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0361 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.tieba.util.s
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
                this.j = a(new URL(this.o.f1897a));
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
        if (this.j == null) {
            throw new SocketException();
        }
        this.j.setConnectTimeout(5000);
        this.j.setReadTimeout(30000);
        this.j.setInstanceFollowRedirects(false);
        if (this.m) {
            r2 = false;
            this.k = 0;
            if (0 != 0) {
                try {
                    inputStream2.close();
                } catch (Exception e5) {
                }
            }
            try {
                if (this.j != null) {
                    this.j.disconnect();
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
            File f2 = p.f(str);
            if (f2 == null) {
                throw new FileNotFoundException();
            }
            long length = f2.length();
            fileOutputStream = new FileOutputStream(f2, true);
            try {
                if (this.l) {
                    this.j.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-" + String.valueOf(200000 + length));
                } else {
                    this.j.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                }
                this.j.connect();
                this.o.b = this.j.getResponseCode();
                if (!x()) {
                    throw new SocketException();
                }
                if (!this.j.getContentType().contains("text/vnd.wap.wml") || this.k >= 1) {
                    this.k = 0;
                    int i2 = 0;
                    String headerField2 = this.j.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i2 = Integer.valueOf(headerField2.substring(indexOf + 1)).intValue();
                    }
                    int intValue = (i2 == 0 && this.o.b == 200 && (headerField = this.j.getHeaderField(HttpUtils.HEADER_NAME_CONTENT_LENGTH)) != null) ? Integer.valueOf(headerField).intValue() : i2;
                    if (length >= intValue) {
                        r2 = true;
                        this.k = 0;
                        if (0 != 0) {
                            try {
                                inputStream2.close();
                            } catch (Exception e8) {
                            }
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
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
                        InputStream inputStream3 = this.j.getInputStream();
                        try {
                            try {
                                byte[] bArr = new byte[1024];
                                int i3 = 0;
                                int i4 = intValue > 0 ? intValue / 50 : 0;
                                int i5 = 0;
                                if (handler != null && length > 0) {
                                    handler.sendMessage(handler.obtainMessage(i, (int) length, intValue));
                                }
                                while (!this.m) {
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
                                    av.a("NetWork", "downloadFile", "time = " + String.valueOf(new Date().getTime() - time) + LocaleUtil.MALAY);
                                    if (intValue != -1) {
                                        av.a("NetWork", "downloadFile", "data.zise = " + String.valueOf(intValue));
                                    }
                                    r2 = ((long) i3) + length >= ((long) intValue);
                                    this.k = 0;
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (Exception e12) {
                                        }
                                    }
                                    try {
                                        if (this.j != null) {
                                            this.j.disconnect();
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
                                this.k = 0;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e16) {
                                    }
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
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
                                this.o.b = -2;
                                this.o.d = this.i.getResources().getString(R.string.FileWriteError);
                                this.k = 0;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e20) {
                                    }
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
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
                                this.k = 0;
                                if (inputStream2 != null) {
                                }
                                if (this.j != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                throw th;
                            }
                        } catch (Exception e23) {
                            inputStream2 = inputStream3;
                            e2 = e23;
                            this.o.b = 0;
                            this.o.d = this.i.getResources().getString(R.string.neterror);
                            av.b("NetWork", "downloadFile", "error = " + e2.getMessage());
                            this.k = 0;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e24) {
                                }
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
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
                    this.j.disconnect();
                    this.k++;
                    this.o.b = 0;
                    r2 = a(str, handler, i);
                    this.k = 0;
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (Exception e27) {
                        }
                    }
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
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

    @Override // com.baidu.tieba.util.s
    public void a(Context context) {
        this.i = context;
    }

    @Override // com.baidu.tieba.util.s
    public Context k() {
        return this.i;
    }

    @Override // com.baidu.tieba.util.s
    public ArrayList<BasicNameValuePair> l() {
        return this.o.e;
    }

    @Override // com.baidu.tieba.util.s
    public void a(ArrayList<BasicNameValuePair> arrayList) {
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

    @Override // com.baidu.tieba.util.s
    public void a(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tieba.util.s
    public void a(String str, byte[] bArr) {
        if (this.o.f == null) {
            this.o.f = new HashMap<>();
        }
        this.o.f.put(str, bArr);
    }

    @Override // com.baidu.tieba.util.s
    public void a(BasicNameValuePair basicNameValuePair) {
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

    private int a(ArrayList<BasicNameValuePair> arrayList, String str) {
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

    @Override // com.baidu.tieba.util.s
    public void c(boolean z) {
        this.o.h = z;
    }

    public void d(boolean z) {
        this.o.i = z;
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
                    av.a("NetWorkCore", "NetworkStateInfo", "UNAVAIL");
                } catch (Exception e3) {
                    e2 = e3;
                }
            } else if (activeNetworkInfo.getType() == 1) {
                av.a("NetWorkCore", "NetworkStateInfo", "WIFI");
                networkStateInfo = NetworkStateInfo.WIFI;
            } else {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        av.a("NetWorkCore", "NetworkStateInfo", "TwoG");
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
                        av.a("NetWorkCore", "NetworkStateInfo", "ThreeG");
                        networkStateInfo = NetworkStateInfo.ThreeG;
                        break;
                    default:
                        av.a("NetWorkCore", "NetworkStateInfo-default", "TwoG");
                        networkStateInfo = NetworkStateInfo.TwoG;
                        break;
                }
            }
            return networkStateInfo;
        } catch (Exception e4) {
            return e2;
        }
    }

    private void b(URL url) {
        try {
            InetAddress.getByName(url.getHost()).getHostAddress();
        } catch (Exception e2) {
            av.b(getClass().getName(), "checkDNS", e2.toString());
        }
    }

    @Override // com.baidu.tieba.util.s
    public void a(boolean z) {
        this.p = z;
    }

    @Override // com.baidu.tieba.util.s
    public boolean a() {
        return this.j != null && "image/gif".equalsIgnoreCase(this.j.getHeaderField("Src-Content-Type"));
    }
}
