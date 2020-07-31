package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes20.dex */
public class d {
    private g lmQ;
    private b lmU;
    private int Kz = 0;
    private long Km = 0;

    public d(g gVar) {
        this.lmQ = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.jZ().kc().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jZ().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.jZ().ka().getTimeOutAuto() : i4;
        this.lmU = new b(this.lmQ);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.Kz = i5;
                boolean a = this.lmU.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lmQ.a(eVar);
                a dcn = a.dcn();
                if (dcn != null) {
                    dcn.a(this.lmQ);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.lmQ.dcq().responseCode = -100;
                    eVar.exception = String.valueOf(this.lmQ.dcq().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.lmQ.a(eVar);
                    com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lmQ.a(eVar);
                    a dcn2 = a.dcn();
                    if (dcn2 != null) {
                        dcn2.a(this.lmQ);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lmQ.a(eVar);
                    a dcn3 = a.dcn();
                    if (dcn3 != null) {
                        dcn3.a(this.lmQ);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.lmQ.dcq().responseCode = -10;
                eVar.exception = String.valueOf(this.lmQ.dcq().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.lmQ.a(eVar);
                com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lmQ.a(eVar);
                a dcn4 = a.dcn();
                if (dcn4 != null) {
                    dcn4.a(this.lmQ);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.d.b.jZ().kc().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.jZ().ka().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.lmQ.dcq().Le && z && i4 < i; i4++) {
            e eVar = new e();
            this.lmQ.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.Kz = i4;
                                eVar.retry = i4 + 1;
                                eVar.KP = 1;
                                this.lmU = new b(this.lmQ);
                                this.lmU.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.lmQ.dcq().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Km <= 0 && this.lmU != null) {
                                    this.Km = this.lmU.kK();
                                }
                                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                                this.lmQ.b(eVar);
                                a dcn = a.dcn();
                                if (dcn != null) {
                                    dcn.a(this.lmQ);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.lmQ.dcq().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.lmQ.dcq().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Km <= 0 && this.lmU != null) {
                                this.Km = this.lmU.kK();
                            }
                            eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                            this.lmQ.b(eVar);
                            a dcn2 = a.dcn();
                            if (dcn2 != null) {
                                dcn2.a(this.lmQ);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.lmQ.dcq().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.lmQ.dcq().mNetErrorCode = -13;
                        if (this.Km <= 0 && this.lmU != null) {
                            this.Km = this.lmU.kK();
                        }
                        eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                        this.lmQ.b(eVar);
                        a dcn3 = a.dcn();
                        if (dcn3 != null) {
                            dcn3.a(this.lmQ);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.lmQ.dcq().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.lmQ.dcq().mNetErrorCode = -12;
                    if (this.Km <= 0 && this.lmU != null) {
                        this.Km = this.lmU.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lmQ.b(eVar);
                    a dcn4 = a.dcn();
                    if (dcn4 != null) {
                        dcn4.a(this.lmQ);
                    }
                    z = true;
                }
                if (this.lmQ.dcq().responseCode == 200) {
                    this.lmQ.b(eVar);
                    if (this.Km <= 0 && this.lmU != null) {
                        this.Km = this.lmU.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lmQ.b(eVar);
                    a dcn5 = a.dcn();
                    if (dcn5 != null) {
                        dcn5.a(this.lmQ);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.lmQ.dcq().responseCode) + "|retryCount:" + i4;
                boolean ak = ak(this.lmQ.dcq().responseCode);
                if (this.Km <= 0 && this.lmU != null) {
                    this.Km = this.lmU.kK();
                }
                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lmQ.b(eVar);
                a dcn6 = a.dcn();
                if (dcn6 != null) {
                    dcn6.a(this.lmQ);
                }
                z = ak;
            } catch (Throwable th) {
                if (this.Km <= 0 && this.lmU != null) {
                    this.Km = this.lmU.kK();
                }
                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lmQ.b(eVar);
                a dcn7 = a.dcn();
                if (dcn7 != null) {
                    dcn7.a(this.lmQ);
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
            i2 = com.baidu.adp.framework.d.b.jZ().kc().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.jZ().ka().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.lmQ.dcq().Le && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.Kz = i4;
            try {
                try {
                    try {
                        this.lmU = new b(this.lmQ);
                        this.lmU.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.lmQ.dcq().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.lmQ.a(eVar);
                        if (this.Km <= 0 && this.lmU != null) {
                            this.Km = this.lmU.kK();
                        }
                        eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                        this.lmQ.a(eVar);
                        a dcn = a.dcn();
                        if (dcn != null && this.lmU != null && this.lmU.kN()) {
                            dcn.a(this.lmQ);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.lmQ.dcq().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.lmQ.a(eVar);
                        if (this.Km <= 0 && this.lmU != null) {
                            this.Km = this.lmU.kK();
                        }
                        eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                        this.lmQ.a(eVar);
                        a dcn2 = a.dcn();
                        if (dcn2 != null && this.lmU != null && this.lmU.kN()) {
                            dcn2.a(this.lmQ);
                        }
                    }
                } catch (SocketException e3) {
                    this.lmQ.dcq().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.lmQ.a(eVar);
                    if (this.Km <= 0 && this.lmU != null) {
                        this.Km = this.lmU.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lmQ.a(eVar);
                    a dcn3 = a.dcn();
                    if (dcn3 != null && this.lmU != null && this.lmU.kN()) {
                        dcn3.a(this.lmQ);
                    }
                } catch (Throwable th) {
                    this.lmQ.dcq().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.lmQ.a(eVar);
                    if (this.Km <= 0 && this.lmU != null) {
                        this.Km = this.lmU.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lmQ.a(eVar);
                    a dcn4 = a.dcn();
                    if (dcn4 != null && this.lmU != null && this.lmU.kN()) {
                        dcn4.a(this.lmQ);
                    }
                }
                if (this.lmQ.dcq().responseCode == 200) {
                    if (this.Km <= 0 && this.lmU != null) {
                        this.Km = this.lmU.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lmQ.a(eVar);
                    a dcn5 = a.dcn();
                    if (dcn5 == null || this.lmU == null || !this.lmU.kN()) {
                        return;
                    }
                    dcn5.a(this.lmQ);
                    return;
                }
                eVar.exception = String.valueOf(this.lmQ.dcq().responseCode) + "|retryCount:" + i4;
                z = ak(this.lmQ.dcq().responseCode);
                this.lmQ.a(eVar);
                if (this.Km <= 0 && this.lmU != null) {
                    this.Km = this.lmU.kK();
                }
                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lmQ.a(eVar);
                a dcn6 = a.dcn();
                if (dcn6 != null && this.lmU != null && this.lmU.kN()) {
                    dcn6.a(this.lmQ);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Km <= 0 && this.lmU != null) {
                    this.Km = this.lmU.kK();
                }
                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lmQ.a(eVar);
                a dcn7 = a.dcn();
                if (dcn7 != null && this.lmU != null && this.lmU.kN()) {
                    dcn7.a(this.lmQ);
                }
                throw th2;
            }
        }
    }

    private boolean ak(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.lmQ.dcp().kX()) {
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
            i2 = com.baidu.adp.framework.d.b.jZ().kc().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.jZ().ka().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.lmQ.dcq().Le && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.Kz = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.lmU = new b(this.lmQ);
                        this.lmU.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.lmQ.dcq().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.lmQ.a(eVar);
                        if (this.Km <= 0 && this.lmU != null) {
                            this.Km = this.lmU.kK();
                        }
                        eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                        this.lmQ.a(eVar);
                        a dcn = a.dcn();
                        if (dcn != null) {
                            dcn.a(this.lmQ);
                        }
                    } catch (Throwable th) {
                        this.lmQ.dcq().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.lmQ.a(eVar);
                        if (this.Km <= 0 && this.lmU != null) {
                            this.Km = this.lmU.kK();
                        }
                        eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                        this.lmQ.a(eVar);
                        a dcn2 = a.dcn();
                        if (dcn2 != null) {
                            dcn2.a(this.lmQ);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.lmQ.dcq().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.lmQ.a(eVar);
                    if (this.Km <= 0 && this.lmU != null) {
                        this.Km = this.lmU.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lmQ.a(eVar);
                    a dcn3 = a.dcn();
                    if (dcn3 != null) {
                        dcn3.a(this.lmQ);
                    }
                } catch (SocketException e3) {
                    this.lmQ.dcq().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.lmQ.a(eVar);
                    if (this.Km <= 0 && this.lmU != null) {
                        this.Km = this.lmU.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lmQ.a(eVar);
                    a dcn4 = a.dcn();
                    if (dcn4 != null) {
                        dcn4.a(this.lmQ);
                    }
                }
                if (this.lmQ.dcq().responseCode == 200) {
                    if (this.Km <= 0 && this.lmU != null) {
                        this.Km = this.lmU.kK();
                    }
                    eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                    this.lmQ.a(eVar);
                    a dcn5 = a.dcn();
                    if (dcn5 != null) {
                        dcn5.a(this.lmQ);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.lmQ.dcq().responseCode) + "|retryCount:" + i4;
                z = ak(this.lmQ.dcq().responseCode);
                this.lmQ.a(eVar);
                if (this.Km <= 0 && this.lmU != null) {
                    this.Km = this.lmU.kK();
                }
                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lmQ.a(eVar);
                a dcn6 = a.dcn();
                if (dcn6 != null) {
                    dcn6.a(this.lmQ);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Km <= 0 && this.lmU != null) {
                    this.Km = this.lmU.kK();
                }
                eVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.lmQ.dcp().getUrl(), this.lmQ.dcp().bC("Host"), TextUtils.isEmpty(eVar.exception), eVar.KI != null);
                this.lmQ.a(eVar);
                a dcn7 = a.dcn();
                if (dcn7 != null) {
                    dcn7.a(this.lmQ);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.lmU != null) {
            this.lmU.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.lmQ == null) {
            return false;
        }
        return this.lmQ.dcq().Le;
    }

    public void setCancel() {
        if (this.lmQ != null) {
            this.lmQ.dcq().Le = true;
        }
    }
}
