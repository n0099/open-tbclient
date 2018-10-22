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
    private int CA = 0;
    private long Cq = 0;
    private g gEh;
    private b gEl;

    public d(g gVar) {
        this.gEh = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int hs = i3 <= 0 ? com.baidu.adp.framework.c.b.ho().hr().hs() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ho().getRetryCount();
        }
        int hs2 = i4 <= 0 ? com.baidu.adp.framework.c.b.ho().hp().hs() : i4;
        this.gEl = new b(this.gEh);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.CE = i5 + 1;
                this.CA = i5;
                boolean a = this.gEl.a(str, jVar, hs, hs2, z, eVar, z2);
                com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                this.gEh.a(eVar);
                a bty = a.bty();
                if (bty != null) {
                    bty.a(this.gEh);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.gEh.btB().responseCode = -100;
                    eVar.CH = String.valueOf(this.gEh.btB().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.gEh.a(eVar);
                    com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                    this.gEh.a(eVar);
                    a bty2 = a.bty();
                    if (bty2 != null) {
                        bty2.a(this.gEh);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                    this.gEh.a(eVar);
                    a bty3 = a.bty();
                    if (bty3 != null) {
                        bty3.a(this.gEh);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.gEh.btB().responseCode = -10;
                eVar.CH = String.valueOf(this.gEh.btB().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.gEh.a(eVar);
                com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                this.gEh.a(eVar);
                a bty4 = a.bty();
                if (bty4 != null) {
                    bty4.a(this.gEh);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void e(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.ho().hr().hs();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ho().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ho().hp().hs();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.gEh.btB().CZ && z && i4 < i; i4++) {
            e eVar = new e();
            this.gEh.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.CA = i4;
                                eVar.CE = i4 + 1;
                                eVar.CO = 1;
                                this.gEl = new b(this.gEh);
                                this.gEl.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.gEh.btB().Da = -19;
                                eVar.CH = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Cq <= 0 && this.gEl != null) {
                                    this.Cq = this.gEl.je();
                                }
                                eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                                this.gEh.b(eVar);
                                a bty = a.bty();
                                if (bty != null) {
                                    bty.a(this.gEh);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.CH = String.valueOf(this.gEh.btB().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.gEh.btB().Da = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Cq <= 0 && this.gEl != null) {
                                this.Cq = this.gEl.je();
                            }
                            eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                            this.gEh.b(eVar);
                            a bty2 = a.bty();
                            if (bty2 != null) {
                                bty2.a(this.gEh);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.CH = String.valueOf(this.gEh.btB().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.gEh.btB().Da = -13;
                        if (this.Cq <= 0 && this.gEl != null) {
                            this.Cq = this.gEl.je();
                        }
                        eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                        this.gEh.b(eVar);
                        a bty3 = a.bty();
                        if (bty3 != null) {
                            bty3.a(this.gEh);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.CH = String.valueOf(this.gEh.btB().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.gEh.btB().Da = -12;
                    if (this.Cq <= 0 && this.gEl != null) {
                        this.Cq = this.gEl.je();
                    }
                    eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                    this.gEh.b(eVar);
                    a bty4 = a.bty();
                    if (bty4 != null) {
                        bty4.a(this.gEh);
                    }
                    z = true;
                }
                if (this.gEh.btB().responseCode == 200) {
                    this.gEh.b(eVar);
                    if (this.Cq <= 0 && this.gEl != null) {
                        this.Cq = this.gEl.je();
                    }
                    eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                    this.gEh.b(eVar);
                    a bty5 = a.bty();
                    if (bty5 != null) {
                        bty5.a(this.gEh);
                        return;
                    }
                    return;
                }
                eVar.CH = String.valueOf(this.gEh.btB().responseCode) + "|retryCount:" + i4;
                boolean aj = aj(this.gEh.btB().responseCode);
                if (this.Cq <= 0 && this.gEl != null) {
                    this.Cq = this.gEl.je();
                }
                eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                this.gEh.b(eVar);
                a bty6 = a.bty();
                if (bty6 != null) {
                    bty6.a(this.gEh);
                }
                z = aj;
            } catch (Throwable th) {
                if (this.Cq <= 0 && this.gEl != null) {
                    this.Cq = this.gEl.je();
                }
                eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                this.gEh.b(eVar);
                a bty7 = a.bty();
                if (bty7 != null) {
                    bty7.a(this.gEh);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [346=7, 347=7, 349=7, 350=14, 351=7, 352=7, 353=7, 354=7, 356=5] */
    private void f(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.ho().hr().hs();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ho().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ho().hp().hs();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.gEh.btB().CZ && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.CE = i4 + 1;
            this.CA = i4;
            try {
                try {
                    try {
                        this.gEl = new b(this.gEh);
                        this.gEl.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.gEh.btB().Da = -14;
                        eVar.CH = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.gEh.a(eVar);
                        if (this.Cq <= 0 && this.gEl != null) {
                            this.Cq = this.gEl.je();
                        }
                        eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                        this.gEh.a(eVar);
                        a bty = a.bty();
                        if (bty != null && this.gEl != null && this.gEl.jh()) {
                            bty.a(this.gEh);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.gEh.btB().Da = -13;
                        z = true;
                        eVar.CH = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.gEh.a(eVar);
                        if (this.Cq <= 0 && this.gEl != null) {
                            this.Cq = this.gEl.je();
                        }
                        eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                        this.gEh.a(eVar);
                        a bty2 = a.bty();
                        if (bty2 != null && this.gEl != null && this.gEl.jh()) {
                            bty2.a(this.gEh);
                        }
                    }
                } catch (SocketException e3) {
                    this.gEh.btB().Da = -12;
                    z = true;
                    eVar.CH = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gEh.a(eVar);
                    if (this.Cq <= 0 && this.gEl != null) {
                        this.Cq = this.gEl.je();
                    }
                    eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                    this.gEh.a(eVar);
                    a bty3 = a.bty();
                    if (bty3 != null && this.gEl != null && this.gEl.jh()) {
                        bty3.a(this.gEh);
                    }
                } catch (Throwable th) {
                    this.gEh.btB().Da = -10;
                    z = false;
                    eVar.CH = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.gEh.a(eVar);
                    if (this.Cq <= 0 && this.gEl != null) {
                        this.Cq = this.gEl.je();
                    }
                    eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                    this.gEh.a(eVar);
                    a bty4 = a.bty();
                    if (bty4 != null && this.gEl != null && this.gEl.jh()) {
                        bty4.a(this.gEh);
                    }
                }
                if (this.gEh.btB().responseCode == 200) {
                    if (this.Cq <= 0 && this.gEl != null) {
                        this.Cq = this.gEl.je();
                    }
                    eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                    this.gEh.a(eVar);
                    a bty5 = a.bty();
                    if (bty5 == null || this.gEl == null || !this.gEl.jh()) {
                        return;
                    }
                    bty5.a(this.gEh);
                    return;
                }
                eVar.CH = String.valueOf(this.gEh.btB().responseCode) + "|retryCount:" + i4;
                z = aj(this.gEh.btB().responseCode);
                this.gEh.a(eVar);
                if (this.Cq <= 0 && this.gEl != null) {
                    this.Cq = this.gEl.je();
                }
                eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                this.gEh.a(eVar);
                a bty6 = a.bty();
                if (bty6 != null && this.gEl != null && this.gEl.jh()) {
                    bty6.a(this.gEh);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Cq <= 0 && this.gEl != null) {
                    this.Cq = this.gEl.je();
                }
                eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                this.gEh.a(eVar);
                a bty7 = a.bty();
                if (bty7 != null && this.gEl != null && this.gEl.jh()) {
                    bty7.a(this.gEh);
                }
                throw th2;
            }
        }
    }

    private boolean aj(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void g(int i, int i2, int i3) {
        if (this.gEh.btA().jv()) {
            f(i, i2, i3);
        } else {
            h(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [467=7, 468=7, 470=7, 471=14, 472=7, 473=7, 474=7, 475=7, 477=5] */
    private void h(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.ho().hr().hs();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ho().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ho().hp().hs();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.gEh.btB().CZ && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.CA = i4;
            eVar.CE = i4 + 1;
            try {
                try {
                    try {
                        this.gEl = new b(this.gEh);
                        this.gEl.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.gEh.btB().Da = -13;
                        z = true;
                        eVar.CH = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.gEh.a(eVar);
                        if (this.Cq <= 0 && this.gEl != null) {
                            this.Cq = this.gEl.je();
                        }
                        eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                        this.gEh.a(eVar);
                        a bty = a.bty();
                        if (bty != null) {
                            bty.a(this.gEh);
                        }
                    } catch (Throwable th) {
                        this.gEh.btB().Da = -10;
                        z = false;
                        eVar.CH = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.gEh.a(eVar);
                        if (this.Cq <= 0 && this.gEl != null) {
                            this.Cq = this.gEl.je();
                        }
                        eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                        this.gEh.a(eVar);
                        a bty2 = a.bty();
                        if (bty2 != null) {
                            bty2.a(this.gEh);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.gEh.btB().Da = -14;
                    eVar.CH = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.gEh.a(eVar);
                    if (this.Cq <= 0 && this.gEl != null) {
                        this.Cq = this.gEl.je();
                    }
                    eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                    this.gEh.a(eVar);
                    a bty3 = a.bty();
                    if (bty3 != null) {
                        bty3.a(this.gEh);
                    }
                } catch (SocketException e3) {
                    this.gEh.btB().Da = -12;
                    z = true;
                    eVar.CH = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gEh.a(eVar);
                    if (this.Cq <= 0 && this.gEl != null) {
                        this.Cq = this.gEl.je();
                    }
                    eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                    this.gEh.a(eVar);
                    a bty4 = a.bty();
                    if (bty4 != null) {
                        bty4.a(this.gEh);
                    }
                }
                if (this.gEh.btB().responseCode == 200) {
                    if (this.Cq <= 0 && this.gEl != null) {
                        this.Cq = this.gEl.je();
                    }
                    eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                    this.gEh.a(eVar);
                    a bty5 = a.bty();
                    if (bty5 != null) {
                        bty5.a(this.gEh);
                        return;
                    }
                    return;
                }
                eVar.CH = String.valueOf(this.gEh.btB().responseCode) + "|retryCount:" + i4;
                z = aj(this.gEh.btB().responseCode);
                this.gEh.a(eVar);
                if (this.Cq <= 0 && this.gEl != null) {
                    this.Cq = this.gEl.je();
                }
                eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                this.gEh.a(eVar);
                a bty6 = a.bty();
                if (bty6 != null) {
                    bty6.a(this.gEh);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Cq <= 0 && this.gEl != null) {
                    this.Cq = this.gEl.je();
                }
                eVar.CF = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iG().a(this.gEh.btA().getUrl(), this.gEh.btA().aQ("Host"), TextUtils.isEmpty(eVar.CH), eVar.CL != null);
                this.gEh.a(eVar);
                a bty7 = a.bty();
                if (bty7 != null) {
                    bty7.a(this.gEh);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.gEl != null) {
            this.gEl.ji();
        }
    }

    public boolean jk() {
        if (this.gEh == null) {
            return false;
        }
        return this.gEh.btB().CZ;
    }

    public void jl() {
        if (this.gEh != null) {
            this.gEh.btB().CZ = true;
        }
    }
}
