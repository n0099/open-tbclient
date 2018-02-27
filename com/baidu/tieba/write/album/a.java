package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] cbB;
    private b hEA;
    private String hEv;
    private String hEw;
    private AlbumActivity hEx;
    private String[] hEy;
    private k hEz;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hEv = "tag_image";
        this.hEw = "tag_b_image";
        this.hEx = albumActivity;
    }

    public void aYT() {
        this.cbB = new Fragment[2];
        this.hEy = new String[2];
        this.hEz = new k();
        this.cbB[0] = this.hEz;
        this.hEy[0] = this.hEv;
        this.hEA = new b();
        this.cbB[1] = this.hEA;
        this.hEy[1] = this.hEw;
    }

    public Fragment xl(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.cbB[i];
    }

    public String xm(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hEy[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cbB.length) {
                if (this.cbB[i3] != null && (this.cbB[i3] instanceof k)) {
                    ((k) this.cbB[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bGb() {
        if (this.hEz == null) {
            return null;
        }
        return this.hEz.bGb();
    }

    public void stopCamera() {
        TbCameraView bGb = bGb();
        if (bGb != null) {
            bGb.stopCamera();
            bGb.setVisibility(4);
        }
    }

    public void bGa() {
        TbCameraView bGb = bGb();
        if (bGb != null) {
            bGb.setVisibility(0);
            bGb.nI(false);
        }
        if (this.hEz != null && this.hEz.bGz() != null) {
            this.hEz.bGz().bGE();
        }
    }

    public View bGc() {
        if (this.hEz == null) {
            return null;
        }
        return this.hEz.brl();
    }

    public View bGd() {
        if (this.hEz == null) {
            return null;
        }
        return this.hEz.bGy();
    }

    public View bGe() {
        if (this.hEA == null) {
            return null;
        }
        return this.hEA.brl();
    }

    public View bGf() {
        if (this.hEA == null) {
            return null;
        }
        return this.hEA.bGk();
    }

    public View bGg() {
        if (this.hEA == null) {
            return null;
        }
        return this.hEA.bGg();
    }

    public View bGh() {
        if (this.hEz == null) {
            return null;
        }
        return this.hEz.bGg();
    }

    public void onDestroy() {
    }

    public void nE(boolean z) {
        if (this.hEA != null) {
            this.hEA.nE(z);
        }
        if (this.hEz != null) {
            this.hEz.nE(z);
        }
    }

    public void a(l lVar) {
        if (this.hEz != null) {
            this.hEz.a(lVar);
        }
    }
}
