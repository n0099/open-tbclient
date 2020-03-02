package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes10.dex */
public class i implements com.baidu.tieba.k.f {
    private k jAz;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.jAz = new k(str);
    }

    @Override // com.baidu.tieba.k.f
    public void q(String str, int i, String str2) {
        if (Hk(str)) {
            this.jAz.cAo();
            this.jAz.a(new com.baidu.tieba.n.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void r(String str, int i, String str2) {
        if (Hk(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.jAz.cAo();
                this.jAz.a(new com.baidu.tieba.n.d(i, str2, i, VideoPlatformStatic.ob(i)));
                return;
            }
            this.jAz.a(new com.baidu.tieba.n.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void s(String str, int i, String str2) {
        if (Hk(str)) {
            this.jAz.cAo();
            this.jAz.a(new com.baidu.tieba.n.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void e(String str, int i, int i2, String str2) {
        if (Hk(str)) {
            this.jAz.cAo();
            this.jAz.cAm();
            this.jAz.cAq();
            this.jAz.a(new com.baidu.tieba.n.d(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void EW(String str) {
        if (Hk(str)) {
            this.jAz.cAq();
            this.jAz.a(new com.baidu.tieba.n.d(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void EX(String str) {
        if (Hk(str)) {
            this.jAz.cAq();
            this.jAz.cAn();
            this.jAz.a(new com.baidu.tieba.n.d(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void t(String str, int i, String str2) {
        if (Hk(str)) {
            this.jAz.cAo();
            this.jAz.cAm();
            this.jAz.cAq();
            this.jAz.a(new com.baidu.tieba.n.d(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void eU(String str) {
        if (Hk(str)) {
            com.baidu.tieba.u.b.cOI().q(this.mUuid, com.baidu.tieba.u.b.a(VideoPlatformStatic.aXB(), this.jAz.cgP(), this.jAz.cgR()));
        }
    }

    @Override // com.baidu.tieba.k.f
    public boolean EY(String str) {
        if (Hk(str)) {
            return this.jAz.cAp();
        }
        return false;
    }

    @Override // com.baidu.tieba.k.f
    public boolean EZ(String str) {
        return this.jAz.cAr();
    }

    @Override // com.baidu.tieba.k.f
    public void dV(String str, String str2) {
        if (Hk(str)) {
            this.jAz.a(new com.baidu.tieba.n.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void dW(String str, String str2) {
        if (Hk(str)) {
            this.jAz.a(new com.baidu.tieba.n.d(501, str2, -4399, ""));
        }
    }

    private boolean Hk(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
