package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes8.dex */
public class i implements com.baidu.tieba.j.f {
    private k jzH;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.jzH = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void p(String str, int i, String str2) {
        if (GW(str)) {
            this.jzH.cyR();
            this.jzH.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void q(String str, int i, String str2) {
        if (GW(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.jzH.cyR();
                this.jzH.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.nK(i)));
                return;
            }
            this.jzH.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void r(String str, int i, String str2) {
        if (GW(str)) {
            this.jzH.cyR();
            this.jzH.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (GW(str)) {
            this.jzH.cyR();
            this.jzH.cyP();
            this.jzH.cyT();
            this.jzH.a(new com.baidu.tieba.m.d(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void EG(String str) {
        if (GW(str)) {
            this.jzH.cyT();
            this.jzH.a(new com.baidu.tieba.m.d(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void EH(String str) {
        if (GW(str)) {
            this.jzH.cyT();
            this.jzH.cyQ();
            this.jzH.a(new com.baidu.tieba.m.d(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void s(String str, int i, String str2) {
        if (GW(str)) {
            this.jzH.cyR();
            this.jzH.cyP();
            this.jzH.cyT();
            this.jzH.a(new com.baidu.tieba.m.d(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void eE(String str) {
        if (GW(str)) {
            com.baidu.tieba.t.b.cNl().q(this.mUuid, com.baidu.tieba.t.b.a(VideoPlatformStatic.aVj(), this.jzH.cfj(), this.jzH.cfl()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean EI(String str) {
        if (GW(str)) {
            return this.jzH.cyS();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean EJ(String str) {
        return this.jzH.cyU();
    }

    @Override // com.baidu.tieba.j.f
    public void dM(String str, String str2) {
        if (GW(str)) {
            this.jzH.a(new com.baidu.tieba.m.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void dN(String str, String str2) {
        if (GW(str)) {
            this.jzH.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean GW(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
