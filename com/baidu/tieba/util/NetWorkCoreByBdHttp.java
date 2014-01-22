package com.baidu.tieba.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.network.BdHttpCancelException;
import com.baidu.adp.lib.network.BdHttpErrorException;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ErrorData;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Timer;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class NetWorkCoreByBdHttp implements al {
    private static int c = 2097152;
    protected Context a;
    private bl d;
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
        MOBILE
    }

    public NetWorkCoreByBdHttp(bl blVar) {
        E();
        this.a = TiebaApplication.h();
        this.d = blVar;
        com.baidu.adp.lib.network.e.a().b("BaiduTieba for Android " + com.baidu.tieba.data.h.j());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    @Override // com.baidu.tieba.util.al
    public long e() {
        return this.j.a;
    }

    @Override // com.baidu.tieba.util.al
    public long f() {
        return this.j.b;
    }

    @Override // com.baidu.tieba.util.al
    public long g() {
        return this.j.c;
    }

    @Override // com.baidu.tieba.util.al
    public long j() {
        return this.j.d;
    }

    @Override // com.baidu.tieba.util.al
    public long h() {
        return this.j.g;
    }

    @Override // com.baidu.tieba.util.al
    public int i() {
        return this.j.e;
    }

    @Override // com.baidu.tieba.util.al
    public int n() {
        return this.j.b;
    }

    @Override // com.baidu.tieba.util.al
    public String d() {
        if (this.d.a == null) {
            return null;
        }
        String str = com.baidu.tieba.data.h.a;
        if (this.d.a.startsWith(str)) {
            int indexOf = this.d.a.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.d.a.length();
            }
            return this.d.a.substring(str.length(), indexOf);
        }
        return this.d.a;
    }

    @Override // com.baidu.tieba.util.al
    public long c() {
        return this.j.f;
    }

    private int a(UtilHelper.NetworkStateInfo networkStateInfo) {
        switch (be.a[networkStateInfo.ordinal()]) {
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

    private void E() {
        this.a = null;
    }

    @Override // com.baidu.tieba.util.al
    public void c(boolean z) {
        this.d.j = z;
    }

    @Override // com.baidu.tieba.util.al
    public String o() {
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

    @Override // com.baidu.tieba.util.al
    public void a(Boolean bool) {
        this.d.g = bool.booleanValue();
    }

    @Override // com.baidu.tieba.util.al
    public void b(String str) {
        this.d.a = str;
    }

    public String D() {
        return this.d.a;
    }

    @Override // com.baidu.tieba.util.al
    public boolean p() {
        return this.d.b == 200 && this.d.c == 0;
    }

    @Override // com.baidu.tieba.util.al
    public boolean q() {
        return this.d.b == 200;
    }

    @Override // com.baidu.tieba.util.al
    public int k() {
        return this.d.c;
    }

    @Override // com.baidu.tieba.util.al
    public int A() {
        return this.d.b;
    }

    @Override // com.baidu.tieba.util.al
    public String r() {
        return this.d.d;
    }

    @Override // com.baidu.tieba.util.al
    public void v() {
        this.d.d = "";
    }

    @Override // com.baidu.tieba.util.al
    public void c(String str) {
        this.d.d = str;
    }

    @Override // com.baidu.tieba.util.al
    public boolean t() {
        return this.b.c();
    }

    @Override // com.baidu.tieba.util.al
    public void s() {
        this.b.a();
        try {
            int a = bh.a(D());
            if (a > 0) {
                bh.a().a(a, 1);
            }
        } catch (Throwable th) {
            com.baidu.adp.lib.g.e.a(th.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [667=12] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x05e2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0121  */
    @Override // com.baidu.tieba.util.al
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] w() {
        com.baidu.adp.lib.network.f fVar;
        com.baidu.adp.lib.network.f fVar2;
        String str;
        String str2;
        String str3;
        boolean z = true;
        com.baidu.adp.lib.network.e.a().c(TiebaApplication.A());
        try {
            int a = bh.a(this.d.a);
            if (a > 0) {
                bh.a().a(a);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.a(e.getMessage());
        }
        try {
            try {
                if (this.d.e == null || this.d.e.size() <= 0 || this.e) {
                    str2 = this.d.a;
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
                        sb.append(bu.d(this.d.e.get(i).getValue()));
                    }
                    str2 = sb.toString();
                }
                if (com.baidu.tieba.data.h.u()) {
                    com.baidu.adp.lib.g.e.e(getClass().getName(), "getNetData", str2);
                }
                if ((!this.d.g || this.d.h) && !this.e) {
                    z = false;
                }
            } finally {
                bh.c(this.d.a);
            }
        } catch (BdHttpCancelException e2) {
            e = e2;
            fVar2 = null;
        } catch (BdHttpErrorException e3) {
            e = e3;
            fVar = null;
        } catch (Exception e4) {
            e = e4;
            fVar = null;
        } catch (OutOfMemoryError e5) {
            e = e5;
            fVar = null;
        } catch (SocketException e6) {
            e = e6;
            fVar = null;
        } catch (SocketTimeoutException e7) {
            e = e7;
            fVar = null;
        }
        if (this.b.c()) {
            throw new BdHttpCancelException();
        }
        long time = new Date().getTime();
        fVar = com.baidu.adp.lib.network.e.a().a(str2, z, 5, 100, new bc(this, str2, time), this.b, F());
        if (fVar != null) {
            try {
                if (fVar.c != null) {
                    this.j = fVar.c;
                }
            } catch (BdHttpCancelException e8) {
                e = e8;
                fVar2 = fVar;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j != null ? this.j.e : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.d.b = -14;
                bh.c(this.d.a);
                fVar = fVar2;
                if (fVar != null) {
                }
            } catch (BdHttpErrorException e9) {
                e = e9;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j != null ? this.j.e : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.d.b = e.getHttpResponseCode();
                by.a(this);
                str = this.d.a;
                bh.c(str);
                if (fVar != null) {
                }
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.d.d = this.a.getResources().getString(R.string.memoryerror);
                this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j == null ? -1 : this.j.e) + "|" + e.getClass() + "|" + e.getMessage();
                this.d.b = -15;
                com.baidu.adp.lib.g.e.b(getClass().getName(), "getNetData", " 内存溢出！error = " + e.getMessage());
                by.a(this);
                str = this.d.a;
                bh.c(str);
                if (fVar != null) {
                }
            } catch (SocketException e11) {
                e = e11;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j != null ? this.j.e : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.d.b = -12;
                by.a(this);
                str = this.d.a;
                bh.c(str);
                if (fVar != null) {
                }
            } catch (SocketTimeoutException e12) {
                e = e12;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j != null ? this.j.e : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.d.b = -13;
                by.a(this);
                str = this.d.a;
                bh.c(str);
                if (fVar != null) {
                }
            } catch (Exception e13) {
                e = e13;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j != null ? this.j.e : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.d.b = -10;
                com.baidu.adp.lib.g.e.b(getClass().getName(), "getNetData", "error = " + e.getMessage());
                by.a(this);
                str = this.d.a;
                bh.c(str);
                if (fVar != null) {
                }
            }
        }
        if (fVar == null) {
            bh.c(this.d.a);
            return null;
        }
        this.d.b = fVar.a;
        if (this.d.b != 200) {
            this.d.d = this.a.getResources().getString(R.string.neterror);
            this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j == null ? -1 : this.j.e);
            by.a(this);
            bh.c(this.d.a);
            return null;
        }
        if (TiebaApplication.h().q() && (str3 = fVar.b) != null) {
            try {
                int parseInt = Integer.parseInt(str3);
                if (parseInt > c) {
                    this.d.b = -11;
                    by.a(this);
                    bh.c(this.d.a);
                    return null;
                }
                int i2 = parseInt * 10;
                if (i2 > 0) {
                    if (com.baidu.adp.lib.g.e.a()) {
                        com.baidu.adp.lib.g.e.d("pre-free memory for downloaded image:[" + this.d.a + "], size:" + i2);
                    }
                    if (!com.baidu.tbadk.imageManager.d.a().c(i2)) {
                        com.baidu.adp.lib.g.e.d("Image download cacelled. out of memory. url:[" + this.d.a + "], size:" + i2);
                        this.d.b = -16;
                        by.a(this);
                        bh.c(this.d.a);
                        return null;
                    }
                }
            } catch (Throwable th) {
                com.baidu.adp.lib.g.e.e(NetWorkCoreByBdHttp.class.getName(), "getNetData", th.getMessage());
            }
        }
        long time2 = new Date().getTime() - time;
        bn bnVar = new bn();
        bnVar.e = a(UtilHelper.g(this.a));
        bnVar.c = this.j.b;
        bnVar.b = time2;
        bnVar.d = this.j.e;
        bnVar.a = 2;
        bm.a(bnVar);
        bm.a.set(this.j.e);
        if (time2 > 5000) {
            com.baidu.tieba.log.a.a(com.baidu.tieba.log.j.a(str2, "" + time2, bnVar.c + "", "download OK,|DNS Time" + h() + "|ConnectTime" + g() + "|current ip" + UtilHelper.c(UtilHelper.d(str2)) + " retryCount: " + bnVar.d, ""));
        }
        by.a(this);
        str = this.d.a;
        bh.c(str);
        if (fVar != null) {
            this.d.k = fVar.e;
            return fVar.d;
        }
        return null;
    }

    public void d(String str) {
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
                com.baidu.adp.lib.g.e.b("NetWork", "parseServerCode", "error = " + e.getMessage());
                this.d.d = this.a.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tieba.util.al
    public String x() {
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
                com.baidu.adp.lib.g.e.b(getClass().getName(), "getNetString", "error = " + e2.getMessage());
                return str;
            } catch (OutOfMemoryError e4) {
                e = e4;
                com.baidu.adp.lib.g.e.b(getClass().getName(), "getNetString", " 内存溢出！error = " + e.getMessage());
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [901=11] */
    @Override // com.baidu.tieba.util.al
    public String u() {
        Throwable th;
        String str;
        SocketTimeoutException e;
        SocketException e2;
        OutOfMemoryError e3;
        Exception e4;
        BdHttpErrorException e5;
        BdHttpCancelException e6;
        String str2;
        StringBuilder sb = new StringBuilder(1024);
        StringBuilder sb2 = new StringBuilder(1024);
        try {
            int a = bh.a(this.d.a);
            if (a > 0) {
                bh.a().a(a);
            }
        } catch (Exception e7) {
            com.baidu.adp.lib.g.e.a(e7.getMessage());
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
                sb.append(name + "=");
                sb.append(bu.d(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
            i = i2 + 1;
        }
        if (this.d.i) {
            sb2.append("tiebaclient!!!");
            String a2 = bu.a(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(a2);
        }
        String sb3 = sb.toString();
        if (com.baidu.tieba.data.h.u()) {
            com.baidu.adp.lib.g.e.e(getClass().getName(), "postNetData", this.d.a + "?" + sb3);
        }
        try {
            try {
            } finally {
                bh.c(this.d.a);
            }
        } catch (BdHttpCancelException e8) {
            e6 = e8;
            str = null;
        } catch (BdHttpErrorException e9) {
            e5 = e9;
            str = null;
        } catch (Exception e10) {
            e4 = e10;
            str = null;
        } catch (OutOfMemoryError e11) {
            e3 = e11;
            str = null;
        } catch (SocketException e12) {
            e2 = e12;
            str = null;
        } catch (SocketTimeoutException e13) {
            e = e13;
            str = null;
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
        if (this.b.c()) {
            bh.c(this.d.a);
            return null;
        }
        com.baidu.adp.lib.network.f a3 = com.baidu.adp.lib.network.e.a().a(this.d.a, sb3.getBytes(), this.d.g, 5, (com.baidu.adp.lib.network.d) null, this.b, F());
        if (a3 == null) {
            throw new BdHttpCancelException();
        }
        if (a3.c != null) {
            this.j = a3.c;
        }
        this.d.b = a3.a;
        if (this.d.b != 200) {
            this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j == null ? -1 : this.j.e);
            by.a(this);
            bh.c(this.d.a);
            return null;
        } else if (this.b.c()) {
            bh.c(this.d.a);
            return null;
        } else {
            com.baidu.adp.lib.g.e.a(getClass().getName(), "postNetData", "time = " + String.valueOf(this.j.f) + "ms");
            com.baidu.adp.lib.g.e.a(getClass().getName(), "postNetData", "Get data.zise = " + String.valueOf(this.j.b));
            str = new String(a3.d, "utf-8");
            try {
                if (this.d.i && this.d.j) {
                    d(str);
                }
                bn bnVar = new bn();
                bnVar.e = a(UtilHelper.g(this.a));
                bnVar.c = this.j.b;
                bnVar.b = this.j.f;
                bnVar.d = this.j.e;
                bnVar.a = 1;
                bm.a(bnVar);
                bm.a.set(this.j.e);
                by.a(this);
                str2 = this.d.a;
            } catch (BdHttpCancelException e14) {
                e6 = e14;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j != null ? this.j.e : -1) + "|" + e6.getClass() + "|" + e6.getMessage();
                this.d.b = -14;
                str2 = this.d.a;
                bh.c(str2);
                return str;
            } catch (BdHttpErrorException e15) {
                e5 = e15;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j == null ? -1 : this.j.e) + "|" + e5.getClass() + "|" + e5.getMessage();
                this.d.b = e5.getHttpResponseCode();
                by.a(this);
                str2 = this.d.a;
                bh.c(str2);
                return str;
            } catch (SocketException e16) {
                e2 = e16;
                this.d.b = -12;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                com.baidu.adp.lib.g.e.b(getClass().getName(), "postNetData", "SocketException " + e2.getMessage());
                by.a(this);
                str2 = this.d.a;
                bh.c(str2);
                return str;
            } catch (SocketTimeoutException e17) {
                e = e17;
                this.d.b = -13;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                com.baidu.adp.lib.g.e.b(getClass().getName(), "postNetData", "SocketTimeoutException " + e.getMessage());
                by.a(this);
                str2 = this.d.a;
                bh.c(str2);
                return str;
            } catch (Exception e18) {
                e4 = e18;
                this.d.b = -10;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                com.baidu.adp.lib.g.e.b(getClass().getName(), "postNetData", e4.getMessage());
                by.a(this);
                str2 = this.d.a;
                bh.c(str2);
                return str;
            } catch (OutOfMemoryError e19) {
                e3 = e19;
                this.d.b = -15;
                this.d.d = this.a.getResources().getString(R.string.memoryerror);
                com.baidu.adp.lib.g.e.b(getClass().getName(), "postNetData", " 内存溢出！error = " + e3.getMessage());
                by.a(this);
                str2 = this.d.a;
                bh.c(str2);
                return str;
            } catch (Throwable th3) {
                th = th3;
                this.d.b = -10;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                com.baidu.adp.lib.g.e.b(getClass().getName(), "postNetData", th.getMessage());
                by.a(this);
                str2 = this.d.a;
                bh.c(str2);
                return str;
            }
            bh.c(str2);
            return str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1006=8] */
    @Override // com.baidu.tieba.util.al
    public String y() {
        OutOfMemoryError e;
        String str;
        Exception e2;
        BdHttpErrorException e3;
        BdHttpCancelException e4;
        Timer timer;
        bf bfVar;
        try {
            try {
            } finally {
                new Timer().schedule(new bf(this, null), 0L);
            }
        } catch (BdHttpCancelException e5) {
            e4 = e5;
            str = null;
        } catch (BdHttpErrorException e6) {
            e3 = e6;
            str = null;
        } catch (SocketException e7) {
            str = null;
        } catch (SocketTimeoutException e8) {
            str = null;
        } catch (Exception e9) {
            e2 = e9;
            str = null;
        } catch (OutOfMemoryError e10) {
            e = e10;
            str = null;
        }
        if (this.b.c()) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.f a = com.baidu.adp.lib.network.e.a().a(this.d.a, this.d.g, this.d.e, this.d.f, 5, null, this.b, null, F());
        this.d.b = a.a;
        new Timer().schedule(new bf(this, null), 45000L);
        if (this.d.b != 200) {
            this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j == null ? -1 : this.j.e);
            by.a(this);
            return null;
        } else if (this.b.c()) {
            throw new BdHttpCancelException();
        } else {
            str = new String(a.d, a.e);
            try {
                d(str);
                by.a(this);
                timer = new Timer();
                bfVar = new bf(this, null);
            } catch (BdHttpCancelException e11) {
                e4 = e11;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j != null ? this.j.e : -1) + "|" + e4.getClass() + "|" + e4.getMessage();
                this.d.b = -14;
                timer = new Timer();
                bfVar = new bf(this, null);
                timer.schedule(bfVar, 0L);
                return str;
            } catch (BdHttpErrorException e12) {
                e3 = e12;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j == null ? -1 : this.j.e) + "|" + e3.getClass() + "|" + e3.getMessage();
                this.d.b = e3.getHttpResponseCode();
                by.a(this);
                timer = new Timer();
                bfVar = new bf(this, null);
                timer.schedule(bfVar, 0L);
                return str;
            } catch (Exception e13) {
                e2 = e13;
                this.d.b = -10;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                com.baidu.adp.lib.g.e.b("NetWork", "postMultiNetData", "error = " + e2.getMessage());
                by.a(this);
                timer = new Timer();
                bfVar = new bf(this, null);
                timer.schedule(bfVar, 0L);
                return str;
            } catch (OutOfMemoryError e14) {
                e = e14;
                this.d.b = -15;
                this.d.d = this.a.getResources().getString(R.string.memoryerror);
                com.baidu.adp.lib.g.e.b(getClass().getName(), "postMultiNetData", " 内存溢出！error = " + e.getMessage());
                by.a(this);
                timer = new Timer();
                bfVar = new bf(this, null);
                timer.schedule(bfVar, 0L);
                return str;
            } catch (SocketException e15) {
                this.d.b = -12;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                by.a(this);
                timer = new Timer();
                bfVar = new bf(this, null);
                timer.schedule(bfVar, 0L);
                return str;
            } catch (SocketTimeoutException e16) {
                this.d.b = -13;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                by.a(this);
                timer = new Timer();
                bfVar = new bf(this, null);
                timer.schedule(bfVar, 0L);
                return str;
            }
            timer.schedule(bfVar, 0L);
            return str;
        }
    }

    @Override // com.baidu.tieba.util.al
    public boolean z() {
        return this.d.b == 200 || this.d.b == 206;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1091=5] */
    @Override // com.baidu.tieba.util.al
    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        boolean z;
        try {
            try {
                try {
                } catch (OutOfMemoryError e) {
                    this.d.b = -15;
                    this.d.d = this.a.getResources().getString(R.string.memoryerror);
                    com.baidu.adp.lib.g.e.b(getClass().getName(), "downloadFile", "error = " + e.getMessage());
                    by.a(this);
                    z = false;
                }
            } catch (Exception e2) {
                this.d.b = -10;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                com.baidu.adp.lib.g.e.b("NetWork", "downloadFile", "error = " + e2.getMessage());
                by.a(this);
                z = false;
            }
            if (this.b.c()) {
                return false;
            }
            z = com.baidu.adp.lib.network.e.a().a(this.d.a, ad.g(str).getAbsolutePath(), false, i2, i3, new bd(this, handler, i), this.b, F());
            return z;
        } finally {
            by.a(this);
        }
    }

    @Override // com.baidu.tieba.util.al
    public void a(Context context) {
        this.a = context;
    }

    @Override // com.baidu.tieba.util.al
    public Context l() {
        return this.a;
    }

    @Override // com.baidu.tieba.util.al
    public ArrayList<BasicNameValuePair> m() {
        return this.d.e;
    }

    @Override // com.baidu.tieba.util.al
    public void a(ArrayList<BasicNameValuePair> arrayList) {
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

    @Override // com.baidu.tieba.util.al
    public void a(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tieba.util.al
    public void a(String str, byte[] bArr) {
        if (this.d.f == null) {
            this.d.f = new HashMap<>();
        }
        this.d.f.put(str, bArr);
    }

    @Override // com.baidu.tieba.util.al
    public void a(BasicNameValuePair basicNameValuePair) {
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

    @Override // com.baidu.tieba.util.al
    public void d(boolean z) {
        this.d.h = z;
    }

    @Override // com.baidu.tieba.util.al
    public void e(boolean z) {
        this.d.i = z;
    }

    @Override // com.baidu.tieba.util.al
    public void a(boolean z) {
        this.e = z;
    }

    @Override // com.baidu.tieba.util.al
    public boolean a() {
        return this.f;
    }

    @Override // com.baidu.tieba.util.al
    public boolean b() {
        return this.h;
    }

    @Override // com.baidu.tieba.util.al
    public void b(boolean z) {
        this.h = z;
    }

    @Override // com.baidu.tieba.util.al
    public void a(int i) {
        this.i = i;
    }

    @Override // com.baidu.tieba.util.al
    public void a(String str) {
        this.g = str;
    }

    @Override // com.baidu.tieba.util.al
    public String B() {
        return this.d.l;
    }

    private LinkedList<BasicNameValuePair> F() {
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

    @Override // com.baidu.tieba.util.al
    public String C() {
        if (this.d != null) {
            return this.d.m;
        }
        return null;
    }
}
