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
    private g ihZ;
    private b iid;

    public d(g gVar) {
        this.ihZ = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int ho = i3 <= 0 ? com.baidu.adp.framework.c.b.hk().hn().ho() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.hk().getRetryCount();
        }
        int ho2 = i4 <= 0 ? com.baidu.adp.framework.c.b.hk().hl().ho() : i4;
        this.iid = new b(this.ihZ);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.CH = i5 + 1;
                this.CD = i5;
                boolean a = this.iid.a(str, jVar, ho, ho2, z, eVar, z2);
                com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihZ.a(eVar);
                a bWV = a.bWV();
                if (bWV != null) {
                    bWV.a(this.ihZ);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.ihZ.bWY().responseCode = -100;
                    eVar.CK = String.valueOf(this.ihZ.bWY().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.ihZ.a(eVar);
                    com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihZ.a(eVar);
                    a bWV2 = a.bWV();
                    if (bWV2 != null) {
                        bWV2.a(this.ihZ);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihZ.a(eVar);
                    a bWV3 = a.bWV();
                    if (bWV3 != null) {
                        bWV3.a(this.ihZ);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.ihZ.bWY().responseCode = -10;
                eVar.CK = String.valueOf(this.ihZ.bWY().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.ihZ.a(eVar);
                com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihZ.a(eVar);
                a bWV4 = a.bWV();
                if (bWV4 != null) {
                    bWV4.a(this.ihZ);
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
        for (int i4 = 0; !this.ihZ.bWY().Dc && z && i4 < i; i4++) {
            e eVar = new e();
            this.ihZ.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.CD = i4;
                                eVar.CH = i4 + 1;
                                eVar.CT = 1;
                                this.iid = new b(this.ihZ);
                                this.iid.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.ihZ.bWY().Dd = -19;
                                eVar.CK = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Ct <= 0 && this.iid != null) {
                                    this.Ct = this.iid.je();
                                }
                                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                                this.ihZ.b(eVar);
                                a bWV = a.bWV();
                                if (bWV != null) {
                                    bWV.a(this.ihZ);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.CK = String.valueOf(this.ihZ.bWY().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.ihZ.bWY().Dd = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Ct <= 0 && this.iid != null) {
                                this.Ct = this.iid.je();
                            }
                            eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                            this.ihZ.b(eVar);
                            a bWV2 = a.bWV();
                            if (bWV2 != null) {
                                bWV2.a(this.ihZ);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.CK = String.valueOf(this.ihZ.bWY().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.ihZ.bWY().Dd = -13;
                        if (this.Ct <= 0 && this.iid != null) {
                            this.Ct = this.iid.je();
                        }
                        eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                        this.ihZ.b(eVar);
                        a bWV3 = a.bWV();
                        if (bWV3 != null) {
                            bWV3.a(this.ihZ);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.CK = String.valueOf(this.ihZ.bWY().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.ihZ.bWY().Dd = -12;
                    if (this.Ct <= 0 && this.iid != null) {
                        this.Ct = this.iid.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihZ.b(eVar);
                    a bWV4 = a.bWV();
                    if (bWV4 != null) {
                        bWV4.a(this.ihZ);
                    }
                    z = true;
                }
                if (this.ihZ.bWY().responseCode == 200) {
                    this.ihZ.b(eVar);
                    if (this.Ct <= 0 && this.iid != null) {
                        this.Ct = this.iid.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihZ.b(eVar);
                    a bWV5 = a.bWV();
                    if (bWV5 != null) {
                        bWV5.a(this.ihZ);
                        return;
                    }
                    return;
                }
                eVar.CK = String.valueOf(this.ihZ.bWY().responseCode) + "|retryCount:" + i4;
                boolean aj = aj(this.ihZ.bWY().responseCode);
                if (this.Ct <= 0 && this.iid != null) {
                    this.Ct = this.iid.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihZ.b(eVar);
                a bWV6 = a.bWV();
                if (bWV6 != null) {
                    bWV6.a(this.ihZ);
                }
                z = aj;
            } catch (Throwable th) {
                if (this.Ct <= 0 && this.iid != null) {
                    this.Ct = this.iid.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihZ.b(eVar);
                a bWV7 = a.bWV();
                if (bWV7 != null) {
                    bWV7.a(this.ihZ);
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
        for (int i4 = 0; !this.ihZ.bWY().Dc && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.CH = i4 + 1;
            this.CD = i4;
            try {
                try {
                    try {
                        this.iid = new b(this.ihZ);
                        this.iid.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.ihZ.bWY().Dd = -14;
                        eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.ihZ.a(eVar);
                        if (this.Ct <= 0 && this.iid != null) {
                            this.Ct = this.iid.je();
                        }
                        eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                        this.ihZ.a(eVar);
                        a bWV = a.bWV();
                        if (bWV != null && this.iid != null && this.iid.jh()) {
                            bWV.a(this.ihZ);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.ihZ.bWY().Dd = -13;
                        z = true;
                        eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.ihZ.a(eVar);
                        if (this.Ct <= 0 && this.iid != null) {
                            this.Ct = this.iid.je();
                        }
                        eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                        this.ihZ.a(eVar);
                        a bWV2 = a.bWV();
                        if (bWV2 != null && this.iid != null && this.iid.jh()) {
                            bWV2.a(this.ihZ);
                        }
                    }
                } catch (SocketException e3) {
                    this.ihZ.bWY().Dd = -12;
                    z = true;
                    eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.ihZ.a(eVar);
                    if (this.Ct <= 0 && this.iid != null) {
                        this.Ct = this.iid.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihZ.a(eVar);
                    a bWV3 = a.bWV();
                    if (bWV3 != null && this.iid != null && this.iid.jh()) {
                        bWV3.a(this.ihZ);
                    }
                } catch (Throwable th) {
                    this.ihZ.bWY().Dd = -10;
                    z = false;
                    eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.ihZ.a(eVar);
                    if (this.Ct <= 0 && this.iid != null) {
                        this.Ct = this.iid.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihZ.a(eVar);
                    a bWV4 = a.bWV();
                    if (bWV4 != null && this.iid != null && this.iid.jh()) {
                        bWV4.a(this.ihZ);
                    }
                }
                if (this.ihZ.bWY().responseCode == 200) {
                    if (this.Ct <= 0 && this.iid != null) {
                        this.Ct = this.iid.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihZ.a(eVar);
                    a bWV5 = a.bWV();
                    if (bWV5 == null || this.iid == null || !this.iid.jh()) {
                        return;
                    }
                    bWV5.a(this.ihZ);
                    return;
                }
                eVar.CK = String.valueOf(this.ihZ.bWY().responseCode) + "|retryCount:" + i4;
                z = aj(this.ihZ.bWY().responseCode);
                this.ihZ.a(eVar);
                if (this.Ct <= 0 && this.iid != null) {
                    this.Ct = this.iid.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihZ.a(eVar);
                a bWV6 = a.bWV();
                if (bWV6 != null && this.iid != null && this.iid.jh()) {
                    bWV6.a(this.ihZ);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ct <= 0 && this.iid != null) {
                    this.Ct = this.iid.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihZ.a(eVar);
                a bWV7 = a.bWV();
                if (bWV7 != null && this.iid != null && this.iid.jh()) {
                    bWV7.a(this.ihZ);
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
        if (this.ihZ.bWX().jv()) {
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
        for (int i4 = 0; !this.ihZ.bWY().Dc && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.CD = i4;
            eVar.CH = i4 + 1;
            try {
                try {
                    try {
                        this.iid = new b(this.ihZ);
                        this.iid.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.ihZ.bWY().Dd = -13;
                        z = true;
                        eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.ihZ.a(eVar);
                        if (this.Ct <= 0 && this.iid != null) {
                            this.Ct = this.iid.je();
                        }
                        eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                        this.ihZ.a(eVar);
                        a bWV = a.bWV();
                        if (bWV != null) {
                            bWV.a(this.ihZ);
                        }
                    } catch (Throwable th) {
                        this.ihZ.bWY().Dd = -10;
                        z = false;
                        eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.ihZ.a(eVar);
                        if (this.Ct <= 0 && this.iid != null) {
                            this.Ct = this.iid.je();
                        }
                        eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                        this.ihZ.a(eVar);
                        a bWV2 = a.bWV();
                        if (bWV2 != null) {
                            bWV2.a(this.ihZ);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.ihZ.bWY().Dd = -14;
                    eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.ihZ.a(eVar);
                    if (this.Ct <= 0 && this.iid != null) {
                        this.Ct = this.iid.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihZ.a(eVar);
                    a bWV3 = a.bWV();
                    if (bWV3 != null) {
                        bWV3.a(this.ihZ);
                    }
                } catch (SocketException e3) {
                    this.ihZ.bWY().Dd = -12;
                    z = true;
                    eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.ihZ.a(eVar);
                    if (this.Ct <= 0 && this.iid != null) {
                        this.Ct = this.iid.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihZ.a(eVar);
                    a bWV4 = a.bWV();
                    if (bWV4 != null) {
                        bWV4.a(this.ihZ);
                    }
                }
                if (this.ihZ.bWY().responseCode == 200) {
                    if (this.Ct <= 0 && this.iid != null) {
                        this.Ct = this.iid.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihZ.a(eVar);
                    a bWV5 = a.bWV();
                    if (bWV5 != null) {
                        bWV5.a(this.ihZ);
                        return;
                    }
                    return;
                }
                eVar.CK = String.valueOf(this.ihZ.bWY().responseCode) + "|retryCount:" + i4;
                z = aj(this.ihZ.bWY().responseCode);
                this.ihZ.a(eVar);
                if (this.Ct <= 0 && this.iid != null) {
                    this.Ct = this.iid.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihZ.a(eVar);
                a bWV6 = a.bWV();
                if (bWV6 != null) {
                    bWV6.a(this.ihZ);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ct <= 0 && this.iid != null) {
                    this.Ct = this.iid.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihZ.bWX().getUrl(), this.ihZ.bWX().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihZ.a(eVar);
                a bWV7 = a.bWV();
                if (bWV7 != null) {
                    bWV7.a(this.ihZ);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.iid != null) {
            this.iid.ji();
        }
    }

    public boolean jk() {
        if (this.ihZ == null) {
            return false;
        }
        return this.ihZ.bWY().Dc;
    }

    public void jl() {
        if (this.ihZ != null) {
            this.ihZ.bWY().Dc = true;
        }
    }
}
