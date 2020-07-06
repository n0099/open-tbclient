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
                com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lfC.a(eVar);
                a cZg = a.cZg();
                if (cZg != null) {
                    cZg.a(this.lfC);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.lfC.cZj().responseCode = -100;
                    eVar.exception = String.valueOf(this.lfC.cZj().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.lfC.a(eVar);
                    com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lfC.a(eVar);
                    a cZg2 = a.cZg();
                    if (cZg2 != null) {
                        cZg2.a(this.lfC);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lfC.a(eVar);
                    a cZg3 = a.cZg();
                    if (cZg3 != null) {
                        cZg3.a(this.lfC);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.lfC.cZj().responseCode = -10;
                eVar.exception = String.valueOf(this.lfC.cZj().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.lfC.a(eVar);
                com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lfC.a(eVar);
                a cZg4 = a.cZg();
                if (cZg4 != null) {
                    cZg4.a(this.lfC);
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
        for (int i4 = 0; !this.lfC.cZj().Le && z && i4 < i; i4++) {
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
                                this.lfC.cZj().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Km <= 0 && this.lfG != null) {
                                    this.Km = this.lfG.kK();
                                }
                                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                                this.lfC.b(eVar);
                                a cZg = a.cZg();
                                if (cZg != null) {
                                    cZg.a(this.lfC);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.lfC.cZj().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.lfC.cZj().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Km <= 0 && this.lfG != null) {
                                this.Km = this.lfG.kK();
                            }
                            eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                            this.lfC.b(eVar);
                            a cZg2 = a.cZg();
                            if (cZg2 != null) {
                                cZg2.a(this.lfC);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.lfC.cZj().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.lfC.cZj().mNetErrorCode = -13;
                        if (this.Km <= 0 && this.lfG != null) {
                            this.Km = this.lfG.kK();
                        }
                        eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                        this.lfC.b(eVar);
                        a cZg3 = a.cZg();
                        if (cZg3 != null) {
                            cZg3.a(this.lfC);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.lfC.cZj().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.lfC.cZj().mNetErrorCode = -12;
                    if (this.Km <= 0 && this.lfG != null) {
                        this.Km = this.lfG.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lfC.b(eVar);
                    a cZg4 = a.cZg();
                    if (cZg4 != null) {
                        cZg4.a(this.lfC);
                    }
                    z = true;
                }
                if (this.lfC.cZj().responseCode == 200) {
                    this.lfC.b(eVar);
                    if (this.Km <= 0 && this.lfG != null) {
                        this.Km = this.lfG.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lfC.b(eVar);
                    a cZg5 = a.cZg();
                    if (cZg5 != null) {
                        cZg5.a(this.lfC);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.lfC.cZj().responseCode) + "|retryCount:" + i4;
                boolean ai = ai(this.lfC.cZj().responseCode);
                if (this.Km <= 0 && this.lfG != null) {
                    this.Km = this.lfG.kK();
                }
                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lfC.b(eVar);
                a cZg6 = a.cZg();
                if (cZg6 != null) {
                    cZg6.a(this.lfC);
                }
                z = ai;
            } catch (Throwable th) {
                if (this.Km <= 0 && this.lfG != null) {
                    this.Km = this.lfG.kK();
                }
                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lfC.b(eVar);
                a cZg7 = a.cZg();
                if (cZg7 != null) {
                    cZg7.a(this.lfC);
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
        for (int i4 = 0; !this.lfC.cZj().Le && z2 && i4 < i; i4++) {
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
                        this.lfC.cZj().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.lfC.a(eVar);
                        if (this.Km <= 0 && this.lfG != null) {
                            this.Km = this.lfG.kK();
                        }
                        eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                        this.lfC.a(eVar);
                        a cZg = a.cZg();
                        if (cZg != null && this.lfG != null && this.lfG.kN()) {
                            cZg.a(this.lfC);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.lfC.cZj().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.lfC.a(eVar);
                        if (this.Km <= 0 && this.lfG != null) {
                            this.Km = this.lfG.kK();
                        }
                        eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                        this.lfC.a(eVar);
                        a cZg2 = a.cZg();
                        if (cZg2 != null && this.lfG != null && this.lfG.kN()) {
                            cZg2.a(this.lfC);
                        }
                    }
                } catch (SocketException e3) {
                    this.lfC.cZj().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.lfC.a(eVar);
                    if (this.Km <= 0 && this.lfG != null) {
                        this.Km = this.lfG.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lfC.a(eVar);
                    a cZg3 = a.cZg();
                    if (cZg3 != null && this.lfG != null && this.lfG.kN()) {
                        cZg3.a(this.lfC);
                    }
                } catch (Throwable th) {
                    this.lfC.cZj().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.lfC.a(eVar);
                    if (this.Km <= 0 && this.lfG != null) {
                        this.Km = this.lfG.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lfC.a(eVar);
                    a cZg4 = a.cZg();
                    if (cZg4 != null && this.lfG != null && this.lfG.kN()) {
                        cZg4.a(this.lfC);
                    }
                }
                if (this.lfC.cZj().responseCode == 200) {
                    if (this.Km <= 0 && this.lfG != null) {
                        this.Km = this.lfG.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lfC.a(eVar);
                    a cZg5 = a.cZg();
                    if (cZg5 == null || this.lfG == null || !this.lfG.kN()) {
                        return;
                    }
                    cZg5.a(this.lfC);
                    return;
                }
                eVar.exception = String.valueOf(this.lfC.cZj().responseCode) + "|retryCount:" + i4;
                z = ai(this.lfC.cZj().responseCode);
                this.lfC.a(eVar);
                if (this.Km <= 0 && this.lfG != null) {
                    this.Km = this.lfG.kK();
                }
                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lfC.a(eVar);
                a cZg6 = a.cZg();
                if (cZg6 != null && this.lfG != null && this.lfG.kN()) {
                    cZg6.a(this.lfC);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Km <= 0 && this.lfG != null) {
                    this.Km = this.lfG.kK();
                }
                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lfC.a(eVar);
                a cZg7 = a.cZg();
                if (cZg7 != null && this.lfG != null && this.lfG.kN()) {
                    cZg7.a(this.lfC);
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
        if (this.lfC.cZi().kX()) {
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
        for (int i4 = 0; !this.lfC.cZj().Le && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.Kz = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.lfG = new b(this.lfC);
                        this.lfG.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.lfC.cZj().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.lfC.a(eVar);
                        if (this.Km <= 0 && this.lfG != null) {
                            this.Km = this.lfG.kK();
                        }
                        eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                        this.lfC.a(eVar);
                        a cZg = a.cZg();
                        if (cZg != null) {
                            cZg.a(this.lfC);
                        }
                    } catch (Throwable th) {
                        this.lfC.cZj().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.lfC.a(eVar);
                        if (this.Km <= 0 && this.lfG != null) {
                            this.Km = this.lfG.kK();
                        }
                        eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                        this.lfC.a(eVar);
                        a cZg2 = a.cZg();
                        if (cZg2 != null) {
                            cZg2.a(this.lfC);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.lfC.cZj().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.lfC.a(eVar);
                    if (this.Km <= 0 && this.lfG != null) {
                        this.Km = this.lfG.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lfC.a(eVar);
                    a cZg3 = a.cZg();
                    if (cZg3 != null) {
                        cZg3.a(this.lfC);
                    }
                } catch (SocketException e3) {
                    this.lfC.cZj().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.lfC.a(eVar);
                    if (this.Km <= 0 && this.lfG != null) {
                        this.Km = this.lfG.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lfC.a(eVar);
                    a cZg4 = a.cZg();
                    if (cZg4 != null) {
                        cZg4.a(this.lfC);
                    }
                }
                if (this.lfC.cZj().responseCode == 200) {
                    if (this.Km <= 0 && this.lfG != null) {
                        this.Km = this.lfG.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lfC.a(eVar);
                    a cZg5 = a.cZg();
                    if (cZg5 != null) {
                        cZg5.a(this.lfC);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.lfC.cZj().responseCode) + "|retryCount:" + i4;
                z = ai(this.lfC.cZj().responseCode);
                this.lfC.a(eVar);
                if (this.Km <= 0 && this.lfG != null) {
                    this.Km = this.lfG.kK();
                }
                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lfC.a(eVar);
                a cZg6 = a.cZg();
                if (cZg6 != null) {
                    cZg6.a(this.lfC);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Km <= 0 && this.lfG != null) {
                    this.Km = this.lfG.kK();
                }
                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.lfC.cZi().getUrl(), this.lfC.cZi().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lfC.a(eVar);
                a cZg7 = a.cZg();
                if (cZg7 != null) {
                    cZg7.a(this.lfC);
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
        return this.lfC.cZj().Le;
    }

    public void setCancel() {
        if (this.lfC != null) {
            this.lfC.cZj().Le = true;
        }
    }
}
