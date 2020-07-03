package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes10.dex */
public class i implements com.baidu.tieba.k.f {
    private k kZs;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.kZs = new k(str);
    }

    @Override // com.baidu.tieba.k.f
    public void o(String str, int i, String str2) {
        if (Lj(str)) {
            this.kZs.cWY();
            this.kZs.a(new com.baidu.tieba.n.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void p(String str, int i, String str2) {
        if (Lj(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.kZs.cWY();
                this.kZs.a(new com.baidu.tieba.n.d(i, str2, i, VideoPlatformStatic.py(i)));
                return;
            }
            this.kZs.a(new com.baidu.tieba.n.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void q(String str, int i, String str2) {
        if (Lj(str)) {
            this.kZs.cWY();
            this.kZs.a(new com.baidu.tieba.n.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void e(String str, int i, int i2, String str2) {
        if (Lj(str)) {
            this.kZs.cWY();
            this.kZs.cWW();
            this.kZs.cXa();
            this.kZs.a(new com.baidu.tieba.n.d(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void IT(String str) {
        if (Lj(str)) {
            this.kZs.cXa();
            this.kZs.a(new com.baidu.tieba.n.d(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void IU(String str) {
        if (Lj(str)) {
            this.kZs.cXa();
            this.kZs.cWX();
            this.kZs.a(new com.baidu.tieba.n.d(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void r(String str, int i, String str2) {
        if (Lj(str)) {
            this.kZs.cWY();
            this.kZs.cWW();
            this.kZs.cXa();
            this.kZs.a(new com.baidu.tieba.n.d(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void gY(String str) {
        if (Lj(str)) {
            com.baidu.tieba.u.b.dlJ().q(this.mUuid, com.baidu.tieba.u.b.a(VideoPlatformStatic.bow(), this.kZs.cCG(), this.kZs.cCI()));
        }
    }

    @Override // com.baidu.tieba.k.f
    public boolean IV(String str) {
        if (Lj(str)) {
            return this.kZs.cWZ();
        }
        return false;
    }

    @Override // com.baidu.tieba.k.f
    public boolean IW(String str) {
        return this.kZs.cXb();
    }

    @Override // com.baidu.tieba.k.f
    public void eP(String str, String str2) {
        if (Lj(str)) {
            this.kZs.a(new com.baidu.tieba.n.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void eQ(String str, String str2) {
        if (Lj(str)) {
            this.kZs.a(new com.baidu.tieba.n.d(501, str2, -4399, ""));
        }
    }

    private boolean Lj(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
