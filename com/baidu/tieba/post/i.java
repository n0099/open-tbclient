package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes5.dex */
public class i implements com.baidu.tieba.j.f {
    private String gYh;
    private k icd;

    public i(String str) {
        this.gYh = str;
        this.icd = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void k(String str, int i, String str2) {
        if (Bb(str)) {
            this.icd.bUU();
            this.icd.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void l(String str, int i, String str2) {
        if (Bb(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.icd.bUU();
                this.icd.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.ls(i)));
                return;
            }
            this.icd.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void m(String str, int i, String str2) {
        if (Bb(str)) {
            this.icd.bUU();
            this.icd.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (Bb(str)) {
            this.icd.bUU();
            this.icd.bUS();
            this.icd.bUW();
            this.icd.a(new com.baidu.tieba.m.d(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void yS(String str) {
        if (Bb(str)) {
            this.icd.bUW();
            this.icd.a(new com.baidu.tieba.m.d(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void yT(String str) {
        if (Bb(str)) {
            this.icd.bUW();
            this.icd.bUT();
            this.icd.a(new com.baidu.tieba.m.d(401, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void n(String str, int i, String str2) {
        if (Bb(str)) {
            this.icd.bUU();
            this.icd.bUS();
            this.icd.bUW();
            this.icd.a(new com.baidu.tieba.m.d(402, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void df(String str) {
        if (Bb(str)) {
            com.baidu.tieba.s.b.cir().n(this.gYh, com.baidu.tieba.s.b.a(VideoPlatformStatic.awe(), this.icd.bEv(), this.icd.bEx()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean yU(String str) {
        if (Bb(str)) {
            return this.icd.bUV();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean yV(String str) {
        return this.icd.bUX();
    }

    @Override // com.baidu.tieba.j.f
    public void dp(String str, String str2) {
        if (Bb(str)) {
            this.icd.a(new com.baidu.tieba.m.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void dq(String str, String str2) {
        if (Bb(str)) {
            this.icd.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean Bb(String str) {
        return (!TextUtils.equals(this.gYh, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.gYh)) ? false : true;
    }
}
