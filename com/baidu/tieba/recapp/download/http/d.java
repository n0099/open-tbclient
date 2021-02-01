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
    private g mSA;
    private b mSE;
    private int LX = 0;
    private long LH = 0;

    public d(g gVar) {
        this.mSA = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.kY().lb().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kY().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.kY().kZ().getTimeOutAuto() : i4;
        this.mSE = new b(this.mSA);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.LX = i5;
                boolean a2 = this.mSE.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                this.mSA.a(eVar);
                a dDA = a.dDA();
                if (dDA != null) {
                    dDA.a(this.mSA);
                }
                return a2;
            } catch (FileNotFoundException e) {
                try {
                    this.mSA.dDD().responseCode = -100;
                    eVar.exception = String.valueOf(this.mSA.dDD().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.mSA.a(eVar);
                    com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                    this.mSA.a(eVar);
                    a dDA2 = a.dDA();
                    if (dDA2 != null) {
                        dDA2.a(this.mSA);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                    this.mSA.a(eVar);
                    a dDA3 = a.dDA();
                    if (dDA3 != null) {
                        dDA3.a(this.mSA);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.mSA.dDD().responseCode = -10;
                eVar.exception = String.valueOf(this.mSA.dDD().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.mSA.a(eVar);
                com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                this.mSA.a(eVar);
                a dDA4 = a.dDA();
                if (dDA4 != null) {
                    dDA4.a(this.mSA);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.d.b.kY().lb().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kY().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.kY().kZ().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.mSA.dDD().MD && z && i4 < i; i4++) {
            e eVar = new e();
            this.mSA.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.LX = i4;
                                eVar.retry = i4 + 1;
                                eVar.Mm = 1;
                                this.mSE = new b(this.mSA);
                                this.mSE.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.mSA.dDD().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.LH <= 0 && this.mSE != null) {
                                    this.LH = this.mSE.lL();
                                }
                                eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                                this.mSA.b(eVar);
                                a dDA = a.dDA();
                                if (dDA != null) {
                                    dDA.a(this.mSA);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.mSA.dDD().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.mSA.dDD().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.LH <= 0 && this.mSE != null) {
                                this.LH = this.mSE.lL();
                            }
                            eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                            this.mSA.b(eVar);
                            a dDA2 = a.dDA();
                            if (dDA2 != null) {
                                dDA2.a(this.mSA);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.mSA.dDD().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.mSA.dDD().mNetErrorCode = -13;
                        if (this.LH <= 0 && this.mSE != null) {
                            this.LH = this.mSE.lL();
                        }
                        eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                        this.mSA.b(eVar);
                        a dDA3 = a.dDA();
                        if (dDA3 != null) {
                            dDA3.a(this.mSA);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.mSA.dDD().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.mSA.dDD().mNetErrorCode = -12;
                    if (this.LH <= 0 && this.mSE != null) {
                        this.LH = this.mSE.lL();
                    }
                    eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                    this.mSA.b(eVar);
                    a dDA4 = a.dDA();
                    if (dDA4 != null) {
                        dDA4.a(this.mSA);
                    }
                    z = true;
                }
                if (this.mSA.dDD().responseCode == 200) {
                    this.mSA.b(eVar);
                    if (this.LH <= 0 && this.mSE != null) {
                        this.LH = this.mSE.lL();
                    }
                    eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                    this.mSA.b(eVar);
                    a dDA5 = a.dDA();
                    if (dDA5 != null) {
                        dDA5.a(this.mSA);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.mSA.dDD().responseCode) + "|retryCount:" + i4;
                boolean as = as(this.mSA.dDD().responseCode);
                if (this.LH <= 0 && this.mSE != null) {
                    this.LH = this.mSE.lL();
                }
                eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                this.mSA.b(eVar);
                a dDA6 = a.dDA();
                if (dDA6 != null) {
                    dDA6.a(this.mSA);
                }
                z = as;
            } catch (Throwable th) {
                if (this.LH <= 0 && this.mSE != null) {
                    this.LH = this.mSE.lL();
                }
                eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                this.mSA.b(eVar);
                a dDA7 = a.dDA();
                if (dDA7 != null) {
                    dDA7.a(this.mSA);
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
            i2 = com.baidu.adp.framework.d.b.kY().lb().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kY().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.kY().kZ().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.mSA.dDD().MD && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.LX = i4;
            try {
                try {
                    try {
                        this.mSE = new b(this.mSA);
                        this.mSE.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.mSA.dDD().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.mSA.a(eVar);
                        if (this.LH <= 0 && this.mSE != null) {
                            this.LH = this.mSE.lL();
                        }
                        eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                        this.mSA.a(eVar);
                        a dDA = a.dDA();
                        if (dDA != null && this.mSE != null && this.mSE.lO()) {
                            dDA.a(this.mSA);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.mSA.dDD().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.mSA.a(eVar);
                        if (this.LH <= 0 && this.mSE != null) {
                            this.LH = this.mSE.lL();
                        }
                        eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                        this.mSA.a(eVar);
                        a dDA2 = a.dDA();
                        if (dDA2 != null && this.mSE != null && this.mSE.lO()) {
                            dDA2.a(this.mSA);
                        }
                    }
                } catch (SocketException e3) {
                    this.mSA.dDD().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.mSA.a(eVar);
                    if (this.LH <= 0 && this.mSE != null) {
                        this.LH = this.mSE.lL();
                    }
                    eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                    this.mSA.a(eVar);
                    a dDA3 = a.dDA();
                    if (dDA3 != null && this.mSE != null && this.mSE.lO()) {
                        dDA3.a(this.mSA);
                    }
                } catch (Throwable th) {
                    this.mSA.dDD().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.mSA.a(eVar);
                    if (this.LH <= 0 && this.mSE != null) {
                        this.LH = this.mSE.lL();
                    }
                    eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                    this.mSA.a(eVar);
                    a dDA4 = a.dDA();
                    if (dDA4 != null && this.mSE != null && this.mSE.lO()) {
                        dDA4.a(this.mSA);
                    }
                }
                if (this.mSA.dDD().responseCode == 200) {
                    if (this.LH <= 0 && this.mSE != null) {
                        this.LH = this.mSE.lL();
                    }
                    eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                    this.mSA.a(eVar);
                    a dDA5 = a.dDA();
                    if (dDA5 == null || this.mSE == null || !this.mSE.lO()) {
                        return;
                    }
                    dDA5.a(this.mSA);
                    return;
                }
                eVar.exception = String.valueOf(this.mSA.dDD().responseCode) + "|retryCount:" + i4;
                z = as(this.mSA.dDD().responseCode);
                this.mSA.a(eVar);
                if (this.LH <= 0 && this.mSE != null) {
                    this.LH = this.mSE.lL();
                }
                eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                this.mSA.a(eVar);
                a dDA6 = a.dDA();
                if (dDA6 != null && this.mSE != null && this.mSE.lO()) {
                    dDA6.a(this.mSA);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.LH <= 0 && this.mSE != null) {
                    this.LH = this.mSE.lL();
                }
                eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                this.mSA.a(eVar);
                a dDA7 = a.dDA();
                if (dDA7 != null && this.mSE != null && this.mSE.lO()) {
                    dDA7.a(this.mSA);
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
        if (this.mSA.dDC().lY()) {
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
            i2 = com.baidu.adp.framework.d.b.kY().lb().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kY().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.kY().kZ().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.mSA.dDD().MD && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.LX = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.mSE = new b(this.mSA);
                        this.mSE.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.mSA.dDD().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.mSA.a(eVar);
                        if (this.LH <= 0 && this.mSE != null) {
                            this.LH = this.mSE.lL();
                        }
                        eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                        this.mSA.a(eVar);
                        a dDA = a.dDA();
                        if (dDA != null) {
                            dDA.a(this.mSA);
                        }
                    } catch (Throwable th) {
                        this.mSA.dDD().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.mSA.a(eVar);
                        if (this.LH <= 0 && this.mSE != null) {
                            this.LH = this.mSE.lL();
                        }
                        eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                        this.mSA.a(eVar);
                        a dDA2 = a.dDA();
                        if (dDA2 != null) {
                            dDA2.a(this.mSA);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.mSA.dDD().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.mSA.a(eVar);
                    if (this.LH <= 0 && this.mSE != null) {
                        this.LH = this.mSE.lL();
                    }
                    eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                    this.mSA.a(eVar);
                    a dDA3 = a.dDA();
                    if (dDA3 != null) {
                        dDA3.a(this.mSA);
                    }
                } catch (SocketException e3) {
                    this.mSA.dDD().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.mSA.a(eVar);
                    if (this.LH <= 0 && this.mSE != null) {
                        this.LH = this.mSE.lL();
                    }
                    eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                    this.mSA.a(eVar);
                    a dDA4 = a.dDA();
                    if (dDA4 != null) {
                        dDA4.a(this.mSA);
                    }
                }
                if (this.mSA.dDD().responseCode == 200) {
                    if (this.LH <= 0 && this.mSE != null) {
                        this.LH = this.mSE.lL();
                    }
                    eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                    this.mSA.a(eVar);
                    a dDA5 = a.dDA();
                    if (dDA5 != null) {
                        dDA5.a(this.mSA);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.mSA.dDD().responseCode) + "|retryCount:" + i4;
                z = as(this.mSA.dDD().responseCode);
                this.mSA.a(eVar);
                if (this.LH <= 0 && this.mSE != null) {
                    this.LH = this.mSE.lL();
                }
                eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                this.mSA.a(eVar);
                a dDA6 = a.dDA();
                if (dDA6 != null) {
                    dDA6.a(this.mSA);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.LH <= 0 && this.mSE != null) {
                    this.LH = this.mSE.lL();
                }
                eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.mSA.dDC().getUrl(), this.mSA.dDC().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                this.mSA.a(eVar);
                a dDA7 = a.dDA();
                if (dDA7 != null) {
                    dDA7.a(this.mSA);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.mSE != null) {
            this.mSE.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.mSA == null) {
            return false;
        }
        return this.mSA.dDD().MD;
    }

    public void setCancel() {
        if (this.mSA != null) {
            this.mSA.dDD().MD = true;
        }
    }
}
