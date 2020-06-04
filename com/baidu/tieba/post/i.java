package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes10.dex */
public class i implements com.baidu.tieba.k.f {
    private k kFw;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.kFw = new k(str);
    }

    @Override // com.baidu.tieba.k.f
    public void o(String str, int i, String str2) {
        if (KI(str)) {
            this.kFw.cSI();
            this.kFw.a(new com.baidu.tieba.n.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void p(String str, int i, String str2) {
        if (KI(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.kFw.cSI();
                this.kFw.a(new com.baidu.tieba.n.d(i, str2, i, VideoPlatformStatic.oZ(i)));
                return;
            }
            this.kFw.a(new com.baidu.tieba.n.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void q(String str, int i, String str2) {
        if (KI(str)) {
            this.kFw.cSI();
            this.kFw.a(new com.baidu.tieba.n.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void e(String str, int i, int i2, String str2) {
        if (KI(str)) {
            this.kFw.cSI();
            this.kFw.cSG();
            this.kFw.cSK();
            this.kFw.a(new com.baidu.tieba.n.d(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void Ir(String str) {
        if (KI(str)) {
            this.kFw.cSK();
            this.kFw.a(new com.baidu.tieba.n.d(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void Is(String str) {
        if (KI(str)) {
            this.kFw.cSK();
            this.kFw.cSH();
            this.kFw.a(new com.baidu.tieba.n.d(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void r(String str, int i, String str2) {
        if (KI(str)) {
            this.kFw.cSI();
            this.kFw.cSG();
            this.kFw.cSK();
            this.kFw.a(new com.baidu.tieba.n.d(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void gQ(String str) {
        if (KI(str)) {
            com.baidu.tieba.u.b.dhB().q(this.mUuid, com.baidu.tieba.u.b.a(VideoPlatformStatic.blX(), this.kFw.cyJ(), this.kFw.cyL()));
        }
    }

    @Override // com.baidu.tieba.k.f
    public boolean It(String str) {
        if (KI(str)) {
            return this.kFw.cSJ();
        }
        return false;
    }

    @Override // com.baidu.tieba.k.f
    public boolean Iu(String str) {
        return this.kFw.cSL();
    }

    @Override // com.baidu.tieba.k.f
    public void eJ(String str, String str2) {
        if (KI(str)) {
            this.kFw.a(new com.baidu.tieba.n.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void eK(String str, String str2) {
        if (KI(str)) {
            this.kFw.a(new com.baidu.tieba.n.d(501, str2, -4399, ""));
        }
    }

    private boolean KI(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
