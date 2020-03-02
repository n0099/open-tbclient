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
    private g jHe;
    private b jHi;
    private int qL = 0;
    private long qz = 0;

    public d(g gVar) {
        this.jHe = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.c.b.fc().ff().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fc().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.c.b.fc().fd().getTimeOutAuto() : i4;
        this.jHi = new b(this.jHe);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.qL = i5;
                boolean a = this.jHi.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHe.a(eVar);
                a cCI = a.cCI();
                if (cCI != null) {
                    cCI.a(this.jHe);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.jHe.cCL().responseCode = -100;
                    eVar.exception = String.valueOf(this.jHe.cCL().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.jHe.a(eVar);
                    com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHe.a(eVar);
                    a cCI2 = a.cCI();
                    if (cCI2 != null) {
                        cCI2.a(this.jHe);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHe.a(eVar);
                    a cCI3 = a.cCI();
                    if (cCI3 != null) {
                        cCI3.a(this.jHe);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.jHe.cCL().responseCode = -10;
                eVar.exception = String.valueOf(this.jHe.cCL().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.jHe.a(eVar);
                com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHe.a(eVar);
                a cCI4 = a.cCI();
                if (cCI4 != null) {
                    cCI4.a(this.jHe);
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
        for (int i4 = 0; !this.jHe.cCL().rp && z && i4 < i; i4++) {
            e eVar = new e();
            this.jHe.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.qL = i4;
                                eVar.retry = i4 + 1;
                                eVar.qY = 1;
                                this.jHi = new b(this.jHe);
                                this.jHi.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.jHe.cCL().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.qz <= 0 && this.jHi != null) {
                                    this.qz = this.jHi.fO();
                                }
                                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                                this.jHe.b(eVar);
                                a cCI = a.cCI();
                                if (cCI != null) {
                                    cCI.a(this.jHe);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.jHe.cCL().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.jHe.cCL().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.qz <= 0 && this.jHi != null) {
                                this.qz = this.jHi.fO();
                            }
                            eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                            this.jHe.b(eVar);
                            a cCI2 = a.cCI();
                            if (cCI2 != null) {
                                cCI2.a(this.jHe);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.jHe.cCL().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.jHe.cCL().mNetErrorCode = -13;
                        if (this.qz <= 0 && this.jHi != null) {
                            this.qz = this.jHi.fO();
                        }
                        eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                        this.jHe.b(eVar);
                        a cCI3 = a.cCI();
                        if (cCI3 != null) {
                            cCI3.a(this.jHe);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.jHe.cCL().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.jHe.cCL().mNetErrorCode = -12;
                    if (this.qz <= 0 && this.jHi != null) {
                        this.qz = this.jHi.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHe.b(eVar);
                    a cCI4 = a.cCI();
                    if (cCI4 != null) {
                        cCI4.a(this.jHe);
                    }
                    z = true;
                }
                if (this.jHe.cCL().responseCode == 200) {
                    this.jHe.b(eVar);
                    if (this.qz <= 0 && this.jHi != null) {
                        this.qz = this.jHi.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHe.b(eVar);
                    a cCI5 = a.cCI();
                    if (cCI5 != null) {
                        cCI5.a(this.jHe);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.jHe.cCL().responseCode) + "|retryCount:" + i4;
                boolean P = P(this.jHe.cCL().responseCode);
                if (this.qz <= 0 && this.jHi != null) {
                    this.qz = this.jHi.fO();
                }
                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHe.b(eVar);
                a cCI6 = a.cCI();
                if (cCI6 != null) {
                    cCI6.a(this.jHe);
                }
                z = P;
            } catch (Throwable th) {
                if (this.qz <= 0 && this.jHi != null) {
                    this.qz = this.jHi.fO();
                }
                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHe.b(eVar);
                a cCI7 = a.cCI();
                if (cCI7 != null) {
                    cCI7.a(this.jHe);
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
        for (int i4 = 0; !this.jHe.cCL().rp && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.qL = i4;
            try {
                try {
                    try {
                        this.jHi = new b(this.jHe);
                        this.jHi.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.jHe.cCL().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.jHe.a(eVar);
                        if (this.qz <= 0 && this.jHi != null) {
                            this.qz = this.jHi.fO();
                        }
                        eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                        this.jHe.a(eVar);
                        a cCI = a.cCI();
                        if (cCI != null && this.jHi != null && this.jHi.fR()) {
                            cCI.a(this.jHe);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.jHe.cCL().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.jHe.a(eVar);
                        if (this.qz <= 0 && this.jHi != null) {
                            this.qz = this.jHi.fO();
                        }
                        eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                        this.jHe.a(eVar);
                        a cCI2 = a.cCI();
                        if (cCI2 != null && this.jHi != null && this.jHi.fR()) {
                            cCI2.a(this.jHe);
                        }
                    }
                } catch (SocketException e3) {
                    this.jHe.cCL().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.jHe.a(eVar);
                    if (this.qz <= 0 && this.jHi != null) {
                        this.qz = this.jHi.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHe.a(eVar);
                    a cCI3 = a.cCI();
                    if (cCI3 != null && this.jHi != null && this.jHi.fR()) {
                        cCI3.a(this.jHe);
                    }
                } catch (Throwable th) {
                    this.jHe.cCL().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.jHe.a(eVar);
                    if (this.qz <= 0 && this.jHi != null) {
                        this.qz = this.jHi.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHe.a(eVar);
                    a cCI4 = a.cCI();
                    if (cCI4 != null && this.jHi != null && this.jHi.fR()) {
                        cCI4.a(this.jHe);
                    }
                }
                if (this.jHe.cCL().responseCode == 200) {
                    if (this.qz <= 0 && this.jHi != null) {
                        this.qz = this.jHi.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHe.a(eVar);
                    a cCI5 = a.cCI();
                    if (cCI5 == null || this.jHi == null || !this.jHi.fR()) {
                        return;
                    }
                    cCI5.a(this.jHe);
                    return;
                }
                eVar.exception = String.valueOf(this.jHe.cCL().responseCode) + "|retryCount:" + i4;
                z = P(this.jHe.cCL().responseCode);
                this.jHe.a(eVar);
                if (this.qz <= 0 && this.jHi != null) {
                    this.qz = this.jHi.fO();
                }
                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHe.a(eVar);
                a cCI6 = a.cCI();
                if (cCI6 != null && this.jHi != null && this.jHi.fR()) {
                    cCI6.a(this.jHe);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.qz <= 0 && this.jHi != null) {
                    this.qz = this.jHi.fO();
                }
                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHe.a(eVar);
                a cCI7 = a.cCI();
                if (cCI7 != null && this.jHi != null && this.jHi.fR()) {
                    cCI7.a(this.jHe);
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
        if (this.jHe.cCK().gb()) {
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
        for (int i4 = 0; !this.jHe.cCL().rp && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.qL = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.jHi = new b(this.jHe);
                        this.jHi.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.jHe.cCL().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.jHe.a(eVar);
                        if (this.qz <= 0 && this.jHi != null) {
                            this.qz = this.jHi.fO();
                        }
                        eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                        this.jHe.a(eVar);
                        a cCI = a.cCI();
                        if (cCI != null) {
                            cCI.a(this.jHe);
                        }
                    } catch (Throwable th) {
                        this.jHe.cCL().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.jHe.a(eVar);
                        if (this.qz <= 0 && this.jHi != null) {
                            this.qz = this.jHi.fO();
                        }
                        eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                        this.jHe.a(eVar);
                        a cCI2 = a.cCI();
                        if (cCI2 != null) {
                            cCI2.a(this.jHe);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.jHe.cCL().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.jHe.a(eVar);
                    if (this.qz <= 0 && this.jHi != null) {
                        this.qz = this.jHi.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHe.a(eVar);
                    a cCI3 = a.cCI();
                    if (cCI3 != null) {
                        cCI3.a(this.jHe);
                    }
                } catch (SocketException e3) {
                    this.jHe.cCL().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.jHe.a(eVar);
                    if (this.qz <= 0 && this.jHi != null) {
                        this.qz = this.jHi.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHe.a(eVar);
                    a cCI4 = a.cCI();
                    if (cCI4 != null) {
                        cCI4.a(this.jHe);
                    }
                }
                if (this.jHe.cCL().responseCode == 200) {
                    if (this.qz <= 0 && this.jHi != null) {
                        this.qz = this.jHi.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHe.a(eVar);
                    a cCI5 = a.cCI();
                    if (cCI5 != null) {
                        cCI5.a(this.jHe);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.jHe.cCL().responseCode) + "|retryCount:" + i4;
                z = P(this.jHe.cCL().responseCode);
                this.jHe.a(eVar);
                if (this.qz <= 0 && this.jHi != null) {
                    this.qz = this.jHi.fO();
                }
                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHe.a(eVar);
                a cCI6 = a.cCI();
                if (cCI6 != null) {
                    cCI6.a(this.jHe);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.qz <= 0 && this.jHi != null) {
                    this.qz = this.jHi.fO();
                }
                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jHe.cCK().getUrl(), this.jHe.cCK().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHe.a(eVar);
                a cCI7 = a.cCI();
                if (cCI7 != null) {
                    cCI7.a(this.jHe);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.jHi != null) {
            this.jHi.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.jHe == null) {
            return false;
        }
        return this.jHe.cCL().rp;
    }

    public void setCancel() {
        if (this.jHe != null) {
            this.jHe.cCL().rp = true;
        }
    }
}
