package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes8.dex */
public class i implements com.baidu.tieba.l.e {
    private k mMx;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.mMx = new k(str);
    }

    @Override // com.baidu.tieba.l.e
    public void p(String str, int i, String str2) {
        if (QK(str)) {
            this.mMx.dBv();
            this.mMx.a(new com.baidu.tieba.n.c(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void q(String str, int i, String str2) {
        if (QK(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.mMx.dBv();
                this.mMx.a(new com.baidu.tieba.n.c(i, str2, i, VideoPlatformStatic.sV(i)));
                return;
            }
            this.mMx.a(new com.baidu.tieba.n.c(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void r(String str, int i, String str2) {
        if (QK(str)) {
            this.mMx.dBv();
            this.mMx.a(new com.baidu.tieba.n.c(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void e(String str, int i, int i2, String str2) {
        if (QK(str)) {
            this.mMx.dBv();
            this.mMx.dBt();
            this.mMx.dBx();
            this.mMx.a(new com.baidu.tieba.n.c(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void Oz(String str) {
        if (QK(str)) {
            this.mMx.dBx();
            this.mMx.a(new com.baidu.tieba.n.c(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void OA(String str) {
        if (QK(str)) {
            this.mMx.dBx();
            this.mMx.dBu();
            this.mMx.a(new com.baidu.tieba.n.c(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void s(String str, int i, String str2) {
        if (QK(str)) {
            this.mMx.dBv();
            this.mMx.dBt();
            this.mMx.dBx();
            this.mMx.a(new com.baidu.tieba.n.c(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void report(String str) {
        if (QK(str)) {
            com.baidu.tieba.u.b.dRC().u(this.mUuid, com.baidu.tieba.u.b.a(VideoPlatformStatic.bKQ(), this.mMx.dgW(), this.mMx.dgY()));
        }
    }

    @Override // com.baidu.tieba.l.e
    public boolean OB(String str) {
        if (QK(str)) {
            return this.mMx.dBw();
        }
        return false;
    }

    @Override // com.baidu.tieba.l.e
    public boolean OC(String str) {
        return this.mMx.dBy();
    }

    @Override // com.baidu.tieba.l.e
    public void fN(String str, String str2) {
        if (QK(str)) {
            this.mMx.a(new com.baidu.tieba.n.c(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void fO(String str, String str2) {
        if (QK(str)) {
            this.mMx.a(new com.baidu.tieba.n.c(501, str2, -4399, ""));
        }
    }

    private boolean QK(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
