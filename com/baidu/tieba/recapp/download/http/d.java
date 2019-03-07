package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class d {
    private int CD = 0;
    private long Ct = 0;
    private g ihY;
    private b iic;

    public d(g gVar) {
        this.ihY = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int ho = i3 <= 0 ? com.baidu.adp.framework.c.b.hk().hn().ho() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.hk().getRetryCount();
        }
        int ho2 = i4 <= 0 ? com.baidu.adp.framework.c.b.hk().hl().ho() : i4;
        this.iic = new b(this.ihY);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.CH = i5 + 1;
                this.CD = i5;
                boolean a = this.iic.a(str, jVar, ho, ho2, z, eVar, z2);
                com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihY.a(eVar);
                a bWU = a.bWU();
                if (bWU != null) {
                    bWU.a(this.ihY);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.ihY.bWX().responseCode = -100;
                    eVar.CK = String.valueOf(this.ihY.bWX().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.ihY.a(eVar);
                    com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihY.a(eVar);
                    a bWU2 = a.bWU();
                    if (bWU2 != null) {
                        bWU2.a(this.ihY);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihY.a(eVar);
                    a bWU3 = a.bWU();
                    if (bWU3 != null) {
                        bWU3.a(this.ihY);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.ihY.bWX().responseCode = -10;
                eVar.CK = String.valueOf(this.ihY.bWX().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.ihY.a(eVar);
                com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihY.a(eVar);
                a bWU4 = a.bWU();
                if (bWU4 != null) {
                    bWU4.a(this.ihY);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void e(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.hk().hn().ho();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.hk().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.hk().hl().ho();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.ihY.bWX().Dc && z && i4 < i; i4++) {
            e eVar = new e();
            this.ihY.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.CD = i4;
                                eVar.CH = i4 + 1;
                                eVar.CT = 1;
                                this.iic = new b(this.ihY);
                                this.iic.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.ihY.bWX().Dd = -19;
                                eVar.CK = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Ct <= 0 && this.iic != null) {
                                    this.Ct = this.iic.je();
                                }
                                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                                this.ihY.b(eVar);
                                a bWU = a.bWU();
                                if (bWU != null) {
                                    bWU.a(this.ihY);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.CK = String.valueOf(this.ihY.bWX().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.ihY.bWX().Dd = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Ct <= 0 && this.iic != null) {
                                this.Ct = this.iic.je();
                            }
                            eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                            this.ihY.b(eVar);
                            a bWU2 = a.bWU();
                            if (bWU2 != null) {
                                bWU2.a(this.ihY);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.CK = String.valueOf(this.ihY.bWX().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.ihY.bWX().Dd = -13;
                        if (this.Ct <= 0 && this.iic != null) {
                            this.Ct = this.iic.je();
                        }
                        eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                        this.ihY.b(eVar);
                        a bWU3 = a.bWU();
                        if (bWU3 != null) {
                            bWU3.a(this.ihY);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.CK = String.valueOf(this.ihY.bWX().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.ihY.bWX().Dd = -12;
                    if (this.Ct <= 0 && this.iic != null) {
                        this.Ct = this.iic.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihY.b(eVar);
                    a bWU4 = a.bWU();
                    if (bWU4 != null) {
                        bWU4.a(this.ihY);
                    }
                    z = true;
                }
                if (this.ihY.bWX().responseCode == 200) {
                    this.ihY.b(eVar);
                    if (this.Ct <= 0 && this.iic != null) {
                        this.Ct = this.iic.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihY.b(eVar);
                    a bWU5 = a.bWU();
                    if (bWU5 != null) {
                        bWU5.a(this.ihY);
                        return;
                    }
                    return;
                }
                eVar.CK = String.valueOf(this.ihY.bWX().responseCode) + "|retryCount:" + i4;
                boolean aj = aj(this.ihY.bWX().responseCode);
                if (this.Ct <= 0 && this.iic != null) {
                    this.Ct = this.iic.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihY.b(eVar);
                a bWU6 = a.bWU();
                if (bWU6 != null) {
                    bWU6.a(this.ihY);
                }
                z = aj;
            } catch (Throwable th) {
                if (this.Ct <= 0 && this.iic != null) {
                    this.Ct = this.iic.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihY.b(eVar);
                a bWU7 = a.bWU();
                if (bWU7 != null) {
                    bWU7.a(this.ihY);
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
            i2 = com.baidu.adp.framework.c.b.hk().hn().ho();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.hk().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.hk().hl().ho();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.ihY.bWX().Dc && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.CH = i4 + 1;
            this.CD = i4;
            try {
                try {
                    try {
                        this.iic = new b(this.ihY);
                        this.iic.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.ihY.bWX().Dd = -14;
                        eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.ihY.a(eVar);
                        if (this.Ct <= 0 && this.iic != null) {
                            this.Ct = this.iic.je();
                        }
                        eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                        this.ihY.a(eVar);
                        a bWU = a.bWU();
                        if (bWU != null && this.iic != null && this.iic.jh()) {
                            bWU.a(this.ihY);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.ihY.bWX().Dd = -13;
                        z = true;
                        eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.ihY.a(eVar);
                        if (this.Ct <= 0 && this.iic != null) {
                            this.Ct = this.iic.je();
                        }
                        eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                        this.ihY.a(eVar);
                        a bWU2 = a.bWU();
                        if (bWU2 != null && this.iic != null && this.iic.jh()) {
                            bWU2.a(this.ihY);
                        }
                    }
                } catch (SocketException e3) {
                    this.ihY.bWX().Dd = -12;
                    z = true;
                    eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.ihY.a(eVar);
                    if (this.Ct <= 0 && this.iic != null) {
                        this.Ct = this.iic.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihY.a(eVar);
                    a bWU3 = a.bWU();
                    if (bWU3 != null && this.iic != null && this.iic.jh()) {
                        bWU3.a(this.ihY);
                    }
                } catch (Throwable th) {
                    this.ihY.bWX().Dd = -10;
                    z = false;
                    eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.ihY.a(eVar);
                    if (this.Ct <= 0 && this.iic != null) {
                        this.Ct = this.iic.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihY.a(eVar);
                    a bWU4 = a.bWU();
                    if (bWU4 != null && this.iic != null && this.iic.jh()) {
                        bWU4.a(this.ihY);
                    }
                }
                if (this.ihY.bWX().responseCode == 200) {
                    if (this.Ct <= 0 && this.iic != null) {
                        this.Ct = this.iic.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihY.a(eVar);
                    a bWU5 = a.bWU();
                    if (bWU5 == null || this.iic == null || !this.iic.jh()) {
                        return;
                    }
                    bWU5.a(this.ihY);
                    return;
                }
                eVar.CK = String.valueOf(this.ihY.bWX().responseCode) + "|retryCount:" + i4;
                z = aj(this.ihY.bWX().responseCode);
                this.ihY.a(eVar);
                if (this.Ct <= 0 && this.iic != null) {
                    this.Ct = this.iic.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihY.a(eVar);
                a bWU6 = a.bWU();
                if (bWU6 != null && this.iic != null && this.iic.jh()) {
                    bWU6.a(this.ihY);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ct <= 0 && this.iic != null) {
                    this.Ct = this.iic.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihY.a(eVar);
                a bWU7 = a.bWU();
                if (bWU7 != null && this.iic != null && this.iic.jh()) {
                    bWU7.a(this.ihY);
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
        if (this.ihY.bWW().jv()) {
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
            i2 = com.baidu.adp.framework.c.b.hk().hn().ho();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.hk().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.hk().hl().ho();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.ihY.bWX().Dc && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.CD = i4;
            eVar.CH = i4 + 1;
            try {
                try {
                    try {
                        this.iic = new b(this.ihY);
                        this.iic.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.ihY.bWX().Dd = -13;
                        z = true;
                        eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.ihY.a(eVar);
                        if (this.Ct <= 0 && this.iic != null) {
                            this.Ct = this.iic.je();
                        }
                        eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                        this.ihY.a(eVar);
                        a bWU = a.bWU();
                        if (bWU != null) {
                            bWU.a(this.ihY);
                        }
                    } catch (Throwable th) {
                        this.ihY.bWX().Dd = -10;
                        z = false;
                        eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.ihY.a(eVar);
                        if (this.Ct <= 0 && this.iic != null) {
                            this.Ct = this.iic.je();
                        }
                        eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                        this.ihY.a(eVar);
                        a bWU2 = a.bWU();
                        if (bWU2 != null) {
                            bWU2.a(this.ihY);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.ihY.bWX().Dd = -14;
                    eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.ihY.a(eVar);
                    if (this.Ct <= 0 && this.iic != null) {
                        this.Ct = this.iic.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihY.a(eVar);
                    a bWU3 = a.bWU();
                    if (bWU3 != null) {
                        bWU3.a(this.ihY);
                    }
                } catch (SocketException e3) {
                    this.ihY.bWX().Dd = -12;
                    z = true;
                    eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.ihY.a(eVar);
                    if (this.Ct <= 0 && this.iic != null) {
                        this.Ct = this.iic.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihY.a(eVar);
                    a bWU4 = a.bWU();
                    if (bWU4 != null) {
                        bWU4.a(this.ihY);
                    }
                }
                if (this.ihY.bWX().responseCode == 200) {
                    if (this.Ct <= 0 && this.iic != null) {
                        this.Ct = this.iic.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihY.a(eVar);
                    a bWU5 = a.bWU();
                    if (bWU5 != null) {
                        bWU5.a(this.ihY);
                        return;
                    }
                    return;
                }
                eVar.CK = String.valueOf(this.ihY.bWX().responseCode) + "|retryCount:" + i4;
                z = aj(this.ihY.bWX().responseCode);
                this.ihY.a(eVar);
                if (this.Ct <= 0 && this.iic != null) {
                    this.Ct = this.iic.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihY.a(eVar);
                a bWU6 = a.bWU();
                if (bWU6 != null) {
                    bWU6.a(this.ihY);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ct <= 0 && this.iic != null) {
                    this.Ct = this.iic.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihY.bWW().getUrl(), this.ihY.bWW().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihY.a(eVar);
                a bWU7 = a.bWU();
                if (bWU7 != null) {
                    bWU7.a(this.ihY);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.iic != null) {
            this.iic.ji();
        }
    }

    public boolean jk() {
        if (this.ihY == null) {
            return false;
        }
        return this.ihY.bWX().Dc;
    }

    public void jl() {
        if (this.ihY != null) {
            this.ihY.bWX().Dc = true;
        }
    }
}
