package com.baidu.tieba.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.network.BdHttpCancelException;
import com.baidu.adp.lib.network.BdHttpErrorException;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ErrorData;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Timer;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class NetWorkCoreByBdHttp implements an {
    private static int c = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private static /* synthetic */ int[] k;
    protected Context a;
    private final bj d;
    protected final com.baidu.adp.lib.network.a b = new com.baidu.adp.lib.network.a();
    private boolean e = false;
    private boolean f = false;
    private String g = "other";
    private boolean h = false;
    private int i = 0;
    private com.baidu.adp.lib.network.h j = new com.baidu.adp.lib.network.h();

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

    private static /* synthetic */ int[] E() {
        int[] iArr = k;
        if (iArr == null) {
            iArr = new int[UtilHelper.NetworkStateInfo.valuesCustom().length];
            try {
                iArr[UtilHelper.NetworkStateInfo.ThreeG.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[UtilHelper.NetworkStateInfo.TwoG.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[UtilHelper.NetworkStateInfo.UNAVAIL.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[UtilHelper.NetworkStateInfo.WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            k = iArr;
        }
        return iArr;
    }

    public NetWorkCoreByBdHttp(bj bjVar) {
        this.a = null;
        this.a = TiebaApplication.g().b();
        this.d = bjVar;
        com.baidu.adp.lib.network.e.a();
        com.baidu.adp.lib.network.b.c = "BaiduTieba for Android " + com.baidu.tieba.data.i.u();
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    @Override // com.baidu.tieba.util.an
    public final long e() {
        return this.j.a;
    }

    @Override // com.baidu.tieba.util.an
    public final long f() {
        return this.j.b;
    }

    @Override // com.baidu.tieba.util.an
    public final long g() {
        return this.j.c;
    }

    @Override // com.baidu.tieba.util.an
    public final long j() {
        return this.j.d;
    }

    @Override // com.baidu.tieba.util.an
    public final long h() {
        return this.j.g;
    }

    @Override // com.baidu.tieba.util.an
    public final int i() {
        return this.j.e;
    }

    @Override // com.baidu.tieba.util.an
    public final int n() {
        return this.j.b;
    }

    @Override // com.baidu.tieba.util.an
    public final String d() {
        if (this.d.a == null) {
            return null;
        }
        String str = com.baidu.tieba.data.i.a;
        if (this.d.a.startsWith(str)) {
            int indexOf = this.d.a.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.d.a.length();
            }
            return this.d.a.substring(str.length(), indexOf);
        }
        return this.d.a;
    }

    @Override // com.baidu.tieba.util.an
    public final long c() {
        return this.j.f;
    }

    private static int a(UtilHelper.NetworkStateInfo networkStateInfo) {
        switch (E()[networkStateInfo.ordinal()]) {
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

    @Override // com.baidu.tieba.util.an
    public final void c(boolean z) {
        this.d.j = z;
    }

    @Override // com.baidu.tieba.util.an
    public final String o() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.a.getSystemService("connectivity")).getActiveNetworkInfo();
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
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.tieba.util.an
    public final void a(Boolean bool) {
        this.d.g = bool.booleanValue();
    }

    @Override // com.baidu.tieba.util.an
    public final void b(String str) {
        this.d.a = str;
    }

    @Override // com.baidu.tieba.util.an
    public final boolean p() {
        return this.d.b == 200 && this.d.c == 0;
    }

    @Override // com.baidu.tieba.util.an
    public final boolean q() {
        return this.d.b == 200;
    }

    @Override // com.baidu.tieba.util.an
    public final int k() {
        return this.d.c;
    }

    @Override // com.baidu.tieba.util.an
    public final int A() {
        return this.d.b;
    }

    @Override // com.baidu.tieba.util.an
    public final String r() {
        return this.d.d;
    }

    @Override // com.baidu.tieba.util.an
    public final void v() {
        this.d.d = "";
    }

    @Override // com.baidu.tieba.util.an
    public final void c(String str) {
        this.d.d = str;
    }

    @Override // com.baidu.tieba.util.an
    public final boolean t() {
        return this.b.c();
    }

    @Override // com.baidu.tieba.util.an
    public final void s() {
        this.b.a();
        try {
            int a = bg.a(this.d.a);
            if (a > 0) {
                bg.a().a(a, 1);
            }
        } catch (Throwable th) {
            com.baidu.adp.lib.util.e.b(th.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [690=12] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v61 long)] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x05d2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f7  */
    @Override // com.baidu.tieba.util.an
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] w() {
        com.baidu.adp.lib.network.f fVar;
        com.baidu.adp.lib.network.f fVar2;
        String str;
        boolean z;
        String str2;
        com.baidu.adp.lib.network.e.a();
        com.baidu.adp.lib.network.b.d = TiebaApplication.v();
        try {
            int a = bg.a(this.d.a);
            if (a > 0) {
                bg.a().a(a);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(e.getMessage());
        }
        try {
            try {
                if (this.d.e == null || this.d.e.size() <= 0 || this.e) {
                    str = this.d.a;
                } else {
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(this.d.a);
                    if (this.d.a.indexOf("?") < 0) {
                        sb.append("?");
                    } else if (!this.d.a.endsWith("?") && !this.d.a.endsWith("&")) {
                        sb.append("&");
                    }
                    for (int i = 0; i < this.d.e.size(); i++) {
                        if (i != 0) {
                            sb.append("&");
                        }
                        sb.append(this.d.e.get(i).getName());
                        sb.append("=");
                        sb.append(bs.d(this.d.e.get(i).getValue()));
                    }
                    str = sb.toString();
                }
                if (com.baidu.tieba.data.i.F()) {
                    com.baidu.adp.lib.util.e.e(getClass().getName(), "getNetData", str);
                }
                z = (this.d.g && !this.d.h) || this.e;
            } finally {
                bg.c(this.d.a);
            }
        } catch (BdHttpCancelException e2) {
            e = e2;
            fVar2 = null;
        } catch (BdHttpErrorException e3) {
            e = e3;
            fVar = null;
        } catch (OutOfMemoryError e4) {
            e = e4;
            fVar = null;
        } catch (SocketException e5) {
            e = e5;
            fVar = null;
        } catch (SocketTimeoutException e6) {
            e = e6;
            fVar = null;
        } catch (Exception e7) {
            e = e7;
            fVar = null;
        }
        if (this.b.c()) {
            throw new BdHttpCancelException();
        }
        long time = new Date().getTime();
        com.baidu.adp.lib.network.e.a();
        fVar = com.baidu.adp.lib.network.e.a(str, z, 5, 100, -1, new bc(this, str, time), this.b, D());
        if (fVar != null) {
            try {
                if (fVar.c != null) {
                    this.j = fVar.c;
                }
            } catch (BdHttpCancelException e8) {
                e = e8;
                fVar2 = fVar;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                this.d.l = String.valueOf(String.valueOf(this.d.b)) + "|retryCount:" + (this.j != null ? this.j.e : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.d.b = -14;
                bg.c(this.d.a);
                fVar = fVar2;
                if (fVar != null) {
                }
            } catch (BdHttpErrorException e9) {
                e = e9;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                this.d.l = String.valueOf(String.valueOf(this.d.b)) + "|retryCount:" + (this.j != null ? this.j.e : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.d.b = e.getHttpResponseCode();
                cb.a(this);
                if (fVar != null) {
                }
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.d.d = this.a.getResources().getString(R.string.memoryerror);
                this.d.l = String.valueOf(String.valueOf(this.d.b)) + "|retryCount:" + (this.j == null ? -1 : this.j.e) + "|" + e.getClass() + "|" + e.getMessage();
                this.d.b = -15;
                com.baidu.adp.lib.util.e.b(getClass().getName(), "getNetData", " 内存溢出！error = " + e.getMessage());
                cb.a(this);
                bg.c(this.d.a);
                if (fVar != null) {
                }
            } catch (SocketException e11) {
                e = e11;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                this.d.l = String.valueOf(String.valueOf(this.d.b)) + "|retryCount:" + (this.j != null ? this.j.e : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.d.b = -12;
                cb.a(this);
                bg.c(this.d.a);
                if (fVar != null) {
                }
            } catch (SocketTimeoutException e12) {
                e = e12;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                this.d.l = String.valueOf(String.valueOf(this.d.b)) + "|retryCount:" + (this.j != null ? this.j.e : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.d.b = -13;
                cb.a(this);
                bg.c(this.d.a);
                if (fVar != null) {
                }
            } catch (Exception e13) {
                e = e13;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                this.d.l = String.valueOf(String.valueOf(this.d.b)) + "|retryCount:" + (this.j != null ? this.j.e : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.d.b = -10;
                com.baidu.adp.lib.util.e.b(getClass().getName(), "getNetData", "error = " + e.getMessage());
                cb.a(this);
                bg.c(this.d.a);
                if (fVar != null) {
                }
            }
        }
        if (fVar == null) {
            bg.c(this.d.a);
            return null;
        }
        this.d.b = fVar.a;
        if (this.d.b != 200) {
            this.d.d = this.a.getResources().getString(R.string.neterror);
            this.d.l = String.valueOf(String.valueOf(this.d.b)) + "|retryCount:" + (this.j == null ? -1 : this.j.e);
            cb.a(this);
            bg.c(this.d.a);
            return null;
        }
        if (TiebaApplication.g().l() && (str2 = fVar.b) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > c) {
                    this.d.b = -11;
                    cb.a(this);
                    bg.c(this.d.a);
                    return null;
                }
                int i2 = parseInt * 10;
                if (i2 > 0) {
                    if (com.baidu.adp.lib.util.e.a()) {
                        com.baidu.adp.lib.util.e.e("pre-free memory for downloaded image:[" + this.d.a + "], size:" + i2);
                    }
                    if (!com.baidu.tbadk.imageManager.e.a().b(i2)) {
                        com.baidu.adp.lib.util.e.e("Image download cacelled. out of memory. url:[" + this.d.a + "], size:" + i2);
                        this.d.b = -16;
                        cb.a(this);
                        bg.c(this.d.a);
                        return null;
                    }
                }
            } catch (Throwable th) {
                com.baidu.adp.lib.util.e.e(NetWorkCoreByBdHttp.class.getName(), "getNetData", th.getMessage());
            }
        }
        long time2 = new Date().getTime() - time;
        bl blVar = new bl();
        blVar.e = a(UtilHelper.h(this.a));
        blVar.c = this.j.b;
        blVar.b = time2;
        blVar.d = this.j.e;
        blVar.a = 2;
        bk.a(blVar);
        bk.a.set(this.j.e);
        if (time2 > 5000) {
            com.baidu.tieba.log.a.a(com.baidu.tieba.log.j.a(str, new StringBuilder().append(time2).toString(), new StringBuilder(String.valueOf(blVar.c)).toString(), "download OK,|DNS Time" + this.j.g + "|ConnectTime" + this.j.c + "|current ip" + UtilHelper.b(UtilHelper.c(str)) + " retryCount: " + blVar.d, ""));
        }
        cb.a(this);
        if (fVar != null) {
            this.d.k = fVar.e;
            return fVar.d;
        }
        return null;
    }

    private void d(String str) {
        this.d.c = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.d.c = errorData.getError_code();
                if (this.d.c == -1) {
                    this.d.d = this.a.getString(R.string.error_unkown_try_again);
                } else if (this.d.c != 0) {
                    this.d.d = errorData.getError_msg();
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("NetWork", "parseServerCode", "error = " + e.getMessage());
                this.d.d = this.a.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tieba.util.an
    public final String x() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] w = w();
        if (w == null || this.d.b != 200) {
            return null;
        }
        try {
            this.d.k = TextUtils.isEmpty(this.d.k) ? "UTF-8" : this.d.k;
            str = new String(w, 0, w.length, this.d.k);
            try {
                d(str);
                return str;
            } catch (Exception e3) {
                e2 = e3;
                com.baidu.adp.lib.util.e.b(getClass().getName(), "getNetString", "error = " + e2.getMessage());
                return str;
            } catch (OutOfMemoryError e4) {
                e = e4;
                com.baidu.adp.lib.util.e.b(getClass().getName(), "getNetString", " 内存溢出！error = " + e.getMessage());
                return str;
            }
        } catch (Exception e5) {
            str = null;
            e2 = e5;
        } catch (OutOfMemoryError e6) {
            str = null;
            e = e6;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [926=12] */
    @Override // com.baidu.tieba.util.an
    public final String u() {
        Throwable th;
        String str;
        SocketTimeoutException e;
        SocketException e2;
        OutOfMemoryError e3;
        Exception e4;
        BdHttpErrorException e5;
        BdHttpCancelException e6;
        StringBuilder sb = new StringBuilder(1024);
        StringBuilder sb2 = new StringBuilder(1024);
        try {
            int a = bg.a(this.d.a);
            if (a > 0) {
                bg.a().a(a);
            }
        } catch (Exception e7) {
            com.baidu.adp.lib.util.e.b(e7.getMessage());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.d.e == null || i2 >= this.d.e.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.d.e.get(i2);
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
        if (this.d.i) {
            sb2.append("tiebaclient!!!");
            String a2 = bs.a(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(a2);
        }
        String sb3 = sb.toString();
        if (com.baidu.tieba.data.i.F()) {
            com.baidu.adp.lib.util.e.e(getClass().getName(), "postNetData", String.valueOf(this.d.a) + "?" + sb3);
        }
        try {
            try {
                if (this.b.c()) {
                    bg.c(this.d.a);
                    return null;
                }
                com.baidu.adp.lib.network.e.a();
                com.baidu.adp.lib.network.f a3 = com.baidu.adp.lib.network.e.a(this.d.a, sb3.getBytes(), this.d.g, 5, -1, (com.baidu.adp.lib.network.d) null, this.b, D());
                if (a3 == null) {
                    throw new BdHttpCancelException();
                }
                if (a3.c != null) {
                    this.j = a3.c;
                }
                this.d.b = a3.a;
                if (this.d.b != 200) {
                    this.d.l = String.valueOf(String.valueOf(this.d.b)) + "|retryCount:" + (this.j == null ? -1 : this.j.e);
                    cb.a(this);
                    bg.c(this.d.a);
                    return null;
                } else if (this.b.c()) {
                    bg.c(this.d.a);
                    return null;
                } else {
                    com.baidu.adp.lib.util.e.a(getClass().getName(), "postNetData", "time = " + String.valueOf(this.j.f) + "ms");
                    com.baidu.adp.lib.util.e.a(getClass().getName(), "postNetData", "Get data.zise = " + String.valueOf(this.j.b));
                    str = new String(a3.d, "utf-8");
                    try {
                        if (this.d.i && this.d.j) {
                            d(str);
                        }
                        bl blVar = new bl();
                        blVar.e = a(UtilHelper.h(this.a));
                        blVar.c = this.j.b;
                        blVar.b = this.j.f;
                        blVar.d = this.j.e;
                        blVar.a = 1;
                        bk.a(blVar);
                        bk.a.set(this.j.e);
                        cb.a(this);
                        return str;
                    } catch (BdHttpCancelException e8) {
                        e6 = e8;
                        this.d.d = this.a.getResources().getString(R.string.neterror);
                        this.d.l = String.valueOf(String.valueOf(this.d.b)) + "|retryCount:" + (this.j != null ? this.j.e : -1) + "|" + e6.getClass() + "|" + e6.getMessage();
                        this.d.b = -14;
                        return str;
                    } catch (BdHttpErrorException e9) {
                        e5 = e9;
                        this.d.d = this.a.getResources().getString(R.string.neterror);
                        this.d.l = String.valueOf(String.valueOf(this.d.b)) + "|retryCount:" + (this.j == null ? -1 : this.j.e) + "|" + e5.getClass() + "|" + e5.getMessage();
                        this.d.b = e5.getHttpResponseCode();
                        cb.a(this);
                        return str;
                    } catch (SocketTimeoutException e10) {
                        e = e10;
                        this.d.b = -13;
                        this.d.d = this.a.getResources().getString(R.string.neterror);
                        com.baidu.adp.lib.util.e.b(getClass().getName(), "postNetData", "SocketTimeoutException " + e.getMessage());
                        cb.a(this);
                        return str;
                    } catch (Exception e11) {
                        e4 = e11;
                        this.d.b = -10;
                        this.d.d = this.a.getResources().getString(R.string.neterror);
                        com.baidu.adp.lib.util.e.b(getClass().getName(), "postNetData", e4.getMessage());
                        cb.a(this);
                        return str;
                    } catch (OutOfMemoryError e12) {
                        e3 = e12;
                        this.d.b = -15;
                        this.d.d = this.a.getResources().getString(R.string.memoryerror);
                        com.baidu.adp.lib.util.e.b(getClass().getName(), "postNetData", " 内存溢出！error = " + e3.getMessage());
                        cb.a(this);
                        return str;
                    } catch (SocketException e13) {
                        e2 = e13;
                        this.d.b = -12;
                        this.d.d = this.a.getResources().getString(R.string.neterror);
                        com.baidu.adp.lib.util.e.b(getClass().getName(), "postNetData", "SocketException " + e2.getMessage());
                        cb.a(this);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        this.d.b = -10;
                        this.d.d = this.a.getResources().getString(R.string.neterror);
                        com.baidu.adp.lib.util.e.b(getClass().getName(), "postNetData", th.getMessage());
                        cb.a(this);
                        return str;
                    }
                }
            } finally {
                bg.c(this.d.a);
            }
        } catch (BdHttpCancelException e14) {
            e6 = e14;
            str = null;
        } catch (BdHttpErrorException e15) {
            e5 = e15;
            str = null;
        } catch (Exception e16) {
            e4 = e16;
            str = null;
        } catch (OutOfMemoryError e17) {
            e3 = e17;
            str = null;
        } catch (SocketException e18) {
            e2 = e18;
            str = null;
        } catch (SocketTimeoutException e19) {
            e = e19;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1032=9] */
    @Override // com.baidu.tieba.util.an
    public final String y() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        BdHttpErrorException e3;
        BdHttpCancelException e4;
        try {
            try {
                if (this.b.c()) {
                    throw new BdHttpCancelException();
                }
                com.baidu.adp.lib.network.e.a();
                com.baidu.adp.lib.network.f a = com.baidu.adp.lib.network.e.a(this.d.a, this.d.g, this.d.e, this.d.f, 5, -1, null, this.b, D());
                this.d.b = a.a;
                new Timer().schedule(new be(this, (byte) 0), 45000L);
                if (this.d.b != 200) {
                    this.d.l = String.valueOf(String.valueOf(this.d.b)) + "|retryCount:" + (this.j == null ? -1 : this.j.e);
                    cb.a(this);
                    return null;
                } else if (this.b.c()) {
                    throw new BdHttpCancelException();
                } else {
                    str = new String(a.d, a.e);
                    try {
                        d(str);
                        cb.a(this);
                        return str;
                    } catch (BdHttpCancelException e5) {
                        e4 = e5;
                        this.d.d = this.a.getResources().getString(R.string.neterror);
                        this.d.l = String.valueOf(String.valueOf(this.d.b)) + "|retryCount:" + (this.j != null ? this.j.e : -1) + "|" + e4.getClass() + "|" + e4.getMessage();
                        this.d.b = -14;
                        return str;
                    } catch (BdHttpErrorException e6) {
                        e3 = e6;
                        this.d.d = this.a.getResources().getString(R.string.neterror);
                        this.d.l = String.valueOf(String.valueOf(this.d.b)) + "|retryCount:" + (this.j == null ? -1 : this.j.e) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.d.b = e3.getHttpResponseCode();
                        cb.a(this);
                        return str;
                    } catch (OutOfMemoryError e7) {
                        e = e7;
                        this.d.b = -15;
                        this.d.d = this.a.getResources().getString(R.string.memoryerror);
                        com.baidu.adp.lib.util.e.b(getClass().getName(), "postMultiNetData", " 内存溢出！error = " + e.getMessage());
                        cb.a(this);
                        return str;
                    } catch (SocketException e8) {
                        this.d.b = -12;
                        this.d.d = this.a.getResources().getString(R.string.neterror);
                        cb.a(this);
                        return str;
                    } catch (SocketTimeoutException e9) {
                        this.d.b = -13;
                        this.d.d = this.a.getResources().getString(R.string.neterror);
                        cb.a(this);
                        return str;
                    } catch (Exception e10) {
                        e2 = e10;
                        this.d.b = -10;
                        this.d.d = this.a.getResources().getString(R.string.neterror);
                        com.baidu.adp.lib.util.e.b("NetWork", "postMultiNetData", "error = " + e2.getMessage());
                        cb.a(this);
                        return str;
                    }
                }
            } finally {
                new Timer().schedule(new be(this, (byte) 0), 0L);
            }
        } catch (BdHttpCancelException e11) {
            e4 = e11;
            str = null;
        } catch (BdHttpErrorException e12) {
            e3 = e12;
            str = null;
        } catch (Exception e13) {
            e2 = e13;
            str = null;
        } catch (OutOfMemoryError e14) {
            e = e14;
            str = null;
        } catch (SocketException e15) {
            str = null;
        } catch (SocketTimeoutException e16) {
            str = null;
        }
    }

    @Override // com.baidu.tieba.util.an
    public final boolean z() {
        return this.d.b == 200 || this.d.b == 206;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1119=5] */
    @Override // com.baidu.tieba.util.an
    public final boolean a(String str, Handler handler, int i, int i2, int i3) {
        boolean z;
        try {
            try {
            } catch (Exception e) {
                this.d.b = -10;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                com.baidu.adp.lib.util.e.b("NetWork", "downloadFile", "error = " + e.getMessage());
                cb.a(this);
                z = false;
            } catch (OutOfMemoryError e2) {
                this.d.b = -15;
                this.d.d = this.a.getResources().getString(R.string.memoryerror);
                com.baidu.adp.lib.util.e.b(getClass().getName(), "downloadFile", "error = " + e2.getMessage());
                cb.a(this);
                z = false;
            }
            if (this.b.c()) {
                return false;
            }
            File g = af.g(str);
            com.baidu.adp.lib.network.e.a();
            z = com.baidu.adp.lib.network.b.a(this.d.a, g.getAbsolutePath(), false, i2, i3, -1, (com.baidu.adp.lib.network.d) new bd(this, handler, i), this.b, D());
            return z;
        } finally {
            cb.a(this);
        }
    }

    @Override // com.baidu.tieba.util.an
    public final void a(Context context) {
        this.a = context;
    }

    @Override // com.baidu.tieba.util.an
    public final Context l() {
        return this.a;
    }

    @Override // com.baidu.tieba.util.an
    public final ArrayList<BasicNameValuePair> m() {
        return this.d.e;
    }

    @Override // com.baidu.tieba.util.an
    public final void a(ArrayList<BasicNameValuePair> arrayList) {
        if (this.d.e != null) {
            this.d.e.clear();
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
        if (this.d.f == null) {
            this.d.f = new HashMap<>();
        }
        this.d.f.put(str, bArr);
    }

    @Override // com.baidu.tieba.util.an
    public final void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.d.e == null) {
                this.d.e = new ArrayList<>();
            }
            int a = a(this.d.e, basicNameValuePair.getName());
            int size = this.d.e.size();
            if (a >= 0 && a < size) {
                if (basicNameValuePair.getName().equals(this.d.e.get(a).getName())) {
                    this.d.e.set(a, basicNameValuePair);
                } else {
                    this.d.e.add(a, basicNameValuePair);
                }
            } else if (a == size) {
                this.d.e.add(a, basicNameValuePair);
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
    public final void d(boolean z) {
        this.d.h = z;
    }

    @Override // com.baidu.tieba.util.an
    public final void e(boolean z) {
        this.d.i = false;
    }

    @Override // com.baidu.tieba.util.an
    public final void a(boolean z) {
        this.e = z;
    }

    @Override // com.baidu.tieba.util.an
    public final boolean a() {
        return this.f;
    }

    @Override // com.baidu.tieba.util.an
    public final boolean b() {
        return this.h;
    }

    @Override // com.baidu.tieba.util.an
    public final void b(boolean z) {
        this.h = true;
    }

    @Override // com.baidu.tieba.util.an
    public final void a(int i) {
        this.i = i;
    }

    @Override // com.baidu.tieba.util.an
    public final void a(String str) {
        this.g = str;
    }

    @Override // com.baidu.tieba.util.an
    public final String B() {
        return this.d.l;
    }

    private LinkedList<BasicNameValuePair> D() {
        if (this.d != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.d.m)) {
                linkedList.add(new BasicNameValuePair("sid", this.d.m));
            }
            if (!TextUtils.isEmpty(this.d.n)) {
                linkedList.add(new BasicNameValuePair(com.baidu.loginshare.e.e, this.d.n));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    @Override // com.baidu.tieba.util.an
    public final String C() {
        if (this.d != null) {
            return this.d.m;
        }
        return null;
    }
}
