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
import com.baidu.browser.core.util.BdUtil;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ErrorData;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.zeus.NotificationProxy;
import com.slidingmenu.lib.R;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Timer;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class NetWorkCoreByBdHttp implements ag {
    private static int c = 2097152;
    protected Context a;
    private ax d;
    protected final com.baidu.adp.lib.network.a b = new com.baidu.adp.lib.network.a();
    private boolean e = false;
    private boolean f = false;
    private String g = "other";
    private boolean h = false;
    private int i = 0;
    private com.baidu.adp.lib.network.f j = new com.baidu.adp.lib.network.f();

    /* loaded from: classes.dex */
    public enum NetworkState {
        UNAVAIL,
        WIFI,
        MOBILE
    }

    public NetWorkCoreByBdHttp(ax axVar) {
        B();
        this.a = TiebaApplication.h();
        this.d = axVar;
        com.baidu.adp.lib.network.d.a().b("BaiduTieba for Android " + com.baidu.tieba.data.h.j());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    @Override // com.baidu.tieba.util.ag
    public long d() {
        return this.j.a;
    }

    @Override // com.baidu.tieba.util.ag
    public long e() {
        return this.j.b;
    }

    @Override // com.baidu.tieba.util.ag
    public long f() {
        return this.j.c;
    }

    @Override // com.baidu.tieba.util.ag
    public long i() {
        return this.j.d;
    }

    @Override // com.baidu.tieba.util.ag
    public long g() {
        return this.j.g;
    }

    @Override // com.baidu.tieba.util.ag
    public int h() {
        return this.j.e;
    }

    @Override // com.baidu.tieba.util.ag
    public int m() {
        return this.j.b;
    }

    @Override // com.baidu.tieba.util.ag
    public String c() {
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

    @Override // com.baidu.tieba.util.ag
    public long b() {
        return this.j.f;
    }

    private int a(UtilHelper.NetworkStateInfo networkStateInfo) {
        switch (au.a[networkStateInfo.ordinal()]) {
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

    private void B() {
        this.a = null;
    }

    @Override // com.baidu.tieba.util.ag
    public void c(boolean z) {
        this.d.j = z;
    }

    @Override // com.baidu.tieba.util.ag
    public String n() {
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

    @Override // com.baidu.tieba.util.ag
    public void a(Boolean bool) {
        this.d.g = bool.booleanValue();
    }

    @Override // com.baidu.tieba.util.ag
    public void b(String str) {
        this.d.a = str;
    }

    @Override // com.baidu.tieba.util.ag
    public boolean o() {
        return this.d.b == 200 && this.d.c == 0;
    }

    @Override // com.baidu.tieba.util.ag
    public boolean p() {
        return this.d.b == 200;
    }

    @Override // com.baidu.tieba.util.ag
    public int j() {
        return this.d.c;
    }

    @Override // com.baidu.tieba.util.ag
    public int y() {
        return this.d.b;
    }

    @Override // com.baidu.tieba.util.ag
    public String q() {
        return this.d.d;
    }

    @Override // com.baidu.tieba.util.ag
    public void t() {
        this.d.d = "";
    }

    @Override // com.baidu.tieba.util.ag
    public void c(String str) {
        this.d.d = str;
    }

    @Override // com.baidu.tieba.util.ag
    public void r() {
        this.b.a();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [639=12, 640=12] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:166:0x05b9 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:168:0x05bc */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:170:0x05bf */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:172:0x05c2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:174:0x05c5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:184:0x0010 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:57:0x01ac */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:153:0x05a5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0106  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [com.baidu.adp.lib.network.e] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20, types: [com.baidu.adp.lib.network.e] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @Override // com.baidu.tieba.util.ag
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] u() {
        Object obj;
        String str;
        String str2;
        ?? r2 = 1;
        r2 = true;
        boolean z = true;
        com.baidu.adp.lib.network.d.a().c(TiebaApplication.B());
        InputStream inputStream = null;
        try {
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
                            sb.append(bc.d(this.d.e.get(i).getValue()));
                        }
                        str = sb.toString();
                    }
                    if (com.baidu.tieba.data.h.u()) {
                        be.e(getClass().getName(), "getNetData", str);
                    }
                    if ((!this.d.g || this.d.h) && !this.e) {
                        z = false;
                    }
                } catch (Exception e) {
                }
            } catch (BdHttpCancelException e2) {
                e = e2;
                obj = null;
            } catch (BdHttpErrorException e3) {
                e = e3;
                r2 = 0;
            } catch (OutOfMemoryError e4) {
                e = e4;
                r2 = 0;
            } catch (SocketException e5) {
                e = e5;
                r2 = 0;
            } catch (SocketTimeoutException e6) {
                e = e6;
                r2 = 0;
            } catch (Exception e7) {
                e = e7;
                r2 = 0;
            }
            if (this.b.c()) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            r2 = com.baidu.adp.lib.network.d.a().a(str, z, 5, new as(this, str, time), this.b, C());
            if (r2 != 0) {
                try {
                    if (r2.c != null) {
                        this.j = r2.c;
                    }
                } catch (BdHttpCancelException e8) {
                    e = e8;
                    obj = r2;
                    this.d.d = this.a.getResources().getString(R.string.neterror);
                    this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j != null ? this.j.e : -1) + "|" + e.getClass() + "|" + e.getMessage();
                    this.d.b = -14;
                    r2 = obj;
                    if (r2 != 0) {
                    }
                } catch (BdHttpErrorException e9) {
                    e = e9;
                    this.d.d = this.a.getResources().getString(R.string.neterror);
                    this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j != null ? this.j.e : -1) + "|" + e.getClass() + "|" + e.getMessage();
                    this.d.b = e.getHttpResponseCode();
                    bf.a(this);
                    if (0 != 0) {
                        inputStream.close();
                        r2 = r2;
                    }
                    if (r2 != 0) {
                    }
                } catch (Exception e10) {
                    e = e10;
                    this.d.d = this.a.getResources().getString(R.string.neterror);
                    this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j != null ? this.j.e : -1) + "|" + e.getClass() + "|" + e.getMessage();
                    this.d.b = -10;
                    be.b(getClass().getName(), "getNetData", "error = " + e.getMessage());
                    bf.a(this);
                    if (0 != 0) {
                        inputStream.close();
                        r2 = r2;
                    }
                    if (r2 != 0) {
                    }
                } catch (OutOfMemoryError e11) {
                    e = e11;
                    this.d.d = this.a.getResources().getString(R.string.memoryerror);
                    this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j == null ? -1 : this.j.e) + "|" + e.getClass() + "|" + e.getMessage();
                    this.d.b = -15;
                    be.b(getClass().getName(), "getNetData", " 内存溢出！error = " + e.getMessage());
                    bf.a(this);
                    if (0 != 0) {
                        inputStream.close();
                        r2 = r2;
                    }
                    if (r2 != 0) {
                    }
                } catch (SocketException e12) {
                    e = e12;
                    this.d.d = this.a.getResources().getString(R.string.neterror);
                    this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j != null ? this.j.e : -1) + "|" + e.getClass() + "|" + e.getMessage();
                    this.d.b = -12;
                    bf.a(this);
                    if (0 != 0) {
                        inputStream.close();
                        r2 = r2;
                    }
                    if (r2 != 0) {
                    }
                } catch (SocketTimeoutException e13) {
                    e = e13;
                    this.d.d = this.a.getResources().getString(R.string.neterror);
                    this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j != null ? this.j.e : -1) + "|" + e.getClass() + "|" + e.getMessage();
                    this.d.b = -13;
                    bf.a(this);
                    if (0 != 0) {
                        inputStream.close();
                        r2 = r2;
                    }
                    if (r2 != 0) {
                    }
                }
            }
            if (r2 == 0) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e14) {
                    }
                }
                return null;
            }
            this.d.b = r2.a;
            if (this.d.b != 200) {
                this.d.d = this.a.getResources().getString(R.string.neterror);
                this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j == null ? -1 : this.j.e);
                bf.a(this);
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e15) {
                    }
                }
                return null;
            }
            if (TiebaApplication.h().r() && (str2 = r2.b) != null) {
                try {
                    int parseInt = Integer.parseInt(str2);
                    if (parseInt > c) {
                        this.d.b = -11;
                        bf.a(this);
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (Exception e16) {
                            }
                        }
                        return null;
                    }
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.h.e.a()) {
                            com.baidu.adp.lib.h.e.d("pre-free memory for downloaded image:[" + this.d.a + "], size:" + i2);
                        }
                        if (!com.baidu.tbadk.imageManager.d.a().c(i2)) {
                            com.baidu.adp.lib.h.e.d("Image download cacelled. out of memory. url:[" + this.d.a + "], size:" + i2);
                            this.d.b = -16;
                            bf.a(this);
                            if (0 != 0) {
                                try {
                                    inputStream.close();
                                } catch (Exception e17) {
                                }
                            }
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    be.e(NetWorkCoreByBdHttp.class.getName(), "getNetData", th.getMessage());
                }
            }
            long time2 = new Date().getTime() - time;
            az azVar = new az();
            azVar.e = a(UtilHelper.g(this.a));
            azVar.c = this.j.b;
            azVar.b = time2;
            azVar.d = this.j.e;
            azVar.a = 2;
            ay.a(azVar);
            ay.a.set(this.j.e);
            if (time2 > 5000) {
                com.baidu.tieba.log.a.a(com.baidu.tieba.log.k.a(str, "" + time2, azVar.c + "", "download OK,|DNS Time" + g() + "|ConnectTime" + f() + "|current ip" + UtilHelper.c(UtilHelper.d(str)) + " retryCount: " + azVar.d, ""));
            }
            bf.a(this);
            if (0 != 0) {
                inputStream.close();
                r2 = r2;
            }
            if (r2 != 0) {
                this.d.k = r2.e;
                return r2.d;
            }
            return null;
        } finally {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (Exception e18) {
                }
            }
        }
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
                be.b("NetWork", "parseServerCode", "error = " + e.getMessage());
                this.d.d = this.a.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tieba.util.ag
    public String v() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] u = u();
        if (u == null || this.d.b != 200) {
            return null;
        }
        try {
            this.d.k = TextUtils.isEmpty(this.d.k) ? "UTF-8" : this.d.k;
            str = new String(u, 0, u.length, this.d.k);
            try {
                d(str);
                return str;
            } catch (Exception e3) {
                e2 = e3;
                be.b(getClass().getName(), "getNetString", "error = " + e2.getMessage());
                return str;
            } catch (OutOfMemoryError e4) {
                e = e4;
                be.b(getClass().getName(), "getNetString", " 内存溢出！error = " + e.getMessage());
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

    @Override // com.baidu.tieba.util.ag
    public String s() {
        Throwable th;
        String str;
        SocketTimeoutException e;
        SocketException e2;
        OutOfMemoryError e3;
        Exception e4;
        BdHttpErrorException e5;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        StringBuilder sb = new StringBuilder((int) NotificationProxy.MAX_URL_LENGTH);
        StringBuilder sb2 = new StringBuilder((int) NotificationProxy.MAX_URL_LENGTH);
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
                sb.append(bc.d(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
            i = i2 + 1;
        }
        if (this.d.i) {
            sb2.append("tiebaclient!!!");
            String a = bc.a(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(a);
        }
        String sb3 = sb.toString();
        if (com.baidu.tieba.data.h.u()) {
            be.e(getClass().getName(), "postNetData", this.d.a + "?" + sb3);
        }
        try {
            if (this.b.c()) {
                return null;
            }
            com.baidu.adp.lib.network.e a2 = com.baidu.adp.lib.network.d.a().a(this.d.a, sb3.getBytes(), this.d.g, 5, (com.baidu.adp.lib.network.c) null, this.b, C());
            if (a2 == null) {
                throw new BdHttpCancelException();
            }
            if (a2 != null && a2.c != null) {
                this.j = a2.c;
            }
            this.d.b = a2.a;
            if (this.d.b != 200) {
                this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j == null ? -1 : this.j.e);
                bf.a(this);
                return null;
            } else if (this.b.c()) {
                return null;
            } else {
                be.a(getClass().getName(), "postNetData", "time = " + String.valueOf(this.j.f) + "ms");
                be.a(getClass().getName(), "postNetData", "Get data.zise = " + String.valueOf(this.j.b));
                str = new String(a2.d, BdUtil.UTF8);
                try {
                    if (this.d.i && this.d.j) {
                        d(str);
                    }
                    az azVar = new az();
                    azVar.e = a(UtilHelper.g(this.a));
                    azVar.c = this.j.b;
                    azVar.b = this.j.f;
                    azVar.d = this.j.e;
                    azVar.a = 1;
                    ay.a(azVar);
                    ay.a.set(this.j.e);
                    bf.a(this);
                    return str;
                } catch (BdHttpCancelException e6) {
                    bdHttpCancelException = e6;
                    str2 = str;
                    this.d.d = this.a.getResources().getString(R.string.neterror);
                    this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j == null ? -1 : this.j.e) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.d.b = -14;
                    return str2;
                } catch (BdHttpErrorException e7) {
                    e5 = e7;
                    this.d.d = this.a.getResources().getString(R.string.neterror);
                    this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j != null ? this.j.e : -1) + "|" + e5.getClass() + "|" + e5.getMessage();
                    this.d.b = e5.getHttpResponseCode();
                    bf.a(this);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e3 = e8;
                    this.d.b = -15;
                    this.d.d = this.a.getResources().getString(R.string.memoryerror);
                    be.b(getClass().getName(), "postNetData", " 内存溢出！error = " + e3.getMessage());
                    bf.a(this);
                    return str;
                } catch (SocketException e9) {
                    e2 = e9;
                    this.d.b = -12;
                    this.d.d = this.a.getResources().getString(R.string.neterror);
                    be.b(getClass().getName(), "postNetData", "SocketException " + e2.getMessage());
                    bf.a(this);
                    return str;
                } catch (SocketTimeoutException e10) {
                    e = e10;
                    this.d.b = -13;
                    this.d.d = this.a.getResources().getString(R.string.neterror);
                    be.b(getClass().getName(), "postNetData", "SocketTimeoutException " + e.getMessage());
                    bf.a(this);
                    return str;
                } catch (Exception e11) {
                    e4 = e11;
                    this.d.b = -10;
                    this.d.d = this.a.getResources().getString(R.string.neterror);
                    be.b(getClass().getName(), "postNetData", e4.getMessage());
                    bf.a(this);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.d.b = -10;
                    this.d.d = this.a.getResources().getString(R.string.neterror);
                    be.b(getClass().getName(), "postNetData", th.getMessage());
                    bf.a(this);
                    return str;
                }
            }
        } catch (BdHttpCancelException e12) {
            bdHttpCancelException = e12;
            str2 = null;
        } catch (BdHttpErrorException e13) {
            e5 = e13;
            str = null;
        } catch (Exception e14) {
            e4 = e14;
            str = null;
        } catch (OutOfMemoryError e15) {
            e3 = e15;
            str = null;
        } catch (SocketException e16) {
            e2 = e16;
            str = null;
        } catch (SocketTimeoutException e17) {
            e = e17;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [973=9, 974=9, 978=9] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0252 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0205 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x017a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01ae A[Catch: all -> 0x02b5, TRY_ENTER, TryCatch #8 {all -> 0x02b5, blocks: (B:3:0x0002, B:5:0x000a, B:6:0x000f, B:18:0x0084, B:20:0x00c4, B:23:0x00e2, B:28:0x0102, B:29:0x0107, B:31:0x010f, B:32:0x0114, B:43:0x018c, B:44:0x0195, B:46:0x0199, B:72:0x0265, B:66:0x0218, B:60:0x01e9, B:54:0x01bb, B:35:0x0118, B:38:0x0147, B:51:0x01b4, B:9:0x0013, B:12:0x0042, B:50:0x01ae), top: B:128:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b4 A[Catch: all -> 0x02b5, TryCatch #8 {all -> 0x02b5, blocks: (B:3:0x0002, B:5:0x000a, B:6:0x000f, B:18:0x0084, B:20:0x00c4, B:23:0x00e2, B:28:0x0102, B:29:0x0107, B:31:0x010f, B:32:0x0114, B:43:0x018c, B:44:0x0195, B:46:0x0199, B:72:0x0265, B:66:0x0218, B:60:0x01e9, B:54:0x01bb, B:35:0x0118, B:38:0x0147, B:51:0x01b4, B:9:0x0013, B:12:0x0042, B:50:0x01ae), top: B:128:0x0002 }] */
    @Override // com.baidu.tieba.util.ag
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String w() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        BdHttpErrorException e3;
        BdHttpCancelException e4;
        Timer timer;
        av avVar;
        InputStream inputStream = null;
        try {
            try {
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e5) {
                    }
                }
                new Timer().schedule(new av(this, null), 0L);
                throw th;
            }
        } catch (BdHttpCancelException e6) {
            e4 = e6;
            str = null;
        } catch (BdHttpErrorException e7) {
            e3 = e7;
            str = null;
        } catch (SocketException e8) {
            str = null;
        } catch (Exception e9) {
            e2 = e9;
            str = null;
        } catch (OutOfMemoryError e10) {
            e = e10;
            str = null;
        } catch (SocketTimeoutException e11) {
            str = null;
        }
        if (this.b.c()) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.e a = com.baidu.adp.lib.network.d.a().a(this.d.a, this.d.g, this.d.e, this.d.f, 5, null, this.b, null, C());
        this.d.b = a.a;
        new Timer().schedule(new av(this, null), 45000L);
        if (this.d.b != 200) {
            this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j == null ? -1 : this.j.e);
            bf.a(this);
            str = null;
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (Exception e12) {
                }
            }
            timer = new Timer();
            avVar = new av(this, null);
        } else if (this.b.c()) {
            throw new BdHttpCancelException();
        } else {
            if (a != null) {
                String str2 = new String(a.d, a.e);
                try {
                    d(str2);
                    str = str2;
                } catch (BdHttpCancelException e13) {
                    str = str2;
                    e4 = e13;
                    this.d.d = this.a.getResources().getString(R.string.neterror);
                    this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j != null ? -1 : this.j.e) + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.d.b = -14;
                    if (0 != 0) {
                    }
                    timer = new Timer();
                    avVar = new av(this, null);
                    timer.schedule(avVar, 0L);
                    return str;
                } catch (BdHttpErrorException e14) {
                    str = str2;
                    e3 = e14;
                    this.d.d = this.a.getResources().getString(R.string.neterror);
                    this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j != null ? -1 : this.j.e) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.d.b = e3.getHttpResponseCode();
                    bf.a(this);
                    if (0 != 0) {
                    }
                    timer = new Timer();
                    avVar = new av(this, null);
                    timer.schedule(avVar, 0L);
                    return str;
                } catch (OutOfMemoryError e15) {
                    str = str2;
                    e = e15;
                    this.d.b = -15;
                    this.d.d = this.a.getResources().getString(R.string.memoryerror);
                    be.b(getClass().getName(), "postMultiNetData", " 内存溢出！error = " + e.getMessage());
                    bf.a(this);
                    if (0 != 0) {
                    }
                    timer = new Timer();
                    avVar = new av(this, null);
                    timer.schedule(avVar, 0L);
                    return str;
                } catch (SocketException e16) {
                    str = str2;
                    this.d.b = -12;
                    this.d.d = this.a.getResources().getString(R.string.neterror);
                    bf.a(this);
                    if (0 != 0) {
                    }
                    timer = new Timer();
                    avVar = new av(this, null);
                    timer.schedule(avVar, 0L);
                    return str;
                } catch (SocketTimeoutException e17) {
                    str = str2;
                    this.d.b = -13;
                    this.d.d = this.a.getResources().getString(R.string.neterror);
                    bf.a(this);
                    if (0 != 0) {
                    }
                    timer = new Timer();
                    avVar = new av(this, null);
                    timer.schedule(avVar, 0L);
                    return str;
                } catch (Exception e18) {
                    str = str2;
                    e2 = e18;
                    this.d.b = -10;
                    this.d.d = this.a.getResources().getString(R.string.neterror);
                    be.b("NetWork", "postMultiNetData", "error = " + e2.getMessage());
                    bf.a(this);
                    if (0 != 0) {
                    }
                    timer = new Timer();
                    avVar = new av(this, null);
                    timer.schedule(avVar, 0L);
                    return str;
                }
            } else {
                str = null;
            }
            try {
                bf.a(this);
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e19) {
                    }
                }
                timer = new Timer();
                avVar = new av(this, null);
            } catch (BdHttpCancelException e20) {
                e4 = e20;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j != null ? -1 : this.j.e) + "|" + e4.getClass() + "|" + e4.getMessage();
                this.d.b = -14;
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e21) {
                    }
                }
                timer = new Timer();
                avVar = new av(this, null);
                timer.schedule(avVar, 0L);
                return str;
            } catch (BdHttpErrorException e22) {
                e3 = e22;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                this.d.l = String.valueOf(this.d.b) + "|retryCount:" + (this.j != null ? -1 : this.j.e) + "|" + e3.getClass() + "|" + e3.getMessage();
                this.d.b = e3.getHttpResponseCode();
                bf.a(this);
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e23) {
                    }
                }
                timer = new Timer();
                avVar = new av(this, null);
                timer.schedule(avVar, 0L);
                return str;
            } catch (OutOfMemoryError e24) {
                e = e24;
                this.d.b = -15;
                this.d.d = this.a.getResources().getString(R.string.memoryerror);
                be.b(getClass().getName(), "postMultiNetData", " 内存溢出！error = " + e.getMessage());
                bf.a(this);
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e25) {
                    }
                }
                timer = new Timer();
                avVar = new av(this, null);
                timer.schedule(avVar, 0L);
                return str;
            } catch (SocketException e26) {
                this.d.b = -12;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                bf.a(this);
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e27) {
                    }
                }
                timer = new Timer();
                avVar = new av(this, null);
                timer.schedule(avVar, 0L);
                return str;
            } catch (SocketTimeoutException e28) {
                this.d.b = -13;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                bf.a(this);
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e29) {
                    }
                }
                timer = new Timer();
                avVar = new av(this, null);
                timer.schedule(avVar, 0L);
                return str;
            } catch (Exception e30) {
                e2 = e30;
                this.d.b = -10;
                this.d.d = this.a.getResources().getString(R.string.neterror);
                be.b("NetWork", "postMultiNetData", "error = " + e2.getMessage());
                bf.a(this);
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e31) {
                    }
                }
                timer = new Timer();
                avVar = new av(this, null);
                timer.schedule(avVar, 0L);
                return str;
            }
        }
        timer.schedule(avVar, 0L);
        return str;
    }

    @Override // com.baidu.tieba.util.ag
    public boolean x() {
        return this.d.b == 200 || this.d.b == 206;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1063=4] */
    @Override // com.baidu.tieba.util.ag
    public Boolean a(String str, Handler handler, int i) {
        boolean valueOf;
        try {
            if (this.b.c()) {
                valueOf = false;
            } else {
                valueOf = Boolean.valueOf(com.baidu.adp.lib.network.d.a().a(this.d.a, y.g(str).getAbsolutePath(), false, 5, (com.baidu.adp.lib.network.c) new at(this, handler, i), this.b, C()));
            }
            return valueOf;
        } catch (Exception e) {
            this.d.b = -10;
            this.d.d = this.a.getResources().getString(R.string.neterror);
            be.b("NetWork", "downloadFile", "error = " + e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.d.b = -15;
            this.d.d = this.a.getResources().getString(R.string.memoryerror);
            be.b(getClass().getName(), "downloadFile", "error = " + e2.getMessage());
            return false;
        } finally {
            bf.a(this);
        }
    }

    @Override // com.baidu.tieba.util.ag
    public void a(Context context) {
        this.a = context;
    }

    @Override // com.baidu.tieba.util.ag
    public Context k() {
        return this.a;
    }

    @Override // com.baidu.tieba.util.ag
    public ArrayList<BasicNameValuePair> l() {
        return this.d.e;
    }

    @Override // com.baidu.tieba.util.ag
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

    @Override // com.baidu.tieba.util.ag
    public void a(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tieba.util.ag
    public void a(String str, byte[] bArr) {
        if (this.d.f == null) {
            this.d.f = new HashMap<>();
        }
        this.d.f.put(str, bArr);
    }

    @Override // com.baidu.tieba.util.ag
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

    @Override // com.baidu.tieba.util.ag
    public void d(boolean z) {
        this.d.h = z;
    }

    @Override // com.baidu.tieba.util.ag
    public void a(boolean z) {
        this.e = z;
    }

    @Override // com.baidu.tieba.util.ag
    public boolean a() {
        return this.f;
    }

    @Override // com.baidu.tieba.util.ag
    public void b(boolean z) {
        this.h = z;
    }

    @Override // com.baidu.tieba.util.ag
    public void a(int i) {
        this.i = i;
    }

    @Override // com.baidu.tieba.util.ag
    public void a(String str) {
        this.g = str;
    }

    @Override // com.baidu.tieba.util.ag
    public String z() {
        return this.d.l;
    }

    private LinkedList<BasicNameValuePair> C() {
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

    @Override // com.baidu.tieba.util.ag
    public String A() {
        if (this.d != null) {
            return this.d.m;
        }
        return null;
    }
}
