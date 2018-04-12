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
    private g fXP;
    private b fXT;
    private int tz = 0;
    private long tl = 0;

    public d(g gVar) {
        this.fXP = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int de = i3 <= 0 ? com.baidu.adp.framework.c.b.da().dd().de() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.da().getRetryCount();
        }
        int de2 = i4 <= 0 ? com.baidu.adp.framework.c.b.da().db().de() : i4;
        this.fXT = new b(this.fXP);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.tD = i5 + 1;
                this.tz = i5;
                boolean a = this.fXT.a(str, jVar, de, de2, z, eVar, z2);
                com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                this.fXP.a(eVar);
                a bjy = a.bjy();
                if (bjy != null) {
                    bjy.a(this.fXP);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.fXP.bjB().responseCode = -100;
                    eVar.tG = String.valueOf(this.fXP.bjB().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.fXP.a(eVar);
                    com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                    this.fXP.a(eVar);
                    a bjy2 = a.bjy();
                    if (bjy2 != null) {
                        bjy2.a(this.fXP);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                    this.fXP.a(eVar);
                    a bjy3 = a.bjy();
                    if (bjy3 != null) {
                        bjy3.a(this.fXP);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.fXP.bjB().responseCode = -10;
                eVar.tG = String.valueOf(this.fXP.bjB().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.fXP.a(eVar);
                com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                this.fXP.a(eVar);
                a bjy4 = a.bjy();
                if (bjy4 != null) {
                    bjy4.a(this.fXP);
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
        for (int i4 = 0; !this.fXP.bjB().tW && z && i4 < i; i4++) {
            e eVar = new e();
            this.fXP.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.tz = i4;
                                eVar.tD = i4 + 1;
                                eVar.tN = 1;
                                this.fXT = new b(this.fXP);
                                this.fXT.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.fXP.bjB().tX = -19;
                                eVar.tG = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.tl <= 0 && this.fXT != null) {
                                    this.tl = this.fXT.eS();
                                }
                                eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                                this.fXP.b(eVar);
                                a bjy = a.bjy();
                                if (bjy != null) {
                                    bjy.a(this.fXP);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.tG = String.valueOf(this.fXP.bjB().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.fXP.bjB().tX = -10;
                            BdLog.e(e2.getMessage());
                            if (this.tl <= 0 && this.fXT != null) {
                                this.tl = this.fXT.eS();
                            }
                            eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                            this.fXP.b(eVar);
                            a bjy2 = a.bjy();
                            if (bjy2 != null) {
                                bjy2.a(this.fXP);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.tG = String.valueOf(this.fXP.bjB().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.fXP.bjB().tX = -13;
                        if (this.tl <= 0 && this.fXT != null) {
                            this.tl = this.fXT.eS();
                        }
                        eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                        this.fXP.b(eVar);
                        a bjy3 = a.bjy();
                        if (bjy3 != null) {
                            bjy3.a(this.fXP);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.tG = String.valueOf(this.fXP.bjB().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.fXP.bjB().tX = -12;
                    if (this.tl <= 0 && this.fXT != null) {
                        this.tl = this.fXT.eS();
                    }
                    eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                    this.fXP.b(eVar);
                    a bjy4 = a.bjy();
                    if (bjy4 != null) {
                        bjy4.a(this.fXP);
                    }
                    z = true;
                }
                if (this.fXP.bjB().responseCode == 200) {
                    this.fXP.b(eVar);
                    if (this.tl <= 0 && this.fXT != null) {
                        this.tl = this.fXT.eS();
                    }
                    eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                    this.fXP.b(eVar);
                    a bjy5 = a.bjy();
                    if (bjy5 != null) {
                        bjy5.a(this.fXP);
                        return;
                    }
                    return;
                }
                eVar.tG = String.valueOf(this.fXP.bjB().responseCode) + "|retryCount:" + i4;
                boolean aa = aa(this.fXP.bjB().responseCode);
                if (this.tl <= 0 && this.fXT != null) {
                    this.tl = this.fXT.eS();
                }
                eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                this.fXP.b(eVar);
                a bjy6 = a.bjy();
                if (bjy6 != null) {
                    bjy6.a(this.fXP);
                }
                z = aa;
            } catch (Throwable th) {
                if (this.tl <= 0 && this.fXT != null) {
                    this.tl = this.fXT.eS();
                }
                eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                this.fXP.b(eVar);
                a bjy7 = a.bjy();
                if (bjy7 != null) {
                    bjy7.a(this.fXP);
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
        for (int i4 = 0; !this.fXP.bjB().tW && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.tD = i4 + 1;
            this.tz = i4;
            try {
                try {
                    try {
                        this.fXT = new b(this.fXP);
                        this.fXT.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.fXP.bjB().tX = -14;
                        eVar.tG = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.fXP.a(eVar);
                        if (this.tl <= 0 && this.fXT != null) {
                            this.tl = this.fXT.eS();
                        }
                        eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                        this.fXP.a(eVar);
                        a bjy = a.bjy();
                        if (bjy != null && this.fXT != null && this.fXT.eV()) {
                            bjy.a(this.fXP);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.fXP.bjB().tX = -13;
                        z = true;
                        eVar.tG = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.fXP.a(eVar);
                        if (this.tl <= 0 && this.fXT != null) {
                            this.tl = this.fXT.eS();
                        }
                        eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                        this.fXP.a(eVar);
                        a bjy2 = a.bjy();
                        if (bjy2 != null && this.fXT != null && this.fXT.eV()) {
                            bjy2.a(this.fXP);
                        }
                    }
                } catch (SocketException e3) {
                    this.fXP.bjB().tX = -12;
                    z = true;
                    eVar.tG = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.fXP.a(eVar);
                    if (this.tl <= 0 && this.fXT != null) {
                        this.tl = this.fXT.eS();
                    }
                    eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                    this.fXP.a(eVar);
                    a bjy3 = a.bjy();
                    if (bjy3 != null && this.fXT != null && this.fXT.eV()) {
                        bjy3.a(this.fXP);
                    }
                } catch (Throwable th) {
                    this.fXP.bjB().tX = -10;
                    z = false;
                    eVar.tG = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.fXP.a(eVar);
                    if (this.tl <= 0 && this.fXT != null) {
                        this.tl = this.fXT.eS();
                    }
                    eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                    this.fXP.a(eVar);
                    a bjy4 = a.bjy();
                    if (bjy4 != null && this.fXT != null && this.fXT.eV()) {
                        bjy4.a(this.fXP);
                    }
                }
                if (this.fXP.bjB().responseCode == 200) {
                    if (this.tl <= 0 && this.fXT != null) {
                        this.tl = this.fXT.eS();
                    }
                    eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                    this.fXP.a(eVar);
                    a bjy5 = a.bjy();
                    if (bjy5 == null || this.fXT == null || !this.fXT.eV()) {
                        return;
                    }
                    bjy5.a(this.fXP);
                    return;
                }
                eVar.tG = String.valueOf(this.fXP.bjB().responseCode) + "|retryCount:" + i4;
                z = aa(this.fXP.bjB().responseCode);
                this.fXP.a(eVar);
                if (this.tl <= 0 && this.fXT != null) {
                    this.tl = this.fXT.eS();
                }
                eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                this.fXP.a(eVar);
                a bjy6 = a.bjy();
                if (bjy6 != null && this.fXT != null && this.fXT.eV()) {
                    bjy6.a(this.fXP);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.tl <= 0 && this.fXT != null) {
                    this.tl = this.fXT.eS();
                }
                eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                this.fXP.a(eVar);
                a bjy7 = a.bjy();
                if (bjy7 != null && this.fXT != null && this.fXT.eV()) {
                    bjy7.a(this.fXP);
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
        if (this.fXP.bjA().fi()) {
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
        for (int i4 = 0; !this.fXP.bjB().tW && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.tz = i4;
            eVar.tD = i4 + 1;
            try {
                try {
                    try {
                        this.fXT = new b(this.fXP);
                        this.fXT.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.fXP.bjB().tX = -13;
                        z = true;
                        eVar.tG = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.fXP.a(eVar);
                        if (this.tl <= 0 && this.fXT != null) {
                            this.tl = this.fXT.eS();
                        }
                        eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                        this.fXP.a(eVar);
                        a bjy = a.bjy();
                        if (bjy != null) {
                            bjy.a(this.fXP);
                        }
                    } catch (Throwable th) {
                        this.fXP.bjB().tX = -10;
                        z = false;
                        eVar.tG = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.fXP.a(eVar);
                        if (this.tl <= 0 && this.fXT != null) {
                            this.tl = this.fXT.eS();
                        }
                        eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                        this.fXP.a(eVar);
                        a bjy2 = a.bjy();
                        if (bjy2 != null) {
                            bjy2.a(this.fXP);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.fXP.bjB().tX = -14;
                    eVar.tG = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.fXP.a(eVar);
                    if (this.tl <= 0 && this.fXT != null) {
                        this.tl = this.fXT.eS();
                    }
                    eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                    this.fXP.a(eVar);
                    a bjy3 = a.bjy();
                    if (bjy3 != null) {
                        bjy3.a(this.fXP);
                    }
                } catch (SocketException e3) {
                    this.fXP.bjB().tX = -12;
                    z = true;
                    eVar.tG = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.fXP.a(eVar);
                    if (this.tl <= 0 && this.fXT != null) {
                        this.tl = this.fXT.eS();
                    }
                    eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                    this.fXP.a(eVar);
                    a bjy4 = a.bjy();
                    if (bjy4 != null) {
                        bjy4.a(this.fXP);
                    }
                }
                if (this.fXP.bjB().responseCode == 200) {
                    if (this.tl <= 0 && this.fXT != null) {
                        this.tl = this.fXT.eS();
                    }
                    eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                    this.fXP.a(eVar);
                    a bjy5 = a.bjy();
                    if (bjy5 != null) {
                        bjy5.a(this.fXP);
                        return;
                    }
                    return;
                }
                eVar.tG = String.valueOf(this.fXP.bjB().responseCode) + "|retryCount:" + i4;
                z = aa(this.fXP.bjB().responseCode);
                this.fXP.a(eVar);
                if (this.tl <= 0 && this.fXT != null) {
                    this.tl = this.fXT.eS();
                }
                eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                this.fXP.a(eVar);
                a bjy6 = a.bjy();
                if (bjy6 != null) {
                    bjy6.a(this.fXP);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.tl <= 0 && this.fXT != null) {
                    this.tl = this.fXT.eS();
                }
                eVar.tE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eu().a(this.fXP.bjA().getUrl(), this.fXP.bjA().am("Host"), TextUtils.isEmpty(eVar.tG), eVar.tK != null);
                this.fXP.a(eVar);
                a bjy7 = a.bjy();
                if (bjy7 != null) {
                    bjy7.a(this.fXP);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.fXT != null) {
            this.fXT.eW();
        }
    }

    public boolean isCancel() {
        if (this.fXP == null) {
            return false;
        }
        return this.fXP.bjB().tW;
    }

    public void eY() {
        if (this.fXP != null) {
            this.fXP.bjB().tW = true;
        }
    }
}
