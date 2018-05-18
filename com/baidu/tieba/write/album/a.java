package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] blS;
    private String hcA;
    private AlbumActivity hcB;
    private String[] hcC;
    private ImageListFragment hcD;
    private AlbumImageBrowseFragment hcE;
    private String hcz;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hcz = "tag_image";
        this.hcA = "tag_b_image";
        this.hcB = albumActivity;
    }

    public void aTP() {
        this.blS = new Fragment[2];
        this.hcC = new String[2];
        this.hcD = new ImageListFragment();
        this.blS[0] = this.hcD;
        this.hcC[0] = this.hcz;
        this.hcE = new AlbumImageBrowseFragment();
        this.blS[1] = this.hcE;
        this.hcC[1] = this.hcA;
    }

    public Fragment uO(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.blS[i];
    }

    public String uP(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hcC[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.blS.length) {
                if (this.blS[i3] != null && (this.blS[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.blS[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bBr() {
        if (this.hcD == null) {
            return null;
        }
        return this.hcD.bBr();
    }

    public void stopCamera() {
        TbCameraView bBr = bBr();
        if (bBr != null) {
            bBr.stopCamera();
            bBr.setVisibility(4);
        }
    }

    public void bBq() {
        TbCameraView bBr = bBr();
        if (bBr != null) {
            bBr.setVisibility(0);
            bBr.ns(false);
        }
        if (this.hcD != null && this.hcD.bBP() != null) {
            this.hcD.bBP().bBU();
        }
    }

    public View bBs() {
        if (this.hcD == null) {
            return null;
        }
        return this.hcD.bmu();
    }

    public View bBt() {
        if (this.hcD == null) {
            return null;
        }
        return this.hcD.bBO();
    }

    public View bBu() {
        if (this.hcE == null) {
            return null;
        }
        return this.hcE.bmu();
    }

    public View bBv() {
        if (this.hcE == null) {
            return null;
        }
        return this.hcE.bBA();
    }

    public View bBw() {
        if (this.hcE == null) {
            return null;
        }
        return this.hcE.bBw();
    }

    public View bBx() {
        if (this.hcD == null) {
            return null;
        }
        return this.hcD.bBw();
    }

    public void onDestroy() {
    }

    public void no(boolean z) {
        if (this.hcE != null) {
            this.hcE.no(z);
        }
        if (this.hcD != null) {
            this.hcD.no(z);
        }
    }

    public void a(i iVar) {
        if (this.hcD != null) {
            this.hcD.a(iVar);
        }
    }
}
