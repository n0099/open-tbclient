package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes23.dex */
public class i implements com.baidu.tieba.k.f {
    private String mUuid;
    private k mnR;

    public i(String str) {
        this.mUuid = str;
        this.mnR = new k(str);
    }

    @Override // com.baidu.tieba.k.f
    public void q(String str, int i, String str2) {
        if (QQ(str)) {
            this.mnR.dyo();
            this.mnR.a(new com.baidu.tieba.n.c(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void r(String str, int i, String str2) {
        if (QQ(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.mnR.dyo();
                this.mnR.a(new com.baidu.tieba.n.c(i, str2, i, VideoPlatformStatic.ti(i)));
                return;
            }
            this.mnR.a(new com.baidu.tieba.n.c(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void s(String str, int i, String str2) {
        if (QQ(str)) {
            this.mnR.dyo();
            this.mnR.a(new com.baidu.tieba.n.c(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void e(String str, int i, int i2, String str2) {
        if (QQ(str)) {
            this.mnR.dyo();
            this.mnR.dym();
            this.mnR.dyq();
            this.mnR.a(new com.baidu.tieba.n.c(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void OH(String str) {
        if (QQ(str)) {
            this.mnR.dyq();
            this.mnR.a(new com.baidu.tieba.n.c(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void OI(String str) {
        if (QQ(str)) {
            this.mnR.dyq();
            this.mnR.dyn();
            this.mnR.a(new com.baidu.tieba.n.c(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void t(String str, int i, String str2) {
        if (QQ(str)) {
            this.mnR.dyo();
            this.mnR.dym();
            this.mnR.dyq();
            this.mnR.a(new com.baidu.tieba.n.c(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void jS(String str) {
        if (QQ(str)) {
            com.baidu.tieba.u.b.dNR().v(this.mUuid, com.baidu.tieba.u.b.a(VideoPlatformStatic.bIN(), this.mnR.dek(), this.mnR.dem()));
        }
    }

    @Override // com.baidu.tieba.k.f
    public boolean OJ(String str) {
        if (QQ(str)) {
            return this.mnR.dyp();
        }
        return false;
    }

    @Override // com.baidu.tieba.k.f
    public boolean OK(String str) {
        return this.mnR.dyr();
    }

    @Override // com.baidu.tieba.k.f
    public void fI(String str, String str2) {
        if (QQ(str)) {
            this.mnR.a(new com.baidu.tieba.n.c(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void fJ(String str, String str2) {
        if (QQ(str)) {
            this.mnR.a(new com.baidu.tieba.n.c(501, str2, -4399, ""));
        }
    }

    private boolean QQ(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
