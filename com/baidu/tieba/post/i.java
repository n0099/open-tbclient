package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes5.dex */
public class i implements com.baidu.tieba.j.f {
    private String hvC;
    private k iAP;

    public i(String str) {
        this.hvC = str;
        this.iAP = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void o(String str, int i, String str2) {
        if (Dh(str)) {
            this.iAP.cfL();
            this.iAP.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void p(String str, int i, String str2) {
        if (Dh(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.iAP.cfL();
                this.iAP.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.mn(i)));
                return;
            }
            this.iAP.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void q(String str, int i, String str2) {
        if (Dh(str)) {
            this.iAP.cfL();
            this.iAP.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (Dh(str)) {
            this.iAP.cfL();
            this.iAP.cfJ();
            this.iAP.cfN();
            this.iAP.a(new com.baidu.tieba.m.d(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void AU(String str) {
        if (Dh(str)) {
            this.iAP.cfN();
            this.iAP.a(new com.baidu.tieba.m.d(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void AV(String str) {
        if (Dh(str)) {
            this.iAP.cfN();
            this.iAP.cfK();
            this.iAP.a(new com.baidu.tieba.m.d(401, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void r(String str, int i, String str2) {
        if (Dh(str)) {
            this.iAP.cfL();
            this.iAP.cfJ();
            this.iAP.cfN();
            this.iAP.a(new com.baidu.tieba.m.d(402, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void cY(String str) {
        if (Dh(str)) {
            com.baidu.tieba.s.b.ctf().o(this.hvC, com.baidu.tieba.s.b.a(VideoPlatformStatic.aCz(), this.iAP.bOP(), this.iAP.bOR()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean AW(String str) {
        if (Dh(str)) {
            return this.iAP.cfM();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean AX(String str) {
        return this.iAP.cfO();
    }

    @Override // com.baidu.tieba.j.f
    public void dD(String str, String str2) {
        if (Dh(str)) {
            this.iAP.a(new com.baidu.tieba.m.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void dE(String str, String str2) {
        if (Dh(str)) {
            this.iAP.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean Dh(String str) {
        return (!TextUtils.equals(this.hvC, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.hvC)) ? false : true;
    }
}
