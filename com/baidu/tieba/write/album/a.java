package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] blY;
    private String hfi;
    private String hfj;
    private AlbumActivity hfk;
    private String[] hfl;
    private k hfm;
    private b hfn;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hfi = "tag_image";
        this.hfj = "tag_b_image";
        this.hfk = albumActivity;
    }

    public void aPQ() {
        this.blY = new Fragment[2];
        this.hfl = new String[2];
        this.hfm = new k();
        this.blY[0] = this.hfm;
        this.hfl[0] = this.hfi;
        this.hfn = new b();
        this.blY[1] = this.hfn;
        this.hfl[1] = this.hfj;
    }

    public Fragment vR(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.blY[i];
    }

    public String vS(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hfl[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.blY.length) {
                if (this.blY[i3] != null && (this.blY[i3] instanceof k)) {
                    ((k) this.blY[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bGd() {
        if (this.hfm == null) {
            return null;
        }
        return this.hfm.bGd();
    }

    public void stopCamera() {
        TbCameraView bGd = bGd();
        if (bGd != null) {
            bGd.stopCamera();
            bGd.setVisibility(4);
        }
    }

    public void bGc() {
        TbCameraView bGd = bGd();
        if (bGd != null) {
            bGd.setVisibility(0);
            bGd.mU(false);
        }
        if (this.hfm != null && this.hfm.bGB() != null) {
            this.hfm.bGB().bGC();
        }
    }

    public View bGe() {
        if (this.hfm == null) {
            return null;
        }
        return this.hfm.boM();
    }

    public View bGf() {
        if (this.hfm == null) {
            return null;
        }
        return this.hfm.bGA();
    }

    public View bGg() {
        if (this.hfn == null) {
            return null;
        }
        return this.hfn.boM();
    }

    public View bGh() {
        if (this.hfn == null) {
            return null;
        }
        return this.hfn.bGm();
    }

    public View bGi() {
        if (this.hfn == null) {
            return null;
        }
        return this.hfn.bGi();
    }

    public View bGj() {
        if (this.hfm == null) {
            return null;
        }
        return this.hfm.bGi();
    }

    public void onDestroy() {
    }

    public void nX(boolean z) {
        if (this.hfn != null) {
            this.hfn.nX(z);
        }
        if (this.hfm != null) {
            this.hfm.nX(z);
        }
    }

    public void a(l lVar) {
        if (this.hfm != null) {
            this.hfm.a(lVar);
        }
    }
}
