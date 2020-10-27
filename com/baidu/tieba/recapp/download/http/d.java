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
    private g moo;
    private b mos;

    public d(g gVar) {
        this.moo = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.lD().lG().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lD().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.lD().lE().getTimeOutAuto() : i4;
        this.mos = new b(this.moo);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.retry = i5 + 1;
                this.LD = i5;
                boolean a2 = this.mos.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.moo.a(eVar);
                a dxZ = a.dxZ();
                if (dxZ != null) {
                    dxZ.a(this.moo);
                }
                return a2;
            } catch (FileNotFoundException e) {
                try {
                    this.moo.dyc().responseCode = -100;
                    eVar.exception = String.valueOf(this.moo.dyc().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.moo.a(eVar);
                    com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.moo.a(eVar);
                    a dxZ2 = a.dxZ();
                    if (dxZ2 != null) {
                        dxZ2.a(this.moo);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.moo.a(eVar);
                    a dxZ3 = a.dxZ();
                    if (dxZ3 != null) {
                        dxZ3.a(this.moo);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.moo.dyc().responseCode = -10;
                eVar.exception = String.valueOf(this.moo.dyc().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.moo.a(eVar);
                com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.moo.a(eVar);
                a dxZ4 = a.dxZ();
                if (dxZ4 != null) {
                    dxZ4.a(this.moo);
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
        for (int i4 = 0; !this.moo.dyc().Mo && z && i4 < i; i4++) {
            e eVar = new e();
            this.moo.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.LD = i4;
                                eVar.retry = i4 + 1;
                                eVar.LY = 1;
                                this.mos = new b(this.moo);
                                this.mos.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.moo.dyc().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Lp <= 0 && this.mos != null) {
                                    this.Lp = this.mos.mo();
                                }
                                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                                this.moo.b(eVar);
                                a dxZ = a.dxZ();
                                if (dxZ != null) {
                                    dxZ.a(this.moo);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.moo.dyc().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.moo.dyc().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Lp <= 0 && this.mos != null) {
                                this.Lp = this.mos.mo();
                            }
                            eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                            this.moo.b(eVar);
                            a dxZ2 = a.dxZ();
                            if (dxZ2 != null) {
                                dxZ2.a(this.moo);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.moo.dyc().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.moo.dyc().mNetErrorCode = -13;
                        if (this.Lp <= 0 && this.mos != null) {
                            this.Lp = this.mos.mo();
                        }
                        eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                        this.moo.b(eVar);
                        a dxZ3 = a.dxZ();
                        if (dxZ3 != null) {
                            dxZ3.a(this.moo);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.moo.dyc().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.moo.dyc().mNetErrorCode = -12;
                    if (this.Lp <= 0 && this.mos != null) {
                        this.Lp = this.mos.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.moo.b(eVar);
                    a dxZ4 = a.dxZ();
                    if (dxZ4 != null) {
                        dxZ4.a(this.moo);
                    }
                    z = true;
                }
                if (this.moo.dyc().responseCode == 200) {
                    this.moo.b(eVar);
                    if (this.Lp <= 0 && this.mos != null) {
                        this.Lp = this.mos.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.moo.b(eVar);
                    a dxZ5 = a.dxZ();
                    if (dxZ5 != null) {
                        dxZ5.a(this.moo);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.moo.dyc().responseCode) + "|retryCount:" + i4;
                boolean ap = ap(this.moo.dyc().responseCode);
                if (this.Lp <= 0 && this.mos != null) {
                    this.Lp = this.mos.mo();
                }
                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.moo.b(eVar);
                a dxZ6 = a.dxZ();
                if (dxZ6 != null) {
                    dxZ6.a(this.moo);
                }
                z = ap;
            } catch (Throwable th) {
                if (this.Lp <= 0 && this.mos != null) {
                    this.Lp = this.mos.mo();
                }
                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.moo.b(eVar);
                a dxZ7 = a.dxZ();
                if (dxZ7 != null) {
                    dxZ7.a(this.moo);
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
        for (int i4 = 0; !this.moo.dyc().Mo && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.retry = i4 + 1;
            this.LD = i4;
            try {
                try {
                    try {
                        this.mos = new b(this.moo);
                        this.mos.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.moo.dyc().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.moo.a(eVar);
                        if (this.Lp <= 0 && this.mos != null) {
                            this.Lp = this.mos.mo();
                        }
                        eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                        this.moo.a(eVar);
                        a dxZ = a.dxZ();
                        if (dxZ != null && this.mos != null && this.mos.mr()) {
                            dxZ.a(this.moo);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.moo.dyc().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.moo.a(eVar);
                        if (this.Lp <= 0 && this.mos != null) {
                            this.Lp = this.mos.mo();
                        }
                        eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                        this.moo.a(eVar);
                        a dxZ2 = a.dxZ();
                        if (dxZ2 != null && this.mos != null && this.mos.mr()) {
                            dxZ2.a(this.moo);
                        }
                    }
                } catch (SocketException e3) {
                    this.moo.dyc().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.moo.a(eVar);
                    if (this.Lp <= 0 && this.mos != null) {
                        this.Lp = this.mos.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.moo.a(eVar);
                    a dxZ3 = a.dxZ();
                    if (dxZ3 != null && this.mos != null && this.mos.mr()) {
                        dxZ3.a(this.moo);
                    }
                } catch (Throwable th) {
                    this.moo.dyc().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.moo.a(eVar);
                    if (this.Lp <= 0 && this.mos != null) {
                        this.Lp = this.mos.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.moo.a(eVar);
                    a dxZ4 = a.dxZ();
                    if (dxZ4 != null && this.mos != null && this.mos.mr()) {
                        dxZ4.a(this.moo);
                    }
                }
                if (this.moo.dyc().responseCode == 200) {
                    if (this.Lp <= 0 && this.mos != null) {
                        this.Lp = this.mos.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.moo.a(eVar);
                    a dxZ5 = a.dxZ();
                    if (dxZ5 == null || this.mos == null || !this.mos.mr()) {
                        return;
                    }
                    dxZ5.a(this.moo);
                    return;
                }
                eVar.exception = String.valueOf(this.moo.dyc().responseCode) + "|retryCount:" + i4;
                z = ap(this.moo.dyc().responseCode);
                this.moo.a(eVar);
                if (this.Lp <= 0 && this.mos != null) {
                    this.Lp = this.mos.mo();
                }
                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.moo.a(eVar);
                a dxZ6 = a.dxZ();
                if (dxZ6 != null && this.mos != null && this.mos.mr()) {
                    dxZ6.a(this.moo);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Lp <= 0 && this.mos != null) {
                    this.Lp = this.mos.mo();
                }
                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.moo.a(eVar);
                a dxZ7 = a.dxZ();
                if (dxZ7 != null && this.mos != null && this.mos.mr()) {
                    dxZ7.a(this.moo);
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
        if (this.moo.dyb().mB()) {
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
        for (int i4 = 0; !this.moo.dyc().Mo && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.LD = i4;
            eVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.mos = new b(this.moo);
                        this.mos.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.moo.dyc().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.moo.a(eVar);
                        if (this.Lp <= 0 && this.mos != null) {
                            this.Lp = this.mos.mo();
                        }
                        eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                        this.moo.a(eVar);
                        a dxZ = a.dxZ();
                        if (dxZ != null) {
                            dxZ.a(this.moo);
                        }
                    } catch (Throwable th) {
                        this.moo.dyc().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.moo.a(eVar);
                        if (this.Lp <= 0 && this.mos != null) {
                            this.Lp = this.mos.mo();
                        }
                        eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                        this.moo.a(eVar);
                        a dxZ2 = a.dxZ();
                        if (dxZ2 != null) {
                            dxZ2.a(this.moo);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.moo.dyc().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.moo.a(eVar);
                    if (this.Lp <= 0 && this.mos != null) {
                        this.Lp = this.mos.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.moo.a(eVar);
                    a dxZ3 = a.dxZ();
                    if (dxZ3 != null) {
                        dxZ3.a(this.moo);
                    }
                } catch (SocketException e3) {
                    this.moo.dyc().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.moo.a(eVar);
                    if (this.Lp <= 0 && this.mos != null) {
                        this.Lp = this.mos.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.moo.a(eVar);
                    a dxZ4 = a.dxZ();
                    if (dxZ4 != null) {
                        dxZ4.a(this.moo);
                    }
                }
                if (this.moo.dyc().responseCode == 200) {
                    if (this.Lp <= 0 && this.mos != null) {
                        this.Lp = this.mos.mo();
                    }
                    eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                    this.moo.a(eVar);
                    a dxZ5 = a.dxZ();
                    if (dxZ5 != null) {
                        dxZ5.a(this.moo);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.moo.dyc().responseCode) + "|retryCount:" + i4;
                z = ap(this.moo.dyc().responseCode);
                this.moo.a(eVar);
                if (this.Lp <= 0 && this.mos != null) {
                    this.Lp = this.mos.mo();
                }
                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.moo.a(eVar);
                a dxZ6 = a.dxZ();
                if (dxZ6 != null) {
                    dxZ6.a(this.moo);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Lp <= 0 && this.mos != null) {
                    this.Lp = this.mos.mo();
                }
                eVar.LK = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.moo.dyb().getUrl(), this.moo.dyb().bJ("Host"), TextUtils.isEmpty(eVar.exception), eVar.LQ != null);
                this.moo.a(eVar);
                a dxZ7 = a.dxZ();
                if (dxZ7 != null) {
                    dxZ7.a(this.moo);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.mos != null) {
            this.mos.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.moo == null) {
            return false;
        }
        return this.moo.dyc().Mo;
    }

    public void setCancel() {
        if (this.moo != null) {
            this.moo.dyc().Mo = true;
        }
    }
}
