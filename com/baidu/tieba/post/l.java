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
    private String fst;
    private n gwk;

    public l(String str) {
        this.fst = str;
        this.gwk = new n(str);
    }

    @Override // com.baidu.tieba.i.f
    public void i(String str, int i, String str2) {
        if (rm(str)) {
            this.gwk.blq();
            this.gwk.a(new d(i, "record", i, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void j(String str, int i, String str2) {
        if (rm(str)) {
            if (i == 103 || i == 105 || i == 106 || i == 107 || i == 104) {
                this.gwk.blq();
                this.gwk.a(new d(i, str2, i, VideoPlatformStatic.jr(i)));
                return;
            }
            this.gwk.a(new d(i, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void k(String str, int i, String str2) {
        if (rm(str)) {
            this.gwk.blq();
            this.gwk.a(new d(i, "edit", i, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void d(String str, int i, int i2, String str2) {
        if (rm(str)) {
            this.gwk.blq();
            this.gwk.blo();
            this.gwk.bls();
            this.gwk.a(new d(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void pm(String str) {
        if (rm(str)) {
            this.gwk.bls();
            this.gwk.a(new d(HttpStatus.SC_MOVED_PERMANENTLY, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void pn(String str) {
        if (rm(str)) {
            this.gwk.bls();
            this.gwk.blp();
            this.gwk.a(new d(HttpStatus.SC_UNAUTHORIZED, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void l(String str, int i, String str2) {
        if (rm(str)) {
            this.gwk.blq();
            this.gwk.blo();
            this.gwk.bls();
            this.gwk.a(new d(HttpStatus.SC_PAYMENT_REQUIRED, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void po(String str) {
        if (rm(str)) {
            b.bzO().d(this.fst, b.a(VideoPlatformStatic.Tw(), this.gwk.aVu(), this.gwk.aVv()));
        }
    }

    @Override // com.baidu.tieba.i.f
    public boolean pp(String str) {
        if (rm(str)) {
            return this.gwk.blr();
        }
        return false;
    }

    @Override // com.baidu.tieba.i.f
    public boolean pq(String str) {
        return this.gwk.blt();
    }

    @Override // com.baidu.tieba.i.f
    public void by(String str, String str2) {
        if (rm(str)) {
            this.gwk.a(new d(HttpStatus.SC_SERVICE_UNAVAILABLE, str2, -4399, ""));
        }
    }

    @Override // com.baidu.tieba.i.f
    public void bz(String str, String str2) {
        if (rm(str)) {
            this.gwk.a(new d(HttpStatus.SC_NOT_IMPLEMENTED, str2, -4399, ""));
        }
    }

    private boolean rm(String str) {
        return (!TextUtils.equals(this.fst, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.fst)) ? false : true;
    }
}
