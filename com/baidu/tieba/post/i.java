package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes5.dex */
public class i implements com.baidu.tieba.j.f {
    private k iCH;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.iCH = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void m(String str, int i, String str2) {
        if (Ca(str)) {
            this.iCH.cdR();
            this.iCH.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void n(String str, int i, String str2) {
        if (Ca(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.iCH.cdR();
                this.iCH.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.lx(i)));
                return;
            }
            this.iCH.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void o(String str, int i, String str2) {
        if (Ca(str)) {
            this.iCH.cdR();
            this.iCH.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (Ca(str)) {
            this.iCH.cdR();
            this.iCH.cdP();
            this.iCH.cdT();
            this.iCH.a(new com.baidu.tieba.m.d(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void zO(String str) {
        if (Ca(str)) {
            this.iCH.cdT();
            this.iCH.a(new com.baidu.tieba.m.d(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void zP(String str) {
        if (Ca(str)) {
            this.iCH.cdT();
            this.iCH.cdQ();
            this.iCH.a(new com.baidu.tieba.m.d(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void p(String str, int i, String str2) {
        if (Ca(str)) {
            this.iCH.cdR();
            this.iCH.cdP();
            this.iCH.cdT();
            this.iCH.a(new com.baidu.tieba.m.d(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void dK(String str) {
        if (Ca(str)) {
            com.baidu.tieba.s.b.cse().o(this.mUuid, com.baidu.tieba.s.b.a(VideoPlatformStatic.aCY(), this.iCH.bMQ(), this.iCH.bMS()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean zQ(String str) {
        if (Ca(str)) {
            return this.iCH.cdS();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean zR(String str) {
        return this.iCH.cdU();
    }

    @Override // com.baidu.tieba.j.f
    public void dr(String str, String str2) {
        if (Ca(str)) {
            this.iCH.a(new com.baidu.tieba.m.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void ds(String str, String str2) {
        if (Ca(str)) {
            this.iCH.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean Ca(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
