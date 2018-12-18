package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes3.dex */
public class d {
    private int CE = 0;
    private long Ct = 0;
    private b gMC;
    private g gMy;

    public d(g gVar) {
        this.gMy = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int hr = i3 <= 0 ? com.baidu.adp.framework.c.b.hn().hq().hr() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.hn().getRetryCount();
        }
        int hr2 = i4 <= 0 ? com.baidu.adp.framework.c.b.hn().ho().hr() : i4;
        this.gMC = new b(this.gMy);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.CI = i5 + 1;
                this.CE = i5;
                boolean a = this.gMC.a(str, jVar, hr, hr2, z, eVar, z2);
                com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gMy.a(eVar);
                a buM = a.buM();
                if (buM != null) {
                    buM.a(this.gMy);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.gMy.buP().responseCode = -100;
                    eVar.CL = String.valueOf(this.gMy.buP().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.gMy.a(eVar);
                    com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gMy.a(eVar);
                    a buM2 = a.buM();
                    if (buM2 != null) {
                        buM2.a(this.gMy);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gMy.a(eVar);
                    a buM3 = a.buM();
                    if (buM3 != null) {
                        buM3.a(this.gMy);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.gMy.buP().responseCode = -10;
                eVar.CL = String.valueOf(this.gMy.buP().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.gMy.a(eVar);
                com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gMy.a(eVar);
                a buM4 = a.buM();
                if (buM4 != null) {
                    buM4.a(this.gMy);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void e(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.hn().hq().hr();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.hn().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.hn().ho().hr();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.gMy.buP().Dd && z && i4 < i; i4++) {
            e eVar = new e();
            this.gMy.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.CE = i4;
                                eVar.CI = i4 + 1;
                                eVar.CU = 1;
                                this.gMC = new b(this.gMy);
                                this.gMC.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.gMy.buP().De = -19;
                                eVar.CL = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Ct <= 0 && this.gMC != null) {
                                    this.Ct = this.gMC.jc();
                                }
                                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                                this.gMy.b(eVar);
                                a buM = a.buM();
                                if (buM != null) {
                                    buM.a(this.gMy);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.CL = String.valueOf(this.gMy.buP().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.gMy.buP().De = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Ct <= 0 && this.gMC != null) {
                                this.Ct = this.gMC.jc();
                            }
                            eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                            this.gMy.b(eVar);
                            a buM2 = a.buM();
                            if (buM2 != null) {
                                buM2.a(this.gMy);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.CL = String.valueOf(this.gMy.buP().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.gMy.buP().De = -13;
                        if (this.Ct <= 0 && this.gMC != null) {
                            this.Ct = this.gMC.jc();
                        }
                        eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                        this.gMy.b(eVar);
                        a buM3 = a.buM();
                        if (buM3 != null) {
                            buM3.a(this.gMy);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.CL = String.valueOf(this.gMy.buP().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.gMy.buP().De = -12;
                    if (this.Ct <= 0 && this.gMC != null) {
                        this.Ct = this.gMC.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gMy.b(eVar);
                    a buM4 = a.buM();
                    if (buM4 != null) {
                        buM4.a(this.gMy);
                    }
                    z = true;
                }
                if (this.gMy.buP().responseCode == 200) {
                    this.gMy.b(eVar);
                    if (this.Ct <= 0 && this.gMC != null) {
                        this.Ct = this.gMC.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gMy.b(eVar);
                    a buM5 = a.buM();
                    if (buM5 != null) {
                        buM5.a(this.gMy);
                        return;
                    }
                    return;
                }
                eVar.CL = String.valueOf(this.gMy.buP().responseCode) + "|retryCount:" + i4;
                boolean aA = aA(this.gMy.buP().responseCode);
                if (this.Ct <= 0 && this.gMC != null) {
                    this.Ct = this.gMC.jc();
                }
                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gMy.b(eVar);
                a buM6 = a.buM();
                if (buM6 != null) {
                    buM6.a(this.gMy);
                }
                z = aA;
            } catch (Throwable th) {
                if (this.Ct <= 0 && this.gMC != null) {
                    this.Ct = this.gMC.jc();
                }
                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gMy.b(eVar);
                a buM7 = a.buM();
                if (buM7 != null) {
                    buM7.a(this.gMy);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [346=7, 347=7, 349=7, 350=14, 351=7, 352=7, 353=7, 354=7, 356=5] */
    private void f(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.hn().hq().hr();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.hn().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.hn().ho().hr();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.gMy.buP().Dd && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.CI = i4 + 1;
            this.CE = i4;
            try {
                try {
                    try {
                        this.gMC = new b(this.gMy);
                        this.gMC.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.gMy.buP().De = -14;
                        eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.gMy.a(eVar);
                        if (this.Ct <= 0 && this.gMC != null) {
                            this.Ct = this.gMC.jc();
                        }
                        eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                        this.gMy.a(eVar);
                        a buM = a.buM();
                        if (buM != null && this.gMC != null && this.gMC.jf()) {
                            buM.a(this.gMy);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.gMy.buP().De = -13;
                        z = true;
                        eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.gMy.a(eVar);
                        if (this.Ct <= 0 && this.gMC != null) {
                            this.Ct = this.gMC.jc();
                        }
                        eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                        this.gMy.a(eVar);
                        a buM2 = a.buM();
                        if (buM2 != null && this.gMC != null && this.gMC.jf()) {
                            buM2.a(this.gMy);
                        }
                    }
                } catch (SocketException e3) {
                    this.gMy.buP().De = -12;
                    z = true;
                    eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gMy.a(eVar);
                    if (this.Ct <= 0 && this.gMC != null) {
                        this.Ct = this.gMC.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gMy.a(eVar);
                    a buM3 = a.buM();
                    if (buM3 != null && this.gMC != null && this.gMC.jf()) {
                        buM3.a(this.gMy);
                    }
                } catch (Throwable th) {
                    this.gMy.buP().De = -10;
                    z = false;
                    eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.gMy.a(eVar);
                    if (this.Ct <= 0 && this.gMC != null) {
                        this.Ct = this.gMC.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gMy.a(eVar);
                    a buM4 = a.buM();
                    if (buM4 != null && this.gMC != null && this.gMC.jf()) {
                        buM4.a(this.gMy);
                    }
                }
                if (this.gMy.buP().responseCode == 200) {
                    if (this.Ct <= 0 && this.gMC != null) {
                        this.Ct = this.gMC.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gMy.a(eVar);
                    a buM5 = a.buM();
                    if (buM5 == null || this.gMC == null || !this.gMC.jf()) {
                        return;
                    }
                    buM5.a(this.gMy);
                    return;
                }
                eVar.CL = String.valueOf(this.gMy.buP().responseCode) + "|retryCount:" + i4;
                z = aA(this.gMy.buP().responseCode);
                this.gMy.a(eVar);
                if (this.Ct <= 0 && this.gMC != null) {
                    this.Ct = this.gMC.jc();
                }
                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gMy.a(eVar);
                a buM6 = a.buM();
                if (buM6 != null && this.gMC != null && this.gMC.jf()) {
                    buM6.a(this.gMy);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ct <= 0 && this.gMC != null) {
                    this.Ct = this.gMC.jc();
                }
                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gMy.a(eVar);
                a buM7 = a.buM();
                if (buM7 != null && this.gMC != null && this.gMC.jf()) {
                    buM7.a(this.gMy);
                }
                throw th2;
            }
        }
    }

    private boolean aA(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void g(int i, int i2, int i3) {
        if (this.gMy.buO().jt()) {
            f(i, i2, i3);
        } else {
            h(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [467=7, 468=7, 470=7, 471=14, 472=7, 473=7, 474=7, 475=7, 477=5] */
    private void h(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.hn().hq().hr();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.hn().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.hn().ho().hr();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.gMy.buP().Dd && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.CE = i4;
            eVar.CI = i4 + 1;
            try {
                try {
                    try {
                        this.gMC = new b(this.gMy);
                        this.gMC.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.gMy.buP().De = -13;
                        z = true;
                        eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.gMy.a(eVar);
                        if (this.Ct <= 0 && this.gMC != null) {
                            this.Ct = this.gMC.jc();
                        }
                        eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                        this.gMy.a(eVar);
                        a buM = a.buM();
                        if (buM != null) {
                            buM.a(this.gMy);
                        }
                    } catch (Throwable th) {
                        this.gMy.buP().De = -10;
                        z = false;
                        eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.gMy.a(eVar);
                        if (this.Ct <= 0 && this.gMC != null) {
                            this.Ct = this.gMC.jc();
                        }
                        eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                        this.gMy.a(eVar);
                        a buM2 = a.buM();
                        if (buM2 != null) {
                            buM2.a(this.gMy);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.gMy.buP().De = -14;
                    eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.gMy.a(eVar);
                    if (this.Ct <= 0 && this.gMC != null) {
                        this.Ct = this.gMC.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gMy.a(eVar);
                    a buM3 = a.buM();
                    if (buM3 != null) {
                        buM3.a(this.gMy);
                    }
                } catch (SocketException e3) {
                    this.gMy.buP().De = -12;
                    z = true;
                    eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gMy.a(eVar);
                    if (this.Ct <= 0 && this.gMC != null) {
                        this.Ct = this.gMC.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gMy.a(eVar);
                    a buM4 = a.buM();
                    if (buM4 != null) {
                        buM4.a(this.gMy);
                    }
                }
                if (this.gMy.buP().responseCode == 200) {
                    if (this.Ct <= 0 && this.gMC != null) {
                        this.Ct = this.gMC.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gMy.a(eVar);
                    a buM5 = a.buM();
                    if (buM5 != null) {
                        buM5.a(this.gMy);
                        return;
                    }
                    return;
                }
                eVar.CL = String.valueOf(this.gMy.buP().responseCode) + "|retryCount:" + i4;
                z = aA(this.gMy.buP().responseCode);
                this.gMy.a(eVar);
                if (this.Ct <= 0 && this.gMC != null) {
                    this.Ct = this.gMC.jc();
                }
                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gMy.a(eVar);
                a buM6 = a.buM();
                if (buM6 != null) {
                    buM6.a(this.gMy);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ct <= 0 && this.gMC != null) {
                    this.Ct = this.gMC.jc();
                }
                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.gMy.buO().getUrl(), this.gMy.buO().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gMy.a(eVar);
                a buM7 = a.buM();
                if (buM7 != null) {
                    buM7.a(this.gMy);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.gMC != null) {
            this.gMC.jg();
        }
    }

    public boolean ji() {
        if (this.gMy == null) {
            return false;
        }
        return this.gMy.buP().Dd;
    }

    public void jj() {
        if (this.gMy != null) {
            this.gMy.buP().Dd = true;
        }
    }
}
