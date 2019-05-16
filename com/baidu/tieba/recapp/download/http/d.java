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
    private g iAs;
    private b iAw;
    private int An = 0;
    private long Ab = 0;

    public d(g gVar) {
        this.iAs = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int gi = i3 <= 0 ? com.baidu.adp.framework.c.b.ge().gh().gi() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ge().getRetryCount();
        }
        int gi2 = i4 <= 0 ? com.baidu.adp.framework.c.b.ge().gf().gi() : i4;
        this.iAw = new b(this.iAs);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.Ar = i5 + 1;
                this.An = i5;
                boolean a = this.iAw.a(str, jVar, gi, gi2, z, eVar, z2);
                com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                this.iAs.a(eVar);
                a ceX = a.ceX();
                if (ceX != null) {
                    ceX.a(this.iAs);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.iAs.cfa().responseCode = -100;
                    eVar.Au = String.valueOf(this.iAs.cfa().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.iAs.a(eVar);
                    com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                    this.iAs.a(eVar);
                    a ceX2 = a.ceX();
                    if (ceX2 != null) {
                        ceX2.a(this.iAs);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                    this.iAs.a(eVar);
                    a ceX3 = a.ceX();
                    if (ceX3 != null) {
                        ceX3.a(this.iAs);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.iAs.cfa().responseCode = -10;
                eVar.Au = String.valueOf(this.iAs.cfa().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.iAs.a(eVar);
                com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                this.iAs.a(eVar);
                a ceX4 = a.ceX();
                if (ceX4 != null) {
                    ceX4.a(this.iAs);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.ge().gh().gi();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ge().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ge().gf().gi();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.iAs.cfa().AK && z && i4 < i; i4++) {
            e eVar = new e();
            this.iAs.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.An = i4;
                                eVar.Ar = i4 + 1;
                                eVar.AB = 1;
                                this.iAw = new b(this.iAs);
                                this.iAw.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.iAs.cfa().AM = -19;
                                eVar.Au = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Ab <= 0 && this.iAw != null) {
                                    this.Ab = this.iAw.hW();
                                }
                                eVar.As = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                                this.iAs.b(eVar);
                                a ceX = a.ceX();
                                if (ceX != null) {
                                    ceX.a(this.iAs);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.Au = String.valueOf(this.iAs.cfa().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.iAs.cfa().AM = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Ab <= 0 && this.iAw != null) {
                                this.Ab = this.iAw.hW();
                            }
                            eVar.As = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                            this.iAs.b(eVar);
                            a ceX2 = a.ceX();
                            if (ceX2 != null) {
                                ceX2.a(this.iAs);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.Au = String.valueOf(this.iAs.cfa().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.iAs.cfa().AM = -13;
                        if (this.Ab <= 0 && this.iAw != null) {
                            this.Ab = this.iAw.hW();
                        }
                        eVar.As = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                        this.iAs.b(eVar);
                        a ceX3 = a.ceX();
                        if (ceX3 != null) {
                            ceX3.a(this.iAs);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.Au = String.valueOf(this.iAs.cfa().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.iAs.cfa().AM = -12;
                    if (this.Ab <= 0 && this.iAw != null) {
                        this.Ab = this.iAw.hW();
                    }
                    eVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                    this.iAs.b(eVar);
                    a ceX4 = a.ceX();
                    if (ceX4 != null) {
                        ceX4.a(this.iAs);
                    }
                    z = true;
                }
                if (this.iAs.cfa().responseCode == 200) {
                    this.iAs.b(eVar);
                    if (this.Ab <= 0 && this.iAw != null) {
                        this.Ab = this.iAw.hW();
                    }
                    eVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                    this.iAs.b(eVar);
                    a ceX5 = a.ceX();
                    if (ceX5 != null) {
                        ceX5.a(this.iAs);
                        return;
                    }
                    return;
                }
                eVar.Au = String.valueOf(this.iAs.cfa().responseCode) + "|retryCount:" + i4;
                boolean ab = ab(this.iAs.cfa().responseCode);
                if (this.Ab <= 0 && this.iAw != null) {
                    this.Ab = this.iAw.hW();
                }
                eVar.As = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                this.iAs.b(eVar);
                a ceX6 = a.ceX();
                if (ceX6 != null) {
                    ceX6.a(this.iAs);
                }
                z = ab;
            } catch (Throwable th) {
                if (this.Ab <= 0 && this.iAw != null) {
                    this.Ab = this.iAw.hW();
                }
                eVar.As = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                this.iAs.b(eVar);
                a ceX7 = a.ceX();
                if (ceX7 != null) {
                    ceX7.a(this.iAs);
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
            i2 = com.baidu.adp.framework.c.b.ge().gh().gi();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ge().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ge().gf().gi();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.iAs.cfa().AK && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.Ar = i4 + 1;
            this.An = i4;
            try {
                try {
                    try {
                        this.iAw = new b(this.iAs);
                        this.iAw.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.iAs.cfa().AM = -14;
                        eVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.iAs.a(eVar);
                        if (this.Ab <= 0 && this.iAw != null) {
                            this.Ab = this.iAw.hW();
                        }
                        eVar.As = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                        this.iAs.a(eVar);
                        a ceX = a.ceX();
                        if (ceX != null && this.iAw != null && this.iAw.hZ()) {
                            ceX.a(this.iAs);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.iAs.cfa().AM = -13;
                        z = true;
                        eVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.iAs.a(eVar);
                        if (this.Ab <= 0 && this.iAw != null) {
                            this.Ab = this.iAw.hW();
                        }
                        eVar.As = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                        this.iAs.a(eVar);
                        a ceX2 = a.ceX();
                        if (ceX2 != null && this.iAw != null && this.iAw.hZ()) {
                            ceX2.a(this.iAs);
                        }
                    }
                } catch (SocketException e3) {
                    this.iAs.cfa().AM = -12;
                    z = true;
                    eVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.iAs.a(eVar);
                    if (this.Ab <= 0 && this.iAw != null) {
                        this.Ab = this.iAw.hW();
                    }
                    eVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                    this.iAs.a(eVar);
                    a ceX3 = a.ceX();
                    if (ceX3 != null && this.iAw != null && this.iAw.hZ()) {
                        ceX3.a(this.iAs);
                    }
                } catch (Throwable th) {
                    this.iAs.cfa().AM = -10;
                    z = false;
                    eVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.iAs.a(eVar);
                    if (this.Ab <= 0 && this.iAw != null) {
                        this.Ab = this.iAw.hW();
                    }
                    eVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                    this.iAs.a(eVar);
                    a ceX4 = a.ceX();
                    if (ceX4 != null && this.iAw != null && this.iAw.hZ()) {
                        ceX4.a(this.iAs);
                    }
                }
                if (this.iAs.cfa().responseCode == 200) {
                    if (this.Ab <= 0 && this.iAw != null) {
                        this.Ab = this.iAw.hW();
                    }
                    eVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                    this.iAs.a(eVar);
                    a ceX5 = a.ceX();
                    if (ceX5 == null || this.iAw == null || !this.iAw.hZ()) {
                        return;
                    }
                    ceX5.a(this.iAs);
                    return;
                }
                eVar.Au = String.valueOf(this.iAs.cfa().responseCode) + "|retryCount:" + i4;
                z = ab(this.iAs.cfa().responseCode);
                this.iAs.a(eVar);
                if (this.Ab <= 0 && this.iAw != null) {
                    this.Ab = this.iAw.hW();
                }
                eVar.As = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                this.iAs.a(eVar);
                a ceX6 = a.ceX();
                if (ceX6 != null && this.iAw != null && this.iAw.hZ()) {
                    ceX6.a(this.iAs);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ab <= 0 && this.iAw != null) {
                    this.Ab = this.iAw.hW();
                }
                eVar.As = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                this.iAs.a(eVar);
                a ceX7 = a.ceX();
                if (ceX7 != null && this.iAw != null && this.iAw.hZ()) {
                    ceX7.a(this.iAs);
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
        if (this.iAs.ceZ().ip()) {
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
            i2 = com.baidu.adp.framework.c.b.ge().gh().gi();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ge().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ge().gf().gi();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.iAs.cfa().AK && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.An = i4;
            eVar.Ar = i4 + 1;
            try {
                try {
                    try {
                        this.iAw = new b(this.iAs);
                        this.iAw.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.iAs.cfa().AM = -13;
                        z = true;
                        eVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.iAs.a(eVar);
                        if (this.Ab <= 0 && this.iAw != null) {
                            this.Ab = this.iAw.hW();
                        }
                        eVar.As = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                        this.iAs.a(eVar);
                        a ceX = a.ceX();
                        if (ceX != null) {
                            ceX.a(this.iAs);
                        }
                    } catch (Throwable th) {
                        this.iAs.cfa().AM = -10;
                        z = false;
                        eVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.iAs.a(eVar);
                        if (this.Ab <= 0 && this.iAw != null) {
                            this.Ab = this.iAw.hW();
                        }
                        eVar.As = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                        this.iAs.a(eVar);
                        a ceX2 = a.ceX();
                        if (ceX2 != null) {
                            ceX2.a(this.iAs);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.iAs.cfa().AM = -14;
                    eVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.iAs.a(eVar);
                    if (this.Ab <= 0 && this.iAw != null) {
                        this.Ab = this.iAw.hW();
                    }
                    eVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                    this.iAs.a(eVar);
                    a ceX3 = a.ceX();
                    if (ceX3 != null) {
                        ceX3.a(this.iAs);
                    }
                } catch (SocketException e3) {
                    this.iAs.cfa().AM = -12;
                    z = true;
                    eVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.iAs.a(eVar);
                    if (this.Ab <= 0 && this.iAw != null) {
                        this.Ab = this.iAw.hW();
                    }
                    eVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                    this.iAs.a(eVar);
                    a ceX4 = a.ceX();
                    if (ceX4 != null) {
                        ceX4.a(this.iAs);
                    }
                }
                if (this.iAs.cfa().responseCode == 200) {
                    if (this.Ab <= 0 && this.iAw != null) {
                        this.Ab = this.iAw.hW();
                    }
                    eVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                    this.iAs.a(eVar);
                    a ceX5 = a.ceX();
                    if (ceX5 != null) {
                        ceX5.a(this.iAs);
                        return;
                    }
                    return;
                }
                eVar.Au = String.valueOf(this.iAs.cfa().responseCode) + "|retryCount:" + i4;
                z = ab(this.iAs.cfa().responseCode);
                this.iAs.a(eVar);
                if (this.Ab <= 0 && this.iAw != null) {
                    this.Ab = this.iAw.hW();
                }
                eVar.As = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                this.iAs.a(eVar);
                a ceX6 = a.ceX();
                if (ceX6 != null) {
                    ceX6.a(this.iAs);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ab <= 0 && this.iAw != null) {
                    this.Ab = this.iAw.hW();
                }
                eVar.As = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.iAs.ceZ().getUrl(), this.iAs.ceZ().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                this.iAs.a(eVar);
                a ceX7 = a.ceX();
                if (ceX7 != null) {
                    ceX7.a(this.iAs);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.iAw != null) {
            this.iAw.ia();
        }
    }

    public boolean ic() {
        if (this.iAs == null) {
            return false;
        }
        return this.iAs.cfa().AK;
    }

    public void ie() {
        if (this.iAs != null) {
            this.iAs.cfa().AK = true;
        }
    }
}
