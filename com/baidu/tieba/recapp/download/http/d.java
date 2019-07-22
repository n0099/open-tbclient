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
    private g iGN;
    private b iGR;
    private int As = 0;
    private long Ah = 0;

    public d(g gVar) {
        this.iGN = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int gr = i3 <= 0 ? com.baidu.adp.framework.c.b.gn().gq().gr() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.gn().getRetryCount();
        }
        int gr2 = i4 <= 0 ? com.baidu.adp.framework.c.b.gn().go().gr() : i4;
        this.iGR = new b(this.iGN);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.Aw = i5 + 1;
                this.As = i5;
                boolean a = this.iGR.a(str, jVar, gr, gr2, z, eVar, z2);
                com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                this.iGN.a(eVar);
                a chR = a.chR();
                if (chR != null) {
                    chR.a(this.iGN);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.iGN.chU().responseCode = -100;
                    eVar.Az = String.valueOf(this.iGN.chU().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.iGN.a(eVar);
                    com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                    this.iGN.a(eVar);
                    a chR2 = a.chR();
                    if (chR2 != null) {
                        chR2.a(this.iGN);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                    this.iGN.a(eVar);
                    a chR3 = a.chR();
                    if (chR3 != null) {
                        chR3.a(this.iGN);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.iGN.chU().responseCode = -10;
                eVar.Az = String.valueOf(this.iGN.chU().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.iGN.a(eVar);
                com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                this.iGN.a(eVar);
                a chR4 = a.chR();
                if (chR4 != null) {
                    chR4.a(this.iGN);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.gn().gq().gr();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.gn().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.gn().go().gr();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.iGN.chU().AQ && z && i4 < i; i4++) {
            e eVar = new e();
            this.iGN.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.As = i4;
                                eVar.Aw = i4 + 1;
                                eVar.AG = 1;
                                this.iGR = new b(this.iGN);
                                this.iGR.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.iGN.chU().AR = -19;
                                eVar.Az = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Ah <= 0 && this.iGR != null) {
                                    this.Ah = this.iGR.ig();
                                }
                                eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                                this.iGN.b(eVar);
                                a chR = a.chR();
                                if (chR != null) {
                                    chR.a(this.iGN);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.Az = String.valueOf(this.iGN.chU().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.iGN.chU().AR = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Ah <= 0 && this.iGR != null) {
                                this.Ah = this.iGR.ig();
                            }
                            eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                            this.iGN.b(eVar);
                            a chR2 = a.chR();
                            if (chR2 != null) {
                                chR2.a(this.iGN);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.Az = String.valueOf(this.iGN.chU().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.iGN.chU().AR = -13;
                        if (this.Ah <= 0 && this.iGR != null) {
                            this.Ah = this.iGR.ig();
                        }
                        eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                        this.iGN.b(eVar);
                        a chR3 = a.chR();
                        if (chR3 != null) {
                            chR3.a(this.iGN);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.Az = String.valueOf(this.iGN.chU().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.iGN.chU().AR = -12;
                    if (this.Ah <= 0 && this.iGR != null) {
                        this.Ah = this.iGR.ig();
                    }
                    eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                    this.iGN.b(eVar);
                    a chR4 = a.chR();
                    if (chR4 != null) {
                        chR4.a(this.iGN);
                    }
                    z = true;
                }
                if (this.iGN.chU().responseCode == 200) {
                    this.iGN.b(eVar);
                    if (this.Ah <= 0 && this.iGR != null) {
                        this.Ah = this.iGR.ig();
                    }
                    eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                    this.iGN.b(eVar);
                    a chR5 = a.chR();
                    if (chR5 != null) {
                        chR5.a(this.iGN);
                        return;
                    }
                    return;
                }
                eVar.Az = String.valueOf(this.iGN.chU().responseCode) + "|retryCount:" + i4;
                boolean ab = ab(this.iGN.chU().responseCode);
                if (this.Ah <= 0 && this.iGR != null) {
                    this.Ah = this.iGR.ig();
                }
                eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                this.iGN.b(eVar);
                a chR6 = a.chR();
                if (chR6 != null) {
                    chR6.a(this.iGN);
                }
                z = ab;
            } catch (Throwable th) {
                if (this.Ah <= 0 && this.iGR != null) {
                    this.Ah = this.iGR.ig();
                }
                eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                this.iGN.b(eVar);
                a chR7 = a.chR();
                if (chR7 != null) {
                    chR7.a(this.iGN);
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
            i2 = com.baidu.adp.framework.c.b.gn().gq().gr();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.gn().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.gn().go().gr();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.iGN.chU().AQ && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.Aw = i4 + 1;
            this.As = i4;
            try {
                try {
                    try {
                        this.iGR = new b(this.iGN);
                        this.iGR.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.iGN.chU().AR = -14;
                        eVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.iGN.a(eVar);
                        if (this.Ah <= 0 && this.iGR != null) {
                            this.Ah = this.iGR.ig();
                        }
                        eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                        this.iGN.a(eVar);
                        a chR = a.chR();
                        if (chR != null && this.iGR != null && this.iGR.ij()) {
                            chR.a(this.iGN);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.iGN.chU().AR = -13;
                        z = true;
                        eVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.iGN.a(eVar);
                        if (this.Ah <= 0 && this.iGR != null) {
                            this.Ah = this.iGR.ig();
                        }
                        eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                        this.iGN.a(eVar);
                        a chR2 = a.chR();
                        if (chR2 != null && this.iGR != null && this.iGR.ij()) {
                            chR2.a(this.iGN);
                        }
                    }
                } catch (SocketException e3) {
                    this.iGN.chU().AR = -12;
                    z = true;
                    eVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.iGN.a(eVar);
                    if (this.Ah <= 0 && this.iGR != null) {
                        this.Ah = this.iGR.ig();
                    }
                    eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                    this.iGN.a(eVar);
                    a chR3 = a.chR();
                    if (chR3 != null && this.iGR != null && this.iGR.ij()) {
                        chR3.a(this.iGN);
                    }
                } catch (Throwable th) {
                    this.iGN.chU().AR = -10;
                    z = false;
                    eVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.iGN.a(eVar);
                    if (this.Ah <= 0 && this.iGR != null) {
                        this.Ah = this.iGR.ig();
                    }
                    eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                    this.iGN.a(eVar);
                    a chR4 = a.chR();
                    if (chR4 != null && this.iGR != null && this.iGR.ij()) {
                        chR4.a(this.iGN);
                    }
                }
                if (this.iGN.chU().responseCode == 200) {
                    if (this.Ah <= 0 && this.iGR != null) {
                        this.Ah = this.iGR.ig();
                    }
                    eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                    this.iGN.a(eVar);
                    a chR5 = a.chR();
                    if (chR5 == null || this.iGR == null || !this.iGR.ij()) {
                        return;
                    }
                    chR5.a(this.iGN);
                    return;
                }
                eVar.Az = String.valueOf(this.iGN.chU().responseCode) + "|retryCount:" + i4;
                z = ab(this.iGN.chU().responseCode);
                this.iGN.a(eVar);
                if (this.Ah <= 0 && this.iGR != null) {
                    this.Ah = this.iGR.ig();
                }
                eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                this.iGN.a(eVar);
                a chR6 = a.chR();
                if (chR6 != null && this.iGR != null && this.iGR.ij()) {
                    chR6.a(this.iGN);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ah <= 0 && this.iGR != null) {
                    this.Ah = this.iGR.ig();
                }
                eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                this.iGN.a(eVar);
                a chR7 = a.chR();
                if (chR7 != null && this.iGR != null && this.iGR.ij()) {
                    chR7.a(this.iGN);
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
        if (this.iGN.chT().iy()) {
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
            i2 = com.baidu.adp.framework.c.b.gn().gq().gr();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.gn().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.gn().go().gr();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.iGN.chU().AQ && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.As = i4;
            eVar.Aw = i4 + 1;
            try {
                try {
                    try {
                        this.iGR = new b(this.iGN);
                        this.iGR.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.iGN.chU().AR = -13;
                        z = true;
                        eVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.iGN.a(eVar);
                        if (this.Ah <= 0 && this.iGR != null) {
                            this.Ah = this.iGR.ig();
                        }
                        eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                        this.iGN.a(eVar);
                        a chR = a.chR();
                        if (chR != null) {
                            chR.a(this.iGN);
                        }
                    } catch (Throwable th) {
                        this.iGN.chU().AR = -10;
                        z = false;
                        eVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.iGN.a(eVar);
                        if (this.Ah <= 0 && this.iGR != null) {
                            this.Ah = this.iGR.ig();
                        }
                        eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                        this.iGN.a(eVar);
                        a chR2 = a.chR();
                        if (chR2 != null) {
                            chR2.a(this.iGN);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.iGN.chU().AR = -14;
                    eVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.iGN.a(eVar);
                    if (this.Ah <= 0 && this.iGR != null) {
                        this.Ah = this.iGR.ig();
                    }
                    eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                    this.iGN.a(eVar);
                    a chR3 = a.chR();
                    if (chR3 != null) {
                        chR3.a(this.iGN);
                    }
                } catch (SocketException e3) {
                    this.iGN.chU().AR = -12;
                    z = true;
                    eVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.iGN.a(eVar);
                    if (this.Ah <= 0 && this.iGR != null) {
                        this.Ah = this.iGR.ig();
                    }
                    eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                    this.iGN.a(eVar);
                    a chR4 = a.chR();
                    if (chR4 != null) {
                        chR4.a(this.iGN);
                    }
                }
                if (this.iGN.chU().responseCode == 200) {
                    if (this.Ah <= 0 && this.iGR != null) {
                        this.Ah = this.iGR.ig();
                    }
                    eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                    this.iGN.a(eVar);
                    a chR5 = a.chR();
                    if (chR5 != null) {
                        chR5.a(this.iGN);
                        return;
                    }
                    return;
                }
                eVar.Az = String.valueOf(this.iGN.chU().responseCode) + "|retryCount:" + i4;
                z = ab(this.iGN.chU().responseCode);
                this.iGN.a(eVar);
                if (this.Ah <= 0 && this.iGR != null) {
                    this.Ah = this.iGR.ig();
                }
                eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                this.iGN.a(eVar);
                a chR6 = a.chR();
                if (chR6 != null) {
                    chR6.a(this.iGN);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ah <= 0 && this.iGR != null) {
                    this.Ah = this.iGR.ig();
                }
                eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hH().a(this.iGN.chT().getUrl(), this.iGN.chT().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                this.iGN.a(eVar);
                a chR7 = a.chR();
                if (chR7 != null) {
                    chR7.a(this.iGN);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.iGR != null) {
            this.iGR.ik();
        }
    }

    public boolean im() {
        if (this.iGN == null) {
            return false;
        }
        return this.iGN.chU().AQ;
    }

    public void in() {
        if (this.iGN != null) {
            this.iGN.chU().AQ = true;
        }
    }
}
