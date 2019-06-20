package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes5.dex */
public class i implements com.baidu.tieba.j.f {
    private String hpq;
    private k iuy;

    public i(String str) {
        this.hpq = str;
        this.iuy = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void o(String str, int i, String str2) {
        if (Cu(str)) {
            this.iuy.ccU();
            this.iuy.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void p(String str, int i, String str2) {
        if (Cu(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.iuy.ccU();
                this.iuy.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.mg(i)));
                return;
            }
            this.iuy.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void q(String str, int i, String str2) {
        if (Cu(str)) {
            this.iuy.ccU();
            this.iuy.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (Cu(str)) {
            this.iuy.ccU();
            this.iuy.ccS();
            this.iuy.ccW();
            this.iuy.a(new com.baidu.tieba.m.d(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void Aj(String str) {
        if (Cu(str)) {
            this.iuy.ccW();
            this.iuy.a(new com.baidu.tieba.m.d(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void Ak(String str) {
        if (Cu(str)) {
            this.iuy.ccW();
            this.iuy.ccT();
            this.iuy.a(new com.baidu.tieba.m.d(401, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void r(String str, int i, String str2) {
        if (Cu(str)) {
            this.iuy.ccU();
            this.iuy.ccS();
            this.iuy.ccW();
            this.iuy.a(new com.baidu.tieba.m.d(402, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void cT(String str) {
        if (Cu(str)) {
            com.baidu.tieba.s.b.cqv().o(this.hpq, com.baidu.tieba.s.b.a(VideoPlatformStatic.aBk(), this.iuy.bMh(), this.iuy.bMj()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean Al(String str) {
        if (Cu(str)) {
            return this.iuy.ccV();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean Am(String str) {
        return this.iuy.ccX();
    }

    @Override // com.baidu.tieba.j.f
    public void dC(String str, String str2) {
        if (Cu(str)) {
            this.iuy.a(new com.baidu.tieba.m.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void dD(String str, String str2) {
        if (Cu(str)) {
            this.iuy.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean Cu(String str) {
        return (!TextUtils.equals(this.hpq, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.hpq)) ? false : true;
    }
}
