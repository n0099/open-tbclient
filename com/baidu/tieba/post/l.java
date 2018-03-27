package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class l implements com.baidu.tieba.i.f {
    private String fvY;
    private n gxU;

    public l(String str) {
        this.fvY = str;
        this.gxU = new n(str);
    }

    @Override // com.baidu.tieba.i.f
    public void i(String str, int i, String str2) {
        if (rt(str)) {
            this.gxU.bmD();
            this.gxU.a(new com.baidu.tieba.l.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void j(String str, int i, String str2) {
        if (rt(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.gxU.bmD();
                this.gxU.a(new com.baidu.tieba.l.d(i, str2, i, VideoPlatformStatic.jn(i)));
                return;
            }
            this.gxU.a(new com.baidu.tieba.l.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void k(String str, int i, String str2) {
        if (rt(str)) {
            this.gxU.bmD();
            this.gxU.a(new com.baidu.tieba.l.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void e(String str, int i, int i2, String str2) {
        if (rt(str)) {
            this.gxU.bmD();
            this.gxU.bmB();
            this.gxU.bmF();
            this.gxU.a(new com.baidu.tieba.l.d(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void pv(String str) {
        if (rt(str)) {
            this.gxU.bmF();
            this.gxU.a(new com.baidu.tieba.l.d(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void pw(String str) {
        if (rt(str)) {
            this.gxU.bmF();
            this.gxU.bmC();
            this.gxU.a(new com.baidu.tieba.l.d(HttpStatus.SC_UNAUTHORIZED, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void l(String str, int i, String str2) {
        if (rt(str)) {
            this.gxU.bmD();
            this.gxU.bmB();
            this.gxU.bmF();
            this.gxU.a(new com.baidu.tieba.l.d(HttpStatus.SC_PAYMENT_REQUIRED, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void px(String str) {
        if (rt(str)) {
            com.baidu.tieba.q.b.bAC().d(this.fvY, com.baidu.tieba.q.b.a(VideoPlatformStatic.Uf(), this.gxU.aXd(), this.gxU.aXe()));
        }
    }

    @Override // com.baidu.tieba.i.f
    public boolean py(String str) {
        if (rt(str)) {
            return this.gxU.bmE();
        }
        return false;
    }

    @Override // com.baidu.tieba.i.f
    public boolean pz(String str) {
        return this.gxU.bmG();
    }

    @Override // com.baidu.tieba.i.f
    public void bz(String str, String str2) {
        if (rt(str)) {
            this.gxU.a(new com.baidu.tieba.l.d(HttpStatus.SC_SERVICE_UNAVAILABLE, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void bA(String str, String str2) {
        if (rt(str)) {
            this.gxU.a(new com.baidu.tieba.l.d(HttpStatus.SC_NOT_IMPLEMENTED, str2, -4399, ""));
        }
    }

    private boolean rt(String str) {
        return (!TextUtils.equals(this.fvY, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.fvY)) ? false : true;
    }
}
