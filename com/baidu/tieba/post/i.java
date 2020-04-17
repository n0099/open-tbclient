package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes10.dex */
public class i implements com.baidu.tieba.k.f {
    private k kmp;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.kmp = new k(str);
    }

    @Override // com.baidu.tieba.k.f
    public void q(String str, int i, String str2) {
        if (IS(str)) {
            this.kmp.cLu();
            this.kmp.a(new com.baidu.tieba.n.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void r(String str, int i, String str2) {
        if (IS(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.kmp.cLu();
                this.kmp.a(new com.baidu.tieba.n.d(i, str2, i, VideoPlatformStatic.oq(i)));
                return;
            }
            this.kmp.a(new com.baidu.tieba.n.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void s(String str, int i, String str2) {
        if (IS(str)) {
            this.kmp.cLu();
            this.kmp.a(new com.baidu.tieba.n.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void e(String str, int i, int i2, String str2) {
        if (IS(str)) {
            this.kmp.cLu();
            this.kmp.cLs();
            this.kmp.cLw();
            this.kmp.a(new com.baidu.tieba.n.d(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void GE(String str) {
        if (IS(str)) {
            this.kmp.cLw();
            this.kmp.a(new com.baidu.tieba.n.d(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void GF(String str) {
        if (IS(str)) {
            this.kmp.cLw();
            this.kmp.cLt();
            this.kmp.a(new com.baidu.tieba.n.d(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void t(String str, int i, String str2) {
        if (IS(str)) {
            this.kmp.cLu();
            this.kmp.cLs();
            this.kmp.cLw();
            this.kmp.a(new com.baidu.tieba.n.d(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void ge(String str) {
        if (IS(str)) {
            com.baidu.tieba.u.b.daa().p(this.mUuid, com.baidu.tieba.u.b.a(VideoPlatformStatic.bfL(), this.kmp.crR(), this.kmp.crT()));
        }
    }

    @Override // com.baidu.tieba.k.f
    public boolean GG(String str) {
        if (IS(str)) {
            return this.kmp.cLv();
        }
        return false;
    }

    @Override // com.baidu.tieba.k.f
    public boolean GH(String str) {
        return this.kmp.cLx();
    }

    @Override // com.baidu.tieba.k.f
    public void ei(String str, String str2) {
        if (IS(str)) {
            this.kmp.a(new com.baidu.tieba.n.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.k.f
    public void ej(String str, String str2) {
        if (IS(str)) {
            this.kmp.a(new com.baidu.tieba.n.d(501, str2, -4399, ""));
        }
    }

    private boolean IS(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
