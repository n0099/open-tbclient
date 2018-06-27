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
    private g gob;
    private b gof;
    private int zB = 0;
    private long zr = 0;

    public d(g gVar) {
        this.gob = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int fT = i3 <= 0 ? com.baidu.adp.framework.c.b.fP().fS().fT() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fP().getRetryCount();
        }
        int fT2 = i4 <= 0 ? com.baidu.adp.framework.c.b.fP().fQ().fT() : i4;
        this.gof = new b(this.gob);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.zF = i5 + 1;
                this.zB = i5;
                boolean a = this.gof.a(str, jVar, fT, fT2, z, eVar, z2);
                com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                this.gob.a(eVar);
                a boX = a.boX();
                if (boX != null) {
                    boX.a(this.gob);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.gob.bpa().responseCode = -100;
                    eVar.zI = String.valueOf(this.gob.bpa().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.gob.a(eVar);
                    com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                    this.gob.a(eVar);
                    a boX2 = a.boX();
                    if (boX2 != null) {
                        boX2.a(this.gob);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                    this.gob.a(eVar);
                    a boX3 = a.boX();
                    if (boX3 != null) {
                        boX3.a(this.gob);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.gob.bpa().responseCode = -10;
                eVar.zI = String.valueOf(this.gob.bpa().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.gob.a(eVar);
                com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                this.gob.a(eVar);
                a boX4 = a.boX();
                if (boX4 != null) {
                    boX4.a(this.gob);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.fP().fS().fT();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fP().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fP().fQ().fT();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.gob.bpa().zY && z && i4 < i; i4++) {
            e eVar = new e();
            this.gob.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.zB = i4;
                                eVar.zF = i4 + 1;
                                eVar.zP = 1;
                                this.gof = new b(this.gob);
                                this.gof.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.gob.bpa().zZ = -19;
                                eVar.zI = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.zr <= 0 && this.gof != null) {
                                    this.zr = this.gof.hJ();
                                }
                                eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                                this.gob.b(eVar);
                                a boX = a.boX();
                                if (boX != null) {
                                    boX.a(this.gob);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.zI = String.valueOf(this.gob.bpa().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.gob.bpa().zZ = -10;
                            BdLog.e(e2.getMessage());
                            if (this.zr <= 0 && this.gof != null) {
                                this.zr = this.gof.hJ();
                            }
                            eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                            this.gob.b(eVar);
                            a boX2 = a.boX();
                            if (boX2 != null) {
                                boX2.a(this.gob);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.zI = String.valueOf(this.gob.bpa().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.gob.bpa().zZ = -13;
                        if (this.zr <= 0 && this.gof != null) {
                            this.zr = this.gof.hJ();
                        }
                        eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                        this.gob.b(eVar);
                        a boX3 = a.boX();
                        if (boX3 != null) {
                            boX3.a(this.gob);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.zI = String.valueOf(this.gob.bpa().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.gob.bpa().zZ = -12;
                    if (this.zr <= 0 && this.gof != null) {
                        this.zr = this.gof.hJ();
                    }
                    eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                    this.gob.b(eVar);
                    a boX4 = a.boX();
                    if (boX4 != null) {
                        boX4.a(this.gob);
                    }
                    z = true;
                }
                if (this.gob.bpa().responseCode == 200) {
                    this.gob.b(eVar);
                    if (this.zr <= 0 && this.gof != null) {
                        this.zr = this.gof.hJ();
                    }
                    eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                    this.gob.b(eVar);
                    a boX5 = a.boX();
                    if (boX5 != null) {
                        boX5.a(this.gob);
                        return;
                    }
                    return;
                }
                eVar.zI = String.valueOf(this.gob.bpa().responseCode) + "|retryCount:" + i4;
                boolean ab = ab(this.gob.bpa().responseCode);
                if (this.zr <= 0 && this.gof != null) {
                    this.zr = this.gof.hJ();
                }
                eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                this.gob.b(eVar);
                a boX6 = a.boX();
                if (boX6 != null) {
                    boX6.a(this.gob);
                }
                z = ab;
            } catch (Throwable th) {
                if (this.zr <= 0 && this.gof != null) {
                    this.zr = this.gof.hJ();
                }
                eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                this.gob.b(eVar);
                a boX7 = a.boX();
                if (boX7 != null) {
                    boX7.a(this.gob);
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
            i2 = com.baidu.adp.framework.c.b.fP().fS().fT();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fP().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fP().fQ().fT();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.gob.bpa().zY && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.zF = i4 + 1;
            this.zB = i4;
            try {
                try {
                    try {
                        this.gof = new b(this.gob);
                        this.gof.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.gob.bpa().zZ = -14;
                        eVar.zI = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.gob.a(eVar);
                        if (this.zr <= 0 && this.gof != null) {
                            this.zr = this.gof.hJ();
                        }
                        eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                        this.gob.a(eVar);
                        a boX = a.boX();
                        if (boX != null && this.gof != null && this.gof.hM()) {
                            boX.a(this.gob);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.gob.bpa().zZ = -13;
                        z = true;
                        eVar.zI = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.gob.a(eVar);
                        if (this.zr <= 0 && this.gof != null) {
                            this.zr = this.gof.hJ();
                        }
                        eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                        this.gob.a(eVar);
                        a boX2 = a.boX();
                        if (boX2 != null && this.gof != null && this.gof.hM()) {
                            boX2.a(this.gob);
                        }
                    }
                } catch (SocketException e3) {
                    this.gob.bpa().zZ = -12;
                    z = true;
                    eVar.zI = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gob.a(eVar);
                    if (this.zr <= 0 && this.gof != null) {
                        this.zr = this.gof.hJ();
                    }
                    eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                    this.gob.a(eVar);
                    a boX3 = a.boX();
                    if (boX3 != null && this.gof != null && this.gof.hM()) {
                        boX3.a(this.gob);
                    }
                } catch (Throwable th) {
                    this.gob.bpa().zZ = -10;
                    z = false;
                    eVar.zI = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.gob.a(eVar);
                    if (this.zr <= 0 && this.gof != null) {
                        this.zr = this.gof.hJ();
                    }
                    eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                    this.gob.a(eVar);
                    a boX4 = a.boX();
                    if (boX4 != null && this.gof != null && this.gof.hM()) {
                        boX4.a(this.gob);
                    }
                }
                if (this.gob.bpa().responseCode == 200) {
                    if (this.zr <= 0 && this.gof != null) {
                        this.zr = this.gof.hJ();
                    }
                    eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                    this.gob.a(eVar);
                    a boX5 = a.boX();
                    if (boX5 == null || this.gof == null || !this.gof.hM()) {
                        return;
                    }
                    boX5.a(this.gob);
                    return;
                }
                eVar.zI = String.valueOf(this.gob.bpa().responseCode) + "|retryCount:" + i4;
                z = ab(this.gob.bpa().responseCode);
                this.gob.a(eVar);
                if (this.zr <= 0 && this.gof != null) {
                    this.zr = this.gof.hJ();
                }
                eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                this.gob.a(eVar);
                a boX6 = a.boX();
                if (boX6 != null && this.gof != null && this.gof.hM()) {
                    boX6.a(this.gob);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.zr <= 0 && this.gof != null) {
                    this.zr = this.gof.hJ();
                }
                eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                this.gob.a(eVar);
                a boX7 = a.boX();
                if (boX7 != null && this.gof != null && this.gof.hM()) {
                    boX7.a(this.gob);
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
        if (this.gob.boZ().hZ()) {
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
            i2 = com.baidu.adp.framework.c.b.fP().fS().fT();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fP().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fP().fQ().fT();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.gob.bpa().zY && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.zB = i4;
            eVar.zF = i4 + 1;
            try {
                try {
                    try {
                        this.gof = new b(this.gob);
                        this.gof.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.gob.bpa().zZ = -13;
                        z = true;
                        eVar.zI = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.gob.a(eVar);
                        if (this.zr <= 0 && this.gof != null) {
                            this.zr = this.gof.hJ();
                        }
                        eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                        this.gob.a(eVar);
                        a boX = a.boX();
                        if (boX != null) {
                            boX.a(this.gob);
                        }
                    } catch (Throwable th) {
                        this.gob.bpa().zZ = -10;
                        z = false;
                        eVar.zI = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.gob.a(eVar);
                        if (this.zr <= 0 && this.gof != null) {
                            this.zr = this.gof.hJ();
                        }
                        eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                        this.gob.a(eVar);
                        a boX2 = a.boX();
                        if (boX2 != null) {
                            boX2.a(this.gob);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.gob.bpa().zZ = -14;
                    eVar.zI = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.gob.a(eVar);
                    if (this.zr <= 0 && this.gof != null) {
                        this.zr = this.gof.hJ();
                    }
                    eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                    this.gob.a(eVar);
                    a boX3 = a.boX();
                    if (boX3 != null) {
                        boX3.a(this.gob);
                    }
                } catch (SocketException e3) {
                    this.gob.bpa().zZ = -12;
                    z = true;
                    eVar.zI = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gob.a(eVar);
                    if (this.zr <= 0 && this.gof != null) {
                        this.zr = this.gof.hJ();
                    }
                    eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                    this.gob.a(eVar);
                    a boX4 = a.boX();
                    if (boX4 != null) {
                        boX4.a(this.gob);
                    }
                }
                if (this.gob.bpa().responseCode == 200) {
                    if (this.zr <= 0 && this.gof != null) {
                        this.zr = this.gof.hJ();
                    }
                    eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                    this.gob.a(eVar);
                    a boX5 = a.boX();
                    if (boX5 != null) {
                        boX5.a(this.gob);
                        return;
                    }
                    return;
                }
                eVar.zI = String.valueOf(this.gob.bpa().responseCode) + "|retryCount:" + i4;
                z = ab(this.gob.bpa().responseCode);
                this.gob.a(eVar);
                if (this.zr <= 0 && this.gof != null) {
                    this.zr = this.gof.hJ();
                }
                eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                this.gob.a(eVar);
                a boX6 = a.boX();
                if (boX6 != null) {
                    boX6.a(this.gob);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.zr <= 0 && this.gof != null) {
                    this.zr = this.gof.hJ();
                }
                eVar.zG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.gob.boZ().getUrl(), this.gob.boZ().ay("Host"), TextUtils.isEmpty(eVar.zI), eVar.zM != null);
                this.gob.a(eVar);
                a boX7 = a.boX();
                if (boX7 != null) {
                    boX7.a(this.gob);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.gof != null) {
            this.gof.hN();
        }
    }

    public boolean isCancel() {
        if (this.gob == null) {
            return false;
        }
        return this.gob.bpa().zY;
    }

    public void hP() {
        if (this.gob != null) {
            this.gob.bpa().zY = true;
        }
    }
}
