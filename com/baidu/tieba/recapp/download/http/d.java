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
    private g ksF;
    private b ksJ;
    private int JO = 0;
    private long JC = 0;

    public d(g gVar) {
        this.ksF = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.c.b.jH().jK().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.jH().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.c.b.jH().jI().getTimeOutAuto() : i4;
        this.ksJ = new b(this.ksF);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.JO = i5;
                boolean a = this.ksJ.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                this.ksF.a(eVar);
                a cNy = a.cNy();
                if (cNy != null) {
                    cNy.a(this.ksF);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.ksF.cNB().responseCode = -100;
                    eVar.exception = String.valueOf(this.ksF.cNB().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.ksF.a(eVar);
                    com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                    this.ksF.a(eVar);
                    a cNy2 = a.cNy();
                    if (cNy2 != null) {
                        cNy2.a(this.ksF);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                    this.ksF.a(eVar);
                    a cNy3 = a.cNy();
                    if (cNy3 != null) {
                        cNy3.a(this.ksF);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.ksF.cNB().responseCode = -10;
                eVar.exception = String.valueOf(this.ksF.cNB().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.ksF.a(eVar);
                com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                this.ksF.a(eVar);
                a cNy4 = a.cNy();
                if (cNy4 != null) {
                    cNy4.a(this.ksF);
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
        for (int i4 = 0; !this.ksF.cNB().Ks && z && i4 < i; i4++) {
            e eVar = new e();
            this.ksF.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.JO = i4;
                                eVar.retry = i4 + 1;
                                eVar.Kc = 1;
                                this.ksJ = new b(this.ksF);
                                this.ksJ.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.ksF.cNB().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.JC <= 0 && this.ksJ != null) {
                                    this.JC = this.ksJ.ks();
                                }
                                eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                                this.ksF.b(eVar);
                                a cNy = a.cNy();
                                if (cNy != null) {
                                    cNy.a(this.ksF);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.ksF.cNB().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.ksF.cNB().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.JC <= 0 && this.ksJ != null) {
                                this.JC = this.ksJ.ks();
                            }
                            eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                            this.ksF.b(eVar);
                            a cNy2 = a.cNy();
                            if (cNy2 != null) {
                                cNy2.a(this.ksF);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.ksF.cNB().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.ksF.cNB().mNetErrorCode = -13;
                        if (this.JC <= 0 && this.ksJ != null) {
                            this.JC = this.ksJ.ks();
                        }
                        eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                        this.ksF.b(eVar);
                        a cNy3 = a.cNy();
                        if (cNy3 != null) {
                            cNy3.a(this.ksF);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.ksF.cNB().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.ksF.cNB().mNetErrorCode = -12;
                    if (this.JC <= 0 && this.ksJ != null) {
                        this.JC = this.ksJ.ks();
                    }
                    eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                    this.ksF.b(eVar);
                    a cNy4 = a.cNy();
                    if (cNy4 != null) {
                        cNy4.a(this.ksF);
                    }
                    z = true;
                }
                if (this.ksF.cNB().responseCode == 200) {
                    this.ksF.b(eVar);
                    if (this.JC <= 0 && this.ksJ != null) {
                        this.JC = this.ksJ.ks();
                    }
                    eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                    this.ksF.b(eVar);
                    a cNy5 = a.cNy();
                    if (cNy5 != null) {
                        cNy5.a(this.ksF);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.ksF.cNB().responseCode) + "|retryCount:" + i4;
                boolean ab = ab(this.ksF.cNB().responseCode);
                if (this.JC <= 0 && this.ksJ != null) {
                    this.JC = this.ksJ.ks();
                }
                eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                this.ksF.b(eVar);
                a cNy6 = a.cNy();
                if (cNy6 != null) {
                    cNy6.a(this.ksF);
                }
                z = ab;
            } catch (Throwable th) {
                if (this.JC <= 0 && this.ksJ != null) {
                    this.JC = this.ksJ.ks();
                }
                eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                this.ksF.b(eVar);
                a cNy7 = a.cNy();
                if (cNy7 != null) {
                    cNy7.a(this.ksF);
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
        for (int i4 = 0; !this.ksF.cNB().Ks && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.JO = i4;
            try {
                try {
                    try {
                        this.ksJ = new b(this.ksF);
                        this.ksJ.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.ksF.cNB().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.ksF.a(eVar);
                        if (this.JC <= 0 && this.ksJ != null) {
                            this.JC = this.ksJ.ks();
                        }
                        eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                        this.ksF.a(eVar);
                        a cNy = a.cNy();
                        if (cNy != null && this.ksJ != null && this.ksJ.kv()) {
                            cNy.a(this.ksF);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.ksF.cNB().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.ksF.a(eVar);
                        if (this.JC <= 0 && this.ksJ != null) {
                            this.JC = this.ksJ.ks();
                        }
                        eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                        this.ksF.a(eVar);
                        a cNy2 = a.cNy();
                        if (cNy2 != null && this.ksJ != null && this.ksJ.kv()) {
                            cNy2.a(this.ksF);
                        }
                    }
                } catch (SocketException e3) {
                    this.ksF.cNB().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.ksF.a(eVar);
                    if (this.JC <= 0 && this.ksJ != null) {
                        this.JC = this.ksJ.ks();
                    }
                    eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                    this.ksF.a(eVar);
                    a cNy3 = a.cNy();
                    if (cNy3 != null && this.ksJ != null && this.ksJ.kv()) {
                        cNy3.a(this.ksF);
                    }
                } catch (Throwable th) {
                    this.ksF.cNB().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.ksF.a(eVar);
                    if (this.JC <= 0 && this.ksJ != null) {
                        this.JC = this.ksJ.ks();
                    }
                    eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                    this.ksF.a(eVar);
                    a cNy4 = a.cNy();
                    if (cNy4 != null && this.ksJ != null && this.ksJ.kv()) {
                        cNy4.a(this.ksF);
                    }
                }
                if (this.ksF.cNB().responseCode == 200) {
                    if (this.JC <= 0 && this.ksJ != null) {
                        this.JC = this.ksJ.ks();
                    }
                    eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                    this.ksF.a(eVar);
                    a cNy5 = a.cNy();
                    if (cNy5 == null || this.ksJ == null || !this.ksJ.kv()) {
                        return;
                    }
                    cNy5.a(this.ksF);
                    return;
                }
                eVar.exception = String.valueOf(this.ksF.cNB().responseCode) + "|retryCount:" + i4;
                z = ab(this.ksF.cNB().responseCode);
                this.ksF.a(eVar);
                if (this.JC <= 0 && this.ksJ != null) {
                    this.JC = this.ksJ.ks();
                }
                eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                this.ksF.a(eVar);
                a cNy6 = a.cNy();
                if (cNy6 != null && this.ksJ != null && this.ksJ.kv()) {
                    cNy6.a(this.ksF);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.JC <= 0 && this.ksJ != null) {
                    this.JC = this.ksJ.ks();
                }
                eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                this.ksF.a(eVar);
                a cNy7 = a.cNy();
                if (cNy7 != null && this.ksJ != null && this.ksJ.kv()) {
                    cNy7.a(this.ksF);
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
        if (this.ksF.cNA().kF()) {
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
        for (int i4 = 0; !this.ksF.cNB().Ks && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.JO = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.ksJ = new b(this.ksF);
                        this.ksJ.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.ksF.cNB().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.ksF.a(eVar);
                        if (this.JC <= 0 && this.ksJ != null) {
                            this.JC = this.ksJ.ks();
                        }
                        eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                        this.ksF.a(eVar);
                        a cNy = a.cNy();
                        if (cNy != null) {
                            cNy.a(this.ksF);
                        }
                    } catch (Throwable th) {
                        this.ksF.cNB().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.ksF.a(eVar);
                        if (this.JC <= 0 && this.ksJ != null) {
                            this.JC = this.ksJ.ks();
                        }
                        eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                        this.ksF.a(eVar);
                        a cNy2 = a.cNy();
                        if (cNy2 != null) {
                            cNy2.a(this.ksF);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.ksF.cNB().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.ksF.a(eVar);
                    if (this.JC <= 0 && this.ksJ != null) {
                        this.JC = this.ksJ.ks();
                    }
                    eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                    this.ksF.a(eVar);
                    a cNy3 = a.cNy();
                    if (cNy3 != null) {
                        cNy3.a(this.ksF);
                    }
                } catch (SocketException e3) {
                    this.ksF.cNB().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.ksF.a(eVar);
                    if (this.JC <= 0 && this.ksJ != null) {
                        this.JC = this.ksJ.ks();
                    }
                    eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                    this.ksF.a(eVar);
                    a cNy4 = a.cNy();
                    if (cNy4 != null) {
                        cNy4.a(this.ksF);
                    }
                }
                if (this.ksF.cNB().responseCode == 200) {
                    if (this.JC <= 0 && this.ksJ != null) {
                        this.JC = this.ksJ.ks();
                    }
                    eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                    this.ksF.a(eVar);
                    a cNy5 = a.cNy();
                    if (cNy5 != null) {
                        cNy5.a(this.ksF);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.ksF.cNB().responseCode) + "|retryCount:" + i4;
                z = ab(this.ksF.cNB().responseCode);
                this.ksF.a(eVar);
                if (this.JC <= 0 && this.ksJ != null) {
                    this.JC = this.ksJ.ks();
                }
                eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                this.ksF.a(eVar);
                a cNy6 = a.cNy();
                if (cNy6 != null) {
                    cNy6.a(this.ksF);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.JC <= 0 && this.ksJ != null) {
                    this.JC = this.ksJ.ks();
                }
                eVar.JR = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.kg().a(this.ksF.cNA().getUrl(), this.ksF.cNA().bA("Host"), TextUtils.isEmpty(eVar.exception), eVar.JV != null);
                this.ksF.a(eVar);
                a cNy7 = a.cNy();
                if (cNy7 != null) {
                    cNy7.a(this.ksF);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.ksJ != null) {
            this.ksJ.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.ksF == null) {
            return false;
        }
        return this.ksF.cNB().Ks;
    }

    public void setCancel() {
        if (this.ksF != null) {
            this.ksF.cNB().Ks = true;
        }
    }
}
