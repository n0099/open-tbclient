package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] cbE;
    private String hET;
    private String hEU;
    private AlbumActivity hEV;
    private String[] hEW;
    private k hEX;
    private b hEY;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hET = "tag_image";
        this.hEU = "tag_b_image";
        this.hEV = albumActivity;
    }

    public void aYU() {
        this.cbE = new Fragment[2];
        this.hEW = new String[2];
        this.hEX = new k();
        this.cbE[0] = this.hEX;
        this.hEW[0] = this.hET;
        this.hEY = new b();
        this.cbE[1] = this.hEY;
        this.hEW[1] = this.hEU;
    }

    public Fragment xl(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.cbE[i];
    }

    public String xm(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hEW[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cbE.length) {
                if (this.cbE[i3] != null && (this.cbE[i3] instanceof k)) {
                    ((k) this.cbE[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bGg() {
        if (this.hEX == null) {
            return null;
        }
        return this.hEX.bGg();
    }

    public void stopCamera() {
        TbCameraView bGg = bGg();
        if (bGg != null) {
            bGg.stopCamera();
            bGg.setVisibility(4);
        }
    }

    public void bGf() {
        TbCameraView bGg = bGg();
        if (bGg != null) {
            bGg.setVisibility(0);
            bGg.nN(false);
        }
        if (this.hEX != null && this.hEX.bGE() != null) {
            this.hEX.bGE().bGJ();
        }
    }

    public View bGh() {
        if (this.hEX == null) {
            return null;
        }
        return this.hEX.brm();
    }

    public View bGi() {
        if (this.hEX == null) {
            return null;
        }
        return this.hEX.bGD();
    }

    public View bGj() {
        if (this.hEY == null) {
            return null;
        }
        return this.hEY.brm();
    }

    public View bGk() {
        if (this.hEY == null) {
            return null;
        }
        return this.hEY.bGp();
    }

    public View bGl() {
        if (this.hEY == null) {
            return null;
        }
        return this.hEY.bGl();
    }

    public View bGm() {
        if (this.hEX == null) {
            return null;
        }
        return this.hEX.bGl();
    }

    public void onDestroy() {
    }

    public void nJ(boolean z) {
        if (this.hEY != null) {
            this.hEY.nJ(z);
        }
        if (this.hEX != null) {
            this.hEX.nJ(z);
        }
    }

    public void a(l lVar) {
        if (this.hEX != null) {
            this.hEX.a(lVar);
        }
    }
}
