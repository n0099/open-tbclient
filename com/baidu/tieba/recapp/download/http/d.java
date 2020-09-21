package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes25.dex */
public class d {
    private b lMC;
    private g lMy;
    private int Ln = 0;
    private long KZ = 0;

    public d(g gVar) {
        this.lMy = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.lC().lF().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lC().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.lC().lD().getTimeOutAuto() : i4;
        this.lMC = new b(this.lMy);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.Ln = i5;
                boolean a = this.lMC.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                this.lMy.a(eVar);
                a drh = a.drh();
                if (drh != null) {
                    drh.a(this.lMy);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.lMy.drk().responseCode = -100;
                    eVar.exception = String.valueOf(this.lMy.drk().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.lMy.a(eVar);
                    com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                    this.lMy.a(eVar);
                    a drh2 = a.drh();
                    if (drh2 != null) {
                        drh2.a(this.lMy);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                    this.lMy.a(eVar);
                    a drh3 = a.drh();
                    if (drh3 != null) {
                        drh3.a(this.lMy);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.lMy.drk().responseCode = -10;
                eVar.exception = String.valueOf(this.lMy.drk().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.lMy.a(eVar);
                com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                this.lMy.a(eVar);
                a drh4 = a.drh();
                if (drh4 != null) {
                    drh4.a(this.lMy);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.d.b.lC().lF().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lC().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.lC().lD().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.lMy.drk().LX && z && i4 < i; i4++) {
            e eVar = new e();
            this.lMy.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.Ln = i4;
                                eVar.retry = i4 + 1;
                                eVar.LC = 1;
                                this.lMC = new b(this.lMy);
                                this.lMC.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.lMy.drk().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.KZ <= 0 && this.lMC != null) {
                                    this.KZ = this.lMC.mn();
                                }
                                eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                                this.lMy.b(eVar);
                                a drh = a.drh();
                                if (drh != null) {
                                    drh.a(this.lMy);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.lMy.drk().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.lMy.drk().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.KZ <= 0 && this.lMC != null) {
                                this.KZ = this.lMC.mn();
                            }
                            eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                            this.lMy.b(eVar);
                            a drh2 = a.drh();
                            if (drh2 != null) {
                                drh2.a(this.lMy);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.lMy.drk().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.lMy.drk().mNetErrorCode = -13;
                        if (this.KZ <= 0 && this.lMC != null) {
                            this.KZ = this.lMC.mn();
                        }
                        eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                        this.lMy.b(eVar);
                        a drh3 = a.drh();
                        if (drh3 != null) {
                            drh3.a(this.lMy);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.lMy.drk().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.lMy.drk().mNetErrorCode = -12;
                    if (this.KZ <= 0 && this.lMC != null) {
                        this.KZ = this.lMC.mn();
                    }
                    eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                    this.lMy.b(eVar);
                    a drh4 = a.drh();
                    if (drh4 != null) {
                        drh4.a(this.lMy);
                    }
                    z = true;
                }
                if (this.lMy.drk().responseCode == 200) {
                    this.lMy.b(eVar);
                    if (this.KZ <= 0 && this.lMC != null) {
                        this.KZ = this.lMC.mn();
                    }
                    eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                    this.lMy.b(eVar);
                    a drh5 = a.drh();
                    if (drh5 != null) {
                        drh5.a(this.lMy);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.lMy.drk().responseCode) + "|retryCount:" + i4;
                boolean ap = ap(this.lMy.drk().responseCode);
                if (this.KZ <= 0 && this.lMC != null) {
                    this.KZ = this.lMC.mn();
                }
                eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                this.lMy.b(eVar);
                a drh6 = a.drh();
                if (drh6 != null) {
                    drh6.a(this.lMy);
                }
                z = ap;
            } catch (Throwable th) {
                if (this.KZ <= 0 && this.lMC != null) {
                    this.KZ = this.lMC.mn();
                }
                eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                this.lMy.b(eVar);
                a drh7 = a.drh();
                if (drh7 != null) {
                    drh7.a(this.lMy);
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
            i2 = com.baidu.adp.framework.d.b.lC().lF().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lC().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.lC().lD().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.lMy.drk().LX && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.Ln = i4;
            try {
                try {
                    try {
                        this.lMC = new b(this.lMy);
                        this.lMC.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.lMy.drk().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.lMy.a(eVar);
                        if (this.KZ <= 0 && this.lMC != null) {
                            this.KZ = this.lMC.mn();
                        }
                        eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                        this.lMy.a(eVar);
                        a drh = a.drh();
                        if (drh != null && this.lMC != null && this.lMC.mq()) {
                            drh.a(this.lMy);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.lMy.drk().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.lMy.a(eVar);
                        if (this.KZ <= 0 && this.lMC != null) {
                            this.KZ = this.lMC.mn();
                        }
                        eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                        this.lMy.a(eVar);
                        a drh2 = a.drh();
                        if (drh2 != null && this.lMC != null && this.lMC.mq()) {
                            drh2.a(this.lMy);
                        }
                    }
                } catch (SocketException e3) {
                    this.lMy.drk().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.lMy.a(eVar);
                    if (this.KZ <= 0 && this.lMC != null) {
                        this.KZ = this.lMC.mn();
                    }
                    eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                    this.lMy.a(eVar);
                    a drh3 = a.drh();
                    if (drh3 != null && this.lMC != null && this.lMC.mq()) {
                        drh3.a(this.lMy);
                    }
                } catch (Throwable th) {
                    this.lMy.drk().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.lMy.a(eVar);
                    if (this.KZ <= 0 && this.lMC != null) {
                        this.KZ = this.lMC.mn();
                    }
                    eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                    this.lMy.a(eVar);
                    a drh4 = a.drh();
                    if (drh4 != null && this.lMC != null && this.lMC.mq()) {
                        drh4.a(this.lMy);
                    }
                }
                if (this.lMy.drk().responseCode == 200) {
                    if (this.KZ <= 0 && this.lMC != null) {
                        this.KZ = this.lMC.mn();
                    }
                    eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                    this.lMy.a(eVar);
                    a drh5 = a.drh();
                    if (drh5 == null || this.lMC == null || !this.lMC.mq()) {
                        return;
                    }
                    drh5.a(this.lMy);
                    return;
                }
                eVar.exception = String.valueOf(this.lMy.drk().responseCode) + "|retryCount:" + i4;
                z = ap(this.lMy.drk().responseCode);
                this.lMy.a(eVar);
                if (this.KZ <= 0 && this.lMC != null) {
                    this.KZ = this.lMC.mn();
                }
                eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                this.lMy.a(eVar);
                a drh6 = a.drh();
                if (drh6 != null && this.lMC != null && this.lMC.mq()) {
                    drh6.a(this.lMy);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.KZ <= 0 && this.lMC != null) {
                    this.KZ = this.lMC.mn();
                }
                eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                this.lMy.a(eVar);
                a drh7 = a.drh();
                if (drh7 != null && this.lMC != null && this.lMC.mq()) {
                    drh7.a(this.lMy);
                }
                throw th2;
            }
        }
    }

    private boolean ap(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.lMy.drj().mA()) {
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
            i2 = com.baidu.adp.framework.d.b.lC().lF().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lC().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.lC().lD().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.lMy.drk().LX && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.Ln = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.lMC = new b(this.lMy);
                        this.lMC.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.lMy.drk().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.lMy.a(eVar);
                        if (this.KZ <= 0 && this.lMC != null) {
                            this.KZ = this.lMC.mn();
                        }
                        eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                        this.lMy.a(eVar);
                        a drh = a.drh();
                        if (drh != null) {
                            drh.a(this.lMy);
                        }
                    } catch (Throwable th) {
                        this.lMy.drk().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.lMy.a(eVar);
                        if (this.KZ <= 0 && this.lMC != null) {
                            this.KZ = this.lMC.mn();
                        }
                        eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                        this.lMy.a(eVar);
                        a drh2 = a.drh();
                        if (drh2 != null) {
                            drh2.a(this.lMy);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.lMy.drk().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.lMy.a(eVar);
                    if (this.KZ <= 0 && this.lMC != null) {
                        this.KZ = this.lMC.mn();
                    }
                    eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                    this.lMy.a(eVar);
                    a drh3 = a.drh();
                    if (drh3 != null) {
                        drh3.a(this.lMy);
                    }
                } catch (SocketException e3) {
                    this.lMy.drk().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.lMy.a(eVar);
                    if (this.KZ <= 0 && this.lMC != null) {
                        this.KZ = this.lMC.mn();
                    }
                    eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                    this.lMy.a(eVar);
                    a drh4 = a.drh();
                    if (drh4 != null) {
                        drh4.a(this.lMy);
                    }
                }
                if (this.lMy.drk().responseCode == 200) {
                    if (this.KZ <= 0 && this.lMC != null) {
                        this.KZ = this.lMC.mn();
                    }
                    eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                    this.lMy.a(eVar);
                    a drh5 = a.drh();
                    if (drh5 != null) {
                        drh5.a(this.lMy);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.lMy.drk().responseCode) + "|retryCount:" + i4;
                z = ap(this.lMy.drk().responseCode);
                this.lMy.a(eVar);
                if (this.KZ <= 0 && this.lMC != null) {
                    this.KZ = this.lMC.mn();
                }
                eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                this.lMy.a(eVar);
                a drh6 = a.drh();
                if (drh6 != null) {
                    drh6.a(this.lMy);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.KZ <= 0 && this.lMC != null) {
                    this.KZ = this.lMC.mn();
                }
                eVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mb().a(this.lMy.drj().getUrl(), this.lMy.drj().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.Lv != null);
                this.lMy.a(eVar);
                a drh7 = a.drh();
                if (drh7 != null) {
                    drh7.a(this.lMy);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.lMC != null) {
            this.lMC.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.lMy == null) {
            return false;
        }
        return this.lMy.drk().LX;
    }

    public void setCancel() {
        if (this.lMy != null) {
            this.lMy.drk().LX = true;
        }
    }
}
