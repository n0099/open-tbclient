package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class d {
    private g iAv;
    private b iAz;
    private int Am = 0;
    private long Aa = 0;

    public d(g gVar) {
        this.iAv = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int gi = i3 <= 0 ? com.baidu.adp.framework.c.b.ge().gh().gi() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ge().getRetryCount();
        }
        int gi2 = i4 <= 0 ? com.baidu.adp.framework.c.b.ge().gf().gi() : i4;
        this.iAz = new b(this.iAv);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.Aq = i5 + 1;
                this.Am = i5;
                boolean a = this.iAz.a(str, jVar, gi, gi2, z, eVar, z2);
                com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                this.iAv.a(eVar);
                a cfa = a.cfa();
                if (cfa != null) {
                    cfa.a(this.iAv);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.iAv.cfd().responseCode = -100;
                    eVar.At = String.valueOf(this.iAv.cfd().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.iAv.a(eVar);
                    com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                    this.iAv.a(eVar);
                    a cfa2 = a.cfa();
                    if (cfa2 != null) {
                        cfa2.a(this.iAv);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                    this.iAv.a(eVar);
                    a cfa3 = a.cfa();
                    if (cfa3 != null) {
                        cfa3.a(this.iAv);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.iAv.cfd().responseCode = -10;
                eVar.At = String.valueOf(this.iAv.cfd().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.iAv.a(eVar);
                com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                this.iAv.a(eVar);
                a cfa4 = a.cfa();
                if (cfa4 != null) {
                    cfa4.a(this.iAv);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.ge().gh().gi();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ge().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ge().gf().gi();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.iAv.cfd().AJ && z && i4 < i; i4++) {
            e eVar = new e();
            this.iAv.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.Am = i4;
                                eVar.Aq = i4 + 1;
                                eVar.AA = 1;
                                this.iAz = new b(this.iAv);
                                this.iAz.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.iAv.cfd().AK = -19;
                                eVar.At = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Aa <= 0 && this.iAz != null) {
                                    this.Aa = this.iAz.hW();
                                }
                                eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                                this.iAv.b(eVar);
                                a cfa = a.cfa();
                                if (cfa != null) {
                                    cfa.a(this.iAv);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.At = String.valueOf(this.iAv.cfd().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.iAv.cfd().AK = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Aa <= 0 && this.iAz != null) {
                                this.Aa = this.iAz.hW();
                            }
                            eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                            this.iAv.b(eVar);
                            a cfa2 = a.cfa();
                            if (cfa2 != null) {
                                cfa2.a(this.iAv);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.At = String.valueOf(this.iAv.cfd().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.iAv.cfd().AK = -13;
                        if (this.Aa <= 0 && this.iAz != null) {
                            this.Aa = this.iAz.hW();
                        }
                        eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                        this.iAv.b(eVar);
                        a cfa3 = a.cfa();
                        if (cfa3 != null) {
                            cfa3.a(this.iAv);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.At = String.valueOf(this.iAv.cfd().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.iAv.cfd().AK = -12;
                    if (this.Aa <= 0 && this.iAz != null) {
                        this.Aa = this.iAz.hW();
                    }
                    eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                    this.iAv.b(eVar);
                    a cfa4 = a.cfa();
                    if (cfa4 != null) {
                        cfa4.a(this.iAv);
                    }
                    z = true;
                }
                if (this.iAv.cfd().responseCode == 200) {
                    this.iAv.b(eVar);
                    if (this.Aa <= 0 && this.iAz != null) {
                        this.Aa = this.iAz.hW();
                    }
                    eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                    this.iAv.b(eVar);
                    a cfa5 = a.cfa();
                    if (cfa5 != null) {
                        cfa5.a(this.iAv);
                        return;
                    }
                    return;
                }
                eVar.At = String.valueOf(this.iAv.cfd().responseCode) + "|retryCount:" + i4;
                boolean ab = ab(this.iAv.cfd().responseCode);
                if (this.Aa <= 0 && this.iAz != null) {
                    this.Aa = this.iAz.hW();
                }
                eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                this.iAv.b(eVar);
                a cfa6 = a.cfa();
                if (cfa6 != null) {
                    cfa6.a(this.iAv);
                }
                z = ab;
            } catch (Throwable th) {
                if (this.Aa <= 0 && this.iAz != null) {
                    this.Aa = this.iAz.hW();
                }
                eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                this.iAv.b(eVar);
                a cfa7 = a.cfa();
                if (cfa7 != null) {
                    cfa7.a(this.iAv);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [346=7, 347=7, 349=7, 350=14, 351=7, 352=7, 353=7, 354=7, 356=5] */
    private void e(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.ge().gh().gi();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ge().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ge().gf().gi();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.iAv.cfd().AJ && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.Aq = i4 + 1;
            this.Am = i4;
            try {
                try {
                    try {
                        this.iAz = new b(this.iAv);
                        this.iAz.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.iAv.cfd().AK = -14;
                        eVar.At = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.iAv.a(eVar);
                        if (this.Aa <= 0 && this.iAz != null) {
                            this.Aa = this.iAz.hW();
                        }
                        eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                        this.iAv.a(eVar);
                        a cfa = a.cfa();
                        if (cfa != null && this.iAz != null && this.iAz.hZ()) {
                            cfa.a(this.iAv);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.iAv.cfd().AK = -13;
                        z = true;
                        eVar.At = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.iAv.a(eVar);
                        if (this.Aa <= 0 && this.iAz != null) {
                            this.Aa = this.iAz.hW();
                        }
                        eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                        this.iAv.a(eVar);
                        a cfa2 = a.cfa();
                        if (cfa2 != null && this.iAz != null && this.iAz.hZ()) {
                            cfa2.a(this.iAv);
                        }
                    }
                } catch (SocketException e3) {
                    this.iAv.cfd().AK = -12;
                    z = true;
                    eVar.At = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.iAv.a(eVar);
                    if (this.Aa <= 0 && this.iAz != null) {
                        this.Aa = this.iAz.hW();
                    }
                    eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                    this.iAv.a(eVar);
                    a cfa3 = a.cfa();
                    if (cfa3 != null && this.iAz != null && this.iAz.hZ()) {
                        cfa3.a(this.iAv);
                    }
                } catch (Throwable th) {
                    this.iAv.cfd().AK = -10;
                    z = false;
                    eVar.At = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.iAv.a(eVar);
                    if (this.Aa <= 0 && this.iAz != null) {
                        this.Aa = this.iAz.hW();
                    }
                    eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                    this.iAv.a(eVar);
                    a cfa4 = a.cfa();
                    if (cfa4 != null && this.iAz != null && this.iAz.hZ()) {
                        cfa4.a(this.iAv);
                    }
                }
                if (this.iAv.cfd().responseCode == 200) {
                    if (this.Aa <= 0 && this.iAz != null) {
                        this.Aa = this.iAz.hW();
                    }
                    eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                    this.iAv.a(eVar);
                    a cfa5 = a.cfa();
                    if (cfa5 == null || this.iAz == null || !this.iAz.hZ()) {
                        return;
                    }
                    cfa5.a(this.iAv);
                    return;
                }
                eVar.At = String.valueOf(this.iAv.cfd().responseCode) + "|retryCount:" + i4;
                z = ab(this.iAv.cfd().responseCode);
                this.iAv.a(eVar);
                if (this.Aa <= 0 && this.iAz != null) {
                    this.Aa = this.iAz.hW();
                }
                eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                this.iAv.a(eVar);
                a cfa6 = a.cfa();
                if (cfa6 != null && this.iAz != null && this.iAz.hZ()) {
                    cfa6.a(this.iAv);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Aa <= 0 && this.iAz != null) {
                    this.Aa = this.iAz.hW();
                }
                eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                this.iAv.a(eVar);
                a cfa7 = a.cfa();
                if (cfa7 != null && this.iAz != null && this.iAz.hZ()) {
                    cfa7.a(this.iAv);
                }
                throw th2;
            }
        }
    }

    private boolean ab(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.iAv.cfc().ip()) {
            e(i, i2, i3);
        } else {
            g(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [467=7, 468=7, 470=7, 471=14, 472=7, 473=7, 474=7, 475=7, 477=5] */
    private void g(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.ge().gh().gi();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ge().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ge().gf().gi();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.iAv.cfd().AJ && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.Am = i4;
            eVar.Aq = i4 + 1;
            try {
                try {
                    try {
                        this.iAz = new b(this.iAv);
                        this.iAz.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.iAv.cfd().AK = -13;
                        z = true;
                        eVar.At = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.iAv.a(eVar);
                        if (this.Aa <= 0 && this.iAz != null) {
                            this.Aa = this.iAz.hW();
                        }
                        eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                        this.iAv.a(eVar);
                        a cfa = a.cfa();
                        if (cfa != null) {
                            cfa.a(this.iAv);
                        }
                    } catch (Throwable th) {
                        this.iAv.cfd().AK = -10;
                        z = false;
                        eVar.At = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.iAv.a(eVar);
                        if (this.Aa <= 0 && this.iAz != null) {
                            this.Aa = this.iAz.hW();
                        }
                        eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                        this.iAv.a(eVar);
                        a cfa2 = a.cfa();
                        if (cfa2 != null) {
                            cfa2.a(this.iAv);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.iAv.cfd().AK = -14;
                    eVar.At = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.iAv.a(eVar);
                    if (this.Aa <= 0 && this.iAz != null) {
                        this.Aa = this.iAz.hW();
                    }
                    eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                    this.iAv.a(eVar);
                    a cfa3 = a.cfa();
                    if (cfa3 != null) {
                        cfa3.a(this.iAv);
                    }
                } catch (SocketException e3) {
                    this.iAv.cfd().AK = -12;
                    z = true;
                    eVar.At = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.iAv.a(eVar);
                    if (this.Aa <= 0 && this.iAz != null) {
                        this.Aa = this.iAz.hW();
                    }
                    eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                    this.iAv.a(eVar);
                    a cfa4 = a.cfa();
                    if (cfa4 != null) {
                        cfa4.a(this.iAv);
                    }
                }
                if (this.iAv.cfd().responseCode == 200) {
                    if (this.Aa <= 0 && this.iAz != null) {
                        this.Aa = this.iAz.hW();
                    }
                    eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                    this.iAv.a(eVar);
                    a cfa5 = a.cfa();
                    if (cfa5 != null) {
                        cfa5.a(this.iAv);
                        return;
                    }
                    return;
                }
                eVar.At = String.valueOf(this.iAv.cfd().responseCode) + "|retryCount:" + i4;
                z = ab(this.iAv.cfd().responseCode);
                this.iAv.a(eVar);
                if (this.Aa <= 0 && this.iAz != null) {
                    this.Aa = this.iAz.hW();
                }
                eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                this.iAv.a(eVar);
                a cfa6 = a.cfa();
                if (cfa6 != null) {
                    cfa6.a(this.iAv);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Aa <= 0 && this.iAz != null) {
                    this.Aa = this.iAz.hW();
                }
                eVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.iAv.cfc().getUrl(), this.iAv.cfc().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.At), eVar.Ax != null);
                this.iAv.a(eVar);
                a cfa7 = a.cfa();
                if (cfa7 != null) {
                    cfa7.a(this.iAv);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.iAz != null) {
            this.iAz.ia();
        }
    }

    public boolean ic() {
        if (this.iAv == null) {
            return false;
        }
        return this.iAv.cfd().AJ;
    }

    public void ie() {
        if (this.iAv != null) {
            this.iAv.cfd().AJ = true;
        }
    }
}
