package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes26.dex */
public class d {
    private int LD = 0;
    private long Lp = 0;
    private g mul;
    private b mup;

    public d(g gVar) {
        this.mul = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.lD().lG().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lD().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.lD().lE().getTimeOutAuto() : i4;
        this.mup = new b(this.mul);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.LD = i5;
                boolean a2 = this.mup.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.mul.a(eVar);
                a dAB = a.dAB();
                if (dAB != null) {
                    dAB.a(this.mul);
                }
                return a2;
            } catch (FileNotFoundException e) {
                try {
                    this.mul.dAE().responseCode = -100;
                    eVar.exception = String.valueOf(this.mul.dAE().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.mul.a(eVar);
                    com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.mul.a(eVar);
                    a dAB2 = a.dAB();
                    if (dAB2 != null) {
                        dAB2.a(this.mul);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.mul.a(eVar);
                    a dAB3 = a.dAB();
                    if (dAB3 != null) {
                        dAB3.a(this.mul);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.mul.dAE().responseCode = -10;
                eVar.exception = String.valueOf(this.mul.dAE().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.mul.a(eVar);
                com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.mul.a(eVar);
                a dAB4 = a.dAB();
                if (dAB4 != null) {
                    dAB4.a(this.mul);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.d.b.lD().lG().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lD().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.lD().lE().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.mul.dAE().Mo && z && i4 < i; i4++) {
            e eVar = new e();
            this.mul.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.LD = i4;
                                eVar.retry = i4 + 1;
                                eVar.LY = 1;
                                this.mup = new b(this.mul);
                                this.mup.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.mul.dAE().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Lp <= 0 && this.mup != null) {
                                    this.Lp = this.mup.mo();
                                }
                                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                                this.mul.b(eVar);
                                a dAB = a.dAB();
                                if (dAB != null) {
                                    dAB.a(this.mul);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.mul.dAE().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.mul.dAE().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Lp <= 0 && this.mup != null) {
                                this.Lp = this.mup.mo();
                            }
                            eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                            this.mul.b(eVar);
                            a dAB2 = a.dAB();
                            if (dAB2 != null) {
                                dAB2.a(this.mul);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.mul.dAE().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.mul.dAE().mNetErrorCode = -13;
                        if (this.Lp <= 0 && this.mup != null) {
                            this.Lp = this.mup.mo();
                        }
                        eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                        this.mul.b(eVar);
                        a dAB3 = a.dAB();
                        if (dAB3 != null) {
                            dAB3.a(this.mul);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.mul.dAE().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.mul.dAE().mNetErrorCode = -12;
                    if (this.Lp <= 0 && this.mup != null) {
                        this.Lp = this.mup.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.mul.b(eVar);
                    a dAB4 = a.dAB();
                    if (dAB4 != null) {
                        dAB4.a(this.mul);
                    }
                    z = true;
                }
                if (this.mul.dAE().responseCode == 200) {
                    this.mul.b(eVar);
                    if (this.Lp <= 0 && this.mup != null) {
                        this.Lp = this.mup.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.mul.b(eVar);
                    a dAB5 = a.dAB();
                    if (dAB5 != null) {
                        dAB5.a(this.mul);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.mul.dAE().responseCode) + "|retryCount:" + i4;
                boolean ap = ap(this.mul.dAE().responseCode);
                if (this.Lp <= 0 && this.mup != null) {
                    this.Lp = this.mup.mo();
                }
                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.mul.b(eVar);
                a dAB6 = a.dAB();
                if (dAB6 != null) {
                    dAB6.a(this.mul);
                }
                z = ap;
            } catch (Throwable th) {
                if (this.Lp <= 0 && this.mup != null) {
                    this.Lp = this.mup.mo();
                }
                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.mul.b(eVar);
                a dAB7 = a.dAB();
                if (dAB7 != null) {
                    dAB7.a(this.mul);
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
            i2 = com.baidu.adp.framework.d.b.lD().lG().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lD().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.lD().lE().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.mul.dAE().Mo && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.LD = i4;
            try {
                try {
                    try {
                        this.mup = new b(this.mul);
                        this.mup.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.mul.dAE().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.mul.a(eVar);
                        if (this.Lp <= 0 && this.mup != null) {
                            this.Lp = this.mup.mo();
                        }
                        eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                        this.mul.a(eVar);
                        a dAB = a.dAB();
                        if (dAB != null && this.mup != null && this.mup.mr()) {
                            dAB.a(this.mul);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.mul.dAE().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.mul.a(eVar);
                        if (this.Lp <= 0 && this.mup != null) {
                            this.Lp = this.mup.mo();
                        }
                        eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                        this.mul.a(eVar);
                        a dAB2 = a.dAB();
                        if (dAB2 != null && this.mup != null && this.mup.mr()) {
                            dAB2.a(this.mul);
                        }
                    }
                } catch (SocketException e3) {
                    this.mul.dAE().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.mul.a(eVar);
                    if (this.Lp <= 0 && this.mup != null) {
                        this.Lp = this.mup.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.mul.a(eVar);
                    a dAB3 = a.dAB();
                    if (dAB3 != null && this.mup != null && this.mup.mr()) {
                        dAB3.a(this.mul);
                    }
                } catch (Throwable th) {
                    this.mul.dAE().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.mul.a(eVar);
                    if (this.Lp <= 0 && this.mup != null) {
                        this.Lp = this.mup.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.mul.a(eVar);
                    a dAB4 = a.dAB();
                    if (dAB4 != null && this.mup != null && this.mup.mr()) {
                        dAB4.a(this.mul);
                    }
                }
                if (this.mul.dAE().responseCode == 200) {
                    if (this.Lp <= 0 && this.mup != null) {
                        this.Lp = this.mup.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.mul.a(eVar);
                    a dAB5 = a.dAB();
                    if (dAB5 == null || this.mup == null || !this.mup.mr()) {
                        return;
                    }
                    dAB5.a(this.mul);
                    return;
                }
                eVar.exception = String.valueOf(this.mul.dAE().responseCode) + "|retryCount:" + i4;
                z = ap(this.mul.dAE().responseCode);
                this.mul.a(eVar);
                if (this.Lp <= 0 && this.mup != null) {
                    this.Lp = this.mup.mo();
                }
                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.mul.a(eVar);
                a dAB6 = a.dAB();
                if (dAB6 != null && this.mup != null && this.mup.mr()) {
                    dAB6.a(this.mul);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Lp <= 0 && this.mup != null) {
                    this.Lp = this.mup.mo();
                }
                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.mul.a(eVar);
                a dAB7 = a.dAB();
                if (dAB7 != null && this.mup != null && this.mup.mr()) {
                    dAB7.a(this.mul);
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
        if (this.mul.dAD().mB()) {
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
            i2 = com.baidu.adp.framework.d.b.lD().lG().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lD().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.lD().lE().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.mul.dAE().Mo && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.LD = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.mup = new b(this.mul);
                        this.mup.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.mul.dAE().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.mul.a(eVar);
                        if (this.Lp <= 0 && this.mup != null) {
                            this.Lp = this.mup.mo();
                        }
                        eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                        this.mul.a(eVar);
                        a dAB = a.dAB();
                        if (dAB != null) {
                            dAB.a(this.mul);
                        }
                    } catch (Throwable th) {
                        this.mul.dAE().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.mul.a(eVar);
                        if (this.Lp <= 0 && this.mup != null) {
                            this.Lp = this.mup.mo();
                        }
                        eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                        this.mul.a(eVar);
                        a dAB2 = a.dAB();
                        if (dAB2 != null) {
                            dAB2.a(this.mul);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.mul.dAE().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.mul.a(eVar);
                    if (this.Lp <= 0 && this.mup != null) {
                        this.Lp = this.mup.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.mul.a(eVar);
                    a dAB3 = a.dAB();
                    if (dAB3 != null) {
                        dAB3.a(this.mul);
                    }
                } catch (SocketException e3) {
                    this.mul.dAE().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.mul.a(eVar);
                    if (this.Lp <= 0 && this.mup != null) {
                        this.Lp = this.mup.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.mul.a(eVar);
                    a dAB4 = a.dAB();
                    if (dAB4 != null) {
                        dAB4.a(this.mul);
                    }
                }
                if (this.mul.dAE().responseCode == 200) {
                    if (this.Lp <= 0 && this.mup != null) {
                        this.Lp = this.mup.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.mul.a(eVar);
                    a dAB5 = a.dAB();
                    if (dAB5 != null) {
                        dAB5.a(this.mul);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.mul.dAE().responseCode) + "|retryCount:" + i4;
                z = ap(this.mul.dAE().responseCode);
                this.mul.a(eVar);
                if (this.Lp <= 0 && this.mup != null) {
                    this.Lp = this.mup.mo();
                }
                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.mul.a(eVar);
                a dAB6 = a.dAB();
                if (dAB6 != null) {
                    dAB6.a(this.mul);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Lp <= 0 && this.mup != null) {
                    this.Lp = this.mup.mo();
                }
                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mul.dAD().getUrl(), this.mul.dAD().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.mul.a(eVar);
                a dAB7 = a.dAB();
                if (dAB7 != null) {
                    dAB7.a(this.mul);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.mup != null) {
            this.mup.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.mul == null) {
            return false;
        }
        return this.mul.dAE().Mo;
    }

    public void setCancel() {
        if (this.mul != null) {
            this.mul.dAE().Mo = true;
        }
    }
}
