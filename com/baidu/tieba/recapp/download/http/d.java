package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes7.dex */
public class d {
    private g mVi;
    private b mVm;
    private int Ns = 0;
    private long Nf = 0;

    public d(g gVar) {
        this.mVi = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.kY().lb().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kY().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.kY().kZ().getTimeOutAuto() : i4;
        this.mVm = new b(this.mVi);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.Ns = i5;
                boolean a2 = this.mVm.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                this.mVi.a(eVar);
                a dDQ = a.dDQ();
                if (dDQ != null) {
                    dDQ.a(this.mVi);
                }
                return a2;
            } catch (FileNotFoundException e) {
                try {
                    this.mVi.dDT().responseCode = -100;
                    eVar.exception = String.valueOf(this.mVi.dDT().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.mVi.a(eVar);
                    com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                    this.mVi.a(eVar);
                    a dDQ2 = a.dDQ();
                    if (dDQ2 != null) {
                        dDQ2.a(this.mVi);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                    this.mVi.a(eVar);
                    a dDQ3 = a.dDQ();
                    if (dDQ3 != null) {
                        dDQ3.a(this.mVi);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.mVi.dDT().responseCode = -10;
                eVar.exception = String.valueOf(this.mVi.dDT().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.mVi.a(eVar);
                com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                this.mVi.a(eVar);
                a dDQ4 = a.dDQ();
                if (dDQ4 != null) {
                    dDQ4.a(this.mVi);
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
        for (int i4 = 0; !this.mVi.dDT().Od && z && i4 < i; i4++) {
            e eVar = new e();
            this.mVi.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.Ns = i4;
                                eVar.retry = i4 + 1;
                                eVar.NK = 1;
                                this.mVm = new b(this.mVi);
                                this.mVm.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.mVi.dDT().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Nf <= 0 && this.mVm != null) {
                                    this.Nf = this.mVm.lL();
                                }
                                eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                                this.mVi.b(eVar);
                                a dDQ = a.dDQ();
                                if (dDQ != null) {
                                    dDQ.a(this.mVi);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.mVi.dDT().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.mVi.dDT().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Nf <= 0 && this.mVm != null) {
                                this.Nf = this.mVm.lL();
                            }
                            eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                            this.mVi.b(eVar);
                            a dDQ2 = a.dDQ();
                            if (dDQ2 != null) {
                                dDQ2.a(this.mVi);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.mVi.dDT().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.mVi.dDT().mNetErrorCode = -13;
                        if (this.Nf <= 0 && this.mVm != null) {
                            this.Nf = this.mVm.lL();
                        }
                        eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                        this.mVi.b(eVar);
                        a dDQ3 = a.dDQ();
                        if (dDQ3 != null) {
                            dDQ3.a(this.mVi);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.mVi.dDT().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.mVi.dDT().mNetErrorCode = -12;
                    if (this.Nf <= 0 && this.mVm != null) {
                        this.Nf = this.mVm.lL();
                    }
                    eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                    this.mVi.b(eVar);
                    a dDQ4 = a.dDQ();
                    if (dDQ4 != null) {
                        dDQ4.a(this.mVi);
                    }
                    z = true;
                }
                if (this.mVi.dDT().responseCode == 200) {
                    this.mVi.b(eVar);
                    if (this.Nf <= 0 && this.mVm != null) {
                        this.Nf = this.mVm.lL();
                    }
                    eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                    this.mVi.b(eVar);
                    a dDQ5 = a.dDQ();
                    if (dDQ5 != null) {
                        dDQ5.a(this.mVi);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.mVi.dDT().responseCode) + "|retryCount:" + i4;
                boolean as = as(this.mVi.dDT().responseCode);
                if (this.Nf <= 0 && this.mVm != null) {
                    this.Nf = this.mVm.lL();
                }
                eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                this.mVi.b(eVar);
                a dDQ6 = a.dDQ();
                if (dDQ6 != null) {
                    dDQ6.a(this.mVi);
                }
                z = as;
            } catch (Throwable th) {
                if (this.Nf <= 0 && this.mVm != null) {
                    this.Nf = this.mVm.lL();
                }
                eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                this.mVi.b(eVar);
                a dDQ7 = a.dDQ();
                if (dDQ7 != null) {
                    dDQ7.a(this.mVi);
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
        for (int i4 = 0; !this.mVi.dDT().Od && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.Ns = i4;
            try {
                try {
                    try {
                        this.mVm = new b(this.mVi);
                        this.mVm.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.mVi.dDT().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.mVi.a(eVar);
                        if (this.Nf <= 0 && this.mVm != null) {
                            this.Nf = this.mVm.lL();
                        }
                        eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                        this.mVi.a(eVar);
                        a dDQ = a.dDQ();
                        if (dDQ != null && this.mVm != null && this.mVm.lO()) {
                            dDQ.a(this.mVi);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.mVi.dDT().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.mVi.a(eVar);
                        if (this.Nf <= 0 && this.mVm != null) {
                            this.Nf = this.mVm.lL();
                        }
                        eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                        this.mVi.a(eVar);
                        a dDQ2 = a.dDQ();
                        if (dDQ2 != null && this.mVm != null && this.mVm.lO()) {
                            dDQ2.a(this.mVi);
                        }
                    }
                } catch (SocketException e3) {
                    this.mVi.dDT().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.mVi.a(eVar);
                    if (this.Nf <= 0 && this.mVm != null) {
                        this.Nf = this.mVm.lL();
                    }
                    eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                    this.mVi.a(eVar);
                    a dDQ3 = a.dDQ();
                    if (dDQ3 != null && this.mVm != null && this.mVm.lO()) {
                        dDQ3.a(this.mVi);
                    }
                } catch (Throwable th) {
                    this.mVi.dDT().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.mVi.a(eVar);
                    if (this.Nf <= 0 && this.mVm != null) {
                        this.Nf = this.mVm.lL();
                    }
                    eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                    this.mVi.a(eVar);
                    a dDQ4 = a.dDQ();
                    if (dDQ4 != null && this.mVm != null && this.mVm.lO()) {
                        dDQ4.a(this.mVi);
                    }
                }
                if (this.mVi.dDT().responseCode == 200) {
                    if (this.Nf <= 0 && this.mVm != null) {
                        this.Nf = this.mVm.lL();
                    }
                    eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                    this.mVi.a(eVar);
                    a dDQ5 = a.dDQ();
                    if (dDQ5 == null || this.mVm == null || !this.mVm.lO()) {
                        return;
                    }
                    dDQ5.a(this.mVi);
                    return;
                }
                eVar.exception = String.valueOf(this.mVi.dDT().responseCode) + "|retryCount:" + i4;
                z = as(this.mVi.dDT().responseCode);
                this.mVi.a(eVar);
                if (this.Nf <= 0 && this.mVm != null) {
                    this.Nf = this.mVm.lL();
                }
                eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                this.mVi.a(eVar);
                a dDQ6 = a.dDQ();
                if (dDQ6 != null && this.mVm != null && this.mVm.lO()) {
                    dDQ6.a(this.mVi);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Nf <= 0 && this.mVm != null) {
                    this.Nf = this.mVm.lL();
                }
                eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                this.mVi.a(eVar);
                a dDQ7 = a.dDQ();
                if (dDQ7 != null && this.mVm != null && this.mVm.lO()) {
                    dDQ7.a(this.mVi);
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
        if (this.mVi.dDS().lY()) {
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
        for (int i4 = 0; !this.mVi.dDT().Od && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.Ns = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.mVm = new b(this.mVi);
                        this.mVm.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.mVi.dDT().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.mVi.a(eVar);
                        if (this.Nf <= 0 && this.mVm != null) {
                            this.Nf = this.mVm.lL();
                        }
                        eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                        this.mVi.a(eVar);
                        a dDQ = a.dDQ();
                        if (dDQ != null) {
                            dDQ.a(this.mVi);
                        }
                    } catch (Throwable th) {
                        this.mVi.dDT().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.mVi.a(eVar);
                        if (this.Nf <= 0 && this.mVm != null) {
                            this.Nf = this.mVm.lL();
                        }
                        eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                        this.mVi.a(eVar);
                        a dDQ2 = a.dDQ();
                        if (dDQ2 != null) {
                            dDQ2.a(this.mVi);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.mVi.dDT().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.mVi.a(eVar);
                    if (this.Nf <= 0 && this.mVm != null) {
                        this.Nf = this.mVm.lL();
                    }
                    eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                    this.mVi.a(eVar);
                    a dDQ3 = a.dDQ();
                    if (dDQ3 != null) {
                        dDQ3.a(this.mVi);
                    }
                } catch (SocketException e3) {
                    this.mVi.dDT().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.mVi.a(eVar);
                    if (this.Nf <= 0 && this.mVm != null) {
                        this.Nf = this.mVm.lL();
                    }
                    eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                    this.mVi.a(eVar);
                    a dDQ4 = a.dDQ();
                    if (dDQ4 != null) {
                        dDQ4.a(this.mVi);
                    }
                }
                if (this.mVi.dDT().responseCode == 200) {
                    if (this.Nf <= 0 && this.mVm != null) {
                        this.Nf = this.mVm.lL();
                    }
                    eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                    this.mVi.a(eVar);
                    a dDQ5 = a.dDQ();
                    if (dDQ5 != null) {
                        dDQ5.a(this.mVi);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.mVi.dDT().responseCode) + "|retryCount:" + i4;
                z = as(this.mVi.dDT().responseCode);
                this.mVi.a(eVar);
                if (this.Nf <= 0 && this.mVm != null) {
                    this.Nf = this.mVm.lL();
                }
                eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                this.mVi.a(eVar);
                a dDQ6 = a.dDQ();
                if (dDQ6 != null) {
                    dDQ6.a(this.mVi);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Nf <= 0 && this.mVm != null) {
                    this.Nf = this.mVm.lL();
                }
                eVar.Nw = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.mVi.dDS().getUrl(), this.mVi.dDS().bK("Host"), TextUtils.isEmpty(eVar.exception), eVar.NC != null);
                this.mVi.a(eVar);
                a dDQ7 = a.dDQ();
                if (dDQ7 != null) {
                    dDQ7.a(this.mVi);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.mVm != null) {
            this.mVm.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.mVi == null) {
            return false;
        }
        return this.mVi.dDT().Od;
    }

    public void setCancel() {
        if (this.mVi != null) {
            this.mVi.dDT().Od = true;
        }
    }
}
