package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes22.dex */
public class i implements com.baidu.tieba.l.f {
    private String mUuid;
    private k mol;

    public i(String str) {
        this.mUuid = str;
        this.mol = new k(str);
    }

    @Override // com.baidu.tieba.l.f
    public void q(String str, int i, String str2) {
        if (Ql(str)) {
            this.mol.dxO();
            this.mol.a(new com.baidu.tieba.o.c(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void r(String str, int i, String str2) {
        if (Ql(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.mol.dxO();
                this.mol.a(new com.baidu.tieba.o.c(i, str2, i, VideoPlatformStatic.tG(i)));
                return;
            }
            this.mol.a(new com.baidu.tieba.o.c(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void s(String str, int i, String str2) {
        if (Ql(str)) {
            this.mol.dxO();
            this.mol.a(new com.baidu.tieba.o.c(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void e(String str, int i, int i2, String str2) {
        if (Ql(str)) {
            this.mol.dxO();
            this.mol.dxM();
            this.mol.dxQ();
            this.mol.a(new com.baidu.tieba.o.c(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void Od(String str) {
        if (Ql(str)) {
            this.mol.dxQ();
            this.mol.a(new com.baidu.tieba.o.c(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void Oe(String str) {
        if (Ql(str)) {
            this.mol.dxQ();
            this.mol.dxN();
            this.mol.a(new com.baidu.tieba.o.c(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void t(String str, int i, String str2) {
        if (Ql(str)) {
            this.mol.dxO();
            this.mol.dxM();
            this.mol.dxQ();
            this.mol.a(new com.baidu.tieba.o.c(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void jM(String str) {
        if (Ql(str)) {
            com.baidu.tieba.v.b.dNQ().t(this.mUuid, com.baidu.tieba.v.b.a(VideoPlatformStatic.bIh(), this.mol.ddH(), this.mol.ddJ()));
        }
    }

    @Override // com.baidu.tieba.l.f
    public boolean Of(String str) {
        if (Ql(str)) {
            return this.mol.dxP();
        }
        return false;
    }

    @Override // com.baidu.tieba.l.f
    public boolean Og(String str) {
        return this.mol.dxR();
    }

    @Override // com.baidu.tieba.l.f
    public void fI(String str, String str2) {
        if (Ql(str)) {
            this.mol.a(new com.baidu.tieba.o.c(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void fJ(String str, String str2) {
        if (Ql(str)) {
            this.mol.a(new com.baidu.tieba.o.c(501, str2, -4399, ""));
        }
    }

    private boolean Ql(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
