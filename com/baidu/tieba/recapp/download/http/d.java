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
    private g mbP;
    private b mbT;

    public d(g gVar) {
        this.mbP = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.lD().lG().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lD().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.lD().lE().getTimeOutAuto() : i4;
        this.mbT = new b(this.mbP);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.LD = i5;
                boolean a2 = this.mbT.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                this.mbP.a(eVar);
                a duS = a.duS();
                if (duS != null) {
                    duS.a(this.mbP);
                }
                return a2;
            } catch (FileNotFoundException e) {
                try {
                    this.mbP.duV().responseCode = -100;
                    eVar.exception = String.valueOf(this.mbP.duV().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.mbP.a(eVar);
                    com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                    this.mbP.a(eVar);
                    a duS2 = a.duS();
                    if (duS2 != null) {
                        duS2.a(this.mbP);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                    this.mbP.a(eVar);
                    a duS3 = a.duS();
                    if (duS3 != null) {
                        duS3.a(this.mbP);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.mbP.duV().responseCode = -10;
                eVar.exception = String.valueOf(this.mbP.duV().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.mbP.a(eVar);
                com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                this.mbP.a(eVar);
                a duS4 = a.duS();
                if (duS4 != null) {
                    duS4.a(this.mbP);
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
        for (int i4 = 0; !this.mbP.duV().Mn && z && i4 < i; i4++) {
            e eVar = new e();
            this.mbP.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.LD = i4;
                                eVar.retry = i4 + 1;
                                eVar.LX = 1;
                                this.mbT = new b(this.mbP);
                                this.mbT.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.mbP.duV().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Lp <= 0 && this.mbT != null) {
                                    this.Lp = this.mbT.mo();
                                }
                                eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                                this.mbP.b(eVar);
                                a duS = a.duS();
                                if (duS != null) {
                                    duS.a(this.mbP);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.mbP.duV().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.mbP.duV().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Lp <= 0 && this.mbT != null) {
                                this.Lp = this.mbT.mo();
                            }
                            eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                            this.mbP.b(eVar);
                            a duS2 = a.duS();
                            if (duS2 != null) {
                                duS2.a(this.mbP);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.mbP.duV().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.mbP.duV().mNetErrorCode = -13;
                        if (this.Lp <= 0 && this.mbT != null) {
                            this.Lp = this.mbT.mo();
                        }
                        eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                        this.mbP.b(eVar);
                        a duS3 = a.duS();
                        if (duS3 != null) {
                            duS3.a(this.mbP);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.mbP.duV().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.mbP.duV().mNetErrorCode = -12;
                    if (this.Lp <= 0 && this.mbT != null) {
                        this.Lp = this.mbT.mo();
                    }
                    eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                    this.mbP.b(eVar);
                    a duS4 = a.duS();
                    if (duS4 != null) {
                        duS4.a(this.mbP);
                    }
                    z = true;
                }
                if (this.mbP.duV().responseCode == 200) {
                    this.mbP.b(eVar);
                    if (this.Lp <= 0 && this.mbT != null) {
                        this.Lp = this.mbT.mo();
                    }
                    eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                    this.mbP.b(eVar);
                    a duS5 = a.duS();
                    if (duS5 != null) {
                        duS5.a(this.mbP);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.mbP.duV().responseCode) + "|retryCount:" + i4;
                boolean ap = ap(this.mbP.duV().responseCode);
                if (this.Lp <= 0 && this.mbT != null) {
                    this.Lp = this.mbT.mo();
                }
                eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                this.mbP.b(eVar);
                a duS6 = a.duS();
                if (duS6 != null) {
                    duS6.a(this.mbP);
                }
                z = ap;
            } catch (Throwable th) {
                if (this.Lp <= 0 && this.mbT != null) {
                    this.Lp = this.mbT.mo();
                }
                eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                this.mbP.b(eVar);
                a duS7 = a.duS();
                if (duS7 != null) {
                    duS7.a(this.mbP);
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
        for (int i4 = 0; !this.mbP.duV().Mn && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.LD = i4;
            try {
                try {
                    try {
                        this.mbT = new b(this.mbP);
                        this.mbT.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.mbP.duV().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.mbP.a(eVar);
                        if (this.Lp <= 0 && this.mbT != null) {
                            this.Lp = this.mbT.mo();
                        }
                        eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                        this.mbP.a(eVar);
                        a duS = a.duS();
                        if (duS != null && this.mbT != null && this.mbT.mr()) {
                            duS.a(this.mbP);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.mbP.duV().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.mbP.a(eVar);
                        if (this.Lp <= 0 && this.mbT != null) {
                            this.Lp = this.mbT.mo();
                        }
                        eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                        this.mbP.a(eVar);
                        a duS2 = a.duS();
                        if (duS2 != null && this.mbT != null && this.mbT.mr()) {
                            duS2.a(this.mbP);
                        }
                    }
                } catch (SocketException e3) {
                    this.mbP.duV().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.mbP.a(eVar);
                    if (this.Lp <= 0 && this.mbT != null) {
                        this.Lp = this.mbT.mo();
                    }
                    eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                    this.mbP.a(eVar);
                    a duS3 = a.duS();
                    if (duS3 != null && this.mbT != null && this.mbT.mr()) {
                        duS3.a(this.mbP);
                    }
                } catch (Throwable th) {
                    this.mbP.duV().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.mbP.a(eVar);
                    if (this.Lp <= 0 && this.mbT != null) {
                        this.Lp = this.mbT.mo();
                    }
                    eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                    this.mbP.a(eVar);
                    a duS4 = a.duS();
                    if (duS4 != null && this.mbT != null && this.mbT.mr()) {
                        duS4.a(this.mbP);
                    }
                }
                if (this.mbP.duV().responseCode == 200) {
                    if (this.Lp <= 0 && this.mbT != null) {
                        this.Lp = this.mbT.mo();
                    }
                    eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                    this.mbP.a(eVar);
                    a duS5 = a.duS();
                    if (duS5 == null || this.mbT == null || !this.mbT.mr()) {
                        return;
                    }
                    duS5.a(this.mbP);
                    return;
                }
                eVar.exception = String.valueOf(this.mbP.duV().responseCode) + "|retryCount:" + i4;
                z = ap(this.mbP.duV().responseCode);
                this.mbP.a(eVar);
                if (this.Lp <= 0 && this.mbT != null) {
                    this.Lp = this.mbT.mo();
                }
                eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                this.mbP.a(eVar);
                a duS6 = a.duS();
                if (duS6 != null && this.mbT != null && this.mbT.mr()) {
                    duS6.a(this.mbP);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Lp <= 0 && this.mbT != null) {
                    this.Lp = this.mbT.mo();
                }
                eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                this.mbP.a(eVar);
                a duS7 = a.duS();
                if (duS7 != null && this.mbT != null && this.mbT.mr()) {
                    duS7.a(this.mbP);
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
        if (this.mbP.duU().mB()) {
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
        for (int i4 = 0; !this.mbP.duV().Mn && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.LD = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.mbT = new b(this.mbP);
                        this.mbT.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.mbP.duV().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.mbP.a(eVar);
                        if (this.Lp <= 0 && this.mbT != null) {
                            this.Lp = this.mbT.mo();
                        }
                        eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                        this.mbP.a(eVar);
                        a duS = a.duS();
                        if (duS != null) {
                            duS.a(this.mbP);
                        }
                    } catch (Throwable th) {
                        this.mbP.duV().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.mbP.a(eVar);
                        if (this.Lp <= 0 && this.mbT != null) {
                            this.Lp = this.mbT.mo();
                        }
                        eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                        this.mbP.a(eVar);
                        a duS2 = a.duS();
                        if (duS2 != null) {
                            duS2.a(this.mbP);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.mbP.duV().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.mbP.a(eVar);
                    if (this.Lp <= 0 && this.mbT != null) {
                        this.Lp = this.mbT.mo();
                    }
                    eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                    this.mbP.a(eVar);
                    a duS3 = a.duS();
                    if (duS3 != null) {
                        duS3.a(this.mbP);
                    }
                } catch (SocketException e3) {
                    this.mbP.duV().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.mbP.a(eVar);
                    if (this.Lp <= 0 && this.mbT != null) {
                        this.Lp = this.mbT.mo();
                    }
                    eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                    this.mbP.a(eVar);
                    a duS4 = a.duS();
                    if (duS4 != null) {
                        duS4.a(this.mbP);
                    }
                }
                if (this.mbP.duV().responseCode == 200) {
                    if (this.Lp <= 0 && this.mbT != null) {
                        this.Lp = this.mbT.mo();
                    }
                    eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                    this.mbP.a(eVar);
                    a duS5 = a.duS();
                    if (duS5 != null) {
                        duS5.a(this.mbP);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.mbP.duV().responseCode) + "|retryCount:" + i4;
                z = ap(this.mbP.duV().responseCode);
                this.mbP.a(eVar);
                if (this.Lp <= 0 && this.mbT != null) {
                    this.Lp = this.mbT.mo();
                }
                eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                this.mbP.a(eVar);
                a duS6 = a.duS();
                if (duS6 != null) {
                    duS6.a(this.mbP);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Lp <= 0 && this.mbT != null) {
                    this.Lp = this.mbT.mo();
                }
                eVar.LJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mbP.duU().getUrl(), this.mbP.duU().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LO != null);
                this.mbP.a(eVar);
                a duS7 = a.duS();
                if (duS7 != null) {
                    duS7.a(this.mbP);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.mbT != null) {
            this.mbT.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.mbP == null) {
            return false;
        }
        return this.mbP.duV().Mn;
    }

    public void setCancel() {
        if (this.mbP != null) {
            this.mbP.duV().Mn = true;
        }
    }
}
