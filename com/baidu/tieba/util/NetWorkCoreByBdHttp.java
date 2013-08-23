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
import com.baidu.tieba.TiebaApplication;
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
public class NetWorkCoreByBdHttp implements s {
    private static int c = 2097152;
    private static /* synthetic */ int[] f;

    /* renamed from: a  reason: collision with root package name */
    protected Context f1769a;
    private ad d;
    protected final com.baidu.adp.lib.network.a b = new com.baidu.adp.lib.network.a();
    private com.baidu.adp.lib.network.f e = new com.baidu.adp.lib.network.f();

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

    static /* synthetic */ int[] x() {
        int[] iArr = f;
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
            f = iArr;
        }
        return iArr;
    }

    public NetWorkCoreByBdHttp(ad adVar) {
        y();
        this.f1769a = TiebaApplication.g();
        this.d = adVar;
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    @Override // com.baidu.tieba.util.s
    public long c() {
        return this.e.f447a;
    }

    @Override // com.baidu.tieba.util.s
    public long d() {
        return this.e.b;
    }

    @Override // com.baidu.tieba.util.s
    public long e() {
        return this.e.c;
    }

    @Override // com.baidu.tieba.util.s
    public long h() {
        return this.e.d;
    }

    @Override // com.baidu.tieba.util.s
    public long f() {
        return this.e.g;
    }

    @Override // com.baidu.tieba.util.s
    public int g() {
        return this.e.e;
    }

    @Override // com.baidu.tieba.util.s
    public int l() {
        return this.e.b;
    }

    @Override // com.baidu.tieba.util.s
    public String b() {
        if (this.d.f1778a == null) {
            return null;
        }
        String str = com.baidu.tieba.data.g.f1014a;
        if (this.d.f1778a.startsWith(str)) {
            int indexOf = this.d.f1778a.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.d.f1778a.length();
            }
            return this.d.f1778a.substring(str.length(), indexOf);
        }
        return this.d.f1778a;
    }

    @Override // com.baidu.tieba.util.s
    public long a() {
        return this.e.f;
    }

    private int a(UtilHelper.NetworkStateInfo networkStateInfo) {
        switch (x()[networkStateInfo.ordinal()]) {
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

    private void y() {
        this.f1769a = null;
    }

    @Override // com.baidu.tieba.util.s
    public void a(boolean z) {
        this.d.j = z;
    }

    @Override // com.baidu.tieba.util.s
    public String m() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f1769a.getSystemService("connectivity")).getActiveNetworkInfo();
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
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.tieba.util.s
    public void a(Boolean bool) {
        this.d.g = bool.booleanValue();
    }

    @Override // com.baidu.tieba.util.s
    public void a(String str) {
        this.d.f1778a = str;
    }

    @Override // com.baidu.tieba.util.s
    public boolean n() {
        return this.d.b == 200 && this.d.c == 0;
    }

    @Override // com.baidu.tieba.util.s
    public boolean o() {
        return this.d.b == 200;
    }

    @Override // com.baidu.tieba.util.s
    public int i() {
        return this.d.c;
    }

    @Override // com.baidu.tieba.util.s
    public String p() {
        return this.d.d;
    }

    @Override // com.baidu.tieba.util.s
    public void s() {
        this.d.d = "";
    }

    @Override // com.baidu.tieba.util.s
    public void b(String str) {
        this.d.d = str;
    }

    @Override // com.baidu.tieba.util.s
    public void q() {
        this.b.a();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [454=9, 455=9, 457=5] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008f  */
    @Override // com.baidu.tieba.util.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] t() {
        com.baidu.adp.lib.network.e eVar;
        com.baidu.adp.lib.network.e eVar2;
        String str;
        String str2;
        boolean z = false;
        InputStream inputStream = null;
        try {
            try {
                if (this.d.e == null || this.d.e.size() <= 0) {
                    str = this.d.f1778a;
                } else {
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(this.d.f1778a);
                    if (this.d.f1778a.indexOf("?") < 0) {
                        sb.append("?");
                    } else if (!this.d.f1778a.endsWith("?") && !this.d.f1778a.endsWith("&")) {
                        sb.append("&");
                    }
                    for (int i = 0; i < this.d.e.size(); i++) {
                        if (i != 0) {
                            sb.append("&");
                        }
                        sb.append(((BasicNameValuePair) this.d.e.get(i)).getName());
                        sb.append("=");
                        sb.append(ap.d(((BasicNameValuePair) this.d.e.get(i)).getValue()));
                    }
                    str = sb.toString();
                }
                if (com.baidu.tieba.data.g.s()) {
                    aq.e(getClass().getName(), "getNetData", str);
                }
                if (this.d.g && !this.d.h) {
                    z = true;
                }
            } finally {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Exception e2) {
            e = e2;
            eVar = null;
        } catch (OutOfMemoryError e3) {
            e = e3;
            eVar = null;
        } catch (SocketException e4) {
            eVar2 = null;
        } catch (SocketTimeoutException e5) {
            eVar = null;
        }
        if (this.b.c()) {
            throw new BdHttpCancelException();
        }
        long time = new Date().getTime();
        eVar = com.baidu.adp.lib.network.d.a().a(str, z, 5, new z(this), this.b);
        if (eVar != null) {
            try {
                if (eVar.c != null) {
                    this.e = eVar.c;
                }
            } catch (OutOfMemoryError e6) {
                e = e6;
                this.d.b = 0;
                this.d.d = this.f1769a.getResources().getString(R.string.memoryerror);
                aq.b(getClass().getName(), "getNetData", " 内存溢出！error = " + e.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e7) {
                    }
                }
                if (eVar != null) {
                }
            } catch (SocketException e8) {
                eVar2 = eVar;
                this.d.b = 0;
                this.d.d = this.f1769a.getResources().getString(R.string.neterror);
                if (0 != 0) {
                    try {
                        inputStream.close();
                        eVar = eVar2;
                    } catch (Exception e9) {
                        eVar = eVar2;
                    }
                } else {
                    eVar = eVar2;
                }
                if (eVar != null) {
                }
            } catch (SocketTimeoutException e10) {
                this.d.b = 0;
                this.d.d = this.f1769a.getResources().getString(R.string.neterror);
                if (eVar != null) {
                }
            } catch (Exception e11) {
                e = e11;
                this.d.b = 0;
                this.d.d = this.f1769a.getResources().getString(R.string.neterror);
                aq.b(getClass().getName(), "getNetData", "error = " + e.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e12) {
                    }
                }
                if (eVar != null) {
                }
            }
        }
        if (eVar == null) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (Exception e13) {
                }
            }
            return null;
        }
        this.d.b = eVar.f446a;
        if (this.d.b != 200) {
            throw new SocketException();
        }
        if (TiebaApplication.g().s() && (str2 = eVar.b) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > c) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    return null;
                }
                int i2 = parseInt * 10;
                if (i2 > 0) {
                    if (com.baidu.adp.lib.e.d.a()) {
                        com.baidu.adp.lib.e.d.c("pre-free memory for downloaded image:[" + this.d.f1778a + "], size:" + i2);
                    }
                    if (!com.baidu.tbadk.a.e.a().c(i2)) {
                        com.baidu.adp.lib.e.d.c("Image download cacelled. out of memory. url:[" + this.d.f1778a + "], size:" + i2);
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (Exception e15) {
                            }
                        }
                        return null;
                    }
                }
            } catch (Throwable th) {
                aq.e(NetWorkCoreByBdHttp.class.getName(), "getNetData", th.getMessage());
            }
        }
        af afVar = new af();
        afVar.e = a(UtilHelper.i(this.f1769a));
        afVar.c = this.e.b;
        afVar.b = new Date().getTime() - time;
        afVar.d = this.e.e;
        afVar.f1780a = 2;
        ae.a(afVar);
        ae.f1779a.set(this.e.e);
        ar.a(this);
        if (0 != 0) {
            try {
                inputStream.close();
            } catch (Exception e16) {
            }
        }
        if (eVar != null) {
            this.d.k = eVar.e;
            return eVar.d;
        }
        return null;
    }

    public void c(String str) {
        this.d.c = -1;
        if (str != null) {
            try {
                com.baidu.tieba.data.r rVar = new com.baidu.tieba.data.r();
                rVar.b(str);
                this.d.c = rVar.a();
                if (this.d.c == -1) {
                    this.d.d = this.f1769a.getString(R.string.error_unkown_try_again);
                } else if (this.d.c != 0) {
                    this.d.d = rVar.b();
                }
            } catch (Exception e) {
                aq.b("NetWork", "parseServerCode", "error = " + e.getMessage());
                this.d.d = this.f1769a.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tieba.util.s
    public String u() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] t = t();
        if (t == null || this.d.b != 200) {
            return null;
        }
        try {
            this.d.k = TextUtils.isEmpty(this.d.k) ? "UTF-8" : this.d.k;
            str = new String(t, 0, t.length, this.d.k);
            try {
                c(str);
                return str;
            } catch (Exception e3) {
                e2 = e3;
                aq.b(getClass().getName(), "getNetString", "error = " + e2.getMessage());
                return str;
            } catch (OutOfMemoryError e4) {
                e = e4;
                aq.b(getClass().getName(), "getNetString", " 内存溢出！error = " + e.getMessage());
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

    @Override // com.baidu.tieba.util.s
    public String r() {
        SocketException e;
        String str;
        OutOfMemoryError e2;
        Exception e3;
        SocketTimeoutException e4;
        BdHttpErrorException e5;
        BdHttpCancelException e6;
        StringBuilder sb = new StringBuilder(1024);
        StringBuilder sb2 = new StringBuilder(1024);
        for (int i = 0; this.d.e != null && i < this.d.e.size(); i++) {
            BasicNameValuePair basicNameValuePair = (BasicNameValuePair) this.d.e.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                if (i != 0) {
                    sb.append("&");
                }
                sb.append(String.valueOf(name) + "=");
                sb.append(ap.d(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
        }
        if (this.d.i) {
            sb2.append("tiebaclient!!!");
            String a2 = ap.a(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(a2);
        }
        String sb3 = sb.toString();
        if (com.baidu.tieba.data.g.s()) {
            aq.e(getClass().getName(), "postNetData", String.valueOf(this.d.f1778a) + "?" + sb3);
        }
        try {
            if (this.b.c()) {
                return null;
            }
            com.baidu.adp.lib.network.e a3 = com.baidu.adp.lib.network.d.a().a(this.d.f1778a, sb3.getBytes(), this.d.g, 5, (com.baidu.adp.lib.network.c) null, this.b);
            if (a3 == null) {
                throw new BdHttpCancelException();
            }
            if (a3 != null && a3.c != null) {
                this.e = a3.c;
            }
            this.d.b = a3.f446a;
            if (this.d.b != 200) {
                throw new SocketException();
            }
            if (this.b.c()) {
                return null;
            }
            aq.a(getClass().getName(), "postNetData", "time = " + String.valueOf(this.e.f) + LocaleUtil.MALAY);
            aq.a(getClass().getName(), "postNetData", "Get data.zise = " + String.valueOf(this.e.b));
            str = new String(a3.d, BdUtil.UTF8);
            try {
                if (this.d.i && this.d.j) {
                    c(str);
                }
                af afVar = new af();
                afVar.e = a(UtilHelper.i(this.f1769a));
                afVar.c = this.e.b;
                afVar.b = this.e.f;
                afVar.d = this.e.e;
                afVar.f1780a = 1;
                ae.a(afVar);
                ae.f1779a.set(this.e.e);
                ar.a(this);
                return str;
            } catch (BdHttpCancelException e7) {
                e6 = e7;
                aq.b(getClass().getName(), "postNetData", "BdHttpCancelException " + e6.getMessage());
                return str;
            } catch (BdHttpErrorException e8) {
                e5 = e8;
                this.d.d = this.f1769a.getResources().getString(R.string.neterror);
                aq.b(getClass().getName(), "postNetData", "BdHttpErrorException " + e5.getMessage());
                return str;
            } catch (OutOfMemoryError e9) {
                e2 = e9;
                this.d.b = 0;
                this.d.d = this.f1769a.getResources().getString(R.string.memoryerror);
                aq.b(getClass().getName(), "postNetData", " 内存溢出！error = " + e2.getMessage());
                return str;
            } catch (SocketException e10) {
                e = e10;
                this.d.b = 0;
                this.d.d = this.f1769a.getResources().getString(R.string.neterror);
                aq.b(getClass().getName(), "postNetData", "SocketException " + e.getMessage());
                return str;
            } catch (SocketTimeoutException e11) {
                e4 = e11;
                this.d.b = 0;
                this.d.d = this.f1769a.getResources().getString(R.string.neterror);
                aq.b(getClass().getName(), "postNetData", "SocketTimeoutException " + e4.getMessage());
                return str;
            } catch (Exception e12) {
                e3 = e12;
                this.d.b = 0;
                this.d.d = this.f1769a.getResources().getString(R.string.neterror);
                aq.b(getClass().getName(), "postNetData", e3.getMessage());
                return str;
            }
        } catch (BdHttpCancelException e13) {
            e6 = e13;
            str = null;
        } catch (BdHttpErrorException e14) {
            e5 = e14;
            str = null;
        } catch (SocketTimeoutException e15) {
            e4 = e15;
            str = null;
        } catch (Exception e16) {
            e3 = e16;
            str = null;
        } catch (OutOfMemoryError e17) {
            e2 = e17;
            str = null;
        } catch (SocketException e18) {
            e = e18;
            str = null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, CONSTRUCTOR, CONSTRUCTOR, INVOKE, CONSTRUCTOR, CONSTRUCTOR, INVOKE, CONSTRUCTOR, CONSTRUCTOR, INVOKE, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, CONSTRUCTOR, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [685=6, 686=6, 690=6] */
    @Override // com.baidu.tieba.util.s
    public String v() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        InputStream inputStream = null;
        try {
            try {
            } finally {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                    }
                }
                new Timer().schedule(new ab(this, null), 0L);
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
        com.baidu.adp.lib.network.e a2 = com.baidu.adp.lib.network.d.a().a(this.d.f1778a, this.d.g, this.d.e, this.d.f, 5, null, this.b, null);
        this.d.b = a2.f446a;
        new Timer().schedule(new ab(this, null), 45000L);
        if (this.d.b != 200) {
            throw new SocketException();
        }
        if (this.b.c()) {
            throw new BdHttpCancelException();
        }
        if (a2 != null) {
            str = new String(a2.d, a2.e);
            try {
                c(str);
            } catch (Exception e8) {
                e2 = e8;
                this.d.b = 0;
                this.d.d = this.f1769a.getResources().getString(R.string.neterror);
                aq.b("NetWork", "postMultiNetData", "error = " + e2.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e9) {
                    }
                }
                new Timer().schedule(new ab(this, null), 0L);
                return str;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.d.b = 0;
                this.d.d = this.f1769a.getResources().getString(R.string.memoryerror);
                aq.b(getClass().getName(), "postMultiNetData", " 内存溢出！error = " + e.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e11) {
                    }
                }
                new Timer().schedule(new ab(this, null), 0L);
                return str;
            } catch (SocketException e12) {
                this.d.b = 0;
                this.d.d = this.f1769a.getResources().getString(R.string.neterror);
                return str;
            } catch (SocketTimeoutException e13) {
                this.d.b = 0;
                this.d.d = this.f1769a.getResources().getString(R.string.neterror);
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e14) {
                    }
                }
                new Timer().schedule(new ab(this, null), 0L);
                return str;
            }
        } else {
            str = null;
        }
        if (0 != 0) {
            try {
                inputStream.close();
            } catch (Exception e15) {
            }
        }
        new Timer().schedule(new ab(this, null), 0L);
        return str;
    }

    @Override // com.baidu.tieba.util.s
    public boolean w() {
        return this.d.b == 200 || this.d.b == 206;
    }

    @Override // com.baidu.tieba.util.s
    public Boolean a(String str, Handler handler, int i) {
        boolean valueOf;
        try {
            if (this.b.c()) {
                valueOf = false;
            } else {
                valueOf = Boolean.valueOf(com.baidu.adp.lib.network.d.a().a(this.d.f1778a, p.f(str).getAbsolutePath(), false, 5, (com.baidu.adp.lib.network.c) new aa(this, handler, i), this.b));
            }
            return valueOf;
        } catch (Exception e) {
            this.d.b = 0;
            this.d.d = this.f1769a.getResources().getString(R.string.neterror);
            aq.b("NetWork", "downloadFile", "error = " + e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.d.b = 0;
            this.d.d = this.f1769a.getResources().getString(R.string.memoryerror);
            aq.b(getClass().getName(), "downloadFile", "error = " + e2.getMessage());
            return false;
        }
    }

    @Override // com.baidu.tieba.util.s
    public void a(Context context) {
        this.f1769a = context;
    }

    @Override // com.baidu.tieba.util.s
    public Context j() {
        return this.f1769a;
    }

    @Override // com.baidu.tieba.util.s
    public ArrayList k() {
        return this.d.e;
    }

    @Override // com.baidu.tieba.util.s
    public void a(ArrayList arrayList) {
        if (this.d.e != null) {
            this.d.e.clear();
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

    @Override // com.baidu.tieba.util.s
    public void a(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tieba.util.s
    public void a(String str, byte[] bArr) {
        if (this.d.f == null) {
            this.d.f = new HashMap();
        }
        this.d.f.put(str, bArr);
    }

    @Override // com.baidu.tieba.util.s
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.d.e == null) {
                this.d.e = new ArrayList();
            }
            int a2 = a(this.d.e, basicNameValuePair.getName());
            int size = this.d.e.size();
            if (a2 >= 0 && a2 < size) {
                if (basicNameValuePair.getName().equals(((BasicNameValuePair) this.d.e.get(a2)).getName())) {
                    this.d.e.set(a2, basicNameValuePair);
                } else {
                    this.d.e.add(a2, basicNameValuePair);
                }
            } else if (a2 == size) {
                this.d.e.add(a2, basicNameValuePair);
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

    @Override // com.baidu.tieba.util.s
    public void b(boolean z) {
        this.d.h = z;
    }
}
