package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes23.dex */
public class i implements com.baidu.tieba.k.f {
    private String mUuid;
    private k mhT;

    public i(String str) {
        this.mUuid = str;
        this.mhT = new k(str);
    }

    @Override // com.baidu.tieba.k.f
    public void p(String str, int i, String str2) {
        if (Qz(str)) {
            this.mhT.dvM();
            this.mhT.a(new com.baidu.tieba.n.c(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void q(String str, int i, String str2) {
        if (Qz(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.mhT.dvM();
                this.mhT.a(new com.baidu.tieba.n.c(i, str2, i, VideoPlatformStatic.sY(i)));
                return;
            }
            this.mhT.a(new com.baidu.tieba.n.c(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void r(String str, int i, String str2) {
        if (Qz(str)) {
            this.mhT.dvM();
            this.mhT.a(new com.baidu.tieba.n.c(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void e(String str, int i, int i2, String str2) {
        if (Qz(str)) {
            this.mhT.dvM();
            this.mhT.dvK();
            this.mhT.dvO();
            this.mhT.a(new com.baidu.tieba.n.c(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void Oq(String str) {
        if (Qz(str)) {
            this.mhT.dvO();
            this.mhT.a(new com.baidu.tieba.n.c(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void Or(String str) {
        if (Qz(str)) {
            this.mhT.dvO();
            this.mhT.dvL();
            this.mhT.a(new com.baidu.tieba.n.c(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void s(String str, int i, String str2) {
        if (Qz(str)) {
            this.mhT.dvM();
            this.mhT.dvK();
            this.mhT.dvO();
            this.mhT.a(new com.baidu.tieba.n.c(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void jF(String str) {
        if (Qz(str)) {
            com.baidu.tieba.u.b.dLp().t(this.mUuid, com.baidu.tieba.u.b.a(VideoPlatformStatic.bGo(), this.mhT.dbI(), this.mhT.dbK()));
        }
    }

    @Override // com.baidu.tieba.k.f
    public boolean Os(String str) {
        if (Qz(str)) {
            return this.mhT.dvN();
        }
        return false;
    }

    @Override // com.baidu.tieba.k.f
    public boolean Ot(String str) {
        return this.mhT.dvP();
    }

    @Override // com.baidu.tieba.k.f
    public void fI(String str, String str2) {
        if (Qz(str)) {
            this.mhT.a(new com.baidu.tieba.n.c(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void fJ(String str, String str2) {
        if (Qz(str)) {
            this.mhT.a(new com.baidu.tieba.n.c(501, str2, -4399, ""));
        }
    }

    private boolean Qz(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
