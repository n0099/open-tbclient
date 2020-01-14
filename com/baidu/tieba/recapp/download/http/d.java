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
    private g jGl;
    private b jGp;
    private int qK = 0;
    private long qy = 0;

    public d(g gVar) {
        this.jGl = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.c.b.fb().fe().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fb().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.c.b.fb().fc().getTimeOutAuto() : i4;
        this.jGp = new b(this.jGl);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.qK = i5;
                boolean a = this.jGp.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jGl.a(eVar);
                a cBk = a.cBk();
                if (cBk != null) {
                    cBk.a(this.jGl);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.jGl.cBn().responseCode = -100;
                    eVar.exception = String.valueOf(this.jGl.cBn().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.jGl.a(eVar);
                    com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jGl.a(eVar);
                    a cBk2 = a.cBk();
                    if (cBk2 != null) {
                        cBk2.a(this.jGl);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jGl.a(eVar);
                    a cBk3 = a.cBk();
                    if (cBk3 != null) {
                        cBk3.a(this.jGl);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.jGl.cBn().responseCode = -10;
                eVar.exception = String.valueOf(this.jGl.cBn().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.jGl.a(eVar);
                com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jGl.a(eVar);
                a cBk4 = a.cBk();
                if (cBk4 != null) {
                    cBk4.a(this.jGl);
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
        for (int i4 = 0; !this.jGl.cBn().ro && z && i4 < i; i4++) {
            e eVar = new e();
            this.jGl.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.qK = i4;
                                eVar.retry = i4 + 1;
                                eVar.qX = 1;
                                this.jGp = new b(this.jGl);
                                this.jGp.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.jGl.cBn().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.qy <= 0 && this.jGp != null) {
                                    this.qy = this.jGp.fO();
                                }
                                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                                this.jGl.b(eVar);
                                a cBk = a.cBk();
                                if (cBk != null) {
                                    cBk.a(this.jGl);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.jGl.cBn().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.jGl.cBn().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.qy <= 0 && this.jGp != null) {
                                this.qy = this.jGp.fO();
                            }
                            eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                            this.jGl.b(eVar);
                            a cBk2 = a.cBk();
                            if (cBk2 != null) {
                                cBk2.a(this.jGl);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.jGl.cBn().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.jGl.cBn().mNetErrorCode = -13;
                        if (this.qy <= 0 && this.jGp != null) {
                            this.qy = this.jGp.fO();
                        }
                        eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                        this.jGl.b(eVar);
                        a cBk3 = a.cBk();
                        if (cBk3 != null) {
                            cBk3.a(this.jGl);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.jGl.cBn().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.jGl.cBn().mNetErrorCode = -12;
                    if (this.qy <= 0 && this.jGp != null) {
                        this.qy = this.jGp.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jGl.b(eVar);
                    a cBk4 = a.cBk();
                    if (cBk4 != null) {
                        cBk4.a(this.jGl);
                    }
                    z = true;
                }
                if (this.jGl.cBn().responseCode == 200) {
                    this.jGl.b(eVar);
                    if (this.qy <= 0 && this.jGp != null) {
                        this.qy = this.jGp.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jGl.b(eVar);
                    a cBk5 = a.cBk();
                    if (cBk5 != null) {
                        cBk5.a(this.jGl);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.jGl.cBn().responseCode) + "|retryCount:" + i4;
                boolean M = M(this.jGl.cBn().responseCode);
                if (this.qy <= 0 && this.jGp != null) {
                    this.qy = this.jGp.fO();
                }
                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jGl.b(eVar);
                a cBk6 = a.cBk();
                if (cBk6 != null) {
                    cBk6.a(this.jGl);
                }
                z = M;
            } catch (Throwable th) {
                if (this.qy <= 0 && this.jGp != null) {
                    this.qy = this.jGp.fO();
                }
                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jGl.b(eVar);
                a cBk7 = a.cBk();
                if (cBk7 != null) {
                    cBk7.a(this.jGl);
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
        for (int i4 = 0; !this.jGl.cBn().ro && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.qK = i4;
            try {
                try {
                    try {
                        this.jGp = new b(this.jGl);
                        this.jGp.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.jGl.cBn().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.jGl.a(eVar);
                        if (this.qy <= 0 && this.jGp != null) {
                            this.qy = this.jGp.fO();
                        }
                        eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                        this.jGl.a(eVar);
                        a cBk = a.cBk();
                        if (cBk != null && this.jGp != null && this.jGp.fR()) {
                            cBk.a(this.jGl);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.jGl.cBn().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.jGl.a(eVar);
                        if (this.qy <= 0 && this.jGp != null) {
                            this.qy = this.jGp.fO();
                        }
                        eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                        this.jGl.a(eVar);
                        a cBk2 = a.cBk();
                        if (cBk2 != null && this.jGp != null && this.jGp.fR()) {
                            cBk2.a(this.jGl);
                        }
                    }
                } catch (SocketException e3) {
                    this.jGl.cBn().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.jGl.a(eVar);
                    if (this.qy <= 0 && this.jGp != null) {
                        this.qy = this.jGp.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jGl.a(eVar);
                    a cBk3 = a.cBk();
                    if (cBk3 != null && this.jGp != null && this.jGp.fR()) {
                        cBk3.a(this.jGl);
                    }
                } catch (Throwable th) {
                    this.jGl.cBn().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.jGl.a(eVar);
                    if (this.qy <= 0 && this.jGp != null) {
                        this.qy = this.jGp.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jGl.a(eVar);
                    a cBk4 = a.cBk();
                    if (cBk4 != null && this.jGp != null && this.jGp.fR()) {
                        cBk4.a(this.jGl);
                    }
                }
                if (this.jGl.cBn().responseCode == 200) {
                    if (this.qy <= 0 && this.jGp != null) {
                        this.qy = this.jGp.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jGl.a(eVar);
                    a cBk5 = a.cBk();
                    if (cBk5 == null || this.jGp == null || !this.jGp.fR()) {
                        return;
                    }
                    cBk5.a(this.jGl);
                    return;
                }
                eVar.exception = String.valueOf(this.jGl.cBn().responseCode) + "|retryCount:" + i4;
                z = M(this.jGl.cBn().responseCode);
                this.jGl.a(eVar);
                if (this.qy <= 0 && this.jGp != null) {
                    this.qy = this.jGp.fO();
                }
                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jGl.a(eVar);
                a cBk6 = a.cBk();
                if (cBk6 != null && this.jGp != null && this.jGp.fR()) {
                    cBk6.a(this.jGl);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.qy <= 0 && this.jGp != null) {
                    this.qy = this.jGp.fO();
                }
                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jGl.a(eVar);
                a cBk7 = a.cBk();
                if (cBk7 != null && this.jGp != null && this.jGp.fR()) {
                    cBk7.a(this.jGl);
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
        if (this.jGl.cBm().gb()) {
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
        for (int i4 = 0; !this.jGl.cBn().ro && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.qK = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.jGp = new b(this.jGl);
                        this.jGp.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.jGl.cBn().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.jGl.a(eVar);
                        if (this.qy <= 0 && this.jGp != null) {
                            this.qy = this.jGp.fO();
                        }
                        eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                        this.jGl.a(eVar);
                        a cBk = a.cBk();
                        if (cBk != null) {
                            cBk.a(this.jGl);
                        }
                    } catch (Throwable th) {
                        this.jGl.cBn().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.jGl.a(eVar);
                        if (this.qy <= 0 && this.jGp != null) {
                            this.qy = this.jGp.fO();
                        }
                        eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                        this.jGl.a(eVar);
                        a cBk2 = a.cBk();
                        if (cBk2 != null) {
                            cBk2.a(this.jGl);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.jGl.cBn().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.jGl.a(eVar);
                    if (this.qy <= 0 && this.jGp != null) {
                        this.qy = this.jGp.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jGl.a(eVar);
                    a cBk3 = a.cBk();
                    if (cBk3 != null) {
                        cBk3.a(this.jGl);
                    }
                } catch (SocketException e3) {
                    this.jGl.cBn().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.jGl.a(eVar);
                    if (this.qy <= 0 && this.jGp != null) {
                        this.qy = this.jGp.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jGl.a(eVar);
                    a cBk4 = a.cBk();
                    if (cBk4 != null) {
                        cBk4.a(this.jGl);
                    }
                }
                if (this.jGl.cBn().responseCode == 200) {
                    if (this.qy <= 0 && this.jGp != null) {
                        this.qy = this.jGp.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jGl.a(eVar);
                    a cBk5 = a.cBk();
                    if (cBk5 != null) {
                        cBk5.a(this.jGl);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.jGl.cBn().responseCode) + "|retryCount:" + i4;
                z = M(this.jGl.cBn().responseCode);
                this.jGl.a(eVar);
                if (this.qy <= 0 && this.jGp != null) {
                    this.qy = this.jGp.fO();
                }
                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jGl.a(eVar);
                a cBk6 = a.cBk();
                if (cBk6 != null) {
                    cBk6.a(this.jGl);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.qy <= 0 && this.jGp != null) {
                    this.qy = this.jGp.fO();
                }
                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jGl.cBm().getUrl(), this.jGl.cBm().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jGl.a(eVar);
                a cBk7 = a.cBk();
                if (cBk7 != null) {
                    cBk7.a(this.jGl);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.jGp != null) {
            this.jGp.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.jGl == null) {
            return false;
        }
        return this.jGl.cBn().ro;
    }

    public void setCancel() {
        if (this.jGl != null) {
            this.jGl.cBn().ro = true;
        }
    }
}
