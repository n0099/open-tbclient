package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes5.dex */
public class i implements com.baidu.tieba.j.f {
    private k iBQ;
    private String mUuid;

    public i(String str) {
        this.mUuid = str;
        this.iBQ = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void m(String str, int i, String str2) {
        if (Ca(str)) {
            this.iBQ.cdP();
            this.iBQ.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void n(String str, int i, String str2) {
        if (Ca(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.iBQ.cdP();
                this.iBQ.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.lw(i)));
                return;
            }
            this.iBQ.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void o(String str, int i, String str2) {
        if (Ca(str)) {
            this.iBQ.cdP();
            this.iBQ.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (Ca(str)) {
            this.iBQ.cdP();
            this.iBQ.cdN();
            this.iBQ.cdR();
            this.iBQ.a(new com.baidu.tieba.m.d(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void zO(String str) {
        if (Ca(str)) {
            this.iBQ.cdR();
            this.iBQ.a(new com.baidu.tieba.m.d(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void zP(String str) {
        if (Ca(str)) {
            this.iBQ.cdR();
            this.iBQ.cdO();
            this.iBQ.a(new com.baidu.tieba.m.d(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void p(String str, int i, String str2) {
        if (Ca(str)) {
            this.iBQ.cdP();
            this.iBQ.cdN();
            this.iBQ.cdR();
            this.iBQ.a(new com.baidu.tieba.m.d(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void dK(String str) {
        if (Ca(str)) {
            com.baidu.tieba.s.b.csc().o(this.mUuid, com.baidu.tieba.s.b.a(VideoPlatformStatic.aCW(), this.iBQ.bMO(), this.iBQ.bMQ()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean zQ(String str) {
        if (Ca(str)) {
            return this.iBQ.cdQ();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean zR(String str) {
        return this.iBQ.cdS();
    }

    @Override // com.baidu.tieba.j.f
    public void dr(String str, String str2) {
        if (Ca(str)) {
            this.iBQ.a(new com.baidu.tieba.m.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void ds(String str, String str2) {
        if (Ca(str)) {
            this.iBQ.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean Ca(String str) {
        return (!TextUtils.equals(this.mUuid, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) ? false : true;
    }
}
