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
    private g lDt;
    private b lDx;
    private int Ld = 0;
    private long KQ = 0;

    public d(g gVar) {
        this.lDt = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.ly().lB().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.ly().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.ly().lz().getTimeOutAuto() : i4;
        this.lDx = new b(this.lDt);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.Ld = i5;
                boolean a = this.lDx.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                this.lDt.a(eVar);
                a dnv = a.dnv();
                if (dnv != null) {
                    dnv.a(this.lDt);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.lDt.dny().responseCode = -100;
                    eVar.exception = String.valueOf(this.lDt.dny().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.lDt.a(eVar);
                    com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                    this.lDt.a(eVar);
                    a dnv2 = a.dnv();
                    if (dnv2 != null) {
                        dnv2.a(this.lDt);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                    this.lDt.a(eVar);
                    a dnv3 = a.dnv();
                    if (dnv3 != null) {
                        dnv3.a(this.lDt);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.lDt.dny().responseCode = -10;
                eVar.exception = String.valueOf(this.lDt.dny().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.lDt.a(eVar);
                com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                this.lDt.a(eVar);
                a dnv4 = a.dnv();
                if (dnv4 != null) {
                    dnv4.a(this.lDt);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.d.b.ly().lB().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.ly().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.ly().lz().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.lDt.dny().LJ && z && i4 < i; i4++) {
            e eVar = new e();
            this.lDt.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.Ld = i4;
                                eVar.retry = i4 + 1;
                                eVar.Ls = 1;
                                this.lDx = new b(this.lDt);
                                this.lDx.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.lDt.dny().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.KQ <= 0 && this.lDx != null) {
                                    this.KQ = this.lDx.mj();
                                }
                                eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                                this.lDt.b(eVar);
                                a dnv = a.dnv();
                                if (dnv != null) {
                                    dnv.a(this.lDt);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.lDt.dny().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.lDt.dny().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.KQ <= 0 && this.lDx != null) {
                                this.KQ = this.lDx.mj();
                            }
                            eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                            this.lDt.b(eVar);
                            a dnv2 = a.dnv();
                            if (dnv2 != null) {
                                dnv2.a(this.lDt);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.lDt.dny().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.lDt.dny().mNetErrorCode = -13;
                        if (this.KQ <= 0 && this.lDx != null) {
                            this.KQ = this.lDx.mj();
                        }
                        eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                        this.lDt.b(eVar);
                        a dnv3 = a.dnv();
                        if (dnv3 != null) {
                            dnv3.a(this.lDt);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.lDt.dny().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.lDt.dny().mNetErrorCode = -12;
                    if (this.KQ <= 0 && this.lDx != null) {
                        this.KQ = this.lDx.mj();
                    }
                    eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                    this.lDt.b(eVar);
                    a dnv4 = a.dnv();
                    if (dnv4 != null) {
                        dnv4.a(this.lDt);
                    }
                    z = true;
                }
                if (this.lDt.dny().responseCode == 200) {
                    this.lDt.b(eVar);
                    if (this.KQ <= 0 && this.lDx != null) {
                        this.KQ = this.lDx.mj();
                    }
                    eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                    this.lDt.b(eVar);
                    a dnv5 = a.dnv();
                    if (dnv5 != null) {
                        dnv5.a(this.lDt);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.lDt.dny().responseCode) + "|retryCount:" + i4;
                boolean am = am(this.lDt.dny().responseCode);
                if (this.KQ <= 0 && this.lDx != null) {
                    this.KQ = this.lDx.mj();
                }
                eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                this.lDt.b(eVar);
                a dnv6 = a.dnv();
                if (dnv6 != null) {
                    dnv6.a(this.lDt);
                }
                z = am;
            } catch (Throwable th) {
                if (this.KQ <= 0 && this.lDx != null) {
                    this.KQ = this.lDx.mj();
                }
                eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                this.lDt.b(eVar);
                a dnv7 = a.dnv();
                if (dnv7 != null) {
                    dnv7.a(this.lDt);
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
            i2 = com.baidu.adp.framework.d.b.ly().lB().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.ly().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.ly().lz().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.lDt.dny().LJ && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.Ld = i4;
            try {
                try {
                    try {
                        this.lDx = new b(this.lDt);
                        this.lDx.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.lDt.dny().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.lDt.a(eVar);
                        if (this.KQ <= 0 && this.lDx != null) {
                            this.KQ = this.lDx.mj();
                        }
                        eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                        this.lDt.a(eVar);
                        a dnv = a.dnv();
                        if (dnv != null && this.lDx != null && this.lDx.mm()) {
                            dnv.a(this.lDt);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.lDt.dny().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.lDt.a(eVar);
                        if (this.KQ <= 0 && this.lDx != null) {
                            this.KQ = this.lDx.mj();
                        }
                        eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                        this.lDt.a(eVar);
                        a dnv2 = a.dnv();
                        if (dnv2 != null && this.lDx != null && this.lDx.mm()) {
                            dnv2.a(this.lDt);
                        }
                    }
                } catch (SocketException e3) {
                    this.lDt.dny().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.lDt.a(eVar);
                    if (this.KQ <= 0 && this.lDx != null) {
                        this.KQ = this.lDx.mj();
                    }
                    eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                    this.lDt.a(eVar);
                    a dnv3 = a.dnv();
                    if (dnv3 != null && this.lDx != null && this.lDx.mm()) {
                        dnv3.a(this.lDt);
                    }
                } catch (Throwable th) {
                    this.lDt.dny().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.lDt.a(eVar);
                    if (this.KQ <= 0 && this.lDx != null) {
                        this.KQ = this.lDx.mj();
                    }
                    eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                    this.lDt.a(eVar);
                    a dnv4 = a.dnv();
                    if (dnv4 != null && this.lDx != null && this.lDx.mm()) {
                        dnv4.a(this.lDt);
                    }
                }
                if (this.lDt.dny().responseCode == 200) {
                    if (this.KQ <= 0 && this.lDx != null) {
                        this.KQ = this.lDx.mj();
                    }
                    eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                    this.lDt.a(eVar);
                    a dnv5 = a.dnv();
                    if (dnv5 == null || this.lDx == null || !this.lDx.mm()) {
                        return;
                    }
                    dnv5.a(this.lDt);
                    return;
                }
                eVar.exception = String.valueOf(this.lDt.dny().responseCode) + "|retryCount:" + i4;
                z = am(this.lDt.dny().responseCode);
                this.lDt.a(eVar);
                if (this.KQ <= 0 && this.lDx != null) {
                    this.KQ = this.lDx.mj();
                }
                eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                this.lDt.a(eVar);
                a dnv6 = a.dnv();
                if (dnv6 != null && this.lDx != null && this.lDx.mm()) {
                    dnv6.a(this.lDt);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.KQ <= 0 && this.lDx != null) {
                    this.KQ = this.lDx.mj();
                }
                eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                this.lDt.a(eVar);
                a dnv7 = a.dnv();
                if (dnv7 != null && this.lDx != null && this.lDx.mm()) {
                    dnv7.a(this.lDt);
                }
                throw th2;
            }
        }
    }

    private boolean am(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.lDt.dnx().mw()) {
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
            i2 = com.baidu.adp.framework.d.b.ly().lB().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.ly().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.ly().lz().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.lDt.dny().LJ && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.Ld = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.lDx = new b(this.lDt);
                        this.lDx.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.lDt.dny().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.lDt.a(eVar);
                        if (this.KQ <= 0 && this.lDx != null) {
                            this.KQ = this.lDx.mj();
                        }
                        eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                        this.lDt.a(eVar);
                        a dnv = a.dnv();
                        if (dnv != null) {
                            dnv.a(this.lDt);
                        }
                    } catch (Throwable th) {
                        this.lDt.dny().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.lDt.a(eVar);
                        if (this.KQ <= 0 && this.lDx != null) {
                            this.KQ = this.lDx.mj();
                        }
                        eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                        this.lDt.a(eVar);
                        a dnv2 = a.dnv();
                        if (dnv2 != null) {
                            dnv2.a(this.lDt);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.lDt.dny().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.lDt.a(eVar);
                    if (this.KQ <= 0 && this.lDx != null) {
                        this.KQ = this.lDx.mj();
                    }
                    eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                    this.lDt.a(eVar);
                    a dnv3 = a.dnv();
                    if (dnv3 != null) {
                        dnv3.a(this.lDt);
                    }
                } catch (SocketException e3) {
                    this.lDt.dny().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.lDt.a(eVar);
                    if (this.KQ <= 0 && this.lDx != null) {
                        this.KQ = this.lDx.mj();
                    }
                    eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                    this.lDt.a(eVar);
                    a dnv4 = a.dnv();
                    if (dnv4 != null) {
                        dnv4.a(this.lDt);
                    }
                }
                if (this.lDt.dny().responseCode == 200) {
                    if (this.KQ <= 0 && this.lDx != null) {
                        this.KQ = this.lDx.mj();
                    }
                    eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                    this.lDt.a(eVar);
                    a dnv5 = a.dnv();
                    if (dnv5 != null) {
                        dnv5.a(this.lDt);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.lDt.dny().responseCode) + "|retryCount:" + i4;
                z = am(this.lDt.dny().responseCode);
                this.lDt.a(eVar);
                if (this.KQ <= 0 && this.lDx != null) {
                    this.KQ = this.lDx.mj();
                }
                eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                this.lDt.a(eVar);
                a dnv6 = a.dnv();
                if (dnv6 != null) {
                    dnv6.a(this.lDt);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.KQ <= 0 && this.lDx != null) {
                    this.KQ = this.lDx.mj();
                }
                eVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lX().a(this.lDt.dnx().getUrl(), this.lDt.dnx().bH("Host"), TextUtils.isEmpty(eVar.exception), eVar.Ll != null);
                this.lDt.a(eVar);
                a dnv7 = a.dnv();
                if (dnv7 != null) {
                    dnv7.a(this.lDt);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.lDx != null) {
            this.lDx.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.lDt == null) {
            return false;
        }
        return this.lDt.dny().LJ;
    }

    public void setCancel() {
        if (this.lDt != null) {
            this.lDt.dny().LJ = true;
        }
    }
}
