package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes13.dex */
public class d {
    private g lfC;
    private b lfG;
    private int Kz = 0;
    private long Km = 0;

    public d(g gVar) {
        this.lfC = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.jZ().kc().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jZ().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.jZ().ka().getTimeOutAuto() : i4;
        this.lfG = new b(this.lfC);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.Kz = i5;
                boolean a = this.lfG.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lfC.a(eVar);
                a cZf = a.cZf();
                if (cZf != null) {
                    cZf.a(this.lfC);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.lfC.cZi().responseCode = -100;
                    eVar.exception = String.valueOf(this.lfC.cZi().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.lfC.a(eVar);
                    com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lfC.a(eVar);
                    a cZf2 = a.cZf();
                    if (cZf2 != null) {
                        cZf2.a(this.lfC);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lfC.a(eVar);
                    a cZf3 = a.cZf();
                    if (cZf3 != null) {
                        cZf3.a(this.lfC);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.lfC.cZi().responseCode = -10;
                eVar.exception = String.valueOf(this.lfC.cZi().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.lfC.a(eVar);
                com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lfC.a(eVar);
                a cZf4 = a.cZf();
                if (cZf4 != null) {
                    cZf4.a(this.lfC);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.d.b.jZ().kc().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.jZ().ka().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.lfC.cZi().Le && z && i4 < i; i4++) {
            e eVar = new e();
            this.lfC.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.Kz = i4;
                                eVar.retry = i4 + 1;
                                eVar.KP = 1;
                                this.lfG = new b(this.lfC);
                                this.lfG.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.lfC.cZi().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Km <= 0 && this.lfG != null) {
                                    this.Km = this.lfG.kK();
                                }
                                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                                this.lfC.b(eVar);
                                a cZf = a.cZf();
                                if (cZf != null) {
                                    cZf.a(this.lfC);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.lfC.cZi().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.lfC.cZi().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Km <= 0 && this.lfG != null) {
                                this.Km = this.lfG.kK();
                            }
                            eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                            this.lfC.b(eVar);
                            a cZf2 = a.cZf();
                            if (cZf2 != null) {
                                cZf2.a(this.lfC);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.lfC.cZi().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.lfC.cZi().mNetErrorCode = -13;
                        if (this.Km <= 0 && this.lfG != null) {
                            this.Km = this.lfG.kK();
                        }
                        eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                        this.lfC.b(eVar);
                        a cZf3 = a.cZf();
                        if (cZf3 != null) {
                            cZf3.a(this.lfC);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.lfC.cZi().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.lfC.cZi().mNetErrorCode = -12;
                    if (this.Km <= 0 && this.lfG != null) {
                        this.Km = this.lfG.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lfC.b(eVar);
                    a cZf4 = a.cZf();
                    if (cZf4 != null) {
                        cZf4.a(this.lfC);
                    }
                    z = true;
                }
                if (this.lfC.cZi().responseCode == 200) {
                    this.lfC.b(eVar);
                    if (this.Km <= 0 && this.lfG != null) {
                        this.Km = this.lfG.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lfC.b(eVar);
                    a cZf5 = a.cZf();
                    if (cZf5 != null) {
                        cZf5.a(this.lfC);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.lfC.cZi().responseCode) + "|retryCount:" + i4;
                boolean ai = ai(this.lfC.cZi().responseCode);
                if (this.Km <= 0 && this.lfG != null) {
                    this.Km = this.lfG.kK();
                }
                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lfC.b(eVar);
                a cZf6 = a.cZf();
                if (cZf6 != null) {
                    cZf6.a(this.lfC);
                }
                z = ai;
            } catch (Throwable th) {
                if (this.Km <= 0 && this.lfG != null) {
                    this.Km = this.lfG.kK();
                }
                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lfC.b(eVar);
                a cZf7 = a.cZf();
                if (cZf7 != null) {
                    cZf7.a(this.lfC);
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
            i2 = com.baidu.adp.framework.d.b.jZ().kc().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.jZ().ka().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.lfC.cZi().Le && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.Kz = i4;
            try {
                try {
                    try {
                        this.lfG = new b(this.lfC);
                        this.lfG.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.lfC.cZi().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.lfC.a(eVar);
                        if (this.Km <= 0 && this.lfG != null) {
                            this.Km = this.lfG.kK();
                        }
                        eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                        this.lfC.a(eVar);
                        a cZf = a.cZf();
                        if (cZf != null && this.lfG != null && this.lfG.kN()) {
                            cZf.a(this.lfC);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.lfC.cZi().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.lfC.a(eVar);
                        if (this.Km <= 0 && this.lfG != null) {
                            this.Km = this.lfG.kK();
                        }
                        eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                        this.lfC.a(eVar);
                        a cZf2 = a.cZf();
                        if (cZf2 != null && this.lfG != null && this.lfG.kN()) {
                            cZf2.a(this.lfC);
                        }
                    }
                } catch (SocketException e3) {
                    this.lfC.cZi().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.lfC.a(eVar);
                    if (this.Km <= 0 && this.lfG != null) {
                        this.Km = this.lfG.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lfC.a(eVar);
                    a cZf3 = a.cZf();
                    if (cZf3 != null && this.lfG != null && this.lfG.kN()) {
                        cZf3.a(this.lfC);
                    }
                } catch (Throwable th) {
                    this.lfC.cZi().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.lfC.a(eVar);
                    if (this.Km <= 0 && this.lfG != null) {
                        this.Km = this.lfG.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lfC.a(eVar);
                    a cZf4 = a.cZf();
                    if (cZf4 != null && this.lfG != null && this.lfG.kN()) {
                        cZf4.a(this.lfC);
                    }
                }
                if (this.lfC.cZi().responseCode == 200) {
                    if (this.Km <= 0 && this.lfG != null) {
                        this.Km = this.lfG.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lfC.a(eVar);
                    a cZf5 = a.cZf();
                    if (cZf5 == null || this.lfG == null || !this.lfG.kN()) {
                        return;
                    }
                    cZf5.a(this.lfC);
                    return;
                }
                eVar.exception = String.valueOf(this.lfC.cZi().responseCode) + "|retryCount:" + i4;
                z = ai(this.lfC.cZi().responseCode);
                this.lfC.a(eVar);
                if (this.Km <= 0 && this.lfG != null) {
                    this.Km = this.lfG.kK();
                }
                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lfC.a(eVar);
                a cZf6 = a.cZf();
                if (cZf6 != null && this.lfG != null && this.lfG.kN()) {
                    cZf6.a(this.lfC);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Km <= 0 && this.lfG != null) {
                    this.Km = this.lfG.kK();
                }
                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lfC.a(eVar);
                a cZf7 = a.cZf();
                if (cZf7 != null && this.lfG != null && this.lfG.kN()) {
                    cZf7.a(this.lfC);
                }
                throw th2;
            }
        }
    }

    private boolean ai(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.lfC.cZh().kX()) {
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
            i2 = com.baidu.adp.framework.d.b.jZ().kc().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.jZ().ka().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.lfC.cZi().Le && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.Kz = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.lfG = new b(this.lfC);
                        this.lfG.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.lfC.cZi().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.lfC.a(eVar);
                        if (this.Km <= 0 && this.lfG != null) {
                            this.Km = this.lfG.kK();
                        }
                        eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                        this.lfC.a(eVar);
                        a cZf = a.cZf();
                        if (cZf != null) {
                            cZf.a(this.lfC);
                        }
                    } catch (Throwable th) {
                        this.lfC.cZi().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.lfC.a(eVar);
                        if (this.Km <= 0 && this.lfG != null) {
                            this.Km = this.lfG.kK();
                        }
                        eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                        this.lfC.a(eVar);
                        a cZf2 = a.cZf();
                        if (cZf2 != null) {
                            cZf2.a(this.lfC);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.lfC.cZi().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.lfC.a(eVar);
                    if (this.Km <= 0 && this.lfG != null) {
                        this.Km = this.lfG.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lfC.a(eVar);
                    a cZf3 = a.cZf();
                    if (cZf3 != null) {
                        cZf3.a(this.lfC);
                    }
                } catch (SocketException e3) {
                    this.lfC.cZi().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.lfC.a(eVar);
                    if (this.Km <= 0 && this.lfG != null) {
                        this.Km = this.lfG.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lfC.a(eVar);
                    a cZf4 = a.cZf();
                    if (cZf4 != null) {
                        cZf4.a(this.lfC);
                    }
                }
                if (this.lfC.cZi().responseCode == 200) {
                    if (this.Km <= 0 && this.lfG != null) {
                        this.Km = this.lfG.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lfC.a(eVar);
                    a cZf5 = a.cZf();
                    if (cZf5 != null) {
                        cZf5.a(this.lfC);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.lfC.cZi().responseCode) + "|retryCount:" + i4;
                z = ai(this.lfC.cZi().responseCode);
                this.lfC.a(eVar);
                if (this.Km <= 0 && this.lfG != null) {
                    this.Km = this.lfG.kK();
                }
                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lfC.a(eVar);
                a cZf6 = a.cZf();
                if (cZf6 != null) {
                    cZf6.a(this.lfC);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Km <= 0 && this.lfG != null) {
                    this.Km = this.lfG.kK();
                }
                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.lfC.cZh().getUrl(), this.lfC.cZh().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lfC.a(eVar);
                a cZf7 = a.cZf();
                if (cZf7 != null) {
                    cZf7.a(this.lfC);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.lfG != null) {
            this.lfG.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.lfC == null) {
            return false;
        }
        return this.lfC.cZi().Le;
    }

    public void setCancel() {
        if (this.lfC != null) {
            this.lfC.cZi().Le = true;
        }
    }
}
