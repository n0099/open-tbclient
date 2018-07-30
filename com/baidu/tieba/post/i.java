package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class i implements com.baidu.tieba.j.f {
    private String fhf;
    private k gjA;

    public i(String str) {
        this.fhf = str;
        this.gjA = new k(str);
    }

    @Override // com.baidu.tieba.j.f
    public void i(String str, int i, String str2) {
        if (sm(str)) {
            this.gjA.blE();
            this.gjA.a(new com.baidu.tieba.m.d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void j(String str, int i, String str2) {
        if (sm(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.gjA.blE();
                this.gjA.a(new com.baidu.tieba.m.d(i, str2, i, VideoPlatformStatic.gt(i)));
                return;
            }
            this.gjA.a(new com.baidu.tieba.m.d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void k(String str, int i, String str2) {
        if (sm(str)) {
            this.gjA.blE();
            this.gjA.a(new com.baidu.tieba.m.d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void e(String str, int i, int i2, String str2) {
        if (sm(str)) {
            this.gjA.blE();
            this.gjA.blC();
            this.gjA.blG();
            this.gjA.a(new com.baidu.tieba.m.d(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void ql(String str) {
        if (sm(str)) {
            this.gjA.blG();
            this.gjA.a(new com.baidu.tieba.m.d(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void qm(String str) {
        if (sm(str)) {
            this.gjA.blG();
            this.gjA.blD();
            this.gjA.a(new com.baidu.tieba.m.d(HttpStatus.SC_UNAUTHORIZED, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void l(String str, int i, String str2) {
        if (sm(str)) {
            this.gjA.blE();
            this.gjA.blC();
            this.gjA.blG();
            this.gjA.a(new com.baidu.tieba.m.d(HttpStatus.SC_PAYMENT_REQUIRED, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void qn(String str) {
        if (sm(str)) {
            com.baidu.tieba.s.b.bzL().f(this.fhf, com.baidu.tieba.s.b.a(VideoPlatformStatic.QC(), this.gjA.aVV(), this.gjA.aVW()));
        }
    }

    @Override // com.baidu.tieba.j.f
    public boolean qo(String str) {
        if (sm(str)) {
            return this.gjA.blF();
        }
        return false;
    }

    @Override // com.baidu.tieba.j.f
    public boolean qp(String str) {
        return this.gjA.blH();
    }

    @Override // com.baidu.tieba.j.f
    public void bH(String str, String str2) {
        if (sm(str)) {
            this.gjA.a(new com.baidu.tieba.m.d(HttpStatus.SC_SERVICE_UNAVAILABLE, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.j.f
    public void bI(String str, String str2) {
        if (sm(str)) {
            this.gjA.a(new com.baidu.tieba.m.d(501, str2, -4399, ""));
        }
    }

    private boolean sm(String str) {
        return (!TextUtils.equals(this.fhf, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.fhf)) ? false : true;
    }
}
