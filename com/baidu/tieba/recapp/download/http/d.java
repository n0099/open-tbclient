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
                com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gMy.a(eVar);
                a buN = a.buN();
                if (buN != null) {
                    buN.a(this.gMy);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.gMy.buQ().responseCode = -100;
                    eVar.CL = String.valueOf(this.gMy.buQ().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.gMy.a(eVar);
                    com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gMy.a(eVar);
                    a buN2 = a.buN();
                    if (buN2 != null) {
                        buN2.a(this.gMy);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gMy.a(eVar);
                    a buN3 = a.buN();
                    if (buN3 != null) {
                        buN3.a(this.gMy);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.gMy.buQ().responseCode = -10;
                eVar.CL = String.valueOf(this.gMy.buQ().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.gMy.a(eVar);
                com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gMy.a(eVar);
                a buN4 = a.buN();
                if (buN4 != null) {
                    buN4.a(this.gMy);
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
        for (int i4 = 0; !this.gMy.buQ().Dd && z && i4 < i; i4++) {
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
                                this.gMy.buQ().De = -19;
                                eVar.CL = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Ct <= 0 && this.gMC != null) {
                                    this.Ct = this.gMC.jc();
                                }
                                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                                this.gMy.b(eVar);
                                a buN = a.buN();
                                if (buN != null) {
                                    buN.a(this.gMy);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.CL = String.valueOf(this.gMy.buQ().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.gMy.buQ().De = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Ct <= 0 && this.gMC != null) {
                                this.Ct = this.gMC.jc();
                            }
                            eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                            this.gMy.b(eVar);
                            a buN2 = a.buN();
                            if (buN2 != null) {
                                buN2.a(this.gMy);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.CL = String.valueOf(this.gMy.buQ().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.gMy.buQ().De = -13;
                        if (this.Ct <= 0 && this.gMC != null) {
                            this.Ct = this.gMC.jc();
                        }
                        eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                        this.gMy.b(eVar);
                        a buN3 = a.buN();
                        if (buN3 != null) {
                            buN3.a(this.gMy);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.CL = String.valueOf(this.gMy.buQ().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.gMy.buQ().De = -12;
                    if (this.Ct <= 0 && this.gMC != null) {
                        this.Ct = this.gMC.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gMy.b(eVar);
                    a buN4 = a.buN();
                    if (buN4 != null) {
                        buN4.a(this.gMy);
                    }
                    z = true;
                }
                if (this.gMy.buQ().responseCode == 200) {
                    this.gMy.b(eVar);
                    if (this.Ct <= 0 && this.gMC != null) {
                        this.Ct = this.gMC.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gMy.b(eVar);
                    a buN5 = a.buN();
                    if (buN5 != null) {
                        buN5.a(this.gMy);
                        return;
                    }
                    return;
                }
                eVar.CL = String.valueOf(this.gMy.buQ().responseCode) + "|retryCount:" + i4;
                boolean aA = aA(this.gMy.buQ().responseCode);
                if (this.Ct <= 0 && this.gMC != null) {
                    this.Ct = this.gMC.jc();
                }
                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gMy.b(eVar);
                a buN6 = a.buN();
                if (buN6 != null) {
                    buN6.a(this.gMy);
                }
                z = aA;
            } catch (Throwable th) {
                if (this.Ct <= 0 && this.gMC != null) {
                    this.Ct = this.gMC.jc();
                }
                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gMy.b(eVar);
                a buN7 = a.buN();
                if (buN7 != null) {
                    buN7.a(this.gMy);
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
        for (int i4 = 0; !this.gMy.buQ().Dd && z2 && i4 < i; i4++) {
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
                        this.gMy.buQ().De = -14;
                        eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.gMy.a(eVar);
                        if (this.Ct <= 0 && this.gMC != null) {
                            this.Ct = this.gMC.jc();
                        }
                        eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                        this.gMy.a(eVar);
                        a buN = a.buN();
                        if (buN != null && this.gMC != null && this.gMC.jf()) {
                            buN.a(this.gMy);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.gMy.buQ().De = -13;
                        z = true;
                        eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.gMy.a(eVar);
                        if (this.Ct <= 0 && this.gMC != null) {
                            this.Ct = this.gMC.jc();
                        }
                        eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                        this.gMy.a(eVar);
                        a buN2 = a.buN();
                        if (buN2 != null && this.gMC != null && this.gMC.jf()) {
                            buN2.a(this.gMy);
                        }
                    }
                } catch (SocketException e3) {
                    this.gMy.buQ().De = -12;
                    z = true;
                    eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gMy.a(eVar);
                    if (this.Ct <= 0 && this.gMC != null) {
                        this.Ct = this.gMC.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gMy.a(eVar);
                    a buN3 = a.buN();
                    if (buN3 != null && this.gMC != null && this.gMC.jf()) {
                        buN3.a(this.gMy);
                    }
                } catch (Throwable th) {
                    this.gMy.buQ().De = -10;
                    z = false;
                    eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.gMy.a(eVar);
                    if (this.Ct <= 0 && this.gMC != null) {
                        this.Ct = this.gMC.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gMy.a(eVar);
                    a buN4 = a.buN();
                    if (buN4 != null && this.gMC != null && this.gMC.jf()) {
                        buN4.a(this.gMy);
                    }
                }
                if (this.gMy.buQ().responseCode == 200) {
                    if (this.Ct <= 0 && this.gMC != null) {
                        this.Ct = this.gMC.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gMy.a(eVar);
                    a buN5 = a.buN();
                    if (buN5 == null || this.gMC == null || !this.gMC.jf()) {
                        return;
                    }
                    buN5.a(this.gMy);
                    return;
                }
                eVar.CL = String.valueOf(this.gMy.buQ().responseCode) + "|retryCount:" + i4;
                z = aA(this.gMy.buQ().responseCode);
                this.gMy.a(eVar);
                if (this.Ct <= 0 && this.gMC != null) {
                    this.Ct = this.gMC.jc();
                }
                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gMy.a(eVar);
                a buN6 = a.buN();
                if (buN6 != null && this.gMC != null && this.gMC.jf()) {
                    buN6.a(this.gMy);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ct <= 0 && this.gMC != null) {
                    this.Ct = this.gMC.jc();
                }
                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gMy.a(eVar);
                a buN7 = a.buN();
                if (buN7 != null && this.gMC != null && this.gMC.jf()) {
                    buN7.a(this.gMy);
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
        if (this.gMy.buP().jt()) {
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
        for (int i4 = 0; !this.gMy.buQ().Dd && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.CE = i4;
            eVar.CI = i4 + 1;
            try {
                try {
                    try {
                        this.gMC = new b(this.gMy);
                        this.gMC.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.gMy.buQ().De = -13;
                        z = true;
                        eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.gMy.a(eVar);
                        if (this.Ct <= 0 && this.gMC != null) {
                            this.Ct = this.gMC.jc();
                        }
                        eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                        this.gMy.a(eVar);
                        a buN = a.buN();
                        if (buN != null) {
                            buN.a(this.gMy);
                        }
                    } catch (Throwable th) {
                        this.gMy.buQ().De = -10;
                        z = false;
                        eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.gMy.a(eVar);
                        if (this.Ct <= 0 && this.gMC != null) {
                            this.Ct = this.gMC.jc();
                        }
                        eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                        this.gMy.a(eVar);
                        a buN2 = a.buN();
                        if (buN2 != null) {
                            buN2.a(this.gMy);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.gMy.buQ().De = -14;
                    eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.gMy.a(eVar);
                    if (this.Ct <= 0 && this.gMC != null) {
                        this.Ct = this.gMC.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gMy.a(eVar);
                    a buN3 = a.buN();
                    if (buN3 != null) {
                        buN3.a(this.gMy);
                    }
                } catch (SocketException e3) {
                    this.gMy.buQ().De = -12;
                    z = true;
                    eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gMy.a(eVar);
                    if (this.Ct <= 0 && this.gMC != null) {
                        this.Ct = this.gMC.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gMy.a(eVar);
                    a buN4 = a.buN();
                    if (buN4 != null) {
                        buN4.a(this.gMy);
                    }
                }
                if (this.gMy.buQ().responseCode == 200) {
                    if (this.Ct <= 0 && this.gMC != null) {
                        this.Ct = this.gMC.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gMy.a(eVar);
                    a buN5 = a.buN();
                    if (buN5 != null) {
                        buN5.a(this.gMy);
                        return;
                    }
                    return;
                }
                eVar.CL = String.valueOf(this.gMy.buQ().responseCode) + "|retryCount:" + i4;
                z = aA(this.gMy.buQ().responseCode);
                this.gMy.a(eVar);
                if (this.Ct <= 0 && this.gMC != null) {
                    this.Ct = this.gMC.jc();
                }
                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gMy.a(eVar);
                a buN6 = a.buN();
                if (buN6 != null) {
                    buN6.a(this.gMy);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ct <= 0 && this.gMC != null) {
                    this.Ct = this.gMC.jc();
                }
                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.gMy.buP().getUrl(), this.gMy.buP().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gMy.a(eVar);
                a buN7 = a.buN();
                if (buN7 != null) {
                    buN7.a(this.gMy);
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
        return this.gMy.buQ().Dd;
    }

    public void jj() {
        if (this.gMy != null) {
            this.gMy.buQ().Dd = true;
        }
    }
}
