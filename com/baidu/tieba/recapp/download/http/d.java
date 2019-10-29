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
    private g iJe;
    private b iJi;
    private int oS = 0;
    private long oH = 0;

    public d(g gVar) {
        this.iJe = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.c.b.eH().eK().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eH().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.c.b.eH().eI().getTimeOutAuto() : i4;
        this.iJi = new b(this.iJe);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.oV = i5 + 1;
                this.oS = i5;
                boolean a = this.iJi.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                this.iJe.a(eVar);
                a cfZ = a.cfZ();
                if (cfZ != null) {
                    cfZ.a(this.iJe);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.iJe.cgc().responseCode = -100;
                    eVar.exception = String.valueOf(this.iJe.cgc().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.iJe.a(eVar);
                    com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                    this.iJe.a(eVar);
                    a cfZ2 = a.cfZ();
                    if (cfZ2 != null) {
                        cfZ2.a(this.iJe);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                    this.iJe.a(eVar);
                    a cfZ3 = a.cfZ();
                    if (cfZ3 != null) {
                        cfZ3.a(this.iJe);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.iJe.cgc().responseCode = -10;
                eVar.exception = String.valueOf(this.iJe.cgc().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.iJe.a(eVar);
                com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                this.iJe.a(eVar);
                a cfZ4 = a.cfZ();
                if (cfZ4 != null) {
                    cfZ4.a(this.iJe);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void c(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eH().eK().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eH().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eH().eI().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.iJe.cgc().pz && z && i4 < i; i4++) {
            e eVar = new e();
            this.iJe.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.oS = i4;
                                eVar.oV = i4 + 1;
                                eVar.ph = 1;
                                this.iJi = new b(this.iJe);
                                this.iJi.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.iJe.cgc().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.oH <= 0 && this.iJi != null) {
                                    this.oH = this.iJi.fA();
                                }
                                eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                                this.iJe.b(eVar);
                                a cfZ = a.cfZ();
                                if (cfZ != null) {
                                    cfZ.a(this.iJe);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.iJe.cgc().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.iJe.cgc().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.oH <= 0 && this.iJi != null) {
                                this.oH = this.iJi.fA();
                            }
                            eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                            this.iJe.b(eVar);
                            a cfZ2 = a.cfZ();
                            if (cfZ2 != null) {
                                cfZ2.a(this.iJe);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.iJe.cgc().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.iJe.cgc().mNetErrorCode = -13;
                        if (this.oH <= 0 && this.iJi != null) {
                            this.oH = this.iJi.fA();
                        }
                        eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                        this.iJe.b(eVar);
                        a cfZ3 = a.cfZ();
                        if (cfZ3 != null) {
                            cfZ3.a(this.iJe);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.iJe.cgc().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.iJe.cgc().mNetErrorCode = -12;
                    if (this.oH <= 0 && this.iJi != null) {
                        this.oH = this.iJi.fA();
                    }
                    eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                    this.iJe.b(eVar);
                    a cfZ4 = a.cfZ();
                    if (cfZ4 != null) {
                        cfZ4.a(this.iJe);
                    }
                    z = true;
                }
                if (this.iJe.cgc().responseCode == 200) {
                    this.iJe.b(eVar);
                    if (this.oH <= 0 && this.iJi != null) {
                        this.oH = this.iJi.fA();
                    }
                    eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                    this.iJe.b(eVar);
                    a cfZ5 = a.cfZ();
                    if (cfZ5 != null) {
                        cfZ5.a(this.iJe);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.iJe.cgc().responseCode) + "|retryCount:" + i4;
                boolean K = K(this.iJe.cgc().responseCode);
                if (this.oH <= 0 && this.iJi != null) {
                    this.oH = this.iJi.fA();
                }
                eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                this.iJe.b(eVar);
                a cfZ6 = a.cfZ();
                if (cfZ6 != null) {
                    cfZ6.a(this.iJe);
                }
                z = K;
            } catch (Throwable th) {
                if (this.oH <= 0 && this.iJi != null) {
                    this.oH = this.iJi.fA();
                }
                eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                this.iJe.b(eVar);
                a cfZ7 = a.cfZ();
                if (cfZ7 != null) {
                    cfZ7.a(this.iJe);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [346=7, 347=7, 349=7, 350=14, 351=7, 352=7, 353=7, 354=7, 356=5] */
    private void d(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eH().eK().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eH().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eH().eI().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.iJe.cgc().pz && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.oV = i4 + 1;
            this.oS = i4;
            try {
                try {
                    try {
                        this.iJi = new b(this.iJe);
                        this.iJi.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.iJe.cgc().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.iJe.a(eVar);
                        if (this.oH <= 0 && this.iJi != null) {
                            this.oH = this.iJi.fA();
                        }
                        eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                        this.iJe.a(eVar);
                        a cfZ = a.cfZ();
                        if (cfZ != null && this.iJi != null && this.iJi.fD()) {
                            cfZ.a(this.iJe);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.iJe.cgc().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.iJe.a(eVar);
                        if (this.oH <= 0 && this.iJi != null) {
                            this.oH = this.iJi.fA();
                        }
                        eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                        this.iJe.a(eVar);
                        a cfZ2 = a.cfZ();
                        if (cfZ2 != null && this.iJi != null && this.iJi.fD()) {
                            cfZ2.a(this.iJe);
                        }
                    }
                } catch (SocketException e3) {
                    this.iJe.cgc().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.iJe.a(eVar);
                    if (this.oH <= 0 && this.iJi != null) {
                        this.oH = this.iJi.fA();
                    }
                    eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                    this.iJe.a(eVar);
                    a cfZ3 = a.cfZ();
                    if (cfZ3 != null && this.iJi != null && this.iJi.fD()) {
                        cfZ3.a(this.iJe);
                    }
                } catch (Throwable th) {
                    this.iJe.cgc().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.iJe.a(eVar);
                    if (this.oH <= 0 && this.iJi != null) {
                        this.oH = this.iJi.fA();
                    }
                    eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                    this.iJe.a(eVar);
                    a cfZ4 = a.cfZ();
                    if (cfZ4 != null && this.iJi != null && this.iJi.fD()) {
                        cfZ4.a(this.iJe);
                    }
                }
                if (this.iJe.cgc().responseCode == 200) {
                    if (this.oH <= 0 && this.iJi != null) {
                        this.oH = this.iJi.fA();
                    }
                    eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                    this.iJe.a(eVar);
                    a cfZ5 = a.cfZ();
                    if (cfZ5 == null || this.iJi == null || !this.iJi.fD()) {
                        return;
                    }
                    cfZ5.a(this.iJe);
                    return;
                }
                eVar.exception = String.valueOf(this.iJe.cgc().responseCode) + "|retryCount:" + i4;
                z = K(this.iJe.cgc().responseCode);
                this.iJe.a(eVar);
                if (this.oH <= 0 && this.iJi != null) {
                    this.oH = this.iJi.fA();
                }
                eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                this.iJe.a(eVar);
                a cfZ6 = a.cfZ();
                if (cfZ6 != null && this.iJi != null && this.iJi.fD()) {
                    cfZ6.a(this.iJe);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.oH <= 0 && this.iJi != null) {
                    this.oH = this.iJi.fA();
                }
                eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                this.iJe.a(eVar);
                a cfZ7 = a.cfZ();
                if (cfZ7 != null && this.iJi != null && this.iJi.fD()) {
                    cfZ7.a(this.iJe);
                }
                throw th2;
            }
        }
    }

    private boolean K(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void e(int i, int i2, int i3) {
        if (this.iJe.cgb().fN()) {
            d(i, i2, i3);
        } else {
            f(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [467=7, 468=7, 470=7, 471=14, 472=7, 473=7, 474=7, 475=7, 477=5] */
    private void f(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eH().eK().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eH().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eH().eI().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.iJe.cgc().pz && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.oS = i4;
            eVar.oV = i4 + 1;
            try {
                try {
                    try {
                        this.iJi = new b(this.iJe);
                        this.iJi.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.iJe.cgc().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.iJe.a(eVar);
                        if (this.oH <= 0 && this.iJi != null) {
                            this.oH = this.iJi.fA();
                        }
                        eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                        this.iJe.a(eVar);
                        a cfZ = a.cfZ();
                        if (cfZ != null) {
                            cfZ.a(this.iJe);
                        }
                    } catch (Throwable th) {
                        this.iJe.cgc().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.iJe.a(eVar);
                        if (this.oH <= 0 && this.iJi != null) {
                            this.oH = this.iJi.fA();
                        }
                        eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                        this.iJe.a(eVar);
                        a cfZ2 = a.cfZ();
                        if (cfZ2 != null) {
                            cfZ2.a(this.iJe);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.iJe.cgc().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.iJe.a(eVar);
                    if (this.oH <= 0 && this.iJi != null) {
                        this.oH = this.iJi.fA();
                    }
                    eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                    this.iJe.a(eVar);
                    a cfZ3 = a.cfZ();
                    if (cfZ3 != null) {
                        cfZ3.a(this.iJe);
                    }
                } catch (SocketException e3) {
                    this.iJe.cgc().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.iJe.a(eVar);
                    if (this.oH <= 0 && this.iJi != null) {
                        this.oH = this.iJi.fA();
                    }
                    eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                    this.iJe.a(eVar);
                    a cfZ4 = a.cfZ();
                    if (cfZ4 != null) {
                        cfZ4.a(this.iJe);
                    }
                }
                if (this.iJe.cgc().responseCode == 200) {
                    if (this.oH <= 0 && this.iJi != null) {
                        this.oH = this.iJi.fA();
                    }
                    eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                    this.iJe.a(eVar);
                    a cfZ5 = a.cfZ();
                    if (cfZ5 != null) {
                        cfZ5.a(this.iJe);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.iJe.cgc().responseCode) + "|retryCount:" + i4;
                z = K(this.iJe.cgc().responseCode);
                this.iJe.a(eVar);
                if (this.oH <= 0 && this.iJi != null) {
                    this.oH = this.iJi.fA();
                }
                eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                this.iJe.a(eVar);
                a cfZ6 = a.cfZ();
                if (cfZ6 != null) {
                    cfZ6.a(this.iJe);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.oH <= 0 && this.iJi != null) {
                    this.oH = this.iJi.fA();
                }
                eVar.oW = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fh().a(this.iJe.cgb().getUrl(), this.iJe.cgb().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.pd != null);
                this.iJe.a(eVar);
                a cfZ7 = a.cfZ();
                if (cfZ7 != null) {
                    cfZ7.a(this.iJe);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.iJi != null) {
            this.iJi.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.iJe == null) {
            return false;
        }
        return this.iJe.cgc().pz;
    }

    public void setCancel() {
        if (this.iJe != null) {
            this.iJe.cgc().pz = true;
        }
    }
}
