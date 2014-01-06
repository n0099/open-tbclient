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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ErrorData;
import com.baidu.zeus.NotificationProxy;
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
import org.apache.http.message.BasicNameValuePair;
@Deprecated
/* loaded from: classes.dex */
public class NetWorkCore implements ai {
    private static String a = "\r\n";
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
    private bh o;
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

    public NetWorkCore(bh bhVar) {
        F();
        this.o = bhVar;
        this.i = TiebaApplication.g();
    }

    @Override // com.baidu.tieba.util.ai
    public long d() {
        return this.t;
    }

    @Override // com.baidu.tieba.util.ai
    public long e() {
        return this.n;
    }

    @Override // com.baidu.tieba.util.ai
    public long f() {
        return this.v;
    }

    @Override // com.baidu.tieba.util.ai
    public long g() {
        return this.u;
    }

    @Override // com.baidu.tieba.util.ai
    public long i() {
        return this.w;
    }

    @Override // com.baidu.tieba.util.ai
    public int h() {
        return this.x;
    }

    @Override // com.baidu.tieba.util.ai
    public String c() {
        if (this.o.a == null) {
            return null;
        }
        String str = com.baidu.tieba.data.h.a;
        if (this.o.a.startsWith(str)) {
            int indexOf = this.o.a.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.o.a.length();
            }
            return this.o.a.substring(str.length(), indexOf);
        }
        return this.o.a;
    }

    @Override // com.baidu.tieba.util.ai
    public long b() {
        return this.y;
    }

    private int a(NetworkStateInfo networkStateInfo) {
        switch (ax.a[networkStateInfo.ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                return 0;
        }
    }

    private void F() {
        this.j = null;
        this.i = null;
        this.k = 0;
        this.m = false;
        this.l = false;
        B();
    }

    @Override // com.baidu.tieba.util.ai
    public void c(boolean z) {
        this.o.j = z;
    }

    @Override // com.baidu.tieba.util.ai
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
                return SocialConstants.TRUE;
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public static void B() {
        synchronized (NetWorkCore.class) {
            if (!g) {
                g = true;
                C();
            }
        }
    }

    public static synchronized void C() {
        synchronized (NetWorkCore.class) {
            try {
                Cursor query = TiebaApplication.g().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    f = "Basic " + bm.b((string + ":" + string2).getBytes());
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
        e = new aw();
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
        this.o.a = str;
    }

    public String E() {
        return this.o.a;
    }

    @Override // com.baidu.tieba.util.ai
    public boolean o() {
        return this.o.b == 200 && this.o.c == 0;
    }

    @Override // com.baidu.tieba.util.ai
    public boolean p() {
        return this.o.b == 200;
    }

    @Override // com.baidu.tieba.util.ai
    public int j() {
        return this.o.c;
    }

    @Override // com.baidu.tieba.util.ai
    public int y() {
        return this.o.b;
    }

    @Override // com.baidu.tieba.util.ai
    public String q() {
        return this.o.d;
    }

    @Override // com.baidu.tieba.util.ai
    public void t() {
        this.o.d = "";
    }

    @Override // com.baidu.tieba.util.ai
    public void c(String str) {
        this.o.d = str;
    }

    @Override // com.baidu.tieba.util.ai
    public void r() {
        this.m = true;
        try {
            if (this.j != null) {
                this.j.disconnect();
                try {
                    int a2 = bd.a(E());
                    if (a2 > 0) {
                        bd.a().a(a2, 1);
                    }
                } catch (Exception e2) {
                    bo.a(e2.getMessage());
                }
            }
        } catch (Exception e3) {
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x00ce */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x0012 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.tieba.util.NetWorkCore$NetworkState] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v5 */
    private HttpURLConnection a(URL url) {
        Exception e2;
        String defaultHost;
        HttpURLConnection httpURLConnection = null;
        HttpURLConnection b2 = b(this.i);
        this.l = false;
        try {
            if (b2 == NetworkState.UNAVAIL) {
                return null;
            }
            try {
                if (b2 == NetworkState.MOBILE && (defaultHost = Proxy.getDefaultHost()) != null && defaultHost.length() > 0) {
                    if (e(defaultHost)) {
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
                        httpURLConnection2.setRequestProperty("X-Online-Host", url.getHost());
                        httpURLConnection2.setRequestProperty("User-Agent", "BaiduTieba for Android " + com.baidu.tieba.data.h.j());
                        if (!TextUtils.isEmpty(TiebaApplication.A())) {
                            httpURLConnection2.setRequestProperty("client_user_token", TiebaApplication.A());
                        }
                        httpURLConnection = httpURLConnection2;
                    } else {
                        HttpURLConnection httpURLConnection3 = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort())));
                        if (f != null) {
                            httpURLConnection3.setRequestProperty("Proxy-Authorization", f);
                        }
                        httpURLConnection3.setRequestProperty("User-Agent", "BaiduTieba for Android " + com.baidu.tieba.data.h.j());
                        if (!TextUtils.isEmpty(TiebaApplication.A())) {
                            httpURLConnection3.setRequestProperty("client_user_token", TiebaApplication.A());
                        }
                        httpURLConnection = httpURLConnection3;
                    }
                }
                if (httpURLConnection == null) {
                    try {
                        b2 = (HttpURLConnection) url.openConnection();
                    } catch (Exception e3) {
                        b2 = httpURLConnection;
                        e2 = e3;
                        bo.b(getClass().getName(), "getConnect", "error = " + e2.getMessage());
                        return b2;
                    }
                } else {
                    b2 = httpURLConnection;
                }
                if (this.o != null) {
                    if (!TextUtils.isEmpty(this.o.m)) {
                        b2.setRequestProperty("sid", this.o.m);
                    }
                    if (!TextUtils.isEmpty(this.o.n)) {
                        b2.setRequestProperty(com.baidu.loginshare.e.e, this.o.n);
                        return b2;
                    }
                    return b2;
                }
                return b2;
            } catch (Exception e4) {
                e2 = e4;
            }
        } catch (Exception e5) {
            b2 = null;
            e2 = e5;
        }
    }

    private boolean e(String str) {
        if (h.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, IGET, INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [781=12, 782=12, 783=12, 788=12, 789=12, 791=4] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:119:0x0398 -> B:287:0x010d). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:174:0x04bd -> B:294:0x023e). Please submit an issue!!! */
    @Override // com.baidu.tieba.util.ai
    public byte[] u() {
        String str;
        URL url;
        int i;
        int read;
        String headerField;
        byte[] bArr = null;
        try {
            int a2 = bd.a(this.o.a);
            if (a2 > 0) {
                bd.a().a(a2);
            }
        } catch (Exception e2) {
            bo.a(e2.getMessage());
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
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.o.e.size()) {
                        break;
                    }
                    if (i3 != 0) {
                        sb.append("&");
                    }
                    sb.append(this.o.e.get(i3).getName());
                    sb.append("=");
                    sb.append(bm.d(this.o.e.get(i3).getValue()));
                    i2 = i3 + 1;
                }
                str = sb.toString();
            }
            url = new URL(str);
            this.t = str.length();
            if (com.baidu.tieba.data.h.v()) {
                bo.e(getClass().getName(), "getNetData", str);
            }
            i = 0;
        } catch (Exception e3) {
            bo.b(getClass().getName(), "getNetData", e3.getMessage());
            this.o.l = String.valueOf(this.o.b) + e3.getClass() + e3.getMessage();
            bd.c(this.o.a);
        }
        while (!this.m && i < 5) {
            InputStream inputStream = null;
            try {
                try {
                    try {
                        this.j = a(url);
                    } catch (Throwable th) {
                        try {
                            bd.c(this.o.a);
                            if (0 != 0) {
                                inputStream.close();
                            }
                        } catch (Exception e4) {
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e5) {
                        }
                        throw th;
                    }
                } catch (SocketException e6) {
                    e = e6;
                } catch (SocketTimeoutException e7) {
                    e = e7;
                } catch (Exception e8) {
                    e = e8;
                }
            } catch (Exception e9) {
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
                    bd.c(this.o.a);
                    if (0 != 0) {
                        inputStream.close();
                    }
                } catch (Exception e10) {
                }
                if (this.j != null) {
                    this.j.disconnect();
                }
            } else {
                long time = new Date().getTime();
                this.u = new Date().getTime() - time;
                this.j.connect();
                this.v = (new Date().getTime() - time) - this.u;
                this.o.b = this.j.getResponseCode();
                if (this.o.b != 200) {
                    this.o.l = String.valueOf(this.o.b) + "|retryCount:" + i;
                    bi.a.incrementAndGet();
                    this.o.d = this.i.getResources().getString(R.string.neterror);
                    if (i == 0) {
                        bp.a(this);
                    }
                    try {
                        bd.c(this.o.a);
                        if (0 != 0) {
                            inputStream.close();
                        }
                    } catch (Exception e11) {
                    }
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e12) {
                    }
                } else if (!this.j.getContentType().contains("text/vnd.wap.wml")) {
                    String contentEncoding = this.j.getContentEncoding();
                    inputStream = this.j.getInputStream();
                    if (TiebaApplication.g().q() && (headerField = this.j.getHeaderField("Content-Length")) != null) {
                        try {
                            int parseInt = Integer.parseInt(headerField);
                            try {
                                if (parseInt > d) {
                                    bd.c(this.o.a);
                                    bArr = null;
                                    try {
                                        bd.c(this.o.a);
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (Exception e13) {
                                    }
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                } else {
                                    int i4 = parseInt * 10;
                                    if (i4 > 0) {
                                        if (com.baidu.adp.lib.h.e.a()) {
                                            com.baidu.adp.lib.h.e.d("pre-free memory for downloaded image:[" + this.o.a + "], size:" + i4);
                                        }
                                        if (!com.baidu.tbadk.imageManager.d.a().c(i4)) {
                                            com.baidu.adp.lib.h.e.d("Image download cacelled. out of memory. url:[" + this.o.a + "], size:" + i4);
                                            bd.c(this.o.a);
                                            bArr = null;
                                            try {
                                                bd.c(this.o.a);
                                                if (inputStream != null) {
                                                    inputStream.close();
                                                }
                                            } catch (Exception e14) {
                                            }
                                            if (this.j != null) {
                                                this.j.disconnect();
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e15) {
                            }
                        } catch (Throwable th2) {
                        }
                        return bArr;
                    }
                    byte[] bArr2 = new byte[NotificationProxy.MAX_URL_LENGTH];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                    int i5 = 0;
                    String headerField2 = this.j.getHeaderField("imgsrc");
                    boolean z = false;
                    if (headerField2 != null && headerField2.length() > 0) {
                        z = true;
                    }
                    if (this.o.h || z) {
                        byte[] bArr3 = new byte[23];
                        int read2 = inputStream.read(bArr3, 0, 23);
                        if (!new String(bArr3, 0, bArr3.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                            byteArrayOutputStream.write(bArr3, 0, read2);
                            i5 = 0 + read2;
                        }
                    }
                    if (a() && this.s == 1) {
                        this.s = 2;
                    }
                    int i6 = i5;
                    while (!this.m && i6 < d && (read = inputStream.read(bArr2)) != -1) {
                        byteArrayOutputStream.write(bArr2, 0, read);
                        i6 = read + i6;
                    }
                    if (this.m) {
                        try {
                            bd.c(this.o.a);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (Exception e16) {
                        }
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } else {
                        this.n = i6;
                        long time2 = new Date().getTime() - time;
                        this.w = (time2 - this.v) - this.u;
                        bo.a(getClass().getName(), "getNetData", "time = " + String.valueOf(time2) + "ms");
                        if (i6 < d) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                                bo.a(getClass().getName(), "getNetData", "data.zise = " + String.valueOf(i6));
                                if (contentEncoding == null || !contentEncoding.contains("gzip")) {
                                    bArr = byteArray;
                                } else {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                                    ah.b(byteArrayInputStream, byteArrayOutputStream2);
                                    bArr = byteArrayOutputStream2.toByteArray();
                                }
                            } catch (SocketException e17) {
                                bArr = byteArray;
                                e = e17;
                                this.o.l = String.valueOf(this.o.b) + "|retryCount:" + i + "|" + e.getClass() + "|" + e.getMessage();
                                this.o.b = -12;
                                bi.a.incrementAndGet();
                                this.o.d = this.i.getResources().getString(R.string.neterror);
                                if (i == 0) {
                                    bp.a(this);
                                }
                                try {
                                    bd.c(this.o.a);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (Exception e18) {
                                }
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                                i++;
                            } catch (SocketTimeoutException e19) {
                                bArr = byteArray;
                                e = e19;
                                bi.a.incrementAndGet();
                                this.o.l = String.valueOf(this.o.b) + "|retryCount:" + i + "|" + e.getClass() + "|" + e.getMessage();
                                this.o.b = -13;
                                this.o.d = this.i.getResources().getString(R.string.neterror);
                                if (i == 0) {
                                    bp.a(this);
                                }
                                try {
                                    bd.c(this.o.a);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (Exception e20) {
                                }
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                                i++;
                            } catch (Exception e21) {
                                bArr = byteArray;
                                e = e21;
                                this.o.l = String.valueOf(this.o.b) + "|retryCount:" + i + "|" + e.getClass() + "|" + e.getMessage();
                                this.o.b = -10;
                                this.o.d = this.i.getResources().getString(R.string.neterror);
                                bo.b(getClass().getName(), "getNetData", "error = " + e.getMessage());
                                bp.a(this);
                                try {
                                    bd.c(this.o.a);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (Exception e22) {
                                }
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                                this.k = 0;
                                return bArr;
                            }
                        } else {
                            this.o.b = -11;
                            this.o.d = this.i.getResources().getString(R.string.data_too_big);
                        }
                        this.x = i + 1;
                        this.y = time2;
                        bj bjVar = new bj();
                        bjVar.e = a(c(this.i));
                        bjVar.c = this.n;
                        bjVar.b = time2;
                        bjVar.d = i + 1;
                        bjVar.a = 2;
                        if (time2 > 5000) {
                            com.baidu.tieba.log.a.a(com.baidu.tieba.log.k.a(url.toString(), "" + time2, bjVar.c + " |DNS Time" + g() + "|ConnectTime" + f() + "|current ip" + UtilHelper.c(UtilHelper.d(url.toString())), "old network download OK, retryCount:" + bjVar.d, ""));
                        }
                        bi.a(bjVar);
                        bp.a(this);
                        try {
                            bd.c(this.o.a);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (Exception e23) {
                        }
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    }
                } else if (this.k < 1) {
                    this.j.disconnect();
                    this.k++;
                    this.o.b = 0;
                    i--;
                    try {
                        bd.c(this.o.a);
                        if (0 != 0) {
                            inputStream.close();
                        }
                    } catch (Exception e24) {
                    }
                    if (this.j != null) {
                        this.j.disconnect();
                    }
                } else {
                    try {
                        bd.c(this.o.a);
                        if (0 != 0) {
                            inputStream.close();
                        }
                    } catch (Exception e25) {
                    }
                    if (this.j != null) {
                        this.j.disconnect();
                    }
                }
                i++;
            }
        }
        this.k = 0;
        return bArr;
    }

    private String G() {
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
                bo.b("NetWork", "parseServerCode", "error = " + e2.getMessage());
                this.o.d = this.i.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tieba.util.ai
    public String v() {
        String str;
        Exception e2;
        byte[] u = u();
        if (this.o.b != 200) {
            return null;
        }
        try {
            str = new String(u, 0, u.length, G());
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        }
        try {
            d(str);
            return str;
        } catch (Exception e4) {
            e2 = e4;
            bo.b(getClass().getName(), "getNetString", "error = " + e2.getMessage());
            return str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1101=12, 1102=12, 1103=12, 1108=12, 1109=12, 1111=5] */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x02ba, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x02b0, code lost:
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x02b1, code lost:
        com.baidu.tieba.util.bd.c(r14.o.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x02b8, code lost:
        if (0 == 0) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:198:0x057c A[Catch: Exception -> 0x05c4, TRY_LEAVE, TryCatch #26 {Exception -> 0x05c4, blocks: (B:196:0x0573, B:198:0x057c), top: B:286:0x0573 }] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0583 A[Catch: Exception -> 0x05c2, TRY_LEAVE, TryCatch #28 {Exception -> 0x05c2, blocks: (B:199:0x057f, B:201:0x0583), top: B:290:0x057f }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x018c -> B:273:0x012a). Please submit an issue!!! */
    @Override // com.baidu.tieba.util.ai
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String s() {
        InputStream inputStream;
        Exception exc;
        InputStream inputStream2;
        SocketTimeoutException socketTimeoutException;
        InputStream inputStream3;
        SocketException socketException;
        URL url;
        int read;
        StringBuilder sb = new StringBuilder((int) NotificationProxy.MAX_URL_LENGTH);
        StringBuilder sb2 = new StringBuilder((int) NotificationProxy.MAX_URL_LENGTH);
        try {
            int a2 = bd.a(this.o.a);
            if (a2 > 0) {
                bd.a().a(a2);
            }
        } catch (Exception e2) {
            bo.a(e2.getMessage());
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
                sb.append(name + "=");
                sb.append(bm.d(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
            i = i2 + 1;
        }
        if (this.o.i) {
            sb2.append("tiebaclient!!!");
            String a3 = bm.a(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(a3);
        }
        String sb3 = sb.toString();
        this.t = sb3.length();
        if (com.baidu.tieba.data.h.v()) {
            bo.e(getClass().getName(), "postNetData", this.o.a + "?" + sb3);
        }
        int i3 = 0;
        boolean z = true;
        String str = null;
        while (true) {
            if (this.m || !z || i3 >= 5) {
                break;
            }
            InputStream inputStream4 = null;
            try {
                try {
                    url = new URL(this.o.a);
                    this.j = a(url);
                } catch (Throwable th) {
                    th = th;
                    try {
                        bd.c(this.o.a);
                        if (inputStream4 != null) {
                            inputStream4.close();
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
                inputStream3 = null;
                socketException = e5;
            } catch (SocketTimeoutException e6) {
                inputStream2 = null;
                socketTimeoutException = e6;
            } catch (Exception e7) {
                inputStream = null;
                exc = e7;
            }
            if (this.j == null) {
                this.o.d = this.i.getResources().getString(R.string.neterror);
                try {
                    bd.c(this.o.a);
                    if (0 != 0) {
                        inputStream4.close();
                    }
                } catch (Exception e8) {
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
                    try {
                        bd.c(this.o.a);
                        if (0 != 0) {
                            inputStream4.close();
                        }
                    } catch (Exception e9) {
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
                    bo.a("NetWork", "postNetData", "Post data.zise = " + String.valueOf(dataOutputStream.size()));
                    dataOutputStream.close();
                    this.o.b = this.j.getResponseCode();
                    if (this.o.b != 200) {
                        if (this.o.b != 202 && this.o.b != 201 && this.o.b != 205 && this.o.b != 304 && this.o.b != 305 && this.o.b != 408) {
                            if (this.o.b == 502 || this.o.b == 503 || this.o.b == 504) {
                                break;
                            }
                        } else {
                            this.o.l = String.valueOf(this.o.b) + "|retryCount:" + i3;
                            bi.a.incrementAndGet();
                            z = true;
                            this.o.d = this.i.getResources().getString(R.string.neterror);
                            if (i3 == 0) {
                                bp.a(this);
                            }
                            try {
                                bd.c(this.o.a);
                                if (0 != 0) {
                                    inputStream4.close();
                                }
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
                        InputStream inputStream5 = this.j.getInputStream();
                        try {
                            byte[] bArr = new byte[NotificationProxy.MAX_URL_LENGTH];
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                            int i4 = 0;
                            while (!this.m && (read = inputStream5.read(bArr)) != -1) {
                                byteArrayOutputStream.write(bArr, 0, read);
                                i4 += read;
                            }
                            inputStream5.close();
                            this.j.disconnect();
                            if (this.m) {
                                try {
                                    bd.c(this.o.a);
                                    if (inputStream5 != null) {
                                        inputStream5.close();
                                    }
                                } catch (Exception e12) {
                                }
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } else {
                                this.n = i4;
                                long time2 = new Date().getTime() - time;
                                this.w = (time2 - this.v) - this.u;
                                bo.a(getClass().getName(), "postNetData", "time = " + String.valueOf(time2) + "ms");
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                bo.a(getClass().getName(), "postNetData", "Get data.zise = " + String.valueOf(byteArray.length));
                                if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                                    ah.b(byteArrayInputStream, byteArrayOutputStream2);
                                    byteArray = byteArrayOutputStream2.toByteArray();
                                    bo.a(getClass().getName(), "postNetData", "After ungzip data.zise = " + String.valueOf(byteArray.length));
                                }
                                byte[] bArr2 = byteArray;
                                String str2 = new String(bArr2, 0, bArr2.length, G());
                                try {
                                    if (this.o.i && this.o.j) {
                                        d(str2);
                                    }
                                    this.x = i3 + 1;
                                    this.y = time2;
                                    bj bjVar = new bj();
                                    bjVar.e = a(c(this.i));
                                    bjVar.c = this.n;
                                    bjVar.b = time2;
                                    bjVar.d = i3 + 1;
                                    bjVar.a = 1;
                                    bi.a(bjVar);
                                    bp.a(this);
                                    try {
                                        bd.c(this.o.a);
                                        if (inputStream5 != null) {
                                            inputStream5.close();
                                        }
                                    } catch (Exception e13) {
                                    }
                                    try {
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                    } catch (Exception e14) {
                                    }
                                    str = str2;
                                } catch (SocketException e15) {
                                    inputStream3 = inputStream5;
                                    socketException = e15;
                                    str = str2;
                                    try {
                                        bi.a.incrementAndGet();
                                        this.o.b = -12;
                                        z = true;
                                        this.o.d = this.i.getResources().getString(R.string.neterror);
                                        bo.b(getClass().getName(), "postNetData", "SocketException " + socketException.getMessage());
                                        if (i3 == 0) {
                                            bp.a(this);
                                        }
                                        try {
                                            bd.c(this.o.a);
                                            if (inputStream3 != null) {
                                                inputStream3.close();
                                            }
                                        } catch (Exception e16) {
                                        }
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                        i3++;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        inputStream4 = inputStream3;
                                        bd.c(this.o.a);
                                        if (inputStream4 != null) {
                                        }
                                        if (this.j != null) {
                                        }
                                        throw th;
                                    }
                                } catch (SocketTimeoutException e17) {
                                    inputStream2 = inputStream5;
                                    socketTimeoutException = e17;
                                    str = str2;
                                    bi.a.incrementAndGet();
                                    this.o.b = -13;
                                    z = true;
                                    this.o.d = this.i.getResources().getString(R.string.neterror);
                                    bo.b(getClass().getName(), "postNetData", "SocketTimeoutException " + socketTimeoutException.getMessage());
                                    if (i3 == 0) {
                                        bp.a(this);
                                    }
                                    try {
                                        bd.c(this.o.a);
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                    } catch (Exception e18) {
                                    }
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                    i3++;
                                } catch (Exception e19) {
                                    inputStream = inputStream5;
                                    exc = e19;
                                    str = str2;
                                    this.o.b = -10;
                                    z = false;
                                    this.o.d = this.i.getResources().getString(R.string.neterror);
                                    bo.b(getClass().getName(), "postNetData", exc.getMessage());
                                    bp.a(this);
                                    try {
                                        bd.c(this.o.a);
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (Exception e20) {
                                    }
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                    i3++;
                                }
                            }
                        } catch (SocketException e21) {
                            inputStream3 = inputStream5;
                            socketException = e21;
                        } catch (SocketTimeoutException e22) {
                            inputStream2 = inputStream5;
                            socketTimeoutException = e22;
                        } catch (Exception e23) {
                            inputStream = inputStream5;
                            exc = e23;
                        }
                    } else if (this.k < 1) {
                        this.j.disconnect();
                        this.k++;
                        this.o.b = 0;
                        i3--;
                        try {
                            bd.c(this.o.a);
                            if (0 != 0) {
                                inputStream4.close();
                            }
                        } catch (Exception e24) {
                        }
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                        i3++;
                    } else {
                        try {
                            bd.c(this.o.a);
                            if (0 != 0) {
                                inputStream4.close();
                            }
                        } catch (Exception e25) {
                        }
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    }
                }
            }
        }
        this.k = 0;
        return str;
        this.k = 0;
        return str;
        try {
            if (this.j != null) {
                this.j.disconnect();
            }
        } catch (Exception e26) {
        }
        return str;
    }

    @Override // com.baidu.tieba.util.ai
    public int m() {
        return this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1309=11, 1310=11, 1312=11, 1315=11, 1316=11, 1321=11, 1322=11, 1324=11, 1326=11, 1327=11] */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
        r0.removeMessages(0, r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0327 A[Catch: all -> 0x0578, TRY_LEAVE, TryCatch #38 {all -> 0x0578, blocks: (B:44:0x00e4, B:46:0x00ea, B:48:0x00f4, B:50:0x00f8, B:52:0x0104, B:53:0x0108, B:73:0x01aa, B:75:0x01ae, B:77:0x01b4, B:78:0x01c0, B:80:0x01c6, B:105:0x02bb, B:82:0x01dd, B:84:0x022d, B:85:0x023c, B:87:0x024a, B:88:0x0250, B:90:0x0258, B:92:0x0294, B:122:0x0345, B:124:0x0354, B:126:0x0359, B:128:0x0366, B:183:0x0488, B:109:0x030d, B:111:0x0327, B:140:0x038c), top: B:362:0x00e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0333 A[Catch: Exception -> 0x056a, TRY_LEAVE, TryCatch #2 {Exception -> 0x056a, blocks: (B:114:0x032f, B:116:0x0333), top: B:316:0x032f }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04ca A[Catch: Exception -> 0x0567, TRY_LEAVE, TryCatch #7 {Exception -> 0x0567, blocks: (B:186:0x04c6, B:188:0x04ca), top: B:324:0x04c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x04e7 A[Catch: Exception -> 0x0570, TRY_LEAVE, TryCatch #0 {Exception -> 0x0570, blocks: (B:198:0x04e3, B:200:0x04e7), top: B:312:0x04e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x04d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:334:0x04c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:336:0x033a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0188 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:344:0x04ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:346:0x04e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:348:0x032c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0196 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:400:0x01a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:402:0x01a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:404:0x01a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0183 A[Catch: all -> 0x0573, TRY_LEAVE, TryCatch #35 {all -> 0x0573, blocks: (B:58:0x016a, B:60:0x0183), top: B:356:0x016a }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x018f A[Catch: Exception -> 0x056d, TRY_LEAVE, TryCatch #1 {Exception -> 0x056d, blocks: (B:63:0x018b, B:65:0x018f), top: B:314:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019d  */
    @Override // com.baidu.tieba.util.ai
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String w() {
        DataOutputStream dataOutputStream;
        Throwable th;
        Exception e2;
        int i;
        String str;
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
            if (this.m || !z2 || i2 >= 5) {
                break;
            }
            InputStream inputStream2 = null;
            DataOutputStream dataOutputStream3 = null;
            try {
                this.j = a(new URL(this.o.a));
            } catch (SocketException e3) {
                dataOutputStream2 = null;
                i = i2;
                str = str2;
                inputStream = null;
            } catch (SocketTimeoutException e4) {
                dataOutputStream = null;
                i = i2;
                str = str2;
            } catch (Exception e5) {
                e2 = e5;
                dataOutputStream = null;
                i = i2;
                str = str2;
            } catch (Throwable th2) {
                dataOutputStream = null;
                th = th2;
            }
            if (this.j == null) {
                this.o.d = this.i.getResources().getString(R.string.neterror);
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
                    try {
                        dataOutputStream3.close();
                    } catch (Exception e8) {
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
                        } catch (Exception e9) {
                        }
                    }
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e10) {
                    }
                    if (0 != 0) {
                        try {
                            dataOutputStream3.close();
                        } catch (Exception e11) {
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
                                    dataOutputStream.writeBytes(b + c + a);
                                    byte[] bytes = value.getBytes("UTF-8");
                                    dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"" + a);
                                    dataOutputStream.writeBytes(a);
                                    dataOutputStream.write(bytes);
                                    dataOutputStream.writeBytes(a);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (SocketException e12) {
                            dataOutputStream2 = dataOutputStream;
                            i = i2;
                            str = str2;
                            inputStream = null;
                        } catch (SocketTimeoutException e13) {
                            i = i2;
                            str = str2;
                        } catch (Exception e14) {
                            e2 = e14;
                            i = i2;
                            str = str2;
                        }
                    }
                    if (!this.m && this.o.f != null) {
                        for (Map.Entry<String, byte[]> entry : this.o.f.entrySet()) {
                            String key = entry.getKey();
                            byte[] value2 = entry.getValue();
                            if (this.m) {
                                break;
                            } else if (value2 != null) {
                                dataOutputStream.writeBytes(b + c + a);
                                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"" + a);
                                dataOutputStream.writeBytes(a);
                                dataOutputStream.write(value2);
                                dataOutputStream.writeBytes(a);
                            }
                        }
                    }
                    dataOutputStream.writeBytes(b + c + b + a);
                    dataOutputStream.flush();
                    bo.a("NetWork", "postMultiNetData", "Post data.zise = " + String.valueOf(dataOutputStream.size()));
                    dataOutputStream.close();
                    if (e != null) {
                        e.sendMessageDelayed(e.obtainMessage(0, this), 45000L);
                    }
                    this.o.b = this.j.getResponseCode();
                    if (e != null) {
                        e.removeMessages(0, this);
                    }
                    if (this.o.b != 200) {
                        this.o.l = String.valueOf(this.o.b) + "|retryCount:" + i2;
                        bi.a.incrementAndGet();
                        this.o.d = this.i.getResources().getString(R.string.neterror);
                        if (i2 == 0) {
                            bp.a(this);
                        }
                        if (0 != 0) {
                            try {
                                inputStream2.close();
                            } catch (Exception e15) {
                            }
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e16) {
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception e17) {
                            }
                        }
                        if (e != null) {
                            e.removeMessages(0, this);
                        }
                        z = true;
                        i = i2;
                        str = str2;
                    } else if (!this.j.getContentType().contains("text/vnd.wap.wml")) {
                        String contentEncoding = this.j.getContentEncoding();
                        InputStream inputStream3 = this.j.getInputStream();
                        try {
                            try {
                                byte[] bArr2 = new byte[NotificationProxy.MAX_URL_LENGTH];
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                                while (!this.m && (read = inputStream3.read(bArr2)) != -1) {
                                    byteArrayOutputStream.write(bArr2, 0, read);
                                }
                                if (this.m) {
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (Exception e18) {
                                        }
                                    }
                                    try {
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                    } catch (Exception e19) {
                                    }
                                    if (dataOutputStream != null) {
                                        try {
                                            dataOutputStream.close();
                                        } catch (Exception e20) {
                                        }
                                    }
                                    if (e != null) {
                                        handler2 = e;
                                    }
                                } else {
                                    inputStream3.close();
                                    this.j.disconnect();
                                    bo.a("NetWork", "postMultiNetData", "time = " + String.valueOf(new Date().getTime() - time) + "ms");
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    bo.a("NetWork", "postMultiNetData", "Get data.zise = " + String.valueOf(byteArray.length));
                                    if (contentEncoding == null || !contentEncoding.contains("gzip")) {
                                        bArr = byteArray;
                                    } else {
                                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                                        ah.b(byteArrayInputStream, byteArrayOutputStream2);
                                        bArr = byteArrayOutputStream2.toByteArray();
                                    }
                                    String str3 = new String(bArr, 0, bArr.length, G());
                                    try {
                                        d(str3);
                                        bp.a(this);
                                        if (inputStream3 != null) {
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
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (Exception e23) {
                                            }
                                        }
                                        if (e != null) {
                                            e.removeMessages(0, this);
                                        }
                                        str2 = str3;
                                    } catch (SocketException e24) {
                                        dataOutputStream2 = dataOutputStream;
                                        inputStream = inputStream3;
                                        int i4 = i2;
                                        str = str3;
                                        i = i4;
                                        z = true;
                                        this.o.b = -12;
                                        this.o.d = this.i.getResources().getString(R.string.neterror);
                                        if (i == 0) {
                                            bp.a(this);
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e25) {
                                            }
                                        }
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                        if (dataOutputStream2 != null) {
                                            try {
                                                dataOutputStream2.close();
                                            } catch (Exception e26) {
                                            }
                                        }
                                        if (e == null) {
                                            handler = e;
                                            handler.removeMessages(0, this);
                                            z2 = z;
                                            str2 = str;
                                            i2 = i + 1;
                                        } else {
                                            z2 = z;
                                            str2 = str;
                                            i2 = i + 1;
                                        }
                                    } catch (SocketTimeoutException e27) {
                                        inputStream2 = inputStream3;
                                        int i5 = i2;
                                        str = str3;
                                        i = i5;
                                        this.o.b = -13;
                                        z = true;
                                        this.o.d = this.i.getResources().getString(R.string.neterror);
                                        if (i == 0) {
                                            bp.a(this);
                                        }
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
                                        if (e == null) {
                                            handler = e;
                                            handler.removeMessages(0, this);
                                            z2 = z;
                                            str2 = str;
                                            i2 = i + 1;
                                        } else {
                                            z2 = z;
                                            str2 = str;
                                            i2 = i + 1;
                                        }
                                    } catch (Exception e30) {
                                        e2 = e30;
                                        inputStream2 = inputStream3;
                                        int i6 = i2;
                                        str = str3;
                                        i = i6;
                                        this.o.b = -10;
                                        z = false;
                                        this.o.d = this.i.getResources().getString(R.string.neterror);
                                        bo.b("NetWork", "postMultiNetData", "error = " + e2.getMessage());
                                        bp.a(this);
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Exception e31) {
                                            }
                                        }
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (Exception e32) {
                                            }
                                        }
                                        if (e == null) {
                                            handler = e;
                                            handler.removeMessages(0, this);
                                            z2 = z;
                                            str2 = str;
                                            i2 = i + 1;
                                        } else {
                                            z2 = z;
                                            str2 = str;
                                            i2 = i + 1;
                                        }
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream2 = inputStream3;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e33) {
                                    }
                                }
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (Exception e34) {
                                    }
                                }
                                if (e != null) {
                                    e.removeMessages(0, this);
                                }
                                throw th;
                            }
                        } catch (SocketException e35) {
                            dataOutputStream2 = dataOutputStream;
                            i = i2;
                            str = str2;
                            inputStream = inputStream3;
                        } catch (SocketTimeoutException e36) {
                            inputStream2 = inputStream3;
                            i = i2;
                            str = str2;
                        } catch (Exception e37) {
                            e2 = e37;
                            inputStream2 = inputStream3;
                            i = i2;
                            str = str2;
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
                                } catch (Exception e38) {
                                }
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e39) {
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e40) {
                                }
                            }
                            if (e != null) {
                                e.removeMessages(0, this);
                            }
                            z = z2;
                            str = str2;
                        } catch (SocketException e41) {
                            dataOutputStream2 = dataOutputStream;
                            str = str2;
                            inputStream = null;
                            z = true;
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
                                } catch (Exception e42) {
                                }
                                if (dataOutputStream2 != null) {
                                }
                                if (e == null) {
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                dataOutputStream = dataOutputStream2;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                }
                                try {
                                    if (this.j != null) {
                                    }
                                } catch (Exception e43) {
                                }
                                if (dataOutputStream != null) {
                                }
                                if (e != null) {
                                }
                                throw th;
                            }
                        } catch (SocketTimeoutException e44) {
                            str = str2;
                            this.o.b = -13;
                            z = true;
                            this.o.d = this.i.getResources().getString(R.string.neterror);
                            if (i == 0) {
                            }
                            if (inputStream2 != null) {
                            }
                            try {
                                if (this.j != null) {
                                }
                            } catch (Exception e45) {
                            }
                            if (dataOutputStream != null) {
                            }
                            if (e == null) {
                            }
                        } catch (Exception e46) {
                            e2 = e46;
                            str = str2;
                            this.o.b = -10;
                            z = false;
                            this.o.d = this.i.getResources().getString(R.string.neterror);
                            bo.b("NetWork", "postMultiNetData", "error = " + e2.getMessage());
                            bp.a(this);
                            if (inputStream2 != null) {
                            }
                            try {
                                if (this.j != null) {
                                }
                            } catch (Exception e47) {
                            }
                            if (dataOutputStream != null) {
                            }
                            if (e == null) {
                            }
                        }
                    } else {
                        if (0 != 0) {
                            try {
                                inputStream2.close();
                            } catch (Exception e48) {
                            }
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e49) {
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception e50) {
                            }
                        }
                        if (e != null) {
                            handler2 = e;
                        }
                    }
                    z2 = z;
                    str2 = str;
                    i2 = i + 1;
                }
            }
        }
        this.k = 0;
        return str2;
    }

    @Override // com.baidu.tieba.util.ai
    public boolean x() {
        return this.o.b == 200 || this.o.b == 206;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1482=10, 1484=8, 1485=8, 1490=8, 1491=8, 1496=8, 1497=8] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x039a A[Catch: Exception -> 0x03d3, TRY_LEAVE, TryCatch #15 {Exception -> 0x03d3, blocks: (B:160:0x0394, B:162:0x039a), top: B:234:0x0394 }] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0391 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.tieba.util.ai
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, Handler handler, int i, int i2, int i3) {
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
                    this.j = a(new URL(this.o.a));
                } catch (Exception e3) {
                }
            } catch (FileNotFoundException e4) {
                inputStream = null;
            } catch (Exception e5) {
                fileOutputStream = null;
                e2 = e5;
            } catch (Throwable th) {
                th = th;
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
            File g2 = aa.g(str);
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
            if (!x()) {
                this.o.d = this.i.getResources().getString(R.string.neterror);
                bp.a(this);
                r2 = false;
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
            } else if (this.j.getContentType().contains("text/vnd.wap.wml") && this.k < 1) {
                this.j.disconnect();
                this.k++;
                this.o.b = 0;
                r2 = a(str, handler, i, i2, i3);
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
            } else {
                this.k = 0;
                int i4 = 0;
                String headerField2 = this.j.getHeaderField("Content-Range");
                if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                    i4 = Integer.valueOf(headerField2.substring(indexOf + 1)).intValue();
                }
                int intValue = (i4 == 0 && this.o.b == 200 && (headerField = this.j.getHeaderField("Content-Length")) != null) ? Integer.valueOf(headerField).intValue() : i4;
                if (length >= intValue) {
                    r2 = true;
                    this.k = 0;
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (Exception e14) {
                        }
                    }
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e15) {
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return r2;
                }
                InputStream inputStream3 = this.j.getInputStream();
                try {
                    try {
                        byte[] bArr = new byte[NotificationProxy.MAX_URL_LENGTH];
                        int i5 = 0;
                        int i6 = intValue > 0 ? intValue / 50 : 0;
                        int i7 = 0;
                        if (handler != null && length > 0) {
                            handler.sendMessage(handler.obtainMessage(i, (int) length, intValue));
                        }
                        while (!this.m) {
                            int read = inputStream3.read(bArr);
                            if (read != -1) {
                                try {
                                    fileOutputStream.write(bArr, 0, read);
                                    i5 += read;
                                    i7 += read;
                                    if (handler != null && (i7 > i6 || i5 == intValue)) {
                                        i7 = 0;
                                        handler.sendMessage(handler.obtainMessage(i, (int) (i5 + length), intValue));
                                    }
                                } catch (Exception e16) {
                                    throw new FileNotFoundException();
                                }
                            }
                        }
                        try {
                            fileOutputStream.flush();
                            bo.a("NetWork", "downloadFile", "time = " + String.valueOf(new Date().getTime() - time) + "ms");
                            if (intValue != -1) {
                                bo.a("NetWork", "downloadFile", "data.zise = " + String.valueOf(intValue));
                            }
                            r2 = ((long) i5) + length >= ((long) intValue);
                            this.k = 0;
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
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Exception e19) {
                            throw new FileNotFoundException();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream2 = inputStream3;
                        this.k = 0;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e20) {
                            }
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e21) {
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e22) {
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e23) {
                    inputStream = inputStream3;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        bp.a(this);
                        this.o.b = -100;
                        this.o.d = this.i.getResources().getString(R.string.FileWriteError);
                        this.k = 0;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e24) {
                            }
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e25) {
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        return r2;
                    } catch (Throwable th3) {
                        th = th3;
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
                } catch (Exception e26) {
                    inputStream2 = inputStream3;
                    e2 = e26;
                    bp.a(this);
                    this.o.b = -10;
                    this.o.d = this.i.getResources().getString(R.string.neterror);
                    bo.b("NetWork", "downloadFile", "error = " + e2.getMessage());
                    this.k = 0;
                    if (inputStream2 != null) {
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
                        fileOutputStream.close();
                    }
                    return r2;
                }
                return r2;
            }
            return r2;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // com.baidu.tieba.util.ai
    public void a(Context context) {
        this.i = context;
    }

    @Override // com.baidu.tieba.util.ai
    public Context k() {
        return this.i;
    }

    @Override // com.baidu.tieba.util.ai
    public ArrayList<BasicNameValuePair> l() {
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
                    bo.a("NetWorkCore", "NetworkStateInfo", "UNAVAIL");
                } catch (Exception e3) {
                    e2 = e3;
                }
            } else if (activeNetworkInfo.getType() == 1) {
                bo.a("NetWorkCore", "NetworkStateInfo", "WIFI");
                networkStateInfo = NetworkStateInfo.WIFI;
            } else {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        bo.a("NetWorkCore", "NetworkStateInfo", "TwoG");
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
                        bo.a("NetWorkCore", "NetworkStateInfo", "ThreeG");
                        networkStateInfo = NetworkStateInfo.ThreeG;
                        break;
                    default:
                        bo.a("NetWorkCore", "NetworkStateInfo-default", "TwoG");
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
            bo.b(getClass().getName(), "checkDNS", e2.toString());
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
    public void a(int i) {
        this.s = i;
    }

    @Override // com.baidu.tieba.util.ai
    public void a(String str) {
        this.r = str;
    }

    @Override // com.baidu.tieba.util.ai
    public String z() {
        return this.o.l;
    }

    @Override // com.baidu.tieba.util.ai
    public String A() {
        if (this.o != null) {
            return this.o.m;
        }
        return null;
    }
}
