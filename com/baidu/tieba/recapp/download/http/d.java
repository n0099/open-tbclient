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
    private long Cs = 0;
    private g ihG;
    private b ihK;

    public d(g gVar) {
        this.ihG = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int ho = i3 <= 0 ? com.baidu.adp.framework.c.b.hk().hn().ho() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.hk().getRetryCount();
        }
        int ho2 = i4 <= 0 ? com.baidu.adp.framework.c.b.hk().hl().ho() : i4;
        this.ihK = new b(this.ihG);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.CH = i5 + 1;
                this.CD = i5;
                boolean a = this.ihK.a(str, jVar, ho, ho2, z, eVar, z2);
                com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihG.a(eVar);
                a bWT = a.bWT();
                if (bWT != null) {
                    bWT.a(this.ihG);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.ihG.bWW().responseCode = -100;
                    eVar.CK = String.valueOf(this.ihG.bWW().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.ihG.a(eVar);
                    com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihG.a(eVar);
                    a bWT2 = a.bWT();
                    if (bWT2 != null) {
                        bWT2.a(this.ihG);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihG.a(eVar);
                    a bWT3 = a.bWT();
                    if (bWT3 != null) {
                        bWT3.a(this.ihG);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.ihG.bWW().responseCode = -10;
                eVar.CK = String.valueOf(this.ihG.bWW().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.ihG.a(eVar);
                com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihG.a(eVar);
                a bWT4 = a.bWT();
                if (bWT4 != null) {
                    bWT4.a(this.ihG);
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
        for (int i4 = 0; !this.ihG.bWW().Dc && z && i4 < i; i4++) {
            e eVar = new e();
            this.ihG.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.CD = i4;
                                eVar.CH = i4 + 1;
                                eVar.CT = 1;
                                this.ihK = new b(this.ihG);
                                this.ihK.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.ihG.bWW().Dd = -19;
                                eVar.CK = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Cs <= 0 && this.ihK != null) {
                                    this.Cs = this.ihK.je();
                                }
                                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                                this.ihG.b(eVar);
                                a bWT = a.bWT();
                                if (bWT != null) {
                                    bWT.a(this.ihG);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.CK = String.valueOf(this.ihG.bWW().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.ihG.bWW().Dd = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Cs <= 0 && this.ihK != null) {
                                this.Cs = this.ihK.je();
                            }
                            eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                            this.ihG.b(eVar);
                            a bWT2 = a.bWT();
                            if (bWT2 != null) {
                                bWT2.a(this.ihG);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.CK = String.valueOf(this.ihG.bWW().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.ihG.bWW().Dd = -13;
                        if (this.Cs <= 0 && this.ihK != null) {
                            this.Cs = this.ihK.je();
                        }
                        eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                        this.ihG.b(eVar);
                        a bWT3 = a.bWT();
                        if (bWT3 != null) {
                            bWT3.a(this.ihG);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.CK = String.valueOf(this.ihG.bWW().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.ihG.bWW().Dd = -12;
                    if (this.Cs <= 0 && this.ihK != null) {
                        this.Cs = this.ihK.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihG.b(eVar);
                    a bWT4 = a.bWT();
                    if (bWT4 != null) {
                        bWT4.a(this.ihG);
                    }
                    z = true;
                }
                if (this.ihG.bWW().responseCode == 200) {
                    this.ihG.b(eVar);
                    if (this.Cs <= 0 && this.ihK != null) {
                        this.Cs = this.ihK.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihG.b(eVar);
                    a bWT5 = a.bWT();
                    if (bWT5 != null) {
                        bWT5.a(this.ihG);
                        return;
                    }
                    return;
                }
                eVar.CK = String.valueOf(this.ihG.bWW().responseCode) + "|retryCount:" + i4;
                boolean ai = ai(this.ihG.bWW().responseCode);
                if (this.Cs <= 0 && this.ihK != null) {
                    this.Cs = this.ihK.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihG.b(eVar);
                a bWT6 = a.bWT();
                if (bWT6 != null) {
                    bWT6.a(this.ihG);
                }
                z = ai;
            } catch (Throwable th) {
                if (this.Cs <= 0 && this.ihK != null) {
                    this.Cs = this.ihK.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihG.b(eVar);
                a bWT7 = a.bWT();
                if (bWT7 != null) {
                    bWT7.a(this.ihG);
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
        for (int i4 = 0; !this.ihG.bWW().Dc && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.CH = i4 + 1;
            this.CD = i4;
            try {
                try {
                    try {
                        this.ihK = new b(this.ihG);
                        this.ihK.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.ihG.bWW().Dd = -14;
                        eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.ihG.a(eVar);
                        if (this.Cs <= 0 && this.ihK != null) {
                            this.Cs = this.ihK.je();
                        }
                        eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                        this.ihG.a(eVar);
                        a bWT = a.bWT();
                        if (bWT != null && this.ihK != null && this.ihK.jh()) {
                            bWT.a(this.ihG);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.ihG.bWW().Dd = -13;
                        z = true;
                        eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.ihG.a(eVar);
                        if (this.Cs <= 0 && this.ihK != null) {
                            this.Cs = this.ihK.je();
                        }
                        eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                        this.ihG.a(eVar);
                        a bWT2 = a.bWT();
                        if (bWT2 != null && this.ihK != null && this.ihK.jh()) {
                            bWT2.a(this.ihG);
                        }
                    }
                } catch (SocketException e3) {
                    this.ihG.bWW().Dd = -12;
                    z = true;
                    eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.ihG.a(eVar);
                    if (this.Cs <= 0 && this.ihK != null) {
                        this.Cs = this.ihK.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihG.a(eVar);
                    a bWT3 = a.bWT();
                    if (bWT3 != null && this.ihK != null && this.ihK.jh()) {
                        bWT3.a(this.ihG);
                    }
                } catch (Throwable th) {
                    this.ihG.bWW().Dd = -10;
                    z = false;
                    eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.ihG.a(eVar);
                    if (this.Cs <= 0 && this.ihK != null) {
                        this.Cs = this.ihK.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihG.a(eVar);
                    a bWT4 = a.bWT();
                    if (bWT4 != null && this.ihK != null && this.ihK.jh()) {
                        bWT4.a(this.ihG);
                    }
                }
                if (this.ihG.bWW().responseCode == 200) {
                    if (this.Cs <= 0 && this.ihK != null) {
                        this.Cs = this.ihK.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihG.a(eVar);
                    a bWT5 = a.bWT();
                    if (bWT5 == null || this.ihK == null || !this.ihK.jh()) {
                        return;
                    }
                    bWT5.a(this.ihG);
                    return;
                }
                eVar.CK = String.valueOf(this.ihG.bWW().responseCode) + "|retryCount:" + i4;
                z = ai(this.ihG.bWW().responseCode);
                this.ihG.a(eVar);
                if (this.Cs <= 0 && this.ihK != null) {
                    this.Cs = this.ihK.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihG.a(eVar);
                a bWT6 = a.bWT();
                if (bWT6 != null && this.ihK != null && this.ihK.jh()) {
                    bWT6.a(this.ihG);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Cs <= 0 && this.ihK != null) {
                    this.Cs = this.ihK.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihG.a(eVar);
                a bWT7 = a.bWT();
                if (bWT7 != null && this.ihK != null && this.ihK.jh()) {
                    bWT7.a(this.ihG);
                }
                throw th2;
            }
        }
    }

    private boolean ai(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void g(int i, int i2, int i3) {
        if (this.ihG.bWV().jv()) {
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
        for (int i4 = 0; !this.ihG.bWW().Dc && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.CD = i4;
            eVar.CH = i4 + 1;
            try {
                try {
                    try {
                        this.ihK = new b(this.ihG);
                        this.ihK.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.ihG.bWW().Dd = -13;
                        z = true;
                        eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.ihG.a(eVar);
                        if (this.Cs <= 0 && this.ihK != null) {
                            this.Cs = this.ihK.je();
                        }
                        eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                        this.ihG.a(eVar);
                        a bWT = a.bWT();
                        if (bWT != null) {
                            bWT.a(this.ihG);
                        }
                    } catch (Throwable th) {
                        this.ihG.bWW().Dd = -10;
                        z = false;
                        eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.ihG.a(eVar);
                        if (this.Cs <= 0 && this.ihK != null) {
                            this.Cs = this.ihK.je();
                        }
                        eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                        this.ihG.a(eVar);
                        a bWT2 = a.bWT();
                        if (bWT2 != null) {
                            bWT2.a(this.ihG);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.ihG.bWW().Dd = -14;
                    eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.ihG.a(eVar);
                    if (this.Cs <= 0 && this.ihK != null) {
                        this.Cs = this.ihK.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihG.a(eVar);
                    a bWT3 = a.bWT();
                    if (bWT3 != null) {
                        bWT3.a(this.ihG);
                    }
                } catch (SocketException e3) {
                    this.ihG.bWW().Dd = -12;
                    z = true;
                    eVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.ihG.a(eVar);
                    if (this.Cs <= 0 && this.ihK != null) {
                        this.Cs = this.ihK.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihG.a(eVar);
                    a bWT4 = a.bWT();
                    if (bWT4 != null) {
                        bWT4.a(this.ihG);
                    }
                }
                if (this.ihG.bWW().responseCode == 200) {
                    if (this.Cs <= 0 && this.ihK != null) {
                        this.Cs = this.ihK.je();
                    }
                    eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                    this.ihG.a(eVar);
                    a bWT5 = a.bWT();
                    if (bWT5 != null) {
                        bWT5.a(this.ihG);
                        return;
                    }
                    return;
                }
                eVar.CK = String.valueOf(this.ihG.bWW().responseCode) + "|retryCount:" + i4;
                z = ai(this.ihG.bWW().responseCode);
                this.ihG.a(eVar);
                if (this.Cs <= 0 && this.ihK != null) {
                    this.Cs = this.ihK.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihG.a(eVar);
                a bWT6 = a.bWT();
                if (bWT6 != null) {
                    bWT6.a(this.ihG);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Cs <= 0 && this.ihK != null) {
                    this.Cs = this.ihK.je();
                }
                eVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.ihG.bWV().getUrl(), this.ihG.bWV().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.CK), eVar.CO != null);
                this.ihG.a(eVar);
                a bWT7 = a.bWT();
                if (bWT7 != null) {
                    bWT7.a(this.ihG);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.ihK != null) {
            this.ihK.ji();
        }
    }

    public boolean jk() {
        if (this.ihG == null) {
            return false;
        }
        return this.ihG.bWW().Dc;
    }

    public void jl() {
        if (this.ihG != null) {
            this.ihG.bWW().Dc = true;
        }
    }
}
