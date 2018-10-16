package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes4.dex */
public class i implements com.baidu.tieba.j.f {
    private String fwc;
    private k gys;

    public i(String str) {
        this.fwc = str;
        this.gys = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void h(String str, int i, String str2) {
        if (tx(str)) {
            this.gys.brw();
            this.gys.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void i(String str, int i, String str2) {
        if (tx(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.gys.brw();
                this.gys.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.ha(i)));
                return;
            }
            this.gys.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void j(String str, int i, String str2) {
        if (tx(str)) {
            this.gys.brw();
            this.gys.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (tx(str)) {
            this.gys.brw();
            this.gys.bru();
            this.gys.bry();
            this.gys.a(new com.baidu.tieba.m.d(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void rt(String str) {
        if (tx(str)) {
            this.gys.bry();
            this.gys.a(new com.baidu.tieba.m.d(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void ru(String str) {
        if (tx(str)) {
            this.gys.bry();
            this.gys.brv();
            this.gys.a(new com.baidu.tieba.m.d(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void k(String str, int i, String str2) {
        if (tx(str)) {
            this.gys.brw();
            this.gys.bru();
            this.gys.bry();
            this.gys.a(new com.baidu.tieba.m.d(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void dj(String str) {
        if (tx(str)) {
            com.baidu.tieba.s.b.bFQ().g(this.fwc, com.baidu.tieba.s.b.a(VideoPlatformStatic.Ur(), this.gys.bbr(), this.gys.bbs()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean rv(String str) {
        if (tx(str)) {
            return this.gys.brx();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean rw(String str) {
        return this.gys.brz();
    }

    @Override // com.baidu.tieba.j.f
    public void cb(String str, String str2) {
        if (tx(str)) {
            this.gys.a(new com.baidu.tieba.m.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void cc(String str, String str2) {
        if (tx(str)) {
            this.gys.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean tx(String str) {
        return (!TextUtils.equals(this.fwc, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.fwc)) ? false : true;
    }
}
