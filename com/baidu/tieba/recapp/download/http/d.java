package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes8.dex */
public class d {
    private g mNX;
    private b mOb;
    private int Mb = 0;
    private long LM = 0;

    public d(g gVar) {
        this.mNX = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.kZ().lc().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kZ().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.kZ().la().getTimeOutAuto() : i4;
        this.mOb = new b(this.mNX);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.Mb = i5;
                boolean a2 = this.mOb.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                this.mNX.a(eVar);
                a dFi = a.dFi();
                if (dFi != null) {
                    dFi.a(this.mNX);
                }
                return a2;
            } catch (FileNotFoundException e) {
                try {
                    this.mNX.dFl().responseCode = -100;
                    eVar.exception = String.valueOf(this.mNX.dFl().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.mNX.a(eVar);
                    com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                    this.mNX.a(eVar);
                    a dFi2 = a.dFi();
                    if (dFi2 != null) {
                        dFi2.a(this.mNX);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                    this.mNX.a(eVar);
                    a dFi3 = a.dFi();
                    if (dFi3 != null) {
                        dFi3.a(this.mNX);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.mNX.dFl().responseCode = -10;
                eVar.exception = String.valueOf(this.mNX.dFl().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.mNX.a(eVar);
                com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                this.mNX.a(eVar);
                a dFi4 = a.dFi();
                if (dFi4 != null) {
                    dFi4.a(this.mNX);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.d.b.kZ().lc().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.kZ().la().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.mNX.dFl().MH && z && i4 < i; i4++) {
            e eVar = new e();
            this.mNX.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.Mb = i4;
                                eVar.retry = i4 + 1;
                                eVar.Mq = 1;
                                this.mOb = new b(this.mNX);
                                this.mOb.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.mNX.dFl().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.LM <= 0 && this.mOb != null) {
                                    this.LM = this.mOb.lM();
                                }
                                eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                                this.mNX.b(eVar);
                                a dFi = a.dFi();
                                if (dFi != null) {
                                    dFi.a(this.mNX);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.mNX.dFl().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.mNX.dFl().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.LM <= 0 && this.mOb != null) {
                                this.LM = this.mOb.lM();
                            }
                            eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                            this.mNX.b(eVar);
                            a dFi2 = a.dFi();
                            if (dFi2 != null) {
                                dFi2.a(this.mNX);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.mNX.dFl().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.mNX.dFl().mNetErrorCode = -13;
                        if (this.LM <= 0 && this.mOb != null) {
                            this.LM = this.mOb.lM();
                        }
                        eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                        this.mNX.b(eVar);
                        a dFi3 = a.dFi();
                        if (dFi3 != null) {
                            dFi3.a(this.mNX);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.mNX.dFl().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.mNX.dFl().mNetErrorCode = -12;
                    if (this.LM <= 0 && this.mOb != null) {
                        this.LM = this.mOb.lM();
                    }
                    eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                    this.mNX.b(eVar);
                    a dFi4 = a.dFi();
                    if (dFi4 != null) {
                        dFi4.a(this.mNX);
                    }
                    z = true;
                }
                if (this.mNX.dFl().responseCode == 200) {
                    this.mNX.b(eVar);
                    if (this.LM <= 0 && this.mOb != null) {
                        this.LM = this.mOb.lM();
                    }
                    eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                    this.mNX.b(eVar);
                    a dFi5 = a.dFi();
                    if (dFi5 != null) {
                        dFi5.a(this.mNX);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.mNX.dFl().responseCode) + "|retryCount:" + i4;
                boolean as = as(this.mNX.dFl().responseCode);
                if (this.LM <= 0 && this.mOb != null) {
                    this.LM = this.mOb.lM();
                }
                eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                this.mNX.b(eVar);
                a dFi6 = a.dFi();
                if (dFi6 != null) {
                    dFi6.a(this.mNX);
                }
                z = as;
            } catch (Throwable th) {
                if (this.LM <= 0 && this.mOb != null) {
                    this.LM = this.mOb.lM();
                }
                eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                this.mNX.b(eVar);
                a dFi7 = a.dFi();
                if (dFi7 != null) {
                    dFi7.a(this.mNX);
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
            i2 = com.baidu.adp.framework.d.b.kZ().lc().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.kZ().la().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.mNX.dFl().MH && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.Mb = i4;
            try {
                try {
                    try {
                        this.mOb = new b(this.mNX);
                        this.mOb.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.mNX.dFl().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.mNX.a(eVar);
                        if (this.LM <= 0 && this.mOb != null) {
                            this.LM = this.mOb.lM();
                        }
                        eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                        this.mNX.a(eVar);
                        a dFi = a.dFi();
                        if (dFi != null && this.mOb != null && this.mOb.lP()) {
                            dFi.a(this.mNX);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.mNX.dFl().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.mNX.a(eVar);
                        if (this.LM <= 0 && this.mOb != null) {
                            this.LM = this.mOb.lM();
                        }
                        eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                        this.mNX.a(eVar);
                        a dFi2 = a.dFi();
                        if (dFi2 != null && this.mOb != null && this.mOb.lP()) {
                            dFi2.a(this.mNX);
                        }
                    }
                } catch (SocketException e3) {
                    this.mNX.dFl().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.mNX.a(eVar);
                    if (this.LM <= 0 && this.mOb != null) {
                        this.LM = this.mOb.lM();
                    }
                    eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                    this.mNX.a(eVar);
                    a dFi3 = a.dFi();
                    if (dFi3 != null && this.mOb != null && this.mOb.lP()) {
                        dFi3.a(this.mNX);
                    }
                } catch (Throwable th) {
                    this.mNX.dFl().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.mNX.a(eVar);
                    if (this.LM <= 0 && this.mOb != null) {
                        this.LM = this.mOb.lM();
                    }
                    eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                    this.mNX.a(eVar);
                    a dFi4 = a.dFi();
                    if (dFi4 != null && this.mOb != null && this.mOb.lP()) {
                        dFi4.a(this.mNX);
                    }
                }
                if (this.mNX.dFl().responseCode == 200) {
                    if (this.LM <= 0 && this.mOb != null) {
                        this.LM = this.mOb.lM();
                    }
                    eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                    this.mNX.a(eVar);
                    a dFi5 = a.dFi();
                    if (dFi5 == null || this.mOb == null || !this.mOb.lP()) {
                        return;
                    }
                    dFi5.a(this.mNX);
                    return;
                }
                eVar.exception = String.valueOf(this.mNX.dFl().responseCode) + "|retryCount:" + i4;
                z = as(this.mNX.dFl().responseCode);
                this.mNX.a(eVar);
                if (this.LM <= 0 && this.mOb != null) {
                    this.LM = this.mOb.lM();
                }
                eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                this.mNX.a(eVar);
                a dFi6 = a.dFi();
                if (dFi6 != null && this.mOb != null && this.mOb.lP()) {
                    dFi6.a(this.mNX);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.LM <= 0 && this.mOb != null) {
                    this.LM = this.mOb.lM();
                }
                eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                this.mNX.a(eVar);
                a dFi7 = a.dFi();
                if (dFi7 != null && this.mOb != null && this.mOb.lP()) {
                    dFi7.a(this.mNX);
                }
                throw th2;
            }
        }
    }

    private boolean as(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.mNX.dFk().lZ()) {
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
            i2 = com.baidu.adp.framework.d.b.kZ().lc().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.kZ().la().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.mNX.dFl().MH && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.Mb = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.mOb = new b(this.mNX);
                        this.mOb.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.mNX.dFl().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.mNX.a(eVar);
                        if (this.LM <= 0 && this.mOb != null) {
                            this.LM = this.mOb.lM();
                        }
                        eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                        this.mNX.a(eVar);
                        a dFi = a.dFi();
                        if (dFi != null) {
                            dFi.a(this.mNX);
                        }
                    } catch (Throwable th) {
                        this.mNX.dFl().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.mNX.a(eVar);
                        if (this.LM <= 0 && this.mOb != null) {
                            this.LM = this.mOb.lM();
                        }
                        eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                        this.mNX.a(eVar);
                        a dFi2 = a.dFi();
                        if (dFi2 != null) {
                            dFi2.a(this.mNX);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.mNX.dFl().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.mNX.a(eVar);
                    if (this.LM <= 0 && this.mOb != null) {
                        this.LM = this.mOb.lM();
                    }
                    eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                    this.mNX.a(eVar);
                    a dFi3 = a.dFi();
                    if (dFi3 != null) {
                        dFi3.a(this.mNX);
                    }
                } catch (SocketException e3) {
                    this.mNX.dFl().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.mNX.a(eVar);
                    if (this.LM <= 0 && this.mOb != null) {
                        this.LM = this.mOb.lM();
                    }
                    eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                    this.mNX.a(eVar);
                    a dFi4 = a.dFi();
                    if (dFi4 != null) {
                        dFi4.a(this.mNX);
                    }
                }
                if (this.mNX.dFl().responseCode == 200) {
                    if (this.LM <= 0 && this.mOb != null) {
                        this.LM = this.mOb.lM();
                    }
                    eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                    this.mNX.a(eVar);
                    a dFi5 = a.dFi();
                    if (dFi5 != null) {
                        dFi5.a(this.mNX);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.mNX.dFl().responseCode) + "|retryCount:" + i4;
                z = as(this.mNX.dFl().responseCode);
                this.mNX.a(eVar);
                if (this.LM <= 0 && this.mOb != null) {
                    this.LM = this.mOb.lM();
                }
                eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                this.mNX.a(eVar);
                a dFi6 = a.dFi();
                if (dFi6 != null) {
                    dFi6.a(this.mNX);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.LM <= 0 && this.mOb != null) {
                    this.LM = this.mOb.lM();
                }
                eVar.Mf = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lA().a(this.mNX.dFk().getUrl(), this.mNX.dFk().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mj != null);
                this.mNX.a(eVar);
                a dFi7 = a.dFi();
                if (dFi7 != null) {
                    dFi7.a(this.mNX);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.mOb != null) {
            this.mOb.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.mNX == null) {
            return false;
        }
        return this.mNX.dFl().MH;
    }

    public void setCancel() {
        if (this.mNX != null) {
            this.mNX.dFl().MH = true;
        }
    }
}
