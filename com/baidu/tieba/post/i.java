package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes8.dex */
public class i implements com.baidu.tieba.l.e {
    private k mHJ;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.mHJ = new k(str);
    }

    @Override // com.baidu.tieba.l.e
    public void p(String str, int i, String str2) {
        if (Ra(str)) {
            this.mHJ.dCV();
            this.mHJ.a(new com.baidu.tieba.n.c(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void q(String str, int i, String str2) {
        if (Ra(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.mHJ.dCV();
                this.mHJ.a(new com.baidu.tieba.n.c(i, str2, i, VideoPlatformStatic.uw(i)));
                return;
            }
            this.mHJ.a(new com.baidu.tieba.n.c(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void r(String str, int i, String str2) {
        if (Ra(str)) {
            this.mHJ.dCV();
            this.mHJ.a(new com.baidu.tieba.n.c(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void e(String str, int i, int i2, String str2) {
        if (Ra(str)) {
            this.mHJ.dCV();
            this.mHJ.dCT();
            this.mHJ.dCX();
            this.mHJ.a(new com.baidu.tieba.n.c(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void OS(String str) {
        if (Ra(str)) {
            this.mHJ.dCX();
            this.mHJ.a(new com.baidu.tieba.n.c(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void OT(String str) {
        if (Ra(str)) {
            this.mHJ.dCX();
            this.mHJ.dCU();
            this.mHJ.a(new com.baidu.tieba.n.c(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void s(String str, int i, String str2) {
        if (Ra(str)) {
            this.mHJ.dCV();
            this.mHJ.dCT();
            this.mHJ.dCX();
            this.mHJ.a(new com.baidu.tieba.n.c(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void report(String str) {
        if (Ra(str)) {
            com.baidu.tieba.u.b.dTa().u(this.mUuid, com.baidu.tieba.u.b.a(VideoPlatformStatic.bOi(), this.mHJ.diG(), this.mHJ.diI()));
        }
    }

    @Override // com.baidu.tieba.l.e
    public boolean OU(String str) {
        if (Ra(str)) {
            return this.mHJ.dCW();
        }
        return false;
    }

    @Override // com.baidu.tieba.l.e
    public boolean OV(String str) {
        return this.mHJ.dCY();
    }

    @Override // com.baidu.tieba.l.e
    public void fO(String str, String str2) {
        if (Ra(str)) {
            this.mHJ.a(new com.baidu.tieba.n.c(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void fP(String str, String str2) {
        if (Ra(str)) {
            this.mHJ.a(new com.baidu.tieba.n.c(501, str2, -4399, ""));
        }
    }

    private boolean Ra(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
