package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.tieba.i.f;
import com.baidu.tieba.p.b;
/* loaded from: classes2.dex */
public class k implements f {
    private String eDq;
    private m fRU;

    public k(String str) {
        this.eDq = str;
        this.fRU = new m(str);
    }

    @Override // com.baidu.tieba.i.f
    public void i(String str, int i, String str2) {
        if (rz(str)) {
            this.fRU.bkh();
            this.fRU.a(new com.baidu.tieba.l.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void j(String str, int i, String str2) {
        if (rz(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.fRU.bkh();
                this.fRU.a(new com.baidu.tieba.l.d(i, str2, i, VideoPlatformStatic.gw(i)));
                return;
            }
            this.fRU.a(new com.baidu.tieba.l.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void k(String str, int i, String str2) {
        if (rz(str)) {
            this.fRU.bkh();
            this.fRU.a(new com.baidu.tieba.l.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void c(String str, int i, int i2, String str2) {
        if (rz(str)) {
            this.fRU.bkh();
            this.fRU.bkf();
            this.fRU.bkj();
            this.fRU.a(new com.baidu.tieba.l.d(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void oS(String str) {
        if (rz(str)) {
            this.fRU.bkj();
            this.fRU.a(new com.baidu.tieba.l.d(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void oT(String str) {
        if (rz(str)) {
            this.fRU.bkj();
            this.fRU.bkg();
            this.fRU.a(new com.baidu.tieba.l.d(401, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void l(String str, int i, String str2) {
        if (rz(str)) {
            this.fRU.bkh();
            this.fRU.bkf();
            this.fRU.bkj();
            this.fRU.a(new com.baidu.tieba.l.d(402, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void oU(String str) {
        if (rz(str)) {
            b.bAn().d(this.eDq, b.a(VideoPlatformStatic.Mh(), this.fRU.aNY(), this.fRU.aNZ()));
        }
    }

    @Override // com.baidu.tieba.i.f
    public boolean oV(String str) {
        if (rz(str)) {
            return this.fRU.bki();
        }
        return false;
    }

    @Override // com.baidu.tieba.i.f
    public boolean oW(String str) {
        return this.fRU.bkk();
    }

    @Override // com.baidu.tieba.i.f
    public void bz(String str, String str2) {
        if (rz(str)) {
            this.fRU.a(new com.baidu.tieba.l.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void bA(String str, String str2) {
        if (rz(str)) {
            this.fRU.a(new com.baidu.tieba.l.d(501, str2, -4399, ""));
        }
    }

    private boolean rz(String str) {
        return (!TextUtils.equals(this.eDq, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.eDq)) ? false : true;
    }
}
