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
    private g mTb;
    private b mTf;
    private int LX = 0;
    private long LH = 0;

    public d(g gVar) {
        this.mTb = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.kY().lb().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kY().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.kY().kZ().getTimeOutAuto() : i4;
        this.mTf = new b(this.mTb);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.LX = i5;
                boolean a2 = this.mTf.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                this.mTb.a(eVar);
                a dDI = a.dDI();
                if (dDI != null) {
                    dDI.a(this.mTb);
                }
                return a2;
            } catch (FileNotFoundException e) {
                try {
                    this.mTb.dDL().responseCode = -100;
                    eVar.exception = String.valueOf(this.mTb.dDL().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.mTb.a(eVar);
                    com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                    this.mTb.a(eVar);
                    a dDI2 = a.dDI();
                    if (dDI2 != null) {
                        dDI2.a(this.mTb);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                    this.mTb.a(eVar);
                    a dDI3 = a.dDI();
                    if (dDI3 != null) {
                        dDI3.a(this.mTb);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.mTb.dDL().responseCode = -10;
                eVar.exception = String.valueOf(this.mTb.dDL().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.mTb.a(eVar);
                com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                this.mTb.a(eVar);
                a dDI4 = a.dDI();
                if (dDI4 != null) {
                    dDI4.a(this.mTb);
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
        for (int i4 = 0; !this.mTb.dDL().MD && z && i4 < i; i4++) {
            e eVar = new e();
            this.mTb.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.LX = i4;
                                eVar.retry = i4 + 1;
                                eVar.Mm = 1;
                                this.mTf = new b(this.mTb);
                                this.mTf.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.mTb.dDL().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.LH <= 0 && this.mTf != null) {
                                    this.LH = this.mTf.lL();
                                }
                                eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                                this.mTb.b(eVar);
                                a dDI = a.dDI();
                                if (dDI != null) {
                                    dDI.a(this.mTb);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.mTb.dDL().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.mTb.dDL().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.LH <= 0 && this.mTf != null) {
                                this.LH = this.mTf.lL();
                            }
                            eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                            this.mTb.b(eVar);
                            a dDI2 = a.dDI();
                            if (dDI2 != null) {
                                dDI2.a(this.mTb);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.mTb.dDL().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.mTb.dDL().mNetErrorCode = -13;
                        if (this.LH <= 0 && this.mTf != null) {
                            this.LH = this.mTf.lL();
                        }
                        eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                        this.mTb.b(eVar);
                        a dDI3 = a.dDI();
                        if (dDI3 != null) {
                            dDI3.a(this.mTb);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.mTb.dDL().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.mTb.dDL().mNetErrorCode = -12;
                    if (this.LH <= 0 && this.mTf != null) {
                        this.LH = this.mTf.lL();
                    }
                    eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                    this.mTb.b(eVar);
                    a dDI4 = a.dDI();
                    if (dDI4 != null) {
                        dDI4.a(this.mTb);
                    }
                    z = true;
                }
                if (this.mTb.dDL().responseCode == 200) {
                    this.mTb.b(eVar);
                    if (this.LH <= 0 && this.mTf != null) {
                        this.LH = this.mTf.lL();
                    }
                    eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                    this.mTb.b(eVar);
                    a dDI5 = a.dDI();
                    if (dDI5 != null) {
                        dDI5.a(this.mTb);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.mTb.dDL().responseCode) + "|retryCount:" + i4;
                boolean as = as(this.mTb.dDL().responseCode);
                if (this.LH <= 0 && this.mTf != null) {
                    this.LH = this.mTf.lL();
                }
                eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                this.mTb.b(eVar);
                a dDI6 = a.dDI();
                if (dDI6 != null) {
                    dDI6.a(this.mTb);
                }
                z = as;
            } catch (Throwable th) {
                if (this.LH <= 0 && this.mTf != null) {
                    this.LH = this.mTf.lL();
                }
                eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                this.mTb.b(eVar);
                a dDI7 = a.dDI();
                if (dDI7 != null) {
                    dDI7.a(this.mTb);
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
        for (int i4 = 0; !this.mTb.dDL().MD && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.LX = i4;
            try {
                try {
                    try {
                        this.mTf = new b(this.mTb);
                        this.mTf.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.mTb.dDL().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.mTb.a(eVar);
                        if (this.LH <= 0 && this.mTf != null) {
                            this.LH = this.mTf.lL();
                        }
                        eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                        this.mTb.a(eVar);
                        a dDI = a.dDI();
                        if (dDI != null && this.mTf != null && this.mTf.lO()) {
                            dDI.a(this.mTb);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.mTb.dDL().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.mTb.a(eVar);
                        if (this.LH <= 0 && this.mTf != null) {
                            this.LH = this.mTf.lL();
                        }
                        eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                        this.mTb.a(eVar);
                        a dDI2 = a.dDI();
                        if (dDI2 != null && this.mTf != null && this.mTf.lO()) {
                            dDI2.a(this.mTb);
                        }
                    }
                } catch (SocketException e3) {
                    this.mTb.dDL().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.mTb.a(eVar);
                    if (this.LH <= 0 && this.mTf != null) {
                        this.LH = this.mTf.lL();
                    }
                    eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                    this.mTb.a(eVar);
                    a dDI3 = a.dDI();
                    if (dDI3 != null && this.mTf != null && this.mTf.lO()) {
                        dDI3.a(this.mTb);
                    }
                } catch (Throwable th) {
                    this.mTb.dDL().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.mTb.a(eVar);
                    if (this.LH <= 0 && this.mTf != null) {
                        this.LH = this.mTf.lL();
                    }
                    eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                    this.mTb.a(eVar);
                    a dDI4 = a.dDI();
                    if (dDI4 != null && this.mTf != null && this.mTf.lO()) {
                        dDI4.a(this.mTb);
                    }
                }
                if (this.mTb.dDL().responseCode == 200) {
                    if (this.LH <= 0 && this.mTf != null) {
                        this.LH = this.mTf.lL();
                    }
                    eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                    this.mTb.a(eVar);
                    a dDI5 = a.dDI();
                    if (dDI5 == null || this.mTf == null || !this.mTf.lO()) {
                        return;
                    }
                    dDI5.a(this.mTb);
                    return;
                }
                eVar.exception = String.valueOf(this.mTb.dDL().responseCode) + "|retryCount:" + i4;
                z = as(this.mTb.dDL().responseCode);
                this.mTb.a(eVar);
                if (this.LH <= 0 && this.mTf != null) {
                    this.LH = this.mTf.lL();
                }
                eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                this.mTb.a(eVar);
                a dDI6 = a.dDI();
                if (dDI6 != null && this.mTf != null && this.mTf.lO()) {
                    dDI6.a(this.mTb);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.LH <= 0 && this.mTf != null) {
                    this.LH = this.mTf.lL();
                }
                eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                this.mTb.a(eVar);
                a dDI7 = a.dDI();
                if (dDI7 != null && this.mTf != null && this.mTf.lO()) {
                    dDI7.a(this.mTb);
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
        if (this.mTb.dDK().lY()) {
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
        for (int i4 = 0; !this.mTb.dDL().MD && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.LX = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.mTf = new b(this.mTb);
                        this.mTf.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.mTb.dDL().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.mTb.a(eVar);
                        if (this.LH <= 0 && this.mTf != null) {
                            this.LH = this.mTf.lL();
                        }
                        eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                        this.mTb.a(eVar);
                        a dDI = a.dDI();
                        if (dDI != null) {
                            dDI.a(this.mTb);
                        }
                    } catch (Throwable th) {
                        this.mTb.dDL().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.mTb.a(eVar);
                        if (this.LH <= 0 && this.mTf != null) {
                            this.LH = this.mTf.lL();
                        }
                        eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                        this.mTb.a(eVar);
                        a dDI2 = a.dDI();
                        if (dDI2 != null) {
                            dDI2.a(this.mTb);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.mTb.dDL().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.mTb.a(eVar);
                    if (this.LH <= 0 && this.mTf != null) {
                        this.LH = this.mTf.lL();
                    }
                    eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                    this.mTb.a(eVar);
                    a dDI3 = a.dDI();
                    if (dDI3 != null) {
                        dDI3.a(this.mTb);
                    }
                } catch (SocketException e3) {
                    this.mTb.dDL().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.mTb.a(eVar);
                    if (this.LH <= 0 && this.mTf != null) {
                        this.LH = this.mTf.lL();
                    }
                    eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                    this.mTb.a(eVar);
                    a dDI4 = a.dDI();
                    if (dDI4 != null) {
                        dDI4.a(this.mTb);
                    }
                }
                if (this.mTb.dDL().responseCode == 200) {
                    if (this.LH <= 0 && this.mTf != null) {
                        this.LH = this.mTf.lL();
                    }
                    eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                    this.mTb.a(eVar);
                    a dDI5 = a.dDI();
                    if (dDI5 != null) {
                        dDI5.a(this.mTb);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.mTb.dDL().responseCode) + "|retryCount:" + i4;
                z = as(this.mTb.dDL().responseCode);
                this.mTb.a(eVar);
                if (this.LH <= 0 && this.mTf != null) {
                    this.LH = this.mTf.lL();
                }
                eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                this.mTb.a(eVar);
                a dDI6 = a.dDI();
                if (dDI6 != null) {
                    dDI6.a(this.mTb);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.LH <= 0 && this.mTf != null) {
                    this.LH = this.mTf.lL();
                }
                eVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.mTb.dDK().getUrl(), this.mTb.dDK().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mf != null);
                this.mTb.a(eVar);
                a dDI7 = a.dDI();
                if (dDI7 != null) {
                    dDI7.a(this.mTb);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.mTf != null) {
            this.mTf.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.mTb == null) {
            return false;
        }
        return this.mTb.dDL().MD;
    }

    public void setCancel() {
        if (this.mTb != null) {
            this.mTb.dDL().MD = true;
        }
    }
}
