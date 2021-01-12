package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes7.dex */
public class i implements com.baidu.tieba.l.e {
    private k mDa;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.mDa = new k(str);
    }

    @Override // com.baidu.tieba.l.e
    public void p(String str, int i, String str2) {
        if (PR(str)) {
            this.mDa.dze();
            this.mDa.a(new com.baidu.tieba.n.c(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void q(String str, int i, String str2) {
        if (PR(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.mDa.dze();
                this.mDa.a(new com.baidu.tieba.n.c(i, str2, i, VideoPlatformStatic.sQ(i)));
                return;
            }
            this.mDa.a(new com.baidu.tieba.n.c(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void r(String str, int i, String str2) {
        if (PR(str)) {
            this.mDa.dze();
            this.mDa.a(new com.baidu.tieba.n.c(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void e(String str, int i, int i2, String str2) {
        if (PR(str)) {
            this.mDa.dze();
            this.mDa.dzc();
            this.mDa.dzg();
            this.mDa.a(new com.baidu.tieba.n.c(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void NJ(String str) {
        if (PR(str)) {
            this.mDa.dzg();
            this.mDa.a(new com.baidu.tieba.n.c(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void NK(String str) {
        if (PR(str)) {
            this.mDa.dzg();
            this.mDa.dzd();
            this.mDa.a(new com.baidu.tieba.n.c(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void s(String str, int i, String str2) {
        if (PR(str)) {
            this.mDa.dze();
            this.mDa.dzc();
            this.mDa.dzg();
            this.mDa.a(new com.baidu.tieba.n.c(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void report(String str) {
        if (PR(str)) {
            com.baidu.tieba.u.b.dPj().u(this.mUuid, com.baidu.tieba.u.b.a(VideoPlatformStatic.bKr(), this.mDa.deP(), this.mDa.deR()));
        }
    }

    @Override // com.baidu.tieba.l.e
    public boolean NL(String str) {
        if (PR(str)) {
            return this.mDa.dzf();
        }
        return false;
    }

    @Override // com.baidu.tieba.l.e
    public boolean NM(String str) {
        return this.mDa.dzh();
    }

    @Override // com.baidu.tieba.l.e
    public void fN(String str, String str2) {
        if (PR(str)) {
            this.mDa.a(new com.baidu.tieba.n.c(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.l.e
    public void fO(String str, String str2) {
        if (PR(str)) {
            this.mDa.a(new com.baidu.tieba.n.c(501, str2, -4399, ""));
        }
    }

    private boolean PR(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
