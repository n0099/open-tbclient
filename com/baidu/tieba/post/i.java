package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class i implements com.baidu.tieba.j.f {
    private String fgZ;
    private k gjz;

    public i(String str) {
        this.fgZ = str;
        this.gjz = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void h(String str, int i, String str2) {
        if (sp(str)) {
            this.gjz.blB();
            this.gjz.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void i(String str, int i, String str2) {
        if (sp(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.gjz.blB();
                this.gjz.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.gs(i)));
                return;
            }
            this.gjz.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void j(String str, int i, String str2) {
        if (sp(str)) {
            this.gjz.blB();
            this.gjz.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (sp(str)) {
            this.gjz.blB();
            this.gjz.blz();
            this.gjz.blD();
            this.gjz.a(new com.baidu.tieba.m.d(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void qn(String str) {
        if (sp(str)) {
            this.gjz.blD();
            this.gjz.a(new com.baidu.tieba.m.d(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void qo(String str) {
        if (sp(str)) {
            this.gjz.blD();
            this.gjz.blA();
            this.gjz.a(new com.baidu.tieba.m.d(HttpStatus.SC_UNAUTHORIZED, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void k(String str, int i, String str2) {
        if (sp(str)) {
            this.gjz.blB();
            this.gjz.blz();
            this.gjz.blD();
            this.gjz.a(new com.baidu.tieba.m.d(HttpStatus.SC_PAYMENT_REQUIRED, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void qp(String str) {
        if (sp(str)) {
            com.baidu.tieba.s.b.bzN().g(this.fgZ, com.baidu.tieba.s.b.a(VideoPlatformStatic.QH(), this.gjz.aVR(), this.gjz.aVS()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean qq(String str) {
        if (sp(str)) {
            return this.gjz.blC();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean qr(String str) {
        return this.gjz.blE();
    }

    @Override // com.baidu.tieba.j.f
    public void bH(String str, String str2) {
        if (sp(str)) {
            this.gjz.a(new com.baidu.tieba.m.d(HttpStatus.SC_SERVICE_UNAVAILABLE, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void bI(String str, String str2) {
        if (sp(str)) {
            this.gjz.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean sp(String str) {
        return (!TextUtils.equals(this.fgZ, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.fgZ)) ? false : true;
    }
}
