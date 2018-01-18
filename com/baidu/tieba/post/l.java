package com.baidu.tieba.post;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.tieba.i.f;
import com.baidu.tieba.l.d;
import com.baidu.tieba.q.b;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class l implements f {
    private String frY;
    private n gvP;

    public l(String str) {
        this.frY = str;
        this.gvP = new n(str);
    }

    @Override // com.baidu.tieba.i.f
    public void i(String str, int i, String str2) {
        if (rf(str)) {
            this.gvP.blp();
            this.gvP.a(new d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void j(String str, int i, String str2) {
        if (rf(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.gvP.blp();
                this.gvP.a(new d(i, str2, i, VideoPlatformStatic.jr(i)));
                return;
            }
            this.gvP.a(new d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void k(String str, int i, String str2) {
        if (rf(str)) {
            this.gvP.blp();
            this.gvP.a(new d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void d(String str, int i, int i2, String str2) {
        if (rf(str)) {
            this.gvP.blp();
            this.gvP.bln();
            this.gvP.blr();
            this.gvP.a(new d(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void pf(String str) {
        if (rf(str)) {
            this.gvP.blr();
            this.gvP.a(new d(HttpStatus.SC_MOVED_PERMANENTLY, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void pg(String str) {
        if (rf(str)) {
            this.gvP.blr();
            this.gvP.blo();
            this.gvP.a(new d(HttpStatus.SC_UNAUTHORIZED, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void l(String str, int i, String str2) {
        if (rf(str)) {
            this.gvP.blp();
            this.gvP.bln();
            this.gvP.blr();
            this.gvP.a(new d(HttpStatus.SC_PAYMENT_REQUIRED, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void ph(String str) {
        if (rf(str)) {
            b.bzM().d(this.frY, b.a(VideoPlatformStatic.Tu(), this.gvP.aVp(), this.gvP.aVq()));
        }
    }

    @Override // com.baidu.tieba.i.f
    public boolean pi(String str) {
        if (rf(str)) {
            return this.gvP.blq();
        }
        return false;
    }

    @Override // com.baidu.tieba.i.f
    public boolean pj(String str) {
        return this.gvP.bls();
    }

    @Override // com.baidu.tieba.i.f
    public void bz(String str, String str2) {
        if (rf(str)) {
            this.gvP.a(new d(HttpStatus.SC_SERVICE_UNAVAILABLE, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void bA(String str, String str2) {
        if (rf(str)) {
            this.gvP.a(new d(HttpStatus.SC_NOT_IMPLEMENTED, str2, -4399, ""));
        }
    }

    private boolean rf(String str) {
        return (!TextUtils.equals(this.frY, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.frY)) ? false : true;
    }
}
