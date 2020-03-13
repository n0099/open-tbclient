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
    private g jHq;
    private b jHu;
    private int qL = 0;
    private long qz = 0;

    public d(g gVar) {
        this.jHq = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.c.b.fc().ff().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fc().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.c.b.fc().fd().getTimeOutAuto() : i4;
        this.jHu = new b(this.jHq);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.qL = i5;
                boolean a = this.jHu.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHq.a(eVar);
                a cCJ = a.cCJ();
                if (cCJ != null) {
                    cCJ.a(this.jHq);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.jHq.cCM().responseCode = -100;
                    eVar.exception = String.valueOf(this.jHq.cCM().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.jHq.a(eVar);
                    com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHq.a(eVar);
                    a cCJ2 = a.cCJ();
                    if (cCJ2 != null) {
                        cCJ2.a(this.jHq);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHq.a(eVar);
                    a cCJ3 = a.cCJ();
                    if (cCJ3 != null) {
                        cCJ3.a(this.jHq);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.jHq.cCM().responseCode = -10;
                eVar.exception = String.valueOf(this.jHq.cCM().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.jHq.a(eVar);
                com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHq.a(eVar);
                a cCJ4 = a.cCJ();
                if (cCJ4 != null) {
                    cCJ4.a(this.jHq);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void c(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.fc().ff().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fc().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fc().fd().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.jHq.cCM().rp && z && i4 < i; i4++) {
            e eVar = new e();
            this.jHq.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.qL = i4;
                                eVar.retry = i4 + 1;
                                eVar.qY = 1;
                                this.jHu = new b(this.jHq);
                                this.jHu.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.jHq.cCM().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.qz <= 0 && this.jHu != null) {
                                    this.qz = this.jHu.fO();
                                }
                                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                                this.jHq.b(eVar);
                                a cCJ = a.cCJ();
                                if (cCJ != null) {
                                    cCJ.a(this.jHq);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.jHq.cCM().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.jHq.cCM().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.qz <= 0 && this.jHu != null) {
                                this.qz = this.jHu.fO();
                            }
                            eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                            this.jHq.b(eVar);
                            a cCJ2 = a.cCJ();
                            if (cCJ2 != null) {
                                cCJ2.a(this.jHq);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.jHq.cCM().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.jHq.cCM().mNetErrorCode = -13;
                        if (this.qz <= 0 && this.jHu != null) {
                            this.qz = this.jHu.fO();
                        }
                        eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                        this.jHq.b(eVar);
                        a cCJ3 = a.cCJ();
                        if (cCJ3 != null) {
                            cCJ3.a(this.jHq);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.jHq.cCM().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.jHq.cCM().mNetErrorCode = -12;
                    if (this.qz <= 0 && this.jHu != null) {
                        this.qz = this.jHu.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHq.b(eVar);
                    a cCJ4 = a.cCJ();
                    if (cCJ4 != null) {
                        cCJ4.a(this.jHq);
                    }
                    z = true;
                }
                if (this.jHq.cCM().responseCode == 200) {
                    this.jHq.b(eVar);
                    if (this.qz <= 0 && this.jHu != null) {
                        this.qz = this.jHu.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHq.b(eVar);
                    a cCJ5 = a.cCJ();
                    if (cCJ5 != null) {
                        cCJ5.a(this.jHq);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.jHq.cCM().responseCode) + "|retryCount:" + i4;
                boolean P = P(this.jHq.cCM().responseCode);
                if (this.qz <= 0 && this.jHu != null) {
                    this.qz = this.jHu.fO();
                }
                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHq.b(eVar);
                a cCJ6 = a.cCJ();
                if (cCJ6 != null) {
                    cCJ6.a(this.jHq);
                }
                z = P;
            } catch (Throwable th) {
                if (this.qz <= 0 && this.jHu != null) {
                    this.qz = this.jHu.fO();
                }
                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHq.b(eVar);
                a cCJ7 = a.cCJ();
                if (cCJ7 != null) {
                    cCJ7.a(this.jHq);
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
            i2 = com.baidu.adp.framework.c.b.fc().ff().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fc().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fc().fd().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.jHq.cCM().rp && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.qL = i4;
            try {
                try {
                    try {
                        this.jHu = new b(this.jHq);
                        this.jHu.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.jHq.cCM().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.jHq.a(eVar);
                        if (this.qz <= 0 && this.jHu != null) {
                            this.qz = this.jHu.fO();
                        }
                        eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                        this.jHq.a(eVar);
                        a cCJ = a.cCJ();
                        if (cCJ != null && this.jHu != null && this.jHu.fR()) {
                            cCJ.a(this.jHq);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.jHq.cCM().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.jHq.a(eVar);
                        if (this.qz <= 0 && this.jHu != null) {
                            this.qz = this.jHu.fO();
                        }
                        eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                        this.jHq.a(eVar);
                        a cCJ2 = a.cCJ();
                        if (cCJ2 != null && this.jHu != null && this.jHu.fR()) {
                            cCJ2.a(this.jHq);
                        }
                    }
                } catch (SocketException e3) {
                    this.jHq.cCM().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.jHq.a(eVar);
                    if (this.qz <= 0 && this.jHu != null) {
                        this.qz = this.jHu.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHq.a(eVar);
                    a cCJ3 = a.cCJ();
                    if (cCJ3 != null && this.jHu != null && this.jHu.fR()) {
                        cCJ3.a(this.jHq);
                    }
                } catch (Throwable th) {
                    this.jHq.cCM().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.jHq.a(eVar);
                    if (this.qz <= 0 && this.jHu != null) {
                        this.qz = this.jHu.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHq.a(eVar);
                    a cCJ4 = a.cCJ();
                    if (cCJ4 != null && this.jHu != null && this.jHu.fR()) {
                        cCJ4.a(this.jHq);
                    }
                }
                if (this.jHq.cCM().responseCode == 200) {
                    if (this.qz <= 0 && this.jHu != null) {
                        this.qz = this.jHu.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHq.a(eVar);
                    a cCJ5 = a.cCJ();
                    if (cCJ5 == null || this.jHu == null || !this.jHu.fR()) {
                        return;
                    }
                    cCJ5.a(this.jHq);
                    return;
                }
                eVar.exception = String.valueOf(this.jHq.cCM().responseCode) + "|retryCount:" + i4;
                z = P(this.jHq.cCM().responseCode);
                this.jHq.a(eVar);
                if (this.qz <= 0 && this.jHu != null) {
                    this.qz = this.jHu.fO();
                }
                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHq.a(eVar);
                a cCJ6 = a.cCJ();
                if (cCJ6 != null && this.jHu != null && this.jHu.fR()) {
                    cCJ6.a(this.jHq);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.qz <= 0 && this.jHu != null) {
                    this.qz = this.jHu.fO();
                }
                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHq.a(eVar);
                a cCJ7 = a.cCJ();
                if (cCJ7 != null && this.jHu != null && this.jHu.fR()) {
                    cCJ7.a(this.jHq);
                }
                throw th2;
            }
        }
    }

    private boolean P(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void e(int i, int i2, int i3) {
        if (this.jHq.cCL().gb()) {
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
            i2 = com.baidu.adp.framework.c.b.fc().ff().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fc().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fc().fd().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.jHq.cCM().rp && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.qL = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.jHu = new b(this.jHq);
                        this.jHu.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.jHq.cCM().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.jHq.a(eVar);
                        if (this.qz <= 0 && this.jHu != null) {
                            this.qz = this.jHu.fO();
                        }
                        eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                        this.jHq.a(eVar);
                        a cCJ = a.cCJ();
                        if (cCJ != null) {
                            cCJ.a(this.jHq);
                        }
                    } catch (Throwable th) {
                        this.jHq.cCM().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.jHq.a(eVar);
                        if (this.qz <= 0 && this.jHu != null) {
                            this.qz = this.jHu.fO();
                        }
                        eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                        this.jHq.a(eVar);
                        a cCJ2 = a.cCJ();
                        if (cCJ2 != null) {
                            cCJ2.a(this.jHq);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.jHq.cCM().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.jHq.a(eVar);
                    if (this.qz <= 0 && this.jHu != null) {
                        this.qz = this.jHu.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHq.a(eVar);
                    a cCJ3 = a.cCJ();
                    if (cCJ3 != null) {
                        cCJ3.a(this.jHq);
                    }
                } catch (SocketException e3) {
                    this.jHq.cCM().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.jHq.a(eVar);
                    if (this.qz <= 0 && this.jHu != null) {
                        this.qz = this.jHu.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHq.a(eVar);
                    a cCJ4 = a.cCJ();
                    if (cCJ4 != null) {
                        cCJ4.a(this.jHq);
                    }
                }
                if (this.jHq.cCM().responseCode == 200) {
                    if (this.qz <= 0 && this.jHu != null) {
                        this.qz = this.jHu.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHq.a(eVar);
                    a cCJ5 = a.cCJ();
                    if (cCJ5 != null) {
                        cCJ5.a(this.jHq);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.jHq.cCM().responseCode) + "|retryCount:" + i4;
                z = P(this.jHq.cCM().responseCode);
                this.jHq.a(eVar);
                if (this.qz <= 0 && this.jHu != null) {
                    this.qz = this.jHu.fO();
                }
                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHq.a(eVar);
                a cCJ6 = a.cCJ();
                if (cCJ6 != null) {
                    cCJ6.a(this.jHq);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.qz <= 0 && this.jHu != null) {
                    this.qz = this.jHu.fO();
                }
                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jHq.cCL().getUrl(), this.jHq.cCL().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHq.a(eVar);
                a cCJ7 = a.cCJ();
                if (cCJ7 != null) {
                    cCJ7.a(this.jHq);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.jHu != null) {
            this.jHu.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.jHq == null) {
            return false;
        }
        return this.jHq.cCM().rp;
    }

    public void setCancel() {
        if (this.jHq != null) {
            this.jHq.cCM().rp = true;
        }
    }
}
