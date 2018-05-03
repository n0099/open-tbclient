package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] blD;
    private AlbumImageBrowseFragment hbA;
    private String hbv;
    private String hbw;
    private AlbumActivity hbx;
    private String[] hby;
    private ImageListFragment hbz;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hbv = "tag_image";
        this.hbw = "tag_b_image";
        this.hbx = albumActivity;
    }

    public void aTP() {
        this.blD = new Fragment[2];
        this.hby = new String[2];
        this.hbz = new ImageListFragment();
        this.blD[0] = this.hbz;
        this.hby[0] = this.hbv;
        this.hbA = new AlbumImageBrowseFragment();
        this.blD[1] = this.hbA;
        this.hby[1] = this.hbw;
    }

    public Fragment uP(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.blD[i];
    }

    public String uQ(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hby[i];
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
        if (this.hbz == null) {
            return null;
        }
        return this.hbz.bBt();
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
        if (this.hbz != null && this.hbz.bBR() != null) {
            this.hbz.bBR().bBW();
        }
    }

    public View bBu() {
        if (this.hbz == null) {
            return null;
        }
        return this.hbz.bmv();
    }

    public View bBv() {
        if (this.hbz == null) {
            return null;
        }
        return this.hbz.bBQ();
    }

    public View bBw() {
        if (this.hbA == null) {
            return null;
        }
        return this.hbA.bmv();
    }

    public View bBx() {
        if (this.hbA == null) {
            return null;
        }
        return this.hbA.bBC();
    }

    public View bBy() {
        if (this.hbA == null) {
            return null;
        }
        return this.hbA.bBy();
    }

    public View bBz() {
        if (this.hbz == null) {
            return null;
        }
        return this.hbz.bBy();
    }

    public void onDestroy() {
    }

    public void nn(boolean z) {
        if (this.hbA != null) {
            this.hbA.nn(z);
        }
        if (this.hbz != null) {
            this.hbz.nn(z);
        }
    }

    public void a(i iVar) {
        if (this.hbz != null) {
            this.hbz.a(iVar);
        }
    }
}
