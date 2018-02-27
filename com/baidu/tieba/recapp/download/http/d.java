package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes3.dex */
public class d {
    private g gCM;
    private b gCQ;
    private int aiY = 0;
    private long aiO = 0;

    public d(g gVar) {
        this.gCM = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int la = i3 <= 0 ? com.baidu.adp.framework.c.b.kW().kZ().la() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.kW().getRetryCount();
        }
        int la2 = i4 <= 0 ? com.baidu.adp.framework.c.b.kW().kX().la() : i4;
        this.gCQ = new b(this.gCM);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.ajc = i5 + 1;
                this.aiY = i5;
                boolean a = this.gCQ.a(str, jVar, la, la2, z, eVar, z2);
                com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                this.gCM.a(eVar);
                a bor = a.bor();
                if (bor != null) {
                    bor.a(this.gCM);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.gCM.bou().responseCode = -100;
                    eVar.ajf = String.valueOf(this.gCM.bou().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.gCM.a(eVar);
                    com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                    this.gCM.a(eVar);
                    a bor2 = a.bor();
                    if (bor2 != null) {
                        bor2.a(this.gCM);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                    this.gCM.a(eVar);
                    a bor3 = a.bor();
                    if (bor3 != null) {
                        bor3.a(this.gCM);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.gCM.bou().responseCode = -10;
                eVar.ajf = String.valueOf(this.gCM.bou().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.gCM.a(eVar);
                com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                this.gCM.a(eVar);
                a bor4 = a.bor();
                if (bor4 != null) {
                    bor4.a(this.gCM);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void m(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.kW().kZ().la();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.kW().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.kW().kX().la();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.gCM.bou().ajv && z && i4 < i; i4++) {
            e eVar = new e();
            this.gCM.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.aiY = i4;
                                eVar.ajc = i4 + 1;
                                eVar.ajm = 1;
                                this.gCQ = new b(this.gCM);
                                this.gCQ.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.gCM.bou().ajw = -19;
                                eVar.ajf = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.aiO <= 0 && this.gCQ != null) {
                                    this.aiO = this.gCQ.mO();
                                }
                                eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                                this.gCM.b(eVar);
                                a bor = a.bor();
                                if (bor != null) {
                                    bor.a(this.gCM);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.ajf = String.valueOf(this.gCM.bou().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.gCM.bou().ajw = -10;
                            BdLog.e(e2.getMessage());
                            if (this.aiO <= 0 && this.gCQ != null) {
                                this.aiO = this.gCQ.mO();
                            }
                            eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                            this.gCM.b(eVar);
                            a bor2 = a.bor();
                            if (bor2 != null) {
                                bor2.a(this.gCM);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.ajf = String.valueOf(this.gCM.bou().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.gCM.bou().ajw = -13;
                        if (this.aiO <= 0 && this.gCQ != null) {
                            this.aiO = this.gCQ.mO();
                        }
                        eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                        this.gCM.b(eVar);
                        a bor3 = a.bor();
                        if (bor3 != null) {
                            bor3.a(this.gCM);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.ajf = String.valueOf(this.gCM.bou().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.gCM.bou().ajw = -12;
                    if (this.aiO <= 0 && this.gCQ != null) {
                        this.aiO = this.gCQ.mO();
                    }
                    eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                    this.gCM.b(eVar);
                    a bor4 = a.bor();
                    if (bor4 != null) {
                        bor4.a(this.gCM);
                    }
                    z = true;
                }
                if (this.gCM.bou().responseCode == 200) {
                    this.gCM.b(eVar);
                    if (this.aiO <= 0 && this.gCQ != null) {
                        this.aiO = this.gCQ.mO();
                    }
                    eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                    this.gCM.b(eVar);
                    a bor5 = a.bor();
                    if (bor5 != null) {
                        bor5.a(this.gCM);
                        return;
                    }
                    return;
                }
                eVar.ajf = String.valueOf(this.gCM.bou().responseCode) + "|retryCount:" + i4;
                boolean da = da(this.gCM.bou().responseCode);
                if (this.aiO <= 0 && this.gCQ != null) {
                    this.aiO = this.gCQ.mO();
                }
                eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                this.gCM.b(eVar);
                a bor6 = a.bor();
                if (bor6 != null) {
                    bor6.a(this.gCM);
                }
                z = da;
            } catch (Throwable th) {
                if (this.aiO <= 0 && this.gCQ != null) {
                    this.aiO = this.gCQ.mO();
                }
                eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                this.gCM.b(eVar);
                a bor7 = a.bor();
                if (bor7 != null) {
                    bor7.a(this.gCM);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [346=7, 347=7, 349=7, 350=14, 351=7, 352=7, 353=7, 354=7, 356=5] */
    private void n(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.kW().kZ().la();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.kW().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.kW().kX().la();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.gCM.bou().ajv && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.ajc = i4 + 1;
            this.aiY = i4;
            try {
                try {
                    try {
                        this.gCQ = new b(this.gCM);
                        this.gCQ.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.gCM.bou().ajw = -14;
                        eVar.ajf = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.gCM.a(eVar);
                        if (this.aiO <= 0 && this.gCQ != null) {
                            this.aiO = this.gCQ.mO();
                        }
                        eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                        this.gCM.a(eVar);
                        a bor = a.bor();
                        if (bor != null && this.gCQ != null && this.gCQ.mR()) {
                            bor.a(this.gCM);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.gCM.bou().ajw = -13;
                        z = true;
                        eVar.ajf = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.gCM.a(eVar);
                        if (this.aiO <= 0 && this.gCQ != null) {
                            this.aiO = this.gCQ.mO();
                        }
                        eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                        this.gCM.a(eVar);
                        a bor2 = a.bor();
                        if (bor2 != null && this.gCQ != null && this.gCQ.mR()) {
                            bor2.a(this.gCM);
                        }
                    }
                } catch (SocketException e3) {
                    this.gCM.bou().ajw = -12;
                    z = true;
                    eVar.ajf = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gCM.a(eVar);
                    if (this.aiO <= 0 && this.gCQ != null) {
                        this.aiO = this.gCQ.mO();
                    }
                    eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                    this.gCM.a(eVar);
                    a bor3 = a.bor();
                    if (bor3 != null && this.gCQ != null && this.gCQ.mR()) {
                        bor3.a(this.gCM);
                    }
                } catch (Throwable th) {
                    this.gCM.bou().ajw = -10;
                    z = false;
                    eVar.ajf = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.gCM.a(eVar);
                    if (this.aiO <= 0 && this.gCQ != null) {
                        this.aiO = this.gCQ.mO();
                    }
                    eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                    this.gCM.a(eVar);
                    a bor4 = a.bor();
                    if (bor4 != null && this.gCQ != null && this.gCQ.mR()) {
                        bor4.a(this.gCM);
                    }
                }
                if (this.gCM.bou().responseCode == 200) {
                    if (this.aiO <= 0 && this.gCQ != null) {
                        this.aiO = this.gCQ.mO();
                    }
                    eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                    this.gCM.a(eVar);
                    a bor5 = a.bor();
                    if (bor5 == null || this.gCQ == null || !this.gCQ.mR()) {
                        return;
                    }
                    bor5.a(this.gCM);
                    return;
                }
                eVar.ajf = String.valueOf(this.gCM.bou().responseCode) + "|retryCount:" + i4;
                z = da(this.gCM.bou().responseCode);
                this.gCM.a(eVar);
                if (this.aiO <= 0 && this.gCQ != null) {
                    this.aiO = this.gCQ.mO();
                }
                eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                this.gCM.a(eVar);
                a bor6 = a.bor();
                if (bor6 != null && this.gCQ != null && this.gCQ.mR()) {
                    bor6.a(this.gCM);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.aiO <= 0 && this.gCQ != null) {
                    this.aiO = this.gCQ.mO();
                }
                eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                this.gCM.a(eVar);
                a bor7 = a.bor();
                if (bor7 != null && this.gCQ != null && this.gCQ.mR()) {
                    bor7.a(this.gCM);
                }
                throw th2;
            }
        }
    }

    private boolean da(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void o(int i, int i2, int i3) {
        if (this.gCM.bot().nf()) {
            n(i, i2, i3);
        } else {
            p(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [467=7, 468=7, 470=7, 471=14, 472=7, 473=7, 474=7, 475=7, 477=5] */
    private void p(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.kW().kZ().la();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.kW().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.kW().kX().la();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.gCM.bou().ajv && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.aiY = i4;
            eVar.ajc = i4 + 1;
            try {
                try {
                    try {
                        this.gCQ = new b(this.gCM);
                        this.gCQ.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.gCM.bou().ajw = -13;
                        z = true;
                        eVar.ajf = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.gCM.a(eVar);
                        if (this.aiO <= 0 && this.gCQ != null) {
                            this.aiO = this.gCQ.mO();
                        }
                        eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                        this.gCM.a(eVar);
                        a bor = a.bor();
                        if (bor != null) {
                            bor.a(this.gCM);
                        }
                    } catch (Throwable th) {
                        this.gCM.bou().ajw = -10;
                        z = false;
                        eVar.ajf = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.gCM.a(eVar);
                        if (this.aiO <= 0 && this.gCQ != null) {
                            this.aiO = this.gCQ.mO();
                        }
                        eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                        this.gCM.a(eVar);
                        a bor2 = a.bor();
                        if (bor2 != null) {
                            bor2.a(this.gCM);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.gCM.bou().ajw = -14;
                    eVar.ajf = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.gCM.a(eVar);
                    if (this.aiO <= 0 && this.gCQ != null) {
                        this.aiO = this.gCQ.mO();
                    }
                    eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                    this.gCM.a(eVar);
                    a bor3 = a.bor();
                    if (bor3 != null) {
                        bor3.a(this.gCM);
                    }
                } catch (SocketException e3) {
                    this.gCM.bou().ajw = -12;
                    z = true;
                    eVar.ajf = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gCM.a(eVar);
                    if (this.aiO <= 0 && this.gCQ != null) {
                        this.aiO = this.gCQ.mO();
                    }
                    eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                    this.gCM.a(eVar);
                    a bor4 = a.bor();
                    if (bor4 != null) {
                        bor4.a(this.gCM);
                    }
                }
                if (this.gCM.bou().responseCode == 200) {
                    if (this.aiO <= 0 && this.gCQ != null) {
                        this.aiO = this.gCQ.mO();
                    }
                    eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                    this.gCM.a(eVar);
                    a bor5 = a.bor();
                    if (bor5 != null) {
                        bor5.a(this.gCM);
                        return;
                    }
                    return;
                }
                eVar.ajf = String.valueOf(this.gCM.bou().responseCode) + "|retryCount:" + i4;
                z = da(this.gCM.bou().responseCode);
                this.gCM.a(eVar);
                if (this.aiO <= 0 && this.gCQ != null) {
                    this.aiO = this.gCQ.mO();
                }
                eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                this.gCM.a(eVar);
                a bor6 = a.bor();
                if (bor6 != null) {
                    bor6.a(this.gCM);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.aiO <= 0 && this.gCQ != null) {
                    this.aiO = this.gCQ.mO();
                }
                eVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.gCM.bot().getUrl(), this.gCM.bot().ap("Host"), TextUtils.isEmpty(eVar.ajf), eVar.ajj != null);
                this.gCM.a(eVar);
                a bor7 = a.bor();
                if (bor7 != null) {
                    bor7.a(this.gCM);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.gCQ != null) {
            this.gCQ.mS();
        }
    }

    public boolean mU() {
        if (this.gCM == null) {
            return false;
        }
        return this.gCM.bou().ajv;
    }

    public void mV() {
        if (this.gCM != null) {
            this.gCM.bou().ajv = true;
        }
    }
}
