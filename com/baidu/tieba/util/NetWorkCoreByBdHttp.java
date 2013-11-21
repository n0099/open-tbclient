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
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class NetWorkCoreByBdHttp implements ai {
    private static int c = 2097152;

    /* renamed from: a  reason: collision with root package name */
    protected Context f2451a;
    private az d;
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

    public NetWorkCoreByBdHttp(az azVar) {
        A();
        this.f2451a = TiebaApplication.g();
        this.d = azVar;
        com.baidu.adp.lib.network.d.a().b("BaiduTieba for Android " + com.baidu.tieba.data.h.j());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    @Override // com.baidu.tieba.util.ai
    public long f() {
        return this.j.f514a;
    }

    @Override // com.baidu.tieba.util.ai
    public long g() {
        return this.j.b;
    }

    @Override // com.baidu.tieba.util.ai
    public long h() {
        return this.j.c;
    }

    @Override // com.baidu.tieba.util.ai
    public long k() {
        return this.j.d;
    }

    @Override // com.baidu.tieba.util.ai
    public long i() {
        return this.j.g;
    }

    @Override // com.baidu.tieba.util.ai
    public int j() {
        return this.j.e;
    }

    @Override // com.baidu.tieba.util.ai
    public int o() {
        return this.j.b;
    }

    @Override // com.baidu.tieba.util.ai
    public String e() {
        if (this.d.f2478a == null) {
            return null;
        }
        String str = com.baidu.tieba.data.h.f1201a;
        if (this.d.f2478a.startsWith(str)) {
            int indexOf = this.d.f2478a.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.d.f2478a.length();
            }
            return this.d.f2478a.substring(str.length(), indexOf);
        }
        return this.d.f2478a;
    }

    @Override // com.baidu.tieba.util.ai
    public long d() {
        return this.j.f;
    }

    private int a(UtilHelper.NetworkStateInfo networkStateInfo) {
        switch (aw.f2475a[networkStateInfo.ordinal()]) {
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

    private void A() {
        this.f2451a = null;
    }

    @Override // com.baidu.tieba.util.ai
    public void c(boolean z) {
        this.d.j = z;
    }

    @Override // com.baidu.tieba.util.ai
    public String p() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f2451a.getSystemService("connectivity")).getActiveNetworkInfo();
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

    @Override // com.baidu.tieba.util.ai
    public void a(Boolean bool) {
        this.d.g = bool.booleanValue();
    }

    @Override // com.baidu.tieba.util.ai
    public void b(String str) {
        this.d.f2478a = str;
    }

    @Override // com.baidu.tieba.util.ai
    public boolean q() {
        return this.d.b == 200 && this.d.c == 0;
    }

    @Override // com.baidu.tieba.util.ai
    public boolean r() {
        return this.d.b == 200;
    }

    @Override // com.baidu.tieba.util.ai
    public int l() {
        return this.d.c;
    }

    @Override // com.baidu.tieba.util.ai
    public String s() {
        return this.d.d;
    }

    @Override // com.baidu.tieba.util.ai
    public void v() {
        this.d.d = "";
    }

    @Override // com.baidu.tieba.util.ai
    public void c(String str) {
        this.d.d = str;
    }

    @Override // com.baidu.tieba.util.ai
    public void t() {
        this.b.a();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [480=9, 481=9] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:101:0x0246 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:130:0x02e7 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:132:0x02e9 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:139:0x000f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x011d */
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.adp.lib.network.e */
    /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: com.baidu.adp.lib.network.e */
    /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: com.baidu.adp.lib.network.e */
    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: com.baidu.adp.lib.network.e */
    /* JADX DEBUG: Multi-variable search result rejected for r1v13, resolved type: com.baidu.adp.lib.network.e */
    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.adp.lib.network.e */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.adp.lib.network.e */
    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.adp.lib.network.e */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.adp.lib.network.e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c1  */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v17, types: [com.baidu.adp.lib.network.e] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    @Override // com.baidu.tieba.util.ai
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] w() {
        Object obj;
        String str;
        String str2;
        boolean z = true;
        com.baidu.adp.lib.network.d a2 = com.baidu.adp.lib.network.d.a();
        String A = TiebaApplication.A();
        a2.c(A);
        InputStream inputStream = null;
        try {
            try {
                try {
                    if (this.d.e == null || this.d.e.size() <= 0 || this.e) {
                        str = this.d.f2478a;
                    } else {
                        StringBuilder sb = new StringBuilder(30);
                        sb.append(this.d.f2478a);
                        if (this.d.f2478a.indexOf("?") < 0) {
                            sb.append("?");
                        } else if (!this.d.f2478a.endsWith("?") && !this.d.f2478a.endsWith("&")) {
                            sb.append("&");
                        }
                        for (int i = 0; i < this.d.e.size(); i++) {
                            if (i != 0) {
                                sb.append("&");
                            }
                            sb.append(this.d.e.get(i).getName());
                            sb.append("=");
                            sb.append(be.d(this.d.e.get(i).getValue()));
                        }
                        str = sb.toString();
                    }
                    if (com.baidu.tieba.data.h.s()) {
                        bg.e(getClass().getName(), "getNetData", str);
                    }
                    if ((!this.d.g || this.d.h) && !this.e) {
                        z = false;
                    }
                } finally {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e) {
                        }
                    }
                }
            } catch (SocketTimeoutException e2) {
                A = 0;
            } catch (Exception e3) {
                e = e3;
                A = 0;
            } catch (OutOfMemoryError e4) {
                e = e4;
                A = 0;
            } catch (SocketException e5) {
                obj = null;
            }
        } catch (Exception e6) {
        }
        if (this.b.c()) {
            throw new BdHttpCancelException();
        }
        long time = new Date().getTime();
        A = com.baidu.adp.lib.network.d.a().a(str, z, 10, new au(this), this.b);
        if (A != 0) {
            try {
                if (A.c != null) {
                    this.j = A.c;
                }
            } catch (SocketTimeoutException e7) {
                this.d.b = 0;
                this.d.d = this.f2451a.getResources().getString(R.string.neterror);
                if (0 != 0) {
                    inputStream.close();
                    A = A;
                }
                if (A != 0) {
                }
            } catch (Exception e8) {
                e = e8;
                this.d.b = 0;
                this.d.d = this.f2451a.getResources().getString(R.string.neterror);
                bg.b(getClass().getName(), "getNetData", "error = " + e.getMessage());
                if (0 != 0) {
                    inputStream.close();
                    A = A;
                }
                if (A != 0) {
                }
            } catch (OutOfMemoryError e9) {
                e = e9;
                this.d.b = 0;
                this.d.d = this.f2451a.getResources().getString(R.string.memoryerror);
                bg.b(getClass().getName(), "getNetData", " 内存溢出！error = " + e.getMessage());
                if (0 != 0) {
                    inputStream.close();
                    A = A;
                }
                if (A != 0) {
                }
            } catch (SocketException e10) {
                obj = A;
                this.d.b = 0;
                this.d.d = this.f2451a.getResources().getString(R.string.neterror);
                A = obj;
                if (A != 0) {
                }
            }
        }
        if (A == 0) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (Exception e11) {
                }
            }
            return null;
        }
        this.d.b = A.f513a;
        if (this.d.b != 200) {
            throw new SocketException();
        }
        if (TiebaApplication.g().q() && (str2 = A.b) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > c) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e12) {
                        }
                    }
                    return null;
                }
                int i2 = parseInt * 10;
                if (i2 > 0) {
                    if (com.baidu.adp.lib.h.d.a()) {
                        com.baidu.adp.lib.h.d.d("pre-free memory for downloaded image:[" + this.d.f2478a + "], size:" + i2);
                    }
                    if (!com.baidu.tbadk.imageManager.d.a().c(i2)) {
                        com.baidu.adp.lib.h.d.d("Image download cacelled. out of memory. url:[" + this.d.f2478a + "], size:" + i2);
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (Exception e13) {
                            }
                        }
                        return null;
                    }
                }
            } catch (Throwable th) {
                bg.e(NetWorkCoreByBdHttp.class.getName(), "getNetData", th.getMessage());
            }
        }
        bb bbVar = new bb();
        bbVar.e = a(UtilHelper.i(this.f2451a));
        bbVar.c = this.j.b;
        bbVar.b = new Date().getTime() - time;
        bbVar.d = this.j.e;
        bbVar.f2480a = 2;
        ba.a(bbVar);
        ba.f2479a.set(this.j.e);
        if (this.h) {
            bh.b(this);
        } else {
            bh.a(this);
        }
        if (0 != 0) {
            inputStream.close();
            A = A;
        }
        if (A != 0) {
            this.d.k = A.e;
            return A.d;
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
                    this.d.d = this.f2451a.getString(R.string.error_unkown_try_again);
                } else if (this.d.c != 0) {
                    this.d.d = errorData.getError_msg();
                }
            } catch (Exception e) {
                bg.b("NetWork", "parseServerCode", "error = " + e.getMessage());
                this.d.d = this.f2451a.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tieba.util.ai
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
                bg.b(getClass().getName(), "getNetString", "error = " + e2.getMessage());
                return str;
            } catch (OutOfMemoryError e4) {
                e = e4;
                bg.b(getClass().getName(), "getNetString", " 内存溢出！error = " + e.getMessage());
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

    @Override // com.baidu.tieba.util.ai
    public String u() {
        Throwable th;
        String str;
        Exception e;
        SocketTimeoutException e2;
        SocketException e3;
        OutOfMemoryError e4;
        BdHttpErrorException e5;
        BdHttpCancelException e6;
        StringBuilder sb = new StringBuilder(1024);
        StringBuilder sb2 = new StringBuilder(1024);
        for (int i = 0; this.d.e != null && i < this.d.e.size(); i++) {
            BasicNameValuePair basicNameValuePair = this.d.e.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                if (i != 0) {
                    sb.append("&");
                }
                sb.append(name + "=");
                sb.append(be.d(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
        }
        if (this.d.i) {
            sb2.append("tiebaclient!!!");
            String a2 = be.a(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(a2);
        }
        String sb3 = sb.toString();
        if (com.baidu.tieba.data.h.s()) {
            bg.e(getClass().getName(), "postNetData", this.d.f2478a + "?" + sb3);
        }
        try {
            if (this.b.c()) {
                return null;
            }
            com.baidu.adp.lib.network.e a3 = com.baidu.adp.lib.network.d.a().a(this.d.f2478a, sb3.getBytes(), this.d.g, 10, (com.baidu.adp.lib.network.c) null, this.b);
            if (a3 == null) {
                throw new BdHttpCancelException();
            }
            if (a3 != null && a3.c != null) {
                this.j = a3.c;
            }
            this.d.b = a3.f513a;
            if (this.d.b != 200) {
                throw new SocketException();
            }
            if (this.b.c()) {
                return null;
            }
            bg.a(getClass().getName(), "postNetData", "time = " + String.valueOf(this.j.f) + LocaleUtil.MALAY);
            bg.a(getClass().getName(), "postNetData", "Get data.zise = " + String.valueOf(this.j.b));
            str = new String(a3.d, BdUtil.UTF8);
            try {
                if (this.d.i && this.d.j) {
                    d(str);
                }
                bb bbVar = new bb();
                bbVar.e = a(UtilHelper.i(this.f2451a));
                bbVar.c = this.j.b;
                bbVar.b = this.j.f;
                bbVar.d = this.j.e;
                bbVar.f2480a = 1;
                ba.a(bbVar);
                ba.f2479a.set(this.j.e);
                bh.a(this);
                return str;
            } catch (BdHttpCancelException e7) {
                e6 = e7;
                bg.b(getClass().getName(), "postNetData", "BdHttpCancelException " + e6.getMessage());
                return str;
            } catch (BdHttpErrorException e8) {
                e5 = e8;
                this.d.d = this.f2451a.getResources().getString(R.string.neterror);
                bg.b(getClass().getName(), "postNetData", "BdHttpErrorException " + e5.getMessage());
                return str;
            } catch (OutOfMemoryError e9) {
                e4 = e9;
                this.d.b = 0;
                this.d.d = this.f2451a.getResources().getString(R.string.memoryerror);
                bg.b(getClass().getName(), "postNetData", " 内存溢出！error = " + e4.getMessage());
                return str;
            } catch (SocketException e10) {
                e3 = e10;
                this.d.b = 0;
                this.d.d = this.f2451a.getResources().getString(R.string.neterror);
                bg.b(getClass().getName(), "postNetData", "SocketException " + e3.getMessage());
                return str;
            } catch (SocketTimeoutException e11) {
                e2 = e11;
                this.d.b = 0;
                this.d.d = this.f2451a.getResources().getString(R.string.neterror);
                bg.b(getClass().getName(), "postNetData", "SocketTimeoutException " + e2.getMessage());
                return str;
            } catch (Exception e12) {
                e = e12;
                this.d.b = 0;
                this.d.d = this.f2451a.getResources().getString(R.string.neterror);
                bg.b(getClass().getName(), "postNetData", e.getMessage());
                return str;
            } catch (Throwable th2) {
                th = th2;
                this.d.b = 0;
                this.d.d = this.f2451a.getResources().getString(R.string.neterror);
                bg.b(getClass().getName(), "postNetData", th.getMessage());
                return str;
            }
        } catch (BdHttpCancelException e13) {
            e6 = e13;
            str = null;
        } catch (BdHttpErrorException e14) {
            e5 = e14;
            str = null;
        } catch (OutOfMemoryError e15) {
            e4 = e15;
            str = null;
        } catch (SocketException e16) {
            e3 = e16;
            str = null;
        } catch (SocketTimeoutException e17) {
            e2 = e17;
            str = null;
        } catch (Exception e18) {
            e = e18;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [716=6, 717=6, 721=6] */
    @Override // com.baidu.tieba.util.ai
    public String y() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        Timer timer;
        ax axVar;
        InputStream inputStream = null;
        try {
            try {
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                    }
                }
                new Timer().schedule(new ax(this, null), 0L);
                throw th;
            }
        } catch (SocketTimeoutException e4) {
            str = null;
        } catch (Exception e5) {
            e2 = e5;
            str = null;
        } catch (OutOfMemoryError e6) {
            e = e6;
            str = null;
        } catch (SocketException e7) {
            str = null;
        }
        if (this.b.c()) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.e a2 = com.baidu.adp.lib.network.d.a().a(this.d.f2478a, this.d.g, this.d.e, this.d.f, 10, null, this.b, null);
        this.d.b = a2.f513a;
        new Timer().schedule(new ax(this, null), 45000L);
        if (this.d.b != 200) {
            throw new SocketException();
        }
        if (this.b.c()) {
            throw new BdHttpCancelException();
        }
        if (a2 != null) {
            str = new String(a2.d, a2.e);
            try {
                d(str);
            } catch (Exception e8) {
                e2 = e8;
                this.d.b = 0;
                this.d.d = this.f2451a.getResources().getString(R.string.neterror);
                bg.b("NetWork", "postMultiNetData", "error = " + e2.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e9) {
                    }
                }
                timer = new Timer();
                axVar = new ax(this, null);
                timer.schedule(axVar, 0L);
                return str;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.d.b = 0;
                this.d.d = this.f2451a.getResources().getString(R.string.memoryerror);
                bg.b(getClass().getName(), "postMultiNetData", " 内存溢出！error = " + e.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e11) {
                    }
                }
                timer = new Timer();
                axVar = new ax(this, null);
                timer.schedule(axVar, 0L);
                return str;
            } catch (SocketException e12) {
                this.d.b = 0;
                this.d.d = this.f2451a.getResources().getString(R.string.neterror);
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e13) {
                    }
                }
                timer = new Timer();
                axVar = new ax(this, null);
                timer.schedule(axVar, 0L);
                return str;
            } catch (SocketTimeoutException e14) {
                this.d.b = 0;
                this.d.d = this.f2451a.getResources().getString(R.string.neterror);
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e15) {
                    }
                }
                timer = new Timer();
                axVar = new ax(this, null);
                timer.schedule(axVar, 0L);
                return str;
            }
        } else {
            str = null;
        }
        if (0 != 0) {
            try {
                inputStream.close();
            } catch (Exception e16) {
            }
        }
        timer = new Timer();
        axVar = new ax(this, null);
        timer.schedule(axVar, 0L);
        return str;
    }

    @Override // com.baidu.tieba.util.ai
    public boolean z() {
        return this.d.b == 200 || this.d.b == 206;
    }

    @Override // com.baidu.tieba.util.ai
    public Boolean a(String str, Handler handler, int i) {
        boolean valueOf;
        try {
            if (this.b.c()) {
                valueOf = false;
            } else {
                valueOf = Boolean.valueOf(com.baidu.adp.lib.network.d.a().a(this.d.f2478a, af.g(str).getAbsolutePath(), false, 10, (com.baidu.adp.lib.network.c) new av(this, handler, i), this.b));
            }
            return valueOf;
        } catch (Exception e) {
            this.d.b = 0;
            this.d.d = this.f2451a.getResources().getString(R.string.neterror);
            bg.b("NetWork", "downloadFile", "error = " + e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.d.b = 0;
            this.d.d = this.f2451a.getResources().getString(R.string.memoryerror);
            bg.b(getClass().getName(), "downloadFile", "error = " + e2.getMessage());
            return false;
        }
    }

    @Override // com.baidu.tieba.util.ai
    public void a(Context context) {
        this.f2451a = context;
    }

    @Override // com.baidu.tieba.util.ai
    public Context m() {
        return this.f2451a;
    }

    @Override // com.baidu.tieba.util.ai
    public ArrayList<BasicNameValuePair> n() {
        return this.d.e;
    }

    @Override // com.baidu.tieba.util.ai
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

    @Override // com.baidu.tieba.util.ai
    public void a(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tieba.util.ai
    public void a(String str, byte[] bArr) {
        if (this.d.f == null) {
            this.d.f = new HashMap<>();
        }
        this.d.f.put(str, bArr);
    }

    @Override // com.baidu.tieba.util.ai
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.d.e == null) {
                this.d.e = new ArrayList<>();
            }
            int a2 = a(this.d.e, basicNameValuePair.getName());
            int size = this.d.e.size();
            if (a2 >= 0 && a2 < size) {
                if (basicNameValuePair.getName().equals(this.d.e.get(a2).getName())) {
                    this.d.e.set(a2, basicNameValuePair);
                } else {
                    this.d.e.add(a2, basicNameValuePair);
                }
            } else if (a2 == size) {
                this.d.e.add(a2, basicNameValuePair);
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
        this.d.h = z;
    }

    @Override // com.baidu.tieba.util.ai
    public void a(boolean z) {
        this.e = z;
    }

    @Override // com.baidu.tieba.util.ai
    public boolean a() {
        return this.f;
    }

    @Override // com.baidu.tieba.util.ai
    public void b(boolean z) {
        this.h = z;
    }

    @Override // com.baidu.tieba.util.ai
    public int b() {
        return this.i;
    }

    @Override // com.baidu.tieba.util.ai
    public void a(int i) {
        this.i = i;
    }

    @Override // com.baidu.tieba.util.ai
    public String c() {
        return this.g;
    }

    @Override // com.baidu.tieba.util.ai
    public void a(String str) {
        this.g = str;
    }
}
