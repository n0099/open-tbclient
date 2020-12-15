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
    private g mIP;
    private b mIT;

    public d(g gVar) {
        this.mIP = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.lD().lG().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lD().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.lD().lE().getTimeOutAuto() : i4;
        this.mIT = new b(this.mIP);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.MC = i5;
                boolean a2 = this.mIT.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                this.mIP.a(eVar);
                a dFt = a.dFt();
                if (dFt != null) {
                    dFt.a(this.mIP);
                }
                return a2;
            } catch (FileNotFoundException e) {
                try {
                    this.mIP.dFw().responseCode = -100;
                    eVar.exception = String.valueOf(this.mIP.dFw().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.mIP.a(eVar);
                    com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                    this.mIP.a(eVar);
                    a dFt2 = a.dFt();
                    if (dFt2 != null) {
                        dFt2.a(this.mIP);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                    this.mIP.a(eVar);
                    a dFt3 = a.dFt();
                    if (dFt3 != null) {
                        dFt3.a(this.mIP);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.mIP.dFw().responseCode = -10;
                eVar.exception = String.valueOf(this.mIP.dFw().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.mIP.a(eVar);
                com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                this.mIP.a(eVar);
                a dFt4 = a.dFt();
                if (dFt4 != null) {
                    dFt4.a(this.mIP);
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
        for (int i4 = 0; !this.mIP.dFw().Nj && z && i4 < i; i4++) {
            e eVar = new e();
            this.mIP.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.MC = i4;
                                eVar.retry = i4 + 1;
                                eVar.MT = 1;
                                this.mIT = new b(this.mIP);
                                this.mIT.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.mIP.dFw().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Mn <= 0 && this.mIT != null) {
                                    this.Mn = this.mIT.mo();
                                }
                                eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                                this.mIP.b(eVar);
                                a dFt = a.dFt();
                                if (dFt != null) {
                                    dFt.a(this.mIP);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.mIP.dFw().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.mIP.dFw().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Mn <= 0 && this.mIT != null) {
                                this.Mn = this.mIT.mo();
                            }
                            eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                            this.mIP.b(eVar);
                            a dFt2 = a.dFt();
                            if (dFt2 != null) {
                                dFt2.a(this.mIP);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.mIP.dFw().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.mIP.dFw().mNetErrorCode = -13;
                        if (this.Mn <= 0 && this.mIT != null) {
                            this.Mn = this.mIT.mo();
                        }
                        eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                        this.mIP.b(eVar);
                        a dFt3 = a.dFt();
                        if (dFt3 != null) {
                            dFt3.a(this.mIP);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.mIP.dFw().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.mIP.dFw().mNetErrorCode = -12;
                    if (this.Mn <= 0 && this.mIT != null) {
                        this.Mn = this.mIT.mo();
                    }
                    eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                    this.mIP.b(eVar);
                    a dFt4 = a.dFt();
                    if (dFt4 != null) {
                        dFt4.a(this.mIP);
                    }
                    z = true;
                }
                if (this.mIP.dFw().responseCode == 200) {
                    this.mIP.b(eVar);
                    if (this.Mn <= 0 && this.mIT != null) {
                        this.Mn = this.mIT.mo();
                    }
                    eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                    this.mIP.b(eVar);
                    a dFt5 = a.dFt();
                    if (dFt5 != null) {
                        dFt5.a(this.mIP);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.mIP.dFw().responseCode) + "|retryCount:" + i4;
                boolean as = as(this.mIP.dFw().responseCode);
                if (this.Mn <= 0 && this.mIT != null) {
                    this.Mn = this.mIT.mo();
                }
                eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                this.mIP.b(eVar);
                a dFt6 = a.dFt();
                if (dFt6 != null) {
                    dFt6.a(this.mIP);
                }
                z = as;
            } catch (Throwable th) {
                if (this.Mn <= 0 && this.mIT != null) {
                    this.Mn = this.mIT.mo();
                }
                eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                this.mIP.b(eVar);
                a dFt7 = a.dFt();
                if (dFt7 != null) {
                    dFt7.a(this.mIP);
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
        for (int i4 = 0; !this.mIP.dFw().Nj && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.MC = i4;
            try {
                try {
                    try {
                        this.mIT = new b(this.mIP);
                        this.mIT.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.mIP.dFw().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.mIP.a(eVar);
                        if (this.Mn <= 0 && this.mIT != null) {
                            this.Mn = this.mIT.mo();
                        }
                        eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                        this.mIP.a(eVar);
                        a dFt = a.dFt();
                        if (dFt != null && this.mIT != null && this.mIT.mr()) {
                            dFt.a(this.mIP);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.mIP.dFw().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.mIP.a(eVar);
                        if (this.Mn <= 0 && this.mIT != null) {
                            this.Mn = this.mIT.mo();
                        }
                        eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                        this.mIP.a(eVar);
                        a dFt2 = a.dFt();
                        if (dFt2 != null && this.mIT != null && this.mIT.mr()) {
                            dFt2.a(this.mIP);
                        }
                    }
                } catch (SocketException e3) {
                    this.mIP.dFw().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.mIP.a(eVar);
                    if (this.Mn <= 0 && this.mIT != null) {
                        this.Mn = this.mIT.mo();
                    }
                    eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                    this.mIP.a(eVar);
                    a dFt3 = a.dFt();
                    if (dFt3 != null && this.mIT != null && this.mIT.mr()) {
                        dFt3.a(this.mIP);
                    }
                } catch (Throwable th) {
                    this.mIP.dFw().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.mIP.a(eVar);
                    if (this.Mn <= 0 && this.mIT != null) {
                        this.Mn = this.mIT.mo();
                    }
                    eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                    this.mIP.a(eVar);
                    a dFt4 = a.dFt();
                    if (dFt4 != null && this.mIT != null && this.mIT.mr()) {
                        dFt4.a(this.mIP);
                    }
                }
                if (this.mIP.dFw().responseCode == 200) {
                    if (this.Mn <= 0 && this.mIT != null) {
                        this.Mn = this.mIT.mo();
                    }
                    eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                    this.mIP.a(eVar);
                    a dFt5 = a.dFt();
                    if (dFt5 == null || this.mIT == null || !this.mIT.mr()) {
                        return;
                    }
                    dFt5.a(this.mIP);
                    return;
                }
                eVar.exception = String.valueOf(this.mIP.dFw().responseCode) + "|retryCount:" + i4;
                z = as(this.mIP.dFw().responseCode);
                this.mIP.a(eVar);
                if (this.Mn <= 0 && this.mIT != null) {
                    this.Mn = this.mIT.mo();
                }
                eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                this.mIP.a(eVar);
                a dFt6 = a.dFt();
                if (dFt6 != null && this.mIT != null && this.mIT.mr()) {
                    dFt6.a(this.mIP);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Mn <= 0 && this.mIT != null) {
                    this.Mn = this.mIT.mo();
                }
                eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                this.mIP.a(eVar);
                a dFt7 = a.dFt();
                if (dFt7 != null && this.mIT != null && this.mIT.mr()) {
                    dFt7.a(this.mIP);
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
        if (this.mIP.dFv().mB()) {
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
        for (int i4 = 0; !this.mIP.dFw().Nj && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.MC = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.mIT = new b(this.mIP);
                        this.mIT.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.mIP.dFw().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.mIP.a(eVar);
                        if (this.Mn <= 0 && this.mIT != null) {
                            this.Mn = this.mIT.mo();
                        }
                        eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                        this.mIP.a(eVar);
                        a dFt = a.dFt();
                        if (dFt != null) {
                            dFt.a(this.mIP);
                        }
                    } catch (Throwable th) {
                        this.mIP.dFw().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.mIP.a(eVar);
                        if (this.Mn <= 0 && this.mIT != null) {
                            this.Mn = this.mIT.mo();
                        }
                        eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                        this.mIP.a(eVar);
                        a dFt2 = a.dFt();
                        if (dFt2 != null) {
                            dFt2.a(this.mIP);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.mIP.dFw().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.mIP.a(eVar);
                    if (this.Mn <= 0 && this.mIT != null) {
                        this.Mn = this.mIT.mo();
                    }
                    eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                    this.mIP.a(eVar);
                    a dFt3 = a.dFt();
                    if (dFt3 != null) {
                        dFt3.a(this.mIP);
                    }
                } catch (SocketException e3) {
                    this.mIP.dFw().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.mIP.a(eVar);
                    if (this.Mn <= 0 && this.mIT != null) {
                        this.Mn = this.mIT.mo();
                    }
                    eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                    this.mIP.a(eVar);
                    a dFt4 = a.dFt();
                    if (dFt4 != null) {
                        dFt4.a(this.mIP);
                    }
                }
                if (this.mIP.dFw().responseCode == 200) {
                    if (this.Mn <= 0 && this.mIT != null) {
                        this.Mn = this.mIT.mo();
                    }
                    eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                    this.mIP.a(eVar);
                    a dFt5 = a.dFt();
                    if (dFt5 != null) {
                        dFt5.a(this.mIP);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.mIP.dFw().responseCode) + "|retryCount:" + i4;
                z = as(this.mIP.dFw().responseCode);
                this.mIP.a(eVar);
                if (this.Mn <= 0 && this.mIT != null) {
                    this.Mn = this.mIT.mo();
                }
                eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                this.mIP.a(eVar);
                a dFt6 = a.dFt();
                if (dFt6 != null) {
                    dFt6.a(this.mIP);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Mn <= 0 && this.mIT != null) {
                    this.Mn = this.mIT.mo();
                }
                eVar.MG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.mIP.dFv().getUrl(), this.mIP.dFv().bM("Host"), TextUtils.isEmpty(eVar.exception), eVar.MK != null);
                this.mIP.a(eVar);
                a dFt7 = a.dFt();
                if (dFt7 != null) {
                    dFt7.a(this.mIP);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.mIT != null) {
            this.mIT.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.mIP == null) {
            return false;
        }
        return this.mIP.dFw().Nj;
    }

    public void setCancel() {
        if (this.mIP != null) {
            this.mIP.dFw().Nj = true;
        }
    }
}
