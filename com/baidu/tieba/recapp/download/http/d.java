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
    private g jIP;
    private b jIT;
    private int qK = 0;
    private long qy = 0;

    public d(g gVar) {
        this.jIP = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.c.b.fc().ff().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fc().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.c.b.fc().fd().getTimeOutAuto() : i4;
        this.jIT = new b(this.jIP);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.qK = i5;
                boolean a = this.jIT.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jIP.a(eVar);
                a cDd = a.cDd();
                if (cDd != null) {
                    cDd.a(this.jIP);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.jIP.cDg().responseCode = -100;
                    eVar.exception = String.valueOf(this.jIP.cDg().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.jIP.a(eVar);
                    com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jIP.a(eVar);
                    a cDd2 = a.cDd();
                    if (cDd2 != null) {
                        cDd2.a(this.jIP);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jIP.a(eVar);
                    a cDd3 = a.cDd();
                    if (cDd3 != null) {
                        cDd3.a(this.jIP);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.jIP.cDg().responseCode = -10;
                eVar.exception = String.valueOf(this.jIP.cDg().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.jIP.a(eVar);
                com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jIP.a(eVar);
                a cDd4 = a.cDd();
                if (cDd4 != null) {
                    cDd4.a(this.jIP);
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
        for (int i4 = 0; !this.jIP.cDg().rp && z && i4 < i; i4++) {
            e eVar = new e();
            this.jIP.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.qK = i4;
                                eVar.retry = i4 + 1;
                                eVar.qY = 1;
                                this.jIT = new b(this.jIP);
                                this.jIT.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.jIP.cDg().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.qy <= 0 && this.jIT != null) {
                                    this.qy = this.jIT.fO();
                                }
                                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                                this.jIP.b(eVar);
                                a cDd = a.cDd();
                                if (cDd != null) {
                                    cDd.a(this.jIP);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.jIP.cDg().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.jIP.cDg().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.qy <= 0 && this.jIT != null) {
                                this.qy = this.jIT.fO();
                            }
                            eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                            this.jIP.b(eVar);
                            a cDd2 = a.cDd();
                            if (cDd2 != null) {
                                cDd2.a(this.jIP);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.jIP.cDg().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.jIP.cDg().mNetErrorCode = -13;
                        if (this.qy <= 0 && this.jIT != null) {
                            this.qy = this.jIT.fO();
                        }
                        eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                        this.jIP.b(eVar);
                        a cDd3 = a.cDd();
                        if (cDd3 != null) {
                            cDd3.a(this.jIP);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.jIP.cDg().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.jIP.cDg().mNetErrorCode = -12;
                    if (this.qy <= 0 && this.jIT != null) {
                        this.qy = this.jIT.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jIP.b(eVar);
                    a cDd4 = a.cDd();
                    if (cDd4 != null) {
                        cDd4.a(this.jIP);
                    }
                    z = true;
                }
                if (this.jIP.cDg().responseCode == 200) {
                    this.jIP.b(eVar);
                    if (this.qy <= 0 && this.jIT != null) {
                        this.qy = this.jIT.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jIP.b(eVar);
                    a cDd5 = a.cDd();
                    if (cDd5 != null) {
                        cDd5.a(this.jIP);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.jIP.cDg().responseCode) + "|retryCount:" + i4;
                boolean P = P(this.jIP.cDg().responseCode);
                if (this.qy <= 0 && this.jIT != null) {
                    this.qy = this.jIT.fO();
                }
                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jIP.b(eVar);
                a cDd6 = a.cDd();
                if (cDd6 != null) {
                    cDd6.a(this.jIP);
                }
                z = P;
            } catch (Throwable th) {
                if (this.qy <= 0 && this.jIT != null) {
                    this.qy = this.jIT.fO();
                }
                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jIP.b(eVar);
                a cDd7 = a.cDd();
                if (cDd7 != null) {
                    cDd7.a(this.jIP);
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
        for (int i4 = 0; !this.jIP.cDg().rp && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.qK = i4;
            try {
                try {
                    try {
                        this.jIT = new b(this.jIP);
                        this.jIT.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.jIP.cDg().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.jIP.a(eVar);
                        if (this.qy <= 0 && this.jIT != null) {
                            this.qy = this.jIT.fO();
                        }
                        eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                        this.jIP.a(eVar);
                        a cDd = a.cDd();
                        if (cDd != null && this.jIT != null && this.jIT.fR()) {
                            cDd.a(this.jIP);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.jIP.cDg().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.jIP.a(eVar);
                        if (this.qy <= 0 && this.jIT != null) {
                            this.qy = this.jIT.fO();
                        }
                        eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                        this.jIP.a(eVar);
                        a cDd2 = a.cDd();
                        if (cDd2 != null && this.jIT != null && this.jIT.fR()) {
                            cDd2.a(this.jIP);
                        }
                    }
                } catch (SocketException e3) {
                    this.jIP.cDg().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.jIP.a(eVar);
                    if (this.qy <= 0 && this.jIT != null) {
                        this.qy = this.jIT.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jIP.a(eVar);
                    a cDd3 = a.cDd();
                    if (cDd3 != null && this.jIT != null && this.jIT.fR()) {
                        cDd3.a(this.jIP);
                    }
                } catch (Throwable th) {
                    this.jIP.cDg().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.jIP.a(eVar);
                    if (this.qy <= 0 && this.jIT != null) {
                        this.qy = this.jIT.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jIP.a(eVar);
                    a cDd4 = a.cDd();
                    if (cDd4 != null && this.jIT != null && this.jIT.fR()) {
                        cDd4.a(this.jIP);
                    }
                }
                if (this.jIP.cDg().responseCode == 200) {
                    if (this.qy <= 0 && this.jIT != null) {
                        this.qy = this.jIT.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jIP.a(eVar);
                    a cDd5 = a.cDd();
                    if (cDd5 == null || this.jIT == null || !this.jIT.fR()) {
                        return;
                    }
                    cDd5.a(this.jIP);
                    return;
                }
                eVar.exception = String.valueOf(this.jIP.cDg().responseCode) + "|retryCount:" + i4;
                z = P(this.jIP.cDg().responseCode);
                this.jIP.a(eVar);
                if (this.qy <= 0 && this.jIT != null) {
                    this.qy = this.jIT.fO();
                }
                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jIP.a(eVar);
                a cDd6 = a.cDd();
                if (cDd6 != null && this.jIT != null && this.jIT.fR()) {
                    cDd6.a(this.jIP);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.qy <= 0 && this.jIT != null) {
                    this.qy = this.jIT.fO();
                }
                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jIP.a(eVar);
                a cDd7 = a.cDd();
                if (cDd7 != null && this.jIT != null && this.jIT.fR()) {
                    cDd7.a(this.jIP);
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
        if (this.jIP.cDf().gb()) {
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
        for (int i4 = 0; !this.jIP.cDg().rp && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.qK = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.jIT = new b(this.jIP);
                        this.jIT.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.jIP.cDg().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.jIP.a(eVar);
                        if (this.qy <= 0 && this.jIT != null) {
                            this.qy = this.jIT.fO();
                        }
                        eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                        this.jIP.a(eVar);
                        a cDd = a.cDd();
                        if (cDd != null) {
                            cDd.a(this.jIP);
                        }
                    } catch (Throwable th) {
                        this.jIP.cDg().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.jIP.a(eVar);
                        if (this.qy <= 0 && this.jIT != null) {
                            this.qy = this.jIT.fO();
                        }
                        eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                        this.jIP.a(eVar);
                        a cDd2 = a.cDd();
                        if (cDd2 != null) {
                            cDd2.a(this.jIP);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.jIP.cDg().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.jIP.a(eVar);
                    if (this.qy <= 0 && this.jIT != null) {
                        this.qy = this.jIT.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jIP.a(eVar);
                    a cDd3 = a.cDd();
                    if (cDd3 != null) {
                        cDd3.a(this.jIP);
                    }
                } catch (SocketException e3) {
                    this.jIP.cDg().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.jIP.a(eVar);
                    if (this.qy <= 0 && this.jIT != null) {
                        this.qy = this.jIT.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jIP.a(eVar);
                    a cDd4 = a.cDd();
                    if (cDd4 != null) {
                        cDd4.a(this.jIP);
                    }
                }
                if (this.jIP.cDg().responseCode == 200) {
                    if (this.qy <= 0 && this.jIT != null) {
                        this.qy = this.jIT.fO();
                    }
                    eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                    this.jIP.a(eVar);
                    a cDd5 = a.cDd();
                    if (cDd5 != null) {
                        cDd5.a(this.jIP);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.jIP.cDg().responseCode) + "|retryCount:" + i4;
                z = P(this.jIP.cDg().responseCode);
                this.jIP.a(eVar);
                if (this.qy <= 0 && this.jIT != null) {
                    this.qy = this.jIT.fO();
                }
                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jIP.a(eVar);
                a cDd6 = a.cDd();
                if (cDd6 != null) {
                    cDd6.a(this.jIP);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.qy <= 0 && this.jIT != null) {
                    this.qy = this.jIT.fO();
                }
                eVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.jIP.cDf().getUrl(), this.jIP.cDf().al("Host"), TextUtils.isEmpty(eVar.exception), eVar.qR != null);
                this.jIP.a(eVar);
                a cDd7 = a.cDd();
                if (cDd7 != null) {
                    cDd7.a(this.jIP);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.jIT != null) {
            this.jIT.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.jIP == null) {
            return false;
        }
        return this.jIP.cDg().rp;
    }

    public void setCancel() {
        if (this.jIP != null) {
            this.jIP.cDg().rp = true;
        }
    }
}
