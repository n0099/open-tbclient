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
    private g gDb;
    private b gDf;
    private int aje = 0;
    private long aiU = 0;

    public d(g gVar) {
        this.gDb = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int la = i3 <= 0 ? com.baidu.adp.framework.c.b.kW().kZ().la() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.kW().getRetryCount();
        }
        int la2 = i4 <= 0 ? com.baidu.adp.framework.c.b.kW().kX().la() : i4;
        this.gDf = new b(this.gDb);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.aji = i5 + 1;
                this.aje = i5;
                boolean a = this.gDf.a(str, jVar, la, la2, z, eVar, z2);
                com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                this.gDb.a(eVar);
                a bos = a.bos();
                if (bos != null) {
                    bos.a(this.gDb);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.gDb.bov().responseCode = -100;
                    eVar.ajl = String.valueOf(this.gDb.bov().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.gDb.a(eVar);
                    com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                    this.gDb.a(eVar);
                    a bos2 = a.bos();
                    if (bos2 != null) {
                        bos2.a(this.gDb);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                    this.gDb.a(eVar);
                    a bos3 = a.bos();
                    if (bos3 != null) {
                        bos3.a(this.gDb);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.gDb.bov().responseCode = -10;
                eVar.ajl = String.valueOf(this.gDb.bov().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.gDb.a(eVar);
                com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                this.gDb.a(eVar);
                a bos4 = a.bos();
                if (bos4 != null) {
                    bos4.a(this.gDb);
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
        for (int i4 = 0; !this.gDb.bov().ajB && z && i4 < i; i4++) {
            e eVar = new e();
            this.gDb.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.aje = i4;
                                eVar.aji = i4 + 1;
                                eVar.ajs = 1;
                                this.gDf = new b(this.gDb);
                                this.gDf.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.gDb.bov().ajC = -19;
                                eVar.ajl = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.aiU <= 0 && this.gDf != null) {
                                    this.aiU = this.gDf.mO();
                                }
                                eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                                this.gDb.b(eVar);
                                a bos = a.bos();
                                if (bos != null) {
                                    bos.a(this.gDb);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.ajl = String.valueOf(this.gDb.bov().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.gDb.bov().ajC = -10;
                            BdLog.e(e2.getMessage());
                            if (this.aiU <= 0 && this.gDf != null) {
                                this.aiU = this.gDf.mO();
                            }
                            eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                            this.gDb.b(eVar);
                            a bos2 = a.bos();
                            if (bos2 != null) {
                                bos2.a(this.gDb);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.ajl = String.valueOf(this.gDb.bov().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.gDb.bov().ajC = -13;
                        if (this.aiU <= 0 && this.gDf != null) {
                            this.aiU = this.gDf.mO();
                        }
                        eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                        this.gDb.b(eVar);
                        a bos3 = a.bos();
                        if (bos3 != null) {
                            bos3.a(this.gDb);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.ajl = String.valueOf(this.gDb.bov().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.gDb.bov().ajC = -12;
                    if (this.aiU <= 0 && this.gDf != null) {
                        this.aiU = this.gDf.mO();
                    }
                    eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                    this.gDb.b(eVar);
                    a bos4 = a.bos();
                    if (bos4 != null) {
                        bos4.a(this.gDb);
                    }
                    z = true;
                }
                if (this.gDb.bov().responseCode == 200) {
                    this.gDb.b(eVar);
                    if (this.aiU <= 0 && this.gDf != null) {
                        this.aiU = this.gDf.mO();
                    }
                    eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                    this.gDb.b(eVar);
                    a bos5 = a.bos();
                    if (bos5 != null) {
                        bos5.a(this.gDb);
                        return;
                    }
                    return;
                }
                eVar.ajl = String.valueOf(this.gDb.bov().responseCode) + "|retryCount:" + i4;
                boolean da = da(this.gDb.bov().responseCode);
                if (this.aiU <= 0 && this.gDf != null) {
                    this.aiU = this.gDf.mO();
                }
                eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                this.gDb.b(eVar);
                a bos6 = a.bos();
                if (bos6 != null) {
                    bos6.a(this.gDb);
                }
                z = da;
            } catch (Throwable th) {
                if (this.aiU <= 0 && this.gDf != null) {
                    this.aiU = this.gDf.mO();
                }
                eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                this.gDb.b(eVar);
                a bos7 = a.bos();
                if (bos7 != null) {
                    bos7.a(this.gDb);
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
        for (int i4 = 0; !this.gDb.bov().ajB && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.aji = i4 + 1;
            this.aje = i4;
            try {
                try {
                    try {
                        this.gDf = new b(this.gDb);
                        this.gDf.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.gDb.bov().ajC = -14;
                        eVar.ajl = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.gDb.a(eVar);
                        if (this.aiU <= 0 && this.gDf != null) {
                            this.aiU = this.gDf.mO();
                        }
                        eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                        this.gDb.a(eVar);
                        a bos = a.bos();
                        if (bos != null && this.gDf != null && this.gDf.mR()) {
                            bos.a(this.gDb);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.gDb.bov().ajC = -13;
                        z = true;
                        eVar.ajl = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.gDb.a(eVar);
                        if (this.aiU <= 0 && this.gDf != null) {
                            this.aiU = this.gDf.mO();
                        }
                        eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                        this.gDb.a(eVar);
                        a bos2 = a.bos();
                        if (bos2 != null && this.gDf != null && this.gDf.mR()) {
                            bos2.a(this.gDb);
                        }
                    }
                } catch (SocketException e3) {
                    this.gDb.bov().ajC = -12;
                    z = true;
                    eVar.ajl = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gDb.a(eVar);
                    if (this.aiU <= 0 && this.gDf != null) {
                        this.aiU = this.gDf.mO();
                    }
                    eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                    this.gDb.a(eVar);
                    a bos3 = a.bos();
                    if (bos3 != null && this.gDf != null && this.gDf.mR()) {
                        bos3.a(this.gDb);
                    }
                } catch (Throwable th) {
                    this.gDb.bov().ajC = -10;
                    z = false;
                    eVar.ajl = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.gDb.a(eVar);
                    if (this.aiU <= 0 && this.gDf != null) {
                        this.aiU = this.gDf.mO();
                    }
                    eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                    this.gDb.a(eVar);
                    a bos4 = a.bos();
                    if (bos4 != null && this.gDf != null && this.gDf.mR()) {
                        bos4.a(this.gDb);
                    }
                }
                if (this.gDb.bov().responseCode == 200) {
                    if (this.aiU <= 0 && this.gDf != null) {
                        this.aiU = this.gDf.mO();
                    }
                    eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                    this.gDb.a(eVar);
                    a bos5 = a.bos();
                    if (bos5 == null || this.gDf == null || !this.gDf.mR()) {
                        return;
                    }
                    bos5.a(this.gDb);
                    return;
                }
                eVar.ajl = String.valueOf(this.gDb.bov().responseCode) + "|retryCount:" + i4;
                z = da(this.gDb.bov().responseCode);
                this.gDb.a(eVar);
                if (this.aiU <= 0 && this.gDf != null) {
                    this.aiU = this.gDf.mO();
                }
                eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                this.gDb.a(eVar);
                a bos6 = a.bos();
                if (bos6 != null && this.gDf != null && this.gDf.mR()) {
                    bos6.a(this.gDb);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.aiU <= 0 && this.gDf != null) {
                    this.aiU = this.gDf.mO();
                }
                eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                this.gDb.a(eVar);
                a bos7 = a.bos();
                if (bos7 != null && this.gDf != null && this.gDf.mR()) {
                    bos7.a(this.gDb);
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
        if (this.gDb.bou().nf()) {
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
        for (int i4 = 0; !this.gDb.bov().ajB && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.aje = i4;
            eVar.aji = i4 + 1;
            try {
                try {
                    try {
                        this.gDf = new b(this.gDb);
                        this.gDf.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.gDb.bov().ajC = -13;
                        z = true;
                        eVar.ajl = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.gDb.a(eVar);
                        if (this.aiU <= 0 && this.gDf != null) {
                            this.aiU = this.gDf.mO();
                        }
                        eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                        this.gDb.a(eVar);
                        a bos = a.bos();
                        if (bos != null) {
                            bos.a(this.gDb);
                        }
                    } catch (Throwable th) {
                        this.gDb.bov().ajC = -10;
                        z = false;
                        eVar.ajl = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.gDb.a(eVar);
                        if (this.aiU <= 0 && this.gDf != null) {
                            this.aiU = this.gDf.mO();
                        }
                        eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                        this.gDb.a(eVar);
                        a bos2 = a.bos();
                        if (bos2 != null) {
                            bos2.a(this.gDb);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.gDb.bov().ajC = -14;
                    eVar.ajl = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.gDb.a(eVar);
                    if (this.aiU <= 0 && this.gDf != null) {
                        this.aiU = this.gDf.mO();
                    }
                    eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                    this.gDb.a(eVar);
                    a bos3 = a.bos();
                    if (bos3 != null) {
                        bos3.a(this.gDb);
                    }
                } catch (SocketException e3) {
                    this.gDb.bov().ajC = -12;
                    z = true;
                    eVar.ajl = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gDb.a(eVar);
                    if (this.aiU <= 0 && this.gDf != null) {
                        this.aiU = this.gDf.mO();
                    }
                    eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                    this.gDb.a(eVar);
                    a bos4 = a.bos();
                    if (bos4 != null) {
                        bos4.a(this.gDb);
                    }
                }
                if (this.gDb.bov().responseCode == 200) {
                    if (this.aiU <= 0 && this.gDf != null) {
                        this.aiU = this.gDf.mO();
                    }
                    eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                    this.gDb.a(eVar);
                    a bos5 = a.bos();
                    if (bos5 != null) {
                        bos5.a(this.gDb);
                        return;
                    }
                    return;
                }
                eVar.ajl = String.valueOf(this.gDb.bov().responseCode) + "|retryCount:" + i4;
                z = da(this.gDb.bov().responseCode);
                this.gDb.a(eVar);
                if (this.aiU <= 0 && this.gDf != null) {
                    this.aiU = this.gDf.mO();
                }
                eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                this.gDb.a(eVar);
                a bos6 = a.bos();
                if (bos6 != null) {
                    bos6.a(this.gDb);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.aiU <= 0 && this.gDf != null) {
                    this.aiU = this.gDf.mO();
                }
                eVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.gDb.bou().getUrl(), this.gDb.bou().ap("Host"), TextUtils.isEmpty(eVar.ajl), eVar.ajp != null);
                this.gDb.a(eVar);
                a bos7 = a.bos();
                if (bos7 != null) {
                    bos7.a(this.gDb);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.gDf != null) {
            this.gDf.mS();
        }
    }

    public boolean mU() {
        if (this.gDb == null) {
            return false;
        }
        return this.gDb.bov().ajB;
    }

    public void mV() {
        if (this.gDb != null) {
            this.gDb.bov().ajB = true;
        }
    }
}
