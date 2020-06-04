package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] aMI;
    private String bdD;
    private String bdE;
    private AlbumActivity lSE;
    private String[] lSF;
    private ImageListFragment lSG;
    private AlbumImageBrowseFragment lSH;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.bdD = "tag_image";
        this.bdE = "tag_b_image";
        this.lSE = albumActivity;
    }

    public void Hp() {
        this.aMI = new Fragment[2];
        this.lSF = new String[2];
        this.lSG = new ImageListFragment();
        this.aMI[0] = this.lSG;
        this.lSF[0] = this.bdD;
        this.lSH = new AlbumImageBrowseFragment();
        this.aMI[1] = this.lSH;
        this.lSF[1] = this.bdE;
    }

    public Fragment FA(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aMI[i];
    }

    public String FB(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.lSF[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.aMI.length) {
                if (this.aMI[i3] != null && (this.aMI[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.aMI[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView dmX() {
        if (this.lSG == null) {
            return null;
        }
        return this.lSG.dmX();
    }

    public void stopCamera() {
        TbCameraView dmX = dmX();
        if (dmX != null) {
            dmX.stopCamera();
            dmX.setVisibility(4);
        }
    }

    public void PI() {
        TbCameraView dmX = dmX();
        if (dmX != null) {
            dmX.setVisibility(0);
            dmX.vu(false);
        }
        if (this.lSG != null && this.lSG.dnc() != null) {
            this.lSG.dnc().HN();
        }
    }

    public View Hq() {
        if (this.lSG == null) {
            return null;
        }
        return this.lSG.HI();
    }

    public View Hr() {
        if (this.lSG == null) {
            return null;
        }
        return this.lSG.HM();
    }

    public View Hs() {
        if (this.lSH == null) {
            return null;
        }
        return this.lSH.HI();
    }

    public View Ht() {
        if (this.lSH == null) {
            return null;
        }
        return this.lSH.HJ();
    }

    public View Hu() {
        if (this.lSH == null) {
            return null;
        }
        return this.lSH.Hu();
    }

    public View Hv() {
        if (this.lSG == null) {
            return null;
        }
        return this.lSG.Hu();
    }

    public void onDestroy() {
    }

    public void ci(boolean z) {
        if (this.lSH != null) {
            this.lSH.ci(z);
        }
        if (this.lSG != null) {
            this.lSG.ci(z);
        }
    }

    public void a(i iVar) {
        if (this.lSG != null) {
            this.lSG.a(iVar);
        }
    }
}
