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
    private g gkk;
    private b gko;
    private int zD = 0;
    private long zt = 0;

    public d(g gVar) {
        this.gkk = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int fT = i3 <= 0 ? com.baidu.adp.framework.c.b.fP().fS().fT() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fP().getRetryCount();
        }
        int fT2 = i4 <= 0 ? com.baidu.adp.framework.c.b.fP().fQ().fT() : i4;
        this.gko = new b(this.gkk);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.zH = i5 + 1;
                this.zD = i5;
                boolean a = this.gko.a(str, jVar, fT, fT2, z, eVar, z2);
                com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                this.gkk.a(eVar);
                a bow = a.bow();
                if (bow != null) {
                    bow.a(this.gkk);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.gkk.boz().responseCode = -100;
                    eVar.zK = String.valueOf(this.gkk.boz().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.gkk.a(eVar);
                    com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                    this.gkk.a(eVar);
                    a bow2 = a.bow();
                    if (bow2 != null) {
                        bow2.a(this.gkk);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                    this.gkk.a(eVar);
                    a bow3 = a.bow();
                    if (bow3 != null) {
                        bow3.a(this.gkk);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.gkk.boz().responseCode = -10;
                eVar.zK = String.valueOf(this.gkk.boz().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.gkk.a(eVar);
                com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                this.gkk.a(eVar);
                a bow4 = a.bow();
                if (bow4 != null) {
                    bow4.a(this.gkk);
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
        for (int i4 = 0; !this.gkk.boz().Aa && z && i4 < i; i4++) {
            e eVar = new e();
            this.gkk.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.zD = i4;
                                eVar.zH = i4 + 1;
                                eVar.zR = 1;
                                this.gko = new b(this.gkk);
                                this.gko.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.gkk.boz().Ab = -19;
                                eVar.zK = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.zt <= 0 && this.gko != null) {
                                    this.zt = this.gko.hJ();
                                }
                                eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                                this.gkk.b(eVar);
                                a bow = a.bow();
                                if (bow != null) {
                                    bow.a(this.gkk);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.zK = String.valueOf(this.gkk.boz().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.gkk.boz().Ab = -10;
                            BdLog.e(e2.getMessage());
                            if (this.zt <= 0 && this.gko != null) {
                                this.zt = this.gko.hJ();
                            }
                            eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                            this.gkk.b(eVar);
                            a bow2 = a.bow();
                            if (bow2 != null) {
                                bow2.a(this.gkk);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.zK = String.valueOf(this.gkk.boz().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.gkk.boz().Ab = -13;
                        if (this.zt <= 0 && this.gko != null) {
                            this.zt = this.gko.hJ();
                        }
                        eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                        this.gkk.b(eVar);
                        a bow3 = a.bow();
                        if (bow3 != null) {
                            bow3.a(this.gkk);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.zK = String.valueOf(this.gkk.boz().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.gkk.boz().Ab = -12;
                    if (this.zt <= 0 && this.gko != null) {
                        this.zt = this.gko.hJ();
                    }
                    eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                    this.gkk.b(eVar);
                    a bow4 = a.bow();
                    if (bow4 != null) {
                        bow4.a(this.gkk);
                    }
                    z = true;
                }
                if (this.gkk.boz().responseCode == 200) {
                    this.gkk.b(eVar);
                    if (this.zt <= 0 && this.gko != null) {
                        this.zt = this.gko.hJ();
                    }
                    eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                    this.gkk.b(eVar);
                    a bow5 = a.bow();
                    if (bow5 != null) {
                        bow5.a(this.gkk);
                        return;
                    }
                    return;
                }
                eVar.zK = String.valueOf(this.gkk.boz().responseCode) + "|retryCount:" + i4;
                boolean ab = ab(this.gkk.boz().responseCode);
                if (this.zt <= 0 && this.gko != null) {
                    this.zt = this.gko.hJ();
                }
                eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                this.gkk.b(eVar);
                a bow6 = a.bow();
                if (bow6 != null) {
                    bow6.a(this.gkk);
                }
                z = ab;
            } catch (Throwable th) {
                if (this.zt <= 0 && this.gko != null) {
                    this.zt = this.gko.hJ();
                }
                eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                this.gkk.b(eVar);
                a bow7 = a.bow();
                if (bow7 != null) {
                    bow7.a(this.gkk);
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
        for (int i4 = 0; !this.gkk.boz().Aa && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.zH = i4 + 1;
            this.zD = i4;
            try {
                try {
                    try {
                        this.gko = new b(this.gkk);
                        this.gko.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.gkk.boz().Ab = -14;
                        eVar.zK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.gkk.a(eVar);
                        if (this.zt <= 0 && this.gko != null) {
                            this.zt = this.gko.hJ();
                        }
                        eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                        this.gkk.a(eVar);
                        a bow = a.bow();
                        if (bow != null && this.gko != null && this.gko.hM()) {
                            bow.a(this.gkk);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.gkk.boz().Ab = -13;
                        z = true;
                        eVar.zK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.gkk.a(eVar);
                        if (this.zt <= 0 && this.gko != null) {
                            this.zt = this.gko.hJ();
                        }
                        eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                        this.gkk.a(eVar);
                        a bow2 = a.bow();
                        if (bow2 != null && this.gko != null && this.gko.hM()) {
                            bow2.a(this.gkk);
                        }
                    }
                } catch (SocketException e3) {
                    this.gkk.boz().Ab = -12;
                    z = true;
                    eVar.zK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gkk.a(eVar);
                    if (this.zt <= 0 && this.gko != null) {
                        this.zt = this.gko.hJ();
                    }
                    eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                    this.gkk.a(eVar);
                    a bow3 = a.bow();
                    if (bow3 != null && this.gko != null && this.gko.hM()) {
                        bow3.a(this.gkk);
                    }
                } catch (Throwable th) {
                    this.gkk.boz().Ab = -10;
                    z = false;
                    eVar.zK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.gkk.a(eVar);
                    if (this.zt <= 0 && this.gko != null) {
                        this.zt = this.gko.hJ();
                    }
                    eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                    this.gkk.a(eVar);
                    a bow4 = a.bow();
                    if (bow4 != null && this.gko != null && this.gko.hM()) {
                        bow4.a(this.gkk);
                    }
                }
                if (this.gkk.boz().responseCode == 200) {
                    if (this.zt <= 0 && this.gko != null) {
                        this.zt = this.gko.hJ();
                    }
                    eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                    this.gkk.a(eVar);
                    a bow5 = a.bow();
                    if (bow5 == null || this.gko == null || !this.gko.hM()) {
                        return;
                    }
                    bow5.a(this.gkk);
                    return;
                }
                eVar.zK = String.valueOf(this.gkk.boz().responseCode) + "|retryCount:" + i4;
                z = ab(this.gkk.boz().responseCode);
                this.gkk.a(eVar);
                if (this.zt <= 0 && this.gko != null) {
                    this.zt = this.gko.hJ();
                }
                eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                this.gkk.a(eVar);
                a bow6 = a.bow();
                if (bow6 != null && this.gko != null && this.gko.hM()) {
                    bow6.a(this.gkk);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.zt <= 0 && this.gko != null) {
                    this.zt = this.gko.hJ();
                }
                eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                this.gkk.a(eVar);
                a bow7 = a.bow();
                if (bow7 != null && this.gko != null && this.gko.hM()) {
                    bow7.a(this.gkk);
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
        if (this.gkk.boy().hZ()) {
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
        for (int i4 = 0; !this.gkk.boz().Aa && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.zD = i4;
            eVar.zH = i4 + 1;
            try {
                try {
                    try {
                        this.gko = new b(this.gkk);
                        this.gko.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.gkk.boz().Ab = -13;
                        z = true;
                        eVar.zK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.gkk.a(eVar);
                        if (this.zt <= 0 && this.gko != null) {
                            this.zt = this.gko.hJ();
                        }
                        eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                        this.gkk.a(eVar);
                        a bow = a.bow();
                        if (bow != null) {
                            bow.a(this.gkk);
                        }
                    } catch (Throwable th) {
                        this.gkk.boz().Ab = -10;
                        z = false;
                        eVar.zK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.gkk.a(eVar);
                        if (this.zt <= 0 && this.gko != null) {
                            this.zt = this.gko.hJ();
                        }
                        eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                        this.gkk.a(eVar);
                        a bow2 = a.bow();
                        if (bow2 != null) {
                            bow2.a(this.gkk);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.gkk.boz().Ab = -14;
                    eVar.zK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.gkk.a(eVar);
                    if (this.zt <= 0 && this.gko != null) {
                        this.zt = this.gko.hJ();
                    }
                    eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                    this.gkk.a(eVar);
                    a bow3 = a.bow();
                    if (bow3 != null) {
                        bow3.a(this.gkk);
                    }
                } catch (SocketException e3) {
                    this.gkk.boz().Ab = -12;
                    z = true;
                    eVar.zK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gkk.a(eVar);
                    if (this.zt <= 0 && this.gko != null) {
                        this.zt = this.gko.hJ();
                    }
                    eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                    this.gkk.a(eVar);
                    a bow4 = a.bow();
                    if (bow4 != null) {
                        bow4.a(this.gkk);
                    }
                }
                if (this.gkk.boz().responseCode == 200) {
                    if (this.zt <= 0 && this.gko != null) {
                        this.zt = this.gko.hJ();
                    }
                    eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                    this.gkk.a(eVar);
                    a bow5 = a.bow();
                    if (bow5 != null) {
                        bow5.a(this.gkk);
                        return;
                    }
                    return;
                }
                eVar.zK = String.valueOf(this.gkk.boz().responseCode) + "|retryCount:" + i4;
                z = ab(this.gkk.boz().responseCode);
                this.gkk.a(eVar);
                if (this.zt <= 0 && this.gko != null) {
                    this.zt = this.gko.hJ();
                }
                eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                this.gkk.a(eVar);
                a bow6 = a.bow();
                if (bow6 != null) {
                    bow6.a(this.gkk);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.zt <= 0 && this.gko != null) {
                    this.zt = this.gko.hJ();
                }
                eVar.zI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.gkk.boy().getUrl(), this.gkk.boy().ay("Host"), TextUtils.isEmpty(eVar.zK), eVar.zO != null);
                this.gkk.a(eVar);
                a bow7 = a.bow();
                if (bow7 != null) {
                    bow7.a(this.gkk);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.gko != null) {
            this.gko.hN();
        }
    }

    public boolean isCancel() {
        if (this.gkk == null) {
            return false;
        }
        return this.gkk.boz().Aa;
    }

    public void hP() {
        if (this.gkk != null) {
            this.gkk.boz().Aa = true;
        }
    }
}
