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
    private g ihT;
    private b ihX;

    public d(g gVar) {
        this.ihT = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int ho = i3 <= 0 ? com.baidu.adp.framework.c.b.hk().hn().ho() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.hk().getRetryCount();
        }
        int ho2 = i4 <= 0 ? com.baidu.adp.framework.c.b.hk().hl().ho() : i4;
        this.ihX = new b(this.ihT);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.CH = i5 + 1;
                this.CD = i5;
                boolean a = this.ihX.a(str, jVar, ho, ho2, z, eVar, z2);
                com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihT.a(eVar);
                a bWX = a.bWX();
                if (bWX != null) {
                    bWX.a(this.ihT);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.ihT.bXa().responseCode = -100;
                    eVar.CK = String.valueOf(this.ihT.bXa().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.ihT.a(eVar);
                    com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihT.a(eVar);
                    a bWX2 = a.bWX();
                    if (bWX2 != null) {
                        bWX2.a(this.ihT);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihT.a(eVar);
                    a bWX3 = a.bWX();
                    if (bWX3 != null) {
                        bWX3.a(this.ihT);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.ihT.bXa().responseCode = -10;
                eVar.CK = String.valueOf(this.ihT.bXa().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.ihT.a(eVar);
                com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihT.a(eVar);
                a bWX4 = a.bWX();
                if (bWX4 != null) {
                    bWX4.a(this.ihT);
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
        for (int i4 = 0; !this.ihT.bXa().Dc && z && i4 < i; i4++) {
            e eVar = new e();
            this.ihT.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.CD = i4;
                                eVar.CH = i4 + 1;
                                eVar.CT = 1;
                                this.ihX = new b(this.ihT);
                                this.ihX.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.ihT.bXa().Dd = -19;
                                eVar.CK = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Ct <= 0 && this.ihX != null) {
                                    this.Ct = this.ihX.je();
                                }
                                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                                this.ihT.b(eVar);
                                a bWX = a.bWX();
                                if (bWX != null) {
                                    bWX.a(this.ihT);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.CK = String.valueOf(this.ihT.bXa().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.ihT.bXa().Dd = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Ct <= 0 && this.ihX != null) {
                                this.Ct = this.ihX.je();
                            }
                            eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                            this.ihT.b(eVar);
                            a bWX2 = a.bWX();
                            if (bWX2 != null) {
                                bWX2.a(this.ihT);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.CK = String.valueOf(this.ihT.bXa().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.ihT.bXa().Dd = -13;
                        if (this.Ct <= 0 && this.ihX != null) {
                            this.Ct = this.ihX.je();
                        }
                        eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                        this.ihT.b(eVar);
                        a bWX3 = a.bWX();
                        if (bWX3 != null) {
                            bWX3.a(this.ihT);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.CK = String.valueOf(this.ihT.bXa().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.ihT.bXa().Dd = -12;
                    if (this.Ct <= 0 && this.ihX != null) {
                        this.Ct = this.ihX.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihT.b(eVar);
                    a bWX4 = a.bWX();
                    if (bWX4 != null) {
                        bWX4.a(this.ihT);
                    }
                    z = true;
                }
                if (this.ihT.bXa().responseCode == 200) {
                    this.ihT.b(eVar);
                    if (this.Ct <= 0 && this.ihX != null) {
                        this.Ct = this.ihX.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihT.b(eVar);
                    a bWX5 = a.bWX();
                    if (bWX5 != null) {
                        bWX5.a(this.ihT);
                        return;
                    }
                    return;
                }
                eVar.CK = String.valueOf(this.ihT.bXa().responseCode) + "|retryCount:" + i4;
                boolean aj = aj(this.ihT.bXa().responseCode);
                if (this.Ct <= 0 && this.ihX != null) {
                    this.Ct = this.ihX.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihT.b(eVar);
                a bWX6 = a.bWX();
                if (bWX6 != null) {
                    bWX6.a(this.ihT);
                }
                z = aj;
            } catch (Throwable th) {
                if (this.Ct <= 0 && this.ihX != null) {
                    this.Ct = this.ihX.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihT.b(eVar);
                a bWX7 = a.bWX();
                if (bWX7 != null) {
                    bWX7.a(this.ihT);
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
        for (int i4 = 0; !this.ihT.bXa().Dc && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.CH = i4 + 1;
            this.CD = i4;
            try {
                try {
                    try {
                        this.ihX = new b(this.ihT);
                        this.ihX.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.ihT.bXa().Dd = -14;
                        eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.ihT.a(eVar);
                        if (this.Ct <= 0 && this.ihX != null) {
                            this.Ct = this.ihX.je();
                        }
                        eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                        this.ihT.a(eVar);
                        a bWX = a.bWX();
                        if (bWX != null && this.ihX != null && this.ihX.jh()) {
                            bWX.a(this.ihT);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.ihT.bXa().Dd = -13;
                        z = true;
                        eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.ihT.a(eVar);
                        if (this.Ct <= 0 && this.ihX != null) {
                            this.Ct = this.ihX.je();
                        }
                        eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                        this.ihT.a(eVar);
                        a bWX2 = a.bWX();
                        if (bWX2 != null && this.ihX != null && this.ihX.jh()) {
                            bWX2.a(this.ihT);
                        }
                    }
                } catch (SocketException e3) {
                    this.ihT.bXa().Dd = -12;
                    z = true;
                    eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.ihT.a(eVar);
                    if (this.Ct <= 0 && this.ihX != null) {
                        this.Ct = this.ihX.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihT.a(eVar);
                    a bWX3 = a.bWX();
                    if (bWX3 != null && this.ihX != null && this.ihX.jh()) {
                        bWX3.a(this.ihT);
                    }
                } catch (Throwable th) {
                    this.ihT.bXa().Dd = -10;
                    z = false;
                    eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.ihT.a(eVar);
                    if (this.Ct <= 0 && this.ihX != null) {
                        this.Ct = this.ihX.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihT.a(eVar);
                    a bWX4 = a.bWX();
                    if (bWX4 != null && this.ihX != null && this.ihX.jh()) {
                        bWX4.a(this.ihT);
                    }
                }
                if (this.ihT.bXa().responseCode == 200) {
                    if (this.Ct <= 0 && this.ihX != null) {
                        this.Ct = this.ihX.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihT.a(eVar);
                    a bWX5 = a.bWX();
                    if (bWX5 == null || this.ihX == null || !this.ihX.jh()) {
                        return;
                    }
                    bWX5.a(this.ihT);
                    return;
                }
                eVar.CK = String.valueOf(this.ihT.bXa().responseCode) + "|retryCount:" + i4;
                z = aj(this.ihT.bXa().responseCode);
                this.ihT.a(eVar);
                if (this.Ct <= 0 && this.ihX != null) {
                    this.Ct = this.ihX.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihT.a(eVar);
                a bWX6 = a.bWX();
                if (bWX6 != null && this.ihX != null && this.ihX.jh()) {
                    bWX6.a(this.ihT);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ct <= 0 && this.ihX != null) {
                    this.Ct = this.ihX.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihT.a(eVar);
                a bWX7 = a.bWX();
                if (bWX7 != null && this.ihX != null && this.ihX.jh()) {
                    bWX7.a(this.ihT);
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
        if (this.ihT.bWZ().jv()) {
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
        for (int i4 = 0; !this.ihT.bXa().Dc && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.CD = i4;
            eVar.CH = i4 + 1;
            try {
                try {
                    try {
                        this.ihX = new b(this.ihT);
                        this.ihX.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.ihT.bXa().Dd = -13;
                        z = true;
                        eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.ihT.a(eVar);
                        if (this.Ct <= 0 && this.ihX != null) {
                            this.Ct = this.ihX.je();
                        }
                        eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                        this.ihT.a(eVar);
                        a bWX = a.bWX();
                        if (bWX != null) {
                            bWX.a(this.ihT);
                        }
                    } catch (Throwable th) {
                        this.ihT.bXa().Dd = -10;
                        z = false;
                        eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.ihT.a(eVar);
                        if (this.Ct <= 0 && this.ihX != null) {
                            this.Ct = this.ihX.je();
                        }
                        eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                        this.ihT.a(eVar);
                        a bWX2 = a.bWX();
                        if (bWX2 != null) {
                            bWX2.a(this.ihT);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.ihT.bXa().Dd = -14;
                    eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.ihT.a(eVar);
                    if (this.Ct <= 0 && this.ihX != null) {
                        this.Ct = this.ihX.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihT.a(eVar);
                    a bWX3 = a.bWX();
                    if (bWX3 != null) {
                        bWX3.a(this.ihT);
                    }
                } catch (SocketException e3) {
                    this.ihT.bXa().Dd = -12;
                    z = true;
                    eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.ihT.a(eVar);
                    if (this.Ct <= 0 && this.ihX != null) {
                        this.Ct = this.ihX.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihT.a(eVar);
                    a bWX4 = a.bWX();
                    if (bWX4 != null) {
                        bWX4.a(this.ihT);
                    }
                }
                if (this.ihT.bXa().responseCode == 200) {
                    if (this.Ct <= 0 && this.ihX != null) {
                        this.Ct = this.ihX.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihT.a(eVar);
                    a bWX5 = a.bWX();
                    if (bWX5 != null) {
                        bWX5.a(this.ihT);
                        return;
                    }
                    return;
                }
                eVar.CK = String.valueOf(this.ihT.bXa().responseCode) + "|retryCount:" + i4;
                z = aj(this.ihT.bXa().responseCode);
                this.ihT.a(eVar);
                if (this.Ct <= 0 && this.ihX != null) {
                    this.Ct = this.ihX.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihT.a(eVar);
                a bWX6 = a.bWX();
                if (bWX6 != null) {
                    bWX6.a(this.ihT);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ct <= 0 && this.ihX != null) {
                    this.Ct = this.ihX.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihT.bWZ().getUrl(), this.ihT.bWZ().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihT.a(eVar);
                a bWX7 = a.bWX();
                if (bWX7 != null) {
                    bWX7.a(this.ihT);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.ihX != null) {
            this.ihX.ji();
        }
    }

    public boolean jk() {
        if (this.ihT == null) {
            return false;
        }
        return this.ihT.bXa().Dc;
    }

    public void jl() {
        if (this.ihT != null) {
            this.ihT.bXa().Dc = true;
        }
    }
}
