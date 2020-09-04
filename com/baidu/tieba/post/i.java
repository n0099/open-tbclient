package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes17.dex */
public class i implements com.baidu.tieba.k.f {
    private k lxp;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.lxp = new k(str);
    }

    @Override // com.baidu.tieba.k.f
    public void n(String str, int i, String str2) {
        if (OL(str)) {
            this.lxp.dln();
            this.lxp.a(new com.baidu.tieba.n.c(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void o(String str, int i, String str2) {
        if (OL(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.lxp.dln();
                this.lxp.a(new com.baidu.tieba.n.c(i, str2, i, VideoPlatformStatic.rX(i)));
                return;
            }
            this.lxp.a(new com.baidu.tieba.n.c(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void p(String str, int i, String str2) {
        if (OL(str)) {
            this.lxp.dln();
            this.lxp.a(new com.baidu.tieba.n.c(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void e(String str, int i, int i2, String str2) {
        if (OL(str)) {
            this.lxp.dln();
            this.lxp.dll();
            this.lxp.dlp();
            this.lxp.a(new com.baidu.tieba.n.c(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void MB(String str) {
        if (OL(str)) {
            this.lxp.dlp();
            this.lxp.a(new com.baidu.tieba.n.c(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void MC(String str) {
        if (OL(str)) {
            this.lxp.dlp();
            this.lxp.dlm();
            this.lxp.a(new com.baidu.tieba.n.c(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void q(String str, int i, String str2) {
        if (OL(str)) {
            this.lxp.dln();
            this.lxp.dll();
            this.lxp.dlp();
            this.lxp.a(new com.baidu.tieba.n.c(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void ir(String str) {
        if (OL(str)) {
            com.baidu.tieba.u.b.dAB().p(this.mUuid, com.baidu.tieba.u.b.a(VideoPlatformStatic.bAx(), this.lxp.cRl(), this.lxp.cRn()));
        }
    }

    @Override // com.baidu.tieba.k.f
    public boolean MD(String str) {
        if (OL(str)) {
            return this.lxp.dlo();
        }
        return false;
    }

    @Override // com.baidu.tieba.k.f
    public boolean ME(String str) {
        return this.lxp.dlq();
    }

    @Override // com.baidu.tieba.k.f
    public void fj(String str, String str2) {
        if (OL(str)) {
            this.lxp.a(new com.baidu.tieba.n.c(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void fk(String str, String str2) {
        if (OL(str)) {
            this.lxp.a(new com.baidu.tieba.n.c(501, str2, -4399, ""));
        }
    }

    private boolean OL(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
