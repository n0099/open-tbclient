package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes10.dex */
public class i implements com.baidu.tieba.k.f {
    private k jCk;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.jCk = new k(str);
    }

    @Override // com.baidu.tieba.k.f
    public void q(String str, int i, String str2) {
        if (Hl(str)) {
            this.jCk.cAJ();
            this.jCk.a(new com.baidu.tieba.n.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void r(String str, int i, String str2) {
        if (Hl(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.jCk.cAJ();
                this.jCk.a(new com.baidu.tieba.n.d(i, str2, i, VideoPlatformStatic.od(i)));
                return;
            }
            this.jCk.a(new com.baidu.tieba.n.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void s(String str, int i, String str2) {
        if (Hl(str)) {
            this.jCk.cAJ();
            this.jCk.a(new com.baidu.tieba.n.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void e(String str, int i, int i2, String str2) {
        if (Hl(str)) {
            this.jCk.cAJ();
            this.jCk.cAH();
            this.jCk.cAL();
            this.jCk.a(new com.baidu.tieba.n.d(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void EX(String str) {
        if (Hl(str)) {
            this.jCk.cAL();
            this.jCk.a(new com.baidu.tieba.n.d(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void EY(String str) {
        if (Hl(str)) {
            this.jCk.cAL();
            this.jCk.cAI();
            this.jCk.a(new com.baidu.tieba.n.d(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void t(String str, int i, String str2) {
        if (Hl(str)) {
            this.jCk.cAJ();
            this.jCk.cAH();
            this.jCk.cAL();
            this.jCk.a(new com.baidu.tieba.n.d(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void eT(String str) {
        if (Hl(str)) {
            com.baidu.tieba.u.b.cPd().q(this.mUuid, com.baidu.tieba.u.b.a(VideoPlatformStatic.aXG(), this.jCk.chk(), this.jCk.chm()));
        }
    }

    @Override // com.baidu.tieba.k.f
    public boolean EZ(String str) {
        if (Hl(str)) {
            return this.jCk.cAK();
        }
        return false;
    }

    @Override // com.baidu.tieba.k.f
    public boolean Fa(String str) {
        return this.jCk.cAM();
    }

    @Override // com.baidu.tieba.k.f
    public void dT(String str, String str2) {
        if (Hl(str)) {
            this.jCk.a(new com.baidu.tieba.n.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void dU(String str, String str2) {
        if (Hl(str)) {
            this.jCk.a(new com.baidu.tieba.n.d(501, str2, -4399, ""));
        }
    }

    private boolean Hl(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
