package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes5.dex */
public class i implements com.baidu.tieba.j.f {
    private String hyo;
    private k iEl;

    public i(String str) {
        this.hyo = str;
        this.iEl = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void o(String str, int i, String str2) {
        if (DH(str)) {
            this.iEl.cgR();
            this.iEl.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void p(String str, int i, String str2) {
        if (DH(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.iEl.cgR();
                this.iEl.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.ms(i)));
                return;
            }
            this.iEl.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void q(String str, int i, String str2) {
        if (DH(str)) {
            this.iEl.cgR();
            this.iEl.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (DH(str)) {
            this.iEl.cgR();
            this.iEl.cgP();
            this.iEl.cgT();
            this.iEl.a(new com.baidu.tieba.m.d(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void Bu(String str) {
        if (DH(str)) {
            this.iEl.cgT();
            this.iEl.a(new com.baidu.tieba.m.d(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void Bv(String str) {
        if (DH(str)) {
            this.iEl.cgT();
            this.iEl.cgQ();
            this.iEl.a(new com.baidu.tieba.m.d(401, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void r(String str, int i, String str2) {
        if (DH(str)) {
            this.iEl.cgR();
            this.iEl.cgP();
            this.iEl.cgT();
            this.iEl.a(new com.baidu.tieba.m.d(402, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void da(String str) {
        if (DH(str)) {
            com.baidu.tieba.s.b.cup().o(this.hyo, com.baidu.tieba.s.b.a(VideoPlatformStatic.aCP(), this.iEl.bPQ(), this.iEl.bPS()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean Bw(String str) {
        if (DH(str)) {
            return this.iEl.cgS();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean Bx(String str) {
        return this.iEl.cgU();
    }

    @Override // com.baidu.tieba.j.f
    public void dF(String str, String str2) {
        if (DH(str)) {
            this.iEl.a(new com.baidu.tieba.m.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void dG(String str, String str2) {
        if (DH(str)) {
            this.iEl.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean DH(String str) {
        return (!TextUtils.equals(this.hyo, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.hyo)) ? false : true;
    }
}
