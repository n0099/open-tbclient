package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes10.dex */
public class d {
    private g jCE;
    private b jCI;
    private int qM = 0;
    private long qB = 0;

    public d(g gVar) {
        this.jCE = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.c.b.fb().fe().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fb().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.c.b.fb().fc().getTimeOutAuto() : i4;
        this.jCI = new b(this.jCE);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.qM = i5;
                boolean a = this.jCI.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                this.jCE.a(eVar);
                a cAb = a.cAb();
                if (cAb != null) {
                    cAb.a(this.jCE);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.jCE.cAe().responseCode = -100;
                    eVar.exception = String.valueOf(this.jCE.cAe().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.jCE.a(eVar);
                    com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                    this.jCE.a(eVar);
                    a cAb2 = a.cAb();
                    if (cAb2 != null) {
                        cAb2.a(this.jCE);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                    this.jCE.a(eVar);
                    a cAb3 = a.cAb();
                    if (cAb3 != null) {
                        cAb3.a(this.jCE);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.jCE.cAe().responseCode = -10;
                eVar.exception = String.valueOf(this.jCE.cAe().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.jCE.a(eVar);
                com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                this.jCE.a(eVar);
                a cAb4 = a.cAb();
                if (cAb4 != null) {
                    cAb4.a(this.jCE);
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
        for (int i4 = 0; !this.jCE.cAe().ro && z && i4 < i; i4++) {
            e eVar = new e();
            this.jCE.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.qM = i4;
                                eVar.retry = i4 + 1;
                                eVar.qY = 1;
                                this.jCI = new b(this.jCE);
                                this.jCI.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.jCE.cAe().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.qB <= 0 && this.jCI != null) {
                                    this.qB = this.jCI.fO();
                                }
                                eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                                this.jCE.b(eVar);
                                a cAb = a.cAb();
                                if (cAb != null) {
                                    cAb.a(this.jCE);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.jCE.cAe().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.jCE.cAe().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.qB <= 0 && this.jCI != null) {
                                this.qB = this.jCI.fO();
                            }
                            eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                            this.jCE.b(eVar);
                            a cAb2 = a.cAb();
                            if (cAb2 != null) {
                                cAb2.a(this.jCE);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.jCE.cAe().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.jCE.cAe().mNetErrorCode = -13;
                        if (this.qB <= 0 && this.jCI != null) {
                            this.qB = this.jCI.fO();
                        }
                        eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                        this.jCE.b(eVar);
                        a cAb3 = a.cAb();
                        if (cAb3 != null) {
                            cAb3.a(this.jCE);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.jCE.cAe().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.jCE.cAe().mNetErrorCode = -12;
                    if (this.qB <= 0 && this.jCI != null) {
                        this.qB = this.jCI.fO();
                    }
                    eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                    this.jCE.b(eVar);
                    a cAb4 = a.cAb();
                    if (cAb4 != null) {
                        cAb4.a(this.jCE);
                    }
                    z = true;
                }
                if (this.jCE.cAe().responseCode == 200) {
                    this.jCE.b(eVar);
                    if (this.qB <= 0 && this.jCI != null) {
                        this.qB = this.jCI.fO();
                    }
                    eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                    this.jCE.b(eVar);
                    a cAb5 = a.cAb();
                    if (cAb5 != null) {
                        cAb5.a(this.jCE);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.jCE.cAe().responseCode) + "|retryCount:" + i4;
                boolean L = L(this.jCE.cAe().responseCode);
                if (this.qB <= 0 && this.jCI != null) {
                    this.qB = this.jCI.fO();
                }
                eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                this.jCE.b(eVar);
                a cAb6 = a.cAb();
                if (cAb6 != null) {
                    cAb6.a(this.jCE);
                }
                z = L;
            } catch (Throwable th) {
                if (this.qB <= 0 && this.jCI != null) {
                    this.qB = this.jCI.fO();
                }
                eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                this.jCE.b(eVar);
                a cAb7 = a.cAb();
                if (cAb7 != null) {
                    cAb7.a(this.jCE);
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
        for (int i4 = 0; !this.jCE.cAe().ro && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.qM = i4;
            try {
                try {
                    try {
                        this.jCI = new b(this.jCE);
                        this.jCI.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.jCE.cAe().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.jCE.a(eVar);
                        if (this.qB <= 0 && this.jCI != null) {
                            this.qB = this.jCI.fO();
                        }
                        eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                        this.jCE.a(eVar);
                        a cAb = a.cAb();
                        if (cAb != null && this.jCI != null && this.jCI.fR()) {
                            cAb.a(this.jCE);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.jCE.cAe().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.jCE.a(eVar);
                        if (this.qB <= 0 && this.jCI != null) {
                            this.qB = this.jCI.fO();
                        }
                        eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                        this.jCE.a(eVar);
                        a cAb2 = a.cAb();
                        if (cAb2 != null && this.jCI != null && this.jCI.fR()) {
                            cAb2.a(this.jCE);
                        }
                    }
                } catch (SocketException e3) {
                    this.jCE.cAe().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.jCE.a(eVar);
                    if (this.qB <= 0 && this.jCI != null) {
                        this.qB = this.jCI.fO();
                    }
                    eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                    this.jCE.a(eVar);
                    a cAb3 = a.cAb();
                    if (cAb3 != null && this.jCI != null && this.jCI.fR()) {
                        cAb3.a(this.jCE);
                    }
                } catch (Throwable th) {
                    this.jCE.cAe().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.jCE.a(eVar);
                    if (this.qB <= 0 && this.jCI != null) {
                        this.qB = this.jCI.fO();
                    }
                    eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                    this.jCE.a(eVar);
                    a cAb4 = a.cAb();
                    if (cAb4 != null && this.jCI != null && this.jCI.fR()) {
                        cAb4.a(this.jCE);
                    }
                }
                if (this.jCE.cAe().responseCode == 200) {
                    if (this.qB <= 0 && this.jCI != null) {
                        this.qB = this.jCI.fO();
                    }
                    eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                    this.jCE.a(eVar);
                    a cAb5 = a.cAb();
                    if (cAb5 == null || this.jCI == null || !this.jCI.fR()) {
                        return;
                    }
                    cAb5.a(this.jCE);
                    return;
                }
                eVar.exception = String.valueOf(this.jCE.cAe().responseCode) + "|retryCount:" + i4;
                z = L(this.jCE.cAe().responseCode);
                this.jCE.a(eVar);
                if (this.qB <= 0 && this.jCI != null) {
                    this.qB = this.jCI.fO();
                }
                eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                this.jCE.a(eVar);
                a cAb6 = a.cAb();
                if (cAb6 != null && this.jCI != null && this.jCI.fR()) {
                    cAb6.a(this.jCE);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.qB <= 0 && this.jCI != null) {
                    this.qB = this.jCI.fO();
                }
                eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                this.jCE.a(eVar);
                a cAb7 = a.cAb();
                if (cAb7 != null && this.jCI != null && this.jCI.fR()) {
                    cAb7.a(this.jCE);
                }
                throw th2;
            }
        }
    }

    private boolean L(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void e(int i, int i2, int i3) {
        if (this.jCE.cAd().gd()) {
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
        for (int i4 = 0; !this.jCE.cAe().ro && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.qM = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.jCI = new b(this.jCE);
                        this.jCI.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.jCE.cAe().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.jCE.a(eVar);
                        if (this.qB <= 0 && this.jCI != null) {
                            this.qB = this.jCI.fO();
                        }
                        eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                        this.jCE.a(eVar);
                        a cAb = a.cAb();
                        if (cAb != null) {
                            cAb.a(this.jCE);
                        }
                    } catch (Throwable th) {
                        this.jCE.cAe().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.jCE.a(eVar);
                        if (this.qB <= 0 && this.jCI != null) {
                            this.qB = this.jCI.fO();
                        }
                        eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                        this.jCE.a(eVar);
                        a cAb2 = a.cAb();
                        if (cAb2 != null) {
                            cAb2.a(this.jCE);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.jCE.cAe().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.jCE.a(eVar);
                    if (this.qB <= 0 && this.jCI != null) {
                        this.qB = this.jCI.fO();
                    }
                    eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                    this.jCE.a(eVar);
                    a cAb3 = a.cAb();
                    if (cAb3 != null) {
                        cAb3.a(this.jCE);
                    }
                } catch (SocketException e3) {
                    this.jCE.cAe().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.jCE.a(eVar);
                    if (this.qB <= 0 && this.jCI != null) {
                        this.qB = this.jCI.fO();
                    }
                    eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                    this.jCE.a(eVar);
                    a cAb4 = a.cAb();
                    if (cAb4 != null) {
                        cAb4.a(this.jCE);
                    }
                }
                if (this.jCE.cAe().responseCode == 200) {
                    if (this.qB <= 0 && this.jCI != null) {
                        this.qB = this.jCI.fO();
                    }
                    eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                    this.jCE.a(eVar);
                    a cAb5 = a.cAb();
                    if (cAb5 != null) {
                        cAb5.a(this.jCE);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.jCE.cAe().responseCode) + "|retryCount:" + i4;
                z = L(this.jCE.cAe().responseCode);
                this.jCE.a(eVar);
                if (this.qB <= 0 && this.jCI != null) {
                    this.qB = this.jCI.fO();
                }
                eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                this.jCE.a(eVar);
                a cAb6 = a.cAb();
                if (cAb6 != null) {
                    cAb6.a(this.jCE);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.qB <= 0 && this.jCI != null) {
                    this.qB = this.jCI.fO();
                }
                eVar.qP = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jCE.cAd().getUrl(), this.jCE.cAd().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qT != null);
                this.jCE.a(eVar);
                a cAb7 = a.cAb();
                if (cAb7 != null) {
                    cAb7.a(this.jCE);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.jCI != null) {
            this.jCI.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.jCE == null) {
            return false;
        }
        return this.jCE.cAe().ro;
    }

    public void setCancel() {
        if (this.jCE != null) {
            this.jCE.cAe().ro = true;
        }
    }
}
