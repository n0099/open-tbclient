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
    private g gQt;
    private b gQx;

    public d(g gVar) {
        this.gQt = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int hr = i3 <= 0 ? com.baidu.adp.framework.c.b.hn().hq().hr() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.hn().getRetryCount();
        }
        int hr2 = i4 <= 0 ? com.baidu.adp.framework.c.b.hn().ho().hr() : i4;
        this.gQx = new b(this.gQt);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.CI = i5 + 1;
                this.CE = i5;
                boolean a = this.gQx.a(str, jVar, hr, hr2, z, eVar, z2);
                com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gQt.a(eVar);
                a bwh = a.bwh();
                if (bwh != null) {
                    bwh.a(this.gQt);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.gQt.bwk().responseCode = -100;
                    eVar.CL = String.valueOf(this.gQt.bwk().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.gQt.a(eVar);
                    com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gQt.a(eVar);
                    a bwh2 = a.bwh();
                    if (bwh2 != null) {
                        bwh2.a(this.gQt);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gQt.a(eVar);
                    a bwh3 = a.bwh();
                    if (bwh3 != null) {
                        bwh3.a(this.gQt);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.gQt.bwk().responseCode = -10;
                eVar.CL = String.valueOf(this.gQt.bwk().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.gQt.a(eVar);
                com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gQt.a(eVar);
                a bwh4 = a.bwh();
                if (bwh4 != null) {
                    bwh4.a(this.gQt);
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
        for (int i4 = 0; !this.gQt.bwk().Dd && z && i4 < i; i4++) {
            e eVar = new e();
            this.gQt.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.CE = i4;
                                eVar.CI = i4 + 1;
                                eVar.CU = 1;
                                this.gQx = new b(this.gQt);
                                this.gQx.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.gQt.bwk().De = -19;
                                eVar.CL = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Ct <= 0 && this.gQx != null) {
                                    this.Ct = this.gQx.jc();
                                }
                                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                                this.gQt.b(eVar);
                                a bwh = a.bwh();
                                if (bwh != null) {
                                    bwh.a(this.gQt);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.CL = String.valueOf(this.gQt.bwk().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.gQt.bwk().De = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Ct <= 0 && this.gQx != null) {
                                this.Ct = this.gQx.jc();
                            }
                            eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                            this.gQt.b(eVar);
                            a bwh2 = a.bwh();
                            if (bwh2 != null) {
                                bwh2.a(this.gQt);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.CL = String.valueOf(this.gQt.bwk().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.gQt.bwk().De = -13;
                        if (this.Ct <= 0 && this.gQx != null) {
                            this.Ct = this.gQx.jc();
                        }
                        eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                        this.gQt.b(eVar);
                        a bwh3 = a.bwh();
                        if (bwh3 != null) {
                            bwh3.a(this.gQt);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.CL = String.valueOf(this.gQt.bwk().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.gQt.bwk().De = -12;
                    if (this.Ct <= 0 && this.gQx != null) {
                        this.Ct = this.gQx.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gQt.b(eVar);
                    a bwh4 = a.bwh();
                    if (bwh4 != null) {
                        bwh4.a(this.gQt);
                    }
                    z = true;
                }
                if (this.gQt.bwk().responseCode == 200) {
                    this.gQt.b(eVar);
                    if (this.Ct <= 0 && this.gQx != null) {
                        this.Ct = this.gQx.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gQt.b(eVar);
                    a bwh5 = a.bwh();
                    if (bwh5 != null) {
                        bwh5.a(this.gQt);
                        return;
                    }
                    return;
                }
                eVar.CL = String.valueOf(this.gQt.bwk().responseCode) + "|retryCount:" + i4;
                boolean aA = aA(this.gQt.bwk().responseCode);
                if (this.Ct <= 0 && this.gQx != null) {
                    this.Ct = this.gQx.jc();
                }
                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gQt.b(eVar);
                a bwh6 = a.bwh();
                if (bwh6 != null) {
                    bwh6.a(this.gQt);
                }
                z = aA;
            } catch (Throwable th) {
                if (this.Ct <= 0 && this.gQx != null) {
                    this.Ct = this.gQx.jc();
                }
                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gQt.b(eVar);
                a bwh7 = a.bwh();
                if (bwh7 != null) {
                    bwh7.a(this.gQt);
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
        for (int i4 = 0; !this.gQt.bwk().Dd && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.CI = i4 + 1;
            this.CE = i4;
            try {
                try {
                    try {
                        this.gQx = new b(this.gQt);
                        this.gQx.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.gQt.bwk().De = -14;
                        eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.gQt.a(eVar);
                        if (this.Ct <= 0 && this.gQx != null) {
                            this.Ct = this.gQx.jc();
                        }
                        eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                        this.gQt.a(eVar);
                        a bwh = a.bwh();
                        if (bwh != null && this.gQx != null && this.gQx.jf()) {
                            bwh.a(this.gQt);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.gQt.bwk().De = -13;
                        z = true;
                        eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.gQt.a(eVar);
                        if (this.Ct <= 0 && this.gQx != null) {
                            this.Ct = this.gQx.jc();
                        }
                        eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                        this.gQt.a(eVar);
                        a bwh2 = a.bwh();
                        if (bwh2 != null && this.gQx != null && this.gQx.jf()) {
                            bwh2.a(this.gQt);
                        }
                    }
                } catch (SocketException e3) {
                    this.gQt.bwk().De = -12;
                    z = true;
                    eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gQt.a(eVar);
                    if (this.Ct <= 0 && this.gQx != null) {
                        this.Ct = this.gQx.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gQt.a(eVar);
                    a bwh3 = a.bwh();
                    if (bwh3 != null && this.gQx != null && this.gQx.jf()) {
                        bwh3.a(this.gQt);
                    }
                } catch (Throwable th) {
                    this.gQt.bwk().De = -10;
                    z = false;
                    eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.gQt.a(eVar);
                    if (this.Ct <= 0 && this.gQx != null) {
                        this.Ct = this.gQx.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gQt.a(eVar);
                    a bwh4 = a.bwh();
                    if (bwh4 != null && this.gQx != null && this.gQx.jf()) {
                        bwh4.a(this.gQt);
                    }
                }
                if (this.gQt.bwk().responseCode == 200) {
                    if (this.Ct <= 0 && this.gQx != null) {
                        this.Ct = this.gQx.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gQt.a(eVar);
                    a bwh5 = a.bwh();
                    if (bwh5 == null || this.gQx == null || !this.gQx.jf()) {
                        return;
                    }
                    bwh5.a(this.gQt);
                    return;
                }
                eVar.CL = String.valueOf(this.gQt.bwk().responseCode) + "|retryCount:" + i4;
                z = aA(this.gQt.bwk().responseCode);
                this.gQt.a(eVar);
                if (this.Ct <= 0 && this.gQx != null) {
                    this.Ct = this.gQx.jc();
                }
                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gQt.a(eVar);
                a bwh6 = a.bwh();
                if (bwh6 != null && this.gQx != null && this.gQx.jf()) {
                    bwh6.a(this.gQt);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ct <= 0 && this.gQx != null) {
                    this.Ct = this.gQx.jc();
                }
                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gQt.a(eVar);
                a bwh7 = a.bwh();
                if (bwh7 != null && this.gQx != null && this.gQx.jf()) {
                    bwh7.a(this.gQt);
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
        if (this.gQt.bwj().jt()) {
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
        for (int i4 = 0; !this.gQt.bwk().Dd && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.CE = i4;
            eVar.CI = i4 + 1;
            try {
                try {
                    try {
                        this.gQx = new b(this.gQt);
                        this.gQx.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.gQt.bwk().De = -13;
                        z = true;
                        eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.gQt.a(eVar);
                        if (this.Ct <= 0 && this.gQx != null) {
                            this.Ct = this.gQx.jc();
                        }
                        eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                        this.gQt.a(eVar);
                        a bwh = a.bwh();
                        if (bwh != null) {
                            bwh.a(this.gQt);
                        }
                    } catch (Throwable th) {
                        this.gQt.bwk().De = -10;
                        z = false;
                        eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.gQt.a(eVar);
                        if (this.Ct <= 0 && this.gQx != null) {
                            this.Ct = this.gQx.jc();
                        }
                        eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                        this.gQt.a(eVar);
                        a bwh2 = a.bwh();
                        if (bwh2 != null) {
                            bwh2.a(this.gQt);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.gQt.bwk().De = -14;
                    eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.gQt.a(eVar);
                    if (this.Ct <= 0 && this.gQx != null) {
                        this.Ct = this.gQx.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gQt.a(eVar);
                    a bwh3 = a.bwh();
                    if (bwh3 != null) {
                        bwh3.a(this.gQt);
                    }
                } catch (SocketException e3) {
                    this.gQt.bwk().De = -12;
                    z = true;
                    eVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gQt.a(eVar);
                    if (this.Ct <= 0 && this.gQx != null) {
                        this.Ct = this.gQx.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gQt.a(eVar);
                    a bwh4 = a.bwh();
                    if (bwh4 != null) {
                        bwh4.a(this.gQt);
                    }
                }
                if (this.gQt.bwk().responseCode == 200) {
                    if (this.Ct <= 0 && this.gQx != null) {
                        this.Ct = this.gQx.jc();
                    }
                    eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                    this.gQt.a(eVar);
                    a bwh5 = a.bwh();
                    if (bwh5 != null) {
                        bwh5.a(this.gQt);
                        return;
                    }
                    return;
                }
                eVar.CL = String.valueOf(this.gQt.bwk().responseCode) + "|retryCount:" + i4;
                z = aA(this.gQt.bwk().responseCode);
                this.gQt.a(eVar);
                if (this.Ct <= 0 && this.gQx != null) {
                    this.Ct = this.gQx.jc();
                }
                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gQt.a(eVar);
                a bwh6 = a.bwh();
                if (bwh6 != null) {
                    bwh6.a(this.gQt);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ct <= 0 && this.gQx != null) {
                    this.Ct = this.gQx.jc();
                }
                eVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.gQt.bwj().getUrl(), this.gQt.bwj().aQ("Host"), TextUtils.isEmpty(eVar.CL), eVar.CP != null);
                this.gQt.a(eVar);
                a bwh7 = a.bwh();
                if (bwh7 != null) {
                    bwh7.a(this.gQt);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.gQx != null) {
            this.gQx.jg();
        }
    }

    public boolean ji() {
        if (this.gQt == null) {
            return false;
        }
        return this.gQt.bwk().Dd;
    }

    public void jj() {
        if (this.gQt != null) {
            this.gQt.bwk().Dd = true;
        }
    }
}
