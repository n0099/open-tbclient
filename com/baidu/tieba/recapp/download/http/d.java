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
    private int JL = 0;
    private long Jz = 0;
    private g ksB;
    private b ksF;

    public d(g gVar) {
        this.ksB = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.c.b.jH().jK().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.jH().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.c.b.jH().jI().getTimeOutAuto() : i4;
        this.ksF = new b(this.ksB);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.JL = i5;
                boolean a = this.ksF.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                this.ksB.a(eVar);
                a cNB = a.cNB();
                if (cNB != null) {
                    cNB.a(this.ksB);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.ksB.cNE().responseCode = -100;
                    eVar.exception = String.valueOf(this.ksB.cNE().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.ksB.a(eVar);
                    com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                    this.ksB.a(eVar);
                    a cNB2 = a.cNB();
                    if (cNB2 != null) {
                        cNB2.a(this.ksB);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                    this.ksB.a(eVar);
                    a cNB3 = a.cNB();
                    if (cNB3 != null) {
                        cNB3.a(this.ksB);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.ksB.cNE().responseCode = -10;
                eVar.exception = String.valueOf(this.ksB.cNE().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.ksB.a(eVar);
                com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                this.ksB.a(eVar);
                a cNB4 = a.cNB();
                if (cNB4 != null) {
                    cNB4.a(this.ksB);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.jH().jK().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.jH().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.jH().jI().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.ksB.cNE().Kp && z && i4 < i; i4++) {
            e eVar = new e();
            this.ksB.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.JL = i4;
                                eVar.retry = i4 + 1;
                                eVar.JZ = 1;
                                this.ksF = new b(this.ksB);
                                this.ksF.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.ksB.cNE().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Jz <= 0 && this.ksF != null) {
                                    this.Jz = this.ksF.ks();
                                }
                                eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                                this.ksB.b(eVar);
                                a cNB = a.cNB();
                                if (cNB != null) {
                                    cNB.a(this.ksB);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.ksB.cNE().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.ksB.cNE().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Jz <= 0 && this.ksF != null) {
                                this.Jz = this.ksF.ks();
                            }
                            eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                            this.ksB.b(eVar);
                            a cNB2 = a.cNB();
                            if (cNB2 != null) {
                                cNB2.a(this.ksB);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.ksB.cNE().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.ksB.cNE().mNetErrorCode = -13;
                        if (this.Jz <= 0 && this.ksF != null) {
                            this.Jz = this.ksF.ks();
                        }
                        eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                        this.ksB.b(eVar);
                        a cNB3 = a.cNB();
                        if (cNB3 != null) {
                            cNB3.a(this.ksB);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.ksB.cNE().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.ksB.cNE().mNetErrorCode = -12;
                    if (this.Jz <= 0 && this.ksF != null) {
                        this.Jz = this.ksF.ks();
                    }
                    eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                    this.ksB.b(eVar);
                    a cNB4 = a.cNB();
                    if (cNB4 != null) {
                        cNB4.a(this.ksB);
                    }
                    z = true;
                }
                if (this.ksB.cNE().responseCode == 200) {
                    this.ksB.b(eVar);
                    if (this.Jz <= 0 && this.ksF != null) {
                        this.Jz = this.ksF.ks();
                    }
                    eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                    this.ksB.b(eVar);
                    a cNB5 = a.cNB();
                    if (cNB5 != null) {
                        cNB5.a(this.ksB);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.ksB.cNE().responseCode) + "|retryCount:" + i4;
                boolean ab = ab(this.ksB.cNE().responseCode);
                if (this.Jz <= 0 && this.ksF != null) {
                    this.Jz = this.ksF.ks();
                }
                eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                this.ksB.b(eVar);
                a cNB6 = a.cNB();
                if (cNB6 != null) {
                    cNB6.a(this.ksB);
                }
                z = ab;
            } catch (Throwable th) {
                if (this.Jz <= 0 && this.ksF != null) {
                    this.Jz = this.ksF.ks();
                }
                eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                this.ksB.b(eVar);
                a cNB7 = a.cNB();
                if (cNB7 != null) {
                    cNB7.a(this.ksB);
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
            i2 = com.baidu.adp.framework.c.b.jH().jK().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.jH().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.jH().jI().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.ksB.cNE().Kp && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.JL = i4;
            try {
                try {
                    try {
                        this.ksF = new b(this.ksB);
                        this.ksF.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.ksB.cNE().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.ksB.a(eVar);
                        if (this.Jz <= 0 && this.ksF != null) {
                            this.Jz = this.ksF.ks();
                        }
                        eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                        this.ksB.a(eVar);
                        a cNB = a.cNB();
                        if (cNB != null && this.ksF != null && this.ksF.kv()) {
                            cNB.a(this.ksB);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.ksB.cNE().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.ksB.a(eVar);
                        if (this.Jz <= 0 && this.ksF != null) {
                            this.Jz = this.ksF.ks();
                        }
                        eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                        this.ksB.a(eVar);
                        a cNB2 = a.cNB();
                        if (cNB2 != null && this.ksF != null && this.ksF.kv()) {
                            cNB2.a(this.ksB);
                        }
                    }
                } catch (SocketException e3) {
                    this.ksB.cNE().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.ksB.a(eVar);
                    if (this.Jz <= 0 && this.ksF != null) {
                        this.Jz = this.ksF.ks();
                    }
                    eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                    this.ksB.a(eVar);
                    a cNB3 = a.cNB();
                    if (cNB3 != null && this.ksF != null && this.ksF.kv()) {
                        cNB3.a(this.ksB);
                    }
                } catch (Throwable th) {
                    this.ksB.cNE().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.ksB.a(eVar);
                    if (this.Jz <= 0 && this.ksF != null) {
                        this.Jz = this.ksF.ks();
                    }
                    eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                    this.ksB.a(eVar);
                    a cNB4 = a.cNB();
                    if (cNB4 != null && this.ksF != null && this.ksF.kv()) {
                        cNB4.a(this.ksB);
                    }
                }
                if (this.ksB.cNE().responseCode == 200) {
                    if (this.Jz <= 0 && this.ksF != null) {
                        this.Jz = this.ksF.ks();
                    }
                    eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                    this.ksB.a(eVar);
                    a cNB5 = a.cNB();
                    if (cNB5 == null || this.ksF == null || !this.ksF.kv()) {
                        return;
                    }
                    cNB5.a(this.ksB);
                    return;
                }
                eVar.exception = String.valueOf(this.ksB.cNE().responseCode) + "|retryCount:" + i4;
                z = ab(this.ksB.cNE().responseCode);
                this.ksB.a(eVar);
                if (this.Jz <= 0 && this.ksF != null) {
                    this.Jz = this.ksF.ks();
                }
                eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                this.ksB.a(eVar);
                a cNB6 = a.cNB();
                if (cNB6 != null && this.ksF != null && this.ksF.kv()) {
                    cNB6.a(this.ksB);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Jz <= 0 && this.ksF != null) {
                    this.Jz = this.ksF.ks();
                }
                eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                this.ksB.a(eVar);
                a cNB7 = a.cNB();
                if (cNB7 != null && this.ksF != null && this.ksF.kv()) {
                    cNB7.a(this.ksB);
                }
                throw th2;
            }
        }
    }

    private boolean ab(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.ksB.cND().kF()) {
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
            i2 = com.baidu.adp.framework.c.b.jH().jK().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.jH().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.jH().jI().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.ksB.cNE().Kp && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.JL = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.ksF = new b(this.ksB);
                        this.ksF.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.ksB.cNE().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.ksB.a(eVar);
                        if (this.Jz <= 0 && this.ksF != null) {
                            this.Jz = this.ksF.ks();
                        }
                        eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                        this.ksB.a(eVar);
                        a cNB = a.cNB();
                        if (cNB != null) {
                            cNB.a(this.ksB);
                        }
                    } catch (Throwable th) {
                        this.ksB.cNE().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.ksB.a(eVar);
                        if (this.Jz <= 0 && this.ksF != null) {
                            this.Jz = this.ksF.ks();
                        }
                        eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                        this.ksB.a(eVar);
                        a cNB2 = a.cNB();
                        if (cNB2 != null) {
                            cNB2.a(this.ksB);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.ksB.cNE().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.ksB.a(eVar);
                    if (this.Jz <= 0 && this.ksF != null) {
                        this.Jz = this.ksF.ks();
                    }
                    eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                    this.ksB.a(eVar);
                    a cNB3 = a.cNB();
                    if (cNB3 != null) {
                        cNB3.a(this.ksB);
                    }
                } catch (SocketException e3) {
                    this.ksB.cNE().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.ksB.a(eVar);
                    if (this.Jz <= 0 && this.ksF != null) {
                        this.Jz = this.ksF.ks();
                    }
                    eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                    this.ksB.a(eVar);
                    a cNB4 = a.cNB();
                    if (cNB4 != null) {
                        cNB4.a(this.ksB);
                    }
                }
                if (this.ksB.cNE().responseCode == 200) {
                    if (this.Jz <= 0 && this.ksF != null) {
                        this.Jz = this.ksF.ks();
                    }
                    eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                    this.ksB.a(eVar);
                    a cNB5 = a.cNB();
                    if (cNB5 != null) {
                        cNB5.a(this.ksB);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.ksB.cNE().responseCode) + "|retryCount:" + i4;
                z = ab(this.ksB.cNE().responseCode);
                this.ksB.a(eVar);
                if (this.Jz <= 0 && this.ksF != null) {
                    this.Jz = this.ksF.ks();
                }
                eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                this.ksB.a(eVar);
                a cNB6 = a.cNB();
                if (cNB6 != null) {
                    cNB6.a(this.ksB);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Jz <= 0 && this.ksF != null) {
                    this.Jz = this.ksF.ks();
                }
                eVar.JO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.kg().a(this.ksB.cND().getUrl(), this.ksB.cND().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JS != null);
                this.ksB.a(eVar);
                a cNB7 = a.cNB();
                if (cNB7 != null) {
                    cNB7.a(this.ksB);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.ksF != null) {
            this.ksF.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.ksB == null) {
            return false;
        }
        return this.ksB.cNE().Kp;
    }

    public void setCancel() {
        if (this.ksB != null) {
            this.ksB.cNE().Kp = true;
        }
    }
}
