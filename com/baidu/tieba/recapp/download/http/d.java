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
    private g iHR;
    private b iHV;
    private int As = 0;
    private long Ah = 0;

    public d(g gVar) {
        this.iHR = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int gr = i3 <= 0 ? com.baidu.adp.framework.c.b.gn().gq().gr() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.gn().getRetryCount();
        }
        int gr2 = i4 <= 0 ? com.baidu.adp.framework.c.b.gn().go().gr() : i4;
        this.iHV = new b(this.iHR);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.Aw = i5 + 1;
                this.As = i5;
                boolean a = this.iHV.a(str, jVar, gr, gr2, z, eVar, z2);
                com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                this.iHR.a(eVar);
                a cij = a.cij();
                if (cij != null) {
                    cij.a(this.iHR);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.iHR.cim().responseCode = -100;
                    eVar.Az = String.valueOf(this.iHR.cim().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.iHR.a(eVar);
                    com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                    this.iHR.a(eVar);
                    a cij2 = a.cij();
                    if (cij2 != null) {
                        cij2.a(this.iHR);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                    this.iHR.a(eVar);
                    a cij3 = a.cij();
                    if (cij3 != null) {
                        cij3.a(this.iHR);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.iHR.cim().responseCode = -10;
                eVar.Az = String.valueOf(this.iHR.cim().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.iHR.a(eVar);
                com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                this.iHR.a(eVar);
                a cij4 = a.cij();
                if (cij4 != null) {
                    cij4.a(this.iHR);
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
        for (int i4 = 0; !this.iHR.cim().AQ && z && i4 < i; i4++) {
            e eVar = new e();
            this.iHR.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.As = i4;
                                eVar.Aw = i4 + 1;
                                eVar.AG = 1;
                                this.iHV = new b(this.iHR);
                                this.iHV.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.iHR.cim().AR = -19;
                                eVar.Az = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Ah <= 0 && this.iHV != null) {
                                    this.Ah = this.iHV.ig();
                                }
                                eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                                this.iHR.b(eVar);
                                a cij = a.cij();
                                if (cij != null) {
                                    cij.a(this.iHR);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.Az = String.valueOf(this.iHR.cim().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.iHR.cim().AR = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Ah <= 0 && this.iHV != null) {
                                this.Ah = this.iHV.ig();
                            }
                            eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                            this.iHR.b(eVar);
                            a cij2 = a.cij();
                            if (cij2 != null) {
                                cij2.a(this.iHR);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.Az = String.valueOf(this.iHR.cim().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.iHR.cim().AR = -13;
                        if (this.Ah <= 0 && this.iHV != null) {
                            this.Ah = this.iHV.ig();
                        }
                        eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                        this.iHR.b(eVar);
                        a cij3 = a.cij();
                        if (cij3 != null) {
                            cij3.a(this.iHR);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.Az = String.valueOf(this.iHR.cim().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.iHR.cim().AR = -12;
                    if (this.Ah <= 0 && this.iHV != null) {
                        this.Ah = this.iHV.ig();
                    }
                    eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                    this.iHR.b(eVar);
                    a cij4 = a.cij();
                    if (cij4 != null) {
                        cij4.a(this.iHR);
                    }
                    z = true;
                }
                if (this.iHR.cim().responseCode == 200) {
                    this.iHR.b(eVar);
                    if (this.Ah <= 0 && this.iHV != null) {
                        this.Ah = this.iHV.ig();
                    }
                    eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                    this.iHR.b(eVar);
                    a cij5 = a.cij();
                    if (cij5 != null) {
                        cij5.a(this.iHR);
                        return;
                    }
                    return;
                }
                eVar.Az = String.valueOf(this.iHR.cim().responseCode) + "|retryCount:" + i4;
                boolean ab = ab(this.iHR.cim().responseCode);
                if (this.Ah <= 0 && this.iHV != null) {
                    this.Ah = this.iHV.ig();
                }
                eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                this.iHR.b(eVar);
                a cij6 = a.cij();
                if (cij6 != null) {
                    cij6.a(this.iHR);
                }
                z = ab;
            } catch (Throwable th) {
                if (this.Ah <= 0 && this.iHV != null) {
                    this.Ah = this.iHV.ig();
                }
                eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                this.iHR.b(eVar);
                a cij7 = a.cij();
                if (cij7 != null) {
                    cij7.a(this.iHR);
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
        for (int i4 = 0; !this.iHR.cim().AQ && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.Aw = i4 + 1;
            this.As = i4;
            try {
                try {
                    try {
                        this.iHV = new b(this.iHR);
                        this.iHV.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.iHR.cim().AR = -14;
                        eVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.iHR.a(eVar);
                        if (this.Ah <= 0 && this.iHV != null) {
                            this.Ah = this.iHV.ig();
                        }
                        eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                        this.iHR.a(eVar);
                        a cij = a.cij();
                        if (cij != null && this.iHV != null && this.iHV.ij()) {
                            cij.a(this.iHR);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.iHR.cim().AR = -13;
                        z = true;
                        eVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.iHR.a(eVar);
                        if (this.Ah <= 0 && this.iHV != null) {
                            this.Ah = this.iHV.ig();
                        }
                        eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                        this.iHR.a(eVar);
                        a cij2 = a.cij();
                        if (cij2 != null && this.iHV != null && this.iHV.ij()) {
                            cij2.a(this.iHR);
                        }
                    }
                } catch (SocketException e3) {
                    this.iHR.cim().AR = -12;
                    z = true;
                    eVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.iHR.a(eVar);
                    if (this.Ah <= 0 && this.iHV != null) {
                        this.Ah = this.iHV.ig();
                    }
                    eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                    this.iHR.a(eVar);
                    a cij3 = a.cij();
                    if (cij3 != null && this.iHV != null && this.iHV.ij()) {
                        cij3.a(this.iHR);
                    }
                } catch (Throwable th) {
                    this.iHR.cim().AR = -10;
                    z = false;
                    eVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.iHR.a(eVar);
                    if (this.Ah <= 0 && this.iHV != null) {
                        this.Ah = this.iHV.ig();
                    }
                    eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                    this.iHR.a(eVar);
                    a cij4 = a.cij();
                    if (cij4 != null && this.iHV != null && this.iHV.ij()) {
                        cij4.a(this.iHR);
                    }
                }
                if (this.iHR.cim().responseCode == 200) {
                    if (this.Ah <= 0 && this.iHV != null) {
                        this.Ah = this.iHV.ig();
                    }
                    eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                    this.iHR.a(eVar);
                    a cij5 = a.cij();
                    if (cij5 == null || this.iHV == null || !this.iHV.ij()) {
                        return;
                    }
                    cij5.a(this.iHR);
                    return;
                }
                eVar.Az = String.valueOf(this.iHR.cim().responseCode) + "|retryCount:" + i4;
                z = ab(this.iHR.cim().responseCode);
                this.iHR.a(eVar);
                if (this.Ah <= 0 && this.iHV != null) {
                    this.Ah = this.iHV.ig();
                }
                eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                this.iHR.a(eVar);
                a cij6 = a.cij();
                if (cij6 != null && this.iHV != null && this.iHV.ij()) {
                    cij6.a(this.iHR);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ah <= 0 && this.iHV != null) {
                    this.Ah = this.iHV.ig();
                }
                eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                this.iHR.a(eVar);
                a cij7 = a.cij();
                if (cij7 != null && this.iHV != null && this.iHV.ij()) {
                    cij7.a(this.iHR);
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
        if (this.iHR.cil().iy()) {
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
        for (int i4 = 0; !this.iHR.cim().AQ && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.As = i4;
            eVar.Aw = i4 + 1;
            try {
                try {
                    try {
                        this.iHV = new b(this.iHR);
                        this.iHV.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.iHR.cim().AR = -13;
                        z = true;
                        eVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.iHR.a(eVar);
                        if (this.Ah <= 0 && this.iHV != null) {
                            this.Ah = this.iHV.ig();
                        }
                        eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                        this.iHR.a(eVar);
                        a cij = a.cij();
                        if (cij != null) {
                            cij.a(this.iHR);
                        }
                    } catch (Throwable th) {
                        this.iHR.cim().AR = -10;
                        z = false;
                        eVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.iHR.a(eVar);
                        if (this.Ah <= 0 && this.iHV != null) {
                            this.Ah = this.iHV.ig();
                        }
                        eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                        this.iHR.a(eVar);
                        a cij2 = a.cij();
                        if (cij2 != null) {
                            cij2.a(this.iHR);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.iHR.cim().AR = -14;
                    eVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.iHR.a(eVar);
                    if (this.Ah <= 0 && this.iHV != null) {
                        this.Ah = this.iHV.ig();
                    }
                    eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                    this.iHR.a(eVar);
                    a cij3 = a.cij();
                    if (cij3 != null) {
                        cij3.a(this.iHR);
                    }
                } catch (SocketException e3) {
                    this.iHR.cim().AR = -12;
                    z = true;
                    eVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.iHR.a(eVar);
                    if (this.Ah <= 0 && this.iHV != null) {
                        this.Ah = this.iHV.ig();
                    }
                    eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                    this.iHR.a(eVar);
                    a cij4 = a.cij();
                    if (cij4 != null) {
                        cij4.a(this.iHR);
                    }
                }
                if (this.iHR.cim().responseCode == 200) {
                    if (this.Ah <= 0 && this.iHV != null) {
                        this.Ah = this.iHV.ig();
                    }
                    eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                    this.iHR.a(eVar);
                    a cij5 = a.cij();
                    if (cij5 != null) {
                        cij5.a(this.iHR);
                        return;
                    }
                    return;
                }
                eVar.Az = String.valueOf(this.iHR.cim().responseCode) + "|retryCount:" + i4;
                z = ab(this.iHR.cim().responseCode);
                this.iHR.a(eVar);
                if (this.Ah <= 0 && this.iHV != null) {
                    this.Ah = this.iHV.ig();
                }
                eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                this.iHR.a(eVar);
                a cij6 = a.cij();
                if (cij6 != null) {
                    cij6.a(this.iHR);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ah <= 0 && this.iHV != null) {
                    this.Ah = this.iHV.ig();
                }
                eVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hH().a(this.iHR.cil().getUrl(), this.iHR.cil().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Az), eVar.AD != null);
                this.iHR.a(eVar);
                a cij7 = a.cij();
                if (cij7 != null) {
                    cij7.a(this.iHR);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.iHV != null) {
            this.iHV.ik();
        }
    }

    public boolean im() {
        if (this.iHR == null) {
            return false;
        }
        return this.iHR.cim().AQ;
    }

    public void in() {
        if (this.iHR != null) {
            this.iHR.cim().AQ = true;
        }
    }
}
