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
    private int MC = 0;
    private long Mn = 0;
    private g mIN;
    private b mIR;

    public d(g gVar) {
        this.mIN = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.lD().lG().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lD().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.lD().lE().getTimeOutAuto() : i4;
        this.mIR = new b(this.mIN);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.MC = i5;
                boolean a2 = this.mIR.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                this.mIN.a(eVar);
                a dFs = a.dFs();
                if (dFs != null) {
                    dFs.a(this.mIN);
                }
                return a2;
            } catch (FileNotFoundException e) {
                try {
                    this.mIN.dFv().responseCode = -100;
                    eVar.exception = String.valueOf(this.mIN.dFv().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.mIN.a(eVar);
                    com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                    this.mIN.a(eVar);
                    a dFs2 = a.dFs();
                    if (dFs2 != null) {
                        dFs2.a(this.mIN);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                    this.mIN.a(eVar);
                    a dFs3 = a.dFs();
                    if (dFs3 != null) {
                        dFs3.a(this.mIN);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.mIN.dFv().responseCode = -10;
                eVar.exception = String.valueOf(this.mIN.dFv().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.mIN.a(eVar);
                com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                this.mIN.a(eVar);
                a dFs4 = a.dFs();
                if (dFs4 != null) {
                    dFs4.a(this.mIN);
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
        for (int i4 = 0; !this.mIN.dFv().Nj && z && i4 < i; i4++) {
            e eVar = new e();
            this.mIN.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.MC = i4;
                                eVar.retry = i4 + 1;
                                eVar.MT = 1;
                                this.mIR = new b(this.mIN);
                                this.mIR.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.mIN.dFv().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Mn <= 0 && this.mIR != null) {
                                    this.Mn = this.mIR.mo();
                                }
                                eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                                this.mIN.b(eVar);
                                a dFs = a.dFs();
                                if (dFs != null) {
                                    dFs.a(this.mIN);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.mIN.dFv().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.mIN.dFv().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Mn <= 0 && this.mIR != null) {
                                this.Mn = this.mIR.mo();
                            }
                            eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                            this.mIN.b(eVar);
                            a dFs2 = a.dFs();
                            if (dFs2 != null) {
                                dFs2.a(this.mIN);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.mIN.dFv().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.mIN.dFv().mNetErrorCode = -13;
                        if (this.Mn <= 0 && this.mIR != null) {
                            this.Mn = this.mIR.mo();
                        }
                        eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                        this.mIN.b(eVar);
                        a dFs3 = a.dFs();
                        if (dFs3 != null) {
                            dFs3.a(this.mIN);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.mIN.dFv().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.mIN.dFv().mNetErrorCode = -12;
                    if (this.Mn <= 0 && this.mIR != null) {
                        this.Mn = this.mIR.mo();
                    }
                    eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                    this.mIN.b(eVar);
                    a dFs4 = a.dFs();
                    if (dFs4 != null) {
                        dFs4.a(this.mIN);
                    }
                    z = true;
                }
                if (this.mIN.dFv().responseCode == 200) {
                    this.mIN.b(eVar);
                    if (this.Mn <= 0 && this.mIR != null) {
                        this.Mn = this.mIR.mo();
                    }
                    eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                    this.mIN.b(eVar);
                    a dFs5 = a.dFs();
                    if (dFs5 != null) {
                        dFs5.a(this.mIN);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.mIN.dFv().responseCode) + "|retryCount:" + i4;
                boolean as = as(this.mIN.dFv().responseCode);
                if (this.Mn <= 0 && this.mIR != null) {
                    this.Mn = this.mIR.mo();
                }
                eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                this.mIN.b(eVar);
                a dFs6 = a.dFs();
                if (dFs6 != null) {
                    dFs6.a(this.mIN);
                }
                z = as;
            } catch (Throwable th) {
                if (this.Mn <= 0 && this.mIR != null) {
                    this.Mn = this.mIR.mo();
                }
                eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                this.mIN.b(eVar);
                a dFs7 = a.dFs();
                if (dFs7 != null) {
                    dFs7.a(this.mIN);
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
        for (int i4 = 0; !this.mIN.dFv().Nj && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.MC = i4;
            try {
                try {
                    try {
                        this.mIR = new b(this.mIN);
                        this.mIR.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.mIN.dFv().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.mIN.a(eVar);
                        if (this.Mn <= 0 && this.mIR != null) {
                            this.Mn = this.mIR.mo();
                        }
                        eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                        this.mIN.a(eVar);
                        a dFs = a.dFs();
                        if (dFs != null && this.mIR != null && this.mIR.mr()) {
                            dFs.a(this.mIN);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.mIN.dFv().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.mIN.a(eVar);
                        if (this.Mn <= 0 && this.mIR != null) {
                            this.Mn = this.mIR.mo();
                        }
                        eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                        this.mIN.a(eVar);
                        a dFs2 = a.dFs();
                        if (dFs2 != null && this.mIR != null && this.mIR.mr()) {
                            dFs2.a(this.mIN);
                        }
                    }
                } catch (SocketException e3) {
                    this.mIN.dFv().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.mIN.a(eVar);
                    if (this.Mn <= 0 && this.mIR != null) {
                        this.Mn = this.mIR.mo();
                    }
                    eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                    this.mIN.a(eVar);
                    a dFs3 = a.dFs();
                    if (dFs3 != null && this.mIR != null && this.mIR.mr()) {
                        dFs3.a(this.mIN);
                    }
                } catch (Throwable th) {
                    this.mIN.dFv().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.mIN.a(eVar);
                    if (this.Mn <= 0 && this.mIR != null) {
                        this.Mn = this.mIR.mo();
                    }
                    eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                    this.mIN.a(eVar);
                    a dFs4 = a.dFs();
                    if (dFs4 != null && this.mIR != null && this.mIR.mr()) {
                        dFs4.a(this.mIN);
                    }
                }
                if (this.mIN.dFv().responseCode == 200) {
                    if (this.Mn <= 0 && this.mIR != null) {
                        this.Mn = this.mIR.mo();
                    }
                    eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                    this.mIN.a(eVar);
                    a dFs5 = a.dFs();
                    if (dFs5 == null || this.mIR == null || !this.mIR.mr()) {
                        return;
                    }
                    dFs5.a(this.mIN);
                    return;
                }
                eVar.exception = String.valueOf(this.mIN.dFv().responseCode) + "|retryCount:" + i4;
                z = as(this.mIN.dFv().responseCode);
                this.mIN.a(eVar);
                if (this.Mn <= 0 && this.mIR != null) {
                    this.Mn = this.mIR.mo();
                }
                eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                this.mIN.a(eVar);
                a dFs6 = a.dFs();
                if (dFs6 != null && this.mIR != null && this.mIR.mr()) {
                    dFs6.a(this.mIN);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Mn <= 0 && this.mIR != null) {
                    this.Mn = this.mIR.mo();
                }
                eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                this.mIN.a(eVar);
                a dFs7 = a.dFs();
                if (dFs7 != null && this.mIR != null && this.mIR.mr()) {
                    dFs7.a(this.mIN);
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
        if (this.mIN.dFu().mB()) {
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
        for (int i4 = 0; !this.mIN.dFv().Nj && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.MC = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.mIR = new b(this.mIN);
                        this.mIR.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.mIN.dFv().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.mIN.a(eVar);
                        if (this.Mn <= 0 && this.mIR != null) {
                            this.Mn = this.mIR.mo();
                        }
                        eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                        this.mIN.a(eVar);
                        a dFs = a.dFs();
                        if (dFs != null) {
                            dFs.a(this.mIN);
                        }
                    } catch (Throwable th) {
                        this.mIN.dFv().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.mIN.a(eVar);
                        if (this.Mn <= 0 && this.mIR != null) {
                            this.Mn = this.mIR.mo();
                        }
                        eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                        this.mIN.a(eVar);
                        a dFs2 = a.dFs();
                        if (dFs2 != null) {
                            dFs2.a(this.mIN);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.mIN.dFv().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.mIN.a(eVar);
                    if (this.Mn <= 0 && this.mIR != null) {
                        this.Mn = this.mIR.mo();
                    }
                    eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                    this.mIN.a(eVar);
                    a dFs3 = a.dFs();
                    if (dFs3 != null) {
                        dFs3.a(this.mIN);
                    }
                } catch (SocketException e3) {
                    this.mIN.dFv().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.mIN.a(eVar);
                    if (this.Mn <= 0 && this.mIR != null) {
                        this.Mn = this.mIR.mo();
                    }
                    eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                    this.mIN.a(eVar);
                    a dFs4 = a.dFs();
                    if (dFs4 != null) {
                        dFs4.a(this.mIN);
                    }
                }
                if (this.mIN.dFv().responseCode == 200) {
                    if (this.Mn <= 0 && this.mIR != null) {
                        this.Mn = this.mIR.mo();
                    }
                    eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                    this.mIN.a(eVar);
                    a dFs5 = a.dFs();
                    if (dFs5 != null) {
                        dFs5.a(this.mIN);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.mIN.dFv().responseCode) + "|retryCount:" + i4;
                z = as(this.mIN.dFv().responseCode);
                this.mIN.a(eVar);
                if (this.Mn <= 0 && this.mIR != null) {
                    this.Mn = this.mIR.mo();
                }
                eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                this.mIN.a(eVar);
                a dFs6 = a.dFs();
                if (dFs6 != null) {
                    dFs6.a(this.mIN);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Mn <= 0 && this.mIR != null) {
                    this.Mn = this.mIR.mo();
                }
                eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mIN.dFu().getUrl(), this.mIN.dFu().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                this.mIN.a(eVar);
                a dFs7 = a.dFs();
                if (dFs7 != null) {
                    dFs7.a(this.mIN);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.mIR != null) {
            this.mIR.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.mIN == null) {
            return false;
        }
        return this.mIN.dFv().Nj;
    }

    public void setCancel() {
        if (this.mIN != null) {
            this.mIN.dFv().Nj = true;
        }
    }
}
