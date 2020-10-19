package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes23.dex */
public class i implements com.baidu.tieba.k.f {
    private k lVu;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.lVu = new k(str);
    }

    @Override // com.baidu.tieba.k.f
    public void p(String str, int i, String str2) {
        if (Qb(str)) {
            this.lVu.dsF();
            this.lVu.a(new com.baidu.tieba.n.c(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void q(String str, int i, String str2) {
        if (Qb(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.lVu.dsF();
                this.lVu.a(new com.baidu.tieba.n.c(i, str2, i, VideoPlatformStatic.sN(i)));
                return;
            }
            this.lVu.a(new com.baidu.tieba.n.c(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void r(String str, int i, String str2) {
        if (Qb(str)) {
            this.lVu.dsF();
            this.lVu.a(new com.baidu.tieba.n.c(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void e(String str, int i, int i2, String str2) {
        if (Qb(str)) {
            this.lVu.dsF();
            this.lVu.dsD();
            this.lVu.dsH();
            this.lVu.a(new com.baidu.tieba.n.c(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void NS(String str) {
        if (Qb(str)) {
            this.lVu.dsH();
            this.lVu.a(new com.baidu.tieba.n.c(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void NT(String str) {
        if (Qb(str)) {
            this.lVu.dsH();
            this.lVu.dsE();
            this.lVu.a(new com.baidu.tieba.n.c(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void s(String str, int i, String str2) {
        if (Qb(str)) {
            this.lVu.dsF();
            this.lVu.dsD();
            this.lVu.dsH();
            this.lVu.a(new com.baidu.tieba.n.c(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void jm(String str) {
        if (Qb(str)) {
            com.baidu.tieba.u.b.dIh().q(this.mUuid, com.baidu.tieba.u.b.a(VideoPlatformStatic.bEv(), this.lVu.cYA(), this.lVu.cYC()));
        }
    }

    @Override // com.baidu.tieba.k.f
    public boolean NU(String str) {
        if (Qb(str)) {
            return this.lVu.dsG();
        }
        return false;
    }

    @Override // com.baidu.tieba.k.f
    public boolean NV(String str) {
        return this.lVu.dsI();
    }

    @Override // com.baidu.tieba.k.f
    public void fD(String str, String str2) {
        if (Qb(str)) {
            this.lVu.a(new com.baidu.tieba.n.c(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void fE(String str, String str2) {
        if (Qb(str)) {
            this.lVu.a(new com.baidu.tieba.n.c(501, str2, -4399, ""));
        }
    }

    private boolean Qb(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
