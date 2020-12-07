package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes23.dex */
public class i implements com.baidu.tieba.l.f {
    private k mCp;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.mCp = new k(str);
    }

    @Override // com.baidu.tieba.l.f
    public void q(String str, int i, String str2) {
        if (Ru(str)) {
            this.mCp.dDf();
            this.mCp.a(new com.baidu.tieba.o.c(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void r(String str, int i, String str2) {
        if (Ru(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.mCp.dDf();
                this.mCp.a(new com.baidu.tieba.o.c(i, str2, i, VideoPlatformStatic.uk(i)));
                return;
            }
            this.mCp.a(new com.baidu.tieba.o.c(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void s(String str, int i, String str2) {
        if (Ru(str)) {
            this.mCp.dDf();
            this.mCp.a(new com.baidu.tieba.o.c(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void e(String str, int i, int i2, String str2) {
        if (Ru(str)) {
            this.mCp.dDf();
            this.mCp.dDd();
            this.mCp.dDh();
            this.mCp.a(new com.baidu.tieba.o.c(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void Pk(String str) {
        if (Ru(str)) {
            this.mCp.dDh();
            this.mCp.a(new com.baidu.tieba.o.c(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void Pl(String str) {
        if (Ru(str)) {
            this.mCp.dDh();
            this.mCp.dDe();
            this.mCp.a(new com.baidu.tieba.o.c(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void t(String str, int i, String str2) {
        if (Ru(str)) {
            this.mCp.dDf();
            this.mCp.dDd();
            this.mCp.dDh();
            this.mCp.a(new com.baidu.tieba.o.c(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void kt(String str) {
        if (Ru(str)) {
            com.baidu.tieba.v.b.dTi().t(this.mUuid, com.baidu.tieba.v.b.a(VideoPlatformStatic.bLP(), this.mCp.diS(), this.mCp.diU()));
        }
    }

    @Override // com.baidu.tieba.l.f
    public boolean Pm(String str) {
        if (Ru(str)) {
            return this.mCp.dDg();
        }
        return false;
    }

    @Override // com.baidu.tieba.l.f
    public boolean Pn(String str) {
        return this.mCp.dDi();
    }

    @Override // com.baidu.tieba.l.f
    public void fN(String str, String str2) {
        if (Ru(str)) {
            this.mCp.a(new com.baidu.tieba.o.c(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.f
    public void fO(String str, String str2) {
        if (Ru(str)) {
            this.mCp.a(new com.baidu.tieba.o.c(501, str2, -4399, ""));
        }
    }

    private boolean Ru(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
