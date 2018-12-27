package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes4.dex */
public class i implements com.baidu.tieba.j.f {
    private String fHa;
    private k gJB;

    public i(String str) {
        this.fHa = str;
        this.gJB = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void h(String str, int i, String str2) {
        if (uh(str)) {
            this.gJB.btw();
            this.gJB.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void i(String str, int i, String str2) {
        if (uh(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.gJB.btw();
                this.gJB.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.hC(i)));
                return;
            }
            this.gJB.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void j(String str, int i, String str2) {
        if (uh(str)) {
            this.gJB.btw();
            this.gJB.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (uh(str)) {
            this.gJB.btw();
            this.gJB.btu();
            this.gJB.bty();
            this.gJB.a(new com.baidu.tieba.m.d(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void rZ(String str) {
        if (uh(str)) {
            this.gJB.bty();
            this.gJB.a(new com.baidu.tieba.m.d(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void sa(String str) {
        if (uh(str)) {
            this.gJB.bty();
            this.gJB.btv();
            this.gJB.a(new com.baidu.tieba.m.d(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void k(String str, int i, String str2) {
        if (uh(str)) {
            this.gJB.btw();
            this.gJB.btu();
            this.gJB.bty();
            this.gJB.a(new com.baidu.tieba.m.d(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void ds(String str) {
        if (uh(str)) {
            com.baidu.tieba.t.b.bIi().g(this.fHa, com.baidu.tieba.t.b.a(VideoPlatformStatic.VI(), this.gJB.bds(), this.gJB.bdu()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean sb(String str) {
        if (uh(str)) {
            return this.gJB.btx();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean sc(String str) {
        return this.gJB.btz();
    }

    @Override // com.baidu.tieba.j.f
    public void cg(String str, String str2) {
        if (uh(str)) {
            this.gJB.a(new com.baidu.tieba.m.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void ch(String str, String str2) {
        if (uh(str)) {
            this.gJB.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean uh(String str) {
        return (!TextUtils.equals(this.fHa, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.fHa)) ? false : true;
    }
}
