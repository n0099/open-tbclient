package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class i implements com.baidu.tieba.j.f {
    private String fgW;
    private k giZ;

    public i(String str) {
        this.fgW = str;
        this.giZ = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void i(String str, int i, String str2) {
        if (st(str)) {
            this.giZ.bnl();
            this.giZ.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void j(String str, int i, String str2) {
        if (st(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.giZ.bnl();
                this.giZ.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.go(i)));
                return;
            }
            this.giZ.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void k(String str, int i, String str2) {
        if (st(str)) {
            this.giZ.bnl();
            this.giZ.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (st(str)) {
            this.giZ.bnl();
            this.giZ.bnj();
            this.giZ.bnn();
            this.giZ.a(new com.baidu.tieba.m.d(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void qs(String str) {
        if (st(str)) {
            this.giZ.bnn();
            this.giZ.a(new com.baidu.tieba.m.d(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void qt(String str) {
        if (st(str)) {
            this.giZ.bnn();
            this.giZ.bnk();
            this.giZ.a(new com.baidu.tieba.m.d(HttpStatus.SC_UNAUTHORIZED, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void l(String str, int i, String str2) {
        if (st(str)) {
            this.giZ.bnl();
            this.giZ.bnj();
            this.giZ.bnn();
            this.giZ.a(new com.baidu.tieba.m.d(HttpStatus.SC_PAYMENT_REQUIRED, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void qu(String str) {
        if (st(str)) {
            com.baidu.tieba.t.b.bBj().f(this.fgW, com.baidu.tieba.t.b.a(VideoPlatformStatic.Qv(), this.giZ.aXC(), this.giZ.aXD()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean qv(String str) {
        if (st(str)) {
            return this.giZ.bnm();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean qw(String str) {
        return this.giZ.bno();
    }

    @Override // com.baidu.tieba.j.f
    public void bL(String str, String str2) {
        if (st(str)) {
            this.giZ.a(new com.baidu.tieba.m.d(HttpStatus.SC_SERVICE_UNAVAILABLE, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void bM(String str, String str2) {
        if (st(str)) {
            this.giZ.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean st(String str) {
        return (!TextUtils.equals(this.fgW, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.fgW)) ? false : true;
    }
}
