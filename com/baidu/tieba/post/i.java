package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class i implements com.baidu.tieba.j.f {
    private String eQG;
    private k fSD;

    public i(String str) {
        this.eQG = str;
        this.fSD = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void j(String str, int i, String str2) {
        if (rz(str)) {
            this.fSD.bhJ();
            this.fSD.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void k(String str, int i, String str2) {
        if (rz(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.fSD.bhJ();
                this.fSD.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.gl(i)));
                return;
            }
            this.fSD.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void l(String str, int i, String str2) {
        if (rz(str)) {
            this.fSD.bhJ();
            this.fSD.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (rz(str)) {
            this.fSD.bhJ();
            this.fSD.bhH();
            this.fSD.bhL();
            this.fSD.a(new com.baidu.tieba.m.d(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void pB(String str) {
        if (rz(str)) {
            this.fSD.bhL();
            this.fSD.a(new com.baidu.tieba.m.d(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void pC(String str) {
        if (rz(str)) {
            this.fSD.bhL();
            this.fSD.bhI();
            this.fSD.a(new com.baidu.tieba.m.d(HttpStatus.SC_UNAUTHORIZED, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void m(String str, int i, String str2) {
        if (rz(str)) {
            this.fSD.bhJ();
            this.fSD.bhH();
            this.fSD.bhL();
            this.fSD.a(new com.baidu.tieba.m.d(HttpStatus.SC_PAYMENT_REQUIRED, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void pD(String str) {
        if (rz(str)) {
            com.baidu.tieba.r.b.bvE().d(this.eQG, com.baidu.tieba.r.b.a(VideoPlatformStatic.MB(), this.fSD.aRY(), this.fSD.aRZ()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean pE(String str) {
        if (rz(str)) {
            return this.fSD.bhK();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean pF(String str) {
        return this.fSD.bhM();
    }

    @Override // com.baidu.tieba.j.f
    public void bz(String str, String str2) {
        if (rz(str)) {
            this.fSD.a(new com.baidu.tieba.m.d(HttpStatus.SC_SERVICE_UNAVAILABLE, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void bA(String str, String str2) {
        if (rz(str)) {
            this.fSD.a(new com.baidu.tieba.m.d(HttpStatus.SC_NOT_IMPLEMENTED, str2, -4399, ""));
        }
    }

    private boolean rz(String str) {
        return (!TextUtils.equals(this.eQG, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.eQG)) ? false : true;
    }
}
