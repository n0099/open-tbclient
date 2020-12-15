package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes23.dex */
public class i implements com.baidu.tieba.l.f {
    private k mCr;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.mCr = new k(str);
    }

    @Override // com.baidu.tieba.l.f
    public void q(String str, int i, String str2) {
        if (Ru(str)) {
            this.mCr.dDg();
            this.mCr.a(new com.baidu.tieba.o.c(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void r(String str, int i, String str2) {
        if (Ru(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.mCr.dDg();
                this.mCr.a(new com.baidu.tieba.o.c(i, str2, i, VideoPlatformStatic.uk(i)));
                return;
            }
            this.mCr.a(new com.baidu.tieba.o.c(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void s(String str, int i, String str2) {
        if (Ru(str)) {
            this.mCr.dDg();
            this.mCr.a(new com.baidu.tieba.o.c(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void e(String str, int i, int i2, String str2) {
        if (Ru(str)) {
            this.mCr.dDg();
            this.mCr.dDe();
            this.mCr.dDi();
            this.mCr.a(new com.baidu.tieba.o.c(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void Pk(String str) {
        if (Ru(str)) {
            this.mCr.dDi();
            this.mCr.a(new com.baidu.tieba.o.c(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void Pl(String str) {
        if (Ru(str)) {
            this.mCr.dDi();
            this.mCr.dDf();
            this.mCr.a(new com.baidu.tieba.o.c(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void t(String str, int i, String str2) {
        if (Ru(str)) {
            this.mCr.dDg();
            this.mCr.dDe();
            this.mCr.dDi();
            this.mCr.a(new com.baidu.tieba.o.c(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void kt(String str) {
        if (Ru(str)) {
            com.baidu.tieba.v.b.dTj().t(this.mUuid, com.baidu.tieba.v.b.a(VideoPlatformStatic.bLQ(), this.mCr.diT(), this.mCr.diV()));
        }
    }

    @Override // com.baidu.tieba.l.f
    public boolean Pm(String str) {
        if (Ru(str)) {
            return this.mCr.dDh();
        }
        return false;
    }

    @Override // com.baidu.tieba.l.f
    public boolean Pn(String str) {
        return this.mCr.dDj();
    }

    @Override // com.baidu.tieba.l.f
    public void fN(String str, String str2) {
        if (Ru(str)) {
            this.mCr.a(new com.baidu.tieba.o.c(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void fO(String str, String str2) {
        if (Ru(str)) {
            this.mCr.a(new com.baidu.tieba.o.c(501, str2, -4399, ""));
        }
    }

    private boolean Ru(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
