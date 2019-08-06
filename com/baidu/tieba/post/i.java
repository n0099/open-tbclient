package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes5.dex */
public class i implements com.baidu.tieba.j.f {
    private String hwu;
    private k iBT;

    public i(String str) {
        this.hwu = str;
        this.iBT = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void o(String str, int i, String str2) {
        if (Di(str)) {
            this.iBT.cgd();
            this.iBT.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void p(String str, int i, String str2) {
        if (Di(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.iBT.cgd();
                this.iBT.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.mo(i)));
                return;
            }
            this.iBT.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void q(String str, int i, String str2) {
        if (Di(str)) {
            this.iBT.cgd();
            this.iBT.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (Di(str)) {
            this.iBT.cgd();
            this.iBT.cgb();
            this.iBT.cgf();
            this.iBT.a(new com.baidu.tieba.m.d(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void AV(String str) {
        if (Di(str)) {
            this.iBT.cgf();
            this.iBT.a(new com.baidu.tieba.m.d(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void AW(String str) {
        if (Di(str)) {
            this.iBT.cgf();
            this.iBT.cgc();
            this.iBT.a(new com.baidu.tieba.m.d(401, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void r(String str, int i, String str2) {
        if (Di(str)) {
            this.iBT.cgd();
            this.iBT.cgb();
            this.iBT.cgf();
            this.iBT.a(new com.baidu.tieba.m.d(402, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void cY(String str) {
        if (Di(str)) {
            com.baidu.tieba.s.b.ctB().o(this.hwu, com.baidu.tieba.s.b.a(VideoPlatformStatic.aCB(), this.iBT.bPd(), this.iBT.bPf()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean AX(String str) {
        if (Di(str)) {
            return this.iBT.cge();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean AY(String str) {
        return this.iBT.cgg();
    }

    @Override // com.baidu.tieba.j.f
    public void dD(String str, String str2) {
        if (Di(str)) {
            this.iBT.a(new com.baidu.tieba.m.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void dE(String str, String str2) {
        if (Di(str)) {
            this.iBT.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean Di(String str) {
        return (!TextUtils.equals(this.hwu, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.hwu)) ? false : true;
    }
}
