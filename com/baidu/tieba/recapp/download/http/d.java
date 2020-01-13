package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes11.dex */
public class d {
    private g jGg;
    private b jGk;
    private int qK = 0;
    private long qy = 0;

    public d(g gVar) {
        this.jGg = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.c.b.fb().fe().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fb().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.c.b.fb().fc().getTimeOutAuto() : i4;
        this.jGk = new b(this.jGg);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.qK = i5;
                boolean a = this.jGk.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jGg.a(eVar);
                a cBi = a.cBi();
                if (cBi != null) {
                    cBi.a(this.jGg);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.jGg.cBl().responseCode = -100;
                    eVar.exception = String.valueOf(this.jGg.cBl().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.jGg.a(eVar);
                    com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jGg.a(eVar);
                    a cBi2 = a.cBi();
                    if (cBi2 != null) {
                        cBi2.a(this.jGg);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jGg.a(eVar);
                    a cBi3 = a.cBi();
                    if (cBi3 != null) {
                        cBi3.a(this.jGg);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.jGg.cBl().responseCode = -10;
                eVar.exception = String.valueOf(this.jGg.cBl().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.jGg.a(eVar);
                com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jGg.a(eVar);
                a cBi4 = a.cBi();
                if (cBi4 != null) {
                    cBi4.a(this.jGg);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void c(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.fb().fe().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fb().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fb().fc().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.jGg.cBl().ro && z && i4 < i; i4++) {
            e eVar = new e();
            this.jGg.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.qK = i4;
                                eVar.retry = i4 + 1;
                                eVar.qX = 1;
                                this.jGk = new b(this.jGg);
                                this.jGk.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.jGg.cBl().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.qy <= 0 && this.jGk != null) {
                                    this.qy = this.jGk.fO();
                                }
                                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                                this.jGg.b(eVar);
                                a cBi = a.cBi();
                                if (cBi != null) {
                                    cBi.a(this.jGg);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.jGg.cBl().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.jGg.cBl().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.qy <= 0 && this.jGk != null) {
                                this.qy = this.jGk.fO();
                            }
                            eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                            this.jGg.b(eVar);
                            a cBi2 = a.cBi();
                            if (cBi2 != null) {
                                cBi2.a(this.jGg);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.jGg.cBl().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.jGg.cBl().mNetErrorCode = -13;
                        if (this.qy <= 0 && this.jGk != null) {
                            this.qy = this.jGk.fO();
                        }
                        eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                        this.jGg.b(eVar);
                        a cBi3 = a.cBi();
                        if (cBi3 != null) {
                            cBi3.a(this.jGg);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.jGg.cBl().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.jGg.cBl().mNetErrorCode = -12;
                    if (this.qy <= 0 && this.jGk != null) {
                        this.qy = this.jGk.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jGg.b(eVar);
                    a cBi4 = a.cBi();
                    if (cBi4 != null) {
                        cBi4.a(this.jGg);
                    }
                    z = true;
                }
                if (this.jGg.cBl().responseCode == 200) {
                    this.jGg.b(eVar);
                    if (this.qy <= 0 && this.jGk != null) {
                        this.qy = this.jGk.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jGg.b(eVar);
                    a cBi5 = a.cBi();
                    if (cBi5 != null) {
                        cBi5.a(this.jGg);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.jGg.cBl().responseCode) + "|retryCount:" + i4;
                boolean M = M(this.jGg.cBl().responseCode);
                if (this.qy <= 0 && this.jGk != null) {
                    this.qy = this.jGk.fO();
                }
                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jGg.b(eVar);
                a cBi6 = a.cBi();
                if (cBi6 != null) {
                    cBi6.a(this.jGg);
                }
                z = M;
            } catch (Throwable th) {
                if (this.qy <= 0 && this.jGk != null) {
                    this.qy = this.jGk.fO();
                }
                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jGg.b(eVar);
                a cBi7 = a.cBi();
                if (cBi7 != null) {
                    cBi7.a(this.jGg);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [346=7, 347=7, 349=7, 350=14, 351=7, 352=7, 353=7, 354=7, 356=5] */
    private void d(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.fb().fe().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fb().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fb().fc().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.jGg.cBl().ro && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.qK = i4;
            try {
                try {
                    try {
                        this.jGk = new b(this.jGg);
                        this.jGk.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.jGg.cBl().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.jGg.a(eVar);
                        if (this.qy <= 0 && this.jGk != null) {
                            this.qy = this.jGk.fO();
                        }
                        eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                        this.jGg.a(eVar);
                        a cBi = a.cBi();
                        if (cBi != null && this.jGk != null && this.jGk.fR()) {
                            cBi.a(this.jGg);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.jGg.cBl().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.jGg.a(eVar);
                        if (this.qy <= 0 && this.jGk != null) {
                            this.qy = this.jGk.fO();
                        }
                        eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                        this.jGg.a(eVar);
                        a cBi2 = a.cBi();
                        if (cBi2 != null && this.jGk != null && this.jGk.fR()) {
                            cBi2.a(this.jGg);
                        }
                    }
                } catch (SocketException e3) {
                    this.jGg.cBl().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.jGg.a(eVar);
                    if (this.qy <= 0 && this.jGk != null) {
                        this.qy = this.jGk.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jGg.a(eVar);
                    a cBi3 = a.cBi();
                    if (cBi3 != null && this.jGk != null && this.jGk.fR()) {
                        cBi3.a(this.jGg);
                    }
                } catch (Throwable th) {
                    this.jGg.cBl().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.jGg.a(eVar);
                    if (this.qy <= 0 && this.jGk != null) {
                        this.qy = this.jGk.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jGg.a(eVar);
                    a cBi4 = a.cBi();
                    if (cBi4 != null && this.jGk != null && this.jGk.fR()) {
                        cBi4.a(this.jGg);
                    }
                }
                if (this.jGg.cBl().responseCode == 200) {
                    if (this.qy <= 0 && this.jGk != null) {
                        this.qy = this.jGk.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jGg.a(eVar);
                    a cBi5 = a.cBi();
                    if (cBi5 == null || this.jGk == null || !this.jGk.fR()) {
                        return;
                    }
                    cBi5.a(this.jGg);
                    return;
                }
                eVar.exception = String.valueOf(this.jGg.cBl().responseCode) + "|retryCount:" + i4;
                z = M(this.jGg.cBl().responseCode);
                this.jGg.a(eVar);
                if (this.qy <= 0 && this.jGk != null) {
                    this.qy = this.jGk.fO();
                }
                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jGg.a(eVar);
                a cBi6 = a.cBi();
                if (cBi6 != null && this.jGk != null && this.jGk.fR()) {
                    cBi6.a(this.jGg);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.qy <= 0 && this.jGk != null) {
                    this.qy = this.jGk.fO();
                }
                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jGg.a(eVar);
                a cBi7 = a.cBi();
                if (cBi7 != null && this.jGk != null && this.jGk.fR()) {
                    cBi7.a(this.jGg);
                }
                throw th2;
            }
        }
    }

    private boolean M(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void e(int i, int i2, int i3) {
        if (this.jGg.cBk().gb()) {
            d(i, i2, i3);
        } else {
            f(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [467=7, 468=7, 470=7, 471=14, 472=7, 473=7, 474=7, 475=7, 477=5] */
    private void f(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.fb().fe().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fb().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fb().fc().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.jGg.cBl().ro && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.qK = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.jGk = new b(this.jGg);
                        this.jGk.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.jGg.cBl().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.jGg.a(eVar);
                        if (this.qy <= 0 && this.jGk != null) {
                            this.qy = this.jGk.fO();
                        }
                        eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                        this.jGg.a(eVar);
                        a cBi = a.cBi();
                        if (cBi != null) {
                            cBi.a(this.jGg);
                        }
                    } catch (Throwable th) {
                        this.jGg.cBl().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.jGg.a(eVar);
                        if (this.qy <= 0 && this.jGk != null) {
                            this.qy = this.jGk.fO();
                        }
                        eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                        this.jGg.a(eVar);
                        a cBi2 = a.cBi();
                        if (cBi2 != null) {
                            cBi2.a(this.jGg);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.jGg.cBl().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.jGg.a(eVar);
                    if (this.qy <= 0 && this.jGk != null) {
                        this.qy = this.jGk.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jGg.a(eVar);
                    a cBi3 = a.cBi();
                    if (cBi3 != null) {
                        cBi3.a(this.jGg);
                    }
                } catch (SocketException e3) {
                    this.jGg.cBl().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.jGg.a(eVar);
                    if (this.qy <= 0 && this.jGk != null) {
                        this.qy = this.jGk.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jGg.a(eVar);
                    a cBi4 = a.cBi();
                    if (cBi4 != null) {
                        cBi4.a(this.jGg);
                    }
                }
                if (this.jGg.cBl().responseCode == 200) {
                    if (this.qy <= 0 && this.jGk != null) {
                        this.qy = this.jGk.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jGg.a(eVar);
                    a cBi5 = a.cBi();
                    if (cBi5 != null) {
                        cBi5.a(this.jGg);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.jGg.cBl().responseCode) + "|retryCount:" + i4;
                z = M(this.jGg.cBl().responseCode);
                this.jGg.a(eVar);
                if (this.qy <= 0 && this.jGk != null) {
                    this.qy = this.jGk.fO();
                }
                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jGg.a(eVar);
                a cBi6 = a.cBi();
                if (cBi6 != null) {
                    cBi6.a(this.jGg);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.qy <= 0 && this.jGk != null) {
                    this.qy = this.jGk.fO();
                }
                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jGg.cBk().getUrl(), this.jGg.cBk().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jGg.a(eVar);
                a cBi7 = a.cBi();
                if (cBi7 != null) {
                    cBi7.a(this.jGg);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.jGk != null) {
            this.jGk.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.jGg == null) {
            return false;
        }
        return this.jGg.cBl().ro;
    }

    public void setCancel() {
        if (this.jGg != null) {
            this.jGg.cBl().ro = true;
        }
    }
}
