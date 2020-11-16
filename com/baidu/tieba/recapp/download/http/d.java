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
    private int LD = 0;
    private long Lp = 0;
    private g muB;
    private b muF;

    public d(g gVar) {
        this.muB = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.lD().lG().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lD().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.lD().lE().getTimeOutAuto() : i4;
        this.muF = new b(this.muB);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.LD = i5;
                boolean a2 = this.muF.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.muB.a(eVar);
                a dAb = a.dAb();
                if (dAb != null) {
                    dAb.a(this.muB);
                }
                return a2;
            } catch (FileNotFoundException e) {
                try {
                    this.muB.dAe().responseCode = -100;
                    eVar.exception = String.valueOf(this.muB.dAe().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.muB.a(eVar);
                    com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.muB.a(eVar);
                    a dAb2 = a.dAb();
                    if (dAb2 != null) {
                        dAb2.a(this.muB);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.muB.a(eVar);
                    a dAb3 = a.dAb();
                    if (dAb3 != null) {
                        dAb3.a(this.muB);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.muB.dAe().responseCode = -10;
                eVar.exception = String.valueOf(this.muB.dAe().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.muB.a(eVar);
                com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.muB.a(eVar);
                a dAb4 = a.dAb();
                if (dAb4 != null) {
                    dAb4.a(this.muB);
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
        for (int i4 = 0; !this.muB.dAe().Mo && z && i4 < i; i4++) {
            e eVar = new e();
            this.muB.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.LD = i4;
                                eVar.retry = i4 + 1;
                                eVar.LY = 1;
                                this.muF = new b(this.muB);
                                this.muF.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.muB.dAe().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Lp <= 0 && this.muF != null) {
                                    this.Lp = this.muF.mo();
                                }
                                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                                this.muB.b(eVar);
                                a dAb = a.dAb();
                                if (dAb != null) {
                                    dAb.a(this.muB);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.muB.dAe().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.muB.dAe().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Lp <= 0 && this.muF != null) {
                                this.Lp = this.muF.mo();
                            }
                            eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                            this.muB.b(eVar);
                            a dAb2 = a.dAb();
                            if (dAb2 != null) {
                                dAb2.a(this.muB);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.muB.dAe().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.muB.dAe().mNetErrorCode = -13;
                        if (this.Lp <= 0 && this.muF != null) {
                            this.Lp = this.muF.mo();
                        }
                        eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                        this.muB.b(eVar);
                        a dAb3 = a.dAb();
                        if (dAb3 != null) {
                            dAb3.a(this.muB);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.muB.dAe().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.muB.dAe().mNetErrorCode = -12;
                    if (this.Lp <= 0 && this.muF != null) {
                        this.Lp = this.muF.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.muB.b(eVar);
                    a dAb4 = a.dAb();
                    if (dAb4 != null) {
                        dAb4.a(this.muB);
                    }
                    z = true;
                }
                if (this.muB.dAe().responseCode == 200) {
                    this.muB.b(eVar);
                    if (this.Lp <= 0 && this.muF != null) {
                        this.Lp = this.muF.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.muB.b(eVar);
                    a dAb5 = a.dAb();
                    if (dAb5 != null) {
                        dAb5.a(this.muB);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.muB.dAe().responseCode) + "|retryCount:" + i4;
                boolean ap = ap(this.muB.dAe().responseCode);
                if (this.Lp <= 0 && this.muF != null) {
                    this.Lp = this.muF.mo();
                }
                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.muB.b(eVar);
                a dAb6 = a.dAb();
                if (dAb6 != null) {
                    dAb6.a(this.muB);
                }
                z = ap;
            } catch (Throwable th) {
                if (this.Lp <= 0 && this.muF != null) {
                    this.Lp = this.muF.mo();
                }
                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.muB.b(eVar);
                a dAb7 = a.dAb();
                if (dAb7 != null) {
                    dAb7.a(this.muB);
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
        for (int i4 = 0; !this.muB.dAe().Mo && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.LD = i4;
            try {
                try {
                    try {
                        this.muF = new b(this.muB);
                        this.muF.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.muB.dAe().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.muB.a(eVar);
                        if (this.Lp <= 0 && this.muF != null) {
                            this.Lp = this.muF.mo();
                        }
                        eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                        this.muB.a(eVar);
                        a dAb = a.dAb();
                        if (dAb != null && this.muF != null && this.muF.mr()) {
                            dAb.a(this.muB);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.muB.dAe().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.muB.a(eVar);
                        if (this.Lp <= 0 && this.muF != null) {
                            this.Lp = this.muF.mo();
                        }
                        eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                        this.muB.a(eVar);
                        a dAb2 = a.dAb();
                        if (dAb2 != null && this.muF != null && this.muF.mr()) {
                            dAb2.a(this.muB);
                        }
                    }
                } catch (SocketException e3) {
                    this.muB.dAe().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.muB.a(eVar);
                    if (this.Lp <= 0 && this.muF != null) {
                        this.Lp = this.muF.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.muB.a(eVar);
                    a dAb3 = a.dAb();
                    if (dAb3 != null && this.muF != null && this.muF.mr()) {
                        dAb3.a(this.muB);
                    }
                } catch (Throwable th) {
                    this.muB.dAe().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.muB.a(eVar);
                    if (this.Lp <= 0 && this.muF != null) {
                        this.Lp = this.muF.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.muB.a(eVar);
                    a dAb4 = a.dAb();
                    if (dAb4 != null && this.muF != null && this.muF.mr()) {
                        dAb4.a(this.muB);
                    }
                }
                if (this.muB.dAe().responseCode == 200) {
                    if (this.Lp <= 0 && this.muF != null) {
                        this.Lp = this.muF.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.muB.a(eVar);
                    a dAb5 = a.dAb();
                    if (dAb5 == null || this.muF == null || !this.muF.mr()) {
                        return;
                    }
                    dAb5.a(this.muB);
                    return;
                }
                eVar.exception = String.valueOf(this.muB.dAe().responseCode) + "|retryCount:" + i4;
                z = ap(this.muB.dAe().responseCode);
                this.muB.a(eVar);
                if (this.Lp <= 0 && this.muF != null) {
                    this.Lp = this.muF.mo();
                }
                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.muB.a(eVar);
                a dAb6 = a.dAb();
                if (dAb6 != null && this.muF != null && this.muF.mr()) {
                    dAb6.a(this.muB);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Lp <= 0 && this.muF != null) {
                    this.Lp = this.muF.mo();
                }
                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.muB.a(eVar);
                a dAb7 = a.dAb();
                if (dAb7 != null && this.muF != null && this.muF.mr()) {
                    dAb7.a(this.muB);
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
        if (this.muB.dAd().mB()) {
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
        for (int i4 = 0; !this.muB.dAe().Mo && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.LD = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.muF = new b(this.muB);
                        this.muF.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.muB.dAe().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.muB.a(eVar);
                        if (this.Lp <= 0 && this.muF != null) {
                            this.Lp = this.muF.mo();
                        }
                        eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                        this.muB.a(eVar);
                        a dAb = a.dAb();
                        if (dAb != null) {
                            dAb.a(this.muB);
                        }
                    } catch (Throwable th) {
                        this.muB.dAe().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.muB.a(eVar);
                        if (this.Lp <= 0 && this.muF != null) {
                            this.Lp = this.muF.mo();
                        }
                        eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                        this.muB.a(eVar);
                        a dAb2 = a.dAb();
                        if (dAb2 != null) {
                            dAb2.a(this.muB);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.muB.dAe().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.muB.a(eVar);
                    if (this.Lp <= 0 && this.muF != null) {
                        this.Lp = this.muF.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.muB.a(eVar);
                    a dAb3 = a.dAb();
                    if (dAb3 != null) {
                        dAb3.a(this.muB);
                    }
                } catch (SocketException e3) {
                    this.muB.dAe().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.muB.a(eVar);
                    if (this.Lp <= 0 && this.muF != null) {
                        this.Lp = this.muF.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.muB.a(eVar);
                    a dAb4 = a.dAb();
                    if (dAb4 != null) {
                        dAb4.a(this.muB);
                    }
                }
                if (this.muB.dAe().responseCode == 200) {
                    if (this.Lp <= 0 && this.muF != null) {
                        this.Lp = this.muF.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.muB.a(eVar);
                    a dAb5 = a.dAb();
                    if (dAb5 != null) {
                        dAb5.a(this.muB);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.muB.dAe().responseCode) + "|retryCount:" + i4;
                z = ap(this.muB.dAe().responseCode);
                this.muB.a(eVar);
                if (this.Lp <= 0 && this.muF != null) {
                    this.Lp = this.muF.mo();
                }
                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.muB.a(eVar);
                a dAb6 = a.dAb();
                if (dAb6 != null) {
                    dAb6.a(this.muB);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Lp <= 0 && this.muF != null) {
                    this.Lp = this.muF.mo();
                }
                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.muB.dAd().getUrl(), this.muB.dAd().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.muB.a(eVar);
                a dAb7 = a.dAb();
                if (dAb7 != null) {
                    dAb7.a(this.muB);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.muF != null) {
            this.muF.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.muB == null) {
            return false;
        }
        return this.muB.dAe().Mo;
    }

    public void setCancel() {
        if (this.muB != null) {
            this.muB.dAe().Mo = true;
        }
    }
}
