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
import android.text.TextUtils;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ErrorData;
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
public class NetWorkCore implements ai {

    /* renamed from: a  reason: collision with root package name */
    private static String f2448a = "\r\n";
    private static String b = "--";
    private static String c = "--------7da3d81520810*";
    private static int d = 2097152;
    private static Handler e = null;
    private static volatile String f = null;
    private static volatile boolean g = false;
    private static Pattern h = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    private Context i;
    private HttpURLConnection j;
    private int k;
    private boolean l;
    private volatile boolean m;
    private az o;
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

    /* loaded from: classes.dex */
    public enum NetworkState {
        UNAVAIL,
        WIFI,
        MOBILE
    }

    /* loaded from: classes.dex */
    public enum NetworkStateInfo {
        UNAVAIL,
        WIFI,
        TwoG,
        ThreeG
    }

    public NetWorkCore(az azVar) {
        D();
        this.o = azVar;
        this.i = TiebaApplication.g();
    }

    @Override // com.baidu.tieba.util.ai
    public long f() {
        return this.t;
    }

    @Override // com.baidu.tieba.util.ai
    public long g() {
        return this.n;
    }

    @Override // com.baidu.tieba.util.ai
    public long h() {
        return this.v;
    }

    @Override // com.baidu.tieba.util.ai
    public long i() {
        return this.u;
    }

    @Override // com.baidu.tieba.util.ai
    public long k() {
        return this.w;
    }

    @Override // com.baidu.tieba.util.ai
    public int j() {
        return this.x;
    }

    @Override // com.baidu.tieba.util.ai
    public String e() {
        if (this.o.f2478a == null) {
            return null;
        }
        String str = com.baidu.tieba.data.h.f1201a;
        if (this.o.f2478a.startsWith(str)) {
            int indexOf = this.o.f2478a.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.o.f2478a.length();
            }
            return this.o.f2478a.substring(str.length(), indexOf);
        }
        return this.o.f2478a;
    }

    @Override // com.baidu.tieba.util.ai
    public long d() {
        return this.y;
    }

    private int a(NetworkStateInfo networkStateInfo) {
        switch (networkStateInfo) {
            case WIFI:
                return 1;
            case TwoG:
                return 2;
            case ThreeG:
                return 3;
            default:
                return 0;
        }
    }

    private void D() {
        this.j = null;
        this.i = null;
        this.k = 0;
        this.m = false;
        this.l = false;
        A();
    }

    @Override // com.baidu.tieba.util.ai
    public void c(boolean z) {
        this.o.j = z;
    }

    @Override // com.baidu.tieba.util.ai
    public String p() {
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

    public static void A() {
        synchronized (NetWorkCore.class) {
            if (!g) {
                g = true;
                B();
            }
        }
    }

    public static synchronized void B() {
        synchronized (NetWorkCore.class) {
            try {
                Cursor query = TiebaApplication.g().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    f = "Basic " + be.b((string + ":" + string2).getBytes());
                }
            } catch (Exception e2) {
            }
        }
    }

    public static void C() {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        } else {
            System.setProperty("http.keepAlive", "true");
        }
        e = new as();
    }

    @Override // com.baidu.tieba.util.ai
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

    @Override // com.baidu.tieba.util.ai
    public void b(String str) {
        this.o.f2478a = str;
    }

    @Override // com.baidu.tieba.util.ai
    public boolean q() {
        return this.o.b == 200 && this.o.c == 0;
    }

    @Override // com.baidu.tieba.util.ai
    public boolean r() {
        return this.o.b == 200;
    }

    @Override // com.baidu.tieba.util.ai
    public int l() {
        return this.o.c;
    }

    @Override // com.baidu.tieba.util.ai
    public String s() {
        return this.o.d;
    }

    @Override // com.baidu.tieba.util.ai
    public void v() {
        this.o.d = "";
    }

    @Override // com.baidu.tieba.util.ai
    public void c(String str) {
        this.o.d = str;
    }

    @Override // com.baidu.tieba.util.ai
    public void t() {
        this.m = true;
        try {
            if (this.j != null) {
                this.j.disconnect();
            }
        } catch (Exception e2) {
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0124 */
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
                r0 = e(defaultHost);
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
                        httpURLConnection2.setRequestProperty(HttpUtils.HEADER_NAME_USER_AGENT, "BaiduTieba for Android " + com.baidu.tieba.data.h.j());
                        if (!TextUtils.isEmpty(TiebaApplication.A())) {
                            httpURLConnection2.setRequestProperty("client_user_token", TiebaApplication.A());
                        }
                        httpURLConnection = httpURLConnection2;
                    } else {
                        HttpURLConnection httpURLConnection3 = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort())));
                        if (f != null) {
                            httpURLConnection3.setRequestProperty("Proxy-Authorization", f);
                        }
                        httpURLConnection3.setRequestProperty(HttpUtils.HEADER_NAME_USER_AGENT, "BaiduTieba for Android " + com.baidu.tieba.data.h.j());
                        if (!TextUtils.isEmpty(TiebaApplication.A())) {
                            httpURLConnection3.setRequestProperty("client_user_token", TiebaApplication.A());
                        }
                        httpURLConnection = httpURLConnection3;
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    bg.b(getClass().getName(), "getConnect", "error = " + e2.getMessage());
                    return r0;
                }
            }
            if (httpURLConnection == null) {
                try {
                    return (HttpURLConnection) url.openConnection();
                } catch (Exception e4) {
                    r0 = httpURLConnection;
                    e2 = e4;
                    bg.b(getClass().getName(), "getConnect", "error = " + e2.getMessage());
                    return r0;
                }
            }
            return httpURLConnection;
        } catch (Exception e5) {
            r0 = 0;
            e2 = e5;
        }
    }

    private boolean e(String str) {
        if (h.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [648=11, 649=11, 653=11, 654=11, 656=4] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0475 A[Catch: Exception -> 0x04a9, TRY_LEAVE, TryCatch #2 {Exception -> 0x04a9, blocks: (B:198:0x0471, B:200:0x0475), top: B:243:0x0471 }] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x046e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x023e -> B:265:0x00a7). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:161:0x032e -> B:240:0x0156). Please submit an issue!!! */
    @Override // com.baidu.tieba.util.ai
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] w() {
        String str;
        URL url;
        int i;
        InputStream inputStream;
        InputStream inputStream2;
        Exception e2;
        int read;
        String headerField;
        byte[] bArr = null;
        boolean z = true;
        try {
            if (this.o.e == null || this.o.e.size() <= 0 || this.p) {
                str = this.o.f2478a;
            } else {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.o.f2478a);
                if (this.o.f2478a.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.o.f2478a.endsWith("?") && !this.o.f2478a.endsWith("&")) {
                    sb.append("&");
                }
                for (int i2 = 0; i2 < this.o.e.size(); i2++) {
                    if (i2 != 0) {
                        sb.append("&");
                    }
                    sb.append(this.o.e.get(i2).getName());
                    sb.append("=");
                    sb.append(be.d(this.o.e.get(i2).getValue()));
                }
                str = sb.toString();
            }
            url = new URL(str);
            this.t = str.length();
            if (com.baidu.tieba.data.h.s()) {
                bg.e(getClass().getName(), "getNetData", str);
            }
            i = 0;
        } catch (Exception e3) {
            bg.b(getClass().getName(), "getNetData", e3.getMessage());
        }
        while (!this.m && z && i < 10) {
            InputStream inputStream3 = null;
            try {
                this.j = a(url);
            } catch (SocketException e4) {
            } catch (SocketTimeoutException e5) {
            } catch (Exception e6) {
                inputStream2 = null;
                e2 = e6;
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
                if (0 != 0) {
                    try {
                        inputStream3.close();
                    } catch (Exception e7) {
                    }
                }
                if (this.j != null) {
                    this.j.disconnect();
                }
            } else {
                long time = new Date().getTime();
                b(url);
                this.u = new Date().getTime() - time;
                this.j.connect();
                this.v = (new Date().getTime() - time) - this.u;
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
                                try {
                                    if (parseInt > d) {
                                        bArr = null;
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e8) {
                                            }
                                        }
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                    } else {
                                        int i3 = parseInt * 10;
                                        if (i3 > 0) {
                                            if (com.baidu.adp.lib.h.d.a()) {
                                                com.baidu.adp.lib.h.d.d("pre-free memory for downloaded image:[" + this.o.f2478a + "], size:" + i3);
                                            }
                                            if (!com.baidu.tbadk.imageManager.d.a().c(i3)) {
                                                com.baidu.adp.lib.h.d.d("Image download cacelled. out of memory. url:[" + this.o.f2478a + "], size:" + i3);
                                                bArr = null;
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (Exception e9) {
                                                    }
                                                }
                                                if (this.j != null) {
                                                    this.j.disconnect();
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e10) {
                                }
                            } catch (Throwable th2) {
                            }
                            return bArr;
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
                        if (a() && this.s == 1) {
                            this.s = 2;
                        }
                        while (!this.m && i4 < d && (read = inputStream.read(bArr2)) != -1) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                            i4 += read;
                        }
                        if (this.m) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e11) {
                                }
                            }
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } else {
                            this.n = i4;
                            long time2 = new Date().getTime() - time;
                            this.w = (time2 - this.v) - this.u;
                            bg.a(getClass().getName(), "getNetData", "time = " + String.valueOf(time2) + LocaleUtil.MALAY);
                            if (i4 < d) {
                                bArr = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                bg.a(getClass().getName(), "getNetData", "data.zise = " + String.valueOf(i4));
                                if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                    ah.b(byteArrayInputStream, byteArrayOutputStream2);
                                    bArr = byteArrayOutputStream2.toByteArray();
                                }
                            } else {
                                this.o.b = -1;
                                this.o.d = this.i.getResources().getString(R.string.data_too_big);
                            }
                            this.x = i + 1;
                            this.y = time2;
                            bb bbVar = new bb();
                            bbVar.e = a(c(this.i));
                            bbVar.c = this.n;
                            bbVar.b = time2;
                            bbVar.d = i + 1;
                            bbVar.f2480a = 2;
                            ba.a(bbVar);
                            if (this.q) {
                                bh.b(this);
                            } else {
                                bh.a(this);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        }
                    } catch (SocketException e13) {
                        inputStream3 = inputStream;
                        try {
                            this.o.b = 0;
                            ba.f2479a.incrementAndGet();
                            z = true;
                            this.o.d = this.i.getResources().getString(R.string.neterror);
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (Exception e14) {
                                }
                            }
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                            i++;
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = inputStream3;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e15) {
                                }
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e16) {
                            }
                            throw th;
                        }
                    } catch (SocketTimeoutException e17) {
                        inputStream3 = inputStream;
                        ba.f2479a.incrementAndGet();
                        this.o.b = 0;
                        z = true;
                        this.o.d = this.i.getResources().getString(R.string.neterror);
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Exception e18) {
                            }
                        }
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                        i++;
                    } catch (Exception e19) {
                        e2 = e19;
                        inputStream2 = inputStream;
                        try {
                            this.o.b = 0;
                            z = false;
                            this.o.d = this.i.getResources().getString(R.string.neterror);
                            bg.b(getClass().getName(), "getNetData", "error = " + e2.getMessage());
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e20) {
                                }
                            }
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                            i++;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = inputStream2;
                            if (inputStream != null) {
                            }
                            if (this.j != null) {
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
                } else if (this.k < 1) {
                    this.j.disconnect();
                    this.k++;
                    this.o.b = 0;
                    i--;
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
                    i++;
                } else {
                    if (0 != 0) {
                        try {
                            inputStream3.close();
                        } catch (Exception e23) {
                        }
                    }
                    if (this.j != null) {
                        this.j.disconnect();
                    }
                }
            }
        }
        this.k = 0;
        return bArr;
    }

    private String E() {
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

    public void d(String str) {
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
                bg.b("NetWork", "parseServerCode", "error = " + e2.getMessage());
                this.o.d = this.i.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tieba.util.ai
    public String x() {
        String str;
        Exception e2;
        byte[] w = w();
        if (this.o.b != 200) {
            return null;
        }
        try {
            str = new String(w, 0, w.length, E());
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        }
        try {
            d(str);
            return str;
        } catch (Exception e4) {
            e2 = e4;
            bg.b(getClass().getName(), "getNetString", "error = " + e2.getMessage());
            return str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [909=11, 910=11, 914=11, 915=11, 917=4] */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0285, code lost:
        if (0 == 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0287, code lost:
        r3.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:173:0x04b9 A[Catch: Exception -> 0x04ef, TRY_LEAVE, TryCatch #0 {Exception -> 0x04ef, blocks: (B:171:0x04b5, B:173:0x04b9), top: B:221:0x04b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x04b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0165 -> B:232:0x010a). Please submit an issue!!! */
    @Override // com.baidu.tieba.util.ai
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String u() {
        InputStream inputStream;
        Exception exc;
        InputStream inputStream2;
        SocketTimeoutException socketTimeoutException;
        InputStream inputStream3;
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
                sb.append(name + "=");
                sb.append(be.d(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
            i = i2 + 1;
        }
        if (this.o.i) {
            sb2.append("tiebaclient!!!");
            String a2 = be.a(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(a2);
        }
        String sb3 = sb.toString();
        this.t = sb3.length();
        if (com.baidu.tieba.data.h.s()) {
            bg.e(getClass().getName(), "postNetData", this.o.f2478a + "?" + sb3);
        }
        int i3 = 0;
        boolean z = true;
        String str = null;
        while (true) {
            if (this.m || !z || i3 >= 10) {
                break;
            }
            InputStream inputStream4 = null;
            try {
                try {
                    url = new URL(this.o.f2478a);
                    this.j = a(url);
                } catch (Throwable th) {
                    th = th;
                    if (inputStream4 != null) {
                        try {
                            inputStream4.close();
                        } catch (Exception e2) {
                        }
                    }
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e3) {
                    }
                    throw th;
                }
            } catch (SocketException e4) {
                inputStream3 = null;
                socketException = e4;
            } catch (SocketTimeoutException e5) {
                inputStream2 = null;
                socketTimeoutException = e5;
            } catch (Exception e6) {
                inputStream = null;
                exc = e6;
            }
            if (this.j == null) {
                this.o.d = this.i.getResources().getString(R.string.neterror);
                if (0 != 0) {
                    try {
                        inputStream4.close();
                    } catch (Exception e7) {
                    }
                }
                if (this.j != null) {
                    this.j.disconnect();
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
                    if (0 != 0) {
                        try {
                            inputStream4.close();
                        } catch (Exception e8) {
                        }
                    }
                    if (this.j != null) {
                        this.j.disconnect();
                    }
                } else {
                    long time = new Date().getTime();
                    b(url);
                    this.u = new Date().getTime() - time;
                    this.j.connect();
                    this.v = (new Date().getTime() - time) - this.u;
                    DataOutputStream dataOutputStream = new DataOutputStream(this.j.getOutputStream());
                    if (!this.m) {
                        dataOutputStream.writeBytes(sb3);
                    }
                    dataOutputStream.flush();
                    bg.a("NetWork", "postNetData", "Post data.zise = " + String.valueOf(dataOutputStream.size()));
                    dataOutputStream.close();
                    this.o.b = this.j.getResponseCode();
                    if (this.o.b != 200) {
                        if (this.o.b != 202 && this.o.b != 201 && this.o.b != 205 && this.o.b != 304 && this.o.b != 305 && this.o.b != 408) {
                            if (this.o.b == 502 || this.o.b == 503 || this.o.b == 504) {
                                break;
                            }
                        } else {
                            break;
                        }
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
                                    } catch (Exception e9) {
                                    }
                                }
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } else {
                                this.n = i4;
                                long time2 = new Date().getTime() - time;
                                this.w = (time2 - this.v) - this.u;
                                bg.a(getClass().getName(), "postNetData", "time = " + String.valueOf(time2) + LocaleUtil.MALAY);
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                bg.a(getClass().getName(), "postNetData", "Get data.zise = " + String.valueOf(byteArray.length));
                                if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                    ah.b(byteArrayInputStream, byteArrayOutputStream2);
                                    byteArray = byteArrayOutputStream2.toByteArray();
                                    bg.a(getClass().getName(), "postNetData", "After ungzip data.zise = " + String.valueOf(byteArray.length));
                                }
                                byte[] bArr2 = byteArray;
                                String str2 = new String(bArr2, 0, bArr2.length, E());
                                try {
                                    if (this.o.i && this.o.j) {
                                        d(str2);
                                    }
                                    this.x = i3 + 1;
                                    this.y = time2;
                                    bb bbVar = new bb();
                                    bbVar.e = a(c(this.i));
                                    bbVar.c = this.n;
                                    bbVar.b = time2;
                                    bbVar.d = i3 + 1;
                                    bbVar.f2480a = 1;
                                    ba.a(bbVar);
                                    bh.a(this);
                                    if (inputStream5 != null) {
                                        try {
                                            inputStream5.close();
                                        } catch (Exception e10) {
                                        }
                                    }
                                    try {
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                    } catch (Exception e11) {
                                    }
                                    str = str2;
                                } catch (SocketException e12) {
                                    inputStream3 = inputStream5;
                                    socketException = e12;
                                    str = str2;
                                    ba.f2479a.incrementAndGet();
                                    this.o.b = 0;
                                    z = true;
                                    this.o.d = this.i.getResources().getString(R.string.neterror);
                                    bg.b(getClass().getName(), "postNetData", "SocketException " + socketException.getMessage());
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (Exception e13) {
                                        }
                                    }
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                    i3++;
                                } catch (SocketTimeoutException e14) {
                                    inputStream2 = inputStream5;
                                    socketTimeoutException = e14;
                                    str = str2;
                                    try {
                                        ba.f2479a.incrementAndGet();
                                        this.o.b = 0;
                                        z = true;
                                        this.o.d = this.i.getResources().getString(R.string.neterror);
                                        bg.b(getClass().getName(), "postNetData", "SocketTimeoutException " + socketTimeoutException.getMessage());
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Exception e15) {
                                            }
                                        }
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                        i3++;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        inputStream4 = inputStream2;
                                        if (inputStream4 != null) {
                                        }
                                        if (this.j != null) {
                                        }
                                        throw th;
                                    }
                                } catch (Exception e16) {
                                    inputStream = inputStream5;
                                    exc = e16;
                                    str = str2;
                                    this.o.b = 0;
                                    z = false;
                                    this.o.d = this.i.getResources().getString(R.string.neterror);
                                    bg.b(getClass().getName(), "postNetData", exc.getMessage());
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e17) {
                                        }
                                    }
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                    i3++;
                                }
                            }
                        } catch (SocketException e18) {
                            inputStream3 = inputStream5;
                            socketException = e18;
                        } catch (SocketTimeoutException e19) {
                            inputStream2 = inputStream5;
                            socketTimeoutException = e19;
                        } catch (Exception e20) {
                            inputStream = inputStream5;
                            exc = e20;
                        }
                    } else if (this.k < 1) {
                        this.j.disconnect();
                        this.k++;
                        this.o.b = 0;
                        i3--;
                        if (0 != 0) {
                            try {
                                inputStream4.close();
                            } catch (Exception e21) {
                            }
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e22) {
                        }
                        i3++;
                    } else {
                        if (0 != 0) {
                            try {
                                inputStream4.close();
                            } catch (Exception e23) {
                            }
                        }
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    }
                }
            }
        }
        throw new SocketException("retry");
        this.k = 0;
        return str;
        try {
            if (this.j != null) {
                this.j.disconnect();
            }
        } catch (Exception e24) {
        }
        return str;
        return str;
    }

    @Override // com.baidu.tieba.util.ai
    public int o() {
        return this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1074=10, 1075=10, 1077=10, 1079=10, 1080=10, 1084=10, 1085=10, 1087=10, 1088=10, 1089=10] */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
        r0.removeMessages(0, r12);
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0322 A[Catch: Exception -> 0x04f3, TRY_LEAVE, TryCatch #10 {Exception -> 0x04f3, blocks: (B:111:0x031e, B:113:0x0322), top: B:306:0x031e }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x047b A[Catch: Exception -> 0x04fc, TRY_LEAVE, TryCatch #46 {Exception -> 0x04fc, blocks: (B:182:0x0477, B:184:0x047b), top: B:351:0x0477 }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x031b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0284 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0276 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0329 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0474 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0192 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0184 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0482 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:371:0x019f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:372:0x019f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:373:0x019f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018b A[Catch: Exception -> 0x04f9, TRY_LEAVE, TryCatch #47 {Exception -> 0x04f9, blocks: (B:61:0x0187, B:63:0x018b), top: B:353:0x0187 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x027d A[Catch: Exception -> 0x04f6, TRY_LEAVE, TryCatch #7 {Exception -> 0x04f6, blocks: (B:95:0x0279, B:97:0x027d), top: B:302:0x0279 }] */
    @Override // com.baidu.tieba.util.ai
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String y() {
        DataOutputStream dataOutputStream;
        Throwable th;
        String str;
        int i;
        Exception exc;
        DataOutputStream dataOutputStream2;
        InputStream inputStream;
        boolean z;
        Handler handler;
        Handler handler2;
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
            DataOutputStream dataOutputStream3 = null;
            try {
                this.j = a(new URL(this.o.f2478a));
            } catch (SocketException e2) {
                str = str2;
                dataOutputStream2 = null;
                i = i2;
                inputStream = null;
            } catch (SocketTimeoutException e3) {
                dataOutputStream = null;
                str = str2;
                i = i2;
            } catch (Exception e4) {
                dataOutputStream = null;
                str = str2;
                i = i2;
                exc = e4;
            } catch (Throwable th2) {
                dataOutputStream = null;
                th = th2;
            }
            if (this.j == null) {
                this.o.d = this.i.getResources().getString(R.string.neterror);
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
                        dataOutputStream3.close();
                    } catch (Exception e7) {
                    }
                }
                if (e != null) {
                    handler2 = e;
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
                    if (0 != 0) {
                        try {
                            dataOutputStream3.close();
                        } catch (Exception e10) {
                        }
                    }
                    if (e != null) {
                        handler2 = e;
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
                                    dataOutputStream.writeBytes(b + c + f2448a);
                                    byte[] bytes = value.getBytes("UTF-8");
                                    dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"" + f2448a);
                                    dataOutputStream.writeBytes(f2448a);
                                    dataOutputStream.write(bytes);
                                    dataOutputStream.writeBytes(f2448a);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (SocketException e11) {
                            i = i2;
                            str = str2;
                            dataOutputStream2 = dataOutputStream;
                            inputStream = null;
                        } catch (SocketTimeoutException e12) {
                            i = i2;
                            str = str2;
                        } catch (Exception e13) {
                            str = str2;
                            exc = e13;
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
                                dataOutputStream.writeBytes(b + c + f2448a);
                                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"" + f2448a);
                                dataOutputStream.writeBytes(f2448a);
                                dataOutputStream.write(value2);
                                dataOutputStream.writeBytes(f2448a);
                            }
                        }
                    }
                    dataOutputStream.writeBytes(b + c + b + f2448a);
                    dataOutputStream.flush();
                    bg.a("NetWork", "postMultiNetData", "Post data.zise = " + String.valueOf(dataOutputStream.size()));
                    dataOutputStream.close();
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
                                        } catch (Exception e14) {
                                        }
                                    }
                                    try {
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                    } catch (Exception e15) {
                                    }
                                    if (dataOutputStream != null) {
                                        try {
                                            dataOutputStream.close();
                                        } catch (Exception e16) {
                                        }
                                    }
                                    if (e != null) {
                                        handler2 = e;
                                    }
                                } else {
                                    inputStream3.close();
                                    this.j.disconnect();
                                    bg.a("NetWork", "postMultiNetData", "time = " + String.valueOf(new Date().getTime() - time) + LocaleUtil.MALAY);
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    bg.a("NetWork", "postMultiNetData", "Get data.zise = " + String.valueOf(byteArray.length));
                                    if (contentEncoding == null || !contentEncoding.contains("gzip")) {
                                        bArr = byteArray;
                                    } else {
                                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                        ah.b(byteArrayInputStream, byteArrayOutputStream2);
                                        bArr = byteArrayOutputStream2.toByteArray();
                                    }
                                    String str3 = new String(bArr, 0, bArr.length, E());
                                    try {
                                        d(str3);
                                        if (inputStream3 != null) {
                                            try {
                                                inputStream3.close();
                                            } catch (Exception e17) {
                                            }
                                        }
                                        try {
                                            if (this.j != null) {
                                                this.j.disconnect();
                                            }
                                        } catch (Exception e18) {
                                        }
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (Exception e19) {
                                            }
                                        }
                                        if (e != null) {
                                            e.removeMessages(0, this);
                                        }
                                        str2 = str3;
                                    } catch (SocketException e20) {
                                        dataOutputStream2 = dataOutputStream;
                                        str = str3;
                                        i = i2;
                                        inputStream = inputStream3;
                                        z = true;
                                        this.o.b = 0;
                                        this.o.d = this.i.getResources().getString(R.string.neterror);
                                        if (inputStream != null) {
                                        }
                                        if (this.j != null) {
                                        }
                                        if (dataOutputStream2 != null) {
                                        }
                                        if (e == null) {
                                        }
                                    } catch (SocketTimeoutException e21) {
                                        inputStream2 = inputStream3;
                                        str = str3;
                                        i = i2;
                                        this.o.b = 0;
                                        z = true;
                                        this.o.d = this.i.getResources().getString(R.string.neterror);
                                        if (inputStream2 != null) {
                                        }
                                        if (this.j != null) {
                                        }
                                        if (dataOutputStream != null) {
                                        }
                                        if (e == null) {
                                        }
                                    } catch (Exception e22) {
                                        exc = e22;
                                        inputStream2 = inputStream3;
                                        str = str3;
                                        i = i2;
                                        this.o.b = 0;
                                        z = false;
                                        this.o.d = this.i.getResources().getString(R.string.neterror);
                                        bg.b("NetWork", "postMultiNetData", "error = " + exc.getMessage());
                                        if (inputStream2 != null) {
                                        }
                                        if (this.j != null) {
                                        }
                                        if (dataOutputStream != null) {
                                        }
                                        if (e == null) {
                                        }
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream2 = inputStream3;
                                if (inputStream2 != null) {
                                }
                                if (this.j != null) {
                                }
                                if (dataOutputStream != null) {
                                }
                                if (e != null) {
                                }
                                throw th;
                            }
                        } catch (SocketException e23) {
                            i = i2;
                            str = str2;
                            dataOutputStream2 = dataOutputStream;
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
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e28) {
                                }
                            }
                            if (e != null) {
                                e.removeMessages(0, this);
                            }
                            z = z2;
                            str = str2;
                        } catch (SocketException e29) {
                            inputStream = null;
                            str = str2;
                            dataOutputStream2 = dataOutputStream;
                            z = true;
                            try {
                                this.o.b = 0;
                                this.o.d = this.i.getResources().getString(R.string.neterror);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e30) {
                                    }
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                } catch (Exception e31) {
                                }
                                if (dataOutputStream2 != null) {
                                    try {
                                        dataOutputStream2.close();
                                    } catch (Exception e32) {
                                    }
                                }
                                if (e == null) {
                                    handler = e;
                                    handler.removeMessages(0, this);
                                    i2 = i + 1;
                                    str2 = str;
                                    z2 = z;
                                } else {
                                    i2 = i + 1;
                                    str2 = str;
                                    z2 = z;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                dataOutputStream = dataOutputStream2;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e33) {
                                    }
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                } catch (Exception e34) {
                                }
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (Exception e35) {
                                    }
                                }
                                if (e != null) {
                                    e.removeMessages(0, this);
                                }
                                throw th;
                            }
                        } catch (SocketTimeoutException e36) {
                            str = str2;
                            this.o.b = 0;
                            z = true;
                            this.o.d = this.i.getResources().getString(R.string.neterror);
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e37) {
                                }
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e38) {
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e39) {
                                }
                            }
                            if (e == null) {
                                handler = e;
                                handler.removeMessages(0, this);
                                i2 = i + 1;
                                str2 = str;
                                z2 = z;
                            } else {
                                i2 = i + 1;
                                str2 = str;
                                z2 = z;
                            }
                        } catch (Exception e40) {
                            str = str2;
                            exc = e40;
                            this.o.b = 0;
                            z = false;
                            this.o.d = this.i.getResources().getString(R.string.neterror);
                            bg.b("NetWork", "postMultiNetData", "error = " + exc.getMessage());
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e41) {
                                }
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e42) {
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e43) {
                                }
                            }
                            if (e == null) {
                                handler = e;
                                handler.removeMessages(0, this);
                                i2 = i + 1;
                                str2 = str;
                                z2 = z;
                            } else {
                                i2 = i + 1;
                                str2 = str;
                                z2 = z;
                            }
                        }
                        i2 = i + 1;
                        str2 = str;
                        z2 = z;
                    } else {
                        if (0 != 0) {
                            try {
                                inputStream2.close();
                            } catch (Exception e44) {
                            }
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e45) {
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception e46) {
                            }
                        }
                        if (e != null) {
                            handler2 = e;
                        }
                    }
                }
            }
        }
        this.k = 0;
        return str2;
    }

    @Override // com.baidu.tieba.util.ai
    public boolean z() {
        return this.o.b == 200 || this.o.b == 206;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1223=9, 1225=7, 1226=7, 1230=7, 1231=7, 1235=7, 1236=7] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0374 A[Catch: Exception -> 0x03a7, TRY_LEAVE, TryCatch #8 {Exception -> 0x03a7, blocks: (B:154:0x036e, B:156:0x0374), top: B:208:0x036e }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x037d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x036b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.tieba.util.ai
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
                try {
                    this.j = a(new URL(this.o.f2478a));
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
        } catch (Exception e5) {
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
                } catch (Exception e6) {
                }
            }
            try {
                if (this.j != null) {
                    this.j.disconnect();
                }
            } catch (Exception e7) {
            }
            if (0 != 0) {
                fileOutputStream2.close();
            }
            return r2;
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
        } catch (FileNotFoundException e8) {
            fileOutputStream2 = fileOutputStream;
            inputStream = null;
        } catch (Exception e9) {
            e2 = e9;
        }
        if (z()) {
            if (this.j.getContentType().contains("text/vnd.wap.wml") && this.k < 1) {
                this.j.disconnect();
                this.k++;
                this.o.b = 0;
                r2 = a(str, handler, i);
                this.k = 0;
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e10) {
                    }
                }
                try {
                    if (this.j != null) {
                        this.j.disconnect();
                    }
                } catch (Exception e11) {
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return r2;
            }
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
                    fileOutputStream.close();
                }
                return r2;
            }
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
                            } catch (Exception e14) {
                                throw new FileNotFoundException();
                            }
                        }
                    }
                    try {
                        fileOutputStream.flush();
                        bg.a("NetWork", "downloadFile", "time = " + String.valueOf(new Date().getTime() - time) + LocaleUtil.MALAY);
                        if (intValue != -1) {
                            bg.a("NetWork", "downloadFile", "data.zise = " + String.valueOf(intValue));
                        }
                        r2 = ((long) i3) + length >= ((long) intValue);
                        this.k = 0;
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
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Exception e17) {
                        throw new FileNotFoundException();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream2 = inputStream3;
                    this.k = 0;
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
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e20) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e21) {
                inputStream = inputStream3;
                fileOutputStream2 = fileOutputStream;
                try {
                    this.o.b = -2;
                    this.o.d = this.i.getResources().getString(R.string.FileWriteError);
                    this.k = 0;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e22) {
                        }
                    }
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e23) {
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
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
            } catch (Exception e24) {
                inputStream2 = inputStream3;
                e2 = e24;
                this.o.b = 0;
                this.o.d = this.i.getResources().getString(R.string.neterror);
                bg.b("NetWork", "downloadFile", "error = " + e2.getMessage());
                this.k = 0;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception e25) {
                    }
                }
                try {
                    if (this.j != null) {
                        this.j.disconnect();
                    }
                } catch (Exception e26) {
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return r2;
            }
            return r2;
        }
        throw new SocketException();
        return r2;
    }

    @Override // com.baidu.tieba.util.ai
    public void a(Context context) {
        this.i = context;
    }

    @Override // com.baidu.tieba.util.ai
    public Context m() {
        return this.i;
    }

    @Override // com.baidu.tieba.util.ai
    public ArrayList<BasicNameValuePair> n() {
        return this.o.e;
    }

    @Override // com.baidu.tieba.util.ai
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

    @Override // com.baidu.tieba.util.ai
    public void a(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tieba.util.ai
    public void a(String str, byte[] bArr) {
        if (this.o.f == null) {
            this.o.f = new HashMap<>();
        }
        this.o.f.put(str, bArr);
    }

    @Override // com.baidu.tieba.util.ai
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

    @Override // com.baidu.tieba.util.ai
    public void d(boolean z) {
        this.o.h = z;
    }

    public void e(boolean z) {
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
                    bg.a("NetWorkCore", "NetworkStateInfo", "UNAVAIL");
                } catch (Exception e3) {
                    e2 = e3;
                }
            } else if (activeNetworkInfo.getType() == 1) {
                bg.a("NetWorkCore", "NetworkStateInfo", "WIFI");
                networkStateInfo = NetworkStateInfo.WIFI;
            } else {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        bg.a("NetWorkCore", "NetworkStateInfo", "TwoG");
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
                        bg.a("NetWorkCore", "NetworkStateInfo", "ThreeG");
                        networkStateInfo = NetworkStateInfo.ThreeG;
                        break;
                    default:
                        bg.a("NetWorkCore", "NetworkStateInfo-default", "TwoG");
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
            bg.b(getClass().getName(), "checkDNS", e2.toString());
        }
    }

    @Override // com.baidu.tieba.util.ai
    public void a(boolean z) {
        this.p = z;
    }

    @Override // com.baidu.tieba.util.ai
    public boolean a() {
        return this.j != null && "image/gif".equalsIgnoreCase(this.j.getHeaderField("Src-Content-Type"));
    }

    @Override // com.baidu.tieba.util.ai
    public void b(boolean z) {
        this.q = z;
    }

    @Override // com.baidu.tieba.util.ai
    public int b() {
        return this.s;
    }

    @Override // com.baidu.tieba.util.ai
    public void a(int i) {
        this.s = i;
    }

    @Override // com.baidu.tieba.util.ai
    public String c() {
        return this.r;
    }

    @Override // com.baidu.tieba.util.ai
    public void a(String str) {
        this.r = str;
    }
}
