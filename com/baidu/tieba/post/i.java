package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes8.dex */
public class i implements com.baidu.tieba.l.e {
    private k mHI;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.mHI = new k(str);
    }

    @Override // com.baidu.tieba.l.e
    public void p(String str, int i, String str2) {
        if (QZ(str)) {
            this.mHI.dCW();
            this.mHI.a(new com.baidu.tieba.n.c(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void q(String str, int i, String str2) {
        if (QZ(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.mHI.dCW();
                this.mHI.a(new com.baidu.tieba.n.c(i, str2, i, VideoPlatformStatic.uw(i)));
                return;
            }
            this.mHI.a(new com.baidu.tieba.n.c(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void r(String str, int i, String str2) {
        if (QZ(str)) {
            this.mHI.dCW();
            this.mHI.a(new com.baidu.tieba.n.c(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void e(String str, int i, int i2, String str2) {
        if (QZ(str)) {
            this.mHI.dCW();
            this.mHI.dCU();
            this.mHI.dCY();
            this.mHI.a(new com.baidu.tieba.n.c(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void OR(String str) {
        if (QZ(str)) {
            this.mHI.dCY();
            this.mHI.a(new com.baidu.tieba.n.c(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void OS(String str) {
        if (QZ(str)) {
            this.mHI.dCY();
            this.mHI.dCV();
            this.mHI.a(new com.baidu.tieba.n.c(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void s(String str, int i, String str2) {
        if (QZ(str)) {
            this.mHI.dCW();
            this.mHI.dCU();
            this.mHI.dCY();
            this.mHI.a(new com.baidu.tieba.n.c(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void report(String str) {
        if (QZ(str)) {
            com.baidu.tieba.u.b.dTb().u(this.mUuid, com.baidu.tieba.u.b.a(VideoPlatformStatic.bOj(), this.mHI.diH(), this.mHI.diJ()));
        }
    }

    @Override // com.baidu.tieba.l.e
    public boolean OT(String str) {
        if (QZ(str)) {
            return this.mHI.dCX();
        }
        return false;
    }

    @Override // com.baidu.tieba.l.e
    public boolean OU(String str) {
        return this.mHI.dCZ();
    }

    @Override // com.baidu.tieba.l.e
    public void fO(String str, String str2) {
        if (QZ(str)) {
            this.mHI.a(new com.baidu.tieba.n.c(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void fP(String str, String str2) {
        if (QZ(str)) {
            this.mHI.a(new com.baidu.tieba.n.c(501, str2, -4399, ""));
        }
    }

    private boolean QZ(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
