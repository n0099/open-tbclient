package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes7.dex */
public class i implements com.baidu.tieba.l.e {
    private k mOz;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.mOz = new k(str);
    }

    @Override // com.baidu.tieba.l.e
    public void q(String str, int i, String str2) {
        if (QQ(str)) {
            this.mOz.dBD();
            this.mOz.a(new com.baidu.tieba.n.c(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void r(String str, int i, String str2) {
        if (QQ(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.mOz.dBD();
                this.mOz.a(new com.baidu.tieba.n.c(i, str2, i, VideoPlatformStatic.sX(i)));
                return;
            }
            this.mOz.a(new com.baidu.tieba.n.c(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void s(String str, int i, String str2) {
        if (QQ(str)) {
            this.mOz.dBD();
            this.mOz.a(new com.baidu.tieba.n.c(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void e(String str, int i, int i2, String str2) {
        if (QQ(str)) {
            this.mOz.dBD();
            this.mOz.dBB();
            this.mOz.dBF();
            this.mOz.a(new com.baidu.tieba.n.c(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void OF(String str) {
        if (QQ(str)) {
            this.mOz.dBF();
            this.mOz.a(new com.baidu.tieba.n.c(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void OG(String str) {
        if (QQ(str)) {
            this.mOz.dBF();
            this.mOz.dBC();
            this.mOz.a(new com.baidu.tieba.n.c(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void t(String str, int i, String str2) {
        if (QQ(str)) {
            this.mOz.dBD();
            this.mOz.dBB();
            this.mOz.dBF();
            this.mOz.a(new com.baidu.tieba.n.c(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void report(String str) {
        if (QQ(str)) {
            com.baidu.tieba.u.b.dRK().v(this.mUuid, com.baidu.tieba.u.b.a(VideoPlatformStatic.bKU(), this.mOz.dhf(), this.mOz.dhh()));
        }
    }

    @Override // com.baidu.tieba.l.e
    public boolean OH(String str) {
        if (QQ(str)) {
            return this.mOz.dBE();
        }
        return false;
    }

    @Override // com.baidu.tieba.l.e
    public boolean OI(String str) {
        return this.mOz.dBG();
    }

    @Override // com.baidu.tieba.l.e
    public void fN(String str, String str2) {
        if (QQ(str)) {
            this.mOz.a(new com.baidu.tieba.n.c(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void fO(String str, String str2) {
        if (QQ(str)) {
            this.mOz.a(new com.baidu.tieba.n.c(501, str2, -4399, ""));
        }
    }

    private boolean QQ(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
