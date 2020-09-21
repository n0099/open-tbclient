package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes22.dex */
public class i implements com.baidu.tieba.k.f {
    private k lGg;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.lGg = new k(str);
    }

    @Override // com.baidu.tieba.k.f
    public void n(String str, int i, String str2) {
        if (Pm(str)) {
            this.lGg.doU();
            this.lGg.a(new com.baidu.tieba.n.c(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void o(String str, int i, String str2) {
        if (Pm(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.lGg.doU();
                this.lGg.a(new com.baidu.tieba.n.c(i, str2, i, VideoPlatformStatic.sp(i)));
                return;
            }
            this.lGg.a(new com.baidu.tieba.n.c(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void p(String str, int i, String str2) {
        if (Pm(str)) {
            this.lGg.doU();
            this.lGg.a(new com.baidu.tieba.n.c(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void e(String str, int i, int i2, String str2) {
        if (Pm(str)) {
            this.lGg.doU();
            this.lGg.doS();
            this.lGg.doW();
            this.lGg.a(new com.baidu.tieba.n.c(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void Nd(String str) {
        if (Pm(str)) {
            this.lGg.doW();
            this.lGg.a(new com.baidu.tieba.n.c(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void Ne(String str) {
        if (Pm(str)) {
            this.lGg.doW();
            this.lGg.doT();
            this.lGg.a(new com.baidu.tieba.n.c(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void q(String str, int i, String str2) {
        if (Pm(str)) {
            this.lGg.doU();
            this.lGg.doS();
            this.lGg.doW();
            this.lGg.a(new com.baidu.tieba.n.c(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void iK(String str) {
        if (Pm(str)) {
            com.baidu.tieba.u.b.dEv().q(this.mUuid, com.baidu.tieba.u.b.a(VideoPlatformStatic.bBJ(), this.lGg.cUR(), this.lGg.cUT()));
        }
    }

    @Override // com.baidu.tieba.k.f
    public boolean Nf(String str) {
        if (Pm(str)) {
            return this.lGg.doV();
        }
        return false;
    }

    @Override // com.baidu.tieba.k.f
    public boolean Ng(String str) {
        return this.lGg.doX();
    }

    @Override // com.baidu.tieba.k.f
    public void fw(String str, String str2) {
        if (Pm(str)) {
            this.lGg.a(new com.baidu.tieba.n.c(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void fx(String str, String str2) {
        if (Pm(str)) {
            this.lGg.a(new com.baidu.tieba.n.c(501, str2, -4399, ""));
        }
    }

    private boolean Pm(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
