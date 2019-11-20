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
    private g iIn;
    private b iIr;
    private int ot = 0;
    private long of = 0;

    public d(g gVar) {
        this.iIn = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.c.b.eH().eK().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eH().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.c.b.eH().eI().getTimeOutAuto() : i4;
        this.iIr = new b(this.iIn);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.ow = i5 + 1;
                this.ot = i5;
                boolean a = this.iIr.a(str, jVar, timeOutAuto, timeOutAuto2, z, eVar, z2);
                com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                this.iIn.a(eVar);
                a cfX = a.cfX();
                if (cfX != null) {
                    cfX.a(this.iIn);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.iIn.cga().responseCode = -100;
                    eVar.exception = String.valueOf(this.iIn.cga().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.iIn.a(eVar);
                    com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                    this.iIn.a(eVar);
                    a cfX2 = a.cfX();
                    if (cfX2 != null) {
                        cfX2.a(this.iIn);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                    this.iIn.a(eVar);
                    a cfX3 = a.cfX();
                    if (cfX3 != null) {
                        cfX3.a(this.iIn);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.iIn.cga().responseCode = -10;
                eVar.exception = String.valueOf(this.iIn.cga().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.iIn.a(eVar);
                com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                this.iIn.a(eVar);
                a cfX4 = a.cfX();
                if (cfX4 != null) {
                    cfX4.a(this.iIn);
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
        for (int i4 = 0; !this.iIn.cga().oT && z && i4 < i; i4++) {
            e eVar = new e();
            this.iIn.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.ot = i4;
                                eVar.ow = i4 + 1;
                                eVar.oG = 1;
                                this.iIr = new b(this.iIn);
                                this.iIr.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.iIn.cga().mNetErrorCode = -19;
                                eVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.of <= 0 && this.iIr != null) {
                                    this.of = this.iIr.fA();
                                }
                                eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                                this.iIn.b(eVar);
                                a cfX = a.cfX();
                                if (cfX != null) {
                                    cfX.a(this.iIn);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.exception = String.valueOf(this.iIn.cga().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.iIn.cga().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.of <= 0 && this.iIr != null) {
                                this.of = this.iIr.fA();
                            }
                            eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                            this.iIn.b(eVar);
                            a cfX2 = a.cfX();
                            if (cfX2 != null) {
                                cfX2.a(this.iIn);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.exception = String.valueOf(this.iIn.cga().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.iIn.cga().mNetErrorCode = -13;
                        if (this.of <= 0 && this.iIr != null) {
                            this.of = this.iIr.fA();
                        }
                        eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                        this.iIn.b(eVar);
                        a cfX3 = a.cfX();
                        if (cfX3 != null) {
                            cfX3.a(this.iIn);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.exception = String.valueOf(this.iIn.cga().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.iIn.cga().mNetErrorCode = -12;
                    if (this.of <= 0 && this.iIr != null) {
                        this.of = this.iIr.fA();
                    }
                    eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                    this.iIn.b(eVar);
                    a cfX4 = a.cfX();
                    if (cfX4 != null) {
                        cfX4.a(this.iIn);
                    }
                    z = true;
                }
                if (this.iIn.cga().responseCode == 200) {
                    this.iIn.b(eVar);
                    if (this.of <= 0 && this.iIr != null) {
                        this.of = this.iIr.fA();
                    }
                    eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                    this.iIn.b(eVar);
                    a cfX5 = a.cfX();
                    if (cfX5 != null) {
                        cfX5.a(this.iIn);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.iIn.cga().responseCode) + "|retryCount:" + i4;
                boolean K = K(this.iIn.cga().responseCode);
                if (this.of <= 0 && this.iIr != null) {
                    this.of = this.iIr.fA();
                }
                eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                this.iIn.b(eVar);
                a cfX6 = a.cfX();
                if (cfX6 != null) {
                    cfX6.a(this.iIn);
                }
                z = K;
            } catch (Throwable th) {
                if (this.of <= 0 && this.iIr != null) {
                    this.of = this.iIr.fA();
                }
                eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                this.iIn.b(eVar);
                a cfX7 = a.cfX();
                if (cfX7 != null) {
                    cfX7.a(this.iIn);
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
        for (int i4 = 0; !this.iIn.cga().oT && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.ow = i4 + 1;
            this.ot = i4;
            try {
                try {
                    try {
                        this.iIr = new b(this.iIn);
                        this.iIr.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.iIn.cga().mNetErrorCode = -14;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.iIn.a(eVar);
                        if (this.of <= 0 && this.iIr != null) {
                            this.of = this.iIr.fA();
                        }
                        eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                        this.iIn.a(eVar);
                        a cfX = a.cfX();
                        if (cfX != null && this.iIr != null && this.iIr.fD()) {
                            cfX.a(this.iIn);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.iIn.cga().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.iIn.a(eVar);
                        if (this.of <= 0 && this.iIr != null) {
                            this.of = this.iIr.fA();
                        }
                        eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                        this.iIn.a(eVar);
                        a cfX2 = a.cfX();
                        if (cfX2 != null && this.iIr != null && this.iIr.fD()) {
                            cfX2.a(this.iIn);
                        }
                    }
                } catch (SocketException e3) {
                    this.iIn.cga().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.iIn.a(eVar);
                    if (this.of <= 0 && this.iIr != null) {
                        this.of = this.iIr.fA();
                    }
                    eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                    this.iIn.a(eVar);
                    a cfX3 = a.cfX();
                    if (cfX3 != null && this.iIr != null && this.iIr.fD()) {
                        cfX3.a(this.iIn);
                    }
                } catch (Throwable th) {
                    this.iIn.cga().mNetErrorCode = -10;
                    z = false;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.iIn.a(eVar);
                    if (this.of <= 0 && this.iIr != null) {
                        this.of = this.iIr.fA();
                    }
                    eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                    this.iIn.a(eVar);
                    a cfX4 = a.cfX();
                    if (cfX4 != null && this.iIr != null && this.iIr.fD()) {
                        cfX4.a(this.iIn);
                    }
                }
                if (this.iIn.cga().responseCode == 200) {
                    if (this.of <= 0 && this.iIr != null) {
                        this.of = this.iIr.fA();
                    }
                    eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                    this.iIn.a(eVar);
                    a cfX5 = a.cfX();
                    if (cfX5 == null || this.iIr == null || !this.iIr.fD()) {
                        return;
                    }
                    cfX5.a(this.iIn);
                    return;
                }
                eVar.exception = String.valueOf(this.iIn.cga().responseCode) + "|retryCount:" + i4;
                z = K(this.iIn.cga().responseCode);
                this.iIn.a(eVar);
                if (this.of <= 0 && this.iIr != null) {
                    this.of = this.iIr.fA();
                }
                eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                this.iIn.a(eVar);
                a cfX6 = a.cfX();
                if (cfX6 != null && this.iIr != null && this.iIr.fD()) {
                    cfX6.a(this.iIn);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.of <= 0 && this.iIr != null) {
                    this.of = this.iIr.fA();
                }
                eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                this.iIn.a(eVar);
                a cfX7 = a.cfX();
                if (cfX7 != null && this.iIr != null && this.iIr.fD()) {
                    cfX7.a(this.iIn);
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
        if (this.iIn.cfZ().fN()) {
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
        for (int i4 = 0; !this.iIn.cga().oT && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.ot = i4;
            eVar.ow = i4 + 1;
            try {
                try {
                    try {
                        this.iIr = new b(this.iIn);
                        this.iIr.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.iIn.cga().mNetErrorCode = -13;
                        z = true;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.iIn.a(eVar);
                        if (this.of <= 0 && this.iIr != null) {
                            this.of = this.iIr.fA();
                        }
                        eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                        this.iIn.a(eVar);
                        a cfX = a.cfX();
                        if (cfX != null) {
                            cfX.a(this.iIn);
                        }
                    } catch (Throwable th) {
                        this.iIn.cga().mNetErrorCode = -10;
                        z = false;
                        eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.iIn.a(eVar);
                        if (this.of <= 0 && this.iIr != null) {
                            this.of = this.iIr.fA();
                        }
                        eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                        this.iIn.a(eVar);
                        a cfX2 = a.cfX();
                        if (cfX2 != null) {
                            cfX2.a(this.iIn);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.iIn.cga().mNetErrorCode = -14;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.iIn.a(eVar);
                    if (this.of <= 0 && this.iIr != null) {
                        this.of = this.iIr.fA();
                    }
                    eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                    this.iIn.a(eVar);
                    a cfX3 = a.cfX();
                    if (cfX3 != null) {
                        cfX3.a(this.iIn);
                    }
                } catch (SocketException e3) {
                    this.iIn.cga().mNetErrorCode = -12;
                    z = true;
                    eVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.iIn.a(eVar);
                    if (this.of <= 0 && this.iIr != null) {
                        this.of = this.iIr.fA();
                    }
                    eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                    this.iIn.a(eVar);
                    a cfX4 = a.cfX();
                    if (cfX4 != null) {
                        cfX4.a(this.iIn);
                    }
                }
                if (this.iIn.cga().responseCode == 200) {
                    if (this.of <= 0 && this.iIr != null) {
                        this.of = this.iIr.fA();
                    }
                    eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                    this.iIn.a(eVar);
                    a cfX5 = a.cfX();
                    if (cfX5 != null) {
                        cfX5.a(this.iIn);
                        return;
                    }
                    return;
                }
                eVar.exception = String.valueOf(this.iIn.cga().responseCode) + "|retryCount:" + i4;
                z = K(this.iIn.cga().responseCode);
                this.iIn.a(eVar);
                if (this.of <= 0 && this.iIr != null) {
                    this.of = this.iIr.fA();
                }
                eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                this.iIn.a(eVar);
                a cfX6 = a.cfX();
                if (cfX6 != null) {
                    cfX6.a(this.iIn);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.of <= 0 && this.iIr != null) {
                    this.of = this.iIr.fA();
                }
                eVar.ox = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fh().a(this.iIn.cfZ().getUrl(), this.iIn.cfZ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.exception), eVar.oC != null);
                this.iIn.a(eVar);
                a cfX7 = a.cfX();
                if (cfX7 != null) {
                    cfX7.a(this.iIn);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.iIr != null) {
            this.iIr.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.iIn == null) {
            return false;
        }
        return this.iIn.cga().oT;
    }

    public void setCancel() {
        if (this.iIn != null) {
            this.iIn.cga().oT = true;
        }
    }
}
