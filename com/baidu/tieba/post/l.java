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
    private String fqx;
    private n gGG;

    public l(String str) {
        this.fqx = str;
        this.gGG = new n(str);
    }

    @Override // com.baidu.tieba.i.f
    public void i(String str, int i, String str2) {
        if (rL(str)) {
            this.gGG.brW();
            this.gGG.a(new d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void j(String str, int i, String str2) {
        if (rL(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.gGG.brW();
                this.gGG.a(new d(i, str2, i, VideoPlatformStatic.jv(i)));
                return;
            }
            this.gGG.a(new d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void k(String str, int i, String str2) {
        if (rL(str)) {
            this.gGG.brW();
            this.gGG.a(new d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void d(String str, int i, int i2, String str2) {
        if (rL(str)) {
            this.gGG.brW();
            this.gGG.brU();
            this.gGG.brY();
            this.gGG.a(new d(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void pc(String str) {
        if (rL(str)) {
            this.gGG.brY();
            this.gGG.a(new d(HttpStatus.SC_MOVED_PERMANENTLY, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void pd(String str) {
        if (rL(str)) {
            this.gGG.brY();
            this.gGG.brV();
            this.gGG.a(new d(HttpStatus.SC_UNAUTHORIZED, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void l(String str, int i, String str2) {
        if (rL(str)) {
            this.gGG.brW();
            this.gGG.brU();
            this.gGG.brY();
            this.gGG.a(new d(HttpStatus.SC_PAYMENT_REQUIRED, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void pe(String str) {
        if (rL(str)) {
            b.bGp().d(this.fqx, b.a(VideoPlatformStatic.TG(), this.gGG.aVk(), this.gGG.aVl()));
        }
    }

    @Override // com.baidu.tieba.i.f
    public boolean pf(String str) {
        if (rL(str)) {
            return this.gGG.brX();
        }
        return false;
    }

    @Override // com.baidu.tieba.i.f
    public boolean pg(String str) {
        return this.gGG.brZ();
    }

    @Override // com.baidu.tieba.i.f
    public void bA(String str, String str2) {
        if (rL(str)) {
            this.gGG.a(new d(HttpStatus.SC_SERVICE_UNAVAILABLE, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void bB(String str, String str2) {
        if (rL(str)) {
            this.gGG.a(new d(HttpStatus.SC_NOT_IMPLEMENTED, str2, -4399, ""));
        }
    }

    private boolean rL(String str) {
        return (!TextUtils.equals(this.fqx, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.fqx)) ? false : true;
    }
}
