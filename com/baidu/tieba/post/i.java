package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes17.dex */
public class i implements com.baidu.tieba.k.f {
    private k lxe;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.lxe = new k(str);
    }

    @Override // com.baidu.tieba.k.f
    public void o(String str, int i, String str2) {
        if (OK(str)) {
            this.lxe.dlk();
            this.lxe.a(new com.baidu.tieba.n.c(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void p(String str, int i, String str2) {
        if (OK(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.lxe.dlk();
                this.lxe.a(new com.baidu.tieba.n.c(i, str2, i, VideoPlatformStatic.rX(i)));
                return;
            }
            this.lxe.a(new com.baidu.tieba.n.c(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void q(String str, int i, String str2) {
        if (OK(str)) {
            this.lxe.dlk();
            this.lxe.a(new com.baidu.tieba.n.c(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void e(String str, int i, int i2, String str2) {
        if (OK(str)) {
            this.lxe.dlk();
            this.lxe.dli();
            this.lxe.dlm();
            this.lxe.a(new com.baidu.tieba.n.c(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void MA(String str) {
        if (OK(str)) {
            this.lxe.dlm();
            this.lxe.a(new com.baidu.tieba.n.c(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void MB(String str) {
        if (OK(str)) {
            this.lxe.dlm();
            this.lxe.dlj();
            this.lxe.a(new com.baidu.tieba.n.c(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void r(String str, int i, String str2) {
        if (OK(str)) {
            this.lxe.dlk();
            this.lxe.dli();
            this.lxe.dlm();
            this.lxe.a(new com.baidu.tieba.n.c(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void iq(String str) {
        if (OK(str)) {
            com.baidu.tieba.u.b.dAs().p(this.mUuid, com.baidu.tieba.u.b.a(VideoPlatformStatic.bAw(), this.lxe.cRk(), this.lxe.cRm()));
        }
    }

    @Override // com.baidu.tieba.k.f
    public boolean MC(String str) {
        if (OK(str)) {
            return this.lxe.dll();
        }
        return false;
    }

    @Override // com.baidu.tieba.k.f
    public boolean MD(String str) {
        return this.lxe.dln();
    }

    @Override // com.baidu.tieba.k.f
    public void fi(String str, String str2) {
        if (OK(str)) {
            this.lxe.a(new com.baidu.tieba.n.c(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void fj(String str, String str2) {
        if (OK(str)) {
            this.lxe.a(new com.baidu.tieba.n.c(501, str2, -4399, ""));
        }
    }

    private boolean OK(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
