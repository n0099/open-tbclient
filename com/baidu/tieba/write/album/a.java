package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] blD;
    private AlbumActivity hbA;
    private String[] hbB;
    private ImageListFragment hbC;
    private AlbumImageBrowseFragment hbD;
    private String hby;
    private String hbz;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hby = "tag_image";
        this.hbz = "tag_b_image";
        this.hbA = albumActivity;
    }

    public void aTP() {
        this.blD = new Fragment[2];
        this.hbB = new String[2];
        this.hbC = new ImageListFragment();
        this.blD[0] = this.hbC;
        this.hbB[0] = this.hby;
        this.hbD = new AlbumImageBrowseFragment();
        this.blD[1] = this.hbD;
        this.hbB[1] = this.hbz;
    }

    public Fragment uQ(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.blD[i];
    }

    public String uR(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hbB[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.blD.length) {
                if (this.blD[i3] != null && (this.blD[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.blD[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bBt() {
        if (this.hbC == null) {
            return null;
        }
        return this.hbC.bBt();
    }

    public void stopCamera() {
        TbCameraView bBt = bBt();
        if (bBt != null) {
            bBt.stopCamera();
            bBt.setVisibility(4);
        }
    }

    public void bBs() {
        TbCameraView bBt = bBt();
        if (bBt != null) {
            bBt.setVisibility(0);
            bBt.nr(false);
        }
        if (this.hbC != null && this.hbC.bBR() != null) {
            this.hbC.bBR().bBW();
        }
    }

    public View bBu() {
        if (this.hbC == null) {
            return null;
        }
        return this.hbC.bmv();
    }

    public View bBv() {
        if (this.hbC == null) {
            return null;
        }
        return this.hbC.bBQ();
    }

    public View bBw() {
        if (this.hbD == null) {
            return null;
        }
        return this.hbD.bmv();
    }

    public View bBx() {
        if (this.hbD == null) {
            return null;
        }
        return this.hbD.bBC();
    }

    public View bBy() {
        if (this.hbD == null) {
            return null;
        }
        return this.hbD.bBy();
    }

    public View bBz() {
        if (this.hbC == null) {
            return null;
        }
        return this.hbC.bBy();
    }

    public void onDestroy() {
    }

    public void nn(boolean z) {
        if (this.hbD != null) {
            this.hbD.nn(z);
        }
        if (this.hbC != null) {
            this.hbC.nn(z);
        }
    }

    public void a(i iVar) {
        if (this.hbC != null) {
            this.hbC.a(iVar);
        }
    }
}
