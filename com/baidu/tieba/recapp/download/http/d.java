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
    private g iAu;
    private b iAy;
    private int An = 0;
    private long Ab = 0;

    public d(g gVar) {
        this.iAu = gVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int gi = i3 <= 0 ? com.baidu.adp.framework.c.b.ge().gh().gi() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ge().getRetryCount();
        }
        int gi2 = i4 <= 0 ? com.baidu.adp.framework.c.b.ge().gf().gi() : i4;
        this.iAy = new b(this.iAu);
        for (int i5 = 0; i5 < i; i5++) {
            e eVar = new e();
            try {
                eVar.Ar = i5 + 1;
                this.An = i5;
                boolean a = this.iAy.a(str, jVar, gi, gi2, z, eVar, z2);
                com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                this.iAu.a(eVar);
                a ceZ = a.ceZ();
                if (ceZ != null) {
                    ceZ.a(this.iAu);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.iAu.cfc().responseCode = -100;
                    eVar.Au = String.valueOf(this.iAu.cfc().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.iAu.a(eVar);
                    com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                    this.iAu.a(eVar);
                    a ceZ2 = a.ceZ();
                    if (ceZ2 != null) {
                        ceZ2.a(this.iAu);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                    this.iAu.a(eVar);
                    a ceZ3 = a.ceZ();
                    if (ceZ3 != null) {
                        ceZ3.a(this.iAu);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.iAu.cfc().responseCode = -10;
                eVar.Au = String.valueOf(this.iAu.cfc().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.iAu.a(eVar);
                com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                this.iAu.a(eVar);
                a ceZ4 = a.ceZ();
                if (ceZ4 != null) {
                    ceZ4.a(this.iAu);
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
        for (int i4 = 0; !this.iAu.cfc().AK && z && i4 < i; i4++) {
            e eVar = new e();
            this.iAu.a(eVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.An = i4;
                                eVar.Ar = i4 + 1;
                                eVar.AB = 1;
                                this.iAy = new b(this.iAu);
                                this.iAy.a(i2, i3, eVar);
                            } catch (IllegalStateException e) {
                                this.iAu.cfc().AM = -19;
                                eVar.Au = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Ab <= 0 && this.iAy != null) {
                                    this.Ab = this.iAy.hW();
                                }
                                eVar.As = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                                this.iAu.b(eVar);
                                a ceZ = a.ceZ();
                                if (ceZ != null) {
                                    ceZ.a(this.iAu);
                                }
                            }
                        } catch (Exception e2) {
                            eVar.Au = String.valueOf(this.iAu.cfc().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.iAu.cfc().AM = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Ab <= 0 && this.iAy != null) {
                                this.Ab = this.iAy.hW();
                            }
                            eVar.As = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                            this.iAu.b(eVar);
                            a ceZ2 = a.ceZ();
                            if (ceZ2 != null) {
                                ceZ2.a(this.iAu);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        eVar.Au = String.valueOf(this.iAu.cfc().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.iAu.cfc().AM = -13;
                        if (this.Ab <= 0 && this.iAy != null) {
                            this.Ab = this.iAy.hW();
                        }
                        eVar.As = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                        this.iAu.b(eVar);
                        a ceZ3 = a.ceZ();
                        if (ceZ3 != null) {
                            ceZ3.a(this.iAu);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    eVar.Au = String.valueOf(this.iAu.cfc().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.iAu.cfc().AM = -12;
                    if (this.Ab <= 0 && this.iAy != null) {
                        this.Ab = this.iAy.hW();
                    }
                    eVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                    this.iAu.b(eVar);
                    a ceZ4 = a.ceZ();
                    if (ceZ4 != null) {
                        ceZ4.a(this.iAu);
                    }
                    z = true;
                }
                if (this.iAu.cfc().responseCode == 200) {
                    this.iAu.b(eVar);
                    if (this.Ab <= 0 && this.iAy != null) {
                        this.Ab = this.iAy.hW();
                    }
                    eVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                    this.iAu.b(eVar);
                    a ceZ5 = a.ceZ();
                    if (ceZ5 != null) {
                        ceZ5.a(this.iAu);
                        return;
                    }
                    return;
                }
                eVar.Au = String.valueOf(this.iAu.cfc().responseCode) + "|retryCount:" + i4;
                boolean ab = ab(this.iAu.cfc().responseCode);
                if (this.Ab <= 0 && this.iAy != null) {
                    this.Ab = this.iAy.hW();
                }
                eVar.As = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                this.iAu.b(eVar);
                a ceZ6 = a.ceZ();
                if (ceZ6 != null) {
                    ceZ6.a(this.iAu);
                }
                z = ab;
            } catch (Throwable th) {
                if (this.Ab <= 0 && this.iAy != null) {
                    this.Ab = this.iAy.hW();
                }
                eVar.As = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                this.iAu.b(eVar);
                a ceZ7 = a.ceZ();
                if (ceZ7 != null) {
                    ceZ7.a(this.iAu);
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
        for (int i4 = 0; !this.iAu.cfc().AK && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.Ar = i4 + 1;
            this.An = i4;
            try {
                try {
                    try {
                        this.iAy = new b(this.iAu);
                        this.iAy.b(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.iAu.cfc().AM = -14;
                        eVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.iAu.a(eVar);
                        if (this.Ab <= 0 && this.iAy != null) {
                            this.Ab = this.iAy.hW();
                        }
                        eVar.As = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                        this.iAu.a(eVar);
                        a ceZ = a.ceZ();
                        if (ceZ != null && this.iAy != null && this.iAy.hZ()) {
                            ceZ.a(this.iAu);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.iAu.cfc().AM = -13;
                        z = true;
                        eVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.iAu.a(eVar);
                        if (this.Ab <= 0 && this.iAy != null) {
                            this.Ab = this.iAy.hW();
                        }
                        eVar.As = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                        this.iAu.a(eVar);
                        a ceZ2 = a.ceZ();
                        if (ceZ2 != null && this.iAy != null && this.iAy.hZ()) {
                            ceZ2.a(this.iAu);
                        }
                    }
                } catch (SocketException e3) {
                    this.iAu.cfc().AM = -12;
                    z = true;
                    eVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.iAu.a(eVar);
                    if (this.Ab <= 0 && this.iAy != null) {
                        this.Ab = this.iAy.hW();
                    }
                    eVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                    this.iAu.a(eVar);
                    a ceZ3 = a.ceZ();
                    if (ceZ3 != null && this.iAy != null && this.iAy.hZ()) {
                        ceZ3.a(this.iAu);
                    }
                } catch (Throwable th) {
                    this.iAu.cfc().AM = -10;
                    z = false;
                    eVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.iAu.a(eVar);
                    if (this.Ab <= 0 && this.iAy != null) {
                        this.Ab = this.iAy.hW();
                    }
                    eVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                    this.iAu.a(eVar);
                    a ceZ4 = a.ceZ();
                    if (ceZ4 != null && this.iAy != null && this.iAy.hZ()) {
                        ceZ4.a(this.iAu);
                    }
                }
                if (this.iAu.cfc().responseCode == 200) {
                    if (this.Ab <= 0 && this.iAy != null) {
                        this.Ab = this.iAy.hW();
                    }
                    eVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                    this.iAu.a(eVar);
                    a ceZ5 = a.ceZ();
                    if (ceZ5 == null || this.iAy == null || !this.iAy.hZ()) {
                        return;
                    }
                    ceZ5.a(this.iAu);
                    return;
                }
                eVar.Au = String.valueOf(this.iAu.cfc().responseCode) + "|retryCount:" + i4;
                z = ab(this.iAu.cfc().responseCode);
                this.iAu.a(eVar);
                if (this.Ab <= 0 && this.iAy != null) {
                    this.Ab = this.iAy.hW();
                }
                eVar.As = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                this.iAu.a(eVar);
                a ceZ6 = a.ceZ();
                if (ceZ6 != null && this.iAy != null && this.iAy.hZ()) {
                    ceZ6.a(this.iAu);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ab <= 0 && this.iAy != null) {
                    this.Ab = this.iAy.hW();
                }
                eVar.As = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                this.iAu.a(eVar);
                a ceZ7 = a.ceZ();
                if (ceZ7 != null && this.iAy != null && this.iAy.hZ()) {
                    ceZ7.a(this.iAu);
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
        if (this.iAu.cfb().ip()) {
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
        for (int i4 = 0; !this.iAu.cfc().AK && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.An = i4;
            eVar.Ar = i4 + 1;
            try {
                try {
                    try {
                        this.iAy = new b(this.iAu);
                        this.iAy.c(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        this.iAu.cfc().AM = -13;
                        z = true;
                        eVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.iAu.a(eVar);
                        if (this.Ab <= 0 && this.iAy != null) {
                            this.Ab = this.iAy.hW();
                        }
                        eVar.As = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                        this.iAu.a(eVar);
                        a ceZ = a.ceZ();
                        if (ceZ != null) {
                            ceZ.a(this.iAu);
                        }
                    } catch (Throwable th) {
                        this.iAu.cfc().AM = -10;
                        z = false;
                        eVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.iAu.a(eVar);
                        if (this.Ab <= 0 && this.iAy != null) {
                            this.Ab = this.iAy.hW();
                        }
                        eVar.As = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                        this.iAu.a(eVar);
                        a ceZ2 = a.ceZ();
                        if (ceZ2 != null) {
                            ceZ2.a(this.iAu);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.iAu.cfc().AM = -14;
                    eVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.iAu.a(eVar);
                    if (this.Ab <= 0 && this.iAy != null) {
                        this.Ab = this.iAy.hW();
                    }
                    eVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                    this.iAu.a(eVar);
                    a ceZ3 = a.ceZ();
                    if (ceZ3 != null) {
                        ceZ3.a(this.iAu);
                    }
                } catch (SocketException e3) {
                    this.iAu.cfc().AM = -12;
                    z = true;
                    eVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.iAu.a(eVar);
                    if (this.Ab <= 0 && this.iAy != null) {
                        this.Ab = this.iAy.hW();
                    }
                    eVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                    this.iAu.a(eVar);
                    a ceZ4 = a.ceZ();
                    if (ceZ4 != null) {
                        ceZ4.a(this.iAu);
                    }
                }
                if (this.iAu.cfc().responseCode == 200) {
                    if (this.Ab <= 0 && this.iAy != null) {
                        this.Ab = this.iAy.hW();
                    }
                    eVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                    this.iAu.a(eVar);
                    a ceZ5 = a.ceZ();
                    if (ceZ5 != null) {
                        ceZ5.a(this.iAu);
                        return;
                    }
                    return;
                }
                eVar.Au = String.valueOf(this.iAu.cfc().responseCode) + "|retryCount:" + i4;
                z = ab(this.iAu.cfc().responseCode);
                this.iAu.a(eVar);
                if (this.Ab <= 0 && this.iAy != null) {
                    this.Ab = this.iAy.hW();
                }
                eVar.As = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                this.iAu.a(eVar);
                a ceZ6 = a.ceZ();
                if (ceZ6 != null) {
                    ceZ6.a(this.iAu);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ab <= 0 && this.iAy != null) {
                    this.Ab = this.iAy.hW();
                }
                eVar.As = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.iAu.cfb().getUrl(), this.iAu.cfb().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(eVar.Au), eVar.Ay != null);
                this.iAu.a(eVar);
                a ceZ7 = a.ceZ();
                if (ceZ7 != null) {
                    ceZ7.a(this.iAu);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.iAy != null) {
            this.iAy.ia();
        }
    }

    public boolean ic() {
        if (this.iAu == null) {
            return false;
        }
        return this.iAu.cfc().AK;
    }

    public void ie() {
        if (this.iAu != null) {
            this.iAu.cfc().AK = true;
        }
    }
}
