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
    private g mJs;
    private b mJw;
    private int LZ = 0;
    private long LJ = 0;

    public d(g gVar) {
        this.mJs = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.kZ().lc().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kZ().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.kZ().la().getTimeOutAuto() : i4;
        this.mJw = new b(this.mJs);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.LZ = i5;
                boolean a2 = this.mJw.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                this.mJs.a(eVar);
                a dBr = a.dBr();
                if (dBr != null) {
                    dBr.a(this.mJs);
                }
                return a2;
            } catch (FileNotFoundException e) {
                try {
                    this.mJs.dBu().responseCode = -100;
                    eVar.exception = String.valueOf(this.mJs.dBu().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.mJs.a(eVar);
                    com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                    this.mJs.a(eVar);
                    a dBr2 = a.dBr();
                    if (dBr2 != null) {
                        dBr2.a(this.mJs);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                    this.mJs.a(eVar);
                    a dBr3 = a.dBr();
                    if (dBr3 != null) {
                        dBr3.a(this.mJs);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.mJs.dBu().responseCode = -10;
                eVar.exception = String.valueOf(this.mJs.dBu().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.mJs.a(eVar);
                com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                this.mJs.a(eVar);
                a dBr4 = a.dBr();
                if (dBr4 != null) {
                    dBr4.a(this.mJs);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.d.b.kZ().lc().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.kZ().la().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.mJs.dBu().MF && z && i4 < i; i4++) {
            e eVar = new e();
            this.mJs.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.LZ = i4;
                                eVar.retry = i4 + 1;
                                eVar.Mo = 1;
                                this.mJw = new b(this.mJs);
                                this.mJw.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.mJs.dBu().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.LJ <= 0 && this.mJw != null) {
                                    this.LJ = this.mJw.lM();
                                }
                                eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                                this.mJs.b(eVar);
                                a dBr = a.dBr();
                                if (dBr != null) {
                                    dBr.a(this.mJs);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.mJs.dBu().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.mJs.dBu().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.LJ <= 0 && this.mJw != null) {
                                this.LJ = this.mJw.lM();
                            }
                            eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                            this.mJs.b(eVar);
                            a dBr2 = a.dBr();
                            if (dBr2 != null) {
                                dBr2.a(this.mJs);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.mJs.dBu().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.mJs.dBu().mNetErrorCode = -13;
                        if (this.LJ <= 0 && this.mJw != null) {
                            this.LJ = this.mJw.lM();
                        }
                        eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                        this.mJs.b(eVar);
                        a dBr3 = a.dBr();
                        if (dBr3 != null) {
                            dBr3.a(this.mJs);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.mJs.dBu().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.mJs.dBu().mNetErrorCode = -12;
                    if (this.LJ <= 0 && this.mJw != null) {
                        this.LJ = this.mJw.lM();
                    }
                    eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                    this.mJs.b(eVar);
                    a dBr4 = a.dBr();
                    if (dBr4 != null) {
                        dBr4.a(this.mJs);
                    }
                    z = true;
                }
                if (this.mJs.dBu().responseCode == 200) {
                    this.mJs.b(eVar);
                    if (this.LJ <= 0 && this.mJw != null) {
                        this.LJ = this.mJw.lM();
                    }
                    eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                    this.mJs.b(eVar);
                    a dBr5 = a.dBr();
                    if (dBr5 != null) {
                        dBr5.a(this.mJs);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.mJs.dBu().responseCode) + "|retryCount:" + i4;
                boolean as = as(this.mJs.dBu().responseCode);
                if (this.LJ <= 0 && this.mJw != null) {
                    this.LJ = this.mJw.lM();
                }
                eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                this.mJs.b(eVar);
                a dBr6 = a.dBr();
                if (dBr6 != null) {
                    dBr6.a(this.mJs);
                }
                z = as;
            } catch (Throwable th) {
                if (this.LJ <= 0 && this.mJw != null) {
                    this.LJ = this.mJw.lM();
                }
                eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                this.mJs.b(eVar);
                a dBr7 = a.dBr();
                if (dBr7 != null) {
                    dBr7.a(this.mJs);
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
            i2 = com.baidu.adp.framework.d.b.kZ().lc().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.kZ().la().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.mJs.dBu().MF && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.LZ = i4;
            try {
                try {
                    try {
                        this.mJw = new b(this.mJs);
                        this.mJw.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.mJs.dBu().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.mJs.a(eVar);
                        if (this.LJ <= 0 && this.mJw != null) {
                            this.LJ = this.mJw.lM();
                        }
                        eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                        this.mJs.a(eVar);
                        a dBr = a.dBr();
                        if (dBr != null && this.mJw != null && this.mJw.lP()) {
                            dBr.a(this.mJs);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.mJs.dBu().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.mJs.a(eVar);
                        if (this.LJ <= 0 && this.mJw != null) {
                            this.LJ = this.mJw.lM();
                        }
                        eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                        this.mJs.a(eVar);
                        a dBr2 = a.dBr();
                        if (dBr2 != null && this.mJw != null && this.mJw.lP()) {
                            dBr2.a(this.mJs);
                        }
                    }
                } catch (SocketException e3) {
                    this.mJs.dBu().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.mJs.a(eVar);
                    if (this.LJ <= 0 && this.mJw != null) {
                        this.LJ = this.mJw.lM();
                    }
                    eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                    this.mJs.a(eVar);
                    a dBr3 = a.dBr();
                    if (dBr3 != null && this.mJw != null && this.mJw.lP()) {
                        dBr3.a(this.mJs);
                    }
                } catch (Throwable th) {
                    this.mJs.dBu().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.mJs.a(eVar);
                    if (this.LJ <= 0 && this.mJw != null) {
                        this.LJ = this.mJw.lM();
                    }
                    eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                    this.mJs.a(eVar);
                    a dBr4 = a.dBr();
                    if (dBr4 != null && this.mJw != null && this.mJw.lP()) {
                        dBr4.a(this.mJs);
                    }
                }
                if (this.mJs.dBu().responseCode == 200) {
                    if (this.LJ <= 0 && this.mJw != null) {
                        this.LJ = this.mJw.lM();
                    }
                    eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                    this.mJs.a(eVar);
                    a dBr5 = a.dBr();
                    if (dBr5 == null || this.mJw == null || !this.mJw.lP()) {
                        return;
                    }
                    dBr5.a(this.mJs);
                    return;
                }
                eVar.exception = String.valueOf(this.mJs.dBu().responseCode) + "|retryCount:" + i4;
                z = as(this.mJs.dBu().responseCode);
                this.mJs.a(eVar);
                if (this.LJ <= 0 && this.mJw != null) {
                    this.LJ = this.mJw.lM();
                }
                eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                this.mJs.a(eVar);
                a dBr6 = a.dBr();
                if (dBr6 != null && this.mJw != null && this.mJw.lP()) {
                    dBr6.a(this.mJs);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.LJ <= 0 && this.mJw != null) {
                    this.LJ = this.mJw.lM();
                }
                eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                this.mJs.a(eVar);
                a dBr7 = a.dBr();
                if (dBr7 != null && this.mJw != null && this.mJw.lP()) {
                    dBr7.a(this.mJs);
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
        if (this.mJs.dBt().lZ()) {
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
            i2 = com.baidu.adp.framework.d.b.kZ().lc().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.kZ().la().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.mJs.dBu().MF && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.LZ = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.mJw = new b(this.mJs);
                        this.mJw.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.mJs.dBu().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.mJs.a(eVar);
                        if (this.LJ <= 0 && this.mJw != null) {
                            this.LJ = this.mJw.lM();
                        }
                        eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                        this.mJs.a(eVar);
                        a dBr = a.dBr();
                        if (dBr != null) {
                            dBr.a(this.mJs);
                        }
                    } catch (Throwable th) {
                        this.mJs.dBu().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.mJs.a(eVar);
                        if (this.LJ <= 0 && this.mJw != null) {
                            this.LJ = this.mJw.lM();
                        }
                        eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                        this.mJs.a(eVar);
                        a dBr2 = a.dBr();
                        if (dBr2 != null) {
                            dBr2.a(this.mJs);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.mJs.dBu().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.mJs.a(eVar);
                    if (this.LJ <= 0 && this.mJw != null) {
                        this.LJ = this.mJw.lM();
                    }
                    eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                    this.mJs.a(eVar);
                    a dBr3 = a.dBr();
                    if (dBr3 != null) {
                        dBr3.a(this.mJs);
                    }
                } catch (SocketException e3) {
                    this.mJs.dBu().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.mJs.a(eVar);
                    if (this.LJ <= 0 && this.mJw != null) {
                        this.LJ = this.mJw.lM();
                    }
                    eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                    this.mJs.a(eVar);
                    a dBr4 = a.dBr();
                    if (dBr4 != null) {
                        dBr4.a(this.mJs);
                    }
                }
                if (this.mJs.dBu().responseCode == 200) {
                    if (this.LJ <= 0 && this.mJw != null) {
                        this.LJ = this.mJw.lM();
                    }
                    eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                    this.mJs.a(eVar);
                    a dBr5 = a.dBr();
                    if (dBr5 != null) {
                        dBr5.a(this.mJs);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.mJs.dBu().responseCode) + "|retryCount:" + i4;
                z = as(this.mJs.dBu().responseCode);
                this.mJs.a(eVar);
                if (this.LJ <= 0 && this.mJw != null) {
                    this.LJ = this.mJw.lM();
                }
                eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                this.mJs.a(eVar);
                a dBr6 = a.dBr();
                if (dBr6 != null) {
                    dBr6.a(this.mJs);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.LJ <= 0 && this.mJw != null) {
                    this.LJ = this.mJw.lM();
                }
                eVar.Md = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lA().a(this.mJs.dBt().getUrl(), this.mJs.dBt().bG("Host"), TextUtils.isEmpty(eVar.exception), eVar.Mh != null);
                this.mJs.a(eVar);
                a dBr7 = a.dBr();
                if (dBr7 != null) {
                    dBr7.a(this.mJs);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.mJw != null) {
            this.mJw.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.mJs == null) {
            return false;
        }
        return this.mJs.dBu().MF;
    }

    public void setCancel() {
        if (this.mJs != null) {
            this.mJs.dBu().MF = true;
        }
    }
}
