package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes20.dex */
public class d {
    private g lDE;
    private b lDI;
    private int Ld = 0;
    private long KQ = 0;

    public d(g gVar) {
        this.lDE = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.ly().lB().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.ly().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.ly().lz().getTimeOutAuto() : i4;
        this.lDI = new b(this.lDE);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.Ld = i5;
                boolean a = this.lDI.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                this.lDE.a(eVar);
                a dny = a.dny();
                if (dny != null) {
                    dny.a(this.lDE);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.lDE.dnB().responseCode = -100;
                    eVar.exception = String.valueOf(this.lDE.dnB().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.lDE.a(eVar);
                    com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                    this.lDE.a(eVar);
                    a dny2 = a.dny();
                    if (dny2 != null) {
                        dny2.a(this.lDE);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                    this.lDE.a(eVar);
                    a dny3 = a.dny();
                    if (dny3 != null) {
                        dny3.a(this.lDE);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.lDE.dnB().responseCode = -10;
                eVar.exception = String.valueOf(this.lDE.dnB().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.lDE.a(eVar);
                com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                this.lDE.a(eVar);
                a dny4 = a.dny();
                if (dny4 != null) {
                    dny4.a(this.lDE);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.d.b.ly().lB().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.ly().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.ly().lz().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.lDE.dnB().LJ && z && i4 < i; i4++) {
            e eVar = new e();
            this.lDE.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.Ld = i4;
                                eVar.retry = i4 + 1;
                                eVar.Ls = 1;
                                this.lDI = new b(this.lDE);
                                this.lDI.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.lDE.dnB().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.KQ <= 0 && this.lDI != null) {
                                    this.KQ = this.lDI.mj();
                                }
                                eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                                this.lDE.b(eVar);
                                a dny = a.dny();
                                if (dny != null) {
                                    dny.a(this.lDE);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.lDE.dnB().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.lDE.dnB().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.KQ <= 0 && this.lDI != null) {
                                this.KQ = this.lDI.mj();
                            }
                            eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                            this.lDE.b(eVar);
                            a dny2 = a.dny();
                            if (dny2 != null) {
                                dny2.a(this.lDE);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.lDE.dnB().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.lDE.dnB().mNetErrorCode = -13;
                        if (this.KQ <= 0 && this.lDI != null) {
                            this.KQ = this.lDI.mj();
                        }
                        eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                        this.lDE.b(eVar);
                        a dny3 = a.dny();
                        if (dny3 != null) {
                            dny3.a(this.lDE);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.lDE.dnB().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.lDE.dnB().mNetErrorCode = -12;
                    if (this.KQ <= 0 && this.lDI != null) {
                        this.KQ = this.lDI.mj();
                    }
                    eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                    this.lDE.b(eVar);
                    a dny4 = a.dny();
                    if (dny4 != null) {
                        dny4.a(this.lDE);
                    }
                    z = true;
                }
                if (this.lDE.dnB().responseCode == 200) {
                    this.lDE.b(eVar);
                    if (this.KQ <= 0 && this.lDI != null) {
                        this.KQ = this.lDI.mj();
                    }
                    eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                    this.lDE.b(eVar);
                    a dny5 = a.dny();
                    if (dny5 != null) {
                        dny5.a(this.lDE);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.lDE.dnB().responseCode) + "|retryCount:" + i4;
                boolean am = am(this.lDE.dnB().responseCode);
                if (this.KQ <= 0 && this.lDI != null) {
                    this.KQ = this.lDI.mj();
                }
                eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                this.lDE.b(eVar);
                a dny6 = a.dny();
                if (dny6 != null) {
                    dny6.a(this.lDE);
                }
                z = am;
            } catch (Throwable th) {
                if (this.KQ <= 0 && this.lDI != null) {
                    this.KQ = this.lDI.mj();
                }
                eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                this.lDE.b(eVar);
                a dny7 = a.dny();
                if (dny7 != null) {
                    dny7.a(this.lDE);
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
            i2 = com.baidu.adp.framework.d.b.ly().lB().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.ly().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.ly().lz().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.lDE.dnB().LJ && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.Ld = i4;
            try {
                try {
                    try {
                        this.lDI = new b(this.lDE);
                        this.lDI.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.lDE.dnB().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.lDE.a(eVar);
                        if (this.KQ <= 0 && this.lDI != null) {
                            this.KQ = this.lDI.mj();
                        }
                        eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                        this.lDE.a(eVar);
                        a dny = a.dny();
                        if (dny != null && this.lDI != null && this.lDI.mm()) {
                            dny.a(this.lDE);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.lDE.dnB().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.lDE.a(eVar);
                        if (this.KQ <= 0 && this.lDI != null) {
                            this.KQ = this.lDI.mj();
                        }
                        eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                        this.lDE.a(eVar);
                        a dny2 = a.dny();
                        if (dny2 != null && this.lDI != null && this.lDI.mm()) {
                            dny2.a(this.lDE);
                        }
                    }
                } catch (SocketException e3) {
                    this.lDE.dnB().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.lDE.a(eVar);
                    if (this.KQ <= 0 && this.lDI != null) {
                        this.KQ = this.lDI.mj();
                    }
                    eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                    this.lDE.a(eVar);
                    a dny3 = a.dny();
                    if (dny3 != null && this.lDI != null && this.lDI.mm()) {
                        dny3.a(this.lDE);
                    }
                } catch (Throwable th) {
                    this.lDE.dnB().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.lDE.a(eVar);
                    if (this.KQ <= 0 && this.lDI != null) {
                        this.KQ = this.lDI.mj();
                    }
                    eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                    this.lDE.a(eVar);
                    a dny4 = a.dny();
                    if (dny4 != null && this.lDI != null && this.lDI.mm()) {
                        dny4.a(this.lDE);
                    }
                }
                if (this.lDE.dnB().responseCode == 200) {
                    if (this.KQ <= 0 && this.lDI != null) {
                        this.KQ = this.lDI.mj();
                    }
                    eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                    this.lDE.a(eVar);
                    a dny5 = a.dny();
                    if (dny5 == null || this.lDI == null || !this.lDI.mm()) {
                        return;
                    }
                    dny5.a(this.lDE);
                    return;
                }
                eVar.exception = String.valueOf(this.lDE.dnB().responseCode) + "|retryCount:" + i4;
                z = am(this.lDE.dnB().responseCode);
                this.lDE.a(eVar);
                if (this.KQ <= 0 && this.lDI != null) {
                    this.KQ = this.lDI.mj();
                }
                eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                this.lDE.a(eVar);
                a dny6 = a.dny();
                if (dny6 != null && this.lDI != null && this.lDI.mm()) {
                    dny6.a(this.lDE);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.KQ <= 0 && this.lDI != null) {
                    this.KQ = this.lDI.mj();
                }
                eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                this.lDE.a(eVar);
                a dny7 = a.dny();
                if (dny7 != null && this.lDI != null && this.lDI.mm()) {
                    dny7.a(this.lDE);
                }
                throw th2;
            }
        }
    }

    private boolean am(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.lDE.dnA().mw()) {
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
            i2 = com.baidu.adp.framework.d.b.ly().lB().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.ly().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.ly().lz().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.lDE.dnB().LJ && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.Ld = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.lDI = new b(this.lDE);
                        this.lDI.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.lDE.dnB().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.lDE.a(eVar);
                        if (this.KQ <= 0 && this.lDI != null) {
                            this.KQ = this.lDI.mj();
                        }
                        eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                        this.lDE.a(eVar);
                        a dny = a.dny();
                        if (dny != null) {
                            dny.a(this.lDE);
                        }
                    } catch (Throwable th) {
                        this.lDE.dnB().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.lDE.a(eVar);
                        if (this.KQ <= 0 && this.lDI != null) {
                            this.KQ = this.lDI.mj();
                        }
                        eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                        this.lDE.a(eVar);
                        a dny2 = a.dny();
                        if (dny2 != null) {
                            dny2.a(this.lDE);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.lDE.dnB().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.lDE.a(eVar);
                    if (this.KQ <= 0 && this.lDI != null) {
                        this.KQ = this.lDI.mj();
                    }
                    eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                    this.lDE.a(eVar);
                    a dny3 = a.dny();
                    if (dny3 != null) {
                        dny3.a(this.lDE);
                    }
                } catch (SocketException e3) {
                    this.lDE.dnB().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.lDE.a(eVar);
                    if (this.KQ <= 0 && this.lDI != null) {
                        this.KQ = this.lDI.mj();
                    }
                    eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                    this.lDE.a(eVar);
                    a dny4 = a.dny();
                    if (dny4 != null) {
                        dny4.a(this.lDE);
                    }
                }
                if (this.lDE.dnB().responseCode == 200) {
                    if (this.KQ <= 0 && this.lDI != null) {
                        this.KQ = this.lDI.mj();
                    }
                    eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                    this.lDE.a(eVar);
                    a dny5 = a.dny();
                    if (dny5 != null) {
                        dny5.a(this.lDE);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.lDE.dnB().responseCode) + "|retryCount:" + i4;
                z = am(this.lDE.dnB().responseCode);
                this.lDE.a(eVar);
                if (this.KQ <= 0 && this.lDI != null) {
                    this.KQ = this.lDI.mj();
                }
                eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                this.lDE.a(eVar);
                a dny6 = a.dny();
                if (dny6 != null) {
                    dny6.a(this.lDE);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.KQ <= 0 && this.lDI != null) {
                    this.KQ = this.lDI.mj();
                }
                eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lX().a(this.lDE.dnA().getUrl(), this.lDE.dnA().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                this.lDE.a(eVar);
                a dny7 = a.dny();
                if (dny7 != null) {
                    dny7.a(this.lDE);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.lDI != null) {
            this.lDI.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.lDE == null) {
            return false;
        }
        return this.lDE.dnB().LJ;
    }

    public void setCancel() {
        if (this.lDE != null) {
            this.lDE.dnB().LJ = true;
        }
    }
}
