package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class i implements com.baidu.tieba.j.f {
    private String fdf;
    private k geY;

    public i(String str) {
        this.fdf = str;
        this.geY = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void i(String str, int i, String str2) {
        if (su(str)) {
            this.geY.bmH();
            this.geY.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void j(String str, int i, String str2) {
        if (su(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.geY.bmH();
                this.geY.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.gn(i)));
                return;
            }
            this.geY.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void k(String str, int i, String str2) {
        if (su(str)) {
            this.geY.bmH();
            this.geY.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (su(str)) {
            this.geY.bmH();
            this.geY.bmF();
            this.geY.bmJ();
            this.geY.a(new com.baidu.tieba.m.d(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void qs(String str) {
        if (su(str)) {
            this.geY.bmJ();
            this.geY.a(new com.baidu.tieba.m.d(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void qt(String str) {
        if (su(str)) {
            this.geY.bmJ();
            this.geY.bmG();
            this.geY.a(new com.baidu.tieba.m.d(HttpStatus.SC_UNAUTHORIZED, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void l(String str, int i, String str2) {
        if (su(str)) {
            this.geY.bmH();
            this.geY.bmF();
            this.geY.bmJ();
            this.geY.a(new com.baidu.tieba.m.d(HttpStatus.SC_PAYMENT_REQUIRED, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void qu(String str) {
        if (su(str)) {
            com.baidu.tieba.t.b.bAJ().f(this.fdf, com.baidu.tieba.t.b.a(VideoPlatformStatic.PY(), this.geY.aWV(), this.geY.aWW()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean qv(String str) {
        if (su(str)) {
            return this.geY.bmI();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean qw(String str) {
        return this.geY.bmK();
    }

    @Override // com.baidu.tieba.j.f
    public void bH(String str, String str2) {
        if (su(str)) {
            this.geY.a(new com.baidu.tieba.m.d(HttpStatus.SC_SERVICE_UNAVAILABLE, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void bI(String str, String str2) {
        if (su(str)) {
            this.geY.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean su(String str) {
        return (!TextUtils.equals(this.fdf, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.fdf)) ? false : true;
    }
}
