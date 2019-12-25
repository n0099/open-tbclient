package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes7.dex */
public class i implements com.baidu.tieba.j.f {
    private k jwa;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.jwa = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void p(String str, int i, String str2) {
        if (GM(str)) {
            this.jwa.cxI();
            this.jwa.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void q(String str, int i, String str2) {
        if (GM(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.jwa.cxI();
                this.jwa.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.nK(i)));
                return;
            }
            this.jwa.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void r(String str, int i, String str2) {
        if (GM(str)) {
            this.jwa.cxI();
            this.jwa.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (GM(str)) {
            this.jwa.cxI();
            this.jwa.cxG();
            this.jwa.cxK();
            this.jwa.a(new com.baidu.tieba.m.d(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void Ew(String str) {
        if (GM(str)) {
            this.jwa.cxK();
            this.jwa.a(new com.baidu.tieba.m.d(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void Ex(String str) {
        if (GM(str)) {
            this.jwa.cxK();
            this.jwa.cxH();
            this.jwa.a(new com.baidu.tieba.m.d(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void s(String str, int i, String str2) {
        if (GM(str)) {
            this.jwa.cxI();
            this.jwa.cxG();
            this.jwa.cxK();
            this.jwa.a(new com.baidu.tieba.m.d(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void eB(String str) {
        if (GM(str)) {
            com.baidu.tieba.t.b.cMe().q(this.mUuid, com.baidu.tieba.t.b.a(VideoPlatformStatic.aUP(), this.jwa.cea(), this.jwa.cec()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean Ey(String str) {
        if (GM(str)) {
            return this.jwa.cxJ();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean Ez(String str) {
        return this.jwa.cxL();
    }

    @Override // com.baidu.tieba.j.f
    public void dK(String str, String str2) {
        if (GM(str)) {
            this.jwa.a(new com.baidu.tieba.m.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void dL(String str, String str2) {
        if (GM(str)) {
            this.jwa.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean GM(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
