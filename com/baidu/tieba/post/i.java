package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes10.dex */
public class i implements com.baidu.tieba.k.f {
    private k kmt;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.kmt = new k(str);
    }

    @Override // com.baidu.tieba.k.f
    public void q(String str, int i, String str2) {
        if (IV(str)) {
            this.kmt.cLr();
            this.kmt.a(new com.baidu.tieba.n.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void r(String str, int i, String str2) {
        if (IV(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.kmt.cLr();
                this.kmt.a(new com.baidu.tieba.n.d(i, str2, i, VideoPlatformStatic.oq(i)));
                return;
            }
            this.kmt.a(new com.baidu.tieba.n.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void s(String str, int i, String str2) {
        if (IV(str)) {
            this.kmt.cLr();
            this.kmt.a(new com.baidu.tieba.n.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void e(String str, int i, int i2, String str2) {
        if (IV(str)) {
            this.kmt.cLr();
            this.kmt.cLp();
            this.kmt.cLt();
            this.kmt.a(new com.baidu.tieba.n.d(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void GH(String str) {
        if (IV(str)) {
            this.kmt.cLt();
            this.kmt.a(new com.baidu.tieba.n.d(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void GI(String str) {
        if (IV(str)) {
            this.kmt.cLt();
            this.kmt.cLq();
            this.kmt.a(new com.baidu.tieba.n.d(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void t(String str, int i, String str2) {
        if (IV(str)) {
            this.kmt.cLr();
            this.kmt.cLp();
            this.kmt.cLt();
            this.kmt.a(new com.baidu.tieba.n.d(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void ge(String str) {
        if (IV(str)) {
            com.baidu.tieba.u.b.cZX().p(this.mUuid, com.baidu.tieba.u.b.a(VideoPlatformStatic.bfJ(), this.kmt.crO(), this.kmt.crQ()));
        }
    }

    @Override // com.baidu.tieba.k.f
    public boolean GJ(String str) {
        if (IV(str)) {
            return this.kmt.cLs();
        }
        return false;
    }

    @Override // com.baidu.tieba.k.f
    public boolean GK(String str) {
        return this.kmt.cLu();
    }

    @Override // com.baidu.tieba.k.f
    public void ei(String str, String str2) {
        if (IV(str)) {
            this.kmt.a(new com.baidu.tieba.n.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void ej(String str, String str2) {
        if (IV(str)) {
            this.kmt.a(new com.baidu.tieba.n.d(501, str2, -4399, ""));
        }
    }

    private boolean IV(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
