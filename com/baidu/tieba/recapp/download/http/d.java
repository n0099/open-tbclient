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
    private g jHc;
    private b jHg;
    private int qL = 0;
    private long qz = 0;

    public d(g gVar) {
        this.jHc = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.c.b.fc().ff().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fc().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.c.b.fc().fd().getTimeOutAuto() : i4;
        this.jHg = new b(this.jHc);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.qL = i5;
                boolean a = this.jHg.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHc.a(eVar);
                a cCG = a.cCG();
                if (cCG != null) {
                    cCG.a(this.jHc);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.jHc.cCJ().responseCode = -100;
                    eVar.exception = String.valueOf(this.jHc.cCJ().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.jHc.a(eVar);
                    com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHc.a(eVar);
                    a cCG2 = a.cCG();
                    if (cCG2 != null) {
                        cCG2.a(this.jHc);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHc.a(eVar);
                    a cCG3 = a.cCG();
                    if (cCG3 != null) {
                        cCG3.a(this.jHc);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.jHc.cCJ().responseCode = -10;
                eVar.exception = String.valueOf(this.jHc.cCJ().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.jHc.a(eVar);
                com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHc.a(eVar);
                a cCG4 = a.cCG();
                if (cCG4 != null) {
                    cCG4.a(this.jHc);
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
        for (int i4 = 0; !this.jHc.cCJ().rp && z && i4 < i; i4++) {
            e eVar = new e();
            this.jHc.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.qL = i4;
                                eVar.retry = i4 + 1;
                                eVar.qY = 1;
                                this.jHg = new b(this.jHc);
                                this.jHg.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.jHc.cCJ().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.qz <= 0 && this.jHg != null) {
                                    this.qz = this.jHg.fO();
                                }
                                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                                this.jHc.b(eVar);
                                a cCG = a.cCG();
                                if (cCG != null) {
                                    cCG.a(this.jHc);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.jHc.cCJ().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.jHc.cCJ().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.qz <= 0 && this.jHg != null) {
                                this.qz = this.jHg.fO();
                            }
                            eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                            this.jHc.b(eVar);
                            a cCG2 = a.cCG();
                            if (cCG2 != null) {
                                cCG2.a(this.jHc);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.jHc.cCJ().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.jHc.cCJ().mNetErrorCode = -13;
                        if (this.qz <= 0 && this.jHg != null) {
                            this.qz = this.jHg.fO();
                        }
                        eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                        this.jHc.b(eVar);
                        a cCG3 = a.cCG();
                        if (cCG3 != null) {
                            cCG3.a(this.jHc);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.jHc.cCJ().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.jHc.cCJ().mNetErrorCode = -12;
                    if (this.qz <= 0 && this.jHg != null) {
                        this.qz = this.jHg.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHc.b(eVar);
                    a cCG4 = a.cCG();
                    if (cCG4 != null) {
                        cCG4.a(this.jHc);
                    }
                    z = true;
                }
                if (this.jHc.cCJ().responseCode == 200) {
                    this.jHc.b(eVar);
                    if (this.qz <= 0 && this.jHg != null) {
                        this.qz = this.jHg.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHc.b(eVar);
                    a cCG5 = a.cCG();
                    if (cCG5 != null) {
                        cCG5.a(this.jHc);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.jHc.cCJ().responseCode) + "|retryCount:" + i4;
                boolean P = P(this.jHc.cCJ().responseCode);
                if (this.qz <= 0 && this.jHg != null) {
                    this.qz = this.jHg.fO();
                }
                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHc.b(eVar);
                a cCG6 = a.cCG();
                if (cCG6 != null) {
                    cCG6.a(this.jHc);
                }
                z = P;
            } catch (Throwable th) {
                if (this.qz <= 0 && this.jHg != null) {
                    this.qz = this.jHg.fO();
                }
                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHc.b(eVar);
                a cCG7 = a.cCG();
                if (cCG7 != null) {
                    cCG7.a(this.jHc);
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
        for (int i4 = 0; !this.jHc.cCJ().rp && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.qL = i4;
            try {
                try {
                    try {
                        this.jHg = new b(this.jHc);
                        this.jHg.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.jHc.cCJ().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.jHc.a(eVar);
                        if (this.qz <= 0 && this.jHg != null) {
                            this.qz = this.jHg.fO();
                        }
                        eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                        this.jHc.a(eVar);
                        a cCG = a.cCG();
                        if (cCG != null && this.jHg != null && this.jHg.fR()) {
                            cCG.a(this.jHc);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.jHc.cCJ().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.jHc.a(eVar);
                        if (this.qz <= 0 && this.jHg != null) {
                            this.qz = this.jHg.fO();
                        }
                        eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                        this.jHc.a(eVar);
                        a cCG2 = a.cCG();
                        if (cCG2 != null && this.jHg != null && this.jHg.fR()) {
                            cCG2.a(this.jHc);
                        }
                    }
                } catch (SocketException e3) {
                    this.jHc.cCJ().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.jHc.a(eVar);
                    if (this.qz <= 0 && this.jHg != null) {
                        this.qz = this.jHg.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHc.a(eVar);
                    a cCG3 = a.cCG();
                    if (cCG3 != null && this.jHg != null && this.jHg.fR()) {
                        cCG3.a(this.jHc);
                    }
                } catch (Throwable th) {
                    this.jHc.cCJ().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.jHc.a(eVar);
                    if (this.qz <= 0 && this.jHg != null) {
                        this.qz = this.jHg.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHc.a(eVar);
                    a cCG4 = a.cCG();
                    if (cCG4 != null && this.jHg != null && this.jHg.fR()) {
                        cCG4.a(this.jHc);
                    }
                }
                if (this.jHc.cCJ().responseCode == 200) {
                    if (this.qz <= 0 && this.jHg != null) {
                        this.qz = this.jHg.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHc.a(eVar);
                    a cCG5 = a.cCG();
                    if (cCG5 == null || this.jHg == null || !this.jHg.fR()) {
                        return;
                    }
                    cCG5.a(this.jHc);
                    return;
                }
                eVar.exception = String.valueOf(this.jHc.cCJ().responseCode) + "|retryCount:" + i4;
                z = P(this.jHc.cCJ().responseCode);
                this.jHc.a(eVar);
                if (this.qz <= 0 && this.jHg != null) {
                    this.qz = this.jHg.fO();
                }
                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHc.a(eVar);
                a cCG6 = a.cCG();
                if (cCG6 != null && this.jHg != null && this.jHg.fR()) {
                    cCG6.a(this.jHc);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.qz <= 0 && this.jHg != null) {
                    this.qz = this.jHg.fO();
                }
                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHc.a(eVar);
                a cCG7 = a.cCG();
                if (cCG7 != null && this.jHg != null && this.jHg.fR()) {
                    cCG7.a(this.jHc);
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
        if (this.jHc.cCI().gb()) {
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
        for (int i4 = 0; !this.jHc.cCJ().rp && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.qL = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.jHg = new b(this.jHc);
                        this.jHg.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.jHc.cCJ().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.jHc.a(eVar);
                        if (this.qz <= 0 && this.jHg != null) {
                            this.qz = this.jHg.fO();
                        }
                        eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                        this.jHc.a(eVar);
                        a cCG = a.cCG();
                        if (cCG != null) {
                            cCG.a(this.jHc);
                        }
                    } catch (Throwable th) {
                        this.jHc.cCJ().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.jHc.a(eVar);
                        if (this.qz <= 0 && this.jHg != null) {
                            this.qz = this.jHg.fO();
                        }
                        eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                        this.jHc.a(eVar);
                        a cCG2 = a.cCG();
                        if (cCG2 != null) {
                            cCG2.a(this.jHc);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.jHc.cCJ().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.jHc.a(eVar);
                    if (this.qz <= 0 && this.jHg != null) {
                        this.qz = this.jHg.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHc.a(eVar);
                    a cCG3 = a.cCG();
                    if (cCG3 != null) {
                        cCG3.a(this.jHc);
                    }
                } catch (SocketException e3) {
                    this.jHc.cCJ().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.jHc.a(eVar);
                    if (this.qz <= 0 && this.jHg != null) {
                        this.qz = this.jHg.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHc.a(eVar);
                    a cCG4 = a.cCG();
                    if (cCG4 != null) {
                        cCG4.a(this.jHc);
                    }
                }
                if (this.jHc.cCJ().responseCode == 200) {
                    if (this.qz <= 0 && this.jHg != null) {
                        this.qz = this.jHg.fO();
                    }
                    eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                    this.jHc.a(eVar);
                    a cCG5 = a.cCG();
                    if (cCG5 != null) {
                        cCG5.a(this.jHc);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.jHc.cCJ().responseCode) + "|retryCount:" + i4;
                z = P(this.jHc.cCJ().responseCode);
                this.jHc.a(eVar);
                if (this.qz <= 0 && this.jHg != null) {
                    this.qz = this.jHg.fO();
                }
                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHc.a(eVar);
                a cCG6 = a.cCG();
                if (cCG6 != null) {
                    cCG6.a(this.jHc);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.qz <= 0 && this.jHg != null) {
                    this.qz = this.jHg.fO();
                }
                eVar.qO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jHc.cCI().getUrl(), this.jHc.cCI().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qS != null);
                this.jHc.a(eVar);
                a cCG7 = a.cCG();
                if (cCG7 != null) {
                    cCG7.a(this.jHc);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.jHg != null) {
            this.jHg.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.jHc == null) {
            return false;
        }
        return this.jHc.cCJ().rp;
    }

    public void setCancel() {
        if (this.jHc != null) {
            this.jHc.cCJ().rp = true;
        }
    }
}
