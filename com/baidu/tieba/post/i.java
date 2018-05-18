package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class i implements com.baidu.tieba.j.f {
    private String eRN;
    private k fTJ;

    public i(String str) {
        this.eRN = str;
        this.fTJ = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void j(String str, int i, String str2) {
        if (rC(str)) {
            this.fTJ.bhJ();
            this.fTJ.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void k(String str, int i, String str2) {
        if (rC(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.fTJ.bhJ();
                this.fTJ.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.gm(i)));
                return;
            }
            this.fTJ.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void l(String str, int i, String str2) {
        if (rC(str)) {
            this.fTJ.bhJ();
            this.fTJ.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (rC(str)) {
            this.fTJ.bhJ();
            this.fTJ.bhH();
            this.fTJ.bhL();
            this.fTJ.a(new com.baidu.tieba.m.d(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void pE(String str) {
        if (rC(str)) {
            this.fTJ.bhL();
            this.fTJ.a(new com.baidu.tieba.m.d(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void pF(String str) {
        if (rC(str)) {
            this.fTJ.bhL();
            this.fTJ.bhI();
            this.fTJ.a(new com.baidu.tieba.m.d(HttpStatus.SC_UNAUTHORIZED, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void m(String str, int i, String str2) {
        if (rC(str)) {
            this.fTJ.bhJ();
            this.fTJ.bhH();
            this.fTJ.bhL();
            this.fTJ.a(new com.baidu.tieba.m.d(HttpStatus.SC_PAYMENT_REQUIRED, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void pG(String str) {
        if (rC(str)) {
            com.baidu.tieba.r.b.bvC().d(this.eRN, com.baidu.tieba.r.b.a(VideoPlatformStatic.Mz(), this.fTJ.aRY(), this.fTJ.aRZ()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean pH(String str) {
        if (rC(str)) {
            return this.fTJ.bhK();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean pI(String str) {
        return this.fTJ.bhM();
    }

    @Override // com.baidu.tieba.j.f
    public void bz(String str, String str2) {
        if (rC(str)) {
            this.fTJ.a(new com.baidu.tieba.m.d(HttpStatus.SC_SERVICE_UNAVAILABLE, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void bA(String str, String str2) {
        if (rC(str)) {
            this.fTJ.a(new com.baidu.tieba.m.d(HttpStatus.SC_NOT_IMPLEMENTED, str2, -4399, ""));
        }
    }

    private boolean rC(String str) {
        return (!TextUtils.equals(this.eRN, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.eRN)) ? false : true;
    }
}
