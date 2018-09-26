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
    private g gwG;
    private b gwK;
    private int BS = 0;
    private long BI = 0;

    public d(g gVar) {
        this.gwG = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int ha = i3 <= 0 ? com.baidu.adp.framework.c.b.gW().gZ().ha() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.gW().getRetryCount();
        }
        int ha2 = i4 <= 0 ? com.baidu.adp.framework.c.b.gW().gX().ha() : i4;
        this.gwK = new b(this.gwG);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.BW = i5 + 1;
                this.BS = i5;
                boolean a = this.gwK.a(str, jVar, ha, ha2, z, eVar, z2);
                com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                this.gwG.a(eVar);
                a bqj = a.bqj();
                if (bqj != null) {
                    bqj.a(this.gwG);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.gwG.bqm().responseCode = -100;
                    eVar.BZ = String.valueOf(this.gwG.bqm().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.gwG.a(eVar);
                    com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                    this.gwG.a(eVar);
                    a bqj2 = a.bqj();
                    if (bqj2 != null) {
                        bqj2.a(this.gwG);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                    this.gwG.a(eVar);
                    a bqj3 = a.bqj();
                    if (bqj3 != null) {
                        bqj3.a(this.gwG);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.gwG.bqm().responseCode = -10;
                eVar.BZ = String.valueOf(this.gwG.bqm().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.gwG.a(eVar);
                com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                this.gwG.a(eVar);
                a bqj4 = a.bqj();
                if (bqj4 != null) {
                    bqj4.a(this.gwG);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void e(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.gW().gZ().ha();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.gW().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.gW().gX().ha();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.gwG.bqm().Cp && z && i4 < i; i4++) {
            e eVar = new e();
            this.gwG.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.BS = i4;
                                eVar.BW = i4 + 1;
                                eVar.Cg = 1;
                                this.gwK = new b(this.gwG);
                                this.gwK.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.gwG.bqm().Cq = -19;
                                eVar.BZ = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.BI <= 0 && this.gwK != null) {
                                    this.BI = this.gwK.iP();
                                }
                                eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                                this.gwG.b(eVar);
                                a bqj = a.bqj();
                                if (bqj != null) {
                                    bqj.a(this.gwG);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.BZ = String.valueOf(this.gwG.bqm().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.gwG.bqm().Cq = -10;
                            BdLog.e(e2.getMessage());
                            if (this.BI <= 0 && this.gwK != null) {
                                this.BI = this.gwK.iP();
                            }
                            eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                            this.gwG.b(eVar);
                            a bqj2 = a.bqj();
                            if (bqj2 != null) {
                                bqj2.a(this.gwG);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.BZ = String.valueOf(this.gwG.bqm().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.gwG.bqm().Cq = -13;
                        if (this.BI <= 0 && this.gwK != null) {
                            this.BI = this.gwK.iP();
                        }
                        eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                        this.gwG.b(eVar);
                        a bqj3 = a.bqj();
                        if (bqj3 != null) {
                            bqj3.a(this.gwG);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.BZ = String.valueOf(this.gwG.bqm().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.gwG.bqm().Cq = -12;
                    if (this.BI <= 0 && this.gwK != null) {
                        this.BI = this.gwK.iP();
                    }
                    eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                    this.gwG.b(eVar);
                    a bqj4 = a.bqj();
                    if (bqj4 != null) {
                        bqj4.a(this.gwG);
                    }
                    z = true;
                }
                if (this.gwG.bqm().responseCode == 200) {
                    this.gwG.b(eVar);
                    if (this.BI <= 0 && this.gwK != null) {
                        this.BI = this.gwK.iP();
                    }
                    eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                    this.gwG.b(eVar);
                    a bqj5 = a.bqj();
                    if (bqj5 != null) {
                        bqj5.a(this.gwG);
                        return;
                    }
                    return;
                }
                eVar.BZ = String.valueOf(this.gwG.bqm().responseCode) + "|retryCount:" + i4;
                boolean aj = aj(this.gwG.bqm().responseCode);
                if (this.BI <= 0 && this.gwK != null) {
                    this.BI = this.gwK.iP();
                }
                eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                this.gwG.b(eVar);
                a bqj6 = a.bqj();
                if (bqj6 != null) {
                    bqj6.a(this.gwG);
                }
                z = aj;
            } catch (Throwable th) {
                if (this.BI <= 0 && this.gwK != null) {
                    this.BI = this.gwK.iP();
                }
                eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                this.gwG.b(eVar);
                a bqj7 = a.bqj();
                if (bqj7 != null) {
                    bqj7.a(this.gwG);
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
            i2 = com.baidu.adp.framework.c.b.gW().gZ().ha();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.gW().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.gW().gX().ha();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.gwG.bqm().Cp && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.BW = i4 + 1;
            this.BS = i4;
            try {
                try {
                    try {
                        this.gwK = new b(this.gwG);
                        this.gwK.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.gwG.bqm().Cq = -14;
                        eVar.BZ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.gwG.a(eVar);
                        if (this.BI <= 0 && this.gwK != null) {
                            this.BI = this.gwK.iP();
                        }
                        eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                        this.gwG.a(eVar);
                        a bqj = a.bqj();
                        if (bqj != null && this.gwK != null && this.gwK.iS()) {
                            bqj.a(this.gwG);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.gwG.bqm().Cq = -13;
                        z = true;
                        eVar.BZ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.gwG.a(eVar);
                        if (this.BI <= 0 && this.gwK != null) {
                            this.BI = this.gwK.iP();
                        }
                        eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                        this.gwG.a(eVar);
                        a bqj2 = a.bqj();
                        if (bqj2 != null && this.gwK != null && this.gwK.iS()) {
                            bqj2.a(this.gwG);
                        }
                    }
                } catch (SocketException e3) {
                    this.gwG.bqm().Cq = -12;
                    z = true;
                    eVar.BZ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gwG.a(eVar);
                    if (this.BI <= 0 && this.gwK != null) {
                        this.BI = this.gwK.iP();
                    }
                    eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                    this.gwG.a(eVar);
                    a bqj3 = a.bqj();
                    if (bqj3 != null && this.gwK != null && this.gwK.iS()) {
                        bqj3.a(this.gwG);
                    }
                } catch (Throwable th) {
                    this.gwG.bqm().Cq = -10;
                    z = false;
                    eVar.BZ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.gwG.a(eVar);
                    if (this.BI <= 0 && this.gwK != null) {
                        this.BI = this.gwK.iP();
                    }
                    eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                    this.gwG.a(eVar);
                    a bqj4 = a.bqj();
                    if (bqj4 != null && this.gwK != null && this.gwK.iS()) {
                        bqj4.a(this.gwG);
                    }
                }
                if (this.gwG.bqm().responseCode == 200) {
                    if (this.BI <= 0 && this.gwK != null) {
                        this.BI = this.gwK.iP();
                    }
                    eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                    this.gwG.a(eVar);
                    a bqj5 = a.bqj();
                    if (bqj5 == null || this.gwK == null || !this.gwK.iS()) {
                        return;
                    }
                    bqj5.a(this.gwG);
                    return;
                }
                eVar.BZ = String.valueOf(this.gwG.bqm().responseCode) + "|retryCount:" + i4;
                z = aj(this.gwG.bqm().responseCode);
                this.gwG.a(eVar);
                if (this.BI <= 0 && this.gwK != null) {
                    this.BI = this.gwK.iP();
                }
                eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                this.gwG.a(eVar);
                a bqj6 = a.bqj();
                if (bqj6 != null && this.gwK != null && this.gwK.iS()) {
                    bqj6.a(this.gwG);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.BI <= 0 && this.gwK != null) {
                    this.BI = this.gwK.iP();
                }
                eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                this.gwG.a(eVar);
                a bqj7 = a.bqj();
                if (bqj7 != null && this.gwK != null && this.gwK.iS()) {
                    bqj7.a(this.gwG);
                }
                throw th2;
            }
        }
    }

    private boolean aj(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void g(int i, int i2, int i3) {
        if (this.gwG.bql().jg()) {
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
            i2 = com.baidu.adp.framework.c.b.gW().gZ().ha();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.gW().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.gW().gX().ha();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.gwG.bqm().Cp && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.BS = i4;
            eVar.BW = i4 + 1;
            try {
                try {
                    try {
                        this.gwK = new b(this.gwG);
                        this.gwK.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.gwG.bqm().Cq = -13;
                        z = true;
                        eVar.BZ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.gwG.a(eVar);
                        if (this.BI <= 0 && this.gwK != null) {
                            this.BI = this.gwK.iP();
                        }
                        eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                        this.gwG.a(eVar);
                        a bqj = a.bqj();
                        if (bqj != null) {
                            bqj.a(this.gwG);
                        }
                    } catch (Throwable th) {
                        this.gwG.bqm().Cq = -10;
                        z = false;
                        eVar.BZ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.gwG.a(eVar);
                        if (this.BI <= 0 && this.gwK != null) {
                            this.BI = this.gwK.iP();
                        }
                        eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                        this.gwG.a(eVar);
                        a bqj2 = a.bqj();
                        if (bqj2 != null) {
                            bqj2.a(this.gwG);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.gwG.bqm().Cq = -14;
                    eVar.BZ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.gwG.a(eVar);
                    if (this.BI <= 0 && this.gwK != null) {
                        this.BI = this.gwK.iP();
                    }
                    eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                    this.gwG.a(eVar);
                    a bqj3 = a.bqj();
                    if (bqj3 != null) {
                        bqj3.a(this.gwG);
                    }
                } catch (SocketException e3) {
                    this.gwG.bqm().Cq = -12;
                    z = true;
                    eVar.BZ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gwG.a(eVar);
                    if (this.BI <= 0 && this.gwK != null) {
                        this.BI = this.gwK.iP();
                    }
                    eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                    this.gwG.a(eVar);
                    a bqj4 = a.bqj();
                    if (bqj4 != null) {
                        bqj4.a(this.gwG);
                    }
                }
                if (this.gwG.bqm().responseCode == 200) {
                    if (this.BI <= 0 && this.gwK != null) {
                        this.BI = this.gwK.iP();
                    }
                    eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                    this.gwG.a(eVar);
                    a bqj5 = a.bqj();
                    if (bqj5 != null) {
                        bqj5.a(this.gwG);
                        return;
                    }
                    return;
                }
                eVar.BZ = String.valueOf(this.gwG.bqm().responseCode) + "|retryCount:" + i4;
                z = aj(this.gwG.bqm().responseCode);
                this.gwG.a(eVar);
                if (this.BI <= 0 && this.gwK != null) {
                    this.BI = this.gwK.iP();
                }
                eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                this.gwG.a(eVar);
                a bqj6 = a.bqj();
                if (bqj6 != null) {
                    bqj6.a(this.gwG);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.BI <= 0 && this.gwK != null) {
                    this.BI = this.gwK.iP();
                }
                eVar.BX = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iq().a(this.gwG.bql().getUrl(), this.gwG.bql().aQ("Host"), TextUtils.isEmpty(eVar.BZ), eVar.Cd != null);
                this.gwG.a(eVar);
                a bqj7 = a.bqj();
                if (bqj7 != null) {
                    bqj7.a(this.gwG);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.gwK != null) {
            this.gwK.iT();
        }
    }

    public boolean iV() {
        if (this.gwG == null) {
            return false;
        }
        return this.gwG.bqm().Cp;
    }

    public void iW() {
        if (this.gwG != null) {
            this.gwG.bqm().Cp = true;
        }
    }
}
