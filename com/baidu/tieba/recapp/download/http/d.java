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
    private g gpl;
    private b gpp;
    private int zw = 0;
    private long zm = 0;

    public d(g gVar) {
        this.gpl = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int fS = i3 <= 0 ? com.baidu.adp.framework.c.b.fO().fR().fS() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fO().getRetryCount();
        }
        int fS2 = i4 <= 0 ? com.baidu.adp.framework.c.b.fO().fP().fS() : i4;
        this.gpp = new b(this.gpl);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.zA = i5 + 1;
                this.zw = i5;
                boolean a = this.gpp.a(str, jVar, fS, fS2, z, eVar, z2);
                com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                this.gpl.a(eVar);
                a bnB = a.bnB();
                if (bnB != null) {
                    bnB.a(this.gpl);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.gpl.bnE().responseCode = -100;
                    eVar.zD = String.valueOf(this.gpl.bnE().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.gpl.a(eVar);
                    com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                    this.gpl.a(eVar);
                    a bnB2 = a.bnB();
                    if (bnB2 != null) {
                        bnB2.a(this.gpl);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                    this.gpl.a(eVar);
                    a bnB3 = a.bnB();
                    if (bnB3 != null) {
                        bnB3.a(this.gpl);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.gpl.bnE().responseCode = -10;
                eVar.zD = String.valueOf(this.gpl.bnE().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.gpl.a(eVar);
                com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                this.gpl.a(eVar);
                a bnB4 = a.bnB();
                if (bnB4 != null) {
                    bnB4.a(this.gpl);
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
        for (int i4 = 0; !this.gpl.bnE().zT && z && i4 < i; i4++) {
            e eVar = new e();
            this.gpl.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.zw = i4;
                                eVar.zA = i4 + 1;
                                eVar.zK = 1;
                                this.gpp = new b(this.gpl);
                                this.gpp.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.gpl.bnE().zU = -19;
                                eVar.zD = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.zm <= 0 && this.gpp != null) {
                                    this.zm = this.gpp.hJ();
                                }
                                eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                                this.gpl.b(eVar);
                                a bnB = a.bnB();
                                if (bnB != null) {
                                    bnB.a(this.gpl);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.zD = String.valueOf(this.gpl.bnE().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.gpl.bnE().zU = -10;
                            BdLog.e(e2.getMessage());
                            if (this.zm <= 0 && this.gpp != null) {
                                this.zm = this.gpp.hJ();
                            }
                            eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                            this.gpl.b(eVar);
                            a bnB2 = a.bnB();
                            if (bnB2 != null) {
                                bnB2.a(this.gpl);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.zD = String.valueOf(this.gpl.bnE().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.gpl.bnE().zU = -13;
                        if (this.zm <= 0 && this.gpp != null) {
                            this.zm = this.gpp.hJ();
                        }
                        eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                        this.gpl.b(eVar);
                        a bnB3 = a.bnB();
                        if (bnB3 != null) {
                            bnB3.a(this.gpl);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.zD = String.valueOf(this.gpl.bnE().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.gpl.bnE().zU = -12;
                    if (this.zm <= 0 && this.gpp != null) {
                        this.zm = this.gpp.hJ();
                    }
                    eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                    this.gpl.b(eVar);
                    a bnB4 = a.bnB();
                    if (bnB4 != null) {
                        bnB4.a(this.gpl);
                    }
                    z = true;
                }
                if (this.gpl.bnE().responseCode == 200) {
                    this.gpl.b(eVar);
                    if (this.zm <= 0 && this.gpp != null) {
                        this.zm = this.gpp.hJ();
                    }
                    eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                    this.gpl.b(eVar);
                    a bnB5 = a.bnB();
                    if (bnB5 != null) {
                        bnB5.a(this.gpl);
                        return;
                    }
                    return;
                }
                eVar.zD = String.valueOf(this.gpl.bnE().responseCode) + "|retryCount:" + i4;
                boolean ab = ab(this.gpl.bnE().responseCode);
                if (this.zm <= 0 && this.gpp != null) {
                    this.zm = this.gpp.hJ();
                }
                eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                this.gpl.b(eVar);
                a bnB6 = a.bnB();
                if (bnB6 != null) {
                    bnB6.a(this.gpl);
                }
                z = ab;
            } catch (Throwable th) {
                if (this.zm <= 0 && this.gpp != null) {
                    this.zm = this.gpp.hJ();
                }
                eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                this.gpl.b(eVar);
                a bnB7 = a.bnB();
                if (bnB7 != null) {
                    bnB7.a(this.gpl);
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
        for (int i4 = 0; !this.gpl.bnE().zT && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.zA = i4 + 1;
            this.zw = i4;
            try {
                try {
                    try {
                        this.gpp = new b(this.gpl);
                        this.gpp.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.gpl.bnE().zU = -14;
                        eVar.zD = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.gpl.a(eVar);
                        if (this.zm <= 0 && this.gpp != null) {
                            this.zm = this.gpp.hJ();
                        }
                        eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                        this.gpl.a(eVar);
                        a bnB = a.bnB();
                        if (bnB != null && this.gpp != null && this.gpp.hM()) {
                            bnB.a(this.gpl);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.gpl.bnE().zU = -13;
                        z = true;
                        eVar.zD = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.gpl.a(eVar);
                        if (this.zm <= 0 && this.gpp != null) {
                            this.zm = this.gpp.hJ();
                        }
                        eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                        this.gpl.a(eVar);
                        a bnB2 = a.bnB();
                        if (bnB2 != null && this.gpp != null && this.gpp.hM()) {
                            bnB2.a(this.gpl);
                        }
                    }
                } catch (SocketException e3) {
                    this.gpl.bnE().zU = -12;
                    z = true;
                    eVar.zD = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gpl.a(eVar);
                    if (this.zm <= 0 && this.gpp != null) {
                        this.zm = this.gpp.hJ();
                    }
                    eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                    this.gpl.a(eVar);
                    a bnB3 = a.bnB();
                    if (bnB3 != null && this.gpp != null && this.gpp.hM()) {
                        bnB3.a(this.gpl);
                    }
                } catch (Throwable th) {
                    this.gpl.bnE().zU = -10;
                    z = false;
                    eVar.zD = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.gpl.a(eVar);
                    if (this.zm <= 0 && this.gpp != null) {
                        this.zm = this.gpp.hJ();
                    }
                    eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                    this.gpl.a(eVar);
                    a bnB4 = a.bnB();
                    if (bnB4 != null && this.gpp != null && this.gpp.hM()) {
                        bnB4.a(this.gpl);
                    }
                }
                if (this.gpl.bnE().responseCode == 200) {
                    if (this.zm <= 0 && this.gpp != null) {
                        this.zm = this.gpp.hJ();
                    }
                    eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                    this.gpl.a(eVar);
                    a bnB5 = a.bnB();
                    if (bnB5 == null || this.gpp == null || !this.gpp.hM()) {
                        return;
                    }
                    bnB5.a(this.gpl);
                    return;
                }
                eVar.zD = String.valueOf(this.gpl.bnE().responseCode) + "|retryCount:" + i4;
                z = ab(this.gpl.bnE().responseCode);
                this.gpl.a(eVar);
                if (this.zm <= 0 && this.gpp != null) {
                    this.zm = this.gpp.hJ();
                }
                eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                this.gpl.a(eVar);
                a bnB6 = a.bnB();
                if (bnB6 != null && this.gpp != null && this.gpp.hM()) {
                    bnB6.a(this.gpl);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.zm <= 0 && this.gpp != null) {
                    this.zm = this.gpp.hJ();
                }
                eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                this.gpl.a(eVar);
                a bnB7 = a.bnB();
                if (bnB7 != null && this.gpp != null && this.gpp.hM()) {
                    bnB7.a(this.gpl);
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
        if (this.gpl.bnD().ia()) {
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
        for (int i4 = 0; !this.gpl.bnE().zT && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.zw = i4;
            eVar.zA = i4 + 1;
            try {
                try {
                    try {
                        this.gpp = new b(this.gpl);
                        this.gpp.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.gpl.bnE().zU = -13;
                        z = true;
                        eVar.zD = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.gpl.a(eVar);
                        if (this.zm <= 0 && this.gpp != null) {
                            this.zm = this.gpp.hJ();
                        }
                        eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                        this.gpl.a(eVar);
                        a bnB = a.bnB();
                        if (bnB != null) {
                            bnB.a(this.gpl);
                        }
                    } catch (Throwable th) {
                        this.gpl.bnE().zU = -10;
                        z = false;
                        eVar.zD = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.gpl.a(eVar);
                        if (this.zm <= 0 && this.gpp != null) {
                            this.zm = this.gpp.hJ();
                        }
                        eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                        this.gpl.a(eVar);
                        a bnB2 = a.bnB();
                        if (bnB2 != null) {
                            bnB2.a(this.gpl);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.gpl.bnE().zU = -14;
                    eVar.zD = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.gpl.a(eVar);
                    if (this.zm <= 0 && this.gpp != null) {
                        this.zm = this.gpp.hJ();
                    }
                    eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                    this.gpl.a(eVar);
                    a bnB3 = a.bnB();
                    if (bnB3 != null) {
                        bnB3.a(this.gpl);
                    }
                } catch (SocketException e3) {
                    this.gpl.bnE().zU = -12;
                    z = true;
                    eVar.zD = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gpl.a(eVar);
                    if (this.zm <= 0 && this.gpp != null) {
                        this.zm = this.gpp.hJ();
                    }
                    eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                    this.gpl.a(eVar);
                    a bnB4 = a.bnB();
                    if (bnB4 != null) {
                        bnB4.a(this.gpl);
                    }
                }
                if (this.gpl.bnE().responseCode == 200) {
                    if (this.zm <= 0 && this.gpp != null) {
                        this.zm = this.gpp.hJ();
                    }
                    eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                    this.gpl.a(eVar);
                    a bnB5 = a.bnB();
                    if (bnB5 != null) {
                        bnB5.a(this.gpl);
                        return;
                    }
                    return;
                }
                eVar.zD = String.valueOf(this.gpl.bnE().responseCode) + "|retryCount:" + i4;
                z = ab(this.gpl.bnE().responseCode);
                this.gpl.a(eVar);
                if (this.zm <= 0 && this.gpp != null) {
                    this.zm = this.gpp.hJ();
                }
                eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                this.gpl.a(eVar);
                a bnB6 = a.bnB();
                if (bnB6 != null) {
                    bnB6.a(this.gpl);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.zm <= 0 && this.gpp != null) {
                    this.zm = this.gpp.hJ();
                }
                eVar.zB = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.gpl.bnD().getUrl(), this.gpl.bnD().az("Host"), TextUtils.isEmpty(eVar.zD), eVar.zH != null);
                this.gpl.a(eVar);
                a bnB7 = a.bnB();
                if (bnB7 != null) {
                    bnB7.a(this.gpl);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.gpp != null) {
            this.gpp.hN();
        }
    }

    public boolean hP() {
        if (this.gpl == null) {
            return false;
        }
        return this.gpl.bnE().zT;
    }

    public void hQ() {
        if (this.gpl != null) {
            this.gpl.bnE().zT = true;
        }
    }
}
