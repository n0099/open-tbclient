package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes4.dex */
public class i implements com.baidu.tieba.j.f {
    private String fxs;
    private k gzU;

    public i(String str) {
        this.fxs = str;
        this.gzU = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void h(String str, int i, String str2) {
        if (tC(str)) {
            this.gzU.bqS();
            this.gzU.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void i(String str, int i, String str2) {
        if (tC(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.gzU.bqS();
                this.gzU.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.hn(i)));
                return;
            }
            this.gzU.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void j(String str, int i, String str2) {
        if (tC(str)) {
            this.gzU.bqS();
            this.gzU.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (tC(str)) {
            this.gzU.bqS();
            this.gzU.bqQ();
            this.gzU.bqU();
            this.gzU.a(new com.baidu.tieba.m.d(i, "write", i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void ru(String str) {
        if (tC(str)) {
            this.gzU.bqU();
            this.gzU.a(new com.baidu.tieba.m.d(301, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void rv(String str) {
        if (tC(str)) {
            this.gzU.bqU();
            this.gzU.bqR();
            this.gzU.a(new com.baidu.tieba.m.d(401, "write", -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void k(String str, int i, String str2) {
        if (tC(str)) {
            this.gzU.bqS();
            this.gzU.bqQ();
            this.gzU.bqU();
            this.gzU.a(new com.baidu.tieba.m.d(402, "write", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void dj(String str) {
        if (tC(str)) {
            com.baidu.tieba.s.b.bFp().g(this.fxs, com.baidu.tieba.s.b.a(VideoPlatformStatic.UA(), this.gzU.baO(), this.gzU.baQ()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean rw(String str) {
        if (tC(str)) {
            return this.gzU.bqT();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean rx(String str) {
        return this.gzU.bqV();
    }

    @Override // com.baidu.tieba.j.f
    public void cb(String str, String str2) {
        if (tC(str)) {
            this.gzU.a(new com.baidu.tieba.m.d(503, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void cc(String str, String str2) {
        if (tC(str)) {
            this.gzU.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean tC(String str) {
        return (!TextUtils.equals(this.fxs, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.fxs)) ? false : true;
    }
}
