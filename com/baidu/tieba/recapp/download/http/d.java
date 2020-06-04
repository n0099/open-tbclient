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
    private g kLI;
    private b kLM;
    private int JZ = 0;
    private long JM = 0;

    public d(g gVar) {
        this.kLI = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.jJ().jM().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jJ().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.jJ().jK().getTimeOutAuto() : i4;
        this.kLM = new b(this.kLI);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.JZ = i5;
                boolean a = this.kLM.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                this.kLI.a(eVar);
                a cUP = a.cUP();
                if (cUP != null) {
                    cUP.a(this.kLI);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.kLI.cUS().responseCode = -100;
                    eVar.exception = String.valueOf(this.kLI.cUS().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.kLI.a(eVar);
                    com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                    this.kLI.a(eVar);
                    a cUP2 = a.cUP();
                    if (cUP2 != null) {
                        cUP2.a(this.kLI);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                    this.kLI.a(eVar);
                    a cUP3 = a.cUP();
                    if (cUP3 != null) {
                        cUP3.a(this.kLI);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.kLI.cUS().responseCode = -10;
                eVar.exception = String.valueOf(this.kLI.cUS().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.kLI.a(eVar);
                com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                this.kLI.a(eVar);
                a cUP4 = a.cUP();
                if (cUP4 != null) {
                    cUP4.a(this.kLI);
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
        for (int i4 = 0; !this.kLI.cUS().KE && z && i4 < i; i4++) {
            e eVar = new e();
            this.kLI.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.JZ = i4;
                                eVar.retry = i4 + 1;
                                eVar.Ko = 1;
                                this.kLM = new b(this.kLI);
                                this.kLM.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.kLI.cUS().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.JM <= 0 && this.kLM != null) {
                                    this.JM = this.kLM.ku();
                                }
                                eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                                this.kLI.b(eVar);
                                a cUP = a.cUP();
                                if (cUP != null) {
                                    cUP.a(this.kLI);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.kLI.cUS().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.kLI.cUS().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.JM <= 0 && this.kLM != null) {
                                this.JM = this.kLM.ku();
                            }
                            eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                            this.kLI.b(eVar);
                            a cUP2 = a.cUP();
                            if (cUP2 != null) {
                                cUP2.a(this.kLI);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.kLI.cUS().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.kLI.cUS().mNetErrorCode = -13;
                        if (this.JM <= 0 && this.kLM != null) {
                            this.JM = this.kLM.ku();
                        }
                        eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                        this.kLI.b(eVar);
                        a cUP3 = a.cUP();
                        if (cUP3 != null) {
                            cUP3.a(this.kLI);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.kLI.cUS().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.kLI.cUS().mNetErrorCode = -12;
                    if (this.JM <= 0 && this.kLM != null) {
                        this.JM = this.kLM.ku();
                    }
                    eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                    this.kLI.b(eVar);
                    a cUP4 = a.cUP();
                    if (cUP4 != null) {
                        cUP4.a(this.kLI);
                    }
                    z = true;
                }
                if (this.kLI.cUS().responseCode == 200) {
                    this.kLI.b(eVar);
                    if (this.JM <= 0 && this.kLM != null) {
                        this.JM = this.kLM.ku();
                    }
                    eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                    this.kLI.b(eVar);
                    a cUP5 = a.cUP();
                    if (cUP5 != null) {
                        cUP5.a(this.kLI);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.kLI.cUS().responseCode) + "|retryCount:" + i4;
                boolean ac = ac(this.kLI.cUS().responseCode);
                if (this.JM <= 0 && this.kLM != null) {
                    this.JM = this.kLM.ku();
                }
                eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                this.kLI.b(eVar);
                a cUP6 = a.cUP();
                if (cUP6 != null) {
                    cUP6.a(this.kLI);
                }
                z = ac;
            } catch (Throwable th) {
                if (this.JM <= 0 && this.kLM != null) {
                    this.JM = this.kLM.ku();
                }
                eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                this.kLI.b(eVar);
                a cUP7 = a.cUP();
                if (cUP7 != null) {
                    cUP7.a(this.kLI);
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
        for (int i4 = 0; !this.kLI.cUS().KE && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.JZ = i4;
            try {
                try {
                    try {
                        this.kLM = new b(this.kLI);
                        this.kLM.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.kLI.cUS().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.kLI.a(eVar);
                        if (this.JM <= 0 && this.kLM != null) {
                            this.JM = this.kLM.ku();
                        }
                        eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                        this.kLI.a(eVar);
                        a cUP = a.cUP();
                        if (cUP != null && this.kLM != null && this.kLM.kx()) {
                            cUP.a(this.kLI);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.kLI.cUS().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.kLI.a(eVar);
                        if (this.JM <= 0 && this.kLM != null) {
                            this.JM = this.kLM.ku();
                        }
                        eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                        this.kLI.a(eVar);
                        a cUP2 = a.cUP();
                        if (cUP2 != null && this.kLM != null && this.kLM.kx()) {
                            cUP2.a(this.kLI);
                        }
                    }
                } catch (SocketException e3) {
                    this.kLI.cUS().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.kLI.a(eVar);
                    if (this.JM <= 0 && this.kLM != null) {
                        this.JM = this.kLM.ku();
                    }
                    eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                    this.kLI.a(eVar);
                    a cUP3 = a.cUP();
                    if (cUP3 != null && this.kLM != null && this.kLM.kx()) {
                        cUP3.a(this.kLI);
                    }
                } catch (Throwable th) {
                    this.kLI.cUS().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.kLI.a(eVar);
                    if (this.JM <= 0 && this.kLM != null) {
                        this.JM = this.kLM.ku();
                    }
                    eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                    this.kLI.a(eVar);
                    a cUP4 = a.cUP();
                    if (cUP4 != null && this.kLM != null && this.kLM.kx()) {
                        cUP4.a(this.kLI);
                    }
                }
                if (this.kLI.cUS().responseCode == 200) {
                    if (this.JM <= 0 && this.kLM != null) {
                        this.JM = this.kLM.ku();
                    }
                    eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                    this.kLI.a(eVar);
                    a cUP5 = a.cUP();
                    if (cUP5 == null || this.kLM == null || !this.kLM.kx()) {
                        return;
                    }
                    cUP5.a(this.kLI);
                    return;
                }
                eVar.exception = String.valueOf(this.kLI.cUS().responseCode) + "|retryCount:" + i4;
                z = ac(this.kLI.cUS().responseCode);
                this.kLI.a(eVar);
                if (this.JM <= 0 && this.kLM != null) {
                    this.JM = this.kLM.ku();
                }
                eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                this.kLI.a(eVar);
                a cUP6 = a.cUP();
                if (cUP6 != null && this.kLM != null && this.kLM.kx()) {
                    cUP6.a(this.kLI);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.JM <= 0 && this.kLM != null) {
                    this.JM = this.kLM.ku();
                }
                eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                this.kLI.a(eVar);
                a cUP7 = a.cUP();
                if (cUP7 != null && this.kLM != null && this.kLM.kx()) {
                    cUP7.a(this.kLI);
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
        if (this.kLI.cUR().kH()) {
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
        for (int i4 = 0; !this.kLI.cUS().KE && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.JZ = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.kLM = new b(this.kLI);
                        this.kLM.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.kLI.cUS().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.kLI.a(eVar);
                        if (this.JM <= 0 && this.kLM != null) {
                            this.JM = this.kLM.ku();
                        }
                        eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                        this.kLI.a(eVar);
                        a cUP = a.cUP();
                        if (cUP != null) {
                            cUP.a(this.kLI);
                        }
                    } catch (Throwable th) {
                        this.kLI.cUS().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.kLI.a(eVar);
                        if (this.JM <= 0 && this.kLM != null) {
                            this.JM = this.kLM.ku();
                        }
                        eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                        this.kLI.a(eVar);
                        a cUP2 = a.cUP();
                        if (cUP2 != null) {
                            cUP2.a(this.kLI);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.kLI.cUS().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.kLI.a(eVar);
                    if (this.JM <= 0 && this.kLM != null) {
                        this.JM = this.kLM.ku();
                    }
                    eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                    this.kLI.a(eVar);
                    a cUP3 = a.cUP();
                    if (cUP3 != null) {
                        cUP3.a(this.kLI);
                    }
                } catch (SocketException e3) {
                    this.kLI.cUS().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.kLI.a(eVar);
                    if (this.JM <= 0 && this.kLM != null) {
                        this.JM = this.kLM.ku();
                    }
                    eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                    this.kLI.a(eVar);
                    a cUP4 = a.cUP();
                    if (cUP4 != null) {
                        cUP4.a(this.kLI);
                    }
                }
                if (this.kLI.cUS().responseCode == 200) {
                    if (this.JM <= 0 && this.kLM != null) {
                        this.JM = this.kLM.ku();
                    }
                    eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                    this.kLI.a(eVar);
                    a cUP5 = a.cUP();
                    if (cUP5 != null) {
                        cUP5.a(this.kLI);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.kLI.cUS().responseCode) + "|retryCount:" + i4;
                z = ac(this.kLI.cUS().responseCode);
                this.kLI.a(eVar);
                if (this.JM <= 0 && this.kLM != null) {
                    this.JM = this.kLM.ku();
                }
                eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                this.kLI.a(eVar);
                a cUP6 = a.cUP();
                if (cUP6 != null) {
                    cUP6.a(this.kLI);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.JM <= 0 && this.kLM != null) {
                    this.JM = this.kLM.ku();
                }
                eVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ki().a(this.kLI.cUR().getUrl(), this.kLI.cUR().bB("Host"), TextUtils.isEmpty(eVar.exception), eVar.Kh != null);
                this.kLI.a(eVar);
                a cUP7 = a.cUP();
                if (cUP7 != null) {
                    cUP7.a(this.kLI);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.kLM != null) {
            this.kLM.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.kLI == null) {
            return false;
        }
        return this.kLI.cUS().KE;
    }

    public void setCancel() {
        if (this.kLI != null) {
            this.kLI.cUS().KE = true;
        }
    }
}
