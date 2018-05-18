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
    private g fYS;
    private b fYW;
    private int tw = 0;
    private long tk = 0;

    public d(g gVar) {
        this.fYS = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int de = i3 <= 0 ? com.baidu.adp.framework.c.b.da().dd().de() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.da().getRetryCount();
        }
        int de2 = i4 <= 0 ? com.baidu.adp.framework.c.b.da().db().de() : i4;
        this.fYW = new b(this.fYS);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.tC = i5 + 1;
                this.tw = i5;
                boolean a = this.fYW.a(str, jVar, de, de2, z, eVar, z2);
                com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                this.fYS.a(eVar);
                a bjx = a.bjx();
                if (bjx != null) {
                    bjx.a(this.fYS);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.fYS.bjA().responseCode = -100;
                    eVar.tF = String.valueOf(this.fYS.bjA().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.fYS.a(eVar);
                    com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                    this.fYS.a(eVar);
                    a bjx2 = a.bjx();
                    if (bjx2 != null) {
                        bjx2.a(this.fYS);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                    this.fYS.a(eVar);
                    a bjx3 = a.bjx();
                    if (bjx3 != null) {
                        bjx3.a(this.fYS);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.fYS.bjA().responseCode = -10;
                eVar.tF = String.valueOf(this.fYS.bjA().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.fYS.a(eVar);
                com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                this.fYS.a(eVar);
                a bjx4 = a.bjx();
                if (bjx4 != null) {
                    bjx4.a(this.fYS);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.da().dd().de();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.da().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.da().db().de();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.fYS.bjA().tV && z && i4 < i; i4++) {
            e eVar = new e();
            this.fYS.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.tw = i4;
                                eVar.tC = i4 + 1;
                                eVar.tM = 1;
                                this.fYW = new b(this.fYS);
                                this.fYW.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.fYS.bjA().tW = -19;
                                eVar.tF = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.tk <= 0 && this.fYW != null) {
                                    this.tk = this.fYW.eS();
                                }
                                eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                                this.fYS.b(eVar);
                                a bjx = a.bjx();
                                if (bjx != null) {
                                    bjx.a(this.fYS);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.tF = String.valueOf(this.fYS.bjA().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.fYS.bjA().tW = -10;
                            BdLog.e(e2.getMessage());
                            if (this.tk <= 0 && this.fYW != null) {
                                this.tk = this.fYW.eS();
                            }
                            eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                            this.fYS.b(eVar);
                            a bjx2 = a.bjx();
                            if (bjx2 != null) {
                                bjx2.a(this.fYS);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.tF = String.valueOf(this.fYS.bjA().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.fYS.bjA().tW = -13;
                        if (this.tk <= 0 && this.fYW != null) {
                            this.tk = this.fYW.eS();
                        }
                        eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                        this.fYS.b(eVar);
                        a bjx3 = a.bjx();
                        if (bjx3 != null) {
                            bjx3.a(this.fYS);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.tF = String.valueOf(this.fYS.bjA().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.fYS.bjA().tW = -12;
                    if (this.tk <= 0 && this.fYW != null) {
                        this.tk = this.fYW.eS();
                    }
                    eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                    this.fYS.b(eVar);
                    a bjx4 = a.bjx();
                    if (bjx4 != null) {
                        bjx4.a(this.fYS);
                    }
                    z = true;
                }
                if (this.fYS.bjA().responseCode == 200) {
                    this.fYS.b(eVar);
                    if (this.tk <= 0 && this.fYW != null) {
                        this.tk = this.fYW.eS();
                    }
                    eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                    this.fYS.b(eVar);
                    a bjx5 = a.bjx();
                    if (bjx5 != null) {
                        bjx5.a(this.fYS);
                        return;
                    }
                    return;
                }
                eVar.tF = String.valueOf(this.fYS.bjA().responseCode) + "|retryCount:" + i4;
                boolean aa = aa(this.fYS.bjA().responseCode);
                if (this.tk <= 0 && this.fYW != null) {
                    this.tk = this.fYW.eS();
                }
                eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                this.fYS.b(eVar);
                a bjx6 = a.bjx();
                if (bjx6 != null) {
                    bjx6.a(this.fYS);
                }
                z = aa;
            } catch (Throwable th) {
                if (this.tk <= 0 && this.fYW != null) {
                    this.tk = this.fYW.eS();
                }
                eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                this.fYS.b(eVar);
                a bjx7 = a.bjx();
                if (bjx7 != null) {
                    bjx7.a(this.fYS);
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
            i2 = com.baidu.adp.framework.c.b.da().dd().de();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.da().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.da().db().de();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.fYS.bjA().tV && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.tC = i4 + 1;
            this.tw = i4;
            try {
                try {
                    try {
                        this.fYW = new b(this.fYS);
                        this.fYW.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.fYS.bjA().tW = -14;
                        eVar.tF = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.fYS.a(eVar);
                        if (this.tk <= 0 && this.fYW != null) {
                            this.tk = this.fYW.eS();
                        }
                        eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                        this.fYS.a(eVar);
                        a bjx = a.bjx();
                        if (bjx != null && this.fYW != null && this.fYW.eV()) {
                            bjx.a(this.fYS);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.fYS.bjA().tW = -13;
                        z = true;
                        eVar.tF = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.fYS.a(eVar);
                        if (this.tk <= 0 && this.fYW != null) {
                            this.tk = this.fYW.eS();
                        }
                        eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                        this.fYS.a(eVar);
                        a bjx2 = a.bjx();
                        if (bjx2 != null && this.fYW != null && this.fYW.eV()) {
                            bjx2.a(this.fYS);
                        }
                    }
                } catch (SocketException e3) {
                    this.fYS.bjA().tW = -12;
                    z = true;
                    eVar.tF = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.fYS.a(eVar);
                    if (this.tk <= 0 && this.fYW != null) {
                        this.tk = this.fYW.eS();
                    }
                    eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                    this.fYS.a(eVar);
                    a bjx3 = a.bjx();
                    if (bjx3 != null && this.fYW != null && this.fYW.eV()) {
                        bjx3.a(this.fYS);
                    }
                } catch (Throwable th) {
                    this.fYS.bjA().tW = -10;
                    z = false;
                    eVar.tF = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.fYS.a(eVar);
                    if (this.tk <= 0 && this.fYW != null) {
                        this.tk = this.fYW.eS();
                    }
                    eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                    this.fYS.a(eVar);
                    a bjx4 = a.bjx();
                    if (bjx4 != null && this.fYW != null && this.fYW.eV()) {
                        bjx4.a(this.fYS);
                    }
                }
                if (this.fYS.bjA().responseCode == 200) {
                    if (this.tk <= 0 && this.fYW != null) {
                        this.tk = this.fYW.eS();
                    }
                    eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                    this.fYS.a(eVar);
                    a bjx5 = a.bjx();
                    if (bjx5 == null || this.fYW == null || !this.fYW.eV()) {
                        return;
                    }
                    bjx5.a(this.fYS);
                    return;
                }
                eVar.tF = String.valueOf(this.fYS.bjA().responseCode) + "|retryCount:" + i4;
                z = aa(this.fYS.bjA().responseCode);
                this.fYS.a(eVar);
                if (this.tk <= 0 && this.fYW != null) {
                    this.tk = this.fYW.eS();
                }
                eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                this.fYS.a(eVar);
                a bjx6 = a.bjx();
                if (bjx6 != null && this.fYW != null && this.fYW.eV()) {
                    bjx6.a(this.fYS);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.tk <= 0 && this.fYW != null) {
                    this.tk = this.fYW.eS();
                }
                eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                this.fYS.a(eVar);
                a bjx7 = a.bjx();
                if (bjx7 != null && this.fYW != null && this.fYW.eV()) {
                    bjx7.a(this.fYS);
                }
                throw th2;
            }
        }
    }

    private boolean aa(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.fYS.bjz().fi()) {
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
            i2 = com.baidu.adp.framework.c.b.da().dd().de();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.da().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.da().db().de();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.fYS.bjA().tV && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.tw = i4;
            eVar.tC = i4 + 1;
            try {
                try {
                    try {
                        this.fYW = new b(this.fYS);
                        this.fYW.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.fYS.bjA().tW = -13;
                        z = true;
                        eVar.tF = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.fYS.a(eVar);
                        if (this.tk <= 0 && this.fYW != null) {
                            this.tk = this.fYW.eS();
                        }
                        eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                        this.fYS.a(eVar);
                        a bjx = a.bjx();
                        if (bjx != null) {
                            bjx.a(this.fYS);
                        }
                    } catch (Throwable th) {
                        this.fYS.bjA().tW = -10;
                        z = false;
                        eVar.tF = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.fYS.a(eVar);
                        if (this.tk <= 0 && this.fYW != null) {
                            this.tk = this.fYW.eS();
                        }
                        eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                        this.fYS.a(eVar);
                        a bjx2 = a.bjx();
                        if (bjx2 != null) {
                            bjx2.a(this.fYS);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.fYS.bjA().tW = -14;
                    eVar.tF = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.fYS.a(eVar);
                    if (this.tk <= 0 && this.fYW != null) {
                        this.tk = this.fYW.eS();
                    }
                    eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                    this.fYS.a(eVar);
                    a bjx3 = a.bjx();
                    if (bjx3 != null) {
                        bjx3.a(this.fYS);
                    }
                } catch (SocketException e3) {
                    this.fYS.bjA().tW = -12;
                    z = true;
                    eVar.tF = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.fYS.a(eVar);
                    if (this.tk <= 0 && this.fYW != null) {
                        this.tk = this.fYW.eS();
                    }
                    eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                    this.fYS.a(eVar);
                    a bjx4 = a.bjx();
                    if (bjx4 != null) {
                        bjx4.a(this.fYS);
                    }
                }
                if (this.fYS.bjA().responseCode == 200) {
                    if (this.tk <= 0 && this.fYW != null) {
                        this.tk = this.fYW.eS();
                    }
                    eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                    this.fYS.a(eVar);
                    a bjx5 = a.bjx();
                    if (bjx5 != null) {
                        bjx5.a(this.fYS);
                        return;
                    }
                    return;
                }
                eVar.tF = String.valueOf(this.fYS.bjA().responseCode) + "|retryCount:" + i4;
                z = aa(this.fYS.bjA().responseCode);
                this.fYS.a(eVar);
                if (this.tk <= 0 && this.fYW != null) {
                    this.tk = this.fYW.eS();
                }
                eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                this.fYS.a(eVar);
                a bjx6 = a.bjx();
                if (bjx6 != null) {
                    bjx6.a(this.fYS);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.tk <= 0 && this.fYW != null) {
                    this.tk = this.fYW.eS();
                }
                eVar.tD = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eu().a(this.fYS.bjz().getUrl(), this.fYS.bjz().am("Host"), TextUtils.isEmpty(eVar.tF), eVar.tJ != null);
                this.fYS.a(eVar);
                a bjx7 = a.bjx();
                if (bjx7 != null) {
                    bjx7.a(this.fYS);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.fYW != null) {
            this.fYW.eW();
        }
    }

    public boolean isCancel() {
        if (this.fYS == null) {
            return false;
        }
        return this.fYS.bjA().tV;
    }

    public void eY() {
        if (this.fYS != null) {
            this.fYS.bjA().tV = true;
        }
    }
}
