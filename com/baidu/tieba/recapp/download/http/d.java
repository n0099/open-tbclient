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
    private b kKD;
    private g kKz;
    private int JZ = 0;
    private long JM = 0;

    public d(g gVar) {
        this.kKz = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.jJ().jM().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jJ().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.jJ().jK().getTimeOutAuto() : i4;
        this.kKD = new b(this.kKz);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.JZ = i5;
                boolean a = this.kKD.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                this.kKz.a(eVar);
                a cUz = a.cUz();
                if (cUz != null) {
                    cUz.a(this.kKz);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.kKz.cUC().responseCode = -100;
                    eVar.exception = String.valueOf(this.kKz.cUC().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.kKz.a(eVar);
                    com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                    this.kKz.a(eVar);
                    a cUz2 = a.cUz();
                    if (cUz2 != null) {
                        cUz2.a(this.kKz);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                    this.kKz.a(eVar);
                    a cUz3 = a.cUz();
                    if (cUz3 != null) {
                        cUz3.a(this.kKz);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.kKz.cUC().responseCode = -10;
                eVar.exception = String.valueOf(this.kKz.cUC().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.kKz.a(eVar);
                com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                this.kKz.a(eVar);
                a cUz4 = a.cUz();
                if (cUz4 != null) {
                    cUz4.a(this.kKz);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.d.b.jJ().jM().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jJ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.jJ().jK().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.kKz.cUC().KE && z && i4 < i; i4++) {
            e eVar = new e();
            this.kKz.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.JZ = i4;
                                eVar.retry = i4 + 1;
                                eVar.Ko = 1;
                                this.kKD = new b(this.kKz);
                                this.kKD.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.kKz.cUC().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.JM <= 0 && this.kKD != null) {
                                    this.JM = this.kKD.ku();
                                }
                                eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                                this.kKz.b(eVar);
                                a cUz = a.cUz();
                                if (cUz != null) {
                                    cUz.a(this.kKz);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.kKz.cUC().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.kKz.cUC().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.JM <= 0 && this.kKD != null) {
                                this.JM = this.kKD.ku();
                            }
                            eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                            this.kKz.b(eVar);
                            a cUz2 = a.cUz();
                            if (cUz2 != null) {
                                cUz2.a(this.kKz);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.kKz.cUC().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.kKz.cUC().mNetErrorCode = -13;
                        if (this.JM <= 0 && this.kKD != null) {
                            this.JM = this.kKD.ku();
                        }
                        eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                        this.kKz.b(eVar);
                        a cUz3 = a.cUz();
                        if (cUz3 != null) {
                            cUz3.a(this.kKz);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.kKz.cUC().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.kKz.cUC().mNetErrorCode = -12;
                    if (this.JM <= 0 && this.kKD != null) {
                        this.JM = this.kKD.ku();
                    }
                    eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                    this.kKz.b(eVar);
                    a cUz4 = a.cUz();
                    if (cUz4 != null) {
                        cUz4.a(this.kKz);
                    }
                    z = true;
                }
                if (this.kKz.cUC().responseCode == 200) {
                    this.kKz.b(eVar);
                    if (this.JM <= 0 && this.kKD != null) {
                        this.JM = this.kKD.ku();
                    }
                    eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                    this.kKz.b(eVar);
                    a cUz5 = a.cUz();
                    if (cUz5 != null) {
                        cUz5.a(this.kKz);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.kKz.cUC().responseCode) + "|retryCount:" + i4;
                boolean ac = ac(this.kKz.cUC().responseCode);
                if (this.JM <= 0 && this.kKD != null) {
                    this.JM = this.kKD.ku();
                }
                eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                this.kKz.b(eVar);
                a cUz6 = a.cUz();
                if (cUz6 != null) {
                    cUz6.a(this.kKz);
                }
                z = ac;
            } catch (Throwable th) {
                if (this.JM <= 0 && this.kKD != null) {
                    this.JM = this.kKD.ku();
                }
                eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                this.kKz.b(eVar);
                a cUz7 = a.cUz();
                if (cUz7 != null) {
                    cUz7.a(this.kKz);
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
            i2 = com.baidu.adp.framework.d.b.jJ().jM().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jJ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.jJ().jK().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.kKz.cUC().KE && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.JZ = i4;
            try {
                try {
                    try {
                        this.kKD = new b(this.kKz);
                        this.kKD.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.kKz.cUC().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.kKz.a(eVar);
                        if (this.JM <= 0 && this.kKD != null) {
                            this.JM = this.kKD.ku();
                        }
                        eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                        this.kKz.a(eVar);
                        a cUz = a.cUz();
                        if (cUz != null && this.kKD != null && this.kKD.kx()) {
                            cUz.a(this.kKz);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.kKz.cUC().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.kKz.a(eVar);
                        if (this.JM <= 0 && this.kKD != null) {
                            this.JM = this.kKD.ku();
                        }
                        eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                        this.kKz.a(eVar);
                        a cUz2 = a.cUz();
                        if (cUz2 != null && this.kKD != null && this.kKD.kx()) {
                            cUz2.a(this.kKz);
                        }
                    }
                } catch (SocketException e3) {
                    this.kKz.cUC().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.kKz.a(eVar);
                    if (this.JM <= 0 && this.kKD != null) {
                        this.JM = this.kKD.ku();
                    }
                    eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                    this.kKz.a(eVar);
                    a cUz3 = a.cUz();
                    if (cUz3 != null && this.kKD != null && this.kKD.kx()) {
                        cUz3.a(this.kKz);
                    }
                } catch (Throwable th) {
                    this.kKz.cUC().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.kKz.a(eVar);
                    if (this.JM <= 0 && this.kKD != null) {
                        this.JM = this.kKD.ku();
                    }
                    eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                    this.kKz.a(eVar);
                    a cUz4 = a.cUz();
                    if (cUz4 != null && this.kKD != null && this.kKD.kx()) {
                        cUz4.a(this.kKz);
                    }
                }
                if (this.kKz.cUC().responseCode == 200) {
                    if (this.JM <= 0 && this.kKD != null) {
                        this.JM = this.kKD.ku();
                    }
                    eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                    this.kKz.a(eVar);
                    a cUz5 = a.cUz();
                    if (cUz5 == null || this.kKD == null || !this.kKD.kx()) {
                        return;
                    }
                    cUz5.a(this.kKz);
                    return;
                }
                eVar.exception = String.valueOf(this.kKz.cUC().responseCode) + "|retryCount:" + i4;
                z = ac(this.kKz.cUC().responseCode);
                this.kKz.a(eVar);
                if (this.JM <= 0 && this.kKD != null) {
                    this.JM = this.kKD.ku();
                }
                eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                this.kKz.a(eVar);
                a cUz6 = a.cUz();
                if (cUz6 != null && this.kKD != null && this.kKD.kx()) {
                    cUz6.a(this.kKz);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.JM <= 0 && this.kKD != null) {
                    this.JM = this.kKD.ku();
                }
                eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                this.kKz.a(eVar);
                a cUz7 = a.cUz();
                if (cUz7 != null && this.kKD != null && this.kKD.kx()) {
                    cUz7.a(this.kKz);
                }
                throw th2;
            }
        }
    }

    private boolean ac(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.kKz.cUB().kH()) {
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
            i2 = com.baidu.adp.framework.d.b.jJ().jM().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jJ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.jJ().jK().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.kKz.cUC().KE && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.JZ = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.kKD = new b(this.kKz);
                        this.kKD.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.kKz.cUC().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.kKz.a(eVar);
                        if (this.JM <= 0 && this.kKD != null) {
                            this.JM = this.kKD.ku();
                        }
                        eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                        this.kKz.a(eVar);
                        a cUz = a.cUz();
                        if (cUz != null) {
                            cUz.a(this.kKz);
                        }
                    } catch (Throwable th) {
                        this.kKz.cUC().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.kKz.a(eVar);
                        if (this.JM <= 0 && this.kKD != null) {
                            this.JM = this.kKD.ku();
                        }
                        eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                        this.kKz.a(eVar);
                        a cUz2 = a.cUz();
                        if (cUz2 != null) {
                            cUz2.a(this.kKz);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.kKz.cUC().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.kKz.a(eVar);
                    if (this.JM <= 0 && this.kKD != null) {
                        this.JM = this.kKD.ku();
                    }
                    eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                    this.kKz.a(eVar);
                    a cUz3 = a.cUz();
                    if (cUz3 != null) {
                        cUz3.a(this.kKz);
                    }
                } catch (SocketException e3) {
                    this.kKz.cUC().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.kKz.a(eVar);
                    if (this.JM <= 0 && this.kKD != null) {
                        this.JM = this.kKD.ku();
                    }
                    eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                    this.kKz.a(eVar);
                    a cUz4 = a.cUz();
                    if (cUz4 != null) {
                        cUz4.a(this.kKz);
                    }
                }
                if (this.kKz.cUC().responseCode == 200) {
                    if (this.JM <= 0 && this.kKD != null) {
                        this.JM = this.kKD.ku();
                    }
                    eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                    this.kKz.a(eVar);
                    a cUz5 = a.cUz();
                    if (cUz5 != null) {
                        cUz5.a(this.kKz);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.kKz.cUC().responseCode) + "|retryCount:" + i4;
                z = ac(this.kKz.cUC().responseCode);
                this.kKz.a(eVar);
                if (this.JM <= 0 && this.kKD != null) {
                    this.JM = this.kKD.ku();
                }
                eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                this.kKz.a(eVar);
                a cUz6 = a.cUz();
                if (cUz6 != null) {
                    cUz6.a(this.kKz);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.JM <= 0 && this.kKD != null) {
                    this.JM = this.kKD.ku();
                }
                eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ki().a(this.kKz.cUB().getUrl(), this.kKz.cUB().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                this.kKz.a(eVar);
                a cUz7 = a.cUz();
                if (cUz7 != null) {
                    cUz7.a(this.kKz);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.kKD != null) {
            this.kKD.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.kKz == null) {
            return false;
        }
        return this.kKz.cUC().KE;
    }

    public void setCancel() {
        if (this.kKz != null) {
            this.kKz.cUC().KE = true;
        }
    }
}
