package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] cbN;
    private String hEI;
    private String hEJ;
    private AlbumActivity hEK;
    private String[] hEL;
    private k hEM;
    private b hEN;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hEI = "tag_image";
        this.hEJ = "tag_b_image";
        this.hEK = albumActivity;
    }

    public void aYU() {
        this.cbN = new Fragment[2];
        this.hEL = new String[2];
        this.hEM = new k();
        this.cbN[0] = this.hEM;
        this.hEL[0] = this.hEI;
        this.hEN = new b();
        this.cbN[1] = this.hEN;
        this.hEL[1] = this.hEJ;
    }

    public Fragment xk(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.cbN[i];
    }

    public String xl(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hEL[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cbN.length) {
                if (this.cbN[i3] != null && (this.cbN[i3] instanceof k)) {
                    ((k) this.cbN[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bGc() {
        if (this.hEM == null) {
            return null;
        }
        return this.hEM.bGc();
    }

    public void stopCamera() {
        TbCameraView bGc = bGc();
        if (bGc != null) {
            bGc.stopCamera();
            bGc.setVisibility(4);
        }
    }

    public void bGb() {
        TbCameraView bGc = bGc();
        if (bGc != null) {
            bGc.setVisibility(0);
            bGc.nI(false);
        }
        if (this.hEM != null && this.hEM.bGA() != null) {
            this.hEM.bGA().bGF();
        }
    }

    public View bGd() {
        if (this.hEM == null) {
            return null;
        }
        return this.hEM.brm();
    }

    public View bGe() {
        if (this.hEM == null) {
            return null;
        }
        return this.hEM.bGz();
    }

    public View bGf() {
        if (this.hEN == null) {
            return null;
        }
        return this.hEN.brm();
    }

    public View bGg() {
        if (this.hEN == null) {
            return null;
        }
        return this.hEN.bGl();
    }

    public View bGh() {
        if (this.hEN == null) {
            return null;
        }
        return this.hEN.bGh();
    }

    public View bGi() {
        if (this.hEM == null) {
            return null;
        }
        return this.hEM.bGh();
    }

    public void onDestroy() {
    }

    public void nE(boolean z) {
        if (this.hEN != null) {
            this.hEN.nE(z);
        }
        if (this.hEM != null) {
            this.hEM.nE(z);
        }
    }

    public void a(l lVar) {
        if (this.hEM != null) {
            this.hEM.a(lVar);
        }
    }
}
