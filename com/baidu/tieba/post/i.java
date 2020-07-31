package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes17.dex */
public class i implements com.baidu.tieba.k.f {
    private k lgJ;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.lgJ = new k(str);
    }

    @Override // com.baidu.tieba.k.f
    public void o(String str, int i, String str2) {
        if (LR(str)) {
            this.lgJ.dag();
            this.lgJ.a(new com.baidu.tieba.n.c(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void p(String str, int i, String str2) {
        if (LR(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.lgJ.dag();
                this.lgJ.a(new com.baidu.tieba.n.c(i, str2, i, VideoPlatformStatic.pL(i)));
                return;
            }
            this.lgJ.a(new com.baidu.tieba.n.c(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void q(String str, int i, String str2) {
        if (LR(str)) {
            this.lgJ.dag();
            this.lgJ.a(new com.baidu.tieba.n.c(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void e(String str, int i, int i2, String str2) {
        if (LR(str)) {
            this.lgJ.dag();
            this.lgJ.dae();
            this.lgJ.dai();
            this.lgJ.a(new com.baidu.tieba.n.c(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void JI(String str) {
        if (LR(str)) {
            this.lgJ.dai();
            this.lgJ.a(new com.baidu.tieba.n.c(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void JJ(String str) {
        if (LR(str)) {
            this.lgJ.dai();
            this.lgJ.daf();
            this.lgJ.a(new com.baidu.tieba.n.c(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void r(String str, int i, String str2) {
        if (LR(str)) {
            this.lgJ.dag();
            this.lgJ.dae();
            this.lgJ.dai();
            this.lgJ.a(new com.baidu.tieba.n.c(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void gW(String str) {
        if (LR(str)) {
            com.baidu.tieba.u.b.doW().q(this.mUuid, com.baidu.tieba.u.b.a(VideoPlatformStatic.brz(), this.lgJ.cGv(), this.lgJ.cGx()));
        }
    }

    @Override // com.baidu.tieba.k.f
    public boolean JK(String str) {
        if (LR(str)) {
            return this.lgJ.dah();
        }
        return false;
    }

    @Override // com.baidu.tieba.k.f
    public boolean JL(String str) {
        return this.lgJ.daj();
    }

    @Override // com.baidu.tieba.k.f
    public void eR(String str, String str2) {
        if (LR(str)) {
            this.lgJ.a(new com.baidu.tieba.n.c(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void eS(String str, String str2) {
        if (LR(str)) {
            this.lgJ.a(new com.baidu.tieba.n.c(501, str2, -4399, ""));
        }
    }

    private boolean LR(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
