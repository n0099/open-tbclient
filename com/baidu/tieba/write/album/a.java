package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] bmc;
    private String hfn;
    private String hfo;
    private AlbumActivity hfp;
    private String[] hfq;
    private k hfr;
    private b hfs;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hfn = "tag_image";
        this.hfo = "tag_b_image";
        this.hfp = albumActivity;
    }

    public void aPR() {
        this.bmc = new Fragment[2];
        this.hfq = new String[2];
        this.hfr = new k();
        this.bmc[0] = this.hfr;
        this.hfq[0] = this.hfn;
        this.hfs = new b();
        this.bmc[1] = this.hfs;
        this.hfq[1] = this.hfo;
    }

    public Fragment vR(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bmc[i];
    }

    public String vS(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hfq[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bmc.length) {
                if (this.bmc[i3] != null && (this.bmc[i3] instanceof k)) {
                    ((k) this.bmc[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bGe() {
        if (this.hfr == null) {
            return null;
        }
        return this.hfr.bGe();
    }

    public void stopCamera() {
        TbCameraView bGe = bGe();
        if (bGe != null) {
            bGe.stopCamera();
            bGe.setVisibility(4);
        }
    }

    public void bGd() {
        TbCameraView bGe = bGe();
        if (bGe != null) {
            bGe.setVisibility(0);
            bGe.mU(false);
        }
        if (this.hfr != null && this.hfr.bGC() != null) {
            this.hfr.bGC().bGD();
        }
    }

    public View bGf() {
        if (this.hfr == null) {
            return null;
        }
        return this.hfr.boN();
    }

    public View bGg() {
        if (this.hfr == null) {
            return null;
        }
        return this.hfr.bGB();
    }

    public View bGh() {
        if (this.hfs == null) {
            return null;
        }
        return this.hfs.boN();
    }

    public View bGi() {
        if (this.hfs == null) {
            return null;
        }
        return this.hfs.bGn();
    }

    public View bGj() {
        if (this.hfs == null) {
            return null;
        }
        return this.hfs.bGj();
    }

    public View bGk() {
        if (this.hfr == null) {
            return null;
        }
        return this.hfr.bGj();
    }

    public void onDestroy() {
    }

    public void nX(boolean z) {
        if (this.hfs != null) {
            this.hfs.nX(z);
        }
        if (this.hfr != null) {
            this.hfr.nX(z);
        }
    }

    public void a(l lVar) {
        if (this.hfr != null) {
            this.hfr.a(lVar);
        }
    }
}
