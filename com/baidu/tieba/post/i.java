package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes4.dex */
public class i implements com.baidu.tieba.j.f {
    private String fEi;
    private k gGK;

    public i(String str) {
        this.fEi = str;
        this.gGK = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void h(String str, int i, String str2) {
        if (ue(str)) {
            this.gGK.bsK();
            this.gGK.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void i(String str, int i, String str2) {
        if (ue(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.gGK.bsK();
                this.gGK.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.hB(i)));
                return;
            }
            this.gGK.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void j(String str, int i, String str2) {
        if (ue(str)) {
            this.gGK.bsK();
            this.gGK.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (ue(str)) {
            this.gGK.bsK();
            this.gGK.bsI();
            this.gGK.bsM();
            this.gGK.a(new com.baidu.tieba.m.d(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void rW(String str) {
        if (ue(str)) {
            this.gGK.bsM();
            this.gGK.a(new com.baidu.tieba.m.d(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void rX(String str) {
        if (ue(str)) {
            this.gGK.bsM();
            this.gGK.bsJ();
            this.gGK.a(new com.baidu.tieba.m.d(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void k(String str, int i, String str2) {
        if (ue(str)) {
            this.gGK.bsK();
            this.gGK.bsI();
            this.gGK.bsM();
            this.gGK.a(new com.baidu.tieba.m.d(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void ds(String str) {
        if (ue(str)) {
            com.baidu.tieba.s.b.bHs().g(this.fEi, com.baidu.tieba.s.b.a(VideoPlatformStatic.VG(), this.gGK.bcE(), this.gGK.bcG()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean rY(String str) {
        if (ue(str)) {
            return this.gGK.bsL();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean rZ(String str) {
        return this.gGK.bsN();
    }

    @Override // com.baidu.tieba.j.f
    public void cg(String str, String str2) {
        if (ue(str)) {
            this.gGK.a(new com.baidu.tieba.m.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void ch(String str, String str2) {
        if (ue(str)) {
            this.gGK.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean ue(String str) {
        return (!TextUtils.equals(this.fEi, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.fEi)) ? false : true;
    }
}
