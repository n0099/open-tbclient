package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] blX;
    private String hcs;
    private String hct;
    private AlbumActivity hcu;
    private String[] hcv;
    private k hcw;
    private b hcx;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hcs = "tag_image";
        this.hct = "tag_b_image";
        this.hcu = albumActivity;
    }

    public void aPI() {
        this.blX = new Fragment[2];
        this.hcv = new String[2];
        this.hcw = new k();
        this.blX[0] = this.hcw;
        this.hcv[0] = this.hcs;
        this.hcx = new b();
        this.blX[1] = this.hcx;
        this.hcv[1] = this.hct;
    }

    public Fragment vF(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.blX[i];
    }

    public String vG(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hcv[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.blX.length) {
                if (this.blX[i3] != null && (this.blX[i3] instanceof k)) {
                    ((k) this.blX[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bFs() {
        if (this.hcw == null) {
            return null;
        }
        return this.hcw.bFs();
    }

    public void stopCamera() {
        TbCameraView bFs = bFs();
        if (bFs != null) {
            bFs.stopCamera();
            bFs.setVisibility(4);
        }
    }

    public void bFr() {
        TbCameraView bFs = bFs();
        if (bFs != null) {
            bFs.setVisibility(0);
            bFs.mS(false);
        }
        if (this.hcw != null && this.hcw.bFQ() != null) {
            this.hcw.bFQ().bFR();
        }
    }

    public View bFt() {
        if (this.hcw == null) {
            return null;
        }
        return this.hcw.boh();
    }

    public View bFu() {
        if (this.hcw == null) {
            return null;
        }
        return this.hcw.bFP();
    }

    public View bFv() {
        if (this.hcx == null) {
            return null;
        }
        return this.hcx.boh();
    }

    public View bFw() {
        if (this.hcx == null) {
            return null;
        }
        return this.hcx.bFB();
    }

    public View bFx() {
        if (this.hcx == null) {
            return null;
        }
        return this.hcx.bFx();
    }

    public View bFy() {
        if (this.hcw == null) {
            return null;
        }
        return this.hcw.bFx();
    }

    public void onDestroy() {
    }

    public void nW(boolean z) {
        if (this.hcx != null) {
            this.hcx.nW(z);
        }
        if (this.hcw != null) {
            this.hcw.nW(z);
        }
    }

    public void a(l lVar) {
        if (this.hcw != null) {
            this.hcw.a(lVar);
        }
    }
}
