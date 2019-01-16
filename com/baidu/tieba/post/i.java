package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes4.dex */
public class i implements com.baidu.tieba.j.f {
    private String fHU;
    private k gKF;

    public i(String str) {
        this.fHU = str;
        this.gKF = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void h(String str, int i, String str2) {
        if (ux(str)) {
            this.gKF.buf();
            this.gKF.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void i(String str, int i, String str2) {
        if (ux(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.gKF.buf();
                this.gKF.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.hC(i)));
                return;
            }
            this.gKF.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void j(String str, int i, String str2) {
        if (ux(str)) {
            this.gKF.buf();
            this.gKF.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (ux(str)) {
            this.gKF.buf();
            this.gKF.bud();
            this.gKF.buh();
            this.gKF.a(new com.baidu.tieba.m.d(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void sp(String str) {
        if (ux(str)) {
            this.gKF.buh();
            this.gKF.a(new com.baidu.tieba.m.d(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void sq(String str) {
        if (ux(str)) {
            this.gKF.buh();
            this.gKF.bue();
            this.gKF.a(new com.baidu.tieba.m.d(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void k(String str, int i, String str2) {
        if (ux(str)) {
            this.gKF.buf();
            this.gKF.bud();
            this.gKF.buh();
            this.gKF.a(new com.baidu.tieba.m.d(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void dt(String str) {
        if (ux(str)) {
            com.baidu.tieba.t.b.bIR().h(this.fHU, com.baidu.tieba.t.b.a(VideoPlatformStatic.We(), this.gKF.bdS(), this.gKF.bdU()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean ss(String str) {
        if (ux(str)) {
            return this.gKF.bug();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean st(String str) {
        return this.gKF.bui();
    }

    @Override // com.baidu.tieba.j.f
    public void ch(String str, String str2) {
        if (ux(str)) {
            this.gKF.a(new com.baidu.tieba.m.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void ci(String str, String str2) {
        if (ux(str)) {
            this.gKF.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean ux(String str) {
        return (!TextUtils.equals(this.fHU, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.fHU)) ? false : true;
    }
}
