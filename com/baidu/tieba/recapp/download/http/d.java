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
    private g gpo;
    private b gps;
    private int zx = 0;
    private long zn = 0;

    public d(g gVar) {
        this.gpo = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int fS = i3 <= 0 ? com.baidu.adp.framework.c.b.fO().fR().fS() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fO().getRetryCount();
        }
        int fS2 = i4 <= 0 ? com.baidu.adp.framework.c.b.fO().fP().fS() : i4;
        this.gps = new b(this.gpo);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.zB = i5 + 1;
                this.zx = i5;
                boolean a = this.gps.a(str, jVar, fS, fS2, z, eVar, z2);
                com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                this.gpo.a(eVar);
                a bnC = a.bnC();
                if (bnC != null) {
                    bnC.a(this.gpo);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.gpo.bnF().responseCode = -100;
                    eVar.zE = String.valueOf(this.gpo.bnF().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.gpo.a(eVar);
                    com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                    this.gpo.a(eVar);
                    a bnC2 = a.bnC();
                    if (bnC2 != null) {
                        bnC2.a(this.gpo);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                    this.gpo.a(eVar);
                    a bnC3 = a.bnC();
                    if (bnC3 != null) {
                        bnC3.a(this.gpo);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.gpo.bnF().responseCode = -10;
                eVar.zE = String.valueOf(this.gpo.bnF().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.gpo.a(eVar);
                com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                this.gpo.a(eVar);
                a bnC4 = a.bnC();
                if (bnC4 != null) {
                    bnC4.a(this.gpo);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.fO().fR().fS();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fO().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fO().fP().fS();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.gpo.bnF().zU && z && i4 < i; i4++) {
            e eVar = new e();
            this.gpo.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.zx = i4;
                                eVar.zB = i4 + 1;
                                eVar.zL = 1;
                                this.gps = new b(this.gpo);
                                this.gps.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.gpo.bnF().zV = -19;
                                eVar.zE = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.zn <= 0 && this.gps != null) {
                                    this.zn = this.gps.hJ();
                                }
                                eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                                this.gpo.b(eVar);
                                a bnC = a.bnC();
                                if (bnC != null) {
                                    bnC.a(this.gpo);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.zE = String.valueOf(this.gpo.bnF().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.gpo.bnF().zV = -10;
                            BdLog.e(e2.getMessage());
                            if (this.zn <= 0 && this.gps != null) {
                                this.zn = this.gps.hJ();
                            }
                            eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                            this.gpo.b(eVar);
                            a bnC2 = a.bnC();
                            if (bnC2 != null) {
                                bnC2.a(this.gpo);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.zE = String.valueOf(this.gpo.bnF().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.gpo.bnF().zV = -13;
                        if (this.zn <= 0 && this.gps != null) {
                            this.zn = this.gps.hJ();
                        }
                        eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                        this.gpo.b(eVar);
                        a bnC3 = a.bnC();
                        if (bnC3 != null) {
                            bnC3.a(this.gpo);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.zE = String.valueOf(this.gpo.bnF().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.gpo.bnF().zV = -12;
                    if (this.zn <= 0 && this.gps != null) {
                        this.zn = this.gps.hJ();
                    }
                    eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                    this.gpo.b(eVar);
                    a bnC4 = a.bnC();
                    if (bnC4 != null) {
                        bnC4.a(this.gpo);
                    }
                    z = true;
                }
                if (this.gpo.bnF().responseCode == 200) {
                    this.gpo.b(eVar);
                    if (this.zn <= 0 && this.gps != null) {
                        this.zn = this.gps.hJ();
                    }
                    eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                    this.gpo.b(eVar);
                    a bnC5 = a.bnC();
                    if (bnC5 != null) {
                        bnC5.a(this.gpo);
                        return;
                    }
                    return;
                }
                eVar.zE = String.valueOf(this.gpo.bnF().responseCode) + "|retryCount:" + i4;
                boolean ab = ab(this.gpo.bnF().responseCode);
                if (this.zn <= 0 && this.gps != null) {
                    this.zn = this.gps.hJ();
                }
                eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                this.gpo.b(eVar);
                a bnC6 = a.bnC();
                if (bnC6 != null) {
                    bnC6.a(this.gpo);
                }
                z = ab;
            } catch (Throwable th) {
                if (this.zn <= 0 && this.gps != null) {
                    this.zn = this.gps.hJ();
                }
                eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                this.gpo.b(eVar);
                a bnC7 = a.bnC();
                if (bnC7 != null) {
                    bnC7.a(this.gpo);
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
            i2 = com.baidu.adp.framework.c.b.fO().fR().fS();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fO().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fO().fP().fS();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.gpo.bnF().zU && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.zB = i4 + 1;
            this.zx = i4;
            try {
                try {
                    try {
                        this.gps = new b(this.gpo);
                        this.gps.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.gpo.bnF().zV = -14;
                        eVar.zE = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.gpo.a(eVar);
                        if (this.zn <= 0 && this.gps != null) {
                            this.zn = this.gps.hJ();
                        }
                        eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                        this.gpo.a(eVar);
                        a bnC = a.bnC();
                        if (bnC != null && this.gps != null && this.gps.hM()) {
                            bnC.a(this.gpo);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.gpo.bnF().zV = -13;
                        z = true;
                        eVar.zE = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.gpo.a(eVar);
                        if (this.zn <= 0 && this.gps != null) {
                            this.zn = this.gps.hJ();
                        }
                        eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                        this.gpo.a(eVar);
                        a bnC2 = a.bnC();
                        if (bnC2 != null && this.gps != null && this.gps.hM()) {
                            bnC2.a(this.gpo);
                        }
                    }
                } catch (SocketException e3) {
                    this.gpo.bnF().zV = -12;
                    z = true;
                    eVar.zE = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gpo.a(eVar);
                    if (this.zn <= 0 && this.gps != null) {
                        this.zn = this.gps.hJ();
                    }
                    eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                    this.gpo.a(eVar);
                    a bnC3 = a.bnC();
                    if (bnC3 != null && this.gps != null && this.gps.hM()) {
                        bnC3.a(this.gpo);
                    }
                } catch (Throwable th) {
                    this.gpo.bnF().zV = -10;
                    z = false;
                    eVar.zE = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.gpo.a(eVar);
                    if (this.zn <= 0 && this.gps != null) {
                        this.zn = this.gps.hJ();
                    }
                    eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                    this.gpo.a(eVar);
                    a bnC4 = a.bnC();
                    if (bnC4 != null && this.gps != null && this.gps.hM()) {
                        bnC4.a(this.gpo);
                    }
                }
                if (this.gpo.bnF().responseCode == 200) {
                    if (this.zn <= 0 && this.gps != null) {
                        this.zn = this.gps.hJ();
                    }
                    eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                    this.gpo.a(eVar);
                    a bnC5 = a.bnC();
                    if (bnC5 == null || this.gps == null || !this.gps.hM()) {
                        return;
                    }
                    bnC5.a(this.gpo);
                    return;
                }
                eVar.zE = String.valueOf(this.gpo.bnF().responseCode) + "|retryCount:" + i4;
                z = ab(this.gpo.bnF().responseCode);
                this.gpo.a(eVar);
                if (this.zn <= 0 && this.gps != null) {
                    this.zn = this.gps.hJ();
                }
                eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                this.gpo.a(eVar);
                a bnC6 = a.bnC();
                if (bnC6 != null && this.gps != null && this.gps.hM()) {
                    bnC6.a(this.gpo);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.zn <= 0 && this.gps != null) {
                    this.zn = this.gps.hJ();
                }
                eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                this.gpo.a(eVar);
                a bnC7 = a.bnC();
                if (bnC7 != null && this.gps != null && this.gps.hM()) {
                    bnC7.a(this.gpo);
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
        if (this.gpo.bnE().ia()) {
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
            i2 = com.baidu.adp.framework.c.b.fO().fR().fS();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fO().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fO().fP().fS();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.gpo.bnF().zU && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.zx = i4;
            eVar.zB = i4 + 1;
            try {
                try {
                    try {
                        this.gps = new b(this.gpo);
                        this.gps.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.gpo.bnF().zV = -13;
                        z = true;
                        eVar.zE = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.gpo.a(eVar);
                        if (this.zn <= 0 && this.gps != null) {
                            this.zn = this.gps.hJ();
                        }
                        eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                        this.gpo.a(eVar);
                        a bnC = a.bnC();
                        if (bnC != null) {
                            bnC.a(this.gpo);
                        }
                    } catch (Throwable th) {
                        this.gpo.bnF().zV = -10;
                        z = false;
                        eVar.zE = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.gpo.a(eVar);
                        if (this.zn <= 0 && this.gps != null) {
                            this.zn = this.gps.hJ();
                        }
                        eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                        this.gpo.a(eVar);
                        a bnC2 = a.bnC();
                        if (bnC2 != null) {
                            bnC2.a(this.gpo);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.gpo.bnF().zV = -14;
                    eVar.zE = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.gpo.a(eVar);
                    if (this.zn <= 0 && this.gps != null) {
                        this.zn = this.gps.hJ();
                    }
                    eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                    this.gpo.a(eVar);
                    a bnC3 = a.bnC();
                    if (bnC3 != null) {
                        bnC3.a(this.gpo);
                    }
                } catch (SocketException e3) {
                    this.gpo.bnF().zV = -12;
                    z = true;
                    eVar.zE = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gpo.a(eVar);
                    if (this.zn <= 0 && this.gps != null) {
                        this.zn = this.gps.hJ();
                    }
                    eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                    this.gpo.a(eVar);
                    a bnC4 = a.bnC();
                    if (bnC4 != null) {
                        bnC4.a(this.gpo);
                    }
                }
                if (this.gpo.bnF().responseCode == 200) {
                    if (this.zn <= 0 && this.gps != null) {
                        this.zn = this.gps.hJ();
                    }
                    eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                    this.gpo.a(eVar);
                    a bnC5 = a.bnC();
                    if (bnC5 != null) {
                        bnC5.a(this.gpo);
                        return;
                    }
                    return;
                }
                eVar.zE = String.valueOf(this.gpo.bnF().responseCode) + "|retryCount:" + i4;
                z = ab(this.gpo.bnF().responseCode);
                this.gpo.a(eVar);
                if (this.zn <= 0 && this.gps != null) {
                    this.zn = this.gps.hJ();
                }
                eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                this.gpo.a(eVar);
                a bnC6 = a.bnC();
                if (bnC6 != null) {
                    bnC6.a(this.gpo);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.zn <= 0 && this.gps != null) {
                    this.zn = this.gps.hJ();
                }
                eVar.zC = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.gpo.bnE().getUrl(), this.gpo.bnE().az("Host"), TextUtils.isEmpty(eVar.zE), eVar.zI != null);
                this.gpo.a(eVar);
                a bnC7 = a.bnC();
                if (bnC7 != null) {
                    bnC7.a(this.gpo);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.gps != null) {
            this.gps.hN();
        }
    }

    public boolean hP() {
        if (this.gpo == null) {
            return false;
        }
        return this.gpo.bnF().zU;
    }

    public void hQ() {
        if (this.gpo != null) {
            this.gpo.bnF().zU = true;
        }
    }
}
