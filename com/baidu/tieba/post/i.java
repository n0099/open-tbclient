package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes5.dex */
public class i implements com.baidu.tieba.j.f {
    private String hpm;
    private k iuu;

    public i(String str) {
        this.hpm = str;
        this.iuu = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void o(String str, int i, String str2) {
        if (Cs(str)) {
            this.iuu.ccQ();
            this.iuu.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void p(String str, int i, String str2) {
        if (Cs(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.iuu.ccQ();
                this.iuu.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.mg(i)));
                return;
            }
            this.iuu.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void q(String str, int i, String str2) {
        if (Cs(str)) {
            this.iuu.ccQ();
            this.iuu.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (Cs(str)) {
            this.iuu.ccQ();
            this.iuu.ccO();
            this.iuu.ccS();
            this.iuu.a(new com.baidu.tieba.m.d(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void Ah(String str) {
        if (Cs(str)) {
            this.iuu.ccS();
            this.iuu.a(new com.baidu.tieba.m.d(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void Ai(String str) {
        if (Cs(str)) {
            this.iuu.ccS();
            this.iuu.ccP();
            this.iuu.a(new com.baidu.tieba.m.d(401, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void r(String str, int i, String str2) {
        if (Cs(str)) {
            this.iuu.ccQ();
            this.iuu.ccO();
            this.iuu.ccS();
            this.iuu.a(new com.baidu.tieba.m.d(402, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void cU(String str) {
        if (Cs(str)) {
            com.baidu.tieba.s.b.cqs().o(this.hpm, com.baidu.tieba.s.b.a(VideoPlatformStatic.aBh(), this.iuu.bMd(), this.iuu.bMf()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean Aj(String str) {
        if (Cs(str)) {
            return this.iuu.ccR();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean Ak(String str) {
        return this.iuu.ccT();
    }

    @Override // com.baidu.tieba.j.f
    public void dC(String str, String str2) {
        if (Cs(str)) {
            this.iuu.a(new com.baidu.tieba.m.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void dD(String str, String str2) {
        if (Cs(str)) {
            this.iuu.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean Cs(String str) {
        return (!TextUtils.equals(this.hpm, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.hpm)) ? false : true;
    }
}
