package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes5.dex */
public class i implements com.baidu.tieba.j.f {
    private String gXV;
    private k ibQ;

    public i(String str) {
        this.gXV = str;
        this.ibQ = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void k(String str, int i, String str2) {
        if (Ba(str)) {
            this.ibQ.bUQ();
            this.ibQ.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void l(String str, int i, String str2) {
        if (Ba(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.ibQ.bUQ();
                this.ibQ.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.lr(i)));
                return;
            }
            this.ibQ.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void m(String str, int i, String str2) {
        if (Ba(str)) {
            this.ibQ.bUQ();
            this.ibQ.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (Ba(str)) {
            this.ibQ.bUQ();
            this.ibQ.bUO();
            this.ibQ.bUS();
            this.ibQ.a(new com.baidu.tieba.m.d(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void yR(String str) {
        if (Ba(str)) {
            this.ibQ.bUS();
            this.ibQ.a(new com.baidu.tieba.m.d(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void yS(String str) {
        if (Ba(str)) {
            this.ibQ.bUS();
            this.ibQ.bUP();
            this.ibQ.a(new com.baidu.tieba.m.d(401, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void n(String str, int i, String str2) {
        if (Ba(str)) {
            this.ibQ.bUQ();
            this.ibQ.bUO();
            this.ibQ.bUS();
            this.ibQ.a(new com.baidu.tieba.m.d(402, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void dh(String str) {
        if (Ba(str)) {
            com.baidu.tieba.s.b.cip().n(this.gXV, com.baidu.tieba.s.b.a(VideoPlatformStatic.awb(), this.ibQ.bEs(), this.ibQ.bEu()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean yT(String str) {
        if (Ba(str)) {
            return this.ibQ.bUR();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean yU(String str) {
        return this.ibQ.bUT();
    }

    @Override // com.baidu.tieba.j.f
    public void dq(String str, String str2) {
        if (Ba(str)) {
            this.ibQ.a(new com.baidu.tieba.m.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void dr(String str, String str2) {
        if (Ba(str)) {
            this.ibQ.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean Ba(String str) {
        return (!TextUtils.equals(this.gXV, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.gXV)) ? false : true;
    }
}
