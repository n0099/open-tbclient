package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class l implements com.baidu.tieba.i.f {
    private String fvU;
    private n gxP;

    public l(String str) {
        this.fvU = str;
        this.gxP = new n(str);
    }

    @Override // com.baidu.tieba.i.f
    public void i(String str, int i, String str2) {
        if (rt(str)) {
            this.gxP.bmD();
            this.gxP.a(new com.baidu.tieba.l.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void j(String str, int i, String str2) {
        if (rt(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.gxP.bmD();
                this.gxP.a(new com.baidu.tieba.l.d(i, str2, i, VideoPlatformStatic.jn(i)));
                return;
            }
            this.gxP.a(new com.baidu.tieba.l.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void k(String str, int i, String str2) {
        if (rt(str)) {
            this.gxP.bmD();
            this.gxP.a(new com.baidu.tieba.l.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void e(String str, int i, int i2, String str2) {
        if (rt(str)) {
            this.gxP.bmD();
            this.gxP.bmB();
            this.gxP.bmF();
            this.gxP.a(new com.baidu.tieba.l.d(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void pv(String str) {
        if (rt(str)) {
            this.gxP.bmF();
            this.gxP.a(new com.baidu.tieba.l.d(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void pw(String str) {
        if (rt(str)) {
            this.gxP.bmF();
            this.gxP.bmC();
            this.gxP.a(new com.baidu.tieba.l.d(HttpStatus.SC_UNAUTHORIZED, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void l(String str, int i, String str2) {
        if (rt(str)) {
            this.gxP.bmD();
            this.gxP.bmB();
            this.gxP.bmF();
            this.gxP.a(new com.baidu.tieba.l.d(HttpStatus.SC_PAYMENT_REQUIRED, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void px(String str) {
        if (rt(str)) {
            com.baidu.tieba.q.b.bAy().d(this.fvU, com.baidu.tieba.q.b.a(VideoPlatformStatic.Uf(), this.gxP.aXd(), this.gxP.aXe()));
        }
    }

    @Override // com.baidu.tieba.i.f
    public boolean py(String str) {
        if (rt(str)) {
            return this.gxP.bmE();
        }
        return false;
    }

    @Override // com.baidu.tieba.i.f
    public boolean pz(String str) {
        return this.gxP.bmG();
    }

    @Override // com.baidu.tieba.i.f
    public void bz(String str, String str2) {
        if (rt(str)) {
            this.gxP.a(new com.baidu.tieba.l.d(HttpStatus.SC_SERVICE_UNAVAILABLE, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void bA(String str, String str2) {
        if (rt(str)) {
            this.gxP.a(new com.baidu.tieba.l.d(HttpStatus.SC_NOT_IMPLEMENTED, str2, -4399, ""));
        }
    }

    private boolean rt(String str) {
        return (!TextUtils.equals(this.fvU, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.fvU)) ? false : true;
    }
}
