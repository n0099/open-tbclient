package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class i implements com.baidu.tieba.j.f {
    private String fow;
    private k gqR;

    public i(String str) {
        this.fow = str;
        this.gqR = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void h(String str, int i, String str2) {
        if (sX(str)) {
            this.gqR.boh();
            this.gqR.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void i(String str, int i, String str2) {
        if (sX(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.gqR.boh();
                this.gqR.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.gS(i)));
                return;
            }
            this.gqR.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void j(String str, int i, String str2) {
        if (sX(str)) {
            this.gqR.boh();
            this.gqR.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (sX(str)) {
            this.gqR.boh();
            this.gqR.bof();
            this.gqR.boj();
            this.gqR.a(new com.baidu.tieba.m.d(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void qS(String str) {
        if (sX(str)) {
            this.gqR.boj();
            this.gqR.a(new com.baidu.tieba.m.d(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void qT(String str) {
        if (sX(str)) {
            this.gqR.boj();
            this.gqR.bog();
            this.gqR.a(new com.baidu.tieba.m.d(HttpStatus.SC_UNAUTHORIZED, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void k(String str, int i, String str2) {
        if (sX(str)) {
            this.gqR.boh();
            this.gqR.bof();
            this.gqR.boj();
            this.gqR.a(new com.baidu.tieba.m.d(HttpStatus.SC_PAYMENT_REQUIRED, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void qU(String str) {
        if (sX(str)) {
            com.baidu.tieba.s.b.bCC().g(this.fow, com.baidu.tieba.s.b.a(VideoPlatformStatic.Sv(), this.gqR.aYf(), this.gqR.aYg()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean qV(String str) {
        if (sX(str)) {
            return this.gqR.boi();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean qW(String str) {
        return this.gqR.bok();
    }

    @Override // com.baidu.tieba.j.f
    public void bP(String str, String str2) {
        if (sX(str)) {
            this.gqR.a(new com.baidu.tieba.m.d(HttpStatus.SC_SERVICE_UNAVAILABLE, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void bQ(String str, String str2) {
        if (sX(str)) {
            this.gqR.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean sX(String str) {
        return (!TextUtils.equals(this.fow, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.fow)) ? false : true;
    }
}
